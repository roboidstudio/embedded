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

package org.roboid.studio.robotcomposer.editparts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.roboid.robot.Roboid;
import org.roboid.robot.Robot;
import org.roboid.robot.RobotPackage;
import org.roboid.robot.provider.RobotEditPlugin;
import org.roboid.studio.robotcomposer.RoboidBlock;
import org.roboid.studio.robotcomposer.RobotComposerConstants;
import org.roboid.studio.robotcomposer.RobotComposerPackage;
import org.roboid.studio.robotcomposer.RobotComposerPlugin;
import org.roboid.studio.robotcomposer.RobotDiagram;
import org.roboid.studio.robotcomposer.RobotGraphicalEditor;
import org.roboid.studio.robotcomposer.editpolicies.BlockElementXYLayoutEditPolicy;

/**
 * @author Kwang-Hyun Park
 */
public class RobotDiagramEditPart extends EditPartWithListener
{
	private final Image image = ExtendedImageRegistry.INSTANCE.getImage(RobotComposerPlugin.INSTANCE.getImage("robot128.png"));
	
	@Override
	protected IFigure createFigure()
	{
		FreeformLayer layer = new FreeformLayer()
		{
			@Override
			protected void paintClientArea(Graphics g)
			{
				int alpha = g.getAlpha();
				Color fg = g.getForegroundColor();
				g.setForegroundColor(ColorConstants.gray);
				
				int x = getClientArea().x;
				int width = getClientArea().width;
				int y = getClientArea().y;
				int height = getClientArea().height;
				int gap = RobotComposerConstants.GRID;
				
				// 그리드를 그린다.
				if(getModel().isGrid())
				{
					g.setAlpha(25);
					for(int i = gap; i < y + height;)
					{
						g.drawLine(x, i, x + width, i);
						i = i + gap;
					}
					for(int i = gap; i < x + width;)
					{
						g.drawLine(i, y, i, y + height);
						i = i + gap;
					}
					g.setAlpha(25);
					for(int i = 5 * gap; i < y + height;)
					{
						g.drawLine(x, i, x + width, i);
						i = i + 5 * gap;
					}
					for(int i = 5 * gap; i < x + width;)
					{
						g.drawLine(i, y, i, y + height);
						i = i + 5 * gap;
					}
				}
				
				g.setAlpha(50);
				g.drawImage(image, x + width - 140, y + height - 130);
				g.setAlpha(alpha);
				g.setForegroundColor(fg);
				
				super.paintClientArea(g);
			}
		};
		
		layer.setLayoutManager(new FreeformLayout());
		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
		RobotComposerConnectionRouter router = new RobotComposerConnectionRouter(layer);
		router.setSpacing(10);
		connLayer.setConnectionRouter(router);
		return layer;
	}

