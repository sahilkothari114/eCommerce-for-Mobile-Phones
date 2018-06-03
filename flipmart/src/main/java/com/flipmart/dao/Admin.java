package com.flipmart.dao;

public class Admin {
	private int adminId;
	private String firstName;
	private String lastname;
	private String eMail;
	private String password;
	private int pincode;
	private String streetAddress;
	private String contactNo;
	private String displayPicture;
	public Admin(String firstName, String lastname, String eMail, String password, int pincode, String streetAddress,
			String contactNo, String displayPicture) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.eMail = eMail;
		this.password = password;
		this.pincode = pincode;
		this.streetAddress = streetAddress;
		this.contactNo = contactNo;
		this.displayPicture = displayPicture;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getcontactNo() {
		return contactNo;
	}
	public void setcontactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDisplayPicture() {
		return displayPicture;
	}
	public void setDisplayPicture(String displayPicture) {
		this.displayPicture = displayPicture;
	}
	public int getAdminId() {
		return adminId;
	}
	
}
