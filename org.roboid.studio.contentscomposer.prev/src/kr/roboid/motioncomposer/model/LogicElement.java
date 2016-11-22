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

import org.roboid.studio.contentscomposer.LogicType;
import org.roboid.studio.contentscomposer.ScriptType;

/**
 * @author Kwang-Hyun Park
 */
abstract class LogicElement extends NodeElement
{
	private static final long serialVersionUID = 1L;
	int device;
	int logic;
	int location;
	double value = 1;
	String type;
	String name;
	
	@Override
	public void copyTo(org.roboid.studio.contentscomposer.BlockElement newNode)
	{
		super.copyTo(newNode);
		if(type == null || type.equals("0")) newNode.setScriptType(ScriptType.NONE);
		else newNode.setScriptType(ScriptType.ROBOID_SCRIPT);
		newNode.setScriptName(name);
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setDevice(device);
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setLogic(LogicType.get(logic));
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setIndex(location);
		((org.roboid.studio.contentscomposer.LogicBlock)newNode).setValue((float)value);
	}
}
