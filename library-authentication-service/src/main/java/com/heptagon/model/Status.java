package com.heptagon.model;

public class Status {

	public Status(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	private int statusCode;
	private String message;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", message=" + message + "]";
	}
}
