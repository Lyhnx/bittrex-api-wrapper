package com.github.lyhnx.bittrexapiwrapper.utils.gson;

import java.util.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.github.lyhnx.bittrexapiwrapper.utils.gson.BittrexDateGsonTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static java.util.Calendar.YEAR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.DECEMBER;
import static java.lang.String.format;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.MILLISECOND;


public class BittrexDateGsonTypeAdapterTest {

	private Gson gson;
	
	@Before
	public void before() {
		this.gson = new GsonBuilder()
				.registerTypeAdapter(Date.class, BittrexDateGsonTypeAdapter.getInstance())
				.create();
	}
	
	@Test
	public void adapterShouldDeserialize() {
		final String value = "UnitTest";
		final String dateAsString = "2017-11-20T19:24:50.16";
		final String json = createJson(value, dateAsString);
		final TestObject deserializedObject = gson.fromJson(json, TestObject.class);
		assertTrue("Expecting obj not to be null", deserializedObject != null);
		
		assertTrue("Expected deserialized object to contain a valid date instance", deserializedObject.date != null);
		assertEquals(format("Expected deserialized object to contain '%s' as value", value), value, deserializedObject.value);
		assertEquals("Expected deserialized object to contain the correct date", 
				createDate(2017, NOVEMBER, 20, 19, 24, 50, 16).getTime(), deserializedObject.date.getTime());
	}
	
	@Test
	public void adapterShouldParseTwoDigitMs() {
		final String value = "UnitTest";
		final String dateAsString = "2018-12-21T20:30:50.99";
		final String json = createJson(value, dateAsString);
		final TestObject deserializedObject = gson.fromJson(json, TestObject.class);
		assertEquals("Date with two digit ms should be parsed correctly", 
				createDate(2018, DECEMBER, 21, 20, 30, 50, 99).getTime(), deserializedObject.date.getTime());
	}
	
	@Test
	public void adapterShouldParseThreeDigitMs() {
		final String value = "UnitTest";
		final String dateAsString = "2018-12-21T11:19:25.210";
		final String json = createJson(value, dateAsString);
		final TestObject deserializedObject = gson.fromJson(json, TestObject.class);
		assertEquals("Date with three digit ms should be parsed correctly", 
				createDate(2018, DECEMBER, 21, 11, 19, 25, 210).getTime(), deserializedObject.date.getTime());
	}
	
	@Test
	public void adapterShouldParseOneDigitSeconds() {
		final String value = "UnitTest";
		final String dateAsString = "2018-12-21T11:19:2.15";
		final String json = createJson(value, dateAsString);
		final TestObject deserializedObject = gson.fromJson(json, TestObject.class);
		assertEquals("Date with one digit seconds should be parsed correctly", 
				createDate(2018, DECEMBER, 21, 11, 19, 2, 15).getTime(), deserializedObject.date.getTime());
	}
	
	private String createJson(String value, String date) {
		return format("{ \"value\": \"%s\", \"date\": \"%s\" }", value, date);
	}
	
	// Month should always be month - 1 (ie. Calendar.NOVEMBER)
	private Date createDate(int year, int month, int day, int hour, int minute, int seconds, int millis) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR, year);
		calendar.set(MONTH, month);
		calendar.set(DAY_OF_MONTH, day);
		calendar.set(HOUR_OF_DAY, hour);
		calendar.set(MINUTE, minute);
		calendar.set(SECOND, seconds);
		calendar.set(MILLISECOND, millis);
		return calendar.getTime();
	}
	
	private final class TestObject {
		private String value;
		private Date date;
	}
}
