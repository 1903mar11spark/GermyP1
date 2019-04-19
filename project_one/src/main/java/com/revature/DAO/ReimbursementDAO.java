package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import com.revature.Beans.ReimbursementsReq;

public interface ReimbursementDAO {

	public void submitService(ReimbursementsReq req);
	public void updateStatus(ReimbursementsReq req);
	
	
	public List<ReimbursementsReq> viewReimbursements();
}
