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

import org.eclipse.swt.widgets.Display;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IPlayer;
import org.roboid.robot.Protocol;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class Player implements IPlayer
{
	private Robot robot;
	private Protocol protocol; // 프로토콜
	
	private volatile boolean PLAY; // 실행 중
	private MotionContent content; // 콘텐츠 클립
	private AbstractClipPlayer clipPlayer; // 클립 플레이어
	
	public Player(MotionContent content)
	{
		ContentsManager.setFirstMotionClip(true);
		
		this.content = content;
		robot = content.getRobot();
		if(robot != null) robot.clearDeviceMemory();
		protocol = robot.getProtocol();
		if(protocol != null) protocol.clearBuffer();
		clipPlayer = new ContentClipPlayer(robot);
		clipPlayer.setContent(content);
	}
	
	public void play()
	{
		if(PLAY) return;

		// 활성화된 로보이드 리스트를 얻어 로보이드 컴포넌트와 애드온 컴포넌트를 activate시킨다.
		ContentsManager.activate();
		
		PLAY = true;
		new LinkToRoboid(clipPlayer).start();
	}
	
	// 콘텐트 실행을 중지한다.
	public void stop()
	{
		PLAY = false;
		
		// 활성화된 로보이드 리스트를 얻어 로보이드 컴포넌트와 애드온 컴포넌트를 deactivate시킨다.
		ContentsManager.deactivate();

		// 다음 재생을 위해 내부 변수를 초기화한다.
		content.reset();
		
		// 다이어그램의 로직을 검사한다.
		if(Display.getDefault().isDisposed()) return;
		Display.getDefault().syncExec(new Runnable()
		{
			public void run()
			{
				content.validate();
			}
		});
	}
	
	// 실행 중인지 묻는다.
	public boolean isPlaying()
	{
		return PLAY;
	}
	
	class LinkToRoboid extends Thread
	{
		private AbstractClipPlayer player;
		
		LinkToRoboid(AbstractClipPlayer player)
		{
			this.player = player;
		}
		
		public void run()
		{
			if(protocol == null) return;
			
			while(PLAY)
			{
				if(ContentsManager.isReady() && protocol.getRemainingBuffer()  >= protocol.getBufferSize())
				{
					boolean stop = false;
					if(player.play() == -1) stop = true;
					
					// 각 로보이드의 시뮬레이크럼을 갱신하고 로보이드 컴포넌트와 애드온 컴포넌트의 execute()를 호출한다.
					ContentsManager.execute();
					
					if(stop) Player.this.stop(); // 터미네이터 노드까지 가면 실행을 중지한다.
				}
				
				try 
				{
					Thread.sleep(10);
				} catch (InterruptedException e){}
			}
		}
	}
}
