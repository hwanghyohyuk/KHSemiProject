package com.studyhub.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.User;
import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class MyInfoUpdateServlet
 */
@WebServlet("/myinfoupdate")
public class MyInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us;
	private User user;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		int pwdState=0;
		us = new UserService();
		int result = us.updateUserInfo(email,pwd,phone,pwdState);
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
