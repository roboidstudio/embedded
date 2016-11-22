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

package org.roboid.studio.timeline.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.roboid.core.runtime.IClip;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ColorPoint;
import org.roboid.studio.timeline.ColorTrack;
import org.roboid.studio.timeline.CommandPoint;
import org.roboid.studio.timeline.CommandTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.FilePoint;
import org.roboid.studio.timeline.FileTrack;
import org.roboid.studio.timeline.LinearPoint;
import org.roboid.studio.timeline.LinearTrack;
import org.roboid.studio.timeline.MatrixPoint;
import org.roboid.studio.timeline.MatrixTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.MovableElement;
import org.roboid.studio.timeline.TextPoint;
import org.roboid.studio.timeline.TextTrack;
import org.roboid.studio.timeline.TimelineElement;
import org.roboid.studio.timeline.TimelinePackage;
import org.roboid.studio.timeline.VoicePoint;
import org.roboid.studio.timeline.VoiceTrack;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.timeline.TimelinePackage
 * @generated
 */
public class TimelineSwitch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TimelinePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimelineSwitch()
	{
		if (modelPackage == null) {
			modelPackage = TimelinePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject)
	{
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject)
	{
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
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID) {
			case TimelinePackage.TIMELINE_ELEMENT: {
				TimelineElement timelineElement = (TimelineElement)theEObject;
				T result = caseTimelineElement(timelineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.MOTION_CLIP: {
				MotionClip motionClip = (MotionClip)theEObject;
				T result = caseMotionClip(motionClip);
				if (result == null) result = caseTimelineElement(motionClip);
				if (result == null) result = caseIClip(motionClip);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.MOVABLE_ELEMENT: {
				MovableElement movableElement = (MovableElement)theEObject;
				T result = caseMovableElement(movableElement);
				if (result == null) result = caseTimelineElement(movableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.CONTROL_TRACK: {
				ControlTrack controlTrack = (ControlTrack)theEObject;
				T result = caseControlTrack(controlTrack);
				if (result == null) result = caseMovableElement(controlTrack);
				if (result == null) result = caseTimelineElement(controlTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.CHANNEL_TRACK: {
				ChannelTrack channelTrack = (ChannelTrack)theEObject;
				T result = caseChannelTrack(channelTrack);
				if (result == null) result = caseMovableElement(channelTrack);
				if (result == null) result = caseTimelineElement(channelTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.LINEAR_TRACK: {
				LinearTrack linearTrack = (LinearTrack)theEObject;
				T result = caseLinearTrack(linearTrack);
				if (result == null) result = caseChannelTrack(linearTrack);
				if (result == null) result = caseMovableElement(linearTrack);
				if (result == null) result = caseTimelineElement(linearTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.COMMAND_TRACK: {
				CommandTrack commandTrack = (CommandTrack)theEObject;
				T result = caseCommandTrack(commandTrack);
				if (result == null) result = caseChannelTrack(commandTrack);
				if (result == null) result = caseMovableElement(commandTrack);
				if (result == null) result = caseTimelineElement(commandTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.AUDIO_TRACK: {
				AudioTrack audioTrack = (AudioTrack)theEObject;
				T result = caseAudioTrack(audioTrack);
				if (result == null) result = caseChannelTrack(audioTrack);
				if (result == null) result = caseMovableElement(audioTrack);
				if (result == null) result = caseTimelineElement(audioTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.VOICE_TRACK: {
				VoiceTrack voiceTrack = (VoiceTrack)theEObject;
				T result = caseVoiceTrack(voiceTrack);
				if (result == null) result = caseAudioTrack(voiceTrack);
				if (result == null) result = caseChannelTrack(voiceTrack);
				if (result == null) result = caseMovableElement(voiceTrack);
				if (result == null) result = caseTimelineElement(voiceTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.COLOR_TRACK: {
				ColorTrack colorTrack = (ColorTrack)theEObject;
				T result = caseColorTrack(colorTrack);
				if (result == null) result = caseChannelTrack(colorTrack);
				if (result == null) result = caseMovableElement(colorTrack);
				if (result == null) result = caseTimelineElement(colorTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.TEXT_TRACK: {
				TextTrack textTrack = (TextTrack)theEObject;
				T result = caseTextTrack(textTrack);
				if (result == null) result = caseChannelTrack(textTrack);
				if (result == null) result = caseMovableElement(textTrack);
				if (result == null) result = caseTimelineElement(textTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.MATRIX_TRACK: {
				MatrixTrack matrixTrack = (MatrixTrack)theEObject;
				T result = caseMatrixTrack(matrixTrack);
				if (result == null) result = caseLinearTrack(matrixTrack);
				if (result == null) result = caseChannelTrack(matrixTrack);
				if (result == null) result = caseMovableElement(matrixTrack);
				if (result == null) result = caseTimelineElement(matrixTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.FILE_TRACK: {
				FileTrack fileTrack = (FileTrack)theEObject;
				T result = caseFileTrack(fileTrack);
				if (result == null) result = caseChannelTrack(fileTrack);
				if (result == null) result = caseMovableElement(fileTrack);
				if (result == null) result = caseTimelineElement(fileTrack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.CONTROL_POINT: {
				ControlPoint controlPoint = (ControlPoint)theEObject;
				T result = caseControlPoint(controlPoint);
				if (result == null) result = caseMovableElement(controlPoint);
				if (result == null) result = caseTimelineElement(controlPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.LINEAR_POINT: {
				LinearPoint linearPoint = (LinearPoint)theEObject;
				T result = caseLinearPoint(linearPoint);
				if (result == null) result = caseControlPoint(linearPoint);
				if (result == null) result = caseMovableElement(linearPoint);
				if (result == null) result = caseTimelineElement(linearPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.COMMAND_POINT: {
				CommandPoint commandPoint = (CommandPoint)theEObject;
				T result = caseCommandPoint(commandPoint);
				if (result == null) result = caseControlPoint(commandPoint);
				if (result == null) result = caseMovableElement(commandPoint);
				if (result == null) result = caseTimelineElement(commandPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.AUDIO_POINT: {
				AudioPoint audioPoint = (AudioPoint)theEObject;
				T result = caseAudioPoint(audioPoint);
				if (result == null) result = caseControlPoint(audioPoint);
				if (result == null) result = caseMovableElement(audioPoint);
				if (result == null) result = caseTimelineElement(audioPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.VOICE_POINT: {
				VoicePoint voicePoint = (VoicePoint)theEObject;
				T result = caseVoicePoint(voicePoint);
				if (result == null) result = caseAudioPoint(voicePoint);
				if (result == null) result = caseControlPoint(voicePoint);
				if (result == null) result = caseMovableElement(voicePoint);
				if (result == null) result = caseTimelineElement(voicePoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.COLOR_POINT: {
				ColorPoint colorPoint = (ColorPoint)theEObject;
				T result = caseColorPoint(colorPoint);
				if (result == null) result = caseControlPoint(colorPoint);
				if (result == null) result = caseMovableElement(colorPoint);
				if (result == null) result = caseTimelineElement(colorPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.TEXT_POINT: {
				TextPoint textPoint = (TextPoint)theEObject;
				T result = caseTextPoint(textPoint);
				if (result == null) result = caseControlPoint(textPoint);
				if (result == null) result = caseMovableElement(textPoint);
				if (result == null) result = caseTimelineElement(textPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.MATRIX_POINT: {
				MatrixPoint matrixPoint = (MatrixPoint)theEObject;
				T result = caseMatrixPoint(matrixPoint);
				if (result == null) result = caseLinearPoint(matrixPoint);
				if (result == null) result = caseControlPoint(matrixPoint);
				if (result == null) result = caseMovableElement(matrixPoint);
				if (result == null) result = caseTimelineElement(matrixPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimelinePackage.FILE_POINT: {
				FilePoint filePoint = (FilePoint)theEObject;
				T result = caseFilePoint(filePoint);
				if (result == null) result = caseControlPoint(filePoint);
				if (result == null) result = caseMovableElement(filePoint);
				if (result == null) result = caseTimelineElement(filePoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimelineElement(TimelineElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motion Clip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motion Clip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotionClip(MotionClip object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Movable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Movable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMovableElement(MovableElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlTrack(ControlTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelTrack(ChannelTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearTrack(LinearTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandTrack(CommandTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Audio Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Audio Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAudioTrack(AudioTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voice Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voice Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoiceTrack(VoiceTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorTrack(ColorTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextTrack(TextTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matrix Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matrix Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatrixTrack(MatrixTrack object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Track</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Track</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileTrack(FileTrack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlPoint(ControlPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Linear Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Linear Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinearPoint(LinearPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandPoint(CommandPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Audio Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Audio Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAudioPoint(AudioPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voice Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voice Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoicePoint(VoicePoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorPoint(ColorPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextPoint(TextPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matrix Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matrix Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatrixPoint(MatrixPoint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilePoint(FilePoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClip(IClip object)
	{
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
	public T defaultCase(EObject object)
	{
		return null;
	}

} //TimelineSwitch
