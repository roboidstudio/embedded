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
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * @author Kwang-Hyun Park
 */
final class WaitClipBlockHandler extends AbstractBlockHandler
{
	WaitClipBlockHandler(Context context, String prefix, BlockElement block)
	{
		super(context, prefix, "WaitClip", block);
	}
	
	@Override
	void createFunctionCode(Context context, StringBuilder sb)
	{
		WaitClipBlock block = (WaitClipBlock)getBlock();
		
		sb.append("void ");
		sb.append(getFunctionName());
		sb.append("() {\n");
		
		if(block.getScriptType() == ScriptType.NONE)
		{
			float timeout = block.getTimeout();
			if(timeout < 0)
				sb.append("\twhile(1) {\n\t}\n");
			else
			{
				sb.append("\tdelay(");
				sb.append((int)(timeout * 1000));
				sb.append(");\n");
			}
		}
		else
			createScriptCode(context, sb);
		
		createNextHandlerCode(context, sb);
		sb.append("}\n");
	}
}
