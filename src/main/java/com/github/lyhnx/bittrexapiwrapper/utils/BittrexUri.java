package com.github.lyhnx.bittrexapiwrapper.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import org.apache.http.client.utils.URIBuilder;

import com.github.lyhnx.bittrexapiwrapper.api.ApiKey;

/**
 * 
 * @author Lyhnx
 *
 *         Class used to easily generate Bittrex API URIs
 */
public class BittrexUri {

	private static String SCHEME = "https";
	private static String HOST = "bittrex.com";
	private static String API_PATH = "/api";
	private static String VERSION = "v1.1";

	private BittrexUri() {
	}

	/**
	 * Creates a URI for the requested api and method =>
	 * [bittrex-api-url]/[version]/[api]/[method]
	 * 
	 * @param api
	 *            API to use
	 * @param method
	 *            String literal representing the methodname

	 * @return Bittrex API URI
	 */
	public static URI build(String api, String method) {
		return build(api, method, new HashMap<>());
	}
	
	/**
	 * Creates a URI for the requested api and method =>
	 * [bittrex-api-url]/[version]/[api]/[method] Since an <code>ApiKey</code>
	 * is provided it will add the <code>apikey</code> and <code>nonce</code> as
	 * well.
	 * 
	 * @param api
	 *            API to use
	 * @param method
	 *            String literal representing the methodname
	 * @param apiKey
	 *            key is used to build the uri and to create the sign
	 * @param params
	 *            URI Parameter
	 * @return Bittrex API URI
	 */
	public static URI build(String api, String method, ApiKey apiKey) {
		return build(api, method, apiKey, new HashMap<>());
	}
	
	/**
	 * Creates a URI for the requested api and method =>
	 * [bittrex-api-url]/[version]/[api]/[method]
	 * 
	 * @param api
	 *            API to use
	 * @param method
	 *            String literal representing the methodname
	 * @param params
	 *            URI Parameter
	 * @return Bittrex API URI
	 */
	public static URI build(String api, String method, Map<String, String> params) {
		final URIBuilder builder = new URIBuilder();
		builder.setScheme(SCHEME);
		builder.setHost(HOST);
		builder.setPath(String.format("%s/%s/%s/%s", API_PATH, VERSION, api, method));
		if(params == null) {
			params = new HashMap<>();
		}
		
		for(Entry<String, String> paramEntry : params.entrySet()) {
			builder.addParameter(paramEntry.getKey(), paramEntry.getValue());
		}

		try {
			return builder.build();
		} catch (URISyntaxException e) {
			// Do
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Creates a URI for the requested api and method =>
	 * [bittrex-api-url]/[version]/[api]/[method] Since an <code>ApiKey</code>
	 * is provided it will add the <code>apikey</code> and <code>nonce</code> as
	 * well.
	 * 
	 * @param api
	 *            API to use
	 * @param method
	 *            String literal representing the methodname
	 * @param apiKey
	 *            key is used to build the uri and to create the sign
	 * @param params
	 *            URI Parameter
	 * @return Bittrex API URI
	 */
	public static URI build(String api, String method, ApiKey apiKey, Map<String, String> params) {
		final Map<String, String> parameters = params != null ? params : new HashMap<>();
		parameters.put("apikey", apiKey.getKey());
		parameters.put("nonce", String.valueOf(System.currentTimeMillis()));
		return build(api, method, parameters);
	}
}
