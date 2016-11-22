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

package org.roboid.studio.timeline.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.jface.viewers.StructuredSelection;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.editparts.ChannelTrackEditPart;
import org.roboid.studio.timeline.editparts.MotionClipEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class PasteControlPointCommand extends Command
{
	private GraphicalViewer viewer;
	private List<EditPart> oldSelectedEditParts;
	private List<ControlPoint> newControlPoints;
	private ChannelTrackEditPart selectedChannelEditPart;
	
	public PasteControlPointCommand(GraphicalViewer viewer)
	{
		this.viewer = viewer;
	}
	
	@Override
	public boolean canExecute()
	{
		Object contents = Clipboard.getDefault().getContents();
		if(!(contents instanceof List<?>)) return false;
		
		List<?> objects = (List<?>)contents;
		if(objects.isEmpty()) return false;
		
		for(Object o : viewer.getSelectedEditParts())
		{
			if(o instanceof ChannelTrackEditPart)
			{
				selectedChannelEditPart = (ChannelTrackEditPart)o;
				break;
			}
		}
		
		@SuppressWarnings("unchecked")
		Map<ControlPoint, EditPart> map = viewer.getEditPartRegistry();
		MotionClipEditPart motionClipEditPart = (MotionClipEditPart)viewer.getRootEditPart().getChildren().get(0);
		
		for(Object o : objects)
		{
			if(!(o instanceof ControlPoint)) continue;
			
			ControlPoint refPoint = (ControlPoint)o;
			
			ChannelTrack targetChannelTrack = null;
			if(selectedChannelEditPart == null)
			{
				if(map.get(refPoint) != null)
					targetChannelTrack = refPoint.getParent();
				else
				{
					for(Object controlEditPart : motionClipEditPart.getChildren())
					{
						for(Object channelEditPart : ((EditPart)controlEditPart).getChildren())
						{
							if(((ChannelTrackEditPart)channelEditPart).getModel().canCopy(refPoint))
							{
								targetChannelTrack = ((ChannelTrackEditPart)channelEditPart).getModel();
								if(targetChannelTrack != null) return true;
							}
						}
					}
				}
			}
			else if(selectedChannelEditPart.getModel().canCopy(refPoint))
				targetChannelTrack = selectedChannelEditPart.getModel();
			
			if(targetChannelTrack != null) return true;
		}
		
		return false;
	}

	@Override
	public void execute()
	{
		List<?> objects = (List<?>)Clipboard.getDefault().getContents();

		oldSelectedEditParts = new ArrayList<EditPart>();
		for(Object o : viewer.getSelectedEditParts())
			oldSelectedEditParts.add((EditPart)o);
		
		MotionClip sourceMotionClip = null;
		for(Object o : objects)
		{
			if(!(o instanceof ControlPoint)) continue;
			
			sourceMotionClip = ((ControlPoint)o).getParent().getParent().getParent();
		}
		MotionClip targetMotionClip = ((MotionClipEditPart)viewer.getRootEditPart().getChildren().get(0)).getModel();
		if(sourceMotionClip == null || targetMotionClip == null) return;
		
		@SuppressWarnings("unchecked")
		Map<ControlPoint, EditPart> map = viewer.getEditPartRegistry();
		newControlPoints = new ArrayList<ControlPoint>();
		
		if(sourceMotionClip == targetMotionClip || selectedChannelEditPart != null)
		{
			for(Object o : objects)
			{
				if(!(o instanceof ControlPoint)) continue;
				
				ControlPoint refPoint = (ControlPoint)o;
				
				ChannelTrack targetChannelTrack = null;
				if(selectedChannelEditPart == null)
				{
					if(map.get(refPoint) != null)
						targetChannelTrack = refPoint.getParent();
				}
				else if(selectedChannelEditPart.getModel().canCopy(refPoint))
					targetChannelTrack = selectedChannelEditPart.getModel();
	
				if(targetChannelTrack != null)
				{
					int x = refPoint.getFrame();
					
					while(true)
					{
						if(containsAtLocation(x, targetChannelTrack))
							x += 5;
						else
							break;
					}
	
					ControlPoint newPoint = targetChannelTrack.deepCopy(refPoint);
					if(newPoint != null)
					{
						newPoint.setConstraint(new Rectangle(x, MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16));
						newControlPoints.add(newPoint);
						targetChannelTrack.addChild(newPoint);
					}
				}
			}
		}
		else
		{
			List<ChannelTrack> sourceChannelTracks = new ArrayList<ChannelTrack>();
			List<ChannelTrack> targetChannelTracks = new ArrayList<ChannelTrack>();
			
			for(ControlTrack control : sourceMotionClip.getControls())
				sourceChannelTracks.addAll(control.getChannels());
			for(ControlTrack control : targetMotionClip.getControls())
				targetChannelTracks.addAll(control.getChannels());
			
			Iterator<ChannelTrack> it1 = sourceChannelTracks.iterator();
			Iterator<ChannelTrack> it2 = targetChannelTracks.iterator();
			while(it1.hasNext() && it2.hasNext())
			{
				ChannelTrack sourceChannelTrack = it1.next();
				ChannelTrack targetChannelTrack = it2.next();
				for(ControlPoint cp : sourceChannelTrack.getPoints())
				{
					if(objects.contains(cp) && targetChannelTrack.canCopy(cp))
					{
						int x = cp.getFrame();
						
						while(true)
						{
							if(containsAtLocation(x, targetChannelTrack))
								x += 5;
							else
								break;
						}
		
						ControlPoint newPoint = targetChannelTrack.deepCopy(cp);
						if(newPoint != null)
						{
							newPoint.setConstraint(new Rectangle(x, MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16));
							newControlPoints.add(newPoint);
							targetChannelTrack.addChild(newPoint);
						}
					}
				}
			}
		}
		
		List<EditPart> newSelectedEditParts = new ArrayList<EditPart>();
		for(ControlPoint cp : newControlPoints)
		{
			EditPart editPart = map.get(cp);
			if(editPart != null)
				newSelectedEditParts.add(editPart);
		}
		viewer.setSelection(new StructuredSelection(newSelectedEditParts.toArray()));
	}
	
	private boolean containsAtLocation(int x, ChannelTrack channel)
	{
		for(ControlPoint cp : channel.getPoints())
		{
			if(cp.getFrame() == x)
				return true;
		}
		return false;
	}
	
	@Override
	public boolean canUndo()
	{
		return newControlPoints != null && !newControlPoints.isEmpty();
	}

	@Override
	public void undo()
	{
		for(ControlPoint cp : newControlPoints)
			((ChannelTrack)cp.getParent()).removeChild(cp);
		viewer.setSelection(new StructuredSelection(oldSelectedEditParts));
	}

	@Override
	public void redo()
	{
		if(newControlPoints == null || newControlPoints.isEmpty()) return;
		
		oldSelectedEditParts = new ArrayList<EditPart>();
		for(Object o : viewer.getSelectedEditParts())
			oldSelectedEditParts.add((EditPart)o);
		
		@SuppressWarnings("unchecked")
		Map<ControlPoint, EditPart> map = viewer.getEditPartRegistry();
		List<EditPart> newSelectedEditParts = new ArrayList<EditPart>();
		for(ControlPoint cp : newControlPoints)
		{
			cp.getParent().addChild(cp);
			EditPart editPart = map.get(cp);
			if(editPart != null)
				newSelectedEditParts.add(editPart);
		}
		viewer.setSelection(new StructuredSelection(newSelectedEditParts.toArray()));
	}
}
