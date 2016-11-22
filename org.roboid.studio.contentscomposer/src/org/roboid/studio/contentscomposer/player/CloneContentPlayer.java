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

import javax.script.ScriptEngine;

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class CloneContentPlayer extends ContentClipPlayer
{
//	private Robot robot;
	private MotionContentCloneBlock ccc;

	public CloneContentPlayer(Robot robot)
	{
		super(robot);
//		this.robot = robot;
	}

	// �� �������� �����Ѵ�.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // Ŭ�� �������� ���� ������
		if(clipPlayer == null) return frame; // �͹̳����ͱ��� �����ߴ�.
		if(clipPlayer.play() == -1) // ������ �����ߴ�.
		{
			currentBlock = setNextPlayer(currentBlock); // ���� ��带 ��´�.
			if(currentBlock == null) return -1; // ������ �����ߴ�.
		}
		if(ccc != null) ccc.setFrame(frame); // ������ Ŭ�� ���纻�� �������� �����Ѵ�.
		return frame;
	}

	// ������ Ŭ���� ���纻�� �����Ѵ�.
	@Override
	public void setClip(ClipBlock clip)
	{
		ccc = (MotionContentCloneBlock)clip;
		
		// ���� ������ Ŭ���� ��´�.
		MotionContentBlock original = ccc.getOriginal();
		// �ڹ� ��ũ��Ʈ ������ ��´�.
		ScriptEngine engine = original.getParent().getScriptEngine();
		// ���� ������ Ŭ���� ��´�.
		MotionContent diagram = original.getContent();
		// Robot�� ��ũ��Ʈ ������ �����Ѵ�.
		diagram.setRobot(robot);
		diagram.setScriptEngine(engine);
		// ������ Ŭ���� ����� �����Ѵ�.
		setContent(diagram);
	}
}
