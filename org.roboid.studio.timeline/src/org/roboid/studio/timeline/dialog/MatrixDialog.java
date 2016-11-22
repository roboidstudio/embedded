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
	private Composite matrix; // LED ��Ʈ����
	private Button checkShowValue; // �� ���̱� üũ�ڽ�
	private Text textValue; // LED �� �ؽ�Ʈ ������
	private int[] currentValues; // ���� LED ����. ȭ�鿡 ǥ���ϱ� ���� �ӽ� ����
	private int[] finalValues; // ���� ������ LED ����. '�Ϸ�' ��ư�� ������ ���� �����. ����� ��쿡�� null ��
	private int row; // LED ��Ʈ������ �� ��
	private int column; // LED ��Ʈ������ �� ��
	private int minValue; // LED ���� �ּҰ�
	private int maxValue; // LED ���� �ִ밪
	private boolean LBUTTON_DOWN; // ���� ���콺 ��ư�� ��������.
	private boolean RBUTTON_DOWN; // ���콺 ������ ��ư�� ��������.
	private final int LED_SIZE = 10; // ȭ�鿡�� LED�� ũ��
	private final int LED_MARGIN = 5; // ȭ�鿡�� LED�� LED ������ ����
	private final int CELL_SIZE = LED_SIZE + 2 * LED_MARGIN;

	public MatrixDialog(Shell parent, int style, int row, int column, int minValue, int maxValue, int initValue)
	{
		super(parent, style);
		this.row = row;
		this.column = column;
		this.minValue = minValue;
		this.maxValue = maxValue;
		// row�� column�� ���� �迭 ����
		currentValues = new int[row*column];
		// �迭�� �־��� ������ ä���.
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
		// �迭�� �־��� ������ ä���.
		for(int i = 0; i < row*column && i < initValues.length; i ++)
			this.currentValues[i] = initValues[i];
	}
	
	public MatrixDialog(Shell parent, int row, int column, int minValue, int maxValue, int[] initValues)
	{
		this(parent, SWT.NONE, row, column, minValue, maxValue, initValues);
	}
	
	// ��ȭâ�� ����.
	public int[] open() throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		// ��ȭâ�� ���� �������� �����.
		createContents();
		// ��ȭâ�� ��ġ�� ����� �Ѵ�.
		Display display = getParent().getDisplay();
		shell.setLocation((display.getBounds().width - shell.getBounds().width) / 2, (display.getBounds().height - shell.getBounds().height) / 2);
		// ��ȭâ�� ����.
		shell.open();

		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) display.sleep();
		}
		return finalValues;
	}
	
	// ���콺 Ŀ���� x, y ��ġ�κ��� LED�� �ε����� ����Ѵ�.
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
	
	// �ؽ�Ʈ �����Ϳ��� ���� �о� LED ���� ��´�.
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
	
	// ��ȭâ�� ���� �������� �����.
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
					if(e.button == 1) // ���콺 ���� ��ư�� ������ ��
					{
						currentValues[index] = getLedValue();
						LBUTTON_DOWN = true;
					}
					else if(e.button == 3) // ���콺 ������ ��ư�� ������ ��
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
				// ���콺 ���� ��ư�� ���� ä�� �����̸� ������ ��ο� �ִ� ��� LED�� LED ������ ä���.
				if(LBUTTON_DOWN)
				{
					int index = getLedIndex(e.x, e.y);
					if(index >= 0 && index < row*column)
					{
						currentValues[index] = getLedValue();
						matrix.redraw();
					}
				}
				// ���콺 ������ ��ư�� ���� ä�� �����̸� ������ ��ο� �ִ� ��� LED�� �����.
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
			// LED ��Ʈ���� ȭ���� �ٽ� �׸���.
			@Override
			public void paintControl(PaintEvent e)
			{
				int widthBound = column * CELL_SIZE + 5;
				int heightBound = row * CELL_SIZE + 5;
				
				// ����� ���������� ĥ�Ѵ�.
				e.gc.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
				e.gc.fillRectangle(0, 0, widthBound, heightBound);
				
				int index = 0;
				for(int y = 5; y < heightBound; y += CELL_SIZE)
				{
					for(int x = 5; x < widthBound; x += CELL_SIZE)
					{
						// LED ���� ���� ������ �����Ѵ�.
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
						// LED�� �׸���.
						e.gc.setBackground(color);
						e.gc.fillOval(x, y, 15, 15);
						if(color != null) color.dispose();
						// �� ���̱Ⱑ üũ�� ��쿡�� LED ���� ǥ���Ѵ�.
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
		
		// LED ��Ʈ���� �����ʿ� �ִ� �г�
		Composite panel = new Composite(composite, SWT.NONE);
		final GridLayout gl_panel = new GridLayout();
		gl_panel.marginWidth = 0;
		gl_panel.marginHeight = 0;
		gl_panel.marginRight = 5;
		gl_panel.marginBottom = 5;
		panel.setLayout(gl_panel);
		panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 0, 0));
		
		// �г� ����
		Composite panelTop = new Composite(panel, SWT.NONE);
		final GridLayout gl_panelTop = new GridLayout();
		gl_panelTop.numColumns = 2;
		gl_panelTop.marginWidth = 0;
		gl_panelTop.marginHeight = 0;
		panelTop.setLayout(gl_panelTop);
		panelTop.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 0, 0));
		
		// LED �� �ؽ�Ʈ ������
		Label labelValue = new Label(panelTop, SWT.NONE);
		labelValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		labelValue.setText(Messages.MatrixDialog_Value + ":"); //$NON-NLS-1$
		textValue = new Text(panelTop, SWT.BORDER);
		textValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textValue.setText(Integer.toString(maxValue));
		
		new Label(panelTop, SWT.NONE);
		
		// �� ���̱� üũ �ڽ�
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
		
		// ���� ��ư
		Button buttonReset = new Button(panelTop, SWT.NONE);
		buttonReset.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// ���� ��ư�� ������ �ּҰ����� ä���.
				currentValues = new int[row*column];
				for(int i = 0; i < row*column; i ++)
					currentValues[i] = minValue;
				matrix.redraw();
			}
		});
		buttonReset.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		buttonReset.setText(Messages.MatrixDialog_Reset);
		
		// �г� �Ʒ���
		Composite panelBottom = new Composite(panel, SWT.NONE);
		final GridLayout gl_panelBottom = new GridLayout();
		gl_panelBottom.numColumns = 2;
		gl_panelBottom.marginWidth = 0;
		gl_panelBottom.marginHeight = 0;
		panelBottom.setLayout(gl_panelBottom);

		// �Ϸ� ��ư
		Button buttonFinish = new Button(panelBottom, SWT.NONE);
		buttonFinish.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// FINISH ��ư Ŭ�� ��
				finalValues = new int[row*column];
				System.arraycopy(currentValues, 0, finalValues, 0, row*column);
				shell.close();
			}
		});
		final GridData gd_finishButton = new GridData(SWT.RIGHT, SWT.FILL, false, true);
		gd_finishButton.widthHint = 90;
		buttonFinish.setLayoutData(gd_finishButton);
		buttonFinish.setText(Messages.Common_OK);

		// ��� ��ư
		Button buttonCancel = new Button(panelBottom, SWT.NONE);
		buttonCancel.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// ��� Ŭ���� 
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
