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

import org.eclipse.swt.graphics.RGB;
import org.roboid.studio.timeline.TimelineFactory;

/**
 * @author Kwang-Hyun Park
 */
class DualLedPoint extends ControlPoint
{
	private static final long serialVersionUID = 1L;
	private int[] color;
	
	private RGB getColor()
	{
		if(color == null) color = new int[2];
		RGB rgb = new RGB(0,0,0);
		if(color.length > 0) rgb.red = color[0];
		if(color.length > 1) rgb.green = color[1];
		return rgb;
	}
	
	@Override
	org.roboid.studio.timeline.ColorPoint toVersion1_4(org.roboid.studio.timeline.ChannelTrack parent)
	{
		org.roboid.studio.timeline.ColorPoint newPoint = TimelineFactory.eINSTANCE.createColorPoint();
		copyTo(newPoint);
		newPoint.setColor(getColor());
		return newPoint;
	}
}
