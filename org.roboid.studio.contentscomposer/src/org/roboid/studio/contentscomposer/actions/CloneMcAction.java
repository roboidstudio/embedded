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
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.commands.CreateElementCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class CloneMcAction extends SelectionAction
{
	public static String Id = "CloneMC";
	public static String CLONE_MC = "CloneMc";
	Request request;
	
	public CloneMcAction(IWorkbenchPart part)
	{
		super(part);
		request = new Request(CLONE_MC);
		setText("Clone");
		setId(CLONE_MC);
		setToolTipText("Clone Motion Clip");
		setImageDescriptor(ImageDescriptor.createFromFile(Activator.class,"film.png")); //$NON-NLS-1$
	}

	// 복사본 만들기가 가능한지 묻는다.
	@Override
	protected boolean calculateEnabled()
	{
		if(getSelectedObjects().isEmpty())	return false; // 선택된 것이 없다.
		
		for(Object o : getSelectedObjects())
		{
			if(o instanceof EditPart)
			{
				EditPart part = (EditPart)o;
				if(part.getModel() instanceof MotionClipBlock) return true; // 선택된 것이 모션 클립이다.
				if(part.getModel() instanceof MotionClipCloneBlock) return true; // 선택된 것이 모션 클립의 복사본이다.
			}
		}
		return false;
	}

	// 실행
	@Override
	public void run()
	{
		execute(getCommand());
	}

	@SuppressWarnings("unchecked")
	private Command getCommand()
	{
		MotionContent diagram = (MotionContent)((EditPart)getSelectedObjects().get(0)).getParent().getModel(); // 다이어그램
		List<BlockElement> elements = new ArrayList<BlockElement>();
		for(EditPart part : (List<EditPart>)getSelectedObjects()) // 선택된 노드에 대한 에디트 파트
		{
			BlockElement node = (BlockElement)part.getModel(); // 선택된 노드
			part.setSelected(EditPart.SELECTED_NONE);
			
			// TODO [박] 나중에 하나로 합칠 것
			
			// 복사본을 생성한다.
			if(part.getModel() instanceof MotionClipBlock || part.getModel() instanceof MotionClipCloneBlock)
			{
				MotionClipCloneBlock clip = ContentsComposerFactory.eINSTANCE.createMotionClipCloneBlock();
				// 선택된 것이 모션 클립이면 선택된 것을 원본으로 설정한다.
				if(part.getModel() instanceof MotionClipBlock)
					clip.setOriginal((MotionClipBlock)part.getModel());
				// 선택된 것이 모션 클립의 복사본이면 원본을 찾아서 원본으로 설정한다.
				else if(part.getModel() instanceof MotionClipCloneBlock)
					clip.setOriginal(((MotionClipCloneBlock)part.getModel()).getOriginal());
				
				// 한 그리드만큼 떨어진 곳에 생성한다.
				int grid = MotionContent.GRID;
				clip.setX(ContentsComposer.snap(node.getX() + grid));
				clip.setY(ContentsComposer.snap(node.getY() + grid));
				
				elements.add(clip);
			}
/*			else if(part.getModel() instanceof ContentClip || part.getModel() instanceof CloneContent)
			{
				CloneContent clip = new CloneContent();
				// 선택된 것이 콘텐츠 클립이면 선택된 것을 원본으로 설정한다.
				if(part.getModel() instanceof ContentClip)
					clip.setOriginalClip((ContentClip)part.getModel());
				// 선택된 것이 콘텐츠 클립의 복사본이면 원본을 찾아서 원본으로 설정한다.
				else if(part.getModel() instanceof CloneContent)
					clip.setOriginalClip(((CloneContent)part.getModel()).getOriginalClip());
				
				// 한 그리드만큼 떨어진 곳에 생성한다.
				int grid = MotionDiagram.GRID;
				clip.setX(MotionDiagram.snap(node.getX() + grid));
				clip.setY(MotionDiagram.snap(node.getY() + grid));
				
				elements.add(clip);
			}*/
		}
		return new CreateElementCommand(diagram, elements);
	}
	
	// ID를 얻는다.
	@Override
	public String getId()
	{
		return Id;
	}	
}
