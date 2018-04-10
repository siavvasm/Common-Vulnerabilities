package com.miltos.research.common_vulnerabilites;
import javax.servlet.http.*;

import org.apache.commons.lang3.StringEscapeUtils;

public class XSSInjection extends HttpServlet {

    /* Vulnerable */
    public void vulnerable(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        String data = request.getParameter("name");

        if (data != null){
            response.getWriter().println("<br>bad(): data = " + data);
        }

    }
    
    /* Vulnerable */
    public void clean(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        String data = request.getParameter("name");

        if (data != null) {	
        	data = StringEscapeUtils.escapeHtml4(data);
            response.getWriter().println("<br>bad(): data = " + data);
        }

    }
    
	public static void main(String[] args) {
		

	}

}
