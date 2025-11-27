package com.arkticor.exception;

import com.arkticor.constant.ResponseCode;

/**
 * Exception for resource not found errors.
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * {@code
 * throw new NotFoundException("User with ID 123 not found");
 * throw new NotFoundException("User", "123"); // "User with ID 123 not found"
 * }
 * </pre>
 */
public class NotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a not found exception with a default message.
	 */
	public NotFoundException() {
		super(ResponseCode.RESOURCE_NOT_FOUND);
	}

	/**
	 * Creates a not found exception with a custom message.
	 * 
	 * @param message
	 *            Custom error message
	 */
	public NotFoundException(String message) {
		super(ResponseCode.RESOURCE_NOT_FOUND, message);
	}

	/**
	 * Creates a not found exception for a specific resource type and ID.
	 * 
	 * @param resourceType
	 *            The type of resource (e.g., "User", "Order")
	 * @param resourceId
	 *            The ID of the resource that was not found
	 */
	public NotFoundException(String resourceType, String resourceId) {
		super(ResponseCode.RESOURCE_NOT_FOUND, String.format("%s with ID %s not found", resourceType, resourceId));
	}
}

