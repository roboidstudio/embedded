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

package org.roboid.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public final class ExtensionManager
{
	private static List<IExtension> roboidExtensions;
	private static List<IExtension> addonExtensions;
	private static List<IExtension> systemExtensions;
	private static List<String> roboidIds = new ArrayList<String>();

	static {
		collectRoboidExtensions();
		collectAddonExtensions();
		collectSystemExtensions();
		collectRoboidIds();
	}
	
	private ExtensionManager()
	{
		throw new AssertionError();
	}
	
	private static void collectRoboidExtensions()
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint ep = registry.getExtensionPoint("org.roboid.component");
		roboidExtensions = Arrays.asList(ep.getExtensions());
	}
	
	private static void collectAddonExtensions()
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint ep = registry.getExtensionPoint("org.roboid.addon");
		addonExtensions = Arrays.asList(ep.getExtensions());
	}
	
	private static void collectSystemExtensions()
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint ep = registry.getExtensionPoint("org.roboid.system");
		systemExtensions = Arrays.asList(ep.getExtensions());
	}
	
	private static void collectRoboidIds()
	{
		for(IExtension extension : roboidExtensions)
		{
			IConfigurationElement config = extension.getConfigurationElements()[0];
			String id = toRoboidId(config.getAttribute("model"));
			if(!roboidIds.contains(id))
				roboidIds.add(id);
		}
	}
	
	/**
	 * Converter model file name to ID by removing ".roboid"
	 * @param roboidModelFileName
	 * @return String without ".roboid"
	 */
	public static String toRoboidId(String roboidModelFileName)
	{
		if(roboidModelFileName == null) return "";
		if(roboidModelFileName.endsWith("roboid"))
			return roboidModelFileName.substring(0, roboidModelFileName.length() - 7);
		else if(roboidModelFileName.endsWith("robot"))
			return roboidModelFileName.substring(0, roboidModelFileName.length() - 6);
		return "";
	}
	
	/**
	 * Converter extension to ID
	 * @param extension
	 * @return ID
	 */
	public static String toRoboidId(IExtension extension)
	{
		IConfigurationElement config = extension.getConfigurationElements()[0];
		return(toRoboidId(config.getAttribute("model")));
	}
	
	/**
	 * Get all roboid extensions installed as bundle
	 * @return roboid extensions
	 */
	public static List<IExtension> getRoboidExtensions()
	{
		return roboidExtensions;
	}
	
	/**
	 * Get all addon extensions installed as bundle
	 * @return addon extensions
	 */
	public static List<IExtension> getAddonExtensions()
	{
		return addonExtensions;
	}
	
	/**
	 * Get all system extensions installed as bundle
	 * @return system extensions
	 */
	public static List<IExtension> getSystemExtensions()
	{
		return systemExtensions;
	}
	
	/**
	 * Get IDs of all root roboids
	 * @return roboid IDs
	 */
	public static List<String> getRoboidIds()
	{
		return roboidIds;
	}
	
	/**
	 * Get roboid extensions corresponding to roboid's ID.
	 * @param roboidId roboid's ID
	 * @return roboid extensions
	 */
	public static List<IExtension> getRoboidExtensions(String roboidId)
	{
		List<IExtension> roboidExtensionList = new ArrayList<IExtension>();
		if(roboidId == null || roboidExtensions == null) return roboidExtensionList;

		String modelFileName = roboidId + ".roboid";
		for(IExtension extension : roboidExtensions)
		{
			IConfigurationElement config = extension.getConfigurationElements()[0];
			if(modelFileName.equals(config.getAttribute("model")))
				roboidExtensionList.add(extension);
			else
			{
				for(IConfigurationElement child : config.getChildren("model"))
				{
					for(String id : child.getAttribute("id").split("\\s*[\\s;]+\\s*"))
					{
						if(roboidId.equals(id.trim()))
							roboidExtensionList.add(extension);
					}
				}
			}
		}
		return roboidExtensionList;
	}
	
	/**
	 * Get addon extensions corresponding to host roboid's ID.
	 * @param hostId host roboid's ID
	 * @return addon extensions
	 */
	public static List<IExtension> getAddonExtensions(String hostId)
	{
		List<IExtension> addonExtensionList = new ArrayList<IExtension>();
		if(hostId == null || addonExtensions == null) return addonExtensionList;
		
		for(IExtension extension : addonExtensions)
		{
			IConfigurationElement config = extension.getConfigurationElements()[0];
			if(hostId.equals(config.getAttribute("host")))
				addonExtensionList.add(extension);
		}
		return addonExtensionList;
	}
	
	/**
	 * Get roboid extension corresponding to component's ID
	 * @param componentId component's ID (extension's ID)
	 * @return roboid extension
	 */
	public static IExtension getRoboidExtension(String componentId)
	{
		if(componentId == null) return null;
		
		for(IExtension extension : getRoboidExtensions())
		{
			IConfigurationElement config = extension.getConfigurationElements()[0];
			if(componentId.equals(config.getAttribute("id"))) return extension;
		}
		return null;
	}
	
	/**
	 * Get ID of extension
	 * @param extension
	 * @return extension's ID (component's ID)
	 */
	public static String getId(IExtension extension)
	{
		if(extension == null) return null;
		
		IConfigurationElement config = extension.getConfigurationElements()[0];
		String id = config.getAttribute("id");
		return id == null ? "" : id;
	}
}
