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

package org.roboid.studio.timeline.commands;

import javax.sound.sampled.AudioFormat;

import org.eclipse.swt.widgets.Display;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;

/**
 * @author Kwang-Hyun Park
 * @author Tae-hoon Kim
 */
public class ModifyAudioPointCommand extends CreateAudioPointCommand
{
	private String oldText;
	private String oldVoiceId;
	private String oldVoiceEffectId;
	private int oldSpeechRate;
	private int oldVolume;
	private int oldPitch;
	private byte[] oldMp3;
	private AudioFormat oldFormat;
	private int oldLength;
	
	public ModifyAudioPointCommand(AudioTrack channel, AudioPoint cp)
	{
		super(channel, cp);
		
		// Undo를 위해 이전 값을 저장해 둔다.
		oldText = ((AudioPoint)cp).getText();
		oldVoiceId = ((AudioPoint)cp).getVoiceId();
		oldVoiceEffectId = ((AudioPoint)cp).getVoiceEffectId();
		oldSpeechRate = ((AudioPoint)cp).getSpeechRate();
		oldVolume = ((AudioPoint)cp).getVolume();
		oldPitch = ((AudioPoint)cp).getPitch();
		oldMp3 = ((AudioPoint)cp).getMp3();
		oldFormat = ((AudioPoint)cp).getFormat();
		oldLength = ((AudioPoint)cp).getLength();
	}
	
	@Override
	public void execute()
	{
	}
	
	// 되돌리기
	@Override
	public void undo()
	{
		// 저장해둔 이전 값으로 되돌린다.
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				cp.setPropertyValue(AudioPoint.P_TEXT, oldText);
				((AudioPoint)cp).setVoiceId(oldVoiceId);
				((AudioPoint)cp).setVoiceEffectId(oldVoiceEffectId);
				((AudioPoint)cp).setSpeechRate(oldSpeechRate);
				cp.setPropertyValue(AudioPoint.P_VOLUME, oldVolume);
				((AudioPoint)cp).setPitch(oldPitch);
				((AudioPoint)cp).setMp3(oldMp3);
				((AudioPoint)cp).setFormat(oldFormat);
				((AudioPoint)cp).setLength(oldLength);
			}
		});
	}
}
