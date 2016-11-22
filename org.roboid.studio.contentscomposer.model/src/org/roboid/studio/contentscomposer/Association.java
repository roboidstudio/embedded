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
 * A representation of the model object '<em><b>Association</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.Association#getSource <em>Source</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.Association#getTarget <em>Target</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.Association#getSourceLabel <em>Source Label</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.Association#getTargetLabel <em>Target Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends ContentsComposerElement
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(BlockElement)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getAssociation_Source()
	 * @model resolveProxies="false"
	 * @generated
	 */
	BlockElement getSource();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(BlockElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(BlockElement)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getAssociation_Target()
	 * @model resolveProxies="false"
	 * @generated
	 */
	BlockElement getTarget();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(BlockElement value);

	/**
	 * Returns the value of the '<em><b>Source Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Label</em>' attribute.
	 * @see #setSourceLabel(String)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getAssociation_SourceLabel()
	 * @model default=""
	 * @generated
	 */
	String getSourceLabel();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.Association#getSourceLabel <em>Source Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Label</em>' attribute.
	 * @see #getSourceLabel()
	 * @generated
	 */
	void setSourceLabel(String value);

	/**
	 * Returns the value of the '<em><b>Target Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Label</em>' attribute.
	 * @see #setTargetLabel(String)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getAssociation_TargetLabel()
	 * @model default=""
	 * @generated
	 */
	String getTargetLabel();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.Association#getTargetLabel <em>Target Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Label</em>' attribute.
	 * @see #getTargetLabel()
	 * @generated
	 */
	void setTargetLabel(String value);

	/**
	 * @generated NOT
	 */
	public static final String P_SOURCE = "_source";
	/**
	 * @generated NOT
	 */
	public static final String P_TARGET = "_target";
} // Association
