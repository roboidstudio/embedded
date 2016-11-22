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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Kyoung Jin Kim
 */
public class Variable
{
	//--- list of JavaScript keywords
	private static String[] keywords = 
		{"frame", "value", "count",
		"clip", "clipN", "clipY"};
	
	public static boolean match(String word)
	{
		for(int i = 0; i < keywords.length; i++)
		{
			if(word.equals(keywords[i])) return true;
		}
		return false;
	}
	
	public static String assist(String word)
	{
		return "";
	}
	
	public static StyleRange createStyle(Shell shell, int start, int end)
	{
		StyleRange style = new StyleRange();
		style.start = start;
		style.length = end - start;
		style.foreground = shell.getDisplay().getSystemColor(SWT.COLOR_BLUE);
		return style;
	}
}
