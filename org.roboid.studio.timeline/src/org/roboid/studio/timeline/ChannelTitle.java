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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ChannelTitle extends Composite
{
	private Label icon;
	private CLabel title;
//	private Button arrow;

	public ChannelTitle(Composite parent, int style, int width)
	{
		super(parent, style);
		
		final GridLayout gridLayout = new GridLayout();
		gridLayout.horizontalSpacing = 5;
		gridLayout.marginHeight = 3;
		gridLayout.marginLeft = 10;
		gridLayout.numColumns = 2;
		setLayout(gridLayout);
		setBackground(ColorConstants.white);

		icon = new Label(this, SWT.NONE);
		icon.setLayoutData(new GridData(16, 16));
		icon.setBackground(ColorConstants.white);

		// 채널 이름
		title = new CLabel(this, SWT.NONE);
		title.setLayoutData(new GridData(width - 36, 18));
		title.setBackground(ColorConstants.white);
		
		// 화살표
//		arrow = new Button(this, SWT.ARROW | SWT.DOWN);
//		arrow.setLayoutData(new GridData(16, 16));
	}

	// 채널의 이름을 설정한다.
	public void setTitle(String title)
	{
		this.title.setText(title);
	}
	
	// 채널의 아이콘을 설정한다.
	public void setIcon(Image iconImage)
	{
		icon.setImage(iconImage);
	}
	
	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}
}
