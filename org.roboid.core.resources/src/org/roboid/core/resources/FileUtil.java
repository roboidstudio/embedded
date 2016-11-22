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

package org.roboid.core.resources;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

/**
 * @author Kyoung Jin Kim
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public final class FileUtil
{
	private FileUtil()
	{
		throw new AssertionError(); // 내부에서도 객체 생성 방지 (보험)
	}
	
	/**
	 * Returns a file name that is the local equivalent of the supplied file name.
	 * If the specified file name is not a plug-in-relative file name, it is returned as is.
	 * If the specified file name is a plug-in-relative file name of a file (including .jar archive),
	 * it is returned as a locally accessible file name (extracting/caching the file locally, if required).
	 *
	 * @param id bundle id
	 * @param fileName original plug-in-relative file name
	 * @return local equivalent file name
	 * @see Bundle#getResource(String)
	 * @see FileLocator#toFileURL(RUL)
	 */
	public static String toLocalFile(String id, String fileName)
	{
		URL url = Platform.getBundle(id).getResource(fileName);
		try
		{
			url = FileLocator.toFileURL(url);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return url.getFile();
	}
	
	/**
	 * Returns a file path from the supplied file name.
	 * @param fileName file name
	 * @return file path
	 */
	public static String getPath(String fileName)
	{
		String path = "";
		try
		{
			path = new File(fileName).getParentFile().getCanonicalPath();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return path;
	}
	/**
	 * Returns a file path that is the local equivalent path of the supplied file name.
	 * If the specified file name is not a plug-in-relative file name, it is returned as is.
	 * If the specified file name is a plug-in-relative file name of a file (including .jar archive),
	 * it is returned as a locally accessible file path (extracting/caching the file locally, if required).
	 *
	 * @param id bundle id
	 * @param fileName original plug-in-relative file name
	 * @return local equivalent file path
	 * @see FileUtil#toLocalFile(String, String)
	 * @see FileUtil#getPath(String)
	 */
	public static String toLocalPath(String id, String fileName)
	{
		return getPath(toLocalFile(id, fileName));
	}
	
	/**
	 * @param url
	 * @return uri
	 */
	public static URI createURI(String url)
	{
		URI uri = null;
		try
		{
			if(url.startsWith("http://"))
				uri = URI.createURI(url);
			else if(url.startsWith("bundleresource:"))
				uri = URI.createURI(FileLocator.resolve(new URL(url)).toString());
			else if(url.startsWith("file:"))
				uri = URI.createURI(url);
			else
			{
				File file = new File(url);
				if(!file.exists()) return null;
				uri = URI.createFileURI(file.getAbsolutePath());
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return uri;
	}
	
	/**
	 * Add the specified file path into the java.library.path.
	 *
	 * @param path file path
	 */
	public static void addLibraryPath(String path)
	{
		// Reset the "sys_paths" field of the ClassLoader to null.
		try
		{
			Class<ClassLoader> clazz = ClassLoader.class;
			Field field = clazz.getDeclaredField("sys_paths");
			boolean accessible = field.isAccessible();
			if(!accessible)
				field.setAccessible(true);

			// Object originalField = field.get(clazz);

			// Reset it to null so that whenever "System.loadLibrary" is called,
			// it will be reconstructed with the changed value.
			field.set(clazz, null);

			final String propertyName = "java.library.path";
			String libpath = System.getProperty(propertyName, "");
			String ps = File.pathSeparator;
			StringTokenizer tok = new StringTokenizer(libpath, ps);
			ArrayList<String> libPathList = new ArrayList<String>();

			// 라이브러리 패스를 리스트 형태로 읽어오기
			String nextToken;
			while(tok.hasMoreTokens())
			{
				nextToken = tok.nextToken();
				libPathList.add(nextToken);

				// 이미 등록되어 있으면 추가할 필요 없음
				if(nextToken.equals(path))
					return;
			}

			// 없는 패스면 추가
			libPathList.add(path);

			// path 리스트를 스트링 형태로 변환
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < libPathList.size(); i++)
			{
				sb.append(libPathList.get(i));
				if(libPathList.size() > i)
					sb.append(ps);
			}

			try
			{
				System.setProperty(propertyName, sb.toString()); // 패스 지정
			} finally
			{
				// field.set(clazz, originalField);
				field.setAccessible(accessible);
			}
		} catch (SecurityException e1)
		{
			e1.printStackTrace();
		} catch (NoSuchFieldException e1)
		{
			e1.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
}
