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
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.MovableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Clip Clone Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentCloneBlockImpl#getOriginal <em>Original</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotionContentCloneBlockImpl extends ClipBlockImpl implements MotionContentCloneBlock
{
	/**
	 * The cached value of the '{@link #getOriginal() <em>Original</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginal()
	 * @generated
	 * @ordered
	 */
	protected MotionContentBlock original;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotionContentCloneBlockImpl()
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
		return ContentsComposerPackage.Literals.MOTION_CONTENT_CLONE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionContentBlock getOriginal()
	{
		return original;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginal(MotionContentBlock newOriginal)
	{
		MotionContentBlock oldOriginal = original;
		original = newOriginal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK__ORIGINAL, oldOriginal, original));
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
			case ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK__ORIGINAL:
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
			case ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK__ORIGINAL:
				setOriginal((MotionContentBlock)newValue);
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
			case ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK__ORIGINAL:
				setOriginal((MotionContentBlock)null);
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
			case ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK__ORIGINAL:
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
	
	@Override
	public BlockElement deepCopy(MotionContent newParent)
	{
		MotionContentCloneBlock newBlock = ContentsComposerFactory.eINSTANCE.createMotionContentCloneBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}

	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((MotionContentCloneBlock)newBlock).setOriginal(getOriginal());
	}
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		// 콘텐츠 클립 리스트를 얻는다.
		List<MotionContentBlock> clips = getParent().getMotionContentBlocks();
		// 콘텐츠 클립의 이름 리스트를 만든다.
		String[] clipNames = new String[clips.size()];
		for(int i = 0; i < clips.size(); i ++)
			clipNames[i] = clips.get(i).getName();
		
		PropertyDescriptor propertyClipType = new PropertyDescriptor(P_TYPE, "Clip Type");
		propertyClipType.setCategory("Attribute");
		ComboBoxPropertyDescriptor propertyOriginalContentClip = new ComboBoxPropertyDescriptor(P_ORIGINAL, "Original Content Clip", clipNames);
		propertyOriginalContentClip.setCategory("Attribute");
		return new IPropertyDescriptor[]
		{
			propertyClipType,
			propertyOriginalContentClip
		};
	}

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_TYPE)) return "Clone of Contents Clip";
		if(id.equals(P_ORIGINAL)) return getParent().getMotionContentBlocks().indexOf(original);
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_ORIGINAL)) return true;
		return super.isPropertySet(id);
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_ORIGINAL))
		{
			// 원본을 얻는다.
			int i = ((Integer)value).intValue();
			setOriginal(getParent().getMotionContentBlocks().get(i));
			firePropertyChange(P_REDRAW, null, null);
			// 연결과 로직이 맞는지 검사한다.
			getParent().validate();
		}
	}

	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		// 원본이 있어야 한다.
		if(getOriginal() == null) return false;
		return super.validate();
	}
} //ContentClipCloneBlockImpl
