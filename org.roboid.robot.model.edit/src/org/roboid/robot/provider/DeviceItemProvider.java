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

package org.roboid.robot.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.Roboid;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.provider.NamedElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.roboid.robot.Device} object.
 * <!-- begin-user-doc -->
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class DeviceItemProvider
	extends NamedElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Data Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataSizePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Device_dataSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Device_dataSize_feature", "_UI_Device_type"),
				 RobotPackage.Literals.DEVICE__DATA_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Data Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataTypePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Device_dataType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Device_dataType_feature", "_UI_Device_type"),
				 RobotPackage.Literals.DEVICE__DATA_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Proxy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProxyPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Device_proxy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Device_proxy_feature", "_UI_Device_type"),
				 RobotPackage.Literals.DEVICE__PROXY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Access feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccessPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Device_access_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Device_access_feature", "_UI_Device_type"),
				 RobotPackage.Literals.DEVICE__ACCESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		String label = ((Device)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Device_type") :
			getString("_UI_Device_type") + " " + label;
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);
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
	private ItemPropertyDescriptor minPropertyDescriptor;
	/**
	 * @generated NOT
	 */
	private ItemPropertyDescriptor maxPropertyDescriptor;
	/**
	 * @generated NOT
	 */
	private ItemPropertyDescriptor defaultPropertyDescriptor;
	/**
	 * @generated NOT
	 */
	protected ItemPropertyDescriptor proxyForPropertyDescriptor;
	
	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		//if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addDataSizePropertyDescriptor(object);
			addDataTypePropertyDescriptor(object);
