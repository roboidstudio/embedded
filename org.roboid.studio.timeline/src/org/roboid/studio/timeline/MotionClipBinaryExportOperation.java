/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Kwang-Hyun Park - modification for motion clip binary files
 *******************************************************************************/
package org.roboid.studio.timeline;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;

/**
 * @author IBM Corporation
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class MotionClipBinaryExportOperation implements IRunnableWithProgress
{
	private IPath path;
	private IProgressMonitor monitor;
	private MotionClipBinaryExporter exporter = new MotionClipBinaryExporter();
	@SuppressWarnings("rawtypes")
	private List resourcesToExport;
	private IOverwriteQuery overwriteCallback;
	private IResource resource;
	@SuppressWarnings("rawtypes")
	private List errorTable = new ArrayList(1);
	private static final int OVERWRITE_NOT_SET = 0;
	private static final int OVERWRITE_NONE = 1;
	private static final int OVERWRITE_ALL = 2;
	private int overwriteState = OVERWRITE_NOT_SET;
	private boolean createLeadupStructure = true;
	private boolean createContainerDirectories = true;

	public MotionClipBinaryExportOperation(IResource res, String destinationPath, IOverwriteQuery overwriteImplementor)
	{
		super();
		resource = res;
		path = new Path(destinationPath);
		overwriteCallback = overwriteImplementor;
	}

	@SuppressWarnings("rawtypes")
	public MotionClipBinaryExportOperation(IResource res, List resources, String destinationPath, IOverwriteQuery overwriteImplementor)
	{
		this(res, destinationPath, overwriteImplementor);
		resourcesToExport = resources;
	}

	protected int countChildrenOf(IResource parentResource) throws CoreException
	{
		if(parentResource.getType() == IResource.FILE)
		{
			return 1;
		}

		int count = 0;
		if(parentResource.isAccessible())
		{
			IResource[] children = ((IContainer) parentResource).members();
			for(int i = 0; i < children.length; i++)
			{
				count += countChildrenOf(children[i]);
			}
		}
		return count;
	}

	protected int countSelectedResources() throws CoreException
	{
		int result = 0;
		@SuppressWarnings("rawtypes")
		Iterator resources = resourcesToExport.iterator();

		while(resources.hasNext())
		{
			result += countChildrenOf((IResource) resources.next());
		}
		return result;
	}

	protected void createLeadupDirectoriesFor(IResource childResource)
	{
		IPath resourcePath = childResource.getFullPath().removeLastSegments(1);

		for(int i = 0; i < resourcePath.segmentCount(); i++)
		{
			path = path.append(resourcePath.segment(i));
			exporter.createFolder(path);
		}
	}

	@SuppressWarnings("unchecked")
	protected void exportAllResources() throws InterruptedException
	{
		if(resource.getType() == IResource.FILE)
		{
			exportFile((IFile) resource, path);
		}
		else
		{
			try
			{
				exportChildren(((IContainer) resource).members(), path);
			} catch (CoreException e)
			{
				errorTable.add(e.getStatus());
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void exportChildren(IResource[] children, IPath currentPath) throws InterruptedException
	{
		for(int i = 0; i < children.length; i++)
		{
			IResource child = children[i];
			if(!child.isAccessible())
				continue;

			if(child.getType() == IResource.FILE)
				exportFile((IFile) child, currentPath);
			else
			{
				IPath destination = currentPath.append(child.getName());
				exporter.createFolder(destination);
				try
				{
					exportChildren(((IContainer) child).members(), destination);
				} catch (CoreException e)
				{
					errorTable.add(e.getStatus());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void exportFile(IFile file, IPath location) throws InterruptedException
	{
		String fileName = file.getName();
		int dot = fileName.lastIndexOf(".");
		fileName = fileName.substring(0, dot) + ".mcb";
		IPath fullPath = location.append(fileName);
		monitor.subTask(file.getFullPath().toString());
		String properPathString = fullPath.toOSString();
		File targetFile = new File(properPathString);

		if(targetFile.exists())
		{
			if(!targetFile.canWrite())
			{
				errorTable.add(new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, 0, NLS.bind(DataTransferMessages.DataTransfer_cannotOverwrite, targetFile.getAbsolutePath()), null));
				monitor.worked(1);
				return;
			}

			if(overwriteState == OVERWRITE_NONE)
				return;

			if(overwriteState != OVERWRITE_ALL)
			{
				String overwriteAnswer = overwriteCallback.queryOverwrite(properPathString);

				if(overwriteAnswer.equals(IOverwriteQuery.CANCEL))
					throw new InterruptedException();

				if(overwriteAnswer.equals(IOverwriteQuery.NO))
				{
					monitor.worked(1);
					return;
				}

				if(overwriteAnswer.equals(IOverwriteQuery.NO_ALL))
				{
					monitor.worked(1);
					overwriteState = OVERWRITE_NONE;
					return;
				}

				if(overwriteAnswer.equals(IOverwriteQuery.ALL))
					overwriteState = OVERWRITE_ALL;
			}
		}

		try
		{
			exporter.write(file, fullPath);
		} catch (IOException e)
		{
			errorTable.add(new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, 0, NLS.bind(DataTransferMessages.DataTransfer_errorExporting, fullPath, e.getMessage()), e));
		} catch (CoreException e)
		{
			errorTable.add(new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, 0, NLS.bind(DataTransferMessages.DataTransfer_errorExporting, fullPath, e.getMessage()), e));
		}

		monitor.worked(1);
		ModalContext.checkCanceled(monitor);
	}

	@SuppressWarnings("unchecked")
	protected void exportSpecifiedResources() throws InterruptedException
	{
		@SuppressWarnings("rawtypes")
		Iterator resources = resourcesToExport.iterator();
		IPath initPath = (IPath) path.clone();

		while(resources.hasNext())
		{
			IResource currentResource = (IResource)resources.next();
			if(!currentResource.isAccessible())
				continue;

			path = initPath;

			if(resource == null)
			{
				if(createLeadupStructure)
					createLeadupDirectoriesFor(currentResource);
			}
			else
			{
				IPath containersToCreate = currentResource.getFullPath().removeFirstSegments(resource.getFullPath().segmentCount()).removeLastSegments(1);

				for(int i = 0; i < containersToCreate.segmentCount(); i++)
				{
					path = path.append(containersToCreate.segment(i));
					exporter.createFolder(path);
				}
			}

			if(currentResource.getType() == IResource.FILE)
				exportFile((IFile) currentResource, path);
			else
			{
				if(createContainerDirectories)
				{
					path = path.append(currentResource.getName());
					exporter.createFolder(path);
				}

				try
				{
					exportChildren(((IContainer) currentResource).members(), path);
				} catch (CoreException e)
				{
					errorTable.add(e.getStatus());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public IStatus getStatus()
	{
		IStatus[] errors = new IStatus[errorTable.size()];
		errorTable.toArray(errors);
		return new MultiStatus(PlatformUI.PLUGIN_ID, IStatus.OK, errors, DataTransferMessages.FileSystemExportOperation_problemsExporting, null);
	}

	@SuppressWarnings("rawtypes")
	protected boolean isDescendent(List resources, IResource child)
	{
		if(child.getType() == IResource.PROJECT)
			return false;

		IResource parent = child.getParent();
		if(resources.contains(parent))
			return true;

		return isDescendent(resources, parent);
	}

	@SuppressWarnings("unchecked")
	public void run(IProgressMonitor progressMonitor) throws InterruptedException
	{
		this.monitor = progressMonitor;

		if(resource != null)
		{
			if(createLeadupStructure)
				createLeadupDirectoriesFor(resource);

			if(createContainerDirectories && resource.getType() != IResource.FILE)
			{
				path = path.append(resource.getName());
				exporter.createFolder(path);
			}
		}

		try
		{
			int totalWork = IProgressMonitor.UNKNOWN;
			try
			{
				if(resourcesToExport == null)
					totalWork = countChildrenOf(resource);
				else
					totalWork = countSelectedResources();
			} catch (CoreException e)
			{
				errorTable.add(e.getStatus());
			}
			monitor.beginTask(DataTransferMessages.DataTransfer_exportingTitle, totalWork);
			if(resourcesToExport == null)
				exportAllResources();
			else
				exportSpecifiedResources();
		}
		finally
		{
			monitor.done();
		}
	}

	public void setCreateContainerDirectories(boolean value)
	{
		createContainerDirectories = value;
	}

	public void setCreateLeadupStructure(boolean value)
	{
		createLeadupStructure = value;
	}

	public void setOverwriteFiles(boolean value)
	{
		if(value)
			overwriteState = OVERWRITE_ALL;
	}
}
