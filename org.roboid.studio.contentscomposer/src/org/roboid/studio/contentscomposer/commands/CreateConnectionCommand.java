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
	private BlockElement source; // ���ἱ�� �ҽ� ���
	private BlockElement target; // ���ἱ�� Ÿ�� ���
	private Association association; // ���ἱ
	
	public CreateConnectionCommand(MotionContent parent, Association association)
	{
//		super();
		this.parent = parent;
		this.association = association; // ������ ���ἱ
	}
	
	// �ҽ� ��带 �����Ѵ�.
	public void setSource(BlockElement source)
	{
		this.source = source;
	}
	
	// Ÿ�� ��带 �����Ѵ�.
	public void setTarget(BlockElement target)
	{
		this.target = target;
	}
	
	// ������ �� �ִ��� ���´�.
	@Override
	public boolean canExecute()
	{ 
		// �ҽ��� Ÿ���� �־�� �ϰ� ���� �޶�� �Ѵ�.
		if(parent != null && source != null && target != null && !source.equals(target))
		{
			if(!source.canConnect(source, target)) return false; // �ҽ� ����� ���Ἲ �˻�
			if(!target.canConnect(source, target)) return false; // Ÿ�� ����� ���Ἲ �˻�
			return true;
		}
		return false;
	}

	// ����
	@Override
	public void execute()
	{
		// ���ἱ�� �ҽ��� Ÿ���� ��¼��� �Է¼����� �߰��Ѵ�.
		parent.addAssociation(association);
		source.addOutgoing(association);
		target.addIncoming(association);
		// ���ἱ�� �ҽ� ���� Ÿ�� ��带 �����Ѵ�.
		association.setTarget(target);
		association.setSource(source);
		// ����� ������ �´��� �˻��Ѵ�.
		parent.validate();
	}
	
	// �ǵ�����
	@Override
	public void undo()
	{
		// �ҽ� ���� Ÿ�� ��忡�� ���ἱ�� �����Ѵ�.
		source.removeOutgoing(association);
		target.removeIncoming(association);
		parent.removeAssociation(association);
		// ���ἱ�� �ҽ� ���� Ÿ�� ��带 �����Ѵ�.
		association.setTarget(null);
		association.setSource(null);
		// ����� ������ �´��� �˻��Ѵ�.
		parent.validate();
	}
}
