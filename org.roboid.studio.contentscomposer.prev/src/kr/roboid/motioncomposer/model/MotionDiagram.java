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

package kr.roboid.motioncomposer.model;

import java.util.ArrayList;
import java.util.List;

import org.roboid.robot.Robot;
import org.roboid.studio.contentscomposer.ContentsComposerFactory;

/**
 * @author Kwang-Hyun Park
 */
public class MotionDiagram extends AbstractModel
{
	private static final long serialVersionUID = 1L;
	private boolean gridOn = true;
	private boolean minimize = false;
	private String exitScript;
	private List<AbstractClip> contents = new ArrayList<AbstractClip>();
	
	public List<MotionClip> getMotionClips()
	{
		List<MotionClip> clips = new ArrayList<MotionClip>();
		for(int i = 0; i < contents.size(); i++)
		{
			if(contents.get(i) instanceof MotionClip)
				clips.add((MotionClip)contents.get(i));
		}
		return clips;
	}
	
	public List<ContentClip> getContentClips()
	{
		List<ContentClip> clips = new ArrayList<ContentClip>();
		for(int i = 0; i < contents.size(); i++)
		{
			if(contents.get(i) instanceof ContentClip)
				clips.add((ContentClip)contents.get(i));
		}
		return clips;
	}
	
	public org.roboid.studio.contentscomposer.MotionContent toVersion1_4(Robot robot)
	{
		org.roboid.studio.contentscomposer.MotionContent newContent = ContentsComposerFactory.eINSTANCE.createMotionContent();
		newContent.setRobot(robot);
		newContent.setGrid(gridOn);
		newContent.setMinimized(minimize);
		for(int i = 0; i < contents.size(); i ++)
		{
			NodeElement node = (NodeElement)contents.get(i);
			org.roboid.studio.contentscomposer.BlockElement newNode = node.toVersion1_4(newContent, robot);
			newContent.addChild(newNode);
		}
		newContent.setTerminatorScriptCode(exitScript);

		List<org.roboid.studio.contentscomposer.Association> newAssociations = new ArrayList<org.roboid.studio.contentscomposer.Association>();
		List<Association> oldAssociations = new ArrayList<Association>();
		for(int i = 0; i < contents.size(); i ++)
		{
			NodeElement oldNode = (NodeElement)contents.get(i);
			
			for(Association association : oldNode.getIncomings())
			{
				oldAssociations.add(association);
				newAssociations.add(association.toVersion1_4());
			}
			
			if(oldNode instanceof CloneClip)
				((CloneClip)oldNode).setOriginal(newContent);
			else if(oldNode instanceof CloneContent)
				((CloneContent)oldNode).setOriginal(newContent);
		}
		
		for(int i = 0; i < oldAssociations.size(); i ++)
		{
			NodeElement oldSource = oldAssociations.get(i).getSource();
			NodeElement oldTarget = oldAssociations.get(i).getTarget();
			org.roboid.studio.contentscomposer.BlockElement newSource;
			org.roboid.studio.contentscomposer.BlockElement newTarget;
			Association oldAssociation = oldAssociations.get(i);
			org.roboid.studio.contentscomposer.Association newAssociation = newAssociations.get(i);
			
			int indexSource = contents.indexOf(oldSource);
			int indexTarget = contents.indexOf(oldTarget);
			if(indexSource >= 0 && indexTarget >= 0)
			{
				newSource = newContent.getBlocks().get(indexSource);
				newSource.getOutgoings().add(newAssociation);
				newAssociation.setSource(newSource);
				
				newTarget = newContent.getBlocks().get(indexTarget);
				newTarget.getIncomings().add(newAssociation);
				newAssociation.setTarget(newTarget);
				
				newContent.addAssociation(newAssociation);
				if(!oldAssociation.getSourceLabel().isEmpty())
					newAssociation.setSourceLabel(oldAssociation.getSourceLabel());
				if(!oldAssociation.getTargetLabel().isEmpty())
					newAssociation.setTargetLabel(oldAssociation.getTargetLabel());
			}
		}
		return newContent;
	}
	
	public org.roboid.studio.contentscomposer.MotionContent toVersion1_4(org.roboid.studio.contentscomposer.MotionContent newContent, Robot robot)
	{
		newContent.setGrid(gridOn);
		newContent.setMinimized(minimize);
		for(int i = 0; i < contents.size(); i ++)
		{
			NodeElement node = (NodeElement)contents.get(i);
			org.roboid.studio.contentscomposer.BlockElement newNode = node.toVersion1_4(newContent, robot);
			newContent.addChild(newNode);
		}
		newContent.setTerminatorScriptCode(exitScript);

		List<org.roboid.studio.contentscomposer.Association> newAssociations = new ArrayList<org.roboid.studio.contentscomposer.Association>();
		List<Association> oldAssociations = new ArrayList<Association>();
		for(int i = 0; i < contents.size(); i ++)
		{
			NodeElement oldNode = (NodeElement)contents.get(i);
			
			for(Association association : oldNode.getIncomings())
			{
				oldAssociations.add(association);
				newAssociations.add(association.toVersion1_4());
			}
			
			if(oldNode instanceof CloneClip)
				((CloneClip)oldNode).setOriginal(newContent);
			else if(oldNode instanceof CloneContent)
				((CloneContent)oldNode).setOriginal(newContent);
		}
		
		for(int i = 0; i < oldAssociations.size(); i ++)
		{
			NodeElement oldSource = oldAssociations.get(i).getSource();
			NodeElement oldTarget = oldAssociations.get(i).getTarget();
			org.roboid.studio.contentscomposer.BlockElement newSource;
			org.roboid.studio.contentscomposer.BlockElement newTarget;
			Association oldAssociation = oldAssociations.get(i);
			org.roboid.studio.contentscomposer.Association newAssociation = newAssociations.get(i);
			
			int indexSource = contents.indexOf(oldSource);
			int indexTarget = contents.indexOf(oldTarget);
			if(indexSource >= 0 && indexTarget >= 0)
			{
				newSource = newContent.getBlocks().get(indexSource);
				newSource.addOutgoing(newAssociation);
				newAssociation.setSource(newSource);

				newTarget = newContent.getBlocks().get(indexTarget);
				newTarget.addIncoming(newAssociation);
				newAssociation.setTarget(newTarget);
				
				newContent.addAssociation(newAssociation);
				if(!oldAssociation.getSourceLabel().isEmpty())
					newAssociation.setSourceLabel(oldAssociation.getSourceLabel());
				if(!oldAssociation.getTargetLabel().isEmpty())
					newAssociation.setTargetLabel(oldAssociation.getTargetLabel());
			}
		}
		return newContent;
	}
}
