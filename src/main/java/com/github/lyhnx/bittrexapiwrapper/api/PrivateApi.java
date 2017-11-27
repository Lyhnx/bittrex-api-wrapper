package com.github.lyhnx.bittrexapiwrapper.api;


import com.github.lyhnx.bittrexapiwrapper.api.requests.BittrexRequest;

public abstract class PrivateApi extends BittrexApi {
		
	private final ApiKey apiKey;
	
	public PrivateApi(String apiKey, String secret) {
		this(new ApiKey(apiKey, secret));
	}
	
	public PrivateApi(ApiKey apiKey) {
		this.apiKey = new ApiKey(apiKey.getKey(), apiKey.getSecret());
	}
	
	/**
	 * Returns a copy of the used api key
	 * @return api key
	 */
	public ApiKey getApiKey() {
		return new ApiKey(apiKey.getKey(), apiKey.getSecret());
	}
	
	/**
	 * Calls the {@link BittrexRequest#sign(String)} method before processing the request
	 * @param request Request to sign and process
	 * @param <T> target class
	 * @return parsed response as instance of <code>clazz</code>
	 */
	protected <T> T signAndProcess(BittrexRequest request, Class<T> clazz) {
		request.sign(apiKey.getSecret());
		return getRequestProcessor().process(request, clazz);
	}
}
