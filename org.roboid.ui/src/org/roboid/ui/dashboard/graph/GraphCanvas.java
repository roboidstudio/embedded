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

package org.roboid.ui.dashboard.graph;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * @author Kwang-Hyun Park
 */
public class GraphCanvas extends Canvas implements PaintListener
{
	private Display display;
	private List<float[]> points = new ArrayList<float[]>();
	private int max, min, length, index;
	private Color[] colors = new Color[6];
	private String[] labels = new String[0];
	
	public GraphCanvas(Display display, Composite parent)
	{
		super(parent, SWT.NO_BACKGROUND|SWT.DOUBLE_BUFFERED);
		this.display = display;
		
		colors[0] = display.getSystemColor(SWT.COLOR_RED);
		colors[1] = display.getSystemColor(SWT.COLOR_GREEN);
		colors[2] = display.getSystemColor(SWT.COLOR_BLUE);
		colors[3] = display.getSystemColor(SWT.COLOR_YELLOW);
		colors[4] = display.getSystemColor(SWT.COLOR_CYAN);
		colors[5] = display.getSystemColor(SWT.COLOR_MAGENTA);

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
		if(max == min) return;
		
		int w = getBounds().width;
		int h = getBounds().height - 1;
		int sz = max - min;
		
		gc.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
		if(max > 0 && min < 0)
		{
			int p = (-min) * h / sz - 1;
			gc.drawLine(0, p, w, p);
		}
		gc.drawText("" + min, 1, h - 11, true);
		gc.drawText("" + max, 1, 1, true);
		
		int y = 12;
		for(int i = 0; i < labels.length; i ++)
		{
			Color color = display.getSystemColor(SWT.COLOR_CYAN);
			if(colors != null && i < colors.length)
				color = colors[i % colors.length];
			gc.setForeground(color);
			gc.drawText(labels[i], 1, y, true);
			y += 12;
		}
		
		for(int i = 0; i < points.size(); i ++)
		{
			float[] point = points.get(i);
			Color color = display.getSystemColor(SWT.COLOR_CYAN);
			if(colors != null && i < colors.length)
				color = colors[i % colors.length];
			
			if(point.length > 1)
			{
				gc.setForeground(color);
				int x1, y1, x2, y2;
				for(int j = 1; j < index; j ++)
				{
					x1 = (j - 1) * w / (point.length - 1);
					x2 = j * w / (point.length - 1);
					y1 = (int)((max - point[j-1]) * h / sz);
					y2 = (int)((max - point[j]) * h / sz);
					gc.drawLine(x1, y1, x2, y2);
				}
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
	
	public void addData(int[] data)
	{
		if(data == null) return;
		
		float[] point = new float[data.length];
		for(int i = 0; i < data.length; i ++)
			point[i] = data[i];
		addData(point);
	}
	
	public void addData(float[] data)
	{
		if(data == null) return;
		
		if(points.size() != data.length)
		{
			points = new ArrayList<float[]>();
			for(int i = 0; i < data.length; i ++)
				points.add(new float[length]);
			index = 0;
		}
		
		if(index < length)
		{
			for(int i = 0; i < data.length; i ++)
				points.get(i)[index] = data[i];
			index ++;
		}
		else
		{
			for(int i = 0; i < data.length; i ++)
			{
				float[] point = points.get(i);
				System.arraycopy(point, 1, point, 0, length-1);
				point[length-1] = data[i];
			}
		}
		doRedraw();
	}
	
	public void clear()
	{
		index = 0;
		doRedraw();
	}
	
	public void setRange(int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	
	public void setFrameLength(int length)
	{
		this.length = length;
	}
	
	public void setColors(Color[] colors)
	{
		this.colors = colors;
	}
	
	public void setLabels(String[] labels)
	{
		this.labels = labels;
	}
}
