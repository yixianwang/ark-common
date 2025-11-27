package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;

/**
 * Exception for authorization errors (user is authenticated but lacks
 * permission).
 */
public class ForbiddenException extends BusinessException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a forbidden exception with default message.
	 */
	public ForbiddenException() {
		super(ResponseCode.FORBIDDEN);
	}

	/**
	 * Creates a forbidden exception with a custom message.
	 * 
	 * @param message
	 *            Custom error message
	 */
	public ForbiddenException(String message) {
		super(ResponseCode.FORBIDDEN, message);
	}
}

