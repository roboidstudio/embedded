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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.roboid.robot.Command;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.Event;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.EventImpl#getProxyFor <em>Proxy For</em>}</li>
 *   <li>{@link org.roboid.robot.impl.EventImpl#getReceptors <em>Receptors</em>}</li>
 *   <li>{@link org.roboid.robot.impl.EventImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventImpl extends SensoryDeviceImpl implements Event
{
	/**
	 * The cached value of the '{@link #getProxyFor() <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyFor()
	 * @generated
	 * @ordered
	 */
	protected Event proxyFor;
	/**
	 * The cached value of the '{@link #getReceptors() <em>Receptors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceptors()
	 * @generated
	 * @ordered
	 */
	protected EList<Command> receptors;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl()
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
		return RobotPackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyFor(Event newProxyFor)
	{
		Event oldProxyFor = proxyFor;
		proxyFor = newProxyFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.EVENT__PROXY_FOR, oldProxyFor, proxyFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotPackage.EVENT__PROXY_FOR:
				return getProxyFor();
			case RobotPackage.EVENT__RECEPTORS:
				return getReceptors();
			case RobotPackage.EVENT__ID:
				return getId();
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
			case RobotPackage.EVENT__PROXY_FOR:
				setProxyFor((Event)newValue);
				return;
			case RobotPackage.EVENT__RECEPTORS:
				getReceptors().clear();
				getReceptors().addAll((Collection<? extends Command>)newValue);
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
			case RobotPackage.EVENT__PROXY_FOR:
				setProxyFor((Event)null);
				return;
			case RobotPackage.EVENT__RECEPTORS:
				getReceptors().clear();
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
			case RobotPackage.EVENT__PROXY_FOR:
				return proxyFor != null;
			case RobotPackage.EVENT__RECEPTORS:
				return receptors != null && !receptors.isEmpty();
			case RobotPackage.EVENT__ID:
				return id != ID_EDEFAULT;
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
		if(!(obj instanceof Event)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Event other = (Event)obj;
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
	public Event getProxyFor()
	{
		return isProxy() ? proxyFor : null;
	}
	
	/**
	 * @generated NOT
	 */
	public void setProxyFor(Device newProxyFor)
	{
		if(newProxyFor == null || newProxyFor instanceof Event)
			setProxyFor((Event)newProxyFor);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Command> getReceptors()
	{
		if(isProxy())
		{
			List<Command> list = Collections.emptyList();
			return list;
		}
		
		if (receptors == null)
		{
			receptors = new EObjectEList<Command>(Command.class, this, RobotPackage.EVENT__RECEPTORS);
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
		if(receptor instanceof Command)
			getReceptors().add((Command)receptor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeReceptor(Device receptor)
	{
		if(isProxy()) return;
		if(receptor instanceof Command)
			getReceptors().remove((Command)receptor);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload)
	{
		if(canSend())
			payload.write(id);
		super.getSimulacrum(deviceMap, payload);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void setFired()
	{
		super.setFired();
		id = (id+1) & 0xff;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
		if(isReceived())
		{
			int newEvent = simulacrum.read();
			super.setPayload(simulacrum, isMaster, newEvent == id);
			
			if(newEvent != id)
			{
				id = newEvent;
				super.setFired();
				for(DeviceListener listener : getDeviceListeners())
					listener.handleEvent(this);
			}
		}
	}
} //EventImpl
