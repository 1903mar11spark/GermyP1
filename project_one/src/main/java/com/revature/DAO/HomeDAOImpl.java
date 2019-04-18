package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reavature.Util.ConnectionUtil;
import com.revature.Beans.Employees;
import com.revature.Beans.ReimbursementsReq;

public class HomeDAOImpl implements HomeDAO {

	@Override
	public boolean FindEmployee(String email, String pass) {
		ResultSet rs = null;
		PreparedStatement smt = null;
		boolean validate = false;
		
		
		try 
		  { 
			smt = ConnectionUtil.getConnection().prepareStatement("SELECT EMAIL, PASS FROM EMPLOYEES  WHERE EMAIL = ? AND PASS = ? ");
		    smt.setString(1, email);
		    smt.setString(2,pass);
		    rs = smt.executeQuery();
		    
		    if (!rs.next()) {
				  System.out.println("Wrong Username and Password.");
				 } 
				  else {
					  validate = true;
					   }
					
			  
		  }catch (SQLException e) 
				  {e.printStackTrace();}
		  
		return validate;
	}

	@Override
	public List<Employees> AllEmployees(Employees emp) {
		// TODO Auto-generated method stub
		List<Employees> all = new ArrayList<>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement smt = null;
		
		try 
		  { 
			smt = ConnectionUtil.getConnection().prepareStatement("SELECT FROM EMPLOYEES  (STATUS, IMG, AMOUNT, EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMAIL ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
		    rs = smt.executeQuery();
		   
				while (rs.next()) {
					int eID = rs.getInt("EMPLOYEE_ID");
					String first = rs.getString("FIRSTNAME");
					String last = rs.getString("LASTNAME");
					String email = rs.getString("EMAIL");
					String pass = rs.getString("PASS");
					String title = rs.getString("TITLE");
					String img = rs.getString("img");
					int mID = rs.getInt("MANAGER_ID");
					
					all.add(new Employees(eID, first, last, email, pass, title, img, mID));
			  }
		  }
		  catch (SQLException e) 
		  { 
			  e.printStackTrace(); 
		  }finally {
			    try { rs.close(); } catch (Exception e) { /* ignored */ }
			    try { con.close(); } catch (Exception e) { /* ignored */ }
			}
		
		return all;
	}

	
	
}
