package com.github.lyhnx.bittrexapiwrapper.utils;

import static com.github.lyhnx.bittrexapiwrapper.utils.MapUtils.putNonNull;
import static org.junit.Assert.*;

import java.util.Map;

import java.util.HashMap;

import org.junit.Test;

public class MapUtilsTest {

	@Test
	public void putNonNullShouldWork() {
		final Map<String, String> map = new HashMap<>();
		final String key = "KEY";
		final String value = "VALUE";
		
		putNonNull(map, null, value);
		assertTrue("Map should be empty because key was null", map.size() == 0);
		
		putNonNull(map, key, null);
		assertTrue("Map should be empty because value was null", map.size() == 0);
		
		putNonNull(map, null, null);
		assertTrue("Map should be empty because key and values were null", map.size() == 0);
		
		putNonNull(map, key, value);
		assertTrue("Map should contain key", map.containsKey(key));
		assertTrue("Entry should match value", map.get(key).equals(value));
	}

}
