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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.editpolicies.ControlPointComponentEditPolicy;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ControlPointEditPart extends EditPartWithListener
{
	@Override
	protected IFigure createFigure()
	{
		IFigure point = new RectangleFigure()
		{
			@Override
			protected void outlineShape(Graphics g)
			{
				// 제어점의 영역을 그린다.
				Rectangle r = getBounds();
				// 왼쪽과 위쪽 테두리를 그린다.
				g.setForegroundColor(ColorConstants.lightGray);
				g.drawLine(r.x, r.y, r.x + r.width, r.y);
				g.drawLine(r.x, r.y, r.x, r.y + r.height);
				// 오른쪽과 아래쪽 테두리를 그린다.
				g.setForegroundColor(ColorConstants.gray);
				g.drawLine(r.x, r.y + r.height - 1, r.x + r.width, r.y + r.height - 1);
				g.drawLine(r.x + r.width - 1, r.y, r.x + r.width - 1, r.y + r.height);
			}
		};
		
		point.setOpaque(true);
		return point;
	}

	@Override
	public DragTracker getDragTracker(Request request)
	{
		return new DragEditPartsTracker(this)
		{
			@Override
			protected Dimension getDragMoveDelta()
			{
				Dimension dim = getLocation().getDifference(getStartLocation());
				dim.height = 0;
				return dim;
			}
		};
	}

	// 제어점 편집에 대한 정책을 생성한다.
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ControlPointComponentEditPolicy());
	}

	// 프로퍼티의 변경에 따라 다시 그린다.
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if(e.getPropertyName().equals(ControlPoint.P_CONSTRAINT)) // 제어점의 영역
		{
			refreshVisuals();
		}
	}
	
	@Override
	public ControlPoint getModel()
	{
		return (ControlPoint)super.getModel();
	}

	// 제어점의 영역에 따라 새로 그릴 영역을 설정한다.
	@Override
	protected void refreshVisuals()
	{
		Rectangle constraint = getModel().getConstraint();
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), constraint);
	}

	@Override
	public void performRequest(Request req)
	{
		if(req.getType() == RequestConstants.REQ_OPEN)
		{
			modifyControlPoint();
		}
	}

	protected void modifyControlPoint() {}
}
