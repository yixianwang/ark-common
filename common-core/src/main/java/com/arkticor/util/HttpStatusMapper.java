package com.arkticor.util;

import com.arkticor.constant.ResponseCode;

/**
 * Utility class for mapping ResponseCode to HTTP status codes.
 * 
 * <p>
 * This provides a consistent way to convert business logic response codes to
 * appropriate HTTP status codes for REST API responses.
 */
public final class HttpStatusMapper {

	private HttpStatusMapper() {
		// Utility class
	}

	/**
	 * Maps a ResponseCode to an HTTP status code.
	 * 
	 * @param responseCode
	 *            The response code to map
	 * @return The corresponding HTTP status code
	 */
	public static int toHttpStatus(ResponseCode responseCode) {
		return switch (responseCode) {
		// Success
		case SUCCESS -> 200; // OK

		// Client errors - Validation and Input
		case VALIDATION_ERROR, MISSING_REQUIRED_FIELD, INVALID_FORMAT -> 422; // Unprocessable Entity
		case BAD_REQUEST -> 400; // Bad Request

		// Client errors - Authentication and Authorization
		case UNAUTHORIZED, TOKEN_EXPIRED, TOKEN_INVALID -> 401; // Unauthorized
		case FORBIDDEN -> 403; // Forbidden

		// Client errors - Resource Not Found
		case RESOURCE_NOT_FOUND, USER_NOT_FOUND, ENTITY_NOT_FOUND -> 404; // Not Found

		// Client errors - Business Logic Conflicts
		case CONFLICT, DUPLICATE_ENTRY, RESOURCE_ALREADY_EXISTS, OPERATION_NOT_ALLOWED -> 409; // Conflict

		// Client errors - Business Rules
		case INSUFFICIENT_BALANCE, ACCOUNT_LOCKED, RATE_LIMIT_EXCEEDED -> 400; // Bad Request

		// Server errors
		case INTERNAL_ERROR, DATABASE_ERROR, EXTERNAL_SERVICE_ERROR -> 500; // Internal Server Error
		case SERVICE_UNAVAILABLE -> 503; // Service Unavailable
		case TIMEOUT -> 504; // Gateway Timeout
		};
	}
}

