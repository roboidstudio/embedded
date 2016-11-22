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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.roboid.studio.contentscomposer.Activator;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.studio.contentscomposer.commands.MoveElementCommand;
import org.roboid.studio.jseditor.JsEditor;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class EditScriptAction extends SelectionAction
{
	public static String Id = "EditScript";
	public static String EDIT_SCRIPT = "EditScript";
//	private static Rectangle rect = new Rectangle(400, 300, 640, 320);
	Request request;
	EditPart part;
	
	public EditScriptAction(IWorkbenchPart workbenchPart)
	{
		super(workbenchPart);
		setText("Edit Script");
		setId(EDIT_SCRIPT);
		setToolTipText("Open script editer");
		setImageDescriptor(ImageDescriptor.createFromFile(Activator.class,"scroll_edit.png")); //$NON-NLS-1$
	}

	// 스크립트 에디터 열기가 가능한지 묻는다.
	@Override
	protected boolean calculateEnabled()
	{
		if (getSelectedObjects().isEmpty())	return false; // 선택된 노드가 없다.
		
		Object o = getSelectedObjects().get(0);
		if (!(o instanceof EditPart)) return false; // 선택된 것이 에디트 파트가 아니다.
		
		part = (EditPart)o;
		Object model = part.getModel();
		if(!(model instanceof BlockElement)) return false;
		if(((BlockElement)model).getScriptType() == ScriptType.NONE) return false;
		if(isEditorOpen()) return false; // 스크립트 에디터가 이미 열려 있다.
		
		return true;
	}
	
	// 스크립트 에디터가 열려 있는지 묻는다.
	//Do not open second editor
	private boolean isEditorOpen()
	{
		Display display = Display.getDefault();
		Shell[] shells = display.getShells();
		for(int i = 0; i < shells.length; i ++)
			if(shells[i].getText().equals("Roboid Script Editor")) return true;
		return false;
	}
	
	// 실행
	@Override
	public void run()
	{
		Shell parent = getWorkbenchPart().getSite().getShell();
		JsEditor jsEditor = new JsEditor(parent);
		BlockElement block = (BlockElement)part.getModel();

		jsEditor.setName(block.getScriptName());
		jsEditor.setCode(block.getScriptCode());
		String code = jsEditor.open();
		if(!code.equals(block.getScriptCode()))
		{
			execute(new MoveElementCommand(block.getX(), block.getY(), block));
			block.setScriptCode(code);
		}
	}
	
	public void run(EditPart part)
	{
		Object model = part.getModel();
		if(!(model instanceof BlockElement)) return;
		if(((BlockElement)model).getScriptType() == ScriptType.NONE) return;
		if(isEditorOpen()) return;
		
		Shell parent = getWorkbenchPart().getSite().getShell();
		JsEditor jsEditor = new JsEditor(parent);
		BlockElement block = (BlockElement)part.getModel();

		jsEditor.setName(block.getScriptName());
		jsEditor.setCode(block.getScriptCode());
		String code = jsEditor.open();
		if(!code.equals(block.getScriptCode()))
		{
			execute(new MoveElementCommand(block.getX(), block.getY(), block));
			block.setScriptCode(code);
		}
	}

	// ID를 얻는다.
	@Override
	public String getId()
	{
		return Id;
	}	
}
