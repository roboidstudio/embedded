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
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminator Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TerminatorBlockImpl extends BlockElementImpl implements TerminatorBlock
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminatorBlockImpl()
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
		return ContentsComposerPackage.Literals.TERMINATOR_BLOCK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_TYPE = "_type";

	@Override
	public TerminatorBlock deepCopy(MotionContent newParent)
	{
		TerminatorBlock newBlock = ContentsComposerFactory.eINSTANCE.createTerminatorBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
		propertyScriptType.setCategory("Script");
		return new IPropertyDescriptor[] {
			propertyScriptType				
		};
	}

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_TYPE)) return ScriptType.VALUES.indexOf(getScriptType());
		return null;
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // 스크립트 타입
		{
			setScriptType(ScriptType.get(((Integer)value).intValue())); // 스크립트 타입을 설정한다.
			
			// 모든 terminator 노드의 스크립트 타입을 설정한다.
			for(BlockElement block : getParent().getBlocks())
			{
				if(block instanceof TerminatorBlock)
				{
					((TerminatorBlock)block).setScriptType(scriptType); // 타입 설정
				}
			}
		}
	}
	
	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		return super.isPropertySet(id);
	}

	// 스크립트 타입을 설정한다.
	@Override
	public void setScriptType(ScriptType newScriptType)
	{
		super.setScriptType(newScriptType);
		firePropertyChange(P_LABEL, null, null);
	}

	// 스크립트 제목을 얻는다.
	@Override
	public String getScriptName()
	{
		return "stop";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void copyScriptType()
	{
		for(BlockElement block : getParent().getBlocks())
		{
			if(block instanceof TerminatorBlock)
			{
				setScriptType(((TerminatorBlock)block).getScriptType());
				break;
			}
		}
	}

	// 스크립트를 가질 수 있는 노드인지 묻는다.
	@Override
	public boolean canHaveScript()
	{
		return true;
	}

	// 스크립트 타입과 제목, 코드를 변경한다.
	@Override
	public void updateScript(String scriptName, String scriptCode)
	{
		setScriptCode(scriptCode);
		
		// 모든 terminator 노드의 스크립트 타입을 설정한다.
		for(BlockElement block : getParent().getBlocks())
		{
			if(block instanceof TerminatorBlock)
			{
				((TerminatorBlock)block).setScriptType(ScriptType.ROBOID_SCRIPT); // 타입 설정
			}
		}
	}

	// 스크립트 코드를 얻는다.
	// 모든 terminator 노드는 스크립트 코드를 공유하므로 스크립트 코드를 다이어그램에 둔다.
	@Override
	public String getScriptCode()
	{
		return getParent().getTerminatorScriptCode();
	}

	// 스크립트 코드를 설정한다.
	@Override
	public void setScriptCode(String newScriptCode)
	{
		getParent().setTerminatorScriptCode(newScriptCode);
	}

	// 스크립트 코드를 실행한다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void executeScript()
	{
		if(getScriptType() == ScriptType.NONE) return; // 스크립트가 아니므로 통과
		if(getScriptType() == ScriptType.ROBOID_SCRIPT) // 자바 스크립트다.
		{
			String script = getScriptCode();
			if(script.equals("")) return; // 스크립트가 없으므로 통과
			
			// 자바 스크립트 엔진을 얻는다.
			ScriptEngine scriptEngine = getParent().getScriptEngine();
			try
			{
				scriptEngine.eval(script); // 스크립트 실행
			} catch (ScriptException e)
			{
				e.printStackTrace();
				ConsoleFactory.getInstance().println(e.getMessage());
			}
		}
	}
	
	// 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(source.equals(this)) return false; // terminator는 소스가 될 수 없다.
//		if(getOutgoings().size() != 0) return false;
		return true;
	}

	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		if(getIncomings().size() == 0) return false; // 입력선이 없다.
		return true;
	}

	// 다음 노드를 얻는다. terminator는 다음 노드가 없다.
	@Override
	public BlockElement getNextBlock()
	{
		executeScript();
		return null;
	}
} //TerminatorBlockImpl
