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

package org.roboid.studio.timeline.impl;

import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.RobotPackage;
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
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;
import org.roboid.studio.timeline.VoicePoint;
import org.roboid.studio.timeline.VoiceTrack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class TimelinePackageImpl extends EPackageImpl implements TimelinePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timelineElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motionClipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass audioTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voiceTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matrixTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileTrackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass audioPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voicePointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matrixPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filePointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rgbEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rectangleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType audioFormatEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType audioInputStreamEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unsupportedAudioFileExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ioExceptionEDataType = null;

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
	private EDataType propertyChangeListenerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.roboid.studio.timeline.TimelinePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TimelinePackageImpl()
	{
		super(eNS_URI, TimelineFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TimelinePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TimelinePackage init()
	{
		if (isInited) return (TimelinePackage)EPackage.Registry.INSTANCE.getEPackage(TimelinePackage.eNS_URI);

		// Obtain or create and register package
		TimelinePackageImpl theTimelinePackage = (TimelinePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TimelinePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TimelinePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ActivityPackage.eINSTANCE.eClass();
		RobotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTimelinePackage.createPackageContents();

		// Initialize created meta-data
		theTimelinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTimelinePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TimelinePackage.eNS_URI, theTimelinePackage);
		return theTimelinePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimelineElement()
	{
		return timelineElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotionClip()
	{
		return motionClipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionClip_Robot()
	{
		return (EReference)motionClipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionClip_Activity()
	{
		return (EReference)motionClipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionClip_Controls()
	{
		return (EReference)motionClipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionClip_Version()
	{
		return (EAttribute)motionClipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionClip_FrameLimit()
	{
		return (EAttribute)motionClipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovableElement()
	{
		return movableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovableElement_Constraint()
	{
		return (EAttribute)movableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovableElement_Parent()
	{
		return (EReference)movableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlTrack()
	{
		return controlTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlTrack_Channels()
	{
		return (EReference)controlTrackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlTrack_Control()
	{
		return (EReference)controlTrackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelTrack()
	{
		return channelTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannelTrack_Points()
	{
		return (EReference)channelTrackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChannelTrack_Channel()
	{
		return (EReference)channelTrackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearTrack()
	{
		return linearTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinearTrack_Mode()
	{
		return (EAttribute)linearTrackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandTrack()
	{
		return commandTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAudioTrack()
	{
		return audioTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioTrack_Mode()
	{
		return (EAttribute)audioTrackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoiceTrack()
	{
		return voiceTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorTrack()
	{
		return colorTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorTrack_Mode()
	{
		return (EAttribute)colorTrackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextTrack()
	{
		return textTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatrixTrack()
	{
		return matrixTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileTrack() {
		return fileTrackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlPoint()
	{
		return controlPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControlPoint_Frame()
	{
		return (EAttribute)controlPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearPoint()
	{
		return linearPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinearPoint_Values() {
		return (EAttribute)linearPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinearPoint_Mode()
	{
		return (EAttribute)linearPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandPoint()
	{
		return commandPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandPoint_Values() {
		return (EAttribute)commandPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAudioPoint()
	{
		return audioPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Mp3()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Length()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Text()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_VoiceId()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_LanguageId()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_VoiceEffectId()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_SpeechRate()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Volume()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Pitch()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Balance()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Encoding()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_SampleRate()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_SampleSizeInBits()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Channels()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_FrameSize()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_FrameRate()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_BigEndian()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Mode()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Format()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Pcm()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAudioPoint_Modified()
	{
		return (EAttribute)audioPointEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoicePoint()
	{
		return voicePointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVoicePoint_LipGain()
	{
		return (EAttribute)voicePointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorPoint()
	{
		return colorPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorPoint_Mode()
	{
		return (EAttribute)colorPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorPoint_Color()
	{
		return (EAttribute)colorPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextPoint()
	{
		return textPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextPoint_Text()
	{
		return (EAttribute)textPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatrixPoint()
	{
		return matrixPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilePoint() {
		return filePointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilePoint_FileName() {
		return (EAttribute)filePointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClip()
	{
		return iClipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRGB()
	{
		return rgbEDataType;
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
	public EDataType getAudioFormat()
	{
		return audioFormatEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAudioInputStream()
	{
		return audioInputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUnsupportedAudioFileException()
	{
		return unsupportedAudioFileExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIOException()
	{
		return ioExceptionEDataType;
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
	public EDataType getPropertyChangeListener()
	{
		return propertyChangeListenerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimelineFactory getTimelineFactory()
	{
		return (TimelineFactory)getEFactoryInstance();
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
		timelineElementEClass = createEClass(TIMELINE_ELEMENT);

		motionClipEClass = createEClass(MOTION_CLIP);
		createEReference(motionClipEClass, MOTION_CLIP__ROBOT);
		createEReference(motionClipEClass, MOTION_CLIP__ACTIVITY);
		createEReference(motionClipEClass, MOTION_CLIP__CONTROLS);
		createEAttribute(motionClipEClass, MOTION_CLIP__VERSION);
		createEAttribute(motionClipEClass, MOTION_CLIP__FRAME_LIMIT);

		movableElementEClass = createEClass(MOVABLE_ELEMENT);
		createEAttribute(movableElementEClass, MOVABLE_ELEMENT__CONSTRAINT);
		createEReference(movableElementEClass, MOVABLE_ELEMENT__PARENT);

		controlTrackEClass = createEClass(CONTROL_TRACK);
		createEReference(controlTrackEClass, CONTROL_TRACK__CHANNELS);
		createEReference(controlTrackEClass, CONTROL_TRACK__CONTROL);

		channelTrackEClass = createEClass(CHANNEL_TRACK);
		createEReference(channelTrackEClass, CHANNEL_TRACK__POINTS);
		createEReference(channelTrackEClass, CHANNEL_TRACK__CHANNEL);

		linearTrackEClass = createEClass(LINEAR_TRACK);
		createEAttribute(linearTrackEClass, LINEAR_TRACK__MODE);

		commandTrackEClass = createEClass(COMMAND_TRACK);

		audioTrackEClass = createEClass(AUDIO_TRACK);
		createEAttribute(audioTrackEClass, AUDIO_TRACK__MODE);

		voiceTrackEClass = createEClass(VOICE_TRACK);

		colorTrackEClass = createEClass(COLOR_TRACK);
		createEAttribute(colorTrackEClass, COLOR_TRACK__MODE);

		textTrackEClass = createEClass(TEXT_TRACK);

		matrixTrackEClass = createEClass(MATRIX_TRACK);

		fileTrackEClass = createEClass(FILE_TRACK);

		controlPointEClass = createEClass(CONTROL_POINT);
		createEAttribute(controlPointEClass, CONTROL_POINT__FRAME);

		linearPointEClass = createEClass(LINEAR_POINT);
		createEAttribute(linearPointEClass, LINEAR_POINT__VALUES);
		createEAttribute(linearPointEClass, LINEAR_POINT__MODE);

		commandPointEClass = createEClass(COMMAND_POINT);
		createEAttribute(commandPointEClass, COMMAND_POINT__VALUES);

		audioPointEClass = createEClass(AUDIO_POINT);
		createEAttribute(audioPointEClass, AUDIO_POINT__MP3);
		createEAttribute(audioPointEClass, AUDIO_POINT__LENGTH);
		createEAttribute(audioPointEClass, AUDIO_POINT__TEXT);
		createEAttribute(audioPointEClass, AUDIO_POINT__VOICE_ID);
		createEAttribute(audioPointEClass, AUDIO_POINT__LANGUAGE_ID);
		createEAttribute(audioPointEClass, AUDIO_POINT__VOICE_EFFECT_ID);
		createEAttribute(audioPointEClass, AUDIO_POINT__SPEECH_RATE);
		createEAttribute(audioPointEClass, AUDIO_POINT__VOLUME);
		createEAttribute(audioPointEClass, AUDIO_POINT__PITCH);
		createEAttribute(audioPointEClass, AUDIO_POINT__BALANCE);
		createEAttribute(audioPointEClass, AUDIO_POINT__ENCODING);
		createEAttribute(audioPointEClass, AUDIO_POINT__SAMPLE_RATE);
		createEAttribute(audioPointEClass, AUDIO_POINT__SAMPLE_SIZE_IN_BITS);
		createEAttribute(audioPointEClass, AUDIO_POINT__CHANNELS);
		createEAttribute(audioPointEClass, AUDIO_POINT__FRAME_SIZE);
		createEAttribute(audioPointEClass, AUDIO_POINT__FRAME_RATE);
		createEAttribute(audioPointEClass, AUDIO_POINT__BIG_ENDIAN);
		createEAttribute(audioPointEClass, AUDIO_POINT__MODE);
		createEAttribute(audioPointEClass, AUDIO_POINT__FORMAT);
		createEAttribute(audioPointEClass, AUDIO_POINT__PCM);
		createEAttribute(audioPointEClass, AUDIO_POINT__MODIFIED);

		voicePointEClass = createEClass(VOICE_POINT);
		createEAttribute(voicePointEClass, VOICE_POINT__LIP_GAIN);

		colorPointEClass = createEClass(COLOR_POINT);
		createEAttribute(colorPointEClass, COLOR_POINT__MODE);
		createEAttribute(colorPointEClass, COLOR_POINT__COLOR);

		textPointEClass = createEClass(TEXT_POINT);
		createEAttribute(textPointEClass, TEXT_POINT__TEXT);

		matrixPointEClass = createEClass(MATRIX_POINT);

		filePointEClass = createEClass(FILE_POINT);
		createEAttribute(filePointEClass, FILE_POINT__FILE_NAME);

		iClipEClass = createEClass(ICLIP);

		// Create data types
		rectangleEDataType = createEDataType(RECTANGLE);
		rgbEDataType = createEDataType(RGB);
		audioFormatEDataType = createEDataType(AUDIO_FORMAT);
		audioInputStreamEDataType = createEDataType(AUDIO_INPUT_STREAM);
		unsupportedAudioFileExceptionEDataType = createEDataType(UNSUPPORTED_AUDIO_FILE_EXCEPTION);
		ioExceptionEDataType = createEDataType(IO_EXCEPTION);
		floatArrayEDataType = createEDataType(FLOAT_ARRAY);
		propertyChangeListenerEDataType = createEDataType(PROPERTY_CHANGE_LISTENER);
		uriEDataType = createEDataType(URI);
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
		ActivityPackage theActivityPackage = (ActivityPackage)EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		motionClipEClass.getESuperTypes().add(this.getTimelineElement());
		motionClipEClass.getESuperTypes().add(this.getIClip());
		movableElementEClass.getESuperTypes().add(this.getTimelineElement());
		controlTrackEClass.getESuperTypes().add(this.getMovableElement());
		channelTrackEClass.getESuperTypes().add(this.getMovableElement());
		linearTrackEClass.getESuperTypes().add(this.getChannelTrack());
		commandTrackEClass.getESuperTypes().add(this.getChannelTrack());
		audioTrackEClass.getESuperTypes().add(this.getChannelTrack());
		voiceTrackEClass.getESuperTypes().add(this.getAudioTrack());
		colorTrackEClass.getESuperTypes().add(this.getChannelTrack());
		textTrackEClass.getESuperTypes().add(this.getChannelTrack());
		matrixTrackEClass.getESuperTypes().add(this.getLinearTrack());
		fileTrackEClass.getESuperTypes().add(this.getChannelTrack());
		controlPointEClass.getESuperTypes().add(this.getMovableElement());
		linearPointEClass.getESuperTypes().add(this.getControlPoint());
		commandPointEClass.getESuperTypes().add(this.getControlPoint());
		audioPointEClass.getESuperTypes().add(this.getControlPoint());
		voicePointEClass.getESuperTypes().add(this.getAudioPoint());
		colorPointEClass.getESuperTypes().add(this.getControlPoint());
		textPointEClass.getESuperTypes().add(this.getControlPoint());
		matrixPointEClass.getESuperTypes().add(this.getLinearPoint());
		filePointEClass.getESuperTypes().add(this.getControlPoint());

		// Initialize classes and features; add operations and parameters
		initEClass(timelineElementEClass, TimelineElement.class, "TimelineElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(timelineElementEClass, null, "addPropertyChangeListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyChangeListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(timelineElementEClass, null, "firePropertyChange", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "oldValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "newValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(timelineElementEClass, null, "removePropertyChangeListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyChangeListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(motionClipEClass, MotionClip.class, "MotionClip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMotionClip_Robot(), theRobotPackage.getRobot(), null, "robot", null, 0, 1, MotionClip.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionClip_Activity(), theActivityPackage.getActivity(), null, "activity", null, 0, 1, MotionClip.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionClip_Controls(), this.getControlTrack(), null, "controls", null, 0, -1, MotionClip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionClip_Version(), ecorePackage.getEString(), "version", "1.0.0", 0, 1, MotionClip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionClip_FrameLimit(), ecorePackage.getEInt(), "frameLimit", "9999", 0, 1, MotionClip.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(motionClipEClass, ecorePackage.getEInt(), "getTotalFrames", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionClipEClass, this.getControlTrack(), "createControlTrack", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getControl(), "control", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionClipEClass, null, "createControlTracks", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getRobot(), "robot", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionClipEClass, this.getMotionClip(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionClipEClass, null, "refreshResource", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionClipEClass, null, "refreshResource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(movableElementEClass, MovableElement.class, "MovableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovableElement_Constraint(), this.getRectangle(), "constraint", null, 0, 1, MovableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMovableElement_Parent(), this.getTimelineElement(), null, "parent", null, 0, 1, MovableElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlTrackEClass, ControlTrack.class, "ControlTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlTrack_Channels(), this.getChannelTrack(), null, "channels", null, 0, -1, ControlTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getControlTrack_Control(), theRobotPackage.getControl(), null, "control", null, 0, 1, ControlTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(controlTrackEClass, ecorePackage.getEInt(), "getTotalFrames", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(controlTrackEClass, this.getChannelTrack(), "createChannelTrack", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getChannel(), "channel", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(controlTrackEClass, null, "createChannelTracks", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getControl(), "control", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(controlTrackEClass, null, "updateReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRobotPackage.getControl(), "newControl", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(controlTrackEClass, this.getControlTrack(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(channelTrackEClass, ChannelTrack.class, "ChannelTrack", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChannelTrack_Points(), this.getControlPoint(), null, "points", null, 0, -1, ChannelTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChannelTrack_Channel(), theRobotPackage.getChannel(), null, "channel", null, 0, 1, ChannelTrack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(channelTrackEClass, ecorePackage.getEInt(), "getTotalFrames", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(channelTrackEClass, theRobotPackage.getChannelDevice(), "getTargetDevices", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, theRobotPackage.getDevice(), "getTargetDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(channelTrackEClass, null, "createSimulacra", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getControlPoint(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getControlPoint(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, null, "dump", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, null, "reorder", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getControlPoint(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(channelTrackEClass, this.getChannelTrack(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, this.getControlPoint(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getControlPoint(), "cp", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(channelTrackEClass, ecorePackage.getEBoolean(), "canCopy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getControlPoint(), "cp", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(linearTrackEClass, LinearTrack.class, "LinearTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinearTrack_Mode(), theRobotPackage.getLinearMode(), "mode", null, 0, 1, LinearTrack.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(linearTrackEClass, null, "setMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(commandTrackEClass, CommandTrack.class, "CommandTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(audioTrackEClass, AudioTrack.class, "AudioTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAudioTrack_Mode(), theRobotPackage.getAudioMode(), "mode", null, 0, 1, AudioTrack.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(audioTrackEClass, null, "setMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(voiceTrackEClass, VoiceTrack.class, "VoiceTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(colorTrackEClass, ColorTrack.class, "ColorTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorTrack_Mode(), theRobotPackage.getColorMode(), "mode", null, 0, 1, ColorTrack.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(colorTrackEClass, null, "setMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(textTrackEClass, TextTrack.class, "TextTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matrixTrackEClass, MatrixTrack.class, "MatrixTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileTrackEClass, FileTrack.class, "FileTrack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(controlPointEClass, ControlPoint.class, "ControlPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getControlPoint_Frame(), ecorePackage.getEInt(), "frame", null, 0, 1, ControlPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(controlPointEClass, this.getControlPoint(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(controlPointEClass, null, "performConstraintChange", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(linearPointEClass, LinearPoint.class, "LinearPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinearPoint_Values(), this.getFloatArray(), "values", null, 0, 1, LinearPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinearPoint_Mode(), theRobotPackage.getLinearMode(), "mode", null, 0, 1, LinearPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(linearPointEClass, ecorePackage.getEInt(), "getDataSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(linearPointEClass, theRobotPackage.getDataType(), "getDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(linearPointEClass, null, "setMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(linearPointEClass, ecorePackage.getEInt(), "getDataMaxValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(linearPointEClass, ecorePackage.getEInt(), "getDataMinValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(commandPointEClass, CommandPoint.class, "CommandPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommandPoint_Values(), this.getFloatArray(), "values", null, 0, 1, CommandPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(commandPointEClass, ecorePackage.getEInt(), "getDataSize", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(commandPointEClass, theRobotPackage.getDataType(), "getDataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(commandPointEClass, ecorePackage.getEInt(), "getDataMaxValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(commandPointEClass, ecorePackage.getEInt(), "getDataMinValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(audioPointEClass, AudioPoint.class, "AudioPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAudioPoint_Mp3(), ecorePackage.getEByteArray(), "mp3", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Length(), ecorePackage.getEInt(), "length", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Text(), ecorePackage.getEString(), "text", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_VoiceId(), ecorePackage.getEString(), "voiceId", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_LanguageId(), ecorePackage.getEString(), "languageId", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_VoiceEffectId(), ecorePackage.getEString(), "voiceEffectId", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_SpeechRate(), ecorePackage.getEInt(), "speechRate", "100", 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Volume(), ecorePackage.getEInt(), "volume", "100", 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Pitch(), ecorePackage.getEInt(), "pitch", "100", 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Balance(), ecorePackage.getEInt(), "balance", "50", 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Encoding(), ecorePackage.getEString(), "encoding", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_SampleRate(), ecorePackage.getEFloat(), "sampleRate", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_SampleSizeInBits(), ecorePackage.getEInt(), "sampleSizeInBits", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Channels(), ecorePackage.getEInt(), "channels", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_FrameSize(), ecorePackage.getEInt(), "frameSize", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_FrameRate(), ecorePackage.getEFloat(), "frameRate", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_BigEndian(), ecorePackage.getEBoolean(), "bigEndian", null, 0, 1, AudioPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Mode(), theRobotPackage.getAudioMode(), "mode", null, 0, 1, AudioPoint.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Format(), this.getAudioFormat(), "format", null, 0, 1, AudioPoint.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Pcm(), theRobotPackage.getIntArray(), "pcm", null, 0, 1, AudioPoint.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAudioPoint_Modified(), ecorePackage.getEBoolean(), "modified", null, 0, 1, AudioPoint.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(audioPointEClass, null, "setMp3", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAudioInputStream(), "sourceStream", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getUnsupportedAudioFileException());
		addEException(op, this.getIOException());

		op = addEOperation(audioPointEClass, theRobotPackage.getIntArray(), "getPcm", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAudioFormat(), "targetFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(audioPointEClass, ecorePackage.getEBoolean(), "isNew", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(audioPointEClass, ecorePackage.getEBoolean(), "isFile", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(audioPointEClass, ecorePackage.getEBoolean(), "isTts", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(audioPointEClass, null, "setMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(voicePointEClass, VoicePoint.class, "VoicePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVoicePoint_LipGain(), ecorePackage.getEInt(), "lipGain", "100", 0, 1, VoicePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorPointEClass, ColorPoint.class, "ColorPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorPoint_Mode(), theRobotPackage.getColorMode(), "mode", null, 0, 1, ColorPoint.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorPoint_Color(), this.getRGB(), "color", null, 0, 1, ColorPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(colorPointEClass, null, "setMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "newMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(textPointEClass, TextPoint.class, "TextPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextPoint_Text(), ecorePackage.getEString(), "text", null, 0, 1, TextPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matrixPointEClass, MatrixPoint.class, "MatrixPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filePointEClass, FilePoint.class, "FilePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilePoint_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, FilePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iClipEClass, IClip.class, "IClip", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(rectangleEDataType, Rectangle.class, "Rectangle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rgbEDataType, org.eclipse.swt.graphics.RGB.class, "RGB", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(audioFormatEDataType, AudioFormat.class, "AudioFormat", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(audioInputStreamEDataType, AudioInputStream.class, "AudioInputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(unsupportedAudioFileExceptionEDataType, UnsupportedAudioFileException.class, "UnsupportedAudioFileException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ioExceptionEDataType, IOException.class, "IOException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatArrayEDataType, float[].class, "FloatArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertyChangeListenerEDataType, PropertyChangeListener.class, "PropertyChangeListener", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TimelinePackageImpl
