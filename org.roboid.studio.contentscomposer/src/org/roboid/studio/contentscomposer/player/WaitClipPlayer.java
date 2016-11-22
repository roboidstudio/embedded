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

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class WaitClipPlayer extends AbstractClipPlayer
{
//	private int maxFrames;
	private WaitClipBlock wc;
	
	public WaitClipPlayer(Robot robot)
	{
		super(robot);
	}

	// 한 프레임을 실행한다.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // 클립 내에서의 현재 프레임
//		if(frame > maxFrames) return -1;
//		if(wc != null) wc.setFrame(frame);
		if(wc == null) return frame; // Wait 클립이 없다.
		
		wc.setFrame(frame); // Wait 클립의 프레임을 설정한다.
		if(wc.checkTimeout(frame)) return -1; // 타임아웃을 검사한다.
		return frame;
	}

	// Wait 클립을 설정한다.
	@Override
	public void setClip(ClipBlock clip)
	{
		wc = (WaitClipBlock)clip;
		
		// WaitClip 내에서 처리하므로 아래는 필요없음
//		// 타임아웃을 얻는다.
//		double timeout = wc.getTimeout();
//		int maxFrames;
//		if(timeout == -1) maxFrames = Integer.MAX_VALUE; // 타임아웃이 무한대이면
//		else maxFrames = (int)(timeout * 50);
	}
}
