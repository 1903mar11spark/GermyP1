package com.revature.Beans;

import java.text.NumberFormat;

public class ReimbursementsReq {
	
	private Integer rID;
	private Double amount;
	private String status;
	private String img;
	private Integer eID;
	private String firstname;
	private String lastname;
	private String email;
	private Integer managerID;
	
	
	
	
	public ReimbursementsReq() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ReimbursementsReq(Integer rID, String status, String img, Double amount, Integer eID, String firstname,
			String lastname, String email, Integer managerID) {
		super();
		this.rID = rID;
		this.amount = amount;
		this.status = status;
		this.img = img;
		this.eID = eID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.managerID = managerID;
	}




	public Integer getrID() {
		return rID;
	}




	public void setrID(Integer rID) {
		this.rID = rID;
	}




	public Double getAmount() {
		return amount;
	}




	public void setAmount(Double amount) {
		this.amount = amount;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getImg() {
		return img;
	}




	public void setImg(String img) {
		this.img = img;
	}




	public Integer geteID() {
		return eID;
	}




	public void seteID(Integer eID) {
		this.eID = eID;
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


	public Integer getManagerID() {
		return managerID;
	}




	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}




	@Override
	public String toString() {
		NumberFormat format =  NumberFormat.getCurrencyInstance();
		
		return "Reimbursement Requests: [ Reimbursement ID = " + rID + ", Amount = " + format.format(amount) + ", Reimbursement Status = " + status + ", Employee = "
				+ eID + ", First Name = " + firstname + ", Last Name = " + lastname + ", Email = " + email + ", Manager's ID = " + managerID + " , Image = " + img +" ]";
	}
	
	
}
