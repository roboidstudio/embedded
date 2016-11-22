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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.robot.Control;
import org.roboid.robot.Device;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Robot</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.RobotImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RobotImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RobotImpl#getRoboids <em>Roboids</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RobotImpl#getControls <em>Controls</em>}</li>
 *   <li>{@link org.roboid.robot.impl.RobotImpl#getStandard <em>Standard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RobotImpl extends NamedElementImpl implements Robot
{
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
	 * The cached value of the '{@link #getRoboids() <em>Roboids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoboids()
	 * @generated
	 * @ordered
	 */
	protected EList<Roboid> roboids;
	/**
	 * The cached value of the '{@link #getControls() <em>Controls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControls()
	 * @generated
	 * @ordered
	 */
	protected EList<Control> controls;
	/**
	 * The default value of the '{@link #getStandard() <em>Standard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandard()
	 * @generated
	 * @ordered
	 */
	protected static final String STANDARD_EDEFAULT = "RUPI 2.0";
	/**
	 * The cached value of the '{@link #getStandard() <em>Standard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandard()
	 * @generated
	 * @ordered
	 */
	protected String standard = STANDARD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RobotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.ROBOT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOT__PROVIDER, oldProvider, provider));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Roboid> getRoboids() {
		if (roboids == null) {
			roboids = new EObjectContainmentEList<Roboid>(Roboid.class, this, RobotPackage.ROBOT__ROBOIDS);
		}
		return roboids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Control> getControls() {
		if (controls == null) {
			controls = new EObjectContainmentEList<Control>(Control.class, this, RobotPackage.ROBOT__CONTROLS);
		}
		return controls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandard(String newStandard) {
		String oldStandard = standard;
		standard = newStandard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.ROBOT__STANDARD, oldStandard, standard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RobotPackage.ROBOT__ROBOIDS:
				return ((InternalEList<?>)getRoboids()).basicRemove(otherEnd, msgs);
			case RobotPackage.ROBOT__CONTROLS:
				return ((InternalEList<?>)getControls()).basicRemove(otherEnd, msgs);
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
			case RobotPackage.ROBOT__PROVIDER:
				return getProvider();
			case RobotPackage.ROBOT__VERSION:
				return getVersion();
			case RobotPackage.ROBOT__ROBOIDS:
				return getRoboids();
			case RobotPackage.ROBOT__CONTROLS:
				return getControls();
			case RobotPackage.ROBOT__STANDARD:
				return getStandard();
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
			case RobotPackage.ROBOT__PROVIDER:
				setProvider((String)newValue);
				return;
			case RobotPackage.ROBOT__VERSION:
				setVersion((String)newValue);
				return;
			case RobotPackage.ROBOT__ROBOIDS:
				getRoboids().clear();
				getRoboids().addAll((Collection<? extends Roboid>)newValue);
				return;
			case RobotPackage.ROBOT__CONTROLS:
				getControls().clear();
				getControls().addAll((Collection<? extends Control>)newValue);
				return;
			case RobotPackage.ROBOT__STANDARD:
				setStandard((String)newValue);
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
			case RobotPackage.ROBOT__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case RobotPackage.ROBOT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RobotPackage.ROBOT__ROBOIDS:
				getRoboids().clear();
				return;
			case RobotPackage.ROBOT__CONTROLS:
				getControls().clear();
				return;
			case RobotPackage.ROBOT__STANDARD:
				setStandard(STANDARD_EDEFAULT);
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
			case RobotPackage.ROBOT__PROVIDER:
				return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
			case RobotPackage.ROBOT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case RobotPackage.ROBOT__ROBOIDS:
				return roboids != null && !roboids.isEmpty();
			case RobotPackage.ROBOT__CONTROLS:
				return controls != null && !controls.isEmpty();
			case RobotPackage.ROBOT__STANDARD:
				return STANDARD_EDEFAULT == null ? standard != null : !STANDARD_EDEFAULT.equals(standard);
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
		result.append(" (provider: ");
		result.append(provider);
		result.append(", version: ");
		result.append(version);
		result.append(", standard: ");
		result.append(standard);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createDeviceMemory()
	{
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
		for(Roboid roboid : getRoboids())
			roboid.clearDeviceMemory();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Protocol getProtocol()
	{
		for(Roboid roboid : getRoboids())
		{
			if(roboid.getProtocol() != null)
				return roboid.getProtocol();
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Device> collectAllDevices(List<Device> devices)
	{
		for(Roboid child : getRoboids())
			child.collectAllDevices(devices);
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<String> collectAllDeviceNames(List<String> names)
	{
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllDeviceNames(names, "");
		return names;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> collectAllActiveDeviceNames(List<String> names)
	{
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllActiveDeviceNames(names, "");
		return names;
	}

	/**
	 * internal use
	 * @generated NOT
	 */
	private List<Roboid> collectRoboidsById(List<Roboid> roboids, String id)
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
	public List<Roboid> collectAllRoboids(List<Roboid> roboids)
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
	public List<Roboid> collectAllRoboidsById(List<Roboid> roboids, String id)
	{
		collectRoboidsById(roboids, id);
		for(Roboid child : getRoboids())
			((RoboidImpl)child).collectAllChildRoboidsById(roboids, id);
		return roboids;
	}
	
//	/**
//	 * @generated NOT
//	 */
//	List<Control> collectControls(List<Control> controls, Roboid roboid)
//	{
//		if(roboid == null) return controls;
//		
//		for(Control control : getControls())
//		{
//			if(control.getRootRoboid() == roboid)
//				controls.add(control);
//		}
//		return controls;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Device findDevice(String name)
	{
		if(name == null || name.isEmpty()) return null;
		
		int dot = name.indexOf(".");
		if(dot < 0) return null;
		
		String roboidName = name.substring(0, dot);
		String subname = name.substring(dot + 1);
		for(Roboid child : getRoboids())
		{
			if(roboidName.equalsIgnoreCase(child.getName()))
				return child.findDevice(subname);
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
//	public void refreshRoboidUid(Roboid roboid)
//	{
//		if(roboid == null) return;
//		
//		String id = roboid.getId();
//		if(id == null || id.isEmpty()) return;
//		
//		List<Roboid> children = new ArrayList<Roboid>();
//		collectRoboidsById(children, id);
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
//	public void refreshRoboidUid(List<Roboid> roboids)
//	{
//		for(Roboid roboid : roboids)
//			refreshRoboidUid(roboid);
//	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Robot)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Robot other = (Robot)obj;
		if(getVersion() == null)
		{
			if(other.getVersion() != null) return false;
		}
		else if(!getVersion().equalsIgnoreCase(other.getVersion())) return false;
		if(getProvider() == null)
		{
			if(other.getProvider() != null) return false;
		}
		else if(!getProvider().equalsIgnoreCase(other.getProvider())) return false;
		if(getStandard() == null)
		{
			if(other.getStandard() != null) return false;
		}
		else if(!getStandard().equalsIgnoreCase(other.getStandard())) return false;
		if(!equalsContents(getRoboids(), other.getRoboids())) return false;
		if(!equalsContents(getControls(), other.getControls())) return false;
		
		return true;
	}
} //RobotImpl
