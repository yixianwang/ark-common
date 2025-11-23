package com.arkticor.service;

public class CommonService {

	// Java 25 feature: "Stable Values" or simplified pattern matching can be used
	// here
	public String processData(@Nullable String input) {
		return switch (input) {
			case null -> "Default Value";
			case String s when s.isBlank() -> "Empty Value";
			case String s -> "Processed: " + s.toUpperCase();
		};
	}
}