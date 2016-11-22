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

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.internal.wizards.datatransfer.FileSystemExporter;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;

/**
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class MotionClipBinaryExporter extends FileSystemExporter
{
	private static final int VERSION = 1;
	
	@Override
	protected void writeFile(IFile file, IPath destinationPath) throws IOException, CoreException
	{
		if(file == null || destinationPath == null) return;
		
		IPath path = file.getLocation();
		if(path == null) return;
		
		MotionClip clip = TimelineEditor.readMotionClip(path.toFile());
		if(clip == null) return;
		
		Robot robot = clip.getRobot();
		if(robot == null) return;
		
		Protocol protocol = robot.getProtocol();
		if(protocol == null) return;

		DataOutputStream output = null;
		try
		{
			output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(destinationPath.toOSString())));
			output.writeInt(VERSION);
			
			List<Roboid> roboids = robot.getRoboids();
			output.writeInt(roboids.size());
			for(Roboid roboid : robot.getRoboids())
			{
				output.writeUTF(roboid.getId());
			}
			
			output.writeInt(clip.getTotalFrames());
			for(ControlTrack control : clip.getControls())
			{
				for(ChannelTrack channel : control.getChannels())
				{
					List<ControlPoint> points = channel.getPoints();
					output.writeInt(points.size());
					for(ControlPoint p : points)
					{
						output.writeInt(p.getFrame());
						if(p instanceof LinearPoint)
						{
							LinearPoint lp = (LinearPoint)p;
							float[] values = lp.getValues();
							output.writeInt(values.length);
							for(float v : values)
								output.writeFloat(v);
						}
						else if(p instanceof CommandPoint)
						{
							CommandPoint cp = (CommandPoint)p;
							float[] values = cp.getValues();
							output.writeInt(values.length);
							for(float v : values)
								output.writeFloat(v);
						}
						else if(p instanceof ColorPoint)
						{
							ColorPoint cp = (ColorPoint)p;
							RGB rgb = cp.getColor();
							output.writeInt(3);
							output.writeInt(rgb.red);
							output.writeInt(rgb.green);
							output.writeInt(rgb.blue);
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(output != null)
				output.close();
		}
	}
}
