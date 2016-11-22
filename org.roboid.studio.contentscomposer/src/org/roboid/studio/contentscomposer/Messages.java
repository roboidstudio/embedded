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

import org.eclipse.osgi.util.NLS;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.roboid.studio.contentscomposer.messages"; //$NON-NLS-1$
	public static String ImportDropListener_ConfirmToInsert;
	public static String ImportDropListener_ConfirmToReplace;
	public static String ImportDropListener_ConfirmToUpdate;
	public static String ImportDropListener_InsertionError;
	public static String ImportDropListener_InvalidFileError;
	public static String ImportDropListener_InvalidLogicError;
	public static String ImportDropListener_Message_ConfirmToPartiallyInsertMc1;
	public static String ImportDropListener_Message_ConfirmToPartiallyInsertMc2;
	public static String ImportDropListener_Message_ConfirmToPartiallyInsertMcc1;
	public static String ImportDropListener_Message_ConfirmToPartiallyInsertMcc2;
	public static String ImportDropListener_Message_ConfirmToPartiallyUpdateMcc1;
	public static String ImportDropListener_Message_ConfirmToPartiallyUpdateMcc2;
	public static String ImportDropListener_Message_InsertionError_McWithDifferentRobot1;
	public static String ImportDropListener_Message_InsertionError_McWithDifferentRobot2;
	public static String ImportDropListener_Message_InsertionError_MccWithDifferentRobot1;
	public static String ImportDropListener_Message_InsertionError_MccWithDifferentRobot2;
	public static String ImportDropListener_Message_UpdateError_MccWithDifferentRobot1;
	public static String ImportDropListener_Message_UpdateError_MccWithDifferentRobot2;
	public static String ImportDropListener_Message_InsertionError_EmptyMc;
	public static String ImportDropListener_Message_InsertionError_EmptyMcc;
	public static String ImportDropListener_Message_InvalidJsFileError;
	public static String ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInLogicBlock1;
	public static String ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInLogicBlock2;
	public static String ImportDropListener_Message_InvalidMcFileError;
	public static String ImportDropListener_Message_InvalidMccFileError;
	public static String ImportDropListener_Message_InsertionError_MccWithInvalidLogic;
	public static String ImportDropListener_Message_InvalidRobotFileError1;
	public static String ImportDropListener_Message_InvalidRobotFileError2;
	public static String ImportDropListener_Message_InvalidTargetRobotMccError1;
	public static String ImportDropListener_Message_InvalidTargetRobotMccError2;
	public static String ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInScriptCode1;
	public static String ImportDropListener_Message_UpdateError_MccWithDifferentDeviceInScriptCode2;
	public static String ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInLogicBlock1;
	public static String ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInLogicBlock2;
	public static String ImportDropListener_Message_InvalidSourceRobotMccError1;
	public static String ImportDropListener_Message_InvalidSourceRobotMccError2;
	public static String ImportDropListener_Message_InvalidSourceRobotMcError1;
	public static String ImportDropListener_Message_InvalidSourceRobotMcError2;
	public static String ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInScriptCode1;
	public static String ImportDropListener_Message_InsertionError_MccWithDifferentDeviceInScriptCode2;
	public static String ImportDropListener_Message_ConfirmToReplaceJs1;
	public static String ImportDropListener_Message_ConfirmToReplaceJs2;
	public static String ImportDropListener_Message_ConfirmToReplaceMc1;
	public static String ImportDropListener_Message_ConfirmToReplaceMc2;
	public static String ImportDropListener_Message_ConfirmToReplaceMc3;
	public static String ImportDropListener_Message_ReplacementError_McWithSameName;
	public static String ImportDropListener_Message_ConfirmToReplaceMcc1;
	public static String ImportDropListener_Message_ConfirmToReplaceMcc2;
	public static String ImportDropListener_Message_ConfirmToReplaceMcc3;
	public static String ImportDropListener_Message_ReplacementError_MccWithSameName;
	public static String ImportDropListener_Message_UnsupportedFileError;
	public static String ImportDropListener_Message_ConfirmToUpdateMc1;
	public static String ImportDropListener_Message_ConfirmToUpdateMc2;
	public static String ImportDropListener_Message_ConfirmToUpdateMcc1;
	public static String ImportDropListener_Message_ConfirmToUpdateMcc2;
	public static String ImportDropListener_Message_ConfirmToUpdateMccWithSameRobot1;
	public static String ImportDropListener_Message_ConfirmToUpdateMccWithSameRobot2;
	public static String ImportDropListener_ReplacementError;
	public static String ImportDropListener_UnsupportedFileError;
	
	public static String ImportDropListener_UpdateError;
	public static String ImportDropListener_UpdateInformation;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
