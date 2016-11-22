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

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotGraphicalEditor;
import org.roboid.studio.robotcomposer.commands.MoveBlockElementCommand;

/**
 * @author Kwang-Hyun Park
 */
public class BlockElementXYLayoutEditPolicy extends XYLayoutEditPolicy
{
	// moves a block
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint)
	{
		Rectangle rect = (Rectangle)constraint;
		return new MoveBlockElementCommand(RobotGraphicalEditor.snap(rect.x), RobotGraphicalEditor.snap(rect.y), (RoboidBlock)child.getModel());
	}

	@Override
	protected Command getCreateCommand(CreateRequest request)
	{
		return null;
	}

	// no resize
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child)
	{
		return new NonResizableEditPolicy();
	}
}
