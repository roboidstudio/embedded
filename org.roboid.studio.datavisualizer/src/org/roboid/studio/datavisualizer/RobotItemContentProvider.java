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

package org.roboid.studio.datavisualizer;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.roboid.robot.Device;
import org.roboid.robot.Robot;

/**
 * @author Kwang-Hyun Park
 */
public class RobotItemContentProvider implements ITreeContentProvider
{
	private static final int MAX_NODE = 8;
	private HashMap<Object, Object[]> dataMap = new HashMap<Object, Object[]>();
	
	@Override
	public Object[] getChildren(Object parentElement)
	{
		if(parentElement instanceof Robot)
			return ((Robot)parentElement).getRoboids().toArray();
		else if(parentElement instanceof Device)
		{
			Object[] items = dataMap.get(parentElement);
			if(items == null)
			{
				int cnt = ((Device)parentElement).getDataSize();
				if(cnt > MAX_NODE)
					cnt = MAX_NODE;
				items = new DataItem[cnt];
				for(int i = 0; i < cnt; i ++)
					items[i] = new DataItem((Device)parentElement, i);
				dataMap.put(parentElement, items);
			}
			return items;
		}
		else if(parentElement instanceof EObject)
			return ((EObject)parentElement).eContents().toArray();
		return new Object[0];
	}

	@Override
	public Object getParent(Object element)
	{
		if(element instanceof EObject)
			return ((EObject)element).eContainer();
		return null;
	}

	@Override
	public boolean hasChildren(Object element)
	{
		if(element instanceof Device)
			return (((Device)element).getDataSize() > 1);
		else if(element instanceof EObject)
			return !((EObject)element).eContents().isEmpty();
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement)
	{
		return getChildren(inputElement);
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
	}
}
