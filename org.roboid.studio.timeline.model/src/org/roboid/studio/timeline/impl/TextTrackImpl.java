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

import org.eclipse.emf.ecore.EClass;

import org.roboid.robot.Device;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TextPoint;
import org.roboid.studio.timeline.TextTrack;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TextTrackImpl extends ChannelTrackImpl implements TextTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextTrackImpl()
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
		return TimelinePackage.Literals.TEXT_TRACK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */

	// ������Ƽ�� ���� ��´�.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "Text Channel"; // ä�� �̸�
		return super.getPropertyValue(id);
	}

	@Override
	public ChannelTrack deepCopy()
	{
		TextTrack newTrack = TimelineFactory.eINSTANCE.createTextTrack();
		copyTo(newTrack);
		return newTrack;
	}
	
	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(TextPointImpl.class))
			return true;
		return false;
	}

	@Override
	public TextPoint deepCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(TextPointImpl.class))
			return (TextPoint)cp.deepCopy();
		return null;
	}

	// �� �������� �����͸� ����̽��� ����.
	@Override
	public void dump(int frame)
	{
		if(getPoints().size() == 0) return;
		
		Device device = getTargetDevice(0);
		if(device == null) return; // ����� ����̽��� ����.
		
		for(ControlPoint cp : getPoints())
		{
			if(cp.getFrame() == frame)
				device.writeString(((TextPoint)cp).getText());
		}
	}
} //TextTrackImpl
