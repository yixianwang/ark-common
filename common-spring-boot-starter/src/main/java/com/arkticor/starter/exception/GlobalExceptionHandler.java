package com.arkticor.starter.exception;

import com.arkticor.constant.ResponseCode;
import com.arkticor.exception.BusinessException;
import com.arkticor.exception.TechnicalException;
import com.arkticor.response.CommonResponseVO;
import com.arkticor.util.HttpStatusMapper;
import com.arkticor.util.TraceIdUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Global exception handler for REST API controllers.
 * 
 * <p>
 * This handler automatically converts exceptions to CommonResponseVO with
 * appropriate HTTP status codes. It handles:
 * <ul>
 * <li>Business exceptions (BusinessException, TechnicalException)</li>
 * <li>Validation exceptions (Bean Validation, Spring validation)</li>
 * <li>Spring MVC exceptions (404, 405, etc.)</li>
 * <li>Unexpected exceptions (wrapped as INTERNAL_ERROR)</li>
 * </ul>
 * 
 * <p>
 * The handler automatically includes traceId from MDC in all error responses.
 * 
 * <p>
 * This handler is automatically registered when Spring Web is on the classpath.
 */
@RestControllerAdvice
@ConditionalOnWebApplication
@ConditionalOnClass(name = "org.springframework.web.bind.annotation.RestControllerAdvice")
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * Handles BusinessException - application-level business logic errors.
	 */
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleBusinessException(BusinessException ex) {
		log.warn("Business exception: {}", ex.getMessage(), ex);
		CommonResponseVO<Object> response = CommonResponseVO.error(ex.getResponseCode(), ex.getMessage(),
				TraceIdUtil.getTraceId(), ex.getErrorDetails());
		return ResponseEntity.status(HttpStatusMapper.toHttpStatus(ex.getResponseCode())).body(response);
	}

	/**
	 * Handles TechnicalException - system-level technical errors.
	 */
	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleTechnicalException(TechnicalException ex) {
		log.error("Technical exception: {}", ex.getMessage(), ex);
		CommonResponseVO<Object> response = CommonResponseVO.error(ex.getResponseCode(), ex.getMessage(),
				TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatusMapper.toHttpStatus(ex.getResponseCode())).body(response);
	}

	/**
	 * Handles MethodArgumentNotValidException - Bean Validation errors from
	 * @Valid annotations.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex) {
		Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage,
						(existing, replacement) -> existing + "; " + replacement));
		log.warn("Validation error: {}", fieldErrors);
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.VALIDATION_ERROR,
				"Request validation failed", TraceIdUtil.getTraceId(), fieldErrors);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
	}

	/**
	 * Handles BindException - Binding/validation errors.
	 */
	@ExceptionHandler(BindException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleBindException(BindException ex) {
		Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage,
						(existing, replacement) -> existing + "; " + replacement));
		log.warn("Binding error: {}", fieldErrors);
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.VALIDATION_ERROR,
				"Request binding failed", TraceIdUtil.getTraceId(), fieldErrors);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
	}

	/**
	 * Handles ConstraintViolationException - Bean Validation constraint violations.
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleConstraintViolation(ConstraintViolationException ex) {
		Map<String, String> fieldErrors = ex.getConstraintViolations().stream()
				.collect(Collectors.toMap(violation -> violation.getPropertyPath().toString(),
						ConstraintViolation::getMessage, (existing, replacement) -> existing + "; " + replacement));
		log.warn("Constraint violation: {}", fieldErrors);
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.VALIDATION_ERROR,
				"Constraint validation failed", TraceIdUtil.getTraceId(), fieldErrors);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
	}

	/**
	 * Handles MissingServletRequestParameterException - Missing required request
	 * parameters.
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex) {
		log.warn("Missing request parameter: {}", ex.getParameterName());
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.MISSING_REQUIRED_FIELD,
				String.format("Missing required parameter: %s", ex.getParameterName()), TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * Handles MethodArgumentTypeMismatchException - Type mismatch in method
	 * arguments.
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleMethodArgumentTypeMismatch(
			MethodArgumentTypeMismatchException ex) {
		log.warn("Type mismatch for parameter: {}", ex.getName());
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.INVALID_FORMAT,
				String.format("Invalid format for parameter '%s': expected %s", ex.getName(),
						ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown"),
				TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * Handles HttpMessageNotReadableException - Malformed JSON or request body.
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex) {
		log.warn("Malformed request body: {}", ex.getMessage());
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.INVALID_FORMAT,
				"Malformed request body", TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * Handles HttpRequestMethodNotSupportedException - Unsupported HTTP method.
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex) {
		log.warn("Unsupported HTTP method: {}", ex.getMethod());
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.OPERATION_NOT_ALLOWED,
				String.format("HTTP method '%s' is not supported for this endpoint", ex.getMethod()),
				TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
	}

	/**
	 * Handles NoHandlerFoundException - 404 Not Found.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CommonResponseVO<Object>> handleNoHandlerFound(NoHandlerFoundException ex) {
		log.warn("No handler found: {} {}", ex.getHttpMethod(), ex.getRequestURL());
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.RESOURCE_NOT_FOUND,
				String.format("No handler found for %s %s", ex.getHttpMethod(), ex.getRequestURL()),
				TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	/**
	 * Handles all other unexpected exceptions.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CommonResponseVO<Object>> handleGenericException(Exception ex) {
		log.error("Unexpected exception occurred", ex);
		CommonResponseVO<Object> response = CommonResponseVO.error(ResponseCode.INTERNAL_ERROR,
				"An unexpected error occurred", TraceIdUtil.getTraceId());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}

