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

package org.roboid.studio.contentscomposer.commands;

import org.eclipse.gef.commands.Command;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kwang-Hyun Park
 */
public class ModifyMotionClipBlockCommand extends Command
{
	private MotionClipBlock block;
	private MotionClip newClip;
	private MotionClip oldClip;
	private String newName;
	private String oldName;
	
	public ModifyMotionClipBlockCommand(MotionClipBlock block, MotionClip newClip)
	{
		this.block = block;
		this.oldClip = block.getMotionClip();
		this.newClip = newClip;
	}
	
	public ModifyMotionClipBlockCommand(MotionClipBlock block, MotionClip newClip, String newName)
	{
		this(block, newClip);
		this.oldName = block.getName();
		this.newName = newName;
	}
	
	@Override
	public void execute()
	{
		block.setMotionClip(newClip);
		if(newName != null) block.updateName(newName);
	}

	@Override
	public void undo()
	{
		block.setMotionClip(oldClip);
		if(oldName != null) block.updateName(oldName);
	}
}
