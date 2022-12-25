package com.springboot.exception;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidRequestException() {
		super(String.format("If Possible check your request body"));
	}

}
