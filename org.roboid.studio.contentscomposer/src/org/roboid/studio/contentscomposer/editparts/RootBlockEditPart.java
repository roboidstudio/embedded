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

package org.roboid.studio.contentscomposer.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Image;
import org.roboid.studio.contentscomposer.Activator;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class RootBlockEditPart extends BlockElementWithLabelEditPart
{
	private static final String IMAGE = "/icons/movie.png";
	private static final Image image = Activator.getImageDescriptor(IMAGE).createImage();

	@Override
	protected IFigure createFigure()
	{
		// 루트 노드를 그린다.
		BlockFigure figure = new BlockFigure(this)
		{
			@Override
			protected void fillShape(Graphics g)
			{
				int x = getClientArea().x;
				int y = getClientArea().y;
				g.drawImage(image, x, y);
			}
		};
		figure.setSize(24, 24);
		return figure;
	}
}
