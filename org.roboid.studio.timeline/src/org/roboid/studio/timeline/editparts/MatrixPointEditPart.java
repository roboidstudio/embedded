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

package org.roboid.studio.timeline.editparts;

import org.roboid.studio.timeline.MatrixPoint;
import org.roboid.studio.timeline.MatrixTrack;
import org.roboid.studio.timeline.commands.ModifyMatrixPointCommand;

/**
 * @author Kwang-Hyun Park
 */
public class MatrixPointEditPart extends ControlPointEditPart
{
	// 제어점의 내용을 변경한다. 
	@Override
	public void modifyControlPoint()
	{
		// 제어점 변경에 대한 명령을 생성한다.
		ModifyMatrixPointCommand command = new ModifyMatrixPointCommand((MatrixTrack)getParent().getModel(), getModel());
//		TimelineEditor.commandStack.execute(command);
		getViewer().getEditDomain().getCommandStack().execute(command);
	}

	@Override
	public MatrixPoint getModel()
	{
		return (MatrixPoint)super.getModel();
	}
}
