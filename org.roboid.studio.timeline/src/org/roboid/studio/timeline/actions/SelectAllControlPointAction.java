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
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.roboid.studio.timeline.editparts.ChannelTrackEditPart;
import org.roboid.studio.timeline.editparts.MotionClipEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class SelectAllControlPointAction extends SelectionAction
{
	public SelectAllControlPointAction(IWorkbenchPart part)
	{
		super(part);
		setLazyEnablementCalculation(true);
	}
	
	@Override
	protected void init()
	{
		super.init();
		setText("Select All");
		setId(ActionFactory.SELECT_ALL.getId());
		setEnabled(true);
	}
	
	@Override
	protected boolean calculateEnabled()
	{
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run()
	{
		GraphicalViewer viewer = (GraphicalViewer)getWorkbenchPart().getAdapter(GraphicalViewer.class);
		MotionClipEditPart motionClipEditPart = (MotionClipEditPart)viewer.getRootEditPart().getChildren().get(0);
		
		EditPart selectedChannelEditPart = null;
		for(Object o : viewer.getSelectedEditParts())
		{
			if(o instanceof ChannelTrackEditPart)
			{
				selectedChannelEditPart = (EditPart)o;
				break;
			}
		}
		
		List<EditPart> newSelections = new ArrayList<EditPart>();
		if(selectedChannelEditPart != null)
		{
			newSelections.addAll(selectedChannelEditPart.getChildren());
		}
		else
		{
			for(Object controlEditPart : motionClipEditPart.getChildren())
			{
				for(Object channelEditPart : ((EditPart)controlEditPart).getChildren())
				{
					newSelections.addAll(((EditPart)channelEditPart).getChildren());
				}
			}
		}
		viewer.setSelection(new StructuredSelection(newSelections));
	}
}
