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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.core.ExtensionManager;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.RoboidActivity;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.core.component.activity.impl.ActivityImpl#getRoboids <em>Roboids</em>}</li>
 *   <li>{@link org.roboid.core.component.activity.impl.ActivityImpl#getSystems <em>Systems</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends EObjectImpl implements Activity
{
	/**
	 * The cached value of the '{@link #getRoboids() <em>Roboids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoboids()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboidActivity> roboids;

	/**
	 * The cached value of the '{@link #getSystems() <em>Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemActivity> systems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ActivityPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<RoboidActivity> getRoboids()
	{
		if (roboids == null)
		{
			roboids = new EObjectContainmentEList<RoboidActivity>(RoboidActivity.class, this, ActivityPackage.ACTIVITY__ROBOIDS);
		}
		return roboids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<SystemActivity> getSystems()
	{
		if (systems == null)
		{
			systems = new EObjectContainmentEList<SystemActivity>(SystemActivity.class, this, ActivityPackage.ACTIVITY__SYSTEMS);
		}
		return systems;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addChild(RoboidActivity child)
	{
		getRoboids().add(child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addChild(SystemActivity child)
	{
		getSystems().add(child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChild(RoboidActivity child)
	{
		getRoboids().remove(child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChild(SystemActivity child)
	{
		getSystems().remove(child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChildren(List<SystemActivity> children)
	{
		getSystems().removeAll(children);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initializeComponents()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).initializeComponents();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).initializeComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void disposeComponents()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).disposeComponents();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).disposeComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void activateComponents()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).activateComponents();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).activateComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deactivateComponents()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).deactivateComponents();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).deactivateComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void executeComponents()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).executeComponents();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).executeComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void realizeComponents()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).realizeComponents();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).realizeComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isComponentsReady()
	{
		for(RoboidActivity child : getRoboids())
		{
			if(((RoboidActivityImpl)child).isComponentsReady() == false)
				return false;
		}
		for(SystemActivity child : getSystems())
		{
			if(((SystemActivityImpl)child).isComponentReady() == false)
				return false;
		}
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void init(Robot robot)
	{
		if(robot == null) return;
		
		Iterator<Roboid> it1 = robot.getRoboids().iterator();
		Iterator<RoboidActivity> it2 = getRoboids().iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			Roboid roboid = it1.next();
			RoboidActivityImpl roboidActivity = (RoboidActivityImpl)it2.next();
			roboidActivity.init(roboid);
		}
		
		List<SystemActivity> removes = new ArrayList<SystemActivity>();
		for(SystemActivity systemActivity : getSystems())
		{
			IExtension extension = null;
			for(IExtension ext : ExtensionManager.getSystemExtensions())
			{
				String id = ext.getConfigurationElements()[0].getAttribute("id");
				if(id != null && id.equalsIgnoreCase(systemActivity.getId()))
				{
					extension = ext;
					break;
				}
			}
			if(extension == null)
				removes.add(systemActivity);
			else
				((SystemActivityImpl)systemActivity).init(robot);
		}
		getSystems().removeAll(removes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refresh()
	{
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).refresh();
		for(SystemActivity child : getSystems())
			((SystemActivityImpl)child).refresh();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateReference(Activity reference, Robot robot)
	{
		Iterator<RoboidActivity> it1 = getRoboids().iterator();
		Iterator<RoboidActivity> it2 = reference.getRoboids().iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			RoboidActivity roboidActivity = it1.next();
			RoboidActivity other = it2.next();
			((RoboidActivityImpl)roboidActivity).updateReference(other);
		}
		
		List<SystemActivity> candidates = new ArrayList<SystemActivity>(reference.getSystems());
		for(SystemActivity systemActivity : getSystems())
		{
			SystemActivity ref = null;
			for(SystemActivity other : candidates)
			{
				if(other.getId().equalsIgnoreCase(systemActivity.getId()))
				{
					ref = other;
					break;
				}
			}
			if(ref != null)
			{
				((SystemActivityImpl)systemActivity).updateReference(ref);
				candidates.remove(ref);
			}
			else
			{
				((SystemActivityImpl)systemActivity).init(robot);
				systemActivity.refresh();
			}
		}
		for(SystemActivity systemActivity : candidates)
			((SystemActivityImpl)systemActivity).disposeComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ActivityPackage.ACTIVITY__ROBOIDS:
				return ((InternalEList<?>)getRoboids()).basicRemove(otherEnd, msgs);
			case ActivityPackage.ACTIVITY__SYSTEMS:
				return ((InternalEList<?>)getSystems()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ActivityPackage.ACTIVITY__ROBOIDS:
				return getRoboids();
			case ActivityPackage.ACTIVITY__SYSTEMS:
				return getSystems();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ActivityPackage.ACTIVITY__ROBOIDS:
				return roboids != null && !roboids.isEmpty();
			case ActivityPackage.ACTIVITY__SYSTEMS:
				return systems != null && !systems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActivityImpl
