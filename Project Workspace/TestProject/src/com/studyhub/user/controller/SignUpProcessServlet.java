package com.studyhub.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.User;
import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class SignUpProcessServlet
 */
@WebServlet("/signupprocess")
public class SignUpProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService uService = null;
	private User user = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String userEmail = request.getParameter("signupemail");
		String userPwd = request.getParameter("signuppwd");
		String userName = request.getParameter("username");
		String phone = request.getParameter("phone");
		
		user = new User(userEmail, userName, userPwd, phone);
		
		uService = new UserService();
		boolean result = uService.createUser(user);
		
		if(result){
			System.out.println("success");
			RequestDispatcher view = request.getRequestDispatcher("/views/user/Login.jsp");
			view.forward(request, response);
		}else{
			System.out.println("fail");
			RequestDispatcher view = request.getRequestDispatcher("/views/main/Start.jsp");
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
