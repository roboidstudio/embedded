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

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.AbstractConnectionCreationTool;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.roboid.robot.Device;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.SensoryDevice;
import org.roboid.studio.robotcomposer.editparts.DeviceElementEditPart;
import org.roboid.studio.robotcomposer.editparts.RoboidBlockEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class ConnectionCreationTool extends AbstractConnectionCreationTool
{
	private DeviceSelectionMenu menu = new DeviceSelectionMenu();
	private Device sourceDevice;
	
	public ConnectionCreationTool()
	{
		setUnloadWhenFinished(false);
	}

	public ConnectionCreationTool(CreationFactory factory)
	{
		setFactory(factory);
		setUnloadWhenFinished(false);
	}

	@Override
	protected boolean handleButtonDown(int button)
	{
		if(button == 1 && stateTransition(STATE_CONNECTION_STARTED, STATE_TERMINAL))
			eraseSourceFeedback();
		else
			super.handleButtonDown(button);
		
		if(button == 1)
		{
			EditPart target = getTargetEditPart();
			if(!(target instanceof RoboidBlockEditPart || target instanceof DeviceElementEditPart))
				sourceDevice = null;
			
			if(target instanceof RoboidBlockEditPart)
			{
				RoboidBlockEditPart part = (RoboidBlockEditPart)target;
				Device device = menu.open(part, sourceDevice);
				if(device == null)
				{
					setState(STATE_INVALID);
					handleInvalidInput();
					handleFinished();
				}
				else if(isInState(STATE_TERMINAL))
				{
					executeConnectionCommand(sourceDevice, device);
					device = null;
				}
				sourceDevice = device;
				part.getModel().setSourceDevice(device);
			}
			else if(target instanceof DeviceElementEditPart)
				sourceDevice = ((DeviceElement)target.getModel()).getDevice();
			else if(isInState(STATE_TERMINAL))
				return handleCreateConnection();
			
			if(isInState(STATE_CONNECTION_STARTED))
				handleDrag();
		}
		return true;
	}
	
	private void executeConnectionCommand(Device sourceDevice, Device targetDevice)
	{
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof RobotComposer)
		{
			EditingDomain domain = ((RobotComposer)editor).getEditingDomain();
			if(sourceDevice != null && targetDevice != null)
			{
				CommandStack commandStack = ((RobotComposer)editor).getEditingDomain().getCommandStack();
				org.eclipse.emf.common.command.Command command = null;
				if(sourceDevice.isProxy())
					command = SetCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__PROXY_FOR), targetDevice);
				else if(sourceDevice instanceof SensoryDevice)
					command = AddCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__RECEPTORS), targetDevice);
				if(command != null)
				{
					if(command.canExecute())
						commandStack.execute(command);
					else
						command.dispose();
				}
			}
		}
	}
	
	@Override
	protected boolean handleFocusLost()
	{
		if(isInState(STATE_CONNECTION_STARTED | STATE_ACCESSIBLE_DRAG_IN_PROGRESS))
		{
			eraseSourceFeedback();
			eraseTargetFeedback();
			setState(STATE_INVALID);
			handleFinished();
		}
		return super.handleFocusLost();
	}

	@Override
	public void mouseWheelScrolled(Event event, EditPartViewer viewer)
	{
		if(isInState(STATE_INITIAL | STATE_CONNECTION_STARTED))
			performViewerMouseWheel(event, viewer);
	}

	@Override
	public Input getCurrentInput()
	{
		return super.getCurrentInput();
	}
}
