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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.roboid.core.component.IComponent;
import org.roboid.core.component.activity.AbstractActivity;
import org.roboid.core.component.activity.ActivityConstants;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.proxy.AbstractComponentProxy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Activity</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.core.component.activity.impl.AbstractActivityImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.roboid.core.component.activity.impl.AbstractActivityImpl#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractActivityImpl extends EObjectImpl implements AbstractActivity
{
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractActivityImpl()
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
		return ActivityPackage.Literals.ABSTRACT_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		return enabled;
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
			case ActivityPackage.ABSTRACT_ACTIVITY__ID:
				return getId();
			case ActivityPackage.ABSTRACT_ACTIVITY__ENABLED:
				return isEnabled();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ActivityPackage.ABSTRACT_ACTIVITY__ID:
				setId((String)newValue);
				return;
			case ActivityPackage.ABSTRACT_ACTIVITY__ENABLED:
				setEnabled((Boolean)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ActivityPackage.ABSTRACT_ACTIVITY__ID:
				setId(ID_EDEFAULT);
				return;
			case ActivityPackage.ABSTRACT_ACTIVITY__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ActivityPackage.ABSTRACT_ACTIVITY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ActivityPackage.ABSTRACT_ACTIVITY__ENABLED:
				return enabled != ENABLED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	protected List<AbstractComponentProxy> components;
	private AbstractComponentProxy selectedComponent;
	private String[] componentIds;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canChangeEnabled()
	{
		return true;
	}
	
	abstract List<AbstractComponentProxy> collectComponents(List<AbstractComponentProxy> components);
	
	List<AbstractComponentProxy> getComponents()
	{
		if(components == null)
		{
			components = new ArrayList<AbstractComponentProxy>();
			collectComponents(components);
		}
		return components;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.ABSTRACT_ACTIVITY__ID, oldId, id));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.ABSTRACT_ACTIVITY__ENABLED, oldEnabled, enabled));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void update(String newId)
	{
		setId(newId);
		doSetComponent(newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void update(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		setEnabled(newEnabled);
		doSetEnabled(oldEnabled, newEnabled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void update(int newIndex)
	{
		AbstractComponentProxy component = getComponent(newIndex);
		if(component != null)
		{
			setId(component.getId());
			doSetComponent(component);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IComponent getSelectedComponent()
	{
		return selectedComponent;
	}

	private void doSetComponent(AbstractComponentProxy newComponent)
	{
		if(newComponent == null) return;
		
		IComponent oldComponent = getSelectedComponent();
		if(newComponent == oldComponent) return;
		
		selectedComponent = newComponent;
		
		if(isEnabled())
		{
			if(oldComponent != null)
				oldComponent.dispose();
			if(newComponent != null)
			{
				newComponent.realize();
				initializeComponent();
			}
		}
	}
	
	private void doSetComponent(String id)
	{
		if(id == null) return;
		AbstractComponentProxy component = getComponent(id);
		if(component != null) doSetComponent(component);
	}
	
	private void doSetEnabled(boolean oldEnabled, boolean newEnabled)
	{
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component == null) return;
		if(oldEnabled == newEnabled) return;
		
		if(oldEnabled)
			component.dispose();
		if(newEnabled)
		{
			component.realize();
			initializeComponent();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int countComponents()
	{
		return getComponents().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSelectedComponentIndex()
	{
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		return getComponents().indexOf(component);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractComponentProxy getComponent(int index)
	{
		if(index < 0 || index >= getComponents().size()) return null;
		return getComponents().get(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractComponentProxy getComponent(String id)
	{
		if(id == null) return null;
		for(AbstractComponentProxy component : getComponents())
		{
			if(id.equalsIgnoreCase(component.getId()))
				return component;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getPropertyValue(int id)
	{
		switch(id)
		{
		case ActivityConstants.COMPONENT_ID_LIST:
			if(componentIds == null)
			{
				List<String> ids = new ArrayList<String>();
				for(IComponent component : components)
					ids.add(component.getId());
				componentIds = ids.toArray(new String[ids.size()]);
			}
			return componentIds;
		case ActivityConstants.MODEL_FILE_NAME:
			return "";
		case ActivityConstants.ROBOID_ID:
			return "";
		}
		return "";
	}
	
	abstract void initializeComponent();
	
	void disposeComponent()
	{
		if(isEnabled() == false) return;
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component != null) component.dispose();
	}
	
	void activateComponent()
	{
		if(isEnabled() == false) return;
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component != null) component.activate();
	}
	
	void deactivateComponent()
	{
		if(isEnabled() == false) return;
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component != null) component.deactivate();
	}
	
	void executeComponent()
	{
		if(isEnabled() == false) return;
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component != null) component.execute();
	}
	
	void realizeComponent()
	{
		if(isEnabled() == false) return;
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component != null) component.realize();
	}
	
	boolean isComponentReady()
	{
		if(isEnabled() == false) return true;
		AbstractComponentProxy component = (AbstractComponentProxy)getSelectedComponent();
		if(component != null) return component.isReady();
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refresh()
	{
		selectedComponent = getComponent(getId());
		if(isEnabled() && selectedComponent != null)
		{
			selectedComponent.realize();
			initializeComponent();
		}
	}
	
	void updateReference(AbstractActivity reference)
	{
		components = ((AbstractActivityImpl)reference).getComponents();
		selectedComponent = getComponent(reference.getSelectedComponentIndex());
		doSetComponent(getId());
		doSetEnabled(reference.isEnabled(), isEnabled());
	}
} //AbstractActivityImpl
