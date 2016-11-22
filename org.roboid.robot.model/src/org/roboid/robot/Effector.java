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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effector</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.robot.Effector#getProxyFor <em>Proxy For</em>}</li>
 *   <li>{@link org.roboid.robot.Effector#getSustain <em>Sustain</em>}</li>
 *   <li>{@link org.roboid.robot.Effector#getThrottle <em>Throttle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.robot.RobotPackage#getEffector()
 * @model
 * @generated
 */
public interface Effector extends MotoringDevice {
	/**
	 * Returns the value of the '<em><b>Sustain</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sustain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sustain</em>' attribute.
	 * @see #setSustain(int)
	 * @see org.roboid.robot.RobotPackage#getEffector_Sustain()
	 * @model default="5"
	 * @generated
	 */
	int getSustain();

	/**
	 * Sets the value of the '{@link org.roboid.robot.Effector#getSustain <em>Sustain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sustain</em>' attribute.
	 * @see #getSustain()
	 * @generated
	 */
	void setSustain(int value);

	/**
	 * Returns the value of the '<em><b>Throttle</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throttle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throttle</em>' attribute.
	 * @see #setThrottle(int)
	 * @see org.roboid.robot.RobotPackage#getEffector_Throttle()
	 * @model default="1"
	 * @generated
	 */
	int getThrottle();

	/**
	 * Sets the value of the '{@link org.roboid.robot.Effector#getThrottle <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throttle</em>' attribute.
	 * @see #getThrottle()
	 * @generated
	 */
	void setThrottle(int value);

	/**
	 * Returns the value of the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy For</em>' reference.
	 * @see #setProxyFor(Effector)
	 * @see org.roboid.robot.RobotPackage#getEffector_ProxyFor()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Effector getProxyFor();

	/**
	 * Sets the value of the '{@link org.roboid.robot.Effector#getProxyFor <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy For</em>' reference.
	 * @see #getProxyFor()
	 * @generated
	 */
	void setProxyFor(Effector value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasNext();

} // Effector
