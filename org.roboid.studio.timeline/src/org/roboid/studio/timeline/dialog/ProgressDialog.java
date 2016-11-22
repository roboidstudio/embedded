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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Tae-hoon Kim
 */
public class ProgressDialog extends Dialog
{
	protected Object result;
	protected Shell shell;
	protected ProgressBar progressBar;
	protected Label widget_label_message;
	protected Runnable runnable = null;

	/**
	 * Create the dialog
	 * @param parent
	 */
	public ProgressDialog(Shell parent)
	{
		this(parent, SWT.NONE);
	}

	/**
	 * Create the dialog
	 * @param parent
	 * @param style
	 */
	public ProgressDialog(Shell parent, int style)
	{
		super(parent, style);
		createContents();
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents()
	{
		shell = new Shell(getParent(), SWT.APPLICATION_MODAL | SWT.TITLE | SWT.BORDER);
		shell.setLayout(new GridLayout());
		shell.setSize(	379,
						85);
		shell.setText("Processing...");

		progressBar = new ProgressBar(shell, SWT.NONE);
		final GridData gd_progressBar = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_progressBar.heightHint = 23;
		progressBar.setLayoutData(gd_progressBar);

		widget_label_message = new Label(shell, SWT.NONE);
		widget_label_message.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		widget_label_message.setText("");
		//
		
	}


	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open()
	{
		return open(null);
	}
	
	/**
	 * Open the dialog
	 * @return the result
	 */
	public Object open(final Runnable runnable)
	{
		
		Display display = getParent().getDisplay();
		shell.setLocation(	(display.getBounds().width - shell.getBounds().width) / 2,
									(display.getBounds().height - shell.getBounds().height) / 2);
		
		Thread thread = null;
		if(runnable != null)
		{
			// 스레드 생성
			thread = new Thread(new Runnable() {

				@Override
				public void run()
				{
					// runnable 동작
					runnable.run();
					
					// 윈도우 닫기
					Display.getDefault().syncExec(new Runnable(){

						@Override
						public void run()
						{
							shell.dispose();
						}
					});
					
				}
				
			});
		}
		
		// 윈도우 오픈
		shell.open();
		shell.layout();
		
		if(runnable != null && thread != null)
		{
			// 스레드 시작
			thread.start();
		}
		
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch()) display.sleep();
		}
		
		return result;
	}
	
	public void setProgress(final int v)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(!progressBar.isDisposed())
				{
					progressBar.setSelection(v);
				}
			}
		});
	}
	
	public void setResult(Object result)
	{
		this.result = result;
	}
	
	public void setMessage(final String message)
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if(!widget_label_message.isDisposed())
				{
					widget_label_message.setText(message);				
				}
			}
		});
	}
	
	public void dispose()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				shell.dispose();
			}
		});
	}
}
