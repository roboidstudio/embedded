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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.robot.AccessType;
import org.roboid.robot.Device;
import org.roboid.robot.IoMode;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Port;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboid</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getUid <em>Uid</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getRoboids <em>Roboids</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getDevices <em>Devices</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getHostRoboid <em>Host Roboid</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RoboidImpl#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoboidImpl extends NamedElementImpl implements Roboid
{
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getUid() <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUid()
	 * @generated
	 * @ordered
	 */
	protected static final String UID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUid() <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUid()
	 * @generated
	 * @ordered
	 */
	protected String uid = UID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getRoboids() <em>Roboids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoboids()
	 * @generated
	 * @ordered
	 */
	protected EList<Roboid> roboids;
	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected Protocol protocol;
	/**
	 * The cached value of the '{@link #getDevices() <em>Devices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevices()
	 * @generated
	 * @ordered
	 */
	protected EList<Device> devices;
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0.0";
	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;
	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.ROBOID;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Roboid> getRoboids() {
		if (roboids == null) {
			roboids = new EObjectContainmentEList<Roboid>(Roboid.class, this, RobotPackage.ROBOID__ROBOIDS);
		}
		return roboids;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocol() {
		return protocol;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(Protocol newProtocol) {
		if (newProtocol != protocol) {
			NotificationChain msgs = null;
			if (protocol != null)
				msgs = ((InternalEObject)protocol).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobotPackage.ROBOID__PROTOCOL, null, msgs);
			if (newProtocol != null)
				msgs = ((InternalEObject)newProtocol).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobotPackage.ROBOID__PROTOCOL, null, msgs);
			msgs = basicSetProtocol(newProtocol, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__PROTOCOL, newProtocol, newProtocol));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProtocol(Protocol newProtocol, NotificationChain msgs) {
		Protocol oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__PROTOCOL, oldProtocol, newProtocol);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Device> getDevices() {
		if (devices == null) {
			devices = new EObjectContainmentEList<Device>(Device.class, this, RobotPackage.ROBOID__DEVICES);
		}
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUid()
	{
		return uid;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUid(String newUid) {
		String oldUid = uid;
		uid = newUid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__UID, oldUid, uid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress)
	{
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOID__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RobotPackage.ROBOID__ROBOIDS:
				return ((InternalEList<?>)getRoboids()).basicRemove(otherEnd, msgs);
			case RobotPackage.ROBOID__PROTOCOL:
				return basicSetProtocol(null, msgs);
			case RobotPackage.ROBOID__DEVICES:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotPackage.ROBOID__ID:
				return getId();
			case RobotPackage.ROBOID__UID:
				return getUid();
			case RobotPackage.ROBOID__ROBOIDS:
				return getRoboids();
			case RobotPackage.ROBOID__PROTOCOL:
				return getProtocol();
			case RobotPackage.ROBOID__DEVICES:
				return getDevices();
			case RobotPackage.ROBOID__VERSION:
				return getVersion();
			case RobotPackage.ROBOID__PROVIDER:
				return getProvider();
			case RobotPackage.ROBOID__HOST_ROBOID:
				return getHostRoboid();
			case RobotPackage.ROBOID__ADDRESS:
				return getAddress();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RobotPackage.ROBOID__ID:
				setId((String)newValue);
				return;
			case RobotPackage.ROBOID__UID:
				setUid((String)newValue);
				return;
			case RobotPackage.ROBOID__ROBOIDS:
				getRoboids().clear();
				getRoboids().addAll((Collection<? extends Roboid>)newValue);
				return;
			case RobotPackage.ROBOID__PROTOCOL:
				setProtocol((Protocol)newValue);
				return;
			case RobotPackage.ROBOID__DEVICES:
				getDevices().clear();
				getDevices().addAll((Collection<? extends Device>)newValue);
				return;
			case RobotPackage.ROBOID__VERSION:
				setVersion((String)newValue);
				return;
			case RobotPackage.ROBOID__PROVIDER:
				setProvider((String)newValue);
				return;
			case RobotPackage.ROBOID__ADDRESS:
				setAddress((String)newValue);
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
			case RobotPackage.ROBOID__ID:
				setId(ID_EDEFAULT);
				return;
			case RobotPackage.ROBOID__UID:
				setUid(UID_EDEFAULT);
				return;
			case RobotPackage.ROBOID__ROBOIDS:
				getRoboids().clear();
				return;
			case RobotPackage.ROBOID__PROTOCOL:
				setProtocol((Protocol)null);
				return;
			case RobotPackage.ROBOID__DEVICES:
				getDevices().clear();
				return;
			case RobotPackage.ROBOID__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RobotPackage.ROBOID__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case RobotPackage.ROBOID__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
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
			case RobotPackage.ROBOID__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case RobotPackage.ROBOID__UID:
				return UID_EDEFAULT == null ? uid != null : !UID_EDEFAULT.equals(uid);
			case RobotPackage.ROBOID__ROBOIDS:
				return roboids != null && !roboids.isEmpty();
			case RobotPackage.ROBOID__PROTOCOL:
				return protocol != null;
			case RobotPackage.ROBOID__DEVICES:
				return devices != null && !devices.isEmpty();
			case RobotPackage.ROBOID__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case RobotPackage.ROBOID__PROVIDER:
				return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
			case RobotPackage.ROBOID__HOST_ROBOID:
				return getHostRoboid() != null;
			case RobotPackage.ROBOID__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", uid: ");
		result.append(uid);
		result.append(", version: ");
		result.append(version);
		result.append(", provider: ");
		result.append(provider);
		result.append(", address: ");
		result.append(address);
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
	private boolean RECEIVE_FLAG;
	/**
	 * @generated NOT
	 */
	private boolean SEND_FLAG;
	


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload)
	{
		if(canSend())
		{
			deviceMap.write(1);
			
			for(Roboid roboid : getRoboids())
				roboid.getSimulacrum(deviceMap, payload);
			
			for(Device device : getDevices())
			{
				if(device.getAccess() != AccessType.PRIVATE)
					device.getSimulacrum(deviceMap, payload);
			}
		}
		else
		{
			deviceMap.write(0);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createDeviceMemory()
	{
		for(Device device : getDevices())
			device.createDeviceMemory();
		
		for(Roboid roboid : getRoboids())
			roboid.createDeviceMemory();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearDeviceMemory()
	{
		for(Device device : getDevices())
			device.clearDeviceMemory();
		
		for(Roboid roboid : getRoboids())
			roboid.clearDeviceMemory();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canSend()
	{
		for(Device device : getDevices())
		{
			SEND_FLAG = device.canSend();
			if(SEND_FLAG) return true;
		}
		
		for(Roboid roboid : getRoboids())
		{
			SEND_FLAG = roboid.canSend();
			if(SEND_FLAG) return true;
		}
		
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReceived()
	{
		return RECEIVE_FLAG;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int setDeviceMap(int index, byte[] deviceMap, boolean isMaster)
	{
		setMap(index, deviceMap);
		index ++;
		
		for(Roboid roboid : getRoboids())
			index = roboid.setDeviceMap(index, deviceMap, isMaster);
		
		for(Device device : getDevices())
		{
			if(device.getAccess() != AccessType.PRIVATE)
				index = device.setDeviceMap(index, deviceMap, isMaster);
		}
		
		return index;
	}
	
	/**
	 * @generated NOT
	 */
	private void setMap(int index, byte[] deviceMap)
	{
		int bytePos = index / 8;
		int bitPos = index % 8;
		int mask  = 0x80;
		mask >>>= bitPos;
		
		RECEIVE_FLAG = false;
		if((mask & deviceMap[bytePos]) != 0) RECEIVE_FLAG = true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
		if(isReceived())
		{
			for(Roboid roboid : getRoboids())
				roboid.setPayload(simulacrum, isMaster);
			
			for(Device device : getDevices())
			{
				if(device.getAccess() != AccessType.PRIVATE)
					device.setPayload(simulacrum, isMaster);
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateDeviceState()
	{
		for(Roboid roboid : getRoboids())
			roboid.updateDeviceState();
		for(Device device : getDevices())
			device.updateDeviceState();
	}
	
	/**
	 * internal use
	 * @generated NOT
	 */
	Robot getRobot()
	{
		NamedElement parent = getParent();
		while(true)
		{
			if(parent instanceof Robot)
				return (Robot)parent;
			parent = parent.getParent();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Roboid getHostRoboid()
	{
		EObject host = this.eContainer();
		if(host instanceof Roboid)
			return (Roboid)host;
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Device> collectAllDevices(List<Device> devices)
	{
		devices.addAll(getDevices());
		
		for(Roboid child : getRoboids())
			child.collectAllDevices(devices);
		
		return devices;
	}
	
	/**
	 * internal use
	 * @generated NOT
	 */
	List<String> collectAllDeviceNames(List<String> names, String prefix)
	{
		prefix += getName() + ".";
		
		//List up the self devices 
		for(Device device : getDevices())
			names.add(prefix + device.getName());
		
		//List up the device of child roboids
		//Attach prefix for name space
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllDeviceNames(names, prefix);
		return names;
	}
	
	List<String> collectAllActiveDeviceNames(List<String> names, String prefix)
	{
		prefix += getName() + ".";
		
		//List up the self devices 
		for(Device device : getDevices())
		{
			if(device instanceof Port)
			{
				if(((Port)device).getMode() != IoMode.NONE)
					names.add(prefix + device.getName());
			}
			else
				names.add(prefix + device.getName());
		}
		
		//List up the device of child roboids
		//Attach prefix for name space
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllActiveDeviceNames(names, prefix);
		return names;
	}
	
	/**
	 * internal use
	 * @generated NOT
	 */
	List<Roboid> collectAllChildRoboids(List<Roboid> roboids)
	{
		roboids.addAll(getRoboids());
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllChildRoboids(roboids);
		return roboids;
	}

	/**
	 * internal use
	 * @generated NOT
	 */
	private List<Roboid> collectChildRoboidsById(List<Roboid> roboids, String id)
	{
		if(id == null || id.isEmpty()) return roboids;
		
		for(Roboid child : getRoboids())
		{
			if(id.equalsIgnoreCase(child.getId()))
				roboids.add(child);
		}
		return roboids;
	}

	/**
	 * internal use
	 * @generated NOT
	 */
	List<Roboid> collectAllChildRoboidsById(List<Roboid> roboids, String id)
	{
		collectChildRoboidsById(roboids, id);
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllChildRoboidsById(roboids, id);
		return roboids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Device findDevice(String name)
	{
		if(name == null || name.isEmpty()) return null;
		
		int dot = name.indexOf(".");
		if(dot < 0)
		{
			for(Device device : getDevices())
			{
				if(name.equalsIgnoreCase(device.getName()))
				{
					if(device.isProxy())
						return device.getProxyFor();
					return device;
				}
			}
		}
		else
		{
			String roboidName = name.substring(0, dot);
			String subname = name.substring(dot + 1);
			for(Roboid child : getRoboids())
			{
				if(roboidName.equalsIgnoreCase(child.getName()))
					return child.findDevice(subname);
			} 
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Roboid findRoboid(String name)
	{
		if(name == null || name.isEmpty()) return null;
		
		int dot = name.indexOf(".");
		if(dot < 0)
		{
			for(Roboid child : getRoboids())
			{
				if(name.equalsIgnoreCase(child.getName())) 
					return child;
			}
		}
		else
		{
			String roboidName = name.substring(0, dot);
			String subname = name.substring(dot + 1);
			for(Roboid child : getRoboids())
			{
				if(roboidName.equalsIgnoreCase(child.getName()))
					return child.findRoboid(subname);
			} 
		}
		return null;
	}
	
//	/**
//	 * @generated NOT
//	 */
//	Roboid findRoboidByUid(String uid)
//	{
//		if(uid == null || uid.isEmpty()) return null;
//		
//		int pos = uid.indexOf("/");
//		if(pos < 0)
//		{
//			for(Roboid child : getRoboids())
//			{
//				if(uid.equalsIgnoreCase(child.getUid())) 
//					return child;
//			}
//		}
//		else
//		{
//			String roboidUid = uid.substring(0, pos);
//			String subuid = uid.substring(pos + 1);
//			for(Roboid child : getRoboids())
//			{
//				if(roboidUid.equalsIgnoreCase(child.getUid()))
//					return ((RoboidImpl)child).findRoboidByUid(subuid);
//			} 
//		}
//		return null;
//	}
	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void refreshChildRoboidUid(Roboid roboid)
//	{
//		if(roboid == null) return;
//		
//		String id = roboid.getId();
//		if(id == null || id.isEmpty()) return;
//		
//		List<Roboid> children = new ArrayList<Roboid>();
//		collectChildRoboidsById(children, id);
//		
//		int index = 0;
//		String prefix = id + ".";
//		for(Roboid child : children)
//			child.setUid(prefix + index++);
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void refreshChildRoboidUid(List<Roboid> roboids)
//	{
//		for(Roboid roboid : roboids)
//			refreshChildRoboidUid(roboid);
//	}
//	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void refreshUid(String newId, String oldId)
//	{
//		if(newId == null || newId.isEmpty()) return;
//		if(oldId == null || oldId.isEmpty()) return;
//		
//		List<Roboid> oldChildren = new ArrayList<Roboid>();
//		collectSiblingRoboidsById(oldChildren, oldId);
//		
//		int index = 0;
//		String prefix = oldId + ".";
//		for(Roboid child : oldChildren)
//			child.setUid(prefix + index++);
//		
//		List<Roboid> newChildren = new ArrayList<Roboid>();
//		collectSiblingRoboidsById(newChildren, newId);
//		
//		index = 0;
//		prefix = newId + ".";
//		for(Roboid child : newChildren)
//			child.setUid(prefix + index++);
//	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Roboid)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Roboid other = (Roboid)obj;
		if(getId() == null)
		{
			if(other.getId() != null) return false;
		}
		else if(!getId().equalsIgnoreCase(other.getId())) return false;
		if(getVersion() == null)
		{
			if(other.getVersion() != null) return false;
		}
		else if(!getVersion().equalsIgnoreCase(other.getVersion())) return false;
		if(getUid() == null)
		{
			if(other.getUid() != null) return false;
		}
		else if(!getUid().equalsIgnoreCase(other.getUid())) return false;
		if(getAddress() == null)
		{
			if(other.getAddress() != null) return false;
		}
		else if(!getAddress().equalsIgnoreCase(other.getAddress())) return false;
		if(getProvider() == null)
		{
			if(other.getProvider() != null) return false;
		}
		else if(!getProvider().equalsIgnoreCase(other.getProvider())) return false;
		if(getProtocol() == null)
		{
			if(other.getProtocol() != null) return false;
		}
		else if(!getProtocol().equalsContents(other.getProtocol())) return false;
		if(!equalsContents(getDevices(), other.getDevices())) return false;
		if(!equalsContents(getRoboids(), other.getRoboids())) return false;
		
		return true;
	}

	/**
	 * internal use
	 * @generated NOT
	 */
	public boolean equalsFullId(Roboid roboid)
	{
		if(roboid == null) return false;
		if(this == roboid) return true;
		
		if(getId() == null)
		{
			if(roboid.getId() != null) return false;
		}
		else if(!getId().equalsIgnoreCase(roboid.getId())) return false;
		
		NamedElement parent = getParent();
		NamedElement otherParent = roboid.getParent();
		if((parent instanceof Roboid) && (otherParent instanceof Roboid))
			return ((RoboidImpl)parent).equalsFullId((Roboid)otherParent);
		else if(!((parent instanceof Robot) && (otherParent instanceof Robot)))
			return false;
		return true;
	}

	/**
	 * internal use
	 * @generated NOT
	 */
	boolean equalsFullUid(Roboid roboid)
	{
		if(roboid == null) return false;
		if(this == roboid) return true;
		
		if(getUid() == null)
		{
			if(roboid.getUid() != null) return false;
		}
		else if(!getUid().equalsIgnoreCase(roboid.getUid())) return false;
		
		NamedElement parent = getParent();
		NamedElement otherParent = roboid.getParent();
		if((parent instanceof Roboid) && (otherParent instanceof Roboid))
			return ((RoboidImpl)parent).equalsFullUid((Roboid)otherParent);
		else if(!((parent instanceof Robot) && (otherParent instanceof Robot)))
			return false;
		return true;
	}
} //RoboidImpl
