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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RoboidBlock;

/**
 * @author Kwang-Hyun Park
 */
public class RobotComposerEditPartFactory implements EditPartFactory
{
	public static final EditPartFactory INSTANCE = new RobotComposerEditPartFactory();
	
	@Override
	public EditPart createEditPart(EditPart context, Object model)
	{
		EditPart part = null;
		if(model instanceof Association) part = new AssociationEditPart();
		else if(model instanceof RoboidBlock) part = new RoboidBlockEditPart();
		else if(model instanceof DeviceElement) part = new DeviceElementEditPart();
		else part = new RobotDiagramEditPart();

		part.setModel(model);
		return part;
	}
}
