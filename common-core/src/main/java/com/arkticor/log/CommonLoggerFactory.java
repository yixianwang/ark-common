package com.arkticor.log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonLoggerFactory {
  
  private static final Map<Logger, CommonLogger> delegates = Collections.synchronizedMap(new HashMap<>());
	
	public static CommonLogger fromSlf4j(Logger delegate) {
		return delegates.computeIfAbsent(delegate, CommonLogger::new);
	}
  
	public static CommonLogger getLogger(Class<?> clazz) {
		return fromSlf4j(LoggerFactory.getLogger(clazz));
	}

	public static CommonLogger getLogger(String name) {
		return fromSlf4j(LoggerFactory.getLogger(name));
	}
	
	private CommonLoggerFactory() {}
}
