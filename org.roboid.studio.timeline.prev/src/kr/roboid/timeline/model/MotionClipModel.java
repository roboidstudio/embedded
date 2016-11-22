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

package kr.roboid.timeline.model;

import java.util.ArrayList;
import java.util.List;

import org.roboid.robot.Robot;
import org.roboid.studio.timeline.TimelineFactory;

/**
 * @author Kwang-Hyun Park
 */
public class MotionClipModel extends AbstractModel
{
	private static final long serialVersionUID = 1L;
	private List<AbstractChannelModel> childlen;
	
	private List<AbstractChannelModel> getChildren()
	{
		if(childlen == null) childlen = new ArrayList<AbstractChannelModel>();
		return childlen;
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
		List<org.roboid.studio.timeline.ChannelTrack> newChannelModels = new ArrayList<org.roboid.studio.timeline.ChannelTrack>();
		for(org.roboid.studio.timeline.ControlTrack control : newMotionClip.getControls())
			newChannelModels.addAll(control.getChannels());
		
		org.roboid.studio.timeline.VoiceTrack newVoiceChannelModel = null;
		org.roboid.studio.timeline.AudioTrack newAudioChannelModel = null;

		for(org.roboid.studio.timeline.ChannelTrack channelModel : newChannelModels)
		{
			if(channelModel instanceof org.roboid.studio.timeline.VoiceTrack)
				newVoiceChannelModel = (org.roboid.studio.timeline.VoiceTrack)channelModel;
			else if(channelModel instanceof org.roboid.studio.timeline.AudioTrack)
				newAudioChannelModel = (org.roboid.studio.timeline.AudioTrack)channelModel;
		}
		
		int index = 0;
		for(AbstractChannelModel oldChannelModel : getChildren())
		{
			if((oldChannelModel instanceof LipSyncChannelModel) || (oldChannelModel instanceof TextToSpeechChannelModel))
			{
				if(newVoiceChannelModel != null) oldChannelModel.copyTo(newVoiceChannelModel);
				else if(newAudioChannelModel != null) oldChannelModel.copyTo(newAudioChannelModel);
			}
			else if(oldChannelModel instanceof AudioChannelModel)
			{
				if(newAudioChannelModel != null) oldChannelModel.copyTo(newAudioChannelModel);
			}
			else
			{
				org.roboid.studio.timeline.ChannelTrack newChannelModel = null;
				while(true)
				{
					if(index >= newChannelModels.size())
						break;
					
					org.roboid.studio.timeline.ChannelTrack channelModel = newChannelModels.get(index++);
					if(!(channelModel instanceof org.roboid.studio.timeline.AudioTrack))
					{
						newChannelModel = channelModel;
						break;
					}
				}
				if(newChannelModel != null)
					oldChannelModel.copyTo(newChannelModel);
			}
		}
	}
}
