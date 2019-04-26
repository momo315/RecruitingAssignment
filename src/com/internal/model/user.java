package com.internal.model;

import java.io.InputStream;

public class user {
	String username;
	String password;
	String empid;
	String gender;
	String type;
	InputStream pdf;
	String fname;
	String lname;
	
	public user(String username, String password, String empid, String gender, String type, InputStream pdf,
			String fname, String lname) {
		this.username = username;
		this.password = password;
		this.empid = empid;
		this.gender = gender;
		this.type = type;
		this.pdf = pdf;
		this.fname = fname;
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InputStream getPdf() {
		return pdf;
	}

	public void setPdf(InputStream pdf) {
		this.pdf = pdf;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	


}
