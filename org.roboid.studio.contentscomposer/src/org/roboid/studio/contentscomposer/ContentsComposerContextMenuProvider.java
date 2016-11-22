/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Elias Volanakis - initial API and implementation
 *     Kyoung Jin Kim - modification
 *******************************************************************************/

package org.roboid.studio.contentscomposer;

import org.roboid.studio.contentscomposer.actions.CloneMcAction;
import org.roboid.studio.contentscomposer.actions.CloneMccAction;
import org.roboid.studio.contentscomposer.actions.EditScriptAction;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;

/**
 * Provides context menu actions for the ShapesEditor.
 * @author Elias Volanakis
 * @author Kyoung Jin Kim
 */
class ContentsComposerContextMenuProvider extends ContextMenuProvider 
{
	/** The editor's action registry. */
	private ActionRegistry actionRegistry;
		
	/**
	 * Instantiate a new menu context provider for the specified EditPartViewer 
	 * and ActionRegistry.
	 * @param viewer	the editor's graphical viewer
	 * @param registry	the editor's action registry
	 * @throws IllegalArgumentException if registry is <tt>null</tt>. 
	 */
	public ContentsComposerContextMenuProvider(EditPartViewer viewer, ActionRegistry registry)
	{
		super(viewer);
		if(registry == null)
		{
			throw new IllegalArgumentException();
		}
		actionRegistry = registry;
	}
	
	/**
	 * Called when the context menu is about to show. Actions, 
	 * whose state is enabled, will appear in the context menu.
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void buildContextMenu(IMenuManager menu) 
	{
		IAction action;
		
		// Add standard action groups to the menu
		GEFActionConstants.addStandardActionGroups(menu);

		// ��� Ŭ�� ���纻 ����� �޴��� �߰��Ѵ�.
		action = actionRegistry.getAction(CloneMcAction.Id);
		if(action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		// ��� ������ ���纻 ����� �޴��� �߰��Ѵ�.
		action = actionRegistry.getAction(CloneMccAction.Id);
		if(action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		// ��ũ��Ʈ ���� �޴��� �߰��Ѵ�.
		action = actionRegistry.getAction(EditScriptAction.Id);
		if(action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		// Undo, Redo, Delete �޴��� �߰��Ѵ�.
		menu.appendToGroup(
				GEFActionConstants.GROUP_UNDO, // target group id
				getAction(ActionFactory.UNDO.getId())); // action to add
		menu.appendToGroup(
				GEFActionConstants.GROUP_UNDO, 
				getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(
				GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.DELETE.getId()));
		
		menu.appendToGroup(
				GEFActionConstants.GROUP_COPY,
				getAction(ActionFactory.CUT.getId()));
		menu.appendToGroup(
				GEFActionConstants.GROUP_COPY,
				getAction(ActionFactory.COPY.getId()));
		menu.appendToGroup(
				GEFActionConstants.GROUP_COPY,
				getAction(ActionFactory.PASTE.getId()));
		menu.appendToGroup(
				GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.SELECT_ALL.getId()));
	}

	// �׼��� ��´�.
	private IAction getAction(String actionId)
	{
		return actionRegistry.getAction(actionId);
	}
}
