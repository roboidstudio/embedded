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

import java.util.List;
import javax.sound.sampled.AudioInputStream;

/**
 * TTS 음성 합성시 일어나는 이벤트를 처리하는 리스너
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public interface TtsListener
{
	/**
	 * 음성 합성이 부분적으로 처리될 때마다 호출됩니다.
	 * @param len	합성된 음성 데이터 길이
	 */
	public void ttsUpdated(int len);

	/**
	 * 음성 합성이 끝날 때 호출됩니다.
	 * @param ais	목소리 음성 데이터
	 */
	public void ttsCompleted(AudioInputStream audio);
	
	/**
	 * 음성 합성 중 예외가 발생한 경우 호출됩니다.
	 * @param exceptions	발생된 예외들
	 */
	public void ttsExceptionOccured(List<Exception> exceptions);
}
