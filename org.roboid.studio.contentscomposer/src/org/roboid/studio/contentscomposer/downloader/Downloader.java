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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.roboid.robot.Device;
import org.roboid.robot.Port;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.board.BoardFactory;
import org.roboid.studio.contentscomposer.board.IBoard;

/**
 * @author Kwang-Hyun Park
 */
public final class Downloader
{
	private final IBoard board;
	private final Context context = new Context();
	private final List<Port> ports = new ArrayList<Port>();
	private static final Map<String, Downloader> sMap = new HashMap<String, Downloader>();
	
	private static final String VARIABLE = "__VARIABLE__";
	private static final String FUNCTION = "__FUNCTION__";
	private static final String PROTOTYPE = "__PROTOTYPE__";
	private static final String START = "__START__";
	
	private Downloader(String id)
	{
		board = BoardFactory.createBoard(id);
	}
	
	public static Downloader get(String id)
	{
		Downloader downloader = sMap.get(id);
		if(downloader == null)
		{
			downloader = new Downloader(id);
			sMap.put(id, downloader);
		}
		downloader.init();
		return downloader;
	}
	
	private void init()
	{
		if(board != null) board.initPath("_cc");
	}
	
	private void collectPorts(Roboid roboid)
	{
		List<Device> devices = roboid.getDevices();
		List<Port> ports = this.ports;
		ports.clear();
		
		for(Device device : devices)
		{
			if(device instanceof Port)
				ports.add((Port)device);
		}
	}
	
	public void run(MotionContent clip)
	{
		if(clip == null || board == null) return;
		
		Robot robot = clip.getRobot();
		if(robot == null) return;
		
		List<Roboid> roboids = robot.getRoboids();
		if(roboids == null) return;
		if(roboids.size() <= 0) return;
		
		Roboid roboid = roboids.get(0);
		if(roboid == null) return;
		
		collectPorts(roboid);
		
		Context context = this.context;
		context.init(roboid, board, ports);
		
		String template = board.readTemplate();
		template = board.generateSetup(template, ports);
		
		// 함수 이름을 모두 만든다.
		new ContentsClipBlockHandler(context, "", null).createBlockHandlers(context, clip);
		
		StringBuilder sb = new StringBuilder();
		for(String variable : context.getVariables())
		{
			sb.append("int ");
			sb.append(variable);
			sb.append(" = 0;\n");
		}
		template = template.replace(VARIABLE, sb.toString());
		
		sb = new StringBuilder();
		for(AbstractBlockHandler handler : context.getBlockHandlers())
		{
			handler.createPrototypeCode(context, sb);
		}
		template = template.replace(PROTOTYPE, sb.toString());
		
		sb = new StringBuilder();
		for(AbstractBlockHandler handler : context.getBlockHandlers())
		{
			handler.createFunctionCode(context, sb);
		}
		template = template.replace(FUNCTION, sb.toString());
		
		AbstractBlockHandler rootHandler = context.findBlockHandler(context.getRoot(clip));
		if(rootHandler != null)
		{
			sb = new StringBuilder();
			sb.append(rootHandler.getFunctionName());
			sb.append("();\n");
			template = template.replace(START, sb.toString());
		}
		
		board.download(template);
		
		ports.clear();
	}
}
