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
	private Association association; // ���ἱ
	
	public DeleteConnectionCommand(MotionContent parent, Association association)
	{
		this.parent = parent;
		this.association = association; // ������ ���ἱ
	}

	@Override
	public boolean canExecute()
	{
		return parent != null;
	}

	// ����
	@Override
	public void execute()
	{
		// ���ἱ�� Ÿ�� ��忡�� ���ἱ�� �����Ѵ�.
		association.getTarget().removeIncoming(association);
		// ���ἱ�� �ҽ� ��忡�� ���ἱ�� �����Ѵ�.
		association.getSource().removeOutgoing(association);
		// ����� ������ �´��� �˻��Ѵ�.
		parent.removeAssociation(association);
		parent.validate();
	}

	@Override
	public boolean canUndo()
	{
		return parent != null;
	}

	// �ǵ�����
	@Override
	public void undo()
	{
		parent.addAssociation(association);
		// ���ἱ�� Ÿ�� ��忡 ���ἱ�� �ٽ� �߰��Ѵ�.
		association.getTarget().addIncoming(association);
		// ���ἱ�� �ҽ� ��忡 ���ἱ�� �ٽ� �߰��Ѵ�.
		association.getSource().addOutgoing(association);
		// ����� ������ �´��� �˻��Ѵ�.
		parent.validate();
	}
}
