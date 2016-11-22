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

package org.roboid.robot.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.roboid.robot.Device;
import org.roboid.robot.Event;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.RobotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.robot.impl.ProtocolImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.roboid.robot.impl.ProtocolImpl#getBufferSize <em>Buffer Size</em>}</li>
 *   <li>{@link org.roboid.robot.impl.ProtocolImpl#getRemainingBuffer <em>Remaining Buffer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolImpl extends NamedElementImpl implements Protocol
{
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0.0";
	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getBufferSize() <em>Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferSize()
	 * @generated
	 * @ordered
	 */
	protected static final int BUFFER_SIZE_EDEFAULT = 8;
	/**
	 * The cached value of the '{@link #getBufferSize() <em>Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferSize()
	 * @generated
	 * @ordered
	 */
	protected int bufferSize = BUFFER_SIZE_EDEFAULT;
	/**
	 * The default value of the '{@link #getRemainingBuffer() <em>Remaining Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemainingBuffer()
	 * @generated
	 * @ordered
	 */
	protected static final int REMAINING_BUFFER_EDEFAULT = 20;
	/**
	 * The cached value of the '{@link #getRemainingBuffer() <em>Remaining Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemainingBuffer()
	 * @generated
	 * @ordered
	 */
	protected int remainingBuffer = REMAINING_BUFFER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotPackage.Literals.PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.PROTOCOL__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBufferSize() {
		return bufferSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferSize(int newBufferSize) {
		int oldBufferSize = bufferSize;
		bufferSize = newBufferSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.PROTOCOL__BUFFER_SIZE, oldBufferSize, bufferSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRemainingBuffer() {
		return remainingBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingBuffer(int newRemainingBuffer) {
		int oldRemainingBuffer = remainingBuffer;
		remainingBuffer = newRemainingBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotPackage.PROTOCOL__REMAINING_BUFFER, oldRemainingBuffer, remainingBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotPackage.PROTOCOL__VERSION:
				return getVersion();
			case RobotPackage.PROTOCOL__BUFFER_SIZE:
				return getBufferSize();
			case RobotPackage.PROTOCOL__REMAINING_BUFFER:
				return getRemainingBuffer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RobotPackage.PROTOCOL__VERSION:
				setVersion((String)newValue);
				return;
			case RobotPackage.PROTOCOL__BUFFER_SIZE:
				setBufferSize((Integer)newValue);
				return;
			case RobotPackage.PROTOCOL__REMAINING_BUFFER:
				setRemainingBuffer((Integer)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case RobotPackage.PROTOCOL__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RobotPackage.PROTOCOL__BUFFER_SIZE:
				setBufferSize(BUFFER_SIZE_EDEFAULT);
				return;
			case RobotPackage.PROTOCOL__REMAINING_BUFFER:
				setRemainingBuffer(REMAINING_BUFFER_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RobotPackage.PROTOCOL__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case RobotPackage.PROTOCOL__BUFFER_SIZE:
				return bufferSize != BUFFER_SIZE_EDEFAULT;
			case RobotPackage.PROTOCOL__REMAINING_BUFFER:
				return remainingBuffer != REMAINING_BUFFER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (version: ");
		result.append(version);
		result.append(", bufferSize: ");
		result.append(bufferSize);
		result.append(", remainingBuffer: ");
		result.append(remainingBuffer);
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
	 * @generated NOT
	 */
	ByteArrayInputStream inputPayload;
	/**
	 * @generated NOT
	 */
	ByteArrayInputStream inputDevicemap;
	/**
	 * @generated NOT
	 */
	ByteArrayOutputStream outputPayload = new ByteArrayOutputStream();
	/**
	 * @generated NOT
	 */
	ByteArrayOutputStream outputDevicemap = new ByteArrayOutputStream();
	/**
	 * @generated NOT
	 */
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	/**
	 * @generated NOT
	 */
	public byte[] headerToRobot = new byte[Protocol.HEADER_SIZE];
	/**
	 * @generated NOT
	 */
//	public byte[] headerFromRobot = new byte[Protocol.HEADER_SIZE];
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized byte[] getSimulacrum()
	{
		outputDevicemap.reset();
		outputPayload.reset();
		Roboid roboid = (Roboid)eContainer();
		roboid.getSimulacrum(outputDevicemap, outputPayload);
		
		outputStream.reset();
		headerToRobot[0] = 0x12;
		
		try 
		{
			outputStream.write(headerToRobot);
			
			byte[] byteMap = outputDevicemap.toByteArray();
			int byteCount = 0;
			int bitCount = 0;
			int map = 0;
			for(int i = 0; i < byteMap.length; i++)
			{
				map <<= 1;
				if(byteMap[i] != 0) map |= 0x01;
				byteMap[byteCount] = (byte)map;
				
				if(++bitCount == 8) 
				{
					bitCount = 0;
					byteCount++;
					map = 0;
				}
			}
			if((byteMap.length % 8) != 0)
			{
				int k = 8 - byteMap.length % 8;
				map <<= k;
				byteMap[byteCount] = (byte)map;
				byteCount++;
			}
			outputStream.write(byteMap, 0, byteCount);
			outputPayload.writeTo(outputStream);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return outputStream.toByteArray();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void setSimulacrum(byte[] simulacrum, boolean isMaster)
	{
		Roboid roboid = (Roboid)eContainer();
		if(isMaster) remainingBuffer = simulacrum[Protocol.HEADER_SIZE - 1];

		int deviceCount = roboid.setDeviceMap(Protocol.HEADER_SIZE * 8, simulacrum, true);
		ByteArrayInputStream inputStream  = new ByteArrayInputStream(simulacrum, 0, simulacrum.length);
		int payloadPosition = deviceCount / 8;
		if(deviceCount % 8 != 0) payloadPosition++; 
		inputStream.skip(payloadPosition);
		roboid.setPayload(inputStream, isMaster);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearBuffer()
	{
		headerToRobot[Protocol.HEADER_SIZE - 1] ++;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void setEvents()
	{
		Roboid roboid = (Roboid)eContainer();
		for(Device device : roboid.getDevices())
		{
			if(device instanceof Event)
				((Event)device).setEvent();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getBufferId()
	{
		return headerToRobot[Protocol.HEADER_SIZE - 1];
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean equalsContents(Object obj)
	{
		if(this == obj) return true;
		if(!(obj instanceof Protocol)) return false;
		if(!super.equalsContents(obj)) return false;
		
		Protocol other = (Protocol)obj;
		if(getBufferSize() != other.getBufferSize()) return false;
		if(getVersion() == null)
		{
			if(other.getVersion() != null) return false;
		}
		else if(!getVersion().equalsIgnoreCase(other.getVersion())) return false;
		
		return true;
	}

	/**
	 * class as elements
	 * @generated NOT
	 */
	class Header
	{
		private List<Element> elements = new ArrayList<Element>();
		public Version version = new Version();
		public Encryption encryption = new Encryption();
		public Type type = new Type();
		public Buffer buffer = new Buffer();
		public SeqNo seqNo = new SeqNo();
		public Model model = new Model();
		public TimeStamp timeStamp = new TimeStamp();
		public SessionId sessionId = new SessionId();
		public LastSeqNo lastSeqNo = new LastSeqNo();
		
		public Header()
		{
			elements.add(version);
			elements.add(encryption);
			elements.add(type);
			elements.add(seqNo);
			elements.add(model);
			elements.add(timeStamp);
			elements.add(sessionId);
			elements.add(lastSeqNo);
			elements.add(buffer);
		}
		
		public List<Element> getElements()
		{
			return elements;
		}
		
		public void setHeader(byte[] header)
		{
			int loc = 0;
			
			for(int i = 0; i < elements.size(); i++)
			{
				((Element)elements.get(0)).setHeader(header, loc);
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	abstract class Element
	{
		void setHeader(byte[] header, int loc)
		{
		}
		
		byte[] getHeader()
		{
			return null;
		}
	}
	
	/**
	 * @generated NOT
	 */
	class Version extends Element
	{
		public static final int VERSION = 0x12;
	}
	
	/**
	 * @generated NOT
	 */
	class Encryption extends Element
	{
	}
	
	/**
	 * @generated NOT
	 */
	class Type extends Element
	{
	}
	
	/**
	 * @generated NOT
	 */
	class Buffer extends Element
	{
		private int bufferCount;
		private int bufferState;
		
		public void clearBuffer()
		{
			bufferState++;
		}
		
		public int getBuffer()
		{
			return bufferCount;
		}
	}
	
	/**
	 * @generated NOT
	 */
	class SeqNo extends Element
	{
	}
	
	/**
	 * @generated NOT
	 */
	class Model extends Element
	{
	}
	
	/**
	 * @generated NOT
	 */
	class TimeStamp extends Element
	{
	}
	
	/**
	 * @generated NOT
	 */
	class SessionId extends Element
	{
	}
	
	/**
	 * @generated NOT
	 */
	class LastSeqNo extends Element
	{
	}
} //ProtocolImpl
