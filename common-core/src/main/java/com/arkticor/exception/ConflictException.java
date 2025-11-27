package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;

/**
 * Exception for resource conflict errors (e.g., duplicate entry, resource
 * already exists).
 */
public class ConflictException extends BusinessException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a conflict exception with default message.
	 */
	public ConflictException() {
		super(ResponseCode.CONFLICT);
	}

	/**
	 * Creates a conflict exception with a custom message.
	 * 
	 * @param message
	 *            Custom error message
	 */
	public ConflictException(String message) {
		super(ResponseCode.CONFLICT, message);
	}
}

