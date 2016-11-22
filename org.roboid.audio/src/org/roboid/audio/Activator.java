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

package org.roboid.audio;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.osgi.framework.internal.core.AbstractBundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Tae-hoon Kim
 */
@SuppressWarnings("restriction")
public class Activator extends Plugin
{
	// The shared instance
	private static Activator plugin;

	// The plug-in ID
	public static final String PLUGIN_ID = "org.roboid.audio";

	/**
	 * register path to Java library path
	 */
	public static void addLibraryPath(String path)
	{
		// Reset the "sys_paths" field of the ClassLoader to null.
		try
		{
			Class<ClassLoader> clazz = ClassLoader.class;
			Field field = clazz.getDeclaredField("sys_paths");
			boolean accessible = field.isAccessible();

			if (!accessible)
			{
				field.setAccessible(true);
			}

			// Object originalField = field.get(clazz);

			// Reset it to null so that whenever "System.loadLibrary" is called,
			// it will be reconstructed with the changed value.
			field.set(	clazz,
						null);

			/** ************************* */
			final String propertyName = "java.library.path";
			String libpath = System.getProperty(propertyName,
												"");
			String ps = File.pathSeparator;
			StringTokenizer tok = new StringTokenizer(libpath, ps);
			ArrayList<String> libPathList = new ArrayList<String>();

			// get library path as a list
			while (tok.hasMoreTokens())
			{
				String nextToken = tok.nextToken();
				libPathList.add(nextToken);

				// if already registered
				if (nextToken.equals(path)) { return; }
			}

			// add if not exist
			libPathList.add(path);

			// convert a path list to string
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < libPathList.size(); i++)
			{
				stringBuffer.append(libPathList.get(i));
				if (libPathList.size() > i)
				{
					stringBuffer.append(ps);
				}
			}

			try
			{
				// set a path
				System.setProperty(	propertyName,
									stringBuffer.toString());

				/** ***************************** */
			}
			finally
			{
				// field.set(clazz, originalField);
				field.setAccessible(accessible);
			}
		}
		catch (SecurityException e1)
		{
			e1.printStackTrace();
		}
		catch (NoSuchFieldException e1)
		{
			e1.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * convert a library file name (ex. dll) to its absolute path
	 */
	public static String findLibraryPath(String fileName)
	{
		String path = "";

		if (Activator.getDefault() != null)
		{
			// for eclipse plug-in
			path = ((AbstractBundle) Activator.getDefault().getBundle()).getBundleData()
					.findLibrary(fileName);

		}
		else
		{
			// for general Java
			URL url = Activator.class.getClassLoader().getResource(fileName);
			path = url.getPath();
		}
		try
		{
			path = URLDecoder.decode(	path,
										"UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault()
	{
		return plugin;
	}

	/**
	 * The constructor
	 */
	public Activator()
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception
	{
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception
	{
		plugin = null;
		super.stop(context);
	}
}
