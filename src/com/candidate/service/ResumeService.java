package com.candidate.service;

import java.io.InputStream;
import java.sql.Blob;

import com.candidate.dao.ResumeDao;

public class ResumeService {
	
	public InputStream getRes(int user) {
		return new ResumeDao().getRes(user);
	}

}
