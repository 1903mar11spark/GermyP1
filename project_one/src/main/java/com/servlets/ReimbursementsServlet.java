package com.servlets;

import com.revature.Beans.ReimbursementsReq;
import com.revature.Service.ReimbursementService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		PrintWriter out = response.getWriter();
		List<ReimbursementsReq> view = new ArrayList<>();
		ReimbursementService reim = new ReimbursementService();
		view = reim.GetAllReimbursement();
		
		JSONObject json = new JSONObject();
		
		response.setContentType("application/json");
		
		for(ReimbursementsReq c : view) {
				try {
				
					json.put("Reimbursements", c.getFirstname().toString());
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReimbursementService reim = new ReimbursementService();
		
		HttpSession session = request.getSession(false);
		/*Blobs: 1. Create an object of type Part, 2. Request to get a parameter that matches the name of an input from your HTML file.
		 * For me, that parameter was "uploadFile". In the form that surrounds the upload button and other information relevant to Reimbursement
		 * requests I have a value enctype="multipart/form-data" and a @MultipartConfig tag at the top my servlet. This may or may not be necessary.
		 * 3. Create InputStream obj, then set it equal to InputStreamObject.getInputStream(). 4. Send InmputStream Object to DAO.
		 * 5. In your DAO set your parameter in your SQL query as setBlob such like this smt.setBlob(1, req.getImg());
		 * Note: getImage method is of type InputStream and is a part of my Reimbursement Request Class.*/
		
		Part filePart = request.getPart("uploadFile");
		InputStream fileContent = null;
		

		if(filePart != null) {
         fileContent = filePart.getInputStream();
		
		}else {System.out.println("File empty");}
		
		String amount = request.getParameter("amount");
		String cat = request.getParameter("category");
		String script = request.getParameter("description");
		String first = session.getAttribute("First").toString();
		String last = session.getAttribute("Last").toString();
		String email = session.getAttribute("Email").toString();
		String mID = session.getAttribute("Manager").toString();
		String eID = session.getAttribute("Employee").toString();
	
		
		if(fileContent != null) {
			Integer newid = Integer.parseInt(eID);
			Integer newmanager = Integer.parseInt(mID);
			Double newamount = Double.parseDouble(amount);
			
			ReimbursementsReq req = new ReimbursementsReq(fileContent,newamount,newid,first,last,email,newmanager,script,cat);
			
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
