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
import java.util.Map;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.jface.viewers.StructuredSelection;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;

/**
 * @author Kwang-Hyun Park
 */
public class PasteElementCommand extends Command
{
	private MotionContent newDiagram;
	private GraphicalViewer viewer;
	private List<EditPart> oldSelectedEditParts;
	private List<BlockElement> newBlocks;
	private List<Association> newAssociations;

	public PasteElementCommand(MotionContent newDiagram, GraphicalViewer viewer)
	{
		this.newDiagram = newDiagram;
		this.viewer = viewer;
	}
	
	@Override
	public void execute()
	{
		Object contents = Clipboard.getDefault().getContents();
		if(!(contents instanceof List<?>)) return;
		
		List<?> objects = (List<?>)contents;
		if(objects.isEmpty()) return;

		List<BlockElement> refBlocks = new ArrayList<BlockElement>();
		
		int top = -1, bottom = 0;
		for(Object o : objects)
		{
			if(o instanceof BlockElement)
			{
				BlockElement block = (BlockElement)o;
				if(block.getY() < top || top < 0)
					top = block.getY();
				refBlocks.add((BlockElement)o);
			}
		}
		if(refBlocks.size() == 0) return;
		
		for(BlockElement block : newDiagram.getBlocks())
		{
			if(block.getY() > bottom)
				bottom = block.getY();
		}
		int deviation = bottom - top + MotionContent.GRID * 4;
		
		MotionContent refDiagram = refBlocks.get(0).getParent();
		newBlocks = new ArrayList<BlockElement>();
		
		if(refDiagram == newDiagram)
		{
			for(BlockElement refBlock : refBlocks)
			{
				BlockElement newBlock;
				if(refBlock instanceof MotionClipBlock)
				{
					newBlock = ContentsComposerFactory.eINSTANCE.createMotionClipCloneBlock();
					((MotionClipCloneBlock)newBlock).setOriginal((MotionClipBlock)refBlock);
				}
				else if(refBlock instanceof MotionContentBlock)
				{
					newBlock = ContentsComposerFactory.eINSTANCE.createMotionContentCloneBlock();
					((MotionContentCloneBlock)newBlock).setOriginal((MotionContentBlock)refBlock);
				}
				else
					newBlock = refBlock.deepCopy(newDiagram);
				
				int x = ContentsComposer.snap(refBlock.getX());
				int y = ContentsComposer.snap(refBlock.getY() + deviation);
				
				newBlock.setX(x);
				newBlock.setY(y);
				newBlocks.add(newBlock);
				newDiagram.addChild(newBlock);
			}
		}
		else
		{
			for(BlockElement refBlock : refBlocks)
			{
				BlockElement newBlock;
				if(refBlock instanceof MotionClipBlock)
				{
					MotionClipBlock original = newDiagram.findMotionClipBlock(((MotionClipBlock)refBlock).getName());
					if(original != null)
					{
						newBlock = ContentsComposerFactory.eINSTANCE.createMotionClipCloneBlock();
						((MotionClipCloneBlock)newBlock).setOriginal(original);
					}
					else
					{
						newBlock = ((MotionClipBlock)refBlock).deepCopy(newDiagram);
						changeRobot(newBlock, refDiagram, newDiagram);
					}
				}
				else if(refBlock instanceof MotionClipCloneBlock)
				{
					MotionClipBlock original = newDiagram.findMotionClipBlock(((MotionClipCloneBlock)refBlock).getOriginal().getName());
					if(original != null)
					{
						newBlock = ContentsComposerFactory.eINSTANCE.createMotionClipCloneBlock();
						((MotionClipCloneBlock)newBlock).setOriginal(original);
					}
					else
					{
						newBlock = ((MotionClipCloneBlock)refBlock).getOriginal().deepCopy(newDiagram);
						changeRobot(newBlock, refDiagram, newDiagram);
					}
				}
				else if(refBlock instanceof MotionContentBlock)
				{
					MotionContentBlock original = newDiagram.findMotionContentBlock(((MotionContentBlock)refBlock).getName());
					if(original != null)
					{
						newBlock = ContentsComposerFactory.eINSTANCE.createMotionContentCloneBlock();
						((MotionContentCloneBlock)newBlock).setOriginal(original);
					}
					else
					{
						newBlock = ((MotionContentBlock)refBlock).deepCopy(newDiagram);
						changeRobot(newBlock, refDiagram, newDiagram);
					}
				}
				else if(refBlock instanceof MotionContentCloneBlock)
				{
					MotionContentBlock original = newDiagram.findMotionContentBlock(((MotionContentCloneBlock)refBlock).getOriginal().getName());
					if(original != null)
					{
						newBlock = ContentsComposerFactory.eINSTANCE.createMotionContentCloneBlock();
						((MotionContentCloneBlock)newBlock).setOriginal(original);
					}
					else
					{
						newBlock = ((MotionContentCloneBlock)refBlock).getOriginal().deepCopy(newDiagram);
						changeRobot(newBlock, refDiagram, newDiagram);
					}
				}
				else
					newBlock = refBlock.deepCopy(newDiagram);
				
				int x = ContentsComposer.snap(refBlock.getX());
				int y = ContentsComposer.snap(refBlock.getY() + deviation);
				
				newBlock.setX(x);
				newBlock.setY(y);
				newBlocks.add(newBlock);
				newDiagram.addChild(newBlock);
			}
		}
		
		newAssociations = new ArrayList<Association>();
		for(Association association : refDiagram.getAssociations())
		{
			if(refBlocks.contains(association.getSource()) && refBlocks.contains(association.getTarget()))
			{
				Association newAssociation = ContentsComposerFactory.eINSTANCE.createAssociation();
				int indexSource = refBlocks.indexOf(association.getSource());
				int indexTarget = refBlocks.indexOf(association.getTarget());
				if(indexSource >= 0 && indexTarget >= 0)
				{
					BlockElement newSource = newBlocks.get(indexSource);
					newSource.addOutgoing(newAssociation);
					newAssociation.setSource(newSource);
					
					BlockElement newTarget = newBlocks.get(indexTarget);
					newTarget.addIncoming(newAssociation);
					newAssociation.setTarget(newTarget);
					
					newAssociations.add(newAssociation);
					newAssociation.setSourceLabel(association.getSourceLabel());
					newAssociation.setTargetLabel(association.getTargetLabel());
				}
			}
		}
		for(Association association : newAssociations)
			newDiagram.addAssociation(association);
		
		oldSelectedEditParts = new ArrayList<EditPart>();
		for(Object o : viewer.getSelectedEditParts())
			oldSelectedEditParts.add((EditPart)o);
		
		@SuppressWarnings("unchecked")
		Map<BlockElement, EditPart> map = viewer.getEditPartRegistry();
		List<EditPart> newSelections = new ArrayList<EditPart>();
		for(BlockElement block : newBlocks)
		{
			EditPart editPart = map.get(block);
			if(editPart != null)
				newSelections.add(editPart);
		}
		viewer.setSelection(new StructuredSelection(newSelections.toArray()));
		
		// 연결과 로직이 맞는지 검사한다.
		if(newDiagram != null) newDiagram.validate();
		
		FigureCanvas fc = (FigureCanvas)viewer.getControl();
		if(fc != null)
		{
			fc.setRedraw(false);
			viewer.flush();
			fc.scrollToY(deviation);
			fc.setRedraw(true);
		}
	}
	
