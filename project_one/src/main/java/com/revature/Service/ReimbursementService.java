package com.revature.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Beans.ReimbursementsReq;
import com.revature.DAO.ReimbursementDAOImpl;

public class ReimbursementService {
	
	public  void submitRequest (ReimbursementsReq req) throws SQLException, IOException{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		dao.submitService(req);
	}
	
	public  void submitRequestWithImage (ReimbursementsReq req) throws SQLException, IOException{
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		dao.submitServiceImage(req);
	}

	public List<ReimbursementsReq> GetAllReimbursement(){
		ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
		List<ReimbursementsReq> allRequests = new ArrayList<>(); 
		allRequests = dao.viewReimbursements();
		
		return allRequests;
	}
}