	@Override
	protected void createEditPolicies()
	{
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BlockElementXYLayoutEditPolicy());
	}

	@Override
	protected List<RoboidBlock> getModelChildren()
	{
		return getModel().getBlocks();
	}

	@Override
	public RobotDiagram getModel()
	{
		return (RobotDiagram)super.getModel();
	}
	
	@Override
	protected void hookIntoModel()
	{
		super.hookIntoModel();
		EObject model = (EObject)getModel().getRobot();
		if(model != null)
			model.eAdapters().add(this);
	}
	
	@Override
	protected void unhookFromModel()
	{
		super.unhookFromModel();
		EObject model = (EObject)getModel().getRobot();
		if(model != null)
			model.eAdapters().remove(this);
	}
	
	@Override
	public boolean isAdapterForType(Object type)
	{
		return ((getModel().getClass() == type) || (getModel().getRobot().getClass() == type));
	}
	
	@Override
	public void notifyChanged(Notification notification)
	{
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(RobotComposerPackage.class);
		switch(featureId)
		{
			case RobotComposerPackage.ROBOT_DIAGRAM__GRID:
			{
				if(type == Notification.SET)
					getFigure().repaint();
				break;
			}
			case RobotPackage.ROBOT__ROBOIDS:
			{
				switch(type)
				{
					case Notification.ADD:
					{
						Roboid roboid = (Roboid)notification.getNewValue();
						RoboidBlock newBlock = getModel().getRoboidBlock(roboid);
						RoboidBlock childBlock = null;
						for(RoboidBlock child : getModel().getBlocks())
						{
							if(roboid.equals(child.getRoboid()))
							{
								childBlock = child;
								break;
							}
						}
						if(childBlock == null) getModel().addChild(newBlock);
						refreshChildren();
						newBlock.connectAll();
						break;
					}
					case Notification.ADD_MANY:
					{
						@SuppressWarnings("unchecked")
						List<Roboid> roboids = (List<Roboid>)notification.getNewValue();
						for(Roboid roboid : roboids)
						{
							RoboidBlock newBlock = getModel().getRoboidBlock(roboid);
							RoboidBlock childBlock = null;
							for(RoboidBlock child : getModel().getBlocks())
							{
								if(roboid.equals(child.getRoboid()))
								{
									childBlock = child;
									break;
								}
							}
							if(childBlock == null) getModel().addChild(newBlock);
							newBlock.connectAll();
						}
						refreshChildren();
						break;
					}
					case Notification.REMOVE:
					{
						Roboid roboid = (Roboid)notification.getOldValue();
						RoboidBlock oldBlock = getModel().findRoboidBlock(roboid);
						if(oldBlock != null)
							getModel().getBlocks().remove(oldBlock);
						refreshChildren();
						oldBlock.disconnectAll();
						break;
					}
					case Notification.REMOVE_MANY:
					{
						@SuppressWarnings("unchecked")
						List<Roboid> roboids = (List<Roboid>)notification.getOldValue();
						for(Roboid roboid : roboids)
						{
							RoboidBlock oldBlock = getModel().findRoboidBlock(roboid);
							if(oldBlock != null)
								getModel().getBlocks().remove(oldBlock);
							oldBlock.disconnectAll();
						}
						refreshChildren();
						break;
					}
				}
				break;
			}
			case RobotComposerPackage.ROBOT_DIAGRAM__BLOCKS:
			{
				switch(type)
				{
					case Notification.ADD:
					{
						RoboidBlock newBlock = (RoboidBlock)notification.getNewValue();
						if(newBlock.getX() < 0)
							newBlock.setX(RobotComposerConstants.GRID * 5);
						if(newBlock.getY() < 0)
						{
							int y = -1;
							RoboidBlock bottom = null;
							for(RoboidBlock child : getModel().getBlocks())
							{
								if(y < child.getY())
								{
									y = child.getY();
									bottom = child;
								}
							}
							if(y < 0) y = RobotComposerConstants.GRID;
							else if(bottom != null) y = RobotGraphicalEditor.snap(y + 26 + bottom.getDevices().size() * 18) + RobotComposerConstants.GRID;
							newBlock.setY(y);
						}
						refreshChildren();
						break;
					}
				}
				break;
			}
		}
	}
	
	class DiagramPropertySource implements IPropertySource
	{
		private AdapterFactory adapterFactory;
		private Robot robot;
		private RobotDiagram diagram;
		private IItemPropertySource robotPropertySource;
		private IItemPropertySource diagramPropertySource;
		private IPropertyDescriptor[] propertyDescriptors;
		
		public DiagramPropertySource(AdapterFactory adapterFactory)
		{
			this.adapterFactory = adapterFactory;
			robot = getModel().getRobot();
			diagram = getModel();
			robotPropertySource = (IItemPropertySource)adapterFactory.adapt(robot, IItemPropertySource.class);
			diagramPropertySource = (IItemPropertySource)adapterFactory.adapt(diagram, IItemPropertySource.class);
			propertyDescriptors = createPropertyDescriptors();
		}
		
		protected String getString(ResourceLocator resourceLocator, String key, String s0, String s1)
		{
			return resourceLocator.getString(key, new Object[] { getString(resourceLocator, s0), getString(resourceLocator, s1) }, true);
		}
		
		protected String getString(ResourceLocator resourceLocator, String key)
		{
			return resourceLocator.getString(key, true);
		}
		
		private IPropertyDescriptor[] createPropertyDescriptors()
		{
			Collection<IPropertyDescriptor> result = new ArrayList<IPropertyDescriptor>();
			result.add(new PropertyDescriptor(robot,
					new ItemPropertyDescriptor(
							((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
							RobotEditPlugin.INSTANCE,
							getString(RobotEditPlugin.INSTANCE, "_UI_NamedElement_name_feature"),
							getString(RobotEditPlugin.INSTANCE, "_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
							RobotPackage.Literals.NAMED_ELEMENT__NAME,
							true,
							false,
							false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyCategory_robot"),
							null)));
			result.add(new PropertyDescriptor(robot,
					new ItemPropertyDescriptor(
							((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
							RobotEditPlugin.INSTANCE,
							getString(RobotEditPlugin.INSTANCE, "_UI_NamedElement_comment_feature"),
							getString(RobotEditPlugin.INSTANCE, "_UI_PropertyDescriptor_description", "_UI_NamedElement_comment_feature", "_UI_NamedElement_type"),
							RobotPackage.Literals.NAMED_ELEMENT__COMMENT,
							true,
							true,
							false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyCategory_robot"),
							null)));
			result.add(new PropertyDescriptor(robot,
					new ItemPropertyDescriptor(
							((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
							RobotEditPlugin.INSTANCE,
							getString(RobotEditPlugin.INSTANCE, "_UI_Robot_provider_feature"),
							getString(RobotEditPlugin.INSTANCE, "_UI_PropertyDescriptor_description", "_UI_Robot_provider_feature", "_UI_Robot_type"),
							RobotPackage.Literals.ROBOT__PROVIDER,
							true,
							false,
							false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyCategory_robot"),
							null)));
			result.add(new PropertyDescriptor(robot,
					new ItemPropertyDescriptor(
							((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
							RobotEditPlugin.INSTANCE,
							getString(RobotEditPlugin.INSTANCE, "_UI_Robot_version_feature"),
							getString(RobotEditPlugin.INSTANCE, "_UI_PropertyDescriptor_description", "_UI_Robot_version_feature", "_UI_Robot_type"),
							RobotPackage.Literals.ROBOT__VERSION,
							true,
							false,
							false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyCategory_robot"),
							null)));
			result.add(new PropertyDescriptor(robot,
					new ItemPropertyDescriptor(
							((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
							RobotEditPlugin.INSTANCE,
							getString(RobotEditPlugin.INSTANCE, "_UI_Robot_standard_feature"),
							getString(RobotEditPlugin.INSTANCE, "_UI_PropertyDescriptor_description", "_UI_Robot_standard_feature", "_UI_Robot_type"),
							RobotPackage.Literals.ROBOT__STANDARD,
							true,
							false,
							false,
							ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyCategory_robot"),
							null)));
			result.add(new PropertyDescriptor(diagram,
					new ItemPropertyDescriptor(
							((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
							RobotComposerPlugin.INSTANCE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_RobotDiagram_grid_feature"),
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyDescriptor_description", "_UI_RobotDiagram_grid_feature", "_UI_RobotDiagram_type"),
							RobotComposerPackage.Literals.ROBOT_DIAGRAM__GRID,
							true,
							false,
							false,
							ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
							getString(RobotComposerPlugin.INSTANCE, "_UI_PropertyCategory_attribute"),
							null)));

			return result.toArray(new IPropertyDescriptor[result.size()]);
		}
		
		@Override
		public Object getEditableValue()
		{
			return diagramPropertySource.getEditableValue(diagram);
		}

		@Override
		public IPropertyDescriptor[] getPropertyDescriptors()
		{
			return propertyDescriptors;
		}

		@Override
		public Object getPropertyValue(Object id)
		{
			Object target = diagram;
			IItemPropertyDescriptor itemPropertyDescriptor = diagramPropertySource.getPropertyDescriptor(diagram, id);
			if(itemPropertyDescriptor == null)
			{
				target = robot;
				itemPropertyDescriptor = robotPropertySource.getPropertyDescriptor(robot, id);
			}
			return itemPropertyDescriptor != null ? itemPropertyDescriptor.getPropertyValue(target) : null;
		}

		@Override
		public boolean isPropertySet(Object id)
		{
			Object target = diagram;
			IItemPropertyDescriptor itemPropertyDescriptor = diagramPropertySource.getPropertyDescriptor(diagram, id);
			if(itemPropertyDescriptor == null)
			{
				target = robot;
				itemPropertyDescriptor = robotPropertySource.getPropertyDescriptor(robot, id);
			}
			return itemPropertyDescriptor != null ? itemPropertyDescriptor.isPropertySet(target) : false;
		}

		@Override
		public void resetPropertyValue(Object id)
		{
			Object target = diagram;
			IItemPropertyDescriptor itemPropertyDescriptor = diagramPropertySource.getPropertyDescriptor(diagram, id);
			if(itemPropertyDescriptor == null)
			{
				target = robot;
				itemPropertyDescriptor = robotPropertySource.getPropertyDescriptor(robot, id);
			}
			if(itemPropertyDescriptor != null)
				itemPropertyDescriptor.resetPropertyValue(target);
		}

		@Override
		public void setPropertyValue(Object id, Object value)
		{
			Object target = diagram;
			IItemPropertyDescriptor itemPropertyDescriptor = diagramPropertySource.getPropertyDescriptor(diagram, id);
			if(itemPropertyDescriptor == null)
			{
				target = robot;
				itemPropertyDescriptor = robotPropertySource.getPropertyDescriptor(robot, id);
			}
			if(itemPropertyDescriptor != null)
				itemPropertyDescriptor.setPropertyValue(target, value);
		}
	}
	
	public IPropertySource getPropertySource(AdapterFactory adapterFactory)
	{
		return new DiagramPropertySource(adapterFactory);
	}
}
