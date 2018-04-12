package com.miltos.research.common_vulnerabilites;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullPointerDereference {
	
    /* Vulnerable */
    public static void doGetVulnerable(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

        String data = request.getParameter("input");
        
        response.getWriter().println(data);
    }
    
    /* Clean */
    public static void doGetClean(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

        String data = request.getParameter("input");
        
        if (data != null) {
        	response.getWriter().println(data);
        } 
    }
    

	public static void main(String[] args) throws ServletException, IOException {
		/*
		 * 1. Vulnerable Code
		 */
		String input = null;
		
		if (input.equals("auth")) {
			System.out.println("Do something useful");
		} else {
			System.out.println("Not equal");
		}
		
		/*
		 * 2. Clean Code
		 */
		input = null;
		
		if ("auth".equals(input)) {
			System.out.println("Do something useful");
		} else {
			System.out.println("Not equal");
		}

	}

}
