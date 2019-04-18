package com.revature.DAO;

import java.util.ArrayList;

import com.revature.Beans.ReimbursementsReq;

public interface ReimbursementDAO {

	public void submitService(ReimbursementsReq req);
	public void updateStatus(ReimbursementsReq req);
	
	public ArrayList <ReimbursementsReq> viewReimbursements();
}
