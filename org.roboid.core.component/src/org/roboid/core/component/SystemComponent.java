/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kyoung Jin Kim, Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.swtdesigner.ResourceManager;

/**
 * This class is a template for service components
 * 
 * @author Kyoung Jin Kim, Kwang-Hyun Park
 */
public abstract class SystemComponent extends AbstractComponent implements ISystemComponent
{
	private ImageDescriptor imageDescriptor;
	private Image icon;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException
	{
		super.setInitializationData(config, propertyName, data);
		
		String iconFileName = config.getAttribute("icon");
		if(iconFileName != null)
		{
			IExtension extension = config.getDeclaringExtension();
			String pluginExtendingPluginId = extension.getContributor().getName();
			imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(pluginExtendingPluginId, iconFileName);
		}
	}
	
	/**
	 * Getter/Setter
	 */

	@Override
	public Image getIcon()
	{
		if(icon == null) icon = ResourceManager.getImage(imageDescriptor);
		return icon;
	}
}
