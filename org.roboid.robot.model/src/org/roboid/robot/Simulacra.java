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

package org.roboid.robot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulacra</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 *
 * @see org.roboid.robot.RobotPackage#getSimulacra()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Simulacra {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int setDeviceMap(int index, byte[] deviceMap, boolean isMaster);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model simulacrumDataType="org.roboid.robot.ByteArrayInputStream"
	 * @generated
	 */
	void setPayload(ByteArrayInputStream simulacrum, boolean isMaster);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model deviceMapDataType="org.roboid.robot.ByteArrayOutputStream" payloadDataType="org.roboid.robot.ByteArrayOutputStream"
	 * @generated
	 */
	void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isReceived();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canSend();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void updateDeviceState();

} // Simulacra
