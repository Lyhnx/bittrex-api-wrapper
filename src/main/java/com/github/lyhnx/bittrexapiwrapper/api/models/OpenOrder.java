package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class OpenOrder {

	@SerializedName("Uuid")
	private UUID uuid;
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

	@SerializedName("Quantity")
	private double quantity;
	@SerializedName("QuantityRemaining")
	private double quantityRemaining;
	@SerializedName("Limit")
	private double limit;
	@SerializedName("CommissionPaid")
	private double commissionPaid;
	@SerializedName("Price")
	private double price;
	@SerializedName("PricePerUnit")
	private double pricePerUnit;

	@SerializedName("Opened")
	private Date opened;
	@SerializedName("Closed")
	private Date closed;

	@SerializedName("CancelInitiated")
	private boolean cancelInitiated;
	@SerializedName("ImmediateOrCancel")
	private boolean immediateOrCancel;
	@SerializedName("IsConditional")
	private boolean conditional;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
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

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getCommissionPaid() {
		return commissionPaid;
	}

	public void setCommissionPaid(double commissionPaid) {
		this.commissionPaid = commissionPaid;
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

	public boolean isCancelInitiated() {
		return cancelInitiated;
	}

	public void setCancelInitiated(boolean cancelInitiated) {
		this.cancelInitiated = cancelInitiated;
	}

	public boolean isImmediateOrCancel() {
		return immediateOrCancel;
	}

	public void setImmediateOrCancel(boolean immediateOrCancel) {
		this.immediateOrCancel = immediateOrCancel;
	}

	public boolean isConditional() {
		return conditional;
	}

	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}

	@Override
	public String toString() {
		return "OpenOrder [uuid=" + uuid + ", orderUUID=" + orderUUID + ", exchange=" + exchange + ", orderType="
				+ orderType + ", condition=" + condition + ", conditionTarget=" + conditionTarget + ", quantity="
				+ quantity + ", quantityRemaining=" + quantityRemaining + ", limit=" + limit + ", commissionPaid="
				+ commissionPaid + ", price=" + price + ", pricePerUnit=" + pricePerUnit + ", opened=" + opened
				+ ", closed=" + closed + ", cancelInitiated=" + cancelInitiated + ", immediateOrCancel="
				+ immediateOrCancel + ", conditional=" + conditional + "]";
	}
}
