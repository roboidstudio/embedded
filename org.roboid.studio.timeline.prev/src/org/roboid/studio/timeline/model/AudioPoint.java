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

package org.roboid.studio.timeline.model;

import org.roboid.studio.timeline.TimelineFactory;

/**
 * @author Kwang-Hyun Park
 */
class AudioPoint extends ControlPoint
{
	private static final long serialVersionUID = 1L;
	private String text;
	private String fileName;
	private String voiceId;
	private String voiceEffectId;
	private int speechRate;
	private int volume;
	private int pitch;
	private int balance;
	private byte[] mp3Byte;
	private int lengthOfPCMInTimeline;

	private String getText()
	{
		if(text == null)
		{
			if(fileName == null) text = "";
			else text = fileName;
		}
		return text;
	}

	private String getVoiceId()
	{
		return voiceId;
	}

	private String getVoiceEffectId()
	{
		return voiceEffectId;
	}
	
	private int getSpeechRate()
	{
		return speechRate;
	}

	private int getVolume()
	{
		return volume;
	}

	private int getPitch()
	{
		return pitch;
	}
	
	private int getBalance()
	{
		return balance;
	}
	
	private byte[] getMp3Byte()
	{
		if(mp3Byte == null) mp3Byte = new byte[0];
		return mp3Byte;
	}

	private int getLength()
	{
		return lengthOfPCMInTimeline;
	}

	@Override
	org.roboid.studio.timeline.AudioPoint toVersion1_4(org.roboid.studio.timeline.ChannelTrack parent)
	{
		org.roboid.studio.timeline.AudioPoint newPoint = TimelineFactory.eINSTANCE.createAudioPoint();
		copyTo(newPoint);
		return newPoint;
	}
	
	@Override
	void copyTo(org.roboid.studio.timeline.ControlPoint newPoint)
	{
		super.copyTo(newPoint);
		((org.roboid.studio.timeline.AudioPoint)newPoint).setText(getText());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setVoiceId(getVoiceId());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setVoiceEffectId(getVoiceEffectId());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setSpeechRate(getSpeechRate());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setVolume(getVolume());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setPitch(getPitch());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setBalance(getBalance());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setMp3(getMp3Byte());
		((org.roboid.studio.timeline.AudioPoint)newPoint).setLength(getLength());
	}
}
