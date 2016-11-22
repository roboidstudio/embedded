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
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.ForkBlock;
import org.roboid.studio.contentscomposer.MergeBlock;
import org.roboid.studio.contentscomposer.TriggerBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clip Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.ClipBlockImpl#getFrame <em>Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClipBlockImpl extends BlockElementImpl implements ClipBlock
{
	/**
	 * The default value of the '{@link #getFrame() <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected static final int FRAME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFrame() <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected int frame = FRAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClipBlockImpl()
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
		return ContentsComposerPackage.Literals.CLIP_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrame()
	{
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrame(int newFrame)
	{
		int oldFrame = frame;
		frame = newFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.CLIP_BLOCK__FRAME, oldFrame, frame));
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
			case ContentsComposerPackage.CLIP_BLOCK__FRAME:
				return getFrame();
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
			case ContentsComposerPackage.CLIP_BLOCK__FRAME:
				setFrame((Integer)newValue);
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
			case ContentsComposerPackage.CLIP_BLOCK__FRAME:
				setFrame(FRAME_EDEFAULT);
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
			case ContentsComposerPackage.CLIP_BLOCK__FRAME:
				return frame != FRAME_EDEFAULT;
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
		result.append(" (frame: ");
		result.append(frame);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	// �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(target.equals(this)) // Ÿ���� ��� �Է¼��� ����� �Ѵ�.
		{
			if(getIncomings().size() != 0) return false;
			return true;
		}
		
		// Ʈ������ ������ ����.
		int triggers = 0;
		for(int i = 0; i < getOutgoings().size(); i ++)
		{
			BlockElement block  = getOutgoings().get(i).getTarget();
			if(block instanceof TriggerBlock) triggers ++;
		}
		
		// ����� ��� Ʈ������ ��� ������ �� �ִ�.
		if(getOutgoings().size() == triggers) return true;
		// Ʈ���Ű� �ƴ� ����� 1�� ������ Ÿ���� Ʈ���ſ��� �Ѵ�. 
		if(getOutgoings().size() - triggers < 2)
		{
			if(target instanceof TriggerBlock) return true;
		}
		return false;
	}

	// �翬�� �� �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canReconnect(BlockElement newSource, BlockElement newTarget, BlockElement oldBlock)
	{
		if(newTarget != null) // Ÿ���� �����Ѵ�.
		{
			if(!(oldBlock instanceof TriggerBlock)) // ���� Ÿ���� Ʈ���Ű� �ƴ� ���
				return true;
			
			// Ʈ������ ������ ����.
			int triggers = 0;
			for(int i = 0; i < getOutgoings().size(); i ++)
			{
				BlockElement block  = getOutgoings().get(i).getTarget();
				if(block instanceof TriggerBlock) triggers ++;
			}
			
			// ����� ��� Ʈ������ ��� ������ �� �ִ�.
			if(getOutgoings().size() == triggers) return true;
			// Ʈ���Ű� �ƴ� ����� 1�� ������ Ÿ���� Ʈ���ſ��� �Ѵ�.
			if(getOutgoings().size() - triggers < 2)
			{
				if(newTarget instanceof TriggerBlock) return true;
			}
			
			return false;
		}
		return true;
	}
	
	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		if(getIncomings().size() != 1) return false; // �Է¼��� ����.
		if(getOutgoings().size() == 0) return false; // ��¼��� ����.
		
		// ��¼��� �ִ� ���
		// Ʈ������ ������ ����.
		int triggers = 0;
		for(int i = 0; i < getOutgoings().size(); i ++)
		{
			BlockElement block = getOutgoings().get(i).getTarget();
			if(block instanceof TriggerBlock) triggers ++;
		}
		// Ʈ���Ű� �ƴ� ���� �ϳ� �־�� �Ѵ�.
		if(getOutgoings().size() - triggers != 1) return false;
		
		// �Է��� ��ũ�̰ų� ����� ������ ��츦 �˻��Ѵ�.
		if(getIncomings().size() > 0)
		{
			BlockElement priorBlock = getIncomings().get(0).getSource();
			if(priorBlock instanceof ForkBlock) // �Է��� ��ũ�� ���
			{
				// �Է��� ��ũ�� ��쿡�� ����� �ϳ��� �־�� �ϸ� �������� �Ѵ�.
				if(getOutgoings().size() != 1) return false;
				BlockElement postBlock = getOutgoings().get(0).getTarget();
				if(!(postBlock instanceof MergeBlock)) return false;
			}
		}
		if(getOutgoings().size() > 0)
		{
			BlockElement postBlock = getOutgoings().get(0).getTarget();
			if(postBlock instanceof MergeBlock) // ����� ������ ���
			{
				// ����� ������ ��쿡�� �Է��� �ϳ��� �־�� �ϸ� ��ũ���� �Ѵ�.
				if(getIncomings().size() != 1) return false;
				BlockElement priorBlock = getIncomings().get(0).getSource();
				if(!(priorBlock instanceof ForkBlock)) return false;
			}
		}
		return true;
	}

	// ���� ��带 ��´�. ��� �� ȣ��ǹǷ� ����¼��� �ִ�.
	@Override
	public BlockElement getNextBlock()
	{
		// ��� �߿��� Ʈ���Ű� �ƴ� ��带 ã�´�.
		for(int i = 0; i < getOutgoings().size(); i ++)
		{
			BlockElement block = getOutgoings().get(i).getTarget();
			if(!(block instanceof TriggerBlock))
				return block;
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void resetTriggers()
	{
		for(int i = 0; i < getOutgoings().size(); i ++)
		{
			BlockElement block = getOutgoings().get(i).getTarget();
			if(block instanceof TriggerBlock) ((TriggerBlock)block).reset();
		}
	}
	
	@Override
	public void reset()
	{
		frame = 0;
		super.reset();
	}

	@Override
	public float getVariable()
	{
		return frame;
	}
} //ClipBlockImpl
