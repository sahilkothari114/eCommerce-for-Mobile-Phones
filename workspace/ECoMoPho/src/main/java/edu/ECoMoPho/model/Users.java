package edu.ECoMoPho.model;

public class Users {
	private int userId;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private int pincode;
	private String streetAddress;
	private String contactNo;
	private String active;
	public Users(String firstName, String lastName, String eMail, String password, int pincode, String streetAddress,
			String contactNo, String active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.pincode = pincode;
		this.streetAddress = streetAddress;
		this.contactNo = contactNo;
		this.active = active;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getactive() {
		return active;
	}
	public void setactive(String active) {
		this.active = active;
	}
	public int getUserId() {
		return userId;
	}
}
