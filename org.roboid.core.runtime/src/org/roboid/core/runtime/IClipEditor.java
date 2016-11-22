/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.runtime;

import org.roboid.core.component.activity.Activity;
import org.roboid.robot.Robot;

/**
 * @author Kwang-Hyun Park
 */
public interface IClipEditor
{
	IClip getContent();
	Robot getRobot();
	Activity getActivity();
}
