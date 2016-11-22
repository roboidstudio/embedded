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
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ContentClipPlayer extends AbstractClipPlayer
{
//	private Robot robot;
	private MotionContentBlock cc;
	
	public ContentClipPlayer(Robot robot)
	{
		super(robot);
//		this.robot = robot;
	}

	// �� �������� �����Ѵ�.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // Ŭ�� �������� ���� ������
		if(clipPlayer == null) return -1; // �͹̳����ͱ��� �����ߴ�.
		if(clipPlayer.play() == -1) // ������ �����ߴ�.
		{
			currentBlock = setNextPlayer(currentBlock); // ���� ��带 ��´�.
			if(currentBlock == null) return -1; // ������ �����ߴ�.
		}
		if(cc != null) cc.setFrame(frame); // ������ Ŭ���� �������� �����Ѵ�.
		return frame;
	}

	// ������ Ŭ���� �����Ѵ�.
	@Override
	public void setClip(ClipBlock clip)
	{
		cc = (MotionContentBlock)clip;
		
		// �ڹ� ��ũ��Ʈ ������ ��´�.
		ScriptEngine engine = cc.getParent().getScriptEngine();
		// ���� ������ Ŭ���� ��´�.
		MotionContent diagram = cc.getContent();
		// Robot�� ��ũ��Ʈ ������ �����Ѵ�.
		diagram.setRobot(robot);
		diagram.setScriptEngine(engine);
		// ������ Ŭ���� ����� �����Ѵ�.
		setContent(diagram);
	}
}
