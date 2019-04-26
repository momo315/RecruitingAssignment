package com.candidate.service;

import java.sql.Date;
import java.time.LocalDate;

import com.candidate.dao.ApplicationDao;

public class ApplicationService {
	
	public int createApplication(int reqid,int userid) {
		ApplicationDao applicationDao = new ApplicationDao();
		LocalDate current = LocalDate.now();
		Date createdat = java.sql.Date.valueOf(current);
		return applicationDao.createApplication(reqid, userid, createdat);
	}

}
