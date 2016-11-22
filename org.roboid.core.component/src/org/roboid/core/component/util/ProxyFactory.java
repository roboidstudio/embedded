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
import org.roboid.core.component.proxy.AddonComponentProxy;
import org.roboid.core.component.proxy.RoboidComponentProxy;
import org.roboid.core.component.proxy.SystemComponentProxy;

/**
 * @author Kwang-Hyun Park
 */
public final class ProxyFactory
{
	private ProxyFactory()
	{
		throw new AssertionError();
	}
	
	public static RoboidComponentProxy createRoboidComponentProxy(IExtension extension)
	{
		if(extension == null) return null;
		return new RoboidComponentProxy(extension);
	}
	
	public static AddonComponentProxy createAddonComponentProxy(IExtension extension)
	{
		if(extension == null) return null;
		return new AddonComponentProxy(extension);
	}
	
	public static SystemComponentProxy createSystemComponentProxy(IExtension extension)
	{
		if(extension == null) return null;
		return new SystemComponentProxy(extension);
	}
}
