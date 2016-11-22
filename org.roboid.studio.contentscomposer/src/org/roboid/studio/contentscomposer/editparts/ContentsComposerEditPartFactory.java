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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.roboid.studio.contentscomposer.AdderBlock;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.BranchBlock;
import org.roboid.studio.contentscomposer.MotionContentBlock;
import org.roboid.studio.contentscomposer.MotionContentCloneBlock;
import org.roboid.studio.contentscomposer.DiceBlock;
import org.roboid.studio.contentscomposer.ForkBlock;
import org.roboid.studio.contentscomposer.LoopBlock;
import org.roboid.studio.contentscomposer.MergeBlock;
import org.roboid.studio.contentscomposer.MotionClipBlock;
import org.roboid.studio.contentscomposer.MotionClipCloneBlock;
import org.roboid.studio.contentscomposer.RootBlock;
import org.roboid.studio.contentscomposer.TerminatorBlock;
import org.roboid.studio.contentscomposer.TriggerBlock;
import org.roboid.studio.contentscomposer.WaitClipBlock;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class ContentsComposerEditPartFactory implements EditPartFactory
{
	// 에디트 파트를 생성한다.
	@Override
	public EditPart createEditPart(EditPart context, Object model)
	{
		EditPart part = null;
		if(model instanceof Association) part = new AssociationEditPart();
		else if(model instanceof RootBlock) part = new RootBlockEditPart();
		else if(model instanceof TerminatorBlock) part = new TerminatorBlockEditPart();
		else if(model instanceof DiceBlock) part = new DiceBlockEditPart();
		else if(model instanceof LoopBlock) part = new CounterBlockEditPart();
		else if(model instanceof AdderBlock) part = new AdderBlockEditPart();
		else if(model instanceof ForkBlock) part = new ForkBlockEditPart();
		else if(model instanceof MergeBlock) part = new MergeBlockEditPart();
		else if(model instanceof BranchBlock) part = new BranchBlockEditPart();
		else if(model instanceof TriggerBlock) part = new TriggerBlockEditPart();
		else if(model instanceof WaitClipBlock) part = new WaitClipBlockEditPart();
		else if(model instanceof MotionClipBlock) part = new MotionClipBlockEditPart();
		else if(model instanceof MotionContentBlock) part = new ContentsClipBlockEditPart();
		else if(model instanceof MotionClipCloneBlock) part = new MotionClipCloneBlockEditPart();
		else if(model instanceof MotionContentCloneBlock) part = new ContentsClipCloneBlockEditPart();
		else part = new ContentsComposerDiagramEditPart();

		part.setModel(model); // 에디트 파트에 모델을 설정한다.
		return part;
	}
}