	private void changeRobot(BlockElement newBlock, MotionContent oldDiagram, MotionContent newDiagram)
	{
		IClip newClip = null;
		if(newBlock instanceof MotionClipBlock)
			newClip = ((MotionClipBlock)newBlock).getMotionClip();
		else if(newBlock instanceof MotionContentBlock)
			newClip = ((MotionContentBlock)newBlock).getContent();
		if(newClip == null) return;

		Robot oldRobot = oldDiagram.getRobot();
		if(oldRobot == null) return;
		Robot newRobot = newDiagram.getRobot();

		if(oldRobot.equalsContents(newRobot))
			newClip.updateReference(newRobot);
		else
			newClip.adaptTo(newRobot);
	}

	@Override
	public boolean canUndo()
	{
		return newBlocks != null && !newBlocks.isEmpty();
	}

	@Override
	public void undo()
	{
		for(Association association : newAssociations)
			newDiagram.removeAssociation(association);
		for(BlockElement block : newBlocks)
			newDiagram.removeChild(block); // 삭제한다.
		viewer.setSelection(new StructuredSelection(oldSelectedEditParts.toArray()));
		newDiagram.validate(); // 연결과 로직이 맞는지 검사한다.
	}

	@Override
	public void redo()
	{
		if(newBlocks == null || newBlocks.isEmpty()) return;
		
		oldSelectedEditParts = new ArrayList<EditPart>();
		for(Object o : viewer.getSelectedEditParts())
			oldSelectedEditParts.add((EditPart)o);
		
		int top = -1;
		for(BlockElement block : newBlocks)
		{
			newDiagram.addChild(block);
			if(block.getY() < top || top < 0)
				top = block.getY();
		}
		for(Association association : newAssociations)
			newDiagram.addAssociation(association);
		
		@SuppressWarnings("unchecked")
		Map<BlockElement, EditPart> map = viewer.getEditPartRegistry();
		List<EditPart> newSelections = new ArrayList<EditPart>();
		for(BlockElement block : newBlocks)
		{
			EditPart editPart = map.get(block);
			if(editPart != null)
				newSelections.add(editPart);
		}
		viewer.setSelection(new StructuredSelection(newSelections.toArray()));
		
		// 연결과 로직이 맞는지 검사한다.
		if(newDiagram != null) newDiagram.validate();
		
		FigureCanvas fc = (FigureCanvas)viewer.getControl();
		if(fc != null)
		{
			fc.setRedraw(false);
			viewer.flush();
			fc.scrollToY(top);
			fc.setRedraw(true);
		}
	}
}
