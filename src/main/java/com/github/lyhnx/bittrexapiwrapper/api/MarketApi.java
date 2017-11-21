package com.github.lyhnx.bittrexapiwrapper.api;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.lyhnx.bittrexapiwrapper.api.models.OpenOrder;
import com.github.lyhnx.bittrexapiwrapper.api.requests.BittrexRequest;
import com.github.lyhnx.bittrexapiwrapper.market.Market;
import com.google.gson.JsonElement;

import static com.github.lyhnx.bittrexapiwrapper.utils.BittrexUri.build;
import static com.github.lyhnx.bittrexapiwrapper.utils.MapUtils.putNonNull;
import static org.apache.commons.lang3.Validate.notNull;

public class MarketApi extends PrivateApi {

	private static final String METHOD_BUYLIMIT = "buylimit";
	private static final String METHOD_SELLLIMIT = "selllimit";
	private static final String METHOD_CANCEL = "cancel";
	private static final String METHOD_GETOPENORDERS = "getopenorders";

	public MarketApi(ApiKey apiKey) {
		super(apiKey);
	}

	public MarketApi(String apiKey, String secret) {
		super(apiKey, secret);
	}

	/**
	 * Used to place a buy order in a specific market. Use this method to place
	 * limit orders.
	 * 
	 * @param market
	 *            - <b>[Required]</b> object containing market information (ie.
	 *            currencies).
	 * @param quantity
	 *            - <b>[Required]</b> the amount to purchase
	 * @param rate
	 *            - <b>[Required]</b> the rate at which to place the order.
	 * @return id for your buy order
	 */
	public UUID buyLimit(Market market, double quantity, double rate) {
		notNull(market, "market can't be null!");
		notNull(quantity, "quantity can't be null!");
		notNull(rate, "rate can't be null!");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_MARKET, market.getMarketName());
		params.put(PARAM_QUANTITY, String.valueOf(quantity));
		params.put(PARAM_RATE, BigDecimal.valueOf(rate).toPlainString());

		final BittrexRequest request = new BittrexRequest(
				build(MARKET_API, METHOD_BUYLIMIT, getApiKey(), params));
		final JsonElement response = signAndProcess(request, JsonElement.class);
		final JsonElement uuidAttribute = response.getAsJsonObject().get("uuid");
		return (UUID.fromString(uuidAttribute.getAsString()));
	}

	/**
	 * Used to place a sell order in a specific market. Use this method to place
	 * limit orders.
	 * 
	 * @param market
	 *            - <b>[Required]</b> object containing market information (ie.
	 *            currencies).
	 * @param quantity
	 *            - <b>[Required]</b> the amount to sell
	 * @param rate
	 *            - <b>[Required]</b> the rate at which to place the order.
	 * @return id for your sell order
	 */
	public UUID sellLimit(Market market, double quantity, double rate) {
		notNull(market, "market can't be null!");
		notNull(quantity, "quantity can't be null!");
		notNull(rate, "rate can't be null!");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_MARKET, market.getMarketName());
		params.put(PARAM_QUANTITY, String.valueOf(quantity));
		params.put(PARAM_RATE, BigDecimal.valueOf(rate).toPlainString());

		final BittrexRequest request = new BittrexRequest(
				build(MARKET_API, METHOD_SELLLIMIT, getApiKey(), params));
		final JsonElement response = signAndProcess(request, JsonElement.class);
		final JsonElement uuidAttribute = response.getAsJsonObject().get("uuid");
		return (UUID.fromString(uuidAttribute.getAsString()));
	}

	/**
	 * Used to cancel a buy or sell order.
	 * 
	 * @param uuid
	 *            - <b>[Required]</b> uuid of buy or sell order
	 */
	public void cancel(UUID uuid) {
		notNull(uuid, "uuid can't be null!");

		final Map<String, String> params = new HashMap<>();
		params.put(PARAM_UUID, uuid.toString());

		final BittrexRequest request = new BittrexRequest(
				build(MARKET_API, METHOD_CANCEL, getApiKey(), params));
		signAndProcess(request, Object.class);
	}

	/**
	 * Get all orders that you currently have opened. A specific market can be
	 * requested
	 * 
	 * @param market
	 *            - <b>[Optional]</b> object containing market information (ie.
	 *            currencies).
	 * @return all of your open orders
	 */
	public OpenOrder[] getOpenOrders(Market market) {
		final Map<String, String> params = new HashMap<>();
		if(market != null) {
			putNonNull(params, PARAM_MARKET, market.getMarketName());
		}
		
		final BittrexRequest request = new BittrexRequest(build(MARKET_API, METHOD_GETOPENORDERS, getApiKey(), params));
		return signAndProcess(request, OpenOrder[].class);
	}
}
