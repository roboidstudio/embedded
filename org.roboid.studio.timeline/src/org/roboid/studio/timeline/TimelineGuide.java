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

package org.roboid.studio.timeline;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * 가이드는 최대 2개까지 허용한다.
 * 하나만 있는 경우는 시작점을 뜻하며 클립의 마지막까지 재생한다.
 * 2개인 경우는 시작 및 끝 점을 지시한다.
 * 하나를 지워야 다른 곳에 하나를 만들 수 있다. 
 *
 * @author Kyoung Jin Kim
 */
public class TimelineGuide implements Serializable, IPropertySource
{
	static final long serialVersionUID = 1;
	
	/**
	 * Property used to notify listeners when the guide is re-positioned
	 */
	public static final String P_FRAME = "_frame";
	public static final String P_POSITION_CHANGED = "_changed"; //$NON-NLS-1$

	protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
	private int position;

	/**
	 * Empty default constructor
	 */
	public TimelineGuide()
	{
		// empty constructor
	}

	/**
	 * @return	the position/location of the guide (in pixels)
	 */
	public int getPosition()
	{
		return position;
	}

	/**
	 * Sets the location of the guide
	 * 
	 * @param	offset		The location of the guide (in pixels)
	 */
	public void setPosition(int offset)
	{
		if(position != offset)
		{
			int oldValue = position;
			position = offset;
			if(position < 0) position = 0;
			listeners.firePropertyChange(P_POSITION_CHANGED, new Integer(oldValue), new Integer(position));
		}
	}
	
	/**
	 * @see	PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 * @see	PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener)
	{
		listeners.removePropertyChangeListener(listener);
	}

	//Implements IPropertySource
	@Override
	public Object getEditableValue()
	{
		return this;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		IPropertyDescriptor[] desc = new IPropertyDescriptor[] 
		{
			new TextPropertyDescriptor(P_FRAME, "Frame"),
		};
		return desc;
	}

	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_FRAME)) return new Integer(200).toString();
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		return false;
	}

	@Override
	public void resetPropertyValue(Object id)
	{
	}

	@Override
	public void setPropertyValue(Object id, Object value)
	{
	}
}
