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

import javax.script.ScriptEngine;

import org.eclipse.emf.common.util.URI;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.Device;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Motion Content</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getRobot <em>Robot</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#isGrid <em>Grid</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#isMinimized <em>Minimized</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getTerminatorScriptCode <em>Terminator Script Code</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.MotionContent#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent()
 * @model superTypes="org.roboid.studio.contentscomposer.ContentsComposerElement org.roboid.studio.contentscomposer.IClip"
 * @generated
 */
public interface MotionContent extends ContentsComposerElement, IClip
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
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Robot()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Robot getRobot();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#getRobot <em>Robot</em>}' reference.
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
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Activity()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Script Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Engine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Engine</em>' attribute.
	 * @see #setScriptEngine(ScriptEngine)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_ScriptEngine()
	 * @model dataType="org.roboid.studio.contentscomposer.ScriptEngine" transient="true"
	 * @generated
	 */
	ScriptEngine getScriptEngine();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#getScriptEngine <em>Script Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Engine</em>' attribute.
	 * @see #getScriptEngine()
	 * @generated
	 */
	void setScriptEngine(ScriptEngine value);

	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.studio.contentscomposer.BlockElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' containment reference list.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Blocks()
	 * @model containment="true"
	 * @generated
	 */
	List<BlockElement> getBlocks();

	/**
	 * Returns the value of the '<em><b>Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grid</em>' attribute.
	 * @see #setGrid(boolean)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Grid()
	 * @model
	 * @generated
	 */
	boolean isGrid();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#isGrid <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid</em>' attribute.
	 * @see #isGrid()
	 * @generated
	 */
	void setGrid(boolean value);

	/**
	 * Returns the value of the '<em><b>Minimized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimized</em>' attribute.
	 * @see #setMinimized(boolean)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Minimized()
	 * @model
	 * @generated
	 */
	boolean isMinimized();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#isMinimized <em>Minimized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimized</em>' attribute.
	 * @see #isMinimized()
	 * @generated
	 */
	void setMinimized(boolean value);

	/**
	 * Returns the value of the '<em><b>Terminator Script Code</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminator Script Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminator Script Code</em>' attribute.
	 * @see #setTerminatorScriptCode(String)
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_TerminatorScriptCode()
	 * @model default=""
	 * @generated
	 */
	String getTerminatorScriptCode();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#getTerminatorScriptCode <em>Terminator Script Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminator Script Code</em>' attribute.
	 * @see #getTerminatorScriptCode()
	 * @generated
	 */
	void setTerminatorScriptCode(String value);

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.studio.contentscomposer.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Associations()
	 * @model containment="true"
	 * @generated
	 */
	List<Association> getAssociations();

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
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#getMotionContent_Version()
	 * @model default="1.0.0"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.roboid.studio.contentscomposer.MotionContent#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addChild(BlockElement child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeChild(BlockElement child);

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
	 * @model kind="operation" dataType="org.roboid.studio.contentscomposer.StringArray"
	 * @generated
	 */
	String[] getDeviceNames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.roboid.studio.contentscomposer.StringArray"
	 * @generated
	 */
	String[] getActiveDeviceNames();

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
	 * @model dataType="org.roboid.studio.contentscomposer.ScriptEngine"
	 * @generated
	 */
	ScriptEngine createScriptEngine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<Device> getDevices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<MotionClipBlock> getMotionClipBlocks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<MotionContentBlock> getMotionContentBlocks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addAssociation(Association association);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeAssociation(Association association);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getDeviceName(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Device getDevice(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MotionClipBlock findMotionClipBlock(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MotionContentBlock findMotionContentBlock(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MotionContent deepCopy();

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
	public static final String P_GRID = "_grid";
	/**
	 * @generated NOT
	 */
	public static final int GRID = 12;
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
	/**
	 * @generated NOT
	 */
	public static final int INSERT_INVALID_LOGIC_BLOCK = 16;
	/**
	 * @generated NOT
	 */
	public static final int INSERT_INVALID_SCRIPT = 32;
} // MotionContent
