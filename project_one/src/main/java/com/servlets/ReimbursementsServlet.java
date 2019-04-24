package com.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Beans.ReimbursementsReq;
import com.revature.Service.ReimbursementService;

import java.io.IOException;
import java.io.InputStream;
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

import org.json.JSONObject;

/**
 * Servlet implementation class ReimbursementsServlet
 */
@WebServlet("/ReimbursementsServlet")
@MultipartConfig
public class ReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public List<ReimbursementsReq> view = new ArrayList<>();
	public ReimbursementService reim = new ReimbursementService();
	
	
	JSONObject json = new JSONObject();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementsServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		view = reim.GetAllReimbursement();
		
		response.getWriter().write((new ObjectMapper()).writeValueAsString(view));
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReimbursementService reim = new ReimbursementService();
		
		HttpSession session = request.getSession(false);
		/*Blobs: 1. Create an object of type Part, 2. Request to get a parameter that matches the name of an input from your HTML file.
		 * For me, that parameter was "uploadFile". In the form that surrounds the upload button and other information relevant to Reimbursement
		 * requests I have a value enctype="multipart/form-data" and a @MultipartConfig tag at the top my Servlet. This may or may not be necessary.
		 * 3. Create InputStream obj, then set that equal to PartObject.getInputStream(). 4. Send InmputStream Object to DAO.
		 * 5. In your DAO, set your parameter in your SQL query as setBlob such like this smt.setBlob(1, req.getImg());
		 * Note: getImage method is of type InputStream and is a part of my Reimbursement Request Class. Large files may take up to 20 seconds to load.*/
		
		Part filePart = request.getPart("uploadFile");
		InputStream fileContent = null;
		

		if(filePart != null) {
					fileContent = filePart.getInputStream();
         
					String amount = request.getParameter("amount");
					String cat = request.getParameter("category");
					String script = request.getParameter("description");
					String first = session.getAttribute("First").toString();
					String last = session.getAttribute("Last").toString();
					String email = session.getAttribute("Email").toString();
					String eID = session.getAttribute("Employee").toString();
	
					if(session.getAttribute("Manager") == null) {
						
						Integer newid = Integer.parseInt(eID);
						Integer newmanager = 0;
						Double newamount = Double.parseDouble(amount);
						
						ReimbursementsReq req = new ReimbursementsReq(fileContent,newamount,newid,first,last,email,newmanager,script,cat);
						
								try 
								{
									reim.submitRequestWithImage(req);
									response.sendRedirect("ProfileServlet");
								}
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
						
					}else{
								String mID = session.getAttribute("Manager").toString();
								Integer newid = Integer.parseInt(eID);
								Integer newmanager = Integer.parseInt(mID);
								Double newamount = Double.parseDouble(amount);
								
								ReimbursementsReq req = new ReimbursementsReq(fileContent,newamount,newid,first,last,email,newmanager,script,cat);
								
								try 
								{
									reim.submitRequest(req);
									response.sendRedirect("ProfileServlet");
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
						}
		}else {
			//if no user input of a file, do same set of results with no image passed through
					System.out.println("File empty");
					String amount = request.getParameter("amount");
					String cat = request.getParameter("category");
					String script = request.getParameter("description");
					String first = session.getAttribute("First").toString();
					String last = session.getAttribute("Last").toString();
					String email = session.getAttribute("Email").toString();
					String eID = session.getAttribute("Employee").toString();
				
					if(session.getAttribute("Manager") == null) {
						
							
					
						Integer newid = Integer.parseInt(eID);
						Integer newmanager = 0;
						Double newamount = Double.parseDouble(amount);
						
						ReimbursementsReq req = new ReimbursementsReq(newamount,newid,first,last,email,newmanager,script,cat);
						
								try 
								{
									reim.submitRequestWithImage(req);
									response.sendRedirect("ProfileServlet");
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
						
					}else{
								String mID = session.getAttribute("Manager").toString();
								Integer newid = Integer.parseInt(eID);
								Integer newmanager = Integer.parseInt(mID);
								Double newamount = Double.parseDouble(amount);
								
								ReimbursementsReq req = new ReimbursementsReq(newamount,newid,first,last,email,newmanager,script,cat);
								
								try 
								{
									reim.submitRequest(req);
									response.sendRedirect("ProfileServlet");
								} 
								catch (SQLException e) 
								{
									e.printStackTrace();
								}
			
					}
				}
			}//end of doPost
	
	
}	
		

	

