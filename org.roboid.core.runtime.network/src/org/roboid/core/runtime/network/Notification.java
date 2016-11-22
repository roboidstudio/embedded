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

package org.roboid.core.runtime.network;

/**
 * @author Kwang-Hyun Park
 */
public class Notification
{
	private int command;
	private NetworkItem item;
	
	public static final int COMMAND_ADD = 1;
	public static final int COMMAND_REMOVE = 2;
	public static final int COMMAND_STATE = 3;
	public static final int COMMAND_ERROR = 4;
	
	public static final int STATE_NONE = 0;
	public static final int STATE_CONNECTING = 1;
	public static final int STATE_CONNECTED = 2;
	public static final int STATE_CONNECTION_LOST = 3;
	public static final int STATE_DISCONNECTED = 4;
	public static final int STATE_DISPOSED = 5;
	
	public static final int ERROR_NO_AVAILABLE_USB = -1;
	public static final int ERROR_ROBOT_NOT_CONNECTED = -2;
	
	public Notification(int command, NetworkItem item)
	{
		this.command = command;
		this.item = item;
	}
	
	public int getCommand()
	{
		return command;
	}
	
	public NetworkItem getItem()
	{
		return item;
	}
}
