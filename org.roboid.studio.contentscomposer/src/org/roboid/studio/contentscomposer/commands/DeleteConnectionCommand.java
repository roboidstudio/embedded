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
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class DeleteConnectionCommand extends Command
{
	private MotionContent parent;
	private Association association; // 연결선
	
	public DeleteConnectionCommand(MotionContent parent, Association association)
	{
		this.parent = parent;
		this.association = association; // 삭제할 연결선
	}

	@Override
	public boolean canExecute()
	{
		return parent != null;
	}

	// 실행
	@Override
	public void execute()
	{
		// 연결선의 타겟 노드에서 연결선을 삭제한다.
		association.getTarget().removeIncoming(association);
		// 연결선의 소스 노드에서 연결선을 삭제한다.
		association.getSource().removeOutgoing(association);
		// 연결과 로직이 맞는지 검사한다.
		parent.removeAssociation(association);
		parent.validate();
	}

	@Override
	public boolean canUndo()
	{
		return parent != null;
	}

	// 되돌리기
	@Override
	public void undo()
	{
		parent.addAssociation(association);
		// 연결선의 타겟 노드에 연결선을 다시 추가한다.
		association.getTarget().addIncoming(association);
		// 연결선의 소스 노드에 연결선을 다시 추가한다.
		association.getSource().addOutgoing(association);
		// 연결과 로직이 맞는지 검사한다.
		parent.validate();
	}
}
