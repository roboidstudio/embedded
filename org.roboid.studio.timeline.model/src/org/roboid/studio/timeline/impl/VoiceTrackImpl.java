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
import org.roboid.robot.AudioMode;
import org.roboid.robot.Device;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;
import org.roboid.studio.timeline.VoicePoint;
import org.roboid.studio.timeline.VoiceTrack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Voice Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VoiceTrackImpl extends AudioTrackImpl implements VoiceTrack
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoiceTrackImpl()
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
		return TimelinePackage.Literals.VOICE_TRACK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	private static final String P_MODE = "_mode"; // 오디오 모드
	private static final int INERTIA = 4;
	
	private int[] powers; // 입이 열리는 파워

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_CHANNEL)) return "Voice Channel"; // 채널 이름
		if(id.equals(P_MODE)) return getMode().getLiteral();
		if(id.equals(P_TARGET_DEVICE))
		{
			Device device1 = getTargetDevice(0);
			if(device1 == null) return "";
			Device device2 = getTargetDevice(1);
			if(device2 == null) return device1.getName();
			Device device3 = getTargetDevice(2);
			if(device3 == null)
				return device1.getName() + ", " + device2.getName();
			else
				return device1.getName() + ", " + device2.getName() + ", " + device3.getName();
		}
		return super.getPropertyValue(id);
	}

	@Override
	public ChannelTrack deepCopy()
	{
		VoiceTrack newTrack = TimelineFactory.eINSTANCE.createVoiceTrack();
		copyTo(newTrack);
		return newTrack;
	}
	
	@Override
	public boolean canCopy(ControlPoint cp)
	{
		if(cp instanceof AudioPoint)
			return true;
		return false;
	}

	@Override
	public VoicePoint deepCopy(ControlPoint cp)
	{
		if(cp instanceof VoicePoint)
			return (VoicePoint)cp.deepCopy();
		else if(cp instanceof AudioPoint)
		{
			VoicePoint newPoint = TimelineFactory.eINSTANCE.createVoicePoint();
			((AudioPointImpl)cp).copyTo(newPoint);
			return newPoint;
		}
		return null;
	}

	@Override
	public AudioMode getMode()
	{
		if(mode == null)
		{
			if(getTargetDevices().size() == 2)
				mode = AudioMode.MONO;
			else
				mode = AudioMode.STEREO;
		}
		return mode;
	}
	
	// 한 프레임의 데이터를 디바이스에 쓴다.
	@Override
	public void dump(int frame)
	{
		if(getPoints().size() == 0) return; // 제어점이 없다.

		Device device1 = getTargetDevice(0);
		Device device2 = getTargetDevice(1);
		Device device3 = getTargetDevice(2);

		if(device1 == null) return; // 타겟 디바이스가 없는 경우

		if(device3 == null) // mono
		{
			dump(frame, device1, null);
			dumpLip(frame, device1, device2);
		}
		else
		{
			dump(frame, device1, device2);
			dumpLip(frame, device1, device3);
		}
	}

	// 한 프레임의 입 움직임 데이터를 디바이스에 쓴다.
	private void dumpLip(int frame, Device voice, Device lip)
	{
		if(voice == null || lip == null) return;
		
		// 한 프레임의 소리 데이터를 절대치로 다 더한다.
		int sum = 0;
		int lipGain = 0;
		int maxFrame = -1;
		int channels = (getMode() == AudioMode.STEREO) ? 2 : 1;
		int dataSize = voice.getDataSize() * channels;
		
		for(ControlPoint cp : getPoints())
		{
			VoicePoint vp = (VoicePoint)cp;
			if(frame < vp.getFrame()) break;
			else if(frame >= vp.getFrame() + vp.getLength()) continue;

			// PCM 데이터를 얻는다.
			int[] pcm = vp.getPcm();
			if(pcm == null) continue;

			// lipGain은 프레임에 걸쳐 있는 마지막 VoicePoint의 lipGain으로 한다.
			if(vp.getFrame() > maxFrame)
			{
				lipGain = vp.getLipGain();
				maxFrame = vp.getFrame();
			}

			// 절대치의 합을 구한다.
			int offset = (frame - vp.getFrame()) * dataSize;
			int len = pcm.length > offset + dataSize ? dataSize : pcm.length - offset;
			for(int j = 0; j < len; j ++)
			{
				int ww = pcm[offset + j];
				sum += Math.abs(ww) / channels;
			}
		}

		if(powers == null) powers = new int[INERTIA];

		int total = sum;
		for(int i = 1; i < INERTIA; i++)
		{
			powers[i - 1] = powers[i];
			total += powers[i];
		}
		powers[INERTIA - 1] = sum;

		if(total != 0) // lip.write(total * lipGain / 10000000 * lip.getMax() / INERTIA / 64 );
		{
			long pwr = total;
			pwr = pwr * lipGain * lip.getMax() / 64 / INERTIA / 10000000;
			lip.write((int)pwr);
		}
	}
} //VoiceTrackImpl
