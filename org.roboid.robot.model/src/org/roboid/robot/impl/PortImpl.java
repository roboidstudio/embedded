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
import java.io.IOException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.roboid.robot.IoMode;
import org.eclipse.swt.graphics.ImageData;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.Port;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.PortImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.roboid.robot.impl.PortImpl#getProxyFor <em>Proxy For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends ChannelDeviceImpl implements Port {
	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final IoMode MODE_EDEFAULT = IoMode.NONE;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected IoMode mode = MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProxyFor() <em>Proxy For</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyFor()
	 * @generated
	 * @ordered
	 */
	protected Port proxyFor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IoMode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(IoMode newMode) {
		IoMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.PORT__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyFor(Port newProxyFor) {
		Port oldProxyFor = proxyFor;
		proxyFor = newProxyFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.PORT__PROXY_FOR, oldProxyFor, proxyFor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotPackage.PORT__MODE:
				return getMode();
			case RobotPackage.PORT__PROXY_FOR:
				return getProxyFor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RobotPackage.PORT__MODE:
				setMode((IoMode)newValue);
				return;
			case RobotPackage.PORT__PROXY_FOR:
				setProxyFor((Port)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case RobotPackage.PORT__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case RobotPackage.PORT__PROXY_FOR:
				setProxyFor((Port)null);
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
			case RobotPackage.PORT__MODE:
				return mode != MODE_EDEFAULT;
			case RobotPackage.PORT__PROXY_FOR:
				return proxyFor != null;
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
	 * @generated NOT
	 */
	private int[] intData = new int[0];
	/**
	 * @generated NOT
	 */
	private float[] floatData = new float[0];
	/**
	 * @generated NOT
	 */
	private String[] stringData = new String[0];
	/**
	 * @generated NOT
	 */
	protected int retry;
	/**
	 * @generated NOT
	 */
	private static final int RETRY_COUNT = 5; //128;
	
	/**
	 * @generated NOT
	 */
	private TypedArray typedArray;
	/**
	 * @generated NOT
	 */
	private TypedBuffer typedBuffer;
	/**
	 * @generated NOT
	 */
	protected boolean NEXT;
	/**
	 * @generated NOT
	 */
	private int pointer;
	
	/**
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Port)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Port other = (Port)obj;
		if(getMode() != other.getMode()) return false;
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
	public Port getProxyFor()
	{
		return isProxy() ? proxyFor : null;
	}
	
	/**
	 * @generated NOT
	 */
	public void setProxyFor(Device newProxyFor)
	{
		if(newProxyFor == null || newProxyFor instanceof Port)
			setProxyFor((Port)newProxyFor);
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
	public synchronized void createDeviceMemory()
	{
		if(isProxy()) return;

		super.createDeviceMemory();
		if(dataSize <= 0) return;

		typedBuffer = createTypedBuffer();
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			typedArray = new IntTypedArray();
			break;
		case DataType.FLOAT_VALUE:
			typedArray = new FloatTypedArray();
			break;
		case DataType.STRING_VALUE:
			typedArray = new StringTypedArray();
			break;
		case DataType.IMAGE_VALUE:
			typedArray = new ImageTypedArray();
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * @generated NOT
	 */
	protected TypedBuffer createTypedBuffer()
	{
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			return new IntTypedPortBuffer(getDataSize());
		case DataType.FLOAT_VALUE:
			return new FloatTypedPortBuffer(getDataSize());
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
	@Override
	public synchronized void clearDeviceMemory()
	{
		super.clearDeviceMemory();
		if(typedBuffer != null) typedBuffer.clear();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
		if(isMaster)
		{
			if(isReceived())
			{
				if(isProxy())
				{
					Device target = getProxyFor();
					if(target != null) target.readPayload(simulacrum, false);
				}
				else
					readPayload(simulacrum, false);
				
				for(DeviceListener listener: getDeviceListeners())
					listener.stateChanged(this);
				super.setFired();
			}
		}
		else
		{
			setSlavePayload(simulacrum, false);
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void readPayload(ByteArrayInputStream payload, boolean skip)
	{
		if(getDataSize() == 0)
		{
			if(!skip)
				typedDevice.write();
		}
		else
		{
			switch(dataType.getValue())
			{
			case DataType.BYTE_VALUE:
				{
					if(intData.length != getDataSize())
						intData = new int[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
					{
						intData[i] = (int)(payload.read() & 0xff);
						if(intData[i] > 127)
							intData[i] -= 256;
					}
					if(!skip)
						typedDevice.write(intData);
					break;
				}
			case DataType.UNSIGNED_BYTE_VALUE:
				{
					if(intData.length != getDataSize())
						intData = new int[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
						intData[i] = (int)(payload.read() & 0xff);
					if(!skip)
						typedDevice.write(intData);
					break;
				}
			case DataType.SHORT_VALUE:
				{
					if(intData.length != getDataSize())
						intData = new int[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
					{
						intData[i] = (int)(payload.read() & 0xff) << 8;
						intData[i] |= (int)(payload.read() & 0xff);
						if(intData[i] > 32767)
							intData[i] -= 65536;
					}
					if(!skip)
						typedDevice.write(intData);
					break;
				}
			case DataType.UNSIGNED_SHORT_VALUE:
				{
					if(intData.length != getDataSize())
						intData = new int[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
					{
						intData[i] = (int)(payload.read() & 0xff) << 8;
						intData[i] |= (int)(payload.read() & 0xff);
					}
					if(!skip)
						typedDevice.write(intData);
					break;
				}
			case DataType.INTEGER_VALUE:
				{
					if(intData.length != getDataSize())
						intData = new int[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
					{
						intData[i] = (int)(payload.read() & 0xff) << 24;
						intData[i] |= (int)(payload.read() & 0xff) << 16;
						intData[i] |= (int)(payload.read() & 0xff) << 8;
						intData[i] |= (int)(payload.read() & 0xff);
					}
					if(!skip)
						typedDevice.write(intData);
					break;
				}
			case DataType.FLOAT_VALUE:
				{
					int data = 0;
					if(floatData.length != getDataSize())
						floatData = new float[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
					{
						data = (int)(payload.read() & 0xff) << 24;
						data |= (int)(payload.read() & 0xff) << 16;
						data |= (int)(payload.read() & 0xff) << 8;
						data |= (int)(payload.read() & 0xff);
						floatData[i] = Float.intBitsToFloat(data);
					}
					if(!skip)
						typedDevice.write(floatData);
					break;
				}
			case DataType.STRING_VALUE:
				{
					int len = 0;
					if(stringData.length != getDataSize())
						stringData = new String[getDataSize()];
					for(int i = 0; i < getDataSize(); ++i)
					{
						try
						{
							len = (int)(payload.read() & 0xff) << 24;
							len |= (int)(payload.read() & 0xff) << 16;
							len |= (int)(payload.read() & 0xff) << 8;
							len |= (int)(payload.read() & 0xff);
							byte[] buf = new byte[len];
							payload.read(buf);
							stringData[i] = new String(buf, "utf-8");
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					}
					if(!skip)
						typedDevice.write(stringData);
					break;
				}
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
			
			if(isProxy())
			{
				Device target = getProxyFor();
				if(target != null) readPayload(simulacrum, skip);
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
	public void updateDeviceState()
	{
		setEvent();
		
		if(getDataSize() <= 0 || typedBuffer == null) return;
		if(typedBuffer.isEmpty()) return;
		
		typedBuffer.copyTo(typedDevice);
		
		// Clear buffer momory
		typedBuffer.clear();
		
		if(NEXT) writeNext();
		
		if(--retry < 1)
		{
			retry = 0;
			SEND_FLAG = false;
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void writePayload(ByteArrayOutputStream payload)
	{
		int data = 0;
		switch(dataType.getValue())
		{
			case DataType.BYTE_VALUE:
			case DataType.UNSIGNED_BYTE_VALUE:
				for(int i = 0; i < getDataSize(); i ++)
				{
					data = typedDevice.read(i);
					payload.write(data & 0xff);
				}
				break;
			case DataType.SHORT_VALUE: 		//Should be big-endian
			case DataType.UNSIGNED_SHORT_VALUE:
				for(int i = 0; i < getDataSize(); i ++)
				{
					data = typedDevice.read(i);
					payload.write((data >> 8) & 0xff);
					payload.write(data & 0xff);
				}
				break;
			case DataType.INTEGER_VALUE:
				for(int i = 0; i < getDataSize(); i ++)
				{
					data = typedDevice.read(i);
					payload.write((data >> 24) & 0xff);
					payload.write((data >> 16) & 0xff);
					payload.write((data >> 8) & 0xff);
					payload.write(data & 0xff);
				}
				break;
			case DataType.FLOAT_VALUE:
				for(int i = 0; i < getDataSize(); i ++)
				{
					data = Float.floatToIntBits(typedDevice.readFloat(i));
					payload.write((data >> 24) & 0xff);
					payload.write((data >> 16) & 0xff);
					payload.write((data >> 8) & 0xff);
					payload.write(data & 0xff);
				}
				break;
			case DataType.STRING_VALUE:
				for(int i = 0; i < getDataSize(); ++i)
				{
					try
					{
						String str = typedDevice.readString(i);
						data = str.length();
						payload.write((data >> 24) & 0xff);
						payload.write((data >> 16) & 0xff);
						payload.write((data >> 8) & 0xff);
						payload.write(data & 0xff);
						payload.write(str.getBytes("utf-8"));
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				break;
		}
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload)
	{
		if(canSend())
		{
			deviceMap.write(1);
//			if(dataSize <= 0) return;
//			
//			if(!effectBuffer.isEmpty())
//				effectBuffer.copyTo(effectData);
//			
//			// Clear buffer momory
//			effectBuffer.clear();
			
//			updateSimulacrum();
			
			if(isProxy())
			{
				Device target = getProxyFor();
				if(target != null) target.writePayload(payload);
			}
			else
				writePayload(payload);
			
//			if(NEXT) writeNext();
//			
//			if(--retry < 1)
//			{
//				retry = 0;
//				ACTIVE = false;
//			}
		}
		else
			deviceMap.write(0);
	}

	/**
	 * @generated NOT
	 */
	private void writeNext()
	{
		if(typedArray == null || getDataSize() <= 0)
			return;
		
		pointer += getDataSize();
		if(pointer < typedArray.getLength())
		{
			typedArray.writeToBuffer(typedBuffer, pointer);
			retry = RETRY_COUNT;
			SEND_FLAG = true;			
			return;
		}

		pointer = 0;
		NEXT = false;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write()
	{
		setFired();
		prepareToSend();
		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int data)
	{
		if(dataSize <= 0) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(0, data);
		typedArray.writeToBuffer(typedBuffer, 0, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, int data)
	{
		if(dataSize <= 0) return false;
		if(index < 0 || index >= dataSize) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(index, data);
		typedArray.writeToBuffer(typedBuffer, index, 0);
		prepareToSend();
		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int[] data)
	{
		if(dataSize <= 0 || data == null) return false;
		
		setFired();
		
		int len = (data.length + dataSize - 1) / dataSize * dataSize;
		typedArray.initArray(len);
		typedArray.setData(data);
		typedArray.writeToBuffer(typedBuffer, 0);
		prepareToSend();
		if(data.length > dataSize)
			NEXT = true;
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(float data)
	{
		if(dataSize <= 0) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(0, data);
		typedArray.writeToBuffer(typedBuffer, 0, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, float data)
	{
		if(dataSize <= 0) return false;
		if(index < 0 || index >= dataSize) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(index, data);
		typedArray.writeToBuffer(typedBuffer, index, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(float[] data)
	{
		if(dataSize <= 0 || data == null) return false;
		
		setFired();
		
		int len = (data.length + dataSize - 1) / dataSize * dataSize;
		typedArray.initArray(len);
		typedArray.setData(data);
		typedArray.writeToBuffer(typedBuffer, 0);
		prepareToSend();
		if(data.length > dataSize)
			NEXT = true;
		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(String text)
	{
		if(dataSize <= 0) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(0, text);
		typedArray.writeToBuffer(typedBuffer, 0, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, String text)
	{
		if(dataSize <= 0) return false;
		if(index < 0 || index >= dataSize) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(index, text);
		typedArray.writeToBuffer(typedBuffer, index, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(String[] text)
	{
		if(dataSize <= 0 || text == null) return false;
		
		setFired();
		
		int len = (text.length + dataSize - 1) / dataSize * dataSize;
		typedArray.initArray(len);
		typedArray.setData(text);
		typedArray.writeToBuffer(typedBuffer, 0);
		prepareToSend();
		if(text.length > dataSize)
			NEXT = true;
		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(ImageData imageData)
	{
		if(dataSize <= 0) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(0, imageData);
		typedArray.writeToBuffer(typedBuffer, 0, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, ImageData imageData)
	{
		if(dataSize <= 0) return false;
		if(index < 0 || index >= dataSize) return false;
		
		setFired();
		
		typedArray.initArray(dataSize);
		typedArray.setData(index, imageData);
		typedArray.writeToBuffer(typedBuffer, index, 0);
		prepareToSend();
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(ImageData[] imageData)
	{
		if(dataSize <= 0 || imageData == null) return false;
		
		setFired();
		
		int len = (imageData.length + dataSize - 1) / dataSize * dataSize;
		typedArray.initArray(len);
		typedArray.setData(imageData);
		typedArray.writeToBuffer(typedBuffer, 0);
		prepareToSend();
		if(imageData.length > dataSize)
			NEXT = true;
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	protected void prepareToSend()
	{
		retry = RETRY_COUNT;
		SEND_FLAG = true;
		NEXT = false;
		pointer = 0;
	}
	
	/**
	 * @generated NOT
	 */
	private interface TypedArray
	{
		public void initArray(int dataSize);
		public int getLength();
		public void setData(int index, int data);
		public void setData(int index, float data);
		public void setData(int index, String data);
		public void setData(int index, ImageData data);
		public void setData(int[] data);
		public void setData(float[] data);
		public void setData(String[] data);
		public void setData(ImageData[] data);
		public void writeToBuffer(TypedBuffer buffer, int from);
		public void writeToBuffer(TypedBuffer buffer, int index, int from);
	}
	
	/**
	 * @generated NOT
	 */
	private abstract class AbstractTypedArray implements TypedArray
	{
		@Override
		public void setData(int index, int data)
		{
		}
		
		@Override
		public void setData(int index, float data)
		{
		}
		
		@Override
		public void setData(int index, String data)
		{
		}
		
		@Override
		public void setData(int index, ImageData data)
		{
		}
		
		@Override
		public void setData(int[] data)
		{
		}
		
		@Override
		public void setData(float[] data)
		{
		}
		
		@Override
		public void setData(String[] data)
		{
		}
		
		@Override
		public void setData(ImageData[] data)
		{
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class IntTypedArray extends AbstractTypedArray
	{
		private int[] data;
		
		@Override
		public void initArray(int dataSize)
		{
			if(data == null || data.length != dataSize)
				data = new int[dataSize];
			else
			{
				for(int i = 0; i < data.length; i ++)
					data[i] = 0;
			}
		}

		@Override
		public int getLength()
		{
			return data == null ? 0 : data.length;
		}
		
		@Override
		public void setData(int index, int data)
		{
			this.data[index] = data;
		}
		
		@Override
		public void setData(int index, float data)
		{
			this.data[index] = (int)data;
		}
		
		@Override
		public void setData(int[] data)
		{
			System.arraycopy(data, 0, this.data, 0, data.length);
		}
		
		@Override
		public void setData(float[] data)
		{
			for(int i = 0; i < data.length; i ++)
				this.data[i] = (int)data[i];
		}

		@Override
		public void writeToBuffer(TypedBuffer buffer, int from)
		{
			if(buffer != null)
				buffer.write(data, from);
		}
		
		@Override
		public void writeToBuffer(TypedBuffer buffer, int index, int from)
		{
			if(buffer != null)
				buffer.write(data, index, from);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class FloatTypedArray extends AbstractTypedArray
	{
		private float[] data;
		
		@Override
		public void initArray(int dataSize)
		{
			if(data == null || data.length != dataSize)
				data = new float[dataSize];
			else
			{
				for(int i = 0; i < data.length; i ++)
					data[i] = 0;
			}
		}

		@Override
		public int getLength()
		{
			return data == null ? 0 : data.length;
		}
		
		@Override
		public void setData(int index, int data)
		{
			this.data[index] = data;
		}
		
		@Override
		public void setData(int index, float data)
		{
			this.data[index] = data;
		}

		@Override
		public void setData(int[] data)
		{
			for(int i = 0; i < data.length; i ++)
				this.data[i] = data[i];
		}
		
		@Override
		public void setData(float[] data)
		{
			System.arraycopy(data, 0, this.data, 0, data.length);
		}
		
		@Override
		public void writeToBuffer(TypedBuffer buffer, int from)
		{
			if(buffer != null)
				buffer.write(data, from);
		}
		
		@Override
		public void writeToBuffer(TypedBuffer buffer, int index, int from)
		{
			if(buffer != null)
				buffer.write(data, index, from);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class StringTypedArray extends AbstractTypedArray
	{
		private String[] data;
		
		@Override
		public void initArray(int dataSize)
		{
			if(data == null || data.length != dataSize)
				data = new String[dataSize];
			else
			{
				for(int i = 0; i < data.length; i ++)
					data[i] = null;
			}
		}

		@Override
		public int getLength()
		{
			return data == null ? 0 : data.length;
		}
		
		@Override
		public void setData(int index, String data)
		{
			this.data[index] = data;
		}
		
		@Override
		public void setData(String[] data)
		{
			for(int i = 0; i < data.length; i ++)
				this.data[i] = data[i];
		}

		@Override
		public void writeToBuffer(TypedBuffer buffer, int from)
		{
			if(buffer != null)
				buffer.write(data, from);
		}
		
		@Override
		public void writeToBuffer(TypedBuffer buffer, int index, int from)
		{
			if(buffer != null)
				buffer.write(data, index, from);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class ImageTypedArray extends AbstractTypedArray
	{
		private ImageData[] data;
		
		@Override
		public void initArray(int dataSize)
		{
			if(data == null || data.length != dataSize)
				data = new ImageData[dataSize];
			else
			{
				for(int i = 0; i < data.length; i ++)
					data[i] = null;
			}
		}

		@Override
		public int getLength()
		{
			return data == null ? 0 : data.length;
		}
		
		@Override
		public void setData(int index, ImageData data)
		{
			this.data[index] = data;
		}
		
		@Override
		public void setData(ImageData[] data)
		{
			for(int i = 0; i < data.length; i ++)
				this.data[i] = data[i];
		}

		@Override
		public void writeToBuffer(TypedBuffer buffer, int from)
		{
			if(buffer != null)
				buffer.write(data, from);
		}
		
		@Override
		public void writeToBuffer(TypedBuffer buffer, int index, int from)
		{
			if(buffer != null)
				buffer.write(data, index, from);
		}
	}
	
	/**
	 * Data Manager of Motoring device.
	 * @author Kyoung Jin Kim
	 * @author Kwang-Hyun Park
	 */
	/**
	 * @generated NOT
	 */
	protected interface TypedBuffer
	{
		public void clear();
		public void write(int[] data, int from);
		public void write(float[] data, int from);
		public void write(String[] data, int from);
		public void write(ImageData[] data, int from);
		public void write(int[] data, int index, int from);
		public void write(float[] data, int index, int from);
		public void write(String[] data, int index, int from);
		public void write(ImageData[] data, int index, int from);
		public void copyTo(TypedDevice nativeDevice);
		public boolean isEmpty();
	}
	
	/**
	 * @generated NOT
	 */
	protected abstract class AbstractTypedBuffer implements TypedBuffer
	{
		public void write(int[] data, int from)
		{
		}
		
		public void write(float[] data, int from)
		{
		}
		
		public void write(String[] data, int from)
		{
		}
		
		public void write(ImageData[] data, int from)
		{
		}
		
		public void write(int[] data, int index, int from)
		{
		}
		
		public void write(float[] data, int index, int from)
		{
		}
		
		public void write(String[] data, int index, int from)
		{
		}
		
		public void write(ImageData[] data, int index, int from)
		{
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected abstract class AbstractIntTypedBuffer extends AbstractTypedBuffer
	{
		protected int[] buf;
		protected boolean FULL;
		
		public AbstractIntTypedBuffer(int dataSize)
		{
			if(dataSize <= 0) return;
			buf = new int[dataSize];
		}
		
		public void clear()
		{
			if(buf == null) return;
			for(int i = 0; i < buf.length; i++)
				buf[i] = 0;
		}
		
		public void copyTo(TypedDevice nativeDevice)
		{
			if(buf == null) return;
			nativeDevice.write(buf);
			FULL = false;
		}

		public boolean isEmpty()
		{
			return !FULL;
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected abstract class AbstractFloatTypedBuffer extends AbstractTypedBuffer
	{
		protected float[] buf;
		protected boolean FULL;
		
		public AbstractFloatTypedBuffer(int dataSize)
		{
			if(dataSize <= 0) return;
			buf = new float[dataSize];
		}
		
		public void clear()
		{
			if(buf == null) return;
			for(int i = 0; i < buf.length; i++)
				buf[i] = 0;
		}
		
		public void copyTo(TypedDevice nativeDevice)
		{
			if(buf == null) return;
			nativeDevice.write(buf);
			FULL = false;
		}

		public boolean isEmpty()
		{
			return !FULL;
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected class IntTypedPortBuffer extends AbstractIntTypedBuffer
	{
		public IntTypedPortBuffer(int dataSize)
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
	protected class FloatTypedPortBuffer extends AbstractFloatTypedBuffer
	{
		public FloatTypedPortBuffer(int dataSize)
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
	
	/**
	 * @generated NOT
	 */
	protected class StringTypedBuffer extends AbstractTypedBuffer
	{
		protected String[] buf;
		protected boolean FULL;
		
		public StringTypedBuffer(int dataSize)
		{
			if(dataSize <= 0) return;
			buf = new String[dataSize];
		}
		
		public void clear()
		{
			if(buf == null) return;
			for(int i = 0; i < buf.length; i++)
				buf[i] = "";
		}
		
		public void write(String[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
				buf[i] = data[from + i];
			FULL = true;
		}
		
		public void write(String[] data, int index, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			if(index < 0 || index >= len) return;
			buf[index] = data[from + index];
			FULL = true;
		}
		
		public void copyTo(TypedDevice nativeDevice)
		{
			if(buf == null) return;
			nativeDevice.write(buf);
			FULL = false;
		}

		public boolean isEmpty()
		{
			return !FULL;
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected class ImageTypedBuffer extends AbstractTypedBuffer
	{
		protected ImageData[] buf;
		protected boolean FULL;
		
		public ImageTypedBuffer(int dataSize)
		{
			if(dataSize <= 0) return;
			buf = new ImageData[dataSize];
		}
		
		public void clear()
		{
			if(buf == null) return;
			for(int i = 0; i < buf.length; i++)
				buf[i] = null;
		}
		
		public void write(ImageData[] data, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			for(int i = 0; i < len; i++)
				buf[i] = data[from + i];
			FULL = true;
		}
		
		public void write(ImageData[] data, int index, int from)
		{
			if(buf == null || data == null) return;
			int len = Math.min(data.length - from, buf.length);
			if(index < 0 || index >= len) return;
			buf[index] = data[from + index];
			FULL = true;
		}
		
		public void copyTo(TypedDevice nativeDevice)
		{
			if(buf == null) return;
			nativeDevice.write(buf);
			FULL = false;
		}

		public boolean isEmpty()
		{
			return !FULL;
		}
	}
} //PortImpl
