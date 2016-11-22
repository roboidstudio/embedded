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

import java.util.List;

import javax.sound.sampled.AudioInputStream;

import org.roboid.audio.tts.AbstractVc;
import org.roboid.audio.tts.TtsAdapter;
import org.roboid.audio.tts.TtsEngineManager;
import org.roboid.audio.tts.TtsVoiceEffect;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public abstract class AbstractTabAction
{
	void applyVoiceEffect(final TtsDialog dialog, AudioInputStream audio, final AbstractTabProperties p)
	{
		// 음성 변조
		TtsEngineManager manager = TtsEngineManager.getInstance();
		TtsVoiceEffect voiceEffect = manager.getVoiceEffectById(p.getVoiceEffectId());
		if(voiceEffect != null)
		{
			AbstractVc vc = voiceEffect.getEngine();
			if(vc != null)
			{
				vc.setTtsListener(new TtsAdapter()
				{
					@Override
					public void ttsCompleted(AudioInputStream audio)
					{
						// 결과값을 타임라인에 넘겨주고 창을 닫는다
						dialog.processCompletedAndClose(audio, p);
					}

					@Override
					public void ttsExceptionOccured(List<Exception> exceptions)
					{
						StringBuilder sb = new StringBuilder();
						for(Exception e : exceptions)
							sb.append(e.getMessage() + "\n");
						dialog.processExceptionOccurs("Exception", sb.toString());
					}
				});
				vc.setCurrentVoiceEffect(voiceEffect);
				vc.execute(audio);
			}
		}
		else
			dialog.processCompletedAndClose(audio, p);
	}

	abstract public void process(TtsDialog dialog, AbstractTabProperties p);
}
