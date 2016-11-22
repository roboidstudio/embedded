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

package org.roboid.studio.contentscomposer;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * 플레이 하고 있는 동안 나타나는 다이얼로그 창
 * 
 * @author Kyoung Jin Kim
 */
public class PlayerDialog extends Dialog
{
	private Shell shell;
	private Image icon;
//	private MotionDiagram diagram;
//	private RoboidBrowser browser;
//	private FlashViewer flash;
	
	public PlayerDialog(Shell parent, MotionContent content)
	{
		super(parent);
//		this.diagram = diagram;
	}

	public Shell open(boolean minimize)
	{
		// 다이얼로그 창을 만든다.
		Shell parent = getParent();
		shell = new Shell(parent, SWT.APPLICATION_MODAL | SWT.CLOSE);
		shell.setText(" Playing..");
		icon = ImageDescriptor.createFromFile(ContentsComposer.class, "movie16.png").createImage();
		shell.setImage(icon);
		shell.pack();
		
		// 다이얼로그 창의 위치를 설정한다.
		int x = parent.getBounds().x  + 525;
		int y = parent.getBounds().y + 51;
		shell.setBounds(x, y, 125, 0);
		
		// 화면을 최소화하는 경우
		if(minimize) shell.setMinimized(true);
		
		// 창을 연다.
		shell.open();

//		browser = new RoboidBrowser(shell);
//		flash = new FlashViewer(shell);

		return shell;
	}
	
	// 브라우저를 얻는다.
//	public RoboidBrowser getBrowser()
//	{
//		return browser;
//	}
	
	// 플래시를 얻는다.
//	public FlashViewer getFlash()
//	{
//		return flash;
//	}
	
	// 창을 닫는다.
	public void close()
	{
		if(icon != null) icon.dispose();
		shell.dispose();
	}
}
