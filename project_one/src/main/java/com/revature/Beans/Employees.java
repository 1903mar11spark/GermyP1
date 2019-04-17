package com.revature.Beans;

public class Employees {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String title;
	
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employees(Integer id, String firstname, String lastname, String email, String password, String title) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.title = title;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Employees: [ Employee ID = " + id + ", Employee First Name = " + firstname + ", Employee Last Name = " + lastname + ", Employee Email = " + email
				+ ", Employee Password = " + password + ", Title = " + title + " ]";
	}
	
	
}
