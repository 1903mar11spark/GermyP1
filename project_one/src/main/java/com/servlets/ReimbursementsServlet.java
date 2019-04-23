package com.servlets;

import com.revature.Beans.ReimbursementsReq;
import com.revature.Service.ReimbursementService;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ReimbursementsServlet
 */
@WebServlet("/ReimbursementsServlet")
@MultipartConfig
public class ReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReimbursementService reim = new ReimbursementService();
		HttpSession session = request.getSession(false);
		Blob bob = null;
		Part filePart = request.getPart("requestimage");
		
		if(filePart != null) {
        InputStream fileContent = filePart.getInputStream();
		
         bob = (Blob) fileContent;
		}
		
		String amount = request.getParameter("amount");
		String cat = request.getParameter("category");
		String script = request.getParameter("description");
		String first = session.getAttribute("First").toString();
		String last = session.getAttribute("Last").toString();
		String email = session.getAttribute("Email").toString();
		String mID = session.getAttribute("Manager").toString();
		String eID = session.getAttribute("Employee").toString();
		
		if(bob != null) {
			Integer newid = Integer.parseInt(eID);
			Integer newmanager = Integer.parseInt(mID);
			Double newamount = Double.parseDouble(amount);
			
			ReimbursementsReq req = new ReimbursementsReq(bob,newamount,newid,first,last,email,newmanager,script,cat);
			
					try {
						reim.submitRequestWithImage(req);
						response.sendRedirect("ProfileServlet");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}else{
					Integer newid = Integer.parseInt(eID);
					Integer newmanager = Integer.parseInt(mID);
					Double newamount = Double.parseDouble(amount);
					
					ReimbursementsReq req = new ReimbursementsReq(newamount,newid,first,last,email,newmanager,script,cat);
					
					try {
						reim.submitRequest(req);
						response.sendRedirect("ProfileServlet");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
		
		

	}
}
