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

package org.roboid.studio.contentscomposer.actions;

import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposer;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.commands.PasteElementCommand;

/**
 * @author Kwang-Hyun Park
 */
public class PasteBlockAction extends SelectionAction
{
	public PasteBlockAction(IWorkbenchPart part)
	{
		super(part);
		setLazyEnablementCalculation(true);
	}

	@Override
	protected void init()
	{
		super.init();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setText("Paste");
		setId(ActionFactory.PASTE.getId());
		setHoverImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
		setEnabled(true);
	}

	@Override
	protected boolean calculateEnabled()
	{
		Object contents = Clipboard.getDefault().getContents();
		if(!(contents instanceof List<?>)) return false;
		
		List<?> objects = (List<?>)contents;
		if(objects.isEmpty()) return false;
		
		for(Object o : objects)
		{
			if(o instanceof BlockElement) return true;
        }
		return false;
	}

	@Override
	public void run()
	{
		IWorkbenchPart part = getWorkbenchPart();
		if(part == null) return;
		
		MotionContent diagram = ((ContentsComposer)part).getContentsClip();
		if(diagram == null) return;
		
		GraphicalViewer viewer = (GraphicalViewer)part.getAdapter(GraphicalViewer.class);
		execute(new PasteElementCommand(diagram, viewer));
	}
}
