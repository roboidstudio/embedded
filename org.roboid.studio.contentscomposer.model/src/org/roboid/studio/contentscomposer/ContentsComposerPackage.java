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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * @see org.roboid.studio.contentscomposer.ContentsComposerFactory
 * @model kind="package"
 * @generated
 */
public interface ContentsComposerPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "contentscomposer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.roboidstudio.org/model/contentscomposer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.roboid.studio.contentscomposer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContentsComposerPackage eINSTANCE = org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.ContentsComposerElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerElementImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getContentsComposerElement()
	 * @generated
	 */
	int CONTENTS_COMPOSER_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl <em>Motion Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MotionContentImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionContent()
	 * @generated
	 */
	int MOTION_CONTENT = 1;

	/**
	 * The feature id for the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__ROBOT = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__ACTIVITY = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Script Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__SCRIPT_ENGINE = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__BLOCKS = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__GRID = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Minimized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__MINIMIZED = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Terminator Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__TERMINATOR_SCRIPT_CODE = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__ASSOCIATIONS = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT__VERSION = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Motion Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_FEATURE_COUNT = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MovableElementImpl <em>Movable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MovableElementImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMovableElement()
	 * @generated
	 */
	int MOVABLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVABLE_ELEMENT__X = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVABLE_ELEMENT__Y = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Movable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVABLE_ELEMENT_FEATURE_COUNT = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.AssociationImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE_LABEL = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET_LABEL = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = CONTENTS_COMPOSER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl <em>Block Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.BlockElementImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getBlockElement()
	 * @generated
	 */
	int BLOCK_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__X = MOVABLE_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__Y = MOVABLE_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__ERROR = MOVABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__PLAYING = MOVABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__INCOMINGS = MOVABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__OUTGOINGS = MOVABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__SCRIPT_TYPE = MOVABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__SCRIPT_NAME = MOVABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__SCRIPT_CODE = MOVABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__NEXT_BLOCK = MOVABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT__PARENT = MOVABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Block Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ELEMENT_FEATURE_COUNT = MOVABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.RootBlockImpl <em>Root Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.RootBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getRootBlock()
	 * @generated
	 */
	int ROOT_BLOCK = 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>Root Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.TerminatorBlockImpl <em>Terminator Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.TerminatorBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getTerminatorBlock()
	 * @generated
	 */
	int TERMINATOR_BLOCK = 6;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>Terminator Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATOR_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.AdderBlockImpl <em>Adder Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.AdderBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getAdderBlock()
	 * @generated
	 */
	int ADDER_BLOCK = 7;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>Adder Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDER_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.DiceBlockImpl <em>Dice Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.DiceBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getDiceBlock()
	 * @generated
	 */
	int DICE_BLOCK = 8;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__VALUE = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK__RANGE = BLOCK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dice Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICE_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.LoopBlockImpl <em>Loop Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.LoopBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getLoopBlock()
	 * @generated
	 */
	int LOOP_BLOCK = 9;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__VALUE = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Yes Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__YES_BLOCK = BLOCK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>No Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK__NO_BLOCK = BLOCK_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Loop Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.ForkBlockImpl <em>Fork Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.ForkBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getForkBlock()
	 * @generated
	 */
	int FORK_BLOCK = 10;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>Fork Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MergeBlockImpl <em>Merge Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MergeBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMergeBlock()
	 * @generated
	 */
	int MERGE_BLOCK = 11;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>Merge Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl <em>Logic Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.LogicBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getLogicBlock()
	 * @generated
	 */
	int LOGIC_BLOCK = 12;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__FRAME = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__LOGIC = BLOCK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__INDEX = BLOCK_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__VALUE = BLOCK_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Device</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK__DEVICE = BLOCK_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Logic Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.BranchBlockImpl <em>Branch Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.BranchBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getBranchBlock()
	 * @generated
	 */
	int BRANCH_BLOCK = 13;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__X = LOGIC_BLOCK__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__Y = LOGIC_BLOCK__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__ERROR = LOGIC_BLOCK__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__PLAYING = LOGIC_BLOCK__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__INCOMINGS = LOGIC_BLOCK__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__OUTGOINGS = LOGIC_BLOCK__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__SCRIPT_TYPE = LOGIC_BLOCK__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__SCRIPT_NAME = LOGIC_BLOCK__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__SCRIPT_CODE = LOGIC_BLOCK__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__NEXT_BLOCK = LOGIC_BLOCK__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__PARENT = LOGIC_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__FRAME = LOGIC_BLOCK__FRAME;

	/**
	 * The feature id for the '<em><b>Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__LOGIC = LOGIC_BLOCK__LOGIC;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__INDEX = LOGIC_BLOCK__INDEX;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__VALUE = LOGIC_BLOCK__VALUE;

	/**
	 * The feature id for the '<em><b>Device</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__DEVICE = LOGIC_BLOCK__DEVICE;

	/**
	 * The feature id for the '<em><b>Yes Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__YES_BLOCK = LOGIC_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>No Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK__NO_BLOCK = LOGIC_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Branch Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_BLOCK_FEATURE_COUNT = LOGIC_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.TriggerBlockImpl <em>Trigger Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.TriggerBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getTriggerBlock()
	 * @generated
	 */
	int TRIGGER_BLOCK = 14;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__X = LOGIC_BLOCK__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__Y = LOGIC_BLOCK__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__ERROR = LOGIC_BLOCK__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__PLAYING = LOGIC_BLOCK__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__INCOMINGS = LOGIC_BLOCK__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__OUTGOINGS = LOGIC_BLOCK__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__SCRIPT_TYPE = LOGIC_BLOCK__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__SCRIPT_NAME = LOGIC_BLOCK__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__SCRIPT_CODE = LOGIC_BLOCK__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__NEXT_BLOCK = LOGIC_BLOCK__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__PARENT = LOGIC_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__FRAME = LOGIC_BLOCK__FRAME;

	/**
	 * The feature id for the '<em><b>Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__LOGIC = LOGIC_BLOCK__LOGIC;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__INDEX = LOGIC_BLOCK__INDEX;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__VALUE = LOGIC_BLOCK__VALUE;

	/**
	 * The feature id for the '<em><b>Device</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK__DEVICE = LOGIC_BLOCK__DEVICE;

	/**
	 * The number of structural features of the '<em>Trigger Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_BLOCK_FEATURE_COUNT = LOGIC_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.ClipBlockImpl <em>Clip Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.ClipBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getClipBlock()
	 * @generated
	 */
	int CLIP_BLOCK = 15;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__X = BLOCK_ELEMENT__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__Y = BLOCK_ELEMENT__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__ERROR = BLOCK_ELEMENT__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__PLAYING = BLOCK_ELEMENT__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__INCOMINGS = BLOCK_ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__OUTGOINGS = BLOCK_ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__SCRIPT_TYPE = BLOCK_ELEMENT__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__SCRIPT_NAME = BLOCK_ELEMENT__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__SCRIPT_CODE = BLOCK_ELEMENT__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__NEXT_BLOCK = BLOCK_ELEMENT__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__PARENT = BLOCK_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK__FRAME = BLOCK_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Clip Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_FEATURE_COUNT = BLOCK_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.ClipBlockWithFrameImpl <em>Clip Block With Frame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.ClipBlockWithFrameImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getClipBlockWithFrame()
	 * @generated
	 */
	int CLIP_BLOCK_WITH_FRAME = 16;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__X = CLIP_BLOCK__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__Y = CLIP_BLOCK__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__ERROR = CLIP_BLOCK__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__PLAYING = CLIP_BLOCK__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__INCOMINGS = CLIP_BLOCK__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__OUTGOINGS = CLIP_BLOCK__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__SCRIPT_TYPE = CLIP_BLOCK__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__SCRIPT_NAME = CLIP_BLOCK__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__SCRIPT_CODE = CLIP_BLOCK__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__NEXT_BLOCK = CLIP_BLOCK__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__PARENT = CLIP_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__FRAME = CLIP_BLOCK__FRAME;

	/**
	 * The feature id for the '<em><b>Start Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__START_FRAME = CLIP_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stop Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME__STOP_FRAME = CLIP_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Clip Block With Frame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT = CLIP_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MotionClipBlockImpl <em>Motion Clip Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MotionClipBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionClipBlock()
	 * @generated
	 */
	int MOTION_CLIP_BLOCK = 17;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__X = CLIP_BLOCK_WITH_FRAME__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__Y = CLIP_BLOCK_WITH_FRAME__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__ERROR = CLIP_BLOCK_WITH_FRAME__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__PLAYING = CLIP_BLOCK_WITH_FRAME__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__INCOMINGS = CLIP_BLOCK_WITH_FRAME__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__OUTGOINGS = CLIP_BLOCK_WITH_FRAME__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__SCRIPT_TYPE = CLIP_BLOCK_WITH_FRAME__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__SCRIPT_NAME = CLIP_BLOCK_WITH_FRAME__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__SCRIPT_CODE = CLIP_BLOCK_WITH_FRAME__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__NEXT_BLOCK = CLIP_BLOCK_WITH_FRAME__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__PARENT = CLIP_BLOCK_WITH_FRAME__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__FRAME = CLIP_BLOCK_WITH_FRAME__FRAME;

	/**
	 * The feature id for the '<em><b>Start Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__START_FRAME = CLIP_BLOCK_WITH_FRAME__START_FRAME;

	/**
	 * The feature id for the '<em><b>Stop Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__STOP_FRAME = CLIP_BLOCK_WITH_FRAME__STOP_FRAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__NAME = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Motion Clip</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK__MOTION_CLIP = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Motion Clip Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_BLOCK_FEATURE_COUNT = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MotionClipCloneBlockImpl <em>Motion Clip Clone Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MotionClipCloneBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionClipCloneBlock()
	 * @generated
	 */
	int MOTION_CLIP_CLONE_BLOCK = 18;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__X = CLIP_BLOCK_WITH_FRAME__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__Y = CLIP_BLOCK_WITH_FRAME__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__ERROR = CLIP_BLOCK_WITH_FRAME__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__PLAYING = CLIP_BLOCK_WITH_FRAME__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__INCOMINGS = CLIP_BLOCK_WITH_FRAME__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__OUTGOINGS = CLIP_BLOCK_WITH_FRAME__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__SCRIPT_TYPE = CLIP_BLOCK_WITH_FRAME__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__SCRIPT_NAME = CLIP_BLOCK_WITH_FRAME__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__SCRIPT_CODE = CLIP_BLOCK_WITH_FRAME__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__NEXT_BLOCK = CLIP_BLOCK_WITH_FRAME__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__PARENT = CLIP_BLOCK_WITH_FRAME__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__FRAME = CLIP_BLOCK_WITH_FRAME__FRAME;

	/**
	 * The feature id for the '<em><b>Start Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__START_FRAME = CLIP_BLOCK_WITH_FRAME__START_FRAME;

	/**
	 * The feature id for the '<em><b>Stop Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__STOP_FRAME = CLIP_BLOCK_WITH_FRAME__STOP_FRAME;

	/**
	 * The feature id for the '<em><b>Original</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK__ORIGINAL = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Motion Clip Clone Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_CLONE_BLOCK_FEATURE_COUNT = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MotionContentBlockImpl <em>Motion Content Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MotionContentBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionContentBlock()
	 * @generated
	 */
	int MOTION_CONTENT_BLOCK = 19;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__X = CLIP_BLOCK__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__Y = CLIP_BLOCK__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__ERROR = CLIP_BLOCK__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__PLAYING = CLIP_BLOCK__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__INCOMINGS = CLIP_BLOCK__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__OUTGOINGS = CLIP_BLOCK__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__SCRIPT_TYPE = CLIP_BLOCK__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__SCRIPT_NAME = CLIP_BLOCK__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__SCRIPT_CODE = CLIP_BLOCK__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__NEXT_BLOCK = CLIP_BLOCK__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__PARENT = CLIP_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__FRAME = CLIP_BLOCK__FRAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__NAME = CLIP_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK__CONTENT = CLIP_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Motion Content Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_BLOCK_FEATURE_COUNT = CLIP_BLOCK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.MotionContentCloneBlockImpl <em>Motion Content Clone Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.MotionContentCloneBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionContentCloneBlock()
	 * @generated
	 */
	int MOTION_CONTENT_CLONE_BLOCK = 20;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__X = CLIP_BLOCK__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__Y = CLIP_BLOCK__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__ERROR = CLIP_BLOCK__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__PLAYING = CLIP_BLOCK__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__INCOMINGS = CLIP_BLOCK__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__OUTGOINGS = CLIP_BLOCK__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__SCRIPT_TYPE = CLIP_BLOCK__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__SCRIPT_NAME = CLIP_BLOCK__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__SCRIPT_CODE = CLIP_BLOCK__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__NEXT_BLOCK = CLIP_BLOCK__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__PARENT = CLIP_BLOCK__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__FRAME = CLIP_BLOCK__FRAME;

	/**
	 * The feature id for the '<em><b>Original</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK__ORIGINAL = CLIP_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Motion Content Clone Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CONTENT_CLONE_BLOCK_FEATURE_COUNT = CLIP_BLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.impl.WaitClipBlockImpl <em>Wait Clip Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.WaitClipBlockImpl
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getWaitClipBlock()
	 * @generated
	 */
	int WAIT_CLIP_BLOCK = 21;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__X = CLIP_BLOCK_WITH_FRAME__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__Y = CLIP_BLOCK_WITH_FRAME__Y;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__ERROR = CLIP_BLOCK_WITH_FRAME__ERROR;

	/**
	 * The feature id for the '<em><b>Playing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__PLAYING = CLIP_BLOCK_WITH_FRAME__PLAYING;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__INCOMINGS = CLIP_BLOCK_WITH_FRAME__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__OUTGOINGS = CLIP_BLOCK_WITH_FRAME__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__SCRIPT_TYPE = CLIP_BLOCK_WITH_FRAME__SCRIPT_TYPE;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__SCRIPT_NAME = CLIP_BLOCK_WITH_FRAME__SCRIPT_NAME;

	/**
	 * The feature id for the '<em><b>Script Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__SCRIPT_CODE = CLIP_BLOCK_WITH_FRAME__SCRIPT_CODE;

	/**
	 * The feature id for the '<em><b>Next Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__NEXT_BLOCK = CLIP_BLOCK_WITH_FRAME__NEXT_BLOCK;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__PARENT = CLIP_BLOCK_WITH_FRAME__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__FRAME = CLIP_BLOCK_WITH_FRAME__FRAME;

	/**
	 * The feature id for the '<em><b>Start Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__START_FRAME = CLIP_BLOCK_WITH_FRAME__START_FRAME;

	/**
	 * The feature id for the '<em><b>Stop Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__STOP_FRAME = CLIP_BLOCK_WITH_FRAME__STOP_FRAME;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK__TIMEOUT = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait Clip Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_CLIP_BLOCK_FEATURE_COUNT = CLIP_BLOCK_WITH_FRAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.roboid.core.runtime.IClip <em>IClip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.runtime.IClip
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getIClip()
	 * @generated
	 */
	int ICLIP = 22;

	/**
	 * The number of structural features of the '<em>IClip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICLIP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.ScriptType <em>Script Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.ScriptType
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getScriptType()
	 * @generated
	 */
	int SCRIPT_TYPE = 23;

	/**
	 * The meta object id for the '{@link org.roboid.studio.contentscomposer.LogicType <em>Logic Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.LogicType
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getLogicType()
	 * @generated
	 */
	int LOGIC_TYPE = 24;

	/**
	 * The meta object id for the '<em>Rectangle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 25;

	/**
	 * The meta object id for the '<em>Property Change Listener</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.beans.PropertyChangeListener
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getPropertyChangeListener()
	 * @generated
	 */
	int PROPERTY_CHANGE_LISTENER = 26;

	/**
	 * The meta object id for the '<em>Script Engine</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.script.ScriptEngine
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getScriptEngine()
	 * @generated
	 */
	int SCRIPT_ENGINE = 27;

	/**
	 * The meta object id for the '<em>Shell</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.widgets.Shell
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getShell()
	 * @generated
	 */
	int SHELL = 28;

	/**
	 * The meta object id for the '<em>String Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getStringArray()
	 * @generated
	 */
	int STRING_ARRAY = 29;


	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getURI()
	 * @generated
	 */
	int URI = 30;


	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.ContentsComposerElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.roboid.studio.contentscomposer.ContentsComposerElement
	 * @generated
	 */
	EClass getContentsComposerElement();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MotionContent <em>Motion Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motion Content</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent
	 * @generated
	 */
	EClass getMotionContent();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.MotionContent#getRobot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Robot</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getRobot()
	 * @see #getMotionContent()
	 * @generated
	 */
	EReference getMotionContent_Robot();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.MotionContent#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getActivity()
	 * @see #getMotionContent()
	 * @generated
	 */
	EReference getMotionContent_Activity();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionContent#getScriptEngine <em>Script Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Engine</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getScriptEngine()
	 * @see #getMotionContent()
	 * @generated
	 */
	EAttribute getMotionContent_ScriptEngine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.contentscomposer.MotionContent#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getBlocks()
	 * @see #getMotionContent()
	 * @generated
	 */
	EReference getMotionContent_Blocks();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionContent#isGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grid</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#isGrid()
	 * @see #getMotionContent()
	 * @generated
	 */
	EAttribute getMotionContent_Grid();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionContent#isMinimized <em>Minimized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimized</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#isMinimized()
	 * @see #getMotionContent()
	 * @generated
	 */
	EAttribute getMotionContent_Minimized();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionContent#getTerminatorScriptCode <em>Terminator Script Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminator Script Code</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getTerminatorScriptCode()
	 * @see #getMotionContent()
	 * @generated
	 */
	EAttribute getMotionContent_TerminatorScriptCode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.contentscomposer.MotionContent#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getAssociations()
	 * @see #getMotionContent()
	 * @generated
	 */
	EReference getMotionContent_Associations();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionContent#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContent#getVersion()
	 * @see #getMotionContent()
	 * @generated
	 */
	EAttribute getMotionContent_Version();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MovableElement <em>Movable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movable Element</em>'.
	 * @see org.roboid.studio.contentscomposer.MovableElement
	 * @generated
	 */
	EClass getMovableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MovableElement#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.roboid.studio.contentscomposer.MovableElement#getX()
	 * @see #getMovableElement()
	 * @generated
	 */
	EAttribute getMovableElement_X();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MovableElement#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.roboid.studio.contentscomposer.MovableElement#getY()
	 * @see #getMovableElement()
	 * @generated
	 */
	EAttribute getMovableElement_Y();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see org.roboid.studio.contentscomposer.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.roboid.studio.contentscomposer.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.roboid.studio.contentscomposer.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.Association#getSourceLabel <em>Source Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Label</em>'.
	 * @see org.roboid.studio.contentscomposer.Association#getSourceLabel()
	 * @see #getAssociation()
	 * @generated
	 */
	EAttribute getAssociation_SourceLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.Association#getTargetLabel <em>Target Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Label</em>'.
	 * @see org.roboid.studio.contentscomposer.Association#getTargetLabel()
	 * @see #getAssociation()
	 * @generated
	 */
	EAttribute getAssociation_TargetLabel();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.BlockElement <em>Block Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Element</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement
	 * @generated
	 */
	EClass getBlockElement();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.BlockElement#isError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#isError()
	 * @see #getBlockElement()
	 * @generated
	 */
	EAttribute getBlockElement_Error();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.BlockElement#isPlaying <em>Playing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Playing</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#isPlaying()
	 * @see #getBlockElement()
	 * @generated
	 */
	EAttribute getBlockElement_Playing();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.studio.contentscomposer.BlockElement#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getIncomings()
	 * @see #getBlockElement()
	 * @generated
	 */
	EReference getBlockElement_Incomings();

	/**
	 * Returns the meta object for the reference list '{@link org.roboid.studio.contentscomposer.BlockElement#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getOutgoings()
	 * @see #getBlockElement()
	 * @generated
	 */
	EReference getBlockElement_Outgoings();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.BlockElement#getScriptType <em>Script Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Type</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getScriptType()
	 * @see #getBlockElement()
	 * @generated
	 */
	EAttribute getBlockElement_ScriptType();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.BlockElement#getScriptName <em>Script Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Name</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getScriptName()
	 * @see #getBlockElement()
	 * @generated
	 */
	EAttribute getBlockElement_ScriptName();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.BlockElement#getScriptCode <em>Script Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Code</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getScriptCode()
	 * @see #getBlockElement()
	 * @generated
	 */
	EAttribute getBlockElement_ScriptCode();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.BlockElement#getNextBlock <em>Next Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Block</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getNextBlock()
	 * @see #getBlockElement()
	 * @generated
	 */
	EReference getBlockElement_NextBlock();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.BlockElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.roboid.studio.contentscomposer.BlockElement#getParent()
	 * @see #getBlockElement()
	 * @generated
	 */
	EReference getBlockElement_Parent();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.RootBlock <em>Root Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Block</em>'.
	 * @see org.roboid.studio.contentscomposer.RootBlock
	 * @generated
	 */
	EClass getRootBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.TerminatorBlock <em>Terminator Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminator Block</em>'.
	 * @see org.roboid.studio.contentscomposer.TerminatorBlock
	 * @generated
	 */
	EClass getTerminatorBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.AdderBlock <em>Adder Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adder Block</em>'.
	 * @see org.roboid.studio.contentscomposer.AdderBlock
	 * @generated
	 */
	EClass getAdderBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.DiceBlock <em>Dice Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dice Block</em>'.
	 * @see org.roboid.studio.contentscomposer.DiceBlock
	 * @generated
	 */
	EClass getDiceBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.DiceBlock#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.roboid.studio.contentscomposer.DiceBlock#getValue()
	 * @see #getDiceBlock()
	 * @generated
	 */
	EAttribute getDiceBlock_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.DiceBlock#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.roboid.studio.contentscomposer.DiceBlock#getRange()
	 * @see #getDiceBlock()
	 * @generated
	 */
	EAttribute getDiceBlock_Range();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.LoopBlock <em>Loop Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Block</em>'.
	 * @see org.roboid.studio.contentscomposer.LoopBlock
	 * @generated
	 */
	EClass getLoopBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LoopBlock#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.roboid.studio.contentscomposer.LoopBlock#getValue()
	 * @see #getLoopBlock()
	 * @generated
	 */
	EAttribute getLoopBlock_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LoopBlock#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.roboid.studio.contentscomposer.LoopBlock#getCount()
	 * @see #getLoopBlock()
	 * @generated
	 */
	EAttribute getLoopBlock_Count();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.LoopBlock#getYesBlock <em>Yes Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Yes Block</em>'.
	 * @see org.roboid.studio.contentscomposer.LoopBlock#getYesBlock()
	 * @see #getLoopBlock()
	 * @generated
	 */
	EReference getLoopBlock_YesBlock();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.LoopBlock#getNoBlock <em>No Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>No Block</em>'.
	 * @see org.roboid.studio.contentscomposer.LoopBlock#getNoBlock()
	 * @see #getLoopBlock()
	 * @generated
	 */
	EReference getLoopBlock_NoBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.ForkBlock <em>Fork Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork Block</em>'.
	 * @see org.roboid.studio.contentscomposer.ForkBlock
	 * @generated
	 */
	EClass getForkBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MergeBlock <em>Merge Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merge Block</em>'.
	 * @see org.roboid.studio.contentscomposer.MergeBlock
	 * @generated
	 */
	EClass getMergeBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.LogicBlock <em>Logic Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logic Block</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicBlock
	 * @generated
	 */
	EClass getLogicBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LogicBlock#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicBlock#getFrame()
	 * @see #getLogicBlock()
	 * @generated
	 */
	EAttribute getLogicBlock_Frame();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LogicBlock#getLogic <em>Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicBlock#getLogic()
	 * @see #getLogicBlock()
	 * @generated
	 */
	EAttribute getLogicBlock_Logic();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LogicBlock#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicBlock#getIndex()
	 * @see #getLogicBlock()
	 * @generated
	 */
	EAttribute getLogicBlock_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LogicBlock#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicBlock#getValue()
	 * @see #getLogicBlock()
	 * @generated
	 */
	EAttribute getLogicBlock_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.LogicBlock#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicBlock#getDevice()
	 * @see #getLogicBlock()
	 * @generated
	 */
	EAttribute getLogicBlock_Device();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.BranchBlock <em>Branch Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Block</em>'.
	 * @see org.roboid.studio.contentscomposer.BranchBlock
	 * @generated
	 */
	EClass getBranchBlock();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.BranchBlock#getYesBlock <em>Yes Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Yes Block</em>'.
	 * @see org.roboid.studio.contentscomposer.BranchBlock#getYesBlock()
	 * @see #getBranchBlock()
	 * @generated
	 */
	EReference getBranchBlock_YesBlock();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.BranchBlock#getNoBlock <em>No Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>No Block</em>'.
	 * @see org.roboid.studio.contentscomposer.BranchBlock#getNoBlock()
	 * @see #getBranchBlock()
	 * @generated
	 */
	EReference getBranchBlock_NoBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.TriggerBlock <em>Trigger Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger Block</em>'.
	 * @see org.roboid.studio.contentscomposer.TriggerBlock
	 * @generated
	 */
	EClass getTriggerBlock();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.ClipBlock <em>Clip Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clip Block</em>'.
	 * @see org.roboid.studio.contentscomposer.ClipBlock
	 * @generated
	 */
	EClass getClipBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.ClipBlock#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame</em>'.
	 * @see org.roboid.studio.contentscomposer.ClipBlock#getFrame()
	 * @see #getClipBlock()
	 * @generated
	 */
	EAttribute getClipBlock_Frame();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame <em>Clip Block With Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clip Block With Frame</em>'.
	 * @see org.roboid.studio.contentscomposer.ClipBlockWithFrame
	 * @generated
	 */
	EClass getClipBlockWithFrame();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStartFrame <em>Start Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Frame</em>'.
	 * @see org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStartFrame()
	 * @see #getClipBlockWithFrame()
	 * @generated
	 */
	EAttribute getClipBlockWithFrame_StartFrame();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStopFrame <em>Stop Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Frame</em>'.
	 * @see org.roboid.studio.contentscomposer.ClipBlockWithFrame#getStopFrame()
	 * @see #getClipBlockWithFrame()
	 * @generated
	 */
	EAttribute getClipBlockWithFrame_StopFrame();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MotionClipBlock <em>Motion Clip Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motion Clip Block</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionClipBlock
	 * @generated
	 */
	EClass getMotionClipBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionClipBlock#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionClipBlock#getName()
	 * @see #getMotionClipBlock()
	 * @generated
	 */
	EAttribute getMotionClipBlock_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.roboid.studio.contentscomposer.MotionClipBlock#getMotionClip <em>Motion Clip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Motion Clip</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionClipBlock#getMotionClip()
	 * @see #getMotionClipBlock()
	 * @generated
	 */
	EReference getMotionClipBlock_MotionClip();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MotionClipCloneBlock <em>Motion Clip Clone Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motion Clip Clone Block</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionClipCloneBlock
	 * @generated
	 */
	EClass getMotionClipCloneBlock();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.MotionClipCloneBlock#getOriginal <em>Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionClipCloneBlock#getOriginal()
	 * @see #getMotionClipCloneBlock()
	 * @generated
	 */
	EReference getMotionClipCloneBlock_Original();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MotionContentBlock <em>Motion Content Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motion Content Block</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContentBlock
	 * @generated
	 */
	EClass getMotionContentBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.MotionContentBlock#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContentBlock#getName()
	 * @see #getMotionContentBlock()
	 * @generated
	 */
	EAttribute getMotionContentBlock_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.roboid.studio.contentscomposer.MotionContentBlock#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContentBlock#getContent()
	 * @see #getMotionContentBlock()
	 * @generated
	 */
	EReference getMotionContentBlock_Content();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.MotionContentCloneBlock <em>Motion Content Clone Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motion Content Clone Block</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContentCloneBlock
	 * @generated
	 */
	EClass getMotionContentCloneBlock();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.contentscomposer.MotionContentCloneBlock#getOriginal <em>Original</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original</em>'.
	 * @see org.roboid.studio.contentscomposer.MotionContentCloneBlock#getOriginal()
	 * @see #getMotionContentCloneBlock()
	 * @generated
	 */
	EReference getMotionContentCloneBlock_Original();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.contentscomposer.WaitClipBlock <em>Wait Clip Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Clip Block</em>'.
	 * @see org.roboid.studio.contentscomposer.WaitClipBlock
	 * @generated
	 */
	EClass getWaitClipBlock();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.contentscomposer.WaitClipBlock#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see org.roboid.studio.contentscomposer.WaitClipBlock#getTimeout()
	 * @see #getWaitClipBlock()
	 * @generated
	 */
	EAttribute getWaitClipBlock_Timeout();

	/**
	 * Returns the meta object for class '{@link org.roboid.core.runtime.IClip <em>IClip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IClip</em>'.
	 * @see org.roboid.core.runtime.IClip
	 * @model instanceClass="org.roboid.core.runtime.IClip"
	 * @generated
	 */
	EClass getIClip();

	/**
	 * Returns the meta object for enum '{@link org.roboid.studio.contentscomposer.ScriptType <em>Script Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Script Type</em>'.
	 * @see org.roboid.studio.contentscomposer.ScriptType
	 * @generated
	 */
	EEnum getScriptType();

	/**
	 * Returns the meta object for enum '{@link org.roboid.studio.contentscomposer.LogicType <em>Logic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logic Type</em>'.
	 * @see org.roboid.studio.contentscomposer.LogicType
	 * @generated
	 */
	EEnum getLogicType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rectangle</em>'.
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @model instanceClass="org.eclipse.draw2d.geometry.Rectangle"
	 * @generated
	 */
	EDataType getRectangle();

	/**
	 * Returns the meta object for data type '{@link java.beans.PropertyChangeListener <em>Property Change Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Property Change Listener</em>'.
	 * @see java.beans.PropertyChangeListener
	 * @model instanceClass="java.beans.PropertyChangeListener"
	 * @generated
	 */
	EDataType getPropertyChangeListener();

	/**
	 * Returns the meta object for data type '{@link javax.script.ScriptEngine <em>Script Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Script Engine</em>'.
	 * @see javax.script.ScriptEngine
	 * @model instanceClass="javax.script.ScriptEngine"
	 * @generated
	 */
	EDataType getScriptEngine();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Shell <em>Shell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Shell</em>'.
	 * @see org.eclipse.swt.widgets.Shell
	 * @model instanceClass="org.eclipse.swt.widgets.Shell"
	 * @generated
	 */
	EDataType getShell();

	/**
	 * Returns the meta object for data type '<em>String Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Array</em>'.
	 * @model instanceClass="java.lang.String[]"
	 * @generated
	 */
	EDataType getStringArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContentsComposerFactory getContentsComposerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.ContentsComposerElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerElementImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getContentsComposerElement()
		 * @generated
		 */
		EClass CONTENTS_COMPOSER_ELEMENT = eINSTANCE.getContentsComposerElement();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MotionContentImpl <em>Motion Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MotionContentImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionContent()
		 * @generated
		 */
		EClass MOTION_CONTENT = eINSTANCE.getMotionContent();

		/**
		 * The meta object literal for the '<em><b>Robot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CONTENT__ROBOT = eINSTANCE.getMotionContent_Robot();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CONTENT__ACTIVITY = eINSTANCE.getMotionContent_Activity();

		/**
		 * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CONTENT__SCRIPT_ENGINE = eINSTANCE.getMotionContent_ScriptEngine();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CONTENT__BLOCKS = eINSTANCE.getMotionContent_Blocks();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CONTENT__GRID = eINSTANCE.getMotionContent_Grid();

		/**
		 * The meta object literal for the '<em><b>Minimized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CONTENT__MINIMIZED = eINSTANCE.getMotionContent_Minimized();

		/**
		 * The meta object literal for the '<em><b>Terminator Script Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CONTENT__TERMINATOR_SCRIPT_CODE = eINSTANCE.getMotionContent_TerminatorScriptCode();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CONTENT__ASSOCIATIONS = eINSTANCE.getMotionContent_Associations();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CONTENT__VERSION = eINSTANCE.getMotionContent_Version();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MovableElementImpl <em>Movable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MovableElementImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMovableElement()
		 * @generated
		 */
		EClass MOVABLE_ELEMENT = eINSTANCE.getMovableElement();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVABLE_ELEMENT__X = eINSTANCE.getMovableElement_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVABLE_ELEMENT__Y = eINSTANCE.getMovableElement_Y();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.AssociationImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '<em><b>Source Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION__SOURCE_LABEL = eINSTANCE.getAssociation_SourceLabel();

		/**
		 * The meta object literal for the '<em><b>Target Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION__TARGET_LABEL = eINSTANCE.getAssociation_TargetLabel();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.BlockElementImpl <em>Block Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.BlockElementImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getBlockElement()
		 * @generated
		 */
		EClass BLOCK_ELEMENT = eINSTANCE.getBlockElement();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_ELEMENT__ERROR = eINSTANCE.getBlockElement_Error();

		/**
		 * The meta object literal for the '<em><b>Playing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_ELEMENT__PLAYING = eINSTANCE.getBlockElement_Playing();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ELEMENT__INCOMINGS = eINSTANCE.getBlockElement_Incomings();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ELEMENT__OUTGOINGS = eINSTANCE.getBlockElement_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Script Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_ELEMENT__SCRIPT_TYPE = eINSTANCE.getBlockElement_ScriptType();

		/**
		 * The meta object literal for the '<em><b>Script Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_ELEMENT__SCRIPT_NAME = eINSTANCE.getBlockElement_ScriptName();

		/**
		 * The meta object literal for the '<em><b>Script Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_ELEMENT__SCRIPT_CODE = eINSTANCE.getBlockElement_ScriptCode();

		/**
		 * The meta object literal for the '<em><b>Next Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ELEMENT__NEXT_BLOCK = eINSTANCE.getBlockElement_NextBlock();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ELEMENT__PARENT = eINSTANCE.getBlockElement_Parent();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.RootBlockImpl <em>Root Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.RootBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getRootBlock()
		 * @generated
		 */
		EClass ROOT_BLOCK = eINSTANCE.getRootBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.TerminatorBlockImpl <em>Terminator Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.TerminatorBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getTerminatorBlock()
		 * @generated
		 */
		EClass TERMINATOR_BLOCK = eINSTANCE.getTerminatorBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.AdderBlockImpl <em>Adder Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.AdderBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getAdderBlock()
		 * @generated
		 */
		EClass ADDER_BLOCK = eINSTANCE.getAdderBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.DiceBlockImpl <em>Dice Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.DiceBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getDiceBlock()
		 * @generated
		 */
		EClass DICE_BLOCK = eINSTANCE.getDiceBlock();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DICE_BLOCK__VALUE = eINSTANCE.getDiceBlock_Value();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DICE_BLOCK__RANGE = eINSTANCE.getDiceBlock_Range();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.LoopBlockImpl <em>Loop Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.LoopBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getLoopBlock()
		 * @generated
		 */
		EClass LOOP_BLOCK = eINSTANCE.getLoopBlock();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_BLOCK__VALUE = eINSTANCE.getLoopBlock_Value();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_BLOCK__COUNT = eINSTANCE.getLoopBlock_Count();

		/**
		 * The meta object literal for the '<em><b>Yes Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_BLOCK__YES_BLOCK = eINSTANCE.getLoopBlock_YesBlock();

		/**
		 * The meta object literal for the '<em><b>No Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_BLOCK__NO_BLOCK = eINSTANCE.getLoopBlock_NoBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.ForkBlockImpl <em>Fork Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.ForkBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getForkBlock()
		 * @generated
		 */
		EClass FORK_BLOCK = eINSTANCE.getForkBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MergeBlockImpl <em>Merge Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MergeBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMergeBlock()
		 * @generated
		 */
		EClass MERGE_BLOCK = eINSTANCE.getMergeBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.LogicBlockImpl <em>Logic Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.LogicBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getLogicBlock()
		 * @generated
		 */
		EClass LOGIC_BLOCK = eINSTANCE.getLogicBlock();

		/**
		 * The meta object literal for the '<em><b>Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_BLOCK__FRAME = eINSTANCE.getLogicBlock_Frame();

		/**
		 * The meta object literal for the '<em><b>Logic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_BLOCK__LOGIC = eINSTANCE.getLogicBlock_Logic();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_BLOCK__INDEX = eINSTANCE.getLogicBlock_Index();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_BLOCK__VALUE = eINSTANCE.getLogicBlock_Value();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_BLOCK__DEVICE = eINSTANCE.getLogicBlock_Device();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.BranchBlockImpl <em>Branch Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.BranchBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getBranchBlock()
		 * @generated
		 */
		EClass BRANCH_BLOCK = eINSTANCE.getBranchBlock();

		/**
		 * The meta object literal for the '<em><b>Yes Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_BLOCK__YES_BLOCK = eINSTANCE.getBranchBlock_YesBlock();

		/**
		 * The meta object literal for the '<em><b>No Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_BLOCK__NO_BLOCK = eINSTANCE.getBranchBlock_NoBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.TriggerBlockImpl <em>Trigger Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.TriggerBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getTriggerBlock()
		 * @generated
		 */
		EClass TRIGGER_BLOCK = eINSTANCE.getTriggerBlock();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.ClipBlockImpl <em>Clip Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.ClipBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getClipBlock()
		 * @generated
		 */
		EClass CLIP_BLOCK = eINSTANCE.getClipBlock();

		/**
		 * The meta object literal for the '<em><b>Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIP_BLOCK__FRAME = eINSTANCE.getClipBlock_Frame();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.ClipBlockWithFrameImpl <em>Clip Block With Frame</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.ClipBlockWithFrameImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getClipBlockWithFrame()
		 * @generated
		 */
		EClass CLIP_BLOCK_WITH_FRAME = eINSTANCE.getClipBlockWithFrame();

		/**
		 * The meta object literal for the '<em><b>Start Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIP_BLOCK_WITH_FRAME__START_FRAME = eINSTANCE.getClipBlockWithFrame_StartFrame();

		/**
		 * The meta object literal for the '<em><b>Stop Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIP_BLOCK_WITH_FRAME__STOP_FRAME = eINSTANCE.getClipBlockWithFrame_StopFrame();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MotionClipBlockImpl <em>Motion Clip Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MotionClipBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionClipBlock()
		 * @generated
		 */
		EClass MOTION_CLIP_BLOCK = eINSTANCE.getMotionClipBlock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CLIP_BLOCK__NAME = eINSTANCE.getMotionClipBlock_Name();

		/**
		 * The meta object literal for the '<em><b>Motion Clip</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CLIP_BLOCK__MOTION_CLIP = eINSTANCE.getMotionClipBlock_MotionClip();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MotionClipCloneBlockImpl <em>Motion Clip Clone Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MotionClipCloneBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionClipCloneBlock()
		 * @generated
		 */
		EClass MOTION_CLIP_CLONE_BLOCK = eINSTANCE.getMotionClipCloneBlock();

		/**
		 * The meta object literal for the '<em><b>Original</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CLIP_CLONE_BLOCK__ORIGINAL = eINSTANCE.getMotionClipCloneBlock_Original();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MotionContentBlockImpl <em>Motion Content Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MotionContentBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionContentBlock()
		 * @generated
		 */
		EClass MOTION_CONTENT_BLOCK = eINSTANCE.getMotionContentBlock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CONTENT_BLOCK__NAME = eINSTANCE.getMotionContentBlock_Name();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CONTENT_BLOCK__CONTENT = eINSTANCE.getMotionContentBlock_Content();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.MotionContentCloneBlockImpl <em>Motion Content Clone Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.MotionContentCloneBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getMotionContentCloneBlock()
		 * @generated
		 */
		EClass MOTION_CONTENT_CLONE_BLOCK = eINSTANCE.getMotionContentCloneBlock();

		/**
		 * The meta object literal for the '<em><b>Original</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CONTENT_CLONE_BLOCK__ORIGINAL = eINSTANCE.getMotionContentCloneBlock_Original();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.impl.WaitClipBlockImpl <em>Wait Clip Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.WaitClipBlockImpl
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getWaitClipBlock()
		 * @generated
		 */
		EClass WAIT_CLIP_BLOCK = eINSTANCE.getWaitClipBlock();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WAIT_CLIP_BLOCK__TIMEOUT = eINSTANCE.getWaitClipBlock_Timeout();

		/**
		 * The meta object literal for the '{@link org.roboid.core.runtime.IClip <em>IClip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.runtime.IClip
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getIClip()
		 * @generated
		 */
		EClass ICLIP = eINSTANCE.getIClip();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.ScriptType <em>Script Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.ScriptType
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getScriptType()
		 * @generated
		 */
		EEnum SCRIPT_TYPE = eINSTANCE.getScriptType();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.contentscomposer.LogicType <em>Logic Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.LogicType
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getLogicType()
		 * @generated
		 */
		EEnum LOGIC_TYPE = eINSTANCE.getLogicType();

		/**
		 * The meta object literal for the '<em>Rectangle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Rectangle
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getRectangle()
		 * @generated
		 */
		EDataType RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em>Property Change Listener</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.beans.PropertyChangeListener
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getPropertyChangeListener()
		 * @generated
		 */
		EDataType PROPERTY_CHANGE_LISTENER = eINSTANCE.getPropertyChangeListener();

		/**
		 * The meta object literal for the '<em>Script Engine</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.script.ScriptEngine
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getScriptEngine()
		 * @generated
		 */
		EDataType SCRIPT_ENGINE = eINSTANCE.getScriptEngine();

		/**
		 * The meta object literal for the '<em>Shell</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.widgets.Shell
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getShell()
		 * @generated
		 */
		EDataType SHELL = eINSTANCE.getShell();

		/**
		 * The meta object literal for the '<em>String Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getStringArray()
		 * @generated
		 */
		EDataType STRING_ARRAY = eINSTANCE.getStringArray();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.roboid.studio.contentscomposer.impl.ContentsComposerPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //ContentsComposerPackage
