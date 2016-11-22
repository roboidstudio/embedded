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

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.Control;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Motion Clip</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.MotionClip#getRobot <em>Robot</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.MotionClip#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.MotionClip#getControls <em>Controls</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.MotionClip#getVersion <em>Version</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.MotionClip#getFrameLimit <em>Frame Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.timeline.TimelinePackage#getMotionClip()
 * @model superTypes="org.roboid.studio.timeline.TimelineElement org.roboid.studio.timeline.IClip"
 * @generated
 */
public interface MotionClip extends TimelineElement, IClip
{
	/**
	 * Returns the value of the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Robot</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Robot</em>' reference.
	 * @see #setRobot(Robot)
	 * @see org.roboid.studio.timeline.TimelinePackage#getMotionClip_Robot()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Robot getRobot();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.MotionClip#getRobot <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Robot</em>' reference.
	 * @see #getRobot()
	 * @generated
	 */
	void setRobot(Robot value);

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' reference.
	 * @see #setActivity(Activity)
	 * @see org.roboid.studio.timeline.TimelinePackage#getMotionClip_Activity()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.MotionClip#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Controls</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.studio.timeline.ControlTrack}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controls</em>' containment reference list.
	 * @see org.roboid.studio.timeline.TimelinePackage#getMotionClip_Controls()
	 * @model containment="true"
	 * @generated
	 */
	List<ControlTrack> getControls();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.roboid.studio.timeline.TimelinePackage#getMotionClip_Version()
	 * @model default="1.0.0"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.MotionClip#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Frame Limit</b></em>' attribute.
	 * The default value is <code>"9999"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Limit</em>' attribute.
	 * @see org.roboid.studio.timeline.TimelinePackage#getMotionClip_FrameLimit()
	 * @model default="9999" transient="true" changeable="false"
	 * @generated
	 */
	int getFrameLimit();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getTotalFrames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ControlTrack createControlTrack(Control control);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void createControlTracks(Robot robot);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MotionClip deepCopy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void refreshResource();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model uriDataType="org.roboid.studio.timeline.URI"
	 * @generated
	 */
	void refreshResource(URI uri);

	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * @generated NOT
	 */
	public static final String VERSION = "1.4.2";
	/**
	 * @generated NOT
	 */
	public static final String P_CHILDREN = "_children";
	/**
	 * @generated NOT
	 */
	public static final String P_CONSTRAINT = "_constraint";
	/**
	 * @generated NOT
	 */
	public static final int CONTROL_TRACK_TITLE_HEIGHT = 20;
	/**
	 * @generated NOT
	 */
	public static final int CHANNEL_TRACK_HEIGHT = 25;
	/**
	 * @generated NOT
	 */
	public static final int CHANNEL_TRACK_STRIP_HEIGHT = 16;
	/**
	 * @generated NOT
	 */
	public static final int CHANNEL_TRACK_HEIGHT_GAP = 5;
	/**
	 * @generated NOT
	 */
	public static final int INSERT_SUCCESS = 0;
	/**
	 * @generated NOT
	 */
	public static final int INSERT_INVALID_CLIENT_ROBOT = 1;
	/**
	 * @generated NOT
	 */
	public static final int INSERT_INVALID_REFERENCE_ROBOT = 2;
	/**
	 * @generated NOT
	 */
	public static final int INSERT_DIFFERENT_ROBOT = 4;
	/**
	 * @generated NOT
	 */
	public static final int INSERT_PARTIAL = 8;
} // MotionClip
