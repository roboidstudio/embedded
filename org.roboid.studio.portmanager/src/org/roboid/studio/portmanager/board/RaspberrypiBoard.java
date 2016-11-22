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

import java.util.List;

import org.roboid.robot.Device;
import org.roboid.robot.IoMode;
import org.roboid.robot.Port;

/**
 * @author Kwang-Hyun Park
 */
public class RaspberrypiBoard extends Board
{
	public static final String ID = "org.raspberrypi.physical.pi";
	
	private static final int[] GPIO = { 4, 5, 6, 12, 13, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
	private static final String[] LABELS = { LABEL_NONE, LABEL_DIGITAL_INPUT, LABEL_DIGITAL_OUTPUT, LABEL_PWM_OUTPUT, LABEL_SERVO_OUTPUT };
	
	public RaspberrypiBoard()
	{
		super("raspberrypi", "raspberrypi.c", "raspberrypi.cmd");
	}
	
	@Override
	public String[] getModeLabels(int portIndex)
	{
		return LABELS;
	}
	
	@Override
	public int indexOfMode(Port port, int portIndex)
	{
		switch(port.getMode().getValue())
		{
		case IoMode.DIGITAL_INPUT_VALUE: return 1;
		case IoMode.DIGITAL_OUTPUT_VALUE: return 2;
		case IoMode.PWM_OUTPUT_VALUE: return 3;
		case IoMode.SERVO_OUTPUT_VALUE: return 4;
		}
		return 0;
	}
	
	@Override
	public void selectMode(Port port, int portIndex, int selection)
	{
		switch(selection)
		{
		case 1: port.setMode(IoMode.DIGITAL_INPUT); break;
		case 2: port.setMode(IoMode.DIGITAL_OUTPUT); break;
		case 3: port.setMode(IoMode.PWM_OUTPUT); break;
		case 4: port.setMode(IoMode.SERVO_OUTPUT); break;
		default: port.setMode(IoMode.NONE); break;
		}
	}
	
	@Override
	public String generateSetup(String template, List<Port> ports)
	{
		if(template == null || ports == null) return template;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0, sz = ports.size(); i < sz; ++i)
		{
			switch(ports.get(i).getMode().getValue())
			{
			case IoMode.DIGITAL_INPUT_VALUE:
				sb.append("\tpinMode(");
				sb.append(GPIO[i]);
				sb.append(", INPUT);\n");
				break;
			case IoMode.SERVO_OUTPUT_VALUE:
			case IoMode.PWM_OUTPUT_VALUE:
				sb.append("\tpinMode(");
				sb.append(GPIO[i]);
				sb.append(", OUTPUT);\n");
				sb.append("\tsoftPwmCreate(");
				sb.append(GPIO[i]);
				sb.append(", PWM_MIN, PWM_MAX);\n");
				break;
			case IoMode.DIGITAL_OUTPUT_VALUE:
				sb.append("\tpinMode(");
				sb.append(GPIO[i]);
				sb.append(", OUTPUT);\n");
				break;
			}
		}
		return template.replace(SETUP, sb.toString());
	}

	@Override
	public void generateTimelineFunction(String functionName, List<Port> ports, List<OutputColumn> outputColumns, StringBuilder sb, boolean range)
	{
		if(functionName == null || ports == null || outputColumns == null) return;
		
		sb.append("void ");
		sb.append(functionName);
		if(range)
			sb.append("(int start, int end) {\n");
		else
			sb.append("() {\n");
		
		int numOutputColumns = outputColumns.size();
		if(numOutputColumns > 0)
		{
			sb.append("\tint frame;\n\tdouble value;\n");
			
			String condition = "";
			if(range)
			{
				sb.append("\tif(end < 0)\n\t\tend = ");
				sb.append(outputColumns.get(numOutputColumns - 1).getEndFrame());
				sb.append(";\n");
				condition = " && frame >= start && frame <= end";
			}

			OutputColumn column;
			OutputCurve curve;
			float startValue, endValue;
			int startFrame, endFrame;
			for(int i = 0, sz = outputColumns.size(); i < sz; ++i)
			{
				column = outputColumns.get(i);
				startFrame = column.getStartFrame();
				endFrame = column.getEndFrame();
				
				sb.append("\tfor(frame = ");
				sb.append(startFrame);
				if(i == sz - 1)
					sb.append("; frame <= ");
				else
					sb.append("; frame < ");
				sb.append(endFrame);
				sb.append(condition);
				sb.append("; ++frame) {\n");
				
				for(int j = 0, N = column.countCurves(); j < N; ++j)
				{
					curve = column.getCurve(j);
					if(curve != null)
					{
						startValue = curve.getStartValue(0);
						endValue = curve.getEndValue(0);
						
						switch(curve.getPortMode().getValue())
						{
						case IoMode.DIGITAL_OUTPUT_VALUE:
							sb.append("\t\tdigitalWrite(");
							sb.append(GPIO[j]);
							sb.append(", ");
							if(startValue == 0.0f)
								sb.append(0);
							else
								sb.append(1);
							sb.append(");\n");
							break;
						case IoMode.PWM_OUTPUT_VALUE:
							sb.append("\t\tvalue = ");
							if(curve.isSustain() || (startValue == endValue))
								sb.append(startValue);
							else
							{
								sb.append(startValue);
								sb.append(" + ");
								sb.append(endValue - startValue);
								sb.append(" * (frame - ");
								sb.append(startFrame);
								sb.append(") / ");
								sb.append(endFrame - startFrame);
							}
							sb.append(";\n");
							sb.append("\t\trsPwmWrite(");
							sb.append(GPIO[j]);
							sb.append(", value);\n");
							break;
						case IoMode.SERVO_OUTPUT_VALUE:
							sb.append("\t\tvalue = ");
							if(curve.isSustain() || (startValue == endValue))
								sb.append(startValue);
							else
							{
								sb.append(startValue);
								sb.append(" + ");
								sb.append(endValue - startValue);
								sb.append(" * (frame - ");
								sb.append(startFrame);
								sb.append(") / ");
								sb.append(endFrame - startFrame);
							}
							sb.append(";\n");
							sb.append("\t\trsServoWrite(");
							sb.append(GPIO[j]);
							sb.append(", value);\n");
							break;
						}
					}
				}
				sb.append("\t\tdelay(20);\n\t}\n");
			}
		}
		sb.append("}\n");
	}
	
	@Override
	public String getDeviceCode(Device device, int deviceIndex, int dataIndex)
	{
		StringBuilder sb = new StringBuilder();
		if(device instanceof Port)
		{
			sb.append("digitalRead(");
			sb.append(GPIO[deviceIndex]);
			sb.append(")");
		}
		else
		{
			sb.append("rsAnalogRead(");
			sb.append(deviceIndex - 17);
			sb.append(")");
		}
		return sb.toString();
	}
}
