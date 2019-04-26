package com.recruiter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candidate.service.RequisitionListService;
import com.google.gson.Gson;
import com.internal.model.requisitionData;
import com.internal.model.userProfile;
import com.internal.util.SessionChecker;
import com.recruiter.service.RequisitionListRecService;

/**
 * Servlet implementation class RequisitionListRecController
 */
@WebServlet("/RequisitionsRec")
public class RequisitionListRecController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequisitionListRecController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(!SessionChecker.checkSession(request, response)) {
			HashMap<String, String> hm= new HashMap<String, String>();
			hm.put("sess", "false");
			obj = new Gson().toJson(hm, hm.getClass());
		}
		else {
			userProfile up = (userProfile)request.getSession().getAttribute("userProfile");
			RequisitionListRecService requisitionListRecService = new RequisitionListRecService();
			List<requisitionData> reqList = requisitionListRecService.getReqList(up.getEmpid());
			obj = new Gson().toJson(reqList, reqList.getClass());
		}
		out.print(obj);
		out.flush();
	}

}
