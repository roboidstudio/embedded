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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author Kwang-Hyun Park
 */
public class MatrixDialog extends Dialog
{
	private Shell shell;
	private Composite matrix; // LED 매트릭스
	private Button checkShowValue; // 값 보이기 체크박스
	private Text textValue; // LED 값 텍스트 에디터
	private int[] currentValues; // 현재 LED 값들. 화면에 표시하기 위한 임시 값들
	private int[] finalValues; // 최종 결정된 LED 값들. '완료' 버튼을 눌렀을 때만 만든다. 취소인 경우에는 null 값
	private int row; // LED 매트릭스의 행 수
	private int column; // LED 매트릭스의 열 수
	private int minValue; // LED 값의 최소값
	private int maxValue; // LED 값의 최대값
	private boolean LBUTTON_DOWN; // 왼쪽 마우스 버튼이 눌러졌다.
	private boolean RBUTTON_DOWN; // 마우스 오른쪽 버튼이 눌러졌다.
	private final int LED_SIZE = 10; // 화면에서 LED의 크기
	private final int LED_MARGIN = 5; // 화면에서 LED와 LED 사이의 간격
	private final int CELL_SIZE = LED_SIZE + 2 * LED_MARGIN;

	public MatrixDialog(Shell parent, int style, int row, int column, int minValue, int maxValue, int initValue)
	{
		super(parent, style);
		this.row = row;
		this.column = column;
		this.minValue = minValue;
		this.maxValue = maxValue;
		// row와 column에 따라 배열 생성
		currentValues = new int[row*column];
		// 배열을 주어진 값으로 채운다.
		for(int i = 0; i < row*column; i ++)
			currentValues[i] = initValue;
	}
	
	public MatrixDialog(Shell parent, int row, int column, int minValue, int maxValue, int initValue)
	{
		this(parent, SWT.NONE, row, column, minValue, maxValue, initValue);
	}
	
	public MatrixDialog(Shell parent, int style, int row, int column, int minValue, int maxValue, int[] initValues)
	{
		this(parent, style, row, column, minValue, maxValue, 0);
		// 배열을 주어진 값으로 채운다.
		for(int i = 0; i < row*column && i < initValues.length; i ++)
			this.currentValues[i] = initValues[i];
	}
	
	public MatrixDialog(Shell parent, int row, int column, int minValue, int maxValue, int[] initValues)
	{
		this(parent, SWT.NONE, row, column, minValue, maxValue, initValues);
	}
	
