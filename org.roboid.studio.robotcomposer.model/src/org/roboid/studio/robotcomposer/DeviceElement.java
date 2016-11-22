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

package org.roboid.studio.robotcomposer;

import org.roboid.robot.Device;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device Element</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.robotcomposer.DeviceElement#getDevice <em>Device</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getDeviceElement()
 * @model
 * @generated
 */
public interface DeviceElement extends ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' reference.
	 * @see #setDevice(Device)
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getDeviceElement_Device()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Device getDevice();

	/**
	 * Sets the value of the '{@link org.roboid.studio.robotcomposer.DeviceElement#getDevice <em>Device</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(Device value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isConnectedTo(Device targetDevice);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void connectTo(DeviceElement targetElement, boolean isProxy);

	/**
	 * <!-- begin-user-doc -->
	 * Called when the proxyFor or receptor of a device is added.
	 * The root roboid of the argument should exist.
	 * @param targetDevice a target device
	 * @param isProxy connection type
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void connectTo(Device targetDevice, boolean isProxy);

	/**
	 * <!-- begin-user-doc -->
	 * Called when the parent roboid block is removed.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void disconnectFrom(DeviceElement targetElement);

	/**
	 * <!-- begin-user-doc -->
	 * Called when the proxyFor or receptor of a device is removed.
	 * The root roboid of the argument should exist.
	 * @param targetDevice a target device
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void disconnectFrom(Device targetDevice);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reconnectTo(Device oldTargetDevice, Device newTargetDevice);

} // DeviceElement
