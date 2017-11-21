package com.github.lyhnx.bittrexapiwrapper.api.requests;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.github.lyhnx.bittrexapiwrapper.utils.HmacSHA512;

import static java.lang.String.format;

public class BittrexRequest {
	
	private static final Log LOG = LogFactory.getLog(BittrexRequest.class);
	
	private URI uri;
	private Map<String, String> headers;
	private Map<String, String> params;
	private Object content;
	private RequestMethod method;
	
	public BittrexRequest(URI uri) {
		this(uri, new HashMap<>());
	}

	public BittrexRequest(URI uri, Map<String, String> params) {
		this(uri, RequestMethod.GET, null, new HashMap<>(), params);
	}
	
	public BittrexRequest(URI uri, RequestMethod method, Object content, Map<String, String> headers, Map<String, String> params) {
		this.uri = uri;
		this.method = method;
		this.content = content;
		this.headers = headers;
		this.params = params;
	}
	
	public void setContent(Object content) {
		this.content = content;
	}
	
	public URI getUri() {
		return uri;
	}

	public void setUri(URI url) {
		this.uri = url;
	}

	public String getHeader(String header) {
		return headers.get(header);
	}
	
	/**
	 * Add a single header. Initializes the header map if necessary.
	 * If the key or value is <code>null</code> then this call is ignored.
	 * 
	 * @param header field key
	 * @param value field value
	 */
	public void addHeader(String header, String value) {
		if(this.headers == null) {
			this.headers = new HashMap<>();
		}
		
		this.headers.put(header, value);
	}
	
	/**
	 * Returns all headers used by this request
	 * @return map of headers
	 */
	public Optional<Map<String, String>> getHeaders() {
		return Optional.ofNullable(headers);
	}

	/**
	 * Change all of the current headers at once. This value is nullable
	 * @param headers new headers
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 * Returns all parameters used
	 * @return map of parameters
	 */
	public Optional<Map<String, String>> getParams() {
		return Optional.ofNullable(params);
	}

	/**
	 * Change all parameters. It'll override all of the current data.
	 * This value is nullable.
	 * 
	 * @param params Parameters
	 */
	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	/**
	 * Returns the http request method to use
	 * @return http request method
	 */
	public RequestMethod getMethod() {
		return method;
	}

	/**
	 * Change between http request methods
	 * @param method POST, GET, ...
	 */
	public void setMethod(RequestMethod method) {
		this.method = method;
	}

	/**
	 * Returns the request body
	 * @return request body
	 */
	public Object getContent() {
		return content;
	}
	
	/**
	 * Signs the request with your secret.
	 * 
	 * @param secret your secret
	 */
	public void sign(String secret) {
		final String hash = HmacSHA512.hash(getUri().toString(), secret);
		LOG.debug(format("Signing request for %s with %s", getUri().toString(), hash));
		this.headers.put("apisign", hash);
	}
}
