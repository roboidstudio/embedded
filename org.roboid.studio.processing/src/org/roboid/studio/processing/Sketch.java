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

package org.roboid.studio.processing;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.eclipse.swt.graphics.ImageData;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * @author Kyoung Jin Kim
 */
@SuppressWarnings("serial")
public class Sketch extends PApplet
{
	private ScriptEngine scriptEngine;
	private String mode;
	private int width, height;
	private String draw = "draw";
	
	public Sketch(String mode, int width, int height, String func, ScriptEngine engine)
	{
		this.scriptEngine = engine;
		this.width = width;
		this.height = height;
		this.mode = mode;
		if(!func.equals("")) draw = func;
	}

	@Override
	public void setup()
	{
		if(mode.equals("P2D")) size(width, height, P2D);
		else if(mode.equals("P3D")) size(width, height, P3D);
		else size(width, height); //Java2D
	}
	
	@Override
	public void draw()
	{
		invoke(draw);
	}
	
	//--- mouse events
	@Override
	public void mouseDragged()
	{
		invoke("mouseDragged");
	}

	@Override
	public void mouseMoved()
	{
		invoke("mouseMoved");
	}

	@Override
	public void mousePressed()
	{
		invoke("mousePressed");
	}

	@Override
	public void mouseReleased()
	{
		invoke("mouseReleased");
	}

	//--- key events
	@Override
	public void keyPressed()
	{
		invoke("keyPressed");
	}

	@Override
	public void keyReleased()
	{
		invoke("keyReleased");
	}

	//--- invoke call back functions
	private void invoke(String func)
	{
		Invocable invocable = (Invocable)scriptEngine;
		
		try
		{	
			invocable.invokeFunction(func);
		} 
		catch (ScriptException e)
		{} 
		catch (NoSuchMethodException e)
		{}
	}
	
	/**
	 * Image converter
	 */
	public PImage toPImage(ImageData swtImageData)
	{
		BufferedImage image = ImageConverter.convertToAWT(swtImageData);
		return new PImage(image);
	}
	
	public ImageData toSWT(PImage pImage)
	{
		Image image = pImage.getImage();
		BufferedImage bufImage = (BufferedImage)image;
		return ImageConverter.convertToSWT(bufImage);
	}
}
