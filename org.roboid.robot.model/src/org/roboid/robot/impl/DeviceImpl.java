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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.graphics.ImageData;
import org.roboid.robot.AccessType;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.DeviceListener;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#getDataSize <em>Data Size</em>}</li>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#getMax <em>Max</em>}</li>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#getMin <em>Min</em>}</li>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#isProxy <em>Proxy</em>}</li>
 *   <li>{@link org.roboid.robot.impl.DeviceImpl#getAccess <em>Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DeviceImpl extends NamedElementImpl implements Device
{
	/**
	 * The default value of the '{@link #getDataSize() <em>Data Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSize()
	 * @generated
	 * @ordered
	 */
	protected static final int DATA_SIZE_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getDataSize() <em>Data Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSize()
	 * @generated
	 * @ordered
	 */
	protected int dataSize = DATA_SIZE_EDEFAULT;
	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final DataType DATA_TYPE_EDEFAULT = DataType.BYTE;
	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType = DATA_TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_EDEFAULT = "0";
	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected String max = MAX_EDEFAULT;
	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_EDEFAULT = "0";
	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected String min = MIN_EDEFAULT;
	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;
	/**
	 * The default value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProxy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROXY_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProxy()
	 * @generated
	 * @ordered
	 */
	protected boolean proxy = PROXY_EDEFAULT;
	/**
	 * The default value of the '{@link #getAccess() <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected static final AccessType ACCESS_EDEFAULT = AccessType.PUBLIC;
	/**
	 * The cached value of the '{@link #getAccess() <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected AccessType access = ACCESS_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.DEVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDataSize()
	{
		return dataSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSize(int newDataSize)
	{
		int oldDataSize = dataSize;
		dataSize = newDataSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__DATA_SIZE, oldDataSize, dataSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType()
	{
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataType newDataType)
	{
		DataType oldDataType = dataType;
		dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProxy()
	{
		return proxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxy(boolean newProxy)
	{
		boolean oldProxy = proxy;
		proxy = newProxy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__PROXY, oldProxy, proxy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType getAccess()
	{
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccess(AccessType newAccess)
	{
		AccessType oldAccess = access;
		access = newAccess == null ? ACCESS_EDEFAULT : newAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RobotPackage.DEVICE__DATA_SIZE:
				setDataSize((Integer)newValue);
				return;
			case RobotPackage.DEVICE__DATA_TYPE:
				setDataType((DataType)newValue);
				return;
			case RobotPackage.DEVICE__MAX:
				setMax((String)newValue);
				return;
			case RobotPackage.DEVICE__MIN:
				setMin((String)newValue);
				return;
			case RobotPackage.DEVICE__DEFAULT:
				setDefault((String)newValue);
				return;
			case RobotPackage.DEVICE__PROXY:
				setProxy((Boolean)newValue);
				return;
			case RobotPackage.DEVICE__ACCESS:
				setAccess((AccessType)newValue);
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
			case RobotPackage.DEVICE__DATA_SIZE:
				setDataSize(DATA_SIZE_EDEFAULT);
				return;
			case RobotPackage.DEVICE__DATA_TYPE:
				setDataType(DATA_TYPE_EDEFAULT);
				return;
			case RobotPackage.DEVICE__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case RobotPackage.DEVICE__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case RobotPackage.DEVICE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case RobotPackage.DEVICE__PROXY:
				setProxy(PROXY_EDEFAULT);
				return;
			case RobotPackage.DEVICE__ACCESS:
				setAccess(ACCESS_EDEFAULT);
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
			case RobotPackage.DEVICE__DATA_SIZE:
				return dataSize != DATA_SIZE_EDEFAULT;
			case RobotPackage.DEVICE__DATA_TYPE:
				return dataType != DATA_TYPE_EDEFAULT;
			case RobotPackage.DEVICE__MAX:
				return MAX_EDEFAULT == null ? max != null : !MAX_EDEFAULT.equals(max);
			case RobotPackage.DEVICE__MIN:
				return MIN_EDEFAULT == null ? min != null : !MIN_EDEFAULT.equals(min);
			case RobotPackage.DEVICE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case RobotPackage.DEVICE__PROXY:
				return proxy != PROXY_EDEFAULT;
			case RobotPackage.DEVICE__ACCESS:
				return access != ACCESS_EDEFAULT;
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
		result.append(" (dataSize: ");
		result.append(dataSize);
		result.append(", dataType: ");
		result.append(dataType);
		result.append(", max: ");
		result.append(max);
		result.append(", min: ");
		result.append(min);
		result.append(", default: ");
		result.append(default_);
		result.append(", proxy: ");
		result.append(proxy);
		result.append(", access: ");
		result.append(access);
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
	protected List<DeviceListener> listeners;
	/**
	 * @generated NOT
	 */
	protected TypedDevice typedDevice;
	/**
	 * @generated NOT
	 */
	private boolean FIRED;
	/**
	 * @generated NOT
	 */
	private boolean EVENT;
	/**
	 * @generated NOT
	 */
	protected volatile boolean RECEIVE_FLAG;
	/**
	 * @generated NOT
	 */
	protected volatile boolean SEND_FLAG;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case RobotPackage.DEVICE__DATA_SIZE:
				return getDataSize();
			case RobotPackage.DEVICE__DATA_TYPE:
				return getDataType();
			case RobotPackage.DEVICE__MIN:
				return getMinString();
			case RobotPackage.DEVICE__MAX:
				return getMaxString();
			case RobotPackage.DEVICE__DEFAULT:
				return getDefaultString();
			case RobotPackage.DEVICE__PROXY:
				return isProxy();
		}
		return super.eGet(featureID, resolve, coreType);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMin(String newMin)
	{
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			try
			{
				Integer.parseInt(newMin);
			} catch (Exception e)
			{
				return;
			}
			break;
		case DataType.FLOAT_VALUE:
			try
			{
				Float.parseFloat(newMin);
			} catch (Exception e)
			{
				return;
			}
			break;
		case DataType.STRING_VALUE:
		case DataType.IMAGE_VALUE:
			return;
		}
		String oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__MIN, oldMin, min));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMax(String newMax)
	{
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			try
			{
				Integer.parseInt(newMax);
			} catch (Exception e)
			{
				return;
			}
			break;
		case DataType.FLOAT_VALUE:
			try
			{
				Float.parseFloat(newMax);
			} catch (Exception e)
			{
				return;
			}
			break;
		case DataType.STRING_VALUE:
		case DataType.IMAGE_VALUE:
			return;
		}
		String oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDefault(String newDefault)
	{
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			try
			{
				Integer.parseInt(newDefault);
			} catch (Exception e)
			{
				return;
			}
			break;
		case DataType.FLOAT_VALUE:
			try
			{
				Float.parseFloat(newDefault);
			} catch (Exception e)
			{
				return;
			}
			break;
		case DataType.STRING_VALUE:
			break;
		case DataType.IMAGE_VALUE:
			return;
		}
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.DEVICE__DEFAULT, oldDefault, default_));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void createDeviceMemory()
	{
		if(isProxy()) return;
		
		switch(getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
		{
			int minValue = 0, maxValue = 0, defaultValue = 0;
			try
			{
				minValue = Integer.parseInt(min);
			} catch (Exception e)
			{
			}
			try
			{
				maxValue = Integer.parseInt(max);
			} catch (Exception e)
			{
			}
			try
			{
				defaultValue = Integer.parseInt(default_);
			} catch (Exception e)
			{
			}
			typedDevice = new IntTypedDevice(getDataSize(), minValue, maxValue, defaultValue);
			break;
		}
		case DataType.FLOAT_VALUE:
		{
			float minValue = 0.0f, maxValue = 0.0f, defaultValue = 0.0f;
			try
			{
				minValue = Float.parseFloat(min);
			} catch (Exception e)
			{
			}
			try
			{
				maxValue = Float.parseFloat(max);
			} catch (Exception e)
			{
			}
			try
			{
				defaultValue = Float.parseFloat(default_);
			} catch (Exception e)
			{
			}
			typedDevice = new FloatTypedDevice(getDataSize(), minValue, maxValue, defaultValue);
			break;
		}
		case DataType.STRING_VALUE:
			typedDevice = new StringTypedDevice(getDataSize(), default_);
			break;
		case DataType.IMAGE_VALUE:
			typedDevice = new ImageTypedDevice(getDataSize(), null);
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void clearDeviceMemory()
	{
		EVENT = false;
		FIRED = false;
		if(typedDevice != null) typedDevice.clear();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized List<DeviceListener> getDeviceListeners()
	{
		if(listeners == null)
			listeners = new ArrayList<DeviceListener>();
		return listeners;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMin()
	{
		if(typedDevice != null)
			return typedDevice.getMin();
		
		int value = 0;
		try
		{
			value = Integer.parseInt(min);
		} catch (Exception e)
		{
		}
		return value;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float getMinFloat()
	{
		if(typedDevice != null)
			return typedDevice.getMinFloat();
		
		float value = 0.0f;
		try
		{
			value = Float.parseFloat(min);
		} catch (Exception e)
		{
		}
		return value;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMinString()
	{
		return min;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMax()
	{
		if(typedDevice != null)
			return typedDevice.getMax();
		
		int value = 0;
		try
		{
			value = Integer.parseInt(max);
		} catch (Exception e)
		{
		}
		return value;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float getMaxFloat()
	{
		if(typedDevice != null)
			return typedDevice.getMaxFloat();
		
		float value = 0.0f;
		try
		{
			value = Float.parseFloat(max);
		} catch (Exception e)
		{
		}
		return value;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMaxString()
	{
		return max;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDefault()
	{
		if(typedDevice != null)
			return typedDevice.getDefault();

		int value = 0;
		try
		{
			value = Integer.parseInt(default_);
		} catch (Exception e)
		{
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float getDefaultFloat()
	{
		if(typedDevice != null)
			return typedDevice.getDefaultFloat();

		float value = 0.0f;
		try
		{
			value = Float.parseFloat(default_);
		} catch (Exception e)
		{
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDefaultString()
	{
		if(typedDevice != null)
			return typedDevice.getDefaultString();
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ImageData getDefaultImageData()
	{
		if(typedDevice != null)
			return typedDevice.getDefaultImageData();
		return null;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Roboid getRootRoboid()
	{
		NamedElement parent = getParent();
		while(parent instanceof Roboid)
		{
			if(parent.getParent() instanceof Robot)
				return (Roboid)parent;
			parent = parent.getParent();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDataTypeOf(Device device)
	{
		if(device == null) return false;
		
		switch(getDataType().getValue())
		{
			case DataType.BYTE_VALUE:
			case DataType.UNSIGNED_BYTE_VALUE:
			case DataType.SHORT_VALUE:
			case DataType.UNSIGNED_SHORT_VALUE:
			case DataType.INTEGER_VALUE:
			case DataType.FLOAT_VALUE:
			{
				DataType dataType = device.getDataType();
				if(dataType != DataType.BYTE && dataType != DataType.UNSIGNED_BYTE && dataType != DataType.SHORT && dataType != DataType.UNSIGNED_SHORT && dataType != DataType.INTEGER && dataType != DataType.FLOAT)
					return false;
				break;
			}
			case DataType.STRING_VALUE:
			{
				if(device.getDataType() != DataType.STRING)
					return false;
				break;
			}
			case DataType.IMAGE_VALUE:
			{
				if(device.getDataType() != DataType.IMAGE)
					return false;
				break;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void addDeviceListener(DeviceListener listener)
	{
		getDeviceListeners().add(listener);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void removeDeviceListener(DeviceListener listener)
	{
		getDeviceListeners().remove(listener);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void getSimulacrum(ByteArrayOutputStream deviceMap, ByteArrayOutputStream payload)
	{
		if(canSend())
			deviceMap.write(1);
		else
			deviceMap.write(0);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int setDeviceMap(int index, byte[] deviceMap, boolean isMaster)
	{
		setMap(index, deviceMap);
		return ++index;
	}
	
	/**
	 * @generated NOT
	 */
	private void setMap(int index, byte[] deviceMap)
	{
		int bytePos = index / 8;
		int bitPos = index % 8;
		int mask  = 0x80;
		mask >>>= bitPos;
		
		RECEIVE_FLAG = false;
		if((mask & deviceMap[bytePos]) != 0) RECEIVE_FLAG = true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canSend()
	{
		return SEND_FLAG;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean e()
	{
		return EVENT;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEvent()
	{
		EVENT = FIRED;
		FIRED = false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFired()
	{
		FIRED = true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write()
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(int data)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(int index, int data)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(int[] data)
	{
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(float data)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(int index, float data)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(float[] data)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(String text)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(int index, String text)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(String[] text)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(ImageData imageData)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(int index, ImageData imageData)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean write(ImageData[] imageData)
	{
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean writeInt(int data)
	{
		return write(data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean writeInt(int index, int data)
	{
		return write(index, data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean writeInt(int[] data)
	{
		return write(data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeFloat(float data)
	{
		return write(data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeFloat(int index, float data)
	{
		return write(index, data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeFloat(float[] data)
	{
		return write(data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeString(String text)
	{
		return write(text);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeString(int index, String text)
	{
		return write(index, text);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeString(String[] text)
	{
		return write(text);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeImageData(ImageData imageData)
	{
		return write(imageData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeImageData(int index, ImageData imageData)
	{
		return write(index, imageData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean writeImageData(ImageData[] imageData)
	{
		return write(imageData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized int read()
	{
		if(typedDevice != null)
			return typedDevice.read();
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized int read(int index)
	{
		if(typedDevice != null)
			return typedDevice.read(index);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized int read(int[] data)
	{
		if(typedDevice != null)
			return typedDevice.read(data);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int read(float[] data)
	{
		if(typedDevice != null)
			return typedDevice.readFloat(data);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int read(String[] data)
	{
		if(typedDevice != null)
			return typedDevice.readString(data);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int read(ImageData[] data)
	{
		if(typedDevice != null)
			return typedDevice.readImageData(data);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float readInt()
	{
		if(typedDevice != null)
			return typedDevice.read();
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float readInt(int index)
	{
		if(typedDevice != null)
			return typedDevice.read(index);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int readInt(int[] data)
	{
		if(typedDevice != null)
			return typedDevice.read(data);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized float readFloat()
	{
		if(typedDevice != null)
			return typedDevice.readFloat();
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized float readFloat(int index)
	{
		if(typedDevice != null)
			return typedDevice.readFloat(index);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized int readFloat(float[] data)
	{
		if(typedDevice != null)
			return typedDevice.readFloat(data);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized String readString()
	{
		if(typedDevice != null)
			return typedDevice.readString();
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized String readString(int index)
	{
		if(typedDevice != null)
			return typedDevice.readString(index);
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized int readString(String[] text)
	{
		if(typedDevice != null)
			return typedDevice.readString(text);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized ImageData readImageData()
	{
		if(typedDevice != null)
			return typedDevice.readImageData();
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized ImageData readImageData(int index)
	{
		if(typedDevice != null)
			return typedDevice.readImageData(index);
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized int readImageData(ImageData[] imageData)
	{
		if(typedDevice != null)
			return typedDevice.readImageData(imageData);
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void setPayload(ByteArrayInputStream simulacrum, boolean isMaster)
	{
	}
	
	/**
	 * @generated NOT
	 */
	public void readPayload(ByteArrayInputStream payload, boolean skip)
	{
	}
	
	/**
	 * @generated NOT
	 */
	public void writePayload(ByteArrayOutputStream payload)
	{
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReceived()
	{
		return RECEIVE_FLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateDeviceState()
	{
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Device)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Device other = (Device)obj;
		if(getDataSize() != other.getDataSize()) return false;
		if(getDataType() != other.getDataType()) return false;
		if(getAccess() != other.getAccess()) return false;
		if(getMinString() == null)
		{
			if(other.getMinString() != null) return false;
		}
		else if(!getMinString().equalsIgnoreCase(other.getMinString())) return false;
		if(getMaxString() == null)
		{
			if(other.getMaxString() != null) return false;
		}
		else if(!getMaxString().equalsIgnoreCase(other.getMaxString())) return false;
		if(getDefaultString() == null)
		{
			if(other.getDefaultString() != null) return false;
		}
		else if(!getDefaultString().equalsIgnoreCase(other.getDefaultString())) return false;
		if(isProxy() != other.isProxy()) return false;
		
		return true;
	}
	
	boolean equalsProxyContents(Device proxy1, Device proxy2)
	{
		if(proxy1 == proxy2) return true;
		
		if(proxy1 == null)
		{
			if(proxy2 != null) return false;
		}
		else
		{
			Roboid parent1 = (Roboid)proxy1.getParent();
			Roboid parent2 = (Roboid)proxy2.getParent();
			if(parent1.getDevices().indexOf(proxy1) != parent2.getDevices().indexOf(proxy2)) return false;
			if(!((RoboidImpl)parent1).equalsFullUid(parent2)) return false;
		}
		
		return true;
	}
	
	/**
	 * @generated NOT
	 */
	protected interface TypedDevice
	{
		public int getMin();
		public float getMinFloat();
		public int getMax();
		public float getMaxFloat();
		public int getDefault();
		public float getDefaultFloat();
		public String getDefaultString();
		public ImageData getDefaultImageData();
		public int read();
		public int read(int index);
		public int read(int[] data);
		public float readFloat();
		public float readFloat(int index);
		public int readFloat(float[] data);
		public String readString();
		public String readString(int index);
		public int readString(String[] data);
		public ImageData readImageData();
		public ImageData readImageData(int index);
		public int readImageData(ImageData[] data);
		public boolean write();
		public boolean write(int data);
		public boolean write(int index, int data);
		public boolean write(int[] data);
		public boolean write(float data);
		public boolean write(int index, float data);
		public boolean write(float[] data);
		public boolean write(String data);
		public boolean write(int index, String data);
		public boolean write(String[] data);
		public boolean write(ImageData data);
		public boolean write(int index, ImageData data);
		public boolean write(ImageData[] data);
		public void clear();
	}

	/**
	 * @generated NOT
	 */
	private abstract class AbstractTypedDevice implements TypedDevice
	{
		public int getMin()
		{
			return 0;
		}
		
		public float getMinFloat()
		{
			return 0;
		}
		
		public int getMax()
		{
			return 0;
		}
		
		public float getMaxFloat()
		{
			return 0;
		}
		
		public int getDefault()
		{
			return 0;
		}
		
		public float getDefaultFloat()
		{
			return 0;
		}
		
		public String getDefaultString()
		{
			return null;
		}
		
		public ImageData getDefaultImageData()
		{
			return null;
		}
		
		public int read()
		{
			return 0;
		}
		
		public int read(int index)
		{
			return 0;
		}
		
		public int read(int[] data)
		{
			return 0;
		}
		
		public float readFloat()
		{
			return 0;
		}
		
		public float readFloat(int index)
		{
			return 0;
		}
		
		public int readFloat(float[] data)
		{
			return 0;
		}
		
		public String readString()
		{
			return null;
		}
		
		public String readString(int index)
		{
			return null;
		}
		
		public int readString(String[] data)
		{
			return 0;
		}
		
		public ImageData readImageData()
		{
			return null;
		}
		
		public ImageData readImageData(int index)
		{
			return null;
		}
		
		public int readImageData(ImageData[] data)
		{
			return 0;
		}
		
		public boolean write()
		{
			return true;
		}
		
		public boolean write(int data)
		{
			return false;
		}
		
		public boolean write(int index, int data)
		{
			return false;
		}
		
		public boolean write(int[] data)
		{
			return false;
		}
		
		public boolean write(float data)
		{
			return false;
		}
		
		public boolean write(int index, float data)
		{
			return false;
		}
		
		public boolean write(float[] data)
		{
			return false;
		}
		
		public boolean write(String data)
		{
			return false;
		}
		
		public boolean write(int index, String data)
		{
			return false;
		}
		
		public boolean write(String[] data)
		{
			return false;
		}
		
		public boolean write(ImageData data)
		{
			return false;
		}
		
		public boolean write(int index, ImageData data)
		{
			return false;
		}
		
		public boolean write(ImageData[] data)
		{
			return false;
		}
		
		public abstract void clear();
	}
	
	/**
	 * @generated NOT
	 */
	private class IntTypedDevice extends AbstractTypedDevice
	{
		private int[] data;
		private int minValue, maxValue;
		private int defaultValue;
		
		public IntTypedDevice(int dataSize, int minValue, int maxValue, int defaultValue)
		{
			this.minValue = minValue;
			this.maxValue = maxValue;
			this.defaultValue = defaultValue;
			if(dataSize <= 0) return;
			
			data = new int[dataSize];
			for(int i = 0; i < dataSize; i ++)
				data[i] = this.defaultValue;
		}

		public int getMin()
		{
			return minValue;
		}
		
		public float getMinFloat()
		{
			return minValue;
		}
		
		public int getMax()
		{
			return maxValue;
		}
		
		public float getMaxFloat()
		{
			return maxValue;
		}
		
		public int getDefault()
		{
			return defaultValue;
		}
		
		public float getDefaultFloat()
		{
			return defaultValue;
		}
		
		public String getDefaultString()
		{
			return String.valueOf(defaultValue);
		}
		
		public int read()
		{
			if(data == null || data.length <= 0) return 0;
			return data[0];
		}
		
		public int read(int index)
		{
			if(data == null || data.length <= index) return 0;
			return data[index];
		}
		
		public int read(int[] data)
		{
			if(this.data == null || data == null) return 0;
			int len = Math.min(this.data.length, data.length);
			
			System.arraycopy(this.data, 0, data, 0, len);
			for(int i = len; i < data.length; i ++)
				data[i] = 0;
			return len;
		}
		
		public float readFloat()
		{
			return read();
		}
		
		public float readFloat(int index)
		{
			return read(index);
		}
		
		public int readFloat(float[] data)
		{
			if(this.data == null || data == null) return 0;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
				data[i] = this.data[i];
			for(int i = len; i < data.length; i ++)
				data[i] = 0;
			return len;
		}
		
		public boolean write(int data)
		{
			if(this.data == null || this.data.length <= 0) return false;
			this.data[0] = data;
			if(this.data[0] < getMin()) this.data[0] = getMin();
			else if(this.data[0] > getMax()) this.data[0] = getMax();
			return true;
		}
		
		public boolean write(int index, int data)
		{
			if(this.data == null || this.data.length <= index) return false;
			this.data[index] = data;
			if(this.data[index] < getMin()) this.data[index] = getMin();
			else if(this.data[index] > getMax()) this.data[index] = getMax();
			return true;
		}
		
		public boolean write(int[] data)
		{
			if(this.data == null || data == null) return false;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
			{
				this.data[i] = data[i];
				if(this.data[i] < getMin()) this.data[i] = getMin();
				else if(this.data[i] > getMax()) this.data[i] = getMax();
			}
			for(int i = len; i < this.data.length; i ++)
				this.data[i] = 0;
			return true;
		}
		
		public boolean write(float data)
		{
			return write((int)data);
		}
		
		public boolean write(int index, float data)
		{
			return write(index, (int)data);
		}
		
		public boolean write(float[] data)
		{
			if(this.data == null || data == null) return false;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
			{
				this.data[i] = (int)data[i];
				if(this.data[i] < getMin()) this.data[i] = getMin();
				else if(this.data[i] > getMax()) this.data[i] = getMax();
			}
			for(int i = len; i < this.data.length; i ++)
				this.data[i] = 0;
			return true;
		}
		
		public void clear()
		{
			if(data == null) return;
			for(int i = 0; i < data.length; i ++)
				data[i] = defaultValue;
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class FloatTypedDevice extends AbstractTypedDevice
	{
		private float[] data;
		private float minValue, maxValue;
		private float defaultValue;
		
		public FloatTypedDevice(int dataSize, float minValue, float maxValue, float defaultValue)
		{
			this.minValue = minValue;
			this.maxValue = maxValue;
			this.defaultValue = defaultValue;
			if(dataSize <= 0) return;
			
			data = new float[dataSize];
			for(int i = 0; i < dataSize; i ++)
				data[i] = this.defaultValue;
		}
		
		public int getMin()
		{
			return (int)minValue;
		}
		
		public float getMinFloat()
		{
			return minValue;
		}
		
		public int getMax()
		{
			return (int)maxValue;
		}
		
		public float getMaxFloat()
		{
			return maxValue;
		}
		
		public int getDefault()
		{
			return (int)defaultValue;
		}
		
		public float getDefaultFloat()
		{
			return defaultValue;
		}
		
		public String getDefaultString()
		{
			return String.valueOf(defaultValue);
		}
		
		public int read()
		{
			return (int)readFloat();
		}
		
		public int read(int index)
		{
			return (int)readFloat(index);
		}
		
		public int read(int[] data)
		{
			if(this.data == null || data == null) return 0;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
				data[i] = (int)this.data[i];
			for(int i = len; i < data.length; i ++)
				data[i] = 0;
			return len;
		}
		
		public float readFloat()
		{
			if(data == null || data.length <= 0) return 0;
			return data[0];
		}
		
		public float readFloat(int index)
		{
			if(data == null || data.length <= index) return 0;
			return data[index];
		}
		
		public int readFloat(float[] data)
		{
			if(this.data == null || data == null) return 0;
			int len = Math.min(this.data.length, data.length);
			
			System.arraycopy(this.data, 0, data, 0, len);
			for(int i = len; i < data.length; i ++)
				data[i] = 0;
			return len;
		}
		
		public boolean write(int data)
		{
			return write((float)data);
		}
		
		public boolean write(int index, int data)
		{
			return write(index, (float)data);
		}
		
		public boolean write(int[] data)
		{
			if(this.data == null || data == null) return false;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
			{
				this.data[i] = data[i];
				if(this.data[i] < getMin()) this.data[i] = getMin();
				else if(this.data[i] > getMax()) this.data[i] = getMax();
			}
			for(int i = len; i < this.data.length; i ++)
				this.data[i] = 0;
			return true;
		}
		
		public boolean write(float data)
		{
			if(this.data == null || this.data.length <= 0) return false;
			this.data[0] = data;
			if(this.data[0] < getMin()) this.data[0] = getMin();
			else if(this.data[0] > getMax()) this.data[0] = getMax();
			return true;
		}
		
		public boolean write(int index, float data)
		{
			if(this.data == null || this.data.length <= index) return false;
			this.data[index] = data;
			if(this.data[index] < getMin()) this.data[index] = getMin();
			else if(this.data[index] > getMax()) this.data[index] = getMax();
			return true;
		}
		
		public boolean write(float[] data)
		{
			if(this.data == null || data == null) return false;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
			{
				this.data[i] = data[i];
				if(this.data[i] < getMin()) this.data[i] = getMin();
				else if(this.data[i] > getMax()) this.data[i] = getMax();
			}
			for(int i = len; i < this.data.length; i ++)
				this.data[i] = 0;
			return true;
		}
		
		public void clear()
		{
			if(data == null) return;
			for(int i = 0; i < data.length; i ++)
				data[i] = defaultValue;
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class StringTypedDevice extends AbstractTypedDevice
	{
		private String[] data;
		private String defaultValue;
		
		public StringTypedDevice(int dataSize, String defaultValue)
		{
			this.defaultValue = defaultValue;
			if(dataSize <= 0) return;
			
			data = new String[dataSize];
			for(int i = 0; i < dataSize; i ++)
				data[i] = defaultValue;
		}
		
		public String getDefaultString()
		{
			return defaultValue;
		}
		
		public String readString()
		{
			if(data == null || data.length <= 0) return "";
			return data[0];
		}
		
		public String readString(int index)
		{
			if(data == null || data.length <= index) return "";
			return data[index];
		}
		
		public int readString(String[] data)
		{
			if(this.data == null || data == null) return 0;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
				data[i] = this.data[i];
			for(int i = len; i < data.length; i ++)
				data[i] = "";
			return len;
		}
		
		public boolean write(String data)
		{
			if(this.data == null || this.data.length <= 0) return false;
			this.data[0] = data;
			return true;
		}
		
		public boolean write(int index, String data)
		{
			if(this.data == null || this.data.length <= index) return false;
			this.data[index] = data;
			return true;
		}
		
		public boolean write(String[] data)
		{
			if(this.data == null || data == null) return false;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
				this.data[i] = data[i];
			for(int i = len; i < this.data.length; i ++)
				this.data[i] = "";
			return true;
		}
		
		public void clear()
		{
			if(data == null) return;
			for(int i = 0; i < data.length; i ++)
				data[i] = defaultValue;
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class ImageTypedDevice extends AbstractTypedDevice
	{
		private ImageData[] data;
		private ImageData defaultValue;
		
		public ImageTypedDevice(int dataSize, ImageData defaultValue)
		{
			this.defaultValue = defaultValue;
			if(dataSize <= 0) return;
			
			data = new ImageData[dataSize];
			for(int i = 0; i < dataSize; i ++)
				data[i] = defaultValue;
		}
		
		public ImageData getDefaultImageData()
		{
			return defaultValue;
		}
		
		public ImageData readImageData()
		{
			if(data == null || data.length <= 0) return null;
			return data[0];
		}
		
		public ImageData readImageData(int index)
		{
			if(data == null || data.length <= index) return null;
			return data[index];
		}
		
		public int readImageData(ImageData[] data)
		{
			if(this.data == null || data == null) return 0;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
				data[i] = this.data[i];
			for(int i = len; i < data.length; i ++)
				data[i] = null;
			return len;
		}
		
		public boolean write(ImageData data)
		{
			if(this.data == null || this.data.length <= 0) return false;
			this.data[0] = data;
			return true;
		}
		
		public boolean write(int index, ImageData data)
		{
			if(this.data == null || this.data.length <= index) return false;
			this.data[index] = data;
			return true;
		}
		
		public boolean write(ImageData[] data)
		{
			if(this.data == null || data == null) return false;
			int len = Math.min(this.data.length, data.length);
			
			for(int i = 0; i < len; i ++)
				this.data[i] = data[i];
			for(int i = len; i < this.data.length; i ++)
				this.data[i] = null;
			return true;
		}
		
		public void clear()
		{
			if(data == null) return;
			for(int i = 0; i < data.length; i ++)
				data[i] = defaultValue;
		}
	}
} //DeviceImpl
