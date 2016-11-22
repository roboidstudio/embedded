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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * <!-- end-user-doc -->
 * @see org.roboid.robot.RobotFactory
 * @model kind="package"
 * @generated
 */
public interface RobotPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "robot";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.roboidstudio.org/model/robot";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.roboid.robot";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RobotPackage eINSTANCE = org.roboid.robot.impl.RobotPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.NamedElementImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__LITERAL = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__COMMENT = 2;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.roboid.robot.Storable <em>Storable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.Storable
	 * @see org.roboid.robot.impl.RobotPackageImpl#getStorable()
	 * @generated
	 */
	int STORABLE = 1;

	/**
	 * The number of structural features of the '<em>Storable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.Findable <em>Findable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.Findable
	 * @see org.roboid.robot.impl.RobotPackageImpl#getFindable()
	 * @generated
	 */
	int FINDABLE = 2;

	/**
	 * The number of structural features of the '<em>Findable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINDABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.Simulacra <em>Simulacra</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.Simulacra
	 * @see org.roboid.robot.impl.RobotPackageImpl#getSimulacra()
	 * @generated
	 */
	int SIMULACRA = 3;

	/**
	 * The number of structural features of the '<em>Simulacra</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULACRA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.DeviceListener <em>Device Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.DeviceListener
	 * @see org.roboid.robot.impl.RobotPackageImpl#getDeviceListener()
	 * @generated
	 */
	int DEVICE_LISTENER = 4;

	/**
	 * The number of structural features of the '<em>Device Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LISTENER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.RobotImpl <em>Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.RobotImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getRobot()
	 * @generated
	 */
	int ROBOT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__LITERAL = NAMED_ELEMENT__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__PROVIDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Roboids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__ROBOIDS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__CONTROLS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Standard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__STANDARD = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.RoboidImpl <em>Roboid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.RoboidImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getRoboid()
	 * @generated
	 */
	int ROBOID = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__LITERAL = NAMED_ELEMENT__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__ID = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__UID = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Roboids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__ROBOIDS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__PROTOCOL = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__DEVICES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__PROVIDER = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Host Roboid</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__HOST_ROBOID = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID__ADDRESS = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Roboid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOID_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.ControlImpl <em>Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.ControlImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getControl()
	 * @generated
	 */
	int CONTROL = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__LITERAL = NAMED_ELEMENT__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__CHANNELS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Frame Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__FRAME_LIMIT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.ProtocolImpl <em>Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.ProtocolImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getProtocol()
	 * @generated
	 */
	int PROTOCOL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__LITERAL = NAMED_ELEMENT__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__BUFFER_SIZE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Remaining Buffer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__REMAINING_BUFFER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.PortImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 17;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.DeviceImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__LITERAL = NAMED_ELEMENT__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DATA_SIZE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DATA_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__MAX = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__MIN = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__DEFAULT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PROXY = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ACCESS = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.ChannelDeviceImpl <em>Channel Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.ChannelDeviceImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getChannelDevice()
	 * @generated
	 */
	int CHANNEL_DEVICE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__NAME = DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__LITERAL = DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__COMMENT = DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__DATA_SIZE = DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__DATA_TYPE = DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__MAX = DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__MIN = DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__DEFAULT = DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__PROXY = DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE__ACCESS = DEVICE__ACCESS;

	/**
	 * The number of structural features of the '<em>Channel Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEVICE_FEATURE_COUNT = DEVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.SensoryDeviceImpl <em>Sensory Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.SensoryDeviceImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getSensoryDevice()
	 * @generated
	 */
	int SENSORY_DEVICE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__NAME = DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__LITERAL = DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__COMMENT = DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__DATA_SIZE = DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__DATA_TYPE = DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__MAX = DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__MIN = DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__DEFAULT = DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__PROXY = DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE__ACCESS = DEVICE__ACCESS;

	/**
	 * The number of structural features of the '<em>Sensory Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSORY_DEVICE_FEATURE_COUNT = DEVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.MotoringDeviceImpl <em>Motoring Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.MotoringDeviceImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getMotoringDevice()
	 * @generated
	 */
	int MOTORING_DEVICE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__NAME = CHANNEL_DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__LITERAL = CHANNEL_DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__COMMENT = CHANNEL_DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__DATA_SIZE = CHANNEL_DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__DATA_TYPE = CHANNEL_DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__MAX = CHANNEL_DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__MIN = CHANNEL_DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__DEFAULT = CHANNEL_DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__PROXY = CHANNEL_DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE__ACCESS = CHANNEL_DEVICE__ACCESS;

	/**
	 * The number of structural features of the '<em>Motoring Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTORING_DEVICE_FEATURE_COUNT = CHANNEL_DEVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.SensorImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__NAME = SENSORY_DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__LITERAL = SENSORY_DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__COMMENT = SENSORY_DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__DATA_SIZE = SENSORY_DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__DATA_TYPE = SENSORY_DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__MAX = SENSORY_DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__MIN = SENSORY_DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__DEFAULT = SENSORY_DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__PROXY = SENSORY_DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ACCESS = SENSORY_DEVICE__ACCESS;

	/**
	 * The feature id for the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__PROXY_FOR = SENSORY_DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__RECEPTORS = SENSORY_DEVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Throttle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__THROTTLE = SENSORY_DEVICE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = SENSORY_DEVICE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.EffectorImpl <em>Effector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.EffectorImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getEffector()
	 * @generated
	 */
	int EFFECTOR = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__NAME = MOTORING_DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__LITERAL = MOTORING_DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__COMMENT = MOTORING_DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__DATA_SIZE = MOTORING_DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__DATA_TYPE = MOTORING_DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__MAX = MOTORING_DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__MIN = MOTORING_DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__DEFAULT = MOTORING_DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__PROXY = MOTORING_DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__ACCESS = MOTORING_DEVICE__ACCESS;

	/**
	 * The feature id for the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__PROXY_FOR = MOTORING_DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sustain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__SUSTAIN = MOTORING_DEVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Throttle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR__THROTTLE = MOTORING_DEVICE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Effector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFECTOR_FEATURE_COUNT = MOTORING_DEVICE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.CommandImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__NAME = MOTORING_DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__LITERAL = MOTORING_DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__COMMENT = MOTORING_DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__DATA_SIZE = MOTORING_DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__DATA_TYPE = MOTORING_DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__MAX = MOTORING_DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__MIN = MOTORING_DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__DEFAULT = MOTORING_DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__PROXY = MOTORING_DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__ACCESS = MOTORING_DEVICE__ACCESS;

	/**
	 * The feature id for the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__PROXY_FOR = MOTORING_DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__ID = MOTORING_DEVICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = MOTORING_DEVICE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.EventImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = SENSORY_DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__LITERAL = SENSORY_DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COMMENT = SENSORY_DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DATA_SIZE = SENSORY_DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DATA_TYPE = SENSORY_DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__MAX = SENSORY_DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__MIN = SENSORY_DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DEFAULT = SENSORY_DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PROXY = SENSORY_DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ACCESS = SENSORY_DEVICE__ACCESS;

	/**
	 * The feature id for the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PROXY_FOR = SENSORY_DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__RECEPTORS = SENSORY_DEVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ID = SENSORY_DEVICE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = SENSORY_DEVICE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = CHANNEL_DEVICE__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__LITERAL = CHANNEL_DEVICE__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__COMMENT = CHANNEL_DEVICE__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DATA_SIZE = CHANNEL_DEVICE__DATA_SIZE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DATA_TYPE = CHANNEL_DEVICE__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MAX = CHANNEL_DEVICE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MIN = CHANNEL_DEVICE__MIN;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DEFAULT = CHANNEL_DEVICE__DEFAULT;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROXY = CHANNEL_DEVICE__PROXY;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ACCESS = CHANNEL_DEVICE__ACCESS;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MODE = CHANNEL_DEVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Proxy For</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROXY_FOR = CHANNEL_DEVICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = CHANNEL_DEVICE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.ChannelImpl <em>Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.ChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getChannel()
	 * @generated
	 */
	int CHANNEL = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__LITERAL = NAMED_ELEMENT__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__COMMENT = NAMED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__DEVICES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.LinearChannelImpl <em>Linear Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.LinearChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getLinearChannel()
	 * @generated
	 */
	int LINEAR_CHANNEL = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_CHANNEL__MODE = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linear Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.CommandChannelImpl <em>Command Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.CommandChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getCommandChannel()
	 * @generated
	 */
	int COMMAND_CHANNEL = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The number of structural features of the '<em>Command Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.AudioChannelImpl <em>Audio Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.AudioChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getAudioChannel()
	 * @generated
	 */
	int AUDIO_CHANNEL = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The number of structural features of the '<em>Audio Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.VoiceChannelImpl <em>Voice Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.VoiceChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getVoiceChannel()
	 * @generated
	 */
	int VOICE_CHANNEL = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The number of structural features of the '<em>Voice Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.ColorChannelImpl <em>Color Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.ColorChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getColorChannel()
	 * @generated
	 */
	int COLOR_CHANNEL = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CHANNEL__MODE = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.TextChannelImpl <em>Text Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.TextChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getTextChannel()
	 * @generated
	 */
	int TEXT_CHANNEL = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The number of structural features of the '<em>Text Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.MatrixChannelImpl <em>Matrix Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.MatrixChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getMatrixChannel()
	 * @generated
	 */
	int MATRIX_CHANNEL = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_CHANNEL__NAME = LINEAR_CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_CHANNEL__LITERAL = LINEAR_CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_CHANNEL__COMMENT = LINEAR_CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_CHANNEL__DEVICES = LINEAR_CHANNEL__DEVICES;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_CHANNEL__MODE = LINEAR_CHANNEL__MODE;

	/**
	 * The number of structural features of the '<em>Matrix Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_CHANNEL_FEATURE_COUNT = LINEAR_CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.impl.FileChannelImpl <em>File Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.FileChannelImpl
	 * @see org.roboid.robot.impl.RobotPackageImpl#getFileChannel()
	 * @generated
	 */
	int FILE_CHANNEL = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_CHANNEL__LITERAL = CHANNEL__LITERAL;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_CHANNEL__COMMENT = CHANNEL__COMMENT;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_CHANNEL__DEVICES = CHANNEL__DEVICES;

	/**
	 * The number of structural features of the '<em>File Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.robot.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.DataType
	 * @see org.roboid.robot.impl.RobotPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 27;

	/**
	 * The meta object id for the '{@link org.roboid.robot.AccessType <em>Access Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.AccessType
	 * @see org.roboid.robot.impl.RobotPackageImpl#getAccessType()
	 * @generated
	 */
	int ACCESS_TYPE = 28;

	/**
	 * The meta object id for the '{@link org.roboid.robot.LinearMode <em>Linear Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.LinearMode
	 * @see org.roboid.robot.impl.RobotPackageImpl#getLinearMode()
	 * @generated
	 */
	int LINEAR_MODE = 29;

	/**
	 * The meta object id for the '{@link org.roboid.robot.AudioMode <em>Audio Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.AudioMode
	 * @see org.roboid.robot.impl.RobotPackageImpl#getAudioMode()
	 * @generated
	 */
	int AUDIO_MODE = 30;

	/**
	 * The meta object id for the '{@link org.roboid.robot.ColorMode <em>Color Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.ColorMode
	 * @see org.roboid.robot.impl.RobotPackageImpl#getColorMode()
	 * @generated
	 */
	int COLOR_MODE = 31;

	/**
	 * The meta object id for the '{@link org.roboid.robot.IoMode <em>Io Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.IoMode
	 * @see org.roboid.robot.impl.RobotPackageImpl#getIoMode()
	 * @generated
	 */
	int IO_MODE = 32;

	/**
	 * The meta object id for the '<em>Int Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.RobotPackageImpl#getIntArray()
	 * @generated
	 */
	int INT_ARRAY = 33;

	/**
	 * The meta object id for the '<em>Float Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.RobotPackageImpl#getFloatArray()
	 * @generated
	 */
	int FLOAT_ARRAY = 34;

	/**
	 * The meta object id for the '<em>String Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.RobotPackageImpl#getStringArray()
	 * @generated
	 */
	int STRING_ARRAY = 35;

	/**
	 * The meta object id for the '<em>Image Data Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.robot.impl.RobotPackageImpl#getImageDataArray()
	 * @generated
	 */
	int IMAGE_DATA_ARRAY = 36;

	/**
	 * The meta object id for the '<em>Image Data</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.ImageData
	 * @see org.roboid.robot.impl.RobotPackageImpl#getImageData()
	 * @generated
	 */
	int IMAGE_DATA = 37;

	/**
	 * The meta object id for the '<em>Byte Array Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.ByteArrayInputStream
	 * @see org.roboid.robot.impl.RobotPackageImpl#getByteArrayInputStream()
	 * @generated
	 */
	int BYTE_ARRAY_INPUT_STREAM = 38;

	/**
	 * The meta object id for the '<em>Byte Array Output Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.ByteArrayOutputStream
	 * @see org.roboid.robot.impl.RobotPackageImpl#getByteArrayOutputStream()
	 * @generated
	 */
	int BYTE_ARRAY_OUTPUT_STREAM = 39;


	/**
	 * Returns the meta object for class '{@link org.roboid.robot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.roboid.robot.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.roboid.robot.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.NamedElement#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.roboid.robot.NamedElement#getLiteral()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.NamedElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.roboid.robot.NamedElement#getComment()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Comment();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Storable <em>Storable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storable</em>'.
	 * @see org.roboid.robot.Storable
	 * @generated
	 */
	EClass getStorable();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Findable <em>Findable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Findable</em>'.
	 * @see org.roboid.robot.Findable
	 * @generated
	 */
	EClass getFindable();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Simulacra <em>Simulacra</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulacra</em>'.
	 * @see org.roboid.robot.Simulacra
	 * @generated
	 */
	EClass getSimulacra();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.DeviceListener <em>Device Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Listener</em>'.
	 * @see org.roboid.robot.DeviceListener
	 * @generated
	 */
	EClass getDeviceListener();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robot</em>'.
	 * @see org.roboid.robot.Robot
	 * @generated
	 */
	EClass getRobot();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Robot#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.roboid.robot.Robot#getProvider()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Robot#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.roboid.robot.Robot#getVersion()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.robot.Robot#getRoboids <em>Roboids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roboids</em>'.
	 * @see org.roboid.robot.Robot#getRoboids()
	 * @see #getRobot()
	 * @generated
	 */
	EReference getRobot_Roboids();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.robot.Robot#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.roboid.robot.Robot#getControls()
	 * @see #getRobot()
	 * @generated
	 */
	EReference getRobot_Controls();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Robot#getStandard <em>Standard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard</em>'.
	 * @see org.roboid.robot.Robot#getStandard()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Standard();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Roboid <em>Roboid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roboid</em>'.
	 * @see org.roboid.robot.Roboid
	 * @generated
	 */
	EClass getRoboid();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Roboid#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.roboid.robot.Roboid#getId()
	 * @see #getRoboid()
	 * @generated
	 */
	EAttribute getRoboid_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Roboid#getUid <em>Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid</em>'.
	 * @see org.roboid.robot.Roboid#getUid()
	 * @see #getRoboid()
	 * @generated
	 */
	EAttribute getRoboid_Uid();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.robot.Roboid#getRoboids <em>Roboids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roboids</em>'.
	 * @see org.roboid.robot.Roboid#getRoboids()
	 * @see #getRoboid()
	 * @generated
	 */
	EReference getRoboid_Roboids();

	/**
	 * Returns the meta object for the containment reference '{@link org.roboid.robot.Roboid#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Protocol</em>'.
	 * @see org.roboid.robot.Roboid#getProtocol()
	 * @see #getRoboid()
	 * @generated
	 */
	EReference getRoboid_Protocol();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.robot.Roboid#getDevices <em>Devices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Devices</em>'.
	 * @see org.roboid.robot.Roboid#getDevices()
	 * @see #getRoboid()
	 * @generated
	 */
	EReference getRoboid_Devices();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Roboid#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.roboid.robot.Roboid#getVersion()
	 * @see #getRoboid()
	 * @generated
	 */
	EAttribute getRoboid_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Roboid#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.roboid.robot.Roboid#getProvider()
	 * @see #getRoboid()
	 * @generated
	 */
	EAttribute getRoboid_Provider();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.robot.Roboid#getHostRoboid <em>Host Roboid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Host Roboid</em>'.
	 * @see org.roboid.robot.Roboid#getHostRoboid()
	 * @see #getRoboid()
	 * @generated
	 */
	EReference getRoboid_HostRoboid();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Roboid#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see org.roboid.robot.Roboid#getAddress()
	 * @see #getRoboid()
	 * @generated
	 */
	EAttribute getRoboid_Address();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Control <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control</em>'.
	 * @see org.roboid.robot.Control
	 * @generated
	 */
	EClass getControl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.robot.Control#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channels</em>'.
	 * @see org.roboid.robot.Control#getChannels()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_Channels();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Control#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.roboid.robot.Control#getVersion()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Control#getFrameLimit <em>Frame Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Limit</em>'.
	 * @see org.roboid.robot.Control#getFrameLimit()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_FrameLimit();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Protocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol</em>'.
	 * @see org.roboid.robot.Protocol
	 * @generated
	 */
	EClass getProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Protocol#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.roboid.robot.Protocol#getVersion()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Protocol#getBufferSize <em>Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Buffer Size</em>'.
	 * @see org.roboid.robot.Protocol#getBufferSize()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_BufferSize();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Protocol#getRemainingBuffer <em>Remaining Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remaining Buffer</em>'.
	 * @see org.roboid.robot.Protocol#getRemainingBuffer()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_RemainingBuffer();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.roboid.robot.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Port#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.robot.Port#getMode()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Mode();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.robot.Port#getProxyFor <em>Proxy For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proxy For</em>'.
	 * @see org.roboid.robot.Port#getProxyFor()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_ProxyFor();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see org.roboid.robot.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device#getDataSize <em>Data Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Size</em>'.
	 * @see org.roboid.robot.Device#getDataSize()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_DataSize();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.roboid.robot.Device#getDataType()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.roboid.robot.Device
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.roboid.robot.Device
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.roboid.robot.Device
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device#isProxy <em>Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy</em>'.
	 * @see org.roboid.robot.Device#isProxy()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Proxy();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Device#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see org.roboid.robot.Device#getAccess()
	 * @see #getDevice()
	 * @generated
	 */
	EAttribute getDevice_Access();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.ChannelDevice <em>Channel Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Device</em>'.
	 * @see org.roboid.robot.ChannelDevice
	 * @generated
	 */
	EClass getChannelDevice();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.SensoryDevice <em>Sensory Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensory Device</em>'.
	 * @see org.roboid.robot.SensoryDevice
	 * @generated
	 */
	EClass getSensoryDevice();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.MotoringDevice <em>Motoring Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motoring Device</em>'.
	 * @see org.roboid.robot.MotoringDevice
	 * @generated
	 */
	EClass getMotoringDevice();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see org.roboid.robot.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.robot.Sensor#getProxyFor <em>Proxy For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proxy For</em>'.
	 * @see org.roboid.robot.Sensor#getProxyFor()
	 * @see #getSensor()
	 * @generated
	 */
	EReference getSensor_ProxyFor();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.robot.Sensor#getReceptors <em>Receptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receptors</em>'.
	 * @see org.roboid.robot.Sensor#getReceptors()
	 * @see #getSensor()
	 * @generated
	 */
	EReference getSensor_Receptors();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Sensor#getThrottle <em>Throttle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throttle</em>'.
	 * @see org.roboid.robot.Sensor#getThrottle()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Throttle();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Effector <em>Effector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effector</em>'.
	 * @see org.roboid.robot.Effector
	 * @generated
	 */
	EClass getEffector();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.robot.Effector#getProxyFor <em>Proxy For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proxy For</em>'.
	 * @see org.roboid.robot.Effector#getProxyFor()
	 * @see #getEffector()
	 * @generated
	 */
	EReference getEffector_ProxyFor();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Effector#getSustain <em>Sustain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sustain</em>'.
	 * @see org.roboid.robot.Effector#getSustain()
	 * @see #getEffector()
	 * @generated
	 */
	EAttribute getEffector_Sustain();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Effector#getThrottle <em>Throttle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throttle</em>'.
	 * @see org.roboid.robot.Effector#getThrottle()
	 * @see #getEffector()
	 * @generated
	 */
	EAttribute getEffector_Throttle();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.roboid.robot.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.robot.Command#getProxyFor <em>Proxy For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proxy For</em>'.
	 * @see org.roboid.robot.Command#getProxyFor()
	 * @see #getCommand()
	 * @generated
	 */
	EReference getCommand_ProxyFor();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Command#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.roboid.robot.Command#getId()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_Id();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.roboid.robot.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.robot.Event#getProxyFor <em>Proxy For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Proxy For</em>'.
	 * @see org.roboid.robot.Event#getProxyFor()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_ProxyFor();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.robot.Event#getReceptors <em>Receptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receptors</em>'.
	 * @see org.roboid.robot.Event#getReceptors()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Receptors();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.Event#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.roboid.robot.Event#getId()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Id();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel</em>'.
	 * @see org.roboid.robot.Channel
	 * @generated
	 */
	EClass getChannel();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.robot.Channel#getDevices <em>Devices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Devices</em>'.
	 * @see org.roboid.robot.Channel#getDevices()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Devices();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.LinearChannel <em>Linear Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Channel</em>'.
	 * @see org.roboid.robot.LinearChannel
	 * @generated
	 */
	EClass getLinearChannel();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.LinearChannel#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.robot.LinearChannel#getMode()
	 * @see #getLinearChannel()
	 * @generated
	 */
	EAttribute getLinearChannel_Mode();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.CommandChannel <em>Command Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Channel</em>'.
	 * @see org.roboid.robot.CommandChannel
	 * @generated
	 */
	EClass getCommandChannel();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.AudioChannel <em>Audio Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audio Channel</em>'.
	 * @see org.roboid.robot.AudioChannel
	 * @generated
	 */
	EClass getAudioChannel();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.VoiceChannel <em>Voice Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voice Channel</em>'.
	 * @see org.roboid.robot.VoiceChannel
	 * @generated
	 */
	EClass getVoiceChannel();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.ColorChannel <em>Color Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Channel</em>'.
	 * @see org.roboid.robot.ColorChannel
	 * @generated
	 */
	EClass getColorChannel();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.robot.ColorChannel#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.robot.ColorChannel#getMode()
	 * @see #getColorChannel()
	 * @generated
	 */
	EAttribute getColorChannel_Mode();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.TextChannel <em>Text Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Channel</em>'.
	 * @see org.roboid.robot.TextChannel
	 * @generated
	 */
	EClass getTextChannel();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.MatrixChannel <em>Matrix Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matrix Channel</em>'.
	 * @see org.roboid.robot.MatrixChannel
	 * @generated
	 */
	EClass getMatrixChannel();

	/**
	 * Returns the meta object for class '{@link org.roboid.robot.FileChannel <em>File Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Channel</em>'.
	 * @see org.roboid.robot.FileChannel
	 * @generated
	 */
	EClass getFileChannel();

	/**
	 * Returns the meta object for enum '{@link org.roboid.robot.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see org.roboid.robot.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link org.roboid.robot.AccessType <em>Access Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Type</em>'.
	 * @see org.roboid.robot.AccessType
	 * @generated
	 */
	EEnum getAccessType();

	/**
	 * Returns the meta object for enum '{@link org.roboid.robot.LinearMode <em>Linear Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Linear Mode</em>'.
	 * @see org.roboid.robot.LinearMode
	 * @generated
	 */
	EEnum getLinearMode();

	/**
	 * Returns the meta object for enum '{@link org.roboid.robot.AudioMode <em>Audio Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Audio Mode</em>'.
	 * @see org.roboid.robot.AudioMode
	 * @generated
	 */
	EEnum getAudioMode();

	/**
	 * Returns the meta object for enum '{@link org.roboid.robot.ColorMode <em>Color Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Color Mode</em>'.
	 * @see org.roboid.robot.ColorMode
	 * @generated
	 */
	EEnum getColorMode();

	/**
	 * Returns the meta object for enum '{@link org.roboid.robot.IoMode <em>Io Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Io Mode</em>'.
	 * @see org.roboid.robot.IoMode
	 * @generated
	 */
	EEnum getIoMode();

	/**
	 * Returns the meta object for data type '<em>Int Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int Array</em>'.
	 * @model instanceClass="int[]"
	 * @generated
	 */
	EDataType getIntArray();

	/**
	 * Returns the meta object for data type '<em>Float Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float Array</em>'.
	 * @model instanceClass="float[]"
	 * @generated
	 */
	EDataType getFloatArray();

	/**
	 * Returns the meta object for data type '<em>String Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Array</em>'.
	 * @model instanceClass="java.lang.String[]"
	 * @generated
	 */
	EDataType getStringArray();

	/**
	 * Returns the meta object for data type '<em>Image Data Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image Data Array</em>'.
	 * @model instanceClass="org.eclipse.swt.graphics.ImageData[]"
	 * @generated
	 */
	EDataType getImageDataArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.ImageData <em>Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image Data</em>'.
	 * @see org.eclipse.swt.graphics.ImageData
	 * @model instanceClass="org.eclipse.swt.graphics.ImageData"
	 * @generated
	 */
	EDataType getImageData();

	/**
	 * Returns the meta object for data type '{@link java.io.ByteArrayInputStream <em>Byte Array Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Byte Array Input Stream</em>'.
	 * @see java.io.ByteArrayInputStream
	 * @model instanceClass="java.io.ByteArrayInputStream"
	 * @generated
	 */
	EDataType getByteArrayInputStream();

	/**
	 * Returns the meta object for data type '{@link java.io.ByteArrayOutputStream <em>Byte Array Output Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Byte Array Output Stream</em>'.
	 * @see java.io.ByteArrayOutputStream
	 * @model instanceClass="java.io.ByteArrayOutputStream"
	 * @generated
	 */
	EDataType getByteArrayOutputStream();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RobotFactory getRobotFactory();

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
		 * The meta object literal for the '{@link org.roboid.robot.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.NamedElementImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__LITERAL = eINSTANCE.getNamedElement_Literal();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__COMMENT = eINSTANCE.getNamedElement_Comment();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.Storable <em>Storable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.Storable
		 * @see org.roboid.robot.impl.RobotPackageImpl#getStorable()
		 * @generated
		 */
		EClass STORABLE = eINSTANCE.getStorable();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.Findable <em>Findable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.Findable
		 * @see org.roboid.robot.impl.RobotPackageImpl#getFindable()
		 * @generated
		 */
		EClass FINDABLE = eINSTANCE.getFindable();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.Simulacra <em>Simulacra</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.Simulacra
		 * @see org.roboid.robot.impl.RobotPackageImpl#getSimulacra()
		 * @generated
		 */
		EClass SIMULACRA = eINSTANCE.getSimulacra();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.DeviceListener <em>Device Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.DeviceListener
		 * @see org.roboid.robot.impl.RobotPackageImpl#getDeviceListener()
		 * @generated
		 */
		EClass DEVICE_LISTENER = eINSTANCE.getDeviceListener();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.RobotImpl <em>Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.RobotImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getRobot()
		 * @generated
		 */
		EClass ROBOT = eINSTANCE.getRobot();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__PROVIDER = eINSTANCE.getRobot_Provider();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__VERSION = eINSTANCE.getRobot_Version();

		/**
		 * The meta object literal for the '<em><b>Roboids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT__ROBOIDS = eINSTANCE.getRobot_Roboids();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOT__CONTROLS = eINSTANCE.getRobot_Controls();

		/**
		 * The meta object literal for the '<em><b>Standard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__STANDARD = eINSTANCE.getRobot_Standard();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.RoboidImpl <em>Roboid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.RoboidImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getRoboid()
		 * @generated
		 */
		EClass ROBOID = eINSTANCE.getRoboid();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID__ID = eINSTANCE.getRoboid_Id();

		/**
		 * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID__UID = eINSTANCE.getRoboid_Uid();

		/**
		 * The meta object literal for the '<em><b>Roboids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID__ROBOIDS = eINSTANCE.getRoboid_Roboids();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID__PROTOCOL = eINSTANCE.getRoboid_Protocol();

		/**
		 * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID__DEVICES = eINSTANCE.getRoboid_Devices();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID__VERSION = eINSTANCE.getRoboid_Version();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID__PROVIDER = eINSTANCE.getRoboid_Provider();

		/**
		 * The meta object literal for the '<em><b>Host Roboid</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOID__HOST_ROBOID = eINSTANCE.getRoboid_HostRoboid();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOID__ADDRESS = eINSTANCE.getRoboid_Address();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.ControlImpl <em>Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.ControlImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getControl()
		 * @generated
		 */
		EClass CONTROL = eINSTANCE.getControl();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__CHANNELS = eINSTANCE.getControl_Channels();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__VERSION = eINSTANCE.getControl_Version();

		/**
		 * The meta object literal for the '<em><b>Frame Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__FRAME_LIMIT = eINSTANCE.getControl_FrameLimit();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.ProtocolImpl <em>Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.ProtocolImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getProtocol()
		 * @generated
		 */
		EClass PROTOCOL = eINSTANCE.getProtocol();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__VERSION = eINSTANCE.getProtocol_Version();

		/**
		 * The meta object literal for the '<em><b>Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__BUFFER_SIZE = eINSTANCE.getProtocol_BufferSize();

		/**
		 * The meta object literal for the '<em><b>Remaining Buffer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__REMAINING_BUFFER = eINSTANCE.getProtocol_RemainingBuffer();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.PortImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__MODE = eINSTANCE.getPort_Mode();

		/**
		 * The meta object literal for the '<em><b>Proxy For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PROXY_FOR = eINSTANCE.getPort_ProxyFor();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.DeviceImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getDevice()
		 * @generated
		 */
		EClass DEVICE = eINSTANCE.getDevice();

		/**
		 * The meta object literal for the '<em><b>Data Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__DATA_SIZE = eINSTANCE.getDevice_DataSize();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__DATA_TYPE = eINSTANCE.getDevice_DataType();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__MAX = eINSTANCE.getDevice_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__MIN = eINSTANCE.getDevice_Min();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__DEFAULT = eINSTANCE.getDevice_Default();

		/**
		 * The meta object literal for the '<em><b>Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__PROXY = eINSTANCE.getDevice_Proxy();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE__ACCESS = eINSTANCE.getDevice_Access();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.ChannelDeviceImpl <em>Channel Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.ChannelDeviceImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getChannelDevice()
		 * @generated
		 */
		EClass CHANNEL_DEVICE = eINSTANCE.getChannelDevice();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.SensoryDeviceImpl <em>Sensory Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.SensoryDeviceImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getSensoryDevice()
		 * @generated
		 */
		EClass SENSORY_DEVICE = eINSTANCE.getSensoryDevice();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.MotoringDeviceImpl <em>Motoring Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.MotoringDeviceImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getMotoringDevice()
		 * @generated
		 */
		EClass MOTORING_DEVICE = eINSTANCE.getMotoringDevice();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.SensorImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '<em><b>Proxy For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENSOR__PROXY_FOR = eINSTANCE.getSensor_ProxyFor();

		/**
		 * The meta object literal for the '<em><b>Receptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SENSOR__RECEPTORS = eINSTANCE.getSensor_Receptors();

		/**
		 * The meta object literal for the '<em><b>Throttle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__THROTTLE = eINSTANCE.getSensor_Throttle();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.EffectorImpl <em>Effector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.EffectorImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getEffector()
		 * @generated
		 */
		EClass EFFECTOR = eINSTANCE.getEffector();

		/**
		 * The meta object literal for the '<em><b>Proxy For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFFECTOR__PROXY_FOR = eINSTANCE.getEffector_ProxyFor();

		/**
		 * The meta object literal for the '<em><b>Sustain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFECTOR__SUSTAIN = eINSTANCE.getEffector_Sustain();

		/**
		 * The meta object literal for the '<em><b>Throttle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFECTOR__THROTTLE = eINSTANCE.getEffector_Throttle();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.CommandImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Proxy For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND__PROXY_FOR = eINSTANCE.getCommand_ProxyFor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__ID = eINSTANCE.getCommand_Id();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.EventImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Proxy For</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PROXY_FOR = eINSTANCE.getEvent_ProxyFor();

		/**
		 * The meta object literal for the '<em><b>Receptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__RECEPTORS = eINSTANCE.getEvent_Receptors();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__ID = eINSTANCE.getEvent_Id();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.ChannelImpl <em>Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.ChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getChannel()
		 * @generated
		 */
		EClass CHANNEL = eINSTANCE.getChannel();

		/**
		 * The meta object literal for the '<em><b>Devices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__DEVICES = eINSTANCE.getChannel_Devices();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.LinearChannelImpl <em>Linear Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.LinearChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getLinearChannel()
		 * @generated
		 */
		EClass LINEAR_CHANNEL = eINSTANCE.getLinearChannel();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_CHANNEL__MODE = eINSTANCE.getLinearChannel_Mode();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.CommandChannelImpl <em>Command Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.CommandChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getCommandChannel()
		 * @generated
		 */
		EClass COMMAND_CHANNEL = eINSTANCE.getCommandChannel();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.AudioChannelImpl <em>Audio Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.AudioChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getAudioChannel()
		 * @generated
		 */
		EClass AUDIO_CHANNEL = eINSTANCE.getAudioChannel();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.VoiceChannelImpl <em>Voice Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.VoiceChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getVoiceChannel()
		 * @generated
		 */
		EClass VOICE_CHANNEL = eINSTANCE.getVoiceChannel();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.ColorChannelImpl <em>Color Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.ColorChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getColorChannel()
		 * @generated
		 */
		EClass COLOR_CHANNEL = eINSTANCE.getColorChannel();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_CHANNEL__MODE = eINSTANCE.getColorChannel_Mode();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.TextChannelImpl <em>Text Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.TextChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getTextChannel()
		 * @generated
		 */
		EClass TEXT_CHANNEL = eINSTANCE.getTextChannel();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.MatrixChannelImpl <em>Matrix Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.MatrixChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getMatrixChannel()
		 * @generated
		 */
		EClass MATRIX_CHANNEL = eINSTANCE.getMatrixChannel();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.impl.FileChannelImpl <em>File Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.FileChannelImpl
		 * @see org.roboid.robot.impl.RobotPackageImpl#getFileChannel()
		 * @generated
		 */
		EClass FILE_CHANNEL = eINSTANCE.getFileChannel();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.DataType
		 * @see org.roboid.robot.impl.RobotPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.AccessType <em>Access Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.AccessType
		 * @see org.roboid.robot.impl.RobotPackageImpl#getAccessType()
		 * @generated
		 */
		EEnum ACCESS_TYPE = eINSTANCE.getAccessType();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.LinearMode <em>Linear Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.LinearMode
		 * @see org.roboid.robot.impl.RobotPackageImpl#getLinearMode()
		 * @generated
		 */
		EEnum LINEAR_MODE = eINSTANCE.getLinearMode();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.AudioMode <em>Audio Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.AudioMode
		 * @see org.roboid.robot.impl.RobotPackageImpl#getAudioMode()
		 * @generated
		 */
		EEnum AUDIO_MODE = eINSTANCE.getAudioMode();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.ColorMode <em>Color Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.ColorMode
		 * @see org.roboid.robot.impl.RobotPackageImpl#getColorMode()
		 * @generated
		 */
		EEnum COLOR_MODE = eINSTANCE.getColorMode();

		/**
		 * The meta object literal for the '{@link org.roboid.robot.IoMode <em>Io Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.IoMode
		 * @see org.roboid.robot.impl.RobotPackageImpl#getIoMode()
		 * @generated
		 */
		EEnum IO_MODE = eINSTANCE.getIoMode();

		/**
		 * The meta object literal for the '<em>Int Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.RobotPackageImpl#getIntArray()
		 * @generated
		 */
		EDataType INT_ARRAY = eINSTANCE.getIntArray();

		/**
		 * The meta object literal for the '<em>Float Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.RobotPackageImpl#getFloatArray()
		 * @generated
		 */
		EDataType FLOAT_ARRAY = eINSTANCE.getFloatArray();

		/**
		 * The meta object literal for the '<em>String Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.RobotPackageImpl#getStringArray()
		 * @generated
		 */
		EDataType STRING_ARRAY = eINSTANCE.getStringArray();

		/**
		 * The meta object literal for the '<em>Image Data Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.robot.impl.RobotPackageImpl#getImageDataArray()
		 * @generated
		 */
		EDataType IMAGE_DATA_ARRAY = eINSTANCE.getImageDataArray();

		/**
		 * The meta object literal for the '<em>Image Data</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.ImageData
		 * @see org.roboid.robot.impl.RobotPackageImpl#getImageData()
		 * @generated
		 */
		EDataType IMAGE_DATA = eINSTANCE.getImageData();

		/**
		 * The meta object literal for the '<em>Byte Array Input Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.ByteArrayInputStream
		 * @see org.roboid.robot.impl.RobotPackageImpl#getByteArrayInputStream()
		 * @generated
		 */
		EDataType BYTE_ARRAY_INPUT_STREAM = eINSTANCE.getByteArrayInputStream();

		/**
		 * The meta object literal for the '<em>Byte Array Output Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.ByteArrayOutputStream
		 * @see org.roboid.robot.impl.RobotPackageImpl#getByteArrayOutputStream()
		 * @generated
		 */
		EDataType BYTE_ARRAY_OUTPUT_STREAM = eINSTANCE.getByteArrayOutputStream();

	}

} //RobotPackage
