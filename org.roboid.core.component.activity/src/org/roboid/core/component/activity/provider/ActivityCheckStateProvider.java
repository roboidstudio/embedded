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

package org.roboid.core.component.activity.provider;

import org.eclipse.jface.viewers.ICheckStateProvider;
import org.roboid.core.component.activity.AbstractActivity;

/**
 * @author Kwang-Hyun Park
 */
public class ActivityCheckStateProvider implements ICheckStateProvider
{
	@Override
	public boolean isChecked(Object element)
	{
		if(element instanceof AbstractActivity)
			return ((AbstractActivity)element).isEnabled();
		return false;
	}

	@Override
	public boolean isGrayed(Object element)
	{
		return false;
	}
}
