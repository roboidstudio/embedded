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

package org.roboid.studio.timeline.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.CommandPoint;
import org.roboid.studio.timeline.CommandTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CommandTrackImpl extends ChannelTrackImpl implements CommandTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandTrackImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return TimelinePackage.Literals.COMMAND_TRACK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */

	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "Command Channel"; // 채널 이름
		return super.getPropertyValue(id);
	}
	
	@Override
	public ChannelTrack deepCopy()
	{
		CommandTrack newTrack = TimelineFactory.eINSTANCE.createCommandTrack();
		copyTo(newTrack);
		return newTrack;
	}
	
	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(CommandPointImpl.class))
			return true;
		return false;
	}

	@Override
	public CommandPoint deepCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(CommandPointImpl.class))
			return (CommandPoint)cp.deepCopy();
		return null;
	}

	// 한 프레임의 데이터를 디바이스에 쓴다.
	@Override
	public void dump(int frame)
	{
		if(initialValues == null)
		{
			if(getPoints().size() == 0) return;
			
			Device device = getTargetDevice(0);
			if(device == null) return; // 연결된 디바이스가 없다.
			
			for(ControlPoint cp : getPoints())
			{
				if(frame < cp.getFrame()) break;
				else if(frame > cp.getFrame()) continue;
				
				float[] values = ((CommandPointImpl)cp).getValues();
				int sz = Math.min(device.getDataSize(), values.length);
				if(sz > 0)
				{
					for(int j = 0; j < sz; j ++)
						device.write(j, values[j]);
				}
				else
					device.write();
			}
		}
		else
		{
			Device device = getTargetDevice(0);
			if(device == null) return; // 연결된 디바이스가 없다.
			
			int sz = getPoints().size();
			if(sz == 0)
			{
				if(frame == 0)
					device.write(initialValues);
			}
			else
			{
				if(frame == 0)
				{
					ControlPoint cp = getPoints().get(0);
					if(cp.getFrame() == 0)
					{
						float[] values = ((CommandPointImpl)cp).getValues();
						sz = Math.min(device.getDataSize(), values.length);
						if(sz > 0)
						{
							for(int j = 0; j < sz; j ++)
								device.write(j, values[j]);
						}
						else
							device.write();
					}
					else
						device.write(initialValues);
				}
				else
				{
					for(ControlPoint cp : getPoints())
					{
						if(frame < cp.getFrame()) break;
						else if(frame > cp.getFrame()) continue;
						
						float[] values = ((CommandPointImpl)cp).getValues();
						sz = Math.min(device.getDataSize(), values.length);
						if(sz > 0)
						{
							for(int j = 0; j < sz; j ++)
								device.write(j, values[j]);
						}
						else
							device.write();
					}
				}
			}
		}
	}
	
	@Override
	public float[] getValues(int frame)
	{
		List<ControlPoint> points = getPoints();
		int sz = points.size();
		if(sz > 0)
		{
			CommandPoint last = (CommandPoint)points.get(sz - 1);
			if(frame >= last.getFrame())
				return last.getValues();
			else
			{
				last = null;
				for(ControlPoint cp : getPoints())
				{
					if(frame < cp.getFrame()) break;
					else if(frame >= cp.getFrame()) last = (CommandPoint)cp;
				}
				if(last != null)
					return last.getValues();
			}
		}
		return initialValues;
	}
} //CommandTrackImpl
