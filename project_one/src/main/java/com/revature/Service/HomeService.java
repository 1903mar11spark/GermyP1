package com.revature.Service;

import com.revature.Beans.Employees;
import com.revature.DAO.HomeDAOImpl;

public class HomeService {

	
	public boolean validateEmployee(String email, String pass) {
		boolean validate;
		HomeDAOImpl home = new HomeDAOImpl();
		validate = home.FindEmployee(email, pass);
		
		return validate;
	}
	
	public Employees getDAOEmployee(String email, String pass) {
		HomeDAOImpl home = new HomeDAOImpl();
		Employees emp = home.getEmployee(email, pass);
		
		return emp;
	}
}
