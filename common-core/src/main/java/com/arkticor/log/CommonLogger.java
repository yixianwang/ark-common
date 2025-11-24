package com.arkticor.log;

import org.slf4j.Logger;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonLogger {
	private final Logger delegate;

	public void info(String msg) {
		delegate.info("???", msg);
	}
}
