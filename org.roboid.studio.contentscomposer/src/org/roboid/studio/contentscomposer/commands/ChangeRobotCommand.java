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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * @author Kwang-Hyun Park
 */
public class ChangeRobotCommand extends Command
{
	private ContentsComposer editor;
	private MotionContent oldClip;
	private MotionContent newClip;
		
	public ChangeRobotCommand(ContentsComposer editor, MotionContent oldClip, MotionContent newClip)
	{
		this.editor = editor;
		this.oldClip = oldClip;
		this.newClip = newClip;
	}
	
	@Override
	public void execute()
	{
		ContentsComposer.layoutNestedMotionClip(newClip);
		URI uri = ((EObject)oldClip).eResource().getURI();
		newClip.refreshResource(uri);
		editor.setContentsClip(newClip);
		editor.updateContentsComposer(newClip);
		ContentsManager.changeContent(newClip);
	}

	@Override
	public void undo()
	{
		ContentsComposer.layoutNestedMotionClip(oldClip);
		oldClip.refreshResource();
		editor.setContentsClip(oldClip);
		editor.updateContentsComposer(oldClip);
		ContentsManager.changeContent(oldClip);
	}
}