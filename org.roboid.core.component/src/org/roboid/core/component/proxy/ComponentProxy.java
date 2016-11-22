/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kwang-Hyun Park
 */
public class ComponentProxy
{
	private List<RoboidComponentProxy> roboids = new ArrayList<RoboidComponentProxy>();
	private List<SystemComponentProxy> systems = new ArrayList<SystemComponentProxy>();
	
	public List<RoboidComponentProxy> getRoboids()
	{
		return roboids;
	}
	
	public List<SystemComponentProxy> getSystems()
	{
		return systems;
	}
	
	public void addChild(RoboidComponentProxy child)
	{
		roboids.add(child);
	}
	
	public void addChild(SystemComponentProxy child)
	{
		systems.add(child);
	}
}
