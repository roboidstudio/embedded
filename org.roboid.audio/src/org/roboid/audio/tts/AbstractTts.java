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
 * TTS 클래스의 추상 버전
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public abstract class AbstractTts
{
	private List<TtsVoice> voices; // 전체 보이스
	private TtsVoice currentVoice; // 현재 보이스
	private TtsProperty speechRate; // 속도
	private TtsProperty volume; // 볼륨
	private TtsProperty pitch; // 음 높이
	private TtsProperty pitchRange; // 음 높이 변화
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
	 * 재생을 종료하고 재생하는 파일을 닫을때 호출합니다.
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
	 * 오디오 데이터를 설정합니다.
	 * 마지막 패킷일 경우 이 메소드를 호출한 후 {@link #complete(List<Exception> exceptions)} 메소드를 호출해야 합니다.
	 * 
	 * @param audio		바이트 배열
	 */
	public void write(byte[] audio)
	{
		write(audio, 0, audio.length);
	}

	/**
	 * 오디오 데이터를 설정합니다.
	 * 마지막 패킷일 경우 이 메소드를 호출한 후 {@link #complete(List<Exception> exceptions)} 메소드를 호출해야 합니다.
	 * 
	 * @param audio		바이트 배열
	 * @param offset	바이트 배열에서 시작 위치
	 * @param len		바이트 배열의 시작위치에서부터 사용해야 할 크기
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
	 * 음성 합성이 끝날 때 호출합니다.
	 * 마지막 write() 메소드를 호출한 후 이 메소드를 호출해야 합니다.
	 * 
	 * @param exceptions	발생한 예외 리스트
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
		
		// GENERAL 음성이 없다.
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
	 * TTS에서 지원하는 목소리의 목록을 반환합니다.
	 * 
	 * @return	목소리 목록
	 */
	abstract protected List<TtsVoice> createVoices();
	
	/**
	 * 사용 가능한 목소리 목록을 반환합니다.
	 * @return	목소리 목록
	 */
	public List<TtsVoice> getVoices()
	{
		// 사용 가능한 목소리들을 가져온다.
		if(voices == null)
			voices = createVoices();
		return voices;
	}
	
	/**
	 * 사용 가능한 목소리 목록을 반환합니다.
	 * 
	 * @param filter
	 *            null을 지정할 경우 모든 목소리 종류를 반환하고,
	 *            filter에 특정한 속성을 지정하고 나머지는 null로
	 *            지정하는 경우 해당 속성을 갖는 목소리를 반환합니다.
	 * @return	목소리 목록
	 */
	public List<TtsVoice> getVoices(TtsVoice filter)
	{
		// 사용 가능한 목소리들을 가져온다.
		if(voices == null)
			voices = createVoices();

		// filter가  null인 경우 모든 목소리 목록을 반환한다.
		if(filter == null) return voices;

		// filter가  지정되어 있는 경우 사용 가능한 목소리인지 확인한다.
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
