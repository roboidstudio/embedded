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
import org.roboid.core.component.activity.ActivityConstants;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.AddonActivity;
import org.roboid.core.component.proxy.AbstractComponentProxy;
import org.roboid.core.component.proxy.AddonComponentProxy;
import org.roboid.core.component.util.ProxyFactory;
import org.roboid.robot.Roboid;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addon Activity</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AddonActivityImpl extends AbstractActivityImpl implements AddonActivity
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonActivityImpl()
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
		return ActivityPackage.Literals.ADDON_ACTIVITY;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	private Roboid host;
	private IExtension extension;
	
	void init(Roboid host, IExtension extension)
	{
		this.host = host;
		this.extension = extension;
	}
	
	Roboid getHost()
	{
		return host;
	}
	
	@Override
	List<AbstractComponentProxy> collectComponents(List<AbstractComponentProxy> components)
	{
		if(extension == null) return components;
		AddonComponentProxy component = ProxyFactory.createAddonComponentProxy(extension);
		if(component != null) components.add(component);
		return components;
	}

	@Override
	void initializeComponent()
	{
		if(isEnabled() == false) return;
		if(host == null) return;
		AddonComponentProxy component = (AddonComponentProxy)getSelectedComponent();
		if(component != null) component.initialize(host);
	}

	@Override
	public Object getPropertyValue(int id)
	{
		switch(id)
		{
		case ActivityConstants.MODEL_FILE_NAME:
			AddonComponentProxy component = (AddonComponentProxy)getSelectedComponent();
			return component == null ? "-" : component.getModelFileName();
		}
		return super.getPropertyValue(id);
	}
	
	void updateReference(AddonActivity reference)
	{
		host = ((AddonActivityImpl)reference).getHost();
		super.updateReference(reference);
	}
} //AddonActivityImpl
