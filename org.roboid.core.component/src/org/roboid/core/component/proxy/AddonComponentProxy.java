/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component.proxy;

import org.eclipse.core.runtime.IExtension;
import org.roboid.core.component.AddonComponent;
import org.roboid.core.component.IAddonComponent;
import org.roboid.core.component.IComponent;
import org.roboid.robot.Roboid;

/**
 * @author Kwang-Hyun Park
 */
public class AddonComponentProxy extends AbstractComponentProxy implements IAddonComponent
{
	private String host;
	private String modelFileName;

	public AddonComponentProxy(IExtension extension)
	{
		super(extension);
	}
	
	@Override
	public String getHost()
	{
		if(host == null)
		{
			host = getConfig().getAttribute("host");
			if(host == null) setName("");
		}
		return host;
	}
	
	@Override
	public String getModelFileName()
	{
		if(modelFileName == null)
		{
			modelFileName = getConfig().getAttribute("model");
			if(modelFileName == null) modelFileName = "-";
		}
		return modelFileName;
	}
	
	@Override
	public void initialize(final Roboid host)
	{
		if(INITIALIZED == true) return;
		
		IComponent component = getComponent();
		if(component != null)
		{
			try
			{
				((AddonComponent)component).initialize(host);
				INITIALIZED = true;
//				System.out.println(component + " was initialized using " + host);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
