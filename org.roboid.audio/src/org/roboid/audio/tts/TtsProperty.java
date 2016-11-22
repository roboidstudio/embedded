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
public class TtsProperty
{
	private boolean enabled;
	private int minValue;
	private int maxValue;
	private int gridValue; // page increment
	private int defaultValue;
	private int currentValue;
	
	public TtsProperty()
	{
	}
	
	public TtsProperty(int minValue, int maxValue, int defaultValue, boolean enabled)
	{
		this(minValue, maxValue, (maxValue - minValue) / 10, defaultValue, enabled);
	}
	
	public TtsProperty(TtsProperty p)
	{
		this(p.getMin(), p.getMax(), p.getGrid(), p.getDefault(), p.isEnabled());
	}
	
	public TtsProperty(int minValue, int maxValue, int gridValue, int defaultValue, boolean enabled)
	{
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.gridValue = gridValue;
		this.defaultValue = defaultValue;
		this.currentValue = defaultValue;
		this.enabled = enabled;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public int getMin()
	{
		return minValue;
	}
	
	public void setMin(int minValue)
	{
		this.minValue = minValue;
	}
	
	public int getMax()
	{
		return maxValue;
	}
	
	public void setMax(int maxValue)
	{
		this.maxValue = maxValue;
	}
	
	public int getGrid()
	{
		return gridValue;
	}
	
	public void setGrid(int gridValue)
	{
		this.gridValue = gridValue;
	}
	
	public int getDefault()
	{
		return defaultValue;
	}
	
	public void setDefault(int defaultValue)
	{
		this.defaultValue = defaultValue;
	}
	
	public int getValue()
	{
		return currentValue;
	}
	
	public void setValue(int value)
	{
		if(value > maxValue) value = maxValue;
		else if(value < minValue) value = minValue;
		this.currentValue = value;
	}
	
	public void reset()
	{
		setValue(defaultValue);
	}
}
