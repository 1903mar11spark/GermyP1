package com.revature.Beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.reavature.Util.ConnectionUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C:/gitrepos/GermyP1/project_one/resources/Connections.properties");
		 System.out.println(new File(".").getAbsoluteFile());
		    System.out.println(file.exists());
		    try {
				Scanner scan = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  try 
		  { 
		  Connection con = ConnectionUtil.getConnectionFromFile("Connections.properties");
		  System.out.println(con); 
		  }
		  catch (SQLException e) 
		  { 
			  e.printStackTrace(); 
		  }
		  catch (IOException e) 
		  {
			  e.printStackTrace(); 
}
	}

}
