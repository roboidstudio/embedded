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

package org.roboid.robot.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.roboid.robot.Channel;
import org.roboid.robot.ChannelDevice;
import org.roboid.robot.IoMode;
import org.roboid.robot.MotoringDevice;
import org.roboid.robot.Port;
import org.roboid.robot.Roboid;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.ChannelImpl#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChannelImpl extends NamedElementImpl implements Channel
{
	/**
	 * The cached value of the '{@link #getDevices() <em>Devices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevices()
	 * @generated
	 * @ordered
	 */
	protected EList<ChannelDevice> devices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return RobotPackage.Literals.CHANNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ChannelDevice> getDevices()
	{
		if (devices == null) {
			devices = new EObjectEList<ChannelDevice>(ChannelDevice.class, this, RobotPackage.CHANNEL__DEVICES);
		}
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case RobotPackage.CHANNEL__DEVICES:
				return getDevices();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case RobotPackage.CHANNEL__DEVICES:
				getDevices().clear();
				getDevices().addAll((Collection<? extends ChannelDevice>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case RobotPackage.CHANNEL__DEVICES:
				getDevices().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case RobotPackage.CHANNEL__DEVICES:
				return devices != null && !devices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Channel)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Channel other = (Channel)obj;
		if(!equalsDevicesContents(getDevices(), other.getDevices())) return false;
		
		return true;
	}
	
	private boolean equalsDevicesContents(List<ChannelDevice> devices1, List<ChannelDevice> devices2)
	{
		if(devices1 == devices2) return true;
		if(devices1.size() != devices2.size()) return false;
		
		Iterator<ChannelDevice> it1 = devices1.iterator();
		Iterator<ChannelDevice> it2 = devices2.iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			ChannelDevice dev1 = it1.next();
			ChannelDevice dev2 = it2.next();
			if(dev1 == null)
			{
				if(dev2 != null) return false;
			}
			else if(dev1 != dev2)
			{
				Roboid parent1 = (Roboid)dev1.getParent();
				Roboid parent2 = (Roboid)dev2.getParent();
				if(parent1.getDevices().indexOf(dev1) != parent2.getDevices().indexOf(dev2)) return false;
				if(!((RoboidImpl)parent1).equalsFullUid(parent2)) return false;
			}
		}
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEnabled()
	{
		if(devices.size() <= 0) return false;
		
		ChannelDevice device = devices.get(0);
		if(device instanceof Port)
		{
			IoMode mode = ((Port)device).getMode();
			return (mode == IoMode.SERVO_OUTPUT) || (mode == IoMode.PWM_OUTPUT) || (mode == IoMode.DIGITAL_OUTPUT);
		}
		else if(device instanceof MotoringDevice)
			return true;
		return false;
	}
} //ChannelImpl
