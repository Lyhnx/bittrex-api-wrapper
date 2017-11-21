package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.UUID;

import com.github.lyhnx.bittrexapiwrapper.market.Currency;
import com.google.gson.annotations.SerializedName;

public class Balance {

	@SerializedName("Currency")
	private Currency currency;
	
	@SerializedName("Balance")
	private double balance; 
	@SerializedName("Available")
	private double available;
	@SerializedName("Pending")
	private double pending;

	@SerializedName("CryptoAddress")
	private String cryptoAddress;
	
	@SerializedName("Requested")
	private boolean requested;
	
	@SerializedName("Uuid")
	private UUID uuid;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public double getPending() {
		return pending;
	}

	public void setPending(double pending) {
		this.pending = pending;
	}

	public String getCryptoAddress() {
		return cryptoAddress;
	}

	public void setCryptoAddress(String cryptoAddress) {
		this.cryptoAddress = cryptoAddress;
	}

	public boolean isRequested() {
		return requested;
	}

	public void setRequested(boolean requested) {
		this.requested = requested;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Balance [currency=" + currency + ", balance=" + balance + ", available=" + available + ", pending="
				+ pending + ", cryptoAddress=" + cryptoAddress + ", requested=" + requested + ", uuid=" + uuid + "]";
	}
}
