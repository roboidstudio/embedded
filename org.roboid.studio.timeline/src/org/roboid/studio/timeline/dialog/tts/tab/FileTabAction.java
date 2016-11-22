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

import java.io.File;

import javax.sound.sampled.AudioInputStream;

import org.roboid.audio.AudioUtil;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class FileTabAction extends AbstractTabAction
{
	@Override
	public void process(final TtsDialog dialog, final AbstractTabProperties properties)
	{
		// 파일을 선택하지 않았을 경우 오류 메시지 표시
		if(((FileTabProperties)properties).getFilePath() == null || ((FileTabProperties) properties).getFilePath().equals("")) //$NON-NLS-1$
		{
			dialog.processExceptionOccurs(	Messages.Common_Error,
											Messages.FileTabAction_ErrorMessage_You_must_select_a_file);
			return;
		}

		// 오디오 파일을 읽는다.
		AudioInputStream audio = null;
		
		try
		{
			// 파일로부터 오디오 파일을 읽는다.
			File file = new File(((FileTabProperties) properties).getFilePath());
			audio = AudioUtil.getAudioInputStream(file);
		}
		catch (Exception e)
		{
			dialog.processExceptionOccurs(e);
			return;
		}
		
		dialog.processCompletedAndClose(audio, properties);
	}
}
