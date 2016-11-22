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

package org.roboid.studio.robotcomposer.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.ConnectableElement;
import org.roboid.studio.robotcomposer.commands.CreateConnectionCommand;
import org.roboid.studio.robotcomposer.commands.ReconnectionCommand;

/**
 * @author Kwang-Hyun Park
 */
public class ConnectableElementGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy
{
	// starts connection
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request)
	{
		ConnectableElement source = (ConnectableElement)request.getTargetEditPart().getModel();
		CreateConnectionCommand command = new CreateConnectionCommand(source);
		request.setStartCommand(command);
		return command;
	}
	
	// completes connection
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
	{
		ConnectableElement target = (ConnectableElement)request.getTargetEditPart().getModel();
		CreateConnectionCommand command = (CreateConnectionCommand)request.getStartCommand();
		command.setTarget(target);
		return command;
	}

	// source reconnection
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request)
	{
		Association association = (Association)request.getConnectionEditPart().getModel();
		ReconnectionCommand command = new ReconnectionCommand(association, request.getTarget());
		command.setNewSource((ConnectableElement)getHost().getModel());
		return command;
	}

	// target reconnection
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request)
	{
 		Association association = (Association)request.getConnectionEditPart().getModel();
		ReconnectionCommand command = new ReconnectionCommand(association, request.getTarget());
		command.setNewTarget((ConnectableElement)getHost().getModel());
		return command;
	}
}
