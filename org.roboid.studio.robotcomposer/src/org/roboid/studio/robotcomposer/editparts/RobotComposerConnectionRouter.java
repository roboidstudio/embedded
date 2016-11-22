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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.Path;
import org.eclipse.draw2d.graph.ShortestPathRouter;
import org.roboid.studio.robotcomposer.editparts.DeviceElementEditPart.DevicePolylineConnection;

/**
 * modify ShortestConnectionRouter 
 * @author Kwang-Hyun Park
 *
 */
public final class RobotComposerConnectionRouter extends AbstractRouter
{
	private class LayoutTracker extends LayoutListener.Stub
	{
		public void postLayout(IFigure container)
		{
			processLayout();
		}
		public void remove(IFigure child)
		{
			removeChild(child);
		}
		public void setConstraint(IFigure child, Object constraint)
		{
			addChild(child);
		}
	}

	private Map<Connection, Object> constraintMap = new HashMap<Connection, Object>();
	private Map<IFigure, Rectangle> figuresToBounds;
	private Map<Connection, Path> connectionToPaths;
	private boolean isDirty;
	private ShortestPathRouter algorithm = new ShortestPathRouter();
	private IFigure container;
	private Set<Connection> staleConnections = new HashSet<Connection>();
	private LayoutListener listener = new LayoutTracker();
	private boolean ignoreInvalidate;

	private FigureListener figureListener = new FigureListener()
	{
		public void figureMoved(IFigure source)
		{
			Rectangle newBounds = source.getBounds().getCopy();
			if(algorithm.updateObstacle((Rectangle)figuresToBounds.get(source), newBounds))
			{
				queueSomeRouting();
				isDirty = true;
			}
			figuresToBounds.put(source, newBounds);
		}
	};

	public RobotComposerConnectionRouter(IFigure container)
	{
		isDirty = false;
		algorithm = new ShortestPathRouter();
		this.container = container;
	}

	void addChild(IFigure child)
	{
		if(connectionToPaths == null)
			return;
		if(figuresToBounds.containsKey(child))
			return;
		Rectangle bounds = child.getBounds().getCopy();
		algorithm.addObstacle(bounds);
		figuresToBounds.put(child, bounds);
		child.addFigureListener(figureListener);
		isDirty = true;
	}

	private void hookAll()
	{
		figuresToBounds = new HashMap<IFigure, Rectangle>();
		for(int i = 0; i < container.getChildren().size(); i++)
		{
			IFigure figure = (IFigure)container.getChildren().get(i);
			addChild(figure);
		}
		container.addLayoutListener(listener);
	}

	private void unhookAll()
	{
		container.removeLayoutListener(listener);
		if(figuresToBounds != null)
		{
			Iterator<IFigure> figureItr = figuresToBounds.keySet().iterator();
			while(figureItr.hasNext())
			{
				IFigure child = (IFigure)figureItr.next();
				figureItr.remove();
				removeChild(child);
			}
			figuresToBounds = null;
		}
	}

	public Object getConstraint(Connection connection)
	{
		return constraintMap.get(connection);
	}

	public int getSpacing()
	{
		return algorithm.getSpacing();
	}

	public void invalidate(Connection connection)
	{
		if(ignoreInvalidate) return;
		if(connection instanceof DevicePolylineConnection) return;
		staleConnections.add(connection);
		isDirty = true;
	}

	private void processLayout()
	{
		if(staleConnections.isEmpty()) return;
		((Connection)staleConnections.iterator().next()).revalidate();
	}

