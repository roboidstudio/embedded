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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.MultiPageSelectionProvider;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotFactory;
import org.roboid.studio.robotcomposer.provider.RobotAdapterFactoryContentProvider;
import org.roboid.studio.robotcomposer.provider.RobotItemProviderAdapterFactory;

/**
 * @author Kwang-Hyun Park
 */
public class RobotComposer extends MultiPageEditorPart implements IEditingDomainProvider, IMenuListener, IViewerProvider, IGotoMarker
{
	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;
	protected PropertySheetPage propertySheetPage;
	protected Viewer currentViewer;
	protected MultiPageSelectionProvider selectionProvider;
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();
	protected IPartListener partListener = new IPartListener()
	{
		public void partActivated(IWorkbenchPart part)
		{
			if(part instanceof PropertySheet)
			{
				if(((PropertySheet)part).getCurrentPage() == propertySheetPage)
				{
					getActionBarContributor().setActiveEditor(RobotComposer.this);
					handleActivate();
				}
			}
			else if(part == RobotComposer.this)
			{
				handleActivate();
			}
		}
		public void partBroughtToTop(IWorkbenchPart p)
		{
		}
		public void partClosed(IWorkbenchPart p)
		{
		}
		public void partDeactivated(IWorkbenchPart p)
		{
		}
		public void partOpened(IWorkbenchPart p)
		{
		}
	};

