package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class Order {

	@SerializedName("AccountId")
	private UUID accountId;
	@SerializedName("OrderUuid")
	private UUID orderUUID;

	@SerializedName("Exchange")
	private String exchange;
	@SerializedName("Type")
	private String type;
	@SerializedName("Condition")
	private String condition;
	@SerializedName("ConditionTarget")
	private String conditionTarget;
	@SerializedName("Sentinel")
	private String sentinel;

	@SerializedName("Quantity")
	private double quantity;
	@SerializedName("QuantityRemaining")
	private double quantityRemaining;
	@SerializedName("Reserved")
	private double reserved;
	@SerializedName("ReserveRemaining")
	private double reserveRemaining;
	@SerializedName("ComissionReserved")
	private double comissionReserved;
	@SerializedName("ComissionReserveRemaining")
	private double comissionReserveRemaining;
	@SerializedName("ComissionPaid")
	private double comissionPaid;
	@SerializedName("Price")
	private double price;
	@SerializedName("PricePerUnit")
	private double pricePerUnit;

	@SerializedName("Opened")
	private Date opened;
	@SerializedName("TimeStamp")
	private Date closed;

	@SerializedName("IsOpen")
	private boolean open;
	@SerializedName("CancelInitiated")
	private boolean cancelInitiated;
	@SerializedName("IsConditional")
	private boolean conditional;

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public UUID getOrderUUID() {
		return orderUUID;
	}

	public void setOrderUUID(UUID orderUUID) {
		this.orderUUID = orderUUID;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConditionTarget() {
		return conditionTarget;
	}

	public void setConditionTarget(String conditionTarget) {
		this.conditionTarget = conditionTarget;
	}

	public String getSentinel() {
		return sentinel;
	}

	public void setSentinel(String sentinel) {
		this.sentinel = sentinel;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getQuantityRemaining() {
		return quantityRemaining;
	}

	public void setQuantityRemaining(double quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}

	public double getReserved() {
		return reserved;
	}

	public void setReserved(double reserved) {
		this.reserved = reserved;
	}

	public double getReserveRemaining() {
		return reserveRemaining;
	}

	public void setReserveRemaining(double reserveRemaining) {
		this.reserveRemaining = reserveRemaining;
	}

	public double getComissionReserved() {
		return comissionReserved;
	}

	public void setComissionReserved(double comissionReserved) {
		this.comissionReserved = comissionReserved;
	}

	public double getComissionReserveRemaining() {
		return comissionReserveRemaining;
	}

	public void setComissionReserveRemaining(double comissionReserveRemaining) {
		this.comissionReserveRemaining = comissionReserveRemaining;
	}

	public double getComissionPaid() {
		return comissionPaid;
	}

	public void setComissionPaid(double comissionPaid) {
		this.comissionPaid = comissionPaid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Date getOpened() {
		return opened;
	}

	public void setOpened(Date opened) {
		this.opened = opened;
	}

	public Date getClosed() {
		return closed;
	}

	public void setClosed(Date closed) {
		this.closed = closed;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isCancelInitiated() {
		return cancelInitiated;
	}

	public void setCancelInitiated(boolean cancelInitiated) {
		this.cancelInitiated = cancelInitiated;
	}

	public boolean isConditional() {
		return conditional;
	}

	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}

	@Override
	public String toString() {
		return "Order [accountId=" + accountId + ", orderUUID=" + orderUUID + ", exchange=" + exchange + ", type="
				+ type + ", condition=" + condition + ", conditionTarget=" + conditionTarget + ", sentinel=" + sentinel
				+ ", quantity=" + quantity + ", quantityRemaining=" + quantityRemaining + ", reserved=" + reserved
				+ ", reserveRemaining=" + reserveRemaining + ", comissionReserved=" + comissionReserved
				+ ", comissionReserveRemaining=" + comissionReserveRemaining + ", comissionPaid=" + comissionPaid
				+ ", price=" + price + ", pricePerUnit=" + pricePerUnit + ", opened=" + opened + ", timestamp="
				+ closed + ", open=" + open + ", cancelInitiated=" + cancelInitiated + ", conditional=" + conditional
				+ "]";
	}
}
