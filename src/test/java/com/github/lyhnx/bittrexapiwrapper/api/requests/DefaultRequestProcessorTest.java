package com.github.lyhnx.bittrexapiwrapper.api.requests;

import static org.junit.Assert.*;

import java.net.URI;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.lyhnx.bittrexapiwrapper.api.requests.ApiError;
import com.github.lyhnx.bittrexapiwrapper.api.requests.BittrexRequest;
import com.github.lyhnx.bittrexapiwrapper.api.requests.DefaultRequestProcessor;
import com.github.lyhnx.bittrexapiwrapper.exceptions.BittrexRequestException;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class DefaultRequestProcessorTest {
	
	@Rule
	public final WireMockRule wireMockRule = new WireMockRule(9999);
	
	private DefaultRequestProcessor processor;
	
	private final String path = "/api/v1.1/accounts";
	private final String url = "http://localhost:9999" + path;
	
	@Before
	public void before() {
		this.processor = new DefaultRequestProcessor();
		
	}
	
	@Test
	public void processShouldProcessRequest() {
		final BittrexRequest request = new BittrexRequest(URI.create(url));
		final TestObject expectedResult = new TestObject();
		expectedResult.description = "Test Description";
		expectedResult.id = 1337;
		expectedResult.name = "Test";
		stubFor(get(urlEqualTo(path))
				.willReturn(aResponse()
						.withStatus(200)
						.withBody(DefaultResponse.asJson(true, "", expectedResult))));
		
		assertEquals("Processed request should match", expectedResult, processor.process(request, TestObject.class));
	}
	
	@Test(expected=BittrexRequestException.class)
	public void processShouldThrowException() {
		final BittrexRequest request = new BittrexRequest(URI.create(url));
		stubFor(get(urlEqualTo(path))
				.willReturn(aResponse()
						.withStatus(200)
						.withBody(DefaultResponse.asJson(false, ApiError.APIKEY_INVALID.getName(), new TestObject()))));
		processor.process(request, TestObject.class);
	}
	
	private final class TestObject {
		private int id;
		private String name;
		private String description;
		
		@Override
		public boolean equals(Object obj) {
			if(obj != null && obj instanceof TestObject) {
				final TestObject polymorphedObj = (TestObject) obj;
				if(polymorphedObj.description.equals(description) 
						&& polymorphedObj.id == id && polymorphedObj.name.equals(name)) {
					return true;
				}
			}
			
			return false;
		}
	}

}
