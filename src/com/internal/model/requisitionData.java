package com.internal.model;


import java.sql.Date;
import java.util.List;

public class requisitionData {
	int reqId;
	String reqName;
	Date createdAt;
	Date expiry;
	String status;
	String location;
	int experience;
	String skills;
	String createdBy;
	
	public requisitionData(String reqName, Date createdAt, Date expiry, String status, String location, int experience,
			String skills,String createdBy) {
		this.reqName = reqName;
		this.createdAt = createdAt;
		this.expiry = expiry;
		this.status = status;
		this.location = location;
		this.experience = experience;
		this.skills = skills;
		this.createdBy = createdBy;
	}

	public requisitionData(int reqId, String reqName, String status, String location, int experience) {
		super();
		this.reqId = reqId;
		this.reqName = reqName;
		this.status = status;
		this.location = location;
		this.experience = experience;
	}

	public requisitionData(int reqId, String reqName, Date createdAt, Date expiry, String status, String location,
			int experience, String skills, String createdBy) {
		this.reqId = reqId;
		this.reqName = reqName;
		this.createdAt = createdAt;
		this.expiry = expiry;
		this.status = status;
		this.location = location;
		this.experience = experience;
		this.skills = skills;
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	

}
