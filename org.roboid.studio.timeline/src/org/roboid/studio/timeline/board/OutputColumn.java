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

package org.roboid.studio.timeline.board;

/**
 * @author Kwang-Hyun Park
 */
public final class OutputColumn
{
	private final int startFrame;
	private final int endFrame;
	private final OutputCurve[] curves;
	
	public OutputColumn(int numCurves, int startFrame, int endFrame)
	{
		this.startFrame = startFrame;
		this.endFrame = endFrame;
		curves = new OutputCurve[numCurves];
	}
	
	public int getStartFrame()
	{
		return startFrame;
	}
	
	public int getEndFrame()
	{
		return endFrame;
	}
	
	public int countCurves()
	{
		return curves.length;
	}
	
	public OutputCurve getCurve(int index)
	{
		if(index < 0 || index >= curves.length) return null;
		return curves[index];
	}
	
	public void setCurve(int index, OutputCurve curve)
	{
		if(index < 0 || index >= curves.length) return;
		curves[index] = curve;
	}
}
