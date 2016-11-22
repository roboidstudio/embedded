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

package org.roboid.studio.contentscomposer.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.roboid.studio.contentscomposer.ClipBlockWithFrame;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MovableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clip Block With Frame</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.ClipBlockWithFrameImpl#getStartFrame <em>Start Frame</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.ClipBlockWithFrameImpl#getStopFrame <em>Stop Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClipBlockWithFrameImpl extends ClipBlockImpl implements ClipBlockWithFrame
{
	/**
	 * The default value of the '{@link #getStartFrame() <em>Start Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartFrame()
	 * @generated
	 * @ordered
	 */
	protected static final int START_FRAME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartFrame() <em>Start Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartFrame()
	 * @generated
	 * @ordered
	 */
	protected int startFrame = START_FRAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStopFrame() <em>Stop Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopFrame()
	 * @generated
	 * @ordered
	 */
	protected static final int STOP_FRAME_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getStopFrame() <em>Stop Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopFrame()
	 * @generated
	 * @ordered
	 */
	protected int stopFrame = STOP_FRAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClipBlockWithFrameImpl()
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
		return ContentsComposerPackage.Literals.CLIP_BLOCK_WITH_FRAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartFrame()
	{
		return startFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartFrame(int newStartFrame)
	{
		int oldStartFrame = startFrame;
		startFrame = newStartFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__START_FRAME, oldStartFrame, startFrame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStopFrame()
	{
		return stopFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopFrame(int newStopFrame)
	{
		int oldStopFrame = stopFrame;
		stopFrame = newStopFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__STOP_FRAME, oldStopFrame, stopFrame));
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
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__START_FRAME:
				return getStartFrame();
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__STOP_FRAME:
				return getStopFrame();
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
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__START_FRAME:
				setStartFrame((Integer)newValue);
				return;
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__STOP_FRAME:
				setStopFrame((Integer)newValue);
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
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__START_FRAME:
				setStartFrame(START_FRAME_EDEFAULT);
				return;
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__STOP_FRAME:
				setStopFrame(STOP_FRAME_EDEFAULT);
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
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__START_FRAME:
				return startFrame != START_FRAME_EDEFAULT;
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME__STOP_FRAME:
				return stopFrame != STOP_FRAME_EDEFAULT;
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
		result.append(" (startFrame: ");
		result.append(startFrame);
		result.append(", stopFrame: ");
		result.append(stopFrame);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((ClipBlockWithFrame)newBlock).setStartFrame(getStartFrame());
		((ClipBlockWithFrame)newBlock).setStopFrame(getStopFrame());
	}
} //ClipBlockWithFrameImpl
