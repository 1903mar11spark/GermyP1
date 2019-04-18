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
	//
	static String plug = "Connections.properties";
	Connection con = null;
    ResultSet rs = null; 
    PreparedStatement ps = null;
	Connection  connection;
    
    public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String pass = "";
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			}
		return DriverManager.getConnection(url, username, pass);
	}

	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream(plug);
		prop.load(in);
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			}
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("pass"));
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
