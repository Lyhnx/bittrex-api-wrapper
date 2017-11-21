package com.github.lyhnx.bittrexapiwrapper.api.requests;

@FunctionalInterface
public interface RequestProcessor {

	/**
	 * This method process the request and tries to parse the response to the expected instance of <code>clazz</code>
	 * @param request request to handle
	 * @param clazz expected result
	 * @return instance of <code>clazz</code> representing the result
	 */
	<T> T process(BittrexRequest request, Class<T> clazz);

}