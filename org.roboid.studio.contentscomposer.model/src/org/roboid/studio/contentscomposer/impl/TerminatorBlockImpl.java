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

	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // ��ũ��Ʈ Ÿ��
		{
			setScriptType(ScriptType.get(((Integer)value).intValue())); // ��ũ��Ʈ Ÿ���� �����Ѵ�.
			
			// ��� terminator ����� ��ũ��Ʈ Ÿ���� �����Ѵ�.
			for(BlockElement block : getParent().getBlocks())
			{
				if(block instanceof TerminatorBlock)
				{
					((TerminatorBlock)block).setScriptType(scriptType); // Ÿ�� ����
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

	// ��ũ��Ʈ Ÿ���� �����Ѵ�.
	@Override
	public void setScriptType(ScriptType newScriptType)
	{
		super.setScriptType(newScriptType);
		firePropertyChange(P_LABEL, null, null);
	}

	// ��ũ��Ʈ ������ ��´�.
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

	// ��ũ��Ʈ�� ���� �� �ִ� ������� ���´�.
	@Override
	public boolean canHaveScript()
	{
		return true;
	}

	// ��ũ��Ʈ Ÿ�԰� ����, �ڵ带 �����Ѵ�.
	@Override
	public void updateScript(String scriptName, String scriptCode)
	{
		setScriptCode(scriptCode);
		
		// ��� terminator ����� ��ũ��Ʈ Ÿ���� �����Ѵ�.
		for(BlockElement block : getParent().getBlocks())
		{
			if(block instanceof TerminatorBlock)
			{
				((TerminatorBlock)block).setScriptType(ScriptType.ROBOID_SCRIPT); // Ÿ�� ����
			}
		}
	}

	// ��ũ��Ʈ �ڵ带 ��´�.
	// ��� terminator ���� ��ũ��Ʈ �ڵ带 �����ϹǷ� ��ũ��Ʈ �ڵ带 ���̾�׷��� �д�.
	@Override
	public String getScriptCode()
	{
		return getParent().getTerminatorScriptCode();
	}

	// ��ũ��Ʈ �ڵ带 �����Ѵ�.
	@Override
	public void setScriptCode(String newScriptCode)
	{
		getParent().setTerminatorScriptCode(newScriptCode);
	}

	// ��ũ��Ʈ �ڵ带 �����Ѵ�.
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
	
	// �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(source.equals(this)) return false; // terminator�� �ҽ��� �� �� ����.
//		if(getOutgoings().size() != 0) return false;
		return true;
	}

	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		if(getIncomings().size() == 0) return false; // �Է¼��� ����.
		return true;
	}

	// ���� ��带 ��´�. terminator�� ���� ��尡 ����.
	@Override
	public BlockElement getNextBlock()
	{
		executeScript();
		return null;
	}
} //TerminatorBlockImpl
