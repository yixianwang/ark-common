package com.arkticor.util;

import org.slf4j.MDC;

/**
 * Utility class for managing trace IDs using SLF4J's Mapped Diagnostic Context
 * (MDC).
 * 
 * <p>
 * Best Practice: The traceId should be set in a Filter/Interceptor at the
 * request entry point:
 * <ul>
 * <li>Extract from HTTP header (X-Trace-Id, X-Request-Id, or traceparent)</li>
 * <li>If not present, generate a new UUID</li>
 * <li>Store in MDC for logging correlation</li>
 * <li>Clean up MDC after request completes</li>
 * </ul>
 * 
 * <p>
 * Example Filter implementation:
 * 
 * <pre>
 * {
 * 	&#64;code
 * 	&#64;Component
 * 	public class TraceIdFilter implements Filter {
 * 		private static final String TRACE_ID_KEY = "traceId";
 * 		private static final String TRACE_ID_HEADER = "X-Trace-Id";
 * 
 * 		@Override
 * 		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
 * 				throws IOException, ServletException {
 * 			try {
 * 				String traceId = extractOrGenerateTraceId((HttpServletRequest) request);
 * 				MDC.put(TRACE_ID_KEY, traceId);
 * 				((HttpServletResponse) response).setHeader(TRACE_ID_HEADER, traceId);
 * 				chain.doFilter(request, response);
 * 			} finally {
 * 				MDC.remove(TRACE_ID_KEY);
 * 			}
 * 		}
 * 
 * 		private String extractOrGenerateTraceId(HttpServletRequest request) {
 * 			String traceId = request.getHeader(TRACE_ID_HEADER);
 * 			return traceId != null && !traceId.isEmpty() ? traceId : UUID.randomUUID().toString();
 * 		}
 * 	}
 * }
 * </pre>
 */
public final class TraceIdUtil {

	/**
	 * MDC key for trace ID. This should match the key used in your
	 * Filter/Interceptor.
	 */
	public static final String TRACE_ID_KEY = "traceId";

	private TraceIdUtil() {
		// Utility class
	}

	/**
	 * Gets the trace ID from MDC (Mapped Diagnostic Context).
	 * 
	 * @return The trace ID if present in MDC, null otherwise
	 */
	public static String getTraceId() {
		return MDC.get(TRACE_ID_KEY);
	}

	/**
	 * Sets the trace ID in MDC (Mapped Diagnostic Context).
	 * 
	 * @param traceId
	 *            The trace ID to set
	 */
	public static void setTraceId(String traceId) {
		if (traceId != null && !traceId.isEmpty()) {
			MDC.put(TRACE_ID_KEY, traceId);
		}
	}

	/**
	 * Removes the trace ID from MDC (Mapped Diagnostic Context). Should be called
	 * in a finally block after request processing completes.
	 */
	public static void clearTraceId() {
		MDC.remove(TRACE_ID_KEY);
	}

	/**
	 * Clears all MDC context. Useful for cleanup after request processing.
	 */
	public static void clearAll() {
		MDC.clear();
	}
}
