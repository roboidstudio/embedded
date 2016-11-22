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
	private Association association; // ���ἱ
	private BlockElement newSource; // ���ο� �ҽ� ���
	private BlockElement newTarget; // ���ο� Ÿ�� ���
	private BlockElement oldSource; // ���� �ҽ� ���
	private BlockElement oldTarget; // ���� Ÿ�� ���

	public ReconnectionCommand(Association association)
	{
//		super();
		this.association = association; // ���ἱ
	}

	// ������  �� �ִ��� ���´�.
	@Override
	public boolean canExecute()
	{
		BlockElement source = association.getSource();
		BlockElement target = association.getTarget();
		
		if(newSource != null) // �ҽ� ��带 �����ϴ� ���
		{
			// �ҽ��� Ÿ���� ���� ���� ����.
			if(newSource == target) return false;
			
			// �ҽ� ����� ���Ἲ �˻�
			if(!newSource.canConnect(newSource, target)) return false;
			// Ÿ�� ����� ���Ἲ �˻�
			if(!target.canReconnect(newSource, null, source)) return false;
			return true;
		}
		else if(newTarget != null) // Ÿ�� ��带 �����ϴ� ���
		{
			// �ҽ��� Ÿ���� ���� ���� ����.
			if(newTarget == source) return true;

			// �ҽ� ����� ���Ἲ �˻�
			if(!source.canReconnect(null, newTarget, target)) return false;
			// Ÿ�� ����� ���Ἲ �˻�
			if(!newTarget.canConnect(source, newTarget)) return false;
			return true;
		}
		return false;
	}

	// ����
	@Override
	public void execute()
	{
		if(newSource != null) // �ҽ� ��带 �����ϴ� ���
		{
			// Undo�� ���� �ҽ� ��带 �����Ѵ�.
			oldSource = association.getSource();
			// ���ἱ�� �ҽ� ��带 �����Ѵ�.
			association.setSource(newSource);
			// ���� �ҽ� ��忡�� ���ἱ�� �����Ѵ�.
			oldSource.removeOutgoing(association);
			// ���ο� �ҽ� ��忡 ���ἱ�� �߰��Ѵ�.
			newSource.addOutgoing(association);
			// ����� ������ �´��� �˻��Ѵ�.
			newSource.getParent().validate();
		}
		if(newTarget != null) // Ÿ�� ��带 �����ϴ� ���
		{
			// Undo�� ���� Ÿ�� ��带 �����Ѵ�.
			oldTarget = association.getTarget();
			// ���ἱ�� Ÿ�� ��带 �����Ѵ�.
			association.setTarget(newTarget);
			// ���� Ÿ�� ��忡�� ���ἱ�� �����Ѵ�.
			oldTarget.removeIncoming(association);
			// ���ο� Ÿ�� ��忡 ���ἱ�� �߰��Ѵ�.
			newTarget.addIncoming(association);
			// ����� ������ �´��� �˻��Ѵ�.
			newTarget.getParent().validate();
		}
	}

	// ���ο� �ҽ� ��带 �����Ѵ�.
	public void setNewSource(BlockElement node)
	{
		newSource = node;
	}
	
	// ���ο� Ÿ�� ��带 �����Ѵ�.
	public void setNewTarget(BlockElement node)
	{
		newTarget = node;
	}
	
	// �ǵ�����
	@Override
	public void undo()
	{
		if(oldSource != null) // �ҽ� ��带 ������ ���
		{
			newSource = association.getSource();
			// ���ἱ�� �ҽ� ��带 �����Ѵ�.
			association.setSource(oldSource);
			// ���� �ҽ� ��忡�� ���ἱ�� �����Ѵ�.
			newSource.removeOutgoing(association);
			// ���ο� �ҽ� ��忡 ���ἱ�� �߰��Ѵ�.
			oldSource.addOutgoing(association);
			// ����� ������ �´��� �˻��Ѵ�.
			oldSource.getParent().validate();
		}
		if(oldTarget != null) // Ÿ�� ��带 ������ ���
		{
			newTarget = association.getTarget();
			// ���ἱ�� Ÿ�� ��带 �����Ѵ�.
			association.setTarget(oldTarget);
			// ���� Ÿ�� ��忡�� ���ἱ�� �����Ѵ�.
			newTarget.removeIncoming(association);
			// ���ο� Ÿ�� ��忡 ���ἱ�� �߰��Ѵ�.
			oldTarget.addIncoming(association);
			// ����� ������ �´��� �˻��Ѵ�.
			oldTarget.getParent().validate();
		}
	}
}
