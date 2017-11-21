package com.github.lyhnx.bittrexapiwrapper.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.github.lyhnx.bittrexapiwrapper.api.requests.DefaultRequestProcessor;
import com.github.lyhnx.bittrexapiwrapper.api.requests.RequestProcessor;

import static org.apache.commons.lang3.Validate.notNull;
import static java.lang.String.format;
/**
 * @author Lyhnx
 *
 * This class serves as parent class for all Api Subclasses (ie {@link AccountApi}).
 */
public abstract class BittrexApi {
	
	private static final Log LOG = LogFactory.getLog(BittrexApi.class);
	
	protected static final String PUBLIC_API = "public";
	protected static final String MARKET_API = "market";
	protected static final String ACCOUNT_API = "account";
	
	protected static final String PARAM_MARKET = "market";
	protected static final String PARAM_QUANTITY = "quantity";
	protected static final String PARAM_RATE = "rate";
	protected static final String PARAM_UUID = "uuid";
	protected static final String PARAM_TYPE = "type";
	protected static final String PARAM_CURRENCY = "currency"; 
	protected static final String PARAM_ADDRESS = "address";
	protected static final String PARAM_PAYMENTID = "paymentid";
	
	private RequestProcessor processor;
	
	protected BittrexApi() {
		this(new DefaultRequestProcessor());
	}
	
	protected BittrexApi(RequestProcessor processor) {
		setRequestProcessor(processor);
	}
	
	/**
	 * Sets the <code>RequestProcessor</code> used to process api requests.
	 * By default {@link DefaultRequestProcessor} is used.
	 * 
	 * @param processor to process api requests. Can't be null!
	 */
	public void setRequestProcessor(RequestProcessor processor) {
		notNull(processor, "processor can't be null!");
		LOG.debug(format("RequestProcessor has beend changed from %s to an instance of %s", getRequestProcessor() != null ? getRequestProcessor().getClass().getName() : "none", processor.getClass().getName()));
		this.processor = processor;
	}
	
	protected RequestProcessor getRequestProcessor() {
		return this.processor;
	}
	
}
