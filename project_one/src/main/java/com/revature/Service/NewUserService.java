package com.revature.Service;


import com.revature.DAO.NewUserDAOImpl;

public class NewUserService {

	public void CreateUser(String first, String last, String email, String pass, Integer mID ) {
		NewUserDAOImpl employ = new NewUserDAOImpl();
		employ.CreateUser(first, last, email, pass, mID);
	}
	public void CreateEmployee(String first, String last, String email, String pass ) {
		NewUserDAOImpl employ = new NewUserDAOImpl();
		employ.CreateEmployee(first, last, email, pass);
	}
	public void CreateEmployeeWithImage(String first, String last, String email, String pass , String pic) {
		NewUserDAOImpl employ = new NewUserDAOImpl();
		employ.CreateEmployeeWithImage(first, last, email, pass, pic);
	}
}
