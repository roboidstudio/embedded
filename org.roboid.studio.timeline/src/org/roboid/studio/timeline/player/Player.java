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

import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IPlayer;
import org.roboid.robot.Protocol;
import org.roboid.robot.Robot;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineGuide;
import org.roboid.studio.timeline.TimelineRuler;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class Player implements IPlayer
{
	private Robot robot;
	private Protocol protocol; // 프로토콜
	private TimelineRuler ruler; // 룰러
	
	private volatile boolean PLAY; // 실행 중
	private MotionClip motionClip;
	private volatile int startFrame; // 시작 프레임
	private volatile int stopFrame; // 끝 프레임
	
	public Player(MotionClip motionClip)
	{
		this.motionClip = motionClip;
		robot = motionClip.getRobot();
		if(robot != null) robot.clearDeviceMemory();
		protocol = robot.getProtocol();
		if(protocol != null) protocol.clearBuffer();
		stopFrame = motionClip.getFrameLimit();
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
	
	// 모션 클립을 실행한다.
	public void play()
	{
		if(PLAY) return; // 이미 실행하고 있다.

		// 활성화된 로보이드 리스트를 얻어 로보이드 컴포넌트와 애드온 컴포넌트를 activate시킨다.
		ContentsManager.activate();
		
		// 시뮬레이크럼을 생성한다.
		for(ControlTrack control : motionClip.getControls())
		{
			for(ChannelTrack channel : control.getChannels())
				channel.createSimulacra();
		}
		
		// 쓰레드를 만들고 모션 클립을 설정한 후 쓰레드를 실행한다.
		PLAY = true;
		new LinkToRoboid(motionClip, startFrame, stopFrame).start();
	}
	
	// 모션 클립의 실행을 중지한다.
	public void stop()
	{
		PLAY = false;

		// 활성화된 로보이드 리스트를 얻어 로보이드 컴포넌트와 애드온 컴포넌트를 deactivate시킨다.
		ContentsManager.deactivate();
	}
	
	public boolean isPlaying()
	{
		return PLAY;
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
	
	/*
	 * Inner Thread
	 * Link To roboid
	 */
	class LinkToRoboid extends Thread
	{
		private MotionClip motionClip;
		private int startFrame;
		private int stopFrame;
		
		LinkToRoboid(MotionClip motionClip, int startFrame, int stopFrame)
		{
			this.motionClip = motionClip;
			this.startFrame = startFrame;
			this.stopFrame = stopFrame;
		}
		
		public void run()
		{
			if(protocol == null) return;
			
			int frame = startFrame; // 시작 프레임
			while(PLAY)
			{
				if(ContentsManager.isReady() && protocol.getRemainingBuffer() >= protocol.getBufferSize())
				{
					// 채널별로 한 프레임의 데이터를 디바이스에 쓴다.
					for(ControlTrack control : motionClip.getControls())
					{
						for(ChannelTrack channel : control.getChannels())
							channel.dump(frame);
					}
					
					// 각 로보이드의 시뮬레이크럼을 갱신하고 로보이드 컴포넌트와 애드온 컴포넌트의 execute()를 호출한다.
					ContentsManager.execute();

					frame ++; // 프레임 증가
					if(frame > stopFrame) Player.this.stop(); // 끝 프레임까지 실행하면 실행을 종료한다.
				}
				
				try 
				{
					Thread.sleep(10);
				} catch (InterruptedException e){}
			}
		}
	}
}
