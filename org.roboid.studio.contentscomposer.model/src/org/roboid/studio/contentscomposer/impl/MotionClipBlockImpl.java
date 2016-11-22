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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.timeline.MotionClip;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motion Clip Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionClipBlockImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionClipBlockImpl#getMotionClip <em>Motion Clip</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotionClipBlockImpl extends ClipBlockWithFrameImpl implements MotionClipBlock
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMotionClip() <em>Motion Clip</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMotionClip()
	 * @generated
	 * @ordered
	 */
	protected MotionClip motionClip;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotionClipBlockImpl()
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
		return ContentsComposerPackage.Literals.MOTION_CLIP_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionClip getMotionClip()
	{
		return motionClip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMotionClip(MotionClip newMotionClip, NotificationChain msgs)
	{
		MotionClip oldMotionClip = motionClip;
		motionClip = newMotionClip;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP, oldMotionClip, newMotionClip);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMotionClip(MotionClip newMotionClip)
	{
		if (newMotionClip != motionClip) {
			NotificationChain msgs = null;
			if (motionClip != null)
				msgs = ((InternalEObject)motionClip).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP, null, msgs);
			if (newMotionClip != null)
				msgs = ((InternalEObject)newMotionClip).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP, null, msgs);
			msgs = basicSetMotionClip(newMotionClip, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP, newMotionClip, newMotionClip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP:
				return basicSetMotionClip(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__NAME:
				return getName();
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP:
				return getMotionClip();
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
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__NAME:
				setName((String)newValue);
				return;
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP:
				setMotionClip((MotionClip)newValue);
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
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP:
				setMotionClip((MotionClip)null);
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
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ContentsComposerPackage.MOTION_CLIP_BLOCK__MOTION_CLIP:
				return motionClip != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_TYPE = "_type";
	public static final String P_NAME = "_name";
	public static final String P_CLONE = "_clones";
	public static final String P_START = "_start";
	public static final String P_STOP = "_stop";
	public static final String P_TOTAL = "_total";

	@Override
	public MotionClipBlock deepCopy(MotionContent newParent)
	{
		MotionClipBlock newBlock = ContentsComposerFactory.eINSTANCE.createMotionClipBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}
	
	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((MotionClipBlock)newBlock).setName(getName());
		((MotionClipBlock)newBlock).setMotionClip(getMotionClip().deepCopy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CLIP_BLOCK__NAME, oldName, name));
	}
	
	// 전체 프레임 수를 얻는다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getTotalFrames()
	{
		return getMotionClip() == null ? 0 : getMotionClip().getTotalFrames();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateName(String newName)
	{
		setName(newName);
		getParent().firePropertyChange(MotionContent.P_CHILDREN, null, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int countClones()
	{
		List<BlockElement> children = getParent().getBlocks();
		int clones = 0;
		for(int i = 0; i < children.size(); i ++)
		{
			BlockElement block = children.get(i);
			if(block instanceof MotionClipCloneBlock)
			{
				// 클론 중에서 원본이 이것과 같은 것을 센다.
				MotionClipBlock mc = ((MotionClipCloneBlock)block).getOriginal();
				if(mc != null && mc.equals(this)) clones ++;
			}
		}
		return clones;
	}

	// 삭제할 수 있는지 묻는다.
//	@Override
//	public boolean canDelete()
//	{
//		// 클론이 없어야 한다.
//		if(countClones() != 0) return false;
//		return true;
//	}
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		PropertyDescriptor propertyClipType = new PropertyDescriptor(P_TYPE, "Clip Type");
		propertyClipType.setCategory("Attribute");
		TextPropertyDescriptor propertyClipName = new TextPropertyDescriptor(P_NAME, "Clip Name");
		propertyClipName.setCategory("Attribute");
		PropertyDescriptor propertyClones = new PropertyDescriptor(P_CLONE, "Clones");
		propertyClones.setCategory("Attribute");
		TextPropertyDescriptor propertyStartFrame = new TextPropertyDescriptor(P_START, "Start Frame");
		propertyStartFrame.setCategory("Attribute");
		TextPropertyDescriptor propertyStopFrame = new TextPropertyDescriptor(P_STOP, "Stop Frame");
		propertyStopFrame.setCategory("Attribute");
		PropertyDescriptor propertyTotalFrames = new PropertyDescriptor(P_TOTAL, "Total Frames");
		propertyTotalFrames.setCategory("Attribute");
		return new IPropertyDescriptor[]
		{
			propertyClipType,
			propertyClipName,
			propertyClones,
			propertyStartFrame,
			propertyStopFrame,				
			propertyTotalFrames				
		};
	}

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_TYPE)) return "Motion Clip";
		if(id.equals(P_NAME)) return getName();
		if(id.equals(P_CLONE)) return countClones();
		if(id.equals(P_START)) return Integer.toString(getStartFrame());
		if(id.equals(P_STOP)) return Integer.toString(getStopFrame());
		if(id.equals(P_TOTAL)) return getTotalFrames();
		return null;
	}
	
	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_NAME)) return true;
		if(id.equals(P_CLONE)) return true;
		if(id.equals(P_START)) return true;
		if(id.equals(P_STOP)) return true;
		if(id.equals(P_TOTAL)) return true;
		return super.isPropertySet(id);
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_NAME))
		{
			setName((String)value);
			getParent().firePropertyChange(MotionContent.P_CHILDREN, null, null);
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
	
	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		// 입출력선이 없지만 클론이 있는 경우에는 true
		if(getOutgoings().size() == 0 && getIncomings().size() == 0 && countClones() > 0) return true;
		return super.validate();
	}
} //MotionClipBlockImpl
