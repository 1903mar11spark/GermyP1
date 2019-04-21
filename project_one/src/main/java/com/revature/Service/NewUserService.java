package com.revature.Service;

import com.revature.DAO.NewUserDAOImpl;

public class NewUserService {

	public void CreateUser(String first, String last, String email, String pass, Integer mID ) {
		NewUserDAOImpl employ = new NewUserDAOImpl();
		employ.CreateUser(first, last, email, pass, mID);
	}
	public void CreateUser(String first, String last, String email, String pass, String img ) {
		NewUserDAOImpl employ = new NewUserDAOImpl();
		employ.CreateUser(first, last, email, pass, img);
	}
}
