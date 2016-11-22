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

package kr.robomation.instrument.scope.event;

import java.util.ArrayList;
import java.util.List;

import kr.robomation.instrument.scope.basic.Activator;
import kr.robomation.instrument.scope.basic.IntList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.roboid.core.component.IComponent;
import org.roboid.core.component.SystemComponent;
import org.roboid.core.component.activity.SystemActivity;
import org.roboid.core.component.proxy.AbstractComponentProxy;
import org.roboid.core.runtime.ContentChangeListener;
import org.roboid.core.runtime.ContentsManager;
import org.roboid.core.runtime.IClip;
import org.roboid.robot.Command;
import org.roboid.robot.DataType;
import org.roboid.robot.Device;
import org.roboid.robot.Event;
import org.roboid.robot.Robot;
import org.roboid.ui.dashboard.AbstractDashboard;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class EventScope extends SystemComponent
{
	private Robot robot;
	private List<Device> deviceList;
	private IntList dataSequence = new IntList();
	private Device selectedDevice;
	private int indexOfData; // index of a data array of the selected device
	private ControlPanel dashboard;
	private boolean INITIALIZED = false;
	private String preferenceKey = "";
	private ContentChangeListener contentListener = new ContentChangeListener()
	{
		@Override
		public void contentChanged(IClip oldContent, IClip newContent)
		{
			preferenceKey = getPreferenceKey(newContent);
			if(dashboard != null && !dashboard.isDisposed()) dashboard.refresh();
		}
	};
	
	public EventScope()
	{
	}

	private String getPreferenceKey(IClip content)
	{
		StringBuilder sb = new StringBuilder(getId());
		sb.append(".");
		int index = 0;
		if(content != null)
		{
			sb.append(content.getResource().getURI().toString());
			for(SystemActivity activity : content.getActivity().getSystems())
			{
				AbstractComponentProxy proxy = (AbstractComponentProxy)activity.getSelectedComponent();
				if(proxy != null)
				{
					IComponent component = proxy.getComponent();
					if(component != null)
					{
						if(component == this)
							break;
					}
				}
				index ++;
			}
		}
		sb.append(index);
		return sb.toString();
	}
	
	@Override
	public void initialize(Robot robot)
	{
		this.robot = robot;

		deviceList = new ArrayList<Device>();
		List<Device> devices = new ArrayList<Device>();
		robot.collectAllDevices(devices);
		for(Device device : devices)
		{
			if(device instanceof Command || device instanceof Event)
			{
				DataType type = device.getDataType();
				if(type == DataType.BYTE || type == DataType.SHORT || type == DataType.INTEGER || type == DataType.FLOAT)
					deviceList.add(device);
			}
		}
		
		ContentsManager.addContentChangeListener(contentListener);
		preferenceKey = getPreferenceKey(ContentsManager.getCurrentContent());
		
		INITIALIZED = true;
		dashboard = new ControlPanel(getId() + robot.getName());
		dashboard.start();
	}
	
	@Override
	public void dispose()
	{
		ContentsManager.removeContentChangeListener(contentListener);
		if(!INITIALIZED) return;
		dashboard.dispose();
	}

	@Override
	public void activate()
	{
		if(!INITIALIZED) return;
		dataSequence = new IntList();
		dashboard.activate();
	}

	@Override
	public void deactivate()
	{
	}

	@Override
	public void execute()
	{
		if(!INITIALIZED) return;

		if(selectedDevice != null)
		{
			int offData = 0, onData = 1;
			if(indexOfData < selectedDevice.getDataSize())
			{
				offData = selectedDevice.getDefault();
				onData = selectedDevice.read(indexOfData);
			}
			
			if(selectedDevice.e())
				dataSequence.setLast(offData);
			dataSequence.add(onData);
		}

		dashboard.update();
	}

	/**
	 * Inner class for control panel GUI
	 */
	class ControlPanel extends AbstractDashboard
	{
		private Panel panel;
		private int frame;
		
		public ControlPanel(String title)
		{
			super(preferenceKey, SWT.TITLE|SWT.BORDER, Activator.getDefault());
			this.setDaemon(true);
		}
		
		@Override
		protected void createContents(Shell shell)
		{
			final GridLayout gridLayout = new GridLayout();
			gridLayout.marginBottom = 5;
			gridLayout.marginTop = 5;
			gridLayout.marginLeft = 5;
			gridLayout.marginRight = 5;
			gridLayout.numColumns = 2;
			gridLayout.marginWidth = 0;
			gridLayout.marginHeight = 0;
			shell.setLayout(gridLayout);
			shell.setSize(575, 256);
			shell.setText("Command/Event Scope | " + robot.getName());
			panel = new Panel(this, shell);
		}
		
		public void update()
		{
			if(++frame % 2 != 0) return;
			
			if(isDisposed()) return;
			getDisplay().asyncExec(new Runnable()
			{
				public void run()
				{
					Canvas canvas = panel.getCanvas();
					if(canvas != null && !canvas.isDisposed()) canvas.redraw();
				}
			});
		}

		public void activate()
		{
			if(isDisposed()) return;
			getDisplay().asyncExec(new Runnable()
			{
				public void run()
				{
					if(getShell() == null || getShell().isDisposed()) return;
					panel.getSlider().setSelection(0);
					getShell().forceActive();
				}
			});		
		}
		
		public void refresh()
		{
			if(getDisplay() != null)
			{
				getDisplay().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						if(panel != null)
							panel.refresh(ControlPanel.this);
					}
				});
			}
		}
		
		class Panel
		{
			private static final int WIDTH = 400, HEIGHT = 200;
			private static final int UP = 5;
			private static final int CENTER = 105;
			private static final int DOWN = 205;
			private static final int BOTTOM = 210;
			
			private Color beamColor = ResourceManager.getColor(255,255,255); //(64, 64, 64);
			private Color backColor = ResourceManager.getColor(64, 64, 64); //(255, 255, 235);
			private Canvas canvas;
			private Combo comboTimeDiv;
			private Combo comboProbe;
			private Label labelPosition;
			private Slider sliderPosition;
			private Combo comboData;
			private Combo comboScale;
			private Image image;
			
			private int mode = 0;
			private int[] values = new int[WIDTH];
			private int scaleFactor = 1;
			private int timeFactor = 1;

			/**
			 * Create the composite
			 * @param parent
			 * @param style
			 */
			public Panel(final ControlPanel parent, final Shell shell)
			{
				// create canvas for scope with SWT.NO_BACKGROUND option
				canvas = new Canvas(shell, SWT.BORDER | SWT.NO_BACKGROUND|SWT.DOUBLE_BUFFERED);
				canvas.setBackground(backColor);
				final GridData gdCanvas = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 3);
				gdCanvas.heightHint = 210;
				gdCanvas.widthHint = 400;
				canvas.setLayoutData(gdCanvas);

				Group groupHorizontal = new Group(shell, SWT.NONE);
				groupHorizontal.setText("Horizontal");
				groupHorizontal.setLayout(new GridLayout());
				groupHorizontal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

				Label labelTimeDiv = new Label(groupHorizontal, SWT.NONE);
				labelTimeDiv.setText("Time/Div");

				comboTimeDiv = new Combo(groupHorizontal, SWT.NONE);
				comboTimeDiv.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				comboTimeDiv.setItems(new String[] {"1.0 sec", "2.0 sec", "5.0 sec", "10 sec", "20 sec", "50 sec"});
				final int[] timeFactors = new int[]{1, 2, 5, 10, 20, 50};
				int index = parent.getPreferenceInt(preferenceKey + ".timediv");
				if(index < 0 || index >= timeFactors.length)
					index = 0;
				comboTimeDiv.select(index);
				timeFactor = timeFactors[index];
				comboTimeDiv.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						timeFactor = timeFactors[comboTimeDiv.getSelectionIndex()];
						canvas.redraw();
						parent.setPreferenceValue(preferenceKey + ".timediv", comboTimeDiv.getSelectionIndex());
						parent.savePreference();
					}
				});

				labelPosition = new Label(groupHorizontal, SWT.NONE);
				final GridData gdPosition = new GridData(SWT.FILL, SWT.CENTER, false, false);
				gdPosition.widthHint = 126;
				labelPosition.setLayoutData(gdPosition);

				sliderPosition = new Slider(groupHorizontal, SWT.NONE);
				final GridData gdSlider = new GridData(SWT.FILL, SWT.CENTER, false, false);
				gdSlider.widthHint = 126;
				sliderPosition.setLayoutData(gdSlider);
				sliderPosition.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						canvas.redraw();
					}				
				});

				Group groupChannel = new Group(shell, SWT.NONE);
				final GridLayout glChannelGroup = new GridLayout();
				glChannelGroup.horizontalSpacing = 10;
				glChannelGroup.verticalSpacing = 3;
				glChannelGroup.numColumns = 2;
				groupChannel.setLayout(glChannelGroup);
				groupChannel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				groupChannel.setText("Channel");
				
				Label labelProbe = new Label(groupChannel, SWT.NONE);
				labelProbe.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
				labelProbe.setText("Probe");

				comboProbe = new Combo(groupChannel, SWT.NONE);
				comboProbe.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
				comboProbe.removeAll();
				for(Device device : deviceList)
					comboProbe.add(device.getFullName());
				if(!deviceList.isEmpty())
				{
					index = parent.getPreferenceInt(preferenceKey + ".device");
					if(index < 0 || index >= deviceList.size())
						index = 0;
					comboProbe.select(index);
					selectedDevice = deviceList.get(index);
				}
				comboProbe.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						selectedDevice = deviceList.get(comboProbe.getSelectionIndex());
						dataSequence = new IntList();
						comboData.removeAll();
						for(int i = 0; i < selectedDevice.getDataSize(); i ++)
							comboData.add(String.valueOf(i));
						comboData.select(0);
						indexOfData = 0;
						
						drawScope();
						
						parent.setPreferenceValue(preferenceKey + ".device", comboProbe.getSelectionIndex());
						parent.savePreference();
					}
				});
				
				Label labelData = new Label(groupChannel, SWT.NONE);
				labelData.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));
				labelData.setText("Data");

				Label labelScale = new Label(groupChannel, SWT.NONE);
				labelScale.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
				labelScale.setText("Scale");

				comboData = new Combo(groupChannel, SWT.NONE);
				final GridData gdData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
				gdData.widthHint = 45;
				comboData.setLayoutData(gdData);
				comboData.removeAll();
				if(selectedDevice != null)
				{
					for(int i = 0; i < selectedDevice.getDataSize(); i++)
						comboData.add(String.valueOf(i));
					indexOfData = parent.getPreferenceInt(preferenceKey + ".data");
					if(indexOfData < 0 || indexOfData >= comboData.getItemCount())
						indexOfData = 0;
					comboData.select(indexOfData);
				}
				comboData.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						indexOfData = comboData.getSelectionIndex();
						parent.setPreferenceValue(preferenceKey + ".data", comboData.getSelectionIndex());
						parent.savePreference();
					}
				});

				comboScale = new Combo(groupChannel, SWT.NONE);
				final GridData gdScale = new GridData(SWT.FILL, SWT.CENTER, true, false);
				gdScale.widthHint = 45;
				comboScale.setLayoutData(gdScale);
				comboScale.setItems(new String[] {"x 1", "x 2", "x 5", "x 10"});
				final int[] scales = new int[]{1, 2, 5, 10};
				index = parent.getPreferenceInt(preferenceKey + ".scale");
				if(index < 0 || index >= scales.length)
					index = 0;
				comboScale.select(index);
				scaleFactor = scales[index];
				comboScale.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						scaleFactor = scales[comboScale.getSelectionIndex()];
						canvas.redraw();
						parent.setPreferenceValue(preferenceKey + ".scale", comboScale.getSelectionIndex());
						parent.savePreference();
					}
				});

				if(image == null) image = new Image(shell.getDisplay(), 400, 210);
				drawScope();
				canvas.addPaintListener(new PaintListener()
				{
					@Override
					public void paintControl(PaintEvent e)
					{
						GC gc = e.gc;
						Image buffer = new Image(shell.getDisplay(), image, 0);
						int onCanvas = buildWaveForm();
						drawWaveForm(buffer, onCanvas);
						gc.drawImage(buffer, 0, 0);
						buffer.dispose();
					}
				});
				shell.addDisposeListener(new DisposeListener()
				{
					@Override
					public void widgetDisposed(DisposeEvent e)
					{
						if(image != null && !image.isDisposed())
							image.dispose();
					}
				});
			}
			
			// 바탕 눈금을 그림
			// 1. 디폴트가 최소와 같은 경우
			// 2. 디폴트가 최소와 최대 사이
			// 3. 디폴트가 최대와 같은 경우
			public Image drawScope()
			{
				mode = 0;
				if(selectedDevice != null)
				{
					if(selectedDevice.getDefault() == selectedDevice.getMin()) mode = 1;
					if(selectedDevice.getDefault() == selectedDevice.getMax()) mode = 2;
				}
				
				GC gc = new GC(image);
				gc.setBackground(backColor);
				gc.fillRectangle(image.getBounds());
				
				// draw base line
				gc.setForeground(ResourceManager.getColor(0, 135, 0));
				if(mode == 0) gc.drawLine(0, CENTER, WIDTH, CENTER);
				else if(mode == 1) gc.drawLine(0, DOWN, WIDTH, DOWN);
				else if(mode == 2) gc.drawLine(0, UP, WIDTH, UP);
				
				// draw tick marks
				gc.setForeground(ResourceManager.getColor(150, 150, 150));
				for(int i = 0; i < WIDTH/10; i++)	//Horizontal
				{
					int tick = i * 10;
					gc.drawLine(tick, 0, tick, 3);
					gc.drawLine(tick, BOTTOM, tick, BOTTOM - 3);
				}
				for(int i = 0; i <= HEIGHT/10; i++) //Vertical
				{
					int tick = i * 10;
					gc.drawLine(0, tick, 3, tick);
					gc.drawLine(WIDTH, tick, WIDTH - 4, tick);
				}
				
				// draw dots
				for(int j = 0; j < 8; j++)
				{
					for(int k = 0; k < HEIGHT/10; k++)
					{
						int tick = j * 50;
						gc.drawPoint(tick, k * 10);					
					}
				}
				for(int j = 0; j < 5; j++)
				{
					for(int k = 0; k < WIDTH/10; k++)
					{
						int tick = j * 50 + 5;
						gc.drawPoint(k * 10, tick);					
					}
				}
				
				gc.dispose();
				return image;
			}
			
			// 입력값에서 디폴트 값을 빼고 스케일을 곱한다.
			// 타임값에 따라 늘리고 줄인다.
			// 시작점을 타임 슬라이더로 이동한다.
			private int buildWaveForm()
			{
				int start = sliderPosition.getSelection();
				start = dataSequence.size() * start / (sliderPosition.getMaximum()-sliderPosition.getThumb());
				float delay = start * 20;
				if(delay != 0.0) delay /= -1000;
				labelPosition.setText("Position: " + delay + " sec");
				
				int onCanvas = 0;
				if(selectedDevice != null)
				{
					for(int i = 0; i < WIDTH; i++)
					{
						int val = selectedDevice.getDefault();
						int size = dataSequence.size();
						int k = (size - 1) - i * timeFactor - start;
						if(k >= 0) val = dataSequence.get(k);
						if(i == 0) onCanvas = val; //get value to display on canvas
						
						// normalize
						val = val - selectedDevice.getDefault();
						int norm = selectedDevice.getMax() - selectedDevice.getDefault();
						if(norm <= 0) norm = 1; // divide-by-zero?
						if(mode == 0) val = val * 100 / norm;
						else val = val * 200 / norm;
						values[WIDTH - 1 - i] = scaleFactor * val; 
					}
				}
				return onCanvas;
			}
			
			public Image drawWaveForm(Image buffer, int onCanvas)
			{
				GC gc = new GC(buffer);
				//gc.setAlpha(200);	
				if(beamColor.isDisposed()) return buffer;
				gc.setForeground(beamColor);
				
				int center = CENTER;
				if(mode == 1) center = DOWN;
				else if(mode == 2) center = UP;
				
				for(int i = 0; i < WIDTH; i++)
				{
					int v2 = (-1)*(values[i]) + center;
					int v1;

					if(i == 0) v1 = v2;
					else v1 = (-1)*(values[i-1]) + center;
					
					int r1 = (int)(Math.random()*2);
					int r2 = (int)(Math.random()*2);
					gc.drawLine(i, v1+r1, i, v2-r2);
					gc.drawPoint(i, v1);
				}
				
				// display data
				String value = "" + onCanvas; //target.read(dataIndex);
				int x = gc.stringExtent(value).x;
				gc.setBackground(backColor);
				gc.drawString(value, WIDTH - 10 - x, 10);

				gc.dispose();
				return buffer;
			}
			
			public Canvas getCanvas()
			{
				return canvas;
			}
			
			public Slider getSlider()
			{
				return sliderPosition;
			}
			
			public void refresh(ControlPanel parent)
			{
				int [] timeFactors = new int[]{1, 2, 5, 10, 20, 50};
				int index = parent.getPreferenceInt(preferenceKey + ".timediv");
				if(index < 0 || index >= timeFactors.length)
					index = 0;
				comboTimeDiv.select(index);
				timeFactor = timeFactors[index];
				
				if(!deviceList.isEmpty())
				{
					index = parent.getPreferenceInt(preferenceKey + ".device");
					if(index < 0 || index >= deviceList.size())
						index = 0;
					comboProbe.select(index);
					selectedDevice = deviceList.get(index);
					
					if(selectedDevice != null)
					{
						comboData.removeAll();
						for(int i = 0; i < selectedDevice.getDataSize(); i++)
							comboData.add(String.valueOf(i));
						indexOfData = parent.getPreferenceInt(preferenceKey + ".data");
						if(indexOfData < 0 || indexOfData >= comboData.getItemCount())
							indexOfData = 0;
						comboData.select(indexOfData);
						
						final int[] scales = new int[]{1, 2, 5, 10};
						index = parent.getPreferenceInt(preferenceKey + ".scale");
						if(index < 0 || index >= scales.length)
							index = 0;
						comboScale.select(index);
						scaleFactor = scales[index];
					}
				}
				
				dataSequence = new IntList();
				drawScope();
				canvas.redraw();
			}
		}
	}
}
