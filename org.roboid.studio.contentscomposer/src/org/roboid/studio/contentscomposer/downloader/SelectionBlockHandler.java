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
abstract class SelectionBlockHandler extends AbstractBlockHandler
{
	SelectionBlockHandler(Context context, String prefix, String name, BlockElement block)
	{
		super(context, prefix, name, block);
	}
	
	BlockElement getYesBlock()
	{
		BlockElement nextBlock = null;
		List<Association> outgoings = getBlock().getOutgoings();
		if(outgoings.size() > 0)
		{
			Association association = outgoings.get(0);
			if(association.getSourceLabel().equals("y"))
				nextBlock = association.getTarget();
			else if(outgoings.size() > 1)
				nextBlock = outgoings.get(1).getTarget();
			while(nextBlock instanceof AdderBlock)
				nextBlock = getNextBlock(nextBlock);
		}
		return nextBlock;
	}
	
	BlockElement getNoBlock()
	{
		BlockElement nextBlock = null;
		List<Association> outgoings = getBlock().getOutgoings();
		if(outgoings.size() > 0)
		{
			Association association = outgoings.get(0);
			if(association.getSourceLabel().equals("n"))
				nextBlock = association.getTarget();
			else if(outgoings.size() > 1)
				nextBlock = outgoings.get(1).getTarget();
			while(nextBlock instanceof AdderBlock)
				nextBlock = getNextBlock(nextBlock);
		}
		return nextBlock;
	}
}
