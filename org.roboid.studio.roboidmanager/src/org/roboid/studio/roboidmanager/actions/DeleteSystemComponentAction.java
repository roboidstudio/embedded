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

package org.roboid.studio.roboidmanager.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.studio.roboidmanager.Activator;

/**
 * @author Kwang-Hyun Park
 */
public class DeleteSystemComponentAction extends Action
{
	private StructuredViewer viewer;
	private Activity activity;
	private List<SystemActivity> systemActivities;
	
	public DeleteSystemComponentAction(StructuredViewer viewer, Activity activity)
	{
		this.viewer = viewer;
		this.activity = activity;
		
		setText("Delete System Component");
		setId("org.roboid.studio.roboidmanager.deletesystemcomponent");
		setToolTipText("Delete selected system components");
		setImageDescriptor(Activator.getImageDescriptor("icons/delete_system_component.gif"));
	}

	@Override
	public boolean isEnabled()
	{
		if(viewer == null) return false;
		
		StructuredSelection selection = (StructuredSelection)viewer.getSelection();
		systemActivities = new ArrayList<SystemActivity>();
		Iterator<?> it = selection.iterator();
		while(it.hasNext())
		{
			Object o = it.next();
			if(o instanceof SystemActivity)
				systemActivities.add((SystemActivity)o);
		}
		if(systemActivities.isEmpty()) return false;
		
		return super.isEnabled();
	}

	@Override
	public void run()
	{
		activity.removeChildren(systemActivities);
	}
}
