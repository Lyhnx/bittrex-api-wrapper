package com.github.lyhnx.bittrexapiwrapper.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.lyhnx.bittrexapiwrapper.api.models.Balance;
import com.github.lyhnx.bittrexapiwrapper.api.models.Deposit;
import com.github.lyhnx.bittrexapiwrapper.api.models.DepositAddress;
import com.github.lyhnx.bittrexapiwrapper.api.models.Order;
import com.github.lyhnx.bittrexapiwrapper.api.models.OrderHistoryEntry;
import com.github.lyhnx.bittrexapiwrapper.api.models.Withdrawal;
import com.github.lyhnx.bittrexapiwrapper.api.requests.BittrexRequest;
import com.github.lyhnx.bittrexapiwrapper.market.Currency;
import com.github.lyhnx.bittrexapiwrapper.market.Market;
import com.google.gson.JsonElement;

import static com.github.lyhnx.bittrexapiwrapper.utils.BittrexUri.build;
import static com.github.lyhnx.bittrexapiwrapper.utils.MapUtils.putNonNull;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * @author Lyhnx
 *
 * This class contains all available methods for the Bittrex account api.
 */
public class AccountApi extends PrivateApi {

	private static final String METHOD_GETBALANCES = "getbalances";
	private static final String METHOD_GETBALANCE = "getbalance";
	private static final String METHOD_GETDEPOSITADDRESS = "getdepositaddress";
	private static final String METHOD_WITHDRAW = "withdraw";
	private static final String METHOD_GETORDER = "getorder";
	private static final String METHOD_GETORDERHISTORY = "getorderhistory";
	private static final String METHOD_GETWITHDRAWALHISTORY = "getwithdrawalhistory";
	private static final String METHOD_GETDEPOSITHISTORY = "getdeposithistory";

	public AccountApi(ApiKey apiKey) {
		super(apiKey);
	}

	public AccountApi(String apiKey, String secret) {
		super(apiKey, secret);
	}

	/**
	 * Used to retrieve all balances from your account
	 * @return all your balances
	 */
	public Balance[] getBalances() {
		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETBALANCES, getApiKey()));
		return signAndProcess(request, Balance[].class);
	}

	/**
	 * Used to retrieve the balance from your account for a specific currency. 
	 * @param currency - <b>[Required]</b> a currency object storing at least the symbol of a valid currency
	 * @return your balance for <code>currency<code>
	 */
	public Balance getBalance(Currency currency) {
		notNull(currency, "currency can't be null!");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_CURRENCY, currency.getSymbol());

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETBALANCE, getApiKey(), params));
		return signAndProcess(request, Balance.class);
	}

	/**
	 * Used to retrieve an address for a specific currency. If one does not exist, the call will fail and return a <code>DepositAddress</b> instance without address. 
	 * @param currency - <b>[Required]</b> a currency object storing at least the symbol of a valid currency
	 * @return your <code>DepositAddress</code> related to the <code>currency</code>.
	 */
	public DepositAddress getDepositAddress(Currency currency) {
		notNull(currency, "currency can't be null!");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_CURRENCY, currency.getSymbol());

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETDEPOSITADDRESS, getApiKey(), params));
		DepositAddress depositAddress = signAndProcess(request, DepositAddress.class);
		if(depositAddress == null) {
			depositAddress = new DepositAddress();
			depositAddress.setCurrency(currency);
		}
		
		return depositAddress;
	}

	/**
	 * Used to withdraw funds from your account. note: please account for txfee.
	 * @param currency - <b>[Required]</b> currency object representing the withdrawable currency.
	 * @param quantity - <b>[Required]</b> the quantity of coins to withdraw
	 * @param address - <b>[Required]</b> the address where to send the funds.
	 * @param paymentId - <b>[Optional]</b> used for CryptoNotes/BitShareX/Nxt optional field (memo/paymentid)
	 * @return id of your withdrawal process
	 */
	public UUID withdraw(Currency currency, double quantity, String address, String paymentId) {
		notNull(currency, "currency can't be null!");
		notNull(quantity, "quantity can't be null!");
		notNull(address, "address can't be null!");

		final Map<String, String> params = new HashMap<>();
		putNonNull(params, PARAM_CURRENCY, currency.getSymbol());
		putNonNull(params, PARAM_PAYMENTID, paymentId);
		params.put(PARAM_QUANTITY, String.valueOf(quantity));
		params.put(PARAM_ADDRESS, address);

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_WITHDRAW, getApiKey(), params));
		final JsonElement response = signAndProcess(request, JsonElement.class);
		final JsonElement uuidAttribute = response.getAsJsonObject().get("uuid");
		return (UUID.fromString(uuidAttribute.getAsString()));
	}

	/**
	 * Used to retrieve a single order by uuid.
	 * @param uuid - <b>[Required]</b> the uuid of the buy/sell order
	 * @return buy or sell order
	 */
	public Order getOrder(UUID uuid) {
		notNull(uuid, "uuid can't be null!");
		final Map<String, String> params = new HashMap<>();
		params.put(PARAM_UUID, uuid.toString());

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETORDER, getApiKey(), params));
		return signAndProcess(request, Order.class);
	}

	/**
	 * Used to retrieve your order history.
	 * @param market - <b>[Optional]</b> object containing market information (ie. currencies). If ommited, will return for all markets
	 * @return your order history
	 */
	public OrderHistoryEntry[] getOrderHistory(Market market) {
		final Map<String, String> params = new HashMap<>();
		if (market != null) {
			putNonNull(params, PARAM_MARKET, market.getMarketName());
		}

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETORDERHISTORY, getApiKey(), params));
		return signAndProcess(request, OrderHistoryEntry[].class);
	}

	/**
	 * Used to retrieve your withdrawal history.
	 * 
	 * @param currency
	 *            - <b>[Optional]</b> a currency object storing at least the symbol of a valid currency (ie.
	 *            BTC). If currency is null, this method will return the history
	 *            for all currencies
	 * @return your withdrawal history
	 */
	public Withdrawal[] getWithdrawalHistory(Currency currency) {
		final Map<String, String> params = new HashMap<>();
		if (currency != null) {
			putNonNull(params, PARAM_CURRENCY, currency.getSymbol());
		}

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETWITHDRAWALHISTORY, getApiKey(), params));
		return signAndProcess(request, Withdrawal[].class);
	}

	/**
	 * Used to retrieve your deposit history
	 * 
	 * @param currency
	 *            - <b>[Optional]</b> a currency object storing at least the symbol of a valid currency (ie. BTC). If currency is null, this method will return the history
	 *            for all currencies
	 * 
	 * @return your deposit history
	 */
	public Deposit[] getDepositHistory(Currency currency) {
		final Map<String, String> params = new HashMap<>();
		if (currency != null) {
			putNonNull(params, PARAM_CURRENCY, currency.getSymbol());
		}

		final BittrexRequest request = new BittrexRequest(
				build(ACCOUNT_API, METHOD_GETDEPOSITHISTORY, getApiKey(), params));
		return signAndProcess(request, Deposit[].class);
	}

}
