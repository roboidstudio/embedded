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

package org.roboid.audio.tts.aquest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;

import org.roboid.audio.Activator;
import org.roboid.audio.tts.AbstractTts;
import org.roboid.audio.tts.TtsLanguage;
import org.roboid.audio.tts.TtsProperty;
import org.roboid.audio.tts.TtsVoice;
import org.roboid.audio.tts.UnsupportedTtsTextException;


/**
 * A-Quest의 무료 일본어 TTS
 * 
 * 다양한 목소리가 있으므로 추후 추가 예정 
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class AquestTts extends AbstractTts
{
	public static final AudioFormat AQUEST_AUDIO_FORMAT = new AudioFormat(8000, 16, 1, true, false);
	
	static
	{
		try
		{
			File file = new File(Activator.findLibraryPath("AquesTalk.dll")); //$NON-NLS-1$
			Activator.addLibraryPath(file.getParentFile().getCanonicalPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.loadLibrary("AquesTalk"); //$NON-NLS-1$
		System.loadLibrary("AquesTalkJNI"); //$NON-NLS-1$
	}
	
	/**
	 * @param text
	 * @param speed		기본값:100 (50~300)
	 */
	private native byte[] nativeSynthesis(String text, int speed);
	private static AquestTts instance = null;

	private AquestTts()
	{
		super();
		setAudioFormat(AQUEST_AUDIO_FORMAT);
		setCurrentVoice(getDefaultVoice());
		setSpeechRate(new TtsProperty(50, 300, 10, 100, true));
	}
	
	public static AquestTts getInstance()
	{
		if(instance == null)
			instance = new AquestTts();
		return instance;
	}
	
	@Override
	public void execute(String text)
	{
		List<Exception> exceptionList = new ArrayList<Exception>();
		try
		{
			// 문자열 인코딩을 shift-jis로 변환한다.
			// 일본 윈도우가 아닌 환경에서 일본어를 입력할 경우 일본어가 깨지지 않도록 함
			text = new String(text.getBytes("shift-jis")); //$NON-NLS-1$
	
			// 음성 합성
			byte[] audio = nativeSynthesis(text, getSpeechRate().getValue());
	
			// TTS에서 지원하지 않는 문자열일 경우 예외 발생 
			if(audio == null)
				throw new UnsupportedTtsTextException();

			write(audio);
		}
		catch (Exception e)
		{
			exceptionList.add(e);
		}
		
		complete(exceptionList);
	}

	@Override
	protected List<TtsVoice> createVoices()
	{
		List<TtsVoice> voices = new ArrayList<TtsVoice>();
		voices.add(new TtsVoice(this,
								"org.roboid.audio.tts.aquest.woman", // voice id
								"Aquest Woman", // voice name
								TtsLanguage.JAPANESE, // language
								TtsVoice.Age.YOUNGER_ADULT,
								TtsVoice.Gender.FEMALE,
								TtsVoice.Style.STANDARD,
								TtsVoice.Domain.GENERAL));
		return voices;
	}
}
