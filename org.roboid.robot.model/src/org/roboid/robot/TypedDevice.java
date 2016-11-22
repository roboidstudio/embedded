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

package org.roboid.robot;

import org.eclipse.swt.graphics.ImageData;

/**
 * @author Kwang-Hyun Park
 */
public interface TypedDevice
{
	public int getMin();
	public float getMinFloat();
	public int getMax();
	public float getMaxFloat();
	public int getDefault();
	public float getDefaultFloat();
	public String getDefaultString();
	public ImageData getDefaultImageData();
	public int read();
	public int read(int index);
	public int read(int[] data);
	public float readFloat();
	public float readFloat(int index);
	public int readFloat(float[] data);
	public String readString();
	public String readString(int index);
	public int readString(String[] data);
	public ImageData readImageData();
	public ImageData readImageData(int index);
	public int readImageData(ImageData[] data);
	public boolean write();
	public boolean write(int data);
	public boolean write(int index, int data);
	public boolean write(int[] data);
	public boolean write(float data);
	public boolean write(int index, float data);
	public boolean write(float[] data);
	public boolean write(String data);
	public boolean write(int index, String data);
	public boolean write(String[] data);
	public boolean write(ImageData data);
	public boolean write(int index, ImageData data);
	public boolean write(ImageData[] data);
	public void clear();
}
