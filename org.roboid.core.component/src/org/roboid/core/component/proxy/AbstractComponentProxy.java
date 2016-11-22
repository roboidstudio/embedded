/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component.proxy;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.roboid.core.ExtensionManager;
import org.roboid.core.component.IComponent;

/**
 * @author Kwang-Hyun Park
 */
public abstract class AbstractComponentProxy implements IComponent
{
	private final IExtension extension;
	private volatile IComponent component;

	private IConfigurationElement config;
	private String id;
	private String name;
	private String provider;
	private String version;
	
	boolean INITIALIZED;
	boolean ACTIVATED;

	public AbstractComponentProxy(IExtension extension)
	{
		this.extension = extension;
	}

	@Override
	public IConfigurationElement getConfig()
	{
		if(config == null) config = extension.getConfigurationElements()[0];
		return config;
	}
	
	@Override
	public String getId()
	{
		if(id == null) id = ExtensionManager.getId(extension);
		return id;
	}
	
	@Override
	public String getName()
	{
		if(name == null)
		{
			name = getConfig().getAttribute("name");
			if(name == null) name = "";
		}
		return name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getProvider()
	{
		if(provider == null)
		{
			provider = getConfig().getAttribute("provider");
			if(provider == null) provider = "";
		}
		return provider;
	}

	@Override
	public String getVersion()
	{
		if(version == null)
		{
			version = getConfig().getAttribute("version");
			if(version == null) version = "";
		}
		return version;
	}
	
	IExtension getExtension()
	{
		return extension;
	}
	
	public IComponent getComponent()
	{
		return component;
	}
	
	@Override
	public void dispose()
	{
		if(INITIALIZED == false) return; // already disposed
		if(ACTIVATED) deactivate(); // if activated, deactivates first
		
		if(component != null)
		{
			try
			{
				component.dispose();
//				System.out.println(component + " was disposed");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		INITIALIZED = false;
		component = null;
	}

	@Override
	public void activate()
	{
		if(INITIALIZED == false) return; // not initialized
		if(ACTIVATED) return; // already activated
		
		if(component != null)
		{
			try
			{
				component.activate();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		ACTIVATED = true;
	}

	@Override
	public void deactivate()
	{
		if(INITIALIZED == false) return; // not initialized
		if(ACTIVATED == false) return; // already deactivated
		
		if(component != null)
		{
			try
			{
				component.deactivate();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		ACTIVATED = false;
	}

	@Override
	public void execute()
	{
		if(INITIALIZED == false) return; // not initialized
		if(ACTIVATED == false) return; // not activated
		
		if(component != null)
		{
			try
			{
				component.execute();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isReady()
	{
		if(INITIALIZED == false) return false; // not initialized
		if(component == null) return false;
		
		try
		{
			return component.isReady();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public void realize() // create real component
	{
		if(component != null) return; // already created
		
		try
		{
			IComponent newComponent = (IComponent)getConfig().createExecutableExtension("class");
			if(newComponent != null) component = newComponent;
		} catch (CoreException e)
		{
			e.printStackTrace();
		}
	}
}
