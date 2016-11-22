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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.graphics.Color;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.commands.CreateAudioPointCommand;
import org.roboid.studio.timeline.editpolicies.AudioPointXYLayoutEditPolicy;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class AudioTrackEditPart extends ChannelTrackEditPart
{
	// 채널의 배경색을 얻는다.
	// AudioChannel과 VoiceChannel은 오렌지 색
	@Override
	protected Color getChannelColor()
	{
		return ColorConstants.orange;
	}

	/*
	 * 오디오 관련 채널일 경우는 오디오 클립의 길이 만큼 연장된다.
	 */
	protected void paintStrip(Graphics graphics, Rectangle bounds)
	{
		for(ControlPoint cp : getModelChildren())
		{
			// 띠의 영역을 계산한다.
			Rectangle strip = new Rectangle(bounds);
			strip.x = cp.getFrame();
			strip.y = bounds.y + MotionClip.CHANNEL_TRACK_HEIGHT_GAP;
			strip.width = ((AudioPoint)cp).getLength();
			strip.height = MotionClip.CHANNEL_TRACK_STRIP_HEIGHT;
			
			// 채널의 색상에 따라 띠 영역을 그린다.
			graphics.setBackgroundColor(getChannelColor());
			graphics.setAlpha(96);
			graphics.fillRectangle(strip);
		}
	}
	
	// 제어점 편집에 대한 정책을 생성한다.
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AudioPointXYLayoutEditPolicy(getModel()));
	}

	// 제어점을 생성한다.
	@Override
	public void createControlPoint(int frame)
	{
		AudioPoint cp = TimelineFactory.eINSTANCE.createAudioPoint();
		cp.setConstraint(new Rectangle(frame, MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16));
		
		// 제어점 생성에 대한 명령을 생성한다.
		CreateAudioPointCommand command = new CreateAudioPointCommand(getModel(), cp);
//		TimelineEditor.commandStack.execute(command);
		getViewer().getEditDomain().getCommandStack().execute(command);
	}

	@Override
	public AudioTrack getModel()
	{
		return (AudioTrack)super.getModel();
	}
}
