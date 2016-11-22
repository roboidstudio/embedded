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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logic Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.LogicBlock#getFrame <em>Frame</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.LogicBlock#getLogic <em>Logic</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.LogicBlock#getIndex <em>Index</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.LogicBlock#getValue <em>Value</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.LogicBlock#getDevice <em>Device</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getLogicBlock()
 * @model abstract="true"
 * @generated
 */
public interface LogicBlock extends BlockElement
{
	/**
	 * Returns the value of the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame</em>' attribute.
	 * @see #setFrame(int)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getLogicBlock_Frame()
	 * @model transient="true"
	 * @generated
	 */
	int getFrame();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.LogicBlock#getFrame <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame</em>' attribute.
	 * @see #getFrame()
	 * @generated
	 */
	void setFrame(int value);

	/**
	 * Returns the value of the '<em><b>Logic</b></em>' attribute.
	 * The literals are from the enumeration {@link org.roboid.studio.contentscomposer.LogicType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logic</em>' attribute.
	 * @see org.roboid.studio.contentscomposer.LogicType
	 * @see #setLogic(LogicType)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getLogicBlock_Logic()
	 * @model
	 * @generated
	 */
	LogicType getLogic();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.LogicBlock#getLogic <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logic</em>' attribute.
	 * @see org.roboid.studio.contentscomposer.LogicType
	 * @see #getLogic()
	 * @generated
	 */
	void setLogic(LogicType value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getLogicBlock_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.LogicBlock#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getLogicBlock_Value()
	 * @model default="1"
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.LogicBlock#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

	/**
	 * Returns the value of the '<em><b>Device</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' attribute.
	 * @see #setDevice(int)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getLogicBlock_Device()
	 * @model
	 * @generated
	 */
	int getDevice();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.LogicBlock#getDevice <em>Device</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' attribute.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean checkCondition();

} // LogicBlock
