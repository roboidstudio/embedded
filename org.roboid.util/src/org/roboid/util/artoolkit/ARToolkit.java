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

package org.roboid.util.artoolkit;

/**
 * @author Kwang-Hyun Park
 */
public class ARToolkit
{
	static
	{
		System.loadLibrary("glut32");
		System.loadLibrary("ARToolkitJNI");
	}
	
	private static ARToolkit INSTANCE;
	
	public native String arGetVersion();
	public native int arInitCparam();
	public native int arParamChangeSize(int xsize, int ysize);
	public native int arParamLoad(String filename);
	public native int arParamSave(String filename);
	public native String arParamDisp();
	
	public native int arLoadPatt(String filename);
	public native int arFreePatt(int patt_no);
	public native int arActivatePatt(int pat_no);
	public native int arDeactivatePatt(int pat_no);
	public native int[] arDetectMarker(byte[] dataPtr, int thresh);
	public native int[] arDetectMarkerLite(byte[] dataPtr, int thresh);
	public native int arMultiReadConfigFile(String filename);
	public native int arMultiFreeConfig(int multiMarkerID);
	public native int arMultiActivate(int multiMarkerID);
	public native int arMultiDeactivate(int multiMarkerID);
	
//	int arSavePatt(ARUint8 *image, ARMarkerInfo *marker_info, char *filename );
	
	public native int argInit(double zoom, int fullFlag, int xwin, int ywin, int hmd_flag);
	public native double arUtilTimer();
	public native void arUtilTimerReset();
	public native void arUtilSleep(int msec);
	
	private ARToolkit()
	{
	}
	
	public static ARToolkit getInstance()
	{
		if(INSTANCE == null)
			INSTANCE = new ARToolkit();
		return INSTANCE;
	}
}
