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

package org.roboid.studio.contentscomposer.downloader;

import java.util.List;

import org.roboid.studio.contentscomposer.AdderBlock;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;

/**
 * @author Kwang-Hyun Park
 */
abstract class AbstractBlockHandler
{
	private final int index;
	private final String name;
	private final String functionName;
	private final BlockElement block;
	
	AbstractBlockHandler(Context context, String prefix, String name, BlockElement block)
	{
		index = context.getNextIndex();
		this.name = prefix + name + index;
		this.functionName = "run" + this.name;
		this.block = block;
	}
	
	int getIndex()
	{
		return index;
	}
	
	String getName()
	{
		return name;
	}
	
	String getFunctionName()
	{
		return functionName;
	}
	
	BlockElement getBlock()
	{
		return block;
	}
	
	BlockElement getNextBlock()
	{
		BlockElement nextBlock = null;
		List<Association> outgoings = block.getOutgoings();
		if(outgoings.size() > 0)
		{
			nextBlock = outgoings.get(0).getTarget();
			while(nextBlock instanceof AdderBlock)
				nextBlock = getNextBlock(nextBlock);
		}
		return nextBlock;
	}
	
	BlockElement getNextBlock(BlockElement block)
	{
		List<Association> outgoings = block.getOutgoings();
		if(outgoings.size() > 0)
			return outgoings.get(0).getTarget();
		return null;
	}
	
	void createPrototypeCode(Context context, StringBuilder sb)
	{
		sb.append("void ");
		sb.append(getFunctionName());
		sb.append("();\n");
	}
	
	abstract void createFunctionCode(Context context, StringBuilder sb);
	
	void createScriptCode(Context context, StringBuilder sb)
	{
		String code = block.getScriptCode();
		if(code.length() > 0)
		{
			code = code.replaceAll("\n", "\n\t");
			sb.append("\t");
			sb.append(code);
			sb.append("\n");
		}
	}
	
	void createNextHandlerCode(Context context, StringBuilder sb)
	{
		AbstractBlockHandler nextHandler = context.findBlockHandler(getNextBlock());
		if(nextHandler == null) return;
		
		sb.append("\t");
		sb.append(nextHandler.getFunctionName());
		sb.append("();\n");
	}
}
