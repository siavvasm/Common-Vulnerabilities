package com.miltos.research.common_vulnerabilites;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

import com.miltos.research.supporting.Request;

public class OSCommandInjection {

	public static void main(String[] args) throws IOException {
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
		 * Solution 1: Input Validation
		 */
		String parameter = "123.1 kill -9 svchost";
		
		Pattern notAllowedCharacters = Pattern.compile("[&]");
		Matcher matcher = notAllowedCharacters.matcher(parameter);
		
		if(!matcher.find()) {
			System.out.println("Execute the command!!!");
			Runtime rt = Runtime.getRuntime();
			Process exec = rt.exec("cmd.exe /C program.exe -value" + parameter);
		} else {
			System.out.println("Potentially malicious input!!!");
		}
		
		/*
		 * Solution 2: Input Sanitization (Neutralization)
		 */
		parameter = "123.1 & kill -9 svchost % ere";
		String sanitizedParam = parameter.replaceAll("[&, %]", "");
		System.out.println(sanitizedParam);
		
		String string = "<script>a simple \"string\"</script>";
		string = StringEscapeUtils.escapeHtml4(string);
		System.out.println(string);
		
	}
	
	public static void solution(Request request) throws IOException {
		/*
		 * Vulnerable code...
		 */
		String parameter = request.getParameter("input");
		Runtime rt = Runtime.getRuntime();
		Process exec = rt.exec("cmd.exe /C program.exe -value" + parameter);
	
		/*
		 * Solution 1: Input Validation
		 */
		parameter = request.getParameter("input");
		
		Pattern nonAllowableChars = Pattern.compile("...RegEx of non-allowable characters...");
		Matcher matcher = nonAllowableChars.matcher(parameter);
		
		if(!matcher.find()) {
			Runtime runTime = Runtime.getRuntime();
			Process execProg = runTime.exec("cmd.exe /C program.exe -value" + parameter);
		} else {
			// Do not execute the command...
			// Inform the user ...
			// Log the event ...
		}
		
		/*
		 * Solution 2: Input Sanitization (Neutralization)
		 */
		parameter = request.getParameter("input");
		String sanitizedParam = parameter.replaceAll("...RegEx of non-allowable characters...", "");
		Runtime runTime = Runtime.getRuntime();
		Process execProg = runTime.exec("cmd.exe /C program.exe -value" + parameter);
	}

}
