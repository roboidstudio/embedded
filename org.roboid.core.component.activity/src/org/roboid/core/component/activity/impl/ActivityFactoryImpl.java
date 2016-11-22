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

package org.roboid.core.component.activity.impl;

import java.util.List;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.roboid.core.ExtensionManager;
import org.roboid.core.component.IComponent;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.AddonActivity;
import org.roboid.core.component.activity.RoboidActivity;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.core.component.proxy.AbstractComponentProxy;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityFactoryImpl extends EFactoryImpl implements ActivityFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityFactory init()
	{
		try
		{
			ActivityFactory theActivityFactory = (ActivityFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.roboidstudio.org/model/component"); 
			if (theActivityFactory != null)
			{
				return theActivityFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActivityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case ActivityPackage.ACTIVITY: return (EObject)createActivity();
			case ActivityPackage.ROBOID_ACTIVITY: return (EObject)createRoboidActivity();
			case ActivityPackage.ADDON_ACTIVITY: return (EObject)createAddonActivity();
			case ActivityPackage.SYSTEM_ACTIVITY: return (EObject)createSystemActivity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case ActivityPackage.ROBOT:
				return createRobotFromString(eDataType, initialValue);
			case ActivityPackage.ICOMPONENT:
				return createIComponentFromString(eDataType, initialValue);
			case ActivityPackage.ABSTRACT_COMPONENT_PROXY:
				return createAbstractComponentProxyFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case ActivityPackage.ROBOT:
				return convertRobotToString(eDataType, instanceValue);
			case ActivityPackage.ICOMPONENT:
				return convertIComponentToString(eDataType, instanceValue);
			case ActivityPackage.ABSTRACT_COMPONENT_PROXY:
				return convertAbstractComponentProxyToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity()
	{
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboidActivity createRoboidActivity()
	{
		RoboidActivityImpl roboidActivity = new RoboidActivityImpl();
		return roboidActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddonActivity createAddonActivity()
	{
		AddonActivityImpl addonActivity = new AddonActivityImpl();
		return addonActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemActivity createSystemActivity()
	{
		SystemActivityImpl systemActivity = new SystemActivityImpl();
		return systemActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot createRobotFromString(EDataType eDataType, String initialValue)
	{
		return (Robot)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRobotToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IComponent createIComponentFromString(EDataType eDataType, String initialValue)
	{
		return (IComponent)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIComponentToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractComponentProxy createAbstractComponentProxyFromString(EDataType eDataType, String initialValue)
	{
		return (AbstractComponentProxy)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAbstractComponentProxyToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityPackage getActivityPackage()
	{
		return (ActivityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActivityPackage getPackage()
	{
		return ActivityPackage.eINSTANCE;
	}
	
	public Activity createActivity(Robot robot)
	{
		if(robot == null) return null;
		
		Activity activity = createActivity();
		
		for(Roboid roboid : robot.getRoboids())
		{
			RoboidActivity roboidActivity = createRoboidActivity(roboid);
			if(roboidActivity != null) activity.addChild(roboidActivity);
		}
		return activity;
	}
	
	public RoboidActivity createRoboidActivity(Roboid roboid)
	{
		if(roboid == null) return null;
		
		List<IExtension> roboidExtensions = ExtensionManager.getRoboidExtensions(roboid.getId());
		if(roboidExtensions.size() <= 0) return null;
		
		IExtension roboidExtension = roboidExtensions.get(0);
		String id = ExtensionManager.getId(roboidExtension);
		if(id == null || id.isEmpty()) return null;
		
		RoboidActivity roboidActivity = createRoboidActivity();
		roboidActivity.setId(id);
		roboidActivity.setEnabled(true);
		
		for(IExtension extension : ExtensionManager.getAddonExtensions(roboid.getId()))
		{
			AddonActivity addonActivity = createAddonActivity(extension);
			if(addonActivity != null) roboidActivity.addChild(addonActivity);
		}
		
		for(Roboid child : roboid.getRoboids())
		{
			RoboidActivity childActivity = createRoboidActivity(child);
			if(childActivity != null) roboidActivity.addChild(childActivity);
		}
		return roboidActivity;
	}
	
	public AddonActivity createAddonActivity(IExtension extension)
	{
		String id = ExtensionManager.getId(extension);
		if(id == null || id.isEmpty()) return null;
		
		AddonActivity addonActivity = createAddonActivity();
		addonActivity.setId(id);
		addonActivity.setEnabled(false);
		return addonActivity;
	}
	
	public SystemActivity createSystemActivity(IExtension extension)
	{
		String id = ExtensionManager.getId(extension);
		if(id == null || id.isEmpty()) return null;
		
		SystemActivity systemActivity = createSystemActivity();
		systemActivity.setId(id);
		systemActivity.setEnabled(false);
		return systemActivity;
	}
} //ActivityFactoryImpl
