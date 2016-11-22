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
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.palette.editparts.PaletteEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.ui.IWorkbenchPart;
import org.roboid.robot.Control;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.robotcomposer.actions.AlignmentAction;
import org.roboid.studio.robotcomposer.actions.ZoomInAction;
import org.roboid.studio.robotcomposer.actions.ZoomOutAction;
import org.roboid.studio.robotcomposer.editparts.RobotComposerEditPartFactory;

/**
 * @author Kwang-Hyun Park
 */
public class RobotGraphicalEditor extends GraphicalEditorWithPalette implements IMenuListener, IEditingDomainProvider
{
	private RobotComposer parent;
	private RobotDiagram diagram;
	private static PaletteRoot palette;
	
	public RobotGraphicalEditor(RobotComposer parent)
	{
		super.setEditDomain(new DefaultEditDomain(this));
		this.parent = parent;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void createActions()
	{
		super.createActions();
		
		IAction action = new AlignmentAction((IWorkbenchPart)this, PositionConstants.CENTER);
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new AlignmentAction((IWorkbenchPart)this, PositionConstants.MIDDLE);
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
	}

	@Override
	protected void configureGraphicalViewer()
	{
		super.configureGraphicalViewer();
		
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(RobotComposerEditPartFactory.INSTANCE);
		
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		
		ZoomManager manager = rootEditPart.getZoomManager();
		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
		
		createContextMenuFor(viewer);
		getEditorSite().setSelectionProvider(viewer);
		
		viewer.addDropTargetListener(new ImportDropListener(viewer, FileTransfer.getInstance()));
		
		PaletteEditPart palette = (PaletteEditPart)getPaletteViewer().getRootEditPart().getContents();
		palette.getFigure().setBackgroundColor(ColorConstants.white);
	}
	
	@Override
	public ActionRegistry getActionRegistry()
	{
		return super.getActionRegistry();
	}

	protected void createContextMenuFor(GraphicalViewer viewer)
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
	public EditingDomain getEditingDomain()
	{
		return parent.getEditingDomain();
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
		return ((BasicCommandStack)getEditingDomain().getCommandStack()).isSaveNeeded();
	}

	@Override
	protected void initializeGraphicalViewer()
	{
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(getDiagram());
		layoutDiagram();
	}
	
	@Override
	protected int getInitialPaletteSize()
	{
		return 145;
	}
	
	@Override
	protected PaletteRoot getPaletteRoot()
	{
		if(palette == null)
		{
			palette = new PaletteRoot();
			
			PaletteGroup group = new PaletteGroup("Selection Tool");
			ToolEntry select = new PanningSelectionToolEntry();
			group.add(select);
			palette.setDefaultEntry(select);
			
			group.add(new MarqueeToolEntry());
			group.add(new PaletteSeparator());
			group.add(new ConnectionCreationToolEntry("Connection", "Connect blocks",
					new SimpleEFactory(RobotComposerPackage.eINSTANCE.getAssociation()),
					ExtendedImageRegistry.INSTANCE.getImageDescriptor(RobotComposerPlugin.INSTANCE.getImage("connection16.gif")),
					ExtendedImageRegistry.INSTANCE.getImageDescriptor(RobotComposerPlugin.INSTANCE.getImage("connection16.gif"))));
			palette.add(group);
		}
		return palette;
	}
	
	private class SimpleEFactory implements CreationFactory
	{
		private EClass type;
		
		public SimpleEFactory(EClass aClass)
		{
			type = aClass;
		}
		
		public Object getNewObject()
		{
			try
			{
				return RobotComposerFactory.eINSTANCE.create(type);
			}
			catch (Exception e)
			{
				return null;
			}
		}
		
		public Object getObjectType()
		{
			return type;
		}
	}

	public RobotDiagram getDiagram()
	{
		if(diagram == null)
		{
			Resource resource = getEditingDomain().getResourceSet().getResources().get(0);
			diagram = (RobotDiagram)resource.getContents().get(1);
		}
		return diagram;
	}
	
	private void layoutDiagram()
	{
		RobotDiagram diagram = getDiagram();
		int y = -1;
		RoboidBlock bottom = null;
		for(RoboidBlock block : diagram.getBlocks())
		{
			if(y < block.getY())
			{
				y = block.getY();
				bottom = block;
			}
		}
		
		if(y < 0) y = RobotComposerConstants.GRID;
		else if(bottom != null) y = RobotGraphicalEditor.snap(y + 26 + bottom.getDevices().size() * 18) + RobotComposerConstants.GRID;
		
		for(RoboidBlock block : diagram.getBlocks())
		{
			if(block.getX() < 0)
				block.setX(RobotComposerConstants.GRID * 5);
			if(block.getY() < 0)
			{
				block.setY(y);
				y = RobotGraphicalEditor.snap(y + 26 + block.getDevices().size() * 18) + RobotComposerConstants.GRID;
			}
		}
	}
	
	public static int snap(int value)
	{
		return RobotComposerConstants.GRID * Math.round((float)value / RobotComposerConstants.GRID);
	}
	
	class ImportDropListener extends AbstractTransferDropTargetListener
	{
		private int horizontalScrollBarPosition;
		private int verticalScrollBarPosition;
		
		public ImportDropListener(EditPartViewer viewer, Transfer xfer)
		{
			super(viewer, xfer);
			
			FigureCanvas fc = (FigureCanvas)viewer.getControl();
			final ScrollBar horizontalScrollBar = fc.getHorizontalBar();
			final ScrollBar verticalScrollBar = fc.getVerticalBar();

			horizontalScrollBar.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					horizontalScrollBarPosition = horizontalScrollBar.getSelection();
				}
			});

