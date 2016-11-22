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

import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.ecore.EFactory;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.core.component.activity.ActivityPackage
 * @generated
 */
public interface ActivityFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityFactory eINSTANCE = org.roboid.core.component.activity.impl.ActivityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity</em>'.
	 * @generated
	 */
	Activity createActivity();

	/**
	 * Returns a new object of class '<em>Roboid Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roboid Activity</em>'.
	 * @generated
	 */
	RoboidActivity createRoboidActivity();

	/**
	 * Returns a new object of class '<em>Addon Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addon Activity</em>'.
	 * @generated
	 */
	AddonActivity createAddonActivity();

	/**
	 * Returns a new object of class '<em>System Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Activity</em>'.
	 * @generated
	 */
	SystemActivity createSystemActivity();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActivityPackage getActivityPackage();

	/**
	 * @generated NOT
	 */
	Activity createActivity(Robot robot);
	/**
	 * @generated NOT
	 */
	RoboidActivity createRoboidActivity(Roboid roboid);
	/**
	 * @generated NOT
	 */
	AddonActivity createAddonActivity(IExtension extension);
	/**
	 * @generated NOT
	 */
	SystemActivity createSystemActivity(IExtension extension);
} //ActivityFactory
