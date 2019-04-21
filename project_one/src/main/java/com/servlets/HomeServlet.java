package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParser; 
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.revature.Beans.Employees;
import com.revature.Service.HomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class HomeServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = 4760485627819196392L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.html").forward(request, response);
	}

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			//check if user exists and if manager id is null
			String email = req.getParameter("email");
			String password = req.getParameter("pwd");
			HttpSession session = req.getSession();
			HomeService home = new HomeService();
			Employees e = home.getDAOEmployee(email, password);
			
			if (home.validateEmployee(email, password)) {
				
				System.out.println(home.validateEmployee(email, password));
				session.setAttribute("employee", e.getId());
				session.setAttribute("email", e.getEmail());
				session.setAttribute("firstname", e.getFirstname());
				session.setAttribute("lastname", e.getLastname());
				if(e.getManagerID() == null) {
				res.sendRedirect("ProfileServlet");
				}else {
					res.sendRedirect("ManagerProfile");
				}
				
			}else {
				//otherwise redirect to login page
				System.out.println(home.validateEmployee(email, password));
				res.sendRedirect("home");
			}
			
			PrintWriter out = res.getWriter();
			out.println("Data:" + email);
			
		}
}
