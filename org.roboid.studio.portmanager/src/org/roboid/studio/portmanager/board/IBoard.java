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

package org.roboid.studio.portmanager.board;

import java.io.File;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.roboid.robot.Device;
import org.roboid.robot.Port;

/**
 * @author Kwang-Hyun Park
 */
public interface IBoard
{
	public abstract IConfigurationElement getConfig();
	public abstract String getId();
	public abstract void initPath(String suffix);
	public abstract File getOutputFile();
	public abstract String readTemplate();
	public abstract void download(String code);
	
	/**
	 * Following APIs should be implemented by bundles
	 */
	public abstract String[] getModeLabels(int portIndex);
	public abstract String getModeLabel(Port port, int portIndex);
	public abstract int indexOfMode(Port port, int portIndex);
	public abstract void selectMode(Port port, int portIndex, int selection);
	public abstract String generateSetup(String template, List<Port> ports);
	public abstract void generateTimelineFunction(String functionName, List<Port> ports, List<OutputColumn> outputColumns, StringBuilder sb, boolean range);
	public abstract String getDeviceCode(Device device, int deviceIndex, int dataIndex);
}
