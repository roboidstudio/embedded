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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.SelectAllAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.roboid.robot.Channel;
import org.roboid.robot.Control;
import org.roboid.robot.Device;
import org.roboid.robot.NamedElement;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.SensoryDevice;
import org.roboid.studio.robotcomposer.actions.AlignmentAction;
import org.roboid.studio.robotcomposer.actions.ZoomInAction;
import org.roboid.studio.robotcomposer.actions.ZoomOutAction;
import org.roboid.studio.robotcomposer.editparts.AssociationEditPart;
import org.roboid.studio.robotcomposer.editparts.DeviceElementEditPart;
import org.roboid.studio.robotcomposer.editparts.RoboidBlockEditPart;
import org.roboid.studio.robotcomposer.editparts.RobotDiagramEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class Contributor extends MultiPageEditorActionBarContributor implements IMenuListener, IPropertyListener, ISelectionChangedListener
{
	protected IEditorPart activeEditor;
	protected IEditorPart activePagePart;
	protected ISelectionProvider selectionProvider;
	protected List<IContributionItem> graphicToolBarItems = new ArrayList<IContributionItem>();
	public static final int ADDITIONS_LAST_STYLE = 0x1;
	protected int style;
	protected DeleteAction deleteAction;
	protected UndoAction undoAction;
	protected RedoAction redoAction;
	protected ZoomInAction zoomInAction;
	protected ZoomOutAction zoomOutAction;
	protected SelectAllAction selectAllAction;
	protected AlignmentAction alignCenterAction;
	protected AlignmentAction alignMiddleAction;
	protected IAction showPropertiesViewAction = new Action(RobotComposerPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item"))
	{
		@Override
		public void run()
		{
			try
			{
				getPage().showView("org.eclipse.ui.views.PropertySheet");
			}
			catch (PartInitException e)
			{
				RobotComposerPlugin.INSTANCE.log(e);
			}
		}
	};
	protected IAction refreshViewerAction =  new Action(RobotComposerPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item"))
	{
		@Override
		public boolean isEnabled()
		{
			return activeEditor instanceof IViewerProvider;
		}
		
		@Override
		public void run()
		{
			if(activeEditor instanceof IViewerProvider)
			{
				Viewer viewer = ((IViewerProvider)activeEditor).getViewer();
				if(viewer != null)
					viewer.refresh();
			}
		}
	};
	protected Collection<IAction> createChildActions;
	protected IMenuManager createChildMenuManager;
	protected Collection<IAction> createSiblingActions;
	protected IMenuManager createSiblingMenuManager;
	
	public Contributor()
	{
		this(ADDITIONS_LAST_STYLE);
	}
	
	public Contributor(int style)
	{
		super();
		this.style = style;
	}

	private void collectDeletableControls(List<Control> controls, EditingDomain domain, List<Roboid> roboids)
	{
		Robot robot = (Robot)domain.getResourceSet().getResources().get(0).getContents().get(0);
		if(robot == null) return;

		for(Control control : robot.getControls())
		{
			if(isDeletable(control, roboids))
				controls.add(control);
		}
	}
	
	private boolean isDeletable(Control control, List<Roboid> roboids)
	{
		for(Channel channel : control.getChannels())
		{
			for(Device device : channel.getDevices())
			{
				if(!roboids.contains(device.getRootRoboid()))
					return false;
			}
		}
		return true;
	}
	
	@Override
	public void init(IActionBars actionBars)
	{
		super.init(actionBars);
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

		deleteAction = new DeleteAction(removeAllReferencesOnDelete())
		{
			@Override
			public Command createCommand(Collection<?> selection)
			{
				List<Object> list = new ArrayList<Object>();
				List<Roboid> roboids = new ArrayList<Roboid>();

				if(activePagePart instanceof RobotGraphicalEditor)
				{
					for(Object o : selection)
					{
						if(o instanceof RoboidBlockEditPart)
						{
							Roboid roboid = ((RoboidBlockEditPart)o).getModel().getRoboid(); 
							list.add(roboid);
							roboids.add(roboid);
						}
						else if(o instanceof AssociationEditPart)
							list.add(((AssociationEditPart)o).getModel());
					}
				}
				else if(activePagePart instanceof RobotTreeEditor)
				{
					list.addAll(selection);
					for(Object o : selection)
					{
						if(o instanceof Roboid)
							roboids.add((Roboid)o);
					}
				}

				List<Control> controls = new ArrayList<Control>();
				collectDeletableControls(controls, domain, roboids);
				list.addAll(controls);
				
				selection = list;

				DeleteCommand command = new DeleteCommand(domain, selection)
				{
					@Override
					public void execute()
					{
						List<Association> associations = new ArrayList<Association>();
						List<Object> others = new ArrayList<Object>();
						for(Object o : collection)
						{
							if(o instanceof Association)
								associations.add((Association)o);
							else
								others.add(o);
						}
						
						collection = others;
						super.execute();
						
						for(Association association : associations)
						{
							DeviceElement sourceElement = (DeviceElement)association.getSource();
							DeviceElement targetElement = (DeviceElement)association.getTarget();
							if(sourceElement != null && targetElement != null)
							{
								Device sourceDevice = sourceElement.getDevice();
								Device targetDevice = targetElement.getDevice();
								if(sourceDevice != null)
								{
									if(sourceDevice.isProxy())
										appendAndExecute(SetCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__PROXY_FOR), SetCommand.UNSET_VALUE));
									else if(sourceDevice instanceof SensoryDevice)
										appendAndExecute(RemoveCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__RECEPTORS), targetDevice));
								}
							}
						}
					}
				};
				return command;
			}
		};
		deleteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
