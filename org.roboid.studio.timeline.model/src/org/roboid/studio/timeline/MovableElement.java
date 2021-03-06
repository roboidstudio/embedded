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

package org.roboid.studio.timeline;

import org.eclipse.draw2d.geometry.Rectangle;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Movable Element</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.MovableElement#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.MovableElement#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.timeline.TimelinePackage#getMovableElement()
 * @model abstract="true"
 * @generated
 */
public interface MovableElement extends TimelineElement
{
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(Rectangle)
	 * @see org.roboid.studio.timeline.TimelinePackage#getMovableElement_Constraint()
	 * @model dataType="org.roboid.studio.timeline.Rectangle" transient="true"
	 * @generated
	 */
	Rectangle getConstraint();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.MovableElement#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Rectangle value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(TimelineElement)
	 * @see org.roboid.studio.timeline.TimelinePackage#getMovableElement_Parent()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	TimelineElement getParent();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.MovableElement#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TimelineElement value);

} // MovableElement
