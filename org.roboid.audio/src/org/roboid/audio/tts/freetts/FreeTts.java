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

package org.roboid.audio.tts.freetts;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.speech.Central;
import javax.speech.EngineList;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

import org.roboid.audio.tts.AbstractTts;
import org.roboid.audio.tts.InvalidTtsVoiceException;
import org.roboid.audio.tts.TtsLanguage;
import org.roboid.audio.tts.TtsProperty;
import org.roboid.audio.tts.TtsVoice;

import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;

/**
 * TTS 라이브러리인 FreeTTS를 사용할 수 있도록 하는 클래스입니다.
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class FreeTts extends AbstractTts
{
	/**
	 * TTS를 사용하는데 필수적인 파일들의 경로들입니다.
	 */
	private static final File[] propertyFiles = {
										new File("." + File.separator + "voices.txt"),
										new File(System.getProperty("java.home") + File.separator + "lib" + File.separator + "speech.properties")
										};

	static
	{
		try
		{
			copyPropertyFiles(); // TTS에 필요한 파일들을 시스템 디렉토리에 복사
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		// 복사한 파일들을 Virtual Machine이 종료되면 삭제되도록 함
		deletePropertyFilesOnExit();
	}
	
	private com.sun.speech.freetts.Voice freeTtsVoice = null;
	private static FreeTts instance = null;

	private FreeTts()
	{
		super();
		setCurrentVoice(getDefaultVoice());
		setSpeechRate(new TtsProperty(0, 400, 10, 150, true));
		setVolume(new TtsProperty(0, 10, 2, 10, true));
		setPitch(new TtsProperty(50, 200, 10, 100, true));
		setPitchRange(new TtsProperty(0, 50, 10, 10, true));
	}
	
	public static FreeTts getInstance()
	{
		if(instance == null)
		{
			synchronized(FreeTts.class)
			{
				if(instance == null)
					instance = new FreeTts();
			}
		}
		return instance;
	}

	/**
	 * TTS에 필수적인 파일들을 지정된 위치에 복사합니다. 필수적인 파일들은
	 * <code>FreeTts.propertyFiles</code>에 저장되어 있습니다.
	 * 
	 * @see FreeTts#propertyFiles
	 * @throws IOException
	 */
	private static void copyPropertyFiles() throws IOException
	{
		for(File f : propertyFiles)
		{
			if(!f.exists() || !f.canRead() || !f.isFile())
			{
				// TTS를 사용하는데 필수적인 파일들이 지정된 경로에 없을 경우 파일들을 지정된 경로에 복사한다.
				BufferedInputStream src = new BufferedInputStream(FreeTts.class.getResourceAsStream(f.getName()));
				FileOutputStream dest = new FileOutputStream(f);
				byte buffer[] = new byte[1024 * 50];
				int readBytes = 0;
				while((readBytes = src.read(buffer)) != -1)
				{
					if(buffer.length > readBytes)
						buffer = Arrays.copyOf(buffer, readBytes);
					dest.write(buffer);
				}
				src.close();
				dest.close();
			}
		}
	}

	/**
	 * TTS에 필수적인 파일들을 Java Virtual Machine이 종료될 때 삭제하도록 합니다.
	 */
	private static void deletePropertyFilesOnExit()
	{
		for(File f : propertyFiles)
		{
			if(f.exists())
				f.deleteOnExit();
		}
	}
	
	@Override
	public void execute(String text)
	{
		List<Exception> exceptionList = new ArrayList<Exception>();
		try
		{
			if(freeTtsVoice == null)
				throw new InvalidTtsVoiceException();
			AudioPlayer audioPlayer = new AudioInputStreamAudioPlayer(this);
			freeTtsVoice.setAudioPlayer(audioPlayer);
			freeTtsVoice.startBatch();
			freeTtsVoice.speak(text);
			freeTtsVoice.endBatch();
		}
		catch (InvalidTtsVoiceException e)
		{
			exceptionList.add(e);
		}

		complete(exceptionList);
	}
	
	@Override
	public boolean dispose()
	{
		if(freeTtsVoice != null)
		{
			if(freeTtsVoice.isLoaded())
				freeTtsVoice.deallocate();
			freeTtsVoice = null;
		}
		return super.dispose();
	}
	
	@Override
	public void setCurrentVoice(TtsVoice voice)
	{
		if(voice == null) return;
		
		// voice가 이미 할당되어 있으면 deallocate한 후 새로운 목소리 할당
		if(freeTtsVoice != null)
			dispose();

		// 새로운 voice 할당
		VoiceManager manager = VoiceManager.getInstance();
		int index = voice.getVoiceId().lastIndexOf('.');
		String speaker = voice.getVoiceId().substring(index+1);
		freeTtsVoice = manager.getVoice(speaker);
		if(freeTtsVoice != null)
			freeTtsVoice.allocate();
		
		super.setCurrentVoice(voice);
	}
	
	/* (non-Javadoc)
	 * @see org.roboid.audio.tts.TtsModel#availableVoices(org.roboid.audio.tts.Voice)
	 */
	@Override
	protected List<TtsVoice> createVoices()
	{
		List<TtsVoice> voices = new ArrayList<TtsVoice>();
		EngineList engineList = Central.availableSynthesizers(null);
		if(engineList == null) return voices;

		// 엔진 리스트 
		for(int i = 0; i < engineList.size(); i++)
		{
			// 엔진의 정보를 받아온다.
			SynthesizerModeDesc desc = (SynthesizerModeDesc)engineList.get(i);
			if(desc == null) continue;

			// 엔진 별 목소리 리스트 
			Voice[] engineVoices = desc.getVoices();
			if(engineVoices == null) continue;
			
			for(Voice voice: engineVoices)
			{
				String voiceName = voice.getName(); // 목소리 이름
				String languageId = desc.getLocale().getLanguage() + "-" + desc.getLocale().getCountry(); // 언어
				TtsLanguage lang = TtsLanguage.findById(languageId);

				// 나이
				TtsVoice.Age age = TtsVoice.Age.DONT_CARE;
				switch(voice.getAge())
				{
				case Voice.AGE_CHILD:
					age = TtsVoice.Age.CHILD;
					break;
				case Voice.AGE_TEENAGER:
					age = TtsVoice.Age.TEENAGER;
					break;
				case Voice.AGE_YOUNGER_ADULT:
					age = TtsVoice.Age.YOUNGER_ADULT;
					break;
				case Voice.AGE_MIDDLE_ADULT:
					age = TtsVoice.Age.MIDDLE_ADULT;
					break;
				case Voice.AGE_OLDER_ADULT:
					age = TtsVoice.Age.OLDER_ADULT;
					break;
				case Voice.AGE_NEUTRAL:
					age = TtsVoice.Age.INDETERMINATE;
					break;
				}

				// 성별
				TtsVoice.Gender gender = TtsVoice.Gender.DONT_CARE;
				switch(voice.getGender())
				{
				case Voice.GENDER_MALE:
					gender = TtsVoice.Gender.MALE;
					break;
				case Voice.GENDER_FEMALE:
					gender = TtsVoice.Gender.FEMALE;
					break;
				case Voice.GENDER_NEUTRAL:
					gender = TtsVoice.Gender.NEUTRAL;
					break;
				}

				// style
				TtsVoice.Style style = TtsVoice.Style.DONT_CARE;
				if(voice.getStyle().equalsIgnoreCase("standard"))
					style = TtsVoice.Style.STANDARD;

				// domain
				TtsVoice.Domain domain = TtsVoice.Domain.DONT_CARE;
				if(desc.getModeName().equalsIgnoreCase("general"))
					domain = TtsVoice.Domain.GENERAL;
				else if (desc.getModeName().equalsIgnoreCase("time"))
					domain = TtsVoice.Domain.TIME;

				// list에 추가
				voices.add(new TtsVoice(
						this, // engine
						"org.roboid.audio.tts.freetts." + voiceName, // voice id
						"FreeTts " + voiceName, // voice name
						lang, // language
						age,
						gender,
						style,
						domain));
			}
		}
		return voices;
	}

	@Override
	public void setSpeechRate(TtsProperty speechRate)
	{
		super.setSpeechRate(speechRate);
		if(freeTtsVoice != null)
			freeTtsVoice.setRate(getSpeechRate().getValue());
	}
	
	@Override
	public void setSpeechRateValue(int speakRate)
	{
		super.setSpeechRateValue(speakRate);
		if(freeTtsVoice != null)
			freeTtsVoice.setRate(getSpeechRate().getValue());
	}

	@Override
	public void setVolume(TtsProperty volume)
	{
		super.setVolume(volume);
		if(freeTtsVoice != null)
			freeTtsVoice.setVolume(getVolume().getValue() / 20.0f + 0.5f);
	}
	
	@Override
	public void setVolumeValue(int volume)
	{
		super.setVolumeValue(volume);
		if(freeTtsVoice != null)
			freeTtsVoice.setVolume(getVolume().getValue() / 20.0f + 0.5f);
	}

	@Override
	public void setPitch(TtsProperty pitch)
	{
		super.setPitch(pitch);
		if(freeTtsVoice != null)
			freeTtsVoice.setPitch(getPitch().getValue());
	}
	
	@Override
	public void setPitchValue(int pitch)
	{
		super.setPitchValue(pitch);
		if(freeTtsVoice != null)
			freeTtsVoice.setPitch(getPitch().getValue());
	}

	@Override
	public void setPitchRange(TtsProperty pitchRange)
	{
		super.setPitchRange(pitchRange);
		if(freeTtsVoice != null)
			freeTtsVoice.setPitchRange(getPitchRange().getValue());
	}
	
	@Override
	public void setPitchRangeValue(int pitchRange)
	{
		super.setPitchRangeValue(pitchRange);
		if(freeTtsVoice != null)
			freeTtsVoice.setPitchRange(getPitchRange().getValue());
	}
}
