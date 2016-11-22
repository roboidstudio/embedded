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

package org.roboid.studio.timeline.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.commands.CopyControlPointCommand;
import org.roboid.studio.timeline.editparts.ControlPointEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class CopyControlPointAction extends SelectionAction
{
	public CopyControlPointAction(IWorkbenchPart part)
	{
		super(part);
		setLazyEnablementCalculation(true);
	}

	@Override
	protected void init()
	{
		super.init();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setText("Copy");
		setId(ActionFactory.COPY.getId());
		setHoverImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setEnabled(true);
	}

	@Override
	protected boolean calculateEnabled()
	{
		if(getSelectedObjects().isEmpty()) return false;
		
		for(Object o : getSelectedObjects())
		{
			if(o instanceof ControlPointEditPart) return true;
		}
		return false;
	}

	@Override
	public void run()
	{
		if(getSelectedObjects().isEmpty()) return;

		List<ControlPoint> points = new ArrayList<ControlPoint>();
		for(Object o : getSelectedObjects())
		{
			if(o instanceof ControlPointEditPart)
				points.add((ControlPoint)((EditPart)o).getModel());
		}
		if(points.isEmpty()) return;
		
		new CopyControlPointCommand(points).execute();
	}
}
