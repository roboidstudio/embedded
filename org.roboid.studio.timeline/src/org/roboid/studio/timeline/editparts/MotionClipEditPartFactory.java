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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ColorPoint;
import org.roboid.studio.timeline.ColorTrack;
import org.roboid.studio.timeline.CommandPoint;
import org.roboid.studio.timeline.CommandTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.FilePoint;
import org.roboid.studio.timeline.FileTrack;
import org.roboid.studio.timeline.LinearPoint;
import org.roboid.studio.timeline.LinearTrack;
import org.roboid.studio.timeline.MatrixPoint;
import org.roboid.studio.timeline.MatrixTrack;
import org.roboid.studio.timeline.TextPoint;
import org.roboid.studio.timeline.TextTrack;
import org.roboid.studio.timeline.VoiceTrack;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class MotionClipEditPartFactory implements EditPartFactory
{
	// 에디트 파트를 생성한다.
	@Override
	public EditPart createEditPart(EditPart context, Object model) 
	{
		EditPart part = null;
		if(model instanceof ControlTrack) part = new ControlTrackEditPart();
		else if(model instanceof MatrixTrack) part = new MatrixTrackEditPart();
		else if(model instanceof LinearTrack) part = new LinearTrackEditPart();
		else if(model instanceof FileTrack) part = new FileTrackEditPart();
		else if(model instanceof TextTrack) part = new TextTrackEditPart();
		else if(model instanceof CommandTrack) part = new CommandTrackEditPart();
		else if(model instanceof VoiceTrack) part = new VoiceTrackEditPart();
		else if(model instanceof AudioTrack) part = new AudioTrackEditPart();
		else if(model instanceof ColorTrack) part = new ColorTrackEditPart();
		else if(model instanceof MatrixPoint) part = new MatrixPointEditPart();
		else if(model instanceof LinearPoint) part = new ControlPointEditPart();
		else if(model instanceof FilePoint) part = new FilePointEditPart();
		else if(model instanceof TextPoint) part = new ControlPointEditPart();
//		else if(model instanceof PinModePoint) part = new PinModePointEditPart();
		else if(model instanceof CommandPoint) part = new ControlPointEditPart();
//		else if(model instanceof VoicePoint) part = new AudioPointEditPart();
		else if(model instanceof AudioPoint) part = new AudioPointEditPart();
		else if(model instanceof ColorPoint) part = new ControlPointEditPart();
		else part = new MotionClipEditPart(); // if(model instanceof MotionClipModel)
		
		part.setModel(model); // 에디트 파트에 모델을 설정한다.
		return part;
	}
}
