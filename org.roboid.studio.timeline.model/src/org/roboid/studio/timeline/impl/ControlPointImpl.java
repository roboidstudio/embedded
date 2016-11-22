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

package org.roboid.studio.timeline.impl;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Point</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.ControlPointImpl#getFrame <em>Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ControlPointImpl extends MovableElementImpl implements ControlPoint
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlPointImpl()
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
		return TimelinePackage.Literals.CONTROL_POINT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.CONTROL_POINT__FRAME, oldFrame, frame));
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
			case TimelinePackage.CONTROL_POINT__FRAME:
				return getFrame();
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
			case TimelinePackage.CONTROL_POINT__FRAME:
				setFrame((Integer)newValue);
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
			case TimelinePackage.CONTROL_POINT__FRAME:
				setFrame(FRAME_EDEFAULT);
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
			case TimelinePackage.CONTROL_POINT__FRAME:
				return frame != FRAME_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}





	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	static final String P_FRAME = "_frame"; // 제어점의 프레임
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract ControlPoint deepCopy();
	
	void copyTo(ControlPoint newPoint)
	{
		newPoint.setConstraint(getConstraint().getCopy());
	}
	
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		propertyDescriptors.add(new TextPropertyDescriptor(P_FRAME, "Frame")
		{
			private CellEditor editor;
			
			@Override
			public CellEditor createPropertyEditor(final Composite parent)
			{
				editor = new TextCellEditor(parent)
				{
					@Override
					public void addListener(ICellEditorListener listener)
					{
						super.addListener(new ICellEditorListener()
						{
							@Override
							public void applyEditorValue()
							{
								IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
								if(part instanceof PropertySheet)
								{
									IPage page = ((PropertySheet)part).getCurrentPage();
									if(page instanceof PropertySheetPage)
										((PropertySheetPage)page).refresh();
								}
							}

							@Override
							public void cancelEditor()
							{
							}

							@Override
							public void editorValueChanged(boolean oldValidState, boolean newValidState)
							{
							}
						});
					}
				};
				
		        if(getValidator() != null)
		        {
					editor.setValidator(getValidator());
				}
		        return editor;
			}
		});
	}
	
	// 프로퍼티의 값을 얻는다.
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_FRAME)) return Integer.toString(getFrame());
		return null;
	}
	
	// 프로퍼티의 값이 기본 값과 다르게 되었는지 묻는다.
	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_FRAME)) return true;
		return false;
	}
	
	// 프로퍼티의 값을 설정한다.
	@Override
	public void setPropertyValue(Object id, Object value)
	{		
		if(id.equals(P_FRAME))
		{
			try
			{
				String v = (String)value;
				Rectangle constraint = getConstraint();
				if(v.startsWith("+"))
					constraint.x += Integer.parseInt(v.substring(1));
				else if(v.startsWith("-"))
					constraint.x -= Integer.parseInt(v.substring(1));
				else
					constraint.x = Integer.parseInt((String)value);
				int frameLimit = getParent().getParent().getParent().getFrameLimit();
				if(constraint.x < 0) constraint.x = 0;
				else if(constraint.x > frameLimit) constraint.x = frameLimit;

				setConstraint(constraint);
				getParent().reorder(this);
			}
			catch(Exception e)
			{}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void performConstraintChange()
	{
		firePropertyChange(P_CONSTRAINT, null, constraint);
	}

	@Override
	public ChannelTrack getParent()
	{
		return (ChannelTrack)super.getParent();
	}

	@Override
	public void setConstraint(Rectangle newConstraint)
	{
		setFrame(newConstraint.x);
		super.setConstraint(newConstraint);
	}
} //ControlPointImpl
