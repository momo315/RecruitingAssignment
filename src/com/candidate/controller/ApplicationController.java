package com.candidate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candidate.service.ApplicationService;
import com.google.gson.Gson;
import com.internal.model.userProfile;
import com.internal.util.SessionChecker;

/**
 * Servlet implementation class ApplicationController
 */
@WebServlet("/Application")
public class ApplicationController extends HttpServlet {
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
			int reqid,userid;
			reqid = Integer.parseInt((String)request.getParameter("reqid"));
			userid = SessionChecker.getId(request);
			ApplicationService applicationService = new ApplicationService();
			int res = applicationService.createApplication(reqid, userid);
			if(res>0) {
				String value = "Application Successfully Registered . Your Application Number : "+res;
				hm.put("msg", value);
				obj = new Gson().toJson(hm, hm.getClass());
			}else {
				hm.put("msg", "Application Failed. Please try again.");
				obj = new Gson().toJson(hm, hm.getClass());
			}
		}
		out.print(obj);
		out.flush();
	}

}
