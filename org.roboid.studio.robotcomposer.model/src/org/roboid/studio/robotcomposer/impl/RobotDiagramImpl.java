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

package org.roboid.studio.robotcomposer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.roboid.robot.Device;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotComposerFactory;
import org.roboid.studio.robotcomposer.RobotComposerPackage;
import org.roboid.studio.robotcomposer.RobotDiagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Robot Diagram</b></em>'.
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RobotDiagramImpl#getRobot <em>Robot</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RobotDiagramImpl#isGrid <em>Grid</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RobotDiagramImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.roboid.studio.robotcomposer.impl.RobotDiagramImpl#getAssociations <em>Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RobotDiagramImpl extends RobotComposerElementImpl implements RobotDiagram {
	/**
	 * The cached value of the '{@link #getRobot() <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobot()
	 * @generated
	 * @ordered
	 */
	protected Robot robot;

	/**
	 * The default value of the '{@link #isGrid() <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GRID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGrid() <em>Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrid()
	 * @generated
	 * @ordered
	 */
	protected boolean grid = GRID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<RoboidBlock> blocks;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RobotDiagramImpl()
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
		return RobotComposerPackage.Literals.ROBOT_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGrid()
	{
		return grid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrid(boolean newGrid)
	{
		boolean oldGrid = grid;
		grid = newGrid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotComposerPackage.ROBOT_DIAGRAM__GRID, oldGrid, grid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<RoboidBlock> getBlocks()
	{
		if (blocks == null) {
			blocks = new EObjectContainmentEList<RoboidBlock>(RoboidBlock.class, this, RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS);
		}
		return blocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Association> getAssociations()
	{
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this, RobotComposerPackage.ROBOT_DIAGRAM__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot getRobot()
	{
		return robot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRobot(Robot newRobot)
	{
		Robot oldRobot = robot;
		robot = newRobot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotComposerPackage.ROBOT_DIAGRAM__ROBOT, oldRobot, robot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS:
				return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
			case RobotComposerPackage.ROBOT_DIAGRAM__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case RobotComposerPackage.ROBOT_DIAGRAM__ROBOT:
				return getRobot();
			case RobotComposerPackage.ROBOT_DIAGRAM__GRID:
				return isGrid();
			case RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS:
				return getBlocks();
			case RobotComposerPackage.ROBOT_DIAGRAM__ASSOCIATIONS:
				return getAssociations();
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
			case RobotComposerPackage.ROBOT_DIAGRAM__ROBOT:
				setRobot((Robot)newValue);
				return;
			case RobotComposerPackage.ROBOT_DIAGRAM__GRID:
				setGrid((Boolean)newValue);
				return;
			case RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends RoboidBlock>)newValue);
				return;
			case RobotComposerPackage.ROBOT_DIAGRAM__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
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
			case RobotComposerPackage.ROBOT_DIAGRAM__ROBOT:
				setRobot((Robot)null);
				return;
			case RobotComposerPackage.ROBOT_DIAGRAM__GRID:
				setGrid(GRID_EDEFAULT);
				return;
			case RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS:
				getBlocks().clear();
				return;
			case RobotComposerPackage.ROBOT_DIAGRAM__ASSOCIATIONS:
				getAssociations().clear();
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
			case RobotComposerPackage.ROBOT_DIAGRAM__ROBOT:
				return robot != null;
			case RobotComposerPackage.ROBOT_DIAGRAM__GRID:
				return grid != GRID_EDEFAULT;
			case RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case RobotComposerPackage.ROBOT_DIAGRAM__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
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
		result.append(" (grid: ");
		result.append(grid);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addChild(RoboidBlock child)
	{
		getBlocks().add(child);
		child.setDiagram(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChild(RoboidBlock child)
	{
		getBlocks().remove(child);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addAssociation(Association association)
	{
		getAssociations().add(association);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeAssociation(Association association)
	{
		getAssociations().remove(association);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RoboidBlock createRoboidBlock(Roboid roboid)
	{
		RoboidBlock newBlock = RobotComposerFactory.eINSTANCE.createRoboidBlock();
		newBlock.setRoboid(roboid);
		addChild(newBlock);
		roboidToRoboidBlockMap.put(roboid, newBlock);
		return newBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RoboidBlock getRoboidBlock(Roboid roboid)
	{
		RoboidBlock roboidBlock = findRoboidBlock(roboid);
		if(roboidBlock == null) roboidBlock = createRoboidBlock(roboid);
		return roboidBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RoboidBlock findRoboidBlock(Roboid roboid)
	{
		if(roboid == null) return null;
		
		RoboidBlock block = roboidToRoboidBlockMap.get(roboid);
		if(block == null)
		{
			for(RoboidBlock child : getBlocks())
			{
				if(roboid.equals(child.getRoboid()))
				{
					roboidToRoboidBlockMap.put(roboid, child);
					return child;
				}
			}
		}
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RoboidBlock findRoboidBlock(Device device)
	{
		if(device == null) return null;
		
		RoboidBlock block = deviceToRoboidBlockMap.get(device);
		if(block == null)
		{
			block = findRoboidBlock(device.getRootRoboid());
			if(block != null)
				deviceToRoboidBlockMap.put(device, block);
		}
		return block;
	}
	
	private Map<Roboid, RoboidBlock> roboidToRoboidBlockMap = new HashMap<Roboid, RoboidBlock>();
	private Map<Device, RoboidBlock> deviceToRoboidBlockMap = new HashMap<Device, RoboidBlock>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshRoboidBlocks()
	{
		if(getRobot() == null) return;
		
		roboidToRoboidBlockMap = new HashMap<Roboid, RoboidBlock>();
		for(Roboid roboid : getRobot().getRoboids())
			getRoboidBlock(roboid);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void connectAll()
	{
		for(RoboidBlock block : getBlocks())
			block.connectAll();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void connect(Device sourceDevice, Device targetDevice, boolean isProxy)
	{
		if(sourceDevice == null || targetDevice == null) return;
		RoboidBlock sourceBlock = findRoboidBlock(sourceDevice);
		if(sourceBlock == null) return;
		DeviceElement sourceElement = sourceBlock.getDeviceElement(sourceDevice);
		sourceElement.connectTo(targetDevice, isProxy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Object> getAllReferences(List<Object> selection)
	{
		List<Object> references = new ArrayList<Object>();
		for(Object o : selection)
		{
			if(o instanceof Roboid)
			{
				RoboidBlock block = findRoboidBlock((Roboid)o);
				if(block != null)
				{
					for(DeviceElement element : block.getDevices())
					{
						for(Association association : element.getOutgoings())
						{
							references.add(association.getTarget());
							references.add(association);
						}
						for(Association association : element.getIncomings())
						{
							DeviceElement sourceElement = (DeviceElement)association.getSource();
							if(sourceElement != null && sourceElement.getOutgoings().size() == 1 && sourceElement.getIncomings().isEmpty())
								references.add(sourceElement);
							references.add(association);
						}
						references.add(element);
					}
					references.add(block);
				}
			}
		}
		return references;
	}
} //RobotDiagramImpl
