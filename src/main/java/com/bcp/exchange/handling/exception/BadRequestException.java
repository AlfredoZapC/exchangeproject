package com.bcp.exchange.handling.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}