package com.github.lyhnx.bittrexapiwrapper.market;

/**
 * @author Lyhnx
 *
 *         This class defines all available marketplaces on Bittrex. Each entry
 *         is wrapping a currency object for these currencies. They are used in
 *         requests to create a exchange literal (ie. 'BTC'-'BCC').
 */
public enum BittrexMarket {
	BITCOIN("Bitcoin", "BTC"), ETHEREUM("Ethereum", "ETH"), USDT("USDT", "USDT");

	private Currency currency;

	private BittrexMarket(String name, String symbol) {
		this.currency = new Currency(name, symbol);
	}

	/**
	 * Returns a copy of the currency object related to the market
	 * 
	 * @return currency object
	 */
	public Currency getCurrency() {
		return new Currency(currency.getName(), currency.getSymbol());
	}
}
