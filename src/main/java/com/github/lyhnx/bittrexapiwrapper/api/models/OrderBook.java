package com.github.lyhnx.bittrexapiwrapper.api.models;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class OrderBook {

	private QuantityRate[] buy;
	private QuantityRate[] sell;

	public QuantityRate[] getBuy() {
		return buy;
	}

	public void setBuy(QuantityRate[] buy) {
		this.buy = buy;
	}

	public QuantityRate[] getSell() {
		return sell;
	}

	public void setSell(QuantityRate[] sell) {
		this.sell = sell;
	}

	@Override
	public String toString() {
		return "OrderBook [buy=" + Arrays.toString(buy) + ", sell=" + Arrays.toString(sell) + "]";
	}
}

class QuantityRate {

	@SerializedName("Quantity")
	private double quantity;
	@SerializedName("Rate")
	private double rate;

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "QuantityRate [quantity=" + quantity + ", rate=" + rate + "]";
	}
}
