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
import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.graphics.ImageData;
import org.roboid.robot.*;
import org.roboid.robot.AccessType;
import org.roboid.robot.AudioChannel;
import org.roboid.robot.AudioMode;
import org.roboid.robot.ColorChannel;
import org.roboid.robot.ColorMode;
import org.roboid.robot.Command;
import org.roboid.robot.CommandChannel;
import org.roboid.robot.Control;
import org.roboid.robot.DataType;
import org.roboid.robot.Effector;
import org.roboid.robot.Event;
import org.roboid.robot.LinearChannel;
import org.roboid.robot.LinearMode;
import org.roboid.robot.MatrixChannel;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.Sensor;
import org.roboid.robot.TextChannel;
import org.roboid.robot.VoiceChannel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class RobotFactoryImpl extends EFactoryImpl implements RobotFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RobotFactory init() {
		try {
			RobotFactory theRobotFactory = (RobotFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.roboidstudio.org/model/robot"); 
			if (theRobotFactory != null) {
				return theRobotFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RobotFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RobotPackage.ROBOT: return (EObject)createRobot();
			case RobotPackage.ROBOID: return (EObject)createRoboid();
			case RobotPackage.CONTROL: return (EObject)createControl();
			case RobotPackage.PROTOCOL: return (EObject)createProtocol();
			case RobotPackage.SENSOR: return (EObject)createSensor();
			case RobotPackage.EFFECTOR: return (EObject)createEffector();
			case RobotPackage.COMMAND: return (EObject)createCommand();
			case RobotPackage.EVENT: return (EObject)createEvent();
			case RobotPackage.PORT: return (EObject)createPort();
			case RobotPackage.LINEAR_CHANNEL: return (EObject)createLinearChannel();
			case RobotPackage.COMMAND_CHANNEL: return (EObject)createCommandChannel();
			case RobotPackage.AUDIO_CHANNEL: return (EObject)createAudioChannel();
			case RobotPackage.VOICE_CHANNEL: return (EObject)createVoiceChannel();
			case RobotPackage.COLOR_CHANNEL: return (EObject)createColorChannel();
			case RobotPackage.TEXT_CHANNEL: return (EObject)createTextChannel();
			case RobotPackage.MATRIX_CHANNEL: return (EObject)createMatrixChannel();
			case RobotPackage.FILE_CHANNEL: return (EObject)createFileChannel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case RobotPackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
			case RobotPackage.ACCESS_TYPE:
				return createAccessTypeFromString(eDataType, initialValue);
			case RobotPackage.LINEAR_MODE:
				return createLinearModeFromString(eDataType, initialValue);
			case RobotPackage.AUDIO_MODE:
				return createAudioModeFromString(eDataType, initialValue);
			case RobotPackage.COLOR_MODE:
				return createColorModeFromString(eDataType, initialValue);
			case RobotPackage.IO_MODE:
				return createIoModeFromString(eDataType, initialValue);
			case RobotPackage.INT_ARRAY:
				return createIntArrayFromString(eDataType, initialValue);
			case RobotPackage.FLOAT_ARRAY:
				return createFloatArrayFromString(eDataType, initialValue);
			case RobotPackage.STRING_ARRAY:
				return createStringArrayFromString(eDataType, initialValue);
			case RobotPackage.IMAGE_DATA_ARRAY:
				return createImageDataArrayFromString(eDataType, initialValue);
			case RobotPackage.IMAGE_DATA:
				return createImageDataFromString(eDataType, initialValue);
			case RobotPackage.BYTE_ARRAY_INPUT_STREAM:
				return createByteArrayInputStreamFromString(eDataType, initialValue);
			case RobotPackage.BYTE_ARRAY_OUTPUT_STREAM:
				return createByteArrayOutputStreamFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case RobotPackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			case RobotPackage.ACCESS_TYPE:
				return convertAccessTypeToString(eDataType, instanceValue);
			case RobotPackage.LINEAR_MODE:
				return convertLinearModeToString(eDataType, instanceValue);
			case RobotPackage.AUDIO_MODE:
				return convertAudioModeToString(eDataType, instanceValue);
			case RobotPackage.COLOR_MODE:
				return convertColorModeToString(eDataType, instanceValue);
			case RobotPackage.IO_MODE:
				return convertIoModeToString(eDataType, instanceValue);
			case RobotPackage.INT_ARRAY:
				return convertIntArrayToString(eDataType, instanceValue);
			case RobotPackage.FLOAT_ARRAY:
				return convertFloatArrayToString(eDataType, instanceValue);
			case RobotPackage.STRING_ARRAY:
				return convertStringArrayToString(eDataType, instanceValue);
			case RobotPackage.IMAGE_DATA_ARRAY:
				return convertImageDataArrayToString(eDataType, instanceValue);
			case RobotPackage.IMAGE_DATA:
				return convertImageDataToString(eDataType, instanceValue);
			case RobotPackage.BYTE_ARRAY_INPUT_STREAM:
				return convertByteArrayInputStreamToString(eDataType, instanceValue);
			case RobotPackage.BYTE_ARRAY_OUTPUT_STREAM:
				return convertByteArrayOutputStreamToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot createRobot() {
		RobotImpl robot = new RobotImpl();
		return robot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Roboid createRoboid() {
		RoboidImpl roboid = new RoboidImpl();
		return roboid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol createProtocol() {
		ProtocolImpl protocol = new ProtocolImpl();
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Control createControl() {
		ControlImpl control = new ControlImpl();
		return control;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sensor createSensor() {
		SensorImpl sensor = new SensorImpl();
		return sensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Effector createEffector() {
		EffectorImpl effector = new EffectorImpl();
		return effector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command createCommand() {
		CommandImpl command = new CommandImpl();
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearChannel createLinearChannel() {
		LinearChannelImpl linearChannel = new LinearChannelImpl();
		return linearChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandChannel createCommandChannel() {
		CommandChannelImpl commandChannel = new CommandChannelImpl();
		return commandChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AudioChannel createAudioChannel() {
		AudioChannelImpl audioChannel = new AudioChannelImpl();
		return audioChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceChannel createVoiceChannel() {
		VoiceChannelImpl voiceChannel = new VoiceChannelImpl();
		return voiceChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorChannel createColorChannel() {
		ColorChannelImpl colorChannel = new ColorChannelImpl();
		return colorChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextChannel createTextChannel() {
		TextChannelImpl textChannel = new TextChannelImpl();
		return textChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixChannel createMatrixChannel() {
		MatrixChannelImpl matrixChannel = new MatrixChannelImpl();
		return matrixChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileChannel createFileChannel() {
		FileChannelImpl fileChannel = new FileChannelImpl();
		return fileChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
		DataType result = DataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType createAccessTypeFromString(EDataType eDataType, String initialValue) {
		AccessType result = AccessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearMode createLinearModeFromString(EDataType eDataType, String initialValue) {
		LinearMode result = LinearMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinearModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AudioMode createAudioModeFromString(EDataType eDataType, String initialValue) {
		AudioMode result = AudioMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAudioModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorMode createColorModeFromString(EDataType eDataType, String initialValue) {
		ColorMode result = ColorMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertColorModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IoMode createIoModeFromString(EDataType eDataType, String initialValue) {
		IoMode result = IoMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIoModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int[] createIntArrayFromString(EDataType eDataType, String initialValue) {
		return (int[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float[] createFloatArrayFromString(EDataType eDataType, String initialValue)
	{
		return (float[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFloatArrayToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String[] createStringArrayFromString(EDataType eDataType, String initialValue)
	{
		return (String[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringArrayToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageData[] createImageDataArrayFromString(EDataType eDataType, String initialValue)
	{
		return (ImageData[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImageDataArrayToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageData createImageDataFromString(EDataType eDataType, String initialValue) {
		return (ImageData)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImageDataToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteArrayInputStream createByteArrayInputStreamFromString(EDataType eDataType, String initialValue) {
		return (ByteArrayInputStream)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertByteArrayInputStreamToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteArrayOutputStream createByteArrayOutputStreamFromString(EDataType eDataType, String initialValue) {
		return (ByteArrayOutputStream)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertByteArrayOutputStreamToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotPackage getRobotPackage() {
		return (RobotPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RobotPackage getPackage() {
		return RobotPackage.eINSTANCE;
	}
	
	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * @generated NOT
	 */
	public Robot createRobot(File file)
	{
		if(file == null) return null;
		URI uri = URI.createFileURI(file.getAbsolutePath());
		return createRobot(uri);
	}
	
	/**
	 * @generated NOT
	 */
	public Robot createRobot(URI uri)
	{
		if(uri == null) return null;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			Robot robot = (Robot)resource.getContents().get(0);
			robot.createDeviceMemory();
			return robot;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
} //RobotFactoryImpl
