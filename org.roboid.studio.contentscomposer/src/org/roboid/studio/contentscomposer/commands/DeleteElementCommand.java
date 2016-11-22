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
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class DeleteElementCommand extends Command
{
	private MotionContent parent; // ��� ���̾�׷�
	private BlockElement element; // ������ ���
	private List<BlockElement> selectedBlocks;
	private MotionClip motionObject;
	private MotionContent contentObject;
	
	// ���� ��� ���� �ҽ����ϴ� ������� ����Ʈ
	private List<Association> sources = new ArrayList<Association>(); 
	// ���� ��� ���� Ÿ��Ʈ���ϴ� ������� ����Ʈ
	private List<Association> targets = new ArrayList<Association>(); 
	
	public DeleteElementCommand(MotionContent parent, BlockElement element, List<BlockElement> selectedBlocks)
	{
//		super();
		this.parent = parent; // ��� ���̾�׷�
		this.element = element; // ������ ���
		this.selectedBlocks = selectedBlocks;
	}
	
	@Override
	public boolean canExecute()
	{
		if(parent == null || element == null) return false;
		if(selectedBlocks.isEmpty()) return false;
		if(!element.canDelete()) return false;
		
		if(element instanceof MotionClipBlock)
		{
			List<BlockElement> clones = new ArrayList<BlockElement>();
			for(BlockElement block : selectedBlocks)
			{
				if(block instanceof MotionClipCloneBlock)
				{
					if(((MotionClipCloneBlock)block).getOriginal() == element)
						clones.add(block);
				}
			}
			if(((MotionClipBlock)element).countClones() != clones.size())
				return false;
		}
		else if(element instanceof MotionContentBlock)
		{
			List<BlockElement> clones = new ArrayList<BlockElement>();
			for(BlockElement block : selectedBlocks)
			{
				if(block instanceof MotionContentCloneBlock)
				{
					if(((MotionContentCloneBlock)block).getOriginal() == element)
						clones.add(block);
				}
			}
			if(((MotionContentBlock)element).countClones() != clones.size())
				return false;
		}
		return true;
	}

	// ����
	@Override
	public void execute()
	{
		// Undo�� ���� ������ �����Ѵ�.
		sources.addAll(element.getOutgoings());
		targets.addAll(element.getIncomings());
		
		// Undo�� ���� ���� ������ ��� �ִ� ��ü�� �����Ѵ�.
		if(element instanceof MotionClipBlock)
			motionObject = ((MotionClipBlock)element).getMotionClip();
		if(element instanceof MotionContentBlock)
			contentObject = ((MotionContentBlock)element).getContent();
		
		// ��� ������ ���� �Ѵ�.
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
		
		// ��带 �����Ѵ�.
		parent.removeChild(element);
		// ����� ������ �´��� �˻��Ѵ�.
		parent.validate();
	}

	@Override
	public boolean canUndo()
	{
		return parent != null && element != null && element.canDelete();
	}

	// �ǵ�����
	@Override
	public void undo()
	{
		// ��带 �ٽ� �߰��Ѵ�.
		parent.addChild(element);
		// ��尡 �͹̳����� ��忴���� �ٸ� �͹̳����� ����� ��ũ��Ʈ Ÿ���� �����Ѵ�.
		if(element instanceof TerminatorBlock)
			((TerminatorBlock)element).copyScriptType();
		
		// ������ �����Ѵ�.
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
		
		// ���� ������ ��� �ִ� ��ü�� �����Ѵ�.
//		System.out.println("retore");
		if(element instanceof MotionClipBlock)
			((MotionClipBlock)element).setMotionClip(motionObject);
		if(element instanceof MotionContentBlock)
			((MotionContentBlock)element).setContent(contentObject);
		
		// ����Ҹ� �ʱ�ȭ�Ѵ�.
		sources.clear();
		targets.clear();
		// ����� ������ �´��� �˻��Ѵ�.
		parent.validate();
	}
}
