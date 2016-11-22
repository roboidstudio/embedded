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

package org.roboid.studio.contentscomposer.player;

import javax.script.ScriptEngine;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.MessageConsoleStream;
import org.roboid.core.runtime.IClipPlayer;
import org.roboid.core.runtime.ISystem;
import org.roboid.core.runtime.RobotManager;
import org.roboid.studio.contentscomposer.FlashFactory;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.RoboidBrowserFactory;
import org.roboid.studio.processing.ProcessingFactory;
import org.roboid.ui.console.ConsoleFactory;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ClipPlayer implements IClipPlayer
{
	private MotionContent clip;
	private AbstractClipPlayer blockPlayer;
	private ProcessingFactory processing;
	
	public ClipPlayer(MotionContent clip)
	{
		this.clip = clip;
	}
	
	@Override
	public void activate(final Shell shell, final ISystem system)
	{
		if(clip == null) return;
		
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				ScriptEngine engine = clip.createScriptEngine();
				engine.put("browser", new RoboidBrowserFactory(shell));
				engine.put("flash", new FlashFactory(shell));
				MessageConsoleStream console = ConsoleFactory.getInstance();
				console.setActivateOnWrite(true);
				engine.put("console", console);
				engine.put("diagram", clip);
				processing = new ProcessingFactory(engine);
				engine.put("processing", processing);
				if(system != null)
					engine.put("system", system);
			}
		});
		
		blockPlayer = new ContentClipPlayer(RobotManager.getCurrentRobot());
		blockPlayer.setContent(clip);
		clip.reset();
	}

	@Override
	public boolean execute()
	{
		if(blockPlayer == null) return false;
		return blockPlayer.play() != -1;
	}

	@Override
	public void deactivate()
	{
		if(processing != null) processing.close();
	}
}
