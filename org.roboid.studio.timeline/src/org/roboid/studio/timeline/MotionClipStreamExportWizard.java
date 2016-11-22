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

package org.roboid.studio.timeline;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.WorkbenchPlugin;

/**
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class MotionClipStreamExportWizard extends Wizard implements IExportWizard
{
	private MotionClipStreamExportPage clipFileExportPage;
	private IStructuredSelection selection;
	
	public MotionClipStreamExportWizard()
	{
		IDialogSettings settings = WorkbenchPlugin.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection("MotionClipStreamExportWizard");
		if(section == null)
			section = settings.addNewSection("MotionClipStreamExportWizard");
		setDialogSettings(section);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection)
	{
		this.selection = selection;
		@SuppressWarnings("rawtypes")
		List selectedResources = IDE.computeSelectedResources(selection);
		if(!selectedResources.isEmpty())
			this.selection = new StructuredSelection(selectedResources);
		
		if(selection.isEmpty() && workbench.getActiveWorkbenchWindow() != null)
		{
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			if(page != null)
			{
				IEditorPart currentEditor = page.getActiveEditor();
				if(currentEditor != null)
				{
					Object selectedResource = currentEditor.getEditorInput().getAdapter(IResource.class);
					if(selectedResource != null)
						this.selection = new StructuredSelection(selectedResource);
				}
			}
		}
		
		setWindowTitle("New");
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/NewMotionClipWizard.png"));
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages()
	{
		super.addPages();
		clipFileExportPage = new MotionClipStreamExportPage("Export Motion Clip", selection);
		clipFileExportPage.setTitle("Motion Clip Stream");
		clipFileExportPage.setDescription("Export a motion clip into a motion clip stream file on the local file system");
		addPage(clipFileExportPage);
	}

	@Override
	public boolean performFinish()
	{
		return clipFileExportPage.finish();
	}
}