	protected Collection<Resource> removedResources = new ArrayList<Resource>();
	protected Collection<Resource> changedResources = new ArrayList<Resource>();
	protected Collection<Resource> savedResources = new ArrayList<Resource>();
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	protected boolean updateProblemIndication = true;
	protected EContentAdapter problemIndicationAdapter = new EContentAdapter()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if(notification.getNotifier() instanceof Resource)
			{
				switch(notification.getFeatureID(Resource.class))
				{
					case Resource.RESOURCE__IS_LOADED:
					case Resource.RESOURCE__ERRORS:
					case Resource.RESOURCE__WARNINGS:
					{
						Resource resource = (Resource)notification.getNotifier();
						Diagnostic diagnostic = analyzeResourceProblems(resource, null);
						if(diagnostic.getSeverity() != Diagnostic.OK)
							resourceToDiagnosticMap.put(resource, diagnostic);
						else
							resourceToDiagnosticMap.remove(resource);

						if(updateProblemIndication)
						{
							getSite().getShell().getDisplay().asyncExec(new Runnable()
							{
								public void run()
								{
									updateProblemIndication();
								}
							});
						}
						break;
					}
				}
			}
			else
				super.notifyChanged(notification);
		}

		@Override
		protected void setTarget(Resource target)
		{
			basicSetTarget(target);
		}

		@Override
		protected void unsetTarget(Resource target)
		{
			basicUnsetTarget(target);
		}
	};

	protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener()
	{
		public void resourceChanged(IResourceChangeEvent event)
		{
			IResourceDelta delta = event.getDelta();
			try
			{
				class ResourceDeltaVisitor implements IResourceDeltaVisitor
				{
					protected ResourceSet resourceSet = editingDomain.getResourceSet();
					protected Collection<Resource> changedResources = new ArrayList<Resource>();
					protected Collection<Resource> removedResources = new ArrayList<Resource>();

					public boolean visit(IResourceDelta delta)
					{
						if(delta.getResource().getType() == IResource.FILE)
						{
							if(delta.getKind() == IResourceDelta.REMOVED ||
							   delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS)
							{
								Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
								if(resource != null)
								{
									if(delta.getKind() == IResourceDelta.REMOVED)
										removedResources.add(resource);
									else if(!savedResources.remove(resource))
										changedResources.add(resource);
								}
							}
						}
						return true;
					}

					public Collection<Resource> getChangedResources()
					{
						return changedResources;
					}

					public Collection<Resource> getRemovedResources()
					{
						return removedResources;
					}
				}

				final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);

				if(!visitor.getRemovedResources().isEmpty())
				{
					getSite().getShell().getDisplay().asyncExec(new Runnable()
					{
						public void run()
						{
							removedResources.addAll(visitor.getRemovedResources());
							if(!isDirty())
								getSite().getPage().closeEditor(RobotComposer.this, false);
						}
					});
				}

				if(!visitor.getChangedResources().isEmpty())
				{
					getSite().getShell().getDisplay().asyncExec(new Runnable()
					{
						public void run()
						{
							changedResources.addAll(visitor.getChangedResources());
							if(getSite().getPage().getActiveEditor() == RobotComposer.this)
								handleActivate();
						}
					});
				}
			}
			catch (CoreException exception)
			{
				RobotComposerPlugin.INSTANCE.log(exception);
			}
		}
	};

	protected void handleActivate()
	{
		if(editingDomain.getResourceToReadOnlyMap() != null)
		{
			editingDomain.getResourceToReadOnlyMap().clear();
			selectionProvider.setSelection(selectionProvider.getSelection());
		}

		if(!removedResources.isEmpty())
		{
			if(handleDirtyConflict())
				getSite().getPage().closeEditor(RobotComposer.this, false);
			else
			{
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		}
		else if(!changedResources.isEmpty())
		{
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	}

	protected void handleChangedResources()
	{
		if(!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict()))
		{
			if(isDirty())
				changedResources.addAll(editingDomain.getResourceSet().getResources());
			editingDomain.getCommandStack().flush();

			updateProblemIndication = false;
			for(Resource resource : changedResources)
			{
				if(resource.isLoaded())
				{
					resource.unload();
					try
					{
						resource.load(Collections.EMPTY_MAP);
					}
					catch (IOException exception)
					{
						if(!resourceToDiagnosticMap.containsKey(resource))
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
					}
				}
			}

			updateProblemIndication = true;
			updateProblemIndication();
		}
	}
  
	protected void updateProblemIndication()
	{
		if(updateProblemIndication)
		{
			BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "org.roboid.studio.robotcomposer", 0, null, new Object [] { editingDomain.getResourceSet() });
			for(Diagnostic childDiagnostic : resourceToDiagnosticMap.values())
			{
				if(childDiagnostic.getSeverity() != Diagnostic.OK)
					diagnostic.add(childDiagnostic);
			}

			int lastEditorPage = getPageCount() - 1;
			if(lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart)
			{
				((ProblemEditorPart)getEditor(lastEditorPage)).setDiagnostic(diagnostic);
				if(diagnostic.getSeverity() != Diagnostic.OK)
					setActivePage(lastEditorPage);
			}
			else if(diagnostic.getSeverity() != Diagnostic.OK)
			{
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(markerHelper);
				try
				{
					addPage(++lastEditorPage, problemEditorPart, getEditorInput());
					setPageText(lastEditorPage, problemEditorPart.getPartName());
					setActivePage(lastEditorPage);
					showTabs();
				}
				catch (PartInitException exception)
				{
					RobotComposerPlugin.INSTANCE.log(exception);
				}
			}

			if(markerHelper.hasMarkers(editingDomain.getResourceSet()))
			{
				markerHelper.deleteMarkers(editingDomain.getResourceSet());
				if(diagnostic.getSeverity() != Diagnostic.OK)
				{
					try
					{
						markerHelper.createMarkers(diagnostic);
					}
					catch (CoreException exception)
					{
						RobotComposerPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
	}

	protected boolean handleDirtyConflict()
	{
		return MessageDialog.openQuestion (getSite().getShell(), getString("_UI_FileConflict_label"), getString("_WARN_FileConflict"));
	}

	public RobotComposer()
	{
		super();
		initializeEditingDomain();
		selectionProvider = new MultiPageSelectionProvider(this);
		selectionProvider.addSelectionChangedListener(new ISelectionChangedListener()
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				setStatusLineManager(event.getSelection());
			}
		});
	}

	protected void initializeEditingDomain()
	{
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new RobotItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		commandStack.addCommandStackListener(new CommandStackListener()
		{
			public void commandStackChanged(final EventObject event)
			{
				getContainer().getDisplay().asyncExec(new Runnable()
				{
					public void run()
					{
						firePropertyChange(IEditorPart.PROP_DIRTY);

						Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
						if(mostRecentCommand != null)
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						if(propertySheetPage != null && !propertySheetPage.getControl().isDisposed())
							propertySheetPage.refresh();
					}
				});
			}
		});

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	@Override
	protected void firePropertyChange(int action)
	{
		super.firePropertyChange(action);
	}

	public void setSelectionToViewer(Collection<?> collection)
	{
		final Collection<?> theSelection = collection;
		if(theSelection != null && !theSelection.isEmpty())
		{
			Runnable runnable = new Runnable()
			{
				public void run()
				{
					if(currentViewer != null)
						currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
				}
			};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	@Override
	public EditingDomain getEditingDomain()
	{
		return editingDomain;
	}

	@Override
	public Viewer getViewer()
	{
		return currentViewer;
	}

	public void createModel()
	{
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Exception exception = null;
		Resource resource = null;
		try
		{
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			createModel(resource);
		}
		catch (Exception e)
		{
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if(diagnostic.getSeverity() != Diagnostic.OK)
			resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
		editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
	}
	
	private void createModel(Resource resource)
	{
		EList<EObject> contents = resource.getContents();
		
		Robot robot = null;
		if(!contents.isEmpty() && (contents.get(0) instanceof Robot))
			robot = (Robot)contents.get(0);
		else
			robot = RobotFactory.eINSTANCE.createRobot();
		
		RobotDiagram diagram = null;
		if(contents.size() > 1 && (contents.get(1) instanceof RobotDiagram))
			diagram = (RobotDiagram)contents.get(1);
		else
			diagram = RobotComposerFactory.eINSTANCE.createRobotDiagram();
		diagram.setRobot(robot);
		
		contents.clear();
		contents.add((EObject)robot);
		contents.add((EObject)diagram);

		diagram.refreshRoboidBlocks();
		diagram.connectAll();
	}
	
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) 
	{
		if(!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty())
		{
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.roboid.studio.robotcomposer", 0, getString("_UI_CreateModelError_message", resource.getURI()), new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if(exception != null)
			return new BasicDiagnostic(Diagnostic.ERROR, "org.roboid.studio.robotcomposer", 0, getString("_UI_CreateModelError_message", resource.getURI()), new Object[] { exception });
		else
			return Diagnostic.OK_INSTANCE;
	}

	@Override
	public void createPages()
	{
		createModel();

		if(!getEditingDomain().getResourceSet().getResources().isEmpty())
		{
			createAndAddGraphicalPage();
			createAndAddTreePage();
			
			getSite().getShell().getDisplay().asyncExec(new Runnable()
			{
				public void run()
				{
					setActivePage(0);
				}
			});
		}

		getContainer().addControlListener(new ControlAdapter()
		{
			boolean guard = false;
			@Override
			public void controlResized(ControlEvent event)
			{
				if(!guard)
				{
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

		getSite().getShell().getDisplay().asyncExec(new Runnable()
		{
			public void run()
			{
				updateProblemIndication();
			}
		});
	}
	
	private void createAndAddGraphicalPage()
	{
		try
		{
			RobotGraphicalEditor graphicEditor = new RobotGraphicalEditor(this);
			int pageIndex = addPage(graphicEditor, getEditorInput());
			setPageText(pageIndex, getString("_UI_DiagramPage_label"));
		} catch (PartInitException e)
		{
			e.printStackTrace();
		}
	}
	
	private void createAndAddTreePage()
	{
		try
		{
			RobotTreeEditor editor = new RobotTreeEditor(this);
			int pageIndex = addPage(editor, getEditorInput());
			setPageText(pageIndex, getString("_UI_TreePage_label"));
			editor.setInput(getEditingDomain().getResourceSet());
		} catch (PartInitException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void hideTabs()
	{
		if(getPageCount() <= 1)
		{
			setPageText(0, "");
			if(getContainer() instanceof CTabFolder)
			{
				((CTabFolder)getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
			}
		}
	}

	protected void showTabs()
	{
		if(getPageCount() > 1)
		{
			setPageText(0, getString("_UI_DiagramPage_label"));
			if(getContainer() instanceof CTabFolder)
			{
				((CTabFolder)getContainer()).setTabHeight(SWT.DEFAULT);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y - 6);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class key)
	{
		if(key.equals(IPropertySheetPage.class))
			return getPropertySheetPage();
		else if(key.equals(IGotoMarker.class))
			return this;
		else
			return super.getAdapter(key);
	}

	public IPropertySheetPage getPropertySheetPage()
	{
		if(propertySheetPage == null)
		{
			propertySheetPage = new ExtendedPropertySheetPage(editingDomain)
			{
				@Override
				public void setSelectionToViewer(List<?> selection)
				{
					RobotComposer.this.setSelectionToViewer(selection);
					RobotComposer.this.setFocus();
				}

				@Override
				public void setActionBars(IActionBars actionBars)
				{
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			};
			propertySheetPage.setPropertySourceProvider(new RobotAdapterFactoryContentProvider(adapterFactory));
		}
		return propertySheetPage;
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor)
	{
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation()
		{
			@Override
			public void execute(IProgressMonitor monitor)
			{
				boolean first = true;
				for(Resource resource : editingDomain.getResourceSet().getResources())
				{
					if((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource))
					{
						try
						{
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if(resource.getTimeStamp() != timeStamp)
								savedResources.add(resource);
						}
						catch (Exception exception)
						{
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};

		updateProblemIndication = false;
		try
		{
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception)
		{
			RobotComposerPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}

	protected boolean isPersisted(Resource resource)
	{
		boolean result = false;
		try
		{
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if(stream != null)
			{
				result = true;
				stream.close();
			}
		}
		catch (IOException e)
		{
		}
		return result;
	}

	@Override
	public boolean isSaveAsAllowed()
	{
		return true;
	}

	@Override
	public void doSaveAs()
	{
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.setOriginalFile(((IFileEditorInput)getEditorInput()).getFile());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if(path != null)
		{
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if(file != null)
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
		}
	}

	protected void doSaveAs(URI uri, IEditorInput editorInput)
	{
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null ?
				getActionBars().getStatusLineManager().getProgressMonitor() :
				new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public void gotoMarker(IMarker marker)
	{
		try
		{
			if(marker.getType().equals(EValidator.MARKER))
			{
				String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if(uriAttribute != null)
				{
					URI uri = URI.createURI(uriAttribute);
					EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
					if(eObject != null)
					  setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
				}
			}
		}
		catch (CoreException exception)
		{
			RobotComposerPlugin.INSTANCE.log(exception);
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput editorInput)
	{
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		site.setSelectionProvider(selectionProvider);
		site.getPage().addPartListener(partListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	public void setStatusLineManager(ISelection selection)
	{
		IStatusLineManager statusLineManager = getActionBars().getStatusLineManager();

		if(statusLineManager != null)
		{
			if(selection instanceof IStructuredSelection)
			{
				Collection<?> collection = ((IStructuredSelection)selection).toList();
				switch (collection.size())
				{
					case 0:
					{
						statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
						break;
					}
					case 1:
					{
						String text = null;
						Object obj = collection.iterator().next();
						if(obj instanceof EditPart)
						{
							obj = ((EditPart)obj).getModel();
							if(obj instanceof RoboidBlock)
								text = new AdapterFactoryItemDelegator(adapterFactory).getText(((RoboidBlock)obj).getRoboid());
							else if(obj instanceof DeviceElement)
								text = new AdapterFactoryItemDelegator(adapterFactory).getText(((DeviceElement)obj).getDevice());
							else if(obj instanceof RobotDiagram)
								text = getString("_UI_RobotDiagram_type");
						}
						if(text == null)
							text = new AdapterFactoryItemDelegator(adapterFactory).getText(obj);
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
						break;
					}
					default:
					{
						statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
						break;
					}
				}
			}
			else
				statusLineManager.setMessage("");
		}
	}

	private static String getString(String key)
	{
		return RobotComposerPlugin.INSTANCE.getString(key);
	}

	private static String getString(String key, Object s1)
	{
		return RobotComposerPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	public void menuAboutToShow(IMenuManager menuManager)
	{
		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	public Contributor getActionBarContributor()
	{
		return (Contributor)getEditorSite().getActionBarContributor();
	}

	public IActionBars getActionBars()
	{
		return getActionBarContributor().getActionBars();
	}

	public AdapterFactory getAdapterFactory()
	{
		return adapterFactory;
	}

	@Override
	public void dispose()
	{
		updateProblemIndication = false;

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if(getActionBarContributor().getActiveEditor() == this)
			getActionBarContributor().setActiveEditor(null);
		if(propertySheetPage != null)
			propertySheetPage.dispose();

		super.dispose();
	}
}
