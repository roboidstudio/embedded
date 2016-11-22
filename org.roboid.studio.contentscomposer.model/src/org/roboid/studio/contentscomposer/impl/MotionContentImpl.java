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

package org.roboid.studio.contentscomposer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.roboid.core.component.activity.Activity;
import org.roboid.robot.Device;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.util.ModelMatcher;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.LogicBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.impl.MotionClipImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motion Content</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getRobot <em>Robot</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#isGrid <em>Grid</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#isMinimized <em>Minimized</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getTerminatorScriptCode <em>Terminator Script Code</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotionContentImpl extends ContentsComposerElementImpl implements MotionContent
{
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
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

	/**
	 * The default value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptEngine()
	 * @generated
	 * @ordered
	 */
	protected static final ScriptEngine SCRIPT_ENGINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptEngine()
	 * @generated
	 * @ordered
	 */
	protected ScriptEngine scriptEngine = SCRIPT_ENGINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockElement> blocks;

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
	 * The default value of the '{@link #isMinimized() <em>Minimized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMinimized() <em>Minimized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimized()
	 * @generated
	 * @ordered
	 */
	protected boolean minimized = MINIMIZED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTerminatorScriptCode() <em>Terminator Script Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminatorScriptCode()
	 * @generated
	 * @ordered
	 */
	protected static final String TERMINATOR_SCRIPT_CODE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTerminatorScriptCode() <em>Terminator Script Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminatorScriptCode()
	 * @generated
	 * @ordered
	 */
	protected String terminatorScriptCode = TERMINATOR_SCRIPT_CODE_EDEFAULT;

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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0.0";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotionContentImpl()
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
		return ContentsComposerPackage.Literals.MOTION_CONTENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__ROBOT, oldRobot, robot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity()
	{
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(Activity newActivity)
	{
		Activity oldActivity = activity;
		activity = newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptEngine getScriptEngine()
	{
		return scriptEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptEngine(ScriptEngine newScriptEngine)
	{
		ScriptEngine oldScriptEngine = scriptEngine;
		scriptEngine = newScriptEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__SCRIPT_ENGINE, oldScriptEngine, scriptEngine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<BlockElement> getBlocks()
	{
		if (blocks == null) {
			blocks = new EObjectContainmentEList<BlockElement>(BlockElement.class, this, ContentsComposerPackage.MOTION_CONTENT__BLOCKS);
		}
		return blocks;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__GRID, oldGrid, grid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMinimized()
	{
		return minimized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimized(boolean newMinimized)
	{
		boolean oldMinimized = minimized;
		minimized = newMinimized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__MINIMIZED, oldMinimized, minimized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminatorScriptCode(String newTerminatorScriptCode)
	{
		String oldTerminatorScriptCode = terminatorScriptCode;
		terminatorScriptCode = newTerminatorScriptCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__TERMINATOR_SCRIPT_CODE, oldTerminatorScriptCode, terminatorScriptCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Association> getAssociations()
	{
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this, ContentsComposerPackage.MOTION_CONTENT__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion)
	{
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.MOTION_CONTENT__VERSION, oldVersion, version));
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
			case ContentsComposerPackage.MOTION_CONTENT__BLOCKS:
				return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
			case ContentsComposerPackage.MOTION_CONTENT__ASSOCIATIONS:
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
			case ContentsComposerPackage.MOTION_CONTENT__ROBOT:
				return getRobot();
			case ContentsComposerPackage.MOTION_CONTENT__ACTIVITY:
				return getActivity();
			case ContentsComposerPackage.MOTION_CONTENT__SCRIPT_ENGINE:
				return getScriptEngine();
			case ContentsComposerPackage.MOTION_CONTENT__BLOCKS:
				return getBlocks();
			case ContentsComposerPackage.MOTION_CONTENT__GRID:
				return isGrid();
			case ContentsComposerPackage.MOTION_CONTENT__MINIMIZED:
				return isMinimized();
			case ContentsComposerPackage.MOTION_CONTENT__TERMINATOR_SCRIPT_CODE:
				return getTerminatorScriptCode();
			case ContentsComposerPackage.MOTION_CONTENT__ASSOCIATIONS:
				return getAssociations();
			case ContentsComposerPackage.MOTION_CONTENT__VERSION:
				return getVersion();
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
			case ContentsComposerPackage.MOTION_CONTENT__ROBOT:
				setRobot((Robot)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__SCRIPT_ENGINE:
				setScriptEngine((ScriptEngine)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends BlockElement>)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__GRID:
				setGrid((Boolean)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__MINIMIZED:
				setMinimized((Boolean)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__TERMINATOR_SCRIPT_CODE:
				setTerminatorScriptCode((String)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__VERSION:
				setVersion((String)newValue);
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
			case ContentsComposerPackage.MOTION_CONTENT__ROBOT:
				setRobot((Robot)null);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__ACTIVITY:
				setActivity((Activity)null);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__SCRIPT_ENGINE:
				setScriptEngine(SCRIPT_ENGINE_EDEFAULT);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__BLOCKS:
				getBlocks().clear();
				return;
			case ContentsComposerPackage.MOTION_CONTENT__GRID:
				setGrid(GRID_EDEFAULT);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__MINIMIZED:
				setMinimized(MINIMIZED_EDEFAULT);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__TERMINATOR_SCRIPT_CODE:
				setTerminatorScriptCode(TERMINATOR_SCRIPT_CODE_EDEFAULT);
				return;
			case ContentsComposerPackage.MOTION_CONTENT__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case ContentsComposerPackage.MOTION_CONTENT__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case ContentsComposerPackage.MOTION_CONTENT__ROBOT:
				return robot != null;
			case ContentsComposerPackage.MOTION_CONTENT__ACTIVITY:
				return activity != null;
			case ContentsComposerPackage.MOTION_CONTENT__SCRIPT_ENGINE:
				return SCRIPT_ENGINE_EDEFAULT == null ? scriptEngine != null : !SCRIPT_ENGINE_EDEFAULT.equals(scriptEngine);
			case ContentsComposerPackage.MOTION_CONTENT__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case ContentsComposerPackage.MOTION_CONTENT__GRID:
				return grid != GRID_EDEFAULT;
			case ContentsComposerPackage.MOTION_CONTENT__MINIMIZED:
				return minimized != MINIMIZED_EDEFAULT;
			case ContentsComposerPackage.MOTION_CONTENT__TERMINATOR_SCRIPT_CODE:
				return TERMINATOR_SCRIPT_CODE_EDEFAULT == null ? terminatorScriptCode != null : !TERMINATOR_SCRIPT_CODE_EDEFAULT.equals(terminatorScriptCode);
			case ContentsComposerPackage.MOTION_CONTENT__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case ContentsComposerPackage.MOTION_CONTENT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(" (scriptEngine: ");
		result.append(scriptEngine);
		result.append(", grid: ");
		result.append(grid);
		result.append(", minimized: ");
		result.append(minimized);
		result.append(", terminatorScriptCode: ");
		result.append(terminatorScriptCode);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_MINIMIZE = "_min";
	private static final String P_ROBOT = "_robot";
	private static final String P_VERSION = "_version";
	private List<Device> devices;
	private String[] deviceNames;
	private String[] activeDeviceNameArray;
	private final List<String> activeDeviceNameList = new ArrayList<String>();
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
		PropertyDescriptor propertyRobot = new PropertyDescriptor(P_ROBOT, "Robot");
		propertyRobot.setCategory("File Info");
		PropertyDescriptor propertyVersion = new PropertyDescriptor(P_VERSION, "Version");
		propertyVersion.setCategory("File Info");
		ComboBoxPropertyDescriptor propertyGridOn = new ComboBoxPropertyDescriptor(P_GRID, "Grid On", new String[] {"yes", "no"});
		propertyGridOn.setCategory("Attribute");
		ComboBoxPropertyDescriptor propertyMinimize = new ComboBoxPropertyDescriptor(P_MINIMIZE, "Minimize", new String[] {"yes", "no"});
		propertyMinimize.setCategory("Attribute");
		return new IPropertyDescriptor[]
		{
			propertyRobot,
			propertyVersion,
			propertyGridOn,
			propertyMinimize
		};
	}

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_ROBOT)) return getRobot() == null ? "" : getRobot().getName();
		if(id.equals(P_VERSION)) return getVersion();
		if(id.equals(P_GRID)) // 그리드 켜고 끄기
		{
			if(isGrid()) return 0;
			return 1;
		}
		if(id.equals(P_MINIMIZE)) // 화면 최소화 하기
		{
			if(isMinimized()) return 0;
			return 1;
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_ROBOT)) return true;
		if(id.equals(P_VERSION)) return true;
		if(id.equals(P_GRID)) return true;
		if(id.equals(P_MINIMIZE)) return true;
		return super.isPropertySet(id);
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_GRID)) // 그리드 켜고 끄기
		{
			if(value.equals(Integer.valueOf(0))) setGrid(true);
			else setGrid(false);
			firePropertyChange(P_GRID, null, null);
		}
		else if(id.equals(P_MINIMIZE)) // 화면 최소화 하기
		{
			if(value.equals(Integer.valueOf(0))) setMinimized(true);
			else setMinimized(false);
			firePropertyChange(P_GRID, null, null);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addChild(BlockElement node)
	{
		getBlocks().add(node);
		node.setParent(this);
		firePropertyChange(P_CHILDREN, null, null);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeChild(BlockElement node)
	{
		getBlocks().remove(node);
		firePropertyChange(P_CHILDREN, null, null);
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
	public boolean validate()
	{
		boolean valid = true;
		boolean nodeValid;
		for(BlockElement node : getBlocks())
		{
			nodeValid = node.validate(); // 각 노드의 유효성 검사
			if(!nodeValid) valid = false; // 유효하지 않다.
			node.setError(!nodeValid); // 에러를 표시한다.
			node.setPlaying(node.isPlaying()); // 현재 재생 중인 노드인지를 표시한다.
		}
		
		return valid;
	}
	
	@Override
	public Resource getResource()
	{
		return eResource();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getDeviceNames()
	{
		if(deviceNames == null)
		{
			List<String> names = new ArrayList<String>();
			names.add("'value'");
			
			// 디바이스 이름의 리스트를 추가한다.
			if(robot != null)
				robot.collectAllDeviceNames(names);
				
			// 스트링 어레이로 반환
			deviceNames = names.toArray(new String[names.size()]);
		}
		return deviceNames;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getActiveDeviceNames()
	{
		List<String> list = activeDeviceNameList;
		list.clear();
		list.add("'value'");
		
		// 디바이스 이름의 리스트를 추가한다.
		if(robot != null)
			robot.collectAllActiveDeviceNames(list);
			
		// 스트링 어레이로 반환
		String[] array = activeDeviceNameArray;
		int sz = list.size();
		if(array == null || array.length != sz)
			array = activeDeviceNameArray = new String[sz];
		for(int i = 0; i < sz; ++i)
			array[i] = list.get(i);
		return array;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDeviceName(int index)
	{
		if(index < 0 || index >= getDeviceNames().length)
			return "";
		return getDeviceNames()[index];
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<Device> getDevices()
	{
		if(devices == null)
		{
			devices = new ArrayList<Device>();
			if(robot != null)
			{
				for(Roboid roboid : robot.getRoboids())
					roboid.collectAllDevices(devices);
			}
		}
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Device getDevice(int index)
	{
		if(index < 0 || index >= getDevices().size())
			return null;
		return getDevices().get(index);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MotionClipBlock findMotionClipBlock(String name)
	{
		for(MotionClipBlock block : getMotionClipBlocks())
		{
			if(block.getName().equalsIgnoreCase(name))
				return block;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MotionContentBlock findMotionContentBlock(String name)
	{
		for(MotionContentBlock block : getMotionContentBlocks())
		{
			if(block.getName().equalsIgnoreCase(name))
				return block;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MotionContent deepCopy()
	{
		MotionContent newContent = ContentsComposerFactory.eINSTANCE.createMotionContent();
		newContent.setVersion(getVersion());
		List<BlockElement> newCloneBlocks = new ArrayList<BlockElement>();
		for(BlockElement block : getBlocks())
		{
			BlockElement newBlock = block.deepCopy(newContent);
			newContent.addChild(newBlock);
			if((block instanceof MotionClipCloneBlock) || (block instanceof MotionContentCloneBlock))
				newCloneBlocks.add(newBlock);
		}
		for(BlockElement newBlock : newCloneBlocks)
		{
			if(newBlock instanceof MotionClipCloneBlock)
			{
				MotionClipBlock original = ((MotionClipCloneBlock)newBlock).getOriginal();
				if(original != null)
					((MotionClipCloneBlock)newBlock).setOriginal(newContent.findMotionClipBlock(original.getName()));
			}
			else if(newBlock instanceof MotionContentCloneBlock)
			{
				MotionContentBlock original = ((MotionContentCloneBlock)newBlock).getOriginal();
				if(original != null)
					((MotionContentCloneBlock)newBlock).setOriginal(newContent.findMotionContentBlock(original.getName()));
			}
		}
		
		for(Association association : getAssociations())
		{
			Association newAssociation = ContentsComposerFactory.eINSTANCE.createAssociation();
			int indexSource = getBlocks().indexOf(association.getSource());
			int indexTarget = getBlocks().indexOf(association.getTarget());
			if(indexSource >= 0 && indexTarget >= 0)
			{
				BlockElement newSource = newContent.getBlocks().get(indexSource);
				newSource.addOutgoing(newAssociation);
				newAssociation.setSource(newSource);
				
				BlockElement newTarget = newContent.getBlocks().get(indexTarget);
				newTarget.addIncoming(newAssociation);
				newAssociation.setTarget(newTarget);
				
				newContent.addAssociation(newAssociation);
				newAssociation.setSourceLabel(association.getSourceLabel());
				newAssociation.setTargetLabel(association.getTargetLabel());
			}
		}
		return newContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshResource()
	{
		Resource resource = eResource();
		if(resource == null) return;
		URI uri = resource.getURI();
		refreshResource(uri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshResource(URI uri)
	{
		if(uri == null) return;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(uri);
			
			resource.getContents().add((EObject)getRobot());
			resource.getContents().add((EObject)getActivity());
			resource.getContents().add((EObject)this);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<MotionClipBlock> getMotionClipBlocks()
	{
		List<MotionClipBlock> nodes = new ArrayList<MotionClipBlock>();
		for(BlockElement node : getBlocks())
		{
			if(node instanceof MotionClipBlock)
				nodes.add((MotionClipBlock)node);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<MotionContentBlock> getMotionContentBlocks()
	{
		List<MotionContentBlock> nodes = new ArrayList<MotionContentBlock>();
		for(BlockElement node : getBlocks())
		{
			if(node instanceof MotionContentBlock)
				nodes.add((MotionContentBlock)node);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reset()
	{
		for(BlockElement node : getBlocks())
		{
			// 각 노드를 초기화
			node.reset();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScriptEngine createScriptEngine()
	{
		// 스크립트에서 robot, protocol, console을 사용할 수 있게 한다.
		scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
		scriptEngine.put("robot", robot);
		scriptEngine.put("protocol", robot.getProtocol()); // 프로토콜을 가진 첫번째 로보이드의 프로토콜을 얻는다.
		return scriptEngine;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTerminatorScriptCode()
	{
		if(terminatorScriptCode == null) terminatorScriptCode = "";
		return terminatorScriptCode;
	}
	
	private int updateReference(MotionContent diagram, Robot newRobot)
	{
		diagram.setRobot(newRobot);
		
		int retCode = INSERT_SUCCESS;
		for(BlockElement block : diagram.getBlocks())
		{
			int code = INSERT_SUCCESS;
			if(block instanceof MotionClipBlock)
			{
				MotionClip motionClip = ((MotionClipBlock)block).getMotionClip();
				if(motionClip != null) code = motionClip.updateReference(newRobot);
			}
			else if(block instanceof MotionContentBlock)
			{
				MotionContent contentsClip = ((MotionContentBlock)block).getContent();
				if(contentsClip != null) code = contentsClip.updateReference(newRobot);
			}
			
			switch(code)
			{
			case INSERT_INVALID_CLIENT_ROBOT:
			case INSERT_INVALID_REFERENCE_ROBOT:
			case INSERT_DIFFERENT_ROBOT:
				return code;
			case INSERT_PARTIAL:
				retCode = code;
				break;
			}
		}
		
		return retCode;
	}
	
	@Override
	public int updateReference(Robot newRobot)
	{
		if(newRobot == null) return INSERT_INVALID_REFERENCE_ROBOT;
		
		return updateReference(this, newRobot);
	}

	@Override
	public int adaptTo(Robot newRobot)
	{
		if(newRobot == null) return INSERT_INVALID_REFERENCE_ROBOT;
		
		Robot oldRobot = getRobot();
		if(oldRobot == null) return INSERT_INVALID_CLIENT_ROBOT;
		
		Map<String, Device> deviceVariableMap = new HashMap<String, Device>();
		Map<String, Roboid> roboidVariableMap = new HashMap<String, Roboid>();
		ModelMatcher matcher = new ModelMatcher(newRobot);
		
		return adaptTo(this, oldRobot, newRobot, matcher, deviceVariableMap, roboidVariableMap);
	}
	
	private int adaptTo(MotionContent diagram, Robot oldRobot, Robot newRobot, ModelMatcher matcher, Map<String, Device> deviceVariableMap, Map<String, Roboid> roboidVariableMap)
	{
		diagram.setRobot(newRobot);
		
		int retCode = INSERT_SUCCESS;
		for(BlockElement block : diagram.getBlocks())
		{
			int code = INSERT_SUCCESS;
			if(block instanceof MotionClipBlock)
			{
				MotionClip motionClip = ((MotionClipBlock)block).getMotionClip();
				if(motionClip != null)
				{
					motionClip.setRobot(oldRobot);
					code = ((MotionClipImpl)motionClip).adaptTo(newRobot, matcher);
				}
			}
			else if(block instanceof MotionContentBlock)
			{
				MotionContent contentsClip = ((MotionContentBlock)block).getContent();
				if(contentsClip != null) code = adaptTo(contentsClip, oldRobot, newRobot, matcher, deviceVariableMap, roboidVariableMap);
			}
			else if(block instanceof LogicBlock)
			{
				int index = ((LogicBlock)block).getDevice();
				if(index > 0)
				{
					Device oldDevice = getDevice(index-1);
					Device newDevice = matcher.findDevice(oldDevice);
					if(newDevice == null)
						code = INSERT_INVALID_LOGIC_BLOCK;
					else
					{
						List<Device> newDevices = new ArrayList<Device>();
						newRobot.collectAllDevices(newDevices);
						index = newDevices.indexOf(newDevice);
						if(index < 0) code = INSERT_INVALID_LOGIC_BLOCK;
						((LogicBlock)block).setDevice(index+1);
					}
				}
			}
			
			switch(code)
			{
			case INSERT_INVALID_CLIENT_ROBOT:
			case INSERT_INVALID_REFERENCE_ROBOT:
			case INSERT_DIFFERENT_ROBOT:
			case INSERT_INVALID_LOGIC_BLOCK:
			case INSERT_INVALID_SCRIPT:
				return code;
			case INSERT_PARTIAL:
				retCode = INSERT_PARTIAL;
				break;
			}
			
			if(block instanceof TerminatorBlock) block.setParent(diagram);
			if(adaptScript(block, oldRobot, newRobot, matcher, deviceVariableMap, roboidVariableMap) == INSERT_INVALID_SCRIPT)
				return INSERT_INVALID_SCRIPT;
		}
		
		return retCode;
	}
	
	private int adaptScript(BlockElement block, Robot oldRobot, Robot newRobot, ModelMatcher matcher, Map<String, Device> deviceVariableMap, Map<String, Roboid> roboidVariableMap)
	{
		String scriptCode = block.getScriptCode();
		if(scriptCode == null || scriptCode.isEmpty())
			return INSERT_SUCCESS;
			
		Pattern pat = Pattern.compile("\\w*\\s*=?\\s*\\w+\\s*.\\s*findRoboid\\s*\\(\\s*\".+\"|\\w*\\s*=?\\s*\\w+\\s*.\\s*findDevice\\s*\\(\\s*\".+\"");
		Matcher mat = pat.matcher(scriptCode);
		StringBuffer sbCode = new StringBuffer();
		
		while(mat.find())
		{
			String script = scriptCode.substring(mat.start(), mat.end());
			if(script.isEmpty()) continue;
			
			int index = script.indexOf('=');
			if(index > 0)
			{
				String var = script.substring(0, index).trim();
				String tmp = script.substring(index+1);
				int dot = tmp.indexOf('.');
				String src = tmp.substring(0, dot).trim();
				int p = tmp.indexOf('(');
				String op = tmp.substring(dot+1, p).trim();
				int start = tmp.indexOf("\"");
				int end = tmp.lastIndexOf("\"");
				String name = tmp.substring(start+1, end);
				
				if(op.equals("findRoboid"))
				{
					Roboid roboid = null;
					if(src.equals("robot"))
						roboid = oldRobot.findRoboid(name);
					else
					{
						Roboid parent = roboidVariableMap.get(src);
						if(parent == null) continue;
						roboid = parent.findRoboid(name);
					}
					if(roboid == null) return INSERT_INVALID_SCRIPT;
					roboidVariableMap.put(var, roboid);
					
					Roboid newRoboid = matcher.findRoboid(roboid);
					if(newRoboid == null) return INSERT_INVALID_SCRIPT;

					String[] str = name.split("\\.");
					StringBuilder sb = new StringBuilder(newRoboid.getName());
					NamedElement parent = newRoboid.getParent();
					for(int i = 0; i < str.length-1; i ++)
					{
						sb.insert(0, parent.getName() + ".");
						parent = parent.getParent();
					}
					sb.insert(0, "\"");
					script = script.replaceFirst("\"" + name, sb.toString());
					mat.appendReplacement(sbCode, script);
				}
				else
				{
					Device device = null;
					if(src.equals("robot"))
						device = oldRobot.findDevice(name);
					else
					{
						Roboid parent = roboidVariableMap.get(src);
						if(parent == null) continue;
						device = parent.findDevice(name);
					}
					if(device == null) return INSERT_INVALID_SCRIPT;
					deviceVariableMap.put(var, device);
					
					Device newDevice = matcher.findDevice(device);
					if(newDevice == null) return INSERT_INVALID_SCRIPT;

					String[] str = name.split("\\.");
					StringBuilder sb = new StringBuilder(newDevice.getName());
					NamedElement parent = newDevice.getParent();
					for(int i = 0; i < str.length-1; i ++)
					{
						sb.insert(0, parent.getName() + ".");
						parent = parent.getParent();
					}
					sb.insert(0, "\"");
					script = script.replaceFirst("\"" + name, sb.toString());
					mat.appendReplacement(sbCode, script);
				}
			}
		}
		mat.appendTail(sbCode);
		block.setScriptCode(sbCode.toString());
		
		return INSERT_SUCCESS;
	}
} //MotionContentImpl
