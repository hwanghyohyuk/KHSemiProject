package com.studyhub.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.main.model.service.MainService;

/**
 * Servlet implementation class UnGStateServlet
 */
@WebServlet("/ungstate")
public class UnGStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MainService ms;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnGStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int senderNo = Integer.parseInt(request.getParameter("senderNo"));
		int groupNo = Integer.parseInt(request.getParameter("groupNo"));

		System.out.println("senderNo : " + senderNo + "\nsenderNo : " + senderNo + "\ngroupNo : " + groupNo);
		ms = new MainService();
		int ungState = ms.ungState(senderNo, groupNo);
		
		PrintWriter pw = response.getWriter();
		pw.println(ungState);
		pw.flush();
		pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
