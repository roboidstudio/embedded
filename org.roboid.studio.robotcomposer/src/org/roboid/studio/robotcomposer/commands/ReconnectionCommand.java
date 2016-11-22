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

package org.roboid.studio.robotcomposer.commands;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.roboid.robot.Device;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.SensoryDevice;
import org.roboid.studio.robotcomposer.Association;
import org.roboid.studio.robotcomposer.ConnectableElement;
import org.roboid.studio.robotcomposer.DeviceElement;
import org.roboid.studio.robotcomposer.DeviceSelectionMenu;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotComposer;
import org.roboid.studio.robotcomposer.editparts.RoboidBlockEditPart;

/**
 * @author Kwang-Hyun Park
 */
public class ReconnectionCommand extends Command
{
	private Association association;
	private EditPart targetEditPart;
	private ConnectableElement newSource;
	private ConnectableElement newTarget;

	public ReconnectionCommand(Association association, EditPart targetEditPart)
	{
		this.association = association;
		this.targetEditPart = targetEditPart;
	}

	@Override
	public boolean canExecute()
	{
		ConnectableElement oldSource = association.getSource();
		ConnectableElement oldTarget = association.getTarget();
		if(oldSource == null || oldTarget == null) return false;
		
		if(newSource != null) // modify source
		{
			// source and target should be different
			if(newSource == oldTarget) return false;
			if(!oldTarget.canReconnectFrom(oldSource, newSource)) return false;
			return true;
		}
		else if(newTarget != null) // modify target
		{
			// source and target should be different
			if(oldSource == newTarget) return true;
			if(!oldSource.canReconnectTo(oldTarget, newTarget)) return false;
			return true;
		}
		return false;
	}

	@Override
	public void execute()
	{
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof RobotComposer)
		{
			EditingDomain domain = ((RobotComposer)editor).getEditingDomain();
			ConnectableElement oldSource = association.getSource();
			ConnectableElement oldTarget = association.getTarget();
			if(!(oldSource instanceof DeviceElement)) return;
			if(!(oldTarget instanceof DeviceElement)) return;
			
			if(newSource != null) // modify source
			{
				Device oldSourceDevice = ((DeviceElement)oldSource).getDevice();
				Device targetDevice = ((DeviceElement)oldTarget).getDevice();
				if(oldSourceDevice == null || targetDevice == null) return;
				
				Device newSourceDevice = null;
				if(newSource instanceof DeviceElement)
					newSourceDevice = ((DeviceElement)newSource).getDevice();
				else if(newSource instanceof RoboidBlock)
					newSourceDevice = new DeviceSelectionMenu().open((RoboidBlockEditPart)targetEditPart, null, targetDevice);
				if(newSourceDevice == null) return;

				CommandStack commandStack = domain.getCommandStack();
				CompoundCommand command = new CompoundCommand();
				if(oldSourceDevice.isProxy())
					command.append(SetCommand.create(domain, oldSourceDevice, ((EObject)oldSourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__PROXY_FOR), SetCommand.UNSET_VALUE));
				else if(oldSourceDevice instanceof SensoryDevice)
					command.append(RemoveCommand.create(domain, oldSourceDevice, ((EObject)newSourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__RECEPTORS), targetDevice));
				if(newSourceDevice.isProxy())
					command.append(SetCommand.create(domain, newSourceDevice, ((EObject)newSourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__PROXY_FOR), targetDevice));
				else if(newSourceDevice instanceof SensoryDevice)
					command.append(AddCommand.create(domain, newSourceDevice, ((EObject)newSourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__RECEPTORS), targetDevice));
				if(command.canExecute())
					commandStack.execute(command);
				else
					command.dispose();
			}
			else if(newTarget != null) // modify target
			{
				if(newTarget instanceof DeviceElement) return;
				Device sourceDevice = ((DeviceElement)oldSource).getDevice();
				Device oldTargetDevice = ((DeviceElement)oldTarget).getDevice();
				if(sourceDevice == null || oldTargetDevice == null) return;
				
				Device newTargetDevice = new DeviceSelectionMenu().open((RoboidBlockEditPart)targetEditPart, sourceDevice);
				if(newTargetDevice == null) return;
				
				CommandStack commandStack = domain.getCommandStack();
				CompoundCommand command = new CompoundCommand();
				if(sourceDevice.isProxy())
					command.append(SetCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__PROXY_FOR), newTargetDevice));
				else if(sourceDevice instanceof SensoryDevice)
				{
					command.append(RemoveCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__RECEPTORS), oldTargetDevice));
					command.append(AddCommand.create(domain, sourceDevice, ((EObject)sourceDevice).eClass().getEStructuralFeature(RobotPackage.SENSOR__RECEPTORS), newTargetDevice));
				}
				if(command.canExecute())
					commandStack.execute(command);
				else
					command.dispose();
			}
		}
	}

	public void setNewSource(ConnectableElement newSource)
	{
		this.newSource = newSource;
	}
	
	public void setNewTarget(ConnectableElement newTarget)
	{
		this.newTarget = newTarget;
	}
}
