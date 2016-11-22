/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.runtime;

import org.eclipse.emf.ecore.resource.Resource;
import org.roboid.core.component.activity.Activity;
import org.roboid.robot.Robot;

/**
 * @author Kwang-Hyun Park
 */
public interface IClip
{
	Robot getRobot();
	Activity getActivity();
	Resource getResource();
	void setActivity(Activity activity);
	int updateReference(Robot newRobot);
	int adaptTo(Robot newRobot);
}
