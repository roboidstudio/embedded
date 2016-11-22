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

package org.roboid.studio.datavisualizer;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.roboid.robot.Command;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.Event;
import org.roboid.robot.MotoringDevice;
import org.roboid.robot.Protocol;
import org.roboid.robot.Roboid;
import org.roboid.robot.SensoryDevice;

/**
 * @author Kwang-Hyun Park
 */
public class RobotItemLabelProvider extends LabelProvider implements ILabelProvider
{
	private ImageRegistry imageRegistry;
	
	public RobotItemLabelProvider()
	{
		imageRegistry = new ImageRegistry(Display.getDefault());
		Image icon_roboid = AbstractUIPlugin.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/roboid.png").createImage();
		Image pin_orange = AbstractUIPlugin.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/pin_orange.png").createImage();
		Image pin_blue = AbstractUIPlugin.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/pin_blue.png").createImage();
		Image pin_green = AbstractUIPlugin.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/pin_green.png").createImage();
		Image pin_gray = AbstractUIPlugin.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/pin_grey.png").createImage();
		Image navi_close = AbstractUIPlugin.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID, "icons/navigate_close.png").createImage();
		
		imageRegistry.put("icon_roboid", icon_roboid);
		imageRegistry.put("pin_orange", pin_orange);
		imageRegistry.put("pin_blue", pin_blue);
		imageRegistry.put("pin_green", pin_green);
		imageRegistry.put("pin_gray", pin_gray);
		imageRegistry.put("navi_close", navi_close);
	}
	
	@Override
	public void dispose()
	{
		if(imageRegistry != null)
			imageRegistry.dispose();
		super.dispose();
	}

	@Override
	public Image getImage(Object element)
	{
		if(element instanceof Roboid)
			return imageRegistry.get("icon_roboid");
		else if(element instanceof Protocol)
			return imageRegistry.get("pin_orange");
		else if(element instanceof MotoringDevice)
			return imageRegistry.get("pin_blue");
		else if(element instanceof SensoryDevice)
			return imageRegistry.get("pin_green");
		return null;
	}

	@Override
	public String getText(Object element)
	{
		if(element instanceof Roboid)
			return ((Roboid)element).getName().trim();
		else if(element instanceof Protocol)
		{
			int buffers = ((Protocol)element).getRemainingBuffer();
			return new StringBuilder("Buffers  ").append(buffers).toString();
		}
		else if(element instanceof Device)
		{
			Device device = (Device)element;
			StringBuilder sb = new StringBuilder(device.getName());
			
			int dataSize = device.getDataSize();
			DataType dataType = device.getDataType();
			if(dataType == DataType.STRING)
				sb.append("  ").append(device.readString());
			else
			{
				if(dataSize > 4)
					sb.append(" (").append(dataSize).append(")");
				
				if(element instanceof Event)
					sb.append(" [").append(((Event)element).getId()).append("]  ");
				else if(element instanceof Command)
					sb.append(" [").append(((Command)element).getId()).append("]  ");
				else
					sb.append("  ");
				
				if(dataSize > 0)
				{
					if(dataType == DataType.FLOAT)
						sb.append(device.readFloat());
					else
						sb.append(device.read());
				}
				if(dataSize > 1)
				{
					if(dataType == DataType.FLOAT)
						sb.append(", ").append(device.readFloat(1));
					else
						sb.append(", ").append(device.read(1));
				}
				if(dataSize > 2)
				{
					if(dataType == DataType.FLOAT)
						sb.append(", ").append(device.readFloat(2));
					else
						sb.append(", ").append(device.read(2));
				}
				if(dataSize > 3)
				{
					if(dataType == DataType.FLOAT)
						sb.append(", ").append(device.readFloat(3));
					else
						sb.append(", ").append(device.read(3));
				}
				if(dataSize > 4)
					sb.append(", ...");
			}
			return sb.toString();
		}
		else if(element instanceof DataItem)
			return ((DataItem)element).getText();
		return "";
	}
}
