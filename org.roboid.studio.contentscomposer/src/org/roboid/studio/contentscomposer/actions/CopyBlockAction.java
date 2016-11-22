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

package org.roboid.studio.contentscomposer.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.commands.CopyElementCommand;
import org.roboid.studio.contentscomposer.editparts.BlockElementEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class CopyBlockAction extends SelectionAction
{
	public CopyBlockAction(IWorkbenchPart part)
	{
		super(part);
		setLazyEnablementCalculation(true);
	}

	@Override
	protected void init()
	{
		super.init();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setText("Copy");
		setId(ActionFactory.COPY.getId());
		setHoverImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setEnabled(true);
	}
	
	@Override
	protected boolean calculateEnabled()
	{
		if(getSelectedObjects().isEmpty()) return false;
		
		for(Object o : getSelectedObjects())
		{
			if(o instanceof BlockElementEditPart)
			{
				BlockElement node = (BlockElement)((EditPart)o).getModel();
				if(node.canCopy()) return true;
			}
		}
		return false;
	}

	private boolean isSelected(BlockElement node)
	{
		for(Object o : getSelectedObjects())
		{
			if(o instanceof BlockElementEditPart)
			{
				if(((EditPart)o).getModel().equals(node))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public void run()
	{
		if(getSelectedObjects().isEmpty()) return;
		
		IWorkbenchPart part = getWorkbenchPart();
		if(part == null) return;
		
		MotionContent diagram = ((ContentsComposer)part).getContentsClip();
		if(diagram == null) return;

		List<BlockElement> nodes = new ArrayList<BlockElement>();
		for(BlockElement node : diagram.getBlocks())
		{
			if((node instanceof MotionClipBlock || node instanceof MotionContentBlock) && isSelected(node) && node.canCopy())
				nodes.add(node);
		}
		for(BlockElement node : diagram.getBlocks())
		{
			if(!(node instanceof MotionClipBlock) && !(node instanceof MotionContentBlock) && isSelected(node) && node.canCopy())
				nodes.add(node);
		}
		
		if(nodes.isEmpty()) return;
		
		new CopyElementCommand(nodes).execute();
	}
}
