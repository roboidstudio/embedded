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

import java.beans.PropertyChangeListener;

import javax.script.ScriptEngine;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.swt.widgets.Shell;

import org.roboid.studio.contentscomposer.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class ContentsComposerFactoryImpl extends EFactoryImpl implements ContentsComposerFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContentsComposerFactory init()
	{
		try {
			ContentsComposerFactory theContentsComposerFactory = (ContentsComposerFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.roboidstudio.org/model/contentscomposer"); 
			if (theContentsComposerFactory != null) {
				return theContentsComposerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ContentsComposerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentsComposerFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID()) {
			case ContentsComposerPackage.MOTION_CONTENT: return (EObject)createMotionContent();
			case ContentsComposerPackage.ASSOCIATION: return (EObject)createAssociation();
			case ContentsComposerPackage.ROOT_BLOCK: return (EObject)createRootBlock();
			case ContentsComposerPackage.TERMINATOR_BLOCK: return (EObject)createTerminatorBlock();
			case ContentsComposerPackage.ADDER_BLOCK: return (EObject)createAdderBlock();
			case ContentsComposerPackage.DICE_BLOCK: return (EObject)createDiceBlock();
			case ContentsComposerPackage.LOOP_BLOCK: return (EObject)createLoopBlock();
			case ContentsComposerPackage.FORK_BLOCK: return (EObject)createForkBlock();
			case ContentsComposerPackage.MERGE_BLOCK: return (EObject)createMergeBlock();
			case ContentsComposerPackage.BRANCH_BLOCK: return (EObject)createBranchBlock();
			case ContentsComposerPackage.TRIGGER_BLOCK: return (EObject)createTriggerBlock();
			case ContentsComposerPackage.MOTION_CLIP_BLOCK: return (EObject)createMotionClipBlock();
			case ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK: return (EObject)createMotionClipCloneBlock();
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK: return (EObject)createMotionContentBlock();
			case ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK: return (EObject)createMotionContentCloneBlock();
			case ContentsComposerPackage.WAIT_CLIP_BLOCK: return (EObject)createWaitClipBlock();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID()) {
			case ContentsComposerPackage.SCRIPT_TYPE:
				return createScriptTypeFromString(eDataType, initialValue);
			case ContentsComposerPackage.LOGIC_TYPE:
				return createLogicTypeFromString(eDataType, initialValue);
			case ContentsComposerPackage.RECTANGLE:
				return createRectangleFromString(eDataType, initialValue);
			case ContentsComposerPackage.PROPERTY_CHANGE_LISTENER:
				return createPropertyChangeListenerFromString(eDataType, initialValue);
			case ContentsComposerPackage.SCRIPT_ENGINE:
				return createScriptEngineFromString(eDataType, initialValue);
			case ContentsComposerPackage.SHELL:
				return createShellFromString(eDataType, initialValue);
			case ContentsComposerPackage.STRING_ARRAY:
				return createStringArrayFromString(eDataType, initialValue);
			case ContentsComposerPackage.URI:
				return createURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID()) {
			case ContentsComposerPackage.SCRIPT_TYPE:
				return convertScriptTypeToString(eDataType, instanceValue);
			case ContentsComposerPackage.LOGIC_TYPE:
				return convertLogicTypeToString(eDataType, instanceValue);
			case ContentsComposerPackage.RECTANGLE:
				return convertRectangleToString(eDataType, instanceValue);
			case ContentsComposerPackage.PROPERTY_CHANGE_LISTENER:
				return convertPropertyChangeListenerToString(eDataType, instanceValue);
			case ContentsComposerPackage.SCRIPT_ENGINE:
				return convertScriptEngineToString(eDataType, instanceValue);
			case ContentsComposerPackage.SHELL:
				return convertShellToString(eDataType, instanceValue);
			case ContentsComposerPackage.STRING_ARRAY:
				return convertStringArrayToString(eDataType, instanceValue);
			case ContentsComposerPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionContent createMotionContent()
	{
		MotionContentImpl motionContent = new MotionContentImpl();
		return motionContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association createAssociation()
	{
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootBlock createRootBlock()
	{
		RootBlockImpl rootBlock = new RootBlockImpl();
		return rootBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminatorBlock createTerminatorBlock()
	{
		TerminatorBlockImpl terminatorBlock = new TerminatorBlockImpl();
		return terminatorBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdderBlock createAdderBlock()
	{
		AdderBlockImpl adderBlock = new AdderBlockImpl();
		return adderBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiceBlock createDiceBlock()
	{
		DiceBlockImpl diceBlock = new DiceBlockImpl();
		return diceBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopBlock createLoopBlock()
	{
		LoopBlockImpl loopBlock = new LoopBlockImpl();
		return loopBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkBlock createForkBlock()
	{
		ForkBlockImpl forkBlock = new ForkBlockImpl();
		return forkBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeBlock createMergeBlock()
	{
		MergeBlockImpl mergeBlock = new MergeBlockImpl();
		return mergeBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchBlock createBranchBlock()
	{
		BranchBlockImpl branchBlock = new BranchBlockImpl();
		return branchBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriggerBlock createTriggerBlock()
	{
		TriggerBlockImpl triggerBlock = new TriggerBlockImpl();
		return triggerBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionClipBlock createMotionClipBlock()
	{
		MotionClipBlockImpl motionClipBlock = new MotionClipBlockImpl();
		return motionClipBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionClipCloneBlock createMotionClipCloneBlock()
	{
		MotionClipCloneBlockImpl motionClipCloneBlock = new MotionClipCloneBlockImpl();
		return motionClipCloneBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionContentBlock createMotionContentBlock()
	{
		MotionContentBlockImpl motionContentBlock = new MotionContentBlockImpl();
		return motionContentBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MotionContentCloneBlock createMotionContentCloneBlock()
	{
		MotionContentCloneBlockImpl motionContentCloneBlock = new MotionContentCloneBlockImpl();
		return motionContentCloneBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitClipBlock createWaitClipBlock()
	{
		WaitClipBlockImpl waitClipBlock = new WaitClipBlockImpl();
		return waitClipBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType createScriptTypeFromString(EDataType eDataType, String initialValue)
	{
		ScriptType result = ScriptType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScriptTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicType createLogicTypeFromString(EDataType eDataType, String initialValue)
	{
		LogicType result = LogicType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle createRectangleFromString(EDataType eDataType, String initialValue)
	{
		return (Rectangle)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRectangleToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyChangeListener createPropertyChangeListenerFromString(EDataType eDataType, String initialValue)
	{
		return (PropertyChangeListener)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyChangeListenerToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptEngine createScriptEngineFromString(EDataType eDataType, String initialValue)
	{
		return (ScriptEngine)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScriptEngineToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shell createShellFromString(EDataType eDataType, String initialValue)
	{
		return (Shell)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShellToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String[] createStringArrayFromString(EDataType eDataType, String initialValue)
	{
		return (String[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringArrayToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentsComposerPackage getContentsComposerPackage()
	{
		return (ContentsComposerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ContentsComposerPackage getPackage()
	{
		return ContentsComposerPackage.eINSTANCE;
	}

} //ContentsComposerFactoryImpl
