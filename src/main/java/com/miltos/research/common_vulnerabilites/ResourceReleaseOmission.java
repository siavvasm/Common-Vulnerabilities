package com.miltos.research.common_vulnerabilites;

import java.io.FileWriter;
import java.io.IOException;

public class ResourceReleaseOmission {

	public static void vulnerableCode() {
		
		try {
			// Read the desired file
			FileWriter fw = new FileWriter("path/to/file");
			
			// Do something useful ...

		} catch (IOException e) {
			// Log the event ...
		} 
	}
	
	public static void cleanCode() throws IOException {

		FileWriter fw = null;
		
		try {
			// Read the desired files
			fw = new FileWriter("path/to/file");
			
			// Do something useful ...
			
		} catch (IOException e) {
			// Log the event ...
		} finally {
			
			// Release the resource...
			if(fw != null) {
				System.out.println("Releasing resource 1");
				fw.close();
			}
		}
	}
}
