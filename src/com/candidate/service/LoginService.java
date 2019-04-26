package com.candidate.service;

import com.candidate.controller.LoginController;
import com.candidate.dao.LoginDao;
import com.internal.model.userProfile;

public class LoginService {
	
	public userProfile Login(String usr , String pass) {
		LoginDao loginDao = new LoginDao();
		userProfile up = loginDao.login(usr, pass);
		System.out.println(up.getUsername());
		if(up.getId() > 0) {
			if(usr.equals(up.getUsername()) && pass.equals(up.getPassword())) {
				return up;
			}
			else {
				return new userProfile(0);
			}
		}
		else {
			return new userProfile(-1);
		}
		
	}

}
