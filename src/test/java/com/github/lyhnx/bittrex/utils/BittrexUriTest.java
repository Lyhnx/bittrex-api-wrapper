package com.github.lyhnx.bittrex.utils;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Test;

import com.github.lyhnx.bittrexapiwrapper.api.ApiKey;
import com.github.lyhnx.bittrexapiwrapper.api.BittrexApi;

import static com.github.lyhnx.bittrexapiwrapper.utils.BittrexUri.build;
import static java.lang.String.format;

public class BittrexUriTest {

	private static final String URI_BASE = "https://bittrex.com/api/v1.1";
	
	@Test
	public void buildSimpleUriShouldWork() {
		final String api = "account";
		final String method = "getbalances";
		final String expected = format("%s/%s/%s", URI_BASE, api, method);
		assertEquals("URIs should match", expected, build(api, method).toString());
	}
	
	@Test
	public void buildWithParamsShouldWork() {
		final String api = "account";
		final String method = "getbalances";
		String expected = format("%s/%s/%s?market=%s", URI_BASE, api, method, "BTC-BCC");
		
		final Map<String, String> params = new HashMap<>();
		params.put("market", "BTC-BCC");
		assertEquals("URIs should match", expected, build(api, method, params).toString());

		params.put("currency", "BTC");
		expected = format("%s/%s/%s?market=%s&currency=%s", URI_BASE, api, method, "BTC-BCC", "BTC");
		assertEquals("URIs should match", expected, build(api, method, params).toString());
	}
	
	@Test
	public void buildWithApiKeyShouldWork() {
		final String api = "account";
		final String method = "getbalances";
		final ApiKey apiKey = new ApiKey("157678318627561265126835351235", "4128418478148718741");
		
		// Since its not possible to know the value of nonce it should be compared with the following pattern
		final String pattern = format("%s/%s/%s\\?apikey=%s&nonce=\\d+", URI_BASE, api, method, apiKey.getKey());
		assertTrue("URIs should match pattern", build(api, method, apiKey).toString().matches(pattern));
	}

	@Test
	public void buildWithApiKeyWithParamsShouldWork() {
		final String api = "account";
		final String method = "getbalances";
		final ApiKey apiKey = new ApiKey("157678318627561265126835351235", "4128418478148718741");
		
		final Map<String, String> params = new HashMap<>();
		params.put("market", "BTC-BCC");
		
		// Since its not possible to know the value of nonce it should be compared with the following pattern
		final String pattern = format("%s/%s/%s\\?market=BTC-BCC&apikey=%s&nonce=\\d+", URI_BASE, api, method, apiKey.getKey());
		assertTrue("URIs should match pattern", build(api, method, apiKey, params).toString().matches(pattern));
	}
}
