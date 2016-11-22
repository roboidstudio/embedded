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

package org.roboid.core.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Not used for the current version
 * 
 * @author Kyoung Jin Kim
 */
public abstract class PhysicalRobot extends AbstractService
{
	private Process process;
	
	@Override
	public boolean startService()
	{
		Runtime r = Runtime.getRuntime();
		try
		{
			// 번들의 경로를 구한다.
		    URL installLocation = getInstallLocation();
		    URL local = null;
		    try
		    {
		    	local = FileLocator.toFileURL(installLocation);
		    } catch (IOException e)
		    {
		    	e.printStackTrace();
		    	return false;
		    }
		    String resourceRoot = new File(local.getPath()).getAbsolutePath();
		    
			//운영체제 판별
			String osPropertyName = System.getProperty("os.name");
			if(osPropertyName.toLowerCase().indexOf("vista") != -1)
			{
				resourceRoot = resourceRoot + "/driver/vista/robot.exe";
			}
			else if(osPropertyName.toLowerCase().indexOf("xp") != -1)
			{
				resourceRoot = resourceRoot + "/driver/xp/robot.exe";
			}
			else 
			{
				System.out.println("Unsupported OS");
				return false;
			}
			System.out.println(resourceRoot);
		    process = r.exec(resourceRoot);
		    System.out.println(r.totalMemory());
		    System.out.println(r.freeMemory());
		}catch(Exception e)
		{
			System.out.println("Error executing robot driver");
			return false;
		}
		return true;
	}

	@Override
	public void stopService()
	{
		if(process != null) process.destroy();
	}

	abstract protected URL getInstallLocation();
	
	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException
	{}

	@Override
	public boolean requestToStart()
	{
		return false;
	}
	
	@Override
	public boolean requestToStop()
	{
		return false;
	}
}
