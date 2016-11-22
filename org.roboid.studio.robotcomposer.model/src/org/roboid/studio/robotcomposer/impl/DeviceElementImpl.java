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

package org.roboid.studio.robotcomposer.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.roboid.robot.Command;
import org.roboid.robot.Device;
import org.roboid.robot.Effector;
import org.roboid.robot.Event;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Roboid;
import org.roboid.robot.Sensor;
import org.roboid.robot.SensoryDevice;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.ConnectableElement;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotComposerFactory;
import org.roboid.studio.robotcomposer.RobotComposerPackage;
import org.roboid.studio.robotcomposer.RobotDiagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Element</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.DeviceElementImpl#getDevice <em>Device</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeviceElementImpl extends ConnectableElementImpl implements DeviceElement {
	/**
	 * The cached value of the '{@link #getDevice() <em>Device</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected Device device;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotComposerPackage.Literals.DEVICE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevice(Device newDevice) {
		Device oldDevice = device;
		device = newDevice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotComposerPackage.DEVICE_ELEMENT__DEVICE, oldDevice, device));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotComposerPackage.DEVICE_ELEMENT__DEVICE:
				return getDevice();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RobotComposerPackage.DEVICE_ELEMENT__DEVICE:
				setDevice((Device)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case RobotComposerPackage.DEVICE_ELEMENT__DEVICE:
				setDevice((Device)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RobotComposerPackage.DEVICE_ELEMENT__DEVICE:
				return device != null;
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
	public RobotDiagram getDiagram()
	{
		if(diagram == null) diagram = ((RoboidBlock)eContainer()).getDiagram();
		return diagram;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String getName()
	{
		if(name == null)
		{
			Device device = getDevice();
			if(device == null || device.getName() == null) return "";
			
			NamedElement parent = device.getParent();
			if(parent == null) return "";
			
			NamedElement grandParent = parent.getParent();
			StringBuilder sb = new StringBuilder(device.getName());
			while(grandParent instanceof Roboid)
			{
				if(parent.getName() == null) break;
				sb.insert(0, parent.getName() + ".");
				parent = grandParent;
				grandParent = parent.getParent();
			}
			name = sb.toString();
		}
		return name;
	}
	
	@Override
	public boolean canConnectTo(ConnectableElement target)
	{
		Device sourceDevice = getDevice();
		if(sourceDevice == null) return false;
		if(sourceDevice.isProxy())
		{
			if(sourceDevice.getProxyFor() != null) return false;
		}
		else if(!(sourceDevice instanceof SensoryDevice))
			return false;
		return true;
	}

	@Override
	public boolean canConnectFrom(ConnectableElement source)
	{
		return false;
	}

	@Override
	public boolean canReconnectTo(ConnectableElement oldTarget, ConnectableElement newTarget)
	{
		if(oldTarget == newTarget) return true;
		if(!(oldTarget instanceof DeviceElement)) return false;
		if(newTarget instanceof DeviceElement) return false;
		if(newTarget instanceof RoboidBlock)
		{
			Device sourceDevice = getDevice();
			if(sourceDevice == null) return false;
			
			Device oldTargetDevice = ((DeviceElement)oldTarget).getDevice();
			if(oldTargetDevice == null) return false;
			
			Roboid roboid = ((RoboidBlock)newTarget).getRoboid();
			if(roboid == null) return false;
			List<Device> newTargetDevices = new ArrayList<Device>();
			roboid.collectAllDevices(newTargetDevices);
			for(Device newTargetDevice : newTargetDevices)
			{
				if(newTargetDevice == oldTargetDevice) continue;
				if(((RoboidBlock)newTarget).findDeviceElement(newTargetDevice) != null) continue;
				if(sourceDevice.isProxy())
				{
					if(sourceDevice.getClass().equals(newTargetDevice.getClass()) && sourceDevice.isDataTypeOf(newTargetDevice))
						return true;
				}
				else if(sourceDevice instanceof Sensor)
				{
					if(newTargetDevice instanceof Effector && sourceDevice.isDataTypeOf(newTargetDevice))
						return true;
				}
				else if(sourceDevice instanceof Event)
				{
					if(newTargetDevice instanceof Command && sourceDevice.isDataTypeOf(newTargetDevice))
						return true;
				}
			}
			return false;
		}
		return true;
	}
	
	@Override
	public boolean canReconnectFrom(ConnectableElement oldSource, ConnectableElement newSource)
	{
		if(oldSource == newSource) return true;
		if(!(oldSource instanceof DeviceElement)) return false;
		
		Device targetDevice = getDevice();
		if(targetDevice == null) return false;
		
		if(newSource instanceof DeviceElement)
		{
			Device newSourceDevice = ((DeviceElement)newSource).getDevice();
			if(newSourceDevice == null) return false;
			if(newSourceDevice.isProxy()) return false;
			else if(newSourceDevice instanceof Sensor)
			{
				if(!(targetDevice instanceof Effector)) return false;
			}
			else if(newSourceDevice instanceof Event)
			{
				if(!(targetDevice instanceof Command)) return false;
			}
			if(!newSourceDevice.isDataTypeOf(targetDevice)) return false;
		}
		else if(newSource instanceof RoboidBlock)
		{
			Device oldSourceDevice = ((DeviceElement)oldSource).getDevice();
			if(oldSourceDevice == null) return false;
			
			Roboid roboid = ((RoboidBlock)newSource).getRoboid();
			if(roboid == null) return false;
			List<Device> newSourceDevices = new ArrayList<Device>();
			roboid.collectAllDevices(newSourceDevices);
			for(Device newSourceDevice : newSourceDevices)
			{
				if(newSourceDevice == oldSourceDevice) continue;
				if(((RoboidBlock)newSource).findDeviceElement(newSourceDevice) != null) continue;
				if(newSourceDevice.isProxy())
				{
					if(newSourceDevice.getClass().equals(targetDevice.getClass()) && newSourceDevice.isDataTypeOf(targetDevice))
						return true;
				}
				else if(newSourceDevice instanceof Sensor)
				{
					if(targetDevice instanceof Effector && newSourceDevice.isDataTypeOf(targetDevice))
						return true;
				}
				else if(newSourceDevice instanceof Event)
				{
					if(targetDevice instanceof Command && newSourceDevice.isDataTypeOf(targetDevice))
						return true;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isConnectedTo(Device targetDevice)
	{
		if(targetDevice == null) return false;
		
		for(Association association : getOutgoings())
		{
			ConnectableElement targetElement = association.getTarget();
			if(targetElement instanceof DeviceElement)
			{
				if(targetDevice.equals(((DeviceElement)targetElement).getDevice()))
					return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void connectTo(DeviceElement targetElement, boolean isProxy)
	{
		if(getDiagram() == null || targetElement == null) return;
		if(isConnectedTo(targetElement.getDevice())) return;
		
		Association association = RobotComposerFactory.eINSTANCE.createAssociation();
		association.setProxy(isProxy);
		association.setSource(this);
		association.setTarget(targetElement);
		addOutgoing(association);
		targetElement.addIncoming(association);
		getDiagram().addAssociation(association);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Called when the proxyFor or receptor of a device is added.
	 * The root roboid of the argument should exist.
	 * @param targetDevice a target device
	 * @param isProxy connection type
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void connectTo(Device targetDevice, boolean isProxy)
	{
		if(getDiagram() == null || targetDevice == null) return;
		if(isConnectedTo(targetDevice)) return;
		
		RoboidBlock targetBlock = getDiagram().findRoboidBlock(targetDevice);
		if(targetBlock == null) return;
		DeviceElement targetElement = targetBlock.getDeviceElement(targetDevice);
		connectTo(targetElement, isProxy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Called when the parent roboid block is removed.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void disconnectFrom(DeviceElement targetElement)
	{
		if(getDiagram() == null || targetElement == null) return;
		if(targetElement.getIncomings().isEmpty()) return;
		
		Association association = targetElement.getIncomings().get(0);
		targetElement.removeIncoming(association);
		removeOutgoing(association);
		getDiagram().removeAssociation(association);
		
		RoboidBlock targetBlock = (RoboidBlock)((EObject)targetElement).eContainer();
		if(targetBlock != null) targetBlock.removeChild(targetElement);
		
		if(getOutgoings().isEmpty() && getIncomings().isEmpty())
		{
			RoboidBlock sourceBlock = (RoboidBlock)eContainer();
			if(sourceBlock != null) sourceBlock.removeChild(this);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Called when the proxyFor or receptor of a device is removed.
	 * The root roboid of the argument should exist.
	 * @param targetDevice a target device
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void disconnectFrom(Device targetDevice)
	{
		if(getDiagram() == null || targetDevice == null) return;
		
		RoboidBlock targetBlock = getDiagram().findRoboidBlock(targetDevice);
		if(targetBlock == null) return;
		DeviceElement targetElement = targetBlock.findDeviceElement(targetDevice);
		disconnectFrom(targetElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reconnectTo(Device oldTargetDevice, Device newTargetDevice)
	{
		if(getDiagram() == null || oldTargetDevice == null || newTargetDevice == null) return;
		
		RoboidBlock oldTargetBlock = getDiagram().findRoboidBlock(oldTargetDevice);
		RoboidBlock newTargetBlock = getDiagram().findRoboidBlock(newTargetDevice);
		if(oldTargetBlock == null || newTargetBlock == null) return;
		
		DeviceElement oldTargetElement = oldTargetBlock.getDeviceElement(oldTargetDevice);
		DeviceElement newTargetElement = newTargetBlock.getDeviceElement(newTargetDevice);
		
		Association association = oldTargetElement.getIncomings().get(0);
		oldTargetElement.removeIncoming(association);
		
		newTargetElement.addIncoming(association);
		association.setTarget(newTargetElement);
	}
} //DeviceElementImpl
