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
import org.roboid.robot.Channel;
import org.roboid.robot.Control;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.ControlImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.roboid.robot.impl.ControlImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.roboid.robot.impl.ControlImpl#getFrameLimit <em>Frame Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlImpl extends NamedElementImpl implements Control
{
	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected EList<Channel> channels;

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
	 * The default value of the '{@link #getFrameLimit() <em>Frame Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int FRAME_LIMIT_EDEFAULT = 9999;

	/**
	 * The cached value of the '{@link #getFrameLimit() <em>Frame Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameLimit()
	 * @generated
	 * @ordered
	 */
	protected int frameLimit = FRAME_LIMIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlImpl()
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
		return RobotPackage.Literals.CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Channel> getChannels()
	{
		if (channels == null) {
			channels = new EObjectContainmentEList<Channel>(Channel.class, this, RobotPackage.CONTROL__CHANNELS);
		}
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion)
	{
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.CONTROL__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrameLimit()
	{
		return frameLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameLimit(int newFrameLimit)
	{
		int oldFrameLimit = frameLimit;
		frameLimit = newFrameLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.CONTROL__FRAME_LIMIT, oldFrameLimit, frameLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case RobotPackage.CONTROL__CHANNELS:
				return ((InternalEList<?>)getChannels()).basicRemove(otherEnd, msgs);
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
			case RobotPackage.CONTROL__CHANNELS:
				return getChannels();
			case RobotPackage.CONTROL__VERSION:
				return getVersion();
			case RobotPackage.CONTROL__FRAME_LIMIT:
				return getFrameLimit();
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
			case RobotPackage.CONTROL__CHANNELS:
				getChannels().clear();
				getChannels().addAll((Collection<? extends Channel>)newValue);
				return;
			case RobotPackage.CONTROL__VERSION:
				setVersion((String)newValue);
				return;
			case RobotPackage.CONTROL__FRAME_LIMIT:
				setFrameLimit((Integer)newValue);
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
			case RobotPackage.CONTROL__CHANNELS:
				getChannels().clear();
				return;
			case RobotPackage.CONTROL__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RobotPackage.CONTROL__FRAME_LIMIT:
				setFrameLimit(FRAME_LIMIT_EDEFAULT);
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
			case RobotPackage.CONTROL__CHANNELS:
				return channels != null && !channels.isEmpty();
			case RobotPackage.CONTROL__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case RobotPackage.CONTROL__FRAME_LIMIT:
				return frameLimit != FRAME_LIMIT_EDEFAULT;
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
		result.append(" (version: ");
		result.append(version);
		result.append(", frameLimit: ");
		result.append(frameLimit);
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
		if(!(obj instanceof Control)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Control other = (Control)obj;
		if(getVersion() == null)
		{
			if(other.getVersion() != null) return false;
		}
		else if(!getVersion().equalsIgnoreCase(other.getVersion())) return false;
		if(getFrameLimit() != other.getFrameLimit()) return false;
		if(!equalsContents(getChannels(), other.getChannels())) return false;
		
		return true;
	}
	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public Roboid getRoboid()
//	{
//		for(Channel channel : getChannels())
//		{
//			for(Device device : channel.getDevices())
//			{
//				Roboid roboid = (Roboid)device.getParent();
//				if(roboid != null) return roboid;
//			}
//		}
//		return null;
//	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public Roboid getRootRoboid()
//	{
//		for(Channel channel : getChannels())
//		{
//			for(Device device : channel.getDevices())
//			{
//				Roboid roboid = device.getRootRoboid();
//				if(roboid != null) return roboid;
//			}
//		}
//		return null;
//	}
} //ControlImpl
