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
	private Protocol protocol; // ��������
	
	private volatile boolean PLAY; // ���� ��
	private MotionContent content; // ������ Ŭ��
	private AbstractClipPlayer clipPlayer; // Ŭ�� �÷��̾�
	
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

		// Ȱ��ȭ�� �κ��̵� ����Ʈ�� ��� �κ��̵� ������Ʈ�� �ֵ�� ������Ʈ�� activate��Ų��.
		ContentsManager.activate();
		
		PLAY = true;
		new LinkToRoboid(clipPlayer).start();
	}
	
	// ����Ʈ ������ �����Ѵ�.
	public void stop()
	{
		PLAY = false;
		
		// Ȱ��ȭ�� �κ��̵� ����Ʈ�� ��� �κ��̵� ������Ʈ�� �ֵ�� ������Ʈ�� deactivate��Ų��.
		ContentsManager.deactivate();

		// ���� ����� ���� ���� ������ �ʱ�ȭ�Ѵ�.
		content.reset();
		
		// ���̾�׷��� ������ �˻��Ѵ�.
		if(Display.getDefault().isDisposed()) return;
		Display.getDefault().syncExec(new Runnable()
		{
			public void run()
			{
				content.validate();
			}
		});
	}
	
	// ���� ������ ���´�.
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
					
					// �� �κ��̵��� �ùķ���ũ���� �����ϰ� �κ��̵� ������Ʈ�� �ֵ�� ������Ʈ�� execute()�� ȣ���Ѵ�.
					ContentsManager.execute();
					
					if(stop) Player.this.stop(); // �͹̳����� ������ ���� ������ �����Ѵ�.
				}
				
				try 
				{
					Thread.sleep(10);
				} catch (InterruptedException e){}
			}
		}
	}
}
