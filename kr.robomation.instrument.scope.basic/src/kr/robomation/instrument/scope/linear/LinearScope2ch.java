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

import java.util.ArrayList;
import java.util.List;

import kr.robomation.instrument.scope.basic.Activator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.roboid.core.component.RoboidComponent;
import org.roboid.robot.Roboid;
import org.roboid.ui.dashboard.AbstractDashboard;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 */
public class LinearScope2ch extends RoboidComponent
{
	private Panel panel;
	private ControlPanel controller;
	private String name;
	private List<Integer> chanA, chanB;
	
	public LinearScope2ch()
	{
	}

	@Override
	public void initialize(Roboid roboid)
	{
		name = getId() + roboid.getName();
		controller = new ControlPanel(name);
		controller.start();
	}

	@Override
	public void activate()
	{
		controller.show();
	}

	@Override
	public void deactivate()
	{
	}

	int frame;
	@Override
	public void execute()
	{
		frame++;
		chanA.remove(0);
		chanA.add(new Integer(frame%100));
		chanB.remove(0);
		chanB.add(new Integer(frame%100));
		controller.update();
	}

	@Override
	public void dispose()
	{
		controller.dispose();
	}

	/**
	 * Inner class for control panel GUI
	 */
	class ControlPanel extends AbstractDashboard
	{
//		private int frame;
		
		public ControlPanel(String title)
		{
			super(title, SWT.DIALOG_TRIM, Activator.getDefault());
		}
		
		@Override
		protected void createContents(Shell shell)
		{
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
			panel = new Panel(shell);
		}
		
		public void update()
		{
//			frame++;
//			if(frame%4 != 0) return;
			
			if(isDisposed()) return;
			getDisplay().syncExec(new Runnable()
			{
				public void run()
				{
					Canvas canvas = panel.getCanvas();
					if(canvas != null && !canvas.isDisposed()) canvas.redraw();
				}
			});
		}

		public void show()
		{
			if(isDisposed()) return;
			getDisplay().asyncExec(new Runnable()
			{
				public void run()
				{
					if(getShell() == null || getShell().isDisposed()) return;
					getShell().forceActive();
				}
			});		
		}
	}
	
	public class Panel
	{
		public static final int width = 500, height = 400;
		Color colorA = ResourceManager.getColor(255, 255, 0);
		Color colorB = ResourceManager.getColor(255, 0, 255);

		private Canvas canvas;
		private Label timedivLabel;
		private Combo timeDiv;
		private Label positionLabel;
		private Slider position;
		private Label probeLabel;
		private Combo probeA;
		private Combo scaleA;
		private Combo probeB;
		private Combo scaleB;
		private Button startButton;
		private Button stopButton;
		private Image scope;
//		private List chanA, chanB;

		/**
		 * Create the composite
		 * @param parent
		 * @param style
		 */
		public Panel(final Shell shell)
		{
			// create canvas for scope with SWT.NO_BACKGROUND option
			canvas = new Canvas(shell, SWT.BORDER | SWT.NO_BACKGROUND);
			final GridData gd_canvas = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 4);
			gd_canvas.heightHint = height;
			gd_canvas.widthHint = width;
			canvas.setLayoutData(gd_canvas);
			canvas.setBackground(ResourceManager.getColor(64, 64, 64));

			Group timedivGroup = new Group(shell, SWT.NONE);
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

			Group aChannelGroup = new Group(shell, SWT.NONE);
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

			Label voltsdivLabel = new Label(aChannelGroup, SWT.NONE);
			voltsdivLabel.setText("Scale");

			scaleA = new Combo(aChannelGroup, SWT.NONE);
			scaleA.setItems(new String[] {"x 1", "x 2", "x 5", "x 10"});
			scaleA.select(0);
			final GridData gd_scaleA = new GridData(SWT.FILL, SWT.CENTER, true, false);
			scaleA.setLayoutData(gd_scaleA);

			Group bChannelGroup = new Group(shell, SWT.NONE);
			bChannelGroup.setText("B Channel");
			final GridData gd_bChannelGroup = new GridData(SWT.FILL, SWT.TOP, true, false);
			gd_bChannelGroup.heightHint = 90;
			bChannelGroup.setLayoutData(gd_bChannelGroup);
			bChannelGroup.setLayout(new GridLayout());

