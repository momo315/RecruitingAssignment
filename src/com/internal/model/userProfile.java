package com.internal.model;

import java.io.InputStream;

public class userProfile {
	
	int id;
	String username;
	String password;
	String empid;
	String gender;
	String type;
	String fname;
	String lname;
	String address;
	String phone;
	String bio;
	
	public userProfile(int id, String username, String password, String empid, String gender, String type,
			 String fname, String lname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.empid = empid;
		this.gender = gender;
		this.type = type;
		this.fname = fname;
		this.lname = lname;
	}

	public userProfile(String username, String empid, String gender, String type, String fname, String lname) {
		super();
		this.username = username;
		this.empid = empid;
		this.gender = gender;
		this.type = type;
		this.fname = fname;
		this.lname = lname;
	}

	public userProfile(String username, String empid, String gender, String fname, String lname, String address,
			String phone, String bio) {
		super();
		this.username = username;
		this.empid = empid;
		this.gender = gender;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phone = phone;
		this.bio = bio;
	}

	public userProfile(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
