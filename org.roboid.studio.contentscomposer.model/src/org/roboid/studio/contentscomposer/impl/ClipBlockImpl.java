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
	
	// 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(target.equals(this)) // 타겟인 경우 입력선이 없어야 한다.
		{
			if(getIncomings().size() != 0) return false;
			return true;
		}
		
		// 트리거의 개수를 센다.
		int triggers = 0;
		for(int i = 0; i < getOutgoings().size(); i ++)
		{
			BlockElement block  = getOutgoings().get(i).getTarget();
			if(block instanceof TriggerBlock) triggers ++;
		}
		
		// 출력이 모두 트리거인 경우 연결할 수 있다.
		if(getOutgoings().size() == triggers) return true;
		// 트리거가 아닌 출력이 1개 있으면 타겟이 트리거여야 한다. 
		if(getOutgoings().size() - triggers < 2)
		{
			if(target instanceof TriggerBlock) return true;
		}
		return false;
	}

	// 재연결 시 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canReconnect(BlockElement newSource, BlockElement newTarget, BlockElement oldBlock)
	{
		if(newTarget != null) // 타겟을 변경한다.
		{
			if(!(oldBlock instanceof TriggerBlock)) // 원래 타겟이 트리거가 아닌 경우
				return true;
			
			// 트리거의 개수를 센다.
			int triggers = 0;
			for(int i = 0; i < getOutgoings().size(); i ++)
			{
				BlockElement block  = getOutgoings().get(i).getTarget();
				if(block instanceof TriggerBlock) triggers ++;
			}
			
			// 출력이 모두 트리거인 경우 연결할 수 있다.
			if(getOutgoings().size() == triggers) return true;
			// 트리거가 아닌 출력이 1개 있으면 타겟이 트리거여야 한다.
			if(getOutgoings().size() - triggers < 2)
			{
				if(newTarget instanceof TriggerBlock) return true;
			}
			
			return false;
		}
		return true;
	}
	
	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		if(getIncomings().size() != 1) return false; // 입력선이 없다.
		if(getOutgoings().size() == 0) return false; // 출력선이 없다.
		
		// 출력선이 있는 경우
		// 트리거의 개수를 센다.
		int triggers = 0;
		for(int i = 0; i < getOutgoings().size(); i ++)
		{
			BlockElement block = getOutgoings().get(i).getTarget();
			if(block instanceof TriggerBlock) triggers ++;
		}
		// 트리거가 아닌 것이 하나 있어야 한다.
		if(getOutgoings().size() - triggers != 1) return false;
		
		// 입력이 포크이거나 출력이 머지인 경우를 검사한다.
		if(getIncomings().size() > 0)
		{
			BlockElement priorBlock = getIncomings().get(0).getSource();
			if(priorBlock instanceof ForkBlock) // 입력이 포크인 경우
			{
				// 입력이 포크인 경우에는 출력이 하나만 있어야 하며 머지여야 한다.
				if(getOutgoings().size() != 1) return false;
				BlockElement postBlock = getOutgoings().get(0).getTarget();
				if(!(postBlock instanceof MergeBlock)) return false;
			}
		}
		if(getOutgoings().size() > 0)
		{
			BlockElement postBlock = getOutgoings().get(0).getTarget();
			if(postBlock instanceof MergeBlock) // 출력이 머지인 경우
			{
				// 출력이 머지인 경우에는 입력이 하나만 있어야 하며 포크여야 한다.
				if(getIncomings().size() != 1) return false;
				BlockElement priorBlock = getIncomings().get(0).getSource();
				if(!(priorBlock instanceof ForkBlock)) return false;
			}
		}
		return true;
	}

	// 다음 노드를 얻는다. 재생 시 호출되므로 입출력선이 있다.
	@Override
	public BlockElement getNextBlock()
	{
		// 출력 중에서 트리거가 아닌 노드를 찾는다.
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
