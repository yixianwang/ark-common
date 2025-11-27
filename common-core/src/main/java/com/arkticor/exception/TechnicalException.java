package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;
import lombok.Getter;

/**
 * Exception class for technical/system-level errors that are not related to
 * business logic.
 * 
 * <p>
 * Use this exception for:
 * <ul>
 * <li>Database connection failures</li>
 * <li>External service unavailability</li>
 * <li>Network timeouts</li>
 * <li>System configuration errors</li>
 * </ul>
 * 
 * <p>
 * For business logic errors (validation, business rules), use
 * {@link BusinessException} instead.
 * 
 * @see BusinessException
 */
@Getter
public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * The response code associated with this exception
	 */
	private final ResponseCode responseCode;

	/**
	 * Creates a technical exception with a response code.
	 * 
	 * @param responseCode
	 *            The response code enum (typically INTERNAL_ERROR,
	 *            SERVICE_UNAVAILABLE, DATABASE_ERROR, etc.)
	 */
	public TechnicalException(ResponseCode responseCode) {
		super(responseCode.getDefaultMessage());
		this.responseCode = responseCode;
	}

	/**
	 * Creates a technical exception with a response code and custom message.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 */
	public TechnicalException(ResponseCode responseCode, String message) {
		super(message);
		this.responseCode = responseCode;
	}

	/**
	 * Creates a technical exception with a response code, custom message, and cause.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param cause
	 *            The underlying cause of this exception
	 */
	public TechnicalException(ResponseCode responseCode, String message, Throwable cause) {
		super(message, cause);
		this.responseCode = responseCode;
	}
}

