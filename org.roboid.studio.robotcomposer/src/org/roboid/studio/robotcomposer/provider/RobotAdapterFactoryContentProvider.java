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

package org.roboid.studio.robotcomposer.provider;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotDiagram;
import org.roboid.studio.robotcomposer.editparts.RobotDiagramEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class RobotAdapterFactoryContentProvider extends AdapterFactoryContentProvider
{
	public RobotAdapterFactoryContentProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	@Override
	public Object[] getChildren(Object object)
	{
		ITreeItemContentProvider treeItemContentProvider = (ITreeItemContentProvider)adapterFactory.adapt(object, ITreeItemContentProvider.class);
		if(treeItemContentProvider == null) return Collections.EMPTY_LIST.toArray();

		Collection<?> children = treeItemContentProvider.getChildren(object);
		
		if((object instanceof Resource) && !children.isEmpty())
			return new Object[] { children.iterator().next() };
		return children.toArray();
	}

	@Override
	public IPropertySource getPropertySource(Object object)
	{
		IPropertySource propertySource = null;
		if(object instanceof EditPart)
		{
			Object model = ((EditPart)object).getModel();
			if(model instanceof RoboidBlock)
				propertySource = super.getPropertySource(((RoboidBlock)model).getRoboid());
			else if(model instanceof DeviceElement)
				propertySource = super.getPropertySource(((DeviceElement)model).getDevice());
			else if(model instanceof RobotDiagram)
				propertySource = ((RobotDiagramEditPart)object).getPropertySource(getAdapterFactory());
			else if(model instanceof Association)
				return null;
			else
				propertySource = super.getPropertySource(((EditPart)object).getModel());
		}
		else
			propertySource = super.getPropertySource(object);

		return propertySource;
	}
}
