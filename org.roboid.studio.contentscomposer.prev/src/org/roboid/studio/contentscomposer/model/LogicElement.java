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

import org.roboid.studio.contentscomposer.LogicType;

/**
 * @author Kwang-Hyun Park
 */
abstract class LogicElement extends NodeElement
{
	private static final long serialVersionUID = 1L;
	private int device; // 디바이스
	private int logic; // 논리 연산
	private int location; // 디바이스의 데이터 인덱스
	private double value = 1; // 비교값
	
	@Override
	public void copyTo(org.roboid.studio.contentscomposer.BlockElement newNode)
	{
		super.copyTo(newNode);
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setDevice(device);
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setLogic(LogicType.get(logic));
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setIndex(location);
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setValue((float)value);
	}
}
