package com.github.lyhnx.bittrexapiwrapper.utils.gson;

import java.lang.reflect.Type;

import com.github.lyhnx.bittrexapiwrapper.market.Currency;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * @author Lyhnx
 *
 *         Gson support for the {@link Currency} class
 */
public class BittrexCurrencyGsonTypeAdapter implements JsonDeserializer<Currency> {

	private static BittrexCurrencyGsonTypeAdapter INSTANCE;

	private BittrexCurrencyGsonTypeAdapter() {
	}

	@Override
	public Currency deserialize(JsonElement element, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		return new Currency(element.getAsString());
	}

	/**
	 * Returns the existing instance or creates a new one
	 * @return instance
	 */
	public static BittrexCurrencyGsonTypeAdapter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BittrexCurrencyGsonTypeAdapter();
		}

		return INSTANCE;
	}
}
