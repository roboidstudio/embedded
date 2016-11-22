/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component.util;

import org.eclipse.core.runtime.IExtension;
import org.roboid.core.ExtensionManager;
import org.roboid.core.component.IRoboidComponent;
import org.roboid.core.component.proxy.RoboidComponentProxy;
import org.roboid.robot.Roboid;
import org.roboid.robot.util.RoboidFactory;

/**
 * @author Kwang-Hyun Park
 */
public final class ComponentFactory
{
	private ComponentFactory()
	{
		throw new AssertionError();
	}
	
	/**
	 * Dynamic loading
	 */
	public static IRoboidComponent createRoboidComponent(String componentId)
	{
		Roboid roboid = RoboidFactory.createRoboid(componentId);
		return createRoboidComponent(componentId, roboid);
	}
	
	public static IRoboidComponent createRoboidComponent(String componentId, Roboid roboid)
	{
		IExtension extension = ExtensionManager.getRoboidExtension(componentId);
		if(extension == null) return null;
		
		RoboidComponentProxy roboidProxy = ProxyFactory.createRoboidComponentProxy(extension);
		roboidProxy.realize();
		return roboidProxy;
	}
}
