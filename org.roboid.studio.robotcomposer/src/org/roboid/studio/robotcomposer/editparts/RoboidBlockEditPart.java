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

package org.roboid.studio.robotcomposer.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.roboid.robot.Device;
import org.roboid.robot.Roboid;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.ConnectableElement;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotComposer;
import org.roboid.studio.robotcomposer.RobotComposerPackage;
import org.roboid.studio.robotcomposer.RobotComposerPlugin;
import org.roboid.studio.robotcomposer.commands.MoveBlockElementCommand;
import org.roboid.studio.robotcomposer.editpolicies.ConnectableElementGraphicalNodeEditPolicy;

/**
 * @author Kwang-Hyun Park
 */
public class RoboidBlockEditPart extends EditPartWithListener implements NodeEditPart
{
	private final Image image = ExtendedImageRegistry.INSTANCE.getImage(RobotComposerPlugin.INSTANCE.getImage("roboidblock.png"));
	private DeviceElement sourceDevice;

	@Override
	protected IFigure createFigure()
	{
		RectangleFigure figure = new RectangleFigure()
		{
			@Override
			protected void fillShape(Graphics g)
			{
				int x = getClientArea().x;
				int y = getClientArea().y;
				g.drawImage(image, x, y);
				
				RoboidBlock block = getModel();
				if(block.getRoboid() != null)
					g.drawText(block.getName(), x + 20, y + 5);
			}
			
			@Override
			protected void outlineShape(Graphics g)
			{
			}
		};
		figure.setSize(96, 24);
		return figure;
	}

	public DeviceElement getSourceDevice()
	{
		return sourceDevice;
	}
	
	public void setSourceDevice(DeviceElement device)
	{
		sourceDevice = device;
	}
	
	@Override
	public RoboidBlock getModel()
	{
		return (RoboidBlock)super.getModel();
	}
	
	@Override
	protected void hookIntoModel()
	{
		super.hookIntoModel();
		hookIntoModel(getModel().getRoboid());
	}
	
	private void hookIntoModel(Roboid roboid)
	{
		if(roboid == null) return;
		((EObject)roboid).eAdapters().add(this);
		for(Device device : roboid.getDevices())
			((EObject)device).eAdapters().add(this);
		for(Roboid child : roboid.getRoboids())
			hookIntoModel(child);
	}
	
	@Override
	protected void unhookFromModel()
	{
		super.unhookFromModel();
		unhookFromModel(getModel().getRoboid());
	}
	
	private void unhookFromModel(Roboid roboid)
	{
		if(roboid == null) return;
		((EObject)roboid).eAdapters().remove(this);
		for(Device device : roboid.getDevices())
			((EObject)device).eAdapters().remove(this);
		for(Roboid child : roboid.getRoboids())
			unhookFromModel(child);
	}
	
