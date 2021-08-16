package com.os.service.exception;

public class DataIntegratyViolationException extends RuntimeException{



	/**
	 * 
	 */
	private static final long serialVersionUID = -4747758604411659613L;

	public DataIntegratyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegratyViolationException(String message) {
		super(message);
	}
}
