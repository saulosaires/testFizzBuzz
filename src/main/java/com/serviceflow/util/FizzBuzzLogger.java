package com.serviceflow.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FizzBuzzLogger {

	private FizzBuzzLogger() {
		 throw new IllegalStateException("Utility class");
	}
	
	private static final  Logger logger = Logger.getLogger(FizzBuzzLogger.class.getName());
	
	
	public static void logSevere(String msg) {
		logger.log(Level.SEVERE, msg);	
	}

	public static void logWarn(String msg) {
		logger.log(Level.WARNING, msg);	
	}

	
}
