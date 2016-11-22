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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage
 * @generated
 */
public interface ContentsComposerFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContentsComposerFactory eINSTANCE = org.roboid.studio.contentscomposer.impl.ContentsComposerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Motion Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Motion Content</em>'.
	 * @generated
	 */
	MotionContent createMotionContent();

	/**
	 * Returns a new object of class '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association</em>'.
	 * @generated
	 */
	Association createAssociation();

	/**
	 * Returns a new object of class '<em>Root Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Block</em>'.
	 * @generated
	 */
	RootBlock createRootBlock();

	/**
	 * Returns a new object of class '<em>Terminator Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminator Block</em>'.
	 * @generated
	 */
	TerminatorBlock createTerminatorBlock();

	/**
	 * Returns a new object of class '<em>Adder Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adder Block</em>'.
	 * @generated
	 */
	AdderBlock createAdderBlock();

	/**
	 * Returns a new object of class '<em>Dice Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dice Block</em>'.
	 * @generated
	 */
	DiceBlock createDiceBlock();

	/**
	 * Returns a new object of class '<em>Loop Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Block</em>'.
	 * @generated
	 */
	LoopBlock createLoopBlock();

	/**
	 * Returns a new object of class '<em>Fork Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork Block</em>'.
	 * @generated
	 */
	ForkBlock createForkBlock();

	/**
	 * Returns a new object of class '<em>Merge Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Block</em>'.
	 * @generated
	 */
	MergeBlock createMergeBlock();

	/**
	 * Returns a new object of class '<em>Branch Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch Block</em>'.
	 * @generated
	 */
	BranchBlock createBranchBlock();

	/**
	 * Returns a new object of class '<em>Trigger Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trigger Block</em>'.
	 * @generated
	 */
	TriggerBlock createTriggerBlock();

	/**
	 * Returns a new object of class '<em>Motion Clip Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Motion Clip Block</em>'.
	 * @generated
	 */
	MotionClipBlock createMotionClipBlock();

	/**
	 * Returns a new object of class '<em>Motion Clip Clone Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Motion Clip Clone Block</em>'.
	 * @generated
	 */
	MotionClipCloneBlock createMotionClipCloneBlock();

	/**
	 * Returns a new object of class '<em>Motion Content Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Motion Content Block</em>'.
	 * @generated
	 */
	MotionContentBlock createMotionContentBlock();

	/**
	 * Returns a new object of class '<em>Motion Content Clone Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Motion Content Clone Block</em>'.
	 * @generated
	 */
	MotionContentCloneBlock createMotionContentCloneBlock();

	/**
	 * Returns a new object of class '<em>Wait Clip Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Clip Block</em>'.
	 * @generated
	 */
	WaitClipBlock createWaitClipBlock();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ContentsComposerPackage getContentsComposerPackage();

} //ContentsComposerFactory
