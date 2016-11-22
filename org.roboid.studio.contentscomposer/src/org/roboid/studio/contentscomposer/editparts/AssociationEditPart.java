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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionEndpointLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.roboid.studio.contentscomposer.Association;
import org.roboid.studio.contentscomposer.ContentsComposerElement;
import org.roboid.studio.contentscomposer.MotionContent;
import org.roboid.studio.contentscomposer.commands.DeleteConnectionCommand;

/**
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 */
public class AssociationEditPart extends AbstractConnectionEditPart implements PropertyChangeListener
{
	private PolylineConnection connection; // 연결선
	private ConnectionEndpointLocator targetLocator; // 타겟 레이블 위치
	private Label targetLabel; // 타겟 레이블
	private ConnectionEndpointLocator sourceLocator; // 소스 레이블 위치
	private Label sourceLabel; // 소스 레이블
	
	@Override
	public void activate()
	{
		super.activate();
		ContentsComposerElement model = (ContentsComposerElement)getModel();
		// 프로퍼티 변경에 대한 리스너를 추가한다.
		model.addPropertyChangeListener(this);
	}

	@Override
	public void deactivate()
	{
		super.deactivate();
		ContentsComposerElement model = (ContentsComposerElement)getModel();
		// 프로퍼티 변경에 대한 리스너를 삭제한다.
		model.removePropertyChangeListener(this);
	}

	// 연결선 편집에 대한 정책을 생성한다.
	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy()
		{
			// 연결선 삭제에 대한 명령을 생성한다.
			@Override
			protected Command getDeleteCommand(GroupRequest request)
			{
				Association association = (Association)getModel();
				MotionContent parent = (MotionContent)((EObject)association).eContainer();
				return new DeleteConnectionCommand(parent, association);
			}
		});
	}
	
	// 프로퍼티의 변경에 따라 다시 그린다.
	@Override
	public void propertyChange(PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(Association.P_SOURCE)) // 소스 레이블 변경
		{
			sourceLabel.setText(getCastedModel().getSourceLabel());
			connection.invalidate();
		}
		else if(event.getPropertyName().equals(Association.P_TARGET)) // 타겟 레이블 변경
		{
			targetLabel.setText(getCastedModel().getTargetLabel());
			connection.invalidate();
		}
	}

	@Override
	protected IFigure createFigure()
	{
		connection = new PolylineConnection()
		{
			// 연결선을 그린다.
			@Override
			protected void outlineShape(Graphics g)
			{
				g.setForegroundColor(ColorConstants.blue);
				g.setAlpha(50);
				super.outlineShape(g);
			}
		};
		
		// 연결선의 타겟쪽 모양을 설정한다.
		connection.setTargetDecoration(new PolygonDecoration()
		{
			@Override
			protected void fillShape(Graphics g)
			{
				g.setForegroundColor(ColorConstants.blue);
				g.setAlpha(60);
				super.fillShape(g);
			}
			
		});
		
		// 연결선의 두께를 설정한다.
		connection.setLineWidth(2);
		
		// 타겟 레이블을 생성한다.
		targetLocator = new ConnectionEndpointLocator(connection, true);
//		targetLocator.setUDistance(0);
		targetLabel = new Label(getCastedModel().getTargetLabel());
		connection.add(targetLabel, targetLocator);
		
		// 소스 레이블을 생성한다.
		sourceLocator = new ConnectionEndpointLocator(connection, false);
//		sourceLocator.setUDistance(0);
		sourceLabel = new Label(getCastedModel().getSourceLabel());
		connection.add(sourceLabel, sourceLocator);
		
		return connection;
	}

	// Association을 얻는다.
	private Association getCastedModel()
	{
		return (Association)getModel();
	}
}
