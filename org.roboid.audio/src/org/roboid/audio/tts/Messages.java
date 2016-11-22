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

package org.roboid.audio.tts;

import org.eclipse.osgi.util.NLS;

/**
 * @author Kwang-Hyun Park
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.roboid.audio.tts.messages"; //$NON-NLS-1$
	public static String InvalidTtsVoiceEffectException_Message_Voice_effect_is_not_valid;
	public static String InvalidTtsVoiceException_Message_Voice_is_not_valid;
	public static String NullVc_None;
	public static String TtsLanguage_Arabic;
	public static String TtsLanguage_Basque;
	public static String TtsLanguage_Chinese_Simplified;
	public static String TtsLanguage_Chinese_Traditional;
	public static String TtsLanguage_Croatian;
	public static String TtsLanguage_Czech;
	public static String TtsLanguage_Dutch;
	public static String TtsLanguage_English;
	public static String TtsLanguage_Finnish;
	public static String TtsLanguage_French;
	public static String TtsLanguage_German;
	public static String TtsLanguage_Greek;
	public static String TtsLanguage_Hebrew;
	public static String TtsLanguage_Hungarian;
	public static String TtsLanguage_Italian;
	public static String TtsLanguage_Japanese;
	public static String TtsLanguage_Korean;
	public static String TtsLanguage_Norwegian;
	public static String TtsLanguage_Polish;
	public static String TtsLanguage_Portuguese;
	public static String TtsLanguage_Romanian;
	public static String TtsLanguage_Russian;
	public static String TtsLanguage_Slovak;
	public static String TtsLanguage_Slovenian;
	public static String TtsLanguage_Spanish;
	public static String TtsLanguage_Swedish;
	public static String TtsLanguage_Thai;
	public static String TtsLanguage_Turkish;
	public static String TtsLanguage_Unknown;
	public static String UnsupportedTtsTextException_Message_Cannot_synthesize_this_text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
