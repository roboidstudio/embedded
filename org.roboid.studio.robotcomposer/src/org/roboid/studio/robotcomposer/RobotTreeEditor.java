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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.roboid.robot.Control;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.robotcomposer.provider.RobotAdapterFactoryContentProvider;

/**
 * @author Kwang-Hyun Park
 */
public class RobotTreeEditor extends EditorPart implements IMenuListener, IEditingDomainProvider
{
	private RobotComposer parent;
	private TreeViewer viewer;
	
	public RobotTreeEditor(RobotComposer parent)
	{
		this.parent = parent;
	}
	
	@Override
	public void createPartControl(Composite parent)
	{
		viewer = new TreeViewer(parent, SWT.MULTI);
		Tree tree = viewer.getTree();
		tree.setLayoutData(new FillLayout());
		viewer.setContentProvider(new RobotAdapterFactoryContentProvider(getAdapterFactory()));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
		viewer.setAutoExpandLevel(3);

		new AdapterFactoryTreeEditor(tree, getAdapterFactory());

		createContextMenuFor(viewer);
		getEditorSite().setSelectionProvider(viewer);
		
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance(), FileTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
//		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
		viewer.addDropSupport(dndOperations, transfers, new LoadRoboidModel(getEditingDomain(), viewer));
	}

	protected void createContextMenuFor(StructuredViewer viewer)
	{
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));
	}
	
	@Override
	public void menuAboutToShow(IMenuManager manager)
	{
		((IMenuListener)parent.getEditorSite().getActionBarContributor()).menuAboutToShow(manager);
	}

	@Override
	public void setFocus()
	{
		viewer.getTree().setFocus();
	}

	public void setInput(Object input)
	{
		viewer.setInput(input);
	}

	public EditingDomain getEditingDomain()
	{
		return parent.getEditingDomain();
	}

	protected BasicCommandStack getCommandStack()
	{
		return ((BasicCommandStack)getEditingDomain().getCommandStack());
	}

	protected AdapterFactory getAdapterFactory()
	{
		return parent.getAdapterFactory();
	}

	@Override
	public void doSave(IProgressMonitor monitor)
	{
	}
	
	@Override
	public void doSaveAs()
	{
	}

	@Override
	public boolean isSaveAsAllowed()
	{
		return true;
	}
	
	@Override
	public boolean isDirty()
	{
		return getCommandStack().isSaveNeeded();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException
	{
		setSite(site);
		setInput(input);
	}

	class LoadRoboidModel extends EditingDomainViewerDropAdapter
	{
		public LoadRoboidModel(EditingDomain domain, Viewer viewer)
		{
			super(domain, viewer);
		}

		@Override
		public void drop(DropTargetEvent event)
		{
			if(FileTransfer.getInstance().isSupportedType(event.currentDataType))
			{
				List<Roboid> roboids = new ArrayList<Roboid>();
				List<Control> controls = new ArrayList<Control>();
				
				String files[] = (String[])event.data;
				for(int i = 0; i < files.length; i++)
				{
					if(files[i].endsWith(".roboid") || files[i].endsWith(".robot"))
					{
						try
						{
							ResourceSet resourceSet = new ResourceSetImpl();
							URI uri = URI.createFileURI(files[i]);
							Resource resource = resourceSet.getResource(uri, true);
							EList<EObject> objects = resource.getContents();
							if(objects.isEmpty()) continue;
							
							Robot source = (Robot)objects.get(0);
							for(Roboid roboid : source.getRoboids())
								roboids.add(roboid);
							for(Control control : source.getControls())
							{
								if(!control.getChannels().isEmpty())
									controls.add(control);
							}
						}
						catch (Exception e)
						{
						}
					}
				}

				Robot target = (Robot)getEditingDomain().getResourceSet().getResources().get(0).getContents().get(0);
				command = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
				((CompoundCommand)command).append(AddCommand.create(getEditingDomain(), target, RobotPackage.Literals.ROBOT__ROBOIDS, roboids));
				if(controls.size() > 0)
					((CompoundCommand)command).append(AddCommand.create(getEditingDomain(), target, RobotPackage.Literals.ROBOT__CONTROLS, controls));
				if(command.canExecute())
					getCommandStack().execute(command);
				else
					command.dispose();
			}
			
			super.drop(event);
		}
	}
}