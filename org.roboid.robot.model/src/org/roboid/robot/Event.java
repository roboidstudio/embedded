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

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.robot.Event#getProxyFor <em>Proxy For</em>}</li>
 *   <li>{@link org.roboid.robot.Event#getReceptors <em>Receptors</em>}</li>
 *   <li>{@link org.roboid.robot.Event#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.robot.RobotPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends SensoryDevice {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see org.roboid.robot.RobotPackage#getEvent_Id()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	int getId();

	/**
	 * Returns the value of the '<em><b>Receptors</b></em>' reference list.
	 * The list contents are of type {@link org.roboid.robot.Command}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receptors</em>' reference list.
	 * @see org.roboid.robot.RobotPackage#getEvent_Receptors()
	 * @model resolveProxies="false"
	 * @generated
	 */
	List<Command> getReceptors();

	/**
	 * Returns the value of the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy For</em>' reference.
	 * @see #setProxyFor(Event)
	 * @see org.roboid.robot.RobotPackage#getEvent_ProxyFor()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Event getProxyFor();

	/**
	 * Sets the value of the '{@link org.roboid.robot.Event#getProxyFor <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy For</em>' reference.
	 * @see #getProxyFor()
	 * @generated
	 */
	void setProxyFor(Event value);

} // Event
