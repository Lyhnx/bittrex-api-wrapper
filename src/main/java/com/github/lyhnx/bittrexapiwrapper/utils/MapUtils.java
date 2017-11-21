package com.github.lyhnx.bittrexapiwrapper.utils;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static java.lang.String.format;

/**
 * @author Lyhnx
 *
 *         Provides utility methods for Map operations
 */
public class MapUtils {

	private static final Log LOG = LogFactory.getLog(MapUtils.class);

	/**
	 * It'll check your key and value first and if none of them is
	 * <code>null</code> they'll be added to <code>map</code>. If one of them is
	 * <code>null</code> then nothing happens
	 * 
	 * @param map
	 *            map to put the given key value pair
	 * @param key
	 * @param value
	 */
	public static <T, Z> void putNonNull(Map<T, Z> map, T key, Z value) {
		LOG.debug(format("putNonNull was called [Key=%s, Value=%s]", key, value));
		if (value != null && key != null) {
			map.put(key, value);
		}
	}
}
