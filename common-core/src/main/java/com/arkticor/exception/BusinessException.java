package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;
import lombok.Getter;

/**
 * Base exception class for all business logic exceptions in the application.
 * 
 * <p>
 * This exception integrates with the ResponseCode enum to provide consistent
 * error handling across all Spring Boot projects. It should be used for
 * application-level business logic errors that can be handled gracefully.
 * 
 * <p>
 * For technical/system errors (database failures, network issues), use
 * {@link TechnicalException} instead.
 * 
 * @see ResponseCode
 * @see TechnicalException
 */
@Getter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * The response code associated with this exception
	 */
	private final ResponseCode responseCode;

	/**
	 * Optional error details that can be included in the response
	 */
	private final Object errorDetails;

	/**
	 * Creates a business exception with a response code.
	 * 
	 * @param responseCode
	 *            The response code enum
	 */
	public BusinessException(ResponseCode responseCode) {
		super(responseCode.getDefaultMessage());
		this.responseCode = responseCode;
		this.errorDetails = null;
	}

	/**
	 * Creates a business exception with a response code and custom message.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 */
	public BusinessException(ResponseCode responseCode, String message) {
		super(message);
		this.responseCode = responseCode;
		this.errorDetails = null;
	}

	/**
	 * Creates a business exception with a response code, custom message, and error
	 * details.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param errorDetails
	 *            Additional error details (e.g., validation errors)
	 */
	public BusinessException(ResponseCode responseCode, String message, Object errorDetails) {
		super(message);
		this.responseCode = responseCode;
		this.errorDetails = errorDetails;
	}

	/**
	 * Creates a business exception with a response code, custom message, and cause.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param cause
	 *            The cause of this exception
	 */
	public BusinessException(ResponseCode responseCode, String message, Throwable cause) {
		super(message, cause);
		this.responseCode = responseCode;
		this.errorDetails = null;
	}

	/**
	 * Creates a business exception with a response code, custom message, error
	 * details, and cause.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param errorDetails
	 *            Additional error details
	 * @param cause
	 *            The cause of this exception
	 */
	public BusinessException(ResponseCode responseCode, String message, Object errorDetails, Throwable cause) {
		super(message, cause);
		this.responseCode = responseCode;
		this.errorDetails = errorDetails;
	}
}

