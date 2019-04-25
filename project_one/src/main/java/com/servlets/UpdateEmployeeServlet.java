package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.Beans.Employees;
import com.revature.Service.HomeService;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Update Employee Servlet Called");
		request.getRequestDispatcher("ProfileServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		
		if(session.getAttribute("Manager") == null || session.getAttribute("Manager").toString() == "0") {
		String user = session.getAttribute("Email").toString();
		
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Employees emp = new Employees(first,last,email,pass);
		HomeService home = new HomeService();
		
		if(emp.getFirstname() != null) {
			
			System.out.println("valid user to update:" + emp.getFirstname());
			home.UpdateEmployee(emp,user);
			response.sendRedirect("ProfileServlet");
		
		}else {
			response.sendRedirect("UpdateEmployeeServlet");
		}
			System.out.println("Update Employee:"+ first +". Servlet redirect to Profile (UES Class).");
		}else {
			
			
			
			
			String first = request.getParameter("firstname");
			String last = request.getParameter("lastname");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			Employees emp = new Employees(first,last,email,pass);
			HomeService home = new HomeService();
			
			if(emp.getFirstname() != null) {
				
				System.out.println("valid user to update:" + emp.getFirstname());
				home.ManagerUpdate(emp);
				response.sendRedirect("ManagerProfile");
			
			}else {
				response.sendRedirect("UpdateEmployeeServlet");
			}
		}
	}

}
