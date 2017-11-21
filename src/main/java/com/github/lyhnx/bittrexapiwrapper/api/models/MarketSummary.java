package com.github.lyhnx.bittrexapiwrapper.api.models;


import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class MarketSummary {

	@SerializedName("MarketName")
	private String marketName;

	@SerializedName("TimeStamp")
	private Date timestamp;
	@SerializedName("Created")
	private Date created;

	@SerializedName("High")
	private double high;
	@SerializedName("Low")
	private double low;
	@SerializedName("Volume")
	private double volume;
	@SerializedName("BaseVolume")
	private double baseVolume;
	@SerializedName("Bid")
	private double bid;
	@SerializedName("Ask")
	private double ask;
	@SerializedName("PrevDay")
	private double prevDay;

	@SerializedName("OpenBuyOrders")
	private int openBuyOrders;
	@SerializedName("OpenSellOrders")
	private int openSellOrders;

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getBaseVolume() {
		return baseVolume;
	}

	public void setBaseVolume(double baseVolume) {
		this.baseVolume = baseVolume;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getPrevDay() {
		return prevDay;
	}

	public void setPrevDay(double prevDay) {
		this.prevDay = prevDay;
	}

	public int getOpenBuyOrders() {
		return openBuyOrders;
	}

	public void setOpenBuyOrders(int openBuyOrders) {
		this.openBuyOrders = openBuyOrders;
	}

	public int getOpenSellOrders() {
		return openSellOrders;
	}

	public void setOpenSellOrders(int openSellOrders) {
		this.openSellOrders = openSellOrders;
	}

	@Override
	public String toString() {
		return "MarketSummary [marketName=" + marketName + ", timestamp=" + timestamp + ", created=" + created
				+ ", high=" + high + ", low=" + low + ", volume=" + volume + ", baseVolume=" + baseVolume + ", bid="
				+ bid + ", ask=" + ask + ", prevDay=" + prevDay + ", openBuyOrders=" + openBuyOrders
				+ ", openSellOrders=" + openSellOrders + "]";
	}
}
