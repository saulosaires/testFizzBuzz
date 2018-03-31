package com.serviceflow.util;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean invalidNumber(Integer number) {

		return number == null || number.intValue() <=0;

	}

}
