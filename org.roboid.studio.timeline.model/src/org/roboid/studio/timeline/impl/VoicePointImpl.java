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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.robot.AudioMode;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;
import org.roboid.studio.timeline.VoicePoint;
import org.roboid.studio.timeline.VoiceTrack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Voice Point</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.VoicePointImpl#getLipGain <em>Lip Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VoicePointImpl extends AudioPointImpl implements VoicePoint
{
	/**
	 * The default value of the '{@link #getLipGain() <em>Lip Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLipGain()
	 * @generated
	 * @ordered
	 */
	protected static final int LIP_GAIN_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getLipGain() <em>Lip Gain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLipGain()
	 * @generated
	 * @ordered
	 */
	protected int lipGain = LIP_GAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoicePointImpl()
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
		return TimelinePackage.Literals.VOICE_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLipGain()
	{
		return lipGain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLipGain(int newLipGain)
	{
		int oldLipGain = lipGain;
		lipGain = newLipGain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.VOICE_POINT__LIP_GAIN, oldLipGain, lipGain));
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
			case TimelinePackage.VOICE_POINT__LIP_GAIN:
				return getLipGain();
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
			case TimelinePackage.VOICE_POINT__LIP_GAIN:
				setLipGain((Integer)newValue);
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
			case TimelinePackage.VOICE_POINT__LIP_GAIN:
				setLipGain(LIP_GAIN_EDEFAULT);
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
			case TimelinePackage.VOICE_POINT__LIP_GAIN:
				return lipGain != LIP_GAIN_EDEFAULT;
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
		result.append(" (lipGain: ");
		result.append(lipGain);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_GAIN = "_gain";

	@Override
	public VoicePoint deepCopy()
	{
		VoicePoint newPoint = TimelineFactory.eINSTANCE.createVoicePoint();
		copyTo(newPoint);
		return newPoint;
	}

	@Override
	void copyTo(ControlPoint newPoint)
	{
		super.copyTo(newPoint);
		if(!(newPoint instanceof VoicePoint)) return;
		
		((VoicePoint)newPoint).setLipGain(getLipGain());
	}
	
	@Override
	public AudioMode getMode()
	{
		if(mode == null)
			mode = ((VoiceTrack)getParent()).getMode();
		return mode;
	}
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		super.getPropertyDescriptors(propertyDescriptors);
		propertyDescriptors.add(new TextPropertyDescriptor(P_GAIN, "Lip Gain"));
	}
	
	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_GAIN)) return Integer.toString(getLipGain());
		return super.getPropertyValue(id);
	}

	// 프로퍼티의 값이 기본 값과 다르게 되었는지 묻는다.
	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_GAIN)) return true;
		return super.isPropertySet(id);
	}
	
	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{		
		if(id.equals(P_GAIN))
		{
			try
			{
				int v = Integer.parseInt((String)value);
				if(v < 0) v = 0;
				if(v > 9999) v = 9999;
				setLipGain(v);
			}
			catch(Exception e)
			{}
		}
		else
			super.setPropertyValue(id, value);
	}
} //VoicePointImpl
