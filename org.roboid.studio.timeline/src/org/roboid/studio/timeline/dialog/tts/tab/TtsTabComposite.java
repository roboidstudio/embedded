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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.roboid.audio.tts.TtsLanguage;
import org.roboid.audio.tts.TtsVoice;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * Tts Dialog에 들어가는 Tab들이 상속받는 추상 클래스
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsTabComposite extends AbstractTabComposite
{
	private Group groupTts;
	private Label labelSpeaker;
	private Combo comboSpeaker;
	private Label labelLanguage;
	private Combo comboLanguage;
	private Text textTts;
	
	private List<TtsLanguage> languageList;
	private List<TtsVoice> voiceList;
	private List<TtsTabProperties> defaultPropertiesList;

	public TtsTabComposite(Composite parent, int style)
	{
		super(parent, style);
	}
	
	private void initializeLanguageComboBox()
	{
		languageList = manager.getAvailableLanguages();
		String languageId = System.getProperty("user.language"); //$NON-NLS-1$
		
		comboLanguage.removeAll();
		for(TtsLanguage lang : languageList)
			comboLanguage.add(lang.getName());
		
		int index = 0;
		for(int i = 0; i < languageList.size(); i ++)
		{
			TtsLanguage lang = languageList.get(i);
			if(lang.getId().equalsIgnoreCase(languageId))
			{
				index = i;
				break;
			}
		}
		
		comboLanguage.select(index);
	}
	
	private void initializeSpeakerComboBox(int languageIndex)
	{
		if(languageIndex < 0 || languageIndex >= languageList.size()) return;
		
		TtsLanguage lang = languageList.get(languageIndex);
		voiceList = manager.getVoicesByLanguageId(lang.getId());
		
		comboSpeaker.removeAll();
		defaultPropertiesList = new ArrayList<TtsTabProperties>();
		for(TtsVoice voice : voiceList)
		{
			comboSpeaker.add(voice.getVoiceName());
			defaultPropertiesList.add(new TtsTabProperties(voice));
		}

		comboSpeaker.select(0);
	}
	
	@Override
	public void applyPropertiesToWidgets(AbstractTabProperties p, boolean isDefault, boolean updateVcCombo)
	{
		if(p == null) return;
		
		if(!isDefault)
		{
			TtsTabProperties prop = (TtsTabProperties)p;
			
			// Text
			textTts.setText(prop.getText());
	
			// language
			String languageId = prop.getLanguageId();
			int index = 0;
			for(int i = 0; i < languageList.size(); i ++)
			{
				TtsLanguage lang = languageList.get(i);
				if(lang.getId().equalsIgnoreCase(languageId))
				{
					index = i;
					break;
				}
			}
			comboLanguage.select(index);
			initializeSpeakerComboBox(index);
			
			// voice
			String voiceId = prop.getVoiceId();
			index = 0;
			for(int i = 0; i < voiceList.size(); i ++)
			{
				TtsVoice voice = voiceList.get(i);
				if(voice.getVoiceId().equalsIgnoreCase(voiceId))
				{
					index = i;
					break;
				}
			}
			comboSpeaker.select(index);
		}

		super.applyPropertiesToWidgets(p, isDefault, updateVcCombo);
	}
	
	@Override
	protected void createContents()
	{
		setLayout(new GridLayout());

		groupTts = new Group(this, SWT.NONE);
		final GridLayout glGroupTts = new GridLayout();
		glGroupTts.numColumns = 4;
		groupTts.setLayout(glGroupTts);
		groupTts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		groupTts.setText(Messages.TtsTabComposite_TextToSpeech + ":"); //$NON-NLS-2$

		labelSpeaker = new Label(groupTts, SWT.NONE);
		labelSpeaker.setAlignment(SWT.RIGHT);
		labelSpeaker.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		labelSpeaker.setText(Messages.TtsTabComposite_Voice + ":"); //$NON-NLS-2$

		comboSpeaker = new Combo(groupTts, SWT.READ_ONLY);
		final GridData gdComboSpeaker = new GridData(SWT.FILL, SWT.FILL, false, false);
		gdComboSpeaker.widthHint = 100;
		comboSpeaker.setLayoutData(gdComboSpeaker);
		comboSpeaker.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// 목소리에 해당하는 속성으로 설정한다.
				applyPropertiesToWidgets(getDefaultProperties(), true, false);
			}
		});

		labelLanguage = new Label(groupTts, SWT.NONE);
		labelLanguage.setAlignment(SWT.RIGHT);
		labelLanguage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		labelLanguage.setText(Messages.TtsTabComposite_Language + ":"); //$NON-NLS-2$

		comboLanguage = new Combo(groupTts, SWT.READ_ONLY);
		comboLanguage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		comboLanguage.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// 언어별로 목소리를 콤보 박스에 나타내도록 함
				initializeSpeakerComboBox(comboLanguage.getSelectionIndex());
				applyPropertiesToWidgets(getDefaultProperties(), true, false);
			}
		});

		textTts = new Text(groupTts, SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		textTts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		textTts.setFocus();
		
		// 초점을 얻으면 Text에 초점을 맞춘다.
		addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				textTts.setFocus();
			}
		});

		// AbstractTabComposite을 표시한다.
		super.createContents();

		// comboLanguage에 목록을 추가한다.
		initializeLanguageComboBox();
		initializeSpeakerComboBox(comboLanguage.getSelectionIndex());
	}
	
	@Override
	public void getPropertiesFromWidgets(AbstractTabProperties p)
	{
		TtsTabProperties prop = (TtsTabProperties)p;

		prop.setText(textTts.getText());
		
		if(languageList == null)
			languageList = manager.getAvailableLanguages();
		int index = comboLanguage.getSelectionIndex();
		if(index >= 0 && index < languageList.size())
		{
			TtsLanguage lang = languageList.get(index);
			prop.setLanguageId(lang.getId());
		}
		
		if(voiceList == null)
			voiceList = manager.getVoicesByLanguageId(prop.getLanguageId());
		index = comboSpeaker.getSelectionIndex();
		if(index >= 0 && index < voiceList.size())
		{
			TtsVoice voice = voiceList.get(index);
			prop.setVoiceId(voice.getVoiceId());
		}
		
		super.getPropertiesFromWidgets(prop);
	}
	
	@Override
	public String getTabName()
	{
		return Messages.TtsTabComposite_TextToSpeech;
	}
	
	@Override
	public boolean isResponsibleFor(AudioPoint ap)
	{
		return ap.isTts();
	}
	
	@Override
	public AbstractTabProperties getDefaultProperties()
	{
		int index = comboSpeaker.getSelectionIndex();
		if(defaultPropertiesList == null || index < 0 || index >= defaultPropertiesList.size())
			return new TtsTabProperties();
		
		return defaultPropertiesList.get(index);
	}

	@Override
	public void execute(TtsDialog dialog)
	{
		int index = comboSpeaker.getSelectionIndex();
		if(index >= 0 && index < voiceList.size())
		{
			TtsVoice voice = voiceList.get(index);
			TtsTabProperties p = new TtsTabProperties(voice);
			getPropertiesFromWidgets(p);
		
			new TtsTabAction().process(dialog, p);
		}
	}
}
