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
import org.roboid.studio.contentscomposer.DiceBlock;
import org.roboid.studio.contentscomposer.LoopBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * @author Kwang-Hyun Park
 */
final class ContentsClipBlockHandler extends AbstractBlockHandler
{
	private final String prefix;
	
	ContentsClipBlockHandler(Context context, String prefix, BlockElement block)
	{
		super(context, prefix, "ContentsClip", block);
		
		this.prefix = prefix;
	}
	
	void createBlockHandlers(Context context, MotionContent clip)
	{
		for(BlockElement block : clip.getBlocks())
		{
			if(block instanceof RootBlock)
				context.addBlockHandler(block, new RootBlockHandler(context, prefix, block));
			else if(block instanceof WaitClipBlock)
				context.addBlockHandler(block, new WaitClipBlockHandler(context, prefix, block));
			else if(block instanceof TerminatorBlock)
				context.addBlockHandler(block, new TerminatorBlockHandler(context, prefix, block));
			else if(block instanceof LoopBlock)
				context.addBlockHandler(block, new LoopBlockHandler(context, prefix, block));
			else if(block instanceof DiceBlock)
				context.addBlockHandler(block, new DiceBlockHandler(context, prefix, block));
			else if(block instanceof BranchBlock)
				context.addBlockHandler(block, new BranchBlockHandler(context, prefix, block));
			else if(block instanceof MotionClipBlock)
				context.addBlockHandler(block, new MotionClipBlockHandler(context, prefix, block));
			else if(block instanceof MotionClipCloneBlock)
				context.addBlockHandler(block, new MotionClipCloneBlockHandler(context, prefix, block));
			else if(block instanceof MotionContentBlock)
			{
				ContentsClipBlockHandler handler = new ContentsClipBlockHandler(context, prefix, block);
				context.addBlockHandler(block, handler);
				handler.createBlockHandlers(context, ((MotionContentBlock)block).getContent());
			}
			else if(block instanceof MotionContentCloneBlock)
				context.addBlockHandler(block, new ContentsClipCloneBlockHandler(context, prefix, block));
		}
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
		MotionContentBlock block = (MotionContentBlock)getBlock();
		String doFunctionName = "do" + getName();
		sb.append("void ");
		sb.append(doFunctionName);
		sb.append("() {\n");
		AbstractBlockHandler rootHandler = context.findBlockHandler(context.getRoot(block.getContent()));
		if(rootHandler != null)
		{
			sb.append("\t");
			sb.append(rootHandler.getFunctionName());
			sb.append("();\n");
		}
		sb.append("}\n");
		
		sb.append("void ");
		sb.append(getFunctionName());
		sb.append("() {\n\t");
		sb.append(doFunctionName);
		sb.append("();\n");
		createNextHandlerCode(context, sb);
		sb.append("}\n");
	}
}
