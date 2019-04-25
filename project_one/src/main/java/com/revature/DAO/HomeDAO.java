package com.revature.DAO;

import java.util.List;

import com.revature.Beans.Employees;

public interface HomeDAO {
	
	public void UpdateEmployee(Employees emp, String User);
	public void Approve(Integer rID);
	public void Deny(Integer rID);
	
	public boolean FindEmployee (String email, String pass);
	public boolean upload(String pic, String email);
	
	public Employees getEmployee(String email, String pass);
	public Employees getEmployee(String email);
	
	List<Employees> AllEmployees();
	
}
