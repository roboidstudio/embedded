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

package kr.robomation.instrument.scope.linear;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 */
public class Panel
{
	private Button startButton;
	private Button stopButton;
	private Group optionGroup;
	private Combo scaleB;
	private Label voltsdivLabel_1;
	private Combo probeB;
	private Label probeLabel_1;
	private Combo scaleA;
	private Label voltsdivLabel;
	private Combo probeA;
	private Label probeLabel;
	private Label positionLabel;
	private Label timedivLabel;
	private Slider position;
	private Combo timeDiv;
	private Group aChannelGroup;
	private Group bChannelGroup;
	private Group timedivGroup;
	private Canvas canvas;
	protected Shell shell;

	/**
	 * Open the window
	 */
	public void open()
	{
		final Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents()
	{
		shell = new Shell(SWT.DIALOG_TRIM);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 14;
		gridLayout.marginBottom = 5;
		gridLayout.marginTop = 5;
		gridLayout.marginLeft = 5;
		gridLayout.marginRight = 5;
		gridLayout.numColumns = 2;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		shell.setLayout(gridLayout);
		shell.setSize(674, 446);
		shell.setText("Oscilloscope 2CH");

		canvas = new Canvas(shell, SWT.BORDER);
		final GridData gd_canvas = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 4);
		gd_canvas.heightHint = 400;
		gd_canvas.widthHint = 500;
		canvas.setLayoutData(gd_canvas);
		canvas.setBackground(ResourceManager.getColor(64, 64, 64));

		timedivGroup = new Group(shell, SWT.NONE);
		timedivGroup.setText("Horizontal");
		final GridData gd_timedivGroup = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd_timedivGroup.heightHint = 87;
		timedivGroup.setLayoutData(gd_timedivGroup);
		timedivGroup.setLayout(new GridLayout());

		timedivLabel = new Label(timedivGroup, SWT.NONE);
		timedivLabel.setText("Time/Div");

		timeDiv = new Combo(timedivGroup, SWT.NONE);
		timeDiv.setSelection(new Point(0, 2));
		timeDiv.setToolTipText("Select time/division");
		timeDiv.setItems(new String[] {"5 sec", "2.5 sec", "1.0 sec", "500 msec", "250 msec", "100 msec"});
		timeDiv.select(2);
		final GridData gd_timeDiv = new GridData(SWT.FILL, SWT.CENTER, true, false);
		timeDiv.setLayoutData(gd_timeDiv);

		positionLabel = new Label(timedivGroup, SWT.NONE);
		positionLabel.setText("Position: ");

		position = new Slider(timedivGroup, SWT.NONE);
		final GridData gd_position = new GridData(SWT.FILL, SWT.CENTER, true, false);
		position.setLayoutData(gd_position);

		aChannelGroup = new Group(shell, SWT.NONE);
		aChannelGroup.setText("A Channel");
		final GridData gd_aChannelGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_aChannelGroup.heightHint = 90;
		aChannelGroup.setLayoutData(gd_aChannelGroup);
		aChannelGroup.setLayout(new GridLayout());

		probeLabel = new Label(aChannelGroup, SWT.NONE);
		final GridData gd_probeLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
		probeLabel.setLayoutData(gd_probeLabel);
		probeLabel.setText("Probe");

		probeA = new Combo(aChannelGroup, SWT.NONE);
		final GridData gd_probeA = new GridData(SWT.FILL, SWT.CENTER, true, false);
		probeA.setLayoutData(gd_probeA);

		voltsdivLabel = new Label(aChannelGroup, SWT.NONE);
		voltsdivLabel.setText("Scale");

		scaleA = new Combo(aChannelGroup, SWT.NONE);
		scaleA.setItems(new String[] {"x 1", "x 2", "x 5", "x 10"});
		scaleA.select(0);
		final GridData gd_scaleA = new GridData(SWT.FILL, SWT.CENTER, true, false);
		scaleA.setLayoutData(gd_scaleA);

		bChannelGroup = new Group(shell, SWT.NONE);
		bChannelGroup.setText("B Channel");
		final GridData gd_bChannelGroup = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd_bChannelGroup.heightHint = 90;
		bChannelGroup.setLayoutData(gd_bChannelGroup);
		bChannelGroup.setLayout(new GridLayout());

		probeLabel_1 = new Label(bChannelGroup, SWT.NONE);
		final GridData gd_probeLabel_1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		probeLabel_1.setLayoutData(gd_probeLabel_1);
		probeLabel_1.setText("Probe");

		probeB = new Combo(bChannelGroup, SWT.NONE);
		final GridData gd_probeB = new GridData(SWT.FILL, SWT.CENTER, true, false);
		probeB.setLayoutData(gd_probeB);

		voltsdivLabel_1 = new Label(bChannelGroup, SWT.NONE);
		voltsdivLabel_1.setText("Scale");

		scaleB = new Combo(bChannelGroup, SWT.NONE);
		scaleB.setItems(new String[] {"x 1", "x 2", "x 5", "x 10"});
		scaleB.select(0);
		final GridData gd_scaleB = new GridData(SWT.FILL, SWT.CENTER, true, false);
		scaleB.setLayoutData(gd_scaleB);

		optionGroup = new Group(shell, SWT.NONE);
		optionGroup.setText("Recorder");
		final GridData gd_optionGroup = new GridData(SWT.FILL, SWT.TOP, true, true);
		gd_optionGroup.heightHint = 35;
		optionGroup.setLayoutData(gd_optionGroup);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 2;
		optionGroup.setLayout(gridLayout_1);

		startButton = new Button(optionGroup, SWT.TOGGLE);
		startButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		startButton.setText("start");

		stopButton = new Button(optionGroup, SWT.TOGGLE);
		stopButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		stopButton.setText("stop");
		new Label(shell, SWT.NONE);
		//
	}

}
