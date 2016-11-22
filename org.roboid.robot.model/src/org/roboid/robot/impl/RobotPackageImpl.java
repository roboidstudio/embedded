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

package org.roboid.robot.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.swt.graphics.ImageData;

import org.roboid.robot.AccessType;
import org.roboid.robot.AudioChannel;
import org.roboid.robot.AudioMode;
import org.roboid.robot.Channel;
import org.roboid.robot.ChannelDevice;
import org.roboid.robot.ColorChannel;
import org.roboid.robot.ColorMode;
import org.roboid.robot.Command;
import org.roboid.robot.CommandChannel;
import org.roboid.robot.Control;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.Effector;
import org.roboid.robot.Event;
import org.roboid.robot.FileChannel;
import org.roboid.robot.Findable;
import org.roboid.robot.IoMode;
import org.roboid.robot.LinearChannel;
import org.roboid.robot.LinearMode;
import org.roboid.robot.MatrixChannel;
import org.roboid.robot.MotoringDevice;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Port;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.Sensor;
import org.roboid.robot.SensoryDevice;
import org.roboid.robot.Simulacra;
import org.roboid.robot.Storable;
import org.roboid.robot.TextChannel;
import org.roboid.robot.VoiceChannel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RobotPackageImpl extends EPackageImpl implements RobotPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass findableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulacraEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass robotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roboidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protocolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensoryDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motoringDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass effectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass audioChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voiceChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matrixChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linearModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum audioModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum colorModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ioModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType floatArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageDataArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageDataEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType byteArrayInputStreamEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType byteArrayOutputStreamEDataType = null;

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
	 * @see org.roboid.robot.RobotPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RobotPackageImpl() {
		super(eNS_URI, RobotFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RobotPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RobotPackage init() {
		if (isInited) return (RobotPackage)EPackage.Registry.INSTANCE.getEPackage(RobotPackage.eNS_URI);

		// Obtain or create and register package
		RobotPackageImpl theRobotPackage = (RobotPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RobotPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RobotPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theRobotPackage.createPackageContents();

		// Initialize created meta-data
		theRobotPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRobotPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RobotPackage.eNS_URI, theRobotPackage);
		return theRobotPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Literal() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Comment() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStorable() {
		return storableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFindable() {
		return findableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulacra() {
		return simulacraEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceListener() {
		return deviceListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRobot() {
		return robotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRobot_Provider() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRobot_Version() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRobot_Roboids() {
		return (EReference)robotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRobot_Controls() {
		return (EReference)robotEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRobot_Standard() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoboid() {
		return roboidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboid_Id() {
		return (EAttribute)roboidEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboid_Uid() {
		return (EAttribute)roboidEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboid_Roboids() {
		return (EReference)roboidEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboid_Protocol() {
		return (EReference)roboidEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboid_Devices() {
		return (EReference)roboidEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboid_Version() {
		return (EAttribute)roboidEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboid_Provider() {
		return (EAttribute)roboidEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoboid_HostRoboid() {
		return (EReference)roboidEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoboid_Address() {
		return (EAttribute)roboidEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControl() {
		return controlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControl_Channels() {
		return (EReference)controlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControl_Version() {
		return (EAttribute)controlEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControl_FrameLimit() {
		return (EAttribute)controlEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtocol() {
		return protocolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocol_Version() {
		return (EAttribute)protocolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocol_BufferSize() {
		return (EAttribute)protocolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtocol_RemainingBuffer() {
		return (EAttribute)protocolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Mode() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_ProxyFor() {
		return (EReference)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDevice() {
		return deviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_DataSize() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_DataType() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Max() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Min() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Default() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Proxy() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDevice_Access() {
		return (EAttribute)deviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelDevice() {
		return channelDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensoryDevice() {
		return sensoryDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotoringDevice() {
		return motoringDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensor() {
		return sensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensor_ProxyFor() {
		return (EReference)sensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensor_Receptors() {
		return (EReference)sensorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensor_Throttle() {
		return (EAttribute)sensorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEffector() {
		return effectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEffector_ProxyFor() {
		return (EReference)effectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffector_Sustain() {
		return (EAttribute)effectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffector_Throttle() {
		return (EAttribute)effectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommand_ProxyFor() {
		return (EReference)commandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_Id() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_ProxyFor() {
		return (EReference)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Receptors() {
		return (EReference)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Id() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannel() {
		return channelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannel_Devices() {
		return (EReference)channelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearChannel() {
		return linearChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinearChannel_Mode() {
		return (EAttribute)linearChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandChannel() {
		return commandChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAudioChannel() {
		return audioChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoiceChannel() {
		return voiceChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorChannel() {
		return colorChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorChannel_Mode() {
		return (EAttribute)colorChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextChannel() {
		return textChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatrixChannel() {
		return matrixChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileChannel() {
		return fileChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataType() {
		return dataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessType() {
		return accessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLinearMode() {
		return linearModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAudioMode() {
		return audioModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColorMode() {
		return colorModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIoMode() {
		return ioModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIntArray() {
		return intArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFloatArray() {
		return floatArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStringArray() {
		return stringArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageDataArray() {
		return imageDataArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageData() {
		return imageDataEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getByteArrayInputStream() {
		return byteArrayInputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getByteArrayOutputStream() {
		return byteArrayOutputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotFactory getRobotFactory() {
		return (RobotFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__LITERAL);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__COMMENT);

		storableEClass = createEClass(STORABLE);

		findableEClass = createEClass(FINDABLE);

		simulacraEClass = createEClass(SIMULACRA);

		deviceListenerEClass = createEClass(DEVICE_LISTENER);

		robotEClass = createEClass(ROBOT);
		createEAttribute(robotEClass, ROBOT__PROVIDER);
		createEAttribute(robotEClass, ROBOT__VERSION);
		createEReference(robotEClass, ROBOT__ROBOIDS);
		createEReference(robotEClass, ROBOT__CONTROLS);
		createEAttribute(robotEClass, ROBOT__STANDARD);

		roboidEClass = createEClass(ROBOID);
		createEAttribute(roboidEClass, ROBOID__ID);
		createEAttribute(roboidEClass, ROBOID__UID);
		createEReference(roboidEClass, ROBOID__ROBOIDS);
		createEReference(roboidEClass, ROBOID__PROTOCOL);
		createEReference(roboidEClass, ROBOID__DEVICES);
		createEAttribute(roboidEClass, ROBOID__VERSION);
		createEAttribute(roboidEClass, ROBOID__PROVIDER);
		createEReference(roboidEClass, ROBOID__HOST_ROBOID);
		createEAttribute(roboidEClass, ROBOID__ADDRESS);

		controlEClass = createEClass(CONTROL);
		createEReference(controlEClass, CONTROL__CHANNELS);
		createEAttribute(controlEClass, CONTROL__VERSION);
		createEAttribute(controlEClass, CONTROL__FRAME_LIMIT);

		protocolEClass = createEClass(PROTOCOL);
		createEAttribute(protocolEClass, PROTOCOL__VERSION);
		createEAttribute(protocolEClass, PROTOCOL__BUFFER_SIZE);
		createEAttribute(protocolEClass, PROTOCOL__REMAINING_BUFFER);

		deviceEClass = createEClass(DEVICE);
		createEAttribute(deviceEClass, DEVICE__DATA_SIZE);
		createEAttribute(deviceEClass, DEVICE__DATA_TYPE);
		createEAttribute(deviceEClass, DEVICE__MAX);
		createEAttribute(deviceEClass, DEVICE__MIN);
		createEAttribute(deviceEClass, DEVICE__DEFAULT);
		createEAttribute(deviceEClass, DEVICE__PROXY);
		createEAttribute(deviceEClass, DEVICE__ACCESS);

		channelDeviceEClass = createEClass(CHANNEL_DEVICE);

		sensoryDeviceEClass = createEClass(SENSORY_DEVICE);

		motoringDeviceEClass = createEClass(MOTORING_DEVICE);

		sensorEClass = createEClass(SENSOR);
		createEReference(sensorEClass, SENSOR__PROXY_FOR);
		createEReference(sensorEClass, SENSOR__RECEPTORS);
		createEAttribute(sensorEClass, SENSOR__THROTTLE);

		effectorEClass = createEClass(EFFECTOR);
		createEReference(effectorEClass, EFFECTOR__PROXY_FOR);
		createEAttribute(effectorEClass, EFFECTOR__SUSTAIN);
		createEAttribute(effectorEClass, EFFECTOR__THROTTLE);

		commandEClass = createEClass(COMMAND);
		createEReference(commandEClass, COMMAND__PROXY_FOR);
		createEAttribute(commandEClass, COMMAND__ID);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__PROXY_FOR);
		createEReference(eventEClass, EVENT__RECEPTORS);
		createEAttribute(eventEClass, EVENT__ID);

		portEClass = createEClass(PORT);
		createEAttribute(portEClass, PORT__MODE);
		createEReference(portEClass, PORT__PROXY_FOR);

		channelEClass = createEClass(CHANNEL);
		createEReference(channelEClass, CHANNEL__DEVICES);

		linearChannelEClass = createEClass(LINEAR_CHANNEL);
		createEAttribute(linearChannelEClass, LINEAR_CHANNEL__MODE);

		commandChannelEClass = createEClass(COMMAND_CHANNEL);

		audioChannelEClass = createEClass(AUDIO_CHANNEL);

		voiceChannelEClass = createEClass(VOICE_CHANNEL);

		colorChannelEClass = createEClass(COLOR_CHANNEL);
		createEAttribute(colorChannelEClass, COLOR_CHANNEL__MODE);

		textChannelEClass = createEClass(TEXT_CHANNEL);

		matrixChannelEClass = createEClass(MATRIX_CHANNEL);

		fileChannelEClass = createEClass(FILE_CHANNEL);

		// Create enums
		dataTypeEEnum = createEEnum(DATA_TYPE);
		accessTypeEEnum = createEEnum(ACCESS_TYPE);
		linearModeEEnum = createEEnum(LINEAR_MODE);
		audioModeEEnum = createEEnum(AUDIO_MODE);
		colorModeEEnum = createEEnum(COLOR_MODE);
		ioModeEEnum = createEEnum(IO_MODE);

		// Create data types
		intArrayEDataType = createEDataType(INT_ARRAY);
		floatArrayEDataType = createEDataType(FLOAT_ARRAY);
		stringArrayEDataType = createEDataType(STRING_ARRAY);
		imageDataArrayEDataType = createEDataType(IMAGE_DATA_ARRAY);
		imageDataEDataType = createEDataType(IMAGE_DATA);
		byteArrayInputStreamEDataType = createEDataType(BYTE_ARRAY_INPUT_STREAM);
		byteArrayOutputStreamEDataType = createEDataType(BYTE_ARRAY_OUTPUT_STREAM);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		robotEClass.getESuperTypes().add(this.getNamedElement());
		robotEClass.getESuperTypes().add(this.getStorable());
		robotEClass.getESuperTypes().add(this.getFindable());
		roboidEClass.getESuperTypes().add(this.getNamedElement());
		roboidEClass.getESuperTypes().add(this.getStorable());
		roboidEClass.getESuperTypes().add(this.getSimulacra());
		roboidEClass.getESuperTypes().add(this.getFindable());
		controlEClass.getESuperTypes().add(this.getNamedElement());
		protocolEClass.getESuperTypes().add(this.getNamedElement());
		deviceEClass.getESuperTypes().add(this.getNamedElement());
		deviceEClass.getESuperTypes().add(this.getStorable());
		deviceEClass.getESuperTypes().add(this.getSimulacra());
		channelDeviceEClass.getESuperTypes().add(this.getDevice());
		sensoryDeviceEClass.getESuperTypes().add(this.getDevice());
		motoringDeviceEClass.getESuperTypes().add(this.getChannelDevice());
		sensorEClass.getESuperTypes().add(this.getSensoryDevice());
		effectorEClass.getESuperTypes().add(this.getMotoringDevice());
		commandEClass.getESuperTypes().add(this.getMotoringDevice());
		eventEClass.getESuperTypes().add(this.getSensoryDevice());
		portEClass.getESuperTypes().add(this.getChannelDevice());
		channelEClass.getESuperTypes().add(this.getNamedElement());
		linearChannelEClass.getESuperTypes().add(this.getChannel());
		commandChannelEClass.getESuperTypes().add(this.getChannel());
		audioChannelEClass.getESuperTypes().add(this.getChannel());
		voiceChannelEClass.getESuperTypes().add(this.getChannel());
		colorChannelEClass.getESuperTypes().add(this.getChannel());
		textChannelEClass.getESuperTypes().add(this.getChannel());
		matrixChannelEClass.getESuperTypes().add(this.getLinearChannel());
		fileChannelEClass.getESuperTypes().add(this.getChannel());

		// Initialize classes and features; add operations and parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Literal(), ecorePackage.getEString(), "literal", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(namedElementEClass, this.getNamedElement(), "getParent", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(namedElementEClass, this.getNamedElement(), "getChildren", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(namedElementEClass, ecorePackage.getEBoolean(), "equalsContents", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(namedElementEClass, ecorePackage.getEString(), "getFullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(storableEClass, Storable.class, "Storable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(storableEClass, null, "createDeviceMemory", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(storableEClass, null, "clearDeviceMemory", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(findableEClass, Findable.class, "Findable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(findableEClass, this.getDevice(), "findDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(findableEClass, this.getRoboid(), "findRoboid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simulacraEClass, Simulacra.class, "Simulacra", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(simulacraEClass, ecorePackage.getEInt(), "setDeviceMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEByteArray(), "deviceMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isMaster", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(simulacraEClass, null, "setPayload", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getByteArrayInputStream(), "simulacrum", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isMaster", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(simulacraEClass, null, "getSimulacrum", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getByteArrayOutputStream(), "deviceMap", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getByteArrayOutputStream(), "payload", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(simulacraEClass, ecorePackage.getEBoolean(), "isReceived", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(simulacraEClass, ecorePackage.getEBoolean(), "canSend", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(simulacraEClass, null, "updateDeviceState", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(deviceListenerEClass, DeviceListener.class, "DeviceListener", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(deviceListenerEClass, null, "effectPerformed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceListenerEClass, null, "commandPerformed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceListenerEClass, null, "stateChanged", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceListenerEClass, null, "handleEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(robotEClass, Robot.class, "Robot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRobot_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRobot_Version(), ecorePackage.getEString(), "version", "1.0.0", 0, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRobot_Roboids(), this.getRoboid(), null, "roboids", null, 1, -1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRobot_Controls(), this.getControl(), null, "controls", null, 0, -1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRobot_Standard(), ecorePackage.getEString(), "standard", "RUPI 2.0", 0, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(robotEClass, this.getProtocol(), "getProtocol", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotEClass, this.getDevice(), "collectAllDevices", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "devices", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotEClass, ecorePackage.getEString(), "collectAllDeviceNames", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "names", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(robotEClass, ecorePackage.getEString(), "collectAllActiveDeviceNames", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "names", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(roboidEClass, Roboid.class, "Roboid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboid_Id(), ecorePackage.getEString(), "id", null, 1, 1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboid_Uid(), ecorePackage.getEString(), "uid", null, 0, 1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboid_Roboids(), this.getRoboid(), null, "roboids", null, 0, -1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboid_Protocol(), this.getProtocol(), null, "protocol", null, 0, 1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboid_Devices(), this.getDevice(), null, "devices", null, 0, -1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboid_Version(), ecorePackage.getEString(), "version", "1.0.0", 0, 1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboid_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoboid_HostRoboid(), this.getRoboid(), null, "hostRoboid", null, 0, 1, Roboid.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoboid_Address(), ecorePackage.getEString(), "address", null, 0, 1, Roboid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(roboidEClass, this.getDevice(), "collectAllDevices", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "devices", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(controlEClass, Control.class, "Control", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControl_Channels(), this.getChannel(), null, "channels", null, 0, -1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getControl_Version(), ecorePackage.getEString(), "version", "1.0.0", 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getControl_FrameLimit(), ecorePackage.getEInt(), "frameLimit", "9999", 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protocolEClass, Protocol.class, "Protocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProtocol_Version(), ecorePackage.getEString(), "version", "1.0.0", 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtocol_BufferSize(), ecorePackage.getEInt(), "bufferSize", "8", 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtocol_RemainingBuffer(), ecorePackage.getEInt(), "remainingBuffer", "20", 0, 1, Protocol.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(protocolEClass, ecorePackage.getEByteArray(), "getSimulacrum", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(protocolEClass, null, "setSimulacrum", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEByteArray(), "simulacrum", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isMaster", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(protocolEClass, null, "clearBuffer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(protocolEClass, null, "setEvents", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(protocolEClass, ecorePackage.getEInt(), "getBufferId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(deviceEClass, Device.class, "Device", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDevice_DataSize(), ecorePackage.getEInt(), "dataSize", "1", 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_DataType(), this.getDataType(), "dataType", "", 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Max(), ecorePackage.getEString(), "max", "0", 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Min(), ecorePackage.getEString(), "min", "0", 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Default(), ecorePackage.getEString(), "default", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Proxy(), ecorePackage.getEBoolean(), "proxy", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDevice_Access(), this.getAccessType(), "access", "", 0, 1, Device.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFloatArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringArray(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageData(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageData(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "write", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageDataArray(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeInt", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeInt", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeInt", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeFloat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeFloat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEFloat(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeFloat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFloatArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringArray(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeImageData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageData(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeImageData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageData(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "writeImageData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageDataArray(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFloatArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageDataArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEFloat(), "readInt", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEFloat(), "readInt", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "readInt", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIntArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEFloat(), "readFloat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEFloat(), "readFloat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "readFloat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFloatArray(), "data", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEString(), "readString", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEString(), "readString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "readString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringArray(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, this.getImageData(), "readImageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, this.getImageData(), "readImageData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEInt(), "readImageData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImageDataArray(), "imageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEBoolean(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, null, "setEvent", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, null, "setFired", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, null, "addDeviceListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDeviceListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, null, "removeDeviceListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDeviceListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, this.getDeviceListener(), "getDeviceListeners", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEInt(), "getMin", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEFloat(), "getMinFloat", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEString(), "getMinString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEInt(), "getMax", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEFloat(), "getMaxFloat", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEString(), "getMaxString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEInt(), "getDefault", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEFloat(), "getDefaultFloat", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, ecorePackage.getEString(), "getDefaultString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, this.getImageData(), "getDefaultImageData", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(deviceEClass, this.getRoboid(), "getRootRoboid", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(deviceEClass, ecorePackage.getEBoolean(), "isDataTypeOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "device", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(channelDeviceEClass, ChannelDevice.class, "ChannelDevice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sensoryDeviceEClass, SensoryDevice.class, "SensoryDevice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sensoryDeviceEClass, null, "addReceptor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "receptor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sensoryDeviceEClass, null, "removeReceptor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDevice(), "receptor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(motoringDeviceEClass, MotoringDevice.class, "MotoringDevice", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sensorEClass, Sensor.class, "Sensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensor_ProxyFor(), this.getSensor(), null, "proxyFor", null, 0, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSensor_Receptors(), this.getEffector(), null, "receptors", null, 0, -1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSensor_Throttle(), ecorePackage.getEInt(), "throttle", "1", 0, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(effectorEClass, Effector.class, "Effector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEffector_ProxyFor(), this.getEffector(), null, "proxyFor", null, 0, 1, Effector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEffector_Sustain(), ecorePackage.getEInt(), "sustain", "5", 0, 1, Effector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEffector_Throttle(), ecorePackage.getEInt(), "throttle", "1", 0, 1, Effector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(effectorEClass, ecorePackage.getEBoolean(), "hasNext", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommand_ProxyFor(), this.getCommand(), null, "proxyFor", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Command.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_ProxyFor(), this.getEvent(), null, "proxyFor", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Receptors(), this.getCommand(), null, "receptors", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Event.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPort_Mode(), this.getIoMode(), "mode", "IoMode.NONE", 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_ProxyFor(), this.getPort(), null, "proxyFor", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(channelEClass, Channel.class, "Channel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChannel_Devices(), this.getChannelDevice(), null, "devices", null, 1, -1, Channel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(channelEClass, ecorePackage.getEBoolean(), "isEnabled", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(linearChannelEClass, LinearChannel.class, "LinearChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinearChannel_Mode(), this.getLinearMode(), "mode", null, 0, 1, LinearChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandChannelEClass, CommandChannel.class, "CommandChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(audioChannelEClass, AudioChannel.class, "AudioChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(voiceChannelEClass, VoiceChannel.class, "VoiceChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(colorChannelEClass, ColorChannel.class, "ColorChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorChannel_Mode(), this.getColorMode(), "mode", null, 0, 1, ColorChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textChannelEClass, TextChannel.class, "TextChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matrixChannelEClass, MatrixChannel.class, "MatrixChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileChannelEClass, FileChannel.class, "FileChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.BYTE);
		addEEnumLiteral(dataTypeEEnum, DataType.UNSIGNED_BYTE);
		addEEnumLiteral(dataTypeEEnum, DataType.SHORT);
		addEEnumLiteral(dataTypeEEnum, DataType.UNSIGNED_SHORT);
		addEEnumLiteral(dataTypeEEnum, DataType.INTEGER);
		addEEnumLiteral(dataTypeEEnum, DataType.FLOAT);
		addEEnumLiteral(dataTypeEEnum, DataType.STRING);
		addEEnumLiteral(dataTypeEEnum, DataType.IMAGE);

		initEEnum(accessTypeEEnum, AccessType.class, "AccessType");
		addEEnumLiteral(accessTypeEEnum, AccessType.PUBLIC);
		addEEnumLiteral(accessTypeEEnum, AccessType.PRIVATE);

		initEEnum(linearModeEEnum, LinearMode.class, "LinearMode");
		addEEnumLiteral(linearModeEEnum, LinearMode.LINEAR);
		addEEnumLiteral(linearModeEEnum, LinearMode.SUSTAIN);

		initEEnum(audioModeEEnum, AudioMode.class, "AudioMode");
		addEEnumLiteral(audioModeEEnum, AudioMode.MONO);
		addEEnumLiteral(audioModeEEnum, AudioMode.STEREO);

		initEEnum(colorModeEEnum, ColorMode.class, "ColorMode");
		addEEnumLiteral(colorModeEEnum, ColorMode.RGB);
		addEEnumLiteral(colorModeEEnum, ColorMode.RED_GREEN);
		addEEnumLiteral(colorModeEEnum, ColorMode.RED);
		addEEnumLiteral(colorModeEEnum, ColorMode.GREEN);
		addEEnumLiteral(colorModeEEnum, ColorMode.BLUE);
		addEEnumLiteral(colorModeEEnum, ColorMode.GRAY);

		initEEnum(ioModeEEnum, IoMode.class, "IoMode");
		addEEnumLiteral(ioModeEEnum, IoMode.NONE);
		addEEnumLiteral(ioModeEEnum, IoMode.ANALOG_INPUT);
		addEEnumLiteral(ioModeEEnum, IoMode.DIGITAL_INPUT);
		addEEnumLiteral(ioModeEEnum, IoMode.SERVO_OUTPUT);
		addEEnumLiteral(ioModeEEnum, IoMode.PWM_OUTPUT);
		addEEnumLiteral(ioModeEEnum, IoMode.DIGITAL_OUTPUT);

		// Initialize data types
		initEDataType(intArrayEDataType, int[].class, "IntArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatArrayEDataType, float[].class, "FloatArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringArrayEDataType, String[].class, "StringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageDataArrayEDataType, ImageData[].class, "ImageDataArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageDataEDataType, ImageData.class, "ImageData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(byteArrayInputStreamEDataType, ByteArrayInputStream.class, "ByteArrayInputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(byteArrayOutputStreamEDataType, ByteArrayOutputStream.class, "ByteArrayOutputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RobotPackageImpl
