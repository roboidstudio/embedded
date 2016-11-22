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

package org.roboid.robot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.roboid.robot.Device;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.impl.RoboidImpl;
import org.roboid.robot.impl.RobotImpl;

/**
 * @author Kwang-Hyun Park
 */
public class ModelMatcher
{
	Map<Device, Device> deviceMap = new HashMap<Device, Device>();
	Map<Roboid, Roboid> roboidMap = new HashMap<Roboid, Roboid>();
	Robot newRobot;
	
	public ModelMatcher(Robot newRobot)
	{
		this.newRobot = newRobot;
	}
	
	public Roboid findRoboid(Roboid oldRoboid)
	{
		if(newRobot == null || oldRoboid == null) return null;
		
		Roboid newRoboid = roboidMap.get(oldRoboid);
		if(newRoboid != null) return newRoboid;
		
		List<Roboid> newRoboids = new ArrayList<Roboid>();
		collectRoboids(newRoboids, oldRoboid);
		
		if(newRoboids.size() == 1)
			newRoboid = newRoboids.get(0);
		else if(newRoboids.size() > 0)
			newRoboid = selectRoboid(newRoboids, oldRoboid);
		
		if(newRoboid != null) roboidMap.put(oldRoboid, newRoboid);
		
		return newRoboid;
	}
	
	private List<Roboid> collectRoboids(List<Roboid> newRoboids, Roboid oldRoboid)
	{
		// ID, all parent's IDs and version should be same
		List<Roboid> candidates = new ArrayList<Roboid>();
		((RobotImpl)newRobot).collectAllRoboidsById(candidates, oldRoboid.getId());
		
		for(Roboid newRoboid : candidates)
		{
			if(newRoboid.getVersion() == null)
			{
				if(oldRoboid.getVersion() != null) continue;
			}
			else if(!newRoboid.getVersion().equalsIgnoreCase(oldRoboid.getVersion())) continue;
			if(((RoboidImpl)newRoboid).equalsFullId(oldRoboid) && !roboidMap.containsValue(newRoboid))
				newRoboids.add(newRoboid);
		}
		return newRoboids;
	}
	
	private Roboid selectRoboid(List<Roboid> newRoboids, Roboid oldRoboid)
	{
		List<Roboid> candidates = new ArrayList<Roboid>();
		for(Roboid newRoboid : newRoboids)
		{
			if(checkFullAddress(newRoboid, oldRoboid))
				candidates.add(newRoboid);
		}
		
		if(candidates.size() > 0)
			return candidates.get(0);
		
		return newRoboids.get(0);
	}
	
	private boolean checkFullAddress(Roboid newRoboid, Roboid oldRoboid)
	{
		if(newRoboid == oldRoboid) return true;
		
		String newAddress = newRoboid.getAddress();
		String oldAddress = oldRoboid.getAddress();
		
		if(newAddress != null && !newAddress.isEmpty() && oldAddress != null && !oldAddress.isEmpty() && !newAddress.equalsIgnoreCase(oldAddress))
			return false;

		NamedElement oldParent = oldRoboid.getParent();
		NamedElement newParent = newRoboid.getParent();
		if((oldParent instanceof Roboid) && (newParent instanceof Roboid))
			return checkFullAddress((Roboid)newParent, (Roboid)oldParent);
		else if(!((oldParent instanceof Robot) && (newParent instanceof Robot)))
			return false;

		return true;
	}
	
	public Device findDevice(Device oldDevice)
	{
		if(newRobot == null || oldDevice == null) return null;
		
		Device newDevice = deviceMap.get(oldDevice);
		if(newDevice != null) return newDevice;
		
		Roboid newRoboid = findRoboid((Roboid)oldDevice.getParent());
		if(newRoboid == null) return null;
		
		int index = ((Roboid)oldDevice.getParent()).getDevices().indexOf(oldDevice);
		if(index < 0) return null;
		if(index >= newRoboid.getDevices().size()) return null;

		newDevice = newRoboid.getDevices().get(index);
		if(newDevice != null) deviceMap.put(oldDevice, newDevice);
		return newDevice;
	}
	
	public void collectDifferentRoboids(List<Roboid> adds, List<Roboid> removes, Robot oldRobot)
	{
		if(adds == null || removes == null || oldRobot == null || newRobot == null) return;
		
		((RobotImpl)oldRobot).collectAllRoboids(removes);
		((RobotImpl)newRobot).collectAllRoboids(adds);
		List<Roboid> oldRoboids = new ArrayList<Roboid>(removes);
		
		for(Roboid oldRoboid : oldRoboids)
		{
			Roboid newRoboid = findRoboid(oldRoboid);
			if(newRoboid != null)
			{
				adds.remove(newRoboid);
				removes.remove(oldRoboid);
			}
		}
	}
}
