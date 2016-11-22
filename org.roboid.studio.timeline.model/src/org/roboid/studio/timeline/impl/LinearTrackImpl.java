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
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.roboid.robot.Channel;
import org.roboid.robot.Device;
import org.roboid.robot.LinearChannel;
import org.roboid.robot.LinearMode;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.LinearPoint;
import org.roboid.studio.timeline.LinearTrack;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linear Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.LinearTrackImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinearTrackImpl extends ChannelTrackImpl implements LinearTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinearTrackImpl()
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
		return TimelinePackage.Literals.LINEAR_TRACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(LinearMode newMode)
	{
		LinearMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.LINEAR_TRACK__MODE, oldMode, mode));
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
			case TimelinePackage.LINEAR_TRACK__MODE:
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
			case TimelinePackage.LINEAR_TRACK__MODE:
				setMode((LinearMode)newValue);
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
			case TimelinePackage.LINEAR_TRACK__MODE:
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
			case TimelinePackage.LINEAR_TRACK__MODE:
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
	protected static final LinearMode MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected LinearMode mode = MODE_EDEFAULT;

	private static final String P_MODE = "_mode"; // ���������̼� ���
	private Simulacrum[] simulacra; // �ӽ�
	
	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		super.getPropertyDescriptors(propertyDescriptors);
		
		// ���������̼� ��忡 ���� �޺��ڽ��� ����� ���� ǥ���� ���ڿ� �迭�� �����.
		String[] modes = new String[LinearMode.values().length];
		for(int i = 0; i < LinearMode.values().length; i ++)
			modes[i] = LinearMode.get(i).getLiteral();
		
		propertyDescriptors.add(new ComboBoxPropertyDescriptor(P_MODE, "Mode", modes));
	}

	// ������Ƽ�� ���� ��´�.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "Linear Channel"; // ä�� �̸�
		if(id.equals(P_MODE)) return Integer.valueOf(getMode().getValue()); // ���������̼� ����� �ε���
		return super.getPropertyValue(id);
	}
	
	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_MODE))
			setMode(((Integer)value).intValue());
		else
			super.setPropertyValue(id, value);
	}
	
	@Override
	public ChannelTrack deepCopy()
	{
		LinearTrack newTrack = TimelineFactory.eINSTANCE.createLinearTrack();
		copyTo(newTrack);
		return newTrack;
	}

	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(LinearPointImpl.class))
			return true;
		return false;
	}

	@Override
	public LinearPoint deepCopy(ControlPoint cp)
	{
		if(cp.getClass().equals(LinearPointImpl.class))
			return (LinearPoint)cp.deepCopy();
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LinearMode getMode()
	{
		if(mode == null)
		{
			Channel channel = getChannel();
			// Mode�� �ʱⰪ�� �𵨿��� ������ ������ �Ѵ�.
			if(channel instanceof LinearChannel)
				mode = ((LinearChannel)channel).getMode();
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
		LinearMode mode = LinearMode.get(newMode);
		if(mode != null) setMode(mode);
	}
	
	// �ùķ���ũ���� �����.
	@Override
	public void createSimulacra()
	{
		if(initialValues == null)
		{
			// ���������̼��� �ϹǷ� �������� 2�� �̻��̾�� �Ѵ�.
			if(getPoints().size() < 2) return;
			
			Device device = getTargetDevice(0);
			if(device == null) return; // ����� ����̽��� ����.
	
			// ������ ũ�⸸ŭ �ùķ���ũ���� �����.
			int dataSize = device.getDataSize();
			if(simulacra == null) simulacra = new Simulacrum[dataSize];
			
			// �����Ͱ� �ִ� ��ŭ�� �޸𸮸� ��´�.
			ControlPoint first = getPoints().get(0);
			ControlPoint last = getPoints().get(getPoints().size()-1);
			for(int i = 0; i < dataSize; i ++)
				simulacra[i] = new Simulacrum(last.getFrame() - first.getFrame() + 1);
		
			// ������ �����͸� ���������̼� �Ѵ�.
			for(int i = 0; i < dataSize; i ++)
			{
				float[] simulacrum = simulacra[i].getSimulacrum();
		
				// �� �������� ����Ʈ ������ ä���.
				Arrays.fill(simulacrum, device.getDefaultFloat());
				
				// �������� ���������̼� �Ѵ�.
				for(int j = 1; j < getPoints().size(); j ++)
				{
					LinearPoint cp_s = (LinearPoint)getPoints().get(j - 1);
					int frame_s = cp_s.getFrame() - first.getFrame(); // �ε��� ����Ʈ
					float value_s = cp_s.getValues()[i];
					
					LinearPoint cp_e = (LinearPoint)getPoints().get(j);
					int frame_e = cp_e.getFrame() - first.getFrame(); // �ε��� ����Ʈ
					float value_e = cp_e.getValues()[i];
					
					float valueDiff = value_e - value_s;
					int frameDiff = frame_e - frame_s;
					if(cp_s.getMode() == LinearMode.LINEAR)
					{
						// �߰����� �������� ä��
						for(int k = frame_s; k < frame_e; k ++)
							simulacrum[k] = (value_s + valueDiff * (k - frame_s) / frameDiff);
						simulacrum[frame_e] = value_e;
					}
					else if(cp_s.getMode() == LinearMode.SUSTAIN)
					{
						// ���� ����
						for(int k = frame_s; k < frame_e; k ++)
							simulacrum[k] = value_s;
						simulacrum[frame_e] = value_e;
					}
				}
			}
		}
		else
		{
			if(getPoints().size() < 1) return;
			
			Device device = getTargetDevice(0);
			if(device == null) return; // ����� ����̽��� ����.
	
			// ������ ũ�⸸ŭ �ùķ���ũ���� �����.
			int dataSize = device.getDataSize();
			if(simulacra == null) simulacra = new Simulacrum[dataSize];
			
			// �����Ͱ� �ִ� ��ŭ�� �޸𸮸� ��´�.
			ControlPoint last = getPoints().get(getPoints().size()-1);
			for(int i = 0; i < dataSize; i ++)
				simulacra[i] = new Simulacrum(last.getFrame() + 1);
		
			// ������ �����͸� ���������̼� �Ѵ�.
			for(int i = 0; i < dataSize; i ++)
			{
				float[] simulacrum = simulacra[i].getSimulacrum();
		
				// �� �������� ����Ʈ ������ ä���.
				Arrays.fill(simulacrum, device.getDefaultFloat());
				
				// �������� ���������̼� �Ѵ�.
				float value_s = initialValues[i];
				
				LinearPoint cp_e = (LinearPoint)getPoints().get(0);
				int frame_e = cp_e.getFrame();
				float value_e = cp_e.getValues()[i];
				
				float valueDiff = value_e - value_s;
				int frameDiff = frame_e;
				{
					// �߰����� �������� ä��
					for(int k = 0; k < frame_e; k ++)
						simulacrum[k] = (value_s + valueDiff * k / frameDiff);
					simulacrum[frame_e] = value_e;
				}
				
				for(int j = 1; j < getPoints().size(); j ++)
				{
					LinearPoint cp_s = (LinearPoint)getPoints().get(j - 1);
					int frame_s = cp_s.getFrame(); // �ε��� ����Ʈ
					value_s = cp_s.getValues()[i];
					
					cp_e = (LinearPoint)getPoints().get(j);
					frame_e = cp_e.getFrame(); // �ε��� ����Ʈ
					value_e = cp_e.getValues()[i];
					
					valueDiff = value_e - value_s;
					frameDiff = frame_e - frame_s;
					if(cp_s.getMode() == LinearMode.LINEAR)
					{
						// �߰����� �������� ä��
						for(int k = frame_s; k < frame_e; k ++)
							simulacrum[k] = (value_s + valueDiff * (k - frame_s) / frameDiff);
						simulacrum[frame_e] = value_e;
					}
					else if(cp_s.getMode() == LinearMode.SUSTAIN)
					{
						// ���� ����
						for(int k = frame_s; k < frame_e; k ++)
							simulacrum[k] = value_s;
						simulacrum[frame_e] = value_e;
					}
				}
			}
		}
	}

	// �� �������� �����͸� ����̽��� ����.
	@Override
	public void dump(int frame)
	{
		if(initialValues == null)
		{
			// ���������̼��� �ϹǷ� �������� 2�� �̻��̾�� �Ѵ�.
			if(getPoints().size() < 2) return;
			
			// �������� ������ �˻��Ѵ�.
			LinearPoint first = (LinearPoint)getPoints().get(0);
			LinearPoint last = (LinearPoint)getPoints().get(getPoints().size()-1);
			if(frame < first.getFrame()) return;
			else if(frame > last.getFrame()) return;
	
			Device device = getTargetDevice(0);
			if(device == null) return; // ����� ����̽��� ����.
	
			// �ε��� ����Ʈ
			frame -= first.getFrame();
			for(int i = 0; i < device.getDataSize(); i ++)
				device.write(i, simulacra[i].getSimulacrum()[frame]);
		}
		else
		{
			Device device = getTargetDevice(0);
			if(device == null) return; // ����� ����̽��� ����.
			
			int sz = getPoints().size();
			if(sz == 0)
			{
				if(frame == 0)
					device.write(initialValues);
			}
			else
			{
				LinearPoint last = (LinearPoint)getPoints().get(sz - 1);
				if(frame > last.getFrame()) return;
		
				for(int i = 0; i < device.getDataSize(); i ++)
					device.write(i, simulacra[i].getSimulacrum()[frame]);
			}
		}
	}

	private class Simulacrum
	{
		private float[] simulacrum;
		
		Simulacrum(int sz)
		{
			simulacrum = new float[sz];
		}
		
		float[] getSimulacrum()
		{
			return simulacrum;
		}
	}
	
	@Override
	public float[] getValues(int frame)
	{
		List<ControlPoint> points = getPoints();
		int sz = points.size();
		if(sz > 0)
		{
			LinearPoint last = (LinearPoint)points.get(sz - 1);
			if(frame >= last.getFrame())
				return last.getValues();
			else
			{
				createSimulacra();
				Device device = getTargetDevice(0);
				if(device == null) return null;
				
				sz = device.getDataSize();
				float[] values = new float[sz];
				for(int i = 0; i < sz; ++i)
					values[i] = simulacra[i].getSimulacrum()[frame];
				return values;
			}
		}
		return initialValues;
	}
} //LinearTrackImpl
