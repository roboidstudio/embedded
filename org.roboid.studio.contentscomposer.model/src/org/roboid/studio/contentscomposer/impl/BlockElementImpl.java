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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.ScriptType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Element</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#isError <em>Error</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#isPlaying <em>Playing</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getScriptName <em>Script Name</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getScriptCode <em>Script Code</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getNextBlock <em>Next Block</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BlockElementImpl extends MovableElementImpl implements BlockElement
{
	/**
	 * The default value of the '{@link #isError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isError()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ERROR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isError()
	 * @generated
	 * @ordered
	 */
	protected boolean error = ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #isPlaying() <em>Playing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPlaying()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PLAYING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPlaying() <em>Playing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPlaying()
	 * @generated
	 * @ordered
	 */
	protected boolean playing = PLAYING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> incomings;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> outgoings;

	/**
	 * The default value of the '{@link #getScriptType() <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected static final ScriptType SCRIPT_TYPE_EDEFAULT = ScriptType.NONE;

	/**
	 * The cached value of the '{@link #getScriptType() <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptType()
	 * @generated
	 * @ordered
	 */
	protected ScriptType scriptType = SCRIPT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScriptName() <em>Script Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptName()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getScriptName() <em>Script Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptName()
	 * @generated
	 * @ordered
	 */
	protected String scriptName = SCRIPT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getScriptCode() <em>Script Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_CODE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getScriptCode() <em>Script Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptCode()
	 * @generated
	 * @ordered
	 */
	protected String scriptCode = SCRIPT_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected MotionContent parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockElementImpl()
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
		return ContentsComposerPackage.Literals.BLOCK_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isError()
	{
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPlaying()
	{
		return playing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Association> getIncomings()
	{
		if (incomings == null) {
			incomings = new EObjectEList<Association>(Association.class, this, ContentsComposerPackage.BLOCK_ELEMENT__INCOMINGS);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Association> getOutgoings()
	{
		if (outgoings == null) {
			outgoings = new EObjectEList<Association>(Association.class, this, ContentsComposerPackage.BLOCK_ELEMENT__OUTGOINGS);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType getScriptType()
	{
		return scriptType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptType(ScriptType newScriptType)
	{
		ScriptType oldScriptType = scriptType;
		scriptType = newScriptType == null ? SCRIPT_TYPE_EDEFAULT : newScriptType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_TYPE, oldScriptType, scriptType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptName(String newScriptName)
	{
		String oldScriptName = scriptName;
		scriptName = newScriptName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_NAME, oldScriptName, scriptName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptCode(String newScriptCode)
	{
		String oldScriptCode = scriptCode;
		scriptCode = newScriptCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_CODE, oldScriptCode, scriptCode));
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
			case ContentsComposerPackage.BLOCK_ELEMENT__ERROR:
				return isError();
			case ContentsComposerPackage.BLOCK_ELEMENT__PLAYING:
				return isPlaying();
			case ContentsComposerPackage.BLOCK_ELEMENT__INCOMINGS:
				return getIncomings();
			case ContentsComposerPackage.BLOCK_ELEMENT__OUTGOINGS:
				return getOutgoings();
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_TYPE:
				return getScriptType();
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_NAME:
				return getScriptName();
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_CODE:
				return getScriptCode();
			case ContentsComposerPackage.BLOCK_ELEMENT__NEXT_BLOCK:
				return getNextBlock();
			case ContentsComposerPackage.BLOCK_ELEMENT__PARENT:
				return getParent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case ContentsComposerPackage.BLOCK_ELEMENT__ERROR:
				setError((Boolean)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__PLAYING:
				setPlaying((Boolean)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends Association>)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends Association>)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_TYPE:
				setScriptType((ScriptType)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_NAME:
				setScriptName((String)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_CODE:
				setScriptCode((String)newValue);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__PARENT:
				setParent((MotionContent)newValue);
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
			case ContentsComposerPackage.BLOCK_ELEMENT__ERROR:
				setError(ERROR_EDEFAULT);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__PLAYING:
				setPlaying(PLAYING_EDEFAULT);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__INCOMINGS:
				getIncomings().clear();
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__OUTGOINGS:
				getOutgoings().clear();
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_TYPE:
				setScriptType(SCRIPT_TYPE_EDEFAULT);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_NAME:
				setScriptName(SCRIPT_NAME_EDEFAULT);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_CODE:
				setScriptCode(SCRIPT_CODE_EDEFAULT);
				return;
			case ContentsComposerPackage.BLOCK_ELEMENT__PARENT:
				setParent((MotionContent)null);
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
			case ContentsComposerPackage.BLOCK_ELEMENT__ERROR:
				return error != ERROR_EDEFAULT;
			case ContentsComposerPackage.BLOCK_ELEMENT__PLAYING:
				return playing != PLAYING_EDEFAULT;
			case ContentsComposerPackage.BLOCK_ELEMENT__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case ContentsComposerPackage.BLOCK_ELEMENT__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_TYPE:
				return scriptType != SCRIPT_TYPE_EDEFAULT;
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_NAME:
				return SCRIPT_NAME_EDEFAULT == null ? scriptName != null : !SCRIPT_NAME_EDEFAULT.equals(scriptName);
			case ContentsComposerPackage.BLOCK_ELEMENT__SCRIPT_CODE:
				return SCRIPT_CODE_EDEFAULT == null ? scriptCode != null : !SCRIPT_CODE_EDEFAULT.equals(scriptCode);
			case ContentsComposerPackage.BLOCK_ELEMENT__NEXT_BLOCK:
				return getNextBlock() != null;
			case ContentsComposerPackage.BLOCK_ELEMENT__PARENT:
				return parent != null;
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
		result.append(" (error: ");
		result.append(error);
		result.append(", playing: ");
		result.append(playing);
		result.append(", scriptType: ");
		result.append(scriptType);
		result.append(", scriptName: ");
		result.append(scriptName);
		result.append(", scriptCode: ");
		result.append(scriptCode);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((BlockElement)newBlock).setScriptType(getScriptType());
		((BlockElement)newBlock).setScriptName(getScriptName());
		((BlockElement)newBlock).setScriptCode(getScriptCode());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionContent getParent()
	{
		return parent;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(MotionContent newParent)
	{
		MotionContent oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.BLOCK_ELEMENT__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getScriptName()
	{
		if(scriptName == null) scriptName = "";
		return scriptName;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getScriptCode()
	{
		if(scriptCode == null) scriptCode = "";
		return scriptCode;
	}
	
	// 스크립트를 가질 수 있는 노드인지 묻는다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canHaveScript()
	{
		return false;
	}
	
	// 스크립트 타입과 제목, 코드를 변경한다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateScript(String scriptName, String scriptCode)
	{
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel()
	{
		if(scriptType == ScriptType.NONE)
			return "";
		else
			return getScriptName() + ".rs";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canDelete()
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCopy()
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCut()
	{
		return true;
	}
	
	// 에러가 있는지를 설정한다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setError(boolean newError)
	{
		boolean oldError = error;
		error = newError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.BLOCK_ELEMENT__ERROR, oldError, error));
		firePropertyChange(P_REDRAW, null, null);
	}
	
	// 재생 중인 노드인지를 설정한다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPlaying(boolean newPlaying)
	{
		boolean oldPlaying = playing;
		playing = newPlaying;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.BLOCK_ELEMENT__PLAYING, oldPlaying, playing));
		firePropertyChange(P_REDRAW, null, null);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addIncoming(Association association)
	{
		getIncomings().add(association);
		firePropertyChange(P_INCOMING, null, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addOutgoing(Association association)
	{
		getOutgoings().add(association);
		firePropertyChange(P_OUTGOING, null, null);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeIncoming(Association association)
	{
		getIncomings().remove(association);
		firePropertyChange(P_INCOMING, null, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeOutgoing(Association association)
	{
		getOutgoings().remove(association);
		firePropertyChange(P_OUTGOING, null, null);
	}
	
	// 'value' 값을 얻는다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public float getVariable()
	{
		return 0.0f;
	}
	
	// 다시 재생하기 위해 내부 상태를 초기화한다. 몇몇 BlockElement는 이 메소드를 다시 구현하여야 한다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reset()
	{
		error = false;
		playing = false;
	}
	
	// 재연결 시 두 노드를 연결할 수 있는지 묻는다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canReconnect(BlockElement newSource, BlockElement newTarget, BlockElement oldBlock)
	{
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract BlockElement deepCopy(MotionContent newParent);
	
	// 연결과 로직이 맞는지 검사한다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean validate();
	
	// 두 노드를 연결할 수 있는지 묻는다.
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean canConnect(BlockElement source, BlockElement target);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract BlockElement getNextBlock();
} //BlockElementImpl
