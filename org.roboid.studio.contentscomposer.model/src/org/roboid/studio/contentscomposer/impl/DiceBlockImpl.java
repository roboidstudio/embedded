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
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ClipBlockWithFrame;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.DiceBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dice Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.DiceBlockImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.DiceBlockImpl#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiceBlockImpl extends BlockElementImpl implements DiceBlock
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
	 * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected static final int RANGE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected int range = RANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiceBlockImpl()
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
		return ContentsComposerPackage.Literals.DICE_BLOCK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.DICE_BLOCK__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRange()
	{
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(int newRange)
	{
		int oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.DICE_BLOCK__RANGE, oldRange, range));
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
			case ContentsComposerPackage.DICE_BLOCK__VALUE:
				return getValue();
			case ContentsComposerPackage.DICE_BLOCK__RANGE:
				return getRange();
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
			case ContentsComposerPackage.DICE_BLOCK__VALUE:
				setValue((Integer)newValue);
				return;
			case ContentsComposerPackage.DICE_BLOCK__RANGE:
				setRange((Integer)newValue);
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
			case ContentsComposerPackage.DICE_BLOCK__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ContentsComposerPackage.DICE_BLOCK__RANGE:
				setRange(RANGE_EDEFAULT);
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
			case ContentsComposerPackage.DICE_BLOCK__VALUE:
				return value != VALUE_EDEFAULT;
			case ContentsComposerPackage.DICE_BLOCK__RANGE:
				return range != RANGE_EDEFAULT;
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
		result.append(", range: ");
		result.append(range);
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
	public static final String P_MAX = "_max";

	@Override
	public DiceBlock deepCopy(MotionContent newParent)
	{
		DiceBlock newBlock = ContentsComposerFactory.eINSTANCE.createDiceBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}
	
	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((DiceBlock)newBlock).setRange(getRange());
	}
	
	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		String[] scriptEngines = new String[ScriptType.values().length];
		for(int i = 0; i < ScriptType.values().length; i ++)
			scriptEngines[i] = ScriptType.get(i).getLiteral();
		
		if(getScriptType() == ScriptType.NONE) // ��ũ��Ʈ�� �ƴϴ�.
		{
			TextPropertyDescriptor propertyMax = new TextPropertyDescriptor(P_MAX, "Range(<1000)");
			propertyMax.setCategory("Attribute");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", scriptEngines);
			propertyScriptType.setCategory("Script");
			return new IPropertyDescriptor[] {
				propertyMax,
				propertyScriptType
			};
		}
		if(getScriptType() == ScriptType.ROBOID_SCRIPT) // �ڹ� ��ũ��Ʈ
		{
			TextPropertyDescriptor propertyScriptName = new TextPropertyDescriptor(P_NAME, "Name");
			propertyScriptName.setCategory("Script");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", scriptEngines);
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
		if(id.equals(P_MAX)) return Integer.toString(getRange());
		if(id.equals(P_TYPE)) return ScriptType.VALUES.indexOf(getScriptType());
		if(id.equals(P_NAME)) return getScriptName();
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_MAX)) return true;
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
			setScriptType(ScriptType.get(((Integer)value).intValue()));
			firePropertyChange(P_REDRAW, null, null); // dice ���ο� 'js'�� �����Ƿ� �ٽ� �׸���.
		}
		else if(id.equals(P_NAME)) // ��ũ��Ʈ ����
		{
			scriptName = (String)value;
			firePropertyChange(P_LABEL, null, null);
		}
		else if(id.equals(P_MAX)) // ���� �ִ밪
		{
			int range = 1;
			try
			{
				range = Integer.parseInt((String)value);
			} catch(Exception e)
			{}
			if(range > 999) range = 999;
			else if(range < 1) range = 1;
			setRange(range);
			firePropertyChange(P_REDRAW, null, null); // dice ���ο� ���� �ִ밪�� �����Ƿ� �ٽ� �׸���.
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
		firePropertyChange(P_REDRAW, null, null); // dice ���ο� 'js'�� �����Ƿ� �ٽ� �׸���.
	}

	// �� ��带 ������ �� �ִ��� ���´�.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		if(target.equals(this)) // Ÿ���� ��� �Է¼��� ����� �Ѵ�.
		{
			if(getIncomings().size() == 0) return true;
		}
		if(source.equals(this)) // �ҽ��� ��� ��¼��� ����� �Ѵ�.
		{
			if(getOutgoings().size() == 0) return true; // && target instanceof Branch) return true;
		}
		return false;
	}
	
	// ����� ������ �´��� �˻��Ѵ�.
	@Override
	public boolean validate()
	{
		if(getOutgoings().size() != 1) return false; // ��¼��� ����.
		if(getIncomings().size() != 1) return false; // �Է¼��� ����.
		return true;
	}
	
	// ���� ��带 ��´�. ��� �� ȣ��ǹǷ� ����¼��� �ִ�.
	@Override
	public BlockElement getNextBlock()
	{
		BlockElement nextBlock = getOutgoings().get(0).getTarget();
		
		if(getScriptType() == ScriptType.NONE) // ��ũ��Ʈ�� �ƴϴ�.
		{
			double r = Math.random(); // ���� �߻�
			value = (int)(Math.round(r * (range - 1)) + 1);
			return nextBlock;
		}
		if(getScriptType() == ScriptType.ROBOID_SCRIPT) // �ڹ� ��ũ��Ʈ
		{
			String script = getScriptCode();
			if(script.equals("")) return nextBlock; // ��ũ��Ʈ�� �����Ƿ� ���
			
			// �ڹ� ��ũ��Ʈ ������ ��´�.
			ScriptEngine scriptEngine = getParent().getScriptEngine();
			
			ClipBlockWithFrame clip = null;
			if(nextBlock instanceof ClipBlockWithFrame) // ���� ��尡 ��� Ŭ���̸�
				clip = (ClipBlockWithFrame)nextBlock;
			
			// ��ũ��Ʈ���� clip, value�� ����� �� �ְ� �Ѵ�.
			scriptEngine.put("Clip", clip);
			scriptEngine.put("clip", clip);
			// 'value'�� ���� ����� ������ �Ѵ�.
			scriptEngine.put("value", getIncomings().get(0).getSource().getVariable());
			
			try
			{
				Object obj = scriptEngine.eval(script); // ��ũ��Ʈ ����
				if(obj instanceof Double) // ������� double�� ���
					setValue(((Double)obj).intValue()); // ��ũ��Ʈ ����� ����
				else
					setValue(0);
			} catch (ScriptException e)
			{
				e.printStackTrace();
				ConsoleFactory.getInstance().println(e.getMessage());
			}
		}
		return nextBlock;
	}

	// 'value' ���� ��´�.
	@Override
	public float getVariable()
	{
		return value;
	}
} //DiceBlockImpl
