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
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.editpolicies.ControlPointXYLayoutEditPolicy;

// ChannelTrackEditPart -+- LinearTrackEditPart -+- MatrixTrackEditPart
//                       |
//                       +- CommandTrackEditPart -+- TextTrackEditPart
//                       |
//                       +- AudioTrackEditPart -+- VoiceTrackEditPart
//                       |
//                       +- ColorTrackEditPart

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public abstract class ChannelTrackEditPart extends EditPartWithListener
{
	private DragTracker dragTracker;
	private ISelectionChangedListener selectionChangedListener;
	
	@Override
	protected IFigure createFigure()
	{
		IFigure channel = new LayeredPane()
		{
			// 제어점 간의 띠를 그린다.
			@Override
			public void paintFigure(Graphics g)
			{
				if(ChannelTrackEditPart.this.getSelected() == EditPart.SELECTED_PRIMARY)
				{
					g.setAlpha(50);
					g.setBackgroundColor(ColorConstants.lightGray);
					g.fillRectangle(bounds);
				}
				
				paintStrip(g, bounds);
			}

			@Override
			public boolean containsPoint(int x, int y)
			{
				return getBounds().contains(x, y);
			}

			@Override
			public IFigure findFigureAt(int x, int y, TreeSearch search)
			{
				if(!isEnabled())
					return null;
				if(!containsPoint(x, y))
					return null;
				if(search.prune(this))
					return null;
				IFigure child = findDescendantAtExcluding(x, y, search);
				if(child != null)
					return child;
				if(search.accept(this))
					return this;
				return null;
			}
		};
		
		channel.setOpaque(false);
		channel.setLayoutManager(new XYLayout());
		return channel;
	}

	@Override
	public void activate()
	{
		super.activate();
		selectionChangedListener = new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				ChannelTrackEditPart.this.invalidate();
			}
		};
		getViewer().addSelectionChangedListener(selectionChangedListener);
	}

	@Override
	public void deactivate()
	{
		super.deactivate();
		getViewer().removeSelectionChangedListener(selectionChangedListener);
	}

	protected void paintStrip(Graphics graphics, Rectangle bounds)
	{
		List<ControlPoint> points = getModelChildren();
		if(points.size() == 0) return;
		
		// 처음과 마지막 제어점의 위치를 찾는다.
		int xs = points.get(0).getFrame();
		int xe = points.get(points.size() - 1).getFrame();
		
		// 띠의 영역을 계산한다.
		Rectangle strip = new Rectangle(bounds);
		strip.x = xs;
		strip.y = bounds.y + MotionClip.CHANNEL_TRACK_HEIGHT_GAP;
		strip.width = xe - xs;
		strip.height = MotionClip.CHANNEL_TRACK_STRIP_HEIGHT;
		
		// 채널의 색상에 따라 띠 영역을 그린다.
		graphics.setBackgroundColor(getChannelColor());
		graphics.setAlpha(32);
		graphics.fillRectangle(strip);
	}
	
	@Override
	public DragTracker getDragTracker(Request request)
	{
		if(dragTracker == null)
		{
			dragTracker = new MyMarqueeDragTracker()
			{
				@Override
				protected boolean handleDoubleClick(int button)
				{
					IFigure figure = ChannelTrackEditPart.this.getFigure();
					Point where = getLocation();
					figure.translateToRelative(where);
					createControlPoint(where.x);
					return true;
				}

				@Override
				protected boolean handleButtonDown(int button)
				{
					getCurrentViewer().select(ChannelTrackEditPart.this);
					return super.handleButtonDown(button);
				}
			};
		}
		return dragTracker;
	}

	@Override
	public ChannelTrack getModel()
	{
		return (ChannelTrack)super.getModel();
	}

	// 제어점 리스트를 얻는다.
	@Override
	protected List<ControlPoint> getModelChildren()
	{
		return ((ChannelTrack)getModel()).getPoints();
	}

	// 채널의 영역에 따라 새로 그릴 영역을 설정한다.
	@Override
	protected void refreshVisuals()
	{
		Rectangle constraint = getModel().getConstraint();
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), constraint);
	}

	// 채널 편집에 대한 정책을 생성한다.
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ControlPointXYLayoutEditPolicy(getModel()));
	}

	// 프로퍼티의 변경에 따라 다시 그린다.
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if(e.getPropertyName().equals(ChannelTrack.P_CONSTRAINT)) // 채널의 영역
		{
			refreshVisuals();
		}
		
		if(e.getPropertyName().equals(ChannelTrack.P_CHILDREN)) // 채널의 제어점들
		{
			// create connection together
			refreshChildren();
			invalidate();
		}
		
		if(e.getPropertyName().equals(ControlPoint.P_CONSTRAINT)) // 제어점
		{
			invalidate();
		}
	}

	// 영역을 일부러 무효화시킨다.
	protected void invalidate()
	{
		getFigure().repaint();
//		IFigure graph = getFigure();
//		graph.setBounds(graph.getBounds().getTranslated(0, 1));
//		graph.setBounds(graph.getBounds().getTranslated(0, -1));
	}
	
	protected abstract Color getChannelColor();
	protected abstract void createControlPoint(int frame);
}
