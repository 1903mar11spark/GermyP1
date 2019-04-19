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


	public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String pass = "";
		try {
			   Class.forName("oracle.jdbc.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver classsss!");
			}
		return DriverManager.getConnection(url, username, pass);
}
	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("Connections.properties");
		prop.load(in);
		try {
			   Class.forName("oracle.jdbc.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			   System.out.println("Error: unable to load driver class!");
			}
		
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
}
	

}
