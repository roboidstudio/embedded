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

import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Item;
import org.roboid.robot.Port;
import org.roboid.robot.Roboid;
import org.roboid.studio.portmanager.board.BoardManager;
import org.roboid.studio.portmanager.board.IBoard;

/**
 * @author Kwang-Hyun Park
 */
public class BundleCellModifier implements ICellModifier
{
	private final Viewer viewer;
	private final CellEditor[] editors;
	
	public BundleCellModifier(Viewer viewer, CellEditor[] editors)
	{
		this.viewer = viewer;
		this.editors = editors;
//		List<PinMode> modes = PinMode.VALUES;
//		int sz = modes.size();
//		String[] labels = new String[sz];
//		for(int i = 0; i < sz; ++i)
//			labels[i] = modes.get(i).getName();
//		
//		ComboBoxCellEditor editor = (ComboBoxCellEditor)editors[1];
//		editor.setItems(labels);
	}
	
	/**
	 * make item list of selected roboid model and set it in editor
	 * return false when the number of bundle is one.
	 */
	@Override
	public boolean canModify(Object element, String property)
	{
		if(!property.equals("mode")) return false;
		if(!(element instanceof Port)) return false;
		
		return true;
	}
	
	@Override
	public Object getValue(Object element, String property)
	{
		if(!property.equals("mode")) return Integer.valueOf(-1);
		if(!(element instanceof Port)) return Integer.valueOf(-1);
		
		Port port = (Port)element;
		Object parent = port.getParent();
		if(parent instanceof Roboid)
		{
			Object input = viewer.getInput();
			if(input instanceof List<?>)
			{
				int portIndex = ((List<?>)input).indexOf(port);
				ComboBoxCellEditor editor = (ComboBoxCellEditor)editors[1];
				String id = ((Roboid)parent).getId();
				IBoard board = BoardManager.getBoard(id);
				if(board != null)
				{
					editor.setItems(board.getModeLabels(portIndex));
					return Integer.valueOf(board.indexOfMode(port, portIndex));
				}
			}
		}
		return Integer.valueOf(-1);
	}

	@Override
	public void modify(Object element, String property, Object value)
	{
		if(element instanceof Item)
			element = ((Item)element).getData();
		
		if(element instanceof Port)
		{
			Port port = (Port)element;
			Object parent = port.getParent();
			if(parent instanceof Roboid)
			{
				Object input = viewer.getInput();
				if(input instanceof List<?>)
				{
					int portIndex = ((List<?>)input).indexOf(port);
					ComboBoxCellEditor editor = (ComboBoxCellEditor)editors[1];
					String id = ((Roboid)parent).getId();
					IBoard board = BoardManager.getBoard(id);
					if(board != null)
					{
						editor.setItems(board.getModeLabels(portIndex));
						int selection = ((Integer)value).intValue();
						board.selectMode(port, portIndex, selection);
					}
				}
			}
		}
	}
}
