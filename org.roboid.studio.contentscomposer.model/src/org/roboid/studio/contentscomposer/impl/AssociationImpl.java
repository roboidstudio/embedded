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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.AssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.AssociationImpl#getSourceLabel <em>Source Label</em>}</li>
 *   <li>{@link org.roboid.studio.contentscomposer.impl.AssociationImpl#getTargetLabel <em>Target Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends ContentsComposerElementImpl implements Association
{
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected BlockElement source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected BlockElement target;

	/**
	 * The default value of the '{@link #getSourceLabel() <em>Source Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSourceLabel() <em>Source Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLabel()
	 * @generated
	 * @ordered
	 */
	protected String sourceLabel = SOURCE_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetLabel() <em>Target Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTargetLabel() <em>Target Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLabel()
	 * @generated
	 * @ordered
	 */
	protected String targetLabel = TARGET_LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl()
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
		return ContentsComposerPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockElement getSource()
	{
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockElement getTarget()
	{
		return target;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceLabel()
	{
		return sourceLabel;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetLabel()
	{
		return targetLabel;
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
			case ContentsComposerPackage.ASSOCIATION__SOURCE:
				return getSource();
			case ContentsComposerPackage.ASSOCIATION__TARGET:
				return getTarget();
			case ContentsComposerPackage.ASSOCIATION__SOURCE_LABEL:
				return getSourceLabel();
			case ContentsComposerPackage.ASSOCIATION__TARGET_LABEL:
				return getTargetLabel();
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
			case ContentsComposerPackage.ASSOCIATION__SOURCE:
				setSource((BlockElement)newValue);
				return;
			case ContentsComposerPackage.ASSOCIATION__TARGET:
				setTarget((BlockElement)newValue);
				return;
			case ContentsComposerPackage.ASSOCIATION__SOURCE_LABEL:
				setSourceLabel((String)newValue);
				return;
			case ContentsComposerPackage.ASSOCIATION__TARGET_LABEL:
				setTargetLabel((String)newValue);
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
			case ContentsComposerPackage.ASSOCIATION__SOURCE:
				setSource((BlockElement)null);
				return;
			case ContentsComposerPackage.ASSOCIATION__TARGET:
				setTarget((BlockElement)null);
				return;
			case ContentsComposerPackage.ASSOCIATION__SOURCE_LABEL:
				setSourceLabel(SOURCE_LABEL_EDEFAULT);
				return;
			case ContentsComposerPackage.ASSOCIATION__TARGET_LABEL:
				setTargetLabel(TARGET_LABEL_EDEFAULT);
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
			case ContentsComposerPackage.ASSOCIATION__SOURCE:
				return source != null;
			case ContentsComposerPackage.ASSOCIATION__TARGET:
				return target != null;
			case ContentsComposerPackage.ASSOCIATION__SOURCE_LABEL:
				return SOURCE_LABEL_EDEFAULT == null ? sourceLabel != null : !SOURCE_LABEL_EDEFAULT.equals(sourceLabel);
			case ContentsComposerPackage.ASSOCIATION__TARGET_LABEL:
				return TARGET_LABEL_EDEFAULT == null ? targetLabel != null : !TARGET_LABEL_EDEFAULT.equals(targetLabel);
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
		result.append(" (sourceLabel: ");
		result.append(sourceLabel);
		result.append(", targetLabel: ");
		result.append(targetLabel);
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
	public void setSource(BlockElement newSource)
	{
		BlockElement oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.ASSOCIATION__SOURCE, oldSource, source));
		firePropertyChange(P_SOURCE, null, newSource);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTarget(BlockElement newTarget)
	{
		BlockElement oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.ASSOCIATION__TARGET, oldTarget, target));
		firePropertyChange(P_TARGET, null, newTarget);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSourceLabel(String newSourceLabel)
	{
		String oldSourceLabel = sourceLabel;
		sourceLabel = newSourceLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.ASSOCIATION__SOURCE_LABEL, oldSourceLabel, sourceLabel));
		firePropertyChange(P_SOURCE, null, null);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTargetLabel(String newTargetLabel)
	{
		String oldTargetLabel = targetLabel;
		targetLabel = newTargetLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentsComposerPackage.ASSOCIATION__TARGET_LABEL, oldTargetLabel, targetLabel));
		firePropertyChange(P_TARGET, null, null);
	}
} //AssociationImpl