	@SuppressWarnings("unchecked")
	private void processStaleConnections()
	{
		Iterator<Connection> iter = staleConnections.iterator();
		if(iter.hasNext() && connectionToPaths == null)
		{
			connectionToPaths = new HashMap<Connection, Path>();
			hookAll();
		}

		while(iter.hasNext())
		{
			Connection conn = (Connection)iter.next();
			Path path = (Path)connectionToPaths.get(conn);
			if(path == null)
			{
				path = new Path(conn);
				connectionToPaths.put(conn, path);
				algorithm.addPath(path);
			}

			List<Bendpoint> constraint = (List<Bendpoint>)getConstraint(conn);
			if(constraint == null)
				constraint = Collections.EMPTY_LIST;
			
			Point start = conn.getSourceAnchor().getReferencePoint().getCopy();
			Point end = conn.getTargetAnchor().getReferencePoint().getCopy();

			container.translateToRelative(start);
			container.translateToRelative(end);
			
			path.setStartPoint(start);
			path.setEndPoint(end);
			
			if(!constraint.isEmpty())
			{
				PointList bends = new PointList(constraint.size());
				for(Bendpoint bp : constraint)
					bends.addPoint(bp.getLocation());
				path.setBendPoints(bends);
			}
			else
				path.setBendPoints(null);
			
			isDirty |= path.isDirty;
		}
		staleConnections.clear();
	}

	void queueSomeRouting()
	{
		if(connectionToPaths == null || connectionToPaths.isEmpty())
			return;
		try
		{
			ignoreInvalidate = true;
			((Connection)connectionToPaths.keySet().iterator().next()).revalidate();
		}
		finally
		{
			ignoreInvalidate = false;
		}
	}

	public void remove(Connection connection)
	{
		staleConnections.remove(connection);
		constraintMap.remove(connection);
		if(connectionToPaths == null) return;
		
		Path path = (Path)connectionToPaths.remove(connection);
		algorithm.removePath(path);
		isDirty = true;
		if(connectionToPaths.isEmpty())
		{
			unhookAll();
			connectionToPaths = null;
		}
		else
			queueSomeRouting();
	}

	void removeChild(IFigure child)
	{
		if(connectionToPaths == null) return;
		Rectangle bounds = child.getBounds().getCopy();
		boolean change = algorithm.removeObstacle(bounds);
		figuresToBounds.remove(child);
		child.removeFigureListener(figureListener);
		if(change)
		{
			isDirty = true;
			queueSomeRouting();
		}
	}

	public void route(Connection conn)
	{
		if(isDirty)
		{
			ignoreInvalidate = true;
			processStaleConnections();
			isDirty = false;
			@SuppressWarnings("unchecked")
			List<Path> updated = algorithm.solve();
			Connection current;
			for(Path path : updated)
			{
				current = (Connection)path.data;
				current.revalidate();
				
				PointList points = path.getPoints().getCopy();
				Point ref1, ref2, start, end;
				ref1 = new PrecisionPoint(points.getPoint(1));
				ref2 = new PrecisionPoint(points.getPoint(points.size() - 2));
				current.translateToAbsolute(ref1);
				current.translateToAbsolute(ref2);
				
				start = current.getSourceAnchor().getLocation(ref1).getCopy();
				end = current.getTargetAnchor().getLocation(ref2).getCopy();
				
				current.translateToRelative(start);
				current.translateToRelative(end);
				points.setPoint(start, 0);
				points.setPoint(end, points.size() - 1);

				current.setPoints(points);
			}
			ignoreInvalidate = false;
		}
	}

	public void setConstraint(Connection connection, Object constraint)
	{
		staleConnections.add(connection);
		constraintMap.put(connection, constraint);
		isDirty = true;
	}

