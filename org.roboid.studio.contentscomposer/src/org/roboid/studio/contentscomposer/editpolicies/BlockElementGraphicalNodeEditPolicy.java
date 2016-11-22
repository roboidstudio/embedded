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

package org.roboid.studio.contentscomposer.editpolicies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.commands.CreateConnectionCommand;
import org.roboid.studio.contentscomposer.commands.ReconnectionCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class BlockElementGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy
{
	// ������ �Ϸ��ϴ� ����� �����Ѵ�.
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request)
	{
		BlockElement element = (BlockElement)request.getTargetEditPart().getModel();
		CreateConnectionCommand command = (CreateConnectionCommand)request.getStartCommand();
		command.setTarget(element); // Ÿ�� ����
		return command;
	}

	// ������ �����ϴ� ����� �����Ѵ�.
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request)
	{
		Association association = (Association)request.getNewObject();
		BlockElement block = (BlockElement)request.getTargetEditPart().getModel();
		CreateConnectionCommand command = new CreateConnectionCommand(block.getParent(), association);
		command.setSource(block); // �ҽ� ����
		request.setStartCommand(command);
		return command;
	}

	// �ҽ��� ������ �����ϴ�  ����� �����Ѵ�.
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request)
	{
		Association association = (Association)request.getConnectionEditPart().getModel();
		ReconnectionCommand command = new ReconnectionCommand(association);
		command.setNewSource((BlockElement)getHost().getModel());
		return command;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request)
	{
 		Association association = (Association)request.getConnectionEditPart().getModel();
		ReconnectionCommand command = new ReconnectionCommand(association);
		command.setNewTarget((BlockElement)getHost().getModel());
		return command;
	}
}
