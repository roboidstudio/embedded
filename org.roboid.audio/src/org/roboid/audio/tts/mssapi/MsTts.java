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

package org.roboid.audio.tts.mssapi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import org.roboid.audio.Activator;
import org.roboid.audio.AudioUtil;
import org.roboid.audio.tts.AbstractTts;
import org.roboid.audio.tts.InvalidTtsVoiceException;
import org.roboid.audio.tts.TtsLanguage;
import org.roboid.audio.tts.TtsProperty;
import org.roboid.audio.tts.TtsVoice;


/**
 * Microsoft Speech SDK 5.x <br/>
 * 
 * pitch: -10~10, default: 0<br/>
 * rate: -10~10, default: 0<br/>
 * volume: 0~100, default: 100<br/>
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class MsTts extends AbstractTts
{
	/**
	 * 18: SPSF_22kHz16BitMono
	 */
	public final static int DEFAULT_AUDIO_FORMAT_NUMBER = 18;
	public final static AudioFormat MS_AUDIO_FORMAT = new AudioFormat(22050, 16, 1, false, false);
	private static boolean INITIALIZED = false;

	static
	{
		try
		{
			File file = new File(Activator.findLibraryPath("MsTtsJNI.dll"));
			Activator.addLibraryPath(file.getParentFile().getCanonicalPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.loadLibrary("MsTtsJNI");
	}

	/**
	 * initialize TTS
	 * 
	 * @return true: initialize was succeeded.
	 */
	private native boolean nativeInitialize();
	
	/**
	 * tts unInitialize
	 */
	private native void nativeUnInitialize();

	/**
	 * get the number of voices
	 * 
	 * @return
	 */
	private native int nativeGetNumberOfSpeakers();

	/**
	 * get spearker name
	 * 
	 * @param speakerIndex
	 * @return
	 */
	private native String nativeGetSpeakerName(int speakerIndex);

	/**
	 * get spearker name
	 * 
	 * @param speakerIndex
	 * @return
	 */
	private native String nativeGetLanguageID(int speakerIndex);

	/**
	 * @param voiceIndex
	 * @param fileFormat
	 *            0: SPSF_8kHz8BitMono, 1: SPSF_8kHz8BitStereo, 2:
	 *            SPSF_8kHz16BitMono, 3: SPSF_8kHz16BitStereo, 4:
	 *            SPSF_11kHz8BitMono, 5: SPSF_11kHz8BitStereo, 6:
	 *            SPSF_11kHz16BitMono, 7: SPSF_11kHz16BitStereo, 8:
	 *            SPSF_12kHz8BitMono, 9: SPSF_12kHz8BitStereo, 10:
	 *            SPSF_12kHz16BitMono, 11: SPSF_12kHz16BitStereo, 12:
	 *            SPSF_16kHz8BitMono, 13: SPSF_16kHz8BitStereo, 14:
	 *            SPSF_16kHz16BitMono, 15: SPSF_16kHz16BitStereo, 16:
	 *            SPSF_22kHz8BitMono, 17: SPSF_22kHz8BitStereo, 18:
	 *            SPSF_22kHz16BitMono[prefer], 19: SPSF_22kHz16BitStereo, 20:
	 *            SPSF_24kHz8BitMono, 21: SPSF_24kHz8BitStereo, 22:
	 *            SPSF_24kHz16BitMono, 23: SPSF_24kHz16BitStereo, 24:
	 *            SPSF_32kHz8BitMono, 25: SPSF_32kHz8BitStereo, 26:
	 *            SPSF_32kHz16BitMono, 27: SPSF_32kHz16BitStereo, 28:
	 *            SPSF_44kHz8BitMono, 29: SPSF_44kHz8BitStereo, 30:
	 *            SPSF_44kHz16BitMono, 31: SPSF_44kHz16BitStereo, 32:
	 *            SPSF_48kHz8BitMono, 33: SPSF_48kHz8BitStereo, 34:
	 *            SPSF_48kHz16BitMono, 35: SPSF_48kHz16BitStereo
	 * @param text
	 *            synthesis text. support XML synthesis markup. <br/> <a
	 *            href=http://msdn.microsoft.com/en-us/library/ms717077%28VS.85%29.aspx>http://msdn.microsoft.com/en-us/library/ms717077%28VS.85%29.aspx</a>
	 * 
	 */
	private native byte[] nativeSynthesis(String text, int speakerIndex, int audioFormat);
	private static MsTts instance = null;
	
	private MsTts()
	{
		super();
		
		if(INITIALIZED == false)
		{
			if(nativeInitialize())
				INITIALIZED = true;
		}
		
		setAudioFormat(MS_AUDIO_FORMAT);
		setCurrentVoice(getDefaultVoice());
		setSpeechRate(new TtsProperty(0, 20, 2, 10, true));
		setVolume(new TtsProperty(0, 100, 10, 100, true));
		setPitch(new TtsProperty(0, 20, 2, 10, true));
	}
	
	public static MsTts getInstance()
	{
		if(instance == null)
		{
			synchronized(MsTts.class)
			{
				if(instance == null)
					instance = new MsTts();
			}
		}
		return instance;
	}

	@Override
	protected void finalize() throws Throwable
	{
		if(INITIALIZED)
		{
			INITIALIZED = false;
			nativeUnInitialize();
		}
		super.finalize();
	}

	@Override
	public void execute(String text)
	{
		List<Exception> exceptionList = new ArrayList<Exception>();
		
		try
		{
			if(INITIALIZED == false)
				throw new UnsupportedOperationException();
			
			int voiceIndex = getVoices().indexOf(getCurrentVoice());
			if(voiceIndex < 0)
				throw new InvalidTtsVoiceException();
			
			String xmlText = "<rate absspeed=\""
				+ (getSpeechRate().getValue() - 10)
				+ "\">"
				+ "<volume level=\""
				+ getVolume().getValue()
				+ "\">"
				+ "<pitch absmiddle=\""
				+ (getPitch().getValue() - 10)
				+ "\">"
				+ text
				+ "</pitch>"
				+ "</volume>"
				+ "</rate>";
			
			byte[] audio = nativeSynthesis(xmlText, voiceIndex, DEFAULT_AUDIO_FORMAT_NUMBER);
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
		int numberOfSpeakers = nativeGetNumberOfSpeakers();
		
		for(int i = 0; i < numberOfSpeakers; i++)
		{
			String voiceName = nativeGetSpeakerName(i);
			StringTokenizer tok = new StringTokenizer(nativeGetLanguageID(i), ";");
			int id = Integer.parseInt(tok.nextToken(), 16);
			TtsLanguage lang = MsTtsLanguage.getTtsLanguageById(id);
			
			voices.add(new TtsVoice(
					this, // engine
					"org.roboid.audio.tts.mssapi." + voiceName, // voice id
					voiceName, // voice name
					lang, // language
					TtsVoice.Age.DONT_CARE,
					TtsVoice.Gender.DONT_CARE,
					TtsVoice.Style.STANDARD,
					TtsVoice.Domain.GENERAL));
		}
		return voices;
	}

	public int getNumberOfSpeakers()
	{
		return nativeGetNumberOfSpeakers();
	}
	
	public String[] getSpeakerNames()
	{
		int numberOfNames = nativeGetNumberOfSpeakers();
		String ret[] = new String[numberOfNames];
		for(int i = 0; i < numberOfNames; i++)
			ret[i] = nativeGetSpeakerName(i);
		return ret;
	}

	public String getLanguageID(int speakerIndex)
	{
		return nativeGetLanguageID(speakerIndex);
	}
	
	public AudioInputStream synthesis(String text, int speakerIndex, int speed, int volume, int pitch)
	{
		String xmlText = "<rate absspeed=\""
				+ speed
				+ "\">"
				+ "<volume level=\""
				+ volume
				+ "\">"
				+ "<pitch absmiddle=\""
				+ pitch
				+ "\">"
				+ text
				+ "</pitch>"
				+ "</volume>"
				+ "</rate>";

		byte[] audio = nativeSynthesis(xmlText, speakerIndex, DEFAULT_AUDIO_FORMAT_NUMBER);
		return AudioUtil.getAudioInputStream(MS_AUDIO_FORMAT, audio);
	}

	public void writeToFile(String text, File file, int speakerIndex, int speed, int volume, int pitch) throws IOException
	{
		AudioInputStream audio = synthesis(text, speakerIndex, speed, volume, pitch);
		AudioUtil.write(audio, AudioFileFormat.Type.WAVE, file);
	}
}
