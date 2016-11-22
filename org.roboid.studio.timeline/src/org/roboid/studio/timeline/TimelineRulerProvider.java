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

package org.roboid.studio.timeline;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.roboid.studio.timeline.commands.CreateGuideCommand;
import org.roboid.studio.timeline.commands.DeleteGuideCommand;
import org.roboid.studio.timeline.commands.MoveGuideCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.rulers.RulerChangeListener;
import org.eclipse.gef.rulers.RulerProvider;

/**
 * @author Kyoung Jin Kim
 */
public class TimelineRulerProvider extends RulerProvider
{
	private TimelineRuler ruler;

	public TimelineRulerProvider(TimelineRuler ruler) 
	{
		this.ruler = ruler;
		this.ruler.addPropertyChangeListener(rulerListener);
		
		List<TimelineGuide> guides = getGuides();
		for(int i = 0; i < guides.size(); i ++) 
		{
			guides.get(i).addPropertyChangeListener(guideListener);
		}
	}
	
	private PropertyChangeListener rulerListener = new PropertyChangeListener() 
	{
		public void propertyChange(PropertyChangeEvent evt) 
		{
			if(evt.getPropertyName().equals(TimelineRuler.PROPERTY_CHILDREN))
			{
				TimelineGuide guide = (TimelineGuide)evt.getNewValue();
				if(getGuides().contains(guide))
				{
					guide.addPropertyChangeListener(guideListener);
				} 
				else 
				{
					guide.removePropertyChangeListener(guideListener);
				}
				
				for(int i = 0; i < listeners.size(); i ++)
				{
					((RulerChangeListener)listeners.get(i)).notifyGuideReparented(guide);
				}
			} 
			else
			{
				for (int i = 0; i < listeners.size(); i++) 
				{
					((RulerChangeListener)listeners.get(i)).notifyUnitsChanged(ruler.getUnit());
				}
			}
		}
	};

	private PropertyChangeListener guideListener = new PropertyChangeListener() 
	{
		public void propertyChange(PropertyChangeEvent evt) 
		{
			for(int i = 0; i < listeners.size(); i ++) 
			{
				((RulerChangeListener)listeners.get(i)).notifyGuideMoved(evt.getSource());
			}
		}
	};

	public Command getCreateGuideCommand(int position)
	{
		return new CreateGuideCommand(ruler, position);
	}

	public Command getDeleteGuideCommand(TimelineGuide guide)
	{
		return new DeleteGuideCommand(guide, ruler);
	}

	public Command getMoveGuideCommand(TimelineGuide guide, int pDelta)
	{
		return new MoveGuideCommand(guide, pDelta);
	}

	public int[] getGuidePositions()
	{
		List<TimelineGuide> guides = getGuides();
		int[] result = new int[guides.size()];
		
		for(int i = 0; i < guides.size(); i ++)
		{
			result[i] = guides.get(i).getPosition();
		}
		return result;
	}

	public Object getRuler()
	{
		return ruler;
	}

	public int getUnit()
	{
		return ruler.getUnit();
	}

	public void setUnit(int newUnit)
	{
		ruler.setUnit(newUnit);
	}

	public int getGuidePosition(TimelineGuide guide)
	{
		return guide.getPosition();
	}

	public List<TimelineGuide> getGuides()
	{
		return ruler.getGuides();
	}
}
