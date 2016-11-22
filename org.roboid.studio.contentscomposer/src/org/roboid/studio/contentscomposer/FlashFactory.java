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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class FlashFactory
{
	private Shell parent;
	
	public FlashFactory(Shell parent)
	{
		this.parent = parent;
	}
	
	/**
	 * Constructs a new instance of the flash window given its default title ("Roboid Flash"), default style (SWT.SHELL_TRIM |SWT.ON_TOP), default width (1024), and default height (768) values.
	 * The initial location of the flash window is the center of the display.
	 * @return a new instance of the flash window
	 */
	public FlashViewer create()
	{
		return create(SWT.SHELL_TRIM |SWT.ON_TOP);
	}
	
	/**
	 * Constructs a new instance of the flash window using its default title ("Roboid Flash"), default width (1024) and default height (768), and a given style value.
	 * The initial location of the flash window is the center of the display.
	 * @param style the value describing the flash window's behavior and appearance
	 * @return a new instance of the flash window
	 */
	public FlashViewer create(int style)
	{
		FlashViewer viewer = FlashViewer.create(parent, style);
		viewer.setTitle("Roboid Flash");
		viewer.setSize(1024, 768);
		viewer.moveToCenter();
		return viewer;
	}
}
