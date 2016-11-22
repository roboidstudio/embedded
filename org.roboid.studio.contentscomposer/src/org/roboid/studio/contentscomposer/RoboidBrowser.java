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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class RoboidBrowser
{
	private Shell shell;
	private Browser browser;
	private boolean isNewLocation;
	private volatile List<String> pages = new ArrayList<String>();

	private RoboidBrowser(final Shell parent, final int style)
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
	 * Constructs a new instance of the browser window given its parent shell and style.
	 * @param parent the parent shell
	 * @param style the value describing the browser window's behavior and appearance
	 * @return a new instance of the browser window
	 */
	static RoboidBrowser create(final Shell parent, final int style)
	{
		return new RoboidBrowser(parent, style);
	}
	
	/**
	 * Sets the browser window's size to the point specified by the arguments.
	 * Attempting to set the width or height of the window to a negative number will cause that value to be set to zero instead.
	 * @param width the new width of the window
	 * @param height the new height of the window
	 * @return the instance of the browser window
	 * @see Shell#setSize(int, int)
	 */
	public RoboidBrowser setSize(final int width, final int height)
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
	 * Moves the browser window to the center of the display.
	 * @return the instance of the browser window
	 */
	public RoboidBrowser moveToCenter()
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
	 * Sets the browser window's location to the point specified by the arguments which are relative to its display.
	 * @param x the new x coordinate of the window
	 * @param y the new y coordinate of the window
	 * @return the instance of the browser window
	 * @see Shell#setLocation(int, int)
	 */
	public RoboidBrowser setLocation(final int x, final int y)
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
	 * @return the instance of the browser window
	 */
	@Deprecated
	public RoboidBrowser setPosition(final int x, final int y)
	{
		return setLocation(x, y);
	}
	
	/**
	 * Sets the minimized state of the browser window.
	 * If the argument is {@code true} causes the window to switch to the minimized state,
	 * and if the argument is {@code false} and the window was previously minimized, causes the window to switch back to either the maximized or normal states.
	 * @param minimized the new minimized state
	 * @return the instance of the browser window
	 * @see Shell#setMinimized(boolean)
	 */
	public RoboidBrowser setMinimized(final boolean minimized)
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
	 * @return the instance of the browser window
	 */
	public RoboidBrowser setMinimize(final boolean minimized)
	{
		return setMinimized(minimized);
	}
	
	/**
	 * Sets the maximized state of the browser window.
	 * If the argument is {@code true} causes the window to switch to the maximized state,
	 * and if the argument is {@code false} and the window was previously maximized, causes the window to switch back to either the minimized or normal states.
	 * @param maximized the new maximized state
	 * @return the instance of the browser window
	 * @see Shell#setMaximized(boolean)
	 */
	public RoboidBrowser setMaximized(final boolean maximized)
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
	 * @return the instance of the browser window
	 */
	public RoboidBrowser setMaximize(final boolean maximized)
	{
		return setMaximized(maximized);
	}
	
	/**
	 * Sets the full screen state of the browser window.
	 * If the argument is {@code true} causes the window to switch to the full screen state,
	 * and if the argument {@code false} and the window was previously switched into full screen state, causes the window to switch back to either the maximized or normal states.
	 * @param fullScreen the new full screen state
	 * @return the instance of the browser window
	 * @see Shell#setFullScreen(boolean)
	 */
	public RoboidBrowser setFullScreen(final boolean fullScreen)
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
	 * Sets the browser window's title to the argument, which must not be null.
	 * @param title the new title
	 * @return the instance of the browser window
	 * @see Shell#setText(String)
	 */
	public RoboidBrowser setTitle(final String title)
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
	 * Moves the browser window to the top of the drawing order for the display on which it was created (so that all other shells on that display, which are not the browser window's children will be drawn behind it), marks it visible, sets the focus and asks the window manager to make the shell active.
	 * @return the instance of the browser window
	 * @see Shell#open()
	 */
	public RoboidBrowser open()
	{	
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell == null || shell.isDisposed()) return;
				try
				{
					browser = new Browser(shell, SWT.NONE);
					browser.setData(RoboidBrowser.this);
					browser.addLocationListener(new LocationAdapter()
					{
						@Override
						public void changed(LocationEvent event)
						{
							isNewLocation = true;
							pages.add(event.location); // add the URL to the history.
//							System.out.println(pages.size() + ": " + page);
							event.data = RoboidBrowser.this;
						}
					});
				} catch(SWTError e)
				{
					MessageBox mbox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					mbox.setText("Error!!!");
					mbox.setMessage("[Browser] e : " + e.getMessage());
					mbox.open();
				}
				shell.open();
			}			
		});
		return this;
	}
	
	/**
	 * Requests that the window manager close the browser window in the same way it would be closed when the user clicks on the "close box" or performs some other platform specific key or mouse combination that indicates the window should be removed.
	 * @see Shell#close()
	 */
	public void close()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(browser != null && !browser.isDisposed()) browser.dispose();
				if(shell != null && !shell.isDisposed()) shell.close();
			}
		});
	}
	
	/**
	 * Returns {@code true} if the browser window has been disposed, and {@code false} otherwise.
	 * @return {@code true} when the browser window is disposed and {@code false} otherwise
	 */
	public boolean isDisposed()
	{
		if(shell == null) return true;
		return shell.isDisposed(); //disposed;
	}
	
	/**
	 * methods for getUrl and setUrl
	 * @param url
	 * returns TRUE when success
	 */
	private static boolean doneUrl = false;
	private static boolean doneText = false;
	private static boolean doneScript = false;
	private Object doneEvaluate = null;
	private boolean doneForward;
	private boolean doneBackward;
	private static String Url = "";
	
	/**
	 * Sets the URL of the browser window.
	 * @param url the new URL
	 * @return {@code true} when the browser window sets its URL successfully and {@code false} otherwise
	 */
	public boolean setUrl(final String url)
	{
		if(url == null) return false;
		if(browser == null) return false;
		if(browser.isDisposed()) return false ;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				doneUrl = browser.setUrl(url);
			}
		});
		return doneUrl;
	}
	
	/**
	 * Returns the current URL of the browser window.
	 * @return the current URL
	 */
	public String getUrl()
	{
		if(browser == null) return "";
		if(browser.isDisposed()) return "";

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				Url = browser.getUrl();
			}
		});
		return Url;
	}
	
	/**
	 * Renders the HTML text to the browser window.
	 * @param html the HTML text
	 * @return {@code true} when the browser window renders the HTML text successfully and {@code false} otherwise
	 */
	public boolean setText(final String html)
	{
		if(html == null) return false;
		if(browser == null) return false;
		if(browser.isDisposed()) return false;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				doneText = browser.setText(html);
			}
		});
		return doneText;
	}
	
	/**
	 * Executes the script code in the browser window.
	 * @param script the script code
	 * @return {@code true} when the browser executes the script code successfully and {@code false} otherwise
	 */
	public boolean execute(final String script)
	{
		if(script == null) return false;
		if(browser == null) return false;
		if(browser.isDisposed()) return false;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				doneScript = browser.execute(script);		
			}
		});
		return doneScript;
	}
	
	/**
	 * Evaluates the script code in the browser window.
	 * @param script the script code
	 * @return the return value, if any, of executing the script
	 */
	public Object evaluate(final String script)
	{
		if(script == null) return null;
		if(browser == null) return null;
		if(browser.isDisposed()) return null;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				doneEvaluate = browser.evaluate(script);
			}
		});
		return doneEvaluate;
	}
	
	public boolean forward()
	{
		if(browser == null) return false;
		if(browser.isDisposed()) return false;
		
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				doneForward = browser.forward();
			}
		});
		return doneForward;
	}
	
	public boolean back()
	{
		if(browser == null) return false;
		if(browser.isDisposed()) return false;
		
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				doneBackward = browser.back();
			}
		});
		return doneBackward;
	}
	
	/**
	 * Returns {@code true} if a new URL is open, and {@code false} otherwise.
	 */
	public boolean e()
	{
		return isNewLocation;
	}
	
	/**
	 * Clears the URL history, and the flag, which indicates a new URL has been open, to {@code false}.
	 */
	public void clearPages()
	{
		pages.clear();
		isNewLocation = false;
	}
	
	/**
	 * Returns {@code true} if the given URL page has been open and {@code false} otherwise.
	 * @param page the URL
	 */
	public boolean findPage(String url)
	{
		return pages.contains(url);
	}
	
	public void addLocationListener(final LocationListener listener)
	{
		if(listener == null) return;
		if(browser == null) return;
		if(browser.isDisposed()) return;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				browser.addLocationListener(listener);
			}
		});
	}
	
	public void removeLocationListener(final LocationListener listener)
	{
		if(listener == null) return;
		if(browser == null) return;
		if(browser.isDisposed()) return;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				browser.removeLocationListener(listener);
			}
		});
	}
	
	public void addTitleListener(final TitleListener listener)
	{
		if(listener == null) return;
		if(browser == null) return;
		if(browser.isDisposed()) return;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				browser.addTitleListener(listener);
			}
		});
	}
	
	public void removeTitleListener(final TitleListener listener)
	{
		if(listener == null) return;
		if(browser == null) return;
		if(browser.isDisposed()) return;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				browser.removeTitleListener(listener);
			}
		});
	}
	
	public void addStatusTextListener(final StatusTextListener listener)
	{
		if(listener == null) return;
		if(browser == null) return;
		if(browser.isDisposed()) return;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				browser.addStatusTextListener(listener);
			}
		});
	}
	
	public void removeStatusTextListener(final StatusTextListener listener)
	{
		if(listener == null) return;
		if(browser == null) return;
		if(browser.isDisposed()) return;

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				browser.removeStatusTextListener(listener);
			}
		});
	}
}
