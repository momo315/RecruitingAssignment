package com.candidate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candidate.service.ProfileUpdateService;
import com.google.gson.Gson;
import com.internal.util.SessionChecker;

/**
 * Servlet implementation class ProfileUpdateController
 */
@WebServlet("/ProfileUpdate")
public class ProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String obj = "";
		HashMap<String, String> hm= new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(!SessionChecker.checkSession(request, response)) {
			hm.put("sess", "false");
			obj = new Gson().toJson(hm, hm.getClass());
		}
		else {
			String address,phno,bio;
			address = (String)request.getParameter("address");
			phno = (String)request.getParameter("phno");
			bio = (String)request.getParameter("bio");
			ProfileUpdateService profileUpdateService = new ProfileUpdateService();
			int res = profileUpdateService.updateProfile(SessionChecker.getId(request), address, phno, bio);
			if(res>0) {
				hm.put("updated", "true");
				obj = new Gson().toJson(hm, hm.getClass());
			}
			else {
				hm.put("updated", "false");
				obj = new Gson().toJson(hm, hm.getClass());
			}
		}
		out.print(obj);
		out.flush();
	}

}
