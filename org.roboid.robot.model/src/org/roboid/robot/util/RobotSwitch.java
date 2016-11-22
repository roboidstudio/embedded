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

package org.roboid.robot.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.roboid.robot.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.roboid.robot.RobotPackage
 * @generated
 */
public class RobotSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RobotPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotSwitch() {
		if (modelPackage == null) {
			modelPackage = RobotPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RobotPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.STORABLE: {
				Storable storable = (Storable)theEObject;
				T result = caseStorable(storable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.FINDABLE: {
				Findable findable = (Findable)theEObject;
				T result = caseFindable(findable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.SIMULACRA: {
				Simulacra simulacra = (Simulacra)theEObject;
				T result = caseSimulacra(simulacra);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.DEVICE_LISTENER: {
				DeviceListener deviceListener = (DeviceListener)theEObject;
				T result = caseDeviceListener(deviceListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.ROBOT: {
				Robot robot = (Robot)theEObject;
				T result = caseRobot(robot);
				if (result == null) result = caseNamedElement(robot);
				if (result == null) result = caseStorable(robot);
				if (result == null) result = caseFindable(robot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.ROBOID: {
				Roboid roboid = (Roboid)theEObject;
				T result = caseRoboid(roboid);
				if (result == null) result = caseNamedElement(roboid);
				if (result == null) result = caseStorable(roboid);
				if (result == null) result = caseSimulacra(roboid);
				if (result == null) result = caseFindable(roboid);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.CONTROL: {
				Control control = (Control)theEObject;
				T result = caseControl(control);
				if (result == null) result = caseNamedElement(control);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.PROTOCOL: {
				Protocol protocol = (Protocol)theEObject;
				T result = caseProtocol(protocol);
				if (result == null) result = caseNamedElement(protocol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.DEVICE: {
				Device device = (Device)theEObject;
				T result = caseDevice(device);
				if (result == null) result = caseNamedElement(device);
				if (result == null) result = caseStorable(device);
				if (result == null) result = caseSimulacra(device);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.CHANNEL_DEVICE: {
				ChannelDevice channelDevice = (ChannelDevice)theEObject;
				T result = caseChannelDevice(channelDevice);
				if (result == null) result = caseDevice(channelDevice);
				if (result == null) result = caseNamedElement(channelDevice);
				if (result == null) result = caseStorable(channelDevice);
				if (result == null) result = caseSimulacra(channelDevice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.SENSORY_DEVICE: {
				SensoryDevice sensoryDevice = (SensoryDevice)theEObject;
				T result = caseSensoryDevice(sensoryDevice);
				if (result == null) result = caseDevice(sensoryDevice);
				if (result == null) result = caseNamedElement(sensoryDevice);
				if (result == null) result = caseStorable(sensoryDevice);
				if (result == null) result = caseSimulacra(sensoryDevice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.MOTORING_DEVICE: {
				MotoringDevice motoringDevice = (MotoringDevice)theEObject;
				T result = caseMotoringDevice(motoringDevice);
				if (result == null) result = caseChannelDevice(motoringDevice);
				if (result == null) result = caseDevice(motoringDevice);
				if (result == null) result = caseNamedElement(motoringDevice);
				if (result == null) result = caseStorable(motoringDevice);
				if (result == null) result = caseSimulacra(motoringDevice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.SENSOR: {
				Sensor sensor = (Sensor)theEObject;
				T result = caseSensor(sensor);
				if (result == null) result = caseSensoryDevice(sensor);
				if (result == null) result = caseDevice(sensor);
				if (result == null) result = caseNamedElement(sensor);
				if (result == null) result = caseStorable(sensor);
				if (result == null) result = caseSimulacra(sensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.EFFECTOR: {
				Effector effector = (Effector)theEObject;
				T result = caseEffector(effector);
				if (result == null) result = caseMotoringDevice(effector);
				if (result == null) result = caseChannelDevice(effector);
				if (result == null) result = caseDevice(effector);
				if (result == null) result = caseNamedElement(effector);
				if (result == null) result = caseStorable(effector);
				if (result == null) result = caseSimulacra(effector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.COMMAND: {
				Command command = (Command)theEObject;
				T result = caseCommand(command);
				if (result == null) result = caseMotoringDevice(command);
				if (result == null) result = caseChannelDevice(command);
				if (result == null) result = caseDevice(command);
				if (result == null) result = caseNamedElement(command);
				if (result == null) result = caseStorable(command);
				if (result == null) result = caseSimulacra(command);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseSensoryDevice(event);
				if (result == null) result = caseDevice(event);
				if (result == null) result = caseNamedElement(event);
				if (result == null) result = caseStorable(event);
				if (result == null) result = caseSimulacra(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseChannelDevice(port);
				if (result == null) result = caseDevice(port);
				if (result == null) result = caseNamedElement(port);
				if (result == null) result = caseStorable(port);
				if (result == null) result = caseSimulacra(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.CHANNEL: {
				Channel channel = (Channel)theEObject;
				T result = caseChannel(channel);
				if (result == null) result = caseNamedElement(channel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.LINEAR_CHANNEL: {
				LinearChannel linearChannel = (LinearChannel)theEObject;
				T result = caseLinearChannel(linearChannel);
				if (result == null) result = caseChannel(linearChannel);
				if (result == null) result = caseNamedElement(linearChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.COMMAND_CHANNEL: {
				CommandChannel commandChannel = (CommandChannel)theEObject;
				T result = caseCommandChannel(commandChannel);
				if (result == null) result = caseChannel(commandChannel);
				if (result == null) result = caseNamedElement(commandChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.AUDIO_CHANNEL: {
				AudioChannel audioChannel = (AudioChannel)theEObject;
				T result = caseAudioChannel(audioChannel);
				if (result == null) result = caseChannel(audioChannel);
				if (result == null) result = caseNamedElement(audioChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.VOICE_CHANNEL: {
				VoiceChannel voiceChannel = (VoiceChannel)theEObject;
				T result = caseVoiceChannel(voiceChannel);
				if (result == null) result = caseChannel(voiceChannel);
				if (result == null) result = caseNamedElement(voiceChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.COLOR_CHANNEL: {
				ColorChannel colorChannel = (ColorChannel)theEObject;
				T result = caseColorChannel(colorChannel);
				if (result == null) result = caseChannel(colorChannel);
				if (result == null) result = caseNamedElement(colorChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.TEXT_CHANNEL: {
				TextChannel textChannel = (TextChannel)theEObject;
				T result = caseTextChannel(textChannel);
				if (result == null) result = caseChannel(textChannel);
				if (result == null) result = caseNamedElement(textChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.MATRIX_CHANNEL: {
				MatrixChannel matrixChannel = (MatrixChannel)theEObject;
				T result = caseMatrixChannel(matrixChannel);
				if (result == null) result = caseLinearChannel(matrixChannel);
				if (result == null) result = caseChannel(matrixChannel);
				if (result == null) result = caseNamedElement(matrixChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotPackage.FILE_CHANNEL: {
				FileChannel fileChannel = (FileChannel)theEObject;
				T result = caseFileChannel(fileChannel);
				if (result == null) result = caseChannel(fileChannel);
				if (result == null) result = caseNamedElement(fileChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStorable(Storable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Findable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Findable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFindable(Findable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simulacra</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simulacra</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimulacra(Simulacra object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceListener(DeviceListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Robot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Robot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRobot(Robot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roboid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roboid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboid(Roboid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControl(Control object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocol(Protocol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDevice(Device object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelDevice(ChannelDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensory Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensory Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensoryDevice(SensoryDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motoring Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motoring Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotoringDevice(MotoringDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensor(Sensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEffector(Effector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannel(Channel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearChannel(LinearChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandChannel(CommandChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Audio Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Audio Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAudioChannel(AudioChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voice Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voice Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoiceChannel(VoiceChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorChannel(ColorChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextChannel(TextChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matrix Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matrix Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatrixChannel(MatrixChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileChannel(FileChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //RobotSwitch
