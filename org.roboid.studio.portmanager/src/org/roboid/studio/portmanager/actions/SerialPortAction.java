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

package org.roboid.studio.portmanager.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.roboid.comm.serial.Serial;

/**
 * @author Kwang-Hyun Park
 */
public class SerialPortAction extends Action
{
	private SerialPortSelectionChangedListener listener;
	
	public SerialPortAction(IToolBarManager manager)
	{
		setText("Serial Port");
		setMenuCreator(new MenuHandler(manager, this));
	}
	
	public void setSerialPortSelectionChangedListener(SerialPortSelectionChangedListener listener)
	{
		this.listener = listener;
	}
	
	void notifySerialPortSelectionChanged(String port)
	{
		if(listener != null)
			listener.onSerialPortSelectionChanged(port);
	}
	
	public interface SerialPortSelectionChangedListener
	{
		public abstract void onSerialPortSelectionChanged(String portName);
	}
	
	private static final class MenuHandler implements IMenuCreator
	{
		private IToolBarManager manager;
		private SerialPortAction container;
		private final Map<String, MenuAction> menus = new HashMap<String, MenuAction>();
		private MenuAction selected;
		
		MenuHandler(IToolBarManager manager, SerialPortAction container)
		{
			this.manager = manager;
			this.container = container;
		}
		
		@Override
		public Menu getMenu(Control parent)
		{
			Menu menu = new Menu(parent);
			MenuAction action;
			String[] names = Serial.list();
			for(String name : names)
			{
				action = getMenuAction(name);
				action.setChecked(false);
				new ActionContributionItem(action).fill(menu, -1);
			}
			if(selected != null)
				selected.setChecked(true);
		    return menu;
		}

		@Override
		public Menu getMenu(Menu parent)
		{
			return null;
		}
		
		@Override
		public void dispose()
		{
		}
		
		private MenuAction getMenuAction(String title)
		{
			MenuAction action = menus.get(title);
			if(action == null)
			{
				action = new MenuAction(this, title);
				menus.put(title, action);
			}
			return action;
		}
		
		void select(MenuAction action)
		{
			selected = action;
			String text = action.getText();
			container.setText(text);
			manager.update(true);
			container.notifySerialPortSelectionChanged(text);
		}
	}
	
	private static final class MenuAction extends Action
	{
		private final MenuHandler handler;
		
		MenuAction(MenuHandler handler, String title)
		{
			this.handler = handler;
			setText(title);
		}
		
		@Override
		public void run()
		{
			handler.select(this);
		}
	}
}
