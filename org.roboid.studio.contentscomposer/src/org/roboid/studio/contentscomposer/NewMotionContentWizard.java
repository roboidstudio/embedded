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

package org.roboid.studio.contentscomposer;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.roboid.core.component.activity.ActivityFactory;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class NewMotionContentWizard extends Wizard implements INewWizard
{
	private MotionContentWizardNewFileCreationPage newFileCreationPage;
	private MotionContentWizardRobotModelSelectionPage robotModelSelectionPage;
	private IStructuredSelection selection;
	private IWorkbench workbench;
	private File robotFile;
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection)
	{
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("New");
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/new_content_wiz.png"));
	}

	public class MotionContentWizardNewFileCreationPage extends WizardNewFileCreationPage
	{
		public MotionContentWizardNewFileCreationPage(String pageId, IStructuredSelection selection)
		{
			super(pageId, selection);
		}
		
		@Override
		protected boolean validatePage()
		{
			checkRobotFile();
			
			if(super.validatePage())
			{
				String[] fileNames = null;
				String fileName = getNewFile().getName();
				IPath path = getContainerFullPath().append(fileName);
				IPath parentPath = ResourcesPlugin.getWorkspace().getRoot().getFile(path).getParent().getLocation();
				if(parentPath != null)
				{
					fileNames = parentPath.toFile().list(new FilenameFilter()
					{
						@Override
						public boolean accept(File dir, String name)
						{
							return name.toLowerCase().endsWith(".mcc");
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
							robotFile = null;
							return false;
						}
					}
				}
				return true;
			}
			robotFile = null;
			return false;
		}
		
		private void checkRobotFile()
		{
			IPath projectPath = null;
			String[] fileNames = null;
			IPath path = getContainerFullPath();
			if(path != null)
			{
				String projectName = path.segment(0);
				if(projectName != null)
				{
					projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation();
					if(projectPath != null)
					{
						fileNames = projectPath.toFile().list(new FilenameFilter()
						{
							@Override
							public boolean accept(File dir, String name)
							{
								return name.toLowerCase().endsWith(".robot");
							}
						});
					}
				}
			}
			if(projectPath != null && fileNames != null && fileNames.length > 0)
				robotFile = projectPath.append(fileNames[0]).toFile();
			else
				robotFile = null;
		}

		@Override
		public IWizardPage getNextPage()
		{
			if(robotFile != null) return null;
			return super.getNextPage();
		}

		public IFile getNewFile()
		{
			String fileName = getFileName();
			IPath path = getContainerFullPath().append(fileName);
			path = path.removeFileExtension();
			
			String extension = path.getFileExtension();
			if("mcc".equalsIgnoreCase(extension))
				path = path.removeFileExtension();
			path = path.addFileExtension("mcc");

			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
	}
	
	private IFile getNewFile()
	{
		return newFileCreationPage.getNewFile();
	}
	
	public class MotionContentWizardRobotModelSelectionPage extends WizardPage
	{
		private TreeViewer treeViewer;
		private IFile selectedRobotFile;
		private IFile defaultRobotFile;
		
		public MotionContentWizardRobotModelSelectionPage(String pageId)
		{
			super(pageId);
		}

		public void createControl(Composite parent)
		{
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.verticalSpacing = 5;
				composite.setLayout(layout);
				composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			}

			Label robotModelLabel = new Label(composite, SWT.LEFT);
			robotModelLabel.setText("Robot &model:");
			robotModelLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			createTreeViewer(composite);
			
			setPageComplete(false);
			setControl(composite);
		}
		
		protected void createTreeViewer(Composite parent)
		{
			Tree tree = new Tree(parent, SWT.BORDER);
			tree.setLayout(new GridLayout());
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			treeViewer = new TreeViewer(tree);
			treeViewer.setContentProvider(new WorkbenchContentProvider()
			{
				@Override
				public Object[] getChildren(Object element)
				{
					if(element instanceof IProject)
					{
						for(Object child : super.getChildren(element))
						{
							String name = ((IResource)child).getName();
							if(name.equals("robots")) return new Object[]{ child };
						}
						return new Object[0];
					}
					else if(element instanceof IFolder)
					{
						List<Object> children = new ArrayList<Object>();
						for(Object child : super.getChildren(element))
						{
							if(((IResource)child).getName().endsWith(".robot"))
								children.add(child);
		                }
						return children.toArray();
					}
					return new Object[0];
				}
			});
			treeViewer.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
//			treeViewer.setComparator(new WorkbenchViewerComparator());
			treeViewer.setComparator(new ResourceComparator(ResourceComparator.NAME));
			treeViewer.setUseHashlookup(true);
			treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
			{
				public void selectionChanged(SelectionChangedEvent event)
				{
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					containerSelectionChanged(selection.getFirstElement()); // allow null
				}
			});
			treeViewer.addDoubleClickListener(new IDoubleClickListener()
			{
				public void doubleClick(DoubleClickEvent event)
				{
					ISelection selection = event.getSelection();
					if(selection instanceof IStructuredSelection)
					{
						Object item = ((IStructuredSelection)selection).getFirstElement();
						if(item == null)
							return;
						if(item instanceof IFolder)
						{
							if(treeViewer.getExpandedState(item))
								treeViewer.collapseToLevel(item, 1);
							else
								treeViewer.expandToLevel(item, 1);
						}
					}
				}
			});

			treeViewer.setAutoExpandLevel(3);
			treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProject("model"));
		}

		@Override
		public void setVisible(boolean visible)
		{
			super.setVisible(visible);
			if(defaultRobotFile != null)
				treeViewer.setSelection(new StructuredSelection(defaultRobotFile), true);
		}

		public void containerSelectionChanged(Object element)
		{
			setPageComplete(validatePage(element));
			selectedRobotFile = (element instanceof IFile) ? (IFile)element : null; 
		}
		
		protected boolean validatePage(Object element)
		{
			return (element instanceof IFile);
		}

		public IFile getModelFile()
		{
			return selectedRobotFile;
		}
	}
	
	private IFile getModelFile()
	{
		return robotModelSelectionPage.getModelFile();
	}
	
	@Override
	public void addPages()
	{
		newFileCreationPage = new MotionContentWizardNewFileCreationPage("Create Contents Clip", selection);
		newFileCreationPage.setDescription("Create a new contents clip");
		newFileCreationPage.setTitle("New Contents Clip");
		newFileCreationPage.setFileExtension("mcc");
		addPage(newFileCreationPage);
		
		robotModelSelectionPage = new MotionContentWizardRobotModelSelectionPage("Select Robot Model");
		robotModelSelectionPage.setTitle("Robot Model");
		robotModelSelectionPage.setDescription("Select a robot model");
		addPage(robotModelSelectionPage);
	}
	
	@Override
	public boolean canFinish()
	{
		if(robotFile != null || getModelFile() != null)
			return true;
		return super.canFinish();
	}

	@Override
	public boolean performFinish()
	{
		try
		{
			final IFile newFile = getNewFile();
			
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
			{
				@Override
				protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
				{
					try
					{
						File modelFile = null;
						if(robotFile != null) modelFile = robotFile;
						else if(getModelFile() != null) modelFile = getModelFile().getLocation().toFile();
						if(modelFile == null) return;
						
						Robot robot = RobotFactory.eINSTANCE.createRobot(modelFile);
						
						ResourceSet resourceSet = new ResourceSetImpl();
						URI contentURI = URI.createPlatformResourceURI(newFile.getFullPath().toString(), true);
						Resource resource = resourceSet.createResource(contentURI);
						
						MotionContent content = ContentsComposer.createContentsClip(robot);
						if(content != null)
						{
							resource.getContents().add((EObject)robot);
							resource.getContents().add((EObject)ActivityFactory.eINSTANCE.createActivity(robot));
							resource.getContents().add((EObject)content);
						}
						
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
				final ISelection targetSelection = new StructuredSelection(newFile);
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
				page.openEditor(new FileEditorInput(newFile), workbench.getEditorRegistry().getDefaultEditor(newFile.getFullPath().toString()).getId());
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
