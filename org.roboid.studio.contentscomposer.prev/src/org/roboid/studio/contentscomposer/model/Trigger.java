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

package org.roboid.studio.contentscomposer.model;

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;

/**
 * @author Kwang-Hyun Park
 */
public class Trigger extends LogicElement
{
	private static final long serialVersionUID = 1L;

	public org.roboid.studio.contentscomposer.TriggerBlock toVersion1_4(org.roboid.studio.contentscomposer.MotionContent parent, Robot robot)
	{
		org.roboid.studio.contentscomposer.TriggerBlock newNode = ContentsComposerFactory.eINSTANCE.createTriggerBlock();
		copyTo(newNode);
		return newNode;
	}
}
