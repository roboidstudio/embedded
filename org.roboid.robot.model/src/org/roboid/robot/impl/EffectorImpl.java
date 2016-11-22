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

package org.roboid.robot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.Effector;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effector</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.EffectorImpl#getProxyFor <em>Proxy For</em>}</li>
 *   <li>{@link org.roboid.robot.impl.EffectorImpl#getSustain <em>Sustain</em>}</li>
 *   <li>{@link org.roboid.robot.impl.EffectorImpl#getThrottle <em>Throttle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EffectorImpl extends MotoringDeviceImpl implements Effector
{
	/**
	 * The cached value of the '{@link #getProxyFor() <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyFor()
	 * @generated
	 * @ordered
	 */
	protected Effector proxyFor;

	/**
	 * The default value of the '{@link #getSustain() <em>Sustain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSustain()
	 * @generated
	 * @ordered
	 */
	protected static final int SUSTAIN_EDEFAULT = 5;

	/**
	 * The cached value of the '{@link #getSustain() <em>Sustain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSustain()
	 * @generated
	 * @ordered
	 */
	protected int sustain = SUSTAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrottle() <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottle()
	 * @generated
	 * @ordered
	 */
	protected static final int THROTTLE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getThrottle() <em>Throttle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrottle()
	 * @generated
	 * @ordered
	 */
	protected int throttle = THROTTLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EffectorImpl()
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
		return RobotPackage.Literals.EFFECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSustain()
	{
		return sustain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSustain(int newSustain)
	{
		int oldSustain = sustain;
		sustain = newSustain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.EFFECTOR__SUSTAIN, oldSustain, sustain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getThrottle()
	{
		return throttle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrottle(int newThrottle)
	{
		int oldThrottle = throttle;
		throttle = newThrottle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.EFFECTOR__THROTTLE, oldThrottle, throttle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyFor(Effector newProxyFor)
	{
		Effector oldProxyFor = proxyFor;
		proxyFor = newProxyFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.EFFECTOR__PROXY_FOR, oldProxyFor, proxyFor));
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
			case RobotPackage.EFFECTOR__PROXY_FOR:
				return getProxyFor();
			case RobotPackage.EFFECTOR__SUSTAIN:
				return getSustain();
			case RobotPackage.EFFECTOR__THROTTLE:
				return getThrottle();
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
			case RobotPackage.EFFECTOR__PROXY_FOR:
				setProxyFor((Effector)newValue);
				return;
			case RobotPackage.EFFECTOR__SUSTAIN:
				setSustain((Integer)newValue);
				return;
			case RobotPackage.EFFECTOR__THROTTLE:
				setThrottle((Integer)newValue);
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
			case RobotPackage.EFFECTOR__PROXY_FOR:
				setProxyFor((Effector)null);
				return;
			case RobotPackage.EFFECTOR__SUSTAIN:
				setSustain(SUSTAIN_EDEFAULT);
				return;
			case RobotPackage.EFFECTOR__THROTTLE:
				setThrottle(THROTTLE_EDEFAULT);
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
			case RobotPackage.EFFECTOR__PROXY_FOR:
				return proxyFor != null;
			case RobotPackage.EFFECTOR__SUSTAIN:
				return sustain != SUSTAIN_EDEFAULT;
			case RobotPackage.EFFECTOR__THROTTLE:
				return throttle != THROTTLE_EDEFAULT;
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
		result.append(" (sustain: ");
		result.append(sustain);
		result.append(", throttle: ");
		result.append(throttle);
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
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Effector)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Effector other = (Effector)obj;
		if(getSustain() != other.getSustain()) return false;
		if(getThrottle() != other.getThrottle()) return false;
		if(isProxy())
		{
			if(!equalsProxyContents(getProxyFor(), other.getProxyFor())) return false;
		}
		
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Effector getProxyFor()
	{
		return isProxy() ? proxyFor : null;
	}
	
	/**
	 * @generated NOT
	 */
	public void setProxyFor(Device newProxyFor)
	{
		if(newProxyFor == null || newProxyFor instanceof Effector)
			setProxyFor((Effector)newProxyFor);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNext()
	{
		return NEXT;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	protected TypedBuffer createTypedBuffer()
	{
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			return new IntTypedEffectBuffer(getDataSize());
		case DataType.FLOAT_VALUE:
			return new FloatTypedEffectBuffer(getDataSize());
		case DataType.STRING_VALUE:
			return new StringTypedBuffer(getDataSize());
		case DataType.IMAGE_VALUE:
			return new ImageTypedBuffer(getDataSize());
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected class IntTypedEffectBuffer extends AbstractIntTypedBuffer
	{
		public IntTypedEffectBuffer(int dataSize)
		{
			super(dataSize);
		}
		
		//현재는 더하기만 지원한다.
		@Override
		public void write(int[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] += data[from + i];
				if(buf[i] < getMin()) buf[i] = getMin();
				else if(buf[i] > getMax()) buf[i] = getMax();
			}
			FULL = true;
		}
		
		@Override
		public void write(int[] data, int index, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			if(index < 0 || index >= len) return;
			buf[index] += data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
		
		//현재는 더하기만 지원한다.
		public void write(float[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] += (int)data[from + i];
				if(buf[i] < getMin()) buf[i] = getMin();
				else if(buf[i] > getMax()) buf[i] = getMax();
			}
			FULL = true;
		}
		
		public void write(float[] data, int index, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			if(index < 0 || index >= len) return;
			buf[index] += (int)data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected class FloatTypedEffectBuffer extends AbstractFloatTypedBuffer
	{
		public FloatTypedEffectBuffer(int dataSize)
		{
			super(dataSize);
		}
		
		//현재는 더하기만 지원한다.
		public void write(int[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] += data[from + i];
				if(buf[i] < getMin()) buf[i] = getMin();
				else if(buf[i] > getMax()) buf[i] = getMax();
			}
			FULL = true;
		}
		
		public void write(int[] data, int index, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			if(index < 0 || index >= len) return;
			buf[index] += data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
		
		//현재는 더하기만 지원한다.
		public void write(float[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] += data[from + i];
				if(buf[i] < getMin()) buf[i] = getMin();
				else if(buf[i] > getMax()) buf[i] = getMax();
			}
			FULL = true;
		}
		
		public void write(float[] data, int index, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			if(index < 0 || index >= len) return;
			buf[index] += data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
	}
} //EffectorImpl
