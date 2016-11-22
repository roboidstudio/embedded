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

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.roboid.robot.Port;
import org.roboid.robot.Roboid;
import org.roboid.studio.portmanager.Activator;
import org.roboid.studio.portmanager.board.BoardManager;
import org.roboid.studio.portmanager.board.IBoard;

import com.swtdesigner.ResourceManager;

/**
 * @author Kwang-Hyun Park
 */
public class PortViewLabelProvider extends LabelProvider implements ITableLabelProvider
{
	private final Viewer viewer;
	private final Image image;
	
	public PortViewLabelProvider(Viewer viewer)
	{
		this.viewer = viewer;
		image = ResourceManager.getImage(Activator.getImageDescriptor("icons/pin_blue.png"));
	}
	
	@Override
	public Image getColumnImage(Object element, int columnIndex)
	{
		if(columnIndex == 0)
			return image;
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex)
	{
		if(element instanceof Port)
		{
			Port port = (Port)element;
			switch(columnIndex)
			{
				case 0:
					return port.getName();
				case 1:
				{
					Object parent = port.getParent();
					if(parent instanceof Roboid)
					{
						Object input = viewer.getInput();
						if(input instanceof List<?>)
						{
							int index = ((List<?>)input).indexOf(port);
							String id = ((Roboid)parent).getId();
							IBoard board = BoardManager.getBoard(id);
							if(board != null)
								return board.getModeLabel(port, index);
						}
					}
					return "";
				}
			}
		}
		return "";
	}
}
