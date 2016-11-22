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

package org.roboid.studio.timeline.property;

import org.eclipse.swt.graphics.RGB;
import org.roboid.robot.ColorMode;

/**
 * @author Kwang-Hyun Park
 */
public final class RgbColor
{
	private final ColorMode mode;
	private final RGB rgb;

	public RgbColor(ColorMode mode)
	{
		this(mode, new RGB(0,0,0));
	}
	
	public RgbColor(ColorMode mode, RGB rgb)
	{
		this.mode = mode;
		if(rgb == null) rgb = new RGB(0,0,0);
		checkRGB(rgb);
		this.rgb = rgb;
	}
	
	ColorMode getMode()
	{
		return mode;
	}
	
	public RGB getRGB()
	{
		return rgb;
	}
	
	private void checkRGB(RGB rgb)
	{
		if(mode == null) return;

		switch(mode.getValue())
		{
		case ColorMode.RED_GREEN_VALUE:
			rgb.blue = 0;
			break;
		case ColorMode.RED_VALUE:
			rgb.green = rgb.blue = 0;
			break;
		case ColorMode.GREEN_VALUE:
			rgb.red = rgb.blue = 0;
			break;
		case ColorMode.BLUE_VALUE:
			rgb.red = rgb.green = 0;
			break;
		case ColorMode.GRAY_VALUE:
			rgb.green = rgb.blue = rgb.red;
			break;
		}
	}
	
	String getLabelText()
	{
		if(mode == null) return "";
		
		switch(mode.getValue())
		{
		case ColorMode.RED_GREEN_VALUE:
			return "(" + rgb.red + "," + rgb.green + ")";
		case ColorMode.RED_VALUE:
			return "(" + rgb.red + ")";
		case ColorMode.GREEN_VALUE:
			return "(" + rgb.green + ")";
		case ColorMode.BLUE_VALUE:
			return "(" + rgb.blue + ")";
		case ColorMode.GRAY_VALUE:
			return "(" + rgb.red + ")";
		default:
			return "(" + rgb.red + "," + rgb.green + "," + rgb.blue + ")";
		}
	}

	@Override
	public boolean equals(Object object)
	{
		if(object == this) return true;
		if(!(object instanceof RgbColor)) return false;
		RgbColor color = (RgbColor)object;
		return color.rgb.equals(this.rgb) && (color.mode == this.mode);
	}

	@Override
	public int hashCode()
	{
		if(mode == null) return rgb.hashCode();
		else return (rgb.hashCode() << 8) | mode.getValue();
	}

	@Override
	public String toString()
	{
		if(mode == null) return "";
		
		switch(mode.getValue())
		{
		case ColorMode.RED_GREEN_VALUE:
			return "Dual Color {" + rgb.red + ", " + rgb.green + "}";
		case ColorMode.RED_VALUE:
			return "Mono Color {" + rgb.red + "}";
		case ColorMode.GREEN_VALUE:
			return "Mono Color {" + rgb.green + "}";
		case ColorMode.BLUE_VALUE:
			return "Mono Color {" + rgb.blue + "}";
		case ColorMode.GRAY_VALUE:
			return "Mono Color {" + rgb.red + "}";
		default:
			return "RGB {" + rgb.red + ", " + rgb.green + ", " + rgb.blue + "}";
		}
	}
}
