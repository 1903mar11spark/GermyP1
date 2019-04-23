package com.revature.Service;

import java.io.IOException;
import java.sql.SQLException;

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

}
