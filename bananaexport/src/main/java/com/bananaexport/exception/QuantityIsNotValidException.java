package com.bananaexport.exception;

public class QuantityIsNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuantityIsNotValidException(String message) {
		super(message);
	}

}
