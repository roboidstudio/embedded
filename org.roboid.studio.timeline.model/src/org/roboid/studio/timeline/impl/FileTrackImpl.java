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
import org.roboid.studio.timeline.FilePoint;
import org.roboid.studio.timeline.FileTrack;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Track</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FileTrackImpl extends ChannelTrackImpl implements FileTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileTrackImpl()
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
		return TimelinePackage.Literals.FILE_TRACK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "File Channel"; // 채널 이름
		return super.getPropertyValue(id);
	}

	@Override
	public ChannelTrack deepCopy()
	{
		FileTrack newTrack = TimelineFactory.eINSTANCE.createFileTrack();
		copyTo(newTrack);
		return newTrack;
	}
	
	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(FilePointImpl.class))
			return true;
		return false;
	}

	@Override
	public FilePoint deepCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(FilePointImpl.class))
			return (FilePoint)cp.deepCopy();
		return null;
	}

	// 한 프레임의 데이터를 디바이스에 쓴다.
	@Override
	public void dump(int frame)
	{
		if(getPoints().size() == 0) return;
		
		Device device = getTargetDevice(0);
		if(device == null) return; // 연결된 디바이스가 없다.
		
		for(ControlPoint cp : getPoints())
		{
			if(cp.getFrame() == frame)
				device.writeString(((FilePoint)cp).getFileName());
		}
	}
} //FileTrackImpl
