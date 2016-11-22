/*******************************************************************************
 * Copyright (c) 2009 www.roboidstudio.org. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Kwang-Hyun Park
 ******************************************************************************/

package org.roboid.core.runtime;

import java.util.ArrayList;
import java.util.List;

import org.roboid.core.component.activity.Activity;
import org.roboid.robot.Robot;

/**
 * @author Kwang-Hyun Park
 */
public final class ContentsManager
{
	private static IClip currentContent;
	private static List<ContentChangeListener> listeners = new ArrayList<ContentChangeListener>();
	private static List<MotionClipChangedListener> motionClipListeners = new ArrayList<MotionClipChangedListener>();
	private static boolean firstMotionClip = false;
	
	private ContentsManager()
	{
		throw new AssertionError();
	}
	
	public static void startup()
	{
	}
	
	public static void shutdown()
	{
		dispose();
	}
	
	public static IClip getCurrentContent()
	{
		return currentContent;
	}
	
	public static void changeContent(IClip newContent)
	{
		if(newContent == null)
		{
			dispose();
			RobotManager.setCurrentRobot(null);
			ActivityManager.setCurrentActivity(null);
			fireContentChanged(currentContent, null);
			return;
		}

		Robot oldRobot = RobotManager.getCurrentRobot();
		Activity oldActivity = null;
		if(currentContent != null)
			oldActivity = currentContent.getActivity();
		
		Robot newRobot = newContent.getRobot();
		Activity newActivity = newContent.getActivity();
		if(newRobot == null || newActivity == null) return;
		
//		System.out.println("\n... content was changed by " + newActivity + " and " + newRobot + " ...");
		
		if(newRobot.equalsContents(oldRobot))
		{
			newContent.updateReference(oldRobot);
			newActivity.updateReference(oldActivity, oldRobot);
		}
		else
		{
//			ModelMatcher matcher = new ModelMatcher(newRobot);
//			List<Roboid> adds = new ArrayList<Roboid>();
//			List<Roboid> removes = new ArrayList<Roboid>();
//			matcher.collectDifferentRoboids(adds, removes, oldRobot);
			
			dispose();
			newActivity.refresh();
			
			RobotManager.setCurrentRobot(newRobot);
//			System.out.println("<<< robot was changed to " + newRobot + " >>>");
		}
		
		ActivityManager.setCurrentActivity(newActivity);
		fireContentChanged(currentContent, newContent);
		currentContent = newContent;
	}
	
	public static void activate()
	{
		Activity activity = ActivityManager.getCurrentActivity();
		if(activity != null) activity.activateComponents();
	}

	public static void deactivate()
	{
		Activity activity = ActivityManager.getCurrentActivity();
		if(activity != null) activity.deactivateComponents();
	}

	public static void execute()
	{
		Activity activity = ActivityManager.getCurrentActivity();
		if(activity != null) activity.executeComponents();
	}
	
	public static boolean isReady()
	{
		Activity activity = ActivityManager.getCurrentActivity();
		if(activity != null) return activity.isComponentsReady();
		return false;
	}
	
	public static void dispose()
	{
		Activity activity = ActivityManager.getCurrentActivity();
		if(activity != null) activity.disposeComponents();
	}
	
	public static synchronized void addContentChangeListener(ContentChangeListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
	
	public static synchronized void removeContentChangeListener(ContentChangeListener listener)
	{
		if(listener != null)
			listeners.remove(listener);
	}
	
	private static void fireContentChanged(IClip oldContent, IClip newContent)
	{
		for(ContentChangeListener listener : listeners)
			listener.contentChanged(oldContent, newContent);
	}
	
	public static void notifyContentChanged(IClip newContent)
	{
		fireContentChanged(currentContent, newContent);
	}
	
	public static synchronized void addMotionClipChangedListener(MotionClipChangedListener listener)
	{
		if(listener != null)
			motionClipListeners.add(listener);
	}
	
	public static synchronized void removeMotionClipChangedListener(MotionClipChangedListener listener)
	{
		if(listener != null)
			motionClipListeners.remove(listener);
	}
	
	public static void notifyMotionClipChanged(IClip clip)
	{
		for(MotionClipChangedListener listener : motionClipListeners)
			listener.motionClipChanged(clip, firstMotionClip);
	}
	
	public static void setFirstMotionClip(boolean first)
	{
		firstMotionClip = first;
	}
}