	// 대화창을 연다.
	public int[] open() throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		// 대화창의 내부 위젯들을 만든다.
		createContents();
		// 대화창의 위치를 가운데로 한다.
		Display display = getParent().getDisplay();
		shell.setLocation((display.getBounds().width - shell.getBounds().width) / 2, (display.getBounds().height - shell.getBounds().height) / 2);
		// 대화창을 연다.
		shell.open();

		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) display.sleep();
		}
		return finalValues;
	}
	
	// 마우스 커서의 x, y 위치로부터 LED의 인덱스를 계산한다.
	private int getLedIndex(int x, int y)
	{
		int index = -1;
		int x1 = (x - LED_MARGIN) / CELL_SIZE * CELL_SIZE + LED_MARGIN;
		int y1 = (y - LED_MARGIN) / CELL_SIZE * CELL_SIZE + LED_MARGIN;
		if(x1 < LED_MARGIN || x1 >= column * CELL_SIZE + LED_MARGIN || y1 < LED_MARGIN || y1 >= row * CELL_SIZE + LED_MARGIN)
			return -1;
		if(x > x1 && x < x1 + LED_SIZE + LED_MARGIN && y > y1 && y < y1 + LED_SIZE + LED_MARGIN)
			index = y / CELL_SIZE * column + x / CELL_SIZE;
		
		return index;
	}
	
	// 텍스트 에디터에서 값을 읽어 LED 값을 얻는다.
	private int getLedValue()
	{
		int val = 0;
		try
		{
			val = Integer.parseInt(textValue.getText());
			if(val < minValue) val = minValue;
			if(val > maxValue) val = maxValue;
		} catch (Exception e)
		{}
		
		return val;
	}
	
	// 대화창의 내부 위젯들을 만든다.
	protected void createContents() throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		shell = new Shell(getParent(), SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		shell.setText(Messages.MatrixDialog_MatrixEditor);
		shell.setLayout(new FillLayout());
		
		Composite composite = new Composite(shell, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginLeft = LED_MARGIN;
		gridLayout.marginTop = LED_MARGIN;
		composite.setLayout(gridLayout);
		
		matrix = new Composite(composite, SWT.DOUBLE_BUFFERED);
		matrix.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDown(MouseEvent e)
			{
				int index = getLedIndex(e.x, e.y);
				if(index >= 0 && index < row*column)
				{
					if(e.button == 1) // 마우스 왼쪽 버튼을 눌렀을 때
					{
						currentValues[index] = getLedValue();
						LBUTTON_DOWN = true;
					}
					else if(e.button == 3) // 마우스 오른쪽 버튼을 눌렀을 때
					{
						currentValues[index] = minValue;
						RBUTTON_DOWN = true;
					}
					matrix.redraw();
				}
			}

			@Override
			public void mouseUp(MouseEvent e)
			{
				super.mouseUp(e);
				LBUTTON_DOWN = false;
				RBUTTON_DOWN = false;
			}
		});
		matrix.addMouseMoveListener(new MouseMoveListener()
		{
			@Override
			public void mouseMove(MouseEvent e)
			{
				// 마우스 왼쪽 버튼을 누른 채로 움직이면 움직인 경로에 있는 모든 LED를 LED 값으로 채운다.
				if(LBUTTON_DOWN)
				{
					int index = getLedIndex(e.x, e.y);
					if(index >= 0 && index < row*column)
					{
						currentValues[index] = getLedValue();
						matrix.redraw();
					}
				}
				// 마우스 오른쪽 버튼을 누른 채로 움직이면 움직인 경로에 있는 모든 LED를 지운다.
				else if(RBUTTON_DOWN)
				{
					int index = getLedIndex(e.x, e.y);
					if(index >= 0 && index < row*column)
					{
						currentValues[index] = minValue;
						matrix.redraw();
					}
				}
			}
		});
		matrix.addPaintListener(new PaintListener()
		{
			// LED 매트릭스 화면을 다시 그린다.
			@Override
			public void paintControl(PaintEvent e)
			{
				int widthBound = column * CELL_SIZE + 5;
				int heightBound = row * CELL_SIZE + 5;
				
				// 배경은 검은색으로 칠한다.
				e.gc.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
				e.gc.fillRectangle(0, 0, widthBound, heightBound);
				
				int index = 0;
				for(int y = 5; y < heightBound; y += CELL_SIZE)
				{
					for(int x = 5; x < widthBound; x += CELL_SIZE)
					{
						// LED 값에 따라 색상을 결정한다.
						Color color = null;
						if(currentValues[index] == minValue || minValue == maxValue)
							color = new Color(null, 70, 70, 70);
						else
						{
							int r = (currentValues[index] - minValue) * 63 / (maxValue - minValue) + 192;
							if(r < 0) r = 0;
							else if(r > 255) r = 255;
							int gb = 192 - (currentValues[index] - minValue) * 192 / (maxValue - minValue);
							if(gb < 0) gb = 0;
							else if(gb > 255) gb = 255;
							color = new Color(null, r, gb, gb);
						}
						// LED를 그린다.
						e.gc.setBackground(color);
						e.gc.fillOval(x, y, 15, 15);
						if(color != null) color.dispose();
						// 값 보이기가 체크된 경우에는 LED 값도 표시한다.
						if(checkShowValue.getSelection())
						{
							e.gc.setForeground(shell.getDisplay().getSystemColor(SWT.COLOR_YELLOW));
							e.gc.drawString(Integer.toString(currentValues[index]), x, y, true);
						}
						index ++;
					}
				}
			}
		});
		final GridData gd_matrix = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gd_matrix.widthHint = column * CELL_SIZE + 10;
		gd_matrix.heightHint = row * CELL_SIZE + 10;
		matrix.setLayoutData(gd_matrix);
		
		// LED 매트릭스 오른쪽에 있는 패널
		Composite panel = new Composite(composite, SWT.NONE);
		final GridLayout gl_panel = new GridLayout();
		gl_panel.marginWidth = 0;
		gl_panel.marginHeight = 0;
		gl_panel.marginRight = 5;
		gl_panel.marginBottom = 5;
		panel.setLayout(gl_panel);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 0, 0));
		
		// 패널 윗쪽
		Composite panelTop = new Composite(panel, SWT.NONE);
		final GridLayout gl_panelTop = new GridLayout();
		gl_panelTop.numColumns = 2;
		gl_panelTop.marginWidth = 0;
		gl_panelTop.marginHeight = 0;
		panelTop.setLayout(gl_panelTop);
		panelTop.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 0, 0));
		
		// LED 값 텍스트 에디터
		Label labelValue = new Label(panelTop, SWT.NONE);
		labelValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelValue.setText(Messages.MatrixDialog_Value + ":"); //$NON-NLS-1$
		textValue = new Text(panelTop, SWT.BORDER);
		textValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textValue.setText(Integer.toString(maxValue));
		
		new Label(panelTop, SWT.NONE);
		
		// 값 보이기 체크 박스
		checkShowValue = new Button(panelTop, SWT.CHECK);
		checkShowValue.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				matrix.redraw();
			}
		});
		checkShowValue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		checkShowValue.setText(Messages.MatrixDialog_ShowValue);
		
		new Label(panelTop, SWT.NONE);
		
		// 리셋 버튼
		Button buttonReset = new Button(panelTop, SWT.NONE);
		buttonReset.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// 리셋 버튼을 누르면 최소값으로 채운다.
				currentValues = new int[row*column];
				for(int i = 0; i < row*column; i ++)
					currentValues[i] = minValue;
				matrix.redraw();
			}
		});
		buttonReset.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		buttonReset.setText(Messages.MatrixDialog_Reset);
		
		// 패널 아래쪽
		Composite panelBottom = new Composite(panel, SWT.NONE);
		final GridLayout gl_panelBottom = new GridLayout();
		gl_panelBottom.numColumns = 2;
		gl_panelBottom.marginWidth = 0;
		gl_panelBottom.marginHeight = 0;
		panelBottom.setLayout(gl_panelBottom);

		// 완료 버튼
		Button buttonFinish = new Button(panelBottom, SWT.NONE);
		buttonFinish.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// FINISH 버튼 클릭 시
				finalValues = new int[row*column];
				System.arraycopy(currentValues, 0, finalValues, 0, row*column);
				shell.close();
			}
		});
		final GridData gd_finishButton = new GridData(SWT.RIGHT, SWT.FILL, false, true);
		gd_finishButton.widthHint = 90;
		buttonFinish.setLayoutData(gd_finishButton);
		buttonFinish.setText(Messages.Common_OK);

		// 취소 버튼
		Button buttonCancel = new Button(panelBottom, SWT.NONE);
		buttonCancel.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// 취소 클릭시 
				shell.close();
			}
		});
		final GridData gd_cancelButton = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gd_cancelButton.widthHint = 90;
		buttonCancel.setLayoutData(gd_cancelButton);
		buttonCancel.setText(Messages.Common_Cancel);
		
		shell.pack();
	}
}
