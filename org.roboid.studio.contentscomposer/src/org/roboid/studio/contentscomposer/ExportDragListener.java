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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.dnd.AbstractTransferDragSourceListener;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.roboid.studio.contentscomposer.editparts.BlockElementEditPart;
import org.roboid.studio.contentscomposer.editparts.ContentsClipBlockEditPart;
import org.roboid.studio.contentscomposer.editparts.MotionClipBlockEditPart;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineEditor;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ExportDragListener extends	AbstractTransferDragSourceListener
{
	public ExportDragListener(EditPartViewer viewer, Transfer xfer)
	{
		super(viewer, xfer);//FileTransfer.getInstance());
	}

	// �巡�� �� �� ExportClipTool�� ���õǾ� �ִ��� Ȯ���Ѵ�.
	@Override
	public void dragStart(DragSourceEvent event)
	{
		if(!(getViewer().getEditDomain().getActiveTool() instanceof ExportClipTool))
			event.doit = false;
	}

	@Override
	public void dragFinished(DragSourceEvent event)
	{
		super.dragFinished(event);
		Tool tool = getViewer().getEditDomain().getActiveTool();
		if(tool instanceof ExportClipTool)
		{
			((ExportClipTool)tool).setSourceViewer(null);
		}
	}

	/**
	 * create temporary file
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void dragSetData(DragSourceEvent event)
	{
		String strTempPath = System.getProperty("java.io.tmpdir");
		// ������ ������ �ӽ� ������ �����Ѵ�.
		File[] f = new File(strTempPath).listFiles(new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".mc") || name.endsWith(".mcc") || name.endsWith(".js");
			}
		});
		for(int i = 0; i < f.length; i++)
			f[i].delete();
		
		List<String> fileNamesToExport = new ArrayList<String>();
		// ���õ� ��带 ��´�.
		List<EditPart> listPart = getViewer().getSelectedEditParts();
		for(EditPart part : listPart)
		{
			// ���õ� ���� ��� Ŭ���̸�
			if(part instanceof MotionClipBlockEditPart)
			{
				// ��� Ŭ���� ���� �̸��� ��´�.
				MotionClipBlock block = (MotionClipBlock)part.getModel();
				String filePath = strTempPath + block.getName() + ".mc";
				
				// ������ ������ �����Ѵ�.
				try
				{
					File file = new File(filePath);
					MotionClip clip = block.getMotionClip();
					MotionContent motionContent = block.getParent();
					if(TimelineEditor.exportMotionClip(file, motionContent.getRobot(), motionContent.getActivity(), clip))
						fileNamesToExport.add(filePath);
					block.setMotionClip(clip);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			// ���õ� ���� ������ Ŭ���̸�
			else if(part instanceof ContentsClipBlockEditPart)
			{
				// ������ Ŭ���� ���� �̸��� ��´�.
				MotionContentBlock block = (MotionContentBlock)part.getModel();
				String filePath = strTempPath + block.getName() + ".mcc";
				
				// ������ ������ �����Ѵ�.
				try
				{
					File file = new File(filePath);
					MotionContent content = block.getContent();
					MotionContent parent = block.getParent();
					if(ContentsComposer.exportContentsClip(file, parent.getRobot(), parent.getActivity(), content))
						fileNamesToExport.add(filePath);
					block.setContent(content);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			// ���õ� ���� ��ũ��Ʈ�� �ִ� ����̸�
			else if(part instanceof BlockElementEditPart)
			{
				BlockElement node = (BlockElement)part.getModel();
				if(node.getScriptType() == ScriptType.NONE) continue; // ��ũ��Ʈ�� ����.
				
				// ���� �̸��� ��´�.
				String fileName = node.getScriptName();
				if(fileName == null || fileName.equals("")) fileName = "untitled";
				fileName += ".js";
				String filePath = strTempPath + fileName;
				
				// ������ ������ �����Ѵ�.
				fileNamesToExport.add(filePath);
				try
				{
					BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
					bw.write(node.getScriptCode());
					bw.close();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if(fileNamesToExport.size() > 0)
			event.data = fileNamesToExport.toArray(new String[0]);
	}
}
