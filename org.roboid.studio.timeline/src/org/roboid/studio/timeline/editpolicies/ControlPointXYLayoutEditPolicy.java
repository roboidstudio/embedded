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

package org.roboid.studio.timeline.editpolicies;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.commands.CreateControlPointCommand;
import org.roboid.studio.timeline.commands.MoveControlPointCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ControlPointXYLayoutEditPolicy extends XYLayoutEditPolicy
{
	private ChannelTrack channel;
	
	public ControlPointXYLayoutEditPolicy(ChannelTrack model)
	{
		channel = model; // 타임라인 모션 에디터의 채널
	}
	
	// 제어점의 영역 변경에 대한 명령을 생성한다.
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint)
	{
		MoveControlPointCommand command = new MoveControlPointCommand(channel, (ControlPoint)child.getModel());
		((Rectangle)constraint).y = MotionClip.CHANNEL_TRACK_HEIGHT_GAP;
		command.setConstraint(constraint); // 설정할 영역
		return command;
	}

	// 제어점 생성에 대한 명령을 생성한다.
	@Override
	protected Command getCreateCommand(CreateRequest request)
	{
		return new CreateControlPointCommand((ChannelTrack)getHost().getModel(), (ControlPoint)request.getNewObject());
	}

	// 크기 변경을 금지한다.
	@Override
	public Command getCommand(Request request)
	{
		if(request.getType().equals(RequestConstants.REQ_RESIZE_CHILDREN))
			return null;
		return super.getCommand(request);
	}

	// remove resize handle!
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child)
	{
		return new NonResizableEditPolicy()
		{
			@Override
			protected Command getMoveCommand(ChangeBoundsRequest request)
			{
				Point p = request.getMoveDelta();
				p.y = 0;
				request.setMoveDelta(p);
				return super.getMoveCommand(request);
			}

			@Override
			protected void showChangeBoundsFeedback(ChangeBoundsRequest request)
			{
				Point p = request.getMoveDelta();
				p.y = 0;
				request.setMoveDelta(p);
				super.showChangeBoundsFeedback(request);
			}
		};
	}
}
