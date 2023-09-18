package com.challenge.prices.application.exception;

public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}


}
