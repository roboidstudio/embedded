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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.core.ExtensionManager;
import org.roboid.core.component.activity.ActivityConstants;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.AddonActivity;
import org.roboid.core.component.activity.RoboidActivity;
import org.roboid.core.component.proxy.AbstractComponentProxy;
import org.roboid.core.component.proxy.RoboidComponentProxy;
import org.roboid.core.component.util.ProxyFactory;
import org.roboid.robot.Roboid;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roboid Activity</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.core.component.activity.impl.RoboidActivityImpl#getRoboids <em>Roboids</em>}</li>
 *   <li>{@link org.roboid.core.component.activity.impl.RoboidActivityImpl#getAddons <em>Addons</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoboidActivityImpl extends AbstractActivityImpl implements RoboidActivity
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
	 * The cached value of the '{@link #getAddons() <em>Addons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddons()
	 * @generated
	 * @ordered
	 */
	protected EList<AddonActivity> addons;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoboidActivityImpl()
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
		return ActivityPackage.Literals.ROBOID_ACTIVITY;
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
			roboids = new EObjectContainmentEList<RoboidActivity>(RoboidActivity.class, this, ActivityPackage.ROBOID_ACTIVITY__ROBOIDS);
		}
		return roboids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AddonActivity> getAddons()
	{
		if (addons == null)
		{
			addons = new EObjectContainmentEList<AddonActivity>(AddonActivity.class, this, ActivityPackage.ROBOID_ACTIVITY__ADDONS);
		}
		return addons;
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
			case ActivityPackage.ROBOID_ACTIVITY__ROBOIDS:
				return ((InternalEList<?>)getRoboids()).basicRemove(otherEnd, msgs);
			case ActivityPackage.ROBOID_ACTIVITY__ADDONS:
				return ((InternalEList<?>)getAddons()).basicRemove(otherEnd, msgs);
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
			case ActivityPackage.ROBOID_ACTIVITY__ROBOIDS:
				return getRoboids();
			case ActivityPackage.ROBOID_ACTIVITY__ADDONS:
				return getAddons();
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
			case ActivityPackage.ROBOID_ACTIVITY__ROBOIDS:
				return roboids != null && !roboids.isEmpty();
			case ActivityPackage.ROBOID_ACTIVITY__ADDONS:
				return addons != null && !addons.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	private Roboid roboid;
	
	void init(Roboid roboid)
	{
		if(roboid == null) return;
		
		this.roboid = roboid;
		
		for(IExtension extension : ExtensionManager.getAddonExtensions(roboid.getId()))
		{
			AddonActivity addonActivity = null;
			String id = ExtensionManager.getId(extension);
			if(id == null || id.isEmpty()) continue;
			
			for(AddonActivity activity : getAddons())
			{
				if(id.equalsIgnoreCase(activity.getId()))
				{
					addonActivity = activity;
					break;
				}
			}
			if(addonActivity == null)
			{
				addonActivity = ActivityFactory.eINSTANCE.createAddonActivity(extension);
				getAddons().add(addonActivity);
			}
			((AddonActivityImpl)addonActivity).init(roboid, extension);
		}
		
		Iterator<Roboid> it1 = roboid.getRoboids().iterator();
		Iterator<RoboidActivity> it2 = getRoboids().iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			Roboid childRoboid = it1.next();
			RoboidActivityImpl childActivity = (RoboidActivityImpl)it2.next();
			childActivity.init(childRoboid);
		}
	}
	
	Roboid getRoboid()
	{
		return roboid;
	}

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
	public void addChild(AddonActivity child)
	{
		getAddons().add(child);
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
	public void removeChild(AddonActivity child)
	{
		getAddons().remove(child);
	}
	
	@Override
	List<AbstractComponentProxy> collectComponents(List<AbstractComponentProxy> components)
	{
		if(roboid == null) return components;
		
		List<IExtension> roboidExtensions = ExtensionManager.getRoboidExtensions(roboid.getId());
		for(IExtension extension : roboidExtensions)
		{
			RoboidComponentProxy component = ProxyFactory.createRoboidComponentProxy(extension);
			if(component != null) components.add(component);
		}
		return components;
	}

	@Override
	public boolean canChangeEnabled()
	{
		return false;
	}

	@Override
	void initializeComponent()
	{
		if(isEnabled() == false) return;
		if(roboid == null) return;
		RoboidComponentProxy component = (RoboidComponentProxy)getSelectedComponent();
		if(component != null) component.initialize(roboid);
	}
	
	void initializeComponents()
	{
		initializeComponent();
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).initializeComponent();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).initializeComponents();
	}
	
	void disposeComponents()
	{
		disposeComponent();
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).disposeComponent();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).disposeComponents();
	}
	
	void activateComponents()
	{
		activateComponent();
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).activateComponent();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).activateComponents();
	}
	
	void deactivateComponents()
	{
		deactivateComponent();
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).deactivateComponent();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).deactivateComponents();
	}
	
	void executeComponents()
	{
		executeComponent();
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).executeComponent();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).executeComponents();
	}
	
	void realizeComponents()
	{
		realizeComponent();
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).realizeComponent();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).realizeComponents();
	}
	
	boolean isComponentsReady()
	{
		if(isComponentReady() == false) return false;
		for(AddonActivity child : getAddons())
		{
			if(((AddonActivityImpl)child).isComponentReady() == false)
				return false;
		}
		for(RoboidActivity child : getRoboids())
		{
			if(((RoboidActivityImpl)child).isComponentsReady() == false)
				return false;
		}
		return true;
	}
	
	@Override
	public Object getPropertyValue(int id)
	{
		switch(id)
		{
		case ActivityConstants.MODEL_FILE_NAME:
			return ((RoboidComponentProxy)getSelectedComponent()).getModelFileName();
		case ActivityConstants.ROBOID_ID:
			return roboid.getId();
		}
		return super.getPropertyValue(id);
	}
	
	@Override
	public void refresh()
	{
		super.refresh();
		
		for(AddonActivity child : getAddons())
			((AddonActivityImpl)child).refresh();
		for(RoboidActivity child : getRoboids())
			((RoboidActivityImpl)child).refresh();
	}
	
	void updateReference(RoboidActivity reference)
	{
		roboid = ((RoboidActivityImpl)reference).getRoboid();
		super.updateReference(reference);
		
		Iterator<AddonActivity> it1 = getAddons().iterator();
		Iterator<AddonActivity> it2 = reference.getAddons().iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			AddonActivity addonActivity = it1.next();
			AddonActivity other = it2.next();
			((AddonActivityImpl)addonActivity).updateReference(other);
		}
		
		Iterator<RoboidActivity> it3 = getRoboids().iterator();
		Iterator<RoboidActivity> it4 = reference.getRoboids().iterator();
		while(it3.hasNext() && it4.hasNext())
		{
			RoboidActivity roboidActivity = it3.next();
			RoboidActivity other = it4.next();
			((RoboidActivityImpl)roboidActivity).updateReference(other);
		}
	}
} //RoboidActivityImpl
