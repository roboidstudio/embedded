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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.graphics.ImageData;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.MotoringDevice;
import org.roboid.robot.Roboid;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.SensoryDevice;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sensory Device</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SensoryDeviceImpl extends DeviceImpl implements SensoryDevice
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SensoryDeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.SENSORY_DEVICE;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void addReceptor(Device receptor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void removeReceptor(Device receptor);
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write()
	{
		setFired();
		writeToReceptors();
		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int data)
	{
		if(typedDevice.write(data))
		{
			setFired();
			writeToReceptors(data);
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, int data)
	{
		if(typedDevice.write(index, data))
		{
			setFired();
			writeToReceptors(index, data);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int[] data)
	{
		if(typedDevice.write(data))
		{
			setFired();
			writeToReceptors(data);
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(float data)
	{
		if(typedDevice.write(data))
		{
			setFired();
			writeToReceptors(data);
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, float data)
	{
		if(typedDevice.write(index, data))
		{
			setFired();
			writeToReceptors(index, data);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(float[] data)
	{
		if(typedDevice.write(data))
		{
			setFired();
			writeToReceptors(data);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(String text)
	{
		if(typedDevice.write(text))
		{
			setFired();
			writeToReceptors(text);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, String text)
	{
		if(typedDevice.write(index, text))
		{
			setFired();
			writeToReceptors(index, text);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(String[] text)
	{
		if(typedDevice.write(text))
		{
			setFired();
			writeToReceptors(text);
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(ImageData imageData)
	{
		if(typedDevice.write(imageData))
		{
			setFired();
			writeToReceptors(imageData);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(int index, ImageData imageData)
	{
		if(typedDevice.write(index, imageData))
		{
			setFired();
			writeToReceptors(index, imageData);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public synchronized boolean write(ImageData[] imageData)
	{
		if(typedDevice.write(imageData))
		{
			setFired();
			writeToReceptors(imageData);
			return true;
		}
		return false;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public void updateDeviceState()
	{
		setEvent();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload)
	{
		if(canSend())
			deviceMap.write(1);
		else
			deviceMap.write(0);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
		if(isMaster) setMasterPayload(simulacrum, false);
		else setSlavePayload(simulacrum, false);
	}
	
	/**
	 * internal use
	 * @generated NOT
	 */
	synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster, boolean skip)
	{
		if(isMaster) setMasterPayload(simulacrum, skip);
		else setSlavePayload(simulacrum, skip);
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
			{
				typedDevice.write();
				writeToReceptors();
			}
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
					{
						typedDevice.write(intData);
						writeToReceptors(intData);
					}
					break;
				}
			case DataType.UNSIGNED_BYTE_VALUE:
				{
					if(intData.length != getDataSize())
						intData = new int[getDataSize()];
					for(int i = 0; i < getDataSize(); i ++)
						intData[i] = (int)(payload.read() & 0xff);
					if(!skip)
					{
						typedDevice.write(intData);
						writeToReceptors(intData);
					}
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
					{
						typedDevice.write(intData);
						writeToReceptors(intData);
					}
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
					{
						typedDevice.write(intData);
						writeToReceptors(intData);
					}
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
						if(!skip)
						{
							typedDevice.write(intData);
							writeToReceptors(intData);
						}
					}
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
					{
						typedDevice.write(floatData);
						writeToReceptors(floatData);
					}
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
					{
						typedDevice.write(stringData);
						writeToReceptors(stringData);
					}
					break;
				}
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	private void setMasterPayload(ByteArrayInputStream simulacrum, boolean skip)
	{
		if(isReceived())
		{
			if(isProxy())
			{
				Device target = getProxyFor();
				if(target != null) target.readPayload(simulacrum, skip);
			}
			else
				readPayload(simulacrum, skip);
			
			for(DeviceListener listener: getDeviceListeners())
				listener.stateChanged(this);
		}
	}

	/**
	 * @generated NOT
	 */
	private void setSlavePayload(ByteArrayInputStream simulacrum, boolean skip)
	{
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean canSend()
	{
		if(getDeviceListeners().size() == 0) SEND_FLAG = false;
		else SEND_FLAG = true;
		return SEND_FLAG;
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors()
	{
		for(MotoringDevice device : getReceptors())
			device.write();
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(int data)
	{
		for(MotoringDevice device : getReceptors())
			device.write(data);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(int index, int data)
	{
		for(MotoringDevice device : getReceptors())
			device.write(index, data);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(int[] data)
	{
		for(MotoringDevice device : getReceptors())
			device.write(data);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(float data)
	{
		for(MotoringDevice device : getReceptors())
			device.write(data);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(int index, float data)
	{
		for(MotoringDevice device : getReceptors())
			device.write(index, data);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(float[] data)
	{
		for(MotoringDevice device : getReceptors())
			device.write(data);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(String text)
	{
		for(MotoringDevice device : getReceptors())
			device.write(text);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(int index, String text)
	{
		for(MotoringDevice device : getReceptors())
			device.write(index, text);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(String[] text)
	{
		for(MotoringDevice device : getReceptors())
			device.write(text);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(ImageData imageData)
	{
		for(MotoringDevice device : getReceptors())
			device.write(imageData);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(int index, ImageData imageData)
	{
		for(MotoringDevice device : getReceptors())
			device.write(index, imageData);
	}
	
	/**
	 * @generated NOT
	 */
	void writeToReceptors(ImageData[] imageData)
	{
		for(MotoringDevice device : getReceptors())
			device.write(imageData);
	}
	
	/**
	 * @generated NOT
	 */
	<E> boolean equalsReceptorsContents(List<E> receptors1, List<E> receptors2)
	{
		if(receptors1 == receptors2) return true;
		if(receptors1.size() != receptors2.size()) return false;
		
		Iterator<E> it1 = receptors1.iterator();
		Iterator<E> it2 = receptors2.iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			Device dev1 = (Device)it1.next();
			Device dev2 = (Device)it2.next();
			if(dev1 == null)
			{
				if(dev2 != null) return false;
			}
			else if(dev1 != dev2)
			{
				Roboid parent1 = (Roboid)dev1.getParent();
				Roboid parent2 = (Roboid)dev2.getParent();
				if(parent1.getDevices().indexOf(dev1) != parent2.getDevices().indexOf(dev2)) return false;
				if(!((RoboidImpl)parent1).equalsFullUid(parent2)) return false;
			}
		}

		return true;
	}
} //SensoryDeviceImpl
