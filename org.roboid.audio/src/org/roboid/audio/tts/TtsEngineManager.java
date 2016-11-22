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

import java.util.ArrayList;
import java.util.List;

import org.roboid.audio.tts.aquest.AquestTts;
import org.roboid.audio.tts.freetts.FreeTts;
import org.roboid.audio.tts.hci.HciTts;
import org.roboid.audio.tts.hci.HciVc;
import org.roboid.audio.tts.mssapi.MsTts;


/**
 * 
 * TTS 엔진을 관리하는 클래스입니다.
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsEngineManager
{
	/**
	 * TTS 엔진들 목록
	 */
	private static final AbstractTts[] engineArray = {
		MsTts.getInstance(),
		HciTts.getInstance(),
//		FreeTts.getInstance(),
		AquestTts.getInstance()
	};
	
	private static final AbstractVc[] vcArray = {
		NullVc.getInstance(),
		HciVc.getInstance()
	};

	/**
	 * 목소리 목록
	 */
	private static List<TtsVoice> voices = null;
	private static List<TtsVoiceEffect> voiceEffects = null;
	private static TtsEngineManager instance = null;

	private TtsEngineManager()
	{
		super();
		voices = createVoices();
		voiceEffects = createVoiceEffects();
	}
	
	/**
	 * 
	 * TtsEngineManager의 인스턴스를 받아옵니다.
	 * 
	 * @return
	 */
	public static TtsEngineManager getInstance()
	{
		if(instance == null)
		{
			synchronized(TtsEngineManager.class)
			{
				if(instance == null)
					instance = new TtsEngineManager();
			}
		}

		return instance;
	}

	public AbstractTts[] getEngines()
	{
		return TtsEngineManager.engineArray;
	}

	public List<TtsVoice> getVoices()
	{
		if(voices == null)
			voices = createVoices();
		return voices;
	}
	
	public List<TtsVoice> getVoices(TtsVoice filter)
	{
		if(voices == null)
			voices = createVoices();
		
		if(filter == null) return voices;
		
		List<TtsVoice> selectedVoices = new ArrayList<TtsVoice>();
		for(TtsVoice voice : voices)
		{
			if(voice.isAccepted(filter))
				selectedVoices.add(voice);
		}
		return selectedVoices;
	}
	
	public List<TtsVoiceEffect> getVoiceEffects()
	{
		if(voiceEffects == null)
			voiceEffects = createVoiceEffects();
		return voiceEffects;
	}
	
	private List<TtsVoice> createVoices()
	{
		List<TtsVoice> voiceList = new ArrayList<TtsVoice>();
		for(AbstractTts engine : engineArray)
		{
			for(TtsVoice voice : engine.getVoices())
				voiceList.add(voice);
		}
		return voiceList;
	}
	
	private List<TtsVoiceEffect> createVoiceEffects()
	{
		List<TtsVoiceEffect> voiceEffectList = new ArrayList<TtsVoiceEffect>();
		for(AbstractVc vc : vcArray)
		{
			for(TtsVoiceEffect effect : vc.getVoiceEffects())
				voiceEffectList.add(effect);
		}
		return voiceEffectList;
	}

	public List<TtsVoice> getVoicesByLanguageId(String languageId)
	{
		ArrayList<TtsVoice> selectedVoices = new ArrayList<TtsVoice>();
		for(TtsVoice voice : voices)
		{
			if(voice.getLanguage().getId().equalsIgnoreCase(languageId))
				selectedVoices.add(voice);
		}
		return selectedVoices;
	}
	
	public TtsVoice getVoiceById(String id)
	{
		for(TtsVoice voice : voices)
		{
			if(voice.getVoiceId().equalsIgnoreCase(id))
				return voice;
		}
		return null;
	}
	
	public TtsVoiceEffect getVoiceEffectById(String id)
	{
		for(TtsVoiceEffect effect : voiceEffects)
		{
			if(effect.getId().equalsIgnoreCase(id))
				return effect;
		}
		return null;
	}

	public List<TtsLanguage> getAvailableLanguages()
	{
		List<TtsLanguage> languageList = new ArrayList<TtsLanguage>();
		for(TtsVoice voice : voices)
		{
			if(languageList.indexOf(voice.getLanguage()) < 0)
				languageList.add(voice.getLanguage());
		}
		return languageList;
	}
}
