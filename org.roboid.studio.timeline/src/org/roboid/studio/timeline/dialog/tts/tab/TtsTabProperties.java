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

import org.roboid.audio.tts.TtsVoice;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsTabProperties extends AbstractTabProperties
{
	private static final long serialVersionUID = 1L;

	// Text
	private String text = "";

	// speaker
	private String voiceId;
	private String languageId;

	public TtsTabProperties()
	{
		super();
	}
	
	public TtsTabProperties(TtsVoice voice)
	{
		super(voice);
		if(voice == null) return;
		
		setVoiceId(voice.getVoiceId());
		setLanguageId(voice.getLanguage().getId());
	}

	// Text
	public String getText()
	{
		return text;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	// Language
	public String getLanguageId()
	{
		return languageId;
	}
	
	public void setLanguageId(String languageId)
	{
		this.languageId = languageId;
	}

	// speaker
	public String getVoiceId()
	{
		return voiceId;
	}

	public void setVoiceId(String voiceId)
	{
		this.voiceId = voiceId;
	}
}
