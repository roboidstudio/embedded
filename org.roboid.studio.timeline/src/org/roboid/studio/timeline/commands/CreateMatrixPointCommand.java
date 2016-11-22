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
import org.eclipse.swt.widgets.Shell;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.MatrixPoint;
import org.roboid.studio.timeline.MatrixTrack;
import org.roboid.studio.timeline.dialog.MatrixDialog;

/**
 * @author Kwang-Hyun Park
 */
public class CreateMatrixPointCommand extends CreateControlPointCommand
{
	private int[] newValues;
	
	public CreateMatrixPointCommand(MatrixTrack channel, MatrixPoint cp)
	{
		super(channel, cp);
	}
	
	protected boolean openMatrixDialog(int[] oldValues)
	{
		// 연결된 디바이스가 있는지 검사한다.
		Device device = channel.getTargetDevice(0);
		if(device == null) return false;

		try
		{
			// 매트릭스 에디터를 연다.
			Shell shell = new Shell(Display.getCurrent());
			int rowcol = (int)Math.sqrt(device.getDataSize());
			MatrixDialog dialog;
			if(oldValues == null)
				dialog = new MatrixDialog(shell, rowcol, rowcol, device.getMin(), device.getMax(), device.getDefault());
			else
				dialog = new MatrixDialog(shell, rowcol, rowcol, device.getMin(), device.getMax(), oldValues);
			newValues = dialog.open();
			shell.dispose();
			return (newValues != null);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean canExecute()
	{
		return openMatrixDialog(null);
	}

	protected void updateData()
	{
		// 프로퍼티 뷰의 값을 변경한다.
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				for(int i = 0; i < newValues.length; i ++)
					cp.setPropertyValue(MatrixPoint.P_VALUE + i, String.valueOf(newValues[i]));
			}
		});
	}
	
	@Override
	public void execute()
	{
		super.execute();
		updateData();
	}
}
