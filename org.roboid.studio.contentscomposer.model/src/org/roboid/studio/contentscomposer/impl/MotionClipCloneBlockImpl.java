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

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MovableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motion Clip Clone Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionClipCloneBlockImpl#getOriginal <em>Original</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotionClipCloneBlockImpl extends ClipBlockWithFrameImpl implements MotionClipCloneBlock
{
	/**
	 * The cached value of the '{@link #getOriginal() <em>Original</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginal()
	 * @generated
	 * @ordered
	 */
	protected MotionClipBlock original;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotionClipCloneBlockImpl()
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
		return ContentsComposerPackage.Literals.MOTION_CLIP_CLONE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionClipBlock getOriginal()
	{
		return original;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginal(MotionClipBlock newOriginal)
	{
		MotionClipBlock oldOriginal = original;
		original = newOriginal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK__ORIGINAL, oldOriginal, original));
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
			case ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK__ORIGINAL:
				return getOriginal();
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
			case ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK__ORIGINAL:
				setOriginal((MotionClipBlock)newValue);
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
			case ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK__ORIGINAL:
				setOriginal((MotionClipBlock)null);
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
			case ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK__ORIGINAL:
				return original != null;
		}
		return super.eIsSet(featureID);
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_TYPE = "_type";
	public static final String P_ORIGINAL = "_original";
	public static final String P_START = "_start";
	public static final String P_STOP = "_stop";
	public static final String P_TOTAL = "_total";

	@Override
	public MotionClipCloneBlock deepCopy(MotionContent newParent)
	{
		MotionClipCloneBlock newBlock = ContentsComposerFactory.eINSTANCE.createMotionClipCloneBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}

	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((MotionClipCloneBlock)newBlock).setOriginal(getOriginal());
	}
	
	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		// ��� Ŭ�� ����Ʈ�� ��´�.
		List<MotionClipBlock> clips = getParent().getMotionClipBlocks();
		// ��� Ŭ���� �̸� ����Ʈ�� �����.
		String[] clipNames = new String[clips.size()];
		for(int i = 0; i < clips.size(); i ++)
			clipNames[i] = clips.get(i).getName();
		
		PropertyDescriptor propertyClipType = new PropertyDescriptor(P_TYPE, "Clip Type");
		propertyClipType.setCategory("Attribute");
		ComboBoxPropertyDescriptor propertyOriginalMotionClip = new ComboBoxPropertyDescriptor(P_ORIGINAL, "Original Motion Clip", clipNames);
		propertyOriginalMotionClip.setCategory("Attribute");
		TextPropertyDescriptor propertyStartFrame = new TextPropertyDescriptor(P_START, "Start Frame");
		propertyStartFrame.setCategory("Attribute");
		TextPropertyDescriptor propertyStopFrame = new TextPropertyDescriptor(P_STOP, "Stop Frame");
		propertyStopFrame.setCategory("Attribute");
		PropertyDescriptor propertyTotalFrames = new PropertyDescriptor(P_TOTAL, "Total Frames");
		propertyTotalFrames.setCategory("Attribute");
		return new IPropertyDescriptor[]
		{
			propertyClipType,
			propertyOriginalMotionClip,
			propertyStartFrame,
			propertyStopFrame,			
			propertyTotalFrames				
		};
	}

	// ������Ƽ�� ���� ��´�.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_TYPE)) return "Clone of Motion Clip";
		if(id.equals(P_ORIGINAL)) return getParent().getMotionClipBlocks().indexOf(original);
		if(id.equals(P_START)) return Integer.toString(getStartFrame());
		if(id.equals(P_STOP)) return Integer.toString(getStopFrame());
		if(id.equals(P_TOTAL)) return getTotalFrames();
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_ORIGINAL)) return true;
		if(id.equals(P_START)) return true;
		if(id.equals(P_STOP)) return true;
		if(id.equals(P_TOTAL)) return true;
		return super.isPropertySet(id);
	}

	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_ORIGINAL))
		{
			// ������ ��´�.
			int i = ((Integer)value).intValue();
			setOriginal(getParent().getMotionClipBlocks().get(i));
			firePropertyChange(P_REDRAW, null, null);
			// ����� ������ �´��� �˻��Ѵ�.
			getParent().validate();
		}
		else if(id.equals(P_START))
		{
			try
			{
				startFrame = Integer.parseInt((String)value);
			} catch (Exception e)
			{
			}
			if(startFrame < 0) startFrame = 0;
		}
		else if(id.equals(P_STOP))
		{
			try
			{
				stopFrame = Integer.parseInt((String)value);
			} catch (Exception e)
			{
			}
			if(stopFrame < 0) stopFrame = -1;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getTotalFrames()
	{
		return original == null ? 0 : original.getMotionClip() == null ? 0 : original.getMotionClip().getTotalFrames();
	}

	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		// ������ �־�� �Ѵ�.
		if(original == null) return false;
		return super.validate();
	}
} //MotionClipCloneBlockImpl
