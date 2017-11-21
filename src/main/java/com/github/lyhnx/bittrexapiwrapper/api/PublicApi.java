package com.github.lyhnx.bittrexapiwrapper.api;

import java.util.HashMap;
import java.util.Map;

import com.github.lyhnx.bittrexapiwrapper.api.models.Currency;
import com.github.lyhnx.bittrexapiwrapper.api.models.MarketHistory;
import com.github.lyhnx.bittrexapiwrapper.api.models.MarketSummary;
import com.github.lyhnx.bittrexapiwrapper.api.models.OrderBook;
import com.github.lyhnx.bittrexapiwrapper.api.models.Ticker;
import com.github.lyhnx.bittrexapiwrapper.api.requests.BittrexRequest;
import com.github.lyhnx.bittrexapiwrapper.api.requests.OrderBookType;
import com.github.lyhnx.bittrexapiwrapper.api.requests.RequestProcessor;
import com.github.lyhnx.bittrexapiwrapper.market.Market;

import static com.github.lyhnx.bittrexapiwrapper.utils.BittrexUri.build;
import static com.github.lyhnx.bittrexapiwrapper.utils.MapUtils.putNonNull;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * @author Lyhnx
 *
 * This class contains all available methods for the Bittrex public api.
 */
public class PublicApi extends BittrexApi {
	
	private static final String METHOD_GETMARKETS = "getmarkets";
	private static final String METHOD_GETCURRENCIES = "getcurrencies";
	private static final String METHOD_GETTICKER = "getticker";
	private static final String METHOD_GETMARKETSUMMARIES = "getmarketsummaries";
	private static final String METHOD_GETMARKETSUMMARY = "getmarketsummary";
	private static final String METHOD_GETORDERBOOK = "getorderbook";
	private static final String METHOD_GETMARKETHISTORY = "getmarkethistory";
	
	public PublicApi() {
		super();
	}
	
	public PublicApi(RequestProcessor processor) {
		super(processor);
	}
	
	/**
	 *  Used to get the open and available trading markets at Bittrex along with other meta data. 
	 * @return market information for all available and open markets
	 */
	public com.github.lyhnx.bittrexapiwrapper.api.models.Market[] getMarkets() {
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETMARKETS));
		return getRequestProcessor().process(request, com.github.lyhnx.bittrexapiwrapper.api.models.Market[].class);
	}
	
	/**
	 * Used to get all supported currencies at Bittrex along with other meta data. 	 * 
	 * @return information about all supported currencies
	 */
	public Currency[] getCurrencies() {
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETCURRENCIES));
		return getRequestProcessor().process(request, Currency[].class);
	}

	/**
 	 * Used to get the current tick values for a market. 	 
 	 * @param market - <b>[Required]</b> object containing market information (ie. currencies).
	 * 
	 * @return ticker for a specific market
	 */
	public Ticker getTicker(Market market) {
		notNull(market, "market can't be null");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_MARKET, market.getMarketName());
		
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETTICKER, params));
		return getRequestProcessor().process(request, Ticker.class);
	}
	
	/**
	 * Used to get the last 24 hour summary of all active exchanges 
	 * 
	 * @return a summary of all active exchanges
	 */
	public MarketSummary[] getMarketSummaries() {
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETMARKETSUMMARIES));
		return getRequestProcessor().process(request, MarketSummary[].class);
	}
	
	/**
	 * Used to get the last 24 hour summary of all active exchanges for a specific market.<br><br>
	 * 
	 * @param market - <b>[Required]</b> object containing market information (ie. currencies).
	 * @return market summary for <code>market</code>
	 */
	public MarketSummary[] getMarketSummary(Market market) {
		notNull(market, "market can't be null");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_MARKET, market.getMarketName());
		
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETMARKETSUMMARY, params));
		return getRequestProcessor().process(request, MarketSummary[].class);
	}
	
	/**
	 * Used to get retrieve the order book for a given market 
	 * @param market - <b>[Required]</b> object containing market information (ie. currencies).
	 * @param type - <b>[Required]</b> order type defined in <code>OrderBookType</code>
	 * 
	 * @return order book for a specific market
	 */
	public OrderBook getOrderBook(Market market, OrderBookType type) {
		notNull(market, "market can't be null");
		notNull(type, "type can't be null");
		
		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_MARKET, market.getMarketName());
		params.put(PARAM_TYPE, type.getQueryString());
		
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETORDERBOOK, params));
		return getRequestProcessor().process(request, OrderBook.class);
	}
	
	/**
	 * Used to retrieve the latest trades that have occured for a specific market. 
	 * @param market - <b>[Required]</b> object containing market information (ie. currencies).
	 * 
	 * @return market history for a specific market
	 */
	public MarketHistory[] getMarketHistory(Market market) {
		notNull(market, "market can't be null");
		
		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_MARKET, market.getMarketName());
		
		final BittrexRequest request = new BittrexRequest(build(PUBLIC_API, METHOD_GETMARKETHISTORY, params));
		return getRequestProcessor().process(request, MarketHistory[].class);
	}
}
