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

import java.util.List;

import org.roboid.robot.Device;
import org.roboid.robot.IoMode;
import org.roboid.robot.Port;

/**
 * @author Kwang-Hyun Park
 */
public class ModiBoard extends Board
{
	public static final String ID = "com.luxrobo.physical.modi";
	
	private static final int MOTOR = 0;
	private static final int LED = 1;
	private static final int IR = 2;
	private static final int GYRO = 3;
	private static final int COLOR = 4;
	
	private static final String[] LABELS = { LABEL_DISABLE, LABEL_ENABLE };
	
	public ModiBoard()
	{
		super("luxrobo", "luxrobo.c", "luxrobo.cmd");
	}
	
	@Override
	public String[] getModeLabels(int portIndex)
	{
		return LABELS;
	}
	
	@Override
	public String getModeLabel(Port port, int portIndex)
	{
		switch(port.getMode().getValue())
		{
		case IoMode.NONE_VALUE: return LABEL_DISABLE;
		}
		return LABEL_ENABLE;
	}

	@Override
	public int indexOfMode(Port port, int portIndex)
	{
		return (port.getMode() == IoMode.NONE) ? 0 : 1;
	}
	
	@Override
	public void selectMode(Port port, int portIndex, int selection)
	{
		switch(selection)
		{
		case 1: port.setMode(IoMode.PWM_OUTPUT); break;
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
			switch(i)
			{
			case MOTOR:
				sb.append("\tinitMotor(");
				break;
			case LED:
				sb.append("\tinitLed(");
				break;
			case IR:
				sb.append("\tinitIr(");
				break;
			case GYRO:
				sb.append("\tinitGyro(");
				break;
			case COLOR:
				sb.append("\tinitColor(");
				break;
			}
			if(ports.get(i).getMode() == IoMode.NONE)
				sb.append("DISABLE");
			else
				sb.append("ENABLE");
			sb.append(");\n");
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
			sb.append("\tint frame;\n\tdouble value1, value2, value3;\n");
			
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
						switch(j)
						{
						case MOTOR:
							for(int k = 0; k < 2; ++k)
							{
								startValue = curve.getStartValue(k);
								endValue = curve.getEndValue(k);
								sb.append("\t\tvalue");
								sb.append(k + 1);
								sb.append(" = ");
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
							}
							sb.append("\t\twriteMotor((int)value1, (int)value2);\n");
							break;
						case LED:
							for(int k = 0; k < 3; ++k)
							{
								startValue = curve.getStartValue(k);
								endValue = curve.getEndValue(k);
								sb.append("\t\tvalue");
								sb.append(k + 1);
								sb.append(" = ");
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
							}
							sb.append("\t\twriteLed((int)value1, (int)value2, (int)value3);\n");
							break;
						}
					}
				}
				sb.append("\t\tvTaskDelay(20);\n\t}\n");
			}
		}
		sb.append("}\n");
	}
	
	@Override
	public String getDeviceCode(Device device, int deviceIndex, int dataIndex)
	{
		StringBuilder sb = new StringBuilder();
		switch(deviceIndex)
		{
		case IR: // ir
			sb.append("readIr()");
			break;
		case GYRO: // gyro
			sb.append("readGyro(");
			sb.append(dataIndex);
			sb.append(")");
			break;
		case COLOR: // color
			sb.append("readColor(");
			sb.append(dataIndex);
			sb.append(")");
			break;
		}
		return sb.toString();
	}
}
