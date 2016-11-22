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
	
	protected Robot robot; // �κ�
	protected AbstractClipPlayer clipPlayer; // Ŭ�� �÷��̾�
	protected BlockElement currentBlock;
	protected int currentFrame; // Ŭ�� ��� �������� ���� ������
	
	public AbstractClipPlayer(Robot robot)
	{
		this.robot = robot;
	}
	
	/**
	 * set initial content and prepare for playing
	 * @param mcc
	 */
	// ����� ���� �غ� �Ѵ�.
	public void setContent(MotionContent diagram)
	{
		diagram.reset(); // ���� ������ �ʱ�ȭ�Ѵ�.
		currentBlock = getRoot(diagram); // Root ��带 ��´�.
//		((Root)node).executeScript(); // getNextNode���� ��ũ��Ʈ �����ϹǷ� �ʿ� ����
		currentBlock = setNextPlayer(currentBlock); // ���� ��带 ��´�.
	}
	
	// Ŭ�� �������� ���� �������� ��´�.
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	
	/**
	 * set clip and play it depending on clip type
	 * @param clip
	 */
	abstract public void setClip(ClipBlock clip); // ����� Ŭ���� �����Ѵ�.

	/**
	 * execute one frame to make simulacrum of each player
	 * when frame = -1, indicates end-of-frame
	 * @return frame
	 */	
	abstract protected int execute(); // �� ������ ����

	// Root ��带 ��´�.
	private RootBlock getRoot(MotionContent diagram)
	{
		// ��� �߿��� Root�� ã�´�.
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
	// �� ������ ���� ���
	public int play()
	{
		// ���� ��尡 Ŭ���̸�
		if(currentBlock instanceof ClipBlock) 
		{
//			clip.setFrame(currentFrame);
//			System.out.println("current: " + currentFrame);
			
			// Ʈ���� ����Ʈ�� ��´�.
			List<TriggerBlock> triggers = new ArrayList<TriggerBlock>();
			for(Association association : currentBlock.getOutgoings())
			{
				BlockElement target = association.getTarget();
				if(target instanceof TriggerBlock) triggers.add((TriggerBlock)target);
			}
			
			// Ʈ���� ������ �˻��Ѵ�.
			for(TriggerBlock trigger : triggers)
			{
				if(trigger.checkCondition()) // ������ �����ϸ� ������ ���߰� ���� ���´�. 
				{
					setBlockPlaying(currentBlock, false); // ���� �� ǥ�ø� �����Ѵ�.
					
					robot.getProtocol().clearBuffer(); // ���۸� �ʱ�ȭ�Ѵ�.
					currentBlock = setNextPlayer(trigger); // ���� ��带 ��´�.
					if(currentBlock == null) return -1; // ���� ��尡 ������ -1 ��ȯ�Ͽ� ������ Ŭ�� ����� �����Ѵ�.
					return 0;
				}
			}
		}
		
		int frame = execute(); // �� �������� �����Ѵ�.
//		System.out.println("cu: " + currentFrame);
		currentFrame ++;
		return frame;
	}
	
	/**
	 * ������ ����� Ŭ���� �����Ѵ�. ���� ���� ��尡 Ŭ���� �ƴϸ� ������ ����
	 * Ŭ���� ������ ���� ��� recursive call�� �Ѵ�.
	 * @param block
	 */
	protected BlockElement setNextPlayer(BlockElement block)
	{
		while(block != null)
		{
			setBlockPlaying(block, false); // ���� �� ǥ�ø� �����Ѵ�.
			
			block = block.getNextBlock(); // ���� ��带 ��´�. �͹̳������� ���� ���� null�̴�.
			
			if(block == null) return null;
//			{
//				Terminator terminator = (Terminator)node;
//				if(terminator.getScriptType() == 0) return null;
//				terminator.executeScript(); // getNextNode���� ��ũ��Ʈ�� �����ϹǷ� �ʿ� ����
//				return null;
//			}

			// ���� ��忡 ���� Ŭ�� �÷��̾ �����Ѵ�.
			// Ŭ���� ���
			if(block instanceof ClipBlock)
			{
				currentFrame = 0; // Ŭ�� �������� ���� �������� �ʱ�ȭ�Ѵ�.
				
				// ���� ������ �ʱ�ȭ�Ѵ�.
				((ClipBlock)block).reset();
				((ClipBlock)block).resetTriggers();

				// ��� Ŭ���� ���
				if(block instanceof MotionClipBlock)
				{
					clipPlayer = new MotionClipPlayer(robot);
					clipPlayer.setClip((MotionClipBlock)block);
				}
				// ��� Ŭ���� ���纻�� ���
				else if(block instanceof MotionClipCloneBlock)
				{
					clipPlayer = new CloneClipPlayer(robot);
					clipPlayer.setClip((MotionClipCloneBlock)block);
				}
				// ������ Ŭ���� ���
				else if(block instanceof MotionContentBlock)
				{
					clipPlayer = new ContentClipPlayer(robot);
					clipPlayer.setClip((MotionContentBlock)block);
				}
				// ������ Ŭ���� ���纻�� ���
				else if(block instanceof MotionContentCloneBlock)
				{
					clipPlayer = new CloneContentPlayer(robot);
					clipPlayer.setClip((MotionContentCloneBlock)block);
				}
				// Wait Ŭ���� ���
				else if(block instanceof WaitClipBlock)
				{
					clipPlayer = new WaitClipPlayer(robot);
					clipPlayer.setClip((WaitClipBlock)block);
				}
				
				setBlockPlaying(block, true); // ���� ������ ǥ���Ѵ�.
				return block;
			}	
			
			/**
			 * when the block is fork, create subPlayer for playing sub stream
			 */
			// ��ũ�� ���
			else if(block instanceof ForkBlock)
			{
				clipPlayer = new ForkPlayer(robot);
				((ForkPlayer)clipPlayer).setFork((ForkBlock)block);
				return block.getNextBlock();
			}
		}
		return null;
	}
	
	// ��� ������ ǥ���Ѵ�.
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
