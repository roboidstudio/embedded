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

package org.roboid.studio.timeline.commands;

import org.eclipse.gef.commands.Command;
import org.roboid.robot.IoMode;
import org.roboid.robot.Port;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineEditor;

/**
 * @author Kwang-Hyun Park
 */
public class ModifyPortModeCommand extends Command
{
	private TimelineEditor editor;
	private Port port;
	private IoMode oldMode;
	private IoMode newMode;
	
	public ModifyPortModeCommand(TimelineEditor editor, Port port, IoMode oldMode, IoMode newMode)
	{
		this.editor = editor;
		this.port = port;
		this.oldMode = oldMode;
		this.newMode = newMode;
	}

	@Override
	public void execute()
	{
		MotionClip clip = editor.getMotionClip();
		TimelineEditor.layoutMotionClip(clip);
		editor.updateTimelineEditor(clip);
	}

	@Override
	public void undo()
	{
		port.setMode(oldMode);
		MotionClip clip = editor.getMotionClip();
		TimelineEditor.layoutMotionClip(clip);
		editor.updateTimelineEditor(clip);
	}

	@Override
	public void redo()
	{
		port.setMode(newMode);
		MotionClip clip = editor.getMotionClip();
		TimelineEditor.layoutMotionClip(clip);
		editor.updateTimelineEditor(clip);
	}
}
