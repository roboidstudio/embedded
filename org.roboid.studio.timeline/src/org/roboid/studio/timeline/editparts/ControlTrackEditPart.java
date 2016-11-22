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
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineEditor;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ControlTrackEditPart extends EditPartWithListener
{
	@Override
	protected IFigure createFigure()
	{
		IFigure figure = new LayeredPane()
		{
			@Override
			public void paintFigure(Graphics g)
			{
				Rectangle bounds = getClientArea();

				// 배경을 그린다.
				g.setBackgroundColor(ColorConstants.white);
				g.fillRectangle(bounds);
				
				// 보조선을 10 픽셀 간격으로 그린다.
				g.setForegroundColor(TimelineEditor.COLOR_MINOR_GRID);
				for(int j = 10; j < bounds.width; j += 10)
					g.drawLine(j, bounds.y, j, bounds.y + bounds.height);
					
				// 주 그리드를 50픽셀 간격으로 그린다.
				g.setForegroundColor(TimelineEditor.COLOR_MAJOR_GRID);
				for(int j = 50; j < bounds.width; j += 50)
					g.drawLine(j, bounds.y, j, bounds.y + bounds.height);
				
				// 채널 간의 구분선을 그린다.
				g.setForegroundColor(ColorConstants.lightGray);
				int width = getModel().getConstraint().width;
				List<ChannelTrack> channels = getModelChildren();
				if(width <= 0)
				{
					int w;
					for(ChannelTrack channel : channels)
					{
						w = channel.getConstraint().width;
						if(w > width)
							width = w;
					}
				}
				g.drawLine(0, bounds.y, width, bounds.y);
				for(int i = 0; i < channels.size(); i ++)
				{
					int y = bounds.y + (i + 1) * MotionClip.CHANNEL_TRACK_HEIGHT;
					g.drawLine(0, y, width, y);
				}
			}
		};
		
		TitleBarBorder border = new TitleBarBorder()
		{
			@Override
			protected Insets calculateInsets(IFigure figure)
			{
				return new Insets(MotionClip.CONTROL_TRACK_TITLE_HEIGHT, 0, 0, 0);
			}

			@Override
			public void paint(IFigure figure, Graphics g, Insets insets)
			{
				g.setBackgroundColor(TimelineEditor.COLOR_TITLE);
				Rectangle rect = getPaintRectangle(figure, insets);
				rect.height = MotionClip.CONTROL_TRACK_TITLE_HEIGHT;
				g.fillRectangle(rect);
			}
		};
		
		figure.setBorder(border);
		figure.setOpaque(false);
		figure.setLayoutManager(new XYLayout());
		return figure;
	}
	
	@Override
	public ControlTrack getModel()
	{
		return (ControlTrack)super.getModel();
	}

	@Override
	protected List<ChannelTrack> getModelChildren()
	{
		return getModel().getChannels();
	}

	@Override
	protected void refreshVisuals()
	{
		Rectangle constraint = getModel().getConstraint();
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), constraint);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if(e.getPropertyName().equals(ControlTrack.P_CHILDREN)) // 타임라인 모션 에디터의 채널들
			refreshChildren();
	}

	@Override
	protected void createEditPolicies()
	{
	}
}
