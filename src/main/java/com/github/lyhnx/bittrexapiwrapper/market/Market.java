package com.github.lyhnx.bittrexapiwrapper.market;

/**
 * @author Lyhnx
 *
 *         This class is used to create the market string literal used my a lot
 *         of requests.
 */
public class Market {

	private BittrexMarket market;
	private Currency currency;

	public Market(BittrexMarket market, Currency currency) {
		this.market = market;
		this.currency = currency;
	}

	public BittrexMarket getMarket() {
		return market;
	}

	/**
	 * Market to use 
	 * @param market base market (ie. 'Bitcoin' for 'BTC-???')
	 */
	public void setMarket(BittrexMarket market) {
		this.market = market;
	}

	/**
	 * Get the underlying currency
	 * @return currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Change the underlying currency
	 * @param currency (ie. ???-currency)
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Creates the full qualified market name (ie. BTC-BCC).
	 * @return full qualified market name
	 */
	public String getMarketName() {
		return String.format("%s-%s", market.getCurrency().getSymbol(), currency.getSymbol());
	}
}
