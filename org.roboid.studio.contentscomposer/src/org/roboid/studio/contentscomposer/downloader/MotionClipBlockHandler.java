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
import org.roboid.studio.contentscomposer.MotionClipBlock;

/**
 * @author Kwang-Hyun Park
 */
final class MotionClipBlockHandler extends AbstractBlockHandler
{
	MotionClipBlockHandler(Context context, String prefix, BlockElement block)
	{
		super(context, prefix, "MotionClip", block);
	}
	
	@Override
	void createPrototypeCode(Context context, StringBuilder sb)
	{
		sb.append("void do");
		sb.append(getName());
		sb.append("();\n");
		sb.append("void ");
		sb.append(getFunctionName());
		sb.append("();\n");
	}

	@Override
	void createFunctionCode(Context context, StringBuilder sb)
	{
		MotionClipBlock block = (MotionClipBlock)getBlock();
		String doFunctionName = "do" + getName();
		context.generateOutputs(block.getMotionClip(), doFunctionName, sb);
		
		sb.append("void ");
		sb.append(getFunctionName());
		sb.append("() {\n\t");
		sb.append(doFunctionName);
		sb.append("(");
		sb.append(block.getStartFrame());
		sb.append(", ");
		sb.append(block.getStopFrame());
		sb.append(");\n");
		createNextHandlerCode(context, sb);
		sb.append("}\n");
	}
}
