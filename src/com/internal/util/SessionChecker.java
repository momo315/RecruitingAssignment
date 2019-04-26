package com.internal.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internal.model.userProfile;

public class SessionChecker {
	
	public static boolean checkSession(HttpServletRequest request, HttpServletResponse response) {
		userProfile up = (userProfile)request.getSession().getAttribute("userProfile");
		System.out.println("in sessioncheck");
		if(up==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public static int  getId(HttpServletRequest request) {
		userProfile up = (userProfile)request.getSession().getAttribute("userProfile");
		return up.getId();
	}
}
