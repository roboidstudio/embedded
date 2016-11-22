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

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.robot.Command;
import org.roboid.robot.Device;
import org.roboid.robot.Event;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.LogicBlock;
import org.roboid.studio.contentscomposer.LogicType;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.studio.contentscomposer.TriggerBlock;
import org.roboid.ui.console.ConsoleFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logic Block</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl#getFrame <em>Frame</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl#getLogic <em>Logic</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl#getDevice <em>Device</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LogicBlockImpl extends BlockElementImpl implements LogicBlock
{
	/**
	 * The default value of the '{@link #getFrame() <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected static final int FRAME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFrame() <em>Frame</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrame()
	 * @generated
	 * @ordered
	 */
	protected int frame = FRAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLogic() <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogic()
	 * @generated
	 * @ordered
	 */
	protected static final LogicType LOGIC_EDEFAULT = LogicType.EQ;

	/**
	 * The cached value of the '{@link #getLogic() <em>Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogic()
	 * @generated
	 * @ordered
	 */
	protected LogicType logic = LOGIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final float VALUE_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected float value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDevice() <em>Device</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected static final int DEVICE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDevice() <em>Device</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected int device = DEVICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicBlockImpl()
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
		return ContentsComposerPackage.Literals.LOGIC_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrame()
	{
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrame(int newFrame)
	{
		int oldFrame = frame;
		frame = newFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOGIC_BLOCK__FRAME, oldFrame, frame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicType getLogic()
	{
		return logic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogic(LogicType newLogic)
	{
		LogicType oldLogic = logic;
		logic = newLogic == null ? LOGIC_EDEFAULT : newLogic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOGIC_BLOCK__LOGIC, oldLogic, logic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex)
	{
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOGIC_BLOCK__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(float newValue)
	{
		float oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOGIC_BLOCK__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDevice()
	{
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevice(int newDevice)
	{
		int oldDevice = device;
		device = newDevice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.LOGIC_BLOCK__DEVICE, oldDevice, device));
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
			case ContentsComposerPackage.LOGIC_BLOCK__FRAME:
				return getFrame();
			case ContentsComposerPackage.LOGIC_BLOCK__LOGIC:
				return getLogic();
			case ContentsComposerPackage.LOGIC_BLOCK__INDEX:
				return getIndex();
			case ContentsComposerPackage.LOGIC_BLOCK__VALUE:
				return getValue();
			case ContentsComposerPackage.LOGIC_BLOCK__DEVICE:
				return getDevice();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case ContentsComposerPackage.LOGIC_BLOCK__FRAME:
				setFrame((Integer)newValue);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__LOGIC:
				setLogic((LogicType)newValue);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__INDEX:
				setIndex((Integer)newValue);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__VALUE:
				setValue((Float)newValue);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__DEVICE:
				setDevice((Integer)newValue);
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
			case ContentsComposerPackage.LOGIC_BLOCK__FRAME:
				setFrame(FRAME_EDEFAULT);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__LOGIC:
				setLogic(LOGIC_EDEFAULT);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ContentsComposerPackage.LOGIC_BLOCK__DEVICE:
				setDevice(DEVICE_EDEFAULT);
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
			case ContentsComposerPackage.LOGIC_BLOCK__FRAME:
				return frame != FRAME_EDEFAULT;
			case ContentsComposerPackage.LOGIC_BLOCK__LOGIC:
				return logic != LOGIC_EDEFAULT;
			case ContentsComposerPackage.LOGIC_BLOCK__INDEX:
				return index != INDEX_EDEFAULT;
			case ContentsComposerPackage.LOGIC_BLOCK__VALUE:
				return value != VALUE_EDEFAULT;
			case ContentsComposerPackage.LOGIC_BLOCK__DEVICE:
				return device != DEVICE_EDEFAULT;
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
		result.append(" (frame: ");
		result.append(frame);
		result.append(", logic: ");
		result.append(logic);
		result.append(", index: ");
		result.append(index);
		result.append(", value: ");
		result.append(value);
		result.append(", device: ");
		result.append(device);
		result.append(')');
		return result.toString();
	}
	




	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	public static final String P_TYPE = "_type";
	public static final String P_NAME = "_name";
	public static final String P_DEVICE = "_device";
	public static final String P_LOCATION = "_location";
	public static final String P_LOGIC = "_logic";
	public static final String P_VALUE = "_value";
	
	@Override
	protected void copyTo(MovableElement newBlock)
	{
		super.copyTo(newBlock);
		((LogicBlock)newBlock).setDevice(getDevice());
		((LogicBlock)newBlock).setLogic(getLogic());
		((LogicBlock)newBlock).setIndex(getIndex());
		((LogicBlock)newBlock).setValue(getValue());
	}
	
	// 프로퍼티 뷰에 표시할 프로퍼티를 설정한다.
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors()
	{
//		String[] types = MotionComposer.scriptEngines;
//		if(getIncomings().size() == 0) return new IPropertyDescriptor[]{
//			new ComboBoxPropertyDescriptor(P_TYPE, "Script", types)				
//		};
	
		if(getScriptType() == ScriptType.NONE) // 스크립트가 아니다.
		{
			ComboBoxPropertyDescriptor propertyDevice = new ComboBoxPropertyDescriptor(P_DEVICE, "Device", getParent().getDeviceNames());
			propertyDevice.setCategory("Attribute");
			TextPropertyDescriptor propertyLocation = new TextPropertyDescriptor(P_LOCATION, "Location");
			propertyLocation.setCategory("Attribute");
			ComboBoxPropertyDescriptor propertyLogic = new ComboBoxPropertyDescriptor(P_LOGIC, "Logic", LogicType.toStringArray());
			propertyLogic.setCategory("Attribute");
			TextPropertyDescriptor propertyValue = new TextPropertyDescriptor(P_VALUE, "Value");
			propertyValue.setCategory("Attribute");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
			propertyScriptType.setCategory("Script");
			return new IPropertyDescriptor[] {
				propertyDevice,
				propertyLocation,						
				propertyLogic,
				propertyValue,
				propertyScriptType
			};
		}
		if(getScriptType() == ScriptType.ROBOID_SCRIPT) // 자바 스크립트
		{
			TextPropertyDescriptor propertyScriptName = new TextPropertyDescriptor(P_NAME, "Name");
			propertyScriptName.setCategory("Script");
			ComboBoxPropertyDescriptor propertyScriptType = new ComboBoxPropertyDescriptor(P_TYPE, "Type", ScriptType.toStringArray());
			propertyScriptType.setCategory("Script");
			return new IPropertyDescriptor[] {
				propertyScriptType,
				propertyScriptName
			};
		}
		return null;
	}

	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_TYPE)) return ScriptType.VALUES.indexOf(getScriptType());
		if(id.equals(P_NAME)) return getScriptName();
		if(id.equals(P_DEVICE)) return getDevice();
		if(id.equals(P_LOCATION)) return Integer.toString(index);
		if(id.equals(P_LOGIC)) return LogicType.VALUES.indexOf(logic);
		if(id.equals(P_VALUE)) return valueToString();		
		return null;
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_TYPE)) return true;
		if(id.equals(P_NAME)) return true;
		if(id.equals(P_DEVICE)) return true;
		if(id.equals(P_LOCATION)) return true;
		if(id.equals(P_LOGIC)) return true;
		if(id.equals(P_VALUE)) return true;		
		return super.isPropertySet(id);
	}

	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_TYPE)) // 스크립트 타입
			scriptType = ScriptType.get(((Integer)value).intValue());
		else if(id.equals(P_NAME)) // 스크립트 제목
			scriptName = (String)value;
		else if(id.equals(P_DEVICE))
			device = ((Integer)value).intValue();
		else if(id.equals(P_LOGIC))
			logic = LogicType.get(((Integer)value).intValue());
		else if(id.equals(P_LOCATION))
		{
			int index = 0;
			try
			{
				index = Integer.parseInt((String)value);
			} catch (Exception e)
			{
			}
			if(index < 0) index  = 0;
			setIndex(index);
		}
		else if(id.equals(P_VALUE))
		{
			try
			{
				this.value = Float.parseFloat((String)value);
			} catch(Exception e)
			{
			}
		}

		firePropertyChange(P_LABEL, null, null);
	}
	
	// 스크립트를 가질 수 있는 노드인지 묻는다.
	@Override
	public boolean canHaveScript()
	{
		return true;
	}
	
	// 스크립트 타입과 제목, 코드를 변경한다.
	@Override
	public void updateScript(String scriptName, String scriptCode)
	{
		setScriptType(ScriptType.ROBOID_SCRIPT);
		setScriptName(scriptName);
		setScriptCode(scriptCode);
		firePropertyChange(P_LABEL, null, null);
	}
	
	// 숫자값이 ".0"으로 끝나면 잘라낸다.
	private String valueToString()
	{
		String val = Float.toString(value);
		if(val.endsWith(".0")) val = val.substring(0, val.length() - 2);
		return val;
	}
	
	@Override
	public String getLabel()
	{
		if(getScriptType() == ScriptType.NONE) // 스크립트가 아닌 경우
		{
			StringBuilder sb = new StringBuilder(20);
			sb.append(getParent().getDeviceName(device));
			if(index == 0)
				return sb.append(logic.getLiteral()).append(valueToString()).toString();
			else 
				return sb.append("[").append(index).append("]").append(logic.getLiteral()).append(valueToString()).toString();
		}
		else
			return super.getLabel();
	}
	
	// 두 노드를 연결할 수 있는지 묻는다.
	@Override
	public boolean canConnect(BlockElement source, BlockElement target)
	{
		return false;
	}
	
	// 연결과 로직이 맞는지 검사한다.
	@Override
	public boolean validate()
	{
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * checks triggering condition
	 * also checks child triggering condition, if they have
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkCondition()
	{
		// 스크립트인 경우 스크립트를 체크한다.
		if(getScriptType() != ScriptType.NONE) return checkScript();
		
		// device가 'value'인 경우를 처리한다.
		double variable = getVariable();
		if(device == 0) return checkLogic(variable, value);
		
		// device에 대한 조건을 처리한다.
		Device dev = getParent().getDevice(device-1);
		if(dev == null) return false;

		// device가 Command, Event인 경우
		if((dev instanceof Event) || (dev instanceof Command))
		{
			if(!dev.e()) return false; // 이벤트가 일어나지 않았으면 false
			if(dev.getDataSize() == 0) return true; // 데이터가 없는 경우 이벤트가 일어났으면 true
		}
		// 데이터 값이 조건에 맞는지 검사한다.
		if(index >= dev.getDataSize()) return false; //error
		variable = dev.read(index);
		if(checkLogic(variable, value) == false) return false;
		
		// 다음 노드를 얻는다.
		BlockElement nextBlock = getOutgoings().get(0).getTarget();
		// 다음 노드가 트리거인 경우 연결된 모든 트리거를 검사한다.
		// 브랜치의 다음 노드는 트리거가 될 수 없으므로 걱정하지 않아도 된다.
		// 즉, 현재 노드가 트리거인 경우에만 해당된다.
		if(nextBlock instanceof TriggerBlock)
		{
			if(!((TriggerBlock)nextBlock).checkCondition()) return false;
		}
		return true;
	}

	// 'value' 값을 얻는다.
	@Override
	public float getVariable()
	{
		return getIncomings().get(0).getSource().getVariable(); // 이전 노드의 value 값
	}
	
	/**
	 * method for logic check
	 */
	// 조건문을 검사한다.
	private boolean checkLogic(double variable, double value)
	{
		switch(logic.getValue())
		{
		case LogicType.EQ_VALUE:
			return variable == value;
		case LogicType.NE_VALUE:
			return variable != value;
		case LogicType.GT_VALUE:
			return variable > value;
		case LogicType.GE_VALUE:
			return variable >= value;
		case LogicType.LT_VALUE:
			return variable < value;
		case LogicType.LE_VALUE:
			return variable <= value;
		}
		return false;
	}
	
	// 다시 재생하기 위해 내부 상태를 초기화 한다.
	@Override
	public void reset()
	{
//		oldId = -1;
		frame = 0;
		super.reset();
	}

	// 스크립트를 검사한다.
	boolean checkScript()
	{
		if(getScriptType() == ScriptType.ROBOID_SCRIPT)			//supporting java script only
		{
			String script = getScriptCode();
			if(script.equals("")) return false; // 스크립트가 없으므로 통과
			
			// 자바 스크립트 엔진을 얻는다.
			ScriptEngine scriptEngine = getParent().getScriptEngine();

			// 스크립트에서 value, frame를 사용할 수 있게 한다.
			scriptEngine.put("value", getVariable());
			scriptEngine.put("frame", frame);
			
			boolean isTriggered = false;
			try
			{
				isTriggered = (Boolean)scriptEngine.eval(script);
			} catch (ScriptException e)
			{
				e.printStackTrace();
				ConsoleFactory.getInstance().println(e.getMessage());
			}
			frame ++;
			return isTriggered;
		}
		else return false;
	}
} //LogicBlockImpl
