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

package org.roboid.audio.epd.hci;

import javax.sound.sampled.AudioInputStream;

/**
 * EPD 결과
 * 
 * @author Tae-hoon Kim
 * 
 */
public class HciEpdResult
{

	private AudioInputStream epdData = null;
	private boolean isSuccess = false;

	HciEpdResult(boolean isSuccess, AudioInputStream epdAudioInputStream)
	{
		super();
		this.isSuccess = isSuccess;
		this.epdData = epdAudioInputStream;
	}

	/**
	 * epd를 통해 추출한 결과
	 * 
	 * @return
	 */
	public AudioInputStream getEpdAudioInputStream()
	{
		return epdData;
	}

	/**
	 * epd 추출에 성공 했는지 여부
	 * 
	 * @return
	 */
	public boolean isSuccess()
	{
		return isSuccess;
	}

	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("IsSuccess:").append(isSuccess).append(", ")
				.append("EpdAudioInputStream:").append(epdData);
		return buffer.toString();
	}

}
