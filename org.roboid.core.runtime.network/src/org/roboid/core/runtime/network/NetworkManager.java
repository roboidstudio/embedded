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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kwang-Hyun Park
 */
public class NetworkManager
{
	private static final List<NetworkNotificationListener> listeners = new ArrayList<NetworkNotificationListener>();
	private static final List<NetworkItem> items = new ArrayList<NetworkItem>();
	
	private NetworkManager()
	{
		throw new AssertionError();
	}
	
	public static List<NetworkItem> copyNetworkItems()
	{
		synchronized(items)
		{
			return new ArrayList<NetworkItem>(items);
		}
	}
	
	public static void addNetworkNotificationListener(NetworkNotificationListener listener)
	{
		if(listener == null) return;
		listeners.add(listener);
	}
	
	public static void removeNetworkNotificationListener(NetworkNotificationListener listener)
	{
		if(listener == null) return;
		listeners.remove(listener);
	}
	
	public static void notifyNetworkChanged(Notification notification)
	{
		switch(notification.getCommand())
		{
		case Notification.COMMAND_ADD:
			{
				NetworkItem item = notification.getItem();
				if(item == null) return;
				synchronized(items)
				{
					if(items.contains(item)) return;
					items.add(item);
				}
			}
			break;
		case Notification.COMMAND_REMOVE:
			{
				NetworkItem item = notification.getItem();
				if(item == null) return;
				synchronized(items)
				{
					items.remove(item);
				}
			}
			break;
		}
		int N = listeners.size();
		for(int i = N - 1; i >= 0; --i)
			listeners.get(i).onNotify(notification);
	}
}
