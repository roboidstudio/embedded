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

package org.roboid.studio.contentscomposer.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.roboid.core.runtime.IClip;
import org.roboid.studio.contentscomposer.AdderBlock;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.BranchBlock;
import org.roboid.studio.contentscomposer.ClipBlock;
import org.roboid.studio.contentscomposer.ClipBlockWithFrame;
import org.roboid.studio.contentscomposer.ContentsComposerElement;
import org.roboid.studio.contentscomposer.ContentsComposerPackage;
import org.roboid.studio.contentscomposer.DiceBlock;
import org.roboid.studio.contentscomposer.ForkBlock;
import org.roboid.studio.contentscomposer.LogicBlock;
import org.roboid.studio.contentscomposer.LoopBlock;
import org.roboid.studio.contentscomposer.MergeBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.MovableElement;
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.studio.contentscomposer.TriggerBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage
 * @generated
 */
public class ContentsComposerSwitch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ContentsComposerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentsComposerSwitch()
	{
		if (modelPackage == null) {
			modelPackage = ContentsComposerPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject)
	{
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject)
	{
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID) {
			case ContentsComposerPackage.CONTENTS_COMPOSER_ELEMENT: {
				ContentsComposerElement contentsComposerElement = (ContentsComposerElement)theEObject;
				T result = caseContentsComposerElement(contentsComposerElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MOTION_CONTENT: {
				MotionContent motionContent = (MotionContent)theEObject;
				T result = caseMotionContent(motionContent);
				if (result == null) result = caseContentsComposerElement(motionContent);
				if (result == null) result = caseIClip(motionContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MOVABLE_ELEMENT: {
				MovableElement movableElement = (MovableElement)theEObject;
				T result = caseMovableElement(movableElement);
				if (result == null) result = caseContentsComposerElement(movableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.ASSOCIATION: {
				Association association = (Association)theEObject;
				T result = caseAssociation(association);
				if (result == null) result = caseContentsComposerElement(association);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.BLOCK_ELEMENT: {
				BlockElement blockElement = (BlockElement)theEObject;
				T result = caseBlockElement(blockElement);
				if (result == null) result = caseMovableElement(blockElement);
				if (result == null) result = caseContentsComposerElement(blockElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.ROOT_BLOCK: {
				RootBlock rootBlock = (RootBlock)theEObject;
				T result = caseRootBlock(rootBlock);
				if (result == null) result = caseBlockElement(rootBlock);
				if (result == null) result = caseMovableElement(rootBlock);
				if (result == null) result = caseContentsComposerElement(rootBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.TERMINATOR_BLOCK: {
				TerminatorBlock terminatorBlock = (TerminatorBlock)theEObject;
				T result = caseTerminatorBlock(terminatorBlock);
				if (result == null) result = caseBlockElement(terminatorBlock);
				if (result == null) result = caseMovableElement(terminatorBlock);
				if (result == null) result = caseContentsComposerElement(terminatorBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.ADDER_BLOCK: {
				AdderBlock adderBlock = (AdderBlock)theEObject;
				T result = caseAdderBlock(adderBlock);
				if (result == null) result = caseBlockElement(adderBlock);
				if (result == null) result = caseMovableElement(adderBlock);
				if (result == null) result = caseContentsComposerElement(adderBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.DICE_BLOCK: {
				DiceBlock diceBlock = (DiceBlock)theEObject;
				T result = caseDiceBlock(diceBlock);
				if (result == null) result = caseBlockElement(diceBlock);
				if (result == null) result = caseMovableElement(diceBlock);
				if (result == null) result = caseContentsComposerElement(diceBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.LOOP_BLOCK: {
				LoopBlock loopBlock = (LoopBlock)theEObject;
				T result = caseLoopBlock(loopBlock);
				if (result == null) result = caseBlockElement(loopBlock);
				if (result == null) result = caseMovableElement(loopBlock);
				if (result == null) result = caseContentsComposerElement(loopBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.FORK_BLOCK: {
				ForkBlock forkBlock = (ForkBlock)theEObject;
				T result = caseForkBlock(forkBlock);
				if (result == null) result = caseBlockElement(forkBlock);
				if (result == null) result = caseMovableElement(forkBlock);
				if (result == null) result = caseContentsComposerElement(forkBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MERGE_BLOCK: {
				MergeBlock mergeBlock = (MergeBlock)theEObject;
				T result = caseMergeBlock(mergeBlock);
				if (result == null) result = caseBlockElement(mergeBlock);
				if (result == null) result = caseMovableElement(mergeBlock);
				if (result == null) result = caseContentsComposerElement(mergeBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.LOGIC_BLOCK: {
				LogicBlock logicBlock = (LogicBlock)theEObject;
				T result = caseLogicBlock(logicBlock);
				if (result == null) result = caseBlockElement(logicBlock);
				if (result == null) result = caseMovableElement(logicBlock);
				if (result == null) result = caseContentsComposerElement(logicBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.BRANCH_BLOCK: {
				BranchBlock branchBlock = (BranchBlock)theEObject;
				T result = caseBranchBlock(branchBlock);
				if (result == null) result = caseLogicBlock(branchBlock);
				if (result == null) result = caseBlockElement(branchBlock);
				if (result == null) result = caseMovableElement(branchBlock);
				if (result == null) result = caseContentsComposerElement(branchBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.TRIGGER_BLOCK: {
				TriggerBlock triggerBlock = (TriggerBlock)theEObject;
				T result = caseTriggerBlock(triggerBlock);
				if (result == null) result = caseLogicBlock(triggerBlock);
				if (result == null) result = caseBlockElement(triggerBlock);
				if (result == null) result = caseMovableElement(triggerBlock);
				if (result == null) result = caseContentsComposerElement(triggerBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.CLIP_BLOCK: {
				ClipBlock clipBlock = (ClipBlock)theEObject;
				T result = caseClipBlock(clipBlock);
				if (result == null) result = caseBlockElement(clipBlock);
				if (result == null) result = caseMovableElement(clipBlock);
				if (result == null) result = caseContentsComposerElement(clipBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.CLIP_BLOCK_WITH_FRAME: {
				ClipBlockWithFrame clipBlockWithFrame = (ClipBlockWithFrame)theEObject;
				T result = caseClipBlockWithFrame(clipBlockWithFrame);
				if (result == null) result = caseClipBlock(clipBlockWithFrame);
				if (result == null) result = caseBlockElement(clipBlockWithFrame);
				if (result == null) result = caseMovableElement(clipBlockWithFrame);
				if (result == null) result = caseContentsComposerElement(clipBlockWithFrame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MOTION_CLIP_BLOCK: {
				MotionClipBlock motionClipBlock = (MotionClipBlock)theEObject;
				T result = caseMotionClipBlock(motionClipBlock);
				if (result == null) result = caseClipBlockWithFrame(motionClipBlock);
				if (result == null) result = caseClipBlock(motionClipBlock);
				if (result == null) result = caseBlockElement(motionClipBlock);
				if (result == null) result = caseMovableElement(motionClipBlock);
				if (result == null) result = caseContentsComposerElement(motionClipBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MOTION_CLIP_CLONE_BLOCK: {
				MotionClipCloneBlock motionClipCloneBlock = (MotionClipCloneBlock)theEObject;
				T result = caseMotionClipCloneBlock(motionClipCloneBlock);
				if (result == null) result = caseClipBlockWithFrame(motionClipCloneBlock);
				if (result == null) result = caseClipBlock(motionClipCloneBlock);
				if (result == null) result = caseBlockElement(motionClipCloneBlock);
				if (result == null) result = caseMovableElement(motionClipCloneBlock);
				if (result == null) result = caseContentsComposerElement(motionClipCloneBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MOTION_CONTENT_BLOCK: {
				MotionContentBlock motionContentBlock = (MotionContentBlock)theEObject;
				T result = caseMotionContentBlock(motionContentBlock);
				if (result == null) result = caseClipBlock(motionContentBlock);
				if (result == null) result = caseBlockElement(motionContentBlock);
				if (result == null) result = caseMovableElement(motionContentBlock);
				if (result == null) result = caseContentsComposerElement(motionContentBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.MOTION_CONTENT_CLONE_BLOCK: {
				MotionContentCloneBlock motionContentCloneBlock = (MotionContentCloneBlock)theEObject;
				T result = caseMotionContentCloneBlock(motionContentCloneBlock);
				if (result == null) result = caseClipBlock(motionContentCloneBlock);
				if (result == null) result = caseBlockElement(motionContentCloneBlock);
				if (result == null) result = caseMovableElement(motionContentCloneBlock);
				if (result == null) result = caseContentsComposerElement(motionContentCloneBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContentsComposerPackage.WAIT_CLIP_BLOCK: {
				WaitClipBlock waitClipBlock = (WaitClipBlock)theEObject;
				T result = caseWaitClipBlock(waitClipBlock);
				if (result == null) result = caseClipBlockWithFrame(waitClipBlock);
				if (result == null) result = caseClipBlock(waitClipBlock);
				if (result == null) result = caseBlockElement(waitClipBlock);
				if (result == null) result = caseMovableElement(waitClipBlock);
				if (result == null) result = caseContentsComposerElement(waitClipBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContentsComposerElement(ContentsComposerElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motion Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motion Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotionContent(MotionContent object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Movable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Movable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMovableElement(MovableElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociation(Association object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockElement(BlockElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootBlock(RootBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminator Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminator Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminatorBlock(TerminatorBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adder Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adder Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdderBlock(AdderBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dice Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dice Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiceBlock(DiceBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopBlock(LoopBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fork Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fork Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForkBlock(ForkBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeBlock(MergeBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logic Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logic Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicBlock(LogicBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranchBlock(BranchBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTriggerBlock(TriggerBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clip Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clip Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClipBlock(ClipBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clip Block With Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clip Block With Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClipBlockWithFrame(ClipBlockWithFrame object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motion Clip Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motion Clip Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotionClipBlock(MotionClipBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motion Clip Clone Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motion Clip Clone Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotionClipCloneBlock(MotionClipCloneBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motion Content Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motion Content Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotionContentBlock(MotionContentBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Motion Content Clone Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Motion Content Clone Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMotionContentCloneBlock(MotionContentCloneBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait Clip Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait Clip Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitClipBlock(WaitClipBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IClip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IClip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIClip(IClip object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object)
	{
		return null;
	}

} //ContentsComposerSwitch
