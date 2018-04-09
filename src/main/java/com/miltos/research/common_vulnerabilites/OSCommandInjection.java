package com.miltos.research.common_vulnerabilites;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OSCommandInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sample = "hello  echo time";
		Pattern p = Pattern.compile("[&]");
		Matcher m = p.matcher(sample);
		if (m.find()){
			System.out.println("Matches!!");
		} else {
			System.out.println("Not Matches");
		}
		
		String newSample = sample.replaceAll("[a-z]", "-");
		System.out.println(newSample);
		
		/*
		 * Solution 1: Just Input Validation
		 */
		String parameter = "123.1 & kill -9 svchost";
		
		Pattern notAllowedCharacters = Pattern.compile("[&]");
		Matcher matcher = notAllowedCharacters.matcher(parameter);
		
		if(!matcher.find()) {
			System.out.println("Execute the command!!!");
		} else {
			System.out.println("Potentially malicious input!!!");
		}
		
		/*
		 * Solution 2: Remove the malicious characters
		 */
		parameter = "123.1 & kill -9 svchost % ere";
		String sanitizedParam = parameter.replaceAll("[&, %]", "");
		System.out.println(sanitizedParam);
		
	}

}
