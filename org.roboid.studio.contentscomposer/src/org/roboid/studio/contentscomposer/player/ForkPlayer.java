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

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.ForkBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ForkPlayer extends AbstractClipPlayer
{
//	private Robot robot;
	private ForkBlock fork;
	private List<AbstractClipPlayer> players = new ArrayList<AbstractClipPlayer>();
	
	public ForkPlayer(Robot robot)
	{
		super(robot);
//		this.robot = robot;
	}

	// 한 프레임을 실행한다.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // 클립 내에서의 현재 프레임
		// 모든 연결된 클립을 실행
		for(AbstractClipPlayer player : players)
		{
			if(player.play() == -1) // 끝까지 실행했다.
			{
				setChildrenOutline(false); // 모든 연결된 클립의 실행 중 표시를 해제한다.
				currentBlock = setNextPlayer(currentBlock); // 다음 노드를 얻는다.
				if(currentBlock == null) return -1; // 끝까지 실행했다.
			}
		}
		return frame;
	}

	// 연결된 클립의 리스트를 만든다.
	private void createPlayers()
	{
		for(int i = 0; i < fork.getOutgoings().size(); i ++) // 포크의 출력선
		{
			BlockElement content = fork.getOutgoings().get(i).getTarget(); // 다음 노드
			setBlockPlaying(content, true); // 재생 중으로 표시한다.
			
			AbstractClipPlayer player = null;
			// 모션 클립의 경우
			if(content instanceof MotionClipBlock)
			{
				player = new MotionClipPlayer(robot);
				player.setClip((MotionClipBlock)content);
			}
			// 모션 클립의 복사본인 경우
			else if(content instanceof MotionClipCloneBlock)
			{
				player = new CloneClipPlayer(robot);
				player.setClip((MotionClipCloneBlock)content);
			}
			// 콘텐츠 클립인 경우
			else if(content instanceof MotionContentBlock)
			{
				player = new ContentClipPlayer(robot);
				player.setClip((MotionContentBlock)content);
			}
			// 콘텐츠 클립의 복사본인 경우
			else if(content instanceof MotionContentCloneBlock)
			{
				player = new CloneContentPlayer(robot);
				player.setClip((MotionContentCloneBlock)content);
			}
			// Wait 클립인 경우
			else if(content instanceof WaitClipBlock)
			{
				player = new WaitClipPlayer(robot);
				player.setClip((WaitClipBlock)content);
			}
			
			players.add(player);
		}
	}

	@Override
	public void setClip(ClipBlock clip)
	{
	}

	public void setFork(ForkBlock fork)
	{
		this.fork = fork;
		createPlayers(); // 모든 연결된 다음 노드의 리스트를 만든다.
		setChildrenOutline(true); // 모두 재생 중으로 표시한다.
	}
	
	// 자식 노드를 재생 중으로 표시한다.
	private void setChildrenOutline(boolean on)
	{
		for(Association association : fork.getOutgoings())
		{
			BlockElement block = association.getTarget();
			setBlockPlaying(block, on); // 재생 중으로 표시한다.
		}
	}
}
