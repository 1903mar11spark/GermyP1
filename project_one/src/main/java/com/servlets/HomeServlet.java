package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.json.JSONException;


import com.revature.Beans.Employees;
import com.revature.Service.HomeService;

import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;


public class HomeServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = 4760485627819196392L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.html").forward(request, response);
	}

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			String email = req.getParameter("email");
			String password = req.getParameter("pwd");
			//false param prevents the servlet from creating a new session if one does not already exist:
			HttpSession session = req.getSession();
			//Create HomeService obj to check for valid user. This method calls another Method in HomeDAOImpl
			
			HomeService home = new HomeService();
			Employees e = home.getDAOEmployee(email, password);
			
			//If user valid set session attributes
			System.out.println("CHECK POINT: " + email + e.getEmail());
			
			if ( e != null ) {
				
				System.out.println(home.validateEmployee(email, password));
				
				//session.setAttribute("Employee", e.getId().toString());
				session.setAttribute("Email", e.getEmail().toString());
				session.setAttribute("First", e.getFirstname());
				session.setAttribute("Last", e.getLastname());
				session.setAttribute("Manager", e.getManagerID().toString());
				session.setAttribute("Employee", e.getId().toString());
				
				if(e.getManagerID() == null || e.getManagerID() == 0) {
					
				
				res.sendRedirect("ProfileServlet");
				}else {
					//if manager id is not null, redirect to home page
					res.sendRedirect("ManagerProfile");
				}
				
			}else {
				
				//if no user exists refresh page page
				System.out.println(home.validateEmployee(email, password));
				res.sendRedirect("home");
			}
			
			
			
		}
}
