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

package org.roboid.studio.jseditor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Kyoung Jin Kim
 */
public class JsEditor
{
	private static Rectangle rect = new Rectangle(400, 300, 640, 320);
	private Label scriptLabel;
	private StyledText text;
	private final Shell shell;
	private Display display;
	private final Font font;
	private String code;
	
	public JsEditor(Shell parent)
	{
		display = Display.getDefault();
		shell = new Shell(parent, SWT.APPLICATION_MODAL | SWT.CLOSE | SWT.RESIZE);
		shell.setText("Roboid Script Editor");
		shell.setImage(ImageDescriptor.createFromFile(Activator.class, "scroll_edit.png").createImage()); //$NON-NLS-1$
		shell.setBounds(rect);
		final GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);

		scriptLabel = new Label(shell, SWT.NONE);
		final GridData gd_scriptLabel = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		scriptLabel.setLayoutData(gd_scriptLabel);

		text = new StyledText(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		font = new Font(display, "Courier New", 10, SWT.NONE);
		text.setFont(font);
		final GridData gd_styledText = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_styledText.heightHint = 310;
		gd_styledText.widthHint = 474;
		text.setLayoutData(gd_styledText);
		text.setLayout(new FillLayout());

		Label remarksLabel = new Label(shell, SWT.NONE);
		remarksLabel.setLayoutData(new GridData());
		remarksLabel.setText("Remarks:");
		
		addListeners(shell, text);		
	}

	public void setName(String name)
	{
		scriptLabel.setText("Script: " + name);		
	}
	
	public void setCode(String script)
	{
		text.setText(script);
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String open()
	{
		// 에디터 창을 연다.
		shell.open();
		shell.layout();
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch())
			{
				rect = shell.getBounds();

				// 스크립트 코드를 변경한다.
				code = text.getText();
				display.sleep();
			}
		}
		font.dispose();
		return code;
	}
	
	private void addListeners(final Shell shell, final StyledText text)
	{
		text.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseUp(MouseEvent e)
			{
				if(e.button == 3)
				{
					System.out.println("popup");
				}
			}	
		});
		
		text.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				List<StyleRange> styles = new ArrayList<StyleRange>();
				
				Pattern pat = Pattern.compile("\\w+\\w|//.*|/\\*(?:.|[\\n\\r])*?\\*/|\".*?\"");
//				Pattern pat = Pattern.compile("\\w+\\w|//.*|\"[^\"]*\"");
				Matcher mat = pat.matcher(text.getText());
				
				while(mat.find())
				{
					String word = text.getText().substring(mat.start(), mat.end());

					if(word.startsWith("/*") && word.endsWith("*/"))
					{
						styles.add(new CommentStyle(shell, mat.start(), mat.end()));
					}
					else if(word.startsWith("//"))
					{
						styles.add(new CommentStyle(shell, mat.start(), mat.end()));
					}
					else if(word.startsWith("\""))
					{
						styles.add(new StringStyle(shell, mat.start(), mat.end()));
					}
					else if(Keyword.match(word))
					{
						styles.add(Keyword.createStyle(shell, mat.start(), mat.end()));
					}
					else if(Binding.match(word))
					{
						styles.add(Binding.createStyle(shell, mat.start(), mat.end()));												
					}
					else if(Variable.match(word))
					{
						styles.add(Variable.createStyle(shell, mat.start(), mat.end()));												
					}
					else if(Identifier.match(word))
					{
						styles.add(Identifier.createStyle(shell, mat.start(), mat.end()));						
					}
				}
				
				//update styles
				text.setStyleRanges(styles.toArray(new StyleRange[styles.size()]));
			}
		});
	}
}
