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

import org.roboid.robot.ColorMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Track</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.ColorTrack#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.timeline.TimelinePackage#getColorTrack()
 * @model
 * @generated
 */
public interface ColorTrack extends ChannelTrack
{
	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.roboid.robot.ColorMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.roboid.robot.ColorMode
	 * @see #setMode(ColorMode)
	 * @see org.roboid.studio.timeline.TimelinePackage#getColorTrack_Mode()
	 * @model transient="true"
	 * @generated
	 */
	ColorMode getMode();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.ColorTrack#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.roboid.robot.ColorMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(ColorMode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setMode(int newMode);

} // ColorTrack
