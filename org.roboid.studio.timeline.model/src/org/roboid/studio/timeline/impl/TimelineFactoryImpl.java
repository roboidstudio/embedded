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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.graphics.RGB;
import org.roboid.studio.timeline.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class TimelineFactoryImpl extends EFactoryImpl implements TimelineFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimelineFactory init()
	{
		try {
			TimelineFactory theTimelineFactory = (TimelineFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.roboidstudio.org/model/timeline"); 
			if (theTimelineFactory != null) {
				return theTimelineFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TimelineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimelineFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID()) {
			case TimelinePackage.MOTION_CLIP: return (EObject)createMotionClip();
			case TimelinePackage.CONTROL_TRACK: return (EObject)createControlTrack();
			case TimelinePackage.LINEAR_TRACK: return (EObject)createLinearTrack();
			case TimelinePackage.COMMAND_TRACK: return (EObject)createCommandTrack();
			case TimelinePackage.AUDIO_TRACK: return (EObject)createAudioTrack();
			case TimelinePackage.VOICE_TRACK: return (EObject)createVoiceTrack();
			case TimelinePackage.COLOR_TRACK: return (EObject)createColorTrack();
			case TimelinePackage.TEXT_TRACK: return (EObject)createTextTrack();
			case TimelinePackage.MATRIX_TRACK: return (EObject)createMatrixTrack();
			case TimelinePackage.FILE_TRACK: return (EObject)createFileTrack();
			case TimelinePackage.LINEAR_POINT: return (EObject)createLinearPoint();
			case TimelinePackage.COMMAND_POINT: return (EObject)createCommandPoint();
			case TimelinePackage.AUDIO_POINT: return (EObject)createAudioPoint();
			case TimelinePackage.VOICE_POINT: return (EObject)createVoicePoint();
			case TimelinePackage.COLOR_POINT: return (EObject)createColorPoint();
			case TimelinePackage.TEXT_POINT: return (EObject)createTextPoint();
			case TimelinePackage.MATRIX_POINT: return (EObject)createMatrixPoint();
			case TimelinePackage.FILE_POINT: return (EObject)createFilePoint();
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
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID()) {
			case TimelinePackage.RECTANGLE:
				return createRectangleFromString(eDataType, initialValue);
			case TimelinePackage.RGB:
				return createRGBFromString(eDataType, initialValue);
			case TimelinePackage.AUDIO_FORMAT:
				return createAudioFormatFromString(eDataType, initialValue);
			case TimelinePackage.AUDIO_INPUT_STREAM:
				return createAudioInputStreamFromString(eDataType, initialValue);
			case TimelinePackage.UNSUPPORTED_AUDIO_FILE_EXCEPTION:
				return createUnsupportedAudioFileExceptionFromString(eDataType, initialValue);
			case TimelinePackage.IO_EXCEPTION:
				return createIOExceptionFromString(eDataType, initialValue);
			case TimelinePackage.FLOAT_ARRAY:
				return createFloatArrayFromString(eDataType, initialValue);
			case TimelinePackage.PROPERTY_CHANGE_LISTENER:
				return createPropertyChangeListenerFromString(eDataType, initialValue);
			case TimelinePackage.URI:
				return createURIFromString(eDataType, initialValue);
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
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID()) {
			case TimelinePackage.RECTANGLE:
				return convertRectangleToString(eDataType, instanceValue);
			case TimelinePackage.RGB:
				return convertRGBToString(eDataType, instanceValue);
			case TimelinePackage.AUDIO_FORMAT:
				return convertAudioFormatToString(eDataType, instanceValue);
			case TimelinePackage.AUDIO_INPUT_STREAM:
				return convertAudioInputStreamToString(eDataType, instanceValue);
			case TimelinePackage.UNSUPPORTED_AUDIO_FILE_EXCEPTION:
				return convertUnsupportedAudioFileExceptionToString(eDataType, instanceValue);
			case TimelinePackage.IO_EXCEPTION:
				return convertIOExceptionToString(eDataType, instanceValue);
			case TimelinePackage.FLOAT_ARRAY:
				return convertFloatArrayToString(eDataType, instanceValue);
			case TimelinePackage.PROPERTY_CHANGE_LISTENER:
				return convertPropertyChangeListenerToString(eDataType, instanceValue);
			case TimelinePackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionClip createMotionClip()
	{
		MotionClipImpl motionClip = new MotionClipImpl();
		return motionClip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlTrack createControlTrack()
	{
		ControlTrackImpl controlTrack = new ControlTrackImpl();
		return controlTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearTrack createLinearTrack()
	{
		LinearTrackImpl linearTrack = new LinearTrackImpl();
		return linearTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandTrack createCommandTrack()
	{
		CommandTrackImpl commandTrack = new CommandTrackImpl();
		return commandTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AudioTrack createAudioTrack()
	{
		AudioTrackImpl audioTrack = new AudioTrackImpl();
		return audioTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceTrack createVoiceTrack()
	{
		VoiceTrackImpl voiceTrack = new VoiceTrackImpl();
		return voiceTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorTrack createColorTrack()
	{
		ColorTrackImpl colorTrack = new ColorTrackImpl();
		return colorTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextTrack createTextTrack()
	{
		TextTrackImpl textTrack = new TextTrackImpl();
		return textTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixTrack createMatrixTrack()
	{
		MatrixTrackImpl matrixTrack = new MatrixTrackImpl();
		return matrixTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTrack createFileTrack() {
		FileTrackImpl fileTrack = new FileTrackImpl();
		return fileTrack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearPoint createLinearPoint()
	{
		LinearPointImpl linearPoint = new LinearPointImpl();
		return linearPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPoint createCommandPoint()
	{
		CommandPointImpl commandPoint = new CommandPointImpl();
		return commandPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AudioPoint createAudioPoint()
	{
		AudioPointImpl audioPoint = new AudioPointImpl();
		return audioPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoicePoint createVoicePoint()
	{
		VoicePointImpl voicePoint = new VoicePointImpl();
		return voicePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorPoint createColorPoint()
	{
		ColorPointImpl colorPoint = new ColorPointImpl();
		return colorPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextPoint createTextPoint()
	{
		TextPointImpl textPoint = new TextPointImpl();
		return textPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatrixPoint createMatrixPoint()
	{
		MatrixPointImpl matrixPoint = new MatrixPointImpl();
		return matrixPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilePoint createFilePoint() {
		FilePointImpl filePoint = new FilePointImpl();
		return filePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AudioFormat createAudioFormatFromString(EDataType eDataType, String initialValue)
	{
		return (AudioFormat)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAudioFormatToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AudioInputStream createAudioInputStreamFromString(EDataType eDataType, String initialValue)
	{
		return (AudioInputStream)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAudioInputStreamToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnsupportedAudioFileException createUnsupportedAudioFileExceptionFromString(EDataType eDataType, String initialValue)
	{
		return (UnsupportedAudioFileException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnsupportedAudioFileExceptionToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOException createIOExceptionFromString(EDataType eDataType, String initialValue)
	{
		return (IOException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIOExceptionToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyChangeListener createPropertyChangeListenerFromString(EDataType eDataType, String initialValue)
	{
		return (PropertyChangeListener)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyChangeListenerToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimelinePackage getTimelinePackage()
	{
		return (TimelinePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TimelinePackage getPackage()
	{
		return TimelinePackage.eINSTANCE;
	}

	
	
	

	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Rectangle createRectangleFromString(EDataType eDataType, String initialValue)
	{
		String[] values = initialValue.split(",");
		Rectangle rect = new Rectangle();
		if(values.length > 0) rect.x = Integer.parseInt(values[0]);
		if(values.length > 1) rect.y = Integer.parseInt(values[1]);
		if(values.length > 2) rect.width = Integer.parseInt(values[2]);
		if(values.length > 3) rect.height = Integer.parseInt(values[3]);
		return rect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertRectangleToString(EDataType eDataType, Object instanceValue)
	{
		if(instanceValue == null) return null;
		Rectangle rect = (Rectangle)instanceValue;
		return rect.x + "," + rect.y + "," + rect.width + "," + rect.height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RGB createRGBFromString(EDataType eDataType, String initialValue)
	{
		String[] values = initialValue.split(",");
		RGB rgb = new RGB(0,0,0);
		if(values.length > 0) rgb.red = Integer.parseInt(values[0]);
		if(values.length > 1) rgb.green = Integer.parseInt(values[1]);
		if(values.length > 2) rgb.blue = Integer.parseInt(values[2]);
		return rgb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertRGBToString(EDataType eDataType, Object instanceValue)
	{
		if(instanceValue == null) return null;
		RGB rgb = (RGB)instanceValue;
		return rgb.red + "," + rgb.green + "," + rgb.blue;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float[] createFloatArrayFromString(EDataType eDataType, String initialValue)
	{
		if(initialValue == null) return new float[0];
		String[] data = initialValue.split(",");
		if(data == null) return new float[0];
		float[] values = new float[data.length];
		for(int i = 0; i < data.length; i ++)
		{
			try
			{
				values[i] = Float.parseFloat(data[i]);
			}
			catch (Exception e)
			{
				values[i] = 0.0f;
			}
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertFloatArrayToString(EDataType eDataType, Object instanceValue)
	{
		if(instanceValue == null) return null;
		float[] values = (float[])instanceValue;
		if(values.length <= 0) return null;
		StringBuilder sb = new StringBuilder();
		sb.append(values[0]);
		for(int i = 1; i < values.length; i ++)
		{
			sb.append(",");
			sb.append(values[i]);
		}
		return sb.toString();
	}
} //TimelineFactoryImpl
