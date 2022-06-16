package com.bananaexport.exception;

public class CompanyAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompanyAlreadyExistsException(String message) {
		super(message);
	}

}
