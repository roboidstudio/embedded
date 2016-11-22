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

package org.roboid.audio.tts.hci;

import hcilab.HciException;
import hcilab.IStream;
import hcilab.StreamInfo;
import hcilab.TtsLib;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;

import org.roboid.audio.hci.HciOuterException;
import org.roboid.audio.tts.AbstractTts;
import org.roboid.audio.tts.InvalidTtsVoiceException;
import org.roboid.audio.tts.TtsLanguage;
import org.roboid.audio.tts.TtsProperty;
import org.roboid.audio.tts.TtsVoice;


/**
 * TTS 음성합성
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class HciTts extends AbstractTts
{
	private static final AudioFormat HCI_AUDIO_FORMAT = new AudioFormat(16000, 16, 1, true, false);
	private Thread ttsThread;
	private volatile long ttsThreadHashCode;
	private static HciTts instance = null;
	
	private HciTts()
	{
		super();
		setAudioFormat(HCI_AUDIO_FORMAT);
		setCurrentVoice(getDefaultVoice());
		setSpeechRate(new TtsProperty(50, 200, 10, 100, false));
		setVolume(new TtsProperty(50, 150, 10, 150, false));
		setPitch(new TtsProperty(80, 120, 10, 100, false));
	}
	
	public static HciTts getInstance()
	{
		if(instance == null)
		{
			synchronized(HciTts.class)
			{
				if(instance == null)
					instance = new HciTts();
			}
		}
		return instance;
	}

	@Override
	public void execute(String text)
	{
		try
		{
			// 새로운 스레드 생성 
			String threadName = "HCI TTS Thread : " + text.substring(0, Math.min(text.length(), 10)); //$NON-NLS-1$
			ttsThread = new HciTtsThread(threadName, new String(text.getBytes(), "euc-kr")); //$NON-NLS-1$
			ttsThreadHashCode = ttsThread.hashCode();
			ttsThread.start();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected List<TtsVoice> createVoices()
	{
		List<TtsVoice> voices = new ArrayList<TtsVoice>();

		voices.add(new TtsVoice(this,
								"org.roboid.audio.tts.hci.아람", // voice id //$NON-NLS-1$
								Messages.HciTts_Aram, // voice name
								TtsLanguage.KOREAN, // language
								TtsVoice.Age.YOUNGER_ADULT,
								TtsVoice.Gender.FEMALE,
								TtsVoice.Style.STANDARD,
								TtsVoice.Domain.GENERAL));

		voices.add(new TtsVoice(this,
								"org.roboid.audio.tts.hci.종필", // voice id //$NON-NLS-1$
								Messages.HciTts_JongPil, // voice name
								TtsLanguage.KOREAN, // language
								TtsVoice.Age.MIDDLE_ADULT,
								TtsVoice.Gender.MALE,
								TtsVoice.Style.STANDARD,
								TtsVoice.Domain.GENERAL));

		voices.add(new TtsVoice(this,
								"org.roboid.audio.tts.hci.미진", // voice id //$NON-NLS-1$
								Messages.HciTts_MiJin, // voice name
								TtsLanguage.KOREAN, // language
								TtsVoice.Age.MIDDLE_ADULT,
								TtsVoice.Gender.FEMALE,
								TtsVoice.Style.STANDARD,
								TtsVoice.Domain.GENERAL));
		return voices;
	}
	
	/**
	 * TTS Encoding Code
	 * 
	 * @author 김태훈(<a href="mailto:zyint.com@gmail.com">zyint.com@gmail.com</a>)
	 */
	public enum HciTtsEncoding
	{
		PTTS_ENCODING_ADPCM(5),
		PTTS_ENCODING_ALAW(3),
		PTTS_ENCODING_LINEAR16(0),
		PTTS_ENCODING_LINEAR8(1),
		PTTS_ENCODING_MULAW(2),
		PTTS_ENCODING_VOX(4);

		private int value;

		HciTtsEncoding(int value)
		{
			this.value = value;
		}

		public int getEncodingCode()
		{
			return value;
		}
	}

	/**
	 * TTS Thread
	 * 
	 * @author 김태훈(<a href="mailto:zyint.com@gmail.com">zyint.com@gmail.com</a>)
	 */
	class HciTtsThread extends Thread implements IStream
	{
		private final String TTS_SERVER_IP = "roboid.co.kr"; //$NON-NLS-1$
		private final int TTS_SERVER_PORT = 7000;
		private final HciTtsEncoding ENCODING = HciTtsEncoding.PTTS_ENCODING_LINEAR16;
		private String text;
		private List<Exception> exceptionList = new ArrayList<Exception>();

		public HciTtsThread(String name, String text)
		{
			super(name);
			this.text = text;
		}

		/**
		 * TTS 스트리밍 데이터가 올때마다 불려짐. 버퍼크기만큼 불려지므로 긴 TTS 문장의 경우 여러번 불리게 된다.
		 * 
		 * @see hcilab.IStream#getStreamData(hcilab.StreamInfo)
		 */
		public void getStreamData(StreamInfo sinfo)
		{
			// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
			if(ttsThreadHashCode != this.hashCode()) return;

			// 버퍼를 받았을 경우
			if(sinfo.getState() == TtsLib.STREAM_PROCESSING)
				write(sinfo.getBuffer());
		} // end getStreamData()

		@Override
		public void run()
		{
			// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
			if(ttsThreadHashCode != this.hashCode()) return;
			
			TtsLib lib = new TtsLib();
			try
			{
				lib.TTS_SCK_OPEN(TTS_SERVER_IP, TTS_SERVER_PORT);
				TtsVoice voice = getCurrentVoice();
				if(voice == null)
					throw new InvalidTtsVoiceException();
				int index = voice.getVoiceId().lastIndexOf('.');
				String speaker = voice.getVoiceId().substring(index+1);
				lib.TTS_SVC_OPEN(
						voice.getLanguage().getId(),
						speaker,
						ENCODING.getEncodingCode(),
						(int)HCI_AUDIO_FORMAT.getSampleRate(),
						getSpeechRate().getValue(),
						getVolume().getValue(),
						getPitch().getValue());

				// blocking method
				lib.TTS_SVC_TEXT_STREAM(text, 0, 0, this);
				// -- blocking method end
			}
			catch (HciException e)
			{
				// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
				if(ttsThreadHashCode != hashCode()) return;
				exceptionList.add(new HciOuterException(e));
			}
			catch (InvalidTtsVoiceException e)
			{
				exceptionList.add(e);
			}
			catch (Exception e)
			{
				// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
				if(ttsThreadHashCode != hashCode()) return;
				exceptionList.add(e);
			}
			finally
			{
				try
				{
					lib.TTS_SVC_CLOS();
				}
				catch (HciException e)
				{
					// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
					if(ttsThreadHashCode != this.hashCode()) return;
					exceptionList.add(new HciOuterException(e));
				}
				catch (Exception e)
				{
					// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
					if(ttsThreadHashCode != this.hashCode()) return;
					exceptionList.add(e);
				}
				
				try
				{
					lib.TTS_SCK_CLOS();
				}
				catch (HciException e)
				{
					// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
					if(ttsThreadHashCode != this.hashCode()) return;
					exceptionList.add(new HciOuterException(e));
				}
				catch (Exception e)
				{
					// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
					if(ttsThreadHashCode != hashCode()) return;
					exceptionList.add(e);
				}

				// 지금 TTS 결과값이 예전 스레드에 의해서 생긴 경우 결과를 무시해버린다.
				if(ttsThreadHashCode != this.hashCode()) return;
				complete(exceptionList);
			}
		} // end run()
	} // end TTSThread
}
