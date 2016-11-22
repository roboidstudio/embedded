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

package org.roboid.studio.timeline.dialog;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.roboid.audio.AudioUtil;
import org.roboid.studio.timeline.Activator;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.VoicePoint;
import org.roboid.studio.timeline.dialog.tts.tab.AbstractTabComposite;
import org.roboid.studio.timeline.dialog.tts.tab.AbstractTabProperties;
import org.roboid.studio.timeline.dialog.tts.tab.FileTabComposite;
import org.roboid.studio.timeline.dialog.tts.tab.FileTabProperties;
import org.roboid.studio.timeline.dialog.tts.tab.TtsTabComposite;
import org.roboid.studio.timeline.dialog.tts.tab.TtsTabProperties;

import com.swtdesigner.ResourceManager;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsDialog extends Dialog
{
	public static final AudioFormat SPEAKER_FORMAT_MONO = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 16000, 16, 1, 2, 16000, false);

	private Shell shell;
	private TabFolder tabFolder;
	private Button buttonWriteToFile;
	private Button buttonFinish;
	private Button buttonCancel;
	private Label labelMessage;
	private AudioPoint cp;

	private boolean result;

	/**
	 * Create the dialog
	 * 
	 * @param parent
	 */
	public TtsDialog(Shell parent, AudioPoint cp)
	{
		this(parent, SWT.NONE, cp);
	}

	/**
	 * Create the dialog
	 * 
	 * @param parent
	 * @param style
	 * @wbp.parser.constructor
	 */
	public TtsDialog(Shell parent, int style, AudioPoint cp)
	{
		super(parent, style);
		this.cp = cp;
	}

	/**
	 * Create contents of the dialog
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	protected void createContents() throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		shell = new Shell(getParent(), SWT.APPLICATION_MODAL | SWT.TITLE | SWT.BORDER | SWT.CLOSE);
		shell.setLayout(new GridLayout());
		shell.setSize(400, 500);

		// �����, ���̽��� ���� ��ȭâ�� ������ �޸� �Ѵ�.
		if(cp instanceof VoicePoint)
		{
			shell.setText(Messages.TtsDialog_Voice);
			shell.setImage(ResourceManager.getPluginImage(Activator.getDefault(), "icons/voicedialog.png")); //$NON-NLS-1$
		}
		else
		{
			shell.setText(Messages.TtsDialog_Audio);
			shell.setImage(ResourceManager.getPluginImage(Activator.getDefault(), "icons/audiodialog.png")); //$NON-NLS-1$
		}

		tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createTabItems(tabFolder);
		tabFolder.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// TTS ���� ���� Text�� ������ ������ �Ѵ�.
				if(tabFolder.getSelectionIndex() == 1)
				{
					tabFolder.getItem(1).getControl().forceFocus();
				}
			}
		});

		if(cp.isNew()) // ���� �����ϴ� ��� Voice ä���� TTS ����, Audio ä���� ���� ���� ����.
		{
			if(cp instanceof VoicePoint)
				tabFolder.setSelection(1);
			else
				tabFolder.setSelection(0);
		}
		else // �����ϴ� ��� �������� ���� ���� �����Ѵ�.
		{
			if(cp.isFile())
				tabFolder.setSelection(0);
			else
				tabFolder.setSelection(1);
		}

		Composite composite = new Composite(shell, SWT.NONE);
		final GridData gdComposite = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gdComposite.heightHint = 32;
		gdComposite.widthHint = 36;
		composite.setLayoutData(gdComposite);
		final GridLayout glComposite = new GridLayout();
		glComposite.numColumns = 3;
		composite.setLayout(glComposite);

		buttonWriteToFile = new Button(composite, SWT.CHECK);
		buttonWriteToFile.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		buttonWriteToFile.setText(Messages.TtsDialog_WriteToFile);

		buttonFinish = new Button(composite, SWT.NONE);
		buttonFinish.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// FINISH ��ư Ŭ�� ��
				TtsDialog.this.setEnabled(false);

				// �ش�Ǵ� ���� process�� ������ 
				AbstractTabComposite selItem = (AbstractTabComposite)tabFolder.getTabList()[tabFolder.getSelectionIndex()];
				selItem.execute(TtsDialog.this);
			}
		});
		final GridData gdFinishButton = new GridData(SWT.RIGHT, SWT.FILL, false, true);
		gdFinishButton.heightHint = 23;
		gdFinishButton.widthHint = 90;
		buttonFinish.setLayoutData(gdFinishButton);
		buttonFinish.setText(Messages.Common_OK);

		buttonCancel = new Button(composite, SWT.NONE);
		buttonCancel.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// ��� Ŭ���� 
				shell.close();
			}
		});
		final GridData gdCancelButton = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gdCancelButton.widthHint = 90;
		buttonCancel.setLayoutData(gdCancelButton);
		buttonCancel.setText(Messages.Common_Cancel);
	}

	/**
	 * �ǵ��� �����մϴ�.
	 * 
	 * @param parentTabFolder
	 */
	private void createTabItems(TabFolder parentTabFolder)
	{
		// ���� ��
		TabItem tabItem = new TabItem(parentTabFolder, SWT.NONE);
		AbstractTabComposite fileTab = new FileTabComposite(parentTabFolder,
															SWT.NONE);
		fileTab.initialize(cp);
		tabItem.setControl(fileTab);
		tabItem.setText(fileTab.getTabName());

		// TTS ��
		tabItem = new TabItem(parentTabFolder, SWT.NONE);
		AbstractTabComposite ttsTab = new TtsTabComposite(parentTabFolder, SWT.NONE);
		ttsTab.initialize(cp);
		tabItem.setControl(ttsTab);
		tabItem.setText(ttsTab.getTabName());
	}

	/**
	 * Open the dialog
	 * 
	 * @return the result
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * 
	 */
	public boolean open() throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		createContents();
		shell.layout();
		Display display = getParent().getDisplay();
		shell.setLocation(	(getParent().getBounds().width - shell.getBounds().width) / 2,
							(getParent().getBounds().height - shell.getBounds().height) / 2);
		shell.open();

		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) display.sleep();
		}

		return result;
	}
	
	private void dispose()
	{
		// �����츦 �ݴ´�.
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				shell.dispose();
			}
		});
	}

	// ����� ������ �аų� TTS�� �Ϸ�Ǿ��� �� ȣ��ȴ�.
	public void processCompletedAndClose(final AudioInputStream audio, final AbstractTabProperties p)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				AudioInputStream stream = audio;
				
				// ���Ϸ� ������ üũ���� ��� ���Ϸ� �����Ѵ�.
				if(buttonWriteToFile.getSelection())
					stream = saveToFile(stream);
		
				if(stream == null)
				{
					dispose();
					return;
				}
		
				try
				{
					// ����� ���� ��ȯ�� �޽��� ��� 
					showMessage(Messages.TtsDialog_Message_Converting_the_audio_format);
					((AudioPoint)cp).setMp3(stream);
				}
				catch (Exception e)
				{
					processExceptionOccurs(e);
				}
		
				// ������ ����Ѵ�.
				if(p instanceof FileTabProperties)
				{
					cp.setText(((FileTabProperties)p).getFilePath());
					cp.setVoiceId(null);
				}
				else
				{
					cp.setText(((TtsTabProperties)p).getText());
					cp.setVoiceId(((TtsTabProperties)p).getVoiceId());
				}
				
				cp.setVoiceEffectId(p.getVoiceEffectId());
				cp.setSpeechRate(p.getSpeechRateValue());
				cp.setVolume(p.getVolumeValue());
				cp.setPitch(p.getPitchValue());
				
				result = true;
		
				dispose();
			}
		});
	}

	private AudioInputStream saveToFile(AudioInputStream audio)
	{
		if(audio == null) return null;
		
		try
		{
			// ���� ��ȭ���ڸ� ����.
			FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
			fileDialog.setFilterNames(new String[]{ "Wave " + Messages.TtsDialog_Files + "(*.wav)" }); //$NON-NLS-1$ //$NON-NLS-3$
			fileDialog.setFilterExtensions(new String[]{ "*.wav" }); //Windows wild cards //$NON-NLS-1$
			String filePath = fileDialog.open();

			// ������ ������ ��� 
			if(filePath != null)
			{
				// ���Ϸ� �����Ѵ�.
				AudioUtil.write(audio, AudioFileFormat.Type.WAVE, new File(filePath));
				audio.close();
				audio = AudioUtil.getAudioInputStream(new File(filePath));
			}
		}
		catch (Exception e)
		{
			processExceptionOccurs(e);
			return null;
		}
		return audio;
	}

	public void processExceptionOccurs(final Exception e)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(e != null)
				{
					e.printStackTrace();
					// ���̾�α׿� ���� ǥ��
					MessageDialog.openError(shell, e.getClass().getName(), e.getMessage());
				}
				setEnabled(true);
			}
		});
		result = false;
	}

	public void processExceptionOccurs(final String title, final String message)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				MessageDialog.openError(shell, title, message);
				setEnabled(true);
			}
		});
		result = false;
	}

	// �������� Ȱ��ȭ�ϰų� ��Ȱ��ȭ�Ѵ�.
	private void setEnabled(boolean enabled)
	{
		tabFolder.setEnabled(enabled);

		buttonWriteToFile.setEnabled(enabled);
		buttonFinish.setEnabled(enabled);
	}

	// �޽����� ���̾�α� â�� ǥ���Ѵ�.
	public void showMessage(final String message)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(message != null)
				{
					// �޽��� ���̺��� �����.
					if(labelMessage == null || labelMessage.isDisposed())
					{
						labelMessage = new Label(shell, SWT.LEFT);
						final GridData gdLabelMessage = new GridData(SWT.FILL, SWT.CENTER, true, false);
						gdLabelMessage.heightHint = 20;
						labelMessage.setLayoutData(gdLabelMessage);
					}
					// �޽����� ǥ���ϰ� ��ȭâ�� ���η� ���� ũ�� �Ѵ�.
					labelMessage.setText(message);
					shell.setSize(400, 525);
				}
				else
				{
					// �޽��� ���̺��� ���ְ� ��ȭâ�� ���� ũ��� �Ѵ�.
					if(labelMessage != null)
					{
						labelMessage.dispose();
						shell.setSize(400, 500);
					}
				}
			}
		});
	}
}
