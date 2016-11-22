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

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.roboid.robot.Channel;
import org.roboid.robot.ColorChannel;
import org.roboid.robot.ColorMode;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ColorPoint;
import org.roboid.studio.timeline.ColorTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.ColorTrackImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColorTrackImpl extends ChannelTrackImpl implements ColorTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorTrackImpl()
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
		return TimelinePackage.Literals.COLOR_TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(ColorMode newMode)
	{
		ColorMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.COLOR_TRACK__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case TimelinePackage.COLOR_TRACK__MODE:
				return getMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case TimelinePackage.COLOR_TRACK__MODE:
				setMode((ColorMode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case TimelinePackage.COLOR_TRACK__MODE:
				setMode(MODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case TimelinePackage.COLOR_TRACK__MODE:
				return mode != MODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated NOT
	 * @ordered
	 */
	protected static final ColorMode MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected ColorMode mode = MODE_EDEFAULT;

	private static final String P_MODE = "_mode"; // LED 모드
	private Simulacrum[] simulacra; // 임시
	
	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		super.getPropertyDescriptors(propertyDescriptors);
		propertyDescriptors.add(new PropertyDescriptor(P_MODE, "Mode"));
	}
	
	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "Color Channel"; // 채널 이름
		if(id.equals(P_MODE)) return getMode().getLiteral();
		return super.getPropertyValue(id);
	}
	
	@Override
	public ChannelTrack deepCopy()
	{
		ColorTrack newTrack = TimelineFactory.eINSTANCE.createColorTrack();
		copyTo(newTrack);
		return newTrack;
	}

	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(ColorPointImpl.class))
			return true;
		return false;
	}

	@Override
	public ColorPoint deepCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(ColorPointImpl.class))
			return (ColorPoint)cp.deepCopy();
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ColorMode getMode()
	{
		if(mode == null)
		{
			Channel channel = getChannel();
			if(channel instanceof ColorChannel)
				mode = ((ColorChannel)channel).getMode();
			else
				mode = ColorMode.RGB;
		}
		return mode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMode(int newMode)
	{
		ColorMode mode = ColorMode.get(newMode);
		if(mode != null) setMode(mode);
	}
	
	// 시뮬레이크럼을 만든다.
	@Override
	public void createSimulacra()
	{
		if(initialValues == null)
		{
			// 인터폴레이션을 하므로 제어점이 2개 이상이어야 한다.
			if(getPoints().size() < 2) return;
			
			Device device = getTargetDevice(0);
			if(device == null) return; // 연결된 디바이스가 없다.
	
			// 배열 크기를 디바이스의 데이터 크기로 한다.
			int dataSize = device.getDataSize();
			if(simulacra == null) simulacra = new Simulacrum[dataSize];
			
			// 데이터가 있는 만큼만 메모리를 잡는다.
			ControlPoint first = getPoints().get(0);
			ControlPoint last = getPoints().get(getPoints().size()-1);
			for(int i = 0; i < dataSize; i ++)
				simulacra[i] = new Simulacrum(last.getFrame() - first.getFrame() + 1);
	
			// 배열 초기화
			for(Simulacrum s : simulacra)
			{
				int[] simulacrum = s.getSimulacrum();
				Arrays.fill(simulacrum, 0);
			}
			
			// 제어점 데이터를 인터폴레이션 한다.
			for(int i = 1; i < getPoints().size(); i ++)
			{
				ColorPoint cp_s = (ColorPoint)getPoints().get(i - 1);
				int frame_s = cp_s.getFrame() - first.getFrame(); // 인덱스 쉬프트
				RGB rgb_s = cp_s.getColor();
				
				ColorPoint cp_e = (ColorPoint)getPoints().get(i);
				int frame_e = cp_e.getFrame() - first.getFrame(); // 인덱스 쉬프트
				RGB rgb_e = cp_e.getColor();
				
				int frameDiff = frame_e - frame_s;
				if(dataSize > 0)
				{
					// RED - 중간값을 직선으로 채움
					int value_s = rgb_s.red * device.getMax() / 255;
					int value_e = rgb_e.red * device.getMax() / 255;
					int valueDiff = value_e - value_s;
					int[] s = simulacra[0].getSimulacrum();
					
					for(int j = frame_s; j <= frame_e; j ++)
					{
						s[j] = value_s + valueDiff * (j - frame_s) / frameDiff;
					}
				}
				
				if(dataSize > 1)
				{
					// GREEN - 중간값을 직선으로 채움
					int value_s = rgb_s.green * device.getMax() / 255;
					int value_e = rgb_e.green * device.getMax() / 255;
					int valueDiff = value_e - value_s;
					int[] s = simulacra[1].getSimulacrum();
					
					for(int j = frame_s; j <= frame_e; j ++)
					{
						s[j] = value_s + valueDiff * (j - frame_s) / frameDiff;
					}
				}
				
				if(dataSize > 2)
				{
					// BLUE - 중간값을 직선으로 채움
					int value_s = rgb_s.blue * device.getMax() / 255;
					int value_e = rgb_e.blue * device.getMax() / 255;
					int valueDiff = value_e - value_s;
					int[] s = simulacra[2].getSimulacrum();
					
					for(int j = frame_s; j <= frame_e; j ++)
					{
						s[j] = value_s + valueDiff * (j - frame_s) / frameDiff;
					}
				}
			}
		}
		else
		{
			if(getPoints().size() < 1) return;
			
			Device device = getTargetDevice(0);
			if(device == null) return; // 연결된 디바이스가 없다.
	
			// 배열 크기를 디바이스의 데이터 크기로 한다.
			int dataSize = device.getDataSize();
			if(simulacra == null) simulacra = new Simulacrum[dataSize];
			
			// 데이터가 있는 만큼만 메모리를 잡는다.
			ControlPoint last = getPoints().get(getPoints().size()-1);
			for(int i = 0; i < dataSize; i ++)
				simulacra[i] = new Simulacrum(last.getFrame() + 1);
	
			// 배열 초기화
			for(Simulacrum s : simulacra)
			{
				int[] simulacrum = s.getSimulacrum();
				Arrays.fill(simulacrum, 0);
			}
			
			RGB rgb_s = new RGB((int)initialValues[0], (int)initialValues[1], (int)initialValues[2]);
			
			ColorPoint cp_e = (ColorPoint)getPoints().get(0);
			int frame_e = cp_e.getFrame();
			RGB rgb_e = cp_e.getColor();
			
			int frameDiff = frame_e;
			if(dataSize > 0)
			{
				// RED - 중간값을 직선으로 채움
				int value_s = rgb_s.red * device.getMax() / 255;
				int value_e = rgb_e.red * device.getMax() / 255;
				int valueDiff = value_e - value_s;
				int[] s = simulacra[0].getSimulacrum();
				
				for(int j = 0; j <= frame_e; j ++)
				{
					s[j] = value_s + valueDiff * j / frameDiff;
				}
			}
			
			if(dataSize > 1)
			{
				// GREEN - 중간값을 직선으로 채움
				int value_s = rgb_s.green * device.getMax() / 255;
				int value_e = rgb_e.green * device.getMax() / 255;
				int valueDiff = value_e - value_s;
				int[] s = simulacra[1].getSimulacrum();
				
				for(int j = 0; j <= frame_e; j ++)
				{
					s[j] = value_s + valueDiff * j / frameDiff;
				}
			}
			
			if(dataSize > 2)
			{
				// BLUE - 중간값을 직선으로 채움
				int value_s = rgb_s.blue * device.getMax() / 255;
				int value_e = rgb_e.blue * device.getMax() / 255;
				int valueDiff = value_e - value_s;
				int[] s = simulacra[2].getSimulacrum();
				
				for(int j = 0; j <= frame_e; j ++)
				{
					s[j] = value_s + valueDiff * j / frameDiff;
				}
			}
			
			// 제어점 데이터를 인터폴레이션 한다.
			for(int i = 1; i < getPoints().size(); i ++)
			{
				ColorPoint cp_s = (ColorPoint)getPoints().get(i - 1);
				int frame_s = cp_s.getFrame(); // 인덱스 쉬프트
				rgb_s = cp_s.getColor();
				
				cp_e = (ColorPoint)getPoints().get(i);
				frame_e = cp_e.getFrame(); // 인덱스 쉬프트
				rgb_e = cp_e.getColor();
				
				frameDiff = frame_e - frame_s;
				if(dataSize > 0)
				{
					// RED - 중간값을 직선으로 채움
					int value_s = rgb_s.red * device.getMax() / 255;
					int value_e = rgb_e.red * device.getMax() / 255;
					int valueDiff = value_e - value_s;
					int[] s = simulacra[0].getSimulacrum();
					
					for(int j = frame_s; j <= frame_e; j ++)
					{
						s[j] = value_s + valueDiff * (j - frame_s) / frameDiff;
					}
				}
				
				if(dataSize > 1)
				{
					// GREEN - 중간값을 직선으로 채움
					int value_s = rgb_s.green * device.getMax() / 255;
					int value_e = rgb_e.green * device.getMax() / 255;
					int valueDiff = value_e - value_s;
					int[] s = simulacra[1].getSimulacrum();
					
					for(int j = frame_s; j <= frame_e; j ++)
					{
						s[j] = value_s + valueDiff * (j - frame_s) / frameDiff;
					}
				}
				
				if(dataSize > 2)
				{
					// BLUE - 중간값을 직선으로 채움
					int value_s = rgb_s.blue * device.getMax() / 255;
					int value_e = rgb_e.blue * device.getMax() / 255;
					int valueDiff = value_e - value_s;
					int[] s = simulacra[2].getSimulacrum();
					
					for(int j = frame_s; j <= frame_e; j ++)
					{
						s[j] = value_s + valueDiff * (j - frame_s) / frameDiff;
					}
				}
			}
		}
	}

	// 한 프레임의 데이터를 디바이스에 쓴다.
	@Override
	public void dump(int frame)
	{
		if(initialValues == null)
		{
			// 인터폴레이션을 하므로 제어점이 2개 이상이어야 한다.
			if(getPoints().size() < 2) return;
			
			// 제어점의 범위를 검사한다.
			ControlPoint first = getPoints().get(0);
			ControlPoint last = getPoints().get(getPoints().size()-1);
			if(frame < first.getFrame()) return;
			else if(frame > last.getFrame()) return;
			
			Device device = getTargetDevice(0);
			if(device == null) return; // 연결된 디바이스가 없다.
	
			// 인덱스 쉬프트
			frame -= first.getFrame();
			
			int dataSize = device.getDataSize();
			// R
			if(dataSize < 1) return;
			device.write(0, simulacra[0].getSimulacrum()[frame]);
			
			// G
			if(dataSize < 2) return;
			device.write(1, simulacra[1].getSimulacrum()[frame]);
			
			// B
			if(dataSize < 3) return;
			device.write(2, simulacra[2].getSimulacrum()[frame]);
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
				ControlPoint last = getPoints().get(sz - 1);
				if(frame > last.getFrame()) return;
		
				int dataSize = device.getDataSize();
				// R
				if(dataSize < 1) return;
				device.write(0, simulacra[0].getSimulacrum()[frame]);
				
				// G
				if(dataSize < 2) return;
				device.write(1, simulacra[1].getSimulacrum()[frame]);
				
				// B
				if(dataSize < 3) return;
				device.write(2, simulacra[2].getSimulacrum()[frame]);
			}
		}
	}

	private class Simulacrum
	{
		private int[] simulacrum;
		
		Simulacrum(int sz)
		{
			simulacrum = new int[sz];
		}
		
		int[] getSimulacrum()
		{
			return simulacrum;
		}
	}
	
	private float[] tmpValues = new float[3];
	
	@Override
	public float[] getValues(int frame)
	{
		List<ControlPoint> points = getPoints();
		int sz = points.size();
		if(sz > 0)
		{
			ColorPoint last = (ColorPoint)points.get(sz - 1);
			if(frame >= last.getFrame())
			{
				RGB rgb = last.getColor();
				tmpValues[0] = rgb.red;
				tmpValues[1] = rgb.green;
				tmpValues[2] = rgb.blue;
				return tmpValues;
			}
			else
			{
				createSimulacra();
				Device device = getTargetDevice(0);
				if(device == null) return null;
				
				sz = device.getDataSize();
				for(int i = 0; i < sz; ++i)
					tmpValues[i] = simulacra[i].getSimulacrum()[frame];
				return tmpValues;
			}
		}
		return initialValues;
	}
} //ColorTrackImpl
