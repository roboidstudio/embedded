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
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.studio.contentscomposer.WaitClipBlock;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wait Clip Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.WaitClipBlockImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WaitClipBlockImpl extends ClipBlockWithFrameImpl implements WaitClipBlock
{
	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final float TIMEOUT_EDEFAULT = -1.0F;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected float timeout = TIMEOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WaitClipBlockImpl()
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
		return ContentsComposerPackage.Literals.WAIT_CLIP_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTimeout()
	{
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(float newTimeout)
	{
		float oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.WAIT_CLIP_BLOCK__TIMEOUT, oldTimeout, timeout));
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
			case ContentsComposerPackage.WAIT_CLIP_BLOCK__TIMEOUT:
				return getTimeout();
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
			case ContentsComposerPackage.WAIT_CLIP_BLOCK__TIMEOUT:
				setTimeout((Float)newValue);
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
			case ContentsComposerPackage.WAIT_CLIP_BLOCK__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
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
			case ContentsComposerPackage.WAIT_CLIP_BLOCK__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
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
		result.append(" (timeout: ");
		result.append(timeout);
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
	public static final String P_TIMEOUT = "_timeout";

	@Override
	public WaitClipBlock deepCopy(MotionContent newParent)
	{
		WaitClipBlock newBlock = ContentsComposerFactory.eINSTANCE.createWaitClipBlock();
		newBlock.setParent(newParent);
		copyTo(newBlock);
		return newBlock;
	}

	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((WaitClipBlock)newBlock).setTimeout(getTimeout());
	}
	
	// ������Ƽ �信 ǥ���� ������Ƽ�� �����Ѵ�.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		if(getScriptType() == ScriptType.NONE) // ��ũ��Ʈ�� �ƴϴ�.
		{
			TextPropertyDescriptor propertyTimeOut = new TextPropertyDescriptor(P_TIMEOUT, "Time Out");
			propertyTimeOut.setCategory("Attribute");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
			propertyScriptType.setCategory("Script");
			return new IPropertyDescriptor[]
			{
				propertyTimeOut,
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
		if(id.equals(P_TYPE)) return ScriptType.VALUES.indexOf(getScriptType());
		if(id.equals(P_NAME)) return getScriptName();
		if(id.equals(P_TIMEOUT)) return timeoutToString();
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_NAME)) return true;
		if(id.equals(P_TIMEOUT)) return true;
		return super.isPropertySet(id);
	}

	// ������Ƽ�� ���� �����Ѵ�.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // ��ũ��Ʈ Ÿ��
		{
			setScriptType(ScriptType.get(((Integer)value).intValue()));
			firePropertyChange(P_REDRAW, null, null);
		}
		else if(id.equals(P_NAME)) // ��ũ��Ʈ ����
		{
			scriptName = (String)value;
			firePropertyChange(P_LABEL, null, null);
		}
		//�Ҽ��� ���ڸ�
		else if(id.equals(P_TIMEOUT))
		{
			try
			{
				timeout = Float.parseFloat((String)value);
				timeout = (float)Math.rint(timeout * 10) / 10;
			} catch(Exception e)
			{
			}
			if(timeout < 0) timeout = -1;
			firePropertyChange(P_REDRAW, null, null);
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
		firePropertyChange(P_REDRAW, null, null);
	}
	
	// ���ڰ��� ".0"���� ������ �߶󳽴�.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String timeoutToString()
	{
		String val = Float.toString(timeout);
		if(val.endsWith(".0")) val = val.substring(0, val.length() - 2);
		return val;
	}
	
	@Override
	public String getLabel()
	{
//		if(getScriptType() == ScriptType.NONE)
//			return timeoutToString();
		return super.getLabel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkTimeout(int frame)
	{
		if(getScriptType() == ScriptType.NONE) // ��ũ��Ʈ�� �ƴ� ���
		{
			if(timeout < 0) return false; // ���� ��ٸ��� ���
			return (frame > getStopFrame());
		}
		else if(getScriptType() == ScriptType.ROBOID_SCRIPT) // �ڹ� ��ũ��Ʈ�� ���
		{
			String script = getScriptCode();
			if(script.equals("")) return true; // ��ũ��Ʈ�� �����Ƿ� ���
			
			// �ڹ� ��ũ��Ʈ ������ ��´�.
			ScriptEngine scriptEngine = getParent().getScriptEngine();
			
			// ��ũ��Ʈ���� value, frame�� ����� �� �ְ� �Ѵ�.
			scriptEngine.put("value", getVariable());
			scriptEngine.put("frame", frame);
			
			boolean isTrue = true;
			try
			{
				isTrue = (Boolean)scriptEngine.eval(getScriptCode());
			} catch (ScriptException e)
			{
				e.printStackTrace();
				ConsoleFactory.getInstance().println(e.getMessage());
			}
			return isTrue;
		}
		return true;
	}

	@Override
	public int getStartFrame()
	{
		return 0;
	}

	@Override
	public int getStopFrame()
	{
		return (int)(getTimeout() * 50);
	}

	@Override
	public void setStartFrame(int newStartFrame)
	{
	}

	@Override
	public void setStopFrame(int newStopFrame)
	{
		setTimeout((float)newStopFrame / 50);
	}
} //WaitClipBlockImpl
