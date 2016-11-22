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

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.roboid.core.component.activity.AbstractActivity;
import org.roboid.core.component.activity.ActivityConstants;
import org.roboid.core.component.activity.AddonActivity;
import org.roboid.core.component.activity.RoboidActivity;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.studio.roboidmanager.Activator;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ActivityViewLabelProvider extends LabelProvider implements ITableLabelProvider
{
	private Image[] images = new Image[6];
	
	public ActivityViewLabelProvider()
	{
		images[0] = ResourceManager.getImage(Activator.getImageDescriptor("icons/roboid_active.gif"));
		images[1] = ResourceManager.getImage(Activator.getImageDescriptor("icons/activeComponent.gif"));
		images[2] = ResourceManager.getImage(Activator.getImageDescriptor("icons/addon_roboid.gif"));
		images[3] = ResourceManager.getImage(Activator.getImageDescriptor("icons/frgmt_obj.gif"));
		images[4] = ResourceManager.getImage(Activator.getImageDescriptor("icons/roboid.gif"));
		images[5] = ResourceManager.getImage(Activator.getImageDescriptor("icons/ext_plugin_obj.gif"));
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex)
	{
		if(element instanceof RoboidActivity)
			return images[columnIndex];
		else if(element instanceof AddonActivity)
			return images[columnIndex + 2];
		else if(element instanceof SystemActivity)
			return images[columnIndex + 4];
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex)
	{
		if(element instanceof RoboidActivity)
		{
			AbstractActivity activity = (AbstractActivity)element;
			switch(columnIndex)
			{
			case 0:
				return (String)activity.getPropertyValue(ActivityConstants.ROBOID_ID);
			case 1:
				return activity.getId();
			}
		}
		else if(element instanceof AddonActivity)
		{
			AbstractActivity activity = (AbstractActivity)element;
			switch(columnIndex)
			{
			case 0:
				return (String)activity.getPropertyValue(ActivityConstants.MODEL_FILE_NAME);
			case 1:
				return activity.getId();
			}
		}
		else if(element instanceof SystemActivity)
		{
			AbstractActivity activity = (AbstractActivity)element;
			switch(columnIndex)
			{
			case 0:
				return (String)activity.getPropertyValue(ActivityConstants.MODEL_FILE_NAME);
			case 1:
				return activity.getId();
			}
		}
		return "";
	}
}
