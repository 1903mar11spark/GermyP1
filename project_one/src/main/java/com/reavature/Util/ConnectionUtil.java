package com.reavature.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	String plug = "/project_one/resources/Connections.properties";
	Connection con = null;
    ResultSet rs = null; 
    PreparedStatement ps =null;
	public ConnectionUtil() {
    try { 
    Connection con = getConnectionFromFile(plug);
	System.out.println(con);
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
}
	}
    
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
}
	
	
	public void Disconnect() {

        try {
            rs.close();
            ps.close();
            con.close();
            
        }                                            
        catch (Exception ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }  
    }

    public ResultSet ReadRecords(String sql) {
        try {

            ps = con.prepareStatement(sql);
                                    
            rs = ps.executeQuery(sql);

            return rs;

        } 
        catch (SQLException e) {
            System.out.println("The following error has occured: " + e.getMessage());
        }                                                    

        return rs;
    }

    public void ExecuteStatement(String sql) {
        try {
            ps = con.prepareStatement(sql);
                                    
            ps.executeUpdate(sql);
        } 
        catch (SQLException e) {
            System.out.println("The following error has occured: " + e.getMessage());
        }
}
}
