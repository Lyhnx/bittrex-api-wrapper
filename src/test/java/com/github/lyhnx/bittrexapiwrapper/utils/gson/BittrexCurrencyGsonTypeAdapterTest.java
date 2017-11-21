package com.github.lyhnx.bittrexapiwrapper.utils.gson;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.lyhnx.bittrexapiwrapper.market.Currency;
import com.github.lyhnx.bittrexapiwrapper.utils.gson.BittrexCurrencyGsonTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static java.lang.String.format;

public class BittrexCurrencyGsonTypeAdapterTest {

	private Gson gson;
	
	@Before
	public void before() {
		this.gson = new GsonBuilder()
				.registerTypeAdapter(Currency.class, BittrexCurrencyGsonTypeAdapter.getInstance())
				.create();
	}
	
	@Test
	public void adapterShouldDeserialize() {
		final String symbol = "BTC";
		final String value = "UnitTest";
		final String json = format("{ \"value\": \"%s\", \"currency\": \"%s\" }", value, symbol);
		final TestObject deserializedObject = gson.fromJson(json, TestObject.class);
		assertTrue("Expecting obj not to be null", deserializedObject != null);
		
		assertTrue("Expected deserialized object to contain a valid currency instance", deserializedObject.currency != null);
		assertEquals(format("Expected deserialized object to contain '%s' as value", value), value, deserializedObject.value);
		assertEquals(format("Expected deserialized object to contain a currency with %s as symbol", symbol), symbol, deserializedObject.currency.getSymbol());
	}
	
	// Inner Testclass 
	private final class TestObject {
		private String value;
		private Currency currency;
	}
}


