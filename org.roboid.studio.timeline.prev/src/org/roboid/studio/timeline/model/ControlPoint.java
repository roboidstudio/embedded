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

import org.eclipse.draw2d.geometry.Rectangle;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kwang-Hyun Park
 */
abstract class ControlPoint extends AbstractModel
{
	private static final long serialVersionUID = 8871011654483378401L;
	private Rectangle constraint;
	
	private Rectangle getConstraint()
	{
		if(constraint == null) constraint = new Rectangle(0, MotionClip.CHANNEL_TRACK_HEIGHT_GAP, 7, 16);
		else constraint.y = MotionClip.CHANNEL_TRACK_HEIGHT_GAP;
		return constraint;
	}
	
	abstract org.roboid.studio.timeline.ControlPoint toVersion1_4(org.roboid.studio.timeline.ChannelTrack parent);
	
	void copyTo(org.roboid.studio.timeline.ControlPoint newPoint)
	{
		newPoint.setConstraint(getConstraint());
	}
}
