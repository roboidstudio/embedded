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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.MotoringDevice;
import org.roboid.robot.SensoryDevice;

/**
 * This is the item provider adapter for a {@link org.roboid.robot.SensoryDevice} object.
 * <!-- begin-user-doc -->
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class SensoryDeviceItemProvider
	extends DeviceItemProvider
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
	public SensoryDeviceItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
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
		String label = ((SensoryDevice)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SensoryDevice_type") :
			getString("_UI_SensoryDevice_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);
		super.notifyChanged(notification);
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
	protected ItemPropertyDescriptor receptorsPropertyDescriptor;

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		super.getPropertyDescriptors(object);
		
		if(!((Device)object).isProxy())
			addReceptorsPropertyDescriptor(object);

		return itemPropertyDescriptors;
	}
	
	/**
	 * @generated NOT
	 */
	protected void addReceptorsPropertyDescriptor(Object object)
	{
	}
	
	/**
	 * @generated NOT
	 */
	protected void removeReceptorsPropertyDescriptor()
	{
		itemPropertyDescriptors.remove(receptorsPropertyDescriptor);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	protected void checkProxy(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			if(itemPropertyDescriptors == null) return;
			
			Device device = (Device)notification.getNotifier();
			if(device.isProxy())
			{
				addProxyForPropertyDescriptor(device);
				removeReceptorsPropertyDescriptor();
			}
			else
			{
				addReceptorsPropertyDescriptor(device);
				removeProxyForPropertyDescriptor();
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	protected String getReceptorText(Object object)
	{
		if(object instanceof SensoryDevice)
		{
			List<? extends MotoringDevice> receptors = ((SensoryDevice)object).getReceptors();
			if(receptors.size() == 0) return "";
			StringBuilder sb = new StringBuilder(" -> ");
			sb.append(getPrefix(receptors.get(0), ""));
			sb.append(receptors.get(0).getName());
			for(int i = 1; i < receptors.size(); i ++)
			{
				sb.append(", ");
				sb.append(getPrefix(receptors.get(i), ""));
				sb.append(receptors.get(i).getName());
			}
			return sb.toString();
		}
		return "";
	}
	
	/**
	 * @generated NOT
	 */
	protected Collection<?> filterReceptors(Object object, Collection<EObject> candidates)
	{
		List<MotoringDevice> result = new ArrayList<MotoringDevice>();
		
		if(!(object instanceof SensoryDevice))
			return result;
		
		SensoryDevice device = (SensoryDevice)object;
		for(EObject o : candidates)
		{
			if(o instanceof MotoringDevice)
			{
				MotoringDevice receptor = (MotoringDevice)o;
				
				switch(receptor.getDataType().getValue())
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
							result.add(receptor);
						}
					}
					break;
				case DataType.STRING_VALUE:
					if(device.getDataType() == DataType.STRING)
						result.add(receptor);
					break;
				case DataType.IMAGE_VALUE:
					if(device.getDataType() == DataType.IMAGE)
						result.add(receptor);
					break;
				}
			}
		}
		return result;
	}
}
