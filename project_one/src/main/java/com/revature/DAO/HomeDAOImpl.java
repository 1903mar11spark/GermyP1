package com.revature.DAO;

import java.io.IOException;
import java.io.InputStream;
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
		//checks to see if there is a user in database with info matching parameters
		ResultSet rs = null;
		PreparedStatement smt = null;
		boolean validate = false;
		String valemail = null, valpass = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile())
		  { 
			smt = con.prepareStatement("SELECT EMAIL, PASS FROM EMPLOYEES  WHERE EMAIL = ? AND PASS = ? ");
		    smt.setString(1, email);
		    smt.setString(2,pass);
		    rs = smt.executeQuery();
		    
			    while(rs.next()) {
			    	valemail = rs.getString("EMAIL");
			    	valpass = rs.getString("PASS");
			    }
			    
			    if (valemail == null || valpass == null) {
					  System.out.println("Wrong Username and Password.(HomeDAOImpl, Method - Find Employee)");
					  validate = false;
					  return validate;
					 } 
					  else {
						  System.out.println("Correct Username and Password! WOOHOOO (HomeDAOImpl, Method - Find Employee)");
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
		//Create a list of employees form database to print out
		List<Employees> all = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement smt = null;
		
		 try (Connection con = ConnectionUtil.getConnectionFromFile())
		  { 
			smt = con.prepareStatement("SELECT FROM EMPLOYEES  (EMPLOYEE_ID, FIRSTNAME, LASTNAME, EMAIL, IMG, MANAGER_ID ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
		    rs = smt.executeQuery();
		   
				while (rs.next()) {
					int eID = rs.getInt("EMPLOYEE_ID");
					String first = rs.getString("FIRSTNAME");
					String last = rs.getString("LASTNAME");
					String email = rs.getString("EMAIL");
					InputStream img = rs.getBinaryStream("img");
					int mID = rs.getInt("MANAGER_ID");
					
					all.add(new Employees(eID, first, last, email, img, mID));
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
	//Returns an employee and all its values
	public Employees getEmployee(String email, String pass) {
		PreparedStatement stmt = null ;
		ResultSet rs = null;
		String first = "", last = "", mail = "", password = "", title = "";
		InputStream img = null;
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
						 img = rs.getBinaryStream("img");
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
	
public void UpdateEmployee(Employees emp, String user) {
	PreparedStatement stmt = null, stmt2 = null;
	ResultSet rs = null;
	String first = "", last = "", mail = "", password = "";
	String tfirst = emp.getFirstname(), tlast = emp.getLastname(), tmail = emp.getEmail(), tpass = emp.getPassword();
	
	try (Connection con = ConnectionUtil.getConnectionFromFile()) 
	  { 
		  stmt = con.prepareStatement( "SELECT FIRSTNAME, LASTNAME, EMAIL,PASS FROM EMPLOYEES WHERE EMAIL = ?");
		  stmt.setString(1, user);
		  rs = stmt.executeQuery();
		  
			 while (rs.next()) {
					 first = rs.getString("FIRSTNAME");
					 last = rs.getString("LASTNAME");
					 mail = rs.getString("EMAIL");
					 password = rs.getString("PASS");
		  }
			 
		 /*if the values that the user wanted to update are left null then the current value in the database is set to the temp vals
		  * thus, no null values are accidentally replacing valid values in the sql statement*/
			if(tfirst.equals(null)) {
				 tfirst = first;
			 }
			if(tlast.equals("")) {
				tlast =	last;	 
					 }
			if(tmail.equals("")) {
				tmail = mail; 
			}
			if(tpass.equals("")) {
				 tpass = password;
			}
			
			stmt2 = con.prepareStatement( "UPDATE EMPLOYEES SET FIRSTNAME = ? , LASTNAME = ?, EMAIL = ?, PASS = ?  WHERE EMAIL = ?");
			  stmt2.setString(1, tfirst);
			  stmt2.setString(2, tlast);
			  stmt2.setString(3, tmail);
			  stmt2.setString(4, tpass);
			  stmt2.setString(5, user);
			  
			  
			  stmt2.executeUpdate();
			  System.out.println("Employee "+tfirst+" Updated");
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
}
	
	
}
