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

package org.roboid.studio.timeline.dialog.tts.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class FileTabComposite extends AbstractTabComposite
{
	private Group groupFile;
	private Label labelFilePath;
	private Button buttonBrowse;
	private Text textFilePath;

	public FileTabComposite(Composite parent, int style)
	{
		super(parent, style);
	}

	// 프로퍼티의 값을 위젯에 적용한다.
	@Override
	public void applyPropertiesToWidgets(AbstractTabProperties p, boolean isDefault, boolean updateVcCombo)
	{
		if(p == null) return;
		
		if(!isDefault)
		{
			FileTabProperties prop = (FileTabProperties)p;
			
			textFilePath.setText(prop.getFilePath());
		}

		super.applyPropertiesToWidgets(p, isDefault, updateVcCombo);
	}

	// 위젯들을 생성한다.
	@Override
	protected void createContents()
	{
		setLayout(new GridLayout());

		groupFile = new Group(this, SWT.NONE);
		final GridLayout glGroupFile = new GridLayout();
		glGroupFile.numColumns = 3;
		groupFile.setLayout(glGroupFile);
		groupFile.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		groupFile.setText(Messages.FileTabComposite_File);

		labelFilePath = new Label(groupFile, SWT.NONE);
		labelFilePath.setAlignment(SWT.RIGHT);
		labelFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		labelFilePath.setText(Messages.FileTabComposite_FileName + ":"); //$NON-NLS-2$

		textFilePath = new Text(groupFile, SWT.BORDER);
		textFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textFilePath.setEditable(false);

		buttonBrowse = new Button(groupFile, SWT.NONE);
		buttonBrowse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(final SelectionEvent e)
			{
				FileDialog dialog = new FileDialog(FileTabComposite.this.getShell());
				dialog.setFilterNames(new String[]
				{
//					Messages.FileTabComposite_AudioFiles + "(*.wav;*.mp3;*.ogg)", //$NON-NLS-2$
//					"Wave " + Messages.FileTabComposite_Files + "(*.wav)", //$NON-NLS-1$ //$NON-NLS-3$
//					"Mp3 " + Messages.FileTabComposite_Files + "(*.mp3)", //$NON-NLS-1$ //$NON-NLS-3$
//					"Ogg Vorbis " + Messages.FileTabComposite_Files + "(*.ogg)" //$NON-NLS-1$ //$NON-NLS-3$
					Messages.FileTabComposite_AudioFiles + "(*.wav;*.mp3)", //$NON-NLS-2$
					"Wave " + Messages.FileTabComposite_Files + "(*.wav)", //$NON-NLS-1$ //$NON-NLS-3$
					"Mp3 " + Messages.FileTabComposite_Files + "(*.mp3)" //$NON-NLS-1$ //$NON-NLS-3$
				});
//				dialog.setFilterExtensions(new String[]{ "*.wav; *.mp3; *.ogg", "*.wav", "*.mp3", "*.ogg" }); //Windows wild cards //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				dialog.setFilterExtensions(new String[]{ "*.wav; *.mp3", "*.wav", "*.mp3" }); //Windows wild cards //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				String filePath = dialog.open();
				if(filePath != null) textFilePath.setText(filePath);
			}
		});
		buttonBrowse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		buttonBrowse.setText("..."); //$NON-NLS-1$

		super.createContents();
	}

	// 위젯들의 값을 얻는다.
	@Override
	public void getPropertiesFromWidgets(AbstractTabProperties p)
	{
		FileTabProperties prop = (FileTabProperties)p;
		
		prop.setFilePath(textFilePath.getText());
		
		super.getPropertiesFromWidgets(prop);
	}
	
	// 탭의 이름을 얻는다.
	@Override
	public String getTabName()
	{
		return Messages.FileTabComposite_File;
	}
	
	@Override
	public boolean isResponsibleFor(org.roboid.studio.timeline.AudioPoint ap)
	{
		return ap.isFile();
	}
	
	@Override
	public AbstractTabProperties getDefaultProperties()
	{
		return new FileTabProperties();
	}
	
	@Override
	public void execute(TtsDialog dialog)
	{
		FileTabProperties p = new FileTabProperties();
		getPropertiesFromWidgets(p);
		
		new FileTabAction().process(dialog, p);
	}
}
