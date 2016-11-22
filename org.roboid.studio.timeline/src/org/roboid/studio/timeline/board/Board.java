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

package org.roboid.studio.timeline.board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.Platform;
import org.roboid.core.runtime.SerialPortManager;
import org.roboid.robot.IoMode;
import org.roboid.robot.Port;

/**
 * @author Kwang-Hyun Park
 */
public abstract class Board implements IExecutableExtension, IBoard
{
	private final String templateFileTitle;
	private final String outputFileName;
	private final String exeFilePath;
	private IConfigurationElement config;
	private String id;
	private String templateFileName;
	private File path = null;
	
	protected static final String SERVO = "__SERVO__";
	protected static final String SETUP = "__SETUP__";
	protected static final String OUTPUT = "__OUTPUT__";
	
	protected static final String LABEL_NONE = "None";
	protected static final String LABEL_ANALOG_INPUT = "Analog Input";
	protected static final String LABEL_DIGITAL_INPUT = "Digital Input";
	protected static final String LABEL_SERVO_OUTPUT = "Servo Output";
	protected static final String LABEL_PWM_OUTPUT = "PWM Output";
	protected static final String LABEL_DIGITAL_OUTPUT = "Digital Output";
	
	protected static final String LABEL_DISABLE = "Disable";
	protected static final String LABEL_ENABLE = "Enable";
	
	protected Board(String templateFileTitle, String outputFileName, String exeFileName)
	{
		this.templateFileTitle = templateFileTitle;
		this.outputFileName = outputFileName;
		exeFilePath = new File(getDownloaderPath(), exeFileName).getAbsolutePath();
	}
	
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException
	{
		this.config = config;
		
		id = config.getAttribute("id");
		if(id == null) id = "";
	}
	
	@Override
	public IConfigurationElement getConfig()
	{
		return config;
	}
	
	@Override
	public String getId()
	{
		return id;
	}
	
	@Override
	public String getModeLabel(Port port, int portIndex)
	{
		switch(port.getMode().getValue())
		{
		case IoMode.ANALOG_INPUT_VALUE: return LABEL_ANALOG_INPUT;
		case IoMode.DIGITAL_INPUT_VALUE: return LABEL_DIGITAL_INPUT;
		case IoMode.SERVO_OUTPUT_VALUE: return LABEL_SERVO_OUTPUT;
		case IoMode.PWM_OUTPUT_VALUE: return LABEL_PWM_OUTPUT;
		case IoMode.DIGITAL_OUTPUT_VALUE: return LABEL_DIGITAL_OUTPUT;
		}
		return LABEL_NONE;
	}
	
	private File getDownloaderPath()
	{
		if(path == null)
			path = new File(Platform.getInstallLocation().getURL().getPath(), "downloader");
		return path;
	}
	
	@Override
	public void initPath(String suffix)
	{
		templateFileName = templateFileTitle + suffix + ".template";
	}
	
	@Override
	public File getOutputFile()
	{
		File path = getDownloaderPath();
		return new File(path, outputFileName);
	}
	
	@Override
	public String readTemplate()
	{
		if(templateFileName == null) return "";
		
		String template = "";
		BufferedReader br = null;
		try
		{
			File path = getDownloaderPath();
			File file = new File(path, templateFileName);
			br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			if(line != null)
			{
				sb.append(line);
				while((line = br.readLine())!= null)
					sb.append("\n" + line);
			}
			template = sb.toString();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
				}
			}
		}
		return template;
	}
	
	@Override
	public void download(String code)
	{
		boolean success = false;
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(getOutputFile()));
			writer.write(code);
			success = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if(writer != null)
			{
				try
				{
					writer.close();
				} catch (IOException e)
				{
				}
			}
		}
		
		if(success)
		{
			try
			{
				String portName = SerialPortManager.getPortName();
				if(portName != null)
					Runtime.getRuntime().exec(new String[] { exeFilePath, outputFileName, portName}, null, getDownloaderPath());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
