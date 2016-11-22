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
public class RoboidBrowserFactory
{
	private Shell parent;
	
	public RoboidBrowserFactory(Shell parent)
	{
		this.parent = parent;
	}
	
	/**
	 * Constructs a new instance of the browser window given its default title ("Roboid Browser"), default style (SWT.SHELL_TRIM |SWT.ON_TOP), default width (1024), and default height (768) values.
	 * The initial location of the browser window is the center of the display.
	 * @return a new instance of the browser window
	 */
	public RoboidBrowser create()
	{
		return create(SWT.DIALOG_TRIM | SWT.ON_TOP);
	}
	
	/**
	 * Constructs and opens a new instance of the browser window using its default title ("Roboid Browser"), default width (1024) and default height (768), and a given style value.
	 * The initial location of the browser window is the center of the display.
	 * @param style the value describing the browser window's behavior and appearance
	 * @return a new instance of the browser window
	 */
	public RoboidBrowser create(int style)
	{
		RoboidBrowser browser = RoboidBrowser.create(parent, style);
		browser.setTitle("Roboid Browser");
		browser.setSize(1024, 768);
		browser.moveToCenter();
		return browser;
	}
}
