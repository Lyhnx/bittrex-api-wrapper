package com.github.lyhnx.bittrexapiwrapper.utils.gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * @author Lyhnx
 *
 *         This adapter should handle {@link Date} objects since
 *         <code>Gson</code> is not able to parse the date format provided by
 *         Bittrex correctly
 */
public class BittrexDateGsonTypeAdapter implements JsonDeserializer<Date> {

	private static BittrexDateGsonTypeAdapter INSTANCE;

	private BittrexDateGsonTypeAdapter() {}

	@Override
	public Date deserialize(JsonElement element, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		final StringBuilder patternBuilder = new StringBuilder("yyyy-MM-dd'T'HH:mm:s");
		final int strLength = element.getAsString().length();
		if(strLength > 18) {
			final String[] secondsAndMillis = element.getAsString().split("T")[1].split(":")[2].split("\\.");
			final int secondsDigitCount = secondsAndMillis[0].length();
			if(secondsDigitCount > 1) {
				patternBuilder.append("s");
			}
			
			if(secondsAndMillis.length > 1) {
				for(int i = 0; i < secondsAndMillis[1].length(); i++) {
					patternBuilder.append(i > 0 ? "S" : ".S");
				}
			}
		}
		
		final String pattern = patternBuilder.toString();
		final DateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(element.getAsString());
		} catch (ParseException e) {
			throw new JsonParseException(
					String.format("'%s' could not be parsed using pattern '%s'", element.getAsString(), pattern), e);
		}
	}
	
	/**
	 * Returns the existing instance or creates a new one
	 * 
	 * @return instance
	 */
	public static BittrexDateGsonTypeAdapter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BittrexDateGsonTypeAdapter();
		}

		return INSTANCE;
	}

}
