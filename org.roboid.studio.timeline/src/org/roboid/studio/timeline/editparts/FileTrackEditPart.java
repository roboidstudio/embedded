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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.roboid.studio.timeline.FilePoint;
import org.roboid.studio.timeline.FileTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.commands.CreateFilePointCommand;

/**
 * @author Kwang-Hyun Park
 */
public class FileTrackEditPart extends ChannelTrackEditPart
{
	@Override
	protected Color getChannelColor()
	{
		return ColorConstants.red;
	}
	
	// 제어점을 생성한다.
	@Override
	public void createControlPoint(int frame)
	{
		FilePoint cp = TimelineFactory.eINSTANCE.createFilePoint();
		cp.setConstraint(new Rectangle(frame, MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16));
		
		// 제어점 생성에 대한 명령을 생성한다.
		CreateFilePointCommand command = new CreateFilePointCommand(getModel(), cp);
		getViewer().getEditDomain().getCommandStack().execute(command);
	}

	@Override
	public FileTrack getModel()
	{
		return (FileTrack)super.getModel();
	}
}
