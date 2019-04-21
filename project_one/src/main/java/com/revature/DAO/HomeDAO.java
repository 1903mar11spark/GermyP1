package com.revature.DAO;

import java.util.List;

import com.revature.Beans.Employees;

public interface HomeDAO {
	
	public void UpdateEmployee(Employees emp, String User);
	
	public boolean FindEmployee (String email, String pass);
	
	public Employees getEmployee(String email, String pass);

	List<Employees> AllEmployees(Employees emp);
}
