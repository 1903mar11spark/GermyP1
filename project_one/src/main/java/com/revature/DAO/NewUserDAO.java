package com.revature.DAO;

public interface NewUserDAO {

	
	public void CreateUser(String first, String last, String email, String pass, Integer mID );
	
	public void CreateUser(String first, String last, String email, String pass, String img );
	
}
