package com.revature.Beans;

import java.sql.Blob;
import java.text.NumberFormat;

public class ReimbursementsReq {
	
	private Integer rID;
	private String status = "Pending";
	private Blob img;
	private Double amount;
	private Integer eID;
	private String firstname;
	private String lastname;
	private String email;
	private Integer managerID;
	private String description;
	private String category;
	
	
	
	
	public ReimbursementsReq() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ReimbursementsReq(Integer rID, String status, Double amount, Integer eID, String firstname, String lastname,
			String email, Integer managerID, String description) {
		super();
		this.rID = rID;
		this.status = status;
		this.amount = amount;
		this.eID = eID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.managerID = managerID;
		this.description = description;
	}




	public ReimbursementsReq(Double amount, String firstname, String lastname, String email, Integer managerID,
			String description, String category) {
		super();
		this.amount = amount;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.managerID = managerID;
		this.description = description;
		this.category = category;
	}




	public ReimbursementsReq(Double amount, Integer eID, String firstname, String lastname, String email,
			Integer managerID, String description, String category) {
		super();
		this.amount = amount;
		this.eID = eID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.managerID = managerID;
		this.description = description;
		this.category = category;
	}




	public ReimbursementsReq(Blob img, Double amount, Integer eID, String firstname, String lastname, String email,
			Integer managerID, String description, String category) {
		super();
		this.img = img;
		this.amount = amount;
		this.eID = eID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.managerID = managerID;
		this.description = description;
		this.category = category;
	}




	public ReimbursementsReq(String status, Integer eID, String email, Integer managerID) {
		super();
		this.status = status;
		this.eID = eID;
		this.email = email;
		this.managerID = managerID;
	}








	public Blob getImg() {
		return img;
	}




	public void setImg(Blob img) {
		this.img = img;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
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
