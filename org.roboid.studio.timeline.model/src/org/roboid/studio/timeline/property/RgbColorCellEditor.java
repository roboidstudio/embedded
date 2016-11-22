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

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.roboid.robot.ColorMode;

/**
 * @author Kwang-Hyun Park
 */
class RgbColorCellEditor extends DialogCellEditor
{
	private static final int DEFAULT_EXTENT = 16;
	private static final int GAP = 6;
	
	private final ColorMode mode;
	private Composite composite;
	private Label colorLabel;
	private Label rgbLabel;
	private Image image;
	
	public RgbColorCellEditor(Composite parent, ColorMode mode)
	{
		this(parent, SWT.NONE, mode);
	}
	
	public RgbColorCellEditor(Composite parent, int style, ColorMode mode)
	{
		super(parent, style);
		this.mode = mode;
		doSetValue(new RgbColor(mode));
	}
	
	ColorMode getMode()
	{
		return mode;
	}
	
	private ImageData createColorImage(Control w, RGB color)
	{
		GC gc = new GC(w);
		FontMetrics fm = gc.getFontMetrics();
		int size = fm.getAscent();
		gc.dispose();
		
		int indent = 6;
		int extent = DEFAULT_EXTENT;
		if(w instanceof Table)
			extent = ((Table)w).getItemHeight() - 1;
		else if(w instanceof Tree)
			extent = ((Tree)w).getItemHeight() - 1;
		
		if(size > extent)
			size = extent;
		
		int width = indent + size;
		int height = extent;
		int xoffset = indent;
		int yoffset = (height - size) / 2;
		
		RGB black = new RGB(0,0,0);
		PaletteData dataPalette = new PaletteData(new RGB[] { black, black, color});
		ImageData data = new ImageData(width, height, 4, dataPalette);
		data.transparentPixel = 0;
		
		int end = size - 1;
		for(int y = 0; y < size; y ++)
		{
			for(int x = 0; x < size; x ++)
			{
				if(x == 0 || y == 0 || x == end || y == end)
					data.setPixel(x + xoffset, y + yoffset, 1);
				else
					data.setPixel(x + xoffset, y + yoffset, 2);
			}
		}
		return data;
	}
	
	@Override
	protected Control createContents(Composite cell)
	{
		Color bg = cell.getBackground();
        composite = new Composite(cell, getStyle());
        composite.setBackground(bg);
        composite.setLayout(new RgbColorCellLayout());
        colorLabel = new Label(composite, SWT.LEFT);
        colorLabel.setBackground(bg);
        rgbLabel = new Label(composite, SWT.LEFT);
        rgbLabel.setBackground(bg);
        rgbLabel.setFont(cell.getFont());
        return composite;
	}
	
	@Override
	public void dispose()
	{
		if(image != null)
		{
			image.dispose();
			image = null;
		}
		super.dispose();
	}
	
	@Override
	protected Object openDialogBox(Control cellEditorWindow)
	{
		RgbColor value = (RgbColor)getValue();
		if(value == null)
			value = new RgbColor(mode);

		if(mode == null) return null;
		
		switch(mode.getValue())
		{
		case ColorMode.RED_GREEN_VALUE:
			{
				DualColorDialog dialog = new DualColorDialog(cellEditorWindow.getShell(), mode);
				return dialog.open(value);
			}
		case ColorMode.RED_VALUE:
		case ColorMode.GREEN_VALUE:
		case ColorMode.BLUE_VALUE:
		case ColorMode.GRAY_VALUE:
			{
				MonoColorDialog dialog = new MonoColorDialog(cellEditorWindow.getShell(), mode);
				return dialog.open(value);
			}
		default:
			{
				ColorDialog dialog = new ColorDialog(cellEditorWindow.getShell());
				dialog.setRGB(value.getRGB());
				if(dialog.open() == null) return value;
				else return new RgbColor(mode, dialog.getRGB());
			}
		}
	}

	@Override
	protected void updateContents(Object value)
	{
		RgbColor ledColor = (RgbColor)value;
		if(ledColor == null)
			ledColor = new RgbColor(mode);
		
		if(image != null) image.dispose();
		
		ImageData id = createColorImage(colorLabel.getParent().getParent(), ledColor.getRGB());
		ImageData mask = id.getTransparencyMask();
		image = new Image(colorLabel.getDisplay(), id, mask);
		colorLabel.setImage(image);
		rgbLabel.setText(ledColor.getLabelText());
	}

	private class RgbColorCellLayout extends Layout
	{
		@Override
		protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache)
		{
			if(wHint != SWT.DEFAULT && hHint != SWT.DEFAULT)
				return new Point(wHint, hHint);
			
			Point colorSize = colorLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache);
			Point rgbSize = rgbLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache);
			return new Point(colorSize.x + GAP + rgbSize.x, Math.max(colorSize.y, rgbSize.y));
		}

		@Override
		protected void layout(Composite composite, boolean flushCache)
		{
			Rectangle bounds = composite.getClientArea();
			Point colorSize = colorLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache);
			Point rgbSize = rgbLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache);
			int ty = (bounds.height - rgbSize.y) / 2;
			if(ty < 0) ty = 0;
			colorLabel.setBounds(-1, 0, colorSize.x, colorSize.y);
			rgbLabel.setBounds(colorSize.x + GAP - 1, ty, bounds.width - colorSize.x - GAP, bounds.height);
		}
	}
}
