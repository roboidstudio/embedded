/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.runtime;

import org.eclipse.swt.widgets.Shell;

/**
 * @author Kwang-Hyun Park
 */
public interface IClipPlayer
{
	public void activate(Shell shell, ISystem system);
	public boolean execute();
	public void deactivate();
}
