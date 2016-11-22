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

package org.roboid.studio.contentscomposer.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.Clipboard;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kwang-Hyun Park
 */
public class CutElementCommand extends Command
{
	private MotionContent parent;
	private List<BlockElement> nodes;
	private List<Association> sources = new ArrayList<Association>();
	private List<Association> targets = new ArrayList<Association>();
	
	public CutElementCommand(MotionContent parent, List<BlockElement> nodes)
	{
		this.parent = parent;
		this.nodes = nodes;
	}
	
	@Override
	public void execute()
	{
		for(BlockElement node : nodes)
		{
			sources.addAll(node.getOutgoings());
			targets.addAll(node.getIncomings());
			parent.removeChild(node);
		}
		for(Association association : sources)
		{
			association.getTarget().removeIncoming(association);
			parent.removeAssociation(association);
		}
		for(Association association : targets)
		{
			association.getSource().removeOutgoing(association);
			parent.removeAssociation(association);
		}
		
		parent.validate();
		Clipboard.getDefault().setContents(nodes);
	}

	@Override
	public void undo()
	{
		for(BlockElement node : nodes)
			parent.addChild(node);
		for(Association association : sources)
		{
			parent.addAssociation(association);
			association.getTarget().addIncoming(association);
		}
		for(Association association : targets)
		{
			parent.addAssociation(association);
			association.getSource().addOutgoing(association);
		}
		
		sources.clear();
		targets.clear();
		parent.validate();
	}
}
