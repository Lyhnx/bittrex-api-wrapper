package com.github.lyhnx.bittrexapiwrapper.api.requests;

public interface RequestErrorHandler {

	void handle(String responseMessage);

}