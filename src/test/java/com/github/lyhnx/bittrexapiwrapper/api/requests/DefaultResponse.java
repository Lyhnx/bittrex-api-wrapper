package com.github.lyhnx.bittrexapiwrapper.api.requests;

import com.google.gson.GsonBuilder;

public class DefaultResponse {

	private boolean success;
	private String message;
	private Object result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public static String asJson(boolean success, String message, Object result) {
		final DefaultResponse responseObj = new DefaultResponse();
		responseObj.setResult(result);
		responseObj.setSuccess(success);
		responseObj.setMessage(message);
		return new GsonBuilder().setPrettyPrinting().create().toJson(responseObj);
	}
}
