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

package org.roboid.studio.robotcomposer.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.roboid.robot.Control;
import org.roboid.robot.Device;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.SensoryDevice;

/**
 * This is the item provider adapter for a {@link org.roboid.robot.Robot} object.
 * <!-- begin-user-doc -->
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class RobotItemProvider
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
	public RobotItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addProviderPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addStandardPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Robot_provider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Robot_provider_feature", "_UI_Robot_type"),
				 RobotPackage.Literals.ROBOT__PROVIDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Robot_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Robot_version_feature", "_UI_Robot_type"),
				 RobotPackage.Literals.ROBOT__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Standard feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStandardPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Robot_standard_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Robot_standard_feature", "_UI_Robot_type"),
				 RobotPackage.Literals.ROBOT__STANDARD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(RobotPackage.Literals.ROBOT__ROBOIDS);
			childrenFeatures.add(RobotPackage.Literals.ROBOT__CONTROLS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Robot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Robot"));
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
		String label = ((Robot)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Robot_type") :
			getString("_UI_Robot_type") + " " + label;
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

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOT__ROBOIDS,
				 RobotFactory.eINSTANCE.createRoboid()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOT__CONTROLS,
				 RobotFactory.eINSTANCE.createControl()));
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
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

		switch (notification.getFeatureID(Robot.class))
		{
			case RobotPackage.ROBOT__PROVIDER:
			case RobotPackage.ROBOT__VERSION:
			case RobotPackage.ROBOT__STANDARD:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RobotPackage.ROBOT__ROBOIDS:
				checkRoboid(notification);
				fireNotifyChanged(new ViewerNotification(notification, null, true, false));
				return;
			case RobotPackage.ROBOT__CONTROLS:
				checkControl(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}
	
	private void checkRoboid(Notification notification)
	{
		switch(notification.getEventType())
		{
		case Notification.ADD:
			{
				Robot parent = (Robot)notification.getNotifier();
				Roboid newRoboid = (Roboid)notification.getNewValue();
				
				setUniqueName(newRoboid, null, parent.getRoboids());
				newRoboid.setLiteral(newRoboid.getName());
				
				for(NamedElement child : newRoboid.getChildren())
					child.setLiteral(child.getName());
				
				refreshRoboidUid(parent, newRoboid);
				break;
			}
		case Notification.ADD_MANY:
			{
				Robot parent = (Robot)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Roboid> newRoboids = (List<Roboid>)notification.getNewValue();
				
				for(Roboid newRoboid : newRoboids)
				{
					setUniqueName(newRoboid, null, parent.getRoboids());
					newRoboid.setLiteral(newRoboid.getName());
					
					for(NamedElement child : newRoboid.getChildren())
						child.setLiteral(child.getName());
				}
				refreshRoboidUid(parent, newRoboids);
				break;
			}
		case Notification.REMOVE:
			{
				Robot parent = (Robot)notification.getNotifier();
				Roboid oldRoboid = (Roboid)notification.getOldValue();
				refreshRoboidUid(parent, oldRoboid);
				break;
			}
		case Notification.REMOVE_MANY:
			{
				Robot parent = (Robot)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Roboid> oldRoboids = (List<Roboid>)notification.getOldValue();
				refreshRoboidUid(parent, oldRoboids);
				break;
			}
		case Notification.MOVE:
			{
				Robot parent = (Robot)notification.getNotifier();
				Roboid newRoboid = (Roboid)notification.getNewValue();
				refreshRoboidUid(parent, newRoboid);
				break;
			}
		}
	}
	
	private void checkControl(Notification notification)
	{
		switch(notification.getEventType())
		{
		case Notification.ADD:
			{
				Robot parent = (Robot)notification.getNotifier();
				Control newControl = (Control)notification.getNewValue();
				
				setUniqueName(newControl, null, parent.getControls());
				newControl.setLiteral(newControl.getName());
				
				for(NamedElement child : newControl.getChildren())
					child.setLiteral(child.getName());
				break;
			}
		case Notification.ADD_MANY:
			{
				Robot parent = (Robot)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Control> newControls = (List<Control>)notification.getNewValue();
				
				for(Control newControl : newControls)
				{
					setUniqueName(newControl, null, parent.getControls());
					newControl.setLiteral(newControl.getName());
					
					for(NamedElement child : newControl.getChildren())
						child.setLiteral(child.getName());
				}
				break;
			}
//		case Notification.REMOVE:
//			{
//				Robot parent = (Robot)notification.getNotifier();
//				Control oldControl = (Control)notification.getOldValue();
//				break;
//			}
//		case Notification.REMOVE_MANY:
//			{
//				Robot parent = (Robot)notification.getNotifier();
//				@SuppressWarnings("unchecked")
//				List<Control> oldControls = (List<Control>)notification.getOldValue();
//				break;
//			}
//		case Notification.MOVE:
//			{
//				Robot parent = (Robot)notification.getNotifier();
//				Control newControl = (Control)notification.getNewValue();
//				break;
//			}
		}
	}
	
	private void refreshRoboidUid(Robot parent, Roboid ref)
	{
		if(parent == null || ref == null) return;
		
		String id = ref.getId();
		if(id == null || id.isEmpty()) return;
		
		List<Roboid> children = new ArrayList<Roboid>();
		collectRoboidsById(children, parent, id);
		
		int index = 0;
		String prefix = id + ".";
		for(Roboid child : children)
			child.setUid(prefix + index++);
	}

	private List<Roboid> collectRoboidsById(List<Roboid> roboids, Robot parent, String id)
	{
		for(Roboid child : parent.getRoboids())
		{
			if(id.equalsIgnoreCase(child.getId()))
				roboids.add(child);
		}
		return roboids;
	}
	
	private void refreshRoboidUid(Robot parent, List<Roboid> refs)
	{
		if(parent == null || refs == null) return;
		
		for(Roboid ref : refs)
			refreshRoboidUid(parent, ref);
	}
	
	@Override
	public Object getIcon(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Robot.png"));
	}

	@Override
	protected org.eclipse.emf.common.command.Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection, int index)
	{
		for(Object o : collection)
		{
			if(o instanceof Roboid)
				clearReferences((Roboid)o);
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}
	
	private void clearReferences(Roboid roboid)
	{
		if(roboid == null) return;
		
		for(Device device : roboid.getDevices())
		{
			device.setProxyFor(null);
			if(device instanceof SensoryDevice)
				((SensoryDevice)device).getReceptors().clear();
		}
	}
}
