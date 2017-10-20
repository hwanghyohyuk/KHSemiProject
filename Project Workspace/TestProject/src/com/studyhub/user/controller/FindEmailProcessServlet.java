package com.studyhub.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studyhub.common.vo.User;
import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class FindEmailProcessServlet
 */
@WebServlet("/findemailprocess")
public class FindEmailProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEmailProcessServlet() {
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
		String userEmail = request.getParameter("email");
		System.out.println(userEmail);
		us = new UserService();
		int result = us.checkEmail(userEmail);
		if(result>0){
			//찾고자하는 이메일이 1개이상 >> 이메일 중복 O
			 HttpSession session = request.getSession();
	         session.setAttribute("userEmail", userEmail);
	         RequestDispatcher view = request.getRequestDispatcher("/views/user/FindPwd.jsp");
	         view.forward(request, response);
		}else{
			//찾고자하는 이메일이 없다 >> 이메일 중복 X
			 RequestDispatcher view = request.getRequestDispatcher("/views/user/FailFindEmail.jsp");
	         view.forward(request, response);
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
