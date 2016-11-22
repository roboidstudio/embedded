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
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.roboid.robot.Channel;
import org.roboid.robot.ChannelDevice;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.ChannelTrackImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.ChannelTrackImpl#getChannel <em>Channel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChannelTrackImpl extends MovableElementImpl implements ChannelTrack
{
	/**
	 * The cached value of the '{@link #getPoints() <em>Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlPoint> points;

	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected Channel channel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelTrackImpl()
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
		return TimelinePackage.Literals.CHANNEL_TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ControlPoint> getPoints()
	{
		if (points == null) {
			points = new EObjectContainmentEList<ControlPoint>(ControlPoint.class, this, TimelinePackage.CHANNEL_TRACK__POINTS);
		}
		return points;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Channel getChannel()
	{
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(Channel newChannel)
	{
		Channel oldChannel = channel;
		channel = newChannel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.CHANNEL_TRACK__CHANNEL, oldChannel, channel));
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
			case TimelinePackage.CHANNEL_TRACK__POINTS:
				return ((InternalEList<?>)getPoints()).basicRemove(otherEnd, msgs);
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
			case TimelinePackage.CHANNEL_TRACK__POINTS:
				return getPoints();
			case TimelinePackage.CHANNEL_TRACK__CHANNEL:
				return getChannel();
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
			case TimelinePackage.CHANNEL_TRACK__POINTS:
				getPoints().clear();
				getPoints().addAll((Collection<? extends ControlPoint>)newValue);
				return;
			case TimelinePackage.CHANNEL_TRACK__CHANNEL:
				setChannel((Channel)newValue);
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
			case TimelinePackage.CHANNEL_TRACK__POINTS:
				getPoints().clear();
				return;
			case TimelinePackage.CHANNEL_TRACK__CHANNEL:
				setChannel((Channel)null);
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
			case TimelinePackage.CHANNEL_TRACK__POINTS:
				return points != null && !points.isEmpty();
			case TimelinePackage.CHANNEL_TRACK__CHANNEL:
				return channel != null;
		}
		return super.eIsSet(featureID);
	}

	
	
	

	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	static final String P_CHANNEL = "_channel"; // 채널 이름
	static final String P_TARGET_DEVICE = "_device"; // 채널에 연결된 타겟 디바이스의 이름
	static final String P_DATA_TYPE = "_type"; // 타겟 디바이스의 데이터 타입
	static final String P_DATA_SIZE = "_size"; // 타겟 디바이스의 데이터 크기
	static final String P_DATA_DEFAULT = "_default"; // 타겟 디바이스의 데이터 기본 값
	static final String P_DATA_MAX = "_max"; // 타겟 디바이스의 데이터 최대 값
	static final String P_DATA_MIN = "_min"; // 타겟 디바이스의 데이터 최소 값
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		propertyDescriptors.add(new PropertyDescriptor(P_CHANNEL, "Channel"));
		propertyDescriptors.add(new PropertyDescriptor(P_TARGET_DEVICE, "Target Device"));
		propertyDescriptors.add(new PropertyDescriptor(P_DATA_TYPE, "Data Type"));
		propertyDescriptors.add(new PropertyDescriptor(P_DATA_SIZE, "Data Size"));
		
		Device device = getTargetDevice(0);
		if(device != null)
		{
			switch(device.getDataType().getValue())
			{
			case DataType.BYTE_VALUE:
			case DataType.UNSIGNED_BYTE_VALUE:
			case DataType.SHORT_VALUE:
			case DataType.UNSIGNED_SHORT_VALUE:
			case DataType.INTEGER_VALUE:
			case DataType.FLOAT_VALUE:
				propertyDescriptors.add(new PropertyDescriptor(P_DATA_MAX, "Maximum"));
				propertyDescriptors.add(new PropertyDescriptor(P_DATA_MIN, "Minimum"));
			case DataType.STRING_VALUE:
				propertyDescriptors.add(new PropertyDescriptor(P_DATA_DEFAULT, "Default"));
				break;
			}
		}
	}
	
	// 프로퍼티의 값을 얻는다.
	// 데이터 --> 프로퍼티 뷰로 넘겨 준다.
	@Override
	public Object getPropertyValue(Object id)
	{
		Device device = getTargetDevice(0);
		if(device != null)
		{
			if(id.equals(P_TARGET_DEVICE)) return device.getName();
			if(id.equals(P_DATA_TYPE)) return device.getDataType().getLiteral();
			if(id.equals(P_DATA_SIZE)) return Integer.valueOf(device.getDataSize());
			if(id.equals(P_DATA_DEFAULT)) return device.getDefaultString();
			if(id.equals(P_DATA_MAX)) return Integer.valueOf(device.getMax());
			if(id.equals(P_DATA_MIN)) return Integer.valueOf(device.getMin());
		}
		return null;
	}

	@Override
	public ControlTrack getParent()
	{
		return (ControlTrack)super.getParent();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addChild(ControlPoint child)
	{
		List<ControlPoint> points = getPoints();
		int index = 0;
		for(ControlPoint cp : points)
		{
			if(cp.getFrame() > child.getFrame())
				break;
			index ++;
		}
		points.add(index, child); // 제어점 추가
		child.setParent(this);
//		sortChildren(); // 프레임 순서에 따라 정렬
		firePropertyChange(P_CHILDREN, null, null); // 제어점 리스트에 변경이 있음을 에디트 파트에 알린다.
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChild(ControlPoint child)
	{
		getPoints().remove(child); // 제어점 삭제
//		sortChildren(); // 프레임 순서에 따라 정렬
		firePropertyChange(P_CHILDREN, null, null); // 제어점 리스트에 변경이 있음을 에디트 파트에 알린다.
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reorder(ControlPoint target)
	{
		int index = 0;
		for(ControlPoint cp : getPoints())
		{
			if(cp == target) continue;
			if(cp.getFrame() > target.getFrame()) break;
			index ++;
		}
		((EList<ControlPoint>)getPoints()).move(index, target);
		target.performConstraintChange();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract ChannelTrack deepCopy();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract ControlPoint deepCopy(ControlPoint cp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean canCopy(ControlPoint cp);

	protected void copyTo(ChannelTrack newTrack)
	{
		for(ControlPoint cp : getPoints())
			newTrack.addChild(cp.deepCopy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<ChannelDevice> getTargetDevices()
	{
		Channel channel = getChannel();
		if(channel == null) return Collections.emptyList();
		return channel.getDevices();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Device getTargetDevice(int index)
	{
		Channel channel = getChannel();
		if(channel == null) return null;
		if(index < 0 || index >= channel.getDevices().size()) return null;
		return channel.getDevices().get(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getTotalFrames()
	{
		int maxFrame = 0;
		for(ControlPoint cp : getPoints())
		{
			int frame = cp.getFrame(); // 각 제어점의 프레임
			if(maxFrame < frame) maxFrame = frame;
		}
		return maxFrame;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createSimulacra()
	{
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void dump(int frame);
	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void sortChildren()
//	{
//		List<ControlPoint> points = getPoints();
////		Collections.sort(points, new Comparator<ControlPoint>()
////		{
////			@Override
////			public int compare(ControlPoint o1, ControlPoint o2)
////			{
////				int frame1 = o1.getFrame();
////				int frame2 = o2.getFrame();
////				return (frame1 > frame2) ? 1 : ((frame1 < frame2) ? -1 : 0);
////			}
////		});
//		if(points.size() == 0) return; // 정렬할 게 없다.
//		
//		EList<ControlPoint> sorted = new EObjectContainmentEList<ControlPoint>(ControlPoint.class, this, TimelinePackage.CHANNEL_TRACK__POINTS);
//		sorted.add(points.get(0));
//		
//		for(int i = 1; i < points.size(); i ++)
//		{
//			boolean SORTED = false;
//			ControlPoint cp = points.get(i);
//			int cpx = cp.getFrame();
//			for(int j = 0; j < sorted.size(); j ++)
//			{
//				ControlPoint sp = sorted.get(j);
//				int spx = sp.getFrame();
//				if(cpx < spx )
//				{
//					sorted.add(j, cp);
//					SORTED = true;
//					break;
//				}
//			}
//			if(!SORTED) sorted.add(cp);
//		}
//		
//		for(int i = 0; i < sorted.size(); i ++)
//		{
//			this.points.set(i, sorted.get(i));
//		}
//	}
	
	protected float[] initialValues = null;
	
	public void setInitialValues(float[] values)
	{
		initialValues = values;
	}
	
	public float[] getValues(int frame)
	{
		return null;
	}
} //ChannelTrackImpl
