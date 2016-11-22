/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kyoung Jin Kim, Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.roboid.core.resources.FileUtil;

/**
 * @author Kyoung Jin Kim, Kwang-Hyun Park
 */
public abstract class AbstractComponent implements IExecutableExtension, IComponent
{
	private IConfigurationElement config;
	private String id;
	private String name;
	private String provider;
	private String version;
	
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException
	{
		this.config = config;
		
		id = config.getAttribute("id");
		if(id == null) id = "";
		name = config.getAttribute("name");
		if(name == null) name = "";
		provider = config.getAttribute("provider");
		if(provider == null) provider = "";
		version = config.getAttribute("version");
		if(version == null) version = "";
	}
	
	/**
	 * Returns a file name that is the local equivalent of the supplied file name.
	 * If the specified file name is not a plug-in-relative file name, it is returned as is.
	 * If the specified file name is a plug-in-relative file name of a file (including .jar archive),
	 * it is returned as a locally accessible file name (extracting/caching the file locally, if required).
	 * The id of extension and id of a bundle should be equal.
	 *
	 * @param fileName original plug-in-relative file name
	 * @return local equivalent file name
	 * @see Bundle#getResource(String)
	 * @see FileLocator#toFileURL(RUL)
	 * @deprecated use {@link FileUtil#toLocalFile(String, String)} instead
	 */
	protected String extractFileToLocalFolder(String fileName)
	{
		Platform.getBundle(id);
		URL url = Platform.getBundle(id).getResource(fileName);
		try
		{
			url = FileLocator.toFileURL(url);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return url.getFile();
	}
	
	/**
	 * Getter/Setter
	 */

	@Override
	public IConfigurationElement getConfig()
	{
		return config;
	}
	
	@Override
	public String getId()
	{
		return id;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getProvider()
	{
		return provider;
	}

	@Override
	public String getVersion()
	{
		return version;
	}

	/**
	 * isReady() is called to check component is ready to play
	 * @return {@code true} when the component is ready and {@code false} otherwise
	 */
	@Override
	public boolean isReady()
	{
		return true;
	}
	
	/**
	 * dispose() will be called when component is destroyed
	 */
	@Override
	public abstract void dispose();
}
