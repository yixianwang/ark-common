package com.arkticor.constant;

/**
 * Business logic response codes for consistent API responses across all Spring
 * Boot projects.
 * 
 * These codes represent application-level business logic outcomes, independent
 * of HTTP status codes. They provide more granular error information than HTTP
 * status codes alone.
 */
public enum ResponseCode {
	// Success codes
	SUCCESS("SUCCESS", "Operation completed successfully"),

	// Client error codes - Validation and Input
	VALIDATION_ERROR("VALIDATION_ERROR", "Request validation failed"), BAD_REQUEST("BAD_REQUEST",
			"Invalid request parameters"), MISSING_REQUIRED_FIELD("MISSING_REQUIRED_FIELD",
					"Required field is missing"), INVALID_FORMAT("INVALID_FORMAT", "Invalid data format"),

	// Client error codes - Authentication and Authorization
	UNAUTHORIZED("UNAUTHORIZED", "Authentication required"), FORBIDDEN("FORBIDDEN",
			"Insufficient permissions"), TOKEN_EXPIRED("TOKEN_EXPIRED",
					"Authentication token has expired"), TOKEN_INVALID("TOKEN_INVALID", "Invalid authentication token"),

	// Client error codes - Resource Not Found
	RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", "Requested resource not found"), USER_NOT_FOUND("USER_NOT_FOUND",
			"User not found"), ENTITY_NOT_FOUND("ENTITY_NOT_FOUND", "Entity not found"),

	// Client error codes - Business Logic Conflicts
	CONFLICT("CONFLICT", "Resource conflict detected"), DUPLICATE_ENTRY("DUPLICATE_ENTRY",
			"Duplicate entry detected"), RESOURCE_ALREADY_EXISTS("RESOURCE_ALREADY_EXISTS",
					"Resource already exists"), OPERATION_NOT_ALLOWED("OPERATION_NOT_ALLOWED", "Operation not allowed"),

	// Client error codes - Business Rules
	INSUFFICIENT_BALANCE("INSUFFICIENT_BALANCE", "Insufficient balance"), ACCOUNT_LOCKED("ACCOUNT_LOCKED",
			"Account is locked"), RATE_LIMIT_EXCEEDED("RATE_LIMIT_EXCEEDED", "Rate limit exceeded"),

	// Server error codes
	INTERNAL_ERROR("INTERNAL_ERROR", "Internal server error occurred"), SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE",
			"Service temporarily unavailable"), DATABASE_ERROR("DATABASE_ERROR",
					"Database operation failed"), EXTERNAL_SERVICE_ERROR("EXTERNAL_SERVICE_ERROR",
							"External service error"), TIMEOUT("TIMEOUT", "Operation timed out");

	private final String code;
	private final String defaultMessage;

	ResponseCode(String code, String defaultMessage) {
		this.code = code;
		this.defaultMessage = defaultMessage;
	}

	public String getCode() {
		return code;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
}
