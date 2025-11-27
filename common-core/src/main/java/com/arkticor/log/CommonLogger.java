package com.arkticor.log;

import org.slf4j.Logger;
import org.slf4j.Marker;

import lombok.RequiredArgsConstructor;

/**
 * A comprehensive logger wrapper around SLF4J Logger.
 * 
 * This class provides all standard logging methods (trace, debug, info, warn,
 * error) with support for parameterized messages, exceptions, and markers.
 * 
 * @see org.slf4j.Logger
 */
@RequiredArgsConstructor
public class CommonLogger {
	private final Logger delegate;

	// ==================== Level Checking Methods ====================

	/**
	 * Is the logger instance enabled for the TRACE level?
	 */
	public boolean isTraceEnabled() {
		return delegate.isTraceEnabled();
	}

	/**
	 * Is the logger instance enabled for the TRACE level for the given marker?
	 */
	public boolean isTraceEnabled(Marker marker) {
		return delegate.isTraceEnabled(marker);
	}

	/**
	 * Is the logger instance enabled for the DEBUG level?
	 */
	public boolean isDebugEnabled() {
		return delegate.isDebugEnabled();
	}

	/**
	 * Is the logger instance enabled for the DEBUG level for the given marker?
	 */
	public boolean isDebugEnabled(Marker marker) {
		return delegate.isDebugEnabled(marker);
	}

	/**
	 * Is the logger instance enabled for the INFO level?
	 */
	public boolean isInfoEnabled() {
		return delegate.isInfoEnabled();
	}

	/**
	 * Is the logger instance enabled for the INFO level for the given marker?
	 */
	public boolean isInfoEnabled(Marker marker) {
		return delegate.isInfoEnabled(marker);
	}

	/**
	 * Is the logger instance enabled for the WARN level?
	 */
	public boolean isWarnEnabled() {
		return delegate.isWarnEnabled();
	}

	/**
	 * Is the logger instance enabled for the WARN level for the given marker?
	 */
	public boolean isWarnEnabled(Marker marker) {
		return delegate.isWarnEnabled(marker);
	}

	/**
	 * Is the logger instance enabled for the ERROR level?
	 */
	public boolean isErrorEnabled() {
		return delegate.isErrorEnabled();
	}

	/**
	 * Is the logger instance enabled for the ERROR level for the given marker?
	 */
	public boolean isErrorEnabled(Marker marker) {
		return delegate.isErrorEnabled(marker);
	}

	// ==================== TRACE Level Methods ====================

	/**
	 * Log a message at the TRACE level.
	 */
	public void trace(String msg) {
		delegate.trace(msg);
	}

	/**
	 * Log a message at the TRACE level according to the specified format and
	 * argument.
	 */
	public void trace(String format, Object arg) {
		delegate.trace(format, arg);
	}

	/**
	 * Log a message at the TRACE level according to the specified format and
	 * arguments.
	 */
	public void trace(String format, Object arg1, Object arg2) {
		delegate.trace(format, arg1, arg2);
	}

	/**
	 * Log a message at the TRACE level according to the specified format and
	 * arguments.
	 */
	public void trace(String format, Object... arguments) {
		delegate.trace(format, arguments);
	}

	/**
	 * Log an exception (throwable) at the TRACE level with an accompanying message.
	 */
	public void trace(String msg, Throwable t) {
		delegate.trace(msg, t);
	}

	/**
	 * Log a message with the specific Marker at the TRACE level.
	 */
	public void trace(Marker marker, String msg) {
		delegate.trace(marker, msg);
	}

	/**
	 * Log a message with the specific Marker at the TRACE level according to the
	 * specified format and argument.
	 */
	public void trace(Marker marker, String format, Object arg) {
		delegate.trace(marker, format, arg);
	}

