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
class TextPoint extends ControlPoint
{
	private static final long serialVersionUID = 1L;
	private String text;
	
	private String getText()
	{
		if(text == null) text = "";
		return text;
	}
	
	@Override
	org.roboid.studio.timeline.TextPoint toVersion1_4(org.roboid.studio.timeline.ChannelTrack parent)
	{
		org.roboid.studio.timeline.TextPoint newPoint = TimelineFactory.eINSTANCE.createTextPoint();
		copyTo(newPoint);
		newPoint.setText(getText());
		return newPoint;
	}
}
