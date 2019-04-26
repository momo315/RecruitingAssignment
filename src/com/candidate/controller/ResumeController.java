package com.candidate.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candidate.service.ResumeService;
import com.google.gson.Gson;
import com.internal.model.userProfile;
import com.internal.util.SessionChecker;

/**
 * Servlet implementation class ResumeController
 */
@WebServlet("/Resume")
public class ResumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		if(!SessionChecker.checkSession(request, response)) {
//			out.print("fail");
		}
		else {
			ResumeService resumeService = new ResumeService();
			InputStream pdf = resumeService.getRes(SessionChecker.getId(request));
			byte[] b = new byte[pdf.available()];
			b= pdf.readAllBytes();
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=myPdf.pdf");
//			String pdfBase64String = 
//					org.apache.commons.codec.binary.StringUtils.newStringUtf8(org.apache.
//					commons.codec.binary.Base64.encodeBase64(pdf.readAllBytes()));
			ServletOutputStream sos = response.getOutputStream();
			sos.write(b);
//			out.print(pdfBase64String);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
