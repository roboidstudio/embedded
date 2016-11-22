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

import java.beans.PropertyChangeEvent;

import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.commands.ModifyAudioPointCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class AudioPointEditPart extends ControlPointEditPart
{
	// 제어점의 내용을 변경한다. 
	@Override
	public void modifyControlPoint()
	{
		// 제어점 변경에 대한 명령을 생성한다.
		ModifyAudioPointCommand command = new ModifyAudioPointCommand((AudioTrack)getParent().getModel(), getModel());
//		TimelineEditor.commandStack.execute(command);
		getViewer().getEditDomain().getCommandStack().execute(command);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		super.propertyChange(e);
		if(e.getPropertyName().equals(ControlPoint.P_CONSTRAINT)) // 제어점의 영역
			((ChannelTrackEditPart)getParent()).propertyChange(e);
	}

	@Override
	public AudioPoint getModel()
	{
		return (AudioPoint)super.getModel();
	}
}
