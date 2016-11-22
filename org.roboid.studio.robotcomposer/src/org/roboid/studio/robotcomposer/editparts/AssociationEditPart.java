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

package org.roboid.studio.robotcomposer.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.roboid.studio.robotcomposer.Association;

/**
 * @author Kwang-Hyun Park
 */
public class AssociationEditPart extends AbstractConnectionEditPart
{
	private PolylineConnection connection;

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
	}
	
	@Override
	protected IFigure createFigure()
	{
		connection = new PolylineConnection()
		{
			@Override
			protected void outlineShape(Graphics g)
			{
				g.setForegroundColor(ColorConstants.blue);
				g.setAlpha(50);
				super.outlineShape(g);
			}
		};
		
		connection.setTargetDecoration(new PolygonDecoration()
		{
			@Override
			protected void fillShape(Graphics g)
			{
				g.setForegroundColor(ColorConstants.blue);
				g.setAlpha(60);
				super.fillShape(g);
			}
		});
		
		connection.setLineWidth(2);
		if(getModel().isProxy())
			connection.setLineStyle(Graphics.LINE_DASH);
		
		return connection;
	}

	@Override
	public Association getModel()
	{
		return (Association)super.getModel();
	}
}
