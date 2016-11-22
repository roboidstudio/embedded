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

package org.roboid.studio.robotcomposer.impl;

import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.ConnectableElement;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotComposerElement;
import org.roboid.studio.robotcomposer.RobotComposerFactory;
import org.roboid.studio.robotcomposer.RobotComposerPackage;
import org.roboid.studio.robotcomposer.RobotDiagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class RobotComposerPackageImpl extends EPackageImpl implements RobotComposerPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass robotComposerElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass robotDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboidBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertyChangeListenerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rectangleEDataType = null;

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
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RobotComposerPackageImpl()
	{
		super(eNS_URI, RobotComposerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RobotComposerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RobotComposerPackage init()
	{
		if (isInited) return (RobotComposerPackage)EPackage.Registry.INSTANCE.getEPackage(RobotComposerPackage.eNS_URI);

		// Obtain or create and register package
		RobotComposerPackageImpl theRobotComposerPackage = (RobotComposerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RobotComposerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RobotComposerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RobotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRobotComposerPackage.createPackageContents();

		// Initialize created meta-data
		theRobotComposerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRobotComposerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RobotComposerPackage.eNS_URI, theRobotComposerPackage);
		return theRobotComposerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRobotComposerElement()
	{
		return robotComposerElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRobotDiagram()
	{
		return robotDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRobotDiagram_Grid()
	{
		return (EAttribute)robotDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRobotDiagram_Blocks()
	{
		return (EReference)robotDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRobotDiagram_Associations()
	{
		return (EReference)robotDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRobotDiagram_Robot()
	{
		return (EReference)robotDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation()
	{
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Source()
	{
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Target()
	{
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Proxy()
	{
		return (EAttribute)associationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectableElement() {
		return connectableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectableElement_Name()
	{
		return (EAttribute)connectableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectableElement_Incomings() {
		return (EReference)connectableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectableElement_Outgoings() {
		return (EReference)connectableElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectableElement_Diagram() {
		return (EReference)connectableElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboidBlock()
	{
		return roboidBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboidBlock_X()
	{
		return (EAttribute)roboidBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboidBlock_Y()
	{
		return (EAttribute)roboidBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboidBlock_Roboid()
	{
		return (EReference)roboidBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboidBlock_Devices() {
		return (EReference)roboidBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceElement() {
		return deviceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeviceElement_Device() {
		return (EReference)deviceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPropertyChangeListener()
	{
		return propertyChangeListenerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRectangle()
	{
		return rectangleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotComposerFactory getRobotComposerFactory()
	{
		return (RobotComposerFactory)getEFactoryInstance();
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
		robotComposerElementEClass = createEClass(ROBOT_COMPOSER_ELEMENT);

		robotDiagramEClass = createEClass(ROBOT_DIAGRAM);
		createEReference(robotDiagramEClass, ROBOT_DIAGRAM__ROBOT);
		createEAttribute(robotDiagramEClass, ROBOT_DIAGRAM__GRID);
		createEReference(robotDiagramEClass, ROBOT_DIAGRAM__BLOCKS);
		createEReference(robotDiagramEClass, ROBOT_DIAGRAM__ASSOCIATIONS);

		associationEClass = createEClass(ASSOCIATION);
		createEReference(associationEClass, ASSOCIATION__SOURCE);
		createEReference(associationEClass, ASSOCIATION__TARGET);
		createEAttribute(associationEClass, ASSOCIATION__PROXY);

		connectableElementEClass = createEClass(CONNECTABLE_ELEMENT);
		createEAttribute(connectableElementEClass, CONNECTABLE_ELEMENT__NAME);
		createEReference(connectableElementEClass, CONNECTABLE_ELEMENT__INCOMINGS);
		createEReference(connectableElementEClass, CONNECTABLE_ELEMENT__OUTGOINGS);
		createEReference(connectableElementEClass, CONNECTABLE_ELEMENT__DIAGRAM);

		roboidBlockEClass = createEClass(ROBOID_BLOCK);
		createEAttribute(roboidBlockEClass, ROBOID_BLOCK__X);
		createEAttribute(roboidBlockEClass, ROBOID_BLOCK__Y);
		createEReference(roboidBlockEClass, ROBOID_BLOCK__ROBOID);
		createEReference(roboidBlockEClass, ROBOID_BLOCK__DEVICES);

		deviceElementEClass = createEClass(DEVICE_ELEMENT);
		createEReference(deviceElementEClass, DEVICE_ELEMENT__DEVICE);

		// Create data types
		propertyChangeListenerEDataType = createEDataType(PROPERTY_CHANGE_LISTENER);
		rectangleEDataType = createEDataType(RECTANGLE);
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

		// Obtain other dependent packages
		RobotPackage theRobotPackage = (RobotPackage)EPackage.Registry.INSTANCE.getEPackage(RobotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		robotDiagramEClass.getESuperTypes().add(this.getRobotComposerElement());
		associationEClass.getESuperTypes().add(this.getRobotComposerElement());
		connectableElementEClass.getESuperTypes().add(this.getRobotComposerElement());
		roboidBlockEClass.getESuperTypes().add(this.getConnectableElement());
		deviceElementEClass.getESuperTypes().add(this.getConnectableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(robotComposerElementEClass, RobotComposerElement.class, "RobotComposerElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(robotDiagramEClass, RobotDiagram.class, "RobotDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRobotDiagram_Robot(), theRobotPackage.getRobot(), null, "robot", null, 0, 1, RobotDiagram.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRobotDiagram_Grid(), ecorePackage.getEBoolean(), "grid", null, 0, 1, RobotDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRobotDiagram_Blocks(), this.getRoboidBlock(), null, "blocks", null, 0, -1, RobotDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRobotDiagram_Associations(), this.getAssociation(), null, "associations", null, 0, -1, RobotDiagram.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(robotDiagramEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRoboidBlock(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRoboidBlock(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, null, "addAssociation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, null, "removeAssociation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, this.getRoboidBlock(), "createRoboidBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getRoboid(), "roboid", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, this.getRoboidBlock(), "getRoboidBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getRoboid(), "roboid", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, this.getRoboidBlock(), "findRoboidBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getRoboid(), "roboid", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, this.getRoboidBlock(), "findRoboidBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(robotDiagramEClass, null, "refreshRoboidBlocks", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(robotDiagramEClass, null, "connectAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, null, "connect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "sourceDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "targetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotDiagramEClass, ecorePackage.getEJavaObject(), "getAllReferences", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "selection", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociation_Source(), this.getConnectableElement(), null, "source", null, 0, 1, Association.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Target(), this.getConnectableElement(), null, "target", null, 0, 1, Association.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_Proxy(), ecorePackage.getEBoolean(), "proxy", null, 0, 1, Association.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectableElementEClass, ConnectableElement.class, "ConnectableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectableElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConnectableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectableElement_Incomings(), this.getAssociation(), null, "incomings", null, 0, -1, ConnectableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectableElement_Outgoings(), this.getAssociation(), null, "outgoings", null, 0, -1, ConnectableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectableElement_Diagram(), this.getRobotDiagram(), null, "diagram", null, 0, 1, ConnectableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(connectableElementEClass, null, "addIncoming", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, null, "addOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, null, "removeIncoming", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, null, "removeOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, ecorePackage.getEBoolean(), "canConnectTo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectableElement(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, ecorePackage.getEBoolean(), "canConnectFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectableElement(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, ecorePackage.getEBoolean(), "canReconnectTo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectableElement(), "oldTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectableElement(), "newTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectableElementEClass, ecorePackage.getEBoolean(), "canReconnectFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectableElement(), "oldSource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectableElement(), "newSource", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectableElementEClass, null, "refreshName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(roboidBlockEClass, RoboidBlock.class, "RoboidBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboidBlock_X(), ecorePackage.getEInt(), "x", "-1", 0, 1, RoboidBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboidBlock_Y(), ecorePackage.getEInt(), "y", "-1", 0, 1, RoboidBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboidBlock_Roboid(), theRobotPackage.getRoboid(), null, "roboid", null, 0, 1, RoboidBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboidBlock_Devices(), this.getDeviceElement(), null, "devices", null, 0, -1, RoboidBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDeviceElement(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDeviceElement(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, null, "removeAllChildren", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, ecorePackage.getEString(), "collectAllDeviceNames", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "names", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, this.getRoboidBlock(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRobotDiagram(), "newDiagram", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, this.getDeviceElement(), "createDeviceElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, this.getDeviceElement(), "getDeviceElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, this.getDeviceElement(), "findDeviceElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, theRobotPackage.getDevice(), "getSourceDevice", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roboidBlockEClass, null, "setSourceDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, ecorePackage.getEBoolean(), "canDelete", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, ecorePackage.getEBoolean(), "canCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, ecorePackage.getEBoolean(), "canCut", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, null, "connectAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(roboidBlockEClass, null, "disconnectAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(deviceElementEClass, DeviceElement.class, "DeviceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeviceElement_Device(), theRobotPackage.getDevice(), null, "device", null, 0, 1, DeviceElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(deviceElementEClass, ecorePackage.getEBoolean(), "isConnectedTo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "targetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceElementEClass, null, "connectTo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDeviceElement(), "targetElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceElementEClass, null, "connectTo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "targetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isProxy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceElementEClass, null, "disconnectFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDeviceElement(), "targetElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceElementEClass, null, "disconnectFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "targetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceElementEClass, null, "reconnectTo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "oldTargetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getDevice(), "newTargetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(propertyChangeListenerEDataType, PropertyChangeListener.class, "PropertyChangeListener", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rectangleEDataType, Rectangle.class, "Rectangle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RobotComposerPackageImpl
