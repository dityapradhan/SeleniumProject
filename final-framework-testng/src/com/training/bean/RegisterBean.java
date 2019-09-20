package com.training.bean;

public class RegisterBean {
	private String email;
	private String firstname;
	private String lastname;

	public RegisterBean() {
		super();
	}

	public RegisterBean(String email, String firstname, String lastname) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "RegisterBean [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
