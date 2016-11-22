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
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RootBlockImpl extends BlockElementImpl implements RootBlock
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootBlockImpl()
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
		return ContentsComposerPackage.Literals.ROOT_BLOCK;
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_TYPE = "_type";
	
	@Override
	public RootBlock deepCopy(MotionContent newParent)
	{
		RootBlock newBlock = ContentsComposerFactory.eINSTANCE.createRootBlock();
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

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		return super.isPropertySet(id);
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // 스크립트 타입
		{
			setScriptType(ScriptType.get(((Integer)value).intValue()));
			firePropertyChange(P_LABEL, null, null);
		}
	}
	
	@Override
	public String getScriptName()
	{
		return "start";
	}
	
	@Override
	public boolean canHaveScript()
	{
		return true;
	}

	@Override
	public void updateScript(String scriptName, String scriptCode)
	{
		setScriptType(ScriptType.ROBOID_SCRIPT);
		setScriptCode(scriptCode);
		firePropertyChange(P_LABEL, null, null);
	}

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
	
	@Override
	public boolean canDelete()
	{
		return false;
	}
	
	@Override
	public boolean canCopy()
	{
		return false;
	}

	@Override
	public boolean canCut()
	{
		return false;
	}

	// 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(target.equals(this)) return false; // root는 타겟이 될 수 없다.
//		if(getIncomings().size() != 0) return false;
		if(getOutgoings().size() != 0) return false; // 이미 출력선이 있다.
		return true;
	}
	
	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 1) return false; // 출력선이 없다.
		return true;
	}
	
	// 다음 노드를 얻는다. 재생 시 호출되므로 출력선이 있다.
	@Override
	public BlockElement getNextBlock()
	{
		executeScript();
		return getOutgoings().get(0).getTarget(); // 출력선의 타겟을 얻는다.
	}
} //RootBlockImpl
