/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kyoung Jin Kim, Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.runtime;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.roboid.core.ExtensionManager;
import org.roboid.core.resources.FileUtil;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;

/**
 * @author Kyoung Jin Kim, Kwang-Hyun Park
 */
public final class RobotManager
{
	private static List<String> categories = new ArrayList<String>();
	private static Robot defaultRobot;
	private static Robot currentRobot;
	
	static
	{
		categories.add("physical");
		categories.add("virtual");
		categories.add("peripheral");
		categories.add("audio");
		categories.add("voice");
		categories.add("vision");
		categories.add("service");
		categories.add("instrument");
		categories.add("utility");
		categories.add("etc");
		createModelFolder();
	}
	
	private RobotManager()
	{
		throw new AssertionError();
	}
	
	public static void init()
	{
	}
	
	public static Robot getDefaultRobot()
	{
		if(defaultRobot == null)
		{
			String path = FileUtil.toLocalFile(Activator.PLUGIN_ID, "blank.robot");
			URI uri = URI.createFileURI(path);
			defaultRobot = RobotFactory.eINSTANCE.createRobot(uri);
		}
		return defaultRobot;
	}
	
	public static Robot getProjectRobot(File file)
	{
		if(file == null) return null;
		
		IPath path = new Path(file.getAbsolutePath());
		IFile f = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
		if(f == null) return null;
		IProject project = f.getProject();
		if(project == null) return null;
		
		File[] modelFiles = null;
		IPath projectPath = project.getLocation();
		if(projectPath != null)
		{
			File folder = projectPath.toFile();
			modelFiles = folder.listFiles(new FilenameFilter()
			{
				@Override
				public boolean accept(File dir, String name)
				{
					return name.toLowerCase().endsWith(".robot");
				}
			});
		}
		if(modelFiles != null && modelFiles.length > 0)
			return RobotFactory.eINSTANCE.createRobot(modelFiles[0]);
		return null;
	}
	
	public synchronized static Robot getCurrentRobot()
	{
		return currentRobot;
	}
	
	synchronized static void setCurrentRobot(Robot newRobot)
	{
		currentRobot = newRobot;
	}
	
	public static void setDeviceListener(Robot robot, DeviceListener listener)
	{
		if(robot == null || listener == null) return;
		
		for(Roboid roboid : robot.getRoboids())
			setDeviceListener(roboid, listener);
	}
	
	private static void setDeviceListener(Roboid roboid, DeviceListener listener)
	{
		if(roboid == null || listener == null) return;
		
		for(Device device : roboid.getDevices())
			device.addDeviceListener(listener);
		for(Roboid child : roboid.getRoboids())
			setDeviceListener(child, listener);
	}
	
	private static void createModelFolder()
	{
		try
		{
			IProject modelProject = ResourcesPlugin.getWorkspace().getRoot().getProject("model");
			if(!modelProject.exists()) modelProject.create(null);
			modelProject.open(null);
			
			try
			{
				IFolder roboidsFolder = modelProject.getFolder("roboids");
				if(roboidsFolder.exists()) roboidsFolder.delete(true, null);
				roboidsFolder.create(true, true, null);
				
				for(String category : categories)
				{
					IFolder categoryFolder = roboidsFolder.getFolder(category);
					if(categoryFolder.exists()) categoryFolder.delete(true, null);
					categoryFolder.create(true, true, null);
				}
				
				//Copy roboid models from bundle to workspace
				List<IFile> hostRoboidFiles = copyModelsToWorkspace(roboidsFolder);
				
				//Merge model of addons onto host roboid-not implemented
				mergeAddonsToHostModel(roboidsFolder, hostRoboidFiles);
			} catch (CoreException e)
			{
				e.printStackTrace();
			}
			
			//Prepare robots folder if new workspace is created.
			try
			{
				IFolder robotsFolder = modelProject.getFolder("robots");
				if(!robotsFolder.exists())
					robotsFolder.create(true, true, null);
			} catch (CoreException e)
			{
				e.printStackTrace();
			}
		} catch (CoreException e)
		{
			e.printStackTrace();
		}
	}
	
