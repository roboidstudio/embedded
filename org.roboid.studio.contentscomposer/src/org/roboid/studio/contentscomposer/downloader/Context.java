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

package org.roboid.studio.contentscomposer.downloader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.roboid.robot.Command;
import org.roboid.robot.Device;
import org.roboid.robot.IoMode;
import org.roboid.robot.LinearMode;
import org.roboid.robot.Port;
import org.roboid.robot.Roboid;
import org.roboid.studio.contentscomposer.BlockElement;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.board.IBoard;
import org.roboid.studio.contentscomposer.board.OutputColumn;
import org.roboid.studio.contentscomposer.board.OutputCurve;
import org.roboid.studio.timeline.ChannelTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.LinearPoint;
import org.roboid.studio.timeline.MotionClip;

/**
 * @author Kwang-Hyun Park
 */
final class Context
{
	private int index = -1;
	private IBoard board;
	private final List<String> variables = new ArrayList<String>();
	private final Map<BlockElement, AbstractBlockHandler> handlers = new HashMap<BlockElement, AbstractBlockHandler>();
	private List<Port> ports;
	private final List<Device> devices = new ArrayList<Device>();
	private final List<OutputColumn> outputColumns = new ArrayList<OutputColumn>();
	
	Context()
	{
	}
	
	void init(Roboid roboid, IBoard board, List<Port> ports)
	{
		index = -1;
		this.board = board;
		variables.clear();
		variables.add("value");
		handlers.clear();
		this.ports = ports;
		devices.clear();
		roboid.collectAllDevices(devices);
	}
	
	int getNextIndex()
	{
		return ++index;
	}
	
	List<String> getVariables()
	{
		return variables;
	}
	
	Collection<AbstractBlockHandler> getBlockHandlers()
	{
		return handlers.values();
	}
	
	void addVariable(String variable)
	{
		if(variable == null) return;
		if(variables.contains(variable)) return;
		variables.add(variable);
	}
	
	void addBlockHandler(BlockElement block, AbstractBlockHandler downloader)
	{
		handlers.put(block, downloader);
	}
	
	AbstractBlockHandler findBlockHandler(BlockElement block)
	{
		if(block == null) return null;
		return handlers.get(block);
	}
	
	BlockElement getRoot(MotionContent clip)
	{
		for(BlockElement block : clip.getBlocks())
		{
			if(block instanceof RootBlock)
				return block;
		}
		return null;
	}
	
	String getDeviceCode(int deviceIndex, int dataIndex)
	{
		if(deviceIndex < 0 || deviceIndex >= devices.size()) return "";
		Device device = devices.get(deviceIndex);
		return board.getDeviceCode(device, deviceIndex, dataIndex);
	}
	
