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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ScrollBar;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.studio.contentscomposer.commands.ChangeRobotCommand;
import org.roboid.studio.contentscomposer.commands.CreateElementCommand;
import org.roboid.studio.contentscomposer.commands.ModifyContentsClipBlockCommand;
import org.roboid.studio.contentscomposer.commands.ModifyMotionClipBlockCommand;
import org.roboid.studio.contentscomposer.commands.ModifyScriptCommand;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.MotionClipException;
import org.roboid.studio.timeline.TimelineEditor;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ImportDropListener extends AbstractTransferDropTargetListener
{
	private MotionContent diagram;
	private int horizontalScrollBarPosition;
	private int verticalScrollBarPosition;
	private Point dropLocation = new Point();
	
	public ImportDropListener(EditPartViewer viewer, Transfer xfer)
	{
		super(viewer, xfer);
		
		FigureCanvas fc = (FigureCanvas)viewer.getControl();
		final ScrollBar horizontalScrollBar = fc.getHorizontalBar();
		final ScrollBar verticalScrollBar = fc.getVerticalBar();

		horizontalScrollBar.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				horizontalScrollBarPosition = horizontalScrollBar.getSelection();
			}
		});

		verticalScrollBar.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				verticalScrollBarPosition = verticalScrollBar.getSelection();
			}
		});
	}

	@Override
	protected void updateTargetRequest()
	{}

	@Override
	protected Request createTargetRequest()
	{
		return new CreateRequest();
	}

	@Override
	protected Command getCommand()
	{
		Tool tool = getViewer().getEditDomain().getActiveTool();
		if(tool instanceof ExportClipTool)
		{
			if(((ExportClipTool)tool).getSourceViewer() == this.getViewer())
				return null;
		}
		
		dropLocation.x = getDropLocation().x + horizontalScrollBarPosition;
		dropLocation.y = getDropLocation().y + verticalScrollBarPosition;
		return getCommand((String[])getCurrentEvent().data);
	}
	
	private Command getCommand(String[] sourceFileNames)
	{
		diagram = (MotionContent)getTargetEditPart().getModel();
		CompoundCommand commands = new CompoundCommand();
		for(String sourceFileName : sourceFileNames)
		{
			File sourceFile = new File(sourceFileName);
			String sourceClipName = sourceFile.getName();
			String ext = sourceClipName.substring(sourceClipName.lastIndexOf(".") + 1); //$NON-NLS-1$
			
			Command command = null;
			if(ext.equalsIgnoreCase("mc")) //$NON-NLS-1$
				command = getMotionClipCommand(sourceFile);
			else if(ext.equalsIgnoreCase("mcc")) //$NON-NLS-1$
				command = getContentsClipCommand(sourceFile);
			else if(ext.equalsIgnoreCase("js")) //$NON-NLS-1$
				command = getJavaScriptCommand(sourceFile);
			else if(ext.equalsIgnoreCase("robot")) //$NON-NLS-1$
				command = getChangeRobotCommand(sourceFile);
			
			if(command != null) commands.add(command);
		}
		return commands;
	}
	
	private Command getMotionClipCommand(File sourceFile)
	{
		try
		{
			String sourceFileName = sourceFile.getName();
			String newBlockName = sourceFileName.substring(0, sourceFileName.length() - 3);
			
			MotionClip sourceClip = null;
			try
			{
				sourceClip = TimelineEditor.importMotionClip(sourceFile, diagram.getRobot());
			}
			catch (MotionClipException e)
			{
				switch(e.getCode())
				{
				case MotionClip.INSERT_INVALID_CLIENT_ROBOT:
					{
						// The robot of a source motion clip file '[source file name]' is invalid.
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InvalidSourceRobotMcError1 + sourceFileName + Messages.ImportDropListener_Message_InvalidSourceRobotMcError2);
						return null;
					}
				case MotionClip.INSERT_INVALID_REFERENCE_ROBOT:
					{
						// The robot of a target contents clip '[file name of contents composer]' is invalid.
						String targetFileName = ((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart().getTitle();
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InvalidTargetRobotMccError1 + targetFileName + Messages.ImportDropListener_Message_InvalidTargetRobotMccError2);
						return null;
					}
				case MotionClip.INSERT_DIFFERENT_ROBOT:
					{
						// The motion clip file '[source file name]' for a different robot cannot be inserted.
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InsertionError_McWithDifferentRobot1 + sourceFileName + Messages.ImportDropListener_Message_InsertionError_McWithDifferentRobot2);
						return null;
					}
				case MotionClip.INSERT_PARTIAL:
					{
						// The motion clip file '[source file name]' is partially inserted due to the difference of robots. Do you want to proceed?
						if(!MessageDialog.openQuestion(null, Messages.ImportDropListener_ConfirmToInsert, Messages.ImportDropListener_Message_ConfirmToPartiallyInsertMc1 + sourceFileName + Messages.ImportDropListener_Message_ConfirmToPartiallyInsertMc2))
							return null;
						sourceClip = e.getMotionClip();
					}
				}
			}
			if(sourceClip == null)
			{
				// An empty motion clip file cannot be inserted.
				MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InsertionError_EmptyMc);
				return null;
			}
			
			// find a target block at drop position
			MotionClipBlock targetBlock = findMotionClipBlockOnDrop(getDropLocation().translate(new Point(horizontalScrollBarPosition, verticalScrollBarPosition)));
			// find a block with same name
			MotionClipBlock sameNameBlock = diagram.findMotionClipBlock(newBlockName);
			
			if(targetBlock != null) // a block exists at drop position
			{
				// a block with same name is different from the target block
				if(sameNameBlock != null && !newBlockName.equalsIgnoreCase(targetBlock.getName()))
				{
					// The motion clip block cannot be replaced due to the block of the same name.
					MessageDialog.openError(null, Messages.ImportDropListener_ReplacementError, Messages.ImportDropListener_Message_ReplacementError_McWithSameName);
					return null;
				}
				// Would you like to replace the motion clip block [targetBlockName] with [newBlockName]?
				if(!(MessageDialog.openConfirm(null, Messages.ImportDropListener_ConfirmToReplace, Messages.ImportDropListener_Message_ConfirmToReplaceMc1 + targetBlock.getName() + Messages.ImportDropListener_Message_ConfirmToReplaceMc2 + newBlockName + Messages.ImportDropListener_Message_ConfirmToReplaceMc3)))
					return null;
				
				// change the motion clip and the name of the target block
				return new ModifyMotionClipBlockCommand(targetBlock, sourceClip, newBlockName);
			}
			
			// a block doesn't exist at drop position
			// but a block with same name exists
			if(sameNameBlock != null)
			{
				// Would you like to update the motion clip block [newBlockName]?
				if(!(MessageDialog.openConfirm(null, Messages.ImportDropListener_ConfirmToUpdate, Messages.ImportDropListener_Message_ConfirmToUpdateMc1 + newBlockName + Messages.ImportDropListener_Message_ConfirmToUpdateMc2)))
					return null;
				
				// change the motion clip of the target block
				return new ModifyMotionClipBlockCommand(sameNameBlock, sourceClip);
			}

			// create a new block
			MotionClipBlock newBlock = ContentsComposerFactory.eINSTANCE.createMotionClipBlock();
			newBlock.setMotionClip(sourceClip);
			newBlock.setName(newBlockName);
			return getCreateElementCommand(newBlock);
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			MessageDialog.openError(null, Messages.ImportDropListener_InvalidFileError, Messages.ImportDropListener_Message_InvalidMcFileError);
		}
		return null;
	}
	
	private Command getContentsClipCommand(File sourceFile)
	{
		try
		{
			String sourceFileName = sourceFile.getName();
			String newBlockName = sourceFileName.substring(0, sourceFileName.length() - 4);

			MotionContent sourceClip = null;
			try
			{
				sourceClip = ContentsComposer.importContentsClip(sourceFile, diagram.getRobot());
			}
			catch (ContentsClipException e)
			{
				switch(e.getCode())
				{
				case MotionContent.INSERT_INVALID_CLIENT_ROBOT:
					{
						// The robot of a source contents clip file '[source file name]' is invalid.
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InvalidSourceRobotMccError1 + sourceFileName + Messages.ImportDropListener_Message_InvalidSourceRobotMccError2);
						return null;
					}
				case MotionContent.INSERT_INVALID_REFERENCE_ROBOT:
					{
						// The robot of a target contents clip '[file name of contents composer]' is invalid.
						String targetFileName = ((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart().getTitle();
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InvalidTargetRobotMccError1 + targetFileName + Messages.ImportDropListener_Message_InvalidTargetRobotMccError2);
						return null;
					}
				case MotionContent.INSERT_DIFFERENT_ROBOT:
					{
						// The contents clip file '[source file name]' for a different robot cannot be inserted.
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InsertionError_MccWithDifferentRobot1 + sourceFileName + Messages.ImportDropListener_Message_InsertionError_MccWithDifferentRobot2);
						return null;
					}
				case MotionContent.INSERT_INVALID_LOGIC_BLOCK:
					{
						// The contents clip file '[source file name]' cannot be inserted due to the difference of devices in logic blocks.
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInLogicBlock1 + sourceFileName + Messages.ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInLogicBlock2);
						return null;
					}
				case MotionContent.INSERT_INVALID_SCRIPT:
					{
						// The contents clip file '[source file name]' cannot be inserted due to the difference of devices in script codes.
						MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInScriptCode1 + sourceFileName + Messages.ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInScriptCode2);
						return null;
					}
				case MotionContent.INSERT_PARTIAL:
					{
						// The contents clip file '[source file name]' is partially inserted due to the difference of robots. Do you want to proceed?
						if(!MessageDialog.openQuestion(null, Messages.ImportDropListener_ConfirmToInsert, Messages.ImportDropListener_Message_ConfirmToPartiallyInsertMcc1 + sourceFileName + Messages.ImportDropListener_Message_ConfirmToPartiallyInsertMcc2))
							return null;
						sourceClip = e.getContentsClip();
					}
				}
