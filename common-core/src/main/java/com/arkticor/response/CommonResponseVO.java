package com.arkticor.response;

import com.arkticor.constant.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Common response wrapper for consistent API responses across all Spring Boot
 * projects.
 * 
 * @param <T>
 *            The type of data payload
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponseVO<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Business logic response code (e.g., "SUCCESS", "VALIDATION_ERROR",
	 * "RESOURCE_NOT_FOUND"). This is an application-level code that provides
	 * granular error information independent of HTTP status codes.
	 */
	private String code;

	/**
	 * Human-readable message describing the response
	 */
	private String message;

	/**
	 * Response payload data (can be null for error responses)
	 */
	private T data;

	/**
	 * Trace ID for request tracking and debugging
	 */
	private String traceId;

	/**
	 * Creates a successful response with data.
	 * 
	 * @param data
	 *            The response data
	 * @param <T>
	 *            The type of data
	 * @return CommonResponseVO with success code
	 */
	public static <T> CommonResponseVO<T> success(T data) {
		return CommonResponseVO.<T>builder().code(ResponseCode.SUCCESS.getCode())
				.message(ResponseCode.SUCCESS.getDefaultMessage()).data(data).build();
	}

	/**
	 * Creates a successful response with data and custom message.
	 * 
	 * @param data
	 *            The response data
	 * @param message
	 *            Custom success message
	 * @param <T>
	 *            The type of data
	 * @return CommonResponseVO with success code
	 */
	public static <T> CommonResponseVO<T> success(T data, String message) {
		return CommonResponseVO.<T>builder().code(ResponseCode.SUCCESS.getCode()).message(message).data(data).build();
	}

	/**
	 * Creates a successful response with data, message, and traceId.
	 * 
	 * @param data
	 *            The response data
	 * @param message
	 *            Custom success message
	 * @param traceId
	 *            Trace ID for request tracking
	 * @param <T>
	 *            The type of data
	 * @return CommonResponseVO with success code
	 */
	public static <T> CommonResponseVO<T> success(T data, String message, String traceId) {
		return CommonResponseVO.<T>builder().code(ResponseCode.SUCCESS.getCode()).message(message).data(data)
				.traceId(traceId).build();
	}

	/**
	 * Creates an error response with a response code.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param <T>
	 *            The type of data (typically null for errors)
	 * @return CommonResponseVO with error code
	 */
	public static <T> CommonResponseVO<T> error(ResponseCode responseCode) {
		return CommonResponseVO.<T>builder().code(responseCode.getCode()).message(responseCode.getDefaultMessage())
				.build();
	}

	/**
	 * Creates an error response with a response code and custom message.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param <T>
	 *            The type of data (typically null for errors)
	 * @return CommonResponseVO with error code
	 */
	public static <T> CommonResponseVO<T> error(ResponseCode responseCode, String message) {
		return CommonResponseVO.<T>builder().code(responseCode.getCode()).message(message).build();
	}

	/**
	 * Creates an error response with a response code, custom message, and traceId.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param traceId
	 *            Trace ID for request tracking
	 * @param <T>
	 *            The type of data (typically null for errors)
	 * @return CommonResponseVO with error code
	 */
	public static <T> CommonResponseVO<T> error(ResponseCode responseCode, String message, String traceId) {
		return CommonResponseVO.<T>builder().code(responseCode.getCode()).message(message).traceId(traceId).build();
	}

	/**
	 * Creates an error response with a response code, custom message, traceId, and
	 * error data.
	 * 
	 * @param responseCode
	 *            The response code enum
	 * @param message
	 *            Custom error message
	 * @param traceId
	 *            Trace ID for request tracking
	 * @param errorData
	 *            Additional error details
	 * @param <T>
	 *            The type of error data
	 * @return CommonResponseVO with error code
	 */
	public static <T> CommonResponseVO<T> error(ResponseCode responseCode, String message, String traceId,
			T errorData) {
		return CommonResponseVO.<T>builder().code(responseCode.getCode()).message(message).traceId(traceId)
				.data(errorData).build();
	}
}
