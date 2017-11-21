package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class Withdrawal {

	@SerializedName("PaymentUuid")
	private UUID paymentUUID;

	@SerializedName("Currency")
	private String currency;

	@SerializedName("Amount")
	private double amount;
	@SerializedName("TxCost")
	private double txCost;

	@SerializedName("Address")
	private String address;
	@SerializedName("TxId")
	private String txId;

	@SerializedName("Opened")
	private Date opened;
	
	@SerializedName("Authorized")
	private boolean authorized;
	@SerializedName("PendingPayment")
	private boolean pendingPayment;
	@SerializedName("Canceled")
	private boolean canceled;
	@SerializedName("InvalidAddress")
	private boolean invalidAddress;

	public UUID getPaymentUUID() {
		return paymentUUID;
	}

	public void setPaymentUUID(UUID paymentUUID) {
		this.paymentUUID = paymentUUID;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTxCost() {
		return txCost;
	}

	public void setTxCost(double txCost) {
		this.txCost = txCost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOpened() {
		return opened;
	}

	public void setOpened(Date opened) {
		this.opened = opened;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public boolean isPendingPayment() {
		return pendingPayment;
	}

	public void setPendingPayment(boolean pendingPayment) {
		this.pendingPayment = pendingPayment;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public boolean isInvalidAddress() {
		return invalidAddress;
	}

	public void setInvalidAddress(boolean invalidAddress) {
		this.invalidAddress = invalidAddress;
	}

	@Override
	public String toString() {
		return "Withdrawal [paymentUUID=" + paymentUUID + ", currency=" + currency + ", amount=" + amount + ", txCost="
				+ txCost + ", address=" + address + ", opened=" + opened + ", txId=" + txId + ", authorized="
				+ authorized + ", pendingPayment=" + pendingPayment + ", canceled=" + canceled + ", invalidAddress="
				+ invalidAddress + "]";
	}
}
