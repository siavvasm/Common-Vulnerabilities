package com.miltos.research.common_vulnerabilites;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ImproperExceptionHandling {
	
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
			Logger.log(e.getMessage());
		} finally {
			// Relese the resource...
		}
	}
}
