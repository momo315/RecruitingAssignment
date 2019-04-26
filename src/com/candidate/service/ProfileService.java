package com.candidate.service;

import com.candidate.dao.ProfileDao;
import com.internal.model.userProfile;

public class ProfileService {
	
	public userProfile getProfile(int usr) {
		ProfileDao profileDao = new ProfileDao();
		userProfile up = profileDao.getUser(usr);
		return up;
	}

}
