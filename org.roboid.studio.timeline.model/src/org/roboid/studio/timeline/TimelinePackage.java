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

package org.roboid.studio.timeline;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.roboid.studio.timeline.TimelineFactory
 * @model kind="package"
 * @generated
 */
public interface TimelinePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "timeline";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.roboidstudio.org/model/timeline";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.roboid.studio.timeline";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimelinePackage eINSTANCE = org.roboid.studio.timeline.impl.TimelinePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.TimelineElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.TimelineElementImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getTimelineElement()
	 * @generated
	 */
	int TIMELINE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMELINE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.MotionClipImpl <em>Motion Clip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.MotionClipImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMotionClip()
	 * @generated
	 */
	int MOTION_CLIP = 1;

	/**
	 * The feature id for the '<em><b>Robot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP__ROBOT = TIMELINE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP__ACTIVITY = TIMELINE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP__CONTROLS = TIMELINE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP__VERSION = TIMELINE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Frame Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP__FRAME_LIMIT = TIMELINE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Motion Clip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTION_CLIP_FEATURE_COUNT = TIMELINE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.MovableElementImpl <em>Movable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.MovableElementImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMovableElement()
	 * @generated
	 */
	int MOVABLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVABLE_ELEMENT__CONSTRAINT = TIMELINE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVABLE_ELEMENT__PARENT = TIMELINE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Movable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVABLE_ELEMENT_FEATURE_COUNT = TIMELINE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.ControlTrackImpl <em>Control Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.ControlTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getControlTrack()
	 * @generated
	 */
	int CONTROL_TRACK = 3;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TRACK__CONSTRAINT = MOVABLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TRACK__PARENT = MOVABLE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TRACK__CHANNELS = MOVABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TRACK__CONTROL = MOVABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Control Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TRACK_FEATURE_COUNT = MOVABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.ChannelTrackImpl <em>Channel Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.ChannelTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getChannelTrack()
	 * @generated
	 */
	int CHANNEL_TRACK = 4;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.LinearTrackImpl <em>Linear Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.LinearTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getLinearTrack()
	 * @generated
	 */
	int LINEAR_TRACK = 5;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.CommandTrackImpl <em>Command Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.CommandTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getCommandTrack()
	 * @generated
	 */
	int COMMAND_TRACK = 6;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.AudioTrackImpl <em>Audio Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.AudioTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioTrack()
	 * @generated
	 */
	int AUDIO_TRACK = 7;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.VoiceTrackImpl <em>Voice Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.VoiceTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getVoiceTrack()
	 * @generated
	 */
	int VOICE_TRACK = 8;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.ColorTrackImpl <em>Color Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.ColorTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getColorTrack()
	 * @generated
	 */
	int COLOR_TRACK = 9;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.TextTrackImpl <em>Text Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.TextTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getTextTrack()
	 * @generated
	 */
	int TEXT_TRACK = 10;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.MatrixTrackImpl <em>Matrix Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.MatrixTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMatrixTrack()
	 * @generated
	 */
	int MATRIX_TRACK = 11;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.FileTrackImpl <em>File Track</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.FileTrackImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getFileTrack()
	 * @generated
	 */
	int FILE_TRACK = 12;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.ControlPointImpl <em>Control Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.ControlPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getControlPoint()
	 * @generated
	 */
	int CONTROL_POINT = 13;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.LinearPointImpl <em>Linear Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.LinearPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getLinearPoint()
	 * @generated
	 */
	int LINEAR_POINT = 14;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.CommandPointImpl <em>Command Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.CommandPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getCommandPoint()
	 * @generated
	 */
	int COMMAND_POINT = 15;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.AudioPointImpl <em>Audio Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.AudioPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioPoint()
	 * @generated
	 */
	int AUDIO_POINT = 16;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.VoicePointImpl <em>Voice Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.VoicePointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getVoicePoint()
	 * @generated
	 */
	int VOICE_POINT = 17;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.ColorPointImpl <em>Color Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.ColorPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getColorPoint()
	 * @generated
	 */
	int COLOR_POINT = 18;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.TextPointImpl <em>Text Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.TextPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getTextPoint()
	 * @generated
	 */
	int TEXT_POINT = 19;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.MatrixPointImpl <em>Matrix Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.MatrixPointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMatrixPoint()
	 * @generated
	 */
	int MATRIX_POINT = 20;

	/**
	 * The meta object id for the '{@link org.roboid.studio.timeline.impl.FilePointImpl <em>File Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.FilePointImpl
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getFilePoint()
	 * @generated
	 */
	int FILE_POINT = 21;

	/**
	 * The meta object id for the '{@link org.roboid.core.runtime.IClip <em>IClip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.core.runtime.IClip
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getIClip()
	 * @generated
	 */
	int ICLIP = 22;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_TRACK__CONSTRAINT = MOVABLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_TRACK__PARENT = MOVABLE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_TRACK__POINTS = MOVABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_TRACK__CHANNEL = MOVABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Channel Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_TRACK_FEATURE_COUNT = MOVABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_TRACK__CONSTRAINT = CHANNEL_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_TRACK__PARENT = CHANNEL_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_TRACK__POINTS = CHANNEL_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_TRACK__CHANNEL = CHANNEL_TRACK__CHANNEL;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_TRACK__MODE = CHANNEL_TRACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linear Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_TRACK_FEATURE_COUNT = CHANNEL_TRACK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRACK__CONSTRAINT = CHANNEL_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRACK__PARENT = CHANNEL_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRACK__POINTS = CHANNEL_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRACK__CHANNEL = CHANNEL_TRACK__CHANNEL;

	/**
	 * The number of structural features of the '<em>Command Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRACK_FEATURE_COUNT = CHANNEL_TRACK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_TRACK__CONSTRAINT = CHANNEL_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_TRACK__PARENT = CHANNEL_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_TRACK__POINTS = CHANNEL_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_TRACK__CHANNEL = CHANNEL_TRACK__CHANNEL;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_TRACK__MODE = CHANNEL_TRACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Audio Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_TRACK_FEATURE_COUNT = CHANNEL_TRACK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_TRACK__CONSTRAINT = AUDIO_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_TRACK__PARENT = AUDIO_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_TRACK__POINTS = AUDIO_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_TRACK__CHANNEL = AUDIO_TRACK__CHANNEL;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_TRACK__MODE = AUDIO_TRACK__MODE;

	/**
	 * The number of structural features of the '<em>Voice Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_TRACK_FEATURE_COUNT = AUDIO_TRACK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_TRACK__CONSTRAINT = CHANNEL_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_TRACK__PARENT = CHANNEL_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_TRACK__POINTS = CHANNEL_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_TRACK__CHANNEL = CHANNEL_TRACK__CHANNEL;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_TRACK__MODE = CHANNEL_TRACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Color Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_TRACK_FEATURE_COUNT = CHANNEL_TRACK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_TRACK__CONSTRAINT = CHANNEL_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_TRACK__PARENT = CHANNEL_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_TRACK__POINTS = CHANNEL_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_TRACK__CHANNEL = CHANNEL_TRACK__CHANNEL;

	/**
	 * The number of structural features of the '<em>Text Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_TRACK_FEATURE_COUNT = CHANNEL_TRACK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_TRACK__CONSTRAINT = LINEAR_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_TRACK__PARENT = LINEAR_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_TRACK__POINTS = LINEAR_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_TRACK__CHANNEL = LINEAR_TRACK__CHANNEL;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_TRACK__MODE = LINEAR_TRACK__MODE;

	/**
	 * The number of structural features of the '<em>Matrix Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_TRACK_FEATURE_COUNT = LINEAR_TRACK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TRACK__CONSTRAINT = CHANNEL_TRACK__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TRACK__PARENT = CHANNEL_TRACK__PARENT;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TRACK__POINTS = CHANNEL_TRACK__POINTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TRACK__CHANNEL = CHANNEL_TRACK__CHANNEL;

	/**
	 * The number of structural features of the '<em>File Track</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TRACK_FEATURE_COUNT = CHANNEL_TRACK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_POINT__CONSTRAINT = MOVABLE_ELEMENT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_POINT__PARENT = MOVABLE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_POINT__FRAME = MOVABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_POINT_FEATURE_COUNT = MOVABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_POINT__CONSTRAINT = CONTROL_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_POINT__PARENT = CONTROL_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_POINT__FRAME = CONTROL_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_POINT__VALUES = CONTROL_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_POINT__MODE = CONTROL_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Linear Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_POINT_FEATURE_COUNT = CONTROL_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_POINT__CONSTRAINT = CONTROL_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_POINT__PARENT = CONTROL_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_POINT__FRAME = CONTROL_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_POINT__VALUES = CONTROL_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Command Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_POINT_FEATURE_COUNT = CONTROL_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__CONSTRAINT = CONTROL_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__PARENT = CONTROL_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__FRAME = CONTROL_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Mp3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__MP3 = CONTROL_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__LENGTH = CONTROL_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__TEXT = CONTROL_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Voice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__VOICE_ID = CONTROL_POINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Language Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__LANGUAGE_ID = CONTROL_POINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Voice Effect Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__VOICE_EFFECT_ID = CONTROL_POINT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Speech Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__SPEECH_RATE = CONTROL_POINT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__VOLUME = CONTROL_POINT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__PITCH = CONTROL_POINT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__BALANCE = CONTROL_POINT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__ENCODING = CONTROL_POINT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Sample Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__SAMPLE_RATE = CONTROL_POINT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Sample Size In Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__SAMPLE_SIZE_IN_BITS = CONTROL_POINT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__CHANNELS = CONTROL_POINT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Frame Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__FRAME_SIZE = CONTROL_POINT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Frame Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__FRAME_RATE = CONTROL_POINT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Big Endian</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__BIG_ENDIAN = CONTROL_POINT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__MODE = CONTROL_POINT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__FORMAT = CONTROL_POINT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Pcm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__PCM = CONTROL_POINT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT__MODIFIED = CONTROL_POINT_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Audio Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_POINT_FEATURE_COUNT = CONTROL_POINT_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__CONSTRAINT = AUDIO_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__PARENT = AUDIO_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__FRAME = AUDIO_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Mp3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__MP3 = AUDIO_POINT__MP3;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__LENGTH = AUDIO_POINT__LENGTH;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__TEXT = AUDIO_POINT__TEXT;

	/**
	 * The feature id for the '<em><b>Voice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__VOICE_ID = AUDIO_POINT__VOICE_ID;

	/**
	 * The feature id for the '<em><b>Language Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__LANGUAGE_ID = AUDIO_POINT__LANGUAGE_ID;

	/**
	 * The feature id for the '<em><b>Voice Effect Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__VOICE_EFFECT_ID = AUDIO_POINT__VOICE_EFFECT_ID;

	/**
	 * The feature id for the '<em><b>Speech Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__SPEECH_RATE = AUDIO_POINT__SPEECH_RATE;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__VOLUME = AUDIO_POINT__VOLUME;

	/**
	 * The feature id for the '<em><b>Pitch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__PITCH = AUDIO_POINT__PITCH;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__BALANCE = AUDIO_POINT__BALANCE;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__ENCODING = AUDIO_POINT__ENCODING;

	/**
	 * The feature id for the '<em><b>Sample Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__SAMPLE_RATE = AUDIO_POINT__SAMPLE_RATE;

	/**
	 * The feature id for the '<em><b>Sample Size In Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__SAMPLE_SIZE_IN_BITS = AUDIO_POINT__SAMPLE_SIZE_IN_BITS;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__CHANNELS = AUDIO_POINT__CHANNELS;

	/**
	 * The feature id for the '<em><b>Frame Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__FRAME_SIZE = AUDIO_POINT__FRAME_SIZE;

	/**
	 * The feature id for the '<em><b>Frame Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__FRAME_RATE = AUDIO_POINT__FRAME_RATE;

	/**
	 * The feature id for the '<em><b>Big Endian</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__BIG_ENDIAN = AUDIO_POINT__BIG_ENDIAN;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__MODE = AUDIO_POINT__MODE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__FORMAT = AUDIO_POINT__FORMAT;

	/**
	 * The feature id for the '<em><b>Pcm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__PCM = AUDIO_POINT__PCM;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__MODIFIED = AUDIO_POINT__MODIFIED;

	/**
	 * The feature id for the '<em><b>Lip Gain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT__LIP_GAIN = AUDIO_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Voice Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_POINT_FEATURE_COUNT = AUDIO_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_POINT__CONSTRAINT = CONTROL_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_POINT__PARENT = CONTROL_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_POINT__FRAME = CONTROL_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_POINT__MODE = CONTROL_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_POINT__COLOR = CONTROL_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Color Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_POINT_FEATURE_COUNT = CONTROL_POINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POINT__CONSTRAINT = CONTROL_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POINT__PARENT = CONTROL_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POINT__FRAME = CONTROL_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POINT__TEXT = CONTROL_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POINT_FEATURE_COUNT = CONTROL_POINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_POINT__CONSTRAINT = LINEAR_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_POINT__PARENT = LINEAR_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_POINT__FRAME = LINEAR_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_POINT__VALUES = LINEAR_POINT__VALUES;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_POINT__MODE = LINEAR_POINT__MODE;

	/**
	 * The number of structural features of the '<em>Matrix Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATRIX_POINT_FEATURE_COUNT = LINEAR_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_POINT__CONSTRAINT = CONTROL_POINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_POINT__PARENT = CONTROL_POINT__PARENT;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_POINT__FRAME = CONTROL_POINT__FRAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_POINT__FILE_NAME = CONTROL_POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_POINT_FEATURE_COUNT = CONTROL_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IClip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICLIP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Rectangle</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Rectangle
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 23;

	/**
	 * The meta object id for the '<em>RGB</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.RGB
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getRGB()
	 * @generated
	 */
	int RGB = 24;

	/**
	 * The meta object id for the '<em>Audio Format</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.sound.sampled.AudioFormat
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioFormat()
	 * @generated
	 */
	int AUDIO_FORMAT = 25;

	/**
	 * The meta object id for the '<em>Audio Input Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.sound.sampled.AudioInputStream
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioInputStream()
	 * @generated
	 */
	int AUDIO_INPUT_STREAM = 26;

	/**
	 * The meta object id for the '<em>Unsupported Audio File Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.sound.sampled.UnsupportedAudioFileException
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getUnsupportedAudioFileException()
	 * @generated
	 */
	int UNSUPPORTED_AUDIO_FILE_EXCEPTION = 27;

	/**
	 * The meta object id for the '<em>IO Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.IOException
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getIOException()
	 * @generated
	 */
	int IO_EXCEPTION = 28;

	/**
	 * The meta object id for the '<em>Float Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getFloatArray()
	 * @generated
	 */
	int FLOAT_ARRAY = 29;


	/**
	 * The meta object id for the '<em>Property Change Listener</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.beans.PropertyChangeListener
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getPropertyChangeListener()
	 * @generated
	 */
	int PROPERTY_CHANGE_LISTENER = 30;


	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getURI()
	 * @generated
	 */
	int URI = 31;


	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.TimelineElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.roboid.studio.timeline.TimelineElement
	 * @generated
	 */
	EClass getTimelineElement();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.MotionClip <em>Motion Clip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motion Clip</em>'.
	 * @see org.roboid.studio.timeline.MotionClip
	 * @generated
	 */
	EClass getMotionClip();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.timeline.MotionClip#getRobot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Robot</em>'.
	 * @see org.roboid.studio.timeline.MotionClip#getRobot()
	 * @see #getMotionClip()
	 * @generated
	 */
	EReference getMotionClip_Robot();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.timeline.MotionClip#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see org.roboid.studio.timeline.MotionClip#getActivity()
	 * @see #getMotionClip()
	 * @generated
	 */
	EReference getMotionClip_Activity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.timeline.MotionClip#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.roboid.studio.timeline.MotionClip#getControls()
	 * @see #getMotionClip()
	 * @generated
	 */
	EReference getMotionClip_Controls();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.MotionClip#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.roboid.studio.timeline.MotionClip#getVersion()
	 * @see #getMotionClip()
	 * @generated
	 */
	EAttribute getMotionClip_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.MotionClip#getFrameLimit <em>Frame Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Limit</em>'.
	 * @see org.roboid.studio.timeline.MotionClip#getFrameLimit()
	 * @see #getMotionClip()
	 * @generated
	 */
	EAttribute getMotionClip_FrameLimit();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.MovableElement <em>Movable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movable Element</em>'.
	 * @see org.roboid.studio.timeline.MovableElement
	 * @generated
	 */
	EClass getMovableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.MovableElement#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see org.roboid.studio.timeline.MovableElement#getConstraint()
	 * @see #getMovableElement()
	 * @generated
	 */
	EAttribute getMovableElement_Constraint();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.timeline.MovableElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.roboid.studio.timeline.MovableElement#getParent()
	 * @see #getMovableElement()
	 * @generated
	 */
	EReference getMovableElement_Parent();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.ControlTrack <em>Control Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Track</em>'.
	 * @see org.roboid.studio.timeline.ControlTrack
	 * @generated
	 */
	EClass getControlTrack();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.timeline.ControlTrack#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channels</em>'.
	 * @see org.roboid.studio.timeline.ControlTrack#getChannels()
	 * @see #getControlTrack()
	 * @generated
	 */
	EReference getControlTrack_Channels();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.timeline.ControlTrack#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.roboid.studio.timeline.ControlTrack#getControl()
	 * @see #getControlTrack()
	 * @generated
	 */
	EReference getControlTrack_Control();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.ChannelTrack <em>Channel Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Track</em>'.
	 * @see org.roboid.studio.timeline.ChannelTrack
	 * @generated
	 */
	EClass getChannelTrack();

	/**
	 * Returns the meta object for the containment reference list '{@link org.roboid.studio.timeline.ChannelTrack#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see org.roboid.studio.timeline.ChannelTrack#getPoints()
	 * @see #getChannelTrack()
	 * @generated
	 */
	EReference getChannelTrack_Points();

	/**
	 * Returns the meta object for the reference '{@link org.roboid.studio.timeline.ChannelTrack#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Channel</em>'.
	 * @see org.roboid.studio.timeline.ChannelTrack#getChannel()
	 * @see #getChannelTrack()
	 * @generated
	 */
	EReference getChannelTrack_Channel();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.LinearTrack <em>Linear Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Track</em>'.
	 * @see org.roboid.studio.timeline.LinearTrack
	 * @generated
	 */
	EClass getLinearTrack();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.LinearTrack#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.studio.timeline.LinearTrack#getMode()
	 * @see #getLinearTrack()
	 * @generated
	 */
	EAttribute getLinearTrack_Mode();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.CommandTrack <em>Command Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Track</em>'.
	 * @see org.roboid.studio.timeline.CommandTrack
	 * @generated
	 */
	EClass getCommandTrack();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.AudioTrack <em>Audio Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audio Track</em>'.
	 * @see org.roboid.studio.timeline.AudioTrack
	 * @generated
	 */
	EClass getAudioTrack();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioTrack#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.studio.timeline.AudioTrack#getMode()
	 * @see #getAudioTrack()
	 * @generated
	 */
	EAttribute getAudioTrack_Mode();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.VoiceTrack <em>Voice Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voice Track</em>'.
	 * @see org.roboid.studio.timeline.VoiceTrack
	 * @generated
	 */
	EClass getVoiceTrack();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.ColorTrack <em>Color Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Track</em>'.
	 * @see org.roboid.studio.timeline.ColorTrack
	 * @generated
	 */
	EClass getColorTrack();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.ColorTrack#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.studio.timeline.ColorTrack#getMode()
	 * @see #getColorTrack()
	 * @generated
	 */
	EAttribute getColorTrack_Mode();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.TextTrack <em>Text Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Track</em>'.
	 * @see org.roboid.studio.timeline.TextTrack
	 * @generated
	 */
	EClass getTextTrack();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.MatrixTrack <em>Matrix Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matrix Track</em>'.
	 * @see org.roboid.studio.timeline.MatrixTrack
	 * @generated
	 */
	EClass getMatrixTrack();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.FileTrack <em>File Track</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Track</em>'.
	 * @see org.roboid.studio.timeline.FileTrack
	 * @generated
	 */
	EClass getFileTrack();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.ControlPoint <em>Control Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Point</em>'.
	 * @see org.roboid.studio.timeline.ControlPoint
	 * @generated
	 */
	EClass getControlPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.ControlPoint#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame</em>'.
	 * @see org.roboid.studio.timeline.ControlPoint#getFrame()
	 * @see #getControlPoint()
	 * @generated
	 */
	EAttribute getControlPoint_Frame();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.LinearPoint <em>Linear Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Point</em>'.
	 * @see org.roboid.studio.timeline.LinearPoint
	 * @generated
	 */
	EClass getLinearPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.LinearPoint#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Values</em>'.
	 * @see org.roboid.studio.timeline.LinearPoint#getValues()
	 * @see #getLinearPoint()
	 * @generated
	 */
	EAttribute getLinearPoint_Values();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.LinearPoint#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.studio.timeline.LinearPoint#getMode()
	 * @see #getLinearPoint()
	 * @generated
	 */
	EAttribute getLinearPoint_Mode();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.CommandPoint <em>Command Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Point</em>'.
	 * @see org.roboid.studio.timeline.CommandPoint
	 * @generated
	 */
	EClass getCommandPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.CommandPoint#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Values</em>'.
	 * @see org.roboid.studio.timeline.CommandPoint#getValues()
	 * @see #getCommandPoint()
	 * @generated
	 */
	EAttribute getCommandPoint_Values();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.AudioPoint <em>Audio Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audio Point</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint
	 * @generated
	 */
	EClass getAudioPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getMp3 <em>Mp3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mp3</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getMp3()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Mp3();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getLength()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getText()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getVoiceId <em>Voice Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voice Id</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getVoiceId()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_VoiceId();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getLanguageId <em>Language Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Id</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getLanguageId()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_LanguageId();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getVoiceEffectId <em>Voice Effect Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Voice Effect Id</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getVoiceEffectId()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_VoiceEffectId();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getSpeechRate <em>Speech Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speech Rate</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getSpeechRate()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_SpeechRate();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getVolume()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Volume();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getPitch <em>Pitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pitch</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getPitch()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Pitch();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getBalance <em>Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balance</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getBalance()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Balance();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getEncoding()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Encoding();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getSampleRate <em>Sample Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sample Rate</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getSampleRate()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_SampleRate();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getSampleSizeInBits <em>Sample Size In Bits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sample Size In Bits</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getSampleSizeInBits()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_SampleSizeInBits();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channels</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getChannels()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Channels();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getFrameSize <em>Frame Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Size</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getFrameSize()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_FrameSize();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getFrameRate <em>Frame Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Rate</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getFrameRate()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_FrameRate();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#isBigEndian <em>Big Endian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Big Endian</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#isBigEndian()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_BigEndian();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getMode()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getFormat()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#getPcm <em>Pcm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pcm</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#getPcm()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Pcm();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.AudioPoint#isModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see org.roboid.studio.timeline.AudioPoint#isModified()
	 * @see #getAudioPoint()
	 * @generated
	 */
	EAttribute getAudioPoint_Modified();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.VoicePoint <em>Voice Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voice Point</em>'.
	 * @see org.roboid.studio.timeline.VoicePoint
	 * @generated
	 */
	EClass getVoicePoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.VoicePoint#getLipGain <em>Lip Gain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lip Gain</em>'.
	 * @see org.roboid.studio.timeline.VoicePoint#getLipGain()
	 * @see #getVoicePoint()
	 * @generated
	 */
	EAttribute getVoicePoint_LipGain();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.ColorPoint <em>Color Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Point</em>'.
	 * @see org.roboid.studio.timeline.ColorPoint
	 * @generated
	 */
	EClass getColorPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.ColorPoint#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.roboid.studio.timeline.ColorPoint#getMode()
	 * @see #getColorPoint()
	 * @generated
	 */
	EAttribute getColorPoint_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.ColorPoint#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.roboid.studio.timeline.ColorPoint#getColor()
	 * @see #getColorPoint()
	 * @generated
	 */
	EAttribute getColorPoint_Color();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.TextPoint <em>Text Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Point</em>'.
	 * @see org.roboid.studio.timeline.TextPoint
	 * @generated
	 */
	EClass getTextPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.TextPoint#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.roboid.studio.timeline.TextPoint#getText()
	 * @see #getTextPoint()
	 * @generated
	 */
	EAttribute getTextPoint_Text();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.MatrixPoint <em>Matrix Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matrix Point</em>'.
	 * @see org.roboid.studio.timeline.MatrixPoint
	 * @generated
	 */
	EClass getMatrixPoint();

	/**
	 * Returns the meta object for class '{@link org.roboid.studio.timeline.FilePoint <em>File Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Point</em>'.
	 * @see org.roboid.studio.timeline.FilePoint
	 * @generated
	 */
	EClass getFilePoint();

	/**
	 * Returns the meta object for the attribute '{@link org.roboid.studio.timeline.FilePoint#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.roboid.studio.timeline.FilePoint#getFileName()
	 * @see #getFilePoint()
	 * @generated
	 */
	EAttribute getFilePoint_FileName();

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
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.RGB <em>RGB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>RGB</em>'.
	 * @see org.eclipse.swt.graphics.RGB
	 * @model instanceClass="org.eclipse.swt.graphics.RGB"
	 * @generated
	 */
	EDataType getRGB();

	/**
	 * Returns the meta object for data type '{@link javax.sound.sampled.AudioFormat <em>Audio Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Audio Format</em>'.
	 * @see javax.sound.sampled.AudioFormat
	 * @model instanceClass="javax.sound.sampled.AudioFormat"
	 * @generated
	 */
	EDataType getAudioFormat();

	/**
	 * Returns the meta object for data type '{@link javax.sound.sampled.AudioInputStream <em>Audio Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Audio Input Stream</em>'.
	 * @see javax.sound.sampled.AudioInputStream
	 * @model instanceClass="javax.sound.sampled.AudioInputStream"
	 * @generated
	 */
	EDataType getAudioInputStream();

	/**
	 * Returns the meta object for data type '{@link javax.sound.sampled.UnsupportedAudioFileException <em>Unsupported Audio File Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unsupported Audio File Exception</em>'.
	 * @see javax.sound.sampled.UnsupportedAudioFileException
	 * @model instanceClass="javax.sound.sampled.UnsupportedAudioFileException"
	 * @generated
	 */
	EDataType getUnsupportedAudioFileException();

	/**
	 * Returns the meta object for data type '{@link java.io.IOException <em>IO Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IO Exception</em>'.
	 * @see java.io.IOException
	 * @model instanceClass="java.io.IOException"
	 * @generated
	 */
	EDataType getIOException();

	/**
	 * Returns the meta object for data type '<em>Float Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float Array</em>'.
	 * @model instanceClass="float[]"
	 * @generated
	 */
	EDataType getFloatArray();

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
	TimelineFactory getTimelineFactory();

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
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.TimelineElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.TimelineElementImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getTimelineElement()
		 * @generated
		 */
		EClass TIMELINE_ELEMENT = eINSTANCE.getTimelineElement();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.MotionClipImpl <em>Motion Clip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.MotionClipImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMotionClip()
		 * @generated
		 */
		EClass MOTION_CLIP = eINSTANCE.getMotionClip();

		/**
		 * The meta object literal for the '<em><b>Robot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CLIP__ROBOT = eINSTANCE.getMotionClip_Robot();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CLIP__ACTIVITY = eINSTANCE.getMotionClip_Activity();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTION_CLIP__CONTROLS = eINSTANCE.getMotionClip_Controls();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CLIP__VERSION = eINSTANCE.getMotionClip_Version();

		/**
		 * The meta object literal for the '<em><b>Frame Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOTION_CLIP__FRAME_LIMIT = eINSTANCE.getMotionClip_FrameLimit();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.MovableElementImpl <em>Movable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.MovableElementImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMovableElement()
		 * @generated
		 */
		EClass MOVABLE_ELEMENT = eINSTANCE.getMovableElement();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVABLE_ELEMENT__CONSTRAINT = eINSTANCE.getMovableElement_Constraint();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVABLE_ELEMENT__PARENT = eINSTANCE.getMovableElement_Parent();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.ControlTrackImpl <em>Control Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.ControlTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getControlTrack()
		 * @generated
		 */
		EClass CONTROL_TRACK = eINSTANCE.getControlTrack();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_TRACK__CHANNELS = eINSTANCE.getControlTrack_Channels();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_TRACK__CONTROL = eINSTANCE.getControlTrack_Control();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.ChannelTrackImpl <em>Channel Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.ChannelTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getChannelTrack()
		 * @generated
		 */
		EClass CHANNEL_TRACK = eINSTANCE.getChannelTrack();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_TRACK__POINTS = eINSTANCE.getChannelTrack_Points();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_TRACK__CHANNEL = eINSTANCE.getChannelTrack_Channel();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.LinearTrackImpl <em>Linear Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.LinearTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getLinearTrack()
		 * @generated
		 */
		EClass LINEAR_TRACK = eINSTANCE.getLinearTrack();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_TRACK__MODE = eINSTANCE.getLinearTrack_Mode();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.CommandTrackImpl <em>Command Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.CommandTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getCommandTrack()
		 * @generated
		 */
		EClass COMMAND_TRACK = eINSTANCE.getCommandTrack();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.AudioTrackImpl <em>Audio Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.AudioTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioTrack()
		 * @generated
		 */
		EClass AUDIO_TRACK = eINSTANCE.getAudioTrack();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_TRACK__MODE = eINSTANCE.getAudioTrack_Mode();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.VoiceTrackImpl <em>Voice Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.VoiceTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getVoiceTrack()
		 * @generated
		 */
		EClass VOICE_TRACK = eINSTANCE.getVoiceTrack();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.ColorTrackImpl <em>Color Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.ColorTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getColorTrack()
		 * @generated
		 */
		EClass COLOR_TRACK = eINSTANCE.getColorTrack();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_TRACK__MODE = eINSTANCE.getColorTrack_Mode();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.TextTrackImpl <em>Text Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.TextTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getTextTrack()
		 * @generated
		 */
		EClass TEXT_TRACK = eINSTANCE.getTextTrack();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.MatrixTrackImpl <em>Matrix Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.MatrixTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMatrixTrack()
		 * @generated
		 */
		EClass MATRIX_TRACK = eINSTANCE.getMatrixTrack();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.FileTrackImpl <em>File Track</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.FileTrackImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getFileTrack()
		 * @generated
		 */
		EClass FILE_TRACK = eINSTANCE.getFileTrack();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.ControlPointImpl <em>Control Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.ControlPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getControlPoint()
		 * @generated
		 */
		EClass CONTROL_POINT = eINSTANCE.getControlPoint();

		/**
		 * The meta object literal for the '<em><b>Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_POINT__FRAME = eINSTANCE.getControlPoint_Frame();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.LinearPointImpl <em>Linear Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.LinearPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getLinearPoint()
		 * @generated
		 */
		EClass LINEAR_POINT = eINSTANCE.getLinearPoint();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_POINT__VALUES = eINSTANCE.getLinearPoint_Values();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINEAR_POINT__MODE = eINSTANCE.getLinearPoint_Mode();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.CommandPointImpl <em>Command Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.CommandPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getCommandPoint()
		 * @generated
		 */
		EClass COMMAND_POINT = eINSTANCE.getCommandPoint();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_POINT__VALUES = eINSTANCE.getCommandPoint_Values();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.AudioPointImpl <em>Audio Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.AudioPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioPoint()
		 * @generated
		 */
		EClass AUDIO_POINT = eINSTANCE.getAudioPoint();

		/**
		 * The meta object literal for the '<em><b>Mp3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__MP3 = eINSTANCE.getAudioPoint_Mp3();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__LENGTH = eINSTANCE.getAudioPoint_Length();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__TEXT = eINSTANCE.getAudioPoint_Text();

		/**
		 * The meta object literal for the '<em><b>Voice Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__VOICE_ID = eINSTANCE.getAudioPoint_VoiceId();

		/**
		 * The meta object literal for the '<em><b>Language Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__LANGUAGE_ID = eINSTANCE.getAudioPoint_LanguageId();

		/**
		 * The meta object literal for the '<em><b>Voice Effect Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__VOICE_EFFECT_ID = eINSTANCE.getAudioPoint_VoiceEffectId();

		/**
		 * The meta object literal for the '<em><b>Speech Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__SPEECH_RATE = eINSTANCE.getAudioPoint_SpeechRate();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__VOLUME = eINSTANCE.getAudioPoint_Volume();

		/**
		 * The meta object literal for the '<em><b>Pitch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__PITCH = eINSTANCE.getAudioPoint_Pitch();

		/**
		 * The meta object literal for the '<em><b>Balance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__BALANCE = eINSTANCE.getAudioPoint_Balance();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__ENCODING = eINSTANCE.getAudioPoint_Encoding();

		/**
		 * The meta object literal for the '<em><b>Sample Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__SAMPLE_RATE = eINSTANCE.getAudioPoint_SampleRate();

		/**
		 * The meta object literal for the '<em><b>Sample Size In Bits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__SAMPLE_SIZE_IN_BITS = eINSTANCE.getAudioPoint_SampleSizeInBits();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__CHANNELS = eINSTANCE.getAudioPoint_Channels();

		/**
		 * The meta object literal for the '<em><b>Frame Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__FRAME_SIZE = eINSTANCE.getAudioPoint_FrameSize();

		/**
		 * The meta object literal for the '<em><b>Frame Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__FRAME_RATE = eINSTANCE.getAudioPoint_FrameRate();

		/**
		 * The meta object literal for the '<em><b>Big Endian</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__BIG_ENDIAN = eINSTANCE.getAudioPoint_BigEndian();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__MODE = eINSTANCE.getAudioPoint_Mode();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__FORMAT = eINSTANCE.getAudioPoint_Format();

		/**
		 * The meta object literal for the '<em><b>Pcm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__PCM = eINSTANCE.getAudioPoint_Pcm();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO_POINT__MODIFIED = eINSTANCE.getAudioPoint_Modified();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.VoicePointImpl <em>Voice Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.VoicePointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getVoicePoint()
		 * @generated
		 */
		EClass VOICE_POINT = eINSTANCE.getVoicePoint();

		/**
		 * The meta object literal for the '<em><b>Lip Gain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICE_POINT__LIP_GAIN = eINSTANCE.getVoicePoint_LipGain();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.ColorPointImpl <em>Color Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.ColorPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getColorPoint()
		 * @generated
		 */
		EClass COLOR_POINT = eINSTANCE.getColorPoint();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_POINT__MODE = eINSTANCE.getColorPoint_Mode();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_POINT__COLOR = eINSTANCE.getColorPoint_Color();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.TextPointImpl <em>Text Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.TextPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getTextPoint()
		 * @generated
		 */
		EClass TEXT_POINT = eINSTANCE.getTextPoint();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_POINT__TEXT = eINSTANCE.getTextPoint_Text();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.MatrixPointImpl <em>Matrix Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.MatrixPointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getMatrixPoint()
		 * @generated
		 */
		EClass MATRIX_POINT = eINSTANCE.getMatrixPoint();

		/**
		 * The meta object literal for the '{@link org.roboid.studio.timeline.impl.FilePointImpl <em>File Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.FilePointImpl
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getFilePoint()
		 * @generated
		 */
		EClass FILE_POINT = eINSTANCE.getFilePoint();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_POINT__FILE_NAME = eINSTANCE.getFilePoint_FileName();

		/**
		 * The meta object literal for the '{@link org.roboid.core.runtime.IClip <em>IClip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.core.runtime.IClip
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getIClip()
		 * @generated
		 */
		EClass ICLIP = eINSTANCE.getIClip();

		/**
		 * The meta object literal for the '<em>Rectangle</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Rectangle
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getRectangle()
		 * @generated
		 */
		EDataType RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em>RGB</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.RGB
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getRGB()
		 * @generated
		 */
		EDataType RGB = eINSTANCE.getRGB();

		/**
		 * The meta object literal for the '<em>Audio Format</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.sound.sampled.AudioFormat
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioFormat()
		 * @generated
		 */
		EDataType AUDIO_FORMAT = eINSTANCE.getAudioFormat();

		/**
		 * The meta object literal for the '<em>Audio Input Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.sound.sampled.AudioInputStream
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getAudioInputStream()
		 * @generated
		 */
		EDataType AUDIO_INPUT_STREAM = eINSTANCE.getAudioInputStream();

		/**
		 * The meta object literal for the '<em>Unsupported Audio File Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.sound.sampled.UnsupportedAudioFileException
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getUnsupportedAudioFileException()
		 * @generated
		 */
		EDataType UNSUPPORTED_AUDIO_FILE_EXCEPTION = eINSTANCE.getUnsupportedAudioFileException();

		/**
		 * The meta object literal for the '<em>IO Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.IOException
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getIOException()
		 * @generated
		 */
		EDataType IO_EXCEPTION = eINSTANCE.getIOException();

		/**
		 * The meta object literal for the '<em>Float Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getFloatArray()
		 * @generated
		 */
		EDataType FLOAT_ARRAY = eINSTANCE.getFloatArray();

		/**
		 * The meta object literal for the '<em>Property Change Listener</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.beans.PropertyChangeListener
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getPropertyChangeListener()
		 * @generated
		 */
		EDataType PROPERTY_CHANGE_LISTENER = eINSTANCE.getPropertyChangeListener();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.roboid.studio.timeline.impl.TimelinePackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //TimelinePackage
