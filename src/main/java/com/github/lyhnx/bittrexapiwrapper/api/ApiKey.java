package com.github.lyhnx.bittrexapiwrapper.api;

public class ApiKey {
	
	private final String apiKey;
	private final String secret;
	
	public ApiKey(String apiKey, String secret) {
		if(apiKey == null || secret == null) {
			throw new NullPointerException("api key and secret cannot be null!");
		}

		this.apiKey = apiKey;
		this.secret = secret;
	}

	/**
	 * Used to retrieve the stored api key
	 * @return api key
	 */
	public String getKey() {
		return apiKey;
	}
	
	/**
	 * Used to retrieve the secret linked to this api key
	 * @return secret
	 */
	public String getSecret() {
		return secret;
	}
}
