package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;
import lombok.Getter;

import java.util.Map;

/**
 * Exception for validation errors. Typically includes field-level validation
 * details.
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * {@code
 * Map<String, String> errors = new HashMap<>();
 * errors.put("email", "Invalid email format");
 * errors.put("age", "Age must be positive");
 * throw new ValidationException("Validation failed", errors);
 * }
 * </pre>
 */
@Getter
public class ValidationException extends BusinessException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a validation exception with default message.
	 */
	public ValidationException() {
		super(ResponseCode.VALIDATION_ERROR);
	}

	/**
	 * Creates a validation exception with a custom message.
	 * 
	 * @param message
	 *            Custom validation error message
	 */
	public ValidationException(String message) {
		super(ResponseCode.VALIDATION_ERROR, message);
	}

	/**
	 * Creates a validation exception with field-level error details.
	 * 
	 * @param message
	 *            Custom validation error message
	 * @param fieldErrors
	 *            Map of field names to error messages
	 */
	public ValidationException(String message, Map<String, String> fieldErrors) {
		super(ResponseCode.VALIDATION_ERROR, message, fieldErrors);
	}

	/**
	 * Creates a validation exception with field-level error details and cause.
	 * 
	 * @param message
	 *            Custom validation error message
	 * @param fieldErrors
	 *            Map of field names to error messages
	 * @param cause
	 *            The cause of this exception
	 */
	public ValidationException(String message, Map<String, String> fieldErrors, Throwable cause) {
		super(ResponseCode.VALIDATION_ERROR, message, fieldErrors, cause);
	}

	/**
	 * Gets field errors as a Map. Returns null if no field errors were provided.
	 * 
	 * @return Map of field names to error messages, or null
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> getFieldErrors() {
		if (getErrorDetails() instanceof Map) {
			return (Map<String, String>) getErrorDetails();
		}
		return null;
	}
}

