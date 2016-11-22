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

package org.roboid.studio.portmanager.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.roboid.core.runtime.ContentChangeListener;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IClip;
import org.roboid.core.runtime.SerialPortManager;
import org.roboid.robot.Device;
import org.roboid.robot.Port;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.portmanager.actions.SerialPortAction;
import org.roboid.studio.portmanager.actions.SerialPortAction.SerialPortSelectionChangedListener;

/**
 * @author Kwang-Hyun Park
 */
public class PortManagerView extends ViewPart
{
	private TreeViewer portViewer;
	private IClip currentContent;
	private final List<Port> ports = new ArrayList<Port>();
	private final ContentChangeListener contentListener = new ContentChangeListener()
	{
		@Override
		public void contentChanged(IClip oldContent, IClip newContent)
		{
			handleContentChanged(newContent);
		}
	};
	private final EContentAdapter portAdapter = new EContentAdapter()
	{
		@Override
		public void notifyChanged(org.eclipse.emf.common.notify.Notification notification)
		{
			int featureId = notification.getFeatureID(RobotPackage.class);
			
			if(notification.getNotifier() instanceof Port)
			{
				switch(featureId)
				{
					case RobotPackage.PORT__MODE:
					{
						Port port = (Port)notification.getNotifier();
						if(portViewer != null) portViewer.refresh(port);
						break;
					}
				}
			}
			super.notifyChanged(notification);
		}
	};
	private final SerialPortSelectionChangedListener serialPortSelectionChangedListener = new SerialPortSelectionChangedListener()
	{
		@Override
		public void onSerialPortSelectionChanged(String portName)
		{
			SerialPortManager.setPortName(portName);
		}
	};
	
	private void handleContentChanged(IClip newContent)
	{
		if(newContent == currentContent) return;
		if(currentContent != null)
			currentContent.getResource().eAdapters().remove(portAdapter);
		currentContent = newContent;
		
		if(newContent == null)
			portViewer.setInput(null);
		else
		{
			List<Port> ports = this.ports;
			ports.clear();
			
			Robot robot = newContent.getRobot();
			if(robot != null)
			{
				List<Roboid> roboids = robot.getRoboids();
				if(roboids.size() > 0)
				{
					Roboid roboid = roboids.get(0);
					if(roboid != null)
					{
						for(Device device : roboid.getDevices())
						{
							if(device instanceof Port)
								ports.add((Port)device);
						}
					}
				}
			}
			portViewer.setInput(ports);
			portViewer.expandAll();
			newContent.getResource().eAdapters().add(portAdapter);
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
		ContentsManager.removeContentChangeListener(contentListener);
		if(currentContent != null)
			currentContent.getResource().eAdapters().remove(portAdapter);
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent)
	{
		portViewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI);
		Tree tree = portViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		// 포트 열을 만든다.
		TreeColumn columnModel = new TreeColumn(tree, SWT.NONE);
		columnModel.setText("Port");
		columnModel.setResizable(true);
		columnModel.setWidth(150);

		// 모드 열을 만든다.
		TreeColumn columnComponent = new TreeColumn(tree, SWT.NONE);
		columnComponent.setText("Mode");
		columnComponent.setResizable(true);
		columnComponent.setWidth(150);
		
		portViewer.setColumnProperties(new String[] { "port", "mode" });
		CellEditor[] editors = new CellEditor[2];
		editors[1] = new ComboBoxCellEditor(tree, new String[0], SWT.READ_ONLY);
		portViewer.setCellModifier(new BundleCellModifier(portViewer, editors));
		portViewer.setCellEditors(editors);
		portViewer.setContentProvider(new PortContentProvider());
		portViewer.setLabelProvider(new PortViewLabelProvider(portViewer));
		
		contributeToActionBars();
		handleContentChanged(ContentsManager.getCurrentContent());
	}
	
	@Override
	public void setFocus()
	{
		if(portViewer != null)
			portViewer.getTree().setFocus();
	}
	
	private void contributeToActionBars()
	{
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager)
	{
		SerialPortAction action = new SerialPortAction(manager);
		action.setSerialPortSelectionChangedListener(serialPortSelectionChangedListener);
		manager.add(action);
	}
}
