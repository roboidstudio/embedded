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

package org.roboid.robot.util;

import java.io.File;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.roboid.core.ExtensionManager;
import org.roboid.core.resources.FileUtil;
import org.roboid.robot.Roboid;
import org.roboid.robot.RobotFactory;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public final class RoboidFactory
{
	private RoboidFactory()
	{
		throw new AssertionError();
	}
	
	/**
	 * Create a roboid corresponding to roboid's ID contained in a plugin with plugin's ID 
	 * @param pluginId plugin's ID
	 * @param roboidId roboid's ID
	 * @return roboid
	 */
	public static Roboid createRoboid(String pluginId, String roboidId)
	{
		// find model file
		String modelFileName = roboidId + ".roboid";
		modelFileName = FileUtil.toLocalFile(pluginId, modelFileName);
		
		// create a robot and obtain a root roboid
		File modelFile = new File(modelFileName);
		return RobotFactory.eINSTANCE.createRobot(modelFile).getRoboids().get(0);
	}
	
	/**
	 * Create a roboid for a model file described in a roboid component with component's ID
	 * @param componentId component's ID
	 * @return roboid
	 */
	public static Roboid createRoboid(String componentId)
	{
		// find extension
		IExtension extension = ExtensionManager.getRoboidExtension(componentId);
		if(extension == null) return null;
		
		// find plugin contains the extension
		String pluginId = extension.getContributor().getName();
		
		// find model file
		IConfigurationElement config = extension.getConfigurationElements()[0];
		String modelFileName = config.getAttribute("model");
		modelFileName = FileUtil.toLocalFile(pluginId, modelFileName);
		
		// create a robot and obtain a root roboid
		File modelFile = new File(modelFileName);
		return RobotFactory.eINSTANCE.createRobot(modelFile).getRoboids().get(0);
	}
}
