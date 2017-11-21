package com.github.lyhnx.bittrexapiwrapper.api.requests;

import static com.github.lyhnx.bittrexapiwrapper.api.requests.ApiError.byName;
import static java.lang.String.format;

import com.github.lyhnx.bittrexapiwrapper.exceptions.BittrexRequestException;

public class SimpleRequestErrorHandler implements RequestErrorHandler {
	
	@Override
	public void handle(String errorMessage) {
		final ApiError error = byName(errorMessage);
		throw new BittrexRequestException(format("[%s] %s", errorMessage, error.getDescription()));
	}
}
