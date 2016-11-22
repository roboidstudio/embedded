/*
 * Part of the ROBOID project
 * Copyright (C) 2016 Kwang-Hyun Park (akaii@kw.ac.kr) and Kyoung Jin Kim
 * https://github.com/roboidstudio/embedded
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
*/

package org.roboid.studio.robotcomposer.commands;

import org.eclipse.gef.commands.Command;
import org.roboid.studio.robotcomposer.ConnectableElement;

/**
 * @author Kwang-Hyun Park
 */
public class CreateConnectionCommand extends Command
{
	private ConnectableElement source;
	private ConnectableElement target;
	
	public CreateConnectionCommand(ConnectableElement source)
	{
		this.source = source;
	}
	
	public void setTarget(ConnectableElement target)
	{
		this.target = target;
	}

	@Override
	public boolean canExecute()
	{
		if(source != null && target != null)
		{
			if(!source.canConnectTo(target)) return false;
			if(!target.canConnectFrom(source)) return false;
			return true;
		}
		return false;
	}
}
