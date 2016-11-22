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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.robot.Command;
import org.roboid.robot.Device;
import org.roboid.robot.Effector;
import org.roboid.robot.Event;
import org.roboid.robot.MotoringDevice;
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
 * An implementation of the model object '<em><b>Roboid Block</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RoboidBlockImpl#getX <em>X</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RoboidBlockImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RoboidBlockImpl#getRoboid <em>Roboid</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RoboidBlockImpl#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoboidBlockImpl extends ConnectableElementImpl implements RoboidBlock
{
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected int x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected int y = Y_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoboid() <em>Roboid</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoboid()
	 * @generated
	 * @ordered
	 */
	protected Roboid roboid;

	/**
	 * The cached value of the '{@link #getDevices() <em>Devices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevices()
	 * @generated
	 * @ordered
	 */
	protected EList<DeviceElement> devices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboidBlockImpl()
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
		return RobotComposerPackage.Literals.ROBOID_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(int newX)
	{
		int oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotComposerPackage.ROBOID_BLOCK__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(int newY)
	{
		int oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotComposerPackage.ROBOID_BLOCK__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Roboid getRoboid()
	{
		return roboid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoboid(Roboid newRoboid)
	{
		Roboid oldRoboid = roboid;
		roboid = newRoboid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotComposerPackage.ROBOID_BLOCK__ROBOID, oldRoboid, roboid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<DeviceElement> getDevices() {
		if (devices == null) {
			devices = new EObjectContainmentEList<DeviceElement>(DeviceElement.class, this, RobotComposerPackage.ROBOID_BLOCK__DEVICES);
		}
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RobotComposerPackage.ROBOID_BLOCK__DEVICES:
				return ((InternalEList<?>)getDevices()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case RobotComposerPackage.ROBOID_BLOCK__X:
				return getX();
			case RobotComposerPackage.ROBOID_BLOCK__Y:
				return getY();
			case RobotComposerPackage.ROBOID_BLOCK__ROBOID:
				return getRoboid();
			case RobotComposerPackage.ROBOID_BLOCK__DEVICES:
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
			case RobotComposerPackage.ROBOID_BLOCK__X:
				setX((Integer)newValue);
				return;
			case RobotComposerPackage.ROBOID_BLOCK__Y:
				setY((Integer)newValue);
				return;
			case RobotComposerPackage.ROBOID_BLOCK__ROBOID:
				setRoboid((Roboid)newValue);
				return;
			case RobotComposerPackage.ROBOID_BLOCK__DEVICES:
				getDevices().clear();
				getDevices().addAll((Collection<? extends DeviceElement>)newValue);
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
			case RobotComposerPackage.ROBOID_BLOCK__X:
				setX(X_EDEFAULT);
				return;
			case RobotComposerPackage.ROBOID_BLOCK__Y:
				setY(Y_EDEFAULT);
				return;
			case RobotComposerPackage.ROBOID_BLOCK__ROBOID:
				setRoboid((Roboid)null);
				return;
			case RobotComposerPackage.ROBOID_BLOCK__DEVICES:
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
			case RobotComposerPackage.ROBOID_BLOCK__X:
				return x != X_EDEFAULT;
			case RobotComposerPackage.ROBOID_BLOCK__Y:
				return y != Y_EDEFAULT;
			case RobotComposerPackage.ROBOID_BLOCK__ROBOID:
				return roboid != null;
			case RobotComposerPackage.ROBOID_BLOCK__DEVICES:
				return devices != null && !devices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(')');
		return result.toString();
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
	public String getName()
	{
		if(name == null) name = getRoboid().getName();
		return name;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public RobotDiagram getDiagram()
	{
		if(diagram == null) diagram = (RobotDiagram)eContainer();
		return diagram;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public RoboidBlock deepCopy(RobotDiagram newDiagram)
	{
		RoboidBlock newBlock = RobotComposerFactory.eINSTANCE.createRoboidBlock();
		copyTo(newBlock);
		newBlock.setDiagram(newDiagram);
		return newBlock;
	}
	
	/**
	 * @generated NOT
	 */
	protected void copyTo(RoboidBlock newBlock)
	{
		newBlock.setX(getX());
		newBlock.setY(getY());
		newBlock.setRoboid(getRoboid());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addChild(DeviceElement child)
	{
		getDevices().add(child);
		child.setDiagram(getDiagram());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChild(DeviceElement child)
	{
		getDevices().remove(child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeAllChildren()
	{
		getDevices().clear();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DeviceElement createDeviceElement(Device device)
	{
		DeviceElement newElement = RobotComposerFactory.eINSTANCE.createDeviceElement();
		newElement.setDevice(device);
		int index = checkOrder(device);
		insertChild(index, newElement);
		return newElement;
	}
	
	private void insertChild(int index, DeviceElement child)
	{
		if(index < 0)
			getDevices().add(child);
		else
			getDevices().add(index, child);
		child.setDiagram(getDiagram());
	}
	
	private int checkOrder(Device device)
	{
		if(getRoboid() == null) return -1;
		List<Device> devices = new ArrayList<Device>();
		getRoboid().collectAllDevices(devices);
		int i = devices.indexOf(device);
		if(i < 0) return -1;
		
		int index = 0;
		for(DeviceElement element : getDevices())
		{
			if(i < devices.indexOf(element.getDevice()))
				return index;
			index ++;
		}
		return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DeviceElement getDeviceElement(Device device)
	{
		DeviceElement deviceElement = findDeviceElement(device);
		if(deviceElement == null) deviceElement = createDeviceElement(device);
		return deviceElement;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DeviceElement findDeviceElement(Device device)
	{
		if(device == null) return null;
		
		for(DeviceElement child : getDevices())
		{
			if(device.equals(child.getDevice()))
				return child;
		}
		return null;
	}
	
	private Device sourceDevice;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Device getSourceDevice()
	{
		return sourceDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSourceDevice(Device device)
	{
		this.sourceDevice = device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canDelete()
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCopy()
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCut()
	{
		return true;
	}

	@Override
	public boolean canConnectTo(ConnectableElement target)
	{
		if(getRoboid() == null) return false;
		List<Device> sourceDevices = new ArrayList<Device>();
		getRoboid().collectAllDevices(sourceDevices);
		for(Device sourceDevice : sourceDevices)
		{
			if(sourceDevice.isProxy())
			{
				if(sourceDevice.getProxyFor() == null) return true;
			}
			else if(sourceDevice instanceof SensoryDevice)
				return true;
		}
		return false;
	}

	@Override
	public boolean canConnectFrom(ConnectableElement source)
	{
		if(source == null) return false;
		
		Device sourceDevice = null;
		if(source instanceof RoboidBlock)
			sourceDevice = ((RoboidBlock)source).getSourceDevice();
		else if(source instanceof DeviceElement)
			sourceDevice = ((DeviceElement)source).getDevice();
		if(sourceDevice == null) return false;
		
		if(getRoboid() == null) return false;
		List<Device> targetDevices = new ArrayList<Device>();
		getRoboid().collectAllDevices(targetDevices);
		for(Device targetDevice : targetDevices)
		{
			if(findDeviceElement(targetDevice) != null) continue;
			if(sourceDevice.isProxy())
			{
				if(sourceDevice.getClass().equals(targetDevice.getClass()) && sourceDevice.isDataTypeOf(targetDevice))
					return true;
			}
			else if(sourceDevice instanceof Sensor)
			{
				if(targetDevice instanceof Effector && sourceDevice.isDataTypeOf(targetDevice))
					return true;
			}
			else if(sourceDevice instanceof Event)
			{
				if(targetDevice instanceof Command && sourceDevice.isDataTypeOf(targetDevice))
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
	public void connectAll()
	{
		connectAll(getRoboid());
	}
	
	private void connectAll(Roboid roboid)
	{
		if(getDiagram() == null || roboid == null) return;
		
		for(Device sourceDevice : roboid.getDevices())
		{
			if(sourceDevice.isProxy())
				getDiagram().connect(sourceDevice, sourceDevice.getProxyFor(), true);
			else if(sourceDevice instanceof SensoryDevice)
			{
				for(MotoringDevice targetDevice : ((SensoryDevice)sourceDevice).getReceptors())
					getDiagram().connect(sourceDevice, targetDevice, false);
			}
		}
		
		for(Roboid child : roboid.getRoboids())
			connectAll(child);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Called when the parent roboid block is removed.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void disconnectAll()
	{
		if(getDiagram() == null) return;
		
		List<DeviceElement> elements = new ArrayList<DeviceElement>(getDevices());
		for(DeviceElement element : elements)
		{
			List<Association> associations = new ArrayList<Association>(element.getOutgoings());
			for(Association association : associations)
			{
				DeviceElement targetElement = (DeviceElement)association.getTarget();
				element.disconnectFrom(targetElement);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<String> collectAllDeviceNames(List<String> names)
	{
		return collectAllDeviceNames(names, getRoboid(), "");
	}
	
	/**
	 * @generated NOT
	 */
	private List<String> collectAllDeviceNames(List<String> names, Roboid roboid, String prefix)
	{
		for(Device device : roboid.getDevices())
			names.add(prefix + device.getName());
		
		for(Roboid child : roboid.getRoboids())
			collectAllDeviceNames(names, child, prefix + child.getName() + ".");
		return names;
	}
} //RoboidBlockImpl
