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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ClipBlockWithFrame;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.LoopBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LoopBlockImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LoopBlockImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LoopBlockImpl#getYesBlock <em>Yes Block</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LoopBlockImpl#getNoBlock <em>No Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopBlockImpl extends BlockElementImpl implements LoopBlock
{
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopBlockImpl()
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
		return ContentsComposerPackage.Literals.LOOP_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue)
	{
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOOP_BLOCK__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount)
	{
		int oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOOP_BLOCK__COUNT, oldCount, count));
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
			case ContentsComposerPackage.LOOP_BLOCK__VALUE:
				return getValue();
			case ContentsComposerPackage.LOOP_BLOCK__COUNT:
				return getCount();
			case ContentsComposerPackage.LOOP_BLOCK__YES_BLOCK:
				return getYesBlock();
			case ContentsComposerPackage.LOOP_BLOCK__NO_BLOCK:
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case ContentsComposerPackage.LOOP_BLOCK__VALUE:
				setValue((Integer)newValue);
				return;
			case ContentsComposerPackage.LOOP_BLOCK__COUNT:
				setCount((Integer)newValue);
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
			case ContentsComposerPackage.LOOP_BLOCK__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ContentsComposerPackage.LOOP_BLOCK__COUNT:
				setCount(COUNT_EDEFAULT);
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
			case ContentsComposerPackage.LOOP_BLOCK__VALUE:
				return value != VALUE_EDEFAULT;
			case ContentsComposerPackage.LOOP_BLOCK__COUNT:
				return count != COUNT_EDEFAULT;
			case ContentsComposerPackage.LOOP_BLOCK__YES_BLOCK:
				return getYesBlock() != null;
			case ContentsComposerPackage.LOOP_BLOCK__NO_BLOCK:
				return getNoBlock() != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(", count: ");
		result.append(count);
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
	public static final String P_LOOP = "_loops";

	@Override
	public LoopBlock deepCopy(MotionContent newParent)
	{
		LoopBlock newBlock = ContentsComposerFactory.eINSTANCE.createLoopBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}

	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((LoopBlock)newBlock).setCount(getCount());
	}
	
	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		if(getScriptType() == ScriptType.NONE) // ��ũ��Ʈ�� �ƴϴ�.
		{
			TextPropertyDescriptor propertyCount = new TextPropertyDescriptor(P_LOOP, "Count(<1000)");
			propertyCount.setCategory("Attribute");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
			propertyScriptType.setCategory("Script");
			return new IPropertyDescriptor[] {
				propertyCount,
				propertyScriptType
			};
		}
		if(getScriptType() == ScriptType.ROBOID_SCRIPT) // �ڹ� ��ũ��Ʈ
		{
			TextPropertyDescriptor propertyScriptName = new TextPropertyDescriptor(P_NAME, "Name");
			propertyScriptName.setCategory("Script");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
			propertyScriptType.setCategory("Script");
			return new IPropertyDescriptor[] {
				propertyScriptType,
				propertyScriptName
			};
		}
		return null;
	}

	// ������Ƽ�� ���� ��´�.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_LOOP)) return Integer.toString(getCount());
		if(id.equals(P_TYPE)) return ScriptType.VALUES.indexOf(getScriptType());
		if(id.equals(P_NAME)) return getScriptName();
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_LOOP)) return true;
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_NAME)) return true;
		return super.isPropertySet(id);
	}

	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // ��ũ��Ʈ Ÿ��
		{
			scriptType = ScriptType.get(((Integer)value).intValue());
			firePropertyChange(P_REDRAW, null, null); // loop ���ο� 'js'�� �����Ƿ� �ٽ� �׸���.
		}
		else if(id.equals(P_NAME)) // ��ũ��Ʈ ����
		{
			scriptName = (String)value;
			firePropertyChange(P_LABEL, null, null);
		}
		else if(id.equals(P_LOOP)) // �ݺ� Ƚ��
		{
			int count = 0;
			try
			{
				count = Integer.parseInt((String)value);
			} catch (Exception e)
			{
			}
			if(count > 999) count = 999;
			if(count < 1) count = 1;
			setCount(count);
			firePropertyChange(P_REDRAW, null, null); // loop ���ο� ���� �ִ밪�� �����Ƿ� �ٽ� �׸���.
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
		setScriptType(ScriptType.ROBOID_SCRIPT);
		setScriptName(scriptName);
		setScriptCode(scriptCode);
		firePropertyChange(P_REDRAW, null, null); // loop ���ο� 'js'�� �����Ƿ� �ٽ� �׸���.
	}

	@Override
	public void addOutgoing(Association association)
	{
		if(getOutgoings().size() == 0)
			association.setSourceLabel("y"); // ù��° ���� y ǥ��
		else
		{
			if(getOutgoings().get(0).getSourceLabel().equals("y"))
				association.setSourceLabel("n"); // y�� �̹� ������ n�� ǥ��
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

	// �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(target.equals(this)) // Ÿ���� ��� �Է¼��� ����� �Ѵ�.
		{
			if(getIncomings().size() == 0) return true;
		}
		if(source.equals(this)) // �ҽ��� ��� ��¼��� 2������ ����� �Ѵ�.
		{
			if(getOutgoings().size() < 2) return true;
		}
		return false;
	}

	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 2) return false; // ��¼��� 2���� �ƴϴ�.
		if(getIncomings().size() != 1) return false; // �Է¼��� ����.
		return true;
	}

	// ���� ��带 ��´�. ��� �� ȣ��ǹǷ� ����¼��� �ִ�.
	@Override
	public BlockElement getNextBlock()
	{
		value ++; // ���� ���� ���� ������Ų��.
		boolean isTrue = false;
		
		if(getScriptType() == ScriptType.NONE) // ��ũ��Ʈ�� �ƴϴ�.
		{
			//System.out.println("count " + count);
			if(value != count) // ������ �ݺ� Ƚ����ŭ �������� �ʾҴ�. 
				return getNoBlock();
			value = 0;
			return getYesBlock(); // �ݺ� Ƚ����ŭ ������ �Ͽ���.
		}
		else if(getScriptType() == ScriptType.ROBOID_SCRIPT) // �ڹ� ��ũ��Ʈ
		{
			String script = getScriptCode();
			if(script.equals("")) return getNoBlock(); // ��ũ��Ʈ�� ������ n�������� ����
			
			// �ڹ� ��ũ��Ʈ ������ ��´�.
			ScriptEngine scriptEngine = getParent().getScriptEngine();
			
			ClipBlockWithFrame clipY = null;
			ClipBlockWithFrame clipN = null;
			if(getYesBlock() instanceof ClipBlockWithFrame) // ���� ��尡 ��� Ŭ���̸�
				clipY = (ClipBlockWithFrame)getYesBlock();
			if(getNoBlock() instanceof ClipBlockWithFrame) // ���� ��尡 ��� Ŭ���̸� 
				clipN = (ClipBlockWithFrame)getNoBlock();
			
			// ��ũ��Ʈ���� clipY, clipN, value, count�� ����� �� �ְ� �Ѵ�.
			scriptEngine.put("ClipY", clipY);
			scriptEngine.put("ClipN", clipN);
			scriptEngine.put("clipY", clipY);
			scriptEngine.put("clipN", clipN);
			// 'value'�� ���� ����� ������ �Ѵ�.
			scriptEngine.put("value", getIncomings().get(0).getSource().getVariable());
			scriptEngine.put("count", value);

			try
			{
				isTrue = (Boolean)scriptEngine.eval(script); // ��ũ��Ʈ ����
				Object obj = scriptEngine.get("count"); // count ���� ��´�.
				value = (int)(Double.parseDouble(obj.toString()));
			} catch (ScriptException e)
			{
				e.printStackTrace();
				ConsoleFactory.getInstance().println(e.getMessage());
			}
		}
		if(isTrue) return getYesBlock();
		return getNoBlock();
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

	// 'value' ���� ��´�.
	@Override
	public float getVariable()
	{
		return value;
	}
	
	@Override
	public void reset()
	{
		value = 0;
		super.reset();
	}
} //LoopBlockImpl
