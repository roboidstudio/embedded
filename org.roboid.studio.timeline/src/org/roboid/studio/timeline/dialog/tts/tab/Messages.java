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

package org.roboid.studio.timeline.dialog.tts.tab;

import org.eclipse.osgi.util.NLS;

/**
 * @author Kwang-Hyun Park
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.roboid.studio.timeline.dialog.tts.tab.messages"; //$NON-NLS-1$
	public static String AbstractTabComposite_Default;
	public static String AbstractTabComposite_Effect;
	public static String AbstractTabComposite_Pitch;
	public static String AbstractTabComposite_Speed;
	public static String AbstractTabComposite_VoiceEffect;
	public static String AbstractTabComposite_Volume;
	public static String Common_Error;
	public static String FileTabAction_ErrorMessage_You_must_select_a_file;
	public static String FileTabComposite_AudioFiles;
	public static String FileTabComposite_File;
	public static String FileTabComposite_FileName;
	public static String FileTabComposite_Files;
	public static String TtsTabAction_Download;
	public static String TtsTabAction_ErrorMessage_You_must_input_a_text;
	public static String TtsTabAction_Exception;
	public static String TtsTabComposite_Language;
	public static String TtsTabComposite_TextToSpeech;
	public static String TtsTabComposite_Voice;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