	@Override
	public boolean isAdapterForType(Object type)
	{
		return ((getModel().getClass() == type) || (getModel().getRoboid() != null && getModel().getRoboid().getClass() == type));
	}
	
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectableElementGraphicalNodeEditPolicy());
	}

	@Override
	protected void refreshVisuals()
	{
		RoboidBlock block = getModel();
		Point point = new Point(block.getX(), block.getY());
		Dimension dim = new Dimension(-1, -1);
		Rectangle rect = new Rectangle(point, dim);
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), rect);
	}
	
	@Override
	public Command getCommand(Request request)
	{
		if(request instanceof CreateConnectionRequest)
		{
			RoboidBlock source = getModel();
			if(source == null || !source.canConnectTo(null)) return null;
		}
		return super.getCommand(request);
	}

	@Override
	protected List<DeviceElement> getModelSourceConnections()
	{
		return getModel().getDevices();
	}
	
	@Override
	protected List<Association> getModelTargetConnections()
	{
		return getModel().getIncomings();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
	{
		return new ChopboxAnchor(getFigure());
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request request)
	{
		if(request instanceof ReconnectRequest)
		{
			ReconnectRequest req = (ReconnectRequest)request;
			Association association = (Association)req.getConnectionEditPart().getModel();
			ConnectableElement oldSource = association.getSource();
			ConnectableElement oldTarget = association.getTarget();
			if(oldSource == null || oldTarget == null)
				return new XYAnchor(req.getLocation());
			
			EditPart newSourcePart = req.getTarget();
			if(newSourcePart == null)
				return new XYAnchor(req.getLocation());
			
			ConnectableElement newSource = (ConnectableElement)((GraphicalEditPart)newSourcePart).getModel();
			if(newSource == null || !oldTarget.canReconnectFrom(oldSource, newSource))
				return new XYAnchor(req.getLocation());
		}
		return new ChopboxAnchor(getFigure());
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
	{
		return new ChopboxAnchor(getFigure());
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request request)
	{
		if(request instanceof CreateConnectionRequest)
		{
			CreateConnectionRequest req = (CreateConnectionRequest)request;
			EditPart sourcePart = req.getSourceEditPart();
			EditPart targetPart = req.getTargetEditPart();
			if(sourcePart == null || targetPart == null)
				return new XYAnchor(req.getLocation());
			
			ConnectableElement sourceElement = (ConnectableElement)sourcePart.getModel();
			ConnectableElement targetElement = (ConnectableElement)targetPart.getModel();
			
			if(sourceElement == null || targetElement == null || !targetElement.canConnectFrom(sourceElement))
				return new XYAnchor(req.getLocation());
		}
		else if(request instanceof ReconnectRequest)
		{
			ReconnectRequest req = (ReconnectRequest)request;
			Association association = (Association)req.getConnectionEditPart().getModel();
			ConnectableElement oldSource = association.getSource();
			ConnectableElement oldTarget = association.getTarget();
			if(oldSource == null || oldTarget == null)
				return new XYAnchor(req.getLocation());
			
			EditPart newTargetPart = req.getTarget();
			if(newTargetPart == null)
				return new XYAnchor(req.getLocation());
			
			ConnectableElement newTarget = (ConnectableElement)((GraphicalEditPart)newTargetPart).getModel();
			if(newTarget == null || !oldSource.canReconnectTo(oldTarget, newTarget))
				return new XYAnchor(req.getLocation());
		}
		return new ChopboxAnchor(getFigure());
	}
	
	public void refreshDeviceElements()
	{
		refreshSourceConnections();
		for(Object o : getSourceConnections())
		{
			IFigure figure = ((GraphicalEditPart)o).getFigure();
			figure.getLayoutManager().layout(figure);
		}
	}
	
	@Override
	public void notifyChanged(Notification notification)
	{
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(RobotComposerPackage.class);
		if(notification.getNotifier() instanceof Device)
		{
			switch(featureId)
			{
				case RobotPackage.SENSOR__PROXY_FOR: // includes all types of ??__PROXY_FOR
				{
					if(type == Notification.SET)
					{
						Device oldDevice = (Device)notification.getOldValue();
						Device newDevice = (Device)notification.getNewValue();
						if(oldDevice == null && newDevice != null)
						{
							Device sourceDevice = (Device)notification.getNotifier();
							getModel().getDiagram().connect(sourceDevice, newDevice, true);
						}
					}
					break;
				}
				case RobotPackage.SENSOR__RECEPTORS: // includes RobotPackage.EVENT__RECEPTORS
				{
					if(type == Notification.ADD)
					{
						Device sourceDevice = (Device)notification.getNotifier();
						Device targetDevice = (Device)notification.getNewValue();
						getModel().getDiagram().connect(sourceDevice, targetDevice, false);
					}
					break;
				}
			}
		}
		else
		{
			switch(featureId)
			{
				case RobotPackage.NAMED_ELEMENT__NAME:
				{
					getModel().refreshName();
					getFigure().repaint();
					break;
				}
				case RobotComposerPackage.ROBOID_BLOCK__X:
				case RobotComposerPackage.ROBOID_BLOCK__Y:
				{
					refreshVisuals();
					break;
				}
				case RobotComposerPackage.ROBOID_BLOCK__DEVICES:
				{
					switch(type)
					{
						case Notification.ADD:
						case Notification.REMOVE:
						{
							refreshSourceConnections();
							for(Object o : getSourceConnections())
								((GraphicalEditPart)o).getFigure().revalidate();
							break;
						}
					}
					break;
				}
			}
		}
	}

	@Override
	public DragTracker getDragTracker(Request request)
	{
		return new DragEditPartsTracker(this)
		{
			@Override
			protected void executeCommand(Command command)
			{
				IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(!(part instanceof RobotComposer))
				{
					super.executeCommand(command);
					return;
				}
				
				List<MoveBlockElementCommand> moveCommands = new ArrayList<MoveBlockElementCommand>();
				if(command instanceof CompoundCommand)
				{
					for(Object o : ((CompoundCommand)command).getCommands())
					{
						if(o instanceof MoveBlockElementCommand)
							moveCommands.add((MoveBlockElementCommand)o);
					}
				}
				
				if(moveCommands.isEmpty())
					super.executeCommand(command);
				else
				{
					RobotComposer editor = (RobotComposer)part;
					org.eclipse.emf.common.command.CompoundCommand newCommand = new org.eclipse.emf.common.command.CompoundCommand(org.eclipse.emf.common.command.CompoundCommand.MERGE_COMMAND_ALL);
					for(MoveBlockElementCommand c : moveCommands)
					{
						RoboidBlock block = c.getBlock();
						int x = c.getX();
						int y = c.getY();
						newCommand.append(SetCommand.create(editor.getEditingDomain(), block, RobotComposerPackage.Literals.ROBOID_BLOCK__X, x));
						newCommand.append(SetCommand.create(editor.getEditingDomain(), block, RobotComposerPackage.Literals.ROBOID_BLOCK__Y, y));
					}
					CommandStack commandStack = editor.getEditingDomain().getCommandStack();
					if(newCommand.canExecute())
						commandStack.execute(newCommand);
					else
						newCommand.dispose();
				}
			}
		};
	}
}
