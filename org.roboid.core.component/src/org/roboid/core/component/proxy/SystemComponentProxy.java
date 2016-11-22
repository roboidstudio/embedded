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
import org.roboid.core.component.ISystemComponent;
import org.roboid.core.component.SystemComponent;
import org.roboid.robot.Robot;

import com.swtdesigner.ResourceManager;

/**
 * @author Kwang-Hyun Park
 */
public class SystemComponentProxy extends AbstractComponentProxy implements ISystemComponent
{
	private Image icon;

	public SystemComponentProxy(IExtension extension)
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
	public void initialize(Robot robot)
	{
		if(INITIALIZED == true) return;
		
		IComponent component = getComponent();
		if(component != null)
		{
			try
			{
				((SystemComponent)component).initialize(robot);
				INITIALIZED = true;
//				System.out.println(component + " was initialized using " + robot);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
