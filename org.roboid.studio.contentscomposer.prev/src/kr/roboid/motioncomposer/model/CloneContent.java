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

package kr.roboid.motioncomposer.model;

import java.util.List;

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;

/**
 * @author Kwang-Hyun Park
 */
class CloneContent extends AbstractClip
{
	private static final long serialVersionUID = 1L;
	private ContentClip mcc;
	
	private transient org.roboid.studio.contentscomposer.MotionContentCloneBlock newNode;
	
	public org.roboid.studio.contentscomposer.MotionContentCloneBlock toVersion1_4(org.roboid.studio.contentscomposer.MotionContent content, Robot robot)
	{
		org.roboid.studio.contentscomposer.MotionContentCloneBlock newNode = ContentsComposerFactory.eINSTANCE.createMotionContentCloneBlock();
		copyTo(newNode);
		this.newNode = newNode;
		return newNode;
	}
	
	public void setOriginal(org.roboid.studio.contentscomposer.MotionContent content)
	{
		int index = getDiagram().getContentClips().indexOf(mcc);
		List<org.roboid.studio.contentscomposer.MotionContentBlock> nodes = content.getMotionContentBlocks();
		if(index >= 0 && index < nodes.size())
			newNode.setOriginal(nodes.get(index));
	}
}
