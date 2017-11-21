package com.github.lyhnx.bittrexapiwrapper.api.requests;

/**
 * @author Lyhnx
 *
 * Collection of known api errors
 */
public enum ApiError {
	APIKEY_INVALID("APIKEY_INVALID", "API Key is invalid"),
	INVALID_MARKET("INVALID_MARKET", "Parameter 'market' is invalid"),
	INVALID_SIGNATURE("INVALID_SIGNATURE", "The provided signature is invalid"),
	INVALID_CURRENCY("INVALID_CURRENCY", "Parameter 'currency' is invalid"),
	QUANTITY_INVALID("QUANTITY_INVALID", "Parameter 'quantity' is invalid"),
	RATE_INVALID("RATE_INVALID", "Parameter 'rate' is invalid"),
	INSUFFICIENT_FUNDS("INSUFFICIENT_FUNDS", "Your funds are insufficient"),
	MIN_TRADE_REQUIREMENT_NOT_MET("MIN_TRADE_REQUIREMENT_NOT_MET", "The amount of coins you want to trade are to low"),
	DUST_TRADE_DISALLOWED_MIN_VALUE_50K_SAT("DUST_TRADE_DISALLOWED_MIN_VALUE_50K_SAT", "Your trade value must be atleast 50k (0.0005)"),
	QUANTITY_NOT_PROVIDED("QUANTITY_NOT_PROVIDED", "Parameter 'quantity' was not provided"),
	RATE_NOT_PROVIDED("RATE_NOT_PROVIDED", "Parameter 'rate' was not provided"),
	DEFAULT("DEFAULT", "Request failed");
	
	private final String name;
	private final String description;
	
	private ApiError(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Returns error name
	 * @return error name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns a short description of this error
	 * @return error description
	 */
	public String getDescription() {
		return description;
	}
	
	public static ApiError byName(String name) {
		for(ApiError error : values()) {
			if(error.getName().equalsIgnoreCase(name)) {
				return error;
			}
		}
		
		return DEFAULT;
	}
}
