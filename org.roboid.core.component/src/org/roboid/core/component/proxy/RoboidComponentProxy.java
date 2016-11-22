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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.roboid.core.component.IComponent;
import org.roboid.core.component.IRoboidComponent;
import org.roboid.core.component.RoboidComponent;
import org.roboid.robot.Roboid;

import com.swtdesigner.ResourceManager;

/**
 * @author Kwang-Hyun Park
 */
public class RoboidComponentProxy extends AbstractComponentProxy implements IRoboidComponent
{
	Roboid roboid;
	
	private Image icon;
	private String modelFileName;
	private int maxOccurrence = -2;
	
	public RoboidComponentProxy(IExtension extension)
	{
		super(extension);
	}
	
	@Override
	public Image getIcon()
	{
		if(icon == null)
		{
			String iconFileName = getConfig().getAttribute("icon");
			if(iconFileName != null)
			{
				String pluginId = getExtension().getContributor().getName();
				ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, iconFileName);
				icon = ResourceManager.getImage(imageDescriptor);
			}
		}
		return icon;
	}
	
	@Override
	public String getModelFileName()
	{
		if(modelFileName == null)
		{
			modelFileName = getConfig().getAttribute("model");
			if(modelFileName == null) modelFileName = "";
		}
		return modelFileName;
	}
	
	@Override
	public int getMaxOccurrence()
	{
		if(maxOccurrence < -1)
		{
			String str = getConfig().getAttribute("occurrence");
			try
			{
				maxOccurrence = Integer.parseInt(str); 
			} catch (NumberFormatException e)
			{
			}
			if(maxOccurrence < 0) maxOccurrence = -1;
		}
		return maxOccurrence;
	}

	@Override
	public void initialize(final Roboid roboid)
	{
		if(INITIALIZED == true) return;
		
		IComponent component = getComponent();
		if(component != null)
		{
			try
			{
				((RoboidComponent)component).initialize(roboid);
				RoboidComponentProxy.this.roboid = roboid;
				INITIALIZED = true;
//				System.out.println(component + " was initialized using " + roboid);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void execute()
	{
		if(INITIALIZED == false) return;
		if(ACTIVATED == false) return;
		
		if(roboid != null)
		{
			roboid.updateDeviceState();
			super.execute();
		}
	}
}
