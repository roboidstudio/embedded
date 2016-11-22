package org.roboid.core.runtime;

import org.eclipse.emf.common.util.URI;

public interface IClipLoader
{
	public IClip load(URI uri, boolean audioPreload);
}
