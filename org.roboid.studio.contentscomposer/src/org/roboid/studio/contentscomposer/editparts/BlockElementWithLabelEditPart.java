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

import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.roboid.studio.contentscomposer.BlockElement;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public abstract class BlockElementWithLabelEditPart extends BlockElementEditPart
{
	private LabelEditPart label;
	
	@Override
	public IFigure getFigure()
	{
		if(figure == null)
		{
			setFigure(createFigure());
			
			label = new LabelEditPart(this);
			addSourceConnection(label, 0);
		}
		return figure;
	}

	@Override
	public void removeNotify()
	{
		removeSourceConnection(label);
		label.removeNotify();
		label = null;
		super.removeNotify();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(BlockElement.P_LABEL))
		{
			label.refresh();
			return;
		}
		else if(event.getPropertyName().equals(BlockElement.P_REDRAW))
			label.refresh();

		super.propertyChange(event);
	}

	private class LabelEditPart extends AbstractConnectionEditPart
	{
		private AbstractGraphicalEditPart reference;
		
		LabelEditPart(AbstractGraphicalEditPart reference)
		{
			this.reference = reference;
			setSource(reference);
			setTarget(reference);
		}
		
		@Override
		protected void createEditPolicies()
		{
		}

		@Override
		protected IFigure createFigure()
		{
			PolylineConnection connection = new PolylineConnection()
			{
				@Override
				protected void outlineShape(Graphics g)
				{
				}
			};
			
			ConnectionEndpointLocator locator = new ConnectionEndpointLocator(connection, false)
			{
				@Override
				public void relocate(IFigure figure)
				{
					BlockElement node = (BlockElement)getSource().getModel();
					Label label = (Label)figure;
					label.setText((String)node.getLabel());
					
					Point ref = reference.getFigure().getBounds().getBottomLeft();
					int width = reference.getFigure().getPreferredSize().width;
					
					Rectangle rect = Rectangle.SINGLETON;
					rect.setSize(label.getPreferredSize());
					rect.setLocation((int)(ref.x + width * 0.5 - label.getPreferredSize().width * 0.5), ref.y + 2);
					figure.setBounds(rect);
				}
			};
			connection.add(new Label(), locator);
			return connection;
		}
	}
}
