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

package org.roboid.core;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * Not used for the current version
 * 
 * @author Kyoung Jin Kim
 */
public class SocketManager
{
	private static SocketManager manager = null;
	private Application application;
	private Robot robot;
	private List<Sniffer> sniffers = new ArrayList<Sniffer>();

	private SocketManager()
	{
		application = new Application();
		robot = new Robot();
	}
	
	public static synchronized SocketManager getInstance()
	{
		if(manager == null) manager = new SocketManager();
		return manager;
	}
	
	public Sniffer createSniffer(String id)
	{
		Sniffer sniffer = new Sniffer(id);
		sniffers.add(sniffer);
		return sniffer;
	}
	
	public Application getApplication()
	{
		return application;
	}

	public Robot getRobot()
	{
		return robot;
	}

	public List<Sniffer> getSniffers()
	{
		return sniffers;
	}
	
	/**
	 * 
	 */
	class Application
	{
		private DatagramSocket socket;
		
		public Application()
		{
			try
			{
				socket = new DatagramSocket();
			} catch (SocketException e)
			{
				e.printStackTrace();
			}
		}

		public DatagramSocket getSocket()
		{
			return socket;
		}		
	}
	
	public class Sniffer
	{
		private String id;
		private DatagramSocket uplinkSocket;
		private DatagramSocket downlinkSocket;
		
		public Sniffer(String id)
		{
			this.id = id;
			try
			{
				uplinkSocket = new DatagramSocket();
				downlinkSocket = new DatagramSocket();
			} catch (SocketException e)
			{
				e.printStackTrace();
			}
		}

		public String getId()
		{
			return id;
		}

		public DatagramSocket getUplinkSocket()
		{
			return uplinkSocket;
		}

		public DatagramSocket getDownlinkSocket()
		{
			return downlinkSocket;
		}
	}
	
	class Robot
	{
		private DatagramSocket socket;
		
		public Robot()
		{
			try
			{
				socket = new DatagramSocket();
			} catch (SocketException e)
			{
				e.printStackTrace();
			}
		}

		public DatagramSocket getSocket()
		{
			return socket;
		}
	}
	
	/**
	 * test code
	 */
	public static void main(String[] args)
	{
		SocketManager manager = SocketManager.getInstance();
		System.out.println(manager.getApplication().getSocket().getLocalPort());
		System.out.println(manager.getRobot().getSocket().getLocalPort());
		manager.createSniffer("kim");
		manager.getApplication().getSocket().close();
		manager.getRobot().getSocket().close();
		System.out.println(((Sniffer)manager.getSniffers().get(0)).getDownlinkSocket().getLocalPort());
		System.out.println(((Sniffer)manager.getSniffers().get(0)).getUplinkSocket().getLocalPort());
	}
}
