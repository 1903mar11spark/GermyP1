package com.revature.Service;

import java.util.ArrayList;
import java.util.List;

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
	
	public void UpdateEmployee(Employees emp, String user) {
		HomeDAOImpl home = new HomeDAOImpl();
		home.UpdateEmployee(emp, user);
		System.out.println("Service Method Update Employee Called for: " + emp.getFirstname());
	}
	
	public List<Employees> GetAllEmployees(Employees emp){
		HomeDAOImpl home = new HomeDAOImpl();
		List<Employees> all = new ArrayList<>(); 
		all = home.AllEmployees(emp);
		
		return all;
	}

	public Employees getDAOEmployee(String email) {
		// TODO Auto-generated method stub
		HomeDAOImpl home = new HomeDAOImpl();
		Employees emp = home.getEmployee(email);
		
		return emp;
	}
	public boolean upload(String pic, String email) {
		boolean result = false;
		HomeDAOImpl home = new HomeDAOImpl();
		result = home.upload(pic, email);
		
		return result;
	}
}