	public void setSpacing(int spacing)
	{
		algorithm.setSpacing(spacing);
	}

//	private Map<Integer, Integer> rowsUsed = new HashMap<Integer, Integer>();
//	private Map<Integer, Integer> colsUsed = new HashMap<Integer, Integer>();
//	private Map<Connection, ReservedInfo> reservedInfo = new HashMap<Connection, ReservedInfo>();
//	private static final int SPACING = 5;
//	private static final int SCALE = 40;
//
//	private class ReservedInfo
//	{
//		public List<Integer> reservedRows = new ArrayList<Integer>(2);
//		public List<Integer> reservedCols = new ArrayList<Integer>(2);
//	}
//
//	private static Ray 	LEFT	= new Ray(-1, 0),
//						RIGHT	= new Ray(1, 0);
//
//	public void invalidate(Connection connection)
//	{
//		removeReservedLines(connection);
//	}
//
//	private int getColumnNear(Connection connection, int r, int n, int x)
//	{
//		int min = Math.min(n, x),
//			max = Math.max(n, x);
//		if(min > r)
//		{
//			max = min;
//			min = r - (min - r);
//		}
//		if(max < r)
//		{
//			min = max;
//			max = r + (r - max);
//		}
//		int proximity = 0;
//		int direction = -1;
//		if(r % 2 == 1)
//			r--;
//		Integer i;
//		while(proximity < r)
//		{
//			i = new Integer(r + proximity * direction);
//			if(!colsUsed.containsKey(i))
//			{
//				colsUsed.put(i, i);
//				reserveColumn(connection, i);
//				return i.intValue();
//			}
//			int j = i.intValue();
//			if(j <= min)
//				return j + SPACING;
//			if(j >= max)
//				return j - SPACING;
//			if(direction == 1)
//				direction = -1;
//			else
//			{
//				direction = 1;
//				proximity += SPACING;
//			}
//		}
//		return r;
//	}
//
//	protected Ray getDirection(Rectangle r, Point p)
//	{
//		int leftDistance = Math.abs(r.x - p.x);
//		int rightDistance = Math.abs(r.right() - p.x);
//		return (rightDistance > leftDistance) ? LEFT : RIGHT;
//	}
//	
//	protected Ray getEndDirection(Connection conn)
//	{
//		IFigure owner = conn.getTargetAnchor().getOwner();
//		Point p = getEndPoint(conn);
//		Rectangle rect;
//		if(owner == null)
//			rect = new Rectangle(p.x - 1, p.y - 1, 2, 2);
//		else
//		{
//			rect = owner.getBounds().getCopy();
//			owner.translateToAbsolute(rect);
//		}
//		return getDirection(rect, p);
//	}
//
//	protected int getRowNear(Connection connection, int r, int n, int x)
//	{
//		int min = Math.min(n, x),
//			max = Math.max(n, x);
//		if(min > r)
//		{
//			max = min;
//			min = r - (min - r);
//		}
//		if(max < r)
//		{
//			min = max;
//			max = r + (r - max);
//		}
//
//		int proximity = 0;
//		int direction = -1;
//		if(r % 2 == 1)
//			r--;
//		Integer i;
//		while(proximity < r)
//		{
//			i = new Integer(r + proximity * direction);
//			if(!rowsUsed.containsKey(i))
//			{
//				rowsUsed.put(i, i);
//				reserveRow(connection, i);
//				return i.intValue();
//			}
//			int j = i.intValue();
//			if(j <= min)
//				return j + SPACING;
//			if(j >= max)
//				return j - SPACING;
//			if(direction == 1)
//				direction = -1;
//			else
//			{
//				direction = 1;
//				proximity += SPACING;
//			}
//		}
//		return r;
//	}
//
//	protected Ray getStartDirection(Connection conn)
//	{
//		IFigure owner = conn.getSourceAnchor().getOwner();
//		Point p = getStartPoint(conn);
//		Rectangle rect;
//		if(owner == null)
//			rect = new Rectangle(p.x - 1, p.y - 1, 2, 2);
//		else
//		{
//			rect = owner.getBounds().getCopy();
//			owner.translateToAbsolute(rect);
//		}
//		return getDirection(rect, p);
//	}
//
//	protected void processPositions(Ray start, Ray end, List<Integer> positions, boolean horizontal, Connection conn)
//	{
//		removeReservedLines(conn);
//
//		int pos[] = new int[positions.size() + 2];
//		if(horizontal)
//			pos[0] = start.x;
//		else
//			pos[0] = start.y;
//		int i;
//		for(i = 0; i < positions.size(); i++)
//		{
//			pos[i + 1] = (positions.get(i)).intValue();
//		}
//		if(horizontal == (positions.size() % 2 == 1))
//			pos[++i] = end.x;
//		else
//			pos[++i] = end.y;
//
//		PointList points = new PointList();
//		points.addPoint(new Point(start.x, start.y));
//		Point p;
//		int current, prev, min, max;
//		boolean adjust;
//		for(i = 2; i < pos.length - 1; i++)
//		{
//			horizontal = !horizontal;
//			prev = pos[i - 1];
//			current = pos[i];
//
//			adjust = (i != pos.length - 2);
//			if(horizontal)
//			{
//				if(adjust)
//				{
//					min = pos[i - 2];
//					max = pos[i + 2];
//					pos[i] = current = getRowNear(conn, current, min, max);
//				}
//				p = new Point(prev, current);
//			}
//			else
//			{
//				if(adjust)
//				{
//					min = pos[i - 2];
//					max = pos[i + 2];
//					pos[i] = current = getColumnNear(conn, current, min, max);
//				}
//				p = new Point(current, prev);
//			}
//			points.addPoint(p);
//		}
//		points.addPoint(new Point(end.x, end.y));
//		conn.setPoints(points);
//	}
//
//	public void remove(Connection connection)
//	{
//		removeReservedLines(connection);
//	}
//
//	protected void removeReservedLines(Connection connection)
//	{
//		ReservedInfo rInfo = (ReservedInfo) reservedInfo.get(connection);
//		if(rInfo == null) 
//			return;
//		
//		for(int i = 0; i < rInfo.reservedRows.size(); i++)
//		{
//			rowsUsed.remove(rInfo.reservedRows.get(i));
//		}
//		for(int i = 0; i < rInfo.reservedCols.size(); i++)
//		{
//			colsUsed.remove(rInfo.reservedCols.get(i));
//		}
//		reservedInfo.remove(connection);
//	}
//
//	protected void reserveColumn(Connection connection, Integer column)
//	{
//		ReservedInfo info = (ReservedInfo) reservedInfo.get(connection);
//		if(info == null)
//		{
//			info = new ReservedInfo();
//			reservedInfo.put(connection, info);
//		}
//		info.reservedCols.add(column);
//	}
//
//	protected void reserveRow(Connection connection, Integer row)
//	{
//		ReservedInfo info = (ReservedInfo) reservedInfo.get(connection);
//		if(info == null)
//		{
//			info = new ReservedInfo();
//			reservedInfo.put(connection, info);
//		}
//		info.reservedRows.add(row);
//	}
//
//	public void route(Connection conn)
//	{
//		if((conn.getSourceAnchor() == null) || (conn.getTargetAnchor() == null)) 
//			return;
//		
//		Point startPoint = getStartPoint(conn);
//		conn.translateToRelative(startPoint);
//		Point endPoint = getEndPoint(conn);
//		conn.translateToRelative(endPoint);
//
//		Ray start = new Ray(startPoint);
//		Ray end = new Ray(endPoint);
//		Ray average = start.getAveraged(end);
//
//		Ray direction = new Ray(start, end);
//		Ray startNormal = getStartDirection(conn);
//		Ray endNormal   = getEndDirection(conn);
//
//		List<Integer> positions = new ArrayList<Integer>(5);
//		boolean horizontal = true;
//		positions.add(new Integer(start.y));
//		horizontal = !horizontal;
//
//		int i;
//		if(startNormal.dotProduct(endNormal) > 0)
//		{
//			//1
//			if(startNormal.dotProduct(direction) >= 0)
//				i = startNormal.similarity(start.getAdded(startNormal.getScaled(SCALE)));
//			else
//				i = endNormal.similarity(end.getAdded(endNormal.getScaled(SCALE)));
//			positions.add(new Integer(i));
//			horizontal = !horizontal;
//		}
//		else
//		{
//			//3 or 1
//			if(startNormal.dotProduct(direction) < 0)
//			{
//				i = startNormal.similarity(start.getAdded(startNormal.getScaled(SCALE)));
//				positions.add(new Integer(i));
//				horizontal = !horizontal;
//			}
//
//			i = horizontal ? average.y : average.x;
//			positions.add(new Integer(i));
//			horizontal = !horizontal;
//
//			if(startNormal.dotProduct(direction) < 0)
//			{
//				i = endNormal.similarity(end.getAdded(endNormal.getScaled(SCALE)));
//				positions.add(new Integer(i));
//				horizontal = !horizontal;
//			}
//		}
//		if(horizontal) 
//			positions.add(new Integer(end.y));
//		else 
//			positions.add(new Integer(end.x));
//		
//		processPositions(start, end, positions, startNormal.isHorizontal(), conn);
//	}
}
