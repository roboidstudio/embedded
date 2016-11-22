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

package org.roboid.studio.timeline.property;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.roboid.robot.ColorMode;

/**
 * @author Kwang-Hyun Park
 */
class MonoColorDialog extends Dialog
{
	private final int NUM_COLORS = 11;
	
	private final ColorMode mode;
	private boolean success;
	private Shell shell;
	private RGB rgbNew;
	private Color[] colors = new Color[NUM_COLORS];
	private Label labelValue;
	private Scale scale;
	
	MonoColorDialog(Shell parent, ColorMode mode)
	{
		this(parent, SWT.NONE, mode);
	}
	
	MonoColorDialog(Shell parent, int style, ColorMode mode)
	{
		super(parent, style);
		this.mode = mode;
	}
	
	RgbColor open(RgbColor ledColor)
	{
		RGB rgbOld = ledColor.getRGB();
		rgbNew = new RGB(rgbOld.red, rgbOld.green, rgbOld.blue);
		
		createContents();
		
		Display display = getParent().getDisplay();
		shell.setLocation((display.getBounds().width - shell.getBounds().width) / 2, (display.getBounds().height - shell.getBounds().height) / 2);
		shell.open();
		
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) display.sleep();
		}
		
		for(Color color : colors)
			color.dispose();
		
		if(success && (rgbNew.red != rgbOld.red || rgbNew.green != rgbOld.green || rgbNew.blue != rgbOld.blue))
			return new RgbColor(mode, rgbNew);
		else
			return null;
	}
	
	private void createContents()
	{
		shell = new Shell(getParent(), SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		shell.setText(Messages.DualColorDialog_ColorSettings);
		shell.setLayout(new GridLayout());
		
		Composite panel = new Composite(shell, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		panel.setLayout(gridLayout);
		
		final Canvas colorCanvas = new Canvas(panel, SWT.DOUBLE_BUFFERED);
		colorCanvas.addPaintListener(new PaintListener()
		{
			@Override
			public void paintControl(PaintEvent e)
			{
				Color color = new Color(null, rgbNew);
				e.gc.setBackground(color);
				Rectangle rect = colorCanvas.getBounds();
				e.gc.fillRectangle(rect);
				e.gc.setForeground(ColorConstants.darkGray);
				rect.width--; rect.height--;
				e.gc.drawRectangle(rect);
				color.dispose();
			}
		});
		colorCanvas.setLayout(new GridLayout());
		final GridData gdCanvas = new GridData(SWT.FILL, SWT.FILL, false, false);
		gdCanvas.widthHint = 80;
		colorCanvas.setLayoutData(gdCanvas);
		
		Composite panelRight = new Composite(panel, SWT.NONE);
		final GridLayout glRight = new GridLayout();
		glRight.numColumns = NUM_COLORS;
		glRight.horizontalSpacing = 2;
		glRight.verticalSpacing = 2;
		glRight.marginWidth = 0;
		glRight.marginHeight = 0;
		panelRight.setLayout(glRight);
		
		colors[0] = new Color(null, 0, 0, 0);
		int value = 30;
		for(int i = 1; i < NUM_COLORS; i ++)
		{
			colors[i] = createColor(value);
			value += 25;
		}
		
		for(int i = 0; i < NUM_COLORS; i ++)
		{
			final Label label = new Label(panelRight, SWT.NONE);
			label.setLayoutData(new GridData(16, 16));
			label.setBackground(colors[i]);
			label.addPaintListener(new PaintListener()
			{
				@Override
				public void paintControl(PaintEvent e)
				{
					e.gc.setBackground(label.getBackground());
					e.gc.fillRectangle(0, 0, label.getBounds().width, label.getBounds().height);
					e.gc.setForeground(ColorConstants.darkGray);
					e.gc.drawRectangle(0, 0, label.getBounds().width, label.getBounds().height);
				}
			});
			label.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseDown(MouseEvent e)
				{
					rgbNew = label.getBackground().getRGB();
					int v = getValue(rgbNew);
					scale.setSelection(v);
					labelValue.setText(Integer.toString(v));
					colorCanvas.redraw();
				}
			});
		}
		
		Composite panelMiddle = new Composite(panel, SWT.NONE);
		final GridLayout glMiddle = new GridLayout();
		glMiddle.numColumns = 2;
		glMiddle.marginWidth = 0;
		glMiddle.marginHeight = 0;
		panelMiddle.setLayout(glMiddle);
		panelMiddle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		labelValue = new Label(panelMiddle, SWT.NONE);
		labelValue.setAlignment(SWT.CENTER);
		final GridData gdLabelValue = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gdLabelValue.widthHint = 20;
		labelValue.setLayoutData(gdLabelValue);
		int v = getValue(rgbNew);
		labelValue.setText(Integer.toString(v));
		scale = new Scale(panelMiddle, SWT.NONE);
		final GridData gdScale = new GridData(SWT.FILL, SWT.CENTER, true, false);
		scale.setLayoutData(gdScale);
		scale.setMinimum(0);
		scale.setMaximum(255);
		scale.setSelection(v);
		scale.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				int v = scale.getSelection();
				setRGB(rgbNew, v);
				labelValue.setText(Integer.toString(v));
				colorCanvas.redraw();
			}
		});
		scale.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				shell.forceFocus();
			}
		});
		
		Composite panelBottom = new Composite(panel, SWT.NONE);
		final GridLayout glBottom = new GridLayout();
		glBottom.numColumns = 2;
		glBottom.marginWidth = 0;
		glBottom.marginHeight = 0;
		panelBottom.setLayout(glBottom);
		panelBottom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));
		
		Button buttonOK = new Button(panelBottom, SWT.NONE);
		GridData gdOK = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		gdOK.widthHint = 90;
		gdOK.heightHint = 23;
		buttonOK.setLayoutData(gdOK);
		buttonOK.setText(Messages.DualColorDialog_OK);
		buttonOK.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				success = true;
				shell.dispose();
			}
		});
		
		Button buttonCancel = new Button(panelBottom, SWT.NONE);
		GridData gdCancel = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		gdCancel.widthHint = 90;
		gdCancel.heightHint = 23;
		buttonCancel.setLayoutData(gdCancel);
		buttonCancel.setText(Messages.DualColorDialog_Cancel);
		buttonCancel.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				shell.dispose();
			}
		});

		shell.pack();
	}
	
	private Color createColor(int value)
	{
		if(mode == null) return new Color(null, value, value, value);
		
		switch(mode.getValue())
		{
		case ColorMode.RED_VALUE:
			return new Color(null, value, 0, 0);
		case ColorMode.GREEN_VALUE:
			return new Color(null, 0, value, 0);
		case ColorMode.BLUE_VALUE:
			return new Color(null, 0, 0, value);
		case ColorMode.GRAY_VALUE:
		default:
			return new Color(null, value, value, value);
		}
	}
	
	private int getValue(RGB rgb)
	{
		if(mode == null) return rgb.red;
		
		switch(mode.getValue())
		{
		case ColorMode.RED_VALUE:
			return rgb.red;
		case ColorMode.GREEN_VALUE:
			return rgb.green;
		case ColorMode.BLUE_VALUE:
			return rgb.blue;
		case ColorMode.GRAY_VALUE:
		default:
			return rgb.red;
		}
	}
	
	private void setRGB(RGB rgb, int value)
	{
		if(mode == null) rgb.red = rgb.green = rgb.blue = value;

		rgb.red = rgb.green = rgb.blue = 0;
		switch(mode.getValue())
		{
		case ColorMode.RED_VALUE:
			rgb.red = value;
			break;
		case ColorMode.GREEN_VALUE:
			rgb.green = value;
			break;
		case ColorMode.BLUE_VALUE:
			rgb.blue = value;
			break;
		case ColorMode.GRAY_VALUE:
		default:
			rgb.red = rgb.green = rgb.blue = value;
		}
	}
}
