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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.contentscomposer.ContentsComposerPackage
 * @generated
 */
public class ContentsComposerAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ContentsComposerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentsComposerAdapterFactory()
	{
		if (modelPackage == null) {
			modelPackage = ContentsComposerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentsComposerSwitch<Adapter> modelSwitch =
		new ContentsComposerSwitch<Adapter>() {
			@Override
			public Adapter caseContentsComposerElement(ContentsComposerElement object) {
				return createContentsComposerElementAdapter();
			}
			@Override
			public Adapter caseMotionContent(MotionContent object) {
				return createMotionContentAdapter();
			}
			@Override
			public Adapter caseMovableElement(MovableElement object) {
				return createMovableElementAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter caseBlockElement(BlockElement object) {
				return createBlockElementAdapter();
			}
			@Override
			public Adapter caseRootBlock(RootBlock object) {
				return createRootBlockAdapter();
			}
			@Override
			public Adapter caseTerminatorBlock(TerminatorBlock object) {
				return createTerminatorBlockAdapter();
			}
			@Override
			public Adapter caseAdderBlock(AdderBlock object) {
				return createAdderBlockAdapter();
			}
			@Override
			public Adapter caseDiceBlock(DiceBlock object) {
				return createDiceBlockAdapter();
			}
			@Override
			public Adapter caseLoopBlock(LoopBlock object) {
				return createLoopBlockAdapter();
			}
			@Override
			public Adapter caseForkBlock(ForkBlock object) {
				return createForkBlockAdapter();
			}
			@Override
			public Adapter caseMergeBlock(MergeBlock object) {
				return createMergeBlockAdapter();
			}
			@Override
			public Adapter caseLogicBlock(LogicBlock object) {
				return createLogicBlockAdapter();
			}
			@Override
			public Adapter caseBranchBlock(BranchBlock object) {
				return createBranchBlockAdapter();
			}
			@Override
			public Adapter caseTriggerBlock(TriggerBlock object) {
				return createTriggerBlockAdapter();
			}
			@Override
			public Adapter caseClipBlock(ClipBlock object) {
				return createClipBlockAdapter();
			}
			@Override
			public Adapter caseClipBlockWithFrame(ClipBlockWithFrame object) {
				return createClipBlockWithFrameAdapter();
			}
			@Override
			public Adapter caseMotionClipBlock(MotionClipBlock object) {
				return createMotionClipBlockAdapter();
			}
			@Override
			public Adapter caseMotionClipCloneBlock(MotionClipCloneBlock object) {
				return createMotionClipCloneBlockAdapter();
			}
			@Override
			public Adapter caseMotionContentBlock(MotionContentBlock object) {
				return createMotionContentBlockAdapter();
			}
			@Override
			public Adapter caseMotionContentCloneBlock(MotionContentCloneBlock object) {
				return createMotionContentCloneBlockAdapter();
			}
			@Override
			public Adapter caseWaitClipBlock(WaitClipBlock object) {
				return createWaitClipBlockAdapter();
			}
			@Override
			public Adapter caseIClip(IClip object) {
				return createIClipAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.ContentsComposerElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerElement
	 * @generated
	 */
	public Adapter createContentsComposerElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MotionContent <em>Motion Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MotionContent
	 * @generated
	 */
	public Adapter createMotionContentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MovableElement <em>Movable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MovableElement
	 * @generated
	 */
	public Adapter createMovableElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.Association
	 * @generated
	 */
	public Adapter createAssociationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.BlockElement <em>Block Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.BlockElement
	 * @generated
	 */
	public Adapter createBlockElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.RootBlock <em>Root Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.RootBlock
	 * @generated
	 */
	public Adapter createRootBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.TerminatorBlock <em>Terminator Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.TerminatorBlock
	 * @generated
	 */
	public Adapter createTerminatorBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.AdderBlock <em>Adder Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.AdderBlock
	 * @generated
	 */
	public Adapter createAdderBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.DiceBlock <em>Dice Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.DiceBlock
	 * @generated
	 */
	public Adapter createDiceBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.LoopBlock <em>Loop Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.LoopBlock
	 * @generated
	 */
	public Adapter createLoopBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.ForkBlock <em>Fork Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.ForkBlock
	 * @generated
	 */
	public Adapter createForkBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MergeBlock <em>Merge Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MergeBlock
	 * @generated
	 */
	public Adapter createMergeBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.LogicBlock <em>Logic Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.LogicBlock
	 * @generated
	 */
	public Adapter createLogicBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.BranchBlock <em>Branch Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.BranchBlock
	 * @generated
	 */
	public Adapter createBranchBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.TriggerBlock <em>Trigger Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.TriggerBlock
	 * @generated
	 */
	public Adapter createTriggerBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.ClipBlock <em>Clip Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.ClipBlock
	 * @generated
	 */
	public Adapter createClipBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame <em>Clip Block With Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.ClipBlockWithFrame
	 * @generated
	 */
	public Adapter createClipBlockWithFrameAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MotionClipBlock <em>Motion Clip Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MotionClipBlock
	 * @generated
	 */
	public Adapter createMotionClipBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MotionClipCloneBlock <em>Motion Clip Clone Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MotionClipCloneBlock
	 * @generated
	 */
	public Adapter createMotionClipCloneBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MotionContentBlock <em>Motion Content Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MotionContentBlock
	 * @generated
	 */
	public Adapter createMotionContentBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.MotionContentCloneBlock <em>Motion Content Clone Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.MotionContentCloneBlock
	 * @generated
	 */
	public Adapter createMotionContentCloneBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.studio.contentscomposer.WaitClipBlock <em>Wait Clip Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.studio.contentscomposer.WaitClipBlock
	 * @generated
	 */
	public Adapter createWaitClipBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.roboid.core.runtime.IClip <em>IClip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.roboid.core.runtime.IClip
	 * @generated
	 */
	public Adapter createIClipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ContentsComposerAdapterFactory
