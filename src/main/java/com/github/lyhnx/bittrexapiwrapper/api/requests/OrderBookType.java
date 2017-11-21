package com.github.lyhnx.bittrexapiwrapper.api.requests;

public enum OrderBookType {
	BUY("buy"),
	SELL("sell"),
	BOTH("both");
	
	private String type;
	
	private OrderBookType(String type) {
		this.type = type;
	}
	
	public String getQueryString() {
		return "type=" + type;
	}
}