/*
		cutAction = new CutAction()
		{
			@Override
			public Command createCommand(Collection<?> selection)
			{
				CompoundCommand command = new CompoundCommand(EMFEditPlugin.INSTANCE.getString("_UI_CutToClipboardCommand_label"), EMFEditPlugin.INSTANCE.getString("_UI_CutToClipboardCommand_description"))
				{
					@Override
					public void execute()
					{
						super.execute();
						if(activePagePart instanceof RobotGraphicalEditor)
							pasteAction.setEnabled(true);
					}
				};
				
				if(activePagePart instanceof RobotGraphicalEditor)
				{
					List<Object> list = new ArrayList<Object>();
					for(Object o : selection)
					{
						if(o instanceof RoboidBlockEditPart)
							list.add(((RoboidBlockEditPart)o).getModel().getRoboid());
					}
					selection = list;
				}
				command.append(new CopyToClipboardCommand(domain, selection)
				{
					@Override
					public void doExecute()
					{
						RobotDiagram diagram = (RobotDiagram)domain.getResourceSet().getResources().get(0).getContents().get(1);
						if(diagram == null) return;
						
						copiedBlocks = new ArrayList<RoboidBlock>();
						for(Object o : sourceObjects)
						{
							if(o instanceof Roboid)
							{
								RoboidBlock block = diagram.findRoboidBlock((Roboid)o);
								if(block != null) copiedBlocks.add(block);
							}
						}
						super.doExecute();
					}
				});
				command.append(DeleteCommand.create(domain, selection));
				return command;
			}
		};
		cutAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		cutAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cutAction);

		copyAction = new CopyAction()
	    {
			@Override
			public Command createCommand(Collection<?> selection)
			{
				if(activePagePart instanceof RobotGraphicalEditor)
				{
					List<Object> list = new ArrayList<Object>();
					for(Object o : selection)
					{
						if(o instanceof RoboidBlockEditPart)
							list.add(((RoboidBlockEditPart)o).getModel().getRoboid());
					}
					selection = list;
				}
				return new CopyToClipboardCommand(domain, selection)
				{
					@Override
					public boolean doCanUndo()
					{
						return false;
					}

					@Override
					public void doExecute()
					{
						RobotDiagram diagram = (RobotDiagram)domain.getResourceSet().getResources().get(0).getContents().get(1);
						if(diagram == null) return;
						
						copiedBlocks = new ArrayList<RoboidBlock>();
						for(Object o : sourceObjects)
						{
							if(o instanceof Roboid)
							{
								RoboidBlock block = diagram.findRoboidBlock((Roboid)o);
								if(block != null) copiedBlocks.add(block);
							}
						}
						
						super.doExecute();
						if(activePagePart instanceof RobotGraphicalEditor)
							pasteAction.setEnabled(true);
					}
				};
			}
	    };
	    copyAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	    copyAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
	    actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);

	    pasteAction = new PasteAction()
	    {
			@Override
			public Command createCommand(Collection<?> selection)
			{
				if(activePagePart instanceof RobotGraphicalEditor)
				{
					List<Object> list = new ArrayList<Object>();
					list.add(((RobotGraphicalEditor)activePagePart).getDiagram().getRobot());
					selection = list;
				}
				if(selection.size() == 1)
				{
					return new PasteFromClipboardCommand(domain, selection.iterator().next(), null, CommandParameter.NO_INDEX, true)
					{
						private List<EditPart> oldSelectedEditParts = new ArrayList<EditPart>();
				    	
						@Override
						public void doExecute()
						{
							if(command.canExecute())
							{
								RobotDiagram diagram = (RobotDiagram)domain.getResourceSet().getResources().get(0).getContents().get(1);
								if(diagram == null) return;
								
								int top = -1, bottom = -1;
								RoboidBlock last = null;
								for(RoboidBlock block : diagram.getBlocks())
								{
									if(bottom < block.getY())
									{
										bottom = block.getY();
										last = block;
									}
								}
								for(RoboidBlock block : copiedBlocks)
								{
									if(top > block.getY() || top < 0)
										top = block.getY();
								}
								int deviation = RobotGraphicalEditor.snap(bottom - top + 26) + RobotComposerConstants.GRID;
								if(last != null) deviation = RobotGraphicalEditor.snap(deviation + last.getDevices().size() * 18);
								
								command.execute();
								
								List<RoboidBlock> newBlocks = new ArrayList<RoboidBlock>();
								Iterator<?> it1 = doGetResult().iterator();
								Iterator<RoboidBlock> it2 = copiedBlocks.iterator();
								bottom = 0;
								while(it1.hasNext() && it2.hasNext())
								{
									Object r = it1.next();
									if(r instanceof Roboid)
									{
										RoboidBlock ref = it2.next();
										RoboidBlock target = diagram.findRoboidBlock((Roboid)r);
										if(target != null)
										{
											target.setX(ref.getX());
											target.setY(ref.getY() + deviation);
											newBlocks.add(target);
											if(bottom < target.getY())
												bottom = target.getY();
										}
									}
								}
								
								if(activePagePart instanceof RobotGraphicalEditor)
								{
									GraphicalViewer viewer = (GraphicalViewer)activePagePart.getAdapter(GraphicalViewer.class);
									oldSelectedEditParts = new ArrayList<EditPart>();
									for(Object o : viewer.getSelectedEditParts())
										oldSelectedEditParts.add((EditPart)o);
									
									@SuppressWarnings("unchecked")
									Map<RoboidBlock, EditPart> map = viewer.getEditPartRegistry();
									List<EditPart> newSelections = new ArrayList<EditPart>();
									for(RoboidBlock block : newBlocks)
									{
										EditPart editPart = map.get(block);
										if(editPart != null)
											newSelections.add(editPart);
									}
									viewer.setSelection(new StructuredSelection(newSelections.toArray()));
									
									FigureCanvas fc = (FigureCanvas)viewer.getControl();
									if(fc != null)
									{
										fc.setRedraw(false);
										viewer.flush();
										fc.scrollToY(bottom);
										fc.setRedraw(true);
									}
								}
							}
						}

						@Override
						public void doUndo()
						{
							super.doUndo();
							doGetResult();
							if(activePagePart instanceof RobotGraphicalEditor)
							{
								GraphicalViewer viewer = (GraphicalViewer)activePagePart.getAdapter(GraphicalViewer.class);
								viewer.setSelection(new StructuredSelection(oldSelectedEditParts.toArray()));
							}
						}
						
						@Override
						public void doRedo()
						{
							RobotDiagram diagram = (RobotDiagram)domain.getResourceSet().getResources().get(0).getContents().get(1);
							if(diagram == null) return;
							
							super.doRedo();
							
							if(activePagePart instanceof RobotGraphicalEditor)
							{
								List<RoboidBlock> newBlocks = new ArrayList<RoboidBlock>();
								Iterator<?> it1 = doGetResult().iterator();
								int bottom = 0;
								while(it1.hasNext())
								{
									Object r = it1.next();
									if(r instanceof Roboid)
									{
										RoboidBlock target = diagram.findRoboidBlock((Roboid)r);
										if(target != null)
										{
											newBlocks.add(target);
											if(bottom < target.getY())
												bottom = target.getY();
										}
									}
								}

								GraphicalViewer viewer = (GraphicalViewer)activePagePart.getAdapter(GraphicalViewer.class);
								oldSelectedEditParts = new ArrayList<EditPart>();
								for(Object o : viewer.getSelectedEditParts())
									oldSelectedEditParts.add((EditPart)o);
								
								@SuppressWarnings("unchecked")
								Map<RoboidBlock, EditPart> map = viewer.getEditPartRegistry();
								List<EditPart> newSelections = new ArrayList<EditPart>();
								for(RoboidBlock block : newBlocks)
								{
									EditPart editPart = map.get(block);
									if(editPart != null)
										newSelections.add(editPart);
								}
								viewer.setSelection(new StructuredSelection(newSelections.toArray()));
								
								FigureCanvas fc = (FigureCanvas)viewer.getControl();
								if(fc != null)
								{
									fc.setRedraw(false);
									viewer.flush();
									fc.scrollToY(bottom);
									fc.setRedraw(true);
								}
							}
						}
					};
				}
				else
				{
					return UnexecutableCommand.INSTANCE;
				}
			}
	    };
	    pasteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
	    pasteAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
	    actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), pasteAction);
*/
		undoAction = new UndoAction();
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		undoAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO_DISABLED));
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		
		redoAction = new RedoAction();
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		redoAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO_DISABLED));
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}
	
	@Override
	public void contributeToMenu(IMenuManager menuManager)
	{
		super.contributeToMenu(menuManager);
		
		IMenuManager submenuManager = new MenuManager(RobotComposerPlugin.INSTANCE.getString("_UI_RobotEditor_menu"), "org.roboid.robotMenuID");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("settings"));
		submenuManager.add(new Separator("actions"));
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));
		
		createChildMenuManager = new MenuManager(RobotComposerPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
		submenuManager.insertBefore("additions", createChildMenuManager);
		
		createSiblingMenuManager = new MenuManager(RobotComposerPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
		submenuManager.insertBefore("additions", createSiblingMenuManager);
		
		submenuManager.addMenuListener(new IMenuListener()
		{
			@Override
			public void menuAboutToShow(IMenuManager menuManager)
			{
				menuManager.updateAll(true);
			}
		});
		addGlobalActions(submenuManager);
	}
	
	public void shareGlobalActions(IPage page, IActionBars actionBars)
	{
		if (!(page instanceof IPropertySheetPage))
			actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}
	
	public IEditorPart getActiveEditor()
	{
		return activeEditor;
	}
	
	@Override
	public void setActiveEditor(IEditorPart part)
	{
		super.setActiveEditor(part);
		
		if(part != activeEditor)
		{
			if(activeEditor != null)
			{
				deactivate();
			}

			if (part instanceof IEditingDomainProvider)
			{
				activeEditor = part;
				activate();
			}
		}
		
		if(selectionProvider != null)
			selectionProvider.removeSelectionChangedListener(this);
		if(part == null)
			selectionProvider = null;
		else
		{
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);
			
			if(alignCenterAction != null) alignCenterAction.setSelectionProvider(selectionProvider);
			if(alignMiddleAction != null) alignMiddleAction.setSelectionProvider(selectionProvider);
			
			if(selectionProvider.getSelection() != null)
			{
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
		
		if(selectAllAction == null)
		{
			selectAllAction = new SelectAllAction(activeEditor);
			getActionBars().setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), selectAllAction);
		}
	}
	
	@Override
	public void setActivePage(IEditorPart part)
	{
		activePagePart = part;
		IToolBarManager toolBarManager = getActionBars().getToolBarManager();
		
		if(toolBarManager.isEmpty())
		{
			toolBarManager.add(new Separator("robotcomposer-settings"));
			toolBarManager.add(new Separator("robotcomposer-actions"));
			toolBarManager.add(new ActionContributionItem(undoAction));
			toolBarManager.add(new ActionContributionItem(redoAction));
			toolBarManager.add(new ActionContributionItem(deleteAction));
//			toolBarManager.add(new Separator());
//			toolBarManager.add(new ActionContributionItem(cutAction));
//			toolBarManager.add(new ActionContributionItem(copyAction));
//			toolBarManager.add(new ActionContributionItem(pasteAction));
			toolBarManager.add(new Separator("robotcomposer-additions"));
		}
		
		if(part instanceof RobotGraphicalEditor && graphicToolBarItems.isEmpty())
		{
			RobotGraphicalEditor editor = (RobotGraphicalEditor)part;
			graphicToolBarItems.add(new Separator());
			zoomInAction = (ZoomInAction)editor.getActionRegistry().getAction(GEFActionConstants.ZOOM_IN);
			graphicToolBarItems.add(new ActionContributionItem(zoomInAction));
			zoomOutAction = (ZoomOutAction)editor.getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT);
			graphicToolBarItems.add(new ActionContributionItem(zoomOutAction));
			alignCenterAction = (AlignmentAction)editor.getActionRegistry().getAction(GEFActionConstants.ALIGN_CENTER);
			getActionBars().setGlobalActionHandler(alignCenterAction.getId(), alignCenterAction);
			graphicToolBarItems.add(new ActionContributionItem(alignCenterAction));
			alignMiddleAction = (AlignmentAction)editor.getActionRegistry().getAction(GEFActionConstants.ALIGN_MIDDLE);
			getActionBars().setGlobalActionHandler(alignMiddleAction.getId(), alignMiddleAction);
			graphicToolBarItems.add(new ActionContributionItem(alignMiddleAction));
			for(IContributionItem item : graphicToolBarItems)
				toolBarManager.add(item);
		}
		
		if(part instanceof RobotGraphicalEditor)
		{
			RobotGraphicalEditor editor = (RobotGraphicalEditor)part;
			ZoomManager zoomManager = ((ScalableFreeformRootEditPart)editor.getAdapter(EditPart.class)).getZoomManager();
			zoomInAction.setManager(zoomManager);
			zoomOutAction.setManager(zoomManager);
			
			for(IContributionItem item : graphicToolBarItems)
				item.setVisible(true);
			toolBarManager.update(true);
		}
		else
		{
			for(IContributionItem item : graphicToolBarItems)
				item.setVisible(false);
			toolBarManager.update(true);
		}
	}
	
	public void activate()
	{
		activeEditor.addPropertyListener(this);

		deleteAction.setActiveWorkbenchPart(activeEditor);
		undoAction.setActiveWorkbenchPart(activeEditor);
		redoAction.setActiveWorkbenchPart(activeEditor);

		ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider ? (ISelectionProvider)activeEditor : activeEditor.getEditorSite().getSelectionProvider();
		if(selectionProvider != null)
			selectionProvider.addSelectionChangedListener(deleteAction);

		update();
	}
	
	public void deactivate()
	{
		activeEditor.removePropertyListener(this);

		deleteAction.setActiveWorkbenchPart(null);
		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);

		ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider ? (ISelectionProvider)activeEditor : activeEditor.getEditorSite().getSelectionProvider();
		if(selectionProvider != null)
			selectionProvider.removeSelectionChangedListener(deleteAction);
	}

	public void update()
	{
		ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider ? (ISelectionProvider)activeEditor : activeEditor.getEditorSite().getSelectionProvider();
		if(selectionProvider != null)
		{
			ISelection selection = selectionProvider.getSelection();
			IStructuredSelection structuredSelection = selection instanceof IStructuredSelection ?  (IStructuredSelection)selection : StructuredSelection.EMPTY;
			deleteAction.updateSelection(structuredSelection);
		}

		undoAction.update();
		redoAction.update();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event)
	{
		if(createChildMenuManager != null)
			depopulateManager(createChildMenuManager, createChildActions);
		if(createSiblingMenuManager != null)
			depopulateManager(createSiblingMenuManager, createSiblingActions);
		
		Collection<?> newChildDescriptors = null;
		Collection<?> newSiblingDescriptors = null;
		
		ISelection selection = event.getSelection();
		if(selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1)
		{
			Object object = ((IStructuredSelection)selection).getFirstElement();
			EditingDomain domain = ((IEditingDomainProvider)activeEditor).getEditingDomain();
			newChildDescriptors = domain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
		}
		
		createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);
		
		if(createChildMenuManager != null)
		{
			populateManager(createChildMenuManager, createChildActions, null);
			createChildMenuManager.update(true);
		}
		if(createSiblingMenuManager != null)
		{
			populateManager(createSiblingMenuManager, createSiblingActions, null);
			createSiblingMenuManager.update(true);
		}
		
		updateActions();
	}
	
	protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection)
	{
		Collection<IAction> actions = new ArrayList<IAction>();
		if(descriptors != null && selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1)
		{
			Object object = ((IStructuredSelection)selection).getFirstElement();
			for(Object descriptor : descriptors)
			{
				if(object instanceof Robot)
				{
					if(descriptor instanceof CommandParameter && ((CommandParameter)descriptor).getValue() instanceof Control)
						actions.add(new CreateChildAction(activeEditor, selection, descriptor));
				}
			}
		}
		return actions;
	}
	
	protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection)
	{
		Collection<IAction> actions = new ArrayList<IAction>();
		if(descriptors != null && selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1)
		{
			Object object = ((IStructuredSelection)selection).getFirstElement();
			for(Object descriptor : descriptors)
			{
				if(object instanceof Roboid || object instanceof Control)
				{
					if(descriptor instanceof CommandParameter && ((CommandParameter)descriptor).getValue() instanceof Control)
						actions.add(new CreateSiblingAction(activeEditor, selection, descriptor));
				}
			}
		}
		return actions;
	}
	
	protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions, String contributionID)
	{
		if(actions != null)
		{
			for(IAction action : actions)
			{
				if(contributionID != null)
					manager.insertBefore(contributionID, action);
				else
					manager.add(action);
			}
		}
	}
	
	protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions)
	{
		if(actions != null)
		{
			IContributionItem[] items = manager.getItems();
			for(int i = 0; i < items.length; i++)
			{
				IContributionItem contributionItem = items[i];
				while(contributionItem instanceof SubContributionItem)
					contributionItem = ((SubContributionItem)contributionItem).getInnerItem();

				if(contributionItem instanceof ActionContributionItem)
				{
					IAction action = ((ActionContributionItem)contributionItem).getAction();
					if(actions.contains(action))
						manager.remove(contributionItem);
				}
			}
		}
	}
	
	@Override
	public void menuAboutToShow(IMenuManager menuManager)
	{
		if((style & ADDITIONS_LAST_STYLE) == 0)
		{
			menuManager.add(new Separator("additions"));
		}
		menuManager.add(new Separator("edit"));

		menuManager.add(new ActionContributionItem(undoAction));
		menuManager.add(new ActionContributionItem(redoAction));
		menuManager.add(new Separator());
		menuManager.add(new ActionContributionItem(deleteAction));
		menuManager.add(new Separator());

		if((style & ADDITIONS_LAST_STYLE) != 0)
		{
			menuManager.add(new Separator("additions"));
			menuManager.add(new Separator());
		}
		menuManager.add(new Separator("additions-end"));
		addGlobalActions(menuManager);

		MenuManager submenuManager = null;
		submenuManager = new MenuManager(RobotComposerPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
		populateManager(submenuManager, createChildActions, null);
		menuManager.insertBefore("edit", submenuManager);
		submenuManager = new MenuManager(RobotComposerPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
		populateManager(submenuManager, createSiblingActions, null);
		menuManager.insertBefore("edit", submenuManager);
	}
	
	protected void addGlobalActions(IMenuManager menuManager)
	{
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		menuManager.insertAfter("ui-actions", showPropertiesViewAction);
		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
		menuManager.insertAfter("ui-actions", refreshViewerAction);
	}
	
	protected boolean removeAllReferencesOnDelete()
	{
		return true;
	}

	private void updateActions()
	{
		ISelectionProvider selectionProvider = activeEditor instanceof ISelectionProvider ?
				(ISelectionProvider)activeEditor :
				activeEditor.getEditorSite().getSelectionProvider();

		if(selectionProvider != null)
		{
			if(alignCenterAction != null) alignCenterAction.update();
			if(alignMiddleAction != null) alignMiddleAction.update();
			
			ISelection selection = selectionProvider.getSelection();
			IStructuredSelection structuredSelection = selection instanceof IStructuredSelection ? (IStructuredSelection)selection : StructuredSelection.EMPTY;
			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext())
			{
				Object o = it.next();
				if(o instanceof NamedElement)
				{
					if(o instanceof Robot || ((NamedElement)o).getParent() instanceof Roboid)
					{
						deleteAction.setEnabled(false);
//						cutAction.setEnabled(false);
//						copyAction.setEnabled(false);
					}
//					else if(o instanceof Roboid)
//						pasteAction.setEnabled(false);
				}
				else if(o instanceof Resource)
				{
					deleteAction.setEnabled(false);
//					cutAction.setEnabled(false);
//					copyAction.setEnabled(false);
//					pasteAction.setEnabled(false);
				}
				else if(o instanceof RobotDiagramEditPart || o instanceof DeviceElementEditPart)
				{
					deleteAction.setEnabled(false);
//					cutAction.setEnabled(false);
//					copyAction.setEnabled(false);
				}
//				else if(o instanceof AssociationEditPart)
//				{
//					cutAction.setEnabled(false);
//					copyAction.setEnabled(false);
//				}
			}
	    }
	}
	
	@Override
	public void propertyChanged(Object source, int id)
	{
		update();
	}
}
