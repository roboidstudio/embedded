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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.commands.CreateElementCommand;
import org.roboid.studio.contentscomposer.commands.MoveElementCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class BlockElementXYLayoutEditPolicy extends XYLayoutEditPolicy
{
	// ����� ���� ���濡 ���� ����� �����Ѵ�.
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint)
	{
		Rectangle rect = (Rectangle)constraint; // ���ο� ����
		BlockElement element = (BlockElement)child.getModel(); // ������ ���
		return new MoveElementCommand(rect.x, rect.y, element);
	}

	// ����� ������ ���� ����� �����Ѵ�.
	@Override
	protected Command getCreateCommand(CreateRequest request)
	{
		//Point point = request.getLocation();
		BlockElement element = (BlockElement)request.getNewObject(); // ������ ���
		MotionContent parent = (MotionContent)getHost().getModel(); // ����� �θ�
		
		// getLocation()�� ��� ��ġ�̹Ƿ� ���Ұ�
		Rectangle rect = (Rectangle)getConstraintFor(request); // ����� ����
		element.setX(ContentsComposer.snap(rect.x));
		element.setY(ContentsComposer.snap(rect.y));
		return new CreateElementCommand(parent, element);
	}

	// ũ�� ������ �����Ѵ�.
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child)
	{
		return new NonResizableEditPolicy();
	}
}
