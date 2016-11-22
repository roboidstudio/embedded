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

package org.roboid.studio.robotcomposer;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.roboid.robot.Command;
import org.roboid.robot.Device;
import org.roboid.robot.Effector;
import org.roboid.robot.Event;
import org.roboid.robot.MotoringDevice;
import org.roboid.robot.Roboid;
import org.roboid.robot.Sensor;
import org.roboid.robot.SensoryDevice;
import org.roboid.studio.robotcomposer.editparts.RoboidBlockEditPart;
import org.roboid.studio.robotcomposer.provider.DeviceItemProvider;
import org.roboid.studio.robotcomposer.provider.RoboidItemProvider;
import org.roboid.studio.robotcomposer.provider.RobotItemProviderAdapterFactory;

/**
 * @author Kwang-Hyun Park
 */
public class DeviceSelectionMenu
{
	private AdapterFactory factory = new RobotItemProviderAdapterFactory();
	private Menu menu;
	private Device source;
	private Device target;
	private Device result;
	
	public Device open(RoboidBlockEditPart editPart, Device source)
	{
		return open(editPart, source, null);
	}
	
	public Device open(RoboidBlockEditPart editPart, Device source, Device target)
	{
		this.source = source;
		this.target = target;
		result = null;
		
		Control control = editPart.getViewer().getControl();
		menu = new Menu(control);
		if(fillMenu(menu, editPart) == false)
		{
			menu.dispose();
			return null;
		}
		
		Rectangle rect = editPart.getFigure().getBounds().getCopy();
		editPart.getFigure().translateToAbsolute(rect);
		Point pt = control.toDisplay(rect.right(), rect.y);
		menu.setLocation(pt);
		menu.setVisible(true);

		Display display = control.getDisplay();
		while(!menu.isDisposed () && menu.isVisible ())
		{
			if(!display.readAndDispatch ()) display.sleep ();
		}
		menu.dispose();
		return result;
	}
	
	private boolean fillMenu(Menu menu, RoboidBlockEditPart editPart)
	{
		RoboidBlock block = editPart.getModel();
		if(block == null) return false;
		
		if(source == null)
			return fillSourceMenu(menu, block.getRoboid());
		else
			return fillTargetMenu(menu, block, block.getRoboid());
	}
	
	private boolean fillSourceMenu(Menu menu, Roboid roboid)
	{
		if(roboid == null) return false;
		
		for(Device sourceDevice : roboid.getDevices())
		{
			if(sourceDevice.isProxy())
			{
				if(sourceDevice.getProxyFor() != null) continue;
			}
			else if(!(sourceDevice instanceof SensoryDevice))
				continue;
			
			if(target != null)
			{
				if(sourceDevice.isProxy())
				{
					if(!sourceDevice.getClass().equals(target.getClass())) continue;
					if(!sourceDevice.isDataTypeOf(target)) continue;
				}
				else
				{
					if(sourceDevice instanceof Sensor)
					{
						if(!(target instanceof Effector)) continue;
					}
					else if(sourceDevice instanceof Event)
					{
						if(!(target instanceof Command)) continue;
					}
					if(!sourceDevice.isDataTypeOf(target)) continue;
				}
			}
			createMenuItem(menu, sourceDevice);
		}
		
		for(Roboid child : roboid.getRoboids())
		{
			Menu subMenu = new Menu(menu);
			if(fillSourceMenu(subMenu, child))
				createSubMenuItem(menu, subMenu, child);
		}
		return menu.getItemCount() != 0;
	}
	
	private boolean fillTargetMenu(Menu menu, RoboidBlock targetBlock, Roboid roboid)
	{
		if(roboid == null) return false;
		
		for(Device targetDevice : roboid.getDevices())
		{
			if(targetBlock.findDeviceElement(targetDevice) != null) continue;
			if(source.isProxy())
			{
				if(!source.getClass().equals(targetDevice.getClass())) continue;
				if(!source.isDataTypeOf(targetDevice)) continue;
			}
			else
			{
				if(!(targetDevice instanceof MotoringDevice)) continue;
				if(source instanceof Sensor)
				{
					if(!(targetDevice instanceof Effector)) continue;
				}
				else if(source instanceof Event)
				{
					if(!(targetDevice instanceof Command)) continue;
				}
				if(!source.isDataTypeOf(targetDevice)) continue;
			}
			createMenuItem(menu, targetDevice);
		}
		
		for(Roboid child : roboid.getRoboids())
		{
			Menu subMenu = new Menu(menu);
			if(fillTargetMenu(subMenu, targetBlock, child))
				createSubMenuItem(menu, subMenu, child);
		}
		return menu.getItemCount() != 0;
	}
	
	private void createMenuItem(Menu menu, Device device)
	{
		MenuItem item = new MenuItem(menu, SWT.NONE);
		item.setText(device.getName());
		item.setData(device);
		DeviceItemProvider p = (DeviceItemProvider)factory.adapt(device, IItemLabelProvider.class);
		Image image = ExtendedImageRegistry.INSTANCE.getImage(p.getImage(device));
		item.setImage(image);
		item.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				result = (Device)e.widget.getData();
			}
		});
	}
	
	private void createSubMenuItem(Menu parent, Menu subMenu, Roboid roboid)
	{
		MenuItem item = new MenuItem(parent, SWT.CASCADE);
		item.setText(roboid.getName());
		RoboidItemProvider p = (RoboidItemProvider)factory.adapt(roboid, IItemLabelProvider.class);
		Image image = ExtendedImageRegistry.INSTANCE.getImage(p.getImage(roboid));
		item.setImage(image);
		item.setMenu(subMenu);
	}
}
