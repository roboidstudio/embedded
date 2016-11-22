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

	// 한 프레임을 실행한다.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // 클립 내에서의 현재 프레임
		if(clipPlayer == null) return frame; // 터미네이터까지 실행했다.
		if(clipPlayer.play() == -1) // 끝까지 실행했다.
		{
			currentBlock = setNextPlayer(currentBlock); // 다음 노드를 얻는다.
			if(currentBlock == null) return -1; // 끝까지 실행했다.
		}
		if(ccc != null) ccc.setFrame(frame); // 콘텐츠 클립 복사본의 프레임을 설정한다.
		return frame;
	}

	// 콘텐츠 클립의 복사본을 설정한다.
	@Override
	public void setClip(ClipBlock clip)
	{
		ccc = (MotionContentCloneBlock)clip;
		
		// 원본 콘텐츠 클립을 얻는다.
		MotionContentBlock original = ccc.getOriginal();
		// 자바 스크립트 엔진을 얻는다.
		ScriptEngine engine = original.getParent().getScriptEngine();
		// 실제 콘텐츠 클립을 얻는다.
		MotionContent diagram = original.getContent();
		// Robot과 스크립트 엔진을 설정한다.
		diagram.setRobot(robot);
		diagram.setScriptEngine(engine);
		// 콘텐츠 클립의 재생을 시작한다.
		setContent(diagram);
	}
}
