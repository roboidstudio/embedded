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

package org.roboid.studio.timeline.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.roboid.robot.Robot;
import org.roboid.studio.timeline.TimelineFactory;

/**
 * @author Kwang-Hyun Park
 */
public class MotionClipModel extends AbstractModel
{
	private static final long serialVersionUID = 1L;
	private List<AbstractChannelModel> children;
	
	private List<AbstractChannelModel> getChildren()
	{
		if(children == null) children = new ArrayList<AbstractChannelModel>();
		return children;
	}
	
	public org.roboid.studio.timeline.MotionClip toVersion1_4(Robot robot)
	{
		org.roboid.studio.timeline.MotionClip newMotionClip = TimelineFactory.eINSTANCE.createMotionClip();
		newMotionClip.setRobot(robot);
		newMotionClip.createControlTracks(robot);
		toVersion1_4(newMotionClip);
		return newMotionClip;
	}
	
	public void toVersion1_4(org.roboid.studio.timeline.MotionClip newMotionClip)
	{
		List<org.roboid.studio.timeline.ChannelTrack> newChannelTracks = new ArrayList<org.roboid.studio.timeline.ChannelTrack>();
		for(org.roboid.studio.timeline.ControlTrack control : newMotionClip.getControls())
			newChannelTracks.addAll(control.getChannels());
		
		Iterator<AbstractChannelModel> itOld = getChildren().iterator();
		Iterator<org.roboid.studio.timeline.ChannelTrack> itNew = newChannelTracks.iterator();
		while(itOld.hasNext() && itNew.hasNext())
		{
			AbstractChannelModel oldChannelModel = itOld.next();
			org.roboid.studio.timeline.ChannelTrack newChannelTrack = itNew.next();
			oldChannelModel.copyTo(newChannelTrack);
		}
	}
}
