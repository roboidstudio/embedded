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

	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
		propertyScriptType.setCategory("Script");
		return new IPropertyDescriptor[] {
			propertyScriptType
		};
	}

	// ������Ƽ�� ���� ��´�.
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

	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // ��ũ��Ʈ Ÿ��
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
		if(getScriptType() == ScriptType.NONE) return; // ��ũ��Ʈ�� �ƴϹǷ� ���
		if(getScriptType() == ScriptType.ROBOID_SCRIPT) // �ڹ� ��ũ��Ʈ��.
		{
			String script = getScriptCode();
			if(script.equals("")) return; // ��ũ��Ʈ�� �����Ƿ� ���
		
			// �ڹ� ��ũ��Ʈ ������ ��´�.
			ScriptEngine scriptEngine = getParent().getScriptEngine();
			try
			{
				scriptEngine.eval(script); // ��ũ��Ʈ ����
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

	// �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(target.equals(this)) return false; // root�� Ÿ���� �� �� ����.
//		if(getIncomings().size() != 0) return false;
		if(getOutgoings().size() != 0) return false; // �̹� ��¼��� �ִ�.
		return true;
	}
	
	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 1) return false; // ��¼��� ����.
		return true;
	}
	
	// ���� ��带 ��´�. ��� �� ȣ��ǹǷ� ��¼��� �ִ�.
	@Override
	public BlockElement getNextBlock()
	{
		executeScript();
		return getOutgoings().get(0).getTarget(); // ��¼��� Ÿ���� ��´�.
	}
} //RootBlockImpl
