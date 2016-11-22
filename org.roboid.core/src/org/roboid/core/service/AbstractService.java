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

package org.roboid.core.service;

import java.net.DatagramSocket;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * Not used for the current version
 * 
 * @author Kyoung Jin Kim
 */
public abstract class AbstractService implements IExecutableExtension
{
	private DatagramSocket socket;

	abstract public boolean startService();
		
	abstract public void stopService();

	abstract public boolean requestToStart();
	
	abstract public boolean requestToStop();
	
	public DatagramSocket getSocket()
	{
		return socket;
	}

	public void setSocket(DatagramSocket socket)
	{
		this.socket = socket;
	}
}
