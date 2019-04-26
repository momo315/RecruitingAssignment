package com.candidate.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.candidate.dao.LoginDao;
import com.candidate.service.LoginService;
import com.internal.model.userProfile;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
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
		String user,pass;
		System.out.println("in login");
		user = request.getParameter("user");
		pass = request.getParameter("pass");
		LoginService loginService = new LoginService();
		userProfile up = loginService.Login(user, pass);
		System.out.println(up.getId());
		if(up.getId()> 0) {
			System.out.println("logged");
			request.getSession().setAttribute("userProfile", up);
			System.out.println(up.getType());
			if(up.getType().equals("CAN")) {
				RequestDispatcher rd = request.getRequestDispatcher("HomeCan.jsp");
				rd.forward(request, response);
			}
			else if(up.getType().equals("REC")) {
				RequestDispatcher rd = request.getRequestDispatcher("HomeRec.jsp");
				rd.forward(request, response);
			}
			else if(up.getType().equals("ADMIN")) {
				RequestDispatcher rd = request.getRequestDispatcher("HomeAdm.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(up.getId() == 0) {
			request.setAttribute("msg", "Incorrect Password !");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else if(up.getId() == -1){
			request.setAttribute("msg", "User does not exist . Consider Signing up .");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			}
		else {
			System.out.println(up.getId());
		}
		
	}

}
