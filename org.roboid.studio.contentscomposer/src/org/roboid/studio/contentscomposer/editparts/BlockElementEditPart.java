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

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.actions.EditScriptAction;
import org.roboid.studio.contentscomposer.editpolicies.BlockElementComponentEditPolicy;
import org.roboid.studio.contentscomposer.editpolicies.BlockElementGraphicalNodeEditPolicy;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public abstract class BlockElementEditPart extends EditPartWithListener implements NodeEditPart
{
	// 노드의 편집에 대한 정책을 생성한다.
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new BlockElementGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new BlockElementComponentEditPolicy());
	}

	// 프로퍼티의 변경에 따라 다시 그린다.
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(BlockElement.P_X))
		{
			refreshVisuals();
		}
		else if(event.getPropertyName().equals(BlockElement.P_Y))
		{
			refreshVisuals();
		}
		else if(event.getPropertyName().equals(BlockElement.P_INCOMING))
		{
			refreshTargetConnections();
		}
		else if(event.getPropertyName().equals(BlockElement.P_OUTGOING))
		{
			refreshSourceConnections();
		}
		else if(event.getPropertyName().equals(BlockElement.P_REDRAW))
		{
			getFigure().repaint();
		}
	}

	// 노드의 위치 변경에 따라 다시 그린다.
	@Override
	protected void refreshVisuals()
	{
		BlockElement element = (BlockElement)getModel();
		
		Point point = new Point(element.getX(), element.getY());
		Dimension dim = new Dimension(-1, -1);
		Rectangle rect = new Rectangle(point, dim);
		
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), rect);
	}

	// 노드의 출력선 리스트를 얻는다.
	@Override
	protected List<Association> getModelSourceConnections()
	{
		return ((BlockElement)getModel()).getOutgoings();
	}
	
	// 노드의 입력선 리스트를 얻는다.
	@Override
	protected List<Association> getModelTargetConnections()
	{
		return ((BlockElement)getModel()).getIncomings();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart arg0)
	{
		return new ChopboxAnchor(getFigure());
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request arg0)
	{
		return new ChopboxAnchor(getFigure());
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart arg0)
	{
		return new ChopboxAnchor(getFigure());
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request arg0)
	{
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public void performRequest(Request req)
	{
		if(req.getType() == RequestConstants.REQ_OPEN)
		{
			IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			EditScriptAction action = new EditScriptAction(editor);
			action.run(this);
		}
	}
}
