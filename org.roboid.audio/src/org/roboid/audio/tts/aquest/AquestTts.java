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
 * A-Quest�� ���� �Ϻ��� TTS
 * 
 * �پ��� ��Ҹ��� �����Ƿ� ���� �߰� ���� 
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
	 * @param speed		�⺻��:100 (50~300)
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
			// ���ڿ� ���ڵ��� shift-jis�� ��ȯ�Ѵ�.
			// �Ϻ� �����찡 �ƴ� ȯ�濡�� �Ϻ�� �Է��� ��� �Ϻ�� ������ �ʵ��� ��
			text = new String(text.getBytes("shift-jis")); //$NON-NLS-1$
	
			// ���� �ռ�
			byte[] audio = nativeSynthesis(text, getSpeechRate().getValue());
	
			// TTS���� �������� �ʴ� ���ڿ��� ��� ���� �߻� 
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
