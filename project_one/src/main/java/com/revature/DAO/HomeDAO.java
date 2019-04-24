package com.revature.DAO;

import java.sql.Blob;
import java.util.List;

import com.revature.Beans.Employees;

public interface HomeDAO {
	
	public void UpdateEmployee(Employees emp, String User);
	
	public boolean FindEmployee (String email, String pass);
	public Employees getEmployee(String email, String pass);
	public Employees getEmployee(String email);
	List<Employees> AllEmployees(Employees emp);
	public boolean upload(String pic, String email);
}