//			addMaxPropertyDescriptor(object);
//			addMinPropertyDescriptor(object);
//			addDefaultPropertyDescriptor(object);
			addProxyPropertyDescriptor(object);
			
			switch(((Device)object).getDataType().getValue())
			{
			case DataType.BYTE_VALUE:
			case DataType.UNSIGNED_BYTE_VALUE:
			case DataType.SHORT_VALUE:
			case DataType.UNSIGNED_SHORT_VALUE:
			case DataType.INTEGER_VALUE:
			case DataType.FLOAT_VALUE:
				addMinPropertyDescriptor(object);
				addMaxPropertyDescriptor(object);
			case DataType.STRING_VALUE:
				addDefaultPropertyDescriptor(object);
				break;
			}
		
			checkDefault((Device)object);
			if(((Device)object).isProxy())
				addProxyForPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * This adds a property descriptor for the Max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addMaxPropertyDescriptor(Object object)
	{
		if(maxPropertyDescriptor == null)
		{
			maxPropertyDescriptor = new ItemPropertyDescriptor
			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
					 getResourceLocator(),
					 getString("_UI_Device_max_feature"),
					 getString("_UI_PropertyDescriptor_description", "_UI_Device_max_feature", "_UI_Device_type"),
					 RobotPackage.Literals.DEVICE__MAX,
					 true,
					 false,
					 false,
					 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
					 null,
					 null);
		}
		itemPropertyDescriptors.add(maxPropertyDescriptor);
	}
	
	/**
	 * @generated NOT
	 */
	private void removeMaxPropertyDescriptor()
	{
		itemPropertyDescriptors.remove(maxPropertyDescriptor);
	}

	/**
	 * This adds a property descriptor for the Min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addMinPropertyDescriptor(Object object)
	{
		if(minPropertyDescriptor == null)
		{
			minPropertyDescriptor = new ItemPropertyDescriptor
			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
					 getResourceLocator(),
					 getString("_UI_Device_min_feature"),
					 getString("_UI_PropertyDescriptor_description", "_UI_Device_min_feature", "_UI_Device_type"),
					 RobotPackage.Literals.DEVICE__MIN,
					 true,
					 false,
					 false,
					 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
					 null,
					 null);
		}
		itemPropertyDescriptors.add(minPropertyDescriptor);
	}
	
	/**
	 * @generated NOT
	 */
	private void removeMinPropertyDescriptor()
	{
		itemPropertyDescriptors.remove(minPropertyDescriptor);
	}
	
	/**
	 * This adds a property descriptor for the Default feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDefaultPropertyDescriptor(Object object)
	{
		if(defaultPropertyDescriptor == null)
		{
			defaultPropertyDescriptor = new ItemPropertyDescriptor
			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
					 getResourceLocator(),
					 getString("_UI_Device_default_feature"),
					 getString("_UI_PropertyDescriptor_description", "_UI_Device_default_feature", "_UI_Device_type"),
					 RobotPackage.Literals.DEVICE__DEFAULT,
					 true,
					 false,
					 false,
					 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
					 null,
					 null);
		}
		itemPropertyDescriptors.add(defaultPropertyDescriptor);
	}
	
	/**
	 * @generated NOT
	 */
	private void removeDefaultPropertyDescriptor()
	{
		itemPropertyDescriptors.remove(defaultPropertyDescriptor);
	}
	
	/**
	 * @generated NOT
	 */
	protected void addProxyForPropertyDescriptor(Object object)
	{
	}
	
	/**
	 * @generated NOT
	 */
	protected Collection<?> filterProxyFor(Object object, Collection<EObject> candidates)
	{
		List<Device> result = new ArrayList<Device>();
		result.add(null);
		
		Device device = (Device)object;
		for(EObject o : candidates)
		{
			if(object == o) continue;
			Device client = (Device)o;
			if(client.isProxy()) continue;
			
			switch(client.getDataType().getValue())
			{
			case DataType.BYTE_VALUE:
			case DataType.UNSIGNED_BYTE_VALUE:
			case DataType.SHORT_VALUE:
			case DataType.UNSIGNED_SHORT_VALUE:
			case DataType.INTEGER_VALUE:
			case DataType.FLOAT_VALUE:
				{
					switch(device.getDataType().getValue())
					{
					case DataType.BYTE_VALUE:
					case DataType.UNSIGNED_BYTE_VALUE:
					case DataType.SHORT_VALUE:
					case DataType.UNSIGNED_SHORT_VALUE:
					case DataType.INTEGER_VALUE:
					case DataType.FLOAT_VALUE:
						result.add(client);
					}
				}
				break;
			case DataType.STRING_VALUE:
				if(device.getDataType() == DataType.STRING)
					result.add(client);
				break;
			case DataType.IMAGE_VALUE:
				if(device.getDataType() == DataType.IMAGE)
					result.add(client);
				break;
			}
		}
		return result;
	}
	
	/**
	 * @generated NOT
	 */
	protected void removeProxyForPropertyDescriptor()
	{
		itemPropertyDescriptors.remove(proxyForPropertyDescriptor);
	}
	
	/**
	 * @generated NOT
	 */
	protected String getText(Object object, String key)
	{
		String label = ((Device)object).getName();
		String prefix = getPrefix(object, "");
		
		return label == null || label.length() == 0 ?
			getString(key) : ((Device)object).isProxy() ?
			getString(key) + "  " + prefix + label + getProxyText(object):
			getString(key) + "  " + prefix + label;
	}
	
	/**
	 * @generated NOT
	 */
	protected String getPrefix(Object object, String prefix)
	{
		EObject container = ((EObject)object).eContainer();
		if(container instanceof Roboid) 
		{
			
			return getPrefix(container, prefix);
		}
		else
			return prefix;
	}
	
	/**
	 * @generated NOT
	 */
	private String getProxyText(Object object)
	{
		Device proxy = ((Device)object).getProxyFor();
		if(proxy == null) return " - ?";
		
		return " - " + getPrefix(proxy, "") + proxy.getName();
	}
	
	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(Device.class))
		{
			case RobotPackage.NAMED_ELEMENT__NAME:
				checkName(notification);
				fireNotifyChanged(new ViewerNotification(notification, null, false, true));
				return;
			case RobotPackage.DEVICE__PROXY:
				checkProxy(notification);
			case RobotPackage.DEVICE__DATA_SIZE:
			case RobotPackage.DEVICE__MAX:
			case RobotPackage.DEVICE__MIN:
			case RobotPackage.DEVICE__DEFAULT:
			case RobotPackage.SENSOR__PROXY_FOR:
//			case RobotPackage.EFFECTOR__PROXY_FOR:
//			case RobotPackage.COMMAND__PROXY_FOR:
//			case RobotPackage.EVENT__PROXY_FOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RobotPackage.DEVICE__DATA_TYPE:
				checkDataType(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * @generated NOT
	 */
	private void checkDefault(Device device)
	{
		switch(device.getDataType().getValue())
		{
		case DataType.BYTE_VALUE:
		case DataType.UNSIGNED_BYTE_VALUE:
		case DataType.SHORT_VALUE:
		case DataType.UNSIGNED_SHORT_VALUE:
		case DataType.INTEGER_VALUE:
			try
			{
				Integer.parseInt(device.getDefaultString());
			} catch (Exception e)
			{
				try
				{
					float value = Float.parseFloat(device.getDefaultString());
					device.setDefault(String.valueOf((int)value));
				} catch (Exception e2)
				{
					device.setDefault("0");
				}
			}
			break;
		case DataType.FLOAT_VALUE:
			try
			{
				Float.parseFloat(device.getDefaultString());
			} catch (Exception e)
			{
				device.setDefault("0");
			}
			break;
		}
	}
	
	/**
	 * @generated NOT
	 */
	private void checkDataType(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			if(itemPropertyDescriptors == null) return;
			
			Device device = (Device)notification.getNotifier();
			checkDefault(device);
			
			switch(device.getDataType().getValue())
			{
			case DataType.BYTE_VALUE:
			case DataType.UNSIGNED_BYTE_VALUE:
			case DataType.SHORT_VALUE:
			case DataType.UNSIGNED_SHORT_VALUE:
			case DataType.INTEGER_VALUE:
				addMinPropertyDescriptor(device);
				addMaxPropertyDescriptor(device);
				addDefaultPropertyDescriptor(device);
				break;
			case DataType.FLOAT_VALUE:
				addMinPropertyDescriptor(device);
				addMaxPropertyDescriptor(device);
				addDefaultPropertyDescriptor(device);
				break;
			case DataType.STRING_VALUE:
				device.setDefault(null);
				removeMinPropertyDescriptor();
				removeMaxPropertyDescriptor();
				addDefaultPropertyDescriptor(device);
				break;
			case DataType.IMAGE_VALUE:
				removeMinPropertyDescriptor();
				removeMaxPropertyDescriptor();
				removeDefaultPropertyDescriptor();
				break;
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected void checkProxy(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			if(itemPropertyDescriptors == null) return;
			
			Device device = (Device)notification.getNotifier();
			if(device.isProxy())
				addProxyForPropertyDescriptor(device);
			else
				removeProxyForPropertyDescriptor();
		}
	}
	
	/**
	 * @generated NOT
	 */
	private void checkName(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			Device device = (Device)notification.getNotifier();
			String newName = (String)notification.getNewValue();
			Roboid parent = (Roboid)((EObject)device).eContainer();
			setUniqueName(device, newName, parent.getDevices());
		}
	}
}
