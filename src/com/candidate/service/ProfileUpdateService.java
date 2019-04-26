package com.candidate.service;

import com.candidate.dao.ProfileUpdateDao;

public class ProfileUpdateService {
	
	public int updateProfile(int id,String address,String phno,String bio) {
		ProfileUpdateDao profileUpdateDao = new ProfileUpdateDao();
		int res = profileUpdateDao.updateProfile(id, address, phno, bio);
		return res;
		}
	
}
