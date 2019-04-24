package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.revature.Beans.Employees;
import com.revature.Service.HomeService;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		HomeService emp = new HomeService();
		Employees current = emp.getDAOEmployee(session.getAttribute("Email").toString());
		String pic = request.getParameter("upfile");
		boolean result = false;
		
		if(pic != null) {
		result = emp.upload(pic, session.getAttribute("Email").toString());
		}
		System.out.println("Upload Successful: " + result) ;
		
			response.sendRedirect("ProfileServlet");
		
		//response.setContentType("image/jpg");
		
		
		
		//JSONObject json = new JSONObject();
		
		
		
		
	}

}
