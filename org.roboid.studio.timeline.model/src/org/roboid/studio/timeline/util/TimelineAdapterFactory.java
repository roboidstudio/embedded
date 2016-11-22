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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.timeline.TimelinePackage
 * @generated
 */
public class TimelineAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TimelinePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimelineAdapterFactory()
	{
		if (modelPackage == null) {
			modelPackage = TimelinePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimelineSwitch<Adapter> modelSwitch =
		new TimelineSwitch<Adapter>() {
			@Override
			public Adapter caseTimelineElement(TimelineElement object) {
				return createTimelineElementAdapter();
			}
			@Override
			public Adapter caseMotionClip(MotionClip object) {
				return createMotionClipAdapter();
			}
			@Override
			public Adapter caseMovableElement(MovableElement object) {
				return createMovableElementAdapter();
			}
			@Override
			public Adapter caseControlTrack(ControlTrack object) {
				return createControlTrackAdapter();
			}
			@Override
			public Adapter caseChannelTrack(ChannelTrack object) {
				return createChannelTrackAdapter();
			}
			@Override
			public Adapter caseLinearTrack(LinearTrack object) {
				return createLinearTrackAdapter();
			}
			@Override
			public Adapter caseCommandTrack(CommandTrack object) {
				return createCommandTrackAdapter();
			}
			@Override
			public Adapter caseAudioTrack(AudioTrack object) {
				return createAudioTrackAdapter();
			}
			@Override
			public Adapter caseVoiceTrack(VoiceTrack object) {
				return createVoiceTrackAdapter();
			}
			@Override
			public Adapter caseColorTrack(ColorTrack object) {
				return createColorTrackAdapter();
			}
			@Override
			public Adapter caseTextTrack(TextTrack object) {
				return createTextTrackAdapter();
			}
			@Override
			public Adapter caseMatrixTrack(MatrixTrack object) {
				return createMatrixTrackAdapter();
			}
			@Override
			public Adapter caseFileTrack(FileTrack object) {
				return createFileTrackAdapter();
			}
			@Override
			public Adapter caseControlPoint(ControlPoint object) {
				return createControlPointAdapter();
			}
			@Override
			public Adapter caseLinearPoint(LinearPoint object) {
				return createLinearPointAdapter();
			}
			@Override
			public Adapter caseCommandPoint(CommandPoint object) {
				return createCommandPointAdapter();
			}
			@Override
			public Adapter caseAudioPoint(AudioPoint object) {
				return createAudioPointAdapter();
			}
			@Override
			public Adapter caseVoicePoint(VoicePoint object) {
				return createVoicePointAdapter();
			}
			@Override
			public Adapter caseColorPoint(ColorPoint object) {
				return createColorPointAdapter();
			}
			@Override
			public Adapter caseTextPoint(TextPoint object) {
				return createTextPointAdapter();
			}
			@Override
			public Adapter caseMatrixPoint(MatrixPoint object) {
				return createMatrixPointAdapter();
			}
			@Override
			public Adapter caseFilePoint(FilePoint object) {
				return createFilePointAdapter();
			}
			@Override
			public Adapter caseIClip(IClip object) {
				return createIClipAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.TimelineElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.TimelineElement
	 * @generated
	 */
	public Adapter createTimelineElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.MotionClip <em>Motion Clip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.MotionClip
	 * @generated
	 */
	public Adapter createMotionClipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.MovableElement <em>Movable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.MovableElement
	 * @generated
	 */
	public Adapter createMovableElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.ControlTrack <em>Control Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.ControlTrack
	 * @generated
	 */
	public Adapter createControlTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.ChannelTrack <em>Channel Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.ChannelTrack
	 * @generated
	 */
	public Adapter createChannelTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.LinearTrack <em>Linear Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.LinearTrack
	 * @generated
	 */
	public Adapter createLinearTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.CommandTrack <em>Command Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.CommandTrack
	 * @generated
	 */
	public Adapter createCommandTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.AudioTrack <em>Audio Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.AudioTrack
	 * @generated
	 */
	public Adapter createAudioTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.VoiceTrack <em>Voice Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.VoiceTrack
	 * @generated
	 */
	public Adapter createVoiceTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.ColorTrack <em>Color Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.ColorTrack
	 * @generated
	 */
	public Adapter createColorTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.TextTrack <em>Text Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.TextTrack
	 * @generated
	 */
	public Adapter createTextTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.MatrixTrack <em>Matrix Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.MatrixTrack
	 * @generated
	 */
	public Adapter createMatrixTrackAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.FileTrack <em>File Track</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.FileTrack
	 * @generated
	 */
	public Adapter createFileTrackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.ControlPoint <em>Control Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.ControlPoint
	 * @generated
	 */
	public Adapter createControlPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.LinearPoint <em>Linear Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.LinearPoint
	 * @generated
	 */
	public Adapter createLinearPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.CommandPoint <em>Command Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.CommandPoint
	 * @generated
	 */
	public Adapter createCommandPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.AudioPoint <em>Audio Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.AudioPoint
	 * @generated
	 */
	public Adapter createAudioPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.VoicePoint <em>Voice Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.VoicePoint
	 * @generated
	 */
	public Adapter createVoicePointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.ColorPoint <em>Color Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.ColorPoint
	 * @generated
	 */
	public Adapter createColorPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.TextPoint <em>Text Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.TextPoint
	 * @generated
	 */
	public Adapter createTextPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.MatrixPoint <em>Matrix Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.MatrixPoint
	 * @generated
	 */
	public Adapter createMatrixPointAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.timeline.FilePoint <em>File Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.timeline.FilePoint
	 * @generated
	 */
	public Adapter createFilePointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.core.runtime.IClip <em>IClip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.core.runtime.IClip
	 * @generated
	 */
	public Adapter createIClipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //TimelineAdapterFactory
