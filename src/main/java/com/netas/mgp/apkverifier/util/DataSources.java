package com.netas.mgp.apkverifier.util;

import java.nio.ByteBuffer;

import com.netas.mgp.apkverifier.internal.util.ByteBufferDataSource;

/**
 * Utility methods for working with {@link DataSource} abstraction.
 */
public abstract class DataSources {
	private DataSources() {
	}

	/**
	 * Returns a {@link DataSource} backed by the provided {@link ByteBuffer}. The data source
	 * represents the data contained between the position and limit of the buffer. Changes to the
	 * buffer's contents will be visible in the data source.
	 */
	public static DataSource asDataSource(ByteBuffer buffer) {
		if (buffer == null) {
			throw new NullPointerException();
		}
		return new ByteBufferDataSource(buffer);
	}
}
