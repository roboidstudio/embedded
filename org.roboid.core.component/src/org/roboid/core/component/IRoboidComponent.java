/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.component;

import org.eclipse.swt.graphics.Image;
import org.roboid.robot.Roboid;

/**
 * @author Kwang-Hyun Park
 */
public interface IRoboidComponent extends IComponent
{
	public Image getIcon();
	public String getModelFileName();
	public int getMaxOccurrence();
	
	/**
	 * Following API should be implmented by roboid bundles
	 */
	/**
	 * initialize() will be called when component is created
	 * @param roboid
	 */
	public void initialize(Roboid roboid);
}
