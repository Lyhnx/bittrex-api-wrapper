package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Market {

	@SerializedName("MarketCurrency")
	private String marketCurrency;
	
	@SerializedName("BaseCurrency")
	private String baseCurrency;
	
	@SerializedName("MarketCurrencyLong")
	private String marketCurrencyLong;
	
	@SerializedName("BaseCurrencyLong")
	private String baseCurrencyLong;
	
	@SerializedName("MinTradeSize")
	private double minTradeSize;
	
	@SerializedName("MarketName")
	private String marketName;
	
	@SerializedName("IsActive")
	private String active;
	
	@SerializedName("Created")
	private Date created;

	public String getMarketCurrency() {
		return marketCurrency;
	}

	public void setMarketCurrency(String marketCurrency) {
		this.marketCurrency = marketCurrency;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getMarketCurrencyLong() {
		return marketCurrencyLong;
	}

	public void setMarketCurrencyLong(String marketCurrencyLong) {
		this.marketCurrencyLong = marketCurrencyLong;
	}

	public String getBaseCurrencyLong() {
		return baseCurrencyLong;
	}

	public void setBaseCurrencyLong(String baseCurrencyLong) {
		this.baseCurrencyLong = baseCurrencyLong;
	}

	public double getMinTradeSize() {
		return minTradeSize;
	}

	public void setMinTradeSize(double minTradeSize) {
		this.minTradeSize = minTradeSize;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Market [marketCurrency=" + marketCurrency + ", baseCurrency=" + baseCurrency + ", marketCurrencyLong="
				+ marketCurrencyLong + ", baseCurrencyLong=" + baseCurrencyLong + ", minTradeSize=" + minTradeSize
				+ ", marketName=" + marketName + ", active=" + active + ", created=" + created + "]";
	}
}