//				else
//				{
//					StringBuilder sb = new StringBuilder();
//					// The contents clip file [source file name] is partially inserted
//					if((code & MotionContent.INSERT_PARTIAL) != 0)
//					{
//						sb.append("The contents clip file '");
//						sb.append(newBlockName);
//						sb.append(".mcc");
//						sb.append("' is partially inserted ");
//					}
//					if((code & MotionContent.INSERT_INVALID_LOGIC_BLOCK) != 0 || (code & MotionContent.INSERT_INVALID_SCRIPT) != 0)
//					{
//						if((code & MotionContent.INSERT_PARTIAL) != 0)
//							sb.append(" and the inserted contents clip block may have mistakes in "); // and the inserted contents clip block may have mistakes in
//						else
//							sb.append("The inserted contents clip block may have mistakes in "); // The inserted contents clip block may have mistakes in
//						
//						if((code & MotionContent.INSERT_INVALID_LOGIC_BLOCK) != 0 && (code & MotionContent.INSERT_INVALID_SCRIPT) != 0)
//							sb.append("logic blocks and script codes "); // logic blocks and script codes
//						else if((code & MotionContent.INSERT_INVALID_LOGIC_BLOCK) != 0)
//							sb.append("logic blocks "); // logic blocks
//						else
//							sb.append("script codes "); // script codes
//					}
//					// due to the difference of robots. Do you want to proceed?
//					sb.append("due to the difference of robots. Do you want to proceed?");
//					
//					if(MessageDialog.openQuestion(null, "Confirm to Insert", sb.toString()))
//						sourceClip = e.getContentsClip();
//					else
//						return null;
//				}
			}
			if(sourceClip == null)
			{
				// An empty contents clip file cannot be inserted.
				MessageDialog.openError(null, Messages.ImportDropListener_InsertionError, Messages.ImportDropListener_Message_InsertionError_EmptyMcc);
				return null;
			}
			// validates the source clip
			if(!sourceClip.validate())
			{
				// The logic of the contents clip file you want to insert is not valid.
				MessageDialog.openError(null, Messages.ImportDropListener_InvalidLogicError, Messages.ImportDropListener_Message_InsertionError_MccWithInvalidLogic);
				return null;
			}

			// find a target block at drop position
			MotionContentBlock targetBlock = findContentsClipBlockOnDrop(getDropLocation().translate(new Point(horizontalScrollBarPosition, verticalScrollBarPosition)));
			// find a block with same name
			MotionContentBlock sameNameBlock = diagram.findMotionContentBlock(newBlockName);
			
			if(targetBlock != null) // a block exists at drop position
			{
				// a block with same name is different from the target block
				if(sameNameBlock != null && !newBlockName.equalsIgnoreCase(targetBlock.getName()))
				{
					// The contents clip block cannot be replaced due to the block of the same name.
					MessageDialog.openError(null, Messages.ImportDropListener_ReplacementError, Messages.ImportDropListener_Message_ReplacementError_MccWithSameName);
					return null;
				}
				// Would you like to replace the contents clip block [targetBlockName] with [newBlockName]?
				if(!(MessageDialog.openConfirm(null, Messages.ImportDropListener_ConfirmToReplace, Messages.ImportDropListener_Message_ConfirmToReplaceMcc1 + targetBlock.getName() + Messages.ImportDropListener_Message_ConfirmToReplaceMcc2 + newBlockName + Messages.ImportDropListener_Message_ConfirmToReplaceMcc3)))
					return null;
				
				// change the contents clip and the name of the target block
				return new ModifyContentsClipBlockCommand(targetBlock, sourceClip, newBlockName);
			}
			
			// a block doesn't exist at drop posotion
			// but a block with same name exists
			if(sameNameBlock != null)
			{
				// Would you like to update the contents clip block [newBlockName]?
				if(!(MessageDialog.openConfirm(null, Messages.ImportDropListener_ConfirmToUpdate, Messages.ImportDropListener_Message_ConfirmToUpdateMcc1 + newBlockName + Messages.ImportDropListener_Message_ConfirmToUpdateMcc2)))
					return null;
				
				// change the contents clip of the target block
				return new ModifyContentsClipBlockCommand(sameNameBlock, sourceClip);
			}

			// create a new block
			MotionContentBlock newBlock = ContentsComposerFactory.eINSTANCE.createMotionContentBlock();
			newBlock.setContent(sourceClip);
			newBlock.setName(newBlockName);
			return getCreateElementCommand(newBlock);
		}
		catch(Exception e)
		{
			// e.printStackTrace();
			// The contents clip file is invalid.
			MessageDialog.openError(null, Messages.ImportDropListener_InvalidFileError, Messages.ImportDropListener_Message_InvalidMccFileError);
		}
		return null;
	}
	
	private Command getJavaScriptCommand(File jsFile)
	{
		try
		{
			// script name
			String newScriptName = jsFile.getName();
			newScriptName = newScriptName.substring(0, newScriptName.length() - 3);
			
			// find a target block at drop position
			BlockElement targetBlock = findBlockOnDrop(getDropLocation().translate(new Point(horizontalScrollBarPosition, verticalScrollBarPosition)));

			if(targetBlock != null) // a block exists at drop position
			{
				// check a script
				if(!targetBlock.canHaveScript()) return null;
				
				// Would you like to replace the script code with [newScriptName]?
				if(!(MessageDialog.openConfirm(null, Messages.ImportDropListener_ConfirmToReplace, Messages.ImportDropListener_Message_ConfirmToReplaceJs1 + newScriptName + Messages.ImportDropListener_Message_ConfirmToReplaceJs2)))
					return null;
				
				// read a script code from the source file
				String scriptCode = ""; //$NON-NLS-1$
				String line;
				BufferedReader br = new BufferedReader(new FileReader(jsFile.getCanonicalPath()));
				while((line = br.readLine()) != null)
					scriptCode += line + "\n"; //$NON-NLS-1$
				br.close();
				
				// change the script type, script name and script code of the target block
				return new ModifyScriptCommand(targetBlock, newScriptName, scriptCode);
			}
		}
		catch (Exception e)
		{
			// e.printStackTrace();
			// The script file is invalid.
			MessageDialog.openError(null, Messages.ImportDropListener_InvalidFileError, Messages.ImportDropListener_Message_InvalidJsFileError);
		}
		return null;
	}
	
	private Command getChangeRobotCommand(File robotFile)
	{
		Robot newRobot = RobotFactory.eINSTANCE.createRobot(robotFile);
		if(newRobot == null) return null;

		String robotFileName = robotFile.getName();
		ContentsComposer editor = (ContentsComposer)((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart();
		MotionContent oldClip = editor.getContentsClip();
		
		if(newRobot.equalsContents(oldClip.getRobot()))
		{
			// The target contents clip '[file name]' doesn't have to be updated since both robots are same.
			MessageDialog.openInformation(null, Messages.ImportDropListener_UpdateInformation, Messages.ImportDropListener_Message_ConfirmToUpdateMccWithSameRobot1 + editor.getTitle() + Messages.ImportDropListener_Message_ConfirmToUpdateMccWithSameRobot2);
			return null;
		}
		
		MotionContent newClip = oldClip.deepCopy();
		newClip.updateReference(oldClip.getRobot());
		int code = newClip.adaptTo(newRobot);
		
		switch(code)
		{
		case MotionContent.INSERT_INVALID_CLIENT_ROBOT:
			{
				// The robot of a target contents clip '[file name]' is invalid.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_InvalidTargetRobotMccError1 + editor.getTitle() + Messages.ImportDropListener_Message_InvalidTargetRobotMccError2);
				return null;
			}
		case MotionContent.INSERT_INVALID_REFERENCE_ROBOT:
			{
				// The robot file '[robot file name]' is invalid.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_InvalidRobotFileError1 + robotFileName + Messages.ImportDropListener_Message_InvalidRobotFileError2);
				return null;
			}
		case MotionContent.INSERT_DIFFERENT_ROBOT:
			{
				// The target contents clip '[file name]' cannot be updated due to the difference of robots.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_UpdateError_MccWithDifferentRobot1 + editor.getTitle() + Messages.ImportDropListener_Message_UpdateError_MccWithDifferentRobot2);
				return null;
			}
		case MotionContent.INSERT_INVALID_LOGIC_BLOCK:
			{
				// The target contents clip '[file name]' cannot be updated due to the difference of devices in logic blocks.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInLogicBlock1 + editor.getTitle() + Messages.ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInLogicBlock2);
				return null;
			}
		case MotionContent.INSERT_INVALID_SCRIPT:
			{
				// The target contents clip '[file name]' cannot be updated due to the difference of devices in script codes.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInScriptCode1 + editor.getTitle() + Messages.ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInScriptCode2);
				return null;
			}
		case MotionContent.INSERT_PARTIAL:
			{
				// The target contents clip '[file name]' is partially updated due to the difference of robots. Do you want to proceed?
				if(!MessageDialog.openQuestion(null, Messages.ImportDropListener_ConfirmToUpdate, Messages.ImportDropListener_Message_ConfirmToPartiallyUpdateMcc1 + editor.getTitle() + Messages.ImportDropListener_Message_ConfirmToPartiallyUpdateMcc2))
					return null;
			}
		}
//		else if(code != MotionContent.INSERT_SUCCESS)
//		{
//			StringBuilder sb = new StringBuilder();
//			// The target contents clip file [file name of contents composer] is partially updated
//			if((code & MotionContent.INSERT_PARTIAL) != 0)
//			{
//				sb.append("The target contents clip '");
//				sb.append(editor.getTitle());
//				sb.append("' is partially updated ");
//			}
//			if((code & MotionContent.INSERT_INVALID_LOGIC_BLOCK) != 0 || (code & MotionContent.INSERT_INVALID_SCRIPT) != 0)
//			{
//				if((code & MotionContent.INSERT_PARTIAL) != 0)
//					sb.append(" and the updated contents clip may have mistakes in "); // and the updated contents clip may have mistakes in
//				else
//					sb.append("The updated contents clip may have mistakes in "); // The updated contents clip may have mistakes in
//				
//				if((code & MotionContent.INSERT_INVALID_LOGIC_BLOCK) != 0 && (code & MotionContent.INSERT_INVALID_SCRIPT) != 0)
//					sb.append("logic blocks and script codes "); // logic blocks and script codes
//				else if((code & MotionContent.INSERT_INVALID_LOGIC_BLOCK) != 0)
//					sb.append("logic blocks "); // logic blocks
//				else
//					sb.append("script codes "); // script codes
//			}
//			// due to the difference of robots. Do you want to proceed?
//			sb.append("due to the difference of robots. Do you want to proceed?");
//			
//			if(!MessageDialog.openQuestion(null, "Confirm to Insert", sb.toString()))
//				return null;
//		}
		
		Activity newActivity = ActivityFactory.eINSTANCE.createActivity(newRobot);
		newActivity.init(newRobot);
		newClip.setActivity(newActivity);
		
		return new ChangeRobotCommand(editor, oldClip, newClip);
	}
	
	private Command getCreateElementCommand(BlockElement newElement)
	{
		newElement.setX(ContentsComposer.snap(dropLocation.x));
		newElement.setY(ContentsComposer.snap(dropLocation.y));
		dropLocation.x += MotionContent.GRID * 3;
		dropLocation.y += MotionContent.GRID * 3;
		return new CreateElementCommand(diagram, newElement);
	}
	
	// find a block at drop position
	@SuppressWarnings("unchecked")
	private BlockElement findBlockOnDrop(Point dropLocation)
	{
		List<NodeEditPart> parts = getTargetEditPart().getChildren();
		
		for(int i = 0; i < parts.size(); i ++)
		{
			NodeEditPart part = parts.get(i);
			Rectangle bound = part.getFigure().getBounds();
			if(bound.contains(dropLocation))
				return (BlockElement)part.getModel();
		}
		return null;
	}
	
	// find a motion clip block at drop position
	private MotionClipBlock findMotionClipBlockOnDrop(Point dropLocation)
	{
		MotionContent content = (MotionContent)getTargetEditPart().getModel();
		List<MotionClipBlock> clips = content.getMotionClipBlocks();
		
		for(int i = 0; i < clips.size(); i ++)
		{
			MotionClipBlock mc = clips.get(i);
			Rectangle bound = new Rectangle(mc.getX(), mc.getY(), 96, 24);
			if(bound.contains(dropLocation))
				return mc;
		}
		return null;
	}
	
	// find a contents clip block at drop position
	private MotionContentBlock findContentsClipBlockOnDrop(Point dropLocation)
	{
		MotionContent content = (MotionContent)getTargetEditPart().getModel();
		List<MotionContentBlock> clips = content.getMotionContentBlocks();
		
		for(int i = 0; i < clips.size(); i ++)
		{
			MotionContentBlock mcc = clips.get(i);
			Rectangle bound = new Rectangle(mcc.getX(), mcc.getY(), 96, 24);
			if(bound.contains(dropLocation))
				return mcc;
		}
		return null;
	}
}
