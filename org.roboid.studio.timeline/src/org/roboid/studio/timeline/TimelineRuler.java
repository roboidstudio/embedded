/*******************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Pratik Shah
 *     Kyoung Jin Kim  - modification
 *******************************************************************************/
package org.roboid.studio.timeline;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pratik Shah
 * @author Kyoung Jin Kim
 */
public class TimelineRuler implements Serializable
{
	public static final String PROPERTY_CHILDREN = "children changed"; //$NON-NLS-1$
	public static final String PROPERTY_UNIT = "units changed"; //$NON-NLS-1$
		
	static final long serialVersionUID = 1;
	
	protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
	private int unit;	
	private boolean horizontal;
	private List<TimelineGuide> guides = new ArrayList<TimelineGuide>();
	
	public void addGuide(TimelineGuide guide) 
	{
		if(!guides.contains(guide))
		{
			guides.add(guide);
			listeners.firePropertyChange(PROPERTY_CHILDREN, null, guide);
		}
	}
	
	public void removeGuide(TimelineGuide guide) 
	{
		if(guides.remove(guide)) 
		{
			listeners.firePropertyChange(PROPERTY_CHILDREN, null, guide);
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) 
	{
		listeners.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) 
	{
		listeners.removePropertyChangeListener(listener);
	}
	
	// the returned list should not be modified
	public List<TimelineGuide> getGuides()
	{
		return guides;
	}
	
	public int getUnit()
	{
		return unit;
	}
	
	public boolean isHidden()
	{
		return false;
	}
	
	public boolean isHorizontal()
	{
		return horizontal;
	}
	
	public void setHidden(boolean isHidden)
	{
	}
	
	public void setUnit(int newUnit) 
	{
		if(unit != newUnit) 
		{
			int oldUnit = unit;
			unit = newUnit;
			listeners.firePropertyChange(PROPERTY_UNIT, oldUnit, newUnit);
		}
	}
}