	/**
	 * Log a message with the specific Marker at the TRACE level according to the
	 * specified format and arguments.
	 */
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		delegate.trace(marker, format, arg1, arg2);
	}

	/**
	 * Log a message with the specific Marker at the TRACE level according to the
	 * specified format and arguments.
	 */
	public void trace(Marker marker, String format, Object... arguments) {
		delegate.trace(marker, format, arguments);
	}

	/**
	 * Log an exception (throwable) at the TRACE level with an accompanying message
	 * and a specific Marker.
	 */
	public void trace(Marker marker, String msg, Throwable t) {
		delegate.trace(marker, msg, t);
	}

	// ==================== DEBUG Level Methods ====================

	/**
	 * Log a message at the DEBUG level.
	 */
	public void debug(String msg) {
		delegate.debug(msg);
	}

	/**
	 * Log a message at the DEBUG level according to the specified format and
	 * argument.
	 */
	public void debug(String format, Object arg) {
		delegate.debug(format, arg);
	}

	/**
	 * Log a message at the DEBUG level according to the specified format and
	 * arguments.
	 */
	public void debug(String format, Object arg1, Object arg2) {
		delegate.debug(format, arg1, arg2);
	}

	/**
	 * Log a message at the DEBUG level according to the specified format and
	 * arguments.
	 */
	public void debug(String format, Object... arguments) {
		delegate.debug(format, arguments);
	}

	/**
	 * Log an exception (throwable) at the DEBUG level with an accompanying message.
	 */
	public void debug(String msg, Throwable t) {
		delegate.debug(msg, t);
	}

	/**
	 * Log a message with the specific Marker at the DEBUG level.
	 */
	public void debug(Marker marker, String msg) {
		delegate.debug(marker, msg);
	}

	/**
	 * Log a message with the specific Marker at the DEBUG level according to the
	 * specified format and argument.
	 */
	public void debug(Marker marker, String format, Object arg) {
		delegate.debug(marker, format, arg);
	}

	/**
	 * Log a message with the specific Marker at the DEBUG level according to the
	 * specified format and arguments.
	 */
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		delegate.debug(marker, format, arg1, arg2);
	}

	/**
	 * Log a message with the specific Marker at the DEBUG level according to the
	 * specified format and arguments.
	 */
	public void debug(Marker marker, String format, Object... arguments) {
		delegate.debug(marker, format, arguments);
	}

	/**
	 * Log an exception (throwable) at the DEBUG level with an accompanying message
	 * and a specific Marker.
	 */
	public void debug(Marker marker, String msg, Throwable t) {
		delegate.debug(marker, msg, t);
	}

	// ==================== INFO Level Methods ====================

	/**
	 * Log a message at the INFO level.
	 */
	public void info(String msg) {
		delegate.info(msg);
	}

	/**
	 * Log a message at the INFO level according to the specified format and
	 * argument.
	 */
	public void info(String format, Object arg) {
		delegate.info(format, arg);
	}

	/**
	 * Log a message at the INFO level according to the specified format and
	 * arguments.
	 */
	public void info(String format, Object arg1, Object arg2) {
		delegate.info(format, arg1, arg2);
	}

	/**
	 * Log a message at the INFO level according to the specified format and
	 * arguments.
	 */
	public void info(String format, Object... arguments) {
		delegate.info(format, arguments);
	}

	/**
	 * Log an exception (throwable) at the INFO level with an accompanying message.
	 */
	public void info(String msg, Throwable t) {
		delegate.info(msg, t);
	}

	/**
	 * Log a message with the specific Marker at the INFO level.
	 */
	public void info(Marker marker, String msg) {
		delegate.info(marker, msg);
	}

	/**
	 * Log a message with the specific Marker at the INFO level according to the
	 * specified format and argument.
	 */
	public void info(Marker marker, String format, Object arg) {
		delegate.info(marker, format, arg);
	}

	/**
	 * Log a message with the specific Marker at the INFO level according to the
	 * specified format and arguments.
	 */
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		delegate.info(marker, format, arg1, arg2);
	}

	/**
	 * Log a message with the specific Marker at the INFO level according to the
	 * specified format and arguments.
	 */
	public void info(Marker marker, String format, Object... arguments) {
		delegate.info(marker, format, arguments);
	}

	/**
	 * Log an exception (throwable) at the INFO level with an accompanying message
	 * and a specific Marker.
	 */
	public void info(Marker marker, String msg, Throwable t) {
		delegate.info(marker, msg, t);
	}

	// ==================== WARN Level Methods ====================

	/**
	 * Log a message at the WARN level.
	 */
	public void warn(String msg) {
		delegate.warn(msg);
	}

	/**
	 * Log a message at the WARN level according to the specified format and
	 * argument.
	 */
	public void warn(String format, Object arg) {
		delegate.warn(format, arg);
	}

	/**
	 * Log a message at the WARN level according to the specified format and
	 * arguments.
	 */
	public void warn(String format, Object arg1, Object arg2) {
		delegate.warn(format, arg1, arg2);
	}

	/**
	 * Log a message at the WARN level according to the specified format and
	 * arguments.
	 */
	public void warn(String format, Object... arguments) {
		delegate.warn(format, arguments);
	}

	/**
	 * Log an exception (throwable) at the WARN level with an accompanying message.
	 */
	public void warn(String msg, Throwable t) {
		delegate.warn(msg, t);
	}

	/**
	 * Log a message with the specific Marker at the WARN level.
	 */
	public void warn(Marker marker, String msg) {
		delegate.warn(marker, msg);
	}

	/**
	 * Log a message with the specific Marker at the WARN level according to the
	 * specified format and argument.
	 */
	public void warn(Marker marker, String format, Object arg) {
		delegate.warn(marker, format, arg);
	}

	/**
	 * Log a message with the specific Marker at the WARN level according to the
	 * specified format and arguments.
	 */
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		delegate.warn(marker, format, arg1, arg2);
	}

	/**
	 * Log a message with the specific Marker at the WARN level according to the
	 * specified format and arguments.
	 */
	public void warn(Marker marker, String format, Object... arguments) {
		delegate.warn(marker, format, arguments);
	}

	/**
	 * Log an exception (throwable) at the WARN level with an accompanying message
	 * and a specific Marker.
	 */
	public void warn(Marker marker, String msg, Throwable t) {
		delegate.warn(marker, msg, t);
	}

	// ==================== ERROR Level Methods ====================

	/**
	 * Log a message at the ERROR level.
	 */
	public void error(String msg) {
		delegate.error(msg);
	}

	/**
	 * Log a message at the ERROR level according to the specified format and
	 * argument.
	 */
	public void error(String format, Object arg) {
		delegate.error(format, arg);
	}

	/**
	 * Log a message at the ERROR level according to the specified format and
	 * arguments.
	 */
	public void error(String format, Object arg1, Object arg2) {
		delegate.error(format, arg1, arg2);
	}

	/**
	 * Log a message at the ERROR level according to the specified format and
	 * arguments.
	 */
	public void error(String format, Object... arguments) {
		delegate.error(format, arguments);
	}

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying message.
	 */
	public void error(String msg, Throwable t) {
		delegate.error(msg, t);
	}

	/**
	 * Log a message with the specific Marker at the ERROR level.
	 */
	public void error(Marker marker, String msg) {
		delegate.error(marker, msg);
	}

	/**
	 * Log a message with the specific Marker at the ERROR level according to the
	 * specified format and argument.
	 */
	public void error(Marker marker, String format, Object arg) {
		delegate.error(marker, format, arg);
	}

	/**
	 * Log a message with the specific Marker at the ERROR level according to the
	 * specified format and arguments.
	 */
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		delegate.error(marker, format, arg1, arg2);
	}

	/**
	 * Log a message with the specific Marker at the ERROR level according to the
	 * specified format and arguments.
	 */
	public void error(Marker marker, String format, Object... arguments) {
		delegate.error(marker, format, arguments);
	}

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying message
	 * and a specific Marker.
	 */
	public void error(Marker marker, String msg, Throwable t) {
		delegate.error(marker, msg, t);
	}

	// ==================== Convenience Methods ====================

	/**
	 * Get the name of this logger instance.
	 */
	public String getName() {
		return delegate.getName();
	}

	/**
	 * Get the underlying SLF4J Logger delegate.
	 * 
	 * @return the SLF4J Logger instance
	 */
	public Logger getDelegate() {
		return delegate;
	}
}
