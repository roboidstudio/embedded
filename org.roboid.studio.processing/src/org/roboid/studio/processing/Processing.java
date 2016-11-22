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

package org.roboid.studio.processing;

import java.awt.Rectangle;

import javax.script.ScriptEngine;

import org.eclipse.swt.widgets.Display;

/**
 * @author Kwang-Hyun Park
 */
public class Processing
{
	private ScriptEngine scriptEngine;
	private boolean hasFrame;
	private String title = "";
	private String mode = "";
	private int x = -1, y = -1;
	private int width = 1024, height = 768;
	private String func = "";
	private PFrame frame;
	private Sketch sketch;
	
	private Processing(ScriptEngine engine, boolean hasFrame)
	{
		this.scriptEngine = engine;
		this.hasFrame = hasFrame;
	}
	
	/**
	 * Constructs a new instance of the processing given its script engine.
	 * @param engine the script engine
	 * @param hasFrame {@code true} if the processing has a frame and {@code false} otherwise
	 * @return a new instance of the processing
	 */
	static Processing create(ScriptEngine engine, boolean hasFrame)
	{
		return new Processing(engine, hasFrame);
	}
	
	/**
	 * Moves the processing window to the center of the display if the processing has a frame.
	 * @return the instance of the processing
	 */
	public Processing moveToCenter()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(frame == null)
				{
					x = (Display.getDefault().getBounds().width - width) / 2;
					y = (Display.getDefault().getBounds().height - height - 30) / 2;
				}
				else
				{
					Rectangle rect = frame.getBounds();
					x = (Display.getDefault().getBounds().width - rect.width) / 2;
					y = (Display.getDefault().getBounds().height - rect.height) / 2;
					frame.setBounds(x, y, rect.width, rect.height);
				}
			}
		});
		return this;
	}
	
	/**
	 * Sets the processing window's location to the point specified by the arguments if the processing has a frame.
	 * @param x the new x coordinate of the window
	 * @param y the new y coordinate of the window
	 * @return the instance of the processing
	 */
	public Processing setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		if(frame != null)
		{
			Rectangle rect = frame.getBounds();
			frame.setBounds(x, y, rect.width, rect.height);
		}
		return this;
	}
	
	/**
	 * Sets the processing window's title to the argument, which must not be null.
	 * This method should be called before calling the method {@link #open()}.
	 * @param title the new title
	 * @return the instance of the processing
	 */
	public Processing setTitle(String title)
	{
		if(title != null) this.title = title;
		return this;
	}
	
	/**
	 * Sets the processing's mode to the argument, which must not be null.
	 * This method should be called before calling the method {@link #open()}.
	 * @param mode the new mode
	 * @return the instance of the processing
	 */
	public Processing setMode(String mode)
	{
		if(mode != null) this.mode = mode;
		return this;
	}
	
	/**
	 * Sets the processing's draw function to the argument, which must not be null.
	 * This method should be called before calling the method {@link #open()}.
	 * @param func the draw function's name
	 * @return the instance of the processing
	 */
	public Processing setDraw(String func)
	{
		if(func != null) this.func = func;
		return this;
	}
	
	/**
	 * Sets the processing's size to the arguments.
	 * Attempting to set the width or height of the window to a negative number will cause that value to be set to zero instead.
	 * This method should be called before calling the method {@link #open()}.
	 * @param width the new width of the window
	 * @param height the new height of the window
	 * @return the instance of the processing
	 */
	public Processing setSize(int width, int height)
	{
		if(width < 0) width = 0;
		if(height < 0) height = 0;
		this.width = width;
		this.height = height;
		return this;
	}
	
	/**
	 * Marks the processing window visible and sets the focus.
	 * @return the instance of the processing
	 */
	public Processing open()
	{
		if(hasFrame)
		{
			frame = new PFrame(title, mode, x, y, width, height, func, scriptEngine);
			sketch = frame.getSketch();
		}
		return this;
	}
	
	/**
	 * Returns the processing window's frame if it has a frame and {@code null} otherwise.
	 * @return the instance of the processing window's frame
	 */
	public PFrame getFrame()
	{
		return frame;
	}
	
	/**
	 * Returns the instance of the processing's PApplet
	 * @return the instance of the processing's PApplet
	 */
	public Sketch getSketch()
	{
		if(sketch == null)
		{
			sketch = new Sketch(mode, width, height, func, scriptEngine);
			sketch.init();
			sketch.setup();
		}
		return sketch;
	}
	
	/**
	 * Closes the processing
	 */
	public void close()
	{
		if(sketch != null)
			sketch.destroy();
		if(frame != null)
			frame.dispose();
		sketch = null;
		frame = null;
	}
}