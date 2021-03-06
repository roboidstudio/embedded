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

import org.eclipse.emf.ecore.EClass;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.TriggerBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TriggerBlockImpl extends LogicBlockImpl implements TriggerBlock
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerBlockImpl()
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
		return ContentsComposerPackage.Literals.TRIGGER_BLOCK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	@Override
	public TriggerBlock deepCopy(MotionContent newParent)
	{
		TriggerBlock newBlock = ContentsComposerFactory.eINSTANCE.createTriggerBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}

	// 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		// 소스가 클립이나 트리거가 아니다.
		if(!(source instanceof ClipBlock || source instanceof TriggerBlock)) return false;
		//if(source instanceof ContentClip || source instanceof CloneContent) return false;
		
		if(target.equals(this)) // 타겟인 경우 입력선이 없어야 한다.
		{
			if(getIncomings().size() == 0) return true;
		}
		if(source.equals(this)) // 소스인 경우 출력선이 없어야 한다. 
		{
			if(getOutgoings().size() == 0) return true;
		}
		return false;
	}

	// 재연결 시 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canReconnect(BlockElement newSource, BlockElement newTarget, BlockElement oldBlock)
	{
		if(newSource != null) // 소스를 변경한다.
		{
			// 소스가 클립이나 트리거가 아니다.
			if(!(newSource instanceof ClipBlock || newSource instanceof TriggerBlock)) return false;
		}
		return true;
	}

	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 1) return false; // 출력선이 없다.
		if(getIncomings().size() != 1) return false; // 입력선이 없다.
		return true;
	}
	
	/**
	 * get next block of trigger
	 */
	// 다음 노드를 얻는다. 재생 시 호출되므로 입출력선이 있다.
	@Override
	public BlockElement getNextBlock()
	{
		return getOutgoings().get(0).getTarget();
	}
} //TriggerBlockImpl
