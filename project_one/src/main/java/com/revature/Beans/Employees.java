package com.revature.Beans;


public class Employees {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String title;
	private String img;
	private Integer managerID = null;
	

	public Employees() {
		super();
	}
	
	public Employees(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Employees(Integer id, String firstname, String lastname, String email, Integer managerID) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.managerID = managerID;
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
	
	

	public Employees(Integer id, String firstname, String lastname, String email, String password, String title,
			String img, Integer managerID) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.title = title;
		this.img = img;
		this.managerID = managerID;
	}

	public Employees(Integer id, String firstname, String lastname, String email, String password, String title,
			String img) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.title = title;
		this.img = img;
	}
	
	public Employees(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	

	public Employees(Integer id, String firstname, String lastname, String email, String img, Integer managerID) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.img = img;
		this.managerID = managerID;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	
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
	
	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}

	@Override
	public String toString() {
		return "Employees: [ Employee ID = " + id + ", Employee First Name = " + firstname + ", Employee Last Name = " + lastname + ", Employee Email = " + email+ ", ManagerID: "+ managerID+  " ]";
	}
	
	
}
