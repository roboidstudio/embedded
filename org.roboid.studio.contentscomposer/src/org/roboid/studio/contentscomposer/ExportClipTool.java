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

package org.roboid.studio.contentscomposer;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.roboid.studio.contentscomposer.editparts.BlockElementEditPart;
import org.roboid.studio.contentscomposer.editparts.ContentsClipBlockEditPart;
import org.roboid.studio.contentscomposer.editparts.MotionClipBlockEditPart;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ExportClipTool extends SelectionTool
{
	private EditPartViewer currentViewer;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean handleNativeDragStarted(DragSourceEvent event)
	{
		// 드래그하는 에디트 파트를 얻는다.
//		EditPart part = getTargetEditPart();
		currentViewer = getCurrentViewer();
		List<EditPart> parts = currentViewer.getSelectedEditParts();

		event.doit = false;
		for(EditPart part : parts)
		{
			// 모션 클립이나 콘텐츠 클립 혹은 스크립트가 있는 노드이면
			if(part instanceof MotionClipBlockEditPart || part instanceof ContentsClipBlockEditPart)
				event.doit = true;
			else if(part instanceof BlockElementEditPart && ((BlockElement)part.getModel()).getScriptType() != ScriptType.NONE)
				event.doit = true;
//			else
//				event.doit = false;
		}
		return super.handleNativeDragStarted(event);
	}
	
	public EditPartViewer getSourceViewer()
	{
		return currentViewer;
	}
	
	public void setSourceViewer(EditPartViewer viewer)
	{
		currentViewer = viewer;
	}
}
