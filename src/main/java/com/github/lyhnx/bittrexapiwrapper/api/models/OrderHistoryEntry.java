package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class OrderHistoryEntry {

	@SerializedName("OrderUuid")
	private UUID orderUUID;

	@SerializedName("Exchange")
	private String exchange;

	@SerializedName("OrderType")
	private String orderType;
	@SerializedName("Condition")
	private String condition;
	@SerializedName("ConditionTarget")
	private String conditionTarget;

	@SerializedName("Limit")
	private double limit;
	@SerializedName("Quantity")
	private double quantity;
	@SerializedName("QuantityRemaining")
	private double quantityRemaining;
	@SerializedName("Commission")
	private double commission;
	@SerializedName("Price")
	private double price;
	@SerializedName("PricePerUnit")
	private double pricePerUnit;

	@SerializedName("Conditional")
	private boolean conditional;
	@SerializedName("ImmediateOrCancel")
	private boolean immediateOrCancel;

	@SerializedName("TimeStamp")
	private Date timestamp;
	@SerializedName("Closed")
	private Date closed;

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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
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

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
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

	public boolean isConditional() {
		return conditional;
	}

	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}

	public boolean isImmediateOrCancel() {
		return immediateOrCancel;
	}

	public void setImmediateOrCancel(boolean immediateOrCancel) {
		this.immediateOrCancel = immediateOrCancel;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getClosed() {
		return closed;
	}

	public void setClosed(Date closed) {
		this.closed = closed;
	}

	@Override
	public String toString() {
		return "OrderHistoryEntry [orderUUID=" + orderUUID + ", exchange=" + exchange + ", orderType=" + orderType
				+ ", condition=" + condition + ", conditionTarget=" + conditionTarget + ", limit=" + limit
				+ ", quantity=" + quantity + ", quantityRemaining=" + quantityRemaining + ", commission=" + commission
				+ ", price=" + price + ", pricePerUnit=" + pricePerUnit + ", conditional=" + conditional
				+ ", immediateOrCancel=" + immediateOrCancel + ", timestamp=" + timestamp + ", closed=" + closed + "]";
	}

}
