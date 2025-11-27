package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;

/**
 * Exception for authentication errors (user is not authenticated).
 */
public class UnauthorizedException extends BusinessException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an unauthorized exception with default message.
	 */
	public UnauthorizedException() {
		super(ResponseCode.UNAUTHORIZED);
	}

	/**
	 * Creates an unauthorized exception with a custom message.
	 * 
	 * @param message
	 *            Custom error message
	 */
	public UnauthorizedException(String message) {
		super(ResponseCode.UNAUTHORIZED, message);
	}
}

