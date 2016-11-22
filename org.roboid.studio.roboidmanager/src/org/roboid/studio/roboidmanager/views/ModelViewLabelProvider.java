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
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.graphics.Image;
import org.roboid.studio.roboidmanager.Activator;
import org.roboid.studio.roboidmanager.model.ModelNode;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ModelViewLabelProvider extends LabelProvider implements ITableLabelProvider
{
	private Image[] images = new Image[3];
	
	public ModelViewLabelProvider()
	{
		images[0] = ResourceManager.getImage(Activator.getImageDescriptor("icons/roboid_active.gif"));
		images[1] = ResourceManager.getImage(Activator.getImageDescriptor("icons/activeComponent.gif"));
		images[2] = ResourceManager.getImage(Activator.getImageDescriptor("icons/frgmt_obj.gif"));
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex)
	{
		if(columnIndex == 0)
		{
			if(element instanceof ModelNode)
				return images[0];
			else
			{
				if(element == null) return null;
				IExtension extention = (IExtension)((TreeNode)element).getValue();
				IConfigurationElement config = extention.getConfigurationElements()[0];
				String host = config.getAttribute("host");
				if(host == null) return images[1];
				else return images[2];
			}
		}
		return null;
//
//		String icon = config.getAttribute("icon");
//		if(icon != null)
//		{
//			IExtension extension = config.getDeclaringExtension();
//			String pluginExtendingPluginId = extension.getContributor()
//					.getName();
//			ImageDescriptor imageDescriptor = AbstractUIPlugin
//					.imageDescriptorFromPlugin(
//							pluginExtendingPluginId, icon);
//			if (imageDescriptor != null)
//				return imageDescriptor.createImage();			
//		}
//		return null; //config.getAttribute("icon");
	}

	@Override
	public String getColumnText(Object element, int columnIndex)
	{
		if(element instanceof ModelNode)
		{
			switch(columnIndex)
			{
			case 0:
				return ((ModelNode)element).getId();
			case 1:
				return ((ModelNode)element).getCategory();
			}
		}
		else
		{
			switch(columnIndex)
			{
			case 0:
				if(element == null) return "";
				IExtension extention = (IExtension)((TreeNode)element).getValue();
				IConfigurationElement config = extention.getConfigurationElements()[0];
				return config.getAttribute("id");
			}
		}
		return "";
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
