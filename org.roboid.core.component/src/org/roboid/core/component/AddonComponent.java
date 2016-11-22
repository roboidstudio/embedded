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

/**
 * This class is a template for addon components
 * 
 * @author Kyoung Jin Kim, Kwang-Hyun Park
 */
public abstract class AddonComponent extends AbstractComponent implements IAddonComponent
{
	private String host;
	private String modelFileName;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException
	{
		super.setInitializationData(config, propertyName, data);
		
		host = config.getAttribute("host");
		if(host == null) setName("");
		modelFileName = config.getAttribute("model");
		if(modelFileName == null) modelFileName = "-";
	}
	
	/**
	 * Getter/Setter
	 */

	@Override
	public String getHost()
	{
		return host;
	}
	
	@Override
	public String getModelFileName()
	{
		return modelFileName;
	}
}
