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
 * @see org.roboid.studio.robotcomposer.RobotComposerFactory
 * @model kind="package"
 * @generated
 */
public interface RobotComposerPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "robotcomposer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.roboidstudio.org/model/robotcomposer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.roboid.studio.robotcomposer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RobotComposerPackage eINSTANCE = org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.roboid.studio.robotcomposer.impl.RobotComposerElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerElementImpl
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRobotComposerElement()
	 * @generated
	 */
	int ROBOT_COMPOSER_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.robotcomposer.impl.RobotDiagramImpl <em>Robot Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.robotcomposer.impl.RobotDiagramImpl
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRobotDiagram()
	 * @generated
	 */
	int ROBOT_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_DIAGRAM__ROBOT = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_DIAGRAM__GRID = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_DIAGRAM__BLOCKS = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_DIAGRAM__ASSOCIATIONS = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Robot Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_DIAGRAM_FEATURE_COUNT = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.roboid.studio.robotcomposer.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.robotcomposer.impl.AssociationImpl
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__PROXY = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.roboid.studio.robotcomposer.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.robotcomposer.impl.ConnectableElementImpl
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getConnectableElement()
	 * @generated
	 */
	int CONNECTABLE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__NAME = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__INCOMINGS = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__OUTGOINGS = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__DIAGRAM = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Connectable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT_FEATURE_COUNT = ROBOT_COMPOSER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.roboid.studio.robotcomposer.impl.RoboidBlockImpl <em>Roboid Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.robotcomposer.impl.RoboidBlockImpl
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRoboidBlock()
	 * @generated
	 */
	int ROBOID_BLOCK = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__INCOMINGS = CONNECTABLE_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__OUTGOINGS = CONNECTABLE_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__DIAGRAM = CONNECTABLE_ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__X = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__Y = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Roboid</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__ROBOID = CONNECTABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK__DEVICES = CONNECTABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Roboid Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_BLOCK_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.roboid.studio.robotcomposer.impl.DeviceElementImpl <em>Device Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.robotcomposer.impl.DeviceElementImpl
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getDeviceElement()
	 * @generated
	 */
	int DEVICE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_ELEMENT__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_ELEMENT__INCOMINGS = CONNECTABLE_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_ELEMENT__OUTGOINGS = CONNECTABLE_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_ELEMENT__DIAGRAM = CONNECTABLE_ELEMENT__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_ELEMENT__DEVICE = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Device Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_ELEMENT_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Property Change Listener</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.beans.PropertyChangeListener
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getPropertyChangeListener()
	 * @generated
	 */
	int PROPERTY_CHANGE_LISTENER = 6;

	/**
	 * The meta object id for the '<em>Rectangle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 7;


	/**
	 * Returns the meta object for class '{@link org.roboid.studio.robotcomposer.RobotComposerElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.roboid.studio.robotcomposer.RobotComposerElement
	 * @generated
	 */
	EClass getRobotComposerElement();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.robotcomposer.RobotDiagram <em>Robot Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robot Diagram</em>'.
	 * @see org.roboid.studio.robotcomposer.RobotDiagram
	 * @generated
	 */
	EClass getRobotDiagram();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.robotcomposer.RobotDiagram#isGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grid</em>'.
	 * @see org.roboid.studio.robotcomposer.RobotDiagram#isGrid()
	 * @see #getRobotDiagram()
	 * @generated
	 */
	EAttribute getRobotDiagram_Grid();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.robotcomposer.RobotDiagram#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see org.roboid.studio.robotcomposer.RobotDiagram#getBlocks()
	 * @see #getRobotDiagram()
	 * @generated
	 */
	EReference getRobotDiagram_Blocks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.robotcomposer.RobotDiagram#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see org.roboid.studio.robotcomposer.RobotDiagram#getAssociations()
	 * @see #getRobotDiagram()
	 * @generated
	 */
	EReference getRobotDiagram_Associations();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.robotcomposer.RobotDiagram#getRobot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Robot</em>'.
	 * @see org.roboid.studio.robotcomposer.RobotDiagram#getRobot()
	 * @see #getRobotDiagram()
	 * @generated
	 */
	EReference getRobotDiagram_Robot();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.robotcomposer.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see org.roboid.studio.robotcomposer.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.robotcomposer.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.roboid.studio.robotcomposer.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.robotcomposer.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.roboid.studio.robotcomposer.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.robotcomposer.Association#isProxy <em>Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy</em>'.
	 * @see org.roboid.studio.robotcomposer.Association#isProxy()
	 * @see #getAssociation()
	 * @generated
	 */
	EAttribute getAssociation_Proxy();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.robotcomposer.ConnectableElement <em>Connectable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connectable Element</em>'.
	 * @see org.roboid.studio.robotcomposer.ConnectableElement
	 * @generated
	 */
	EClass getConnectableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.robotcomposer.ConnectableElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.roboid.studio.robotcomposer.ConnectableElement#getName()
	 * @see #getConnectableElement()
	 * @generated
	 */
	EAttribute getConnectableElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.studio.robotcomposer.ConnectableElement#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see org.roboid.studio.robotcomposer.ConnectableElement#getIncomings()
	 * @see #getConnectableElement()
	 * @generated
	 */
	EReference getConnectableElement_Incomings();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.studio.robotcomposer.ConnectableElement#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see org.roboid.studio.robotcomposer.ConnectableElement#getOutgoings()
	 * @see #getConnectableElement()
	 * @generated
	 */
	EReference getConnectableElement_Outgoings();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.robotcomposer.ConnectableElement#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagram</em>'.
	 * @see org.roboid.studio.robotcomposer.ConnectableElement#getDiagram()
	 * @see #getConnectableElement()
	 * @generated
	 */
	EReference getConnectableElement_Diagram();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.robotcomposer.RoboidBlock <em>Roboid Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboid Block</em>'.
	 * @see org.roboid.studio.robotcomposer.RoboidBlock
	 * @generated
	 */
	EClass getRoboidBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.robotcomposer.RoboidBlock#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.roboid.studio.robotcomposer.RoboidBlock#getX()
	 * @see #getRoboidBlock()
	 * @generated
	 */
	EAttribute getRoboidBlock_X();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.robotcomposer.RoboidBlock#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.roboid.studio.robotcomposer.RoboidBlock#getY()
	 * @see #getRoboidBlock()
	 * @generated
	 */
	EAttribute getRoboidBlock_Y();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.robotcomposer.RoboidBlock#getRoboid <em>Roboid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Roboid</em>'.
	 * @see org.roboid.studio.robotcomposer.RoboidBlock#getRoboid()
	 * @see #getRoboidBlock()
	 * @generated
	 */
	EReference getRoboidBlock_Roboid();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.robotcomposer.RoboidBlock#getDevices <em>Devices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Devices</em>'.
	 * @see org.roboid.studio.robotcomposer.RoboidBlock#getDevices()
	 * @see #getRoboidBlock()
	 * @generated
	 */
	EReference getRoboidBlock_Devices();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.robotcomposer.DeviceElement <em>Device Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Element</em>'.
	 * @see org.roboid.studio.robotcomposer.DeviceElement
	 * @generated
	 */
	EClass getDeviceElement();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.robotcomposer.DeviceElement#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Device</em>'.
	 * @see org.roboid.studio.robotcomposer.DeviceElement#getDevice()
	 * @see #getDeviceElement()
	 * @generated
	 */
	EReference getDeviceElement_Device();

	/**
	 * Returns the meta object for data type '{@link java.beans.PropertyChangeListener <em>Property Change Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Property Change Listener</em>'.
	 * @see java.beans.PropertyChangeListener
	 * @model instanceClass="java.beans.PropertyChangeListener"
	 * @generated
	 */
	EDataType getPropertyChangeListener();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rectangle</em>'.
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
	 * @generated
	 */
	EDataType getRectangle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RobotComposerFactory getRobotComposerFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.roboid.studio.robotcomposer.impl.RobotComposerElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerElementImpl
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRobotComposerElement()
		 * @generated
		 */
		EClass ROBOT_COMPOSER_ELEMENT = eINSTANCE.getRobotComposerElement();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.robotcomposer.impl.RobotDiagramImpl <em>Robot Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.robotcomposer.impl.RobotDiagramImpl
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRobotDiagram()
		 * @generated
		 */
		EClass ROBOT_DIAGRAM = eINSTANCE.getRobotDiagram();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT_DIAGRAM__GRID = eINSTANCE.getRobotDiagram_Grid();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT_DIAGRAM__BLOCKS = eINSTANCE.getRobotDiagram_Blocks();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT_DIAGRAM__ASSOCIATIONS = eINSTANCE.getRobotDiagram_Associations();

		/**
		 * The meta object literal for the '<em><b>Robot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT_DIAGRAM__ROBOT = eINSTANCE.getRobotDiagram_Robot();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.robotcomposer.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.robotcomposer.impl.AssociationImpl
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '<em><b>Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION__PROXY = eINSTANCE.getAssociation_Proxy();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.robotcomposer.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.robotcomposer.impl.ConnectableElementImpl
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getConnectableElement()
		 * @generated
		 */
		EClass CONNECTABLE_ELEMENT = eINSTANCE.getConnectableElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTABLE_ELEMENT__NAME = eINSTANCE.getConnectableElement_Name();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTABLE_ELEMENT__INCOMINGS = eINSTANCE.getConnectableElement_Incomings();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTABLE_ELEMENT__OUTGOINGS = eINSTANCE.getConnectableElement_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTABLE_ELEMENT__DIAGRAM = eINSTANCE.getConnectableElement_Diagram();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.robotcomposer.impl.RoboidBlockImpl <em>Roboid Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.robotcomposer.impl.RoboidBlockImpl
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRoboidBlock()
		 * @generated
		 */
		EClass ROBOID_BLOCK = eINSTANCE.getRoboidBlock();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID_BLOCK__X = eINSTANCE.getRoboidBlock_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID_BLOCK__Y = eINSTANCE.getRoboidBlock_Y();

		/**
		 * The meta object literal for the '<em><b>Roboid</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID_BLOCK__ROBOID = eINSTANCE.getRoboidBlock_Roboid();

		/**
		 * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID_BLOCK__DEVICES = eINSTANCE.getRoboidBlock_Devices();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.robotcomposer.impl.DeviceElementImpl <em>Device Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.robotcomposer.impl.DeviceElementImpl
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getDeviceElement()
		 * @generated
		 */
		EClass DEVICE_ELEMENT = eINSTANCE.getDeviceElement();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_ELEMENT__DEVICE = eINSTANCE.getDeviceElement_Device();

		/**
		 * The meta object literal for the '<em>Property Change Listener</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.beans.PropertyChangeListener
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getPropertyChangeListener()
		 * @generated
		 */
		EDataType PROPERTY_CHANGE_LISTENER = eINSTANCE.getPropertyChangeListener();

		/**
		 * The meta object literal for the '<em>Rectangle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Rectangle
		 * @see org.roboid.studio.robotcomposer.impl.RobotComposerPackageImpl#getRectangle()
		 * @generated
		 */
		EDataType RECTANGLE = eINSTANCE.getRectangle();

	}

} //RobotComposerPackage
