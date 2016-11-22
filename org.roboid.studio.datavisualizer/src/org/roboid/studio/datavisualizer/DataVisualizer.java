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

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.roboid.core.runtime.ContentChangeListener;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.Robot;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class DataVisualizer extends ViewPart
{
	private CheckboxTreeViewer viewer;
	private MonitorThread monitor;
	private volatile boolean ACTIVE;
	private IClip currentContent;
	private ContentChangeListener contentListener = new ContentChangeListener()
	{
		@Override
		public void contentChanged(IClip oldContent, IClip newContent)
		{
			handleContentChanged(newContent);
		}
	};

	private void handleContentChanged(IClip newContent)
	{
		if(newContent == currentContent) return;
		currentContent = newContent;
		
		disposeMonitor();
		if(newContent == null)
			viewer.setInput(null);
		else
		{
			Robot newRobot = newContent.getRobot();
			viewer.setInput(newRobot);
			if(newRobot == null) return;
			
			ACTIVE = true;
			monitor = new MonitorThread();
			monitor.start();
		}
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException
	{
		super.init(site);
		ContentsManager.addContentChangeListener(contentListener);
	}
	
	@Override
	public void dispose()
	{
		disposeMonitor();
		ContentsManager.removeContentChangeListener(contentListener);
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent)
	{
		final TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Roboid Devices");
		
		viewer = new CheckboxTreeViewer(tabFolder, SWT.BORDER|SWT.SINGLE);
		viewer.setContentProvider(new RobotItemContentProvider());
		viewer.setLabelProvider(new RobotItemLabelProvider());
		viewer.setAutoExpandLevel(2);
		Tree tree = viewer.getTree();
		tree.setLinesVisible(true);
		tabItem.setControl(tree);
		
		handleContentChanged(ContentsManager.getCurrentContent());
	}

	private void disposeMonitor()
	{
		ACTIVE = false;
		try
		{
			if(monitor != null) monitor.join();
			monitor = null;
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void setFocus()
	{
	}
	
	class MonitorThread extends Thread
	{
		public void run()
		{
			while(ACTIVE)
			{
				Display.getDefault().asyncExec(new Runnable()
				{
					public void run()
					{
						if(ACTIVE && viewer != null)
						{
							viewer.refresh();
						}
					}
				});
				
				try 
				{
					Thread.sleep(200);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
