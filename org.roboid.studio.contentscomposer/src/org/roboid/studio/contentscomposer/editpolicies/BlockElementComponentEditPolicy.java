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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.commands.DeleteElementCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class BlockElementComponentEditPolicy extends ComponentEditPolicy
{
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest)
	{
		MotionContent parent = (MotionContent)getHost().getParent().getModel(); // 노드의 부모
		BlockElement element = (BlockElement)getHost().getModel(); // 삭제할 노드

		List<BlockElement> selectedBlocks = new ArrayList<BlockElement>();
		@SuppressWarnings("unchecked")
		List<EditPart> selectedParts = deleteRequest.getEditParts();
		if(selectedParts != null)
		{
			for(EditPart part : selectedParts)
			{
				if(part.getModel() instanceof BlockElement)
					selectedBlocks.add((BlockElement)part.getModel());
			}
		}
		
		return new DeleteElementCommand(parent, element, selectedBlocks);
	}
}
