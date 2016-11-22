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
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.MovableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content Clip Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentBlockImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentBlockImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotionContentBlockImpl extends ClipBlockImpl implements MotionContentBlock
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
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected MotionContent content;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotionContentBlockImpl()
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
		return ContentsComposerPackage.Literals.MOTION_CONTENT_BLOCK;
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
			if(block instanceof MotionContentCloneBlock)
			{
				// Ŭ�� �߿��� ������ �̰Ͱ� ���� ���� ����.
				MotionContentBlock cc = ((MotionContentCloneBlock)block).getOriginal();
				if(cc != null && cc.equals(this)) clones ++;
			}
		}
		return clones;
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
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT:
				return basicSetContent(null, msgs);
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
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__NAME:
				return getName();
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT:
				return getContent();
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
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__NAME:
				setName((String)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT:
				setContent((MotionContent)newValue);
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
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT:
				setContent((MotionContent)null);
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
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT:
				return content != null;
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
	
	@Override
	public MotionContentBlock deepCopy(MotionContent newParent)
	{
		MotionContentBlock newBlock = ContentsComposerFactory.eINSTANCE.createMotionContentBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}

	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((MotionContentBlock)newBlock).setName(getName());
		((MotionContentBlock)newBlock).setContent(getContent().deepCopy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName()
	{
		if(name == null) name = "";
		return name;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT_BLOCK__NAME, oldName, name));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionContent getContent()
	{
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContent(MotionContent newContent, NotificationChain msgs)
	{
		MotionContent oldContent = content;
		content = newContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT, oldContent, newContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(MotionContent newContent)
	{
		if (newContent != content) {
			NotificationChain msgs = null;
			if (content != null)
				msgs = ((InternalEObject)content).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT, null, msgs);
			if (newContent != null)
				msgs = ((InternalEObject)newContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT, null, msgs);
			msgs = basicSetContent(newContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT_BLOCK__CONTENT, newContent, newContent));
	}

	// ������ �� �ִ��� ���´�.
//	@Override
//	public boolean canDelete()
//	{
//		// Ŭ���� ������ ������ �� ����.
//		if(countClones() != 0) return false;
//		return true;
//	}
	
	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		PropertyDescriptor propertyClipType = new PropertyDescriptor(P_TYPE, "Clip Type");
		propertyClipType.setCategory("Attribute");
		TextPropertyDescriptor propertyClipName = new TextPropertyDescriptor(P_NAME, "Clip Name");
		propertyClipName.setCategory("Attribute");
		PropertyDescriptor propertyClones = new PropertyDescriptor(P_CLONE, "Clones");
		propertyClones.setCategory("Attribute");
		return new IPropertyDescriptor[]
		{
			propertyClipType,
			propertyClipName,
			propertyClones
		};
	}

	// ������Ƽ�� ���� ��´�.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_TYPE)) return "Contents Clip";
		if(id.equals(P_NAME)) return getName();
		if(id.equals(P_CLONE)) return countClones();
		return null;
	}
	
	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_NAME)) return true;
		if(id.equals(P_CLONE)) return true;
		return super.isPropertySet(id);
	}

	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_NAME)) // Ŭ�� �̸�
		{
			setName((String)value);
			getParent().firePropertyChange(MotionContent.P_CHILDREN, null, null);
		}
	}
	
	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		// ����¼��� ������ Ŭ���� �ִ� ��쿡�� true
		if(getOutgoings().size() == 0 && getIncomings().size() == 0 && countClones() > 0) return true; 
		return super.validate();
	}
} //ContentClipBlockImpl
