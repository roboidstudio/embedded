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

package org.roboid.ui.dashboard.audio;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * @author Kwang-Hyun Park
 */
public class WaveCanvas extends Canvas implements PaintListener
{
	private Display display;
	private int[] waveData;
	
	public WaveCanvas(Display display, Composite parent)
	{
		super(parent, SWT.NO_BACKGROUND|SWT.DOUBLE_BUFFERED);
		this.display = display;
		addPaintListener(this);
	}

	@Override
	public void paintControl(PaintEvent e)
	{
		Image image = new Image(display, getBounds());
		GC gc = new GC(image);
		
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.fillRectangle(image.getBounds());
		
		drawWave(gc);
		
		e.gc.drawImage(image, 0, 0);
		
		image.dispose();
		gc.dispose();
	}
	
	protected void drawWave(GC gc)
	{
		int w = getBounds().width;
		int h = getBounds().height;
		
		gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
		gc.drawLine(0, h/2-1, w, h/2-1);
		
		if(waveData == null) return;
		
		if(waveData.length > 1)
		{
			gc.setForeground(display.getSystemColor(SWT.COLOR_CYAN));
			int x1, y1, x2, y2;
			for(int i = 1; i < waveData.length; i ++)
			{
				x1 = (i - 1) * w / (waveData.length - 1);
				x2 = i * w / (waveData.length - 1);
				y1 = h/2 + waveData[i-1] * h / 64000 - 1;
				y2 = h/2 + waveData[i] * h / 64000 - 1;
				gc.drawLine(x1, y1, x2, y2);
			}
		}
	}

	private void doRedraw()
	{
		if(isDisposed()) return;
		getDisplay().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(isDisposed()) return;
				redraw();
			}
		});
	}
	
	public void update(int[] waveData)
	{
		this.waveData = waveData;
		doRedraw();
	}
	
	public void update(int[] waveData, int len)
	{
		if(waveData == null)
			this.waveData = null;
		else
		{
			if(this.waveData == null || this.waveData.length != len)
				this.waveData = new int[len];
			int i = 0;
			for(; i < len && i < waveData.length; i ++)
				this.waveData[i] = waveData[i];
			for(; i < len; i ++)
				this.waveData[i] = 0;
		}
		doRedraw();
	}
	
	public void update(short[] waveData)
	{
		update(waveData, waveData.length);
	}
	
	public void update(short[] waveData, int len)
	{
		if(waveData == null)
			this.waveData = null;
		else
		{
			if(this.waveData == null || this.waveData.length != len)
				this.waveData = new int[len];
			int i = 0;
			for(; i < len && i < waveData.length; i ++)
				this.waveData[i] = waveData[i];
			for(; i < len; i ++)
				this.waveData[i] = 0;
		}
		doRedraw();
	}
}
