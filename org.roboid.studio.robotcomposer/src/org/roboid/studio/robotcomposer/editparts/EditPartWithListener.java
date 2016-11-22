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

package org.roboid.studio.robotcomposer.editparts;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

/**
 * @author Kwang-Hyun Park
 */
public abstract class EditPartWithListener extends AbstractGraphicalEditPart implements Adapter
{
	private Notifier target;
	
	@Override
	public void activate()
	{
		if(!isActive())
		{
			hookIntoModel();
			super.activate();
		}
	}

	@Override
	public void deactivate()
	{
		if(isActive())
		{
			unhookFromModel();
			super.deactivate();
		}
	}
	
	protected void hookIntoModel()
	{
		EObject model = (EObject)getModel();
		if(model != null)
			model.eAdapters().add(this);
	}
	
	protected void unhookFromModel()
	{
		EObject model = (EObject)getModel();
		if(model != null)
			model.eAdapters().remove(this);
	}

	@Override
	public Notifier getTarget()
	{
		return target;
	}
	
	@Override
	public void setTarget(Notifier newTarget)
	{
		target = newTarget;
	}

	@Override
	public boolean isAdapterForType(Object type)
	{
		return (getModel().getClass() == type);
	}
}
