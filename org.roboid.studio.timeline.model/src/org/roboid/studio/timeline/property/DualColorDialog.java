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
class DualColorDialog extends Dialog
{
	private final ColorMode mode;
	private boolean success;
	private Shell shell;
	private RGB rgbNew;
	private Color[] colors = new Color[]{
			new Color(null, 32,0,0),
			new Color(null, 64,0,0),
			new Color(null, 96,0,0),
			new Color(null, 128,0,0),
			new Color(null, 160,0,0),
			new Color(null, 192,0,0),
			new Color(null, 208,0,0),
			new Color(null, 224,0,0),
			new Color(null, 240,0,0),
			new Color(null, 255,0,0),
			
			new Color(null, 32,16,0),
			new Color(null, 64,32,0),
			new Color(null, 96,48,0),
			new Color(null, 128,64,0),
			new Color(null, 160,80,0),
			new Color(null, 192,96,0),
			new Color(null, 208,104,0),
			new Color(null, 224,112,0),
			new Color(null, 240,120,0),
			new Color(null, 255,128,0),
			
			new Color(null, 33,32,0),
			new Color(null, 66,64,0),
			new Color(null, 98,96,0),
			new Color(null, 131,128,0),
			new Color(null, 164,160,0),
			new Color(null, 197,192,0),
			new Color(null, 213,208,0),
			new Color(null, 229,224,0),
			new Color(null, 246,240,0),
			new Color(null, 255,255,0),
			
			new Color(null, 16,32,0),
			new Color(null, 32,64,0),
			new Color(null, 48,96,0),
			new Color(null, 64,128,0),
			new Color(null, 80,160,0),
			new Color(null, 96,192,0),
			new Color(null, 104,208,0),
			new Color(null, 112,224,0),
			new Color(null, 120,240,0),
			new Color(null, 128,255,0),
			
			new Color(null, 0,32,0),
			new Color(null, 0,64,0),
			new Color(null, 0,96,0),
			new Color(null, 0,128,0),
			new Color(null, 0,160,0),
			new Color(null, 0,192,0),
			new Color(null, 0,208,0),
			new Color(null, 0,224,0),
			new Color(null, 0,240,0),
			new Color(null, 0,255,0),
			
			new Color(null, 0,0,0) // black
	};
	private Label labelValueR, labelValueG;
	private Scale scaleR, scaleG;
	
	DualColorDialog(Shell parent, ColorMode mode)
	{
		this(parent, SWT.NONE, mode);
	}
	
	DualColorDialog(Shell parent, int style, ColorMode mode)
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
		glRight.numColumns = 10;
		glRight.horizontalSpacing = 2;
		glRight.verticalSpacing = 2;
		glRight.marginWidth = 0;
		glRight.marginHeight = 0;
		panelRight.setLayout(glRight);
		
		for(int i = 0; i < colors.length; i ++)
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
					scaleR.setSelection(rgbNew.red);
					labelValueR.setText(Integer.toString(rgbNew.red));
					scaleG.setSelection(rgbNew.green);
					labelValueG.setText(Integer.toString(rgbNew.green));
					colorCanvas.redraw();
				}
			});
		}
		
		Composite panelMiddle = new Composite(panel, SWT.NONE);
		final GridLayout glMiddle = new GridLayout();
		glMiddle.numColumns = 3;
		glMiddle.marginWidth = 0;
		glMiddle.marginHeight = 0;
		panelMiddle.setLayout(glMiddle);
		panelMiddle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label labelR = new Label(panelMiddle, SWT.NONE);
		labelR.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelR.setText("[R]"); //$NON-NLS-1$
		labelValueR = new Label(panelMiddle, SWT.NONE);
		labelValueR.setAlignment(SWT.CENTER);
		final GridData gdLabelValueR = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gdLabelValueR.widthHint = 20;
		labelValueR.setLayoutData(gdLabelValueR);
		labelValueR.setText(Integer.toString(rgbNew.red));
		scaleR = new Scale(panelMiddle, SWT.NONE);
		final GridData gdScaleR = new GridData(SWT.FILL, SWT.CENTER, true, false);
		scaleR.setLayoutData(gdScaleR);
		scaleR.setMinimum(0);
		scaleR.setMaximum(255);
		scaleR.setSelection(rgbNew.red);
		scaleR.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				rgbNew.red = scaleR.getSelection();
				labelValueR.setText(Integer.toString(rgbNew.red));
				colorCanvas.redraw();
			}
		});
		scaleR.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				shell.forceFocus();
			}
		});
		
		Label labelG = new Label(panelMiddle, SWT.NONE);
		labelG.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelG.setText("[G]"); //$NON-NLS-1$
		labelValueG = new Label(panelMiddle, SWT.NONE);
		labelValueG.setAlignment(SWT.CENTER);
		final GridData gdLabelValueG = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gdLabelValueG.widthHint = 20;
		labelValueG.setLayoutData(gdLabelValueG);
		labelValueG.setText(Integer.toString(rgbNew.green));
		scaleG = new Scale(panelMiddle, SWT.NO_FOCUS);
		scaleG.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		scaleG.setMinimum(0);
		scaleG.setMaximum(255);
		scaleG.setSelection(rgbNew.green);
		scaleG.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				rgbNew.green = scaleG.getSelection();
				labelValueG.setText(Integer.toString(rgbNew.green));
				colorCanvas.redraw();
			}
		});
		scaleG.addFocusListener(new FocusAdapter()
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
}
