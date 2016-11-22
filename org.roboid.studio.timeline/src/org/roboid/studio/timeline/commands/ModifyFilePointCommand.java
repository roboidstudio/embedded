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
import org.roboid.studio.timeline.FilePoint;
import org.roboid.studio.timeline.FileTrack;

/**
 * @author Kwang-Hyun Park
 */
public class ModifyFilePointCommand extends CreateFilePointCommand
{
	private String oldFileName;
	
	public ModifyFilePointCommand(FileTrack channel, FilePoint cp)
	{
		super(channel, cp);
		
		// Undo�� ���� ���� ���� ������ �д�.
		oldFileName = ((FilePoint)cp).getFileName();
	}
	
	@Override
	public boolean canExecute()
	{
		return openFileDialog(oldFileName);
	}

	@Override
	public void execute()
	{
		updateData();
	}

	// �ǵ�����
	@Override
	public void undo()
	{
		// �����ص� ���� ������ �ǵ�����.
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				cp.setPropertyValue(FilePoint.P_FILENAME, oldFileName);
			}
		});
	}
}
