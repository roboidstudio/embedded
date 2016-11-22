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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.roboid.robot.Device;
import org.roboid.robot.Effector;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.Sensor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sensor</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.SensorImpl#getProxyFor <em>Proxy For</em>}</li>
 *   <li>{@link org.roboid.robot.impl.SensorImpl#getReceptors <em>Receptors</em>}</li>
 *   <li>{@link org.roboid.robot.impl.SensorImpl#getThrottle <em>Throttle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SensorImpl extends SensoryDeviceImpl implements Sensor
{
	/**
	 * The cached value of the '{@link #getProxyFor() <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyFor()
	 * @generated
	 * @ordered
	 */
	protected Sensor proxyFor;

	/**
	 * The cached value of the '{@link #getReceptors() <em>Receptors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptors()
	 * @generated
	 * @ordered
	 */
	protected EList<Effector> receptors;

	/**
	 * The default value of the '{@link #getThrottle() <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottle()
	 * @generated
	 * @ordered
	 */
	protected static final int THROTTLE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getThrottle() <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottle()
	 * @generated
	 * @ordered
	 */
	protected int throttle = THROTTLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensorImpl()
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
		return RobotPackage.Literals.SENSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getThrottle()
	{
		return throttle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottle(int newThrottle)
	{
		int oldThrottle = throttle;
		throttle = newThrottle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.SENSOR__THROTTLE, oldThrottle, throttle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyFor(Sensor newProxyFor)
	{
		Sensor oldProxyFor = proxyFor;
		proxyFor = newProxyFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.SENSOR__PROXY_FOR, oldProxyFor, proxyFor));
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
			case RobotPackage.SENSOR__PROXY_FOR:
				return getProxyFor();
			case RobotPackage.SENSOR__RECEPTORS:
				return getReceptors();
			case RobotPackage.SENSOR__THROTTLE:
				return getThrottle();
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
			case RobotPackage.SENSOR__PROXY_FOR:
				setProxyFor((Sensor)newValue);
				return;
			case RobotPackage.SENSOR__RECEPTORS:
				getReceptors().clear();
				getReceptors().addAll((Collection<? extends Effector>)newValue);
				return;
			case RobotPackage.SENSOR__THROTTLE:
				setThrottle((Integer)newValue);
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
			case RobotPackage.SENSOR__PROXY_FOR:
				setProxyFor((Sensor)null);
				return;
			case RobotPackage.SENSOR__RECEPTORS:
				getReceptors().clear();
				return;
			case RobotPackage.SENSOR__THROTTLE:
				setThrottle(THROTTLE_EDEFAULT);
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
			case RobotPackage.SENSOR__PROXY_FOR:
				return proxyFor != null;
			case RobotPackage.SENSOR__RECEPTORS:
				return receptors != null && !receptors.isEmpty();
			case RobotPackage.SENSOR__THROTTLE:
				return throttle != THROTTLE_EDEFAULT;
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
		result.append(" (throttle: ");
		result.append(throttle);
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
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Sensor)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Sensor other = (Sensor)obj;
		if(getThrottle() != other.getThrottle()) return false;
		if(isProxy())
		{
			if(!equalsProxyContents(getProxyFor(), other.getProxyFor())) return false;
		}
		else
		{
			if(!equalsReceptorsContents(getReceptors(), other.getReceptors())) return false;
		}
		
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Sensor getProxyFor()
	{
		return isProxy() ? proxyFor : null;
	}
	
	/**
	 * @generated NOT
	 */
	public void setProxyFor(Device newProxyFor)
	{
		if(newProxyFor == null || newProxyFor instanceof Sensor)
			setProxyFor((Sensor)newProxyFor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Effector> getReceptors()
	{
		if(isProxy())
		{
			List<Effector> list = Collections.emptyList();
			return list;
		}
		
		if (receptors == null)
		{
			receptors = new EObjectEList<Effector>(Effector.class, this, RobotPackage.SENSOR__RECEPTORS);
		}
		return receptors;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addReceptor(Device receptor)
	{
		if(isProxy()) return;
		if(receptor instanceof Effector)
			getReceptors().add((Effector)receptor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeReceptor(Device receptor)
	{
		if(isProxy()) return;
		if(receptor instanceof Effector)
			getReceptors().remove((Effector)receptor);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
		if(isReceived())
		{
			super.setPayload(simulacrum, isMaster);
			super.setFired();
		}
	}
} //SensorImpl
