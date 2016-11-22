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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.roboid.robot.Channel;
import org.roboid.robot.Control;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.robot.RobotPackage;

/**
 * This is the item provider adapter for a {@link org.roboid.robot.Control} object.
 * <!-- begin-user-doc -->
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class ControlItemProvider
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
	public ControlItemProvider(AdapterFactory adapterFactory)
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
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addVersionPropertyDescriptor(object);
			addFrameLimitPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Control_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Control_version_feature", "_UI_Control_type"),
				 RobotPackage.Literals.CONTROL__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Frame Limit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFrameLimitPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Control_frameLimit_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Control_frameLimit_feature", "_UI_Control_type"),
				 RobotPackage.Literals.CONTROL__FRAME_LIMIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(RobotPackage.Literals.CONTROL__CHANNELS);
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
	 * This returns Control.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Control"));
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
		String label = ((Control)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Control_type") :
			getString("_UI_Control_type") + " " + label;
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
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createLinearChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createCommandChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createAudioChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createVoiceChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createColorChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createTextChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createMatrixChannel()));

		newChildDescriptors.add
			(createChildParameter
				(RobotPackage.Literals.CONTROL__CHANNELS,
				 RobotFactory.eINSTANCE.createFileChannel()));
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

		switch (notification.getFeatureID(Control.class))
		{
			case RobotPackage.NAMED_ELEMENT__NAME:
				checkName(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RobotPackage.CONTROL__VERSION:
			case RobotPackage.CONTROL__FRAME_LIMIT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RobotPackage.CONTROL__CHANNELS:
				checkChannel(notification);
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}
	
	private void checkName(Notification notification)
	{
		if(notification.getEventType() == Notification.SET)
		{
			Control control = (Control)notification.getNotifier();
			Robot robot = (Robot)((EObject)control).eContainer();
			String newName = (String)notification.getNewValue();
			setUniqueName(control, newName, robot.getControls());
		}
	}
	
	private void checkChannel(Notification notification)
	{
		switch(notification.getEventType())
		{
		case Notification.ADD:
			{
				Control parent = (Control)notification.getNotifier();
				Channel child = (Channel)notification.getNewValue();
				setUniqueName(child, null, parent.getChannels());
				child.setLiteral(child.getName());
				break;
			}
		case Notification.ADD_MANY:
			{
				Control parent = (Control)notification.getNotifier();
				@SuppressWarnings("unchecked")
				List<Channel> channels = (List<Channel>)notification.getNewValue();
				for(Channel child : channels)
				{
					setUniqueName(child, null, parent.getChannels());
					child.setLiteral(child.getName());
				}
				break;
			}
		}
	}
	
	@Override
	public Object getIcon(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Control.png"));
	}
}
