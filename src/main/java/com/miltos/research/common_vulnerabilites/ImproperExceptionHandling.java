package com.miltos.research.common_vulnerabilites;

import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;



public class ImproperExceptionHandling {

	final static Logger logger = Logger.getLogger(Logger.class);
	
	public static void vulnerableCode() {
		try {
			FileReader fr = new FileReader("path/to/file");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// Release the resource...
		}
	}
	
	public static void cleanCode() {
		try {
			FileReader fr = new FileReader("path/to/file");
		} catch(IOException e) {
			logger.debug(e.getMessage());
		} finally {
			// Relese the resource...
		}
	}
}
