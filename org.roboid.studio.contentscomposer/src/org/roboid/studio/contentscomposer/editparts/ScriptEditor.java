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

package org.roboid.studio.contentscomposer.editparts;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.roboid.studio.contentscomposer.Activator;
import org.roboid.studio.contentscomposer.BlockElement;

/**
 * Not used for the current version
 * 
 * @author Kyoung Jin Kim
 */
public class ScriptEditor implements MouseListener
{
	private static Rectangle rect = new Rectangle(400, 300, 480, 320);
	private BlockElementEditPart part;
	private long oldClick = System.currentTimeMillis();

	public ScriptEditor(BlockElementEditPart part)
	{
		this.part = part;
	}
	
	@Override
	public void mouseDoubleClicked(MouseEvent me){}

	// 더블 클릭을 하면 스크립트 에디터를 연다.
	@Override
	public void mousePressed(MouseEvent me)
	{
		Long click = System.currentTimeMillis();
//		System.out.println(click);
		if(click - oldClick < 450) open();
		oldClick = click;
	}

	@Override
	public void mouseReleased(MouseEvent me)
	{}

	public void open()
	{
		Shell parent = part.getViewer().getControl().getShell();
		Display display = Display.getDefault();
		Shell shell = new Shell(parent, SWT.APPLICATION_MODAL | SWT.CLOSE | SWT.RESIZE);
		shell.setText("Script editor");
		shell.setImage(ImageDescriptor.createFromFile(Activator.class,"scroll_edit.png").createImage()); //$NON-NLS-1$
		shell.setBounds(rect);
		shell.setLayout(new FillLayout());
		
		// 스크립트 코드를 얻는다.
		BlockElement nodeElement = (BlockElement)part.getModel();
		final Text text = new Text(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setText(nodeElement.getScriptCode());
		//execute dummy command
//		execute(new MoveElementCommand(
//			nodeElement.getX(), nodeElement.getY(), nodeElement));

		// 에디터 창을 연다.
		shell.open();
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch())
			{
				rect = shell.getBounds();
				nodeElement.setScriptCode(text.getText());
				display.sleep();
			}
		}
	}
}
