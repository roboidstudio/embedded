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

package org.roboid.studio.robotcomposer;

import java.util.List;

import org.roboid.robot.Device;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Robot Diagram</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.robotcomposer.RobotDiagram#getRobot <em>Robot</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.RobotDiagram#isGrid <em>Grid</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.RobotDiagram#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.RobotDiagram#getAssociations <em>Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRobotDiagram()
 * @model
 * @generated
 */
public interface RobotDiagram extends RobotComposerElement
{
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
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRobotDiagram_Grid()
	 * @model
	 * @generated
	 */
	boolean isGrid();

	/**
	 * Sets the value of the '{@link org.roboid.studio.robotcomposer.RobotDiagram#isGrid <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grid</em>' attribute.
	 * @see #isGrid()
	 * @generated
	 */
	void setGrid(boolean value);

	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.studio.robotcomposer.RoboidBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' containment reference list.
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRobotDiagram_Blocks()
	 * @model containment="true"
	 * @generated
	 */
	List<RoboidBlock> getBlocks();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.roboid.studio.robotcomposer.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRobotDiagram_Associations()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	List<Association> getAssociations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addChild(RoboidBlock child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeChild(RoboidBlock child);

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
	 * @see org.roboid.studio.robotcomposer.RobotComposerPackage#getRobotDiagram_Robot()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	Robot getRobot();

	/**
	 * Sets the value of the '{@link org.roboid.studio.robotcomposer.RobotDiagram#getRobot <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Robot</em>' reference.
	 * @see #getRobot()
	 * @generated
	 */
	void setRobot(Robot value);

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
	RoboidBlock createRoboidBlock(Roboid roboid);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RoboidBlock getRoboidBlock(Roboid roboid);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RoboidBlock findRoboidBlock(Roboid roboid);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RoboidBlock findRoboidBlock(Device device);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void refreshRoboidBlocks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void connectAll();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void connect(Device sourceDevice, Device targetDevice, boolean isProxy);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model selectionMany="true"
	 * @generated
	 */
	List<Object> getAllReferences(List<Object> selection);
} // RobotDiagram
