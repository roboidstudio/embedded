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

package kr.robomation.instrument.scope.basic;

import java.util.Arrays;

/**
 * @author Kwang-Hyun Park
 */
public class IntList
{
	private static final int MAX_INDEX = 1000000;
	private int[] data;
	private int size;
	
	public IntList(int initialCapacity)
	{
		if(initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
		this.data = new int[initialCapacity];
	}
	
	public IntList()
	{
		this(10);
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int get(int index)
	{
		checkRange(index);
		return data[index];
	}
	
	public int set(int index, int value)
	{
		checkRange(index);
		int oldValue = data[index];
		data[index] = value;
		return oldValue;
	}
	
	public void setLast(int value)
	{
		if(size == 0) return;
		set(size - 1, value);
	}
	
	public boolean add(int value)
	{
		if(size > MAX_INDEX)
		{
			System.arraycopy(data, 1, data, 0, MAX_INDEX);
			data[MAX_INDEX] = value;
		}
		else
		{
			ensureCapacity(size + 1);
			data[size++] = value;
		}
		return true;
	}
	
	public int remove(int index)
	{
		checkRange(index);
		int oldValue = data[index];
		int numMoved = size - index - 1;
		if(numMoved > 0)
			System.arraycopy(data, index + 1, data, index, numMoved);
		size --;
		return oldValue;
	}
	
	public void clear()
	{
		size = 0;
	}
	
	private void checkRange(int index)
	{
		if(index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	
	public void ensureCapacity(int minCapacity)
	{
		int oldCapacity = data.length;
		if(minCapacity > oldCapacity)
		{
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if(newCapacity < minCapacity)
				newCapacity = minCapacity;
			data = Arrays.copyOf(data, newCapacity);
		}
	}
}
