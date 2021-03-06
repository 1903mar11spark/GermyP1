package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.Service.NewUserService;

/**
 * Servlet implementation class NewUserServlet
 */

@WebServlet("/NewUserServlet")
@MultipartConfig
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
		//Called after end user clicks Submit in NewUser.html, xmlhttprequest sends data, redirects to same page if null values are passed
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String mID = request.getParameter("managerID");
		Integer newID;

		//if user chooses null has a manager ID to be a reg employee, I check value and parse if to Int if not null
		System.out.println(first);
		if (mID == null || mID.equals("null")) {
			 newID = null;
			 	NewUserService register = new NewUserService();
				register.CreateEmployee(first, last, email, pass);
				System.out.println("Testing if NewUserServlet Call is a Success: " + email);
				response.sendRedirect("home");
		}else {
			newID = Integer.parseInt(mID);
			if (email != null && pass != null && first != null && last != null) {
				NewUserService register = new NewUserService();
				register.CreateUser(first, last, email, pass,newID);
				System.out.println("Testing if NewUserServlet Call is a Success: " + email);
				response.sendRedirect("home");
				}else {
					System.out.println("New User Empty Check (NewUserServlet): " +first + last);
					response.sendRedirect("NewUserServlet");
				}
		}
		
		
	
	}

}
