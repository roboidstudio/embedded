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

import org.eclipse.gef.commands.Command;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class CreateConnectionCommand extends Command
{
	private MotionContent parent;
	private BlockElement source; // 연결선의 소스 노드
	private BlockElement target; // 연결선의 타겟 노드
	private Association association; // 연결선
	
	public CreateConnectionCommand(MotionContent parent, Association association)
	{
//		super();
		this.parent = parent;
		this.association = association; // 생성할 연결선
	}
	
	// 소스 노드를 설정한다.
	public void setSource(BlockElement source)
	{
		this.source = source;
	}
	
	// 타겟 노드를 설정한다.
	public void setTarget(BlockElement target)
	{
		this.target = target;
	}
	
	// 연결할 수 있는지 묻는다.
	@Override
	public boolean canExecute()
	{ 
		// 소스와 타겟이 있어야 하고 서로 달라야 한다.
		if(parent != null && source != null && target != null && !source.equals(target))
		{
			if(!source.canConnect(source, target)) return false; // 소스 노드의 연결성 검사
			if(!target.canConnect(source, target)) return false; // 타겟 노드의 연결성 검사
			return true;
		}
		return false;
	}

	// 실행
	@Override
	public void execute()
	{
		// 연결선을 소스와 타겟의 출력선과 입력선으로 추가한다.
		parent.addAssociation(association);
		source.addOutgoing(association);
		target.addIncoming(association);
		// 연결선의 소스 노드와 타겟 노드를 설정한다.
		association.setTarget(target);
		association.setSource(source);
		// 연결과 로직이 맞는지 검사한다.
		parent.validate();
	}
	
	// 되돌리기
	@Override
	public void undo()
	{
		// 소스 노드와 타겟 노드에서 연결선을 삭제한다.
		source.removeOutgoing(association);
		target.removeIncoming(association);
		parent.removeAssociation(association);
		// 연결선의 소스 노드와 타겟 노드를 삭제한다.
		association.setTarget(null);
		association.setSource(null);
		// 연결과 로직이 맞는지 검사한다.
		parent.validate();
	}
}
