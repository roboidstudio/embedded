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


/**
 * HCILAB 음성 합성 모드를 설정합니다.
 * 
 * @author Tae-hoon Kim
 */
public enum HciVcMode
{
	CAVE(7, Messages.HciVcMode_Cave),
	CHUJUK60MIN(2, Messages.HciVcMode_ChuJeok60Min),
	ECHO(6, Messages.HciVcMode_Echo),
	FOREIGNER(5, Messages.HciVcMode_Foreigner),
	GHOST(8, Messages.HciVcMode_Ghost),
	JOLAMAN(1, Messages.HciVcMode_Jolaman),
	PROTOSS(3, Messages.HciVcMode_Protoss),
	ROBOT(4, Messages.HciVcMode_Robot);

	private int mode;
	private String name;

	HciVcMode(int mode, String name)
	{
		this.mode = mode;
		this.name = name;
	}

	/**
	 * HCILab Library에서 사용하는 모드 넘버
	 * 
	 * @return
	 */
	public int getVCModeCode()
	{
		return mode;
	}

	/**
	 * 음성 변조 이름
	 * 
	 * @return
	 */
	public String getVCName()
	{
		return name;
	}

}
