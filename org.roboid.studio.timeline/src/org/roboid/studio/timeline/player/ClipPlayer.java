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

package org.roboid.studio.timeline.player;

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.roboid.core.runtime.IClipPlayer;
import org.roboid.core.runtime.ISystem;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineGuide;
import org.roboid.studio.timeline.TimelineRuler;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ClipPlayer implements IClipPlayer
{
	private TimelineRuler ruler;
	private MotionClip clip;
	private int startFrame;
	private int stopFrame;
	private int frame;
	
	public ClipPlayer(MotionClip clip)
	{
		this.clip = clip;
	}
	
	@Override
	public void activate(Shell shell, ISystem system)
	{
		if(clip == null) return;
		MotionClip mc = (MotionClip)clip;
		
		// 시뮬레이크럼을 생성한다.
		for(ControlTrack control : mc.getControls())
		{
			for(ChannelTrack channel : control.getChannels())
				channel.createSimulacra();
		}
		
		stopFrame = mc.getFrameLimit();
		frame = startFrame; // 시작 프레임
	}

	@Override
	public boolean execute()
	{
		if(clip == null) return false;
		
		// 채널별로 한 프레임의 데이터를 디바이스에 쓴다.
		for(ControlTrack control : clip.getControls())
		{
			for(ChannelTrack channel : control.getChannels())
				channel.dump(frame);
		}
		return (++frame <= stopFrame);
	}
	
	@Override
	public void deactivate()
	{
	}
	
	// 룰러를 설정한다.
	public void setRuler(TimelineRuler ruler)
	{
		this.ruler = ruler;
		setPlayRange(); // 시작 프레임과 끝 프레임을 설정한다.
	}
	
	// 가이드를 설정한다.
	public void setGuide(TimelineGuide guide)
	{
//		this.guide = guide;
	}
	
	// 시작 프레임과 끝 프레임을 설정한다.
	private void setPlayRange()
	{
		List<TimelineGuide> guides = ruler.getGuides(); // 가이드를 얻는다.
		
		// 가이드가 2개면 시작과 끝을 표시한 경우이다.
		if(guides.size() == 2)
		{
			int g1 = guides.get(0).getPosition(); // 첫번째 가이드의 위치
			int g2 = guides.get(1).getPosition(); // 두번째 가이드의 위치
			// 시작 프레임가 끝 프레임을 설정한다.
			if(g1 > g2)
			{
				startFrame = g2;
				stopFrame = g1;
			}else
			{
				startFrame = g1;
				stopFrame = g2;
			}
		}
		// 가이드가 1개이면 시작 프레임만 표시한 경우이다.
		else if(guides.size() == 1)
		{
			startFrame = guides.get(0).getPosition(); // 시작 프레임을 설정한다.
		}
	}
}
