/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * @author Kwang-Hyun Park
 */
public interface IComponent
{
	public IConfigurationElement getConfig();
	public String getId();
	public String getName();
	public String getProvider();
	public String getVersion();
	
	/**
	 * Following APIs should be implmented by roboid bundles
	 */
	
	/**
	 * dispose() will be called when component is destroyed
	 */
	public void dispose();
	
	/**
	 * activate() will be called when player starts
	 */
	public void activate();
	
	/**
	 * deactivate() will be called when player stops 
	 */
	public void deactivate();
	
	/**
	 * execute() will be called in regular interval when it is active
	 */
	public void execute();
	
	/**
	 * isReady() is called to check component is ready to play
	 * @return {@code true} when the component is ready and {@code false} otherwise
	 */
	public boolean isReady();
}
