package com.revature.Beans;

public class ReimbursementsReq {
	
	private Integer rID;
	private Integer amount;
	private String status;
	private String img;
	private Integer eID;
	private String firstname;
	private String lastname;
	private String email;
	private String title;
	private Integer managerID;
	
	
	
	
	public ReimbursementsReq() {
		super();
		// TODO Auto-generated constructor stub
	}




	public ReimbursementsReq(Integer rID, Integer amount, String status, String img, Integer eID, String firstname,
			String lastname, String email, String title, Integer managerID) {
		super();
		this.rID = rID;
		this.amount = amount;
		this.status = status;
		this.img = img;
		this.eID = eID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.title = title;
		this.managerID = managerID;
	}




	public Integer getrID() {
		return rID;
	}




	public void setrID(Integer rID) {
		this.rID = rID;
	}




	public Integer getAmount() {
		return amount;
	}




	public void setAmount(Integer amount) {
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
		return "ReimbursementsReq [rID=" + rID + ", amount=" + amount + ", status=" + status + ", img=" + img + ", eID="
				+ eID + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", title=" + title
				+ ", managerID=" + managerID + "]";
	}
	
	
}
