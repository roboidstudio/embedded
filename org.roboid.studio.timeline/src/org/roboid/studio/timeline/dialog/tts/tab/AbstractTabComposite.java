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

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.roboid.audio.tts.TtsEngineManager;
import org.roboid.audio.tts.TtsVoice;
import org.roboid.audio.tts.TtsVoiceEffect;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.dialog.TtsDialog;

/**
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public abstract class AbstractTabComposite extends Composite
{
	private Group groupVoiceEffect;
	private Label labelVoiceEffect;
	private Combo comboVoiceEffect;

	private Button buttonDefault;

	private Label labelSpeechRate;
	private Label labelSpeechRateValue;
	private Scale scaleSpeechRate;

	private Label labelVolume;
	private Label labelVolumeValue;
	private Scale scaleVolume;

	private Label labelPitch;
	private Label labelPitchValue;
	private Scale scalePitch;
	
	protected TtsEngineManager manager = TtsEngineManager.getInstance();
	private List<TtsVoiceEffect> voiceEffectList;

	public AbstractTabComposite(Composite parent, int style)
	{
		super(parent, style);
	}

	public void initialize(AudioPoint ap)
	{
		// 위젯들을 생성 한다.
		createContents();
		initializeVoiceEffectCombo();

		// 위젯들의 초기 값 설정
		AbstractTabProperties p = null;
		if(ap != null && !ap.isNew() && isResponsibleFor(ap)) // AudioPoint 저장에 사용된 탭인지 확인
			p = createProperties(ap);
		else
			p = getDefaultProperties();
		applyPropertiesToWidgets(p, false, true);
	}
	
	private void initializeVoiceEffectCombo()
	{
		voiceEffectList = manager.getVoiceEffects();

		comboVoiceEffect.removeAll();
		for(TtsVoiceEffect effect : voiceEffectList)
			comboVoiceEffect.add(effect.getName());
		
		comboVoiceEffect.select(0);
	}

	// 프로퍼티의 값을 위젯에 적용한다.
	public void applyPropertiesToWidgets(AbstractTabProperties p, boolean isDefault, boolean updateVcCombo)
	{
		if(p == null) return;

		if(updateVcCombo)
		{
			groupVoiceEffect.setEnabled(p.isVoiceEffectEnabled());
			labelVoiceEffect.setEnabled(p.isVoiceEffectEnabled());
			comboVoiceEffect.setEnabled(p.isVoiceEffectEnabled());
			
			int index = 0;
			String id = p.getVoiceEffectId();
			if(id != null)
			{
				for(int i = 0; i < voiceEffectList.size(); i ++)
				{
					if(voiceEffectList.get(i).getId().equalsIgnoreCase(id))
					{
						index = i;
						break;
					}
				}
			}
			comboVoiceEffect.select(index);
		}

		// 기본값 버튼 
		buttonDefault.setEnabled(p.isDefaultButtonEnabled());
		
		// speech rate
		labelSpeechRate.setEnabled(p.isSpeechRateEnabled());
		labelSpeechRateValue.setEnabled(p.isSpeechRateEnabled());
		scaleSpeechRate.setEnabled(p.isSpeechRateEnabled());
		if(p.getSpeechRate().getMin() >= scaleSpeechRate.getMaximum())
		{
			scaleSpeechRate.setMaximum(p.getSpeechRate().getMax());
			scaleSpeechRate.setMinimum(p.getSpeechRate().getMin());
		}
		else
		{
			scaleSpeechRate.setMinimum(p.getSpeechRate().getMin());
			scaleSpeechRate.setMaximum(p.getSpeechRate().getMax());
		}
		scaleSpeechRate.setPageIncrement(p.getSpeechRate().getGrid());
		scaleSpeechRate.setSelection(p.getSpeechRateValue());

		// volume
		labelVolume.setEnabled(p.isVolumeEnabled());
		labelVolumeValue.setEnabled(p.isVolumeEnabled());
		scaleVolume.setEnabled(p.isVolumeEnabled());
		if(p.getVolume().getMin() >= scaleVolume.getMaximum())
		{
			scaleVolume.setMaximum(p.getVolume().getMax());
			scaleVolume.setMinimum(p.getVolume().getMin());
		}
		else
		{
			scaleVolume.setMinimum(p.getVolume().getMin());
			scaleVolume.setMaximum(p.getVolume().getMax());
		}
		scaleVolume.setPageIncrement(p.getVolume().getGrid());
		scaleVolume.setSelection(p.getVolumeValue());

		// pitch
		labelPitch.setEnabled(p.isPitchEnabled());
		labelPitchValue.setEnabled(p.isPitchEnabled());
		scalePitch.setEnabled(p.isPitchEnabled());
		if(p.getPitch().getMin() >= scalePitch.getMaximum())
		{
			scalePitch.setMaximum(p.getPitch().getMax());
			scalePitch.setMinimum(p.getPitch().getMin());
		}
		else
		{
			scalePitch.setMinimum(p.getPitch().getMin());
			scalePitch.setMaximum(p.getPitch().getMax());
		}
		scalePitch.setPageIncrement(p.getPitch().getGrid());
		scalePitch.setSelection(p.getPitchValue());
	}

	// 위젯들을 생성한다.
	protected void createContents()
	{
		setLayout(new GridLayout());
		groupVoiceEffect = new Group(this, SWT.NONE);
		final GridLayout glGroupVoiceEffect = new GridLayout();
		glGroupVoiceEffect.numColumns = 4;
		groupVoiceEffect.setLayout(glGroupVoiceEffect);
		groupVoiceEffect.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		groupVoiceEffect.setText(Messages.AbstractTabComposite_VoiceEffect);

		labelVoiceEffect = new Label(groupVoiceEffect, SWT.NONE);
		labelVoiceEffect.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelVoiceEffect.setText(Messages.AbstractTabComposite_Effect + ":"); //$NON-NLS-2$

		comboVoiceEffect = new Combo(groupVoiceEffect, SWT.READ_ONLY);
		comboVoiceEffect.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		buttonDefault = new Button(groupVoiceEffect, SWT.NONE);
		final GridData gdButtonDefault = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		gdButtonDefault.widthHint = 80;
		buttonDefault.setLayoutData(gdButtonDefault);
		buttonDefault.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				applyPropertiesToWidgets(getDefaultProperties(), true, true);
			}
		});
		buttonDefault.setText(Messages.AbstractTabComposite_Default);

		labelSpeechRate = new Label(groupVoiceEffect, SWT.NONE);
		labelSpeechRate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelSpeechRate.setText(Messages.AbstractTabComposite_Speed + ":"); //$NON-NLS-2$

		labelSpeechRateValue = new Label(groupVoiceEffect, SWT.NONE);
		labelSpeechRateValue.setAlignment(SWT.RIGHT);
		labelSpeechRateValue.setLayoutData(new GridData(20, SWT.DEFAULT));
		labelSpeechRateValue.setText("0"); //$NON-NLS-1$

		scaleSpeechRate = new Scale(groupVoiceEffect, SWT.NONE);
		scaleSpeechRate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		scaleSpeechRate.addPaintListener(new PaintListener()
		{
			public void paintControl(final PaintEvent e)
			{
				labelSpeechRateValue.setText(String.valueOf(scaleSpeechRate.getSelection()));
			}
		});
		scaleSpeechRate.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(final SelectionEvent e)
			{
				labelSpeechRateValue.setText(String.valueOf(scaleSpeechRate.getSelection()));
			}
		});

		labelVolume = new Label(groupVoiceEffect, SWT.NONE);
		labelVolume.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelVolume.setText(Messages.AbstractTabComposite_Volume + ":"); //$NON-NLS-2$

		labelVolumeValue = new Label(groupVoiceEffect, SWT.NONE);
		labelVolumeValue.setAlignment(SWT.RIGHT);
		labelVolumeValue.setLayoutData(new GridData(20, SWT.DEFAULT));
		labelVolumeValue.setText("0"); //$NON-NLS-1$

		scaleVolume = new Scale(groupVoiceEffect, SWT.NONE);
		scaleVolume.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		scaleVolume.addPaintListener(new PaintListener()
		{
			public void paintControl(final PaintEvent e)
			{
				labelVolumeValue.setText(String.valueOf(scaleVolume.getSelection()));
			}
		});
		scaleVolume.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(final SelectionEvent e)
			{
				labelVolumeValue.setText(String.valueOf(scaleVolume.getSelection()));
			}
		});

		labelPitch = new Label(groupVoiceEffect, SWT.NONE);
		labelPitch.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelPitch.setText(Messages.AbstractTabComposite_Pitch + ":"); //$NON-NLS-2$

		labelPitchValue = new Label(groupVoiceEffect, SWT.NONE);
		labelPitchValue.setAlignment(SWT.RIGHT);
		labelPitchValue.setLayoutData(new GridData(20, SWT.DEFAULT));
		labelPitchValue.setText("0"); //$NON-NLS-1$

		scalePitch = new Scale(groupVoiceEffect, SWT.NONE);
		scalePitch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		scalePitch.addPaintListener(new PaintListener()
		{
			public void paintControl(final PaintEvent e)
			{
				labelPitchValue.setText(String.valueOf(scalePitch.getSelection()));
			}
		});
		scalePitch.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(final SelectionEvent e)
			{
				labelPitchValue.setText(String.valueOf(scalePitch.getSelection()));
			}
		});
	}

	// 위젯들의 값을 얻는다.
	public void getPropertiesFromWidgets(AbstractTabProperties p)
	{
		if(voiceEffectList == null)
			voiceEffectList = manager.getVoiceEffects();
		int index = comboVoiceEffect.getSelectionIndex();
		if(index >= 0 && index < voiceEffectList.size())
		{
			TtsVoiceEffect voiceEffect = voiceEffectList.get(index);
			p.setVoiceEffectId(voiceEffect.getId());
		}
		p.setSpeechRateValue(scaleSpeechRate.getSelection());
		p.setVolumeValue(scaleVolume.getSelection());
		p.setPitchValue(scalePitch.getSelection());
	}

	AbstractTabProperties createProperties(AudioPoint ap)
	{
		AbstractTabProperties p;
		if(ap.isTts())
		{
			TtsEngineManager manager = TtsEngineManager.getInstance();
			TtsVoice voice = manager.getVoiceById(ap.getVoiceId());
			p = new TtsTabProperties(voice);
			((TtsTabProperties)p).setText(ap.getText());
		}
		else
		{
			p = new FileTabProperties();
			((FileTabProperties)p).setFilePath(ap.getText());
		}
		
		p.setVoiceEffectId(ap.getVoiceEffectId());
		p.setSpeechRateValue(ap.getSpeechRate());
		p.setVolumeValue(ap.getVolume());
		p.setPitchValue(ap.getPitch());
		
		return p;
	}
	
	public abstract String getTabName();
	public abstract boolean isResponsibleFor(AudioPoint ap);
	public abstract AbstractTabProperties getDefaultProperties();
	public abstract void execute(TtsDialog dialog);
}
