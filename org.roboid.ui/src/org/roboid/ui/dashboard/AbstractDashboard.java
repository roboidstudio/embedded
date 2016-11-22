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

package org.roboid.ui.dashboard;

import java.io.IOException;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.roboid.ui.Activator;

/**
 * @author Kwang-Hyun Park
 */
public abstract class AbstractDashboard extends Thread
{
	private Display display;
	private Shell shell;
	private Image icon;
	private String title = "";
	private int x, y;
	private int style;
	private Plugin plugin;
	private ScopedPreferenceStore preferenceStore;
	
	AbstractDashboard()
	{
	}
	
	public AbstractDashboard(String title)
	{
		this(title, -1, -1, SWT.DIALOG_TRIM|SWT.ON_TOP, null);
	}
	
	public AbstractDashboard(String title, Plugin plugin)
	{
		this(title, -1, -1, SWT.DIALOG_TRIM|SWT.ON_TOP, plugin);
	}
	
	public AbstractDashboard(String title, int x, int y)
	{
		this(title, x, y, SWT.DIALOG_TRIM|SWT.ON_TOP, null);
	}
	
	public AbstractDashboard(String title, int x, int y, Plugin plugin)
	{
		this(title, x, y, SWT.DIALOG_TRIM|SWT.ON_TOP, plugin);
	}
	
	public AbstractDashboard(String title, int style)
	{
		this(title, -1, -1, style, null);
	}
	
	public AbstractDashboard(String title, int style, Plugin plugin)
	{
		this(title, -1, -1, style, plugin);
	}
	
	public AbstractDashboard(String title, int x, int y, int style)
	{
		this(title, x, y, style, null);
	}
	
	public AbstractDashboard(String title, int x, int y, int style, Plugin plugin)
	{
		this.title = title;
		this.x = x;
		this.y = y;
		this.style = style;
		this.plugin = plugin;
		
		if(plugin == null)
			this.plugin = Activator.getDefault();
		if(x < 0 && y < 0)
		{
			this.x = getPreferenceInt(title + ".x");
			this.y = getPreferenceInt(title + ".y");
		}
	}

	public Shell getShell()
	{
		if(shell == null || shell.isDisposed()) return null;
		return shell;
	}
	
	public Display getDisplay()
	{
		if(display == null || display.isDisposed()) return null;
		return display;
	}
	
	private ScopedPreferenceStore getPreferenceStore()
	{
		if(preferenceStore == null)
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), plugin.getBundle().getSymbolicName());
		return preferenceStore;
    }
	
	public boolean getPreferenceDefalutBoolean(String key)
	{
		return getPreferenceStore().getDefaultBoolean(key);
	}
	
	public int getPreferenceDefalutInt(String key)
	{
		return getPreferenceStore().getDefaultInt(key);
	}
	
	public long getPreferenceDefalutLong(String key)
	{
		return getPreferenceStore().getDefaultLong(key);
	}
	
	public float getPreferenceDefalutFloat(String key)
	{
		return getPreferenceStore().getDefaultFloat(key);
	}
	
	public double getPreferenceDefalutDouble(String key)
	{
		return getPreferenceStore().getDefaultDouble(key);
	}
	
	public String getPreferenceDefalutString(String key)
	{
		return getPreferenceStore().getDefaultString(key);
	}
	
	public boolean getPreferenceBoolean(String key)
	{
		return getPreferenceStore().getBoolean(key);
	}
	
	public int getPreferenceInt(String key)
	{
		return getPreferenceStore().getInt(key);
	}
	
	public long getPreferenceLong(String key)
	{
		return getPreferenceStore().getLong(key);
	}
	
	public float getPreferenceFloat(String key)
	{
		return getPreferenceStore().getFloat(key);
	}
	
	public double getPreferenceDouble(String key)
	{
		return getPreferenceStore().getDouble(key);
	}
	
	public String getPreferenceString(String key)
	{
		return getPreferenceStore().getString(key);
	}
	
	public void setPreferenceDefault(String key, boolean value)
	{
		getPreferenceStore().setDefault(key, value);
	}
	
	public void setPreferenceDefault(String key, int value)
	{
		getPreferenceStore().setDefault(key, value);
	}
	
	public void setPreferenceDefault(String key, long value)
	{
		getPreferenceStore().setDefault(key, value);
	}
	
	public void setPreferenceDefault(String key, float value)
	{
		getPreferenceStore().setDefault(key, value);
	}
	
	public void setPreferenceDefault(String key, double value)
	{
		getPreferenceStore().setDefault(key, value);
	}
	
	public void setPreferenceDefault(String key, String value)
	{
		getPreferenceStore().setDefault(key, value);
	}
	
	public void setPreferenceValue(String key, boolean value)
	{
		getPreferenceStore().setValue(key, value);
	}
	
	public void setPreferenceValue(String key, int value)
	{
		getPreferenceStore().setValue(key, value);
	}
	
	public void setPreferenceValue(String key, long value)
	{
		getPreferenceStore().setValue(key, value);
	}
	
	public void setPreferenceValue(String key, float value)
	{
		getPreferenceStore().setValue(key, value);
	}
	
	public void setPreferenceValue(String key, double value)
	{
		getPreferenceStore().setValue(key, value);
	}
	
	public void setPreferenceValue(String key, String value)
	{
		getPreferenceStore().setValue(key, value);
	}
	
	public boolean savePreference()
	{
		try
		{
			getPreferenceStore().save();
		} catch (IOException e)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public void run()
	{
		display = new Display();
		shell = new Shell(display, style);
		shell.setText(title);
		shell.setLocation(x, y);
		icon = ImageDescriptor.createFromFile(AbstractDashboard.class, "diag_logo.png").createImage();
		shell.setImage(icon);
		createContents(shell);
		shell.addDisposeListener(new DisposeListener()
		{
			@Override
			public void widgetDisposed(DisposeEvent e)
			{
				x = shell.getBounds().x;
				y = shell.getBounds().y;
				
				setPreferenceValue(title + ".x", x);
				setPreferenceValue(title + ".y", y);
				savePreference();
			}
		});
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) display.sleep();
		}
		if(!display.isDisposed()) display.dispose();
	}
	
	public void dispose()
	{
		if(display == null || display.isDisposed()) return;
		display.asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(shell.isDisposed()) return;
				shell.dispose();
				if(icon != null) icon.dispose();
			}
		});
	}
	
	public boolean isDisposed()
	{
		if(display == null || display.isDisposed()) return true;
		if(shell == null || shell.isDisposed()) return true;
		return false;
	}
	
	abstract protected void createContents(Shell shell);
}