			verticalScrollBar.addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					verticalScrollBarPosition = verticalScrollBar.getSelection();
				}
			});
		}

		@Override
		protected void updateTargetRequest()
		{
		}

		@Override
		protected Request createTargetRequest()
		{
			return new CreateRequest();
		}

		@Override
		public void drop(DropTargetEvent event)
		{
			if(FileTransfer.getInstance().isSupportedType(event.currentDataType))
			{
				List<RoboidBlock> newBlocks = new ArrayList<RoboidBlock>();
				List<Control> newControls = new ArrayList<Control>();
				Point dropLocation = new Point();
				dropLocation.x = getDropLocation().x + horizontalScrollBarPosition;
				dropLocation.y = getDropLocation().y + verticalScrollBarPosition;
				dropLocation.x = RobotGraphicalEditor.snap(dropLocation.x);
				dropLocation.y = RobotGraphicalEditor.snap(dropLocation.y);
				
				String[] fileNames = (String[])event.data;
				for(String fileName : fileNames)
				{
					String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
					if(ext.equalsIgnoreCase("roboid"))
					{
						try
						{
							ResourceSet resourceSet = new ResourceSetImpl();
							URI uri = URI.createFileURI(fileName);
							Resource resource = resourceSet.getResource(uri, true);
							EList<EObject> objects = resource.getContents();
							if(objects.isEmpty()) continue;
							
							Robot newRobot = (Robot)objects.get(0);
							if(newRobot == null) continue;
							
							for(Roboid newRoboid : newRobot.getRoboids())
							{
								RoboidBlock newBlock = RobotComposerFactory.eINSTANCE.createRoboidBlock();
								newBlock.setRoboid(newRoboid);
								newBlock.setDiagram(getDiagram());
								newBlock.setX(dropLocation.x);
								newBlock.setY(dropLocation.y);
								dropLocation.x += RobotComposerConstants.GRID * 2;
								dropLocation.y += RobotComposerConstants.GRID * 2;
								newBlocks.add(newBlock);
							}
							for(Control newControl : newRobot.getControls())
							{
								if(!newControl.getChannels().isEmpty())
									newControls.add(newControl);
							}
						}
						catch (Exception e)
						{
						}
					}
				}
				
				Robot targetRobot = getDiagram().getRobot();
				CompoundCommand command = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
				for(RoboidBlock newBlock : newBlocks)
				{
					command.append(AddCommand.create(getEditingDomain(), getDiagram(), RobotComposerPackage.Literals.ROBOT_DIAGRAM__BLOCKS, newBlock));
					command.append(AddCommand.create(getEditingDomain(), targetRobot, RobotPackage.Literals.ROBOT__ROBOIDS, newBlock.getRoboid()));
				}
				if(newControls.size() > 0)
					command.append(AddCommand.create(getEditingDomain(), targetRobot, RobotPackage.Literals.ROBOT__CONTROLS, newControls));
				
				CommandStack commandStack = getEditingDomain().getCommandStack();
				if(command.canExecute())
					commandStack.execute(command);
				else
					command.dispose();
			}
			super.drop(event);
		}
	}
}
