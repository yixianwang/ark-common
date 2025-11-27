package com.arkticor.starter.filter;

import com.arkticor.util.TraceIdUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * Example Filter implementation for managing trace IDs in Spring Boot
 * applications.
 * 
 * <p>
 * This filter:
 * <ul>
 * <li>Extracts trace ID from HTTP header (X-Trace-Id, X-Request-Id, or
 * traceparent)</li>
 * <li>Generates a new UUID if no trace ID is present</li>
 * <li>Stores trace ID in MDC for logging correlation</li>
 * <li>Adds trace ID to response headers</li>
 * <li>Cleans up MDC after request completes</li>
 * </ul>
 * 
 * <p>
 * To use this filter, ensure you have spring-boot-starter-web dependency and
 * uncomment the @Component annotation, or create your own filter based on this
 * implementation.
 * 
 * <p>
 * The filter is automatically registered when:
 * <ul>
 * <li>Spring Web is on the classpath</li>
 * <li>Running in a web application context</li>
 * </ul>
 * 
 * <p>
 * You can customize the header names or trace ID generation logic by creating
 * your own filter implementation.
 */
@Component
@Order(1) // Execute early in the filter chain
@ConditionalOnWebApplication
@ConditionalOnClass(name = "jakarta.servlet.Filter")
public class TraceIdFilter implements Filter {

	/**
	 * Standard header names for trace ID propagation
	 */
	private static final String[] TRACE_ID_HEADERS = {"X-Trace-Id", "X-Request-Id", "traceparent"};
	private static final String RESPONSE_HEADER = "X-Trace-Id";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;

			// Extract or generate trace ID
			String traceId = extractOrGenerateTraceId(httpRequest);

			// Store in MDC for logging correlation
			TraceIdUtil.setTraceId(traceId);

			// Add to response header for client correlation
			httpResponse.setHeader(RESPONSE_HEADER, traceId);

			chain.doFilter(request, response);
		} finally {
			// Always clean up MDC to prevent memory leaks
			TraceIdUtil.clearTraceId();
		}
	}

	/**
	 * Extracts trace ID from request headers or generates a new one.
	 * 
	 * @param request
	 *            HTTP servlet request
	 * @return Trace ID (from header or newly generated)
	 */
	private String extractOrGenerateTraceId(HttpServletRequest request) {
		// Check standard trace ID headers
		for (String headerName : TRACE_ID_HEADERS) {
			String traceId = request.getHeader(headerName);
			if (traceId != null && !traceId.isEmpty()) {
				// For traceparent (W3C Trace Context), extract the trace ID part
				if ("traceparent".equals(headerName) && traceId.contains("-")) {
					return traceId.split("-")[1]; // Extract trace ID from traceparent format
				}
				return traceId;
			}
		}

		// Generate new UUID if no trace ID found
		return UUID.randomUUID().toString();
	}
}
