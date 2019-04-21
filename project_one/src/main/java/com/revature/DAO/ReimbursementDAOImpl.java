package com.revature.DAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.reavature.Util.ConnectionUtil;
import com.revature.Beans.ReimbursementsReq;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	String plug = "Connections.properties";
	
	@Override
	public void submitService(ReimbursementsReq req) {
		
		PreparedStatement smt = null;
		ResultSet rs = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
		{
			smt = con.prepareStatement("INSERT INTO REIMBURSEMENTS  (STATUS, IMG, AMOUNT, EMPLOYEE_ID, FIRSTNAME,LASTNAME, EMAIL ) "
																+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
			smt.setString(1, req.getStatus());
			smt.setString(2, req.getImg());
			smt.setDouble(3, req.getAmount());
			smt.setInt(4, req.geteID());
			smt.setString(5, req.getFirstname());
			smt.setString(6, req.getLastname());
			smt.setString(7, req.getEmail());
		
			
			smt.execute();
			
		} catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            System.exit(1);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void updateStatus(ReimbursementsReq req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReimbursementsReq> viewReimbursements() {
		// Create a list of reimbursements to print 
		ArrayList<ReimbursementsReq> views = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement smt = null;
		
		try  (Connection con = ConnectionUtil.getConnectionFromFile())
		  { 
			smt = con.prepareStatement("SELECT FROM REIMBURSEMENTS  (STATUS, IMG, AMOUNT, EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMAIL ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
		    rs = smt.executeQuery();
		   
				while (rs.next()) {
					int rID = rs.getInt("R_ID");
					String status = rs.getString("STATUS");
					String img = rs.getString("IMG");
					double amount = rs.getDouble("AMOUNT");
					int eID = rs.getInt("EMPLOYEE_ID");
					String first = rs.getString("FIRSTNAME");
					String last = rs.getString("LASTNAME");
					String email = rs.getString("EMAIL");
					int mID = rs.getInt("MANAGER_ID");
					views.add(new ReimbursementsReq(rID, status, img, amount, eID, first, last, email, mID));
			  }
		  }
		  catch (SQLException e) 
		  { 
			  e.printStackTrace(); 
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			    try { rs.close(); } catch (Exception e) { /* ignored */ }
			}
		
		return views;
	}

}
