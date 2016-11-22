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

package org.roboid.studio.timeline;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Kyoung Jin Kim
 */
public class PlayerDialog extends Dialog
{
	private Image icon;
	
	public PlayerDialog(Shell parent)
	{
		super(parent);
	}

	public void open(boolean minimize)
	{
		// ���̾�α� â�� �����.
		Shell parent = getParent();
		final Shell shell = new Shell(parent, SWT.APPLICATION_MODAL | SWT.CLOSE);
		shell.setText(" Playing..");
		icon = ImageDescriptor.createFromFile(TimelineEditor.class, "film_play.png").createImage();
		shell.setImage(icon);
		shell.pack();
		
		// ���̾�α� â�� ��ġ�� �����Ѵ�.
		int x = parent.getBounds().x  + 525;
		int y = parent.getBounds().y + 51;
		shell.setBounds(x, y, 125, 0);
		
		// ȭ���� �ּ�ȭ�ϴ� ���
		if(minimize) shell.setMinimized(true);
		
		// â�� ����.
		shell.open();
		
		Display display = parent.getDisplay();
		while(!shell.isDisposed()) // â�� ���� ������ ��ٸ���.
		{
			if(!display.readAndDispatch())
				display.sleep();
		}
		
		if(icon != null) icon.dispose();
	}
}