	void generateOutputs(MotionClip clip, String functionName, StringBuilder sb)
	{
		List<OutputColumn> outputColumns = this.outputColumns;
		outputColumns.clear();
		
		// 전체 제어점의 개수를 구한다.
		List<ChannelTrack> tracks = clip.getControls().get(0).getChannels();
		int totalControlPoints = 0;
		for(ChannelTrack track : tracks)
			totalControlPoints += track.getPoints().size();
		if(totalControlPoints <= 0)
			return;
		
		// 프레임 번호를 수집하고 순서대로 정렬한다.
		int[] frames = new int[totalControlPoints];
		int index = 0;
		for(ChannelTrack track : tracks)
		{
			for(ControlPoint point : track.getPoints())
				frames[index++] = point.getFrame();
		}
		Arrays.sort(frames);
		
		// 출력 칼럼을 구간 개수만큼 생성한다.
		int numTracks = tracks.size();
		int prevFrame = 0;
		for(int frame : frames)
		{
			if(frame != prevFrame)
				outputColumns.add(new OutputColumn(numTracks, prevFrame, frame));
			prevFrame = frame;
		}
		
		List<Port> ports = this.ports;
		ChannelTrack track;
		Device device;
		boolean isTrackSustain;
		int portIndex;
		IoMode portMode;
		List<ControlPoint> controlPoints;
		int numControlPoints;
		LinearPoint controlPoint;
		float[] controlPointValues;
		int dimension;
		float[] tmpValues = null;
		float[] tmpPrevValues = null;
		float[] tmpDiffs = null;
		OutputColumn column;
		OutputCurve curve;
		int tmpFrame, tmpPrevFrame;
		int frameDiff;
		boolean sustain;
		int startFrame, endFrame;
		for(int trackIndex = 0; trackIndex < numTracks; ++trackIndex)
		{
			track = tracks.get(trackIndex);
			device = track.getChannel().getDevices().get(0);
			isTrackSustain = false;
			if(device instanceof Port)
			{
				portIndex = ports.indexOf(device);
				portMode = ((Port)device).getMode();
				if(portMode == IoMode.DIGITAL_OUTPUT)
					isTrackSustain = true;
			}
			else
			{
				portIndex = -1;
				portMode = IoMode.NONE;
				if(device instanceof Command)
					isTrackSustain = true;
			}
			sustain = true;
			
			controlPoints = track.getPoints();
			numControlPoints = controlPoints.size();
			if(numControlPoints > 0)
			{
				controlPoint = (LinearPoint)controlPoints.get(0);
				tmpFrame = controlPoint.getFrame();
				controlPointValues = controlPoint.getValues();
				dimension = controlPointValues.length;
				
				if(numControlPoints == 1)
				{
					for(int i = 0, N = outputColumns.size(); i < N; ++i)
					{
						column = outputColumns.get(i);
						curve = new OutputCurve(dimension, true, portIndex, portMode);
						column.setCurve(trackIndex, curve);
						if(column.getEndFrame() <= tmpFrame)
						{
							for(int j = 0; j < dimension; ++j)
								curve.setStartValue(j, 0.0f);
						}
						else
						{
							for(int j = 0; j < dimension; ++j)
								curve.setStartValue(j, controlPointValues[j]);
						}
					}
				}
				else
				{
					if(tmpValues == null || tmpValues.length < dimension)
						tmpValues = new float[dimension];
					if(tmpPrevValues == null || tmpPrevValues.length < dimension)
						tmpPrevValues = new float[dimension];
					if(tmpDiffs == null || tmpDiffs.length < dimension)
						tmpDiffs = new float[dimension];
					
					index = 0;
					tmpPrevFrame = 0;
					for(int i = 0; i < dimension; ++i)
					{
						tmpPrevValues[i] = 0.0f;
						tmpValues[i] = controlPointValues[i];
						tmpDiffs[i] = tmpValues[i] - tmpPrevValues[i];
					}
					frameDiff = tmpFrame - tmpPrevFrame;

					for(int i = 0, N = outputColumns.size(); i < N; ++i)
					{
						while(frameDiff == 0)
						{
							++ index;
							if(index >= numControlPoints)
								break;
							sustain = isTrackSustain || (controlPoint.getMode() == LinearMode.SUSTAIN);
							controlPoint = (LinearPoint)controlPoints.get(index);
							tmpPrevFrame = tmpFrame;
							tmpFrame = controlPoint.getFrame();
							controlPointValues = controlPoint.getValues();
							for(int j = 0; j < dimension; ++j)
							{
								tmpPrevValues[j] = tmpValues[j];
								tmpValues[j] = controlPointValues[j];
								tmpDiffs[j] = tmpValues[j] - tmpPrevValues[j];
							}
							frameDiff = tmpFrame - tmpPrevFrame;
						}
						if(frameDiff == 0) continue;
						
						column = outputColumns.get(i);
						curve = new OutputCurve(dimension, sustain, portIndex, portMode);
						column.setCurve(trackIndex, curve);
						if(sustain)
						{
							for(int j = 0; j < dimension; ++j)
								curve.setStartValue(j, tmpPrevValues[j]);
						}
						else
						{
							startFrame = column.getStartFrame();
							endFrame = column.getEndFrame();
							for(int j = 0; j < dimension; ++j)
							{
								curve.setStartValue(j, (tmpPrevValues[j] + tmpDiffs[j] * (startFrame - tmpPrevFrame) / frameDiff));
								curve.setEndValue(j, (tmpPrevValues[j] + tmpDiffs[j] * (endFrame - tmpPrevFrame) / frameDiff));
							}
						}
						
						if(column.getEndFrame() >= tmpFrame)
						{
							++ index;
							tmpPrevFrame = tmpFrame;
							System.arraycopy(tmpValues, 0, tmpPrevValues, 0, dimension);
							if(index < numControlPoints)
							{
								sustain = isTrackSustain || (controlPoint.getMode() == LinearMode.SUSTAIN);
								controlPoint = (LinearPoint)controlPoints.get(index);
								tmpFrame = controlPoint.getFrame();
								controlPointValues = controlPoint.getValues();
								for(int j = 0; j < dimension; ++j)
								{
									tmpValues[j] = controlPointValues[j];
									tmpDiffs[j] = tmpValues[j] - tmpPrevValues[j];
								}
								frameDiff = tmpFrame - tmpPrevFrame;
							}
							else
								sustain = true;
						}
					}
				}
			}
		}
		board.generateTimelineFunction(functionName, ports, outputColumns, sb, true);
	}
}
