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

package org.roboid.studio.timeline;

import java.io.File;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.dnd.Transfer;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.studio.timeline.commands.ChangeRobotCommand;

/**
 * @author Kwang-Hyun Park
 */
public class ImportDropListener extends AbstractTransferDropTargetListener
{
	public ImportDropListener(EditPartViewer viewer, Transfer xfer)
	{
		super(viewer, xfer);
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
		String[] sourceFileNames = (String[])getCurrentEvent().data;
		if(sourceFileNames == null || sourceFileNames.length <= 0) return null;
		
		File sourceFile = new File(sourceFileNames[0]);
		String sourceFileName = sourceFile.getName();
		String ext = sourceFileName.substring(sourceFileName.lastIndexOf(".") + 1); //$NON-NLS-1$
			
		if(!ext.equalsIgnoreCase("robot")) return null; //$NON-NLS-1$
		
		Robot newRobot = RobotFactory.eINSTANCE.createRobot(sourceFile);
		if(newRobot == null) return null;
		
		TimelineEditor editor = (TimelineEditor)((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart();
		MotionClip oldClip = editor.getMotionClip();

		if(newRobot.equalsContents(oldClip.getRobot()))
		{
			// The target motion clip '[file name]' doesn't have to be updated since both robots are same.
			MessageDialog.openInformation(null, Messages.ImportDropListener_UpdateInformation, Messages.ImportDropListener_Message_ConfirmToUpdateMcWithSameRobot1 + editor.getTitle() + Messages.ImportDropListener_Message_ConfirmToUpdateMcWithSameRobot2);
			return null;
		}

		MotionClip newClip = oldClip.deepCopy();
		newClip.updateReference(oldClip.getRobot());
		int code = newClip.adaptTo(newRobot);
		
		switch(code)
		{
		case MotionClip.INSERT_INVALID_CLIENT_ROBOT:
			{
				// The robot of a target motion clip '[file name]' is invalid.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_InvalidTargetRobotMcError1 + editor.getTitle() + Messages.ImportDropListener_Message_InvalidTargetRobotMcError2);
				return null;
			}
		case MotionClip.INSERT_INVALID_REFERENCE_ROBOT:
			{
				// The robot file '[source file name]' is invalid.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_InvalidRobotFileError1 + sourceFileName + Messages.ImportDropListener_Message_InvalidRobotFileError2);
				return null;
			}
		case MotionClip.INSERT_DIFFERENT_ROBOT:
			{
				// The target motion clip '[file name]' cannot be updated due to the difference of robots.
				MessageDialog.openError(null, Messages.ImportDropListener_UpdateError, Messages.ImportDropListener_Message_UpdateError_McWithDifferentRobot1 + editor.getTitle() + Messages.ImportDropListener_Message_UpdateError_McWithDifferentRobot2);
				return null;
			}
		case MotionClip.INSERT_PARTIAL:
			{
				// The target motion clip '[file name]' is partially updated due to the difference of robots. Do you want to proceed?
				if(!MessageDialog.openQuestion(null, Messages.ImportDropListener_ConfirmToUpdate, Messages.ImportDropListener_Message_ConfirmToPartiallyUpdateMc1 + editor.getTitle() + Messages.ImportDropListener_Message_ConfirmToPartiallyUpdateMc2))
					return null;
			}
		}
		
		Activity newAtivity = ActivityFactory.eINSTANCE.createActivity(newRobot);
		newAtivity.init(newRobot);
		newClip.setActivity(newAtivity);
		
		return new ChangeRobotCommand(editor, oldClip, newClip);
	}
}
