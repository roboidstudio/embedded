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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.CommandPoint;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Point</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.CommandPointImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandPointImpl extends ControlPointImpl implements CommandPoint
{
	/**
	 * The default value of the '{@link #getValues() <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected static final float[] VALUES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected float[] values = VALUES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandPointImpl()
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
		return TimelinePackage.Literals.COMMAND_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValues(float[] newValues) {
		float[] oldValues = values;
		values = newValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.COMMAND_POINT__VALUES, oldValues, values));
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
			case TimelinePackage.COMMAND_POINT__VALUES:
				return getValues();
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
			case TimelinePackage.COMMAND_POINT__VALUES:
				setValues((float[])newValue);
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
			case TimelinePackage.COMMAND_POINT__VALUES:
				setValues(VALUES_EDEFAULT);
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
			case TimelinePackage.COMMAND_POINT__VALUES:
				return VALUES_EDEFAULT == null ? values != null : !VALUES_EDEFAULT.equals(values);
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
		result.append(" (values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */

	private static final String P_VALUE = "_value";
	private static final int MAX_DISPLAY_VALUE = 100;
	private int dataSize = -1;
	private int dataMaxValue, dataMinValue;
	private boolean hasDataMaxValue, hasDataMinValue;
	private DataType dataType;
	
	@Override
	public CommandPoint deepCopy()
	{
		CommandPoint newPoint = TimelineFactory.eINSTANCE.createCommandPoint();
		copyTo(newPoint);
		return newPoint;
	}
	
	@Override
	void copyTo(ControlPoint newPoint)
	{
		super.copyTo(newPoint);
		if(!(newPoint instanceof CommandPoint)) return;
		
		float[] source = getValues();
		if(source != null)
			((CommandPoint)newPoint).setValues(Arrays.copyOf(source, source.length));
	}
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		super.getPropertyDescriptors(propertyDescriptors);
		if(getDataSize() == 1)
			propertyDescriptors.add(new TextPropertyDescriptor(P_VALUE, "Value"));
		else if(getDataSize() >= 2)
		{
			for(int i = 0; i < getDataSize() && i < MAX_DISPLAY_VALUE; i ++)
				propertyDescriptors.add(new TextPropertyDescriptor(P_VALUE + i, String.format("Value [%02d]", i)));
		}
	}

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_VALUE)) return valueToString(getValues()[0]);
		else if(getDataSize() >= 2)
		{
			for(int i = 0; i < getValues().length && i < MAX_DISPLAY_VALUE; i ++)
			{
				if(id.equals(P_VALUE + i)) return valueToString(getValues()[i]);
			}
		}
		return super.getPropertyValue(id);
	}

	// 프로퍼티의 값이 기본 값과 다르게 되었는지 묻는다.
	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_VALUE)) return true;
		else if(getDataSize() >= 2)
		{
			for(int i = 0; i < getDataSize() && i < MAX_DISPLAY_VALUE; i ++)
			{
				if(id.equals(P_VALUE + i)) return true;
			}
		}
		return super.isPropertySet(id);
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_VALUE))
		{
			setValue(0, (String)value);
			return;
		}
		else if(getDataSize() >= 2)
		{
			for(int i = 0; i < getDataSize() && i < MAX_DISPLAY_VALUE; i ++)
			{
				if(id.equals(P_VALUE + i))
				{
					setValue(i, (String)value);
					return;
				}
			}
		}
		super.setPropertyValue(id, value);
	}
	
	// 데이터를 설정한다.
	private void setValue(int index, String value)
	{
		if(index < 0 || index >= getValues().length) return;
		
		try
		{
			float v = Float.parseFloat(value);
			if(v < getDataMinValue()) v = getDataMinValue();
			else if(v > getDataMaxValue()) v = getDataMaxValue();
			getValues()[index] = v;
		} catch (Exception e)
		{
		}
	}
	
	private String valueToString(float value)
	{
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
			return Byte.toString((byte)value);
		case DataType.SHORT_VALUE:
			return Short.toString((short)value);
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			return Integer.toString((int)value);
		case DataType.FLOAT_VALUE:
			return Float.toString(value);
		default:
			return "";
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDataSize()
	{
		if(dataSize < 0)
		{
			Device device = getParent().getTargetDevice(0);
			if(device != null)
				dataSize = device.getDataSize();
		}
		return dataSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDataMaxValue()
	{
		if(hasDataMaxValue == false)
		{
			Device device = getParent().getTargetDevice(0);
			if(device != null)
			{
				dataMaxValue = device.getMax();
				hasDataMaxValue = true;
			}
		}
		return dataMaxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDataMinValue()
	{
		if(hasDataMinValue == false)
		{
			Device device = getParent().getTargetDevice(0);
			if(device != null)
			{
				dataMinValue = device.getMin();
				hasDataMinValue = true;
			}
		}
		return dataMinValue;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataType getDataType()
	{
		if(dataType == null)
		{
			Device device = getParent().getTargetDevice(0);
			if(device != null)
				dataType = device.getDataType();
			else
				dataType = DataType.INTEGER;
		}
		return dataType;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float[] getValues()
	{
		if(values == null)
		{
			int dataSize = 0;
			float defaultValue = 0;
			Device device = getParent().getTargetDevice(0);
			if(device != null)
			{
				dataSize = device.getDataSize();
				defaultValue = device.getDefaultFloat();
			}
			values = new float[dataSize];
			Arrays.fill(values, defaultValue);
		}
		return values;
	}
} //CommandPointImpl
