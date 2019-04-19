package com.revature.DAO;

public interface NewUserDAO {

	
	public void CreateUser(String first, String last, String email, String pass );
	
	public void CreateUser(String first, String last, String email, String pass, String img );
	
}
