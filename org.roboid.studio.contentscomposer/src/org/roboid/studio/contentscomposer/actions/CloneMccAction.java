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
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.roboid.studio.contentscomposer.Activator;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.commands.CreateElementCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class CloneMccAction extends SelectionAction
{
	public static String Id = "CloneMCC";
	public static String CLONE_MCC = "CloneMcc";
	Request request;
	
	public CloneMccAction(IWorkbenchPart part)
	{
		super(part);
		request = new Request(CLONE_MCC);
		setText("Clone");
		setId(CLONE_MCC);
		setToolTipText("Clone Contents Clip");
		setImageDescriptor(
		ImageDescriptor.createFromFile(Activator.class,"movie16.png")); //$NON-NLS-1$
	}

	// ���纻 ����Ⱑ �������� ���´�.
	@Override
	protected boolean calculateEnabled()
	{
		if (getSelectedObjects().isEmpty())	return false; // ���õ� ���� ����.
		
		for(Object o : getSelectedObjects())
		{
			if(o instanceof EditPart)
			{
				EditPart part = (EditPart)o;
				if(part.getModel() instanceof MotionContentBlock) return true; // ���õ� ���� ������ Ŭ���̴�.
				if(part.getModel() instanceof MotionContentCloneBlock) return true; // ���õ� ���� ������ Ŭ���� ���纻�̴�.
			}
		}
		return false;
	}
	
	// ����
	@Override
	public void run()
	{
		execute(getCommand());
	}

	@SuppressWarnings("unchecked")
	private Command getCommand()
	{
		MotionContent diagram = (MotionContent)((EditPart)getSelectedObjects().get(0)).getParent().getModel(); // ���̾�׷�
		List<BlockElement> elements = new ArrayList<BlockElement>();
		for(EditPart part : (List<EditPart>)getSelectedObjects()) // ���õ� ��忡 ���� ����Ʈ ��Ʈ
		{
			BlockElement node = (BlockElement)part.getModel(); // ���õ� ���
			part.setSelected(EditPart.SELECTED_NONE);
			
			// TODO [��] ���߿� �ϳ��� ��ĥ ��
			
			// ���纻�� �����Ѵ�.
			if(part.getModel() instanceof MotionContentBlock || part.getModel() instanceof MotionContentCloneBlock)
			{
				MotionContentCloneBlock clip = ContentsComposerFactory.eINSTANCE.createMotionContentCloneBlock();
				// ���õ� ���� ������ Ŭ���̸� ���õ� ���� �������� �����Ѵ�.
				if(part.getModel() instanceof MotionContentBlock)
					clip.setOriginal((MotionContentBlock)part.getModel());
				// ���õ� ���� ������ Ŭ���� ���纻�̸� ������ ã�Ƽ� �������� �����Ѵ�.
				else if(part.getModel() instanceof MotionContentCloneBlock)
					clip.setOriginal(((MotionContentCloneBlock)part.getModel()).getOriginal());
				
				// �� �׸��常ŭ ������ ���� �����Ѵ�.
				int grid = MotionContent.GRID;
				clip.setX(ContentsComposer.snap(node.getX() + grid));
				clip.setY(ContentsComposer.snap(node.getY() + grid));
				
				elements.add(clip);
			}
/*			else if(part.getModel() instanceof MotionClip || part.getModel() instanceof CloneClip)
			{
				CloneClip clip = new CloneClip();
				// ���õ� ���� ��� Ŭ���̸� ���õ� ���� �������� �����Ѵ�.
				if(part.getModel() instanceof MotionClip)
					clip.setOriginalClip((MotionClip)part.getModel());
				// ���õ� ���� ��� Ŭ���� ���纻�̸� ������ ã�Ƽ� �������� �����Ѵ�.
				else if(part.getModel() instanceof CloneClip)
					clip.setOriginalClip(((CloneClip)part.getModel()).getOriginalClip());
				
				// �� �׸��常ŭ ������ ���� �����Ѵ�.
				int grid = MotionDiagram.GRID;
				clip.setX(MotionDiagram.snap(node.getX() + grid));
				clip.setY(MotionDiagram.snap(node.getY() + grid));
				
				elements.add(clip);
			}*/
		}
		return new CreateElementCommand(diagram, elements); 
	}
	
	// ID�� ��´�.
	@Override
	public String getId()
	{
		return Id;
	}
}
