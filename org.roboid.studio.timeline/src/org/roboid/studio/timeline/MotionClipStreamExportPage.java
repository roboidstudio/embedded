/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Kwang-Hyun Park - modification for motion clip stream files
 *******************************************************************************/
package org.roboid.studio.timeline;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;
import org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages;

/**
 * @author IBM Corporation
 * @author Kwang-Hyun Park
 */
@SuppressWarnings("restriction")
public class MotionClipStreamExportPage extends WizardExportResourcesPage implements Listener
{
	private Combo destinationNameField;
	private Button destinationBrowseButton;
	protected Button overwriteExistingFilesCheckbox;
	protected Button createDirectoryStructureButton;
	protected Button createSelectionOnlyButton;
	private static final String STORE_DESTINATION_NAMES_ID = "MotionClipStreamExportPage.STORE_DESTINATION_NAMES_ID"; //$NON-NLS-1$
	private static final String STORE_OVERWRITE_EXISTING_FILES_ID = "MotionClipStreamExportPage.STORE_OVERWRITE_EXISTING_FILES_ID"; //$NON-NLS-1$
	private static final String STORE_CREATE_STRUCTURE_ID = "MotionClipStreamExportPage.STORE_CREATE_STRUCTURE_ID"; //$NON-NLS-1$
	private static final String SELECT_DESTINATION_MESSAGE = DataTransferMessages.FileExport_selectDestinationMessage;
	private static final String SELECT_DESTINATION_TITLE = DataTransferMessages.FileExport_selectDestinationTitle;

	protected MotionClipStreamExportPage(String name, IStructuredSelection selection)
	{
		super(name, selection);
	}

	protected void addDestinationItem(String value)
	{
		destinationNameField.add(value);
	}

	public void createControl(Composite parent)
	{
		super.createControl(parent);
		giveFocusToDestination();
	}

