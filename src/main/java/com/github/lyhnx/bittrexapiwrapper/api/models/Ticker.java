package com.github.lyhnx.bittrexapiwrapper.api.models;

import com.google.gson.annotations.SerializedName;

public class Ticker {
	
	@SerializedName("Bid")
	private double bid;
	@SerializedName("Ask")
	private double ask;
	@SerializedName("Last")
	private double last;
	
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
	
	public double getLast() {
		return last;
	}
	
	public void setLast(double last) {
		this.last = last;
	}
	@Override
	public String toString() {
		return "Ticker [bid=" + bid + ", ask=" + ask + ", last=" + last + "]";
	}
}
