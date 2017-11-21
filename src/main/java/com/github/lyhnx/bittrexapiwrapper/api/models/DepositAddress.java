package com.github.lyhnx.bittrexapiwrapper.api.models;

import com.github.lyhnx.bittrexapiwrapper.market.Currency;
import com.google.gson.annotations.SerializedName;

public class DepositAddress {

	@SerializedName("Currency")
	private Currency currency;
	
	@SerializedName("Address")
	private String address;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DepositAddress [currency=" + currency + ", address=" + address + "]";
	}
}
