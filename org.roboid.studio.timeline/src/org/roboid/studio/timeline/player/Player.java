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
	private Protocol protocol; // ��������
	private TimelineRuler ruler; // �귯
	
	private volatile boolean PLAY; // ���� ��
	private MotionClip motionClip;
	private volatile int startFrame; // ���� ������
	private volatile int stopFrame; // �� ������
	
	public Player(MotionClip motionClip)
	{
		this.motionClip = motionClip;
		robot = motionClip.getRobot();
		if(robot != null) robot.clearDeviceMemory();
		protocol = robot.getProtocol();
		if(protocol != null) protocol.clearBuffer();
		stopFrame = motionClip.getFrameLimit();
	}
	
	// �귯�� �����Ѵ�.
	public void setRuler(TimelineRuler ruler)
	{
		this.ruler = ruler;
		setPlayRange(); // ���� �����Ӱ� �� �������� �����Ѵ�.
	}
	
	// ���̵带 �����Ѵ�.
	public void setGuide(TimelineGuide guide)
	{
//		this.guide = guide;
	}
	
	// ��� Ŭ���� �����Ѵ�.
	public void play()
	{
		if(PLAY) return; // �̹� �����ϰ� �ִ�.

		// Ȱ��ȭ�� �κ��̵� ����Ʈ�� ��� �κ��̵� ������Ʈ�� �ֵ�� ������Ʈ�� activate��Ų��.
		ContentsManager.activate();
		
		// �ùķ���ũ���� �����Ѵ�.
		for(ControlTrack control : motionClip.getControls())
		{
			for(ChannelTrack channel : control.getChannels())
				channel.createSimulacra();
		}
		
		// �����带 ����� ��� Ŭ���� ������ �� �����带 �����Ѵ�.
		PLAY = true;
		new LinkToRoboid(motionClip, startFrame, stopFrame).start();
	}
	
	// ��� Ŭ���� ������ �����Ѵ�.
	public void stop()
	{
		PLAY = false;

		// Ȱ��ȭ�� �κ��̵� ����Ʈ�� ��� �κ��̵� ������Ʈ�� �ֵ�� ������Ʈ�� deactivate��Ų��.
		ContentsManager.deactivate();
	}
	
	public boolean isPlaying()
	{
		return PLAY;
	}
	
	// ���� �����Ӱ� �� �������� �����Ѵ�.
	private void setPlayRange()
	{
		List<TimelineGuide> guides = ruler.getGuides(); // ���̵带 ��´�.
		
		// ���̵尡 2���� ���۰� ���� ǥ���� ����̴�.
		if(guides.size() == 2)
		{
			int g1 = guides.get(0).getPosition(); // ù��° ���̵��� ��ġ
			int g2 = guides.get(1).getPosition(); // �ι�° ���̵��� ��ġ
			// ���� �����Ӱ� �� �������� �����Ѵ�.
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
		// ���̵尡 1���̸� ���� �����Ӹ� ǥ���� ����̴�.
		else if(guides.size() == 1)
		{
			startFrame = guides.get(0).getPosition(); // ���� �������� �����Ѵ�.
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
			
			int frame = startFrame; // ���� ������
			while(PLAY)
			{
				if(ContentsManager.isReady() && protocol.getRemainingBuffer() >= protocol.getBufferSize())
				{
					// ä�κ��� �� �������� �����͸� ����̽��� ����.
					for(ControlTrack control : motionClip.getControls())
					{
						for(ChannelTrack channel : control.getChannels())
							channel.dump(frame);
					}
					
					// �� �κ��̵��� �ùķ���ũ���� �����ϰ� �κ��̵� ������Ʈ�� �ֵ�� ������Ʈ�� execute()�� ȣ���Ѵ�.
					ContentsManager.execute();

					frame ++; // ������ ����
					if(frame > stopFrame) Player.this.stop(); // �� �����ӱ��� �����ϸ� ������ �����Ѵ�.
				}
				
				try 
				{
					Thread.sleep(10);
				} catch (InterruptedException e){}
			}
		}
	}
}
