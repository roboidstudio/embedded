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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.swtdesigner.ResourceManager;

/**
 * @author Kyoung Jin Kim
 */
public class Script extends Shell
{

	private Label remarksLabel;
	private Label scriptLabel;
	private StyledText text;
	static Script shell;
	/**
	 * Launch the application
	 * @param args
	 */
//	public static void main(String args[])
//	{
//		try
//		{
//			Display display = Display.getDefault();
//			shell = new Script(display, SWT.APPLICATION_MODAL | SWT.CLOSE, "none");
//			shell.open();
//			shell.layout();
//			while (!shell.isDisposed())
//			{
//				if (!display.readAndDispatch())
//					display.sleep();
//			}
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the shell
	 * @param display
	 * @param style
	 */
	public Script(Shell shell, int style, String script)
	{
		super(shell.getDisplay(), style);
		createContents(script);
		final GridLayout gridLayout = new GridLayout();
		setLayout(gridLayout);
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents(String script)
	{
		setText(" Roboid Script Editor");
		setSize(640, 320);

		scriptLabel = new Label(this, SWT.NONE);
		final GridData gd_scriptLabel = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		scriptLabel.setLayoutData(gd_scriptLabel);
		scriptLabel.setText("Script: " + script);

		text = new StyledText(this, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		text.setFont(ResourceManager.getFont("Courier New", 10, SWT.NONE));
		final GridData gd_styledText = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_styledText.heightHint = 310;
		gd_styledText.widthHint = 474;
		text.setLayoutData(gd_styledText);
		text.setLayout(new FillLayout());

		remarksLabel = new Label(this, SWT.NONE);
		remarksLabel.setLayoutData(new GridData());
		remarksLabel.setText("Remarks:");
		
		text.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				List<StyleRange> styles = new ArrayList<StyleRange>();
				
				Pattern pat = Pattern.compile("\\w+\\W|//.*\\r|\".*\"");
				Matcher mat = pat.matcher(text.getText());
				
				while(mat.find())
				{
					String word = text.getText().substring(mat.start(), mat.end()-1);
					System.out.println(word);
					if(Keyword.match(word))
					{
						styles.add(Keyword.createStyle(shell, mat.start(), mat.end()-1));
					}
					else if(Binding.match(word))
					{
						styles.add(Binding.createStyle(shell, mat.start(), mat.end()-1));												
					}
					else if(Variable.match(word))
					{
						styles.add(Variable.createStyle(shell, mat.start(), mat.end()-1));												
					}
					else if(Identifier.match(word))
					{
						styles.add(Identifier.createStyle(shell, mat.start(), mat.end()-1));						
					}
					else if(word.startsWith("//"))
					{
						styles.add(new CommentStyle(shell, mat.start(), mat.end()-1));
					}
					else if(word.startsWith("\""))
					{
						System.out.println(word);
						styles.add(new StringStyle(shell, mat.start(), mat.end()));
					}
				}
				
				//update styles
				StyleRange[] styleRanges = new StyleRange[styles.size()];
				for(int i = 0; i<styles.size(); i++)
				{
					styleRanges[i] = (StyleRange)styles.get(i);
				}
				text.setStyleRanges(styleRanges);
			}
		});		
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

	public StyledText getStyledText()
	{
		return text;
	}

}
