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

package org.roboid.studio.timeline.commands;

import org.eclipse.swt.widgets.Display;
import org.roboid.studio.timeline.MatrixPoint;
import org.roboid.studio.timeline.MatrixTrack;

/**
 * @author Kwang-Hyun Park
 */
public class ModifyMatrixPointCommand extends CreateMatrixPointCommand
{
	private int[] oldValues;
	
	public ModifyMatrixPointCommand(MatrixTrack channel, MatrixPoint cp)
	{
		super(channel, cp);
		
		// Undo를 위해 이전 값을 저장해 둔다.
		oldValues = new int[((MatrixPoint)cp).getValues().length];
		for(int i = 0; i < oldValues.length; i ++)
			oldValues[i] = (int)((MatrixPoint)cp).getValues()[i];
	}
	
	@Override
	public boolean canExecute()
	{
		return openMatrixDialog(oldValues);
	}

	@Override
	public void execute()
	{
		updateData();
	}

	// 되돌리기
	@Override
	public void undo()
	{
		// 저장해둔 이전 값으로 되돌린다.
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				for(int i = 0; i < oldValues.length; i ++)
					cp.setPropertyValue(MatrixPoint.P_VALUE + i, String.valueOf(oldValues[i]));
			}
		});
	}
}
