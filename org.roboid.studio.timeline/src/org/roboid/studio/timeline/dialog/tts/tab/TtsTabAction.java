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

import org.roboid.audio.tts.AbstractTts;
import org.roboid.audio.tts.TtsAdapter;
import org.roboid.audio.tts.TtsEngineManager;
import org.roboid.audio.tts.TtsVoice;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsTabAction extends AbstractTabAction
{
	private int downloadedBytes = 0;
	
	@Override
	public void process(final TtsDialog dialog, final AbstractTabProperties p)
	{
		// 문장을 입력하지 않았을 경우 오류 메시지 표시
		if(((TtsTabProperties)p).getText() == null
				|| ((TtsTabProperties)p).getText().equals("")) //$NON-NLS-1$
		{
			dialog.processExceptionOccurs(	Messages.Common_Error,
											Messages.TtsTabAction_ErrorMessage_You_must_input_a_text);
			return;
		}

		// Tts음성 합성
		TtsEngineManager manager = TtsEngineManager.getInstance();
		TtsVoice voice = manager.getVoiceById(((TtsTabProperties)p).getVoiceId());
		if(voice == null) return;

		final AbstractTts engine = voice.getEngine();
		engine.setCurrentVoice(voice); // 목소리 설정
		engine.setSpeechRateValue(p.getSpeechRateValue());
		engine.setVolumeValue(engine.getVolume().getMax()); // 볼륨은 엔진의 MAX으로 적용한다.
		engine.setPitchValue(p.getPitchValue());
		
		engine.setTtsListener(new TtsAdapter()
		{
			@Override
			public void ttsUpdated(int len)
			{
				downloadedBytes += len;
				dialog.showMessage(String.format(Messages.TtsTabAction_Download + ": %.2f", downloadedBytes / 1024.0) + "KB"); //$NON-NLS-2$ //$NON-NLS-3$
			}
			
			@Override
			public void ttsCompleted(AudioInputStream audio)
			{
				applyVoiceEffect(dialog, audio, p);
				engine.dispose();
			}

			@Override
			public void ttsExceptionOccured(List<Exception> exceptions)
			{
				StringBuilder sb = new StringBuilder();
				for(Exception e : exceptions)
					sb.append(e.getMessage() + "\n"); //$NON-NLS-1$
				dialog.processExceptionOccurs(Messages.TtsTabAction_Exception, sb.toString());
			}
		});

		//SPEAK!!
		engine.speak(((TtsTabProperties)p).getText());
	}
}
