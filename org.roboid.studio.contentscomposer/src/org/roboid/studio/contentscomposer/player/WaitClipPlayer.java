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

	// �� �������� �����Ѵ�.
	@Override
	public int execute()
	{
		int frame = getCurrentFrame(); // Ŭ�� �������� ���� ������
//		if(frame > maxFrames) return -1;
//		if(wc != null) wc.setFrame(frame);
		if(wc == null) return frame; // Wait Ŭ���� ����.
		
		wc.setFrame(frame); // Wait Ŭ���� �������� �����Ѵ�.
		if(wc.checkTimeout(frame)) return -1; // Ÿ�Ӿƿ��� �˻��Ѵ�.
		return frame;
	}

	// Wait Ŭ���� �����Ѵ�.
	@Override
	public void setClip(ClipBlock clip)
	{
		wc = (WaitClipBlock)clip;
		
		// WaitClip ������ ó���ϹǷ� �Ʒ��� �ʿ����
//		// Ÿ�Ӿƿ��� ��´�.
//		double timeout = wc.getTimeout();
//		int maxFrames;
//		if(timeout == -1) maxFrames = Integer.MAX_VALUE; // Ÿ�Ӿƿ��� ���Ѵ��̸�
//		else maxFrames = (int)(timeout * 50);
	}
}
