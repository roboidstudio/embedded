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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kyoung Jin Kim, Kwang-Hyun Park
 */
public class MoveControlPointCommand extends Command
{
	private ChannelTrack channel;
	private ControlPoint cp;
	private Rectangle newConstraint;
	private Rectangle oldConstraint;
	
	public MoveControlPointCommand(ChannelTrack channel, ControlPoint cp)
	{
		this.channel = channel;
		this.cp = cp;
	}
	
	// 실행
	@Override
	public void execute()
	{
		// 영역을 확인한다.
		if(newConstraint.x < 0) newConstraint.x = 0;
		newConstraint.y = MotionClip.CHANNEL_TRACK_HEIGHT_GAP;
		
		// 제어점의 영역을 변경하고 에디트 파트에 알린다.
		cp.setConstraint(newConstraint);
		// 제어점의 순서를 다시 정렬한다.
		channel.reorder(cp);
	}
	
	// 영역을 설정한다. 호출하기 전에 setPointModel을 먼저 호출해야 한다.
	public void setConstraint(Object newConstraint)
	{
		// 이전 위치를 저장한다.
		if(cp != null) oldConstraint = cp.getConstraint();
		// 영역을 변경한다.
		this.newConstraint = (Rectangle)newConstraint;
	}

	// 되돌리기
	public void undo()
	{
		cp.setConstraint(oldConstraint);
		channel.reorder(cp);
	}
}
