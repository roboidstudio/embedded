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

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;

/**
 * 음성 변조
 * 
 * @author Kwang-Hyun Park
 */
public class NullVc extends AbstractVc
{
	private static NullVc instance = null;
	
	private NullVc()
	{
		super();
	}
	
	public static NullVc getInstance()
	{
		if(instance == null)
		{
			synchronized(NullVc.class)
			{
				if(instance == null)
					instance = new NullVc();
			}
		}
		return instance;
	}
	
	@Override
	public void execute(AudioInputStream audio)
	{
		complete(audio, null);
	}
	
	@Override
	protected List<TtsVoiceEffect> createVoiceEffects()
	{
		List<TtsVoiceEffect> voiceEffects = new ArrayList<TtsVoiceEffect>();
		voiceEffects.add(new TtsVoiceEffect(this, "org.roboid.audio.tts.vc.null", Messages.NullVc_None)); //$NON-NLS-1$
		return voiceEffects;
	}
}
