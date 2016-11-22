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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.roboid.core.component.activity.Activity;
import org.roboid.robot.Channel;
import org.roboid.robot.ChannelDevice;
import org.roboid.robot.Control;
import org.roboid.robot.Device;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.util.ModelMatcher;
import org.roboid.studio.timeline.ControlTrack;
import org.roboid.studio.timeline.MotionClip;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motion Clip</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.MotionClipImpl#getRobot <em>Robot</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.MotionClipImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.MotionClipImpl#getControls <em>Controls</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.MotionClipImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.MotionClipImpl#getFrameLimit <em>Frame Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotionClipImpl extends TimelineElementImpl implements MotionClip
{
	/**
	 * The cached value of the '{@link #getRobot() <em>Robot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRobot()
	 * @generated
	 * @ordered
	 */
	protected Robot robot;
	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;
	/**
	 * The cached value of the '{@link #getControls() <em>Controls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControls()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlTrack> controls;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0.0";
	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameLimit() <em>Frame Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameLimit()
	 * @generated
	 * @ordered
	 */
	protected static final int FRAME_LIMIT_EDEFAULT = 9999;
	/**
	 * The cached value of the '{@link #getFrameLimit() <em>Frame Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameLimit()
	 * @generated
	 * @ordered
	 */
	protected int frameLimit = FRAME_LIMIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotionClipImpl()
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
		return TimelinePackage.Literals.MOTION_CLIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot getRobot()
	{
		return robot;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRobot(Robot newRobot)
	{
		Robot oldRobot = robot;
		robot = newRobot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.MOTION_CLIP__ROBOT, oldRobot, robot));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity()
	{
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(Activity newActivity)
	{
		Activity oldActivity = activity;
		activity = newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.MOTION_CLIP__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ControlTrack> getControls()
	{
		if (controls == null) {
			controls = new EObjectContainmentEList<ControlTrack>(ControlTrack.class, this, TimelinePackage.MOTION_CLIP__CONTROLS);
		}
		return controls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion)
	{
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.MOTION_CLIP__VERSION, oldVersion, version));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrameLimit()
	{
		return frameLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case TimelinePackage.MOTION_CLIP__CONTROLS:
				return ((InternalEList<?>)getControls()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case TimelinePackage.MOTION_CLIP__ROBOT:
				return getRobot();
			case TimelinePackage.MOTION_CLIP__ACTIVITY:
				return getActivity();
			case TimelinePackage.MOTION_CLIP__CONTROLS:
				return getControls();
			case TimelinePackage.MOTION_CLIP__VERSION:
				return getVersion();
			case TimelinePackage.MOTION_CLIP__FRAME_LIMIT:
				return getFrameLimit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case TimelinePackage.MOTION_CLIP__ROBOT:
				setRobot((Robot)newValue);
				return;
			case TimelinePackage.MOTION_CLIP__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case TimelinePackage.MOTION_CLIP__CONTROLS:
				getControls().clear();
				getControls().addAll((Collection<? extends ControlTrack>)newValue);
				return;
			case TimelinePackage.MOTION_CLIP__VERSION:
				setVersion((String)newValue);
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
			case TimelinePackage.MOTION_CLIP__ROBOT:
				setRobot((Robot)null);
				return;
			case TimelinePackage.MOTION_CLIP__ACTIVITY:
				setActivity((Activity)null);
				return;
			case TimelinePackage.MOTION_CLIP__CONTROLS:
				getControls().clear();
				return;
			case TimelinePackage.MOTION_CLIP__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case TimelinePackage.MOTION_CLIP__ROBOT:
				return robot != null;
			case TimelinePackage.MOTION_CLIP__ACTIVITY:
				return activity != null;
			case TimelinePackage.MOTION_CLIP__CONTROLS:
				return controls != null && !controls.isEmpty();
			case TimelinePackage.MOTION_CLIP__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case TimelinePackage.MOTION_CLIP__FRAME_LIMIT:
				return frameLimit != FRAME_LIMIT_EDEFAULT;
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
		result.append(" (version: ");
		result.append(version);
		result.append(", frameLimit: ");
		result.append(frameLimit);
		result.append(')');
		return result.toString();
	}

	

	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */

	private static final String P_ROBOT = "_robot";
	private static final String P_VERSION = "_version";
	
	// for properties view
	/**
	 * @generated NOT
	 */
	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		propertyDescriptors.add(new PropertyDescriptor(P_ROBOT, "Robot"));
		propertyDescriptors.add(new PropertyDescriptor(P_VERSION, "Version"));
	}

	// for properties view
	/**
	 * @generated NOT
	 */
	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_ROBOT)) return getRobot() == null ? "" : getRobot().getName();
		if(id.equals(P_VERSION)) return getVersion();
		return null;
	}
	
	@Override
	public Resource getResource()
	{
		return eResource();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ControlTrack createControlTrack(Control control)
	{
		ControlTrack newControlTrack = TimelineFactory.eINSTANCE.createControlTrack();
		newControlTrack.setControl(control);
		newControlTrack.createChannelTracks(control);
		return newControlTrack;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createControlTracks(Robot robot)
	{
		if(robot == null) return;
		
		// calculates a maximum frame in a timeline motion editor
		for(Control control : robot.getControls())
		{
			if(frameLimit < control.getFrameLimit())
				frameLimit = control.getFrameLimit();
		}
		
		getControls().clear();

		for(Control control : robot.getControls())
		{
			ControlTrack newControlTrack = createControlTrack(control);
			if(newControlTrack != null) getControls().add(newControlTrack);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MotionClip deepCopy()
	{
		MotionClip newClip = TimelineFactory.eINSTANCE.createMotionClip();
		newClip.setVersion(getVersion());
		for(ControlTrack track : getControls())
			newClip.getControls().add(track.deepCopy());
		return newClip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshResource()
	{
		Resource resource = eResource();
		if(resource == null) return;
		URI uri = resource.getURI();
		refreshResource(uri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void refreshResource(URI uri)
	{
		if(uri == null) return;
		
		try
		{
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(uri);
			
			resource.getContents().add((EObject)getRobot());
			resource.getContents().add((EObject)getActivity());
			resource.getContents().add((EObject)this);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public int updateReference(Robot newRobot)
	{
		if(newRobot == null) return INSERT_INVALID_REFERENCE_ROBOT;
		
		setRobot(newRobot);
		
		Iterator<ControlTrack> it1 = getControls().iterator();
		Iterator<Control> it2 = newRobot.getControls().iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			ControlTrack oldControlTrack = it1.next();
			Control newControl = it2.next();
			oldControlTrack.updateReference(newControl);
		}
		return INSERT_SUCCESS;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public int adaptTo(Robot newRobot)
	{
		return adaptTo(newRobot, new ModelMatcher(newRobot));
	}
	
	/**
	 * @generated NOT
	 */
	public int adaptTo(Robot newRobot, ModelMatcher matcher)
	{
		if(newRobot == null) return INSERT_INVALID_REFERENCE_ROBOT;
		Robot oldRobot = getRobot();
		if(oldRobot == null) return INSERT_INVALID_CLIENT_ROBOT;
		if(matcher == null) matcher = new ModelMatcher(newRobot);
		
		setRobot(newRobot);

		Map<Control, ControlTrack> controlMap = new HashMap<Control, ControlTrack>();
		List<ControlTrack> thisControlTracks = new ArrayList<ControlTrack>();
		
		boolean found = false;
		int remains = getControls().size();
		for(Control newControl : newRobot.getControls())
		{
			ControlTrack thisControlTrack = findControlTrack(newControl, matcher, controlMap);
			if(thisControlTrack == null)
				thisControlTrack = createControlTrack(newControl);
			else
			{
				found = true;
				thisControlTrack.updateReference(newControl);
				remains --;
			}
			thisControlTracks.add(thisControlTrack);
		}
		
		boolean lost = remains != 0;
		getControls().clear();
		getControls().addAll(thisControlTracks);
		
		if(found == false)
			return INSERT_DIFFERENT_ROBOT;
		if(lost)
			return INSERT_PARTIAL;

		return INSERT_SUCCESS;
	}
	
	/**
	 * @generated NOT
	 */
	private ControlTrack findControlTrack(Control newControl, ModelMatcher matcher, Map<Control, ControlTrack> controlMap)
	{
		ControlTrack thisControlTrack = controlMap.get(newControl);
		if(thisControlTrack != null) return thisControlTrack;
		
		List<ControlTrack> thisControlTracks = new ArrayList<ControlTrack>();
		collectControlTracks(thisControlTracks, newControl, controlMap);
		
		if(thisControlTracks.size() == 1)
			thisControlTrack = thisControlTracks.get(0);
		else if(thisControlTracks.size() > 0)
			thisControlTrack = selectControlTrack(thisControlTracks, newControl, matcher);
		
		if(thisControlTrack != null) controlMap.put(newControl, thisControlTrack);
		
		return thisControlTrack;
	}
	
	/**
	 * @generated NOT
	 */
	private List<ControlTrack> collectControlTracks(List<ControlTrack> thisControlTracks, Control newControl, Map<Control, ControlTrack> controlMap)
	{
		// version and corresponding roboid should be same
		Roboid newRoboid = getRootRoboid(newControl);
		if(newRoboid == null) return thisControlTracks;
		
		for(ControlTrack thisControlTrack : getControls())
		{
			if(controlMap.containsValue(thisControlTrack)) continue;
			
			Control thisControl = thisControlTrack.getControl();
			if(thisControl == null) continue;
			
			// version
			if(newControl.getVersion() == null)
			{
				if(thisControl.getVersion() != null) continue;
			}
			else if(!newControl.getVersion().equalsIgnoreCase(thisControl.getVersion())) continue;

			Roboid thisRoboid = getRootRoboid(thisControl);
			if(thisRoboid == null) continue;
			
			// corresponding roboid
			if(newRoboid.getId().equalsIgnoreCase(thisRoboid.getId()))
			{
				if(newRoboid.getVersion() == null)
				{
					if(thisRoboid.getVersion() != null) continue;
				}
				else if(!newRoboid.getVersion().equalsIgnoreCase(thisRoboid.getVersion())) continue;

				thisControlTracks.add(thisControlTrack);
			}
		}
		return thisControlTracks;
	}
	
	private Roboid getRootRoboid(Control control)
	{
		for(Channel channel : control.getChannels())
		{
			for(Device device : channel.getDevices())
			{
				Roboid roboid = device.getRootRoboid();
				if(roboid != null) return roboid;
			}
		}
		return null;
	}
	
	/**
	 * @generated NOT
	 */
	private ControlTrack selectControlTrack(List<ControlTrack> thisControlTracks, Control newControl, ModelMatcher matcher)
	{
		List<ControlTrack> candidates = new ArrayList<ControlTrack>();
		for(ControlTrack thisControlTrack : thisControlTracks)
		{
			Control thisControl = thisControlTrack.getControl();
			if(checkControl(newControl, thisControl, matcher))
				candidates.add(thisControlTrack);
		}
		
		if(candidates.size() > 0)
			return candidates.get(0);
		
		return thisControlTracks.get(0);
	}
	
	/**
	 * @generated NOT
	 */
	private boolean checkControl(Control thisControl, Control newControl, ModelMatcher matcher)
	{
		if(thisControl == newControl) return true;
		
		List<Channel> thisChannels = thisControl.getChannels();
		List<Channel> newChannels = newControl.getChannels();
		if(thisChannels.size() != newChannels.size()) return false;
		
		Iterator<Channel> it1 = thisChannels.iterator();
		Iterator<Channel> it2 = newChannels.iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			Channel thisChannel = it1.next();
			Channel newChannel = it2.next();
			
			List<ChannelDevice> thisDevices = thisChannel.getDevices();
			List<ChannelDevice> newDevices = newChannel.getDevices();
			if(thisDevices.size() != newDevices.size()) return false;
			
			Iterator<ChannelDevice> it3 = thisDevices.iterator();
			Iterator<ChannelDevice> it4 = newDevices.iterator();
			while(it3.hasNext() && it4.hasNext())
			{
				Device thisDevice = it3.next();
				Device newDevice = it4.next();
				if(matcher.findDevice(thisDevice) != newDevice) return false;
			}
		}
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getTotalFrames()
	{
		int maxFrame = 0;
		for(ControlTrack child : getControls())
		{
			int frame = child.getTotalFrames(); // 각 채널의 프레임 수
			if(maxFrame < frame) maxFrame = frame;
		}
		return maxFrame;
	}
} //MotionClipImpl
