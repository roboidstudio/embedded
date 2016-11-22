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

package org.roboid.studio.timeline.dialog.tts.tab;

import org.roboid.audio.tts.AbstractTts;
import org.roboid.audio.tts.TtsProperty;
import org.roboid.audio.tts.TtsVoice;

/**
 * TTS Tab�� �� � ����� Ȱ��ȭ ��ų�� ������ �����ϴ� Ŭ����
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class AbstractTabProperties
{
	private static final long serialVersionUID = 1L;
	
	// ���� ����
	private String voiceEffectId;
	private boolean voiceEffectEnabled = true;

	// �⺻�� ��ư
	private boolean defaultButtonEnabled = true;
	
	private TtsProperty speechRate; // �ӵ�
	private TtsProperty volume; // ����
	private TtsProperty pitch; // �� ����

	public AbstractTabProperties()
	{
		super();
		setSpeechRate(new TtsProperty(0, 200, 10, 100, false));
		setVolume(new TtsProperty(0, 300, 10, 100, false));
		setPitch(new TtsProperty(0, 200, 10, 100, false));
	}
	
	public AbstractTabProperties(TtsVoice voice)
	{
		super();
		setVolume(new TtsProperty(0, 300, 10, 100, true)); // ������ �������� �����Ǵ� ������ ������� �ʰ�, �����Ϳ��� �����ϵ��� �Ѵ�.
		if(voice == null) return;
		
		AbstractTts engine = voice.getEngine();
		setSpeechRate(new TtsProperty(engine.getSpeechRate()));
		setPitch(new TtsProperty(engine.getPitch()));
	}

	// ���� ����
	public String getVoiceEffectId()
	{
		return voiceEffectId;
	}

	public void setVoiceEffectId(String voiceEffectId)
	{
		this.voiceEffectId = voiceEffectId;
	}

	public boolean isVoiceEffectEnabled()
	{
		return voiceEffectEnabled;
	}

	public void setVoiceEffectEnabled(boolean enabled)
	{
		this.voiceEffectEnabled = enabled;
	}

	// �⺻�� ��ư
	public boolean isDefaultButtonEnabled()
	{
		return defaultButtonEnabled;
	}

	public void setDefaultButtonEnabled(boolean enabled)
	{
		this.defaultButtonEnabled = enabled;
	}

	// �ӵ�
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

	public boolean isSpeechRateEnabled()
	{
		return getSpeechRate().isEnabled();
	}

	public void setSpeechRateEnabled(boolean enabled)
	{
		getSpeechRate().setEnabled(enabled);
	}

	// ����
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

	public boolean isVolumeEnabled()
	{
		return getVolume().isEnabled();
	}

	public void setVolumeEnabled(boolean enabled)
	{
		getVolume().setEnabled(enabled);
	}

	// �� ����
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

	public boolean isPitchEnabled()
	{
		return getPitch().isEnabled();
	}

	public void setPitchEnabled(boolean enabled)
	{
		getPitch().setEnabled(enabled);
	}
}
