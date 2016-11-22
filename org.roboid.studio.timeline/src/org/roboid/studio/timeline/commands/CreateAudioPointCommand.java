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

import javax.sound.sampled.AudioInputStream;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * AudioPoint와 VoicePoint를 생성할 때 사용한다.
 * 
 * @author Kyoung Jin Kim
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park 
 */
public class CreateAudioPointCommand extends CreateControlPointCommand
{
	public CreateAudioPointCommand(AudioTrack channel, AudioPoint cp)
	{
		super(channel, cp);
	}
	
	protected boolean openAudioDialog()
	{
		boolean result = false;
		try
		{
			Shell shell = new Shell(Display.getCurrent());
			
			// TTS 대화창을 연다.
			TtsDialog dialog = new TtsDialog(shell, (AudioPoint)cp); //$NON-NLS-1$);
			result = dialog.open();
			shell.dispose();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			return false;
		}
		return result;
	}

	@Override
	public boolean canExecute()
	{
		return openAudioDialog();
	}

	protected boolean validate(AudioInputStream in)
	{
		if (in.getFormat().getChannels() != 1)
		{
			MessageDialog.openWarning(	null,
										"MultipleChannelError",
										"Please convert a channel to a mono channel.");
			return false;
		}
		if (in.getFormat().getSampleRate() != 16000)
		{
			MessageDialog.openWarning(	null,
										"SampleRateError",
										"Please convert a sampling rate to 16Khz.");
			return false;
		}
		if (in.getFormat().getSampleSizeInBits() != 16)
		{
			MessageDialog.openWarning(	null,
										"SampleSizeInBitsError",
										"Please convert sample size in bits to 16 bits.");
			return false;
		}
		if (in.getFrameLength() > 16000 * 200)
		{
			MessageDialog.openWarning(	null,
										"TooLongAudioClipError",
										"Please use audio data shorter than 3 minutes and 20 seconds.");
			return false;
		}
		return true;
	}
}
