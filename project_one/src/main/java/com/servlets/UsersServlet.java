package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Beans.Employees;
import com.revature.Service.HomeService;



/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<Employees> view = new ArrayList<>();
	public HomeService home = new HomeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			view = home.GetAllEmployees();
			
			response.getWriter().write((new ObjectMapper()).writeValueAsString(view));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession(false);
			
			if(session != null) {
				response.setContentType("application/json");
				
				PrintWriter out = response.getWriter();
				JSONObject json = new JSONObject();
				
				json.put("email", session.getAttribute("Email").toString());
				json.put("first", session.getAttribute("First").toString());
				json.put("last", session.getAttribute("Last").toString());
				json.put("employee", session.getAttribute("Employee").toString());
				
				if(session.getAttribute("Manager").toString() != null || session.getAttribute("Manager").toString() != "0") 
				{
					json.put("Manager",session.getAttribute("Manager").toString());
				}
				
					out.print(json);	
			}
		} 
		catch (JSONException e1) 
		{
			e1.printStackTrace();
		}
		
	
	}
}
