package com.revature.Service;

import com.revature.DAO.HomeDAOImpl;

public class HomeService {

	
	public boolean validateEmployee(String email, String pass) {
		boolean validate;
		HomeDAOImpl home = new HomeDAOImpl();
		validate = home.FindEmployee(email, pass);
		
		return validate;
	}
}
