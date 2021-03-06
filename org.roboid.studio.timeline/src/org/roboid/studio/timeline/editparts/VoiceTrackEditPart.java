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

package org.roboid.studio.timeline.editparts;

import org.eclipse.draw2d.geometry.Rectangle;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.VoicePoint;
import org.roboid.studio.timeline.VoiceTrack;
import org.roboid.studio.timeline.commands.CreateAudioPointCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class VoiceTrackEditPart extends AudioTrackEditPart
{
	// 제어점을 생성한다.
	@Override
	public void createControlPoint(int frame)
	{
		VoicePoint cp = TimelineFactory.eINSTANCE.createVoicePoint();
		cp.setConstraint(new Rectangle(frame, MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16));
		
		// 제어점 생성에 대한 명령을 생성한다.
		CreateAudioPointCommand command = new CreateAudioPointCommand(getModel(), cp);
//		TimelineEditor.commandStack.execute(command);
		getViewer().getEditDomain().getCommandStack().execute(command);
	}

	@Override
	public VoiceTrack getModel()
	{
		return (VoiceTrack)super.getModel();
	}
}
