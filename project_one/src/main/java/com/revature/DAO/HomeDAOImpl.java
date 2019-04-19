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
	String plug = "Connections.properties";
	@Override
	public boolean FindEmployee(String email, String pass) {
		ResultSet rs = null;
		PreparedStatement smt = null;
		boolean validate = false;
		
		
		try (Connection con = ConnectionUtil.getConnectionFromFile())
		  { 
			smt = con.prepareStatement("SELECT EMAIL, PASS FROM EMPLOYEES  WHERE EMAIL = ? AND PASS = ? ");
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
				  {e.printStackTrace();} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return validate;
	}

	@Override
	public List<Employees> AllEmployees(Employees emp) {
		// TODO Auto-generated method stub
		List<Employees> all = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement smt = null;
		
		 try (Connection con = ConnectionUtil.getConnectionFromFile())
		  { 
			smt = con.prepareStatement("SELECT FROM EMPLOYEES  (STATUS, IMG, AMOUNT, EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMAIL ) "
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
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			    try { rs.close(); } catch (Exception e) { /* ignored */ }
			}
		
		return all;
	}

	@Override
	public Employees getEmployee(String email, String pass) {
		PreparedStatement stmt = null ;
		
		ResultSet rs = null;
		String first = "", last = "", mail = "", password = "", title = "", img = ""; 
		Integer eID = 0, mID = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) 
		  { 
		  stmt = con.prepareStatement( "SELECT EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMAIL, PASS, TITLE, IMG, MANAGER_ID FROM EMPLOYEES WHERE EMAIL = ? AND PASS = ?");
		  stmt.setString(1, email);
		  stmt.setString(2, pass);
		  
		  
			 rs = stmt.executeQuery();
			 while (rs.next()) {
					 eID = rs.getInt("EMPLOYEE_ID");
					 first = rs.getString("FIRSTNAME");
					 last = rs.getString("LASTNAME");
					 mail = rs.getString("EMAIL");
					 password = rs.getString("PASS");
					 title = rs.getString("TITLE");
					 img = rs.getString("img");
					 mID = rs.getInt("MANAGER_ID");
		  }
		  }
		  catch (SQLException e) 
		  { 
			  e.printStackTrace(); 
		  }
		  catch (IOException e) 
		  {
			  e.printStackTrace(); 
		  }
		catch (NullPointerException e) 
		  { 
			  e.printStackTrace(); 
		  }
		finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		}
			Employees emp = new Employees(eID,first,last,mail,password,title,img,mID);
			return emp;		
}
	

	
	
}
