package com.github.lyhnx.bittrexapiwrapper.api.models;

import com.google.gson.annotations.SerializedName;

public class Currency {
	
	@SerializedName("Currency")
	private String currency;
	@SerializedName("CurrencyLong")
	private String currencyLong;
	@SerializedName("CoinType")
	private String coinType;
	@SerializedName("BaseAddress")
	private String baseAddress;
	@SerializedName("Notice")
	private String notice;
	
	@SerializedName("MinConfirmation")
	private int minConfirmation;
	
	@SerializedName("TxFee")
	private double txFee;

	@SerializedName("IsActive")
	private boolean active;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyLong() {
		return currencyLong;
	}

	public void setCurrencyLong(String currencyLong) {
		this.currencyLong = currencyLong;
	}

	public String getCoinType() {
		return coinType;
	}

	public void setCoinType(String coinType) {
		this.coinType = coinType;
	}

	public String getBaseAddress() {
		return baseAddress;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}

	public int getMinConfirmation() {
		return minConfirmation;
	}

	public void setMinConfirmation(int minConfirmation) {
		this.minConfirmation = minConfirmation;
	}

	public double getTxFee() {
		return txFee;
	}

	public void setTxFee(double txFee) {
		this.txFee = txFee;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "Currency [currency=" + currency + ", currencyLong=" + currencyLong + ", coinType=" + coinType
				+ ", baseAddress=" + baseAddress + ", notice=" + notice + ", minConfirmation=" + minConfirmation
				+ ", txFee=" + txFee + ", active=" + active + "]";
	}
}
