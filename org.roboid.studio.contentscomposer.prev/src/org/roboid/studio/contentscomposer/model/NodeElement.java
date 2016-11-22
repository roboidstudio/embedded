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

import java.util.ArrayList;
import java.util.List;

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ScriptType;

/**
 * @author Kwang-Hyun Park
 */
abstract class NodeElement extends AbstractModel
{
	private static final long serialVersionUID = 1L;
	private MotionDiagram parentDiagram; // 부모 다이어그램
	private List<Association> incomings = new ArrayList<Association>();
	private List<Association> outgoings = new ArrayList<Association>();
	private int x, y; // 노드 위치
	protected int scriptType; // 스크립트 타입
	protected String scriptName; // 스크립트 제목
	private String scriptCode; // 스크립트 코드

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getScriptType()
	{
		return scriptType;
	}
	
	public String getScriptName()
	{
		if(scriptName == null) scriptName = "";
		return scriptName;
	}
	
	public String getScriptCode()
	{
		if(scriptCode == null) scriptCode = "";
		return scriptCode;
	}

	public List<Association> getIncomings()
	{
		return incomings;
	}

	public List<Association> getOutgoings()
	{
		return outgoings;
	}

	public MotionDiagram getParentDiagram()
	{
		return parentDiagram;
	}

	public abstract org.roboid.studio.contentscomposer.BlockElement toVersion1_4(org.roboid.studio.contentscomposer.MotionContent parent, Robot robot);
	
	public void copyTo(org.roboid.studio.contentscomposer.BlockElement newNode)
	{
		newNode.setX(x);
		newNode.setY(y);
		newNode.setScriptType(ScriptType.get(scriptType));
		newNode.setScriptName(scriptName);
		newNode.setScriptCode(scriptCode);
	}
}
