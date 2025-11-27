package com.arkticor.constant;

/**
 * Common response codes for consistent API responses across all Spring Boot
 * projects.
 */
public enum ResponseCode {
	// Success codes
	SUCCESS("200", "Success"),

	// Client error codes (4xx)
	BAD_REQUEST("400", "Bad Request"), UNAUTHORIZED("401", "Unauthorized"), FORBIDDEN("403", "Forbidden"), NOT_FOUND(
			"404", "Not Found"), METHOD_NOT_ALLOWED("405",
					"Method Not Allowed"), CONFLICT("409", "Conflict"), VALIDATION_ERROR("422", "Validation Error"),

	// Server error codes (5xx)
	INTERNAL_SERVER_ERROR("500", "Internal Server Error"), SERVICE_UNAVAILABLE("503", "Service Unavailable");

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
