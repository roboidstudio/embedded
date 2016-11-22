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

package org.roboid.studio.roboidmanager.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeNodeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.roboid.core.ExtensionManager;
import org.roboid.core.component.activity.AbstractActivity;
import org.roboid.core.component.activity.Activity;
import org.roboid.core.component.activity.ActivityPackage;
import org.roboid.core.component.activity.provider.ActivityCheckStateProvider;
import org.roboid.core.component.activity.provider.ActivityContentProvider;
import org.roboid.core.runtime.ContentChangeListener;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IClip;
import org.roboid.core.runtime.RobotManager;
import org.roboid.studio.roboidmanager.Activator;
import org.roboid.studio.roboidmanager.actions.AddSystemComponentAction;
import org.roboid.studio.roboidmanager.actions.DeleteSystemComponentAction;
import org.roboid.studio.roboidmanager.model.ModelNode;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class RoboidManagerView extends ViewPart
{
	private Control activeControl;
	private CheckboxTreeViewer activityViewer;
	private SortTreeViewer modelViewer;
	private SortTableViewer roboidComponentViewer;
	private SortTableViewer addonComponentViewer;
	private SortTableViewer systemComponentViewer;
	private IClip currentContent;
	private ContentChangeListener contentListener = new ContentChangeListener()
	{
		@Override
		public void contentChanged(IClip oldContent, IClip newContent)
		{
			handleContentChanged(newContent);
		}
	};
	private EContentAdapter activityAdapter = new EContentAdapter()
	{
		@Override
		public void notifyChanged(org.eclipse.emf.common.notify.Notification notification)
		{
			int type = notification.getEventType();
			int featureId = notification.getFeatureID(ActivityPackage.class);
			
			if(notification.getNotifier() instanceof AbstractActivity)
			{
				switch(featureId)
				{
					case ActivityPackage.ABSTRACT_ACTIVITY__ID:
					{
						AbstractActivity activity = (AbstractActivity)notification.getNotifier();
						if(activityViewer != null) activityViewer.refresh(activity);
						break;
					}
					case ActivityPackage.ABSTRACT_ACTIVITY__ENABLED:
					{
						AbstractActivity activity = (AbstractActivity)notification.getNotifier();
						if(activityViewer != null) activityViewer.refresh(activity);
						break;
					}
				}
			}
			else if(notification.getNotifier() instanceof Activity)
			{
				switch(featureId)
				{
					case ActivityPackage.ACTIVITY__SYSTEMS:
					{
						switch(type)
						{
							case Notification.ADD:
							case Notification.REMOVE:
							case Notification.REMOVE_MANY:
								if(activityViewer != null) activityViewer.refresh();
								break;
						}
						break;
					}
				}
			}
			super.notifyChanged(notification);
		}
	};

	private void handleContentChanged(IClip newContent)
	{
		if(newContent == currentContent) return;
		if(currentContent != null)
			currentContent.getResource().eAdapters().remove(activityAdapter);
		currentContent = newContent;
		
		if(newContent == null)
			activityViewer.setInput(null);
		else
		{
			Activity newActivity = newContent.getActivity();
			activityViewer.setInput(newActivity);
			activityViewer.expandAll();
			newContent.getResource().eAdapters().add(activityAdapter);
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
			currentContent.getResource().eAdapters().remove(activityAdapter);
		super.dispose();
	}
	
	@Override
	public void createPartControl(Composite parent)
	{
		TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		createActivityView(tabFolder);
		createModelView(tabFolder);
		createRoboidComponentView(tabFolder);
		createAddonComponentView(tabFolder);
		createSystemComponentView(tabFolder);
		
		tabFolder.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				activeControl = ((TabItem)e.item).getControl();
			}
		});
	}

	private void createActivityView(final TabFolder tabFolder)
	{
		// 탭 표시
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Activity");

		// 트리를 만든다.
		activityViewer = new CheckboxTreeViewer(tabFolder, SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI);
		Tree tree = activityViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		// 모델 열을 만든다.
		TreeColumn columnModel = new TreeColumn(tree, SWT.NONE);
		columnModel.setText("Model");
		columnModel.setResizable(true);
		columnModel.setWidth(350);

		// 로보이드 컴포넌트 열을 만든다.
		TreeColumn columnComponent = new TreeColumn(tree, SWT.NONE);
		columnComponent.setText("Active Component");
		columnComponent.setResizable(true);
		columnComponent.setWidth(300);

		// 활성화된 로보이드 컴포넌트를 선택하기 위한 셀 에디터를 만든다.
		activityViewer.setColumnProperties(new String[] { "roboid", "component" });
		CellEditor[] editors = new CellEditor[2];
		editors[1] = new ComboBoxCellEditor(tree, new String[0], SWT.READ_ONLY);
		activityViewer.setCellModifier(new BundleCellModifier(editors));
		activityViewer.setCellEditors(editors);
		activityViewer.setContentProvider(new ActivityContentProvider());
		activityViewer.setLabelProvider(new ActivityViewLabelProvider());
		activityViewer.setCheckStateProvider(new ActivityCheckStateProvider());
		tabItem.setControl(tree);

		activityViewer.addCheckStateListener(new ICheckStateListener()
		{
			@Override
			public void checkStateChanged(CheckStateChangedEvent event)
			{
				Object element = event.getElement();
				if(element instanceof AbstractActivity)
				{
					AbstractActivity activity = (AbstractActivity)element;
					if(activity.canChangeEnabled())
						activity.update(event.getChecked());
				}
			}
		});
		
		MenuManager menuManager = new MenuManager("#PopupMenu");
		menuManager.setRemoveAllWhenShown(true);
		final Menu menu = menuManager.createContextMenu(activityViewer.getControl());
		menuManager.addMenuListener(new IMenuListener()
		{
			@Override
			public void menuAboutToShow(IMenuManager manager)
			{
				if(currentContent == null) return;
				Activity activity = currentContent.getActivity();
				if(activity == null) return;
				
				MenuManager subManager = new MenuManager("Add System Component", Activator.getImageDescriptor("icons/add_system_component.gif"), "org.roboid.studio.roboidmanager.addsystemcomponent");
				for(IExtension extension : ExtensionManager.getSystemExtensions())
					subManager.add(new AddSystemComponentAction(activity, extension));
				manager.add(subManager);
				manager.add(new DeleteSystemComponentAction(activityViewer, activity));
				manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			}
		});
		activityViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, activityViewer);
		
		handleContentChanged(ContentsManager.getCurrentContent());
	}
	
	private void createModelView(final TabFolder tabFolder)
	{
		// Model view
		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Models");

		modelViewer = new SortTreeViewer(tabFolder, SWT.BORDER|SWT.MULTI);
		Tree tree = modelViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		TreeColumn columnModel = new TreeColumn(tree, SWT.NONE);
		columnModel.setText("Model");
		columnModel.setResizable(true);
		columnModel.setWidth(350);
		
		TreeColumn columnCategory = new TreeColumn(tree, SWT.NONE);
		columnCategory.setText("Category");
		columnCategory.setResizable(true);
		columnCategory.setWidth(100);
		
		modelViewer.setContentProvider(new TreeNodeContentProvider());
		modelViewer.setLabelProvider(new ModelViewLabelProvider());
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<String> ids = new ArrayList<String>();
		for(IExtension ext : ExtensionManager.getRoboidExtensions())
		{
			String id = ExtensionManager.toRoboidId(ext);
			if(!ids.contains(id))
			{
				ids.add(id);
				ModelNode newNode = new ModelNode(null, ext);
				newNode.createChildNodes();
				nodes.add(newNode);
			}
		}
		modelViewer.setInput(nodes.toArray(new TreeNode[nodes.size()]));
		modelViewer.makeAllColumnsSortable();
		tabItem.setControl(tree);
		
		modelViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK, new Transfer[] { FileTransfer.getInstance() }, new DragSourceListener()
		{
			@Override
			public void dragFinished(DragSourceEvent event)
			{
			}

			@Override
			public void dragSetData(DragSourceEvent event)
			{
				IStructuredSelection selection = (IStructuredSelection)modelViewer.getSelection();
				@SuppressWarnings("unchecked")
				Iterator<Object> it = (Iterator<Object>)selection.iterator();
				
				List<String> fileNames = new ArrayList<String>();
				while(it.hasNext())
				{
					Object o = it.next();
					if(o instanceof ModelNode)
					{
						IExtension ext = (IExtension)((ModelNode)o).getValue();
						fileNames.add(RobotManager.getModelFileName(ext));
					}
				}
				event.data = fileNames.toArray(new String[fileNames.size()]);
			}

			@Override
			public void dragStart(DragSourceEvent event)
			{
			}
		});
	}
	
	private void createRoboidComponentView(final TabFolder tabFolder)
	{
		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Roboids");

		roboidComponentViewer = new SortTableViewer(tabFolder, SWT.BORDER|SWT.MULTI);
		Table table = roboidComponentViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableColumn columnRoboid = new TableColumn(table, SWT.NONE);
		columnRoboid.setWidth(250);
		columnRoboid.setText("Roboid Component");

		final TableColumn columnName = new TableColumn(table, SWT.NONE);
		columnName.setWidth(175);
		columnName.setText("Name");
		
		final TableColumn columnCategory = new TableColumn(table, SWT.NONE);
		columnCategory.setWidth(100);
		columnCategory.setText("Category");

		final TableColumn columnModel = new TableColumn(table, SWT.NONE);
		columnModel.setWidth(250);
		columnModel.setText("Model");

		final TableColumn columnProvider = new TableColumn(table, SWT.NONE);
		columnProvider.setWidth(175);
		columnProvider.setText("Provider");

		final TableColumn columnVersion = new TableColumn(table, SWT.NONE);
		columnVersion.setWidth(60);
		columnVersion.setText("Version");

		// final TableColumn newColumnTableColumn_7 = new TableColumn(table,
		// SWT.NONE);
		// newColumnTableColumn_7.setWidth(250);
		// newColumnTableColumn_7.setText("License");

		roboidComponentViewer.setContentProvider(new ArrayContentProvider());
		roboidComponentViewer.setLabelProvider(new RoboidComponentViewLabelProvider());
		roboidComponentViewer.setInput(ExtensionManager.getRoboidExtensions());
		roboidComponentViewer.makeAllColumnsSortable();
		tabItem.setControl(table);
		
		roboidComponentViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK, new Transfer[] { FileTransfer.getInstance() }, new DragSourceListener()
		{
			@Override
			public void dragFinished(DragSourceEvent event)
			{
			}

			@Override
			public void dragSetData(DragSourceEvent event)
			{
				IStructuredSelection selection = (IStructuredSelection)roboidComponentViewer.getSelection();
				@SuppressWarnings("unchecked")
				Iterator<IExtension> it = (Iterator<IExtension>)selection.iterator();
				
				List<String> fileNames = new ArrayList<String>();
				while(it.hasNext())
				{
					IExtension ext = it.next();
					fileNames.add(RobotManager.getModelFileName(ext));
				}
				event.data = fileNames.toArray(new String[fileNames.size()]);
			}

			@Override
			public void dragStart(DragSourceEvent event)
			{
			}
		});
	}
	
	private void createAddonComponentView(final TabFolder tabFolder)
	{
		final TabItem infoTabItem = new TabItem(tabFolder, SWT.NONE);
		infoTabItem.setText("Addons");

		addonComponentViewer = new SortTableViewer(tabFolder, SWT.BORDER);
		Table table = addonComponentViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableColumn columnAddon = new TableColumn(table, SWT.NONE);
		columnAddon.setWidth(300);
		columnAddon.setText("Addon Component");

		final TableColumn columnName = new TableColumn(table, SWT.NONE);
		columnName.setWidth(200);
		columnName.setText("Name");

		final TableColumn columnHostModel = new TableColumn(table, SWT.NONE);
		columnHostModel.setWidth(250);
		columnHostModel.setText("Host Model");

		final TableColumn columnAddonModel = new TableColumn(table, SWT.NONE);
		columnAddonModel.setWidth(250);
		columnAddonModel.setText("Addon Model");

		final TableColumn columnProvider = new TableColumn(table, SWT.NONE);
		columnProvider.setWidth(175);
		columnProvider.setText("Provider");

		final TableColumn columnVersion = new TableColumn(table, SWT.NONE);
		columnVersion.setWidth(60);
		columnVersion.setText("Version");

		addonComponentViewer.setContentProvider(new ArrayContentProvider());
		addonComponentViewer.setLabelProvider(new AddonComponentViewLabelProvider());
		addonComponentViewer.setInput(ExtensionManager.getAddonExtensions());
		addonComponentViewer.makeAllColumnsSortable();
		infoTabItem.setControl(table);
	}

	private void createSystemComponentView(final TabFolder tabFolder)
	{
		// Info view
		final TabItem infoTabItem = new TabItem(tabFolder, SWT.NONE);
		infoTabItem.setText("Systems");

		systemComponentViewer = new SortTableViewer(tabFolder, SWT.BORDER);
		Table table = systemComponentViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final TableColumn columnSystem = new TableColumn(table, SWT.NONE);
		columnSystem.setWidth(250);
		columnSystem.setText("System Component");

		final TableColumn columnName = new TableColumn(table, SWT.NONE);
		columnName.setWidth(175);
		columnName.setText("Name");

		final TableColumn columnProvider = new TableColumn(table, SWT.NONE);
		columnProvider.setWidth(175);
		columnProvider.setText("Provider");

		final TableColumn columnVersion = new TableColumn(table, SWT.NONE);
		columnVersion.setWidth(60);
		columnVersion.setText("Version");

		systemComponentViewer.setContentProvider(new ArrayContentProvider());
		systemComponentViewer.setLabelProvider(new SystemComponentViewLabelProvider());
		systemComponentViewer.setInput(ExtensionManager.getSystemExtensions());
		systemComponentViewer.makeAllColumnsSortable();
		infoTabItem.setControl(table);
	}
	
	@Override
	public void setFocus()
	{
		if(activeControl != null) activeControl.setFocus();
	}
}
