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

package org.roboid.core.component.activity;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roboid Activity</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.core.component.activity.RoboidActivity#getRoboids <em>Roboids</em>}</li>
 *   <li>{@link org.roboid.core.component.activity.RoboidActivity#getAddons <em>Addons</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.core.component.activity.ActivityPackage#getRoboidActivity()
 * @model
 * @generated
 */
public interface RoboidActivity extends AbstractActivity
{
	/**
	 * Returns the value of the '<em><b>Roboids</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.core.component.activity.RoboidActivity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roboids</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roboids</em>' containment reference list.
	 * @see org.roboid.core.component.activity.ActivityPackage#getRoboidActivity_Roboids()
	 * @model containment="true" changeable="false"
	 * @generated
	 */
	List<RoboidActivity> getRoboids();

	/**
	 * Returns the value of the '<em><b>Addons</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.core.component.activity.AddonActivity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addons</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addons</em>' containment reference list.
	 * @see org.roboid.core.component.activity.ActivityPackage#getRoboidActivity_Addons()
	 * @model containment="true" changeable="false"
	 * @generated
	 */
	List<AddonActivity> getAddons();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addChild(RoboidActivity child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addChild(AddonActivity child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeChild(RoboidActivity child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeChild(AddonActivity child);

} // RoboidActivity
