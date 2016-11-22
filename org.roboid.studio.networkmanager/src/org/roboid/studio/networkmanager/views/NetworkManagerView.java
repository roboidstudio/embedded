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

package org.roboid.studio.networkmanager.views;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.roboid.core.runtime.network.NetworkItem;
import org.roboid.core.runtime.network.NetworkManager;
import org.roboid.core.runtime.network.NetworkNotificationListener;
import org.roboid.core.runtime.network.Notification;

/**
 * @author Kwang-Hyun Park
 */
public class NetworkManagerView extends ViewPart
{
	private TreeViewer viewer;
	private List<NetworkItem> items = NetworkManager.copyNetworkItems();
	private NetworkNotificationListener networkNotificationListener = new NetworkNotificationListener()
	{
		@Override
		public void onNotify(Notification notification)
		{
			handleNetworkMessage(notification);
		}
	};
	
	public NetworkManagerView()
	{
	}

	@Override
	public void init(IViewSite site) throws PartInitException
	{
		super.init(site);
		NetworkManager.addNetworkNotificationListener(networkNotificationListener);
	}

	@Override
	public void dispose()
	{
		NetworkManager.removeNetworkNotificationListener(networkNotificationListener);
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent)
	{
		viewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI);
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		TreeColumn columnName = new TreeColumn(tree, SWT.NONE);
		columnName.setText(Messages.NetworkManagerView_Name);
		columnName.setResizable(true);
		columnName.setWidth(350);
		
		TreeColumn columnStatus = new TreeColumn(tree, SWT.NONE);
		columnStatus.setText(Messages.NetworkManagerView_Status);
		columnStatus.setResizable(true);
		columnStatus.setWidth(300);
		
		viewer.setContentProvider(new NetworkContentProvider());
		viewer.setLabelProvider(new NetworkLabelProvider());
		
		viewer.setInput(items);
		viewer.expandAll();
	}

	@Override
	public void setFocus()
	{
	}
	
	private void handleNetworkMessage(Notification notification)
	{
		switch(notification.getCommand())
		{
		case Notification.COMMAND_ADD:
		case Notification.COMMAND_REMOVE:
			items = NetworkManager.copyNetworkItems();
			break;
		}
		Display display = viewer.getControl().getDisplay();
		if(display == null) return;
		display.syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				viewer.setInput(items);
				viewer.expandAll();
			}
		});
	}
}
