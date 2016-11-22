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

package org.roboid.studio.timeline;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.timeline.TimelinePackage
 * @generated
 */
public interface TimelineFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimelineFactory eINSTANCE = org.roboid.studio.timeline.impl.TimelineFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Motion Clip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Motion Clip</em>'.
	 * @generated
	 */
	MotionClip createMotionClip();

	/**
	 * Returns a new object of class '<em>Control Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Track</em>'.
	 * @generated
	 */
	ControlTrack createControlTrack();

	/**
	 * Returns a new object of class '<em>Linear Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Track</em>'.
	 * @generated
	 */
	LinearTrack createLinearTrack();

	/**
	 * Returns a new object of class '<em>Command Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Track</em>'.
	 * @generated
	 */
	CommandTrack createCommandTrack();

	/**
	 * Returns a new object of class '<em>Audio Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Audio Track</em>'.
	 * @generated
	 */
	AudioTrack createAudioTrack();

	/**
	 * Returns a new object of class '<em>Voice Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Voice Track</em>'.
	 * @generated
	 */
	VoiceTrack createVoiceTrack();

	/**
	 * Returns a new object of class '<em>Color Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Track</em>'.
	 * @generated
	 */
	ColorTrack createColorTrack();

	/**
	 * Returns a new object of class '<em>Text Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Track</em>'.
	 * @generated
	 */
	TextTrack createTextTrack();

	/**
	 * Returns a new object of class '<em>Matrix Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matrix Track</em>'.
	 * @generated
	 */
	MatrixTrack createMatrixTrack();

	/**
	 * Returns a new object of class '<em>File Track</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Track</em>'.
	 * @generated
	 */
	FileTrack createFileTrack();

	/**
	 * Returns a new object of class '<em>Linear Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Linear Point</em>'.
	 * @generated
	 */
	LinearPoint createLinearPoint();

	/**
	 * Returns a new object of class '<em>Command Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Point</em>'.
	 * @generated
	 */
	CommandPoint createCommandPoint();

	/**
	 * Returns a new object of class '<em>Audio Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Audio Point</em>'.
	 * @generated
	 */
	AudioPoint createAudioPoint();

	/**
	 * Returns a new object of class '<em>Voice Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Voice Point</em>'.
	 * @generated
	 */
	VoicePoint createVoicePoint();

	/**
	 * Returns a new object of class '<em>Color Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Point</em>'.
	 * @generated
	 */
	ColorPoint createColorPoint();

	/**
	 * Returns a new object of class '<em>Text Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Point</em>'.
	 * @generated
	 */
	TextPoint createTextPoint();

	/**
	 * Returns a new object of class '<em>Matrix Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matrix Point</em>'.
	 * @generated
	 */
	MatrixPoint createMatrixPoint();

	/**
	 * Returns a new object of class '<em>File Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Point</em>'.
	 * @generated
	 */
	FilePoint createFilePoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TimelinePackage getTimelinePackage();

} //TimelineFactory
