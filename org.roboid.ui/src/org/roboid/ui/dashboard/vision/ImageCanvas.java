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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * @author Kwang-Hyun Park
 */
public class ImageCanvas extends Canvas implements PaintListener
{
	private Display display;
	private ImageData imageData;
	private String[] textData;
	private int width = 320, height = 240;
	private boolean autoSize = true;
	private boolean isResized;
	
	public ImageCanvas(Display display, Composite parent)
	{
		super(parent, SWT.NO_BACKGROUND|SWT.DOUBLE_BUFFERED);
		this.display = display;
		addPaintListener(this);
		
		if(display == null || display.isDisposed()) return;
		display.syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				setSize(computeSize(width, height));
			}
		});
	}
	
	@Override
	public void paintControl(PaintEvent e)
	{
		drawImage(e.gc);
		drawText(e.gc);
	}

	protected void drawImage(GC gc)
	{
		if(imageData == null)
		{
			gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
			gc.fillRectangle(getBounds());
		}
		else
		{
			Image image = new Image(display, imageData);
			gc.drawImage(image, 0, 0);
			image.dispose();
			drawImageSize(gc);
		}
	}
	
	protected void drawImageSize(GC gc)
	{
		gc.setForeground(display.getSystemColor(SWT.COLOR_YELLOW));
		StringBuilder sb = new StringBuilder();
		gc.drawText(sb.append(imageData.width).append("x").append(imageData.height).toString(), 10, 10, true);
	}
	
	protected void drawText(GC gc)
	{
		if(textData == null) return;
		gc.setForeground(display.getSystemColor(SWT.COLOR_YELLOW));
		for(int i = 0; i < textData.length; i ++)
			gc.drawText(textData[i], 10, 15*i+25, true);
	}

	public boolean isAutoSize()
	{
		return autoSize;
	}
	
	public void setAutoSize(boolean autoSize)
	{
		this.autoSize = autoSize;
	}
	
	public boolean isResized()
	{
		return isResized;
	}
	
	public void update(ImageData imageData, String ... textOnImage)
	{
		if(autoSize)
		{
			if(imageData == null)
			{
				width = height = 0;
				isResized = true;
			}
			else if(this.imageData == null || this.imageData.width != imageData.width || this.imageData.height != imageData.height)
			{
				width = imageData.width;
				height = imageData.height;
				isResized = true;
			}
			else
				isResized = false;
		}
		this.imageData = imageData;
		
		if(textOnImage == null)
			textData = null;
		else
		{
			if(textData == null || textData.length != textOnImage.length)
				textData = new String[textOnImage.length];
			int i = 0;
			for(String v : textOnImage)
				textData[i++] = v;
		}
		
		if(isDisposed()) return;
		getDisplay().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(isResized) setSize(computeSize(width, height));
				if(isDisposed()) return;
				redraw();
			}
		});
	}
}
