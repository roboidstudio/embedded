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
import java.util.List;

import org.roboid.core.runtime.ContentsManager;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class MotionClipPlayer extends AbstractClipPlayer
{
	protected List<ChannelTrack> channels; // 채널 리스트
	protected int totalFrames; // 전체 프레임 수
	private MotionClipBlock mc; // 재생할 모션 클립

	public MotionClipPlayer(Robot robot)
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
		
		if(mc != null) mc.setFrame(frame); // 모션 클립의 프레임을 설정한다.
		return frame;
	}

	// 모션 클립을 설정한다.
	@Override
	public void setClip(ClipBlock clip)
	{
		mc = (MotionClipBlock)clip;
		
		// 실제 모션 클립을 얻는다.
		MotionClip motionClip = mc.getMotionClip();
		
		ContentsManager.notifyMotionClipChanged(motionClip);
		ContentsManager.setFirstMotionClip(false);
		
		// 끝 프레임을 설정한다.
		int total = motionClip.getTotalFrames();
		if(mc.getStopFrame() == -1 || total < mc.getStopFrame())
			totalFrames = total;
		else 
			totalFrames = mc.getStopFrame();
		
		// 시작 프레임을 설정한다.
		int start = mc.getStartFrame();
		if(start > 0 || totalFrames > start)
			currentFrame = mc.getStartFrame();
		
		channels = new ArrayList<ChannelTrack>();
		for(ControlTrack control : motionClip.getControls())
		{
			channels.addAll(control.getChannels());
		}
		// 각 채널별로 시뮬레이크럼을 생성한다.
		for(ChannelTrack channel : channels)
			channel.createSimulacra();
		
		// 현재 프레임을 설정한다.
		mc.setFrame(currentFrame);
	}
}
