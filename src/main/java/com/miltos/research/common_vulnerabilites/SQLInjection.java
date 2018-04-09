package com.miltos.research.common_vulnerabilites;

import java.sql.PreparedStatement;

import com.miltos.research.supporting.Connection;
import com.miltos.research.supporting.Request;

public class SQLInjection {
	
	Connection conn = new Connection();

	/** Vulnerable **/
	public static void vulnerableCode(Request request) {
		
		// 1. Read the parameters from the request
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		// 2. Construct the query
		String query = "SELECT * FROM Users WHERE Users.firstname = '"
						+ firstName + "' AND Users.surname = '"
						+ lastName +"'";
		
		// 3. Submit the query
		try {
			Statement statement = conn.createStatement("");
		 	ResultSet results = statement.executeQuery(query);
		}
	}
	
	/** Clean **/
	public static void cleanCode(Request request) {
		
		// 1. Read the parameters from the request
		// They still require validation
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		// 2. Construct the query
		String query = "SELECT * FROM Users WHERE Users.firstname = '?' AND Users.surname = '?'";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		
		// 3. Submit the query
		try {
			ResultSet results = pstmt.execute( );;
		}
	}

}
