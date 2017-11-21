package com.github.lyhnx.bittrexapiwrapper.market;

/**
 * @author Lyhnx
 *
 * Just a wrapper for some currency informations which are necessary for bittrex api requests.
 * The <code>name</code> value is just a optional field, which is ignored by all requests. Its up to you if you want to use it.
 * But <code>symbol</code> is pretty much necessary. If you are creating an instance used by a request you should always provide
 * a valid symbol.
 */
public class Currency {
	
	private String name;
	private String symbol;
	
	public Currency(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public Currency(String symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Returns the qualified name for this currency (ie. 'Bitcoin')
	 * @return qualified name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the qualified name for this currency (ie. 'Bitcoin')
	 * @param name the qualified name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the symbol for this currency (ie. 'BTC')
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Returns the symbol of this currency (ie. 'BTC')
	 * @param symbol currency symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", symbol=" + symbol + "]";
	}
}
