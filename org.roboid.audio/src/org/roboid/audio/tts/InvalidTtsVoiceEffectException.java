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
 * @author Kwang-Hyun Park
 */
public class InvalidTtsVoiceEffectException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidTtsVoiceEffectException()
	{
		this(Messages.InvalidTtsVoiceEffectException_Message_Voice_effect_is_not_valid);
	}

	public InvalidTtsVoiceEffectException(String message)
	{
		super(message);
	}

	public InvalidTtsVoiceEffectException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InvalidTtsVoiceEffectException(Throwable cause)
	{
		super(cause);
	}
}
