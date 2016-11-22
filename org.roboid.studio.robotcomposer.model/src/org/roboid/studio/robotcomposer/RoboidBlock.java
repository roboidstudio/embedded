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

import java.util.List;

import org.roboid.robot.Device;
import org.roboid.robot.Roboid;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roboid Block</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.robotcomposer.RoboidBlock#getX <em>X</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.RoboidBlock#getY <em>Y</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.RoboidBlock#getRoboid <em>Roboid</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.RoboidBlock#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRoboidBlock()
 * @model
 * @generated
 */
public interface RoboidBlock extends ConnectableElement
{
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRoboidBlock_X()
	 * @model default="-1"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.roboid.studio.robotcomposer.RoboidBlock#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRoboidBlock_Y()
	 * @model default="-1"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.roboid.studio.robotcomposer.RoboidBlock#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Roboid</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roboid</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roboid</em>' reference.
	 * @see #setRoboid(Roboid)
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRoboidBlock_Roboid()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Roboid getRoboid();

	/**
	 * Sets the value of the '{@link org.roboid.studio.robotcomposer.RoboidBlock#getRoboid <em>Roboid</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Roboid</em>' reference.
	 * @see #getRoboid()
	 * @generated
	 */
	void setRoboid(Roboid value);

	/**
	 * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.studio.robotcomposer.DeviceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Devices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Devices</em>' containment reference list.
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRoboidBlock_Devices()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	List<DeviceElement> getDevices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addChild(DeviceElement child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeChild(DeviceElement child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeAllChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model namesMany="true"
	 * @generated
	 */
	List<String> collectAllDeviceNames(List<String> names);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RoboidBlock deepCopy(RobotDiagram newDiagram);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DeviceElement createDeviceElement(Device device);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DeviceElement getDeviceElement(Device device);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DeviceElement findDeviceElement(Device device);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Device getSourceDevice();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSourceDevice(Device device);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canDelete();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canCopy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canCut();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void connectAll();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void disconnectAll();

} // RoboidBlock
