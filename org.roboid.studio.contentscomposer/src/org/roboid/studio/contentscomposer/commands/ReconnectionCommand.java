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

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ReconnectionCommand extends Command
{
	private Association association; // 연결선
	private BlockElement newSource; // 새로운 소스 노드
	private BlockElement newTarget; // 새로운 타겟 노드
	private BlockElement oldSource; // 이전 소스 노드
	private BlockElement oldTarget; // 이전 타겟 노드

	public ReconnectionCommand(Association association)
	{
//		super();
		this.association = association; // 연결선
	}

	// 연결할  수 있는지 묻는다.
	@Override
	public boolean canExecute()
	{
		BlockElement source = association.getSource();
		BlockElement target = association.getTarget();
		
		if(newSource != null) // 소스 노드를 변경하는 경우
		{
			// 소스와 타겟이 같을 수는 없다.
			if(newSource == target) return false;
			
			// 소스 노드의 연결성 검사
			if(!newSource.canConnect(newSource, target)) return false;
			// 타겟 노드의 연결성 검사
			if(!target.canReconnect(newSource, null, source)) return false;
			return true;
		}
		else if(newTarget != null) // 타겟 노드를 변경하는 경우
		{
			// 소스와 타겟이 같을 수는 없다.
			if(newTarget == source) return true;

			// 소스 노드의 연결성 검사
			if(!source.canReconnect(null, newTarget, target)) return false;
			// 타겟 노드의 연결성 검사
			if(!newTarget.canConnect(source, newTarget)) return false;
			return true;
		}
		return false;
	}

	// 실행
	@Override
	public void execute()
	{
		if(newSource != null) // 소스 노드를 변경하는 경우
		{
			// Undo를 위해 소스 노드를 보관한다.
			oldSource = association.getSource();
			// 연결선의 소스 노드를 변경한다.
			association.setSource(newSource);
			// 이전 소스 노드에서 연결선을 삭제한다.
			oldSource.removeOutgoing(association);
			// 새로운 소스 노드에 연결선을 추가한다.
			newSource.addOutgoing(association);
			// 연결과 로직이 맞는지 검사한다.
			newSource.getParent().validate();
		}
		if(newTarget != null) // 타겟 노드를 변경하는 경우
		{
			// Undo를 위해 타겟 노드를 보관한다.
			oldTarget = association.getTarget();
			// 연결선의 타겟 노드를 변경한다.
			association.setTarget(newTarget);
			// 이전 타겟 노드에서 연결선을 삭제한다.
			oldTarget.removeIncoming(association);
			// 새로운 타겟 노드에 연결선을 추가한다.
			newTarget.addIncoming(association);
			// 연결과 로직이 맞는지 검사한다.
			newTarget.getParent().validate();
		}
	}

	// 새로운 소스 노드를 설정한다.
	public void setNewSource(BlockElement node)
	{
		newSource = node;
	}
	
	// 새로운 타겟 노드를 설정한다.
	public void setNewTarget(BlockElement node)
	{
		newTarget = node;
	}
	
	// 되돌리기
	@Override
	public void undo()
	{
		if(oldSource != null) // 소스 노드를 변경한 경우
		{
			newSource = association.getSource();
			// 연결선의 소스 노드를 변경한다.
			association.setSource(oldSource);
			// 이전 소스 노드에서 연결선을 삭제한다.
			newSource.removeOutgoing(association);
			// 새로운 소스 노드에 연결선을 추가한다.
			oldSource.addOutgoing(association);
			// 연결과 로직이 맞는지 검사한다.
			oldSource.getParent().validate();
		}
		if(oldTarget != null) // 타겟 노드를 변경한 경우
		{
			newTarget = association.getTarget();
			// 연결선의 타겟 노드를 변경한다.
			association.setTarget(oldTarget);
			// 이전 타겟 노드에서 연결선을 삭제한다.
			newTarget.removeIncoming(association);
			// 새로운 타겟 노드에 연결선을 추가한다.
			oldTarget.addIncoming(association);
			// 연결과 로직이 맞는지 검사한다.
			oldTarget.getParent().validate();
		}
	}
}
