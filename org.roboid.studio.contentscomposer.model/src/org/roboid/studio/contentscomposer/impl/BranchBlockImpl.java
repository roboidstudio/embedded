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

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.eclipse.emf.ecore.EClass;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.BranchBlock;
import org.roboid.studio.contentscomposer.ClipBlockWithFrame;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BranchBlockImpl#getYesBlock <em>Yes Block</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BranchBlockImpl#getNoBlock <em>No Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchBlockImpl extends LogicBlockImpl implements BranchBlock
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchBlockImpl()
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
		return ContentsComposerPackage.Literals.BRANCH_BLOCK;
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
			case ContentsComposerPackage.BRANCH_BLOCK__YES_BLOCK:
				return getYesBlock();
			case ContentsComposerPackage.BRANCH_BLOCK__NO_BLOCK:
				return getNoBlock();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case ContentsComposerPackage.BRANCH_BLOCK__YES_BLOCK:
				return getYesBlock() != null;
			case ContentsComposerPackage.BRANCH_BLOCK__NO_BLOCK:
				return getNoBlock() != null;
		}
		return super.eIsSet(featureID);
	}

	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */

	@Override
	public BranchBlock deepCopy(MotionContent newParent)
	{
		BranchBlock newBlock = ContentsComposerFactory.eINSTANCE.createBranchBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}
	
	// 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
//		if(source instanceof AbstractClip) return false;
		if(target.equals(this)) // 타겟인 경우 입력선이 없어야 한다.
		{
			if(getIncomings().size() == 0) return true;
		}
		if(source.equals(this)) // 소스인 경우 출력선이 2개보다 적아야 한다.
		{
			if(getOutgoings().size() < 2) return true;
		}
		return false;
	}

	// 출력선을 추가한다.
	@Override
	public void addOutgoing(Association association)
	{
		if(getOutgoings().size() == 0)
			association.setSourceLabel("y"); // 첫번째 선에 y 표시
		else
		{
			if(getOutgoings().get(0).getSourceLabel().equals("y"))
				association.setSourceLabel("n"); // y가 이미 있으면 n을 표시
			else
				association.setSourceLabel("y");
		}
		super.addOutgoing(association);

		//Is first connection? then set label to "y"
//		if(getOutgoings().size() == 1)	
//			association.setSourceLabel("y");
//		else //Is second, then change label of first to "y" and set "n" itself
//			association.setSourceLabel("n");
	}

	// 출력선을 제거한다.
	@Override
	public void removeOutgoing(Association association)
	{
		super.removeOutgoing(association);
//		if(getOutgoings().size() == 1)
//		{
//			Association asso = (Association)getOutgoings().get(0);
//			asso.setSourceLabel("y");
//		}
	}
	
	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 2) return false; // 출력선이 2개가 아니다.
		if(getIncomings().size() != 1) return false; // 입력선이 없다.
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BlockElement getYesBlock()
	{
		Association association = getOutgoings().get(0);
		if(association.getSourceLabel().equals("y")) return association.getTarget();
		return getOutgoings().get(1).getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BlockElement getNoBlock()
	{
		Association association = getOutgoings().get(0);
		if(association.getSourceLabel().equals("n")) return association.getTarget();
		return getOutgoings().get(1).getTarget();
	}
	
	@Override
	public BlockElement getNextBlock()
	{
		if(checkCondition()) return getYesBlock();
		return getNoBlock();
	}
	
	// 스크립트를 검사한다.
	@Override
	boolean checkScript()
	{
		if(getScriptType() == ScriptType.ROBOID_SCRIPT)			//supporting java script only
		{
			String script = getScriptCode();
			if(script.equals("")) return false; // 스크립트가 없으므로 통과
			
			// 자바 스크립트 엔진을 얻는다.
			ScriptEngine scriptEngine = getParent().getScriptEngine();

			ClipBlockWithFrame clipY = null;
			ClipBlockWithFrame clipN = null;
			if(getYesBlock() instanceof ClipBlockWithFrame) // 다음 노드가 모션 클립이면
				clipY = (ClipBlockWithFrame)getYesBlock();
			if(getNoBlock() instanceof ClipBlockWithFrame) // 다음 노드가 모션 클립이면 
				clipN = (ClipBlockWithFrame)getNoBlock();
			
			// 스크립트에서 clipY, clipN을 사용할 수 있게 한다.
			scriptEngine.put("ClipY", clipY);
			scriptEngine.put("ClipN", clipN);
			scriptEngine.put("clipY", clipY);
			scriptEngine.put("clipN", clipN);
			// 스크립트에서 value, frame를 사용할 수 있게 한다.
			scriptEngine.put("value", getVariable());
			scriptEngine.put("frame", frame);
			
			boolean isTriggered = false;
			try
			{
				isTriggered = (Boolean)scriptEngine.eval(script);
			} catch (ScriptException e)
			{
				e.printStackTrace();
				ConsoleFactory.getInstance().println(e.getMessage());
			}
			frame ++;
			return isTriggered;
		}
		else return false;
	}
} //BranchBlockImpl
