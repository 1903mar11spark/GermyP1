package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reavature.Util.ConnectionUtil;

public class NewUserDAOImpl implements NewUserDAO {
	String plug = "Connections.properties";

	@Override
	public void CreateUser(String first, String last, String email, String pass, Integer mID) {
		//Create user called from NewUser Service class from NewUserServlet from xmlhttprequest in JS file after end user clicks submit in NewUser html
		PreparedStatement stmt = null;
      		try ( Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			//Writing DML query, then using the PreparedStatement helper methods to later execute the query.
			stmt = con.prepareStatement("INSERT INTO EMPLOYEES (FIRSTNAME, LASTNAME, EMAIL, PASS, MANAGER_ID) VALUES (?,?,?,?,?)");
			stmt.setString(1, first);
			stmt.setString(2, last);
			stmt.setString(3, email);
			stmt.setString(4, pass);
			stmt.setInt(5, mID);
			
		    stmt.executeUpdate();
		    
		    
           //More exception handling.
	      } catch (SQLException sqlEx) {
	             sqlEx.printStackTrace();
	             System.exit(1);  
	      } catch (IOException e1) {e1.printStackTrace();} 
					finally {
				             try {stmt.close();}
				             	catch (Exception e) {System.exit(1);}
}
	}
	
	//If user uploads an image then this method should be called
	@Override
	public void CreateEmployee(String first, String last, String email, String pass) {
		PreparedStatement stmt = null;
       
        
        //Some exception handling with connecting to a file.
		try ( Connection con = ConnectionUtil.getConnectionFromFile()) {
			
			//Writing DML query, then using the PreparedStatement helper methods to later execute the query.
			stmt = con.prepareStatement("INSERT INTO EMPLOYEES (FIRSTNAME, LASTNAME, EMAIL, PASS) VALUES (?,?,?,?)");
			stmt.setString(1, first);
			stmt.setString(2, last);
			stmt.setString(3, email);
			stmt.setString(4, pass);
		    stmt.execute();
		    
		    
           //More exception handling.
	      } catch (SQLException sqlEx) {
	             sqlEx.printStackTrace();
	             System.exit(1);  
	      } catch (IOException e1) {e1.printStackTrace();} 
					finally {
				             try {stmt.close();}
				             	catch (Exception e) {System.exit(1);}
}		
	}

}
