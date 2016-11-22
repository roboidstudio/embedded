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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.roboid.core.ExtensionManager;
import org.roboid.studio.roboidmanager.Activator;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class AddonComponentViewLabelProvider extends LabelProvider implements ITableLabelProvider
{
	private Image[] images = new Image[4];
	
	public AddonComponentViewLabelProvider()
	{
		images[0] = ResourceManager.getImage(Activator.getImageDescriptor("icons/frgmt_obj.gif"));
		images[2] = ResourceManager.getImage(Activator.getImageDescriptor("icons/roboid_active.gif"));
		images[3] = ResourceManager.getImage(Activator.getImageDescriptor("icons/addon_roboid2.gif"));
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex)
	{
		if(columnIndex < 0 || columnIndex > 3) return null;
		return images[columnIndex];
	}

	@Override
	public String getColumnText(Object element, int columnIndex)
	{
		if(element == null) return "";

		IConfigurationElement config = ((IExtension)element).getConfigurationElements()[0];
		switch(columnIndex)
		{
			case 0: 
				return config.getAttribute("id");
			case 1:
				return config.getAttribute("name");
			case 2:
				return config.getAttribute("host");	
			case 3:
				String modelFileName = config.getAttribute("model");
				if(modelFileName != null) return ExtensionManager.toRoboidId(modelFileName);
				return "-";
			case 4:
				return config.getAttribute("provider");
			case 5:
				return config.getAttribute("version");
			default:
				return "";
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener)
	{
	}

	@Override
	public void removeListener(ILabelProviderListener listener)
	{
	}
	
	@Override
	public boolean isLabelProperty(Object element, String property)
	{
		return false;
	}
}
