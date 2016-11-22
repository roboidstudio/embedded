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
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposer;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class MoveElementCommand extends Command
{
	private int x, oldx; // x��ǥ
	private int y, oldy; // y��ǥ
	private BlockElement element; // �̵��� ���
	
	public MoveElementCommand(int x, int y, BlockElement element)
	{
//		super();
		this.element = element; // �̵��� ���
		this.x = x; // �̵��� ��ġ�� x��ǥ
		this.y = y; // �̵��� ��ġ�� y��ǥ
	}

	// ����
	@Override
	public void execute()
	{
		// Undo�� ���� x,y ��ǥ�� �����Ѵ�.
		oldx = element.getX();
		oldy = element.getY();
		
		// ����� x, y ��ǥ�� �����Ѵ�.
		element.setX(ContentsComposer.snap(x));
		element.setY(ContentsComposer.snap(y));
	}

	// �ǵ�����
	@Override
	public void undo()
	{
		// ����� x, y ��ǥ�� �����Ѵ�.
		element.setX(oldx);
		element.setY(oldy);
	}
}
