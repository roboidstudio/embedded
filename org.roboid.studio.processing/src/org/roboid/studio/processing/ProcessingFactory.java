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

package org.roboid.studio.processing;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ProcessingFactory
{
	private ScriptEngine scriptEngine;
	private List<Processing> processings = new ArrayList<Processing>();
	
	public ProcessingFactory(ScriptEngine engine)
	{
		this.scriptEngine = engine;
	}
	
	/**
	 * Constructs a new instance of the processing with a frame.
	 * The initial location of the window is the previous location or origin (0, 0).
	 * @return a new instance of the processing
	 */
	public Processing create()
	{
		return create(true);
	}
	
	/**
	 * Constructs a new instance of the processing with or without its frame according to the argument.
	 * The initial location of the window is the previous location or origin (0, 0).
	 * @param hasFrame {@code true} if the processing has a frame and {@code false} otherwise
	 * @return a new instance of the processing
	 */
	public Processing create(boolean hasFrame)
	{
		Processing processing = Processing.create(scriptEngine, hasFrame);
		processings.add(processing);
		return processing;
	}
	
	/**
	 * Closes all the processings
	 */
	public void close()
	{
		for(Processing processing : processings)
			processing.close();
	}	
}
