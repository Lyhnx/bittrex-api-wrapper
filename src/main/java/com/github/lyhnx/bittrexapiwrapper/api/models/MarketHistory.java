package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class MarketHistory {

	@SerializedName("Id")
	private long id;

	@SerializedName("TimeStamp")
	private Date timeStamp;

	@SerializedName("Quantity")
	private double quantity;
	@SerializedName("Price")
	private double price;
	@SerializedName("Total")
	private double total;

	@SerializedName("FillType")
	private String fillType;
	@SerializedName("OrderType")
	private String orderType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFillType() {
		return fillType;
	}

	public void setFillType(String fillType) {
		this.fillType = fillType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "MarketHistory [id=" + id + ", timeStamp=" + timeStamp + ", quantity=" + quantity + ", price=" + price
				+ ", total=" + total + ", fillType=" + fillType + ", orderType=" + orderType + "]";
	}
}
