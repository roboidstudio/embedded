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

import org.eclipse.osgi.util.NLS;

/**
 * @author Kwang-Hyun Park
 */
public class Messages extends NLS
{
	private static final String BUNDLE_NAME = "org.roboid.studio.timeline.messages"; //$NON-NLS-1$
	public static String ImportDropListener_ConfirmToUpdate;
	public static String ImportDropListener_Message_ConfirmToPartiallyUpdateMc1;
	public static String ImportDropListener_Message_ConfirmToPartiallyUpdateMc2;
	public static String ImportDropListener_Message_ConfirmToUpdateMcWithSameRobot1;
	public static String ImportDropListener_Message_ConfirmToUpdateMcWithSameRobot2;
	public static String ImportDropListener_Message_InvalidRobotFileError1;
	public static String ImportDropListener_Message_InvalidRobotFileError2;
	public static String ImportDropListener_Message_InvalidTargetRobotMcError1;
	public static String ImportDropListener_Message_InvalidTargetRobotMcError2;
	public static String ImportDropListener_Message_UpdateError_McWithDifferentRobot1;
	public static String ImportDropListener_Message_UpdateError_McWithDifferentRobot2;
	public static String ImportDropListener_UpdateError;
	public static String ImportDropListener_UpdateInformation;
	static
	{
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages()
	{
	}
}