	protected void createDestinationGroup(Composite parent)
	{
		Font font = parent.getFont();
		Composite destinationSelectionGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		destinationSelectionGroup.setLayout(layout);
		destinationSelectionGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL));
		destinationSelectionGroup.setFont(font);

		Label destinationLabel = new Label(destinationSelectionGroup, SWT.NONE);
		destinationLabel.setText(getDestinationLabel());
		destinationLabel.setFont(font);

		destinationNameField = new Combo(destinationSelectionGroup, SWT.SINGLE | SWT.BORDER);
		destinationNameField.addListener(SWT.Modify, this);
		destinationNameField.addListener(SWT.Selection, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		destinationNameField.setLayoutData(data);
		destinationNameField.setFont(font);

		destinationBrowseButton = new Button(destinationSelectionGroup, SWT.PUSH);
		destinationBrowseButton.setText(DataTransferMessages.DataTransfer_browse);
		destinationBrowseButton.addListener(SWT.Selection, this);
		destinationBrowseButton.setFont(font);
		setButtonLayoutData(destinationBrowseButton);

		new Label(parent, SWT.NONE); // vertical spacer
	}

	protected void createOptionsGroupButtons(Group optionsGroup)
	{
		Font font = optionsGroup.getFont();
		createOverwriteExisting(optionsGroup, font);
		createDirectoryStructureOptions(optionsGroup, font);
	}

	protected void createDirectoryStructureOptions(Composite optionsGroup, Font font)
	{
		createDirectoryStructureButton = new Button(optionsGroup, SWT.RADIO | SWT.LEFT);
		createDirectoryStructureButton.setText(DataTransferMessages.FileExport_createDirectoryStructure);
		createDirectoryStructureButton.setSelection(false);
		createDirectoryStructureButton.setFont(font);

		createSelectionOnlyButton = new Button(optionsGroup, SWT.RADIO | SWT.LEFT);
		createSelectionOnlyButton.setText(DataTransferMessages.FileExport_createSelectedDirectories);
		createSelectionOnlyButton.setSelection(true);
		createSelectionOnlyButton.setFont(font);
	}

	protected void createOverwriteExisting(Group optionsGroup, Font font)
	{
		overwriteExistingFilesCheckbox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		overwriteExistingFilesCheckbox.setText(DataTransferMessages.ExportFile_overwriteExisting);
		overwriteExistingFilesCheckbox.setFont(font);
	}

	protected boolean ensureDirectoryExists(File directory)
	{
		if(!directory.exists())
		{
			if(!queryYesNoQuestion(DataTransferMessages.DataTransfer_createTargetDirectory))
			{
				return false;
			}

			if(!directory.mkdirs())
			{
				displayErrorDialog(DataTransferMessages.DataTransfer_directoryCreationError);
				giveFocusToDestination();
				return false;
			}
		}
		return true;
	}

	protected boolean ensureTargetIsValid(File targetDirectory)
	{
		if(targetDirectory.exists() && !targetDirectory.isDirectory())
		{
			displayErrorDialog(DataTransferMessages.FileExport_directoryExists);
			giveFocusToDestination();
			return false;
		}
		return ensureDirectoryExists(targetDirectory);
	}

	protected boolean executeExportOperation(MotionClipStreamExportOperation op)
	{
		op.setCreateLeadupStructure(createDirectoryStructureButton.getSelection());
		op.setOverwriteFiles(overwriteExistingFilesCheckbox.getSelection());

		try
		{
			getContainer().run(true, true, op);
		} catch (InterruptedException e)
		{
			return false;
		} catch (InvocationTargetException e)
		{
			displayErrorDialog(e.getTargetException());
			return false;
		}

		IStatus status = op.getStatus();
		if(!status.isOK())
		{
			ErrorDialog.openError(getContainer().getShell(), DataTransferMessages.DataTransfer_exportProblems, null, status);
			return false;
		}
		return true;
	}

	public boolean finish()
	{
		@SuppressWarnings("rawtypes")
		List resourcesToExport = getWhiteCheckedResources();
		if(!ensureTargetIsValid(new File(getDestinationValue())))
		{
			return false;
		}

		saveDirtyEditors();
		saveWidgetValues();

		return executeExportOperation(new MotionClipStreamExportOperation(null, resourcesToExport, getDestinationValue(), this));
	}

	protected String getDestinationLabel()
	{
		return DataTransferMessages.FileExport_toDirectory;
	}

	protected String getDestinationValue()
	{
		return destinationNameField.getText().trim();
	}

	protected void giveFocusToDestination()
	{
		destinationNameField.setFocus();
	}

	protected void handleDestinationBrowseButtonPressed()
	{
		DirectoryDialog dialog = new DirectoryDialog(getContainer().getShell(), SWT.SAVE | SWT.SHEET);
		dialog.setMessage(SELECT_DESTINATION_MESSAGE);
		dialog.setText(SELECT_DESTINATION_TITLE);
		dialog.setFilterPath(getDestinationValue());
		String selectedDirectoryName = dialog.open();

		if(selectedDirectoryName != null)
		{
			setErrorMessage(null);
			setDestinationValue(selectedDirectoryName);
		}
	}

	public void handleEvent(Event e)
	{
		Widget source = e.widget;

		if(source == destinationBrowseButton)
		{
			handleDestinationBrowseButtonPressed();
		}

		updatePageCompletion();
	}

	protected void internalSaveWidgetValues()
	{
		IDialogSettings settings = getDialogSettings();
		if(settings != null)
		{
			String[] directoryNames = settings.getArray(STORE_DESTINATION_NAMES_ID);
			if(directoryNames == null)
			{
				directoryNames = new String[0];
			}

			directoryNames = addToHistory(directoryNames, getDestinationValue());
			settings.put(STORE_DESTINATION_NAMES_ID, directoryNames);

			settings.put(STORE_OVERWRITE_EXISTING_FILES_ID, overwriteExistingFilesCheckbox.getSelection());
			settings.put(STORE_CREATE_STRUCTURE_ID, createDirectoryStructureButton.getSelection());
		}
	}

	protected void restoreWidgetValues()
	{
		IDialogSettings settings = getDialogSettings();
		if(settings != null)
		{
			String[] directoryNames = settings.getArray(STORE_DESTINATION_NAMES_ID);
			if(directoryNames == null)
			{
				return; // ie.- no settings stored
			}

			setDestinationValue(directoryNames[0]);
			for(int i = 0; i < directoryNames.length; i++)
			{
				addDestinationItem(directoryNames[i]);
			}

			overwriteExistingFilesCheckbox.setSelection(settings.getBoolean(STORE_OVERWRITE_EXISTING_FILES_ID));

			boolean createDirectories = settings.getBoolean(STORE_CREATE_STRUCTURE_ID);
			createDirectoryStructureButton.setSelection(createDirectories);
			createSelectionOnlyButton.setSelection(!createDirectories);
		}
	}

	protected void setDestinationValue(String value)
	{
		destinationNameField.setText(value);
	}

	protected boolean validateDestinationGroup()
	{
		String destinationValue = getDestinationValue();
		if(destinationValue.length() == 0)
		{
			setMessage(destinationEmptyMessage());
			return false;
		}

		String conflictingContainer = getConflictingContainerNameFor(destinationValue);
		if(conflictingContainer == null)
		{
			String threatenedContainer = getOverlappingProjectName(destinationValue);
			if(threatenedContainer == null)
				setMessage(null);
			else
				setMessage(NLS.bind(DataTransferMessages.FileExport_damageWarning, threatenedContainer), WARNING);
		}
		else
		{
			setErrorMessage(NLS.bind(DataTransferMessages.FileExport_conflictingContainer, conflictingContainer));
			giveFocusToDestination();
			return false;
		}
		return true;
	}

	protected boolean validateSourceGroup()
	{
		boolean isValid = true;
		@SuppressWarnings("rawtypes")
		List resourcesToExport = getWhiteCheckedResources();
		if(resourcesToExport.size() == 0)
		{
			setErrorMessage(DataTransferMessages.FileExport_noneSelected);
			isValid =  false;
		}
		else
		{
			setErrorMessage(null);
		}
		return super.validateSourceGroup() && isValid;
	}

	protected String destinationEmptyMessage()
	{
		return DataTransferMessages.FileExport_destinationEmpty;
	}

	protected String getConflictingContainerNameFor(String targetDirectory)
	{
		IPath rootPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		IPath testPath = new Path(targetDirectory);

		if(testPath.equals(rootPath))
			return rootPath.lastSegment();
        
		if(testPath.matchingFirstSegments(rootPath) == rootPath.segmentCount())
		{
			String firstSegment = testPath.removeFirstSegments(rootPath.segmentCount()).segment(0);
			if(!Character.isLetterOrDigit(firstSegment.charAt(0)))
				return firstSegment;
		}
		return null;
	}

	private String getOverlappingProjectName(String targetDirectory)
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath testPath = new Path(targetDirectory);
		@SuppressWarnings("deprecation")
		IContainer[] containers = root.findContainersForLocation(testPath);
		if(containers.length > 0)
		{
			return containers[0].getProject().getName();
		}
		return null;
	}
}