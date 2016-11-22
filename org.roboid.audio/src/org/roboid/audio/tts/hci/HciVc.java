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
import hcilab.PowerVC;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.roboid.audio.Activator;
import org.roboid.audio.AudioUtil;
import org.roboid.audio.hci.HciOuterException;
import org.roboid.audio.tts.AbstractVc;
import org.roboid.audio.tts.InvalidTtsVoiceEffectException;
import org.roboid.audio.tts.TtsVoiceEffect;

/**
 * 음성 변조
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class HciVc extends AbstractVc
{
	static
	{
		// 라이브러리 Path 추가하기
		try
		{
			File file = new File(Activator.findLibraryPath("PowerVC.dll"));
			Activator.addLibraryPath(file.getParentFile().getCanonicalPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.loadLibrary("PowerVC");
	}
	
	private static HciVc instance = null; 
	
	private HciVc()
	{
		super();
	}
	
	public static HciVc getInstance()
	{
		if(instance == null)
		{
			synchronized(HciVc.class)
			{
				if(instance == null)
					instance = new HciVc();
			}
		}
		return instance;
	}
	
	@Override
	public void execute(AudioInputStream audio)
	{
		List<Exception> exceptionList = new ArrayList<Exception>();
		try
		{
			int index = getVoiceEffects().indexOf(getCurrentVoiceEffect());
			if(index < 0 || index >= HciVcMode.values().length)
				throw new InvalidTtsVoiceEffectException();
			
			audio = convert(audio, HciVcMode.values()[index]);
		}
		catch (Exception e)
		{
			exceptionList.add(e);
		}
		
		complete(audio, exceptionList);
	}
	
	/**
	 * 음성 변조 함수
	 * 
	 * @param audio
	 *            변조할 음성 오디오 스트림
	 * @param vcMode
	 *            변조 모드
	 * @return 변조된 음성 오디오 스트림
	 * @throws org.roboid.audio.hci.HciOuterException
	 *             변조 과정중 예외 발생할 경우
	 * @throws IOException
	 *             입력 오디오 읽는 과정중 예외가 발생할 경우
	 * @throws UnsupportedAudioFileException
	 */
	public AudioInputStream convert(AudioInputStream audio, HciVcMode vcMode) throws IOException, HciOuterException, UnsupportedAudioFileException
	{
		PowerVC vc = new PowerVC();
		AudioInputStream convIn = AudioUtil.getConvertedInputStream(new AudioFormat(16000, 16, 1, true, false), audio);
		byte[] byteAudio = AudioUtil.getByteArrayHeaderless(convIn);
		byte[] byteResult = null;

		try
		{
			vc.HCI_VC_OPEN();
			vc.HCI_VC_CLEAR(vc.getPointer());
			byteResult = vc.HCIVoiceConv(byteAudio,
										byteAudio.length,
										vcMode.getVCModeCode(),
										HciVcEncoding.PCM.getVcEncodingCode(),
										(int)convIn.getFormat().getSampleRate(),
										vc.getPointer());
		}
		catch (HciException e)
		{
			throw new HciOuterException(e);
		}
		finally
		{
			if(vc != null && vc.getPointer() > 0)
			{
				try
				{
					vc.HCI_VC_CLOSE(vc.getPointer());
				}
				catch (HciException e)
				{
					throw new HciOuterException(e);
				}
			}
		}

		convIn = AudioUtil.getAudioInputStream(convIn.getFormat(), byteResult);
		try
		{
			convIn = AudioUtil.getConvertedInputStream(audio.getFormat(), convIn);
		} catch (UnsupportedAudioFileException e) // Kwang-Hyun Park
		{}
		return convIn;
	}
	
	@Override
	protected List<TtsVoiceEffect> createVoiceEffects()
	{
		List<TtsVoiceEffect> voiceEffects = new ArrayList<TtsVoiceEffect>();
		
		for(HciVcMode vc : HciVcMode.values())
		{
			voiceEffects.add(new TtsVoiceEffect(this,
										"org.roboid.audio.tts.hci.vc." + vc.getVCModeCode(),
										vc.getVCName()));
		}
		return voiceEffects;
	}
}