	private static List<IFile> copyModelsToWorkspace(IFolder roboidsFolder)
	{
		List<IFile> hostRoboidFiles = new ArrayList<IFile>();
		for(IExtension extension : ExtensionManager.getRoboidExtensions())
		{
			IConfigurationElement config = extension.getConfigurationElements()[0];
			String modelFileName = config.getAttribute("model");
			String bundleName = config.getContributor().getName();
			int start = modelFileName.indexOf('.') + 1;
			start = modelFileName.indexOf('.', start) + 1;
			int end = modelFileName.indexOf('.', start);
			String category = modelFileName.substring(start, end);
			if(category.equalsIgnoreCase("util"))
				category = "utility";
			if(!categories.contains(category))
				category = "etc";
			
			IFile roboidFile = roboidsFolder.getFile(category + "/" + modelFileName);
			URL url = Platform.getBundle(bundleName).getResource(modelFileName);
			try
			{
				if(!roboidFile.exists())
				{
					roboidFile.create(FileLocator.resolve(url).openStream(), true, null);
					hostRoboidFiles.add(roboidFile);
				}
			} catch (CoreException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return hostRoboidFiles;
	}
	
	public static List<String> getCategories()
	{
		return categories;
	}
	
	public static String getCategory(IExtension extension)
	{
		IConfigurationElement config = extension.getConfigurationElements()[0];
		String modelFileName = config.getAttribute("model");
		if(modelFileName == null)
			return "";
		int start = modelFileName.indexOf('.') + 1;
		start = modelFileName.indexOf('.', start) + 1;
		int end = modelFileName.indexOf('.', start);
		String category = modelFileName.substring(start, end);
		if(category.equalsIgnoreCase("util"))
			category = "utility";
		if(!categories.contains(category))
			category = "etc";
		return category;
	}
	
	public static String getModelFileName(IExtension extension)
	{
		IProject modelProject = ResourcesPlugin.getWorkspace().getRoot().getProject("model");
		IFolder roboidsFolder = modelProject.getFolder("roboids");
		
		IConfigurationElement config = extension.getConfigurationElements()[0];
		String modelFileName = config.getAttribute("model");
		String category = getCategory(extension);
		if(modelFileName == null || category.isEmpty()) return "";
		
		IFile roboidFile = roboidsFolder.getFile(category + "/" + modelFileName);
		return roboidFile.getLocation().toFile().getAbsolutePath();
	}

	private static void mergeAddonsToHostModel(IFolder roboidsFolder, List<IFile> hostRoboidFiles)
	{
		for(IFile file : hostRoboidFiles)
		{
			try
			{
				File hostFile = new File(file.getLocation().toOSString());
				String hostId = ExtensionManager.toRoboidId(hostFile.getName());
				
				List<IExtension> addonExtensionList = ExtensionManager.getAddonExtensions(hostId);
				if(!addonExtensionList.isEmpty())
				{
					//create host model to merge in
					ResourceSet resourceSet = new ResourceSetImpl();
					URI uri = URI.createFileURI(hostFile.getAbsolutePath());
					Resource hostResource = resourceSet.getResource(uri, true);
					
					Roboid hostRoboid = null;
					EObject o = hostResource.getContents().get(0);
					if(o instanceof Robot)
						hostRoboid = ((Robot)o).getRoboids().get(0);
					else
						hostRoboid = (Roboid)o;
					if(hostRoboid != null)
					{
						//create self model and merge
						for(IExtension extension : addonExtensionList)
						{
							IConfigurationElement config = extension.getConfigurationElements()[0];
							String modelFileName = config.getAttribute("model");
							if(modelFileName == null) continue;
							String bundleName = config.getContributor().getName();
							URL url = Platform.getBundle(bundleName).getResource(modelFileName);
							IFile addonModelFile = roboidsFolder.getFile(modelFileName);
							
							try
							{
								//TODO [박] create하지 않고 합치는 방법을 찾자.
								addonModelFile.create(FileLocator.resolve(url).openStream(), true, null);
								File selfModelFile = new File(addonModelFile.getLocation().toOSString());
								URI self = URI.createFileURI(selfModelFile.getAbsolutePath());
								Resource addonResource = resourceSet.getResource(self, true);
								Roboid addonRoboid = null;
								EObject o2 = addonResource.getContents().get(0);
								if(o2 instanceof Robot)
									addonRoboid = ((Robot)o2).getRoboids().get(0);
								else
									addonRoboid = (Roboid)o2;
		
								if(addonRoboid != null)
								{
									for(Device device : addonRoboid.getDevices())
										hostRoboid.getDevices().add(device);
								}
								
								addonModelFile.delete(true, null);
								hostResource.save(null);
							} catch (Exception e)
							{
								e.printStackTrace();
							}
						}
					}
				}
				hostFile.setReadOnly();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			roboidsFolder.refreshLocal(IResource.DEPTH_ONE, null);
		} catch (CoreException e)
		{
			e.printStackTrace();
		}
	}
}
