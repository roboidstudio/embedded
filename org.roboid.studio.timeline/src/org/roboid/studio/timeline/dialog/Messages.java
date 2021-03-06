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

package org.roboid.studio.timeline.dialog;

import org.eclipse.osgi.util.NLS;

/**
 * @author Kwang-Hyun Park
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.roboid.studio.timeline.dialog.messages"; //$NON-NLS-1$
	public static String Common_OK;
	public static String Common_Cancel;
	public static String MatrixDialog_MatrixEditor;
	public static String MatrixDialog_Reset;
	public static String MatrixDialog_ShowValue;
	public static String MatrixDialog_Value;
	public static String TtsDialog_Audio;
	public static String TtsDialog_Files;
	public static String TtsDialog_Message_Converting_the_audio_format;
	public static String TtsDialog_Voice;
	public static String TtsDialog_WriteToFile;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
