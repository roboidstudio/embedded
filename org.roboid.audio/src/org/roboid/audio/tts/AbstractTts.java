/*
 * Part of the ROBOID project
 * Copyright (C) 2016 Kwang-Hyun Park (akaii@kw.ac.kr) and Kyoung Jin Kim
 * https://github.com/roboidstudio/embedded
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
*/

package org.roboid.audio.tts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import org.roboid.audio.AudioUtil;

/**
 * TTS Ŭ������ �߻� ����
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public abstract class AbstractTts
{
	private List<TtsVoice> voices; // ��ü ���̽�
	private TtsVoice currentVoice; // ���� ���̽�
	private TtsProperty speechRate; // �ӵ�
	private TtsProperty volume; // ����
	private TtsProperty pitch; // �� ����
	private TtsProperty pitchRange; // �� ���� ��ȭ
	private TtsListener listener;
	private AudioFormat audioFormat;
	private ByteArrayOutputStream ttsOut;

	public AbstractTts()
	{
		super();
	}
	
	public void reset()
	{
		setCurrentVoice(getDefaultVoice());
		getSpeechRate().reset();
		getVolume().reset();
		getPitch().reset();
		getPitchRange().reset();
	}

	public AudioFormat getAudioFormat()
	{
		if(audioFormat == null)
			audioFormat = new AudioFormat(16000, 16, 1, true, false); // default
		return audioFormat;
	}
	
	public void setAudioFormat(AudioFormat audioFormat)
	{
		this.audioFormat = audioFormat;
	}
	
	public void setTtsListener(TtsListener listener)
	{
		this.listener = listener;
	}
	
	public void speak(String text)
	{
		if(text == null) return;
		ttsOut = new ByteArrayOutputStream();
		execute(text);
	}
	
	/**
	 * ����� �����ϰ� ����ϴ� ������ ������ ȣ���մϴ�.
	 */
	public boolean dispose()
	{
		try
		{
			if(ttsOut != null) ttsOut.close();
			ttsOut = null;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public abstract void execute(String text);
	
	/**
	 * ����� �����͸� �����մϴ�.
	 * ������ ��Ŷ�� ��� �� �޼ҵ带 ȣ���� �� {@link #complete(List<Exception> exceptions)} �޼ҵ带 ȣ���ؾ� �մϴ�.
	 * 
	 * @param audio		����Ʈ �迭
	 */
	public void write(byte[] audio)
	{
		write(audio, 0, audio.length);
	}

	/**
	 * ����� �����͸� �����մϴ�.
	 * ������ ��Ŷ�� ��� �� �޼ҵ带 ȣ���� �� {@link #complete(List<Exception> exceptions)} �޼ҵ带 ȣ���ؾ� �մϴ�.
	 * 
	 * @param audio		����Ʈ �迭
	 * @param offset	����Ʈ �迭���� ���� ��ġ
	 * @param len		����Ʈ �迭�� ������ġ�������� ����ؾ� �� ũ��
	 */
	public void write(byte[] audio, int offset, int len)
	{
		if(ttsOut == null)
			ttsOut = new ByteArrayOutputStream();
		ttsOut.write(audio, offset, len);
		
		if(listener != null)
			listener.ttsUpdated(len);
	}
	
	/**
	 * ���� �ռ��� ���� �� ȣ���մϴ�.
	 * ������ write() �޼ҵ带 ȣ���� �� �� �޼ҵ带 ȣ���ؾ� �մϴ�.
	 * 
	 * @param exceptions	�߻��� ���� ����Ʈ
	 */
	public void complete(List<Exception> exceptions)
	{
		AudioInputStream audio = AudioUtil.getAudioInputStream(getAudioFormat(), ttsOut.toByteArray());
		if(listener != null)
		{
			if(exceptions != null && exceptions.size() > 0)
				listener.ttsExceptionOccured(exceptions);
			else
				listener.ttsCompleted(audio);
		}
	}
	
	// Voice
	public TtsVoice getDefaultVoice()
	{
		List<TtsVoice> voiceList = getVoices(new TtsVoice(null,
														null,
														null,
														null,
														null,
														null,
														null,
														TtsVoice.Domain.GENERAL));
		if(voiceList.size() > 0)
			return voiceList.get(0);
		
		// GENERAL ������ ����.
		voiceList = getVoices();
		if(voiceList.size() > 0)
			return voiceList.get(0);
		
		return null;
	}
	
	public TtsVoice getCurrentVoice()
	{
		if(currentVoice == null)
			currentVoice = getDefaultVoice();
		return currentVoice;
	}
	
	public void setCurrentVoice(TtsVoice voice)
	{
		this.currentVoice = voice;
	}

	/**
	 * TTS���� �����ϴ� ��Ҹ��� ����� ��ȯ�մϴ�.
	 * 
	 * @return	��Ҹ� ���
	 */
	abstract protected List<TtsVoice> createVoices();
	
	/**
	 * ��� ������ ��Ҹ� ����� ��ȯ�մϴ�.
	 * @return	��Ҹ� ���
	 */
	public List<TtsVoice> getVoices()
	{
		// ��� ������ ��Ҹ����� �����´�.
		if(voices == null)
			voices = createVoices();
		return voices;
	}
	
	/**
	 * ��� ������ ��Ҹ� ����� ��ȯ�մϴ�.
	 * 
	 * @param filter
	 *            null�� ������ ��� ��� ��Ҹ� ������ ��ȯ�ϰ�,
	 *            filter�� Ư���� �Ӽ��� �����ϰ� �������� null��
	 *            �����ϴ� ��� �ش� �Ӽ��� ���� ��Ҹ��� ��ȯ�մϴ�.
	 * @return	��Ҹ� ���
	 */
	public List<TtsVoice> getVoices(TtsVoice filter)
	{
		// ��� ������ ��Ҹ����� �����´�.
		if(voices == null)
			voices = createVoices();

		// filter��  null�� ��� ��� ��Ҹ� ����� ��ȯ�Ѵ�.
		if(filter == null) return voices;

		// filter��  �����Ǿ� �ִ� ��� ��� ������ ��Ҹ����� Ȯ���Ѵ�.
		List<TtsVoice> voiceList = new ArrayList<TtsVoice>();
		for(TtsVoice v : voices)
		{
			if(v.isAccepted(filter))
				voiceList.add(v);
		}
		return voiceList;
	}

	public TtsProperty getSpeechRate()
	{
		if(speechRate == null)
			speechRate = new TtsProperty();
		return speechRate;
	}
	
	public void setSpeechRate(TtsProperty speechRate)
	{
		this.speechRate = speechRate;
	}
	
	public int getSpeechRateValue()
	{
		return getSpeechRate().getValue();
	}
	
	public void setSpeechRateValue(int value)
	{
		getSpeechRate().setValue(value);
	}
	
	public TtsProperty getVolume()
	{
		if(volume == null)
			volume = new TtsProperty();
		return volume;
	}
	
	public void setVolume(TtsProperty volume)
	{
		this.volume = volume;
	}
	
	public int getVolumeValue()
	{
		return getVolume().getValue();
	}
	
	public void setVolumeValue(int value)
	{
		getVolume().setValue(value);
	}

	public TtsProperty getPitch()
	{
		if(pitch == null)
			pitch = new TtsProperty();
		return pitch;
	}
	
	public void setPitch(TtsProperty pitch)
	{
		this.pitch = pitch;
	}
	
	public int getPitchValue()
	{
		return getPitch().getValue();
	}
	
	public void setPitchValue(int value)
	{
		getPitch().setValue(value);
	}
	
	public TtsProperty getPitchRange()
	{
		if(pitchRange == null)
			pitchRange = new TtsProperty();
		return pitchRange;
	}
	
	public void setPitchRange(TtsProperty pitchRange)
	{
		this.pitchRange = pitchRange;
	}
	
	public int getPitchRangeValue()
	{
		return getPitchRange().getValue();
	}
	
	public void setPitchRangeValue(int value)
	{
		getPitchRange().setValue(value);
	}
}
