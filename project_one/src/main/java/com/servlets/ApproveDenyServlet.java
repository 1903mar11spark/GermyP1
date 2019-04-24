package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Service.HomeService;

/**
 * Servlet implementation class ApproveDenyServlet
 */
@WebServlet("/ApproveDenyServlet")
public class ApproveDenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveDenyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader =  request.getReader();
		StringBuilder buffer = new StringBuilder();
		HomeService home = new HomeService();
		String line;
		
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    
	    String data = buffer.toString();
	    
	    System.out.println(data);
	    if(data.contains("approve")) {
	    	System.out.println(true);
	    	String str = data.replaceAll("\\D+","");
	    	System.out.println(str);
	    	Integer rID = Integer.parseInt(str);
	    	home.Approve(rID);
	    	
	    }else if(data.contains("deny")){
	    	System.out.println(false);
	    	String str = data.replaceAll("\\D+","");
	    	System.out.println(str);
	    	Integer rID = Integer.parseInt(str);
	    	home.Deny(rID);
	    	
	    }
	}

}
