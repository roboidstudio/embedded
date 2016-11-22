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

package org.roboid.studio.contentscomposer.editparts;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.swt.graphics.Color;
import org.roboid.studio.contentscomposer.Activator;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.editpolicies.BlockElementXYLayoutEditPolicy;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ContentsComposerDiagramEditPart extends EditPartWithListener
{
	@Override
	protected IFigure createFigure()
	{
		final MotionContent content = (MotionContent)getModel();
		
		FreeformLayer layer = new FreeformLayer()
		{
			@Override
			protected void paintClientArea(Graphics g)
			{
				int alpha = g.getAlpha();
				Color fg = g.getForegroundColor();
				g.setForegroundColor(ColorConstants.gray);
				
				int x = getClientArea().x;
				int width = getClientArea().width;
				int y = getClientArea().y;
				int height = getClientArea().height;
				int gap = MotionContent.GRID;
				
				// 그리드를 그린다.
				if(content.isGrid())
				{
					g.setAlpha(25);
					for(int i = gap; i < y + height;)
					{
						g.drawLine(x, i, x + width, i);
						i = i + gap;
					}
					for(int i = gap; i < x + width;)
					{
						g.drawLine(i, y, i, y + height);
						i = i + gap;
					}
					g.setAlpha(25);
					for(int i = 5 * gap; i < y + height;)
					{
						g.drawLine(x, i, x + width, i);
						i = i + 5 * gap;
					}
					for(int i = 5 * gap; i < x + width;)
					{
						g.drawLine(i, y, i, y + height);
						i = i + 5 * gap;
					}
				}
				
				// 필름을 그린다.
				g.setAlpha(50);
				g.drawImage(Activator.getImageDescriptor("/icons/movie128.png").createImage(), x + width - 140, y + height - 130);
				g.setAlpha(alpha);
				g.setForegroundColor(fg);
				
				super.paintClientArea(g);
			}
		};
		
		layer.setLayoutManager(new FreeformLayout());
		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
		//connLayer.setConnectionRouter(new FanRouter());
		//connLayer.setConnectionRouter(new ManhattanConnectionRouter());
		connLayer.setConnectionRouter(new ShortestPathConnectionRouter(layer)); 
		return layer;
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BlockElementXYLayoutEditPolicy());
	}

	// 노드 리스트를 얻는다.
	@Override
	protected List<BlockElement> getModelChildren()
	{
		return ((MotionContent)getModel()).getBlocks();
	}

	// 프로퍼티의 변경에 따라 다시 그린다.
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(MotionContent.P_CHILDREN)) // 콘텐츠 컴포우저의 노드들
		{
			refreshChildren();
			getFigure().repaint();
		}
		else if(event.getPropertyName().equals(MotionContent.P_GRID)) // 그리드
			getFigure().repaint();
	}
}
