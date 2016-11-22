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
import org.eclipse.emf.edit.command.CopyCommand.Helper;
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
import org.roboid.robot.Device;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.robot.RobotPackage;

/**
 * This is the item provider adapter for a {@link org.roboid.robot.Roboid} object.
 * <!-- begin-user-doc -->
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class RoboidItemProvider
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
	public RoboidItemProvider(AdapterFactory adapterFactory)
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
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addIdPropertyDescriptor(object);
//			addUidPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addProviderPropertyDescriptor(object);
//			addHostRoboidPropertyDescriptor(object);
			addAddressPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addIdPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Roboid_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Roboid_id_feature", "_UI_Roboid_type"),
				 RobotPackage.Literals.ROBOID__ID,
				 false,
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
	 * @generated NOT
	 */
	protected void addVersionPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Roboid_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Roboid_version_feature", "_UI_Roboid_type"),
				 RobotPackage.Literals.ROBOID__VERSION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addProviderPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Roboid_provider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Roboid_provider_feature", "_UI_Roboid_type"),
				 RobotPackage.Literals.ROBOID__PROVIDER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAddressPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Roboid_address_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Roboid_address_feature", "_UI_Roboid_type"),
				 RobotPackage.Literals.ROBOID__ADDRESS,
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
			childrenFeatures.add(RobotPackage.Literals.ROBOID__ROBOIDS);
			childrenFeatures.add(RobotPackage.Literals.ROBOID__PROTOCOL);
			childrenFeatures.add(RobotPackage.Literals.ROBOID__DEVICES);
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
	 * This returns Roboid.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Roboid"));
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
		String label = ((Roboid)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Roboid_type") :
			getString("_UI_Roboid_type") + " " + label;
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
				(RobotPackage.Literals.ROBOID__ROBOIDS,
				 RobotFactory.eINSTANCE.createRoboid()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOID__PROTOCOL,
				 RobotFactory.eINSTANCE.createProtocol()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOID__DEVICES,
				 RobotFactory.eINSTANCE.createSensor()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOID__DEVICES,
				 RobotFactory.eINSTANCE.createEffector()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOID__DEVICES,
				 RobotFactory.eINSTANCE.createCommand()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.ROBOID__DEVICES,
				 RobotFactory.eINSTANCE.createEvent()));
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * This adds a property descriptor for the Uid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addUidPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Roboid_uid_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Roboid_uid_feature", "_UI_Roboid_type"),
				 RobotPackage.Literals.ROBOID__UID,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}
	
	/**
	 * This adds a property descriptor for the Host Roboid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addHostRoboidPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Roboid_hostRoboid_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Roboid_hostRoboid_feature", "_UI_Roboid_type"),
				 RobotPackage.Literals.ROBOID__HOST_ROBOID,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
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

		switch (notification.getFeatureID(Roboid.class))
		{
			case RobotPackage.NAMED_ELEMENT__NAME:
				checkName(notification);
				fireNotifyChanged(new ViewerNotification(notification, null, false, true));
				return;
			case RobotPackage.ROBOID__ID:
				checkId(notification);
			case RobotPackage.ROBOID__UID:
			case RobotPackage.ROBOID__VERSION:
			case RobotPackage.ROBOID__PROVIDER:
			case RobotPackage.ROBOID__ADDRESS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RobotPackage.ROBOID__ROBOIDS:
				checkRoboid(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case RobotPackage.ROBOID__PROTOCOL:
				checkProtocol(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			case RobotPackage.ROBOID__DEVICES:
				checkDevice(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}
	
	private void checkName(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			Roboid roboid = (Roboid)notification.getNotifier();
			String newName = (String)notification.getNewValue();
			EObject parent = ((EObject)roboid).eContainer();
			if(parent instanceof Robot)
				setUniqueName(roboid, newName, ((Robot)parent).getRoboids());
			else if(parent instanceof Roboid)
				setUniqueName(roboid, newName, ((Roboid)parent).getRoboids());
		}
	}
	
	private void checkRoboid(Notification notification)
	{
		switch(notification.getEventType())
		{
		case Notification.ADD:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				Roboid newRoboid = (Roboid)notification.getNewValue();
				
				setUniqueName(newRoboid, null, parent.getRoboids());
				newRoboid.setLiteral(newRoboid.getName());
				
				for(NamedElement child : newRoboid.getChildren())
					child.setLiteral(child.getName());
				
				refreshChildRoboidUid(parent, newRoboid);
				break;
			}
		case Notification.ADD_MANY:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Roboid> newRoboids = (List<Roboid>)notification.getNewValue();

				for(Roboid newRoboid : newRoboids)
				{
					setUniqueName(newRoboid, null, parent.getRoboids());
					newRoboid.setLiteral(newRoboid.getName());
					
					for(NamedElement child : newRoboid.getChildren())
						child.setLiteral(child.getName());
				}
				refreshChildRoboidUid(parent, newRoboids);
				break;
			}
		case Notification.REMOVE:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				Roboid oldRoboid = (Roboid)notification.getOldValue();
				refreshChildRoboidUid(parent, oldRoboid);
				break;
			}
		case Notification.REMOVE_MANY:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Roboid> oldRoboids = (List<Roboid>)notification.getOldValue();
				refreshChildRoboidUid(parent, oldRoboids);
				break;
			}
		case Notification.MOVE:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				Roboid newRoboid = (Roboid)notification.getNewValue();
				refreshChildRoboidUid(parent, newRoboid);
				break;
			}
		}
	}
	
	private void checkProtocol(Notification notification)
	{
		switch(notification.getEventType())
		{
		case Notification.ADD:
			{
				Protocol protocol = (Protocol)notification.getNewValue();
				protocol.setLiteral(protocol.getName());
				break;
			}
		}
	}
	
	private void checkDevice(Notification notification)
	{
		switch(notification.getEventType())
		{
		case Notification.ADD:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				Device child = (Device)notification.getNewValue();
				setUniqueName(child, null, parent.getDevices());
				child.setLiteral(child.getName());
				break;
			}
		case Notification.ADD_MANY:
			{
				Roboid parent = (Roboid)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Device> devices = (List<Device>)notification.getNewValue();
				for(Device child : devices)
				{
					setUniqueName(child, null, parent.getDevices());
					child.setLiteral(child.getName());
				}
				break;
			}
		}
	}
	
	private void checkId(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			Roboid roboid = (Roboid)notification.getNotifier();
			String newId = notification.getNewStringValue();
			String oldId = notification.getOldStringValue();
			refreshUid(roboid, newId, oldId);
		}
	}
	
	private void refreshChildRoboidUid(Roboid parent, Roboid ref)
	{
		if(parent == null || ref == null) return;
		
		String id = ref.getId();
		if(id == null || id.isEmpty()) return;
		
		List<Roboid> children = new ArrayList<Roboid>();
		collectChildRoboidsById(children, parent, id);
		
		int index = 0;
		String prefix = id + ".";
		for(Roboid child : children)
			child.setUid(prefix + index++);
	}
	
	private List<Roboid> collectChildRoboidsById(List<Roboid> children, Roboid parent, String id)
	{
		for(Roboid child : parent.getRoboids())
		{
			if(id.equalsIgnoreCase(child.getId()))
				children.add(child);
		}
		return children;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshChildRoboidUid(Roboid parent, List<Roboid> refs)
	{
		if(parent == null || refs == null) return;
		
		for(Roboid ref : refs)
			refreshChildRoboidUid(parent, ref);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshUid(Roboid target, String newId, String oldId)
	{
		if(target == null) return;
		if(newId == null || newId.isEmpty()) return;
		if(oldId == null || oldId.isEmpty()) return;
		
		List<Roboid> oldSiblings = new ArrayList<Roboid>();
		collectSiblingRoboidsById(oldSiblings, target, oldId);
		
		int index = 0;
		String prefix = oldId + ".";
		for(Roboid sibling : oldSiblings)
			sibling.setUid(prefix + index++);
		
		List<Roboid> newSiblings = new ArrayList<Roboid>();
		collectSiblingRoboidsById(newSiblings, target, newId);
		
		index = 0;
		prefix = newId + ".";
		for(Roboid sibling : newSiblings)
			sibling.setUid(prefix + index++);
	}
	
	private List<Roboid> collectSiblingRoboidsById(List<Roboid> siblings, Roboid ref, String id)
	{
		NamedElement parent = ref.getParent();
		List<Roboid> candidates = null;
		if(parent instanceof Robot)
			candidates = ((Robot)parent).getRoboids();
		else if(parent instanceof Roboid)
			candidates = ((Roboid)parent).getRoboids();
		else
			return siblings;
		for(Roboid candidate : candidates)
		{
			if(id.equalsIgnoreCase(candidate.getId()))
				siblings.add(candidate);
		}
		return siblings;
	}
	
	@Override
	public Object getIcon(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Roboid.png"));
	}

	@Override
	protected org.eclipse.emf.common.command.Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection, int index)
	{
		if(owner instanceof Roboid) collection = null;
		return super.createAddCommand(domain, owner, feature, collection, index);
	}
	
	@Override
	protected org.eclipse.emf.common.command.Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection)
	{
		if(owner instanceof Roboid) collection = null;
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	@Override
	protected org.eclipse.emf.common.command.Command createMoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value, int index)
	{
		if(owner instanceof Roboid) value = null;
		return super.createMoveCommand(domain, owner, feature, value, index);
	}
	
	@Override
	protected org.eclipse.emf.common.command.Command createCopyCommand(EditingDomain domain, EObject owner, Helper helper)
	{
		if(owner.eContainer() instanceof Roboid) return null;
		return super.createCopyCommand(domain, owner, helper);
	}

	@Override
	protected org.eclipse.emf.common.command.Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection)
	{
		if(owner instanceof Roboid) collection = null;
		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}
}
