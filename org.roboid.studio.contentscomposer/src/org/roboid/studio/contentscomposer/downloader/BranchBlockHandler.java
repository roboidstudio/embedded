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

import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.BranchBlock;
import org.roboid.studio.contentscomposer.ScriptType;

/**
 * @author Kwang-Hyun Park
 */
final class BranchBlockHandler extends SelectionBlockHandler
{
	BranchBlockHandler(Context context, String prefix, BlockElement block)
	{
		super(context, prefix, "Branch", block);
	}
	
	@Override
	void createFunctionCode(Context context, StringBuilder sb)
	{
		BranchBlock block = (BranchBlock)getBlock();
		
		sb.append("void ");
		sb.append(getFunctionName());
		sb.append("() {\n");
		
		AbstractBlockHandler yesHandler = context.findBlockHandler(getYesBlock());
		AbstractBlockHandler noHandler = context.findBlockHandler(getNoBlock());
		
		if(block.getScriptType() == ScriptType.NONE)
		{
			int deviceIndex = block.getDevice();
			int dataIndex = block.getIndex();
			if(deviceIndex == 0)
			{
				sb.append("\tif(value ");
			}
			else
			{
				sb.append("\tif(");
				sb.append(context.getDeviceCode(deviceIndex - 1, dataIndex));
				sb.append(" ");
			}
			sb.append(block.getLogic().getLiteral());
			sb.append(" ");
			sb.append(block.getValue());
			sb.append(") {\n");
			if(yesHandler != null)
			{
				sb.append("\t\t");
				sb.append(yesHandler.getFunctionName());
				sb.append("();\n");
			}
			sb.append("\t}\n\telse {\n");
			if(noHandler != null)
			{
				sb.append("\t\t");
				sb.append(noHandler.getFunctionName());
				sb.append("();\n");
			}
			sb.append("\t}\n");
		}
		else
		{
			String code = block.getScriptCode();
			if(code.length() > 0)
			{
				sb.append("\tif(");
				sb.append(code);
				sb.append(") {\n");
				if(yesHandler != null)
				{
					sb.append("\t\t");
					sb.append(yesHandler.getFunctionName());
					sb.append("();\n");
				}
				sb.append("\t}\n\telse {\n");
				if(noHandler != null)
				{
					sb.append("\t\t");
					sb.append(noHandler.getFunctionName());
					sb.append("();\n");
				}
				sb.append("\t}\n");
			}
		}
		sb.append("}\n");
	}
}
