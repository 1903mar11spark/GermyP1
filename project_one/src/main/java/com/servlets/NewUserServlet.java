package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.sql.Blob;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.revature.Service.NewUserService;

/**
 * Servlet implementation class NewUserServlet
 */
@MultipartConfig
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("NewUser.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first = request.getParameter("first");//Keep getting null Values Here
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String mID = request.getParameter("mID");
		Integer newID;
		
		System.out.println(first);
		if (mID == null) {
			 newID = null;
		}else {
			newID = Integer.parseInt(mID);
		}
		
		if (email != null && pass != null && first != null && last != null) {
		NewUserService register = new NewUserService();
		register.CreateUser(first, last, email, pass,newID);
		System.out.println("success" + email);
		response.sendRedirect("home");
		}else {
			System.out.println("New User Empty" +first + last);
			response.sendRedirect("NewUserServlet");
		}
	}

}
