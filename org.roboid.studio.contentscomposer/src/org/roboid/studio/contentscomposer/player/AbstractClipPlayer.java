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

import org.eclipse.swt.widgets.Display;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.ForkBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.TriggerBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
abstract public class AbstractClipPlayer
{
	public final Display display = Display.getCurrent();
	
	protected Robot robot; // 로봇
	protected AbstractClipPlayer clipPlayer; // 클립 플레이어
	protected BlockElement currentBlock;
	protected int currentFrame; // 클립 노드 내에서의 현재 프레임
	
	public AbstractClipPlayer(Robot robot)
	{
		this.robot = robot;
	}
	
	/**
	 * set initial content and prepare for playing
	 * @param mcc
	 */
	// 재생을 위한 준비를 한다.
	public void setContent(MotionContent diagram)
	{
		diagram.reset(); // 내부 변수를 초기화한다.
		currentBlock = getRoot(diagram); // Root 노드를 얻는다.
//		((Root)node).executeScript(); // getNextNode에서 스크립트 실행하므로 필요 없음
		currentBlock = setNextPlayer(currentBlock); // 다음 노드를 얻는다.
	}
	
	// 클립 내에서의 현재 프레임을 얻는다.
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	
	/**
	 * set clip and play it depending on clip type
	 * @param clip
	 */
	abstract public void setClip(ClipBlock clip); // 재생할 클립을 설정한다.

	/**
	 * execute one frame to make simulacrum of each player
	 * when frame = -1, indicates end-of-frame
	 * @return frame
	 */	
	abstract protected int execute(); // 한 프레임 실행

	// Root 노드를 얻는다.
	private RootBlock getRoot(MotionContent diagram)
	{
		// 노드 중에서 Root를 찾는다.
		for(BlockElement block : diagram.getBlocks())
		{
			if(block instanceof RootBlock) return (RootBlock)block;
		}
		return null;
	}
	
	/**
	 * play content and check triggering condition at every frame
	 * @return
	 */
	// 매 프레임 마다 재생
	public int play()
	{
		// 현재 노드가 클립이면
		if(currentBlock instanceof ClipBlock) 
		{
//			clip.setFrame(currentFrame);
//			System.out.println("current: " + currentFrame);
			
			// 트리거 리스트를 얻는다.
			List<TriggerBlock> triggers = new ArrayList<TriggerBlock>();
			for(Association association : currentBlock.getOutgoings())
			{
				BlockElement target = association.getTarget();
				if(target instanceof TriggerBlock) triggers.add((TriggerBlock)target);
			}
			
			// 트리거 조건을 검사한다.
			for(TriggerBlock trigger : triggers)
			{
				if(trigger.checkCondition()) // 조건을 만족하면 실행을 멈추고 빠져 나온다. 
				{
					setBlockPlaying(currentBlock, false); // 실행 중 표시를 해제한다.
					
					robot.getProtocol().clearBuffer(); // 버퍼를 초기화한다.
					currentBlock = setNextPlayer(trigger); // 다음 노드를 얻는다.
					if(currentBlock == null) return -1; // 다음 노드가 없으면 -1 반환하여 콘텐츠 클립 재생을 중지한다.
					return 0;
				}
			}
		}
		
		int frame = execute(); // 한 프레임을 실행한다.
//		System.out.println("cu: " + currentFrame);
		currentFrame ++;
		return frame;
	}
	
	/**
	 * 다음에 재생할 클립을 선택한다. 만약 다음 노드가 클립이 아니면 로직에 따라
	 * 클립을 만날때 까지 계속 recursive call을 한다.
	 * @param block
	 */
	protected BlockElement setNextPlayer(BlockElement block)
	{
		while(block != null)
		{
			setBlockPlaying(block, false); // 실행 중 표시를 해제한다.
			
			block = block.getNextBlock(); // 다음 노드를 얻는다. 터미네이터의 다음 노드는 null이다.
			
			if(block == null) return null;
//			{
//				Terminator terminator = (Terminator)node;
//				if(terminator.getScriptType() == 0) return null;
//				terminator.executeScript(); // getNextNode에서 스크립트를 실행하므로 필요 없음
//				return null;
//			}

			// 다음 노드에 따라 클립 플레이어를 선택한다.
			// 클립인 경우
			if(block instanceof ClipBlock)
			{
				currentFrame = 0; // 클립 내에서의 현재 프레임을 초기화한다.
				
				// 내부 변수를 초기화한다.
				((ClipBlock)block).reset();
				((ClipBlock)block).resetTriggers();

				// 모션 클립의 경우
				if(block instanceof MotionClipBlock)
				{
					clipPlayer = new MotionClipPlayer(robot);
					clipPlayer.setClip((MotionClipBlock)block);
				}
				// 모션 클립의 복사본인 경우
				else if(block instanceof MotionClipCloneBlock)
				{
					clipPlayer = new CloneClipPlayer(robot);
					clipPlayer.setClip((MotionClipCloneBlock)block);
				}
				// 콘텐츠 클립인 경우
				else if(block instanceof MotionContentBlock)
				{
					clipPlayer = new ContentClipPlayer(robot);
					clipPlayer.setClip((MotionContentBlock)block);
				}
				// 콘텐츠 클립의 복사본인 경우
				else if(block instanceof MotionContentCloneBlock)
				{
					clipPlayer = new CloneContentPlayer(robot);
					clipPlayer.setClip((MotionContentCloneBlock)block);
				}
				// Wait 클립인 경우
				else if(block instanceof WaitClipBlock)
				{
					clipPlayer = new WaitClipPlayer(robot);
					clipPlayer.setClip((WaitClipBlock)block);
				}
				
				setBlockPlaying(block, true); // 실행 중으로 표시한다.
				return block;
			}	
			
			/**
			 * when the block is fork, create subPlayer for playing sub stream
			 */
			// 포크인 경우
			else if(block instanceof ForkBlock)
			{
				clipPlayer = new ForkPlayer(robot);
				((ForkPlayer)clipPlayer).setFork((ForkBlock)block);
				return block.getNextBlock();
			}
		}
		return null;
	}
	
	// 재생 중임을 표시한다.
	protected void setBlockPlaying(final BlockElement block, final boolean on)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			public void run()
			{
				block.setPlaying(on);
			}
		});
	}
}
