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

package org.roboid.core.component.activity.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.roboid.core.component.IComponent;
import org.roboid.core.component.activity.AbstractActivity;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.AddonActivity;
import org.roboid.core.component.activity.RoboidActivity;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.core.component.proxy.AbstractComponentProxy;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityPackageImpl extends EPackageImpl implements ActivityPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboidActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addonActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType robotEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iComponentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType abstractComponentProxyEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.roboid.core.component.activity.ActivityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActivityPackageImpl()
	{
		super(eNS_URI, ActivityFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ActivityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActivityPackage init()
	{
		if (isInited) return (ActivityPackage)EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI);

		// Obtain or create and register package
		ActivityPackageImpl theActivityPackage = (ActivityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActivityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActivityPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theActivityPackage.createPackageContents();

		// Initialize created meta-data
		theActivityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActivityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActivityPackage.eNS_URI, theActivityPackage);
		return theActivityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity()
	{
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Roboids()
	{
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Systems()
	{
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractActivity()
	{
		return abstractActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractActivity_Id()
	{
		return (EAttribute)abstractActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractActivity_Enabled()
	{
		return (EAttribute)abstractActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboidActivity()
	{
		return roboidActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboidActivity_Roboids()
	{
		return (EReference)roboidActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboidActivity_Addons()
	{
		return (EReference)roboidActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddonActivity()
	{
		return addonActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemActivity()
	{
		return systemActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRobot()
	{
		return robotEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIComponent()
	{
		return iComponentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAbstractComponentProxy()
	{
		return abstractComponentProxyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityFactory getActivityFactory()
	{
		return (ActivityFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__ROBOIDS);
		createEReference(activityEClass, ACTIVITY__SYSTEMS);

		abstractActivityEClass = createEClass(ABSTRACT_ACTIVITY);
		createEAttribute(abstractActivityEClass, ABSTRACT_ACTIVITY__ID);
		createEAttribute(abstractActivityEClass, ABSTRACT_ACTIVITY__ENABLED);

		roboidActivityEClass = createEClass(ROBOID_ACTIVITY);
		createEReference(roboidActivityEClass, ROBOID_ACTIVITY__ROBOIDS);
		createEReference(roboidActivityEClass, ROBOID_ACTIVITY__ADDONS);

		addonActivityEClass = createEClass(ADDON_ACTIVITY);

		systemActivityEClass = createEClass(SYSTEM_ACTIVITY);

		// Create data types
		robotEDataType = createEDataType(ROBOT);
		iComponentEDataType = createEDataType(ICOMPONENT);
		abstractComponentProxyEDataType = createEDataType(ABSTRACT_COMPONENT_PROXY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		roboidActivityEClass.getESuperTypes().add(this.getAbstractActivity());
		addonActivityEClass.getESuperTypes().add(this.getAbstractActivity());
		systemActivityEClass.getESuperTypes().add(this.getAbstractActivity());

		// Initialize classes and features; add operations and parameters
		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_Roboids(), this.getRoboidActivity(), null, "roboids", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_Systems(), this.getSystemActivity(), null, "systems", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(activityEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRoboidActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(activityEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(activityEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRoboidActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(activityEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(activityEClass, null, "removeChildren", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemActivity(), "children", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "initializeComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "disposeComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "activateComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "deactivateComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "executeComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "realizeComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, ecorePackage.getEBoolean(), "isComponentsReady", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(activityEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRobot(), "robot", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "refresh", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(activityEClass, null, "updateReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActivity(), "reference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRobot(), "robot", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(abstractActivityEClass, AbstractActivity.class, "AbstractActivity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractActivity_Id(), ecorePackage.getEString(), "id", null, 0, 1, AbstractActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractActivity_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, AbstractActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(abstractActivityEClass, ecorePackage.getEBoolean(), "canChangeEnabled", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractActivityEClass, ecorePackage.getEInt(), "countComponents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractActivityEClass, this.getIComponent(), "getSelectedComponent", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractActivityEClass, ecorePackage.getEInt(), "getSelectedComponentIndex", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractActivityEClass, this.getAbstractComponentProxy(), "getComponent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractActivityEClass, this.getAbstractComponentProxy(), "getComponent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractActivityEClass, ecorePackage.getEJavaObject(), "getPropertyValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractActivityEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractActivityEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "newEnabled", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractActivityEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newIndex", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractActivityEClass, null, "refresh", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(roboidActivityEClass, RoboidActivity.class, "RoboidActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoboidActivity_Roboids(), this.getRoboidActivity(), null, "roboids", null, 0, -1, RoboidActivity.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboidActivity_Addons(), this.getAddonActivity(), null, "addons", null, 0, -1, RoboidActivity.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(roboidActivityEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRoboidActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidActivityEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAddonActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidActivityEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRoboidActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidActivityEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAddonActivity(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addonActivityEClass, AddonActivity.class, "AddonActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemActivityEClass, SystemActivity.class, "SystemActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(systemActivityEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRobot(), "robot", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(robotEDataType, Robot.class, "Robot", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iComponentEDataType, IComponent.class, "IComponent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(abstractComponentProxyEDataType, AbstractComponentProxy.class, "AbstractComponentProxy", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ActivityPackageImpl
