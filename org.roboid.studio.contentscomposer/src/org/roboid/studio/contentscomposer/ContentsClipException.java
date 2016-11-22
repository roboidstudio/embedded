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

package org.roboid.studio.contentscomposer;

/**
 * @author Kwang-Hyun Park
 */
public class ContentsClipException extends Exception
{
	private static final long serialVersionUID = 1L;
	private int code;
	private MotionContent contentsClip;
	
	public ContentsClipException(int code)
	{
		this.code = code;
	}
	
	public ContentsClipException(int code, MotionContent contentsClip)
	{
		this(code);
		this.contentsClip = contentsClip;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public MotionContent getContentsClip()
	{
		return contentsClip;
	}
}
