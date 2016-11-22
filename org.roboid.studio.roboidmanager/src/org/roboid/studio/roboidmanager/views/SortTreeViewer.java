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

package org.roboid.studio.roboidmanager.views;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

/**
 * @author Kwang-Hyun Park
 */
public class SortTreeViewer extends TreeViewer
{
	public SortTreeViewer(Composite parent)
	{
		super(parent);
	}
	
	public SortTreeViewer(Composite parent, int style)
	{
		super(parent, style);
	}
	
	public SortTreeViewer(Tree tree)
	{
		super(tree);
	}
	
	public void makeAllColumnsSortable()
	{
		setComparator(new TreeComparator());
		
		Tree tree = getTree();
		for(int i = 0; i < tree.getColumnCount(); i ++)
		{
			final int columnIndex = i;
			tree.getColumn(i).addSelectionListener(new SelectionAdapter()
			{
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					updateTreeSorting(columnIndex);
				}
			});
		}
	}
	
	private void updateTreeSorting(int columnIndex)
	{
		TreeComparator comparator = (TreeComparator)getComparator();
		if(columnIndex == comparator.getSortColumn())
			comparator.setAscending(!comparator.isAscending());
		comparator.setSortColumn(columnIndex);
		Tree tree = getTree();
		tree.setSortColumn(tree.getColumn(columnIndex));
		tree.setSortDirection(comparator.isAscending() ? SWT.UP : SWT.DOWN);
		refresh(false);
	}
	
	class TreeComparator extends ViewerComparator
	{
		private int sortColumn = 0;
		private boolean ascending = true;

		public int compare(Viewer viewer, Object e1, Object e2)
		{
			if(viewer instanceof TreeViewer)
			{
				TreeViewer treeViewer = (TreeViewer) viewer;
				IBaseLabelProvider baseLabel = treeViewer.getLabelProvider();
				if(baseLabel instanceof ITableLabelProvider)
				{
					ITableLabelProvider tableProvider = (ITableLabelProvider) baseLabel;
					String e1p = tableProvider.getColumnText(e1, sortColumn);
					String e2p = tableProvider.getColumnText(e2, sortColumn);
					@SuppressWarnings("unchecked")
					int result = getComparator().compare(e1p, e2p);
					return ascending ? result : (-1) * result;
				}
			}

			return super.compare(viewer, e1, e2);
		}

		public int getSortColumn()
		{
			return sortColumn;
		}

		public void setSortColumn(int sortColumn)
		{
			this.sortColumn = sortColumn;
		}

		public boolean isAscending()
		{
			return ascending;
		}

		public void setAscending(boolean ascending)
		{
			this.ascending = ascending;
		}
	}
}
