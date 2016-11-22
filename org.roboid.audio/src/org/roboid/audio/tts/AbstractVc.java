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

import java.util.List;

import javax.sound.sampled.AudioInputStream;

/**
 * 음성 변조 클래스의 추상 버전
 * 
 * @author Kwang-Hyun Park
 */
public abstract class AbstractVc
{
	private List<TtsVoiceEffect> voiceEffects; // 전체 음성 변조
	private TtsVoiceEffect currentVoiceEffect; // 현재 음성 변조
	private TtsListener listener;
	
	public AbstractVc()
	{
		super();
	}
	
	public void setTtsListener(TtsListener listener)
	{
		this.listener = listener;
	}
	
	public abstract void execute(AudioInputStream audio);
	
	public void complete(AudioInputStream audio, List<Exception> exceptions)
	{
		if(listener != null)
		{
			if(exceptions != null && exceptions.size() > 0)
				listener.ttsExceptionOccured(exceptions);
			else
				listener.ttsCompleted(audio);
		}
	}
	
	public TtsVoiceEffect getDefaultVoiceEffect()
	{
		if(getVoiceEffects().size() > 0)
			return getVoiceEffects().get(0);
		return null;
	}
	
	public TtsVoiceEffect getCurrentVoiceEffect()
	{
		if(currentVoiceEffect == null)
			currentVoiceEffect = getDefaultVoiceEffect();
		return currentVoiceEffect;
	}
	
	public void setCurrentVoiceEffect(TtsVoiceEffect voiceEffect)
	{
		this.currentVoiceEffect = voiceEffect;
	}
	
	protected abstract List<TtsVoiceEffect> createVoiceEffects();
	
	public List<TtsVoiceEffect> getVoiceEffects()
	{
		if(voiceEffects == null)
			voiceEffects = createVoiceEffects();
		return voiceEffects;
	}
}
