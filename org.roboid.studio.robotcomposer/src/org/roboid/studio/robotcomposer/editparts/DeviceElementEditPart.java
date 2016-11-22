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

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.swt.graphics.Image;
import org.roboid.robot.Device;
import org.roboid.robot.RobotPackage;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.ConnectableElement;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.RobotComposerPackage;
import org.roboid.studio.robotcomposer.editpolicies.ConnectableElementGraphicalNodeEditPolicy;
import org.roboid.studio.robotcomposer.provider.DeviceItemProvider;
import org.roboid.studio.robotcomposer.provider.RobotItemProviderAdapterFactory;

/**
 * @author Kwang-Hyun Park
 */
public class DeviceElementEditPart extends AbstractConnectionEditPart implements NodeEditPart
{
	private Label label;
	private Adapter adapter = new Adapter()
	{
		private Notifier target;
		
		@Override
		public Notifier getTarget()
		{
			return target;
		}
		
		@Override
		public void setTarget(Notifier newTarget)
		{
			target = newTarget;
		}

		@Override
		public boolean isAdapterForType(Object type)
		{
			return (getModel().getClass() == type || getModel().getDevice().getClass() == type);
		}

		@Override
		public void notifyChanged(Notification notification)
		{
			DeviceElementEditPart.this.notifyChanged(notification);
		}
	};
	
	public DeviceElementEditPart()
	{
	}
	
	@Override
	public void activate()
	{
		if(!isActive())
		{
			hookIntoModel();
			super.activate();
		}
	}

	@Override
	public void deactivate()
	{
		if(isActive())
		{
			unhookFromModel();
			super.deactivate();
		}
	}
	
	private void hookIntoModel()
	{
		EObject model = (EObject)getModel();
		if(model != null)
			model.eAdapters().add(adapter);
		model = (EObject)getModel().getDevice();
		if(model != null)
			model.eAdapters().add(adapter);
	}
	
	private void unhookFromModel()
	{
		EObject model = (EObject)getModel();
		if(model != null)
			model.eAdapters().remove(adapter);
		model = (EObject)getModel().getDevice();
		if(model != null)
			model.eAdapters().remove(adapter);
	}
	
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ConnectableElementGraphicalNodeEditPolicy());
	}

	@Override
	public DeviceElement getModel()
	{
		return (DeviceElement)super.getModel();
	}
	
	public void notifyChanged(Notification notification)
	{
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(RobotComposerPackage.class);
		if(notification.getNotifier() instanceof Device)
		{
			switch(featureId)
			{
				case RobotPackage.NAMED_ELEMENT__NAME:
				{
					getModel().refreshName();
					getFigure().repaint();
					break;
				}
				case RobotPackage.SENSOR__PROXY_FOR: // includes all types of ??__PROXY_FOR
				{
					if(type == Notification.SET)
					{
						Device oldDevice = (Device)notification.getOldValue();
						Device newDevice = (Device)notification.getNewValue();
						if(oldDevice == null)
							getModel().connectTo(newDevice, true);
						else if(newDevice == null)
							getModel().disconnectFrom(oldDevice);
						else
							getModel().reconnectTo(oldDevice, newDevice);
					}
					break;
				}
				case RobotPackage.SENSOR__RECEPTORS: // includes RobotPackage.EVENT__RECEPTORS
				{
					switch(type)
					{
						case Notification.ADD:
						{
							Device targetDevice = (Device)notification.getNewValue();
							getModel().connectTo(targetDevice, false);
							break;
						}
						case Notification.REMOVE:
						{
							Device targetDevice = (Device)notification.getOldValue();
							getModel().disconnectFrom(targetDevice);
							break;
						}
					}
					break;
				}
			}
		}
		else
		{
			switch(featureId)
			{
				case RobotComposerPackage.DEVICE_ELEMENT__INCOMINGS:
					refreshTargetConnections();
					break;
				case RobotComposerPackage.DEVICE_ELEMENT__OUTGOINGS:
					refreshSourceConnections();
					break;
			}
		}
	}

	public class DevicePolylineConnection extends PolylineConnection
	{
	}
	
	@Override
	protected IFigure createFigure()
	{
		PolylineConnection connection = new DevicePolylineConnection()
		{
			@Override
			protected void outlineShape(Graphics g)
			{
			}
		};
		
		ConnectionEndpointLocator locator = new ConnectionEndpointLocator(connection, false)
		{
			@Override
			public void relocate(IFigure figure)
			{
				EditPart part = getSource();
				if(!(part instanceof RoboidBlockEditPart)) return;
				
				RoboidBlockEditPart reference = (RoboidBlockEditPart)part;
				Point ref = reference.getFigure().getBounds().getBottomLeft();
				int index = reference.getModel().getDevices().indexOf(getModel());

				Rectangle rect = Rectangle.SINGLETON;
				Dimension dim = ((Label)figure).getPreferredSize();
				dim.height = 18;
				rect.setSize(dim);
				rect.setLocation(ref.x + 8, ref.y + index * 18 + 2);
				figure.setBounds(rect);
			}
		};
		connection.add(getLabel(), locator);
		return connection;
	}
	
	private Label getLabel()
	{
		if(label == null)
		{
			label = new Label();
			label.setText(getModel().getName());
			
			Device device = getModel().getDevice();
			if(device != null)
			{
				AdapterFactory factory = new RobotItemProviderAdapterFactory();
				DeviceItemProvider p = (DeviceItemProvider)factory.adapt(device, IItemLabelProvider.class);
				Image image = ExtendedImageRegistry.INSTANCE.getImage(p.getImage(device));
				label.setIcon(image);
			}
		}
		return label;
	}
	
	@Override
	public Command getCommand(Request request)
	{
		if(request instanceof CreateConnectionRequest)
		{
			DeviceElement source = getModel();
			if(source == null || !source.canConnectTo(null)) return null;
		}
		return super.getCommand(request);
	}

	@Override
	protected List<Association> getModelSourceConnections()
	{
		return getModel().getOutgoings();
	}

	@Override
	protected List<Association> getModelTargetConnections()
	{
		return getModel().getIncomings();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
	{
		return new SideAnchor(getLabel());
	}

	@Override
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
		return new SideAnchor(getLabel());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
	{
		return new SideAnchor(getLabel());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request)
	{
		if(request instanceof CreateConnectionRequest)
			return new XYAnchor(((CreateConnectionRequest)request).getLocation());
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
		return new SideAnchor(getLabel());
	}
}
