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
import org.eclipse.swt.SWTError;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.sf.feeling.swt.win32.extension.ole.flash.Flash;
import org.sf.feeling.swt.win32.extension.ole.flash.listener.FlashEventAdapter;
import org.sf.feeling.swt.win32.extension.ole.flash.listener.FlashEventListener;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public final class FlashViewer
{
	private Shell shell;
	private Flash flash;
	private String fsCommand = "";
	private String fsValue = "";
	private volatile boolean isNewCommand;

	private FlashViewer(final Shell parent, final int style)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				shell = new Shell(parent, style);
				shell.setLayout(new FillLayout());
			}
		});
	}
	
	/**
	 * Constructs a new instance of the flash window given its parent shell and style.
	 * @param parent the parent shell
	 * @param style the value describing the flash window's behavior and appearance
	 * @return a new instance of the flash window
	 */
	static FlashViewer create(Shell parent, int style)
	{
		return new FlashViewer(parent, style);
	}

	/**
	 * Sets the flash window's size to the point specified by the arguments.
	 * Attempting to set the width or height of the window to a negative number will cause that value to be set to zero instead.
	 * @param width the new width of the window
	 * @param height the new height of the window
	 * @return the instance of the flash window
	 * @see Shell#setSize(int, int)
	 */
	public FlashViewer setSize(final int width, final int height)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				shell.setSize(width, height);
			}
		});
		return this;
	}
	
	/**
	 * Moves the flash window to the center of the display.
	 * @return the instance of the flash window
	 */
	public FlashViewer moveToCenter()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				int x = (Display.getDefault().getBounds().width - shell.getBounds().width) / 2;
				int y = (Display.getDefault().getBounds().height - shell.getBounds().height) / 2;
				shell.setLocation(x, y);
			}
		});
		return this;
	}
	
	/**
	 * Sets the flash window's location to the point specified by the arguments which are relative to its display.
	 * @param x the new x coordinate of the window
	 * @param y the new y coordinate of the window
	 * @return the instance of the flash window
	 * @see Shell#setLocation(int, int)
	 */
	public FlashViewer setLocation(final int x, final int y)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				shell.setLocation(x, y);
			}
		});
		return this;
	}
	
	/**
	 * @deprecated use {@link #setLocation(int, int)} instead
	 * @param x the new x coordinate of the window
	 * @param y the new y coordinate of the window
	 * @return the instance of the flash window
	 */
	public FlashViewer setPosition(int x, int y)
	{
		return setLocation(x, y);
	}
	
	/**
	 * Sets the minimized state of the flash window.
	 * If the argument is {@code true} causes the window to switch to the minimized state,
	 * and if the argument is {@code false} and the window was previously minimized, causes the window to switch back to either the maximized or normal states.
	 * @param minimized the new minimized state
	 * @return the instance of the flash window
	 * @see Shell#setMinimized(boolean)
	 */
	public FlashViewer setMinimized(final boolean minimized)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				shell.setMinimized(minimized);
			}
		});
		return this;
	}
	
	/**
	 * @deprecated use {@link #setMinimized(boolean)} instead
	 * @param minimized the new minimized state
	 * @return the instance of the flash window
	 */
	public FlashViewer setMinimize(boolean minimized)
	{
		return setMinimized(minimized);
	}
	
	/**
	 * Sets the maximized state of the flash window.
	 * If the argument is {@code true} causes the window to switch to the maximized state,
	 * and if the argument is {@code false} and the window was previously maximized, causes the window to switch back to either the minimized or normal states.
	 * @param maximized the new maximized state
	 * @return the instance of the flash window
	 * @see Shell#setMaximized(boolean)
	 */
	public FlashViewer setMaximized(final boolean maximized)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				shell.setMaximized(maximized);
			}
		});
		return this;
	}
	
	/**
	 * @deprecated use {@link #setMaximized(boolean)} instead
	 * @param maximized the new maximized state
	 * @return the instance of the flash window
	 */
	public FlashViewer setMaximize(boolean maximized)
	{
		return setMaximized(maximized);
	}
	
	/**
	 * Sets the full screen state of the flash window.
	 * If the argument is {@code true} causes the window to switch to the full screen state,
	 * and if the argument {@code false} and the window was previously switched into full screen state, causes the window to switch back to either the maximized or normal states.
	 * @param fullScreen the new full screen state
	 * @return the instance of the flash window
	 * @see Shell#setFullScreen(boolean)
	 */
	public FlashViewer setFullScreen(final boolean fullScreen)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				shell.setFullScreen(fullScreen);
			}
		});
		return this;
	}
	
	/**
	 * Sets the flash window's title to the argument, which must not be null.
	 * @param title the new title
	 * @return the instance of the flash window
	 * @see Shell#setText(String)
	 */
	public FlashViewer setTitle(final String title)
	{
		if(title == null) return this;
		
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				shell.setText(title);
			}
		});
		return this;
	}
	
	/**
	 * Moves the flash window to the top of the drawing order for the display on which it was created (so that all other shells on that display, which are not the flash window's children will be drawn behind it), marks it visible, sets the focus and asks the window manager to make the shell active.
	 * @return the instance of the flash window
	 * @see Shell#open()
	 */
	public FlashViewer open()
	{	
		// listener for receiving fsCommand
		final FlashEventListener listener = new FlashEventAdapter() 
		{
			public void onFSCommand(String command, String args) 
			{
				fsCommand = command;
				fsValue = args;
				isNewCommand = true;
//				System.out.println("FScommand: " + fs_command + ", " + fs_value);
			}
		};
	
		// open the flash window
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				try
				{
					flash = new Flash(shell, SWT.NONE, listener);
				}
				catch(SWTError e)
				{
					MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					mbox.setText("Error!!!");
					mbox.setMessage("[Flash] e : " + e.getMessage());
					mbox.open();
				}
				shell.open();
			}			
		});
		return this;
	}
	
	/**
	 * Requests that the window manager close the flash window in the same way it would be closed when the user clicks on the "close box" or performs some other platform specific key or mouse combination that indicates the window should be removed.
	 * @see Shell#close()
	 */
	public void close()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(flash != null && !flash.isDisposed()) flash.dispose();
				if(shell != null && !shell.isDisposed()) shell.close();
			}
		});
	}
	
	/**
	 * Returns {@code true} if the flash window has been disposed, and {@code false} otherwise.
	 * @return {@code true} when the flash window is disposed and {@code false} otherwise
	 */
	public boolean isDisposed()
	{
		if(shell == null) return true;
		return shell.isDisposed(); //disposed;
	}
	
	/**
	 * @deprecated use {@link #getFsCommand()} instead
	 * @return fsCommand of the flash
	 */
	public String getFSCommand()
	{
		return fsCommand;
	}
	
	/**
	 * Returns fsCommand of the flash
	 * @return fsCommand of the flash
	 */
	public String getFsCommand()
	{
		return fsCommand;
	}
	
	/**
	 * @deprecated use {@link #getFsValue()} instead
	 * @return fsValue of the flash
	 */
	public String getFSValue()
	{
		return fsValue;
	}
	
	/**
	 * Returns fsValue of the flash
	 * @return fsValue of the flash
	 */
	public String getFsValue()
	{
		return fsValue;
	}
	
	/**
	 * Returns the value of the variable specified by the arguments.
	 * @param variable the variable name
	 */
	public String getVariable(String variable)
	{
		if(variable == null) return "";
		if(flash == null || flash.isDisposed()) return "";
		
		return flash.getVariable(variable);
	}
	
	/**
	 * Sets the value of the variable to the value specified by the arguments.
	 * @param variable the variable name
	 * @param value the new value
	 */
	public void setVariable(String variable, String value)
	{
		if(variable == null || value == null) return;
		if(flash == null || flash.isDisposed()) return;
		
		flash.setVariable(variable, value);
	}
	
	/**
	 * Loads the flash movie for the url specified by the argument.
	 * @param url
	 */
	public void loadMovie(final String url)
	{
		if(url == null) return;
		if(flash == null || flash.isDisposed()) return;
		
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				flash.loadMovie(0, url);
			}
		});
	}
	
	/**
	 * Rewinds the flash movie.
	 * @see #loadMovie(String)
	 */
	public void rewind()
	{
		if(flash == null || flash.isDisposed()) return;
		flash.rewind();
	}
	
	/**
	 * Starts to play the flash movie.
	 */
	public void play()
	{
		if(flash == null || flash.isDisposed()) return;
		flash.play();
	}
	
	/**
	 * Stops playing the flash movie.
	 */
	public void stop()
	{
		if(flash == null || flash.isDisposed()) return;
		flash.stop();
	}
	
	/**
	 * flash event mechanism
	 */
	
	/**
	 * Returns {@code true} if a new fsCommand is received, and {@code false} otherwise.
	 */
	public boolean e()
	{
		return isNewCommand;
	}
	
	/**
	 * Clears the flag, which indicates a new fsCommand has been received, to {@code false}.
	 * @see #clearCommand()
	 */
	public void clear_e()
	{
		clearCommand();
	}
	
	/**
	 * Clears the flag, which indicates a new fsCommand has been received, to {@code false}.
	 */
	public void clearCommand()
	{
		isNewCommand = false;
	}
}
