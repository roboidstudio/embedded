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
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class MotionClipEditPart extends EditPartWithListener
{
	@Override
	protected IFigure createFigure() 
	{
		IFigure figure = new LayeredPane()
		{
			@Override
			public void paintFigure(Graphics g)
			{
				Rectangle bounds = getBounds();
				
				// 배경을 그린다.
				g.setBackgroundColor(ColorConstants.white);
				g.fillRectangle(bounds);
			}
		};
		
		figure.setLayoutManager(new XYLayout());
		figure.setOpaque(false);
		return figure;
	}

	@Override
	public MotionClip getModel()
	{
		return (MotionClip)super.getModel();
	}

	// 콘트롤 리스트를 얻는다.
	@Override
	protected List<ControlTrack> getModelChildren()
	{
		return getModel().getControls();
	}

	@Override
	protected void createEditPolicies()
	{
		// non movable this version
	}

	// 프로퍼티의 변경에 따라 다시 그린다.
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if(e.getPropertyName().equals(MotionClip.P_CHILDREN)) // 타임라인 모션 에디터의 콘트롤들
			refreshChildren();
	}
}
