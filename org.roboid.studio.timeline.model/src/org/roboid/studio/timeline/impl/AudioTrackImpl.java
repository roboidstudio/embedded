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

import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.AudioFormat;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.roboid.audio.AudioUtil;
import org.roboid.robot.AudioMode;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;
import org.roboid.studio.timeline.VoicePoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audio Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioTrackImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AudioTrackImpl extends ChannelTrackImpl implements AudioTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AudioTrackImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return TimelinePackage.Literals.AUDIO_TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(AudioMode newMode)
	{
		AudioMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_TRACK__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_TRACK__MODE:
				return getMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_TRACK__MODE:
				setMode((AudioMode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_TRACK__MODE:
				setMode(MODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_TRACK__MODE:
				return mode != MODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated NOT
	 * @ordered
	 */
	protected static final AudioMode MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected AudioMode mode = MODE_EDEFAULT;

	private static final String P_MODE = "_mode";
	int[] wave; // temporary wave data for one frame
	private AudioFormat audioFormat;

	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		super.getPropertyDescriptors(propertyDescriptors);
		propertyDescriptors.add(new PropertyDescriptor(P_MODE, "Mode"));
	}

	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "Audio Channel";
		if(id.equals(P_MODE)) return getMode().getLiteral();
		if(id.equals(P_TARGET_DEVICE))
		{
			Device left = getTargetDevice(0);
			if(left == null) return "";
			Device right = getTargetDevice(1);
			if(right == null)
				return left.getName();
			else
				return left.getName() + ", " + right.getName();
		}
		return super.getPropertyValue(id);
	}
	
	@Override
	public ChannelTrack deepCopy()
	{
		AudioTrack newTrack = TimelineFactory.eINSTANCE.createAudioTrack();
		copyTo(newTrack);
		return newTrack;
	}

	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp instanceof AudioPoint)
			return true;
		return false;
	}

	@Override
	public AudioPoint deepCopy(ControlPoint cp)
	{
		if(cp instanceof VoicePoint)
		{
			AudioPoint newPoint = TimelineFactory.eINSTANCE.createAudioPoint();
			((AudioPointImpl)cp).copyTo(newPoint);
			return newPoint;
		}
		else if(cp instanceof AudioPoint)
			return (AudioPoint)cp.deepCopy();
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AudioMode getMode()
	{
		if(mode == null)
		{
			if(getTargetDevices().size() == 1)
				mode = AudioMode.MONO;
			else
				mode = AudioMode.STEREO;
		}
		return mode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMode(int newMode)
	{
		AudioMode mode = AudioMode.get(newMode);
		if(mode != null) setMode(mode);
	}
	
	@Override
	public int getTotalFrames()
	{
		int maxFrame = 0;
		for(ControlPoint cp : getPoints())
		{
			int frame = cp.getFrame() + ((AudioPoint)cp).getLength(); // start frame + length of frames
			if(maxFrame < frame) maxFrame = frame;
		}
		return maxFrame;
	}

	private AudioFormat getAudioFormatOfChannel(Device device)
	{
		// exception
		// support only BYTE, SHORT, INTEGER types
		if(!(device.getDataType().equals(DataType.BYTE) || device.getDataType().equals(DataType.SHORT) || device.getDataType().equals(DataType.INTEGER)))
			throw new IllegalArgumentException("The datatype of target device should be BYTE, SHORT or INTEGER only.");

		// format
		int sampleSizeInBits = device.getDataType().getValue();
		int channels = (getMode() == AudioMode.STEREO) ? 2 : 1;
		int frameSize = ((sampleSizeInBits + 7) / 8) * channels;
		float sampleRate = 50 * device.getDataSize();

		AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
													sampleRate,
													sampleSizeInBits,
													channels,
													frameSize,
													sampleRate,
													false);

		return targetFormat;
	}
	
	public void preLoad()
	{
		Device leftDevice = getTargetDevice(0);
		audioFormat = getAudioFormatOfChannel(leftDevice);
		
		for(ControlPoint cp : getPoints())
		{
			((AudioPoint)cp).getPcm(audioFormat);
		}
	}
	
	@Override
	public void dump(int frame)
	{
		if(getPoints().size() == 0) return; // no control points

		Device leftDevice = getTargetDevice(0);
		Device rightDevice = getTargetDevice(1);

		dump(frame, leftDevice, rightDevice);
	}
	
	/**
	 * writes audio data at current frame to the corresponding device
	 * 
	 * @param frame
	 * @param leftDevice
	 * @param rightDevice
	 */
	protected void dump(int frame, Device leftDevice, Device rightDevice)
	{
		if(leftDevice == null) return;
		
		// device format
		if(audioFormat == null)
			audioFormat = getAudioFormatOfChannel(leftDevice);

		// obtain audio data at current frame
		wave = getAudioData(frame, leftDevice, audioFormat);

		if(getMode() == AudioMode.MONO)
		{
			leftDevice.write(wave);
		}
		else
		{
			if(rightDevice == null) return;
			
			// stereo case
			AudioFormat rightDeviceFormat = getAudioFormatOfChannel(rightDevice);

			// exception
			// audio formats of two target devices should be same
			if(!AudioUtil.isEqual(audioFormat, rightDeviceFormat))
			{
				throw new IllegalArgumentException("The type of two target audio devices should be the same: " + audioFormat + " and " + rightDeviceFormat);
			}

			// divide two channels into seperate arrays
			int stereo[][] = AudioUtil.splitChannel(wave, audioFormat.getChannels());

			// write to each device
			leftDevice.write(stereo[1]); // IMPORTANT: exchange left and right
			rightDevice.write(stereo[0]);
		}
	}

	/**
	 * returns audio data at current frame in target format
	 * 
	 * @param frame
	 * @param targetFormat
	 * @return
	 */
	private int[] getAudioData(int frame, Device device, AudioFormat targetFormat)
	{
		int dataSize = device.getDataSize() * targetFormat.getChannels();
		int maxValue = device.getMax();;
		int minValue = device.getMin();
		
		if(wave == null) wave = new int[dataSize];
		Arrays.fill(wave, 0);

		for(ControlPoint cp : getPoints())
		{
			AudioPoint ap = (AudioPoint)cp;
			if(frame < ap.getFrame()) break;
			else if(frame >= ap.getFrame() + ap.getLength()) continue;

			int[] pcm = ap.getPcm(targetFormat);
			if(pcm == null) continue;
			
			// calculate offset of current frame in whole audio data
			int offset = (frame - ap.getFrame()) * dataSize;
			int len = pcm.length > offset + dataSize ? dataSize : pcm.length - offset;

			// apply volume to audio data
			AudioUtil.multiplyAndSum(pcm, offset, ap.getVolume()/100.0f, wave, 0, len, minValue, maxValue);
		}
		return wave;
	}
} //AudioTrackImpl
