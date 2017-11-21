package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Deposit {
	
	@SerializedName("Id")
	private long id;
	
	@SerializedName("Amount")
	private double amount;
	
	@SerializedName("Currency")
	private String currency;
	@SerializedName("LastUpdated")
	private Date lastUpdated;
	@SerializedName("TxId")
	private String txId;
	@SerializedName("CryptoAddress")
	private String cryptoAddress;

	@SerializedName("Confirmations")
	private int confirmations;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getCryptoAddress() {
		return cryptoAddress;
	}

	public void setCryptoAddress(String cryptoAddress) {
		this.cryptoAddress = cryptoAddress;
	}

	public int getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(int confirmations) {
		this.confirmations = confirmations;
	}

	@Override
	public String toString() {
		return "Deposit [id=" + id + ", amount=" + amount + ", currency=" + currency + ", lastUpdated=" + lastUpdated
				+ ", txId=" + txId + ", cryptoAddress=" + cryptoAddress + ", confirmations=" + confirmations + "]";
	}
}
