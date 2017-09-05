package com.jamesdschmidt;

public class Console {

	public static String readLine(String prompt) {
		String input = null;
		do {
			input = System.console().readLine(prompt);
		} while (Strings.isEmpty(input));
		return input;
	}
}
