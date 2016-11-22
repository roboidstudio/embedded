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

package org.roboid.studio.contentscomposer;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Element</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#isError <em>Error</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#isPlaying <em>Playing</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getScriptName <em>Script Name</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getScriptCode <em>Script Code</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getNextBlock <em>Next Block</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.BlockElement#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement()
 * @model abstract="true"
 * @generated
 */
public interface BlockElement extends MovableElement
{
	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute.
	 * @see #setError(boolean)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_Error()
	 * @model transient="true"
	 * @generated
	 */
	boolean isError();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.BlockElement#isError <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' attribute.
	 * @see #isError()
	 * @generated
	 */
	void setError(boolean value);

	/**
	 * Returns the value of the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Playing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Playing</em>' attribute.
	 * @see #setPlaying(boolean)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_Playing()
	 * @model transient="true"
	 * @generated
	 */
	boolean isPlaying();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.BlockElement#isPlaying <em>Playing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Playing</em>' attribute.
	 * @see #isPlaying()
	 * @generated
	 */
	void setPlaying(boolean value);

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link org.roboid.studio.contentscomposer.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_Incomings()
	 * @model resolveProxies="false"
	 * @generated
	 */
	List<Association> getIncomings();

	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link org.roboid.studio.contentscomposer.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_Outgoings()
	 * @model resolveProxies="false"
	 * @generated
	 */
	List<Association> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Script Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.roboid.studio.contentscomposer.ScriptType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Type</em>' attribute.
	 * @see org.roboid.studio.contentscomposer.ScriptType
	 * @see #setScriptType(ScriptType)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_ScriptType()
	 * @model
	 * @generated
	 */
	ScriptType getScriptType();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.BlockElement#getScriptType <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Type</em>' attribute.
	 * @see org.roboid.studio.contentscomposer.ScriptType
	 * @see #getScriptType()
	 * @generated
	 */
	void setScriptType(ScriptType value);

	/**
	 * Returns the value of the '<em><b>Script Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Name</em>' attribute.
	 * @see #setScriptName(String)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_ScriptName()
	 * @model default=""
	 * @generated
	 */
	String getScriptName();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.BlockElement#getScriptName <em>Script Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Name</em>' attribute.
	 * @see #getScriptName()
	 * @generated
	 */
	void setScriptName(String value);

	/**
	 * Returns the value of the '<em><b>Script Code</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Code</em>' attribute.
	 * @see #setScriptCode(String)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_ScriptCode()
	 * @model default=""
	 * @generated
	 */
	String getScriptCode();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.BlockElement#getScriptCode <em>Script Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Code</em>' attribute.
	 * @see #getScriptCode()
	 * @generated
	 */
	void setScriptCode(String value);

	/**
	 * Returns the value of the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Block</em>' reference.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_NextBlock()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	BlockElement getNextBlock();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canHaveScript();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void updateScript(String scriptName, String scriptCode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getLabel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canDelete();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canCopy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canCut();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addIncoming(Association association);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addOutgoing(Association association);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeIncoming(Association association);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeOutgoing(Association association);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	float getVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reset();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canReconnect(BlockElement newSource, BlockElement newTarget, BlockElement oldBlock);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(MotionContent)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getBlockElement_Parent()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	MotionContent getParent();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.BlockElement#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(MotionContent value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canConnect(BlockElement source, BlockElement target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	BlockElement deepCopy(MotionContent newParent);

	/**
	 * @generated NOT
	 */
	public static final String P_REDRAW = "_redraw";
	/**
	 * @generated NOT
	 */
	public static final String P_INCOMING = "_incoming";
	/**
	 * @generated NOT
	 */
	public static final String P_OUTGOING = "_outgoing";
	/**
	 * @generated NOT
	 */
	public static final String P_LABEL = "_label";
} // BlockElement
