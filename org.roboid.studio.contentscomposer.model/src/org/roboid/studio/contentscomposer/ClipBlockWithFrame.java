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
 * A representation of the model object '<em><b>Clip Block With Frame</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStartFrame <em>Start Frame</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStopFrame <em>Stop Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getClipBlockWithFrame()
 * @model abstract="true"
 * @generated
 */
public interface ClipBlockWithFrame extends ClipBlock
{
	/**
	 * Returns the value of the '<em><b>Start Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Frame</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Frame</em>' attribute.
	 * @see #setStartFrame(int)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getClipBlockWithFrame_StartFrame()
	 * @model
	 * @generated
	 */
	int getStartFrame();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStartFrame <em>Start Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Frame</em>' attribute.
	 * @see #getStartFrame()
	 * @generated
	 */
	void setStartFrame(int value);

	/**
	 * Returns the value of the '<em><b>Stop Frame</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Frame</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Frame</em>' attribute.
	 * @see #setStopFrame(int)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getClipBlockWithFrame_StopFrame()
	 * @model default="-1"
	 * @generated
	 */
	int getStopFrame();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStopFrame <em>Stop Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Frame</em>' attribute.
	 * @see #getStopFrame()
	 * @generated
	 */
	void setStopFrame(int value);

} // ClipBlockWithFrame
