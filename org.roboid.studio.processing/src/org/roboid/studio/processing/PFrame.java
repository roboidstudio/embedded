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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("serial")
public class PFrame extends Frame
{
//	private ScriptEngine se;
	private String name;
	private Sketch sketch;
	
	public PFrame(String title, String mode, int x, int y, int width, int height, String func, ScriptEngine engine)
	{
		super(title + " | Processing");
//		this.se = se;
		this.name = title + "_processing";
		setLayout(new BorderLayout());
		sketch = new Sketch(mode, width, height, func, engine);
		add(sketch, BorderLayout.CENTER);		
		sketch.init();
		sketch.setSize(width, height);
		sketch.setPreferredSize(new Dimension(width, height));
		pack();
		setResizable(false);

		try
		{
			URL url = Platform.getBundle(Activator.PLUGIN_ID).getResource("icons/processing.png");
			try
			{
				url = FileLocator.toFileURL(url);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
				
			Image image = ImageIO.read(new File(url.getFile()));
			setIconImage(image);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//setLocation
		if(x == -1)
		{
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			int xx = store.getInt(name + ".x");
			int yy = store.getInt(name + ".y");
			setLocation(xx, yy);
		}
		else
			setLocation(x, y);
				
		setAlwaysOnTop(true);
		setVisible(true);

		//save last location
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent e)
			{
				int x = e.getWindow().getLocation().x;
				int y = e.getWindow().getLocation().y;
				IPersistentPreferenceStore store = (IPersistentPreferenceStore)Activator.getDefault().getPreferenceStore();
				store.setValue(name + ".x", x);
				store.setValue(name + ".y", y);
				try
				{
					store.save();
				} catch (IOException ex)
				{
				}
			}

			@Override
			public void windowClosing(WindowEvent e)
			{
				e.getWindow().dispose();
			}
		});
	}

	public Sketch getSketch()
	{
		return sketch;
	}
}