			Label probeLabel_1 = new Label(bChannelGroup, SWT.NONE);
			final GridData gd_probeLabel_1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
			probeLabel_1.setLayoutData(gd_probeLabel_1);
			probeLabel_1.setText("Probe");

			probeB = new Combo(bChannelGroup, SWT.NONE);
			final GridData gd_probeB = new GridData(SWT.FILL, SWT.CENTER, true, false);
			probeB.setLayoutData(gd_probeB);

			Label voltsdivLabel_1 = new Label(bChannelGroup, SWT.NONE);
			voltsdivLabel_1.setText("Scale");

			scaleB = new Combo(bChannelGroup, SWT.NONE);
			scaleB.setItems(new String[] {"x 1", "x 2", "x 5", "x 10"});
			scaleB.select(0);
			final GridData gd_scaleB = new GridData(SWT.FILL, SWT.CENTER, true, false);
			scaleB.setLayoutData(gd_scaleB);

			Group optionGroup = new Group(shell, SWT.NONE);
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
			if(scope == null)
				scope = new Image(shell.getDisplay(), width, height);
			drawScope();
			canvas.addPaintListener(new  PaintListener()
			{
				@Override
				public void paintControl(PaintEvent e)
				{
					GC gc = e.gc;
					Image buffer = new Image(shell.getDisplay(), scope, 0);
					drawWaveForm(buffer);
					gc.drawImage(buffer, 0, 0);
					buffer.dispose();
				}	
			});
			
			chanA = new ArrayList<Integer>();
			chanB = new ArrayList<Integer>();
			for(int i = 0; i < 501; i++)
			{
				chanA.add(new Integer(i % 100));
				chanB.add(new Integer(i % 100));
			}
		}
		
		public Image drawScope()
		{
			GC gc = new GC(scope);
			gc.setBackground(ResourceManager.getColor(64, 64, 64 ));
			gc.fillRectangle(scope.getBounds());
			gc.setForeground(ResourceManager.getColor(128, 128, 128));
			//
			for(int i = 0; i < 51; i++)	//Horizontal
			{
				int tick = i * 10;
				gc.drawLine(tick, 0, tick, 3);
				gc.drawLine(tick, height, tick, height - 4);
				gc.drawLine(tick, height/2 + 1, tick, height/2 - 1);
			}
			for(int i = 0; i < 51; i++) //Vertical
			{
				int tick = i * 10;
				gc.drawLine(0, tick, 3, tick);
				gc.drawLine(width, tick, width - 4, tick);
				gc.drawLine(width/2 + 1, tick, width/2 - 1, tick);
			}
			for(int j = 0; j < 10; j++)
			{
				for(int k = 0; k < height/10; k++)
				{
					int tick = j * 50;
					gc.drawPoint(tick, k * 10);					
				}
			}
			for(int j = 0; j < 10; j++)
			{
				for(int k = 0; k < width/10; k++)
				{
					int tick = j * 50;
					gc.drawPoint(k * 10, tick);					
				}
			}
			gc.dispose();
			return scope;
		}
		

		public Image drawWaveForm(Image buffer)
		{
			GC gc = new GC(buffer);
//			gc.setAlpha(175);
			
			//chan_A
			gc.setForeground(colorA);
			for(int i = chanA.size() - width; i < chanA.size(); i++)
			{
				int v2 = (-1)*((Integer)chanA.get(i)).intValue() + height/2;
				int v1;

				if(i == 0) v1 = v2;
				else v1 = (-1)*((Integer)chanA.get(i-1)).intValue() + height/2;
				
				int r1 = (int)(Math.random()*2);
				int r2 = (int)(Math.random()*2);
				gc.drawLine(i, v1+r1, i, v2-r2);
				gc.drawPoint(i, v1);
			}
			
			//chan_B
			gc.setForeground(colorB);
			for(int i = 0; i < width; i++)
			{
				int v2 = (-1)*((Integer)chanB.get(i)).intValue() + height;
				int v1;

				if(i == 0) v1 = v2;
				else v1 = (-1)*((Integer)chanB.get(i-1)).intValue() + height;
				
				int r1 = (int)(Math.random()*2);
				int r2 = (int)(Math.random()*2);
				gc.drawLine(i, v1+r1, i, v2-r2);
				gc.drawPoint(i, v1);
			}
			
			gc.dispose();
			return buffer;
		}
		
		public Canvas getCanvas()
		{
			return canvas;
		}
	}
}
