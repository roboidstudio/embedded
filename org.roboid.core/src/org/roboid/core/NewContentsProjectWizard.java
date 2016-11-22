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

package org.roboid.core;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.activities.IIdentifier;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.internal.IPreferenceConstants;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.ide.IDEInternalPreferences;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.dialogs.ResourceComparator;
import org.eclipse.ui.internal.misc.StatusUtil;
import org.eclipse.ui.internal.registry.PerspectiveDescriptor;
import org.eclipse.ui.internal.util.PrefUtil;
import org.eclipse.ui.internal.wizards.newresource.ResourceMessages;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

/**
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class NewContentsProjectWizard extends BasicNewResourceWizard implements IExecutableExtension
{
	public static final String WIZARD_ID = "org.eclipse.ui.wizards.new.project";
	
	private WizardNewContentsProjectCreationPage mainPage;
	private IProject newProject;
	private IConfigurationElement configElement;
	private static String WINDOW_PROBLEMS_TITLE = ResourceMessages.NewProject_errorOpeningWindow;
	private static final String FINAL_PERSPECTIVE = "finalPerspective";
	private static final String PREFERRED_PERSPECTIVES = "preferredPerspectives";

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection)
	{
		super.init(workbench, currentSelection);
		setNeedsProgressMonitor(true);
		setWindowTitle("New Contents Project");
	}
	
	public class WizardNewContentsProjectCreationPage extends WizardNewProjectCreationPage
	{
		private TreeViewer treeViewer;
		private IFile selectedRobotFile;
		private boolean firstSelection = true;
		
		public WizardNewContentsProjectCreationPage()
		{
			super("NewContentsProjectPage");
		}
		
		public void createControl(Composite parent)
		{
			super.createControl(parent);
			
			createRobotModelGroup((Composite)getControl());
			setPageComplete(false);
		}

		private void createRobotModelGroup(Composite parent)
		{
			Composite robotModelComposite = new Composite(parent, SWT.NONE);
			robotModelComposite.setLayout(new GridLayout());
			robotModelComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

			Label robotModelLabel = new Label(robotModelComposite, SWT.LEFT);
			robotModelLabel.setText("Robot &model:");
			robotModelLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			Tree tree = new Tree(robotModelComposite, SWT.BORDER);
			tree.setLayout(new GridLayout());
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			IDialogSettings settings = Activator.getDefault().getDialogSettings();
			final String modelFileName = settings.get("Robot Model");

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
							String name = ((IResource)child).getName();
							if(name.endsWith(".robot"))
							{
								children.add(child);
								if(name.equals(modelFileName))
									selectedRobotFile = (IFile)child;
							}
		                }
						if(selectedRobotFile == null)
						{
							if(children.size() > 0)
								selectedRobotFile = (IFile)children.get(0);
						}
						return children.toArray();
					}
					return new Object[0];
				}
			});
			treeViewer.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
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
			if(selectedRobotFile != null)
				treeViewer.setSelection(new StructuredSelection(selectedRobotFile), true);
		}

		@Override
		protected boolean validatePage()
		{
			String projectName = getProjectName();
			if(projectName.equals(""))
	        {
	            setErrorMessage("Project name must be specified.");
	            return false;
	        }
			
			IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
			for(IProject project : workspace.getProjects())
			{
				if(projectName.equalsIgnoreCase(project.getName()))
				{
					String problemMessage = NLS.bind(IDEWorkbenchMessages.ResourceGroup_nameExists, projectName);
					setErrorMessage(problemMessage);
					return false;
				}
			}
			
			if(selectedRobotFile == null)
			{
				setErrorMessage("Model file must be selected.");
	            return false;
			}
			
			if(super.validatePage() == false) return false;

			setMessage("Create a new contents project.");
			return true;
		}

		private void containerSelectionChanged(Object element)
		{
			if(element instanceof IFile)
			{
				selectedRobotFile = (IFile)element;
				
				IDialogSettings settings = Activator.getDefault().getDialogSettings();
				settings.put("Robot Model", selectedRobotFile.getName());
				Activator.getDefault().saveDialogSettings();
			}
			else
				selectedRobotFile = null;
			
			if(!firstSelection)
				setPageComplete(validatePage());
			firstSelection = false;
		}
		
		public IFile getModelFile()
		{
			return selectedRobotFile;
		}
	}
	
	@Override
	public void addPages()
	{
		super.addPages();

		mainPage = new WizardNewContentsProjectCreationPage();
		mainPage.setTitle("Contents Project");
		mainPage.setDescription("Create a new contents project.");
		this.addPage(mainPage);
	}

	@SuppressWarnings("deprecation")
	private IProject createNewProject()
	{
		if(newProject != null)
			return newProject;

		// get a project handle
		final IProject newProjectHandle = mainPage.getProjectHandle();

		// get a project descriptor
		URI location = null;
		if(!mainPage.useDefaults())
			location = mainPage.getLocationURI();

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);

		// create the new project operation
		IRunnableWithProgress op = new IRunnableWithProgress()
		{
			public void run(IProgressMonitor monitor) throws InvocationTargetException
			{
				CreateProjectOperation op = new CreateProjectOperation(description, ResourceMessages.NewProject_windowTitle);
				try
				{
					op.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
				} catch (ExecutionException e)
				{
					throw new InvocationTargetException(e);
				}
			}
		};

		// run the new project creation operation
		try
		{
			getContainer().run(true, true, op);
		} catch (InterruptedException e)
		{
			return null;
		} catch (InvocationTargetException e)
		{
			Throwable t = e.getTargetException();
			if(t instanceof ExecutionException && t.getCause() instanceof CoreException)
			{
				CoreException cause = (CoreException) t.getCause();
				StatusAdapter status;
				if(cause.getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS)
				{
					status = new StatusAdapter(StatusUtil.newStatus(IStatus.WARNING, NLS.bind(ResourceMessages.NewProject_caseVariantExistsError, newProjectHandle.getName()), cause));
				}
				else
				{
					status = new StatusAdapter(StatusUtil.newStatus(cause.getStatus().getSeverity(), ResourceMessages.NewProject_errorMessage, cause));
				}
				status.setProperty(StatusAdapter.TITLE_PROPERTY, ResourceMessages.NewProject_errorMessage);
				StatusManager.getManager().handle(status, StatusManager.BLOCK);
			}
			else
			{
				StatusAdapter status = new StatusAdapter(new Status(IStatus.WARNING, IDEWorkbenchPlugin.IDE_WORKBENCH, 0, NLS.bind(ResourceMessages.NewProject_internalError, t.getMessage()), t));
				status.setProperty(StatusAdapter.TITLE_PROPERTY, ResourceMessages.NewProject_errorMessage);
				StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);
			}
			return null;
		}

		newProject = newProjectHandle;

		return newProject;
	}

	public IProject getNewProject()
	{
		return newProject;
	}

	protected void initializeDefaultPageImageDescriptor()
	{
		ImageDescriptor desc = Activator.getImageDescriptor("icons/wizban/newprj_wiz.png");
		setDefaultPageImageDescriptor(desc);
	}

	private static void openInNewWindow(IPerspectiveDescriptor desc)
	{
		try
		{
			PlatformUI.getWorkbench().openWorkbenchWindow(desc.getId(), ResourcesPlugin.getWorkspace().getRoot());
		} catch (WorkbenchException e)
		{
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if(window != null)
			{
				ErrorDialog.openError(window.getShell(), WINDOW_PROBLEMS_TITLE, e.getMessage(), e.getStatus());
			}
		}
	}

	public boolean performFinish()
	{
		createNewProject();

		if(newProject == null) return false;
		
		IFile modelFile = mainPage.getModelFile();
		if(modelFile != null)
		{
			try
			{
				IFile newFile = newProject.getFile(modelFile.getName());
				modelFile.copy(newFile.getFullPath(), true, null);
				
				IFolder contentsFolder = newProject.getFolder("contents");
				contentsFolder.create(true, true, null);
				selectAndReveal(contentsFolder);
			} catch (CoreException e)
			{
				e.printStackTrace();
			}
		}
		
		updatePerspective();
		return true;
	}

	private static void replaceCurrentPerspective(IPerspectiveDescriptor persp)
	{
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window == null)
		{
			return;
		}
		IWorkbenchPage page = window.getActivePage();
		if(page == null)
		{
			return;
		}

		// Set the perspective.
		page.setPerspective(persp);
	}

	public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data)
	{
		configElement = cfig;
	}

	protected void updatePerspective()
	{
		updatePerspective(configElement);
	}

	public static void updatePerspective(IConfigurationElement configElement)
	{
		// Do not change perspective if the configuration element is
		// not specified.
		if(configElement == null) return;

		// Retrieve the new project open perspective preference setting
		String perspSetting = PrefUtil.getAPIPreferenceStore().getString(IDE.Preferences.PROJECT_OPEN_NEW_PERSPECTIVE);
		String promptSetting = IDEWorkbenchPlugin.getDefault().getPreferenceStore().getString(IDEInternalPreferences.PROJECT_SWITCH_PERSP_MODE);

		// Return if do not switch perspective setting and are not prompting
		if(!(promptSetting.equals(MessageDialogWithToggle.PROMPT)) && perspSetting.equals(IWorkbenchPreferenceConstants.NO_NEW_PERSPECTIVE))
			return;

		// Read the requested perspective id to be opened.
		String finalPerspId = configElement.getAttribute(FINAL_PERSPECTIVE);
		if(finalPerspId == null) return;

		// Map perspective id to descriptor.
		IPerspectiveRegistry reg = PlatformUI.getWorkbench().getPerspectiveRegistry();

		// leave this code in - the perspective of a given project may map to
		// activities other than those that the wizard itself maps to.
		IPerspectiveDescriptor finalPersp = reg.findPerspectiveWithId(finalPerspId);
		if(finalPersp != null && finalPersp instanceof IPluginContribution)
		{
			IPluginContribution contribution = (IPluginContribution) finalPersp;
			if(contribution.getPluginId() != null)
			{
				IWorkbenchActivitySupport workbenchActivitySupport = PlatformUI.getWorkbench().getActivitySupport();
				IActivityManager activityManager = workbenchActivitySupport.getActivityManager();
				IIdentifier identifier = activityManager.getIdentifier(WorkbenchActivityHelper.createUnifiedId(contribution));
				@SuppressWarnings("unchecked")
				Set<String> idActivities = identifier.getActivityIds();

				if(!idActivities.isEmpty())
				{
					@SuppressWarnings("unchecked")
					Set<String> enabledIds = new HashSet<String>(activityManager.getEnabledActivityIds());

					if(enabledIds.addAll(idActivities))
					{
						workbenchActivitySupport.setEnabledActivityIds(enabledIds);
					}
				}
			}
		}
		else
		{
			IDEWorkbenchPlugin.log("Unable to find persective " + finalPerspId + " in BasicNewProjectResourceWizard.updatePerspective");
			return;
		}

		// gather the preferred perspectives
		// always consider the final perspective (and those derived from it)
		// to be preferred
		List<String> preferredPerspIds = new ArrayList<String>();
		addPerspectiveAndDescendants(preferredPerspIds, finalPerspId);
		String preferred = configElement.getAttribute(PREFERRED_PERSPECTIVES);
		if(preferred != null)
		{
			StringTokenizer tok = new StringTokenizer(preferred, " \t\n\r\f,");
			while(tok.hasMoreTokens())
			{
				addPerspectiveAndDescendants(preferredPerspIds, tok.nextToken());
			}
		}

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(window != null)
		{
			IWorkbenchPage page = window.getActivePage();
			if(page != null)
			{
				IPerspectiveDescriptor currentPersp = page.getPerspective();

				// don't switch if the current perspective is a preferred
				// perspective
				if(currentPersp != null && preferredPerspIds.contains(currentPersp.getId()))
					return;
			}

			// prompt the user to switch
			if(!confirmPerspectiveSwitch(window, finalPersp))
				return;
		}

		int workbenchPerspectiveSetting = WorkbenchPlugin.getDefault().getPreferenceStore().getInt(IPreferenceConstants.OPEN_PERSP_MODE);

		// open perspective in new window setting
		if(workbenchPerspectiveSetting == IPreferenceConstants.OPM_NEW_WINDOW)
		{
			openInNewWindow(finalPersp);
			return;
		}

		// replace active perspective setting otherwise
		replaceCurrentPerspective(finalPersp);
	}

	private static void addPerspectiveAndDescendants(List<String> perspectiveIds, String id)
	{
		IPerspectiveRegistry registry = PlatformUI.getWorkbench().getPerspectiveRegistry();
		IPerspectiveDescriptor[] perspectives = registry.getPerspectives();
		for(int i = 0; i < perspectives.length; i++)
		{
			PerspectiveDescriptor descriptor = ((PerspectiveDescriptor) perspectives[i]);
			if(descriptor.getOriginalId().equals(id))
				perspectiveIds.add(descriptor.getId());
		}
	}

	private static boolean confirmPerspectiveSwitch(IWorkbenchWindow window, IPerspectiveDescriptor finalPersp)
	{
		IPreferenceStore store = IDEWorkbenchPlugin.getDefault().getPreferenceStore();
		String pspm = store.getString(IDEInternalPreferences.PROJECT_SWITCH_PERSP_MODE);
		if(!IDEInternalPreferences.PSPM_PROMPT.equals(pspm))
		{
			// Return whether or not we should always switch
			return IDEInternalPreferences.PSPM_ALWAYS.equals(pspm);
		}
		String desc = finalPersp.getDescription();
		String message;
		if(desc == null || desc.length() == 0)
			message = NLS.bind(ResourceMessages.NewProject_perspSwitchMessage, finalPersp.getLabel());
		else
			message = NLS.bind(ResourceMessages.NewProject_perspSwitchMessageWithDesc, new String[] { finalPersp.getLabel(), desc });

		MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(window.getShell(),
												ResourceMessages.NewProject_perspSwitchTitle, message,
												null /* use the default message for the toggle */,
												false /* toggle is initially unchecked */, store,
												IDEInternalPreferences.PROJECT_SWITCH_PERSP_MODE);
		int result = dialog.getReturnCode();

		// If we are not going to prompt anymore propogate the choice.
		if(dialog.getToggleState())
		{
			String preferenceValue;
			if(result == IDialogConstants.YES_ID)
			{
				// Doesn't matter if it is replace or new window
				// as we are going to use the open perspective setting
				preferenceValue = IWorkbenchPreferenceConstants.OPEN_PERSPECTIVE_REPLACE;
			}
			else
			{
				preferenceValue = IWorkbenchPreferenceConstants.NO_NEW_PERSPECTIVE;
			}

			// update PROJECT_OPEN_NEW_PERSPECTIVE to correspond
			PrefUtil.getAPIPreferenceStore().setValue(IDE.Preferences.PROJECT_OPEN_NEW_PERSPECTIVE, preferenceValue);
		}
		return result == IDialogConstants.YES_ID;
	}
}
