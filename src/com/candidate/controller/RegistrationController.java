package com.candidate.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.candidate.dao.RegistrationDao;
import com.internal.model.user;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(description = "Handles Sign up", urlPatterns = { "/Registration" })
@MultipartConfig
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String usr,pass,id,fname,lname,type,gender;
	InputStream pdf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		// TODO Auto-generated method stub
//		usr=request.getParameter("user");
//		pass=request.getParameter("pass");
//		id=request.getParameter("empid");
//		fname=request.getParameter("fname");
//		lname=request.getParameter("lname");
//		type=request.getParameter("type");
//		gender=request.getParameter("gender");
//		Part filepart = request.getPart("sume");
//		InputStream filecontent = filepart.getInputStream();
		
		user usr = new user(request.getParameter("user"),request.getParameter("pass"),request.getParameter("empid"),request.getParameter("gender"),request.getParameter("usertype"),request.getPart("sume").getInputStream(),request.getParameter("fname"), request.getParameter("lname"));
		RegistrationDao rd = new RegistrationDao();
		String stat = rd.register(usr);
		if(stat.equals("success")) {
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Successfully Registered, Please Sign in");
			view.forward(request, response);
		}
		else if(stat.equals("userexist")) {
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "User already registered ");
			view.forward(request, response);
		}
		else if(stat.equals("exception")) {
			RequestDispatcher view = request.getRequestDispatcher("SignUp.jsp");
			request.setAttribute("msg", "Something went wrong , Sorry .");
			view.forward(request, response);
		}
		
	}

}
