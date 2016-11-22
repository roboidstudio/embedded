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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.core.component.activity.ActivityFactory
 * @model kind="package"
 * @generated
 */
public interface ActivityPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "activity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.roboidstudio.org/model/component";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.roboid.component";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityPackage eINSTANCE = org.roboid.core.component.activity.impl.ActivityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.roboid.core.component.activity.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.activity.impl.ActivityImpl
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 0;

	/**
	 * The feature id for the '<em><b>Roboids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ROBOIDS = 0;

	/**
	 * The feature id for the '<em><b>Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__SYSTEMS = 1;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.roboid.core.component.activity.impl.AbstractActivityImpl <em>Abstract Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.activity.impl.AbstractActivityImpl
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getAbstractActivity()
	 * @generated
	 */
	int ABSTRACT_ACTIVITY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__ID = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__ENABLED = 1;

	/**
	 * The number of structural features of the '<em>Abstract Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.roboid.core.component.activity.impl.RoboidActivityImpl <em>Roboid Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.activity.impl.RoboidActivityImpl
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getRoboidActivity()
	 * @generated
	 */
	int ROBOID_ACTIVITY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_ACTIVITY__ID = ABSTRACT_ACTIVITY__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_ACTIVITY__ENABLED = ABSTRACT_ACTIVITY__ENABLED;

	/**
	 * The feature id for the '<em><b>Roboids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_ACTIVITY__ROBOIDS = ABSTRACT_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Addons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_ACTIVITY__ADDONS = ABSTRACT_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Roboid Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_ACTIVITY_FEATURE_COUNT = ABSTRACT_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.core.component.activity.impl.AddonActivityImpl <em>Addon Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.activity.impl.AddonActivityImpl
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getAddonActivity()
	 * @generated
	 */
	int ADDON_ACTIVITY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON_ACTIVITY__ID = ABSTRACT_ACTIVITY__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON_ACTIVITY__ENABLED = ABSTRACT_ACTIVITY__ENABLED;

	/**
	 * The number of structural features of the '<em>Addon Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDON_ACTIVITY_FEATURE_COUNT = ABSTRACT_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.core.component.activity.impl.SystemActivityImpl <em>System Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.activity.impl.SystemActivityImpl
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getSystemActivity()
	 * @generated
	 */
	int SYSTEM_ACTIVITY = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ACTIVITY__ID = ABSTRACT_ACTIVITY__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ACTIVITY__ENABLED = ABSTRACT_ACTIVITY__ENABLED;

	/**
	 * The number of structural features of the '<em>System Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_ACTIVITY_FEATURE_COUNT = ABSTRACT_ACTIVITY_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '<em>Robot</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.Robot
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getRobot()
	 * @generated
	 */
	int ROBOT = 5;

	/**
	 * The meta object id for the '<em>IComponent</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.IComponent
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getIComponent()
	 * @generated
	 */
	int ICOMPONENT = 6;


	/**
	 * The meta object id for the '<em>Abstract Component Proxy</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.component.proxy.AbstractComponentProxy
	 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getAbstractComponentProxy()
	 * @generated
	 */
	int ABSTRACT_COMPONENT_PROXY = 7;


	/**
	 * Returns the meta object for class '{@link org.roboid.core.component.activity.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see org.roboid.core.component.activity.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.core.component.activity.Activity#getRoboids <em>Roboids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roboids</em>'.
	 * @see org.roboid.core.component.activity.Activity#getRoboids()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Roboids();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.core.component.activity.Activity#getSystems <em>Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Systems</em>'.
	 * @see org.roboid.core.component.activity.Activity#getSystems()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Systems();

	/**
	 * Returns the meta object for class '{@link org.roboid.core.component.activity.AbstractActivity <em>Abstract Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Activity</em>'.
	 * @see org.roboid.core.component.activity.AbstractActivity
	 * @generated
	 */
	EClass getAbstractActivity();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.core.component.activity.AbstractActivity#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.roboid.core.component.activity.AbstractActivity#getId()
	 * @see #getAbstractActivity()
	 * @generated
	 */
	EAttribute getAbstractActivity_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.core.component.activity.AbstractActivity#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.roboid.core.component.activity.AbstractActivity#isEnabled()
	 * @see #getAbstractActivity()
	 * @generated
	 */
	EAttribute getAbstractActivity_Enabled();

	/**
	 * Returns the meta object for class '{@link org.roboid.core.component.activity.RoboidActivity <em>Roboid Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboid Activity</em>'.
	 * @see org.roboid.core.component.activity.RoboidActivity
	 * @generated
	 */
	EClass getRoboidActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.core.component.activity.RoboidActivity#getRoboids <em>Roboids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roboids</em>'.
	 * @see org.roboid.core.component.activity.RoboidActivity#getRoboids()
	 * @see #getRoboidActivity()
	 * @generated
	 */
	EReference getRoboidActivity_Roboids();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.core.component.activity.RoboidActivity#getAddons <em>Addons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Addons</em>'.
	 * @see org.roboid.core.component.activity.RoboidActivity#getAddons()
	 * @see #getRoboidActivity()
	 * @generated
	 */
	EReference getRoboidActivity_Addons();

	/**
	 * Returns the meta object for class '{@link org.roboid.core.component.activity.AddonActivity <em>Addon Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addon Activity</em>'.
	 * @see org.roboid.core.component.activity.AddonActivity
	 * @generated
	 */
	EClass getAddonActivity();

	/**
	 * Returns the meta object for class '{@link org.roboid.core.component.activity.SystemActivity <em>System Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Activity</em>'.
	 * @see org.roboid.core.component.activity.SystemActivity
	 * @generated
	 */
	EClass getSystemActivity();

	/**
	 * Returns the meta object for data type '{@link org.roboid.robot.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Robot</em>'.
	 * @see org.roboid.robot.Robot
	 * @model instanceClass="org.roboid.robot.Robot"
	 * @generated
	 */
	EDataType getRobot();

	/**
	 * Returns the meta object for data type '{@link org.roboid.core.component.IComponent <em>IComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IComponent</em>'.
	 * @see org.roboid.core.component.IComponent
	 * @model instanceClass="org.roboid.core.component.IComponent"
	 * @generated
	 */
	EDataType getIComponent();

	/**
	 * Returns the meta object for data type '{@link org.roboid.core.component.proxy.AbstractComponentProxy <em>Abstract Component Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Abstract Component Proxy</em>'.
	 * @see org.roboid.core.component.proxy.AbstractComponentProxy
	 * @model instanceClass="org.roboid.core.component.proxy.AbstractComponentProxy"
	 * @generated
	 */
	EDataType getAbstractComponentProxy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivityFactory getActivityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.roboid.core.component.activity.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.activity.impl.ActivityImpl
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Roboids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__ROBOIDS = eINSTANCE.getActivity_Roboids();

		/**
		 * The meta object literal for the '<em><b>Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__SYSTEMS = eINSTANCE.getActivity_Systems();

		/**
		 * The meta object literal for the '{@link org.roboid.core.component.activity.impl.AbstractActivityImpl <em>Abstract Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.activity.impl.AbstractActivityImpl
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getAbstractActivity()
		 * @generated
		 */
		EClass ABSTRACT_ACTIVITY = eINSTANCE.getAbstractActivity();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ACTIVITY__ID = eINSTANCE.getAbstractActivity_Id();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ACTIVITY__ENABLED = eINSTANCE.getAbstractActivity_Enabled();

		/**
		 * The meta object literal for the '{@link org.roboid.core.component.activity.impl.RoboidActivityImpl <em>Roboid Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.activity.impl.RoboidActivityImpl
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getRoboidActivity()
		 * @generated
		 */
		EClass ROBOID_ACTIVITY = eINSTANCE.getRoboidActivity();

		/**
		 * The meta object literal for the '<em><b>Roboids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID_ACTIVITY__ROBOIDS = eINSTANCE.getRoboidActivity_Roboids();

		/**
		 * The meta object literal for the '<em><b>Addons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID_ACTIVITY__ADDONS = eINSTANCE.getRoboidActivity_Addons();

		/**
		 * The meta object literal for the '{@link org.roboid.core.component.activity.impl.AddonActivityImpl <em>Addon Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.activity.impl.AddonActivityImpl
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getAddonActivity()
		 * @generated
		 */
		EClass ADDON_ACTIVITY = eINSTANCE.getAddonActivity();

		/**
		 * The meta object literal for the '{@link org.roboid.core.component.activity.impl.SystemActivityImpl <em>System Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.activity.impl.SystemActivityImpl
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getSystemActivity()
		 * @generated
		 */
		EClass SYSTEM_ACTIVITY = eINSTANCE.getSystemActivity();

		/**
		 * The meta object literal for the '<em>Robot</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.Robot
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getRobot()
		 * @generated
		 */
		EDataType ROBOT = eINSTANCE.getRobot();

		/**
		 * The meta object literal for the '<em>IComponent</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.IComponent
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getIComponent()
		 * @generated
		 */
		EDataType ICOMPONENT = eINSTANCE.getIComponent();

		/**
		 * The meta object literal for the '<em>Abstract Component Proxy</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.component.proxy.AbstractComponentProxy
		 * @see org.roboid.core.component.activity.impl.ActivityPackageImpl#getAbstractComponentProxy()
		 * @generated
		 */
		EDataType ABSTRACT_COMPONENT_PROXY = eINSTANCE.getAbstractComponentProxy();

	}

} //ActivityPackage
