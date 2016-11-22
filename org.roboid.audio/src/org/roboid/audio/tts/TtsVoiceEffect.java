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

/**
 * 음성 변조 정보를 나타내는 클래스
 * 
 * @author Kwang-Hyun Park
 */
public class TtsVoiceEffect
{
	private AbstractVc engine;
	private String id;
	private String name;
	
	public TtsVoiceEffect(AbstractVc engine, String id, String name)
	{
		super();
		this.engine = engine;
		this.id = id;
		this.name = name;
	}
	
	public AbstractVc getEngine()
	{
		return engine;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("engine:")
				.append(engine)
				.append(", effect:")
				.append(name)
				.append("(")
				.append(id)
				.append(")");
		return sb.toString();
	}
}
