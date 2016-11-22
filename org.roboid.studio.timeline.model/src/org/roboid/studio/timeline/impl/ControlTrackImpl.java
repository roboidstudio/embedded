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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.robot.AudioChannel;
import org.roboid.robot.Channel;
import org.roboid.robot.ColorChannel;
import org.roboid.robot.CommandChannel;
import org.roboid.robot.Control;
import org.roboid.robot.FileChannel;
import org.roboid.robot.MatrixChannel;
import org.roboid.robot.TextChannel;
import org.roboid.robot.VoiceChannel;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.ControlTrackImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.ControlTrackImpl#getControl <em>Control</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlTrackImpl extends MovableElementImpl implements ControlTrack
{
	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected EList<ChannelTrack> channels;

	/**
	 * The cached value of the '{@link #getControl() <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControl()
	 * @generated
	 * @ordered
	 */
	protected Control control;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlTrackImpl()
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
		return TimelinePackage.Literals.CONTROL_TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ChannelTrack> getChannels()
	{
		if (channels == null) {
			channels = new EObjectContainmentEList<ChannelTrack>(ChannelTrack.class, this, TimelinePackage.CONTROL_TRACK__CHANNELS);
		}
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Control getControl()
	{
		return control;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControl(Control newControl)
	{
		Control oldControl = control;
		control = newControl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.CONTROL_TRACK__CONTROL, oldControl, control));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case TimelinePackage.CONTROL_TRACK__CHANNELS:
				return ((InternalEList<?>)getChannels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case TimelinePackage.CONTROL_TRACK__CHANNELS:
				return getChannels();
			case TimelinePackage.CONTROL_TRACK__CONTROL:
				return getControl();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case TimelinePackage.CONTROL_TRACK__CHANNELS:
				getChannels().clear();
				getChannels().addAll((Collection<? extends ChannelTrack>)newValue);
				return;
			case TimelinePackage.CONTROL_TRACK__CONTROL:
				setControl((Control)newValue);
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
			case TimelinePackage.CONTROL_TRACK__CHANNELS:
				getChannels().clear();
				return;
			case TimelinePackage.CONTROL_TRACK__CONTROL:
				setControl((Control)null);
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
			case TimelinePackage.CONTROL_TRACK__CHANNELS:
				return channels != null && !channels.isEmpty();
			case TimelinePackage.CONTROL_TRACK__CONTROL:
				return control != null;
		}
		return super.eIsSet(featureID);
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	@Override
	public MotionClip getParent()
	{
		return (MotionClip)super.getParent();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getTotalFrames()
	{
		int maxFrame = 0;
		for(ChannelTrack child : getChannels())
		{
			int frame = child.getTotalFrames(); // 각 채널의 프레임 수
			if(maxFrame < frame) maxFrame = frame;
		}
		return maxFrame;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ChannelTrack createChannelTrack(Channel channel)
	{
		ChannelTrack newChannelTrack;
		if(channel instanceof FileChannel) newChannelTrack = TimelineFactory.eINSTANCE.createFileTrack();
		else if(channel instanceof TextChannel) newChannelTrack = TimelineFactory.eINSTANCE.createTextTrack();
		else if(channel instanceof CommandChannel) newChannelTrack = TimelineFactory.eINSTANCE.createCommandTrack();
		else if(channel instanceof VoiceChannel) newChannelTrack = TimelineFactory.eINSTANCE.createVoiceTrack();
		else if(channel instanceof AudioChannel) newChannelTrack = TimelineFactory.eINSTANCE.createAudioTrack();
		else if(channel instanceof ColorChannel) newChannelTrack = TimelineFactory.eINSTANCE.createColorTrack();
		else if(channel instanceof MatrixChannel) newChannelTrack = TimelineFactory.eINSTANCE.createMatrixTrack();
		else newChannelTrack = TimelineFactory.eINSTANCE.createLinearTrack();
		
		newChannelTrack.setChannel(channel);
		return newChannelTrack;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createChannelTracks(Control control)
	{
		if(control == null) return;
		getChannels().clear();
		
		for(Channel channel : control.getChannels())
		{
			getChannels().add(createChannelTrack(channel));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateReference(Control newControl)
	{
		if(newControl == null) return;
		
		setControl(newControl);
		
		Iterator<ChannelTrack> it1 = getChannels().iterator();
		Iterator<Channel> it2 = newControl.getChannels().iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			ChannelTrack oldChannelTrack = it1.next();
			Channel newChannel = it2.next();
			oldChannelTrack.setChannel(newChannel);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ControlTrack deepCopy()
	{
		ControlTrack newTrack = TimelineFactory.eINSTANCE.createControlTrack();
		for(ChannelTrack channel : getChannels())
			newTrack.getChannels().add(channel.deepCopy());
		return newTrack;
	}
} //ControlTrackImpl
