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
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.commands.CutElementCommand;
import org.roboid.studio.contentscomposer.editparts.BlockElementEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class CutBlockAction extends SelectionAction
{
	private List<BlockElement> cutBlocks;
	
	public CutBlockAction(IWorkbenchPart part)
	{
		super(part);
		setLazyEnablementCalculation(true);
	}
	
	@Override
	protected void init()
	{
		super.init();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setText("Cut");
		setId(ActionFactory.CUT.getId());
		setHoverImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
		setEnabled(true);
	}

	@Override
	protected boolean calculateEnabled()
	{
		if(getSelectedObjects().isEmpty()) return false;

		cutBlocks = new ArrayList<BlockElement>();
		
		IWorkbenchPart part = getWorkbenchPart();
		if(part == null) return false;
		
		MotionContent diagram = ((ContentsComposer)part).getContentsClip();
		if(diagram == null) return false;
		
		for(Object o : getSelectedObjects())
		{
			if(o instanceof BlockElementEditPart)
			{
				if(!((BlockElement)((EditPart)o).getModel()).canCut())
					return false;
			}
		}
		
		for(BlockElement block : diagram.getBlocks())
		{
			if((block instanceof MotionClipBlock || block instanceof MotionContentBlock) && isSelected(block) && block.canCut())
				cutBlocks.add(block);
		}
		for(BlockElement block : diagram.getBlocks())
		{
			if(!(block instanceof MotionClipBlock) && !(block instanceof MotionContentBlock) && isSelected(block) && block.canCut())
				cutBlocks.add(block);
		}
		
		if(cutBlocks.isEmpty()) return false;
		
		for(BlockElement block : cutBlocks)
		{
			if(checkCut(block) == false)
				return false;
		}
		return true;
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

	private boolean checkCut(BlockElement block)
	{
		if(cutBlocks == null || cutBlocks.isEmpty()) return false;
		
		if(block instanceof MotionClipBlock)
		{
			List<BlockElement> clones = new ArrayList<BlockElement>();
			for(BlockElement node : cutBlocks)
			{
				if(node instanceof MotionClipCloneBlock)
				{
					if(((MotionClipCloneBlock)node).getOriginal() == block)
						clones.add(node);
				}
			}
			if(((MotionClipBlock)block).countClones() != clones.size())
				return false;
		}
		else if(block instanceof MotionContentBlock)
		{
			List<BlockElement> clones = new ArrayList<BlockElement>();
			for(BlockElement node : cutBlocks)
			{
				if(node instanceof MotionContentCloneBlock)
				{
					if(((MotionContentCloneBlock)node).getOriginal() == block)
						clones.add(node);
				}
			}
			if(((MotionContentBlock)block).countClones() != clones.size())
				return false;
		}
		return true;
	}
	
	@Override
	public void run()
	{
		if(getSelectedObjects().isEmpty()) return;
		if(cutBlocks == null || cutBlocks.isEmpty()) return;
		
		IWorkbenchPart part = getWorkbenchPart();
		if(part == null) return;
		
		MotionContent diagram = ((ContentsComposer)part).getContentsClip();
		if(diagram == null) return;
		
		execute(new CutElementCommand(diagram, cutBlocks));
	}
}
