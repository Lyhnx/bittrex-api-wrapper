package com.github.lyhnx.bittrexapiwrapper.api.requests;

import java.io.IOException;
import java.util.Date;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.github.lyhnx.bittrexapiwrapper.market.Currency;
import com.github.lyhnx.bittrexapiwrapper.utils.gson.BittrexCurrencyGsonTypeAdapter;
import com.github.lyhnx.bittrexapiwrapper.utils.gson.BittrexDateGsonTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DefaultRequestProcessor implements RequestProcessor {
	
	private static final Log LOG = LogFactory.getLog(DefaultRequestProcessor.class);
	
	private final Gson gson;
	private final RequestErrorHandler errorHandler;
	
	public DefaultRequestProcessor() {
		this(new SimpleRequestErrorHandler());
	}
	
	public DefaultRequestProcessor(RequestErrorHandler handler) {
		this.errorHandler = handler;
		// Gson can't parse the given date format by default
		gson = new GsonBuilder()
				.registerTypeAdapter(Date.class, BittrexDateGsonTypeAdapter.getInstance())
				.registerTypeAdapter(Currency.class, BittrexCurrencyGsonTypeAdapter.getInstance())
				.create();
	}
	
	@Override
	public <T> T process(BittrexRequest request, Class<T> clazz) {
		LOG.debug(String.format("Processing request for %s", request.getUri().toString()));
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			final HttpRequestBase getRequest = addHeadersToRequest(request.getMethod() == RequestMethod.GET ? new HttpGet() : new HttpPost(), request);
			final HttpResponse httpResponse = httpClient.execute(getRequest);
			LOG.debug(String.format("Request has processed - STATUS: %s", httpResponse.getStatusLine()));
			final JsonObject element = (JsonObject) new JsonParser().parse(IOUtils.toString(httpResponse.getEntity().getContent()));
			// on success
			if(element.get("success").getAsBoolean()) {
				JsonElement jsonElement = element.get("result");
				LOG.debug(String.format("Trying to parse result to an instance of %s", clazz.getName()));
				return gson.fromJson(jsonElement, clazz);
			} else {
				LOG.debug("Request was not successful");
				errorHandler.handle(element.get("message").getAsString());
			}
		} catch (IOException e) {
			LOG.error(String.format("Failed to execute Response for %s", request.getUri().toString()), e);
		}
		
		return null;
	}
	
	private HttpRequestBase addHeadersToRequest(HttpRequestBase httpRequest, BittrexRequest bittrexRequest) {
		HttpRequestBase httpRequestCopy = null;
		
		try {
			httpRequestCopy = (HttpRequestBase) httpRequest.clone();
		} catch (CloneNotSupportedException e) {
			LOG.error("Could not copy the given instance of HttpRequestBase. Usually this shouldn't happen.", e);
		}
		
		if(bittrexRequest.getHeaders().isPresent()) {
			for(Entry<String, String> header : bittrexRequest.getHeaders().get().entrySet()) {
				httpRequestCopy.addHeader(header.getKey(), header.getValue());
				LOG.debug(String.format("Adding header %s: %s", header.getKey(), header.getValue()));
			}
		}
		
		httpRequestCopy.setURI(bittrexRequest.getUri());
		return httpRequestCopy;
	}
}
