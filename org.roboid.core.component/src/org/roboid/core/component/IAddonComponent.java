/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component;

import org.roboid.robot.Roboid;

/**
 * @author Kwang-Hyun Park
 */
public interface IAddonComponent extends IComponent
{
	public String getHost();
	public String getModelFileName();
	
	/**
	 * Following API should be implmented by roboid bundles
	 */
	/**
	 * initialize() will be called when component is created
	 * @param host the host roboid of this addon
	 */
	public void initialize(Roboid host);
}
