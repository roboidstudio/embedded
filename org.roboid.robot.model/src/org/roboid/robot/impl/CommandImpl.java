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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.roboid.robot.Command;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.CommandImpl#getProxyFor <em>Proxy For</em>}</li>
 *   <li>{@link org.roboid.robot.impl.CommandImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandImpl extends MotoringDeviceImpl implements Command
{
	/**
	 * The cached value of the '{@link #getProxyFor() <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyFor()
	 * @generated
	 * @ordered
	 */
	protected Command proxyFor;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.COMMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyFor(Command newProxyFor)
	{
		Command oldProxyFor = proxyFor;
		proxyFor = newProxyFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.COMMAND__PROXY_FOR, oldProxyFor, proxyFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotPackage.COMMAND__PROXY_FOR:
				return getProxyFor();
			case RobotPackage.COMMAND__ID:
				return getId();
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
			case RobotPackage.COMMAND__PROXY_FOR:
				setProxyFor((Command)newValue);
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
			case RobotPackage.COMMAND__PROXY_FOR:
				setProxyFor((Command)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RobotPackage.COMMAND__PROXY_FOR:
				return proxyFor != null;
			case RobotPackage.COMMAND__ID:
				return id != ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
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
		if(!(obj instanceof Command)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Command other = (Command)obj;
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
	public Command getProxyFor()
	{
		return isProxy() ? proxyFor : null;
	}
	
	/**
	 * @generated NOT
	 */
	public void setProxyFor(Device newProxyFor)
	{
		if(newProxyFor == null || newProxyFor instanceof Command)
			setProxyFor((Command)newProxyFor);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload)
	{
		if(canSend())
			payload.write(id);
		super.getSimulacrum(deviceMap, payload);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void prepareToSend()
	{
		id = (id+1) & 0xff;
		super.prepareToSend();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
		if(isMaster) setMasterPayload(simulacrum);
		else setSlavePayload(simulacrum, false);
	}

	/**
	 * @generated NOT
	 */
	private void setMasterPayload(ByteArrayInputStream simulacrum)
	{
		if(isReceived())
		{
			int ack = simulacrum.read();
			if(ack == id) 
			{
				if(SEND_FLAG)
				{	
					for(DeviceListener listener : getDeviceListeners())
						listener.commandPerformed(this);
				}
				
				SEND_FLAG = false;
				retry = 0;
			}
		}
	}

	/**
	 * @generated NOT
	 */
	private void setSlavePayload(ByteArrayInputStream simulacrum, boolean skip)
	{
		if(isReceived())
		{
			SEND_FLAG = true;
			
			id = simulacrum.read();
	
			if(isProxy())
			{
				Device target = getProxyFor();
				if(target != null) target.readPayload(simulacrum, skip);
			}
			else
				readPayload(simulacrum, skip);
		}
		else
		{
			SEND_FLAG = false;
		}		
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
			return new IntTypedCommandBuffer(getDataSize());
		case DataType.FLOAT_VALUE:
			return new FloatTypedCommandBuffer(getDataSize());
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
	protected class IntTypedCommandBuffer extends AbstractIntTypedBuffer
	{
		public IntTypedCommandBuffer(int dataSize)
		{
			super(dataSize);
		}
		
		@Override
		public void write(int[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] = data[from + i];
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
			buf[index] = data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
		
		public void write(float[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] = (int)data[from + i];
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
			buf[index] = (int)data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected class FloatTypedCommandBuffer extends AbstractFloatTypedBuffer
	{
		public FloatTypedCommandBuffer(int dataSize)
		{
			super(dataSize);
		}
		
		public void write(int[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] = data[from + i];
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
			buf[index] = data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
		
		public void write(float[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
			{
				buf[i] = data[from + i];
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
			buf[index] = data[from + index];
			if(buf[index] < getMin()) buf[index] = getMin();
			else if(buf[index] > getMax()) buf[index] = getMax();
			FULL = true;
		}
	}
} //CommandImpl
