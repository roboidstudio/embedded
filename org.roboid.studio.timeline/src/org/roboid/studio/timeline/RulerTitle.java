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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * @author Kyoung Jin Kim
 */
public class RulerTitle extends Composite
{
	private Label icon;
	private CLabel name;

	/**
	 * Create the composite
	 * @param parent
	 * @param style
	 */
	public RulerTitle(Composite parent, int style)
	{
		super(parent, style);
		
		// 레이아웃
		final GridLayout gl = new GridLayout();
		gl.horizontalSpacing = 6;
		gl.marginHeight = 0;
		gl.numColumns = 2;
		setLayout(gl);

		// 아이콘
		icon = new Label(this, SWT.NONE);
		icon.setLayoutData(new GridData(16, 14));
		icon.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
//		icon.setImage(ResourceManager.getPluginImage(Activator.getDefault(), "icons/clip.gif"));
		
		// "x20 msec"를 표시
		name = new CLabel(this, SWT.NONE);
		name.setText("x20 msec");
		name.setLayoutData(new GridData(115, 16));
		name.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}
}
