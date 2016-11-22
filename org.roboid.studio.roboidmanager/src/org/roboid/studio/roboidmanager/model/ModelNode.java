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

package org.roboid.studio.roboidmanager.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.viewers.TreeNode;
import org.roboid.core.ExtensionManager;
import org.roboid.core.runtime.RobotManager;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ModelNode extends AbstractNode
{
	private String id;
	private String category;
	
	public ModelNode(final TreeNode parent, final Object value)
	{
		super(parent, value);
		id = ExtensionManager.toRoboidId((IExtension)value);
		category = RobotManager.getCategory((IExtension)value);
	}
	
	public void createChildNodes()
	{
		List<IExtension> roboidExtensionList = ExtensionManager.getRoboidExtensions(id);
		List<IExtension> addonExtensionList = ExtensionManager.getAddonExtensions(id);

		List<TreeNode> childNodes = new ArrayList<TreeNode>();
		for(IExtension extension : roboidExtensionList)
			childNodes.add(new ExtensionNode(this, extension));

		for(IExtension extension : addonExtensionList)
			childNodes.add(new ExtensionNode(this, extension));
		
		setChildren(childNodes.toArray(new TreeNode[childNodes.size()]));
	}

	public String getId()
	{
		return id; 
	}
	
	public String getCategory()
	{
		return category;
	}
}
