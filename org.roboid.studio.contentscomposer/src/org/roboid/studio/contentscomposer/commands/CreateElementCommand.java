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
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.TerminatorBlock;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class CreateElementCommand extends Command
{
	private MotionContent parent;
	private List<BlockElement> elements = new ArrayList<BlockElement>();
	
	public CreateElementCommand(MotionContent parent, BlockElement element)
	{
		this.parent = parent; // 모션 다이어그램
		this.elements.add(element); // 생성할 노드
	}
	
	public CreateElementCommand(MotionContent parent, List<BlockElement> elements)
	{
		this.parent = parent;
		this.elements = elements;
	}
	
	@Override
	public void execute()
	{
		for(BlockElement element : elements)
		{
			// 노드를 추가한다.
			parent.addChild(element);
			// 터미네이터 노드인 경우 다른 터미네이터 노드의 스크립트 타입을 복사한다.
			if(element instanceof TerminatorBlock)
				((TerminatorBlock)element).copyScriptType();
		}
		// 연결과 로직이 맞는지 검사한다.
		parent.validate();
	}

	// 되돌리기
	@Override
	public void undo()
	{
		for(BlockElement element : elements)
			parent.removeChild(element); // 삭제한다.
		parent.validate(); // 연결과 로직이 맞는지 검사한다.
	}
}
