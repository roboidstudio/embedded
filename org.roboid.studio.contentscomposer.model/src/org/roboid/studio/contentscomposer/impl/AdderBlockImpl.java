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
import org.roboid.studio.contentscomposer.AdderBlock;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adder Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AdderBlockImpl extends BlockElementImpl implements AdderBlock
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdderBlockImpl()
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
		return ContentsComposerPackage.Literals.ADDER_BLOCK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	@Override
	public AdderBlock deepCopy(MotionContent newParent)
	{
		AdderBlock newBlock = ContentsComposerFactory.eINSTANCE.createAdderBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}
	
	// �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(source.equals(this)) // �ҽ��� ��� ��¼��� ����� �Ѵ�.
		{
			if(getOutgoings().size() != 0) return false;
		}
		return true;
	}

	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 1) return false; // ��¼��� ����.
		if(getIncomings().size() < 1) return false; // �Է¼��� ����.
		return true;
	}

	// ���� ��带 ��´�. ��� �� ȣ��ǹǷ� ����¼��� �ִ�.
	@Override
	public BlockElement getNextBlock()
	{
		return getOutgoings().get(0).getTarget();
	}
} //AdderBlockImpl
