package com.bcp.exchange.handling.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String code;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String code, String message) {
		super(message);
		this.code = code;
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
}