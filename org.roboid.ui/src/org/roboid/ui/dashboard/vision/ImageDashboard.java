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

package org.roboid.ui.dashboard.vision;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.roboid.ui.dashboard.AbstractDashboard;

/**
 * @author Kwang-Hyun Park
 */
public class ImageDashboard extends AbstractDashboard
{
	private ImageCanvas canvas;
	
	public ImageDashboard(String title)
	{
		super(title);
	}
	
	public ImageDashboard(String title, Plugin plugin)
	{
		super(title, plugin);
	}
	
	public ImageDashboard(String title, int x, int y)
	{
		super(title, x, y);
	}
	
	public ImageDashboard(String title, int x, int y, Plugin plugin)
	{
		super(title, x, y, plugin);
	}
	
	public ImageDashboard(String title, int style)
	{
		super(title, style);
	}
	
	public ImageDashboard(String title, int style, Plugin plugin)
	{
		super(title, style, plugin);
	}
	
	public ImageDashboard(String title, int x, int y, int style)
	{
		super(title, x, y, style);
	}
	
	public ImageDashboard(String title, int x, int y, int style, Plugin plugin)
	{
		super(title, x, y, style, plugin);
	}
	
	@Override
	protected void createContents(Shell shell)
	{
		shell.setLayout(new GridLayout());
		
		Composite panel = new Composite(shell, SWT.NONE);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		setCanvas(new ImageCanvas(getDisplay(), panel));
	}
	
	public void setCanvas(ImageCanvas canvas)
	{
		this.canvas = canvas;
	}
	
	public void update(ImageData imageData, String ... textOnImage)
	{
		if(canvas == null) return;
		canvas.update(imageData, textOnImage);
		if(canvas.isResized())
		{
			if(isDisposed()) return;
			getDisplay().asyncExec(new Runnable()
			{
				@Override
				public void run()
				{
					if(getShell() == null) return;
					getShell().pack();
				}
			});
		}
	}
}
