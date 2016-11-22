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

package org.roboid.studio.contentscomposer.player;

import org.eclipse.emf.common.util.URI;
import org.roboid.core.runtime.IClip;
import org.roboid.core.runtime.IClipLoader;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kwang-Hyun Park
 */
public class ClipLoader implements IClipLoader
{
	@Override
	public IClip load(URI uri, boolean audioPreload)
	{
		MotionContent clip = ContentsComposer.readContentsClip(uri);
		if(clip == null) return null;
		Robot robot = clip.getRobot();
		if(robot == null) clip = null;
		else if(!clip.validate()) clip = null;
		else if(audioPreload) preloadAudio(clip);
		return clip;
	}
	
	private void preloadAudio(MotionContent clip)
	{
		if(clip == null) return;
		
		for(MotionClipBlock block : clip.getMotionClipBlocks())
		{
			MotionClip motionClip = block.getMotionClip();
			if(motionClip == null) continue;

			for(ControlTrack control : motionClip.getControls())
			{
				for(ChannelTrack channel : control.getChannels())
				{
					if(channel instanceof AudioTrack)
						((AudioTrack)channel).preLoad();
				}
			}
		}
		
		for(MotionContentBlock block : clip.getMotionContentBlocks())
			preloadAudio(block.getContent());
	}
}
