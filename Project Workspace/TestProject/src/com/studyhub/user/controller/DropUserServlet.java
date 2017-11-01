package com.studyhub.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class DropUserServlet
 */
@WebServlet("/dropuser")
public class DropUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String email = request.getParameter("email");
		us = new UserService();
		int result = us.changeUserState(email,1);
		PrintWriter pw = response.getWriter();
		if (result > 0) {
			pw.println("1");
			pw.flush();
			pw.close();
		} else {
			pw.println("0");
			pw.flush();
			pw.close();
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
