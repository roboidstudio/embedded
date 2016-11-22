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

import javax.sound.sampled.AudioFormat;

import com.sun.speech.freetts.audio.AudioPlayer;

/**
 * @author Kwang-Hyun Park
 */
class AudioInputStreamAudioPlayer implements AudioPlayer
{
	private float volume;
	private FreeTts tts;

	public AudioInputStreamAudioPlayer(FreeTts tts)
	{
		this.tts = tts;
	}

	@Override
	public void close()
	{
		// 이 함수는 호출되지 않습니다.
	}
	
	@Override
	public void begin(int size)
	{
	}

	@Override
	public boolean end()
	{
		return true;
	}
	
	@Override
	public void cancel()
	{
	}

	@Override
	public boolean drain()
	{
		return true;
	}

	@Override
	public AudioFormat getAudioFormat()
	{
		return tts.getAudioFormat();
	}

	@Override
	public void setAudioFormat(AudioFormat audioFormat)
	{
		tts.setAudioFormat(audioFormat);
	}
	
	@Override
	public float getVolume()
	{
		return volume;
	}

	@Override
	public void setVolume(float f)
	{
		this.volume = f;
	}
	
	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
	
	@Override
	public void reset()
	{
	}

	@Override
	public void startFirstSampleTimer()
	{
		// 가장 처음에 호출되는 함수 
	}
	
	@Override
	public long getTime()
	{
		return -1L;
	}
	
	@Override
	public void resetTime()
	{
	}

	@Override
	public void showMetrics()
	{
	}

	@Override
	public boolean write(byte[] audio)
	{
		return write(audio, 0, audio.length);
	}

	@Override
	public boolean write(byte[] audio, int offset, int len)
	{
		tts.write(audio, offset, len);
		return true;
	}
}
