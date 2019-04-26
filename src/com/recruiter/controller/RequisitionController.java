package com.recruiter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.internal.model.requisitionData;
import com.internal.model.user;
import com.internal.model.userProfile;
import com.internal.util.SessionChecker;
import com.recruiter.service.RequisitionService;


/**
 * Servlet implementation class RequisitionController
 */
@WebServlet("/Requisition")
public class RequisitionController extends HttpServlet {
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
		String skillString = "";
		userProfile up = (userProfile)request.getSession().getAttribute("userProfile");
		HashMap<String, String> hm= new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(!SessionChecker.checkSession(request, response)) {
			hm.put("sess", "false");
			obj = new Gson().toJson(hm, hm.getClass());
		}
		else {
			String reqName, status,location, expString,createdBy;
			int exp;
			LocalDate expiryu,createdAtu;
			java.sql.Date expiry,createdAt;
			expiryu = null;
			createdAtu = null;
			expiry = null;
			createdAt = null;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String createdString = new Date().toString();
			String expiryString = request.getParameter("expiry");
			createdBy = up.getEmpid();
			try {
				expiryu = LocalDate.parse(expiryString, dtf);
				createdAtu = LocalDate.now();
				expiry = java.sql.Date.valueOf(expiryu);
				createdAt = java.sql.Date.valueOf(createdAtu);
				
			
			
			reqName = (String)request.getParameter("name");
			status = (String) request.getParameter("status");
			location =(String) request.getParameter("loc");
			expString = (String)request.getParameter("exp");
			exp = Integer.parseInt(expString);
			String[] skills = (String[])request.getParameterValues("skills[]");
			for(int i =0;i<skills.length;i++) {
				if(i==0) {
					skillString = skillString +skills[i];
				}
				else {
					skillString = skillString +", "+skills[i];
				}
			}
			requisitionData rd = new requisitionData(reqName, createdAt, expiry, status, location, exp, skillString,createdBy);
			RequisitionService requisitionService = new RequisitionService();
			int id = requisitionService.createReq(rd);
			if(id>0) {
				hm.put("created", "true");
				obj = new Gson().toJson(hm, hm.getClass());
			}
			else {
				hm.put("created", "false");
				obj = new Gson().toJson(hm, hm.getClass());
				}
			}catch(Exception e) {
				System.out.println("time stopped : "+e.getMessage());
			}
			
		}
		out.print(obj);
		out.flush();
	}

}
