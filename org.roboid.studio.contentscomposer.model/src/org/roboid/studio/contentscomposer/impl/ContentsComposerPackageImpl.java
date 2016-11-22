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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.swt.widgets.Shell;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.contentscomposer.AdderBlock;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.BranchBlock;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.ClipBlockWithFrame;
import org.roboid.studio.contentscomposer.ContentsComposerElement;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.DiceBlock;
import org.roboid.studio.contentscomposer.ForkBlock;
import org.roboid.studio.contentscomposer.LogicBlock;
import org.roboid.studio.contentscomposer.LogicType;
import org.roboid.studio.contentscomposer.LoopBlock;
import org.roboid.studio.contentscomposer.MergeBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.ScriptType;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.studio.contentscomposer.TriggerBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @generated
 */
public class ContentsComposerPackageImpl extends EPackageImpl implements ContentsComposerPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentsComposerElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motionContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminatorBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adderBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diceBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forkBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clipBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clipBlockWithFrameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motionClipBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motionClipCloneBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motionContentBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass motionContentCloneBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitClipBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iClipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scriptTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rectangleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertyChangeListenerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType scriptEngineEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType shellEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ContentsComposerPackageImpl()
	{
		super(eNS_URI, ContentsComposerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ContentsComposerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ContentsComposerPackage init()
	{
		if (isInited) return (ContentsComposerPackage)EPackage.Registry.INSTANCE.getEPackage(ContentsComposerPackage.eNS_URI);

		// Obtain or create and register package
		ContentsComposerPackageImpl theContentsComposerPackage = (ContentsComposerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ContentsComposerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ContentsComposerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimelinePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theContentsComposerPackage.createPackageContents();

		// Initialize created meta-data
		theContentsComposerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theContentsComposerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ContentsComposerPackage.eNS_URI, theContentsComposerPackage);
		return theContentsComposerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContentsComposerElement()
	{
		return contentsComposerElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotionContent()
	{
		return motionContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionContent_Robot()
	{
		return (EReference)motionContentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionContent_Activity()
	{
		return (EReference)motionContentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionContent_ScriptEngine()
	{
		return (EAttribute)motionContentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionContent_Blocks()
	{
		return (EReference)motionContentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionContent_Grid()
	{
		return (EAttribute)motionContentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionContent_Minimized()
	{
		return (EAttribute)motionContentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionContent_TerminatorScriptCode()
	{
		return (EAttribute)motionContentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionContent_Associations()
	{
		return (EReference)motionContentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionContent_Version()
	{
		return (EAttribute)motionContentEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovableElement()
	{
		return movableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovableElement_X()
	{
		return (EAttribute)movableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovableElement_Y()
	{
		return (EAttribute)movableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation()
	{
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Source()
	{
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Target()
	{
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_SourceLabel()
	{
		return (EAttribute)associationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_TargetLabel()
	{
		return (EAttribute)associationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockElement()
	{
		return blockElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockElement_Error()
	{
		return (EAttribute)blockElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockElement_Playing()
	{
		return (EAttribute)blockElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockElement_Incomings()
	{
		return (EReference)blockElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockElement_Outgoings()
	{
		return (EReference)blockElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockElement_ScriptType()
	{
		return (EAttribute)blockElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockElement_ScriptName()
	{
		return (EAttribute)blockElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockElement_ScriptCode()
	{
		return (EAttribute)blockElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockElement_NextBlock()
	{
		return (EReference)blockElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockElement_Parent()
	{
		return (EReference)blockElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootBlock()
	{
		return rootBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminatorBlock()
	{
		return terminatorBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdderBlock()
	{
		return adderBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiceBlock()
	{
		return diceBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiceBlock_Value()
	{
		return (EAttribute)diceBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiceBlock_Range()
	{
		return (EAttribute)diceBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopBlock()
	{
		return loopBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopBlock_Value()
	{
		return (EAttribute)loopBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopBlock_Count()
	{
		return (EAttribute)loopBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopBlock_YesBlock()
	{
		return (EReference)loopBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopBlock_NoBlock()
	{
		return (EReference)loopBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForkBlock()
	{
		return forkBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeBlock()
	{
		return mergeBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicBlock()
	{
		return logicBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicBlock_Frame()
	{
		return (EAttribute)logicBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicBlock_Logic()
	{
		return (EAttribute)logicBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicBlock_Index()
	{
		return (EAttribute)logicBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicBlock_Value()
	{
		return (EAttribute)logicBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicBlock_Device()
	{
		return (EAttribute)logicBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchBlock()
	{
		return branchBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchBlock_YesBlock()
	{
		return (EReference)branchBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchBlock_NoBlock()
	{
		return (EReference)branchBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriggerBlock()
	{
		return triggerBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClipBlock()
	{
		return clipBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipBlock_Frame()
	{
		return (EAttribute)clipBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClipBlockWithFrame()
	{
		return clipBlockWithFrameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipBlockWithFrame_StartFrame()
	{
		return (EAttribute)clipBlockWithFrameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipBlockWithFrame_StopFrame()
	{
		return (EAttribute)clipBlockWithFrameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotionClipBlock()
	{
		return motionClipBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionClipBlock_Name()
	{
		return (EAttribute)motionClipBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionClipBlock_MotionClip()
	{
		return (EReference)motionClipBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotionClipCloneBlock()
	{
		return motionClipCloneBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionClipCloneBlock_Original()
	{
		return (EReference)motionClipCloneBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotionContentBlock()
	{
		return motionContentBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMotionContentBlock_Name()
	{
		return (EAttribute)motionContentBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionContentBlock_Content()
	{
		return (EReference)motionContentBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMotionContentCloneBlock()
	{
		return motionContentCloneBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMotionContentCloneBlock_Original()
	{
		return (EReference)motionContentCloneBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWaitClipBlock()
	{
		return waitClipBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWaitClipBlock_Timeout()
	{
		return (EAttribute)waitClipBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIClip() {
		return iClipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScriptType()
	{
		return scriptTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicType()
	{
		return logicTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRectangle()
	{
		return rectangleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPropertyChangeListener()
	{
		return propertyChangeListenerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getScriptEngine()
	{
		return scriptEngineEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getShell()
	{
		return shellEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStringArray()
	{
		return stringArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentsComposerFactory getContentsComposerFactory()
	{
		return (ContentsComposerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		contentsComposerElementEClass = createEClass(CONTENTS_COMPOSER_ELEMENT);

		motionContentEClass = createEClass(MOTION_CONTENT);
		createEReference(motionContentEClass, MOTION_CONTENT__ROBOT);
		createEReference(motionContentEClass, MOTION_CONTENT__ACTIVITY);
		createEAttribute(motionContentEClass, MOTION_CONTENT__SCRIPT_ENGINE);
		createEReference(motionContentEClass, MOTION_CONTENT__BLOCKS);
		createEAttribute(motionContentEClass, MOTION_CONTENT__GRID);
		createEAttribute(motionContentEClass, MOTION_CONTENT__MINIMIZED);
		createEAttribute(motionContentEClass, MOTION_CONTENT__TERMINATOR_SCRIPT_CODE);
		createEReference(motionContentEClass, MOTION_CONTENT__ASSOCIATIONS);
		createEAttribute(motionContentEClass, MOTION_CONTENT__VERSION);

		movableElementEClass = createEClass(MOVABLE_ELEMENT);
		createEAttribute(movableElementEClass, MOVABLE_ELEMENT__X);
		createEAttribute(movableElementEClass, MOVABLE_ELEMENT__Y);

		associationEClass = createEClass(ASSOCIATION);
		createEReference(associationEClass, ASSOCIATION__SOURCE);
		createEReference(associationEClass, ASSOCIATION__TARGET);
		createEAttribute(associationEClass, ASSOCIATION__SOURCE_LABEL);
		createEAttribute(associationEClass, ASSOCIATION__TARGET_LABEL);

		blockElementEClass = createEClass(BLOCK_ELEMENT);
		createEAttribute(blockElementEClass, BLOCK_ELEMENT__ERROR);
		createEAttribute(blockElementEClass, BLOCK_ELEMENT__PLAYING);
		createEReference(blockElementEClass, BLOCK_ELEMENT__INCOMINGS);
		createEReference(blockElementEClass, BLOCK_ELEMENT__OUTGOINGS);
		createEAttribute(blockElementEClass, BLOCK_ELEMENT__SCRIPT_TYPE);
		createEAttribute(blockElementEClass, BLOCK_ELEMENT__SCRIPT_NAME);
		createEAttribute(blockElementEClass, BLOCK_ELEMENT__SCRIPT_CODE);
		createEReference(blockElementEClass, BLOCK_ELEMENT__NEXT_BLOCK);
		createEReference(blockElementEClass, BLOCK_ELEMENT__PARENT);

		rootBlockEClass = createEClass(ROOT_BLOCK);

		terminatorBlockEClass = createEClass(TERMINATOR_BLOCK);

		adderBlockEClass = createEClass(ADDER_BLOCK);

		diceBlockEClass = createEClass(DICE_BLOCK);
		createEAttribute(diceBlockEClass, DICE_BLOCK__VALUE);
		createEAttribute(diceBlockEClass, DICE_BLOCK__RANGE);

		loopBlockEClass = createEClass(LOOP_BLOCK);
		createEAttribute(loopBlockEClass, LOOP_BLOCK__VALUE);
		createEAttribute(loopBlockEClass, LOOP_BLOCK__COUNT);
		createEReference(loopBlockEClass, LOOP_BLOCK__YES_BLOCK);
		createEReference(loopBlockEClass, LOOP_BLOCK__NO_BLOCK);

		forkBlockEClass = createEClass(FORK_BLOCK);

		mergeBlockEClass = createEClass(MERGE_BLOCK);

		logicBlockEClass = createEClass(LOGIC_BLOCK);
		createEAttribute(logicBlockEClass, LOGIC_BLOCK__FRAME);
		createEAttribute(logicBlockEClass, LOGIC_BLOCK__LOGIC);
		createEAttribute(logicBlockEClass, LOGIC_BLOCK__INDEX);
		createEAttribute(logicBlockEClass, LOGIC_BLOCK__VALUE);
		createEAttribute(logicBlockEClass, LOGIC_BLOCK__DEVICE);

		branchBlockEClass = createEClass(BRANCH_BLOCK);
		createEReference(branchBlockEClass, BRANCH_BLOCK__YES_BLOCK);
		createEReference(branchBlockEClass, BRANCH_BLOCK__NO_BLOCK);

		triggerBlockEClass = createEClass(TRIGGER_BLOCK);

		clipBlockEClass = createEClass(CLIP_BLOCK);
		createEAttribute(clipBlockEClass, CLIP_BLOCK__FRAME);

		clipBlockWithFrameEClass = createEClass(CLIP_BLOCK_WITH_FRAME);
		createEAttribute(clipBlockWithFrameEClass, CLIP_BLOCK_WITH_FRAME__START_FRAME);
		createEAttribute(clipBlockWithFrameEClass, CLIP_BLOCK_WITH_FRAME__STOP_FRAME);

		motionClipBlockEClass = createEClass(MOTION_CLIP_BLOCK);
		createEAttribute(motionClipBlockEClass, MOTION_CLIP_BLOCK__NAME);
		createEReference(motionClipBlockEClass, MOTION_CLIP_BLOCK__MOTION_CLIP);

		motionClipCloneBlockEClass = createEClass(MOTION_CLIP_CLONE_BLOCK);
		createEReference(motionClipCloneBlockEClass, MOTION_CLIP_CLONE_BLOCK__ORIGINAL);

		motionContentBlockEClass = createEClass(MOTION_CONTENT_BLOCK);
		createEAttribute(motionContentBlockEClass, MOTION_CONTENT_BLOCK__NAME);
		createEReference(motionContentBlockEClass, MOTION_CONTENT_BLOCK__CONTENT);

		motionContentCloneBlockEClass = createEClass(MOTION_CONTENT_CLONE_BLOCK);
		createEReference(motionContentCloneBlockEClass, MOTION_CONTENT_CLONE_BLOCK__ORIGINAL);

		waitClipBlockEClass = createEClass(WAIT_CLIP_BLOCK);
		createEAttribute(waitClipBlockEClass, WAIT_CLIP_BLOCK__TIMEOUT);

		iClipEClass = createEClass(ICLIP);

		// Create enums
		scriptTypeEEnum = createEEnum(SCRIPT_TYPE);
		logicTypeEEnum = createEEnum(LOGIC_TYPE);

		// Create data types
		rectangleEDataType = createEDataType(RECTANGLE);
		propertyChangeListenerEDataType = createEDataType(PROPERTY_CHANGE_LISTENER);
		scriptEngineEDataType = createEDataType(SCRIPT_ENGINE);
		shellEDataType = createEDataType(SHELL);
		stringArrayEDataType = createEDataType(STRING_ARRAY);
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TimelinePackage theTimelinePackage = (TimelinePackage)EPackage.Registry.INSTANCE.getEPackage(TimelinePackage.eNS_URI);
		RobotPackage theRobotPackage = (RobotPackage)EPackage.Registry.INSTANCE.getEPackage(RobotPackage.eNS_URI);
		ActivityPackage theActivityPackage = (ActivityPackage)EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		motionContentEClass.getESuperTypes().add(this.getContentsComposerElement());
		motionContentEClass.getESuperTypes().add(this.getIClip());
		movableElementEClass.getESuperTypes().add(this.getContentsComposerElement());
		associationEClass.getESuperTypes().add(this.getContentsComposerElement());
		blockElementEClass.getESuperTypes().add(this.getMovableElement());
		rootBlockEClass.getESuperTypes().add(this.getBlockElement());
		terminatorBlockEClass.getESuperTypes().add(this.getBlockElement());
		adderBlockEClass.getESuperTypes().add(this.getBlockElement());
		diceBlockEClass.getESuperTypes().add(this.getBlockElement());
		loopBlockEClass.getESuperTypes().add(this.getBlockElement());
		forkBlockEClass.getESuperTypes().add(this.getBlockElement());
		mergeBlockEClass.getESuperTypes().add(this.getBlockElement());
		logicBlockEClass.getESuperTypes().add(this.getBlockElement());
		branchBlockEClass.getESuperTypes().add(this.getLogicBlock());
		triggerBlockEClass.getESuperTypes().add(this.getLogicBlock());
		clipBlockEClass.getESuperTypes().add(this.getBlockElement());
		clipBlockWithFrameEClass.getESuperTypes().add(this.getClipBlock());
		motionClipBlockEClass.getESuperTypes().add(this.getClipBlockWithFrame());
		motionClipCloneBlockEClass.getESuperTypes().add(this.getClipBlockWithFrame());
		motionContentBlockEClass.getESuperTypes().add(this.getClipBlock());
		motionContentCloneBlockEClass.getESuperTypes().add(this.getClipBlock());
		waitClipBlockEClass.getESuperTypes().add(this.getClipBlockWithFrame());

		// Initialize classes and features; add operations and parameters
		initEClass(contentsComposerElementEClass, ContentsComposerElement.class, "ContentsComposerElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(contentsComposerElementEClass, null, "addPropertyChangeListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTimelinePackage.getPropertyChangeListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentsComposerElementEClass, null, "firePropertyChange", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "propertyName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "oldValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "newValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(contentsComposerElementEClass, null, "removePropertyChangeListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTimelinePackage.getPropertyChangeListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(motionContentEClass, MotionContent.class, "MotionContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMotionContent_Robot(), theRobotPackage.getRobot(), null, "robot", null, 0, 1, MotionContent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionContent_Activity(), theActivityPackage.getActivity(), null, "activity", null, 0, 1, MotionContent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionContent_ScriptEngine(), this.getScriptEngine(), "scriptEngine", null, 0, 1, MotionContent.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionContent_Blocks(), this.getBlockElement(), null, "blocks", null, 0, -1, MotionContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionContent_Grid(), ecorePackage.getEBoolean(), "grid", null, 0, 1, MotionContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionContent_Minimized(), ecorePackage.getEBoolean(), "minimized", null, 0, 1, MotionContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionContent_TerminatorScriptCode(), ecorePackage.getEString(), "terminatorScriptCode", "", 0, 1, MotionContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionContent_Associations(), this.getAssociation(), null, "associations", null, 0, -1, MotionContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMotionContent_Version(), ecorePackage.getEString(), "version", "1.0.0", 0, 1, MotionContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(motionContentEClass, null, "addChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, null, "removeChild", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "child", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, this.getStringArray(), "getDeviceNames", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, this.getStringArray(), "getActiveDeviceNames", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, this.getScriptEngine(), "createScriptEngine", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, theRobotPackage.getDevice(), "getDevices", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, this.getMotionClipBlock(), "getMotionClipBlocks", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, this.getMotionContentBlock(), "getMotionContentBlocks", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, null, "addAssociation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, null, "removeAssociation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, ecorePackage.getEString(), "getDeviceName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, theRobotPackage.getDevice(), "getDevice", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, this.getMotionClipBlock(), "findMotionClipBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, this.getMotionContentBlock(), "findMotionContentBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, this.getMotionContent(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentEClass, null, "refreshResource", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionContentEClass, null, "refreshResource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTimelinePackage.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(movableElementEClass, MovableElement.class, "MovableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMovableElement_X(), ecorePackage.getEInt(), "x", null, 0, 1, MovableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovableElement_Y(), ecorePackage.getEInt(), "y", null, 0, 1, MovableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociation_Source(), this.getBlockElement(), null, "source", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Target(), this.getBlockElement(), null, "target", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_SourceLabel(), ecorePackage.getEString(), "sourceLabel", "", 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociation_TargetLabel(), ecorePackage.getEString(), "targetLabel", "", 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockElementEClass, BlockElement.class, "BlockElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlockElement_Error(), ecorePackage.getEBoolean(), "error", null, 0, 1, BlockElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockElement_Playing(), ecorePackage.getEBoolean(), "playing", null, 0, 1, BlockElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockElement_Incomings(), this.getAssociation(), null, "incomings", null, 0, -1, BlockElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockElement_Outgoings(), this.getAssociation(), null, "outgoings", null, 0, -1, BlockElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockElement_ScriptType(), this.getScriptType(), "scriptType", null, 0, 1, BlockElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockElement_ScriptName(), ecorePackage.getEString(), "scriptName", "", 0, 1, BlockElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockElement_ScriptCode(), ecorePackage.getEString(), "scriptCode", "", 0, 1, BlockElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockElement_NextBlock(), this.getBlockElement(), null, "nextBlock", null, 0, 1, BlockElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBlockElement_Parent(), this.getMotionContent(), null, "parent", null, 0, 1, BlockElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "canHaveScript", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, null, "updateScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scriptName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scriptCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEString(), "getLabel", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "canDelete", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "canCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "canCut", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, null, "addIncoming", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, null, "addOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, null, "removeIncoming", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, null, "removeOutgoing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAssociation(), "association", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEFloat(), "getVariable", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, null, "reset", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "canReconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "newSource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "newTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "oldBlock", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, ecorePackage.getEBoolean(), "canConnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBlockElement(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockElementEClass, this.getBlockElement(), "deepCopy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMotionContent(), "newParent", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(rootBlockEClass, RootBlock.class, "RootBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(rootBlockEClass, null, "executeScript", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(terminatorBlockEClass, TerminatorBlock.class, "TerminatorBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(terminatorBlockEClass, null, "copyScriptType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(terminatorBlockEClass, null, "executeScript", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(adderBlockEClass, AdderBlock.class, "AdderBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diceBlockEClass, DiceBlock.class, "DiceBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiceBlock_Value(), ecorePackage.getEInt(), "value", null, 0, 1, DiceBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiceBlock_Range(), ecorePackage.getEInt(), "range", "1", 0, 1, DiceBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopBlockEClass, LoopBlock.class, "LoopBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopBlock_Value(), ecorePackage.getEInt(), "value", null, 0, 1, LoopBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoopBlock_Count(), ecorePackage.getEInt(), "count", "1", 0, 1, LoopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopBlock_YesBlock(), this.getBlockElement(), null, "yesBlock", null, 0, 1, LoopBlock.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getLoopBlock_NoBlock(), this.getBlockElement(), null, "noBlock", null, 0, 1, LoopBlock.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(forkBlockEClass, ForkBlock.class, "ForkBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mergeBlockEClass, MergeBlock.class, "MergeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicBlockEClass, LogicBlock.class, "LogicBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogicBlock_Frame(), ecorePackage.getEInt(), "frame", null, 0, 1, LogicBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogicBlock_Logic(), this.getLogicType(), "logic", null, 0, 1, LogicBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogicBlock_Index(), ecorePackage.getEInt(), "index", null, 0, 1, LogicBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogicBlock_Value(), ecorePackage.getEFloat(), "value", "1", 0, 1, LogicBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogicBlock_Device(), ecorePackage.getEInt(), "device", null, 0, 1, LogicBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(logicBlockEClass, ecorePackage.getEBoolean(), "checkCondition", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(branchBlockEClass, BranchBlock.class, "BranchBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranchBlock_YesBlock(), this.getBlockElement(), null, "yesBlock", null, 0, 1, BranchBlock.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBranchBlock_NoBlock(), this.getBlockElement(), null, "noBlock", null, 0, 1, BranchBlock.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(triggerBlockEClass, TriggerBlock.class, "TriggerBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clipBlockEClass, ClipBlock.class, "ClipBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClipBlock_Frame(), ecorePackage.getEInt(), "frame", null, 0, 1, ClipBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(clipBlockEClass, null, "resetTriggers", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(clipBlockWithFrameEClass, ClipBlockWithFrame.class, "ClipBlockWithFrame", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClipBlockWithFrame_StartFrame(), ecorePackage.getEInt(), "startFrame", null, 0, 1, ClipBlockWithFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipBlockWithFrame_StopFrame(), ecorePackage.getEInt(), "stopFrame", "-1", 0, 1, ClipBlockWithFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(motionClipBlockEClass, MotionClipBlock.class, "MotionClipBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMotionClipBlock_Name(), ecorePackage.getEString(), "name", "", 0, 1, MotionClipBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionClipBlock_MotionClip(), theTimelinePackage.getMotionClip(), null, "motionClip", null, 0, 1, MotionClipBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(motionClipBlockEClass, ecorePackage.getEInt(), "getTotalFrames", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(motionClipBlockEClass, null, "updateName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionClipBlockEClass, ecorePackage.getEInt(), "countClones", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(motionClipCloneBlockEClass, MotionClipCloneBlock.class, "MotionClipCloneBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMotionClipCloneBlock_Original(), this.getMotionClipBlock(), null, "original", null, 0, 1, MotionClipCloneBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(motionClipCloneBlockEClass, ecorePackage.getEInt(), "getTotalFrames", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(motionContentBlockEClass, MotionContentBlock.class, "MotionContentBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMotionContentBlock_Name(), ecorePackage.getEString(), "name", "", 0, 1, MotionContentBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMotionContentBlock_Content(), this.getMotionContent(), null, "content", null, 0, 1, MotionContentBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(motionContentBlockEClass, null, "updateName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(motionContentBlockEClass, ecorePackage.getEInt(), "countClones", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(motionContentCloneBlockEClass, MotionContentCloneBlock.class, "MotionContentCloneBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMotionContentCloneBlock_Original(), this.getMotionContentBlock(), null, "original", null, 0, 1, MotionContentCloneBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitClipBlockEClass, WaitClipBlock.class, "WaitClipBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWaitClipBlock_Timeout(), ecorePackage.getEFloat(), "timeout", "-1", 0, 1, WaitClipBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(waitClipBlockEClass, ecorePackage.getEBoolean(), "checkTimeout", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "frame", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(waitClipBlockEClass, ecorePackage.getEString(), "timeoutToString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iClipEClass, IClip.class, "IClip", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(scriptTypeEEnum, ScriptType.class, "ScriptType");
		addEEnumLiteral(scriptTypeEEnum, ScriptType.NONE);
		addEEnumLiteral(scriptTypeEEnum, ScriptType.ROBOID_SCRIPT);

		initEEnum(logicTypeEEnum, LogicType.class, "LogicType");
		addEEnumLiteral(logicTypeEEnum, LogicType.EQ);
		addEEnumLiteral(logicTypeEEnum, LogicType.NE);
		addEEnumLiteral(logicTypeEEnum, LogicType.GT);
		addEEnumLiteral(logicTypeEEnum, LogicType.GE);
		addEEnumLiteral(logicTypeEEnum, LogicType.LT);
		addEEnumLiteral(logicTypeEEnum, LogicType.LE);

		// Initialize data types
		initEDataType(rectangleEDataType, Rectangle.class, "Rectangle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertyChangeListenerEDataType, PropertyChangeListener.class, "PropertyChangeListener", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(scriptEngineEDataType, ScriptEngine.class, "ScriptEngine", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(shellEDataType, Shell.class, "Shell", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringArrayEDataType, String[].class, "StringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ContentsComposerPackageImpl
