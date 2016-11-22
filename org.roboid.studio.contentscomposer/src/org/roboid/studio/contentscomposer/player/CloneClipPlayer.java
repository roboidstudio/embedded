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

import java.util.ArrayList;

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class CloneClipPlayer extends MotionClipPlayer
{
	private MotionClipCloneBlock cc; // 모션 클립의 복사본

	public CloneClipPlayer(Robot robot)
	{
		super(robot);
	}

	// 한 프레임을 실행한다.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // 클립 내에서의 현재 프레임
		if(frame > totalFrames) return -1; // 끝까지 실행했다.
		
		// 각 채널별로 한 프레임의 데이터를 디바이스에 쓴다.
		for(ChannelTrack channel : channels)
			channel.dump(frame);
		
		if(cc != null) cc.setFrame(frame); // 복사본의 프레임을 설정한다.
		return frame;
	}

	// 모션 클립의 복사본을 설정한다.
	@Override
	public void setClip(ClipBlock clip)
	{
		cc = (MotionClipCloneBlock)clip;
		
		// 실제 모션 클립을 얻는다.
		MotionClip motionClip = cc.getOriginal().getMotionClip();
		
		// 끝 프레임을 설정한다.
		int total = motionClip.getTotalFrames();
		if(cc.getStopFrame() == -1 || total < cc.getStopFrame())
			totalFrames = total;
		else 
			totalFrames = cc.getStopFrame();
		
		// 시작 프레임을 설정한다.
		int start = cc.getStartFrame();
		if(start > 0 || totalFrames > start)
			currentFrame = cc.getStartFrame();

		channels = new ArrayList<ChannelTrack>();
		for(ControlTrack control : motionClip.getControls())
		{
			channels.addAll(control.getChannels());
		}

		// 각 채널별로 시뮬레이크럼을 생성한다.
		for(ChannelTrack channel : channels)
			channel.createSimulacra();
		
		// 현재 프레임을 설정한다.
		cc.setFrame(currentFrame);
	}
}
