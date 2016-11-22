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

package org.roboid.studio.roboidmanager.views;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.Item;
import org.roboid.core.component.activity.AbstractActivity;
import org.roboid.core.component.activity.ActivityConstants;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class BundleCellModifier implements ICellModifier
{
	private CellEditor[] editors;
	private ComboBoxCellEditor editor;
	
	public BundleCellModifier(CellEditor[] editors)
	{
		this.editors = editors;
	}
	
	/**
	 * make item list of selected roboid model and set it in editor
	 * return false when the number of bundle is one.
	 */
	@Override
	public boolean canModify(Object element, String property)
	{
		if(!property.equals("component")) return false;
		if(!(element instanceof AbstractActivity)) return false;
		
		AbstractActivity activity = (AbstractActivity)element;
		if(activity.countComponents() < 2) return false;
		
		return true;
	}

	@Override
	public Object getValue(Object element, String property)
	{
		if(!property.equals("component")) return Integer.valueOf(-1);
		if(!(element instanceof AbstractActivity)) return Integer.valueOf(-1);
		
		AbstractActivity activity = (AbstractActivity)element;
		editor = (ComboBoxCellEditor)editors[1];
		editor.setItems((String[])activity.getPropertyValue(ActivityConstants.COMPONENT_ID_LIST));
		
		int index = activity.getSelectedComponentIndex();
		if(index < 0) index = 0;
		return Integer.valueOf(index);
	}

	@Override
	public void modify(Object element, String property, Object value)
	{
		if(element instanceof Item)
			element = ((Item)element).getData();

		if(element instanceof AbstractActivity)
		{
			AbstractActivity activity = (AbstractActivity)element;
			int index = ((Integer)value).intValue();
			activity.update(index);
		}
	}
}
