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

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;

/**
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class NewRobotModelWizard extends Wizard implements INewWizard
{
	private RobotModelWizardNewFileCreationPage newFileCreationPage;
	private RobotModelWizardInitialObjectCreationPage initialObjectCreationPage;
	private IStructuredSelection selection;
	private IWorkbench workbench;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection)
	{
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("New");
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(RobotComposerPlugin.INSTANCE.getImage("new_robot_wiz.png")));
	}
	
	public class RobotModelWizardNewFileCreationPage extends WizardNewFileCreationPage
	{
		public RobotModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection)
		{
			super(pageId, selection);
		}

		@Override
		protected boolean validatePage()
		{
			if(super.validatePage())
			{
				String[] fileNames = null;
				String fileName = getModelFile().getName();
				IPath path = getContainerFullPath().append(fileName);
				IPath parentPath = ResourcesPlugin.getWorkspace().getRoot().getFile(path).getLocation();
				if(parentPath != null)
				{
					fileNames = parentPath.toFile().list(new FilenameFilter()
					{
						@Override
						public boolean accept(File dir, String name)
						{
							return name.toLowerCase().endsWith(".robot");
						}
					});
				}
				
				if(fileNames != null)
				{
					for(String name : fileNames)
					{
						if(name.equalsIgnoreCase(fileName))
						{
							String problemMessage = NLS.bind(IDEWorkbenchMessages.ResourceGroup_nameExists, fileName);
							setErrorMessage(problemMessage);
							return false;
						}
					}
				}
				return true;
			}
			return false;
		}
		
		public IFile getModelFile()
		{
			String fileName = getFileName();
			IPath path = getContainerFullPath().append(fileName);
			path = path.removeFileExtension();
			
			String extension = path.getFileExtension();
			if("robot".equalsIgnoreCase(extension))
				path = path.removeFileExtension();
			path = path.addFileExtension("robot");
			
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
	}
	
	public class RobotModelWizardInitialObjectCreationPage extends WizardPage
	{
		private Text nameField;
		private Text providerField;
		
		public RobotModelWizardInitialObjectCreationPage(String pageId)
		{
			super(pageId);
		}

		public void createControl(Composite parent)
		{
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			Label nameLabel = new Label(composite, SWT.LEFT);
			{
				nameLabel.setText("&Name:");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				nameLabel.setLayoutData(data);
			}

			nameField = new Text(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				nameField.setLayoutData(data);
			}

			nameField.addModifyListener(validator);

			Label providerLabel = new Label(composite, SWT.LEFT);
			{
				providerLabel.setText("&Provider:");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				providerLabel.setLayoutData(data);
			}
			providerField = new Text(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				providerField.setLayoutData(data);
			}

			providerField.addModifyListener(validator);

			setPageComplete(validatePage());
			setControl(composite);
		}

		protected ModifyListener validator = new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				setPageComplete(validatePage());
			}
		};

		protected boolean validatePage()
		{
			return getRoboidName().isEmpty() == false && getProviderName().isEmpty() == false;
		}

		@Override
		public void setVisible(boolean visible)
		{
			super.setVisible(visible);
			if(visible)
			{
				if(getRoboidName().isEmpty() == false)
					providerField.setFocus();
				else
					nameField.setFocus();
			}
		}

		public String getRoboidName()
		{
			return nameField.getText();
		}

		public String getProviderName()
		{
			return providerField.getText();
		}
	}
	
	private IFile getModelFile()
	{
		return newFileCreationPage.getModelFile();
	}
	
	@Override
	public void addPages()
	{
		newFileCreationPage = new RobotModelWizardNewFileCreationPage("Create Robot Model", selection);
		newFileCreationPage.setTitle("New Robot Model");
		newFileCreationPage.setDescription("Create a new robot model");
		newFileCreationPage.setFileExtension("robot");
		addPage(newFileCreationPage);
		
		initialObjectCreationPage = new RobotModelWizardInitialObjectCreationPage("New2");
		initialObjectCreationPage.setTitle("New Robot Model");
		initialObjectCreationPage.setDescription("Enter the data required to generate the model");
		addPage(initialObjectCreationPage);
	}

	@Override
	public boolean performFinish()
	{
		try
		{
			final IFile modelFile = getModelFile();
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
			{
				@Override
				protected void execute(IProgressMonitor monitor)
				{
					try
					{
						Robot robot = RobotFactory.eINSTANCE.createRobot();
						String name = initialObjectCreationPage.getRoboidName();
						robot.setName(name);
						robot.setLiteral(name);
						String provider = initialObjectCreationPage.getProviderName();
						robot.setProvider(provider);
						
						ResourceSet resourceSet = new ResourceSetImpl();
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
						Resource resource = resourceSet.createResource(fileURI);

						RobotDiagram diagram = RobotComposerFactory.eINSTANCE.createRobotDiagram();
						diagram.setRobot(robot);

						resource.getContents().add((EObject)robot);
						resource.getContents().add((EObject)diagram);

						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_ENCODING, "UTF-8");
						resource.save(options);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						monitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if(activePart instanceof ISetSelectionTarget)
			{
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable()
				{
					@Override
					public void run()
					{
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}

			try
			{
				page.openEditor(new FileEditorInput(modelFile), workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
			}
			catch (PartInitException e)
			{
				MessageDialog.openError(workbenchWindow.getShell(), "Open Editor", e.getMessage());
				return false;
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
