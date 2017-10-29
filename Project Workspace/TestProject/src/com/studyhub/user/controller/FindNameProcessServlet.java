package com.studyhub.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studyhub.common.CryptTemplate;
import com.studyhub.common.vo.AesUtil;
import com.studyhub.common.vo.User;
import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class FindEmailProcessServlet
 */
@WebServlet("/findnameprocess")
public class FindNameProcessServlet extends HttpServlet implements CryptTemplate{
	private static final long serialVersionUID = 1L;
	private UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindNameProcessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userEmail = request.getParameter("email");
		String userName = request.getParameter("name");
		
		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String decryptEmail = util.decrypt(SALT, IV, PASSPHRASE, userEmail);
		us = new UserService();
		int result = us.checkName(decryptEmail,userName);
		
		String encryptName = util.encrypt(SALT, IV, PASSPHRASE, userName);
		
		RequestDispatcher view = null;
			if (result > 0) {
				request.setAttribute("userEmail", userEmail);
				request.setAttribute("userName", encryptName);
				view = request.getRequestDispatcher("/views/user/FindPwd.jsp");
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("/views/user/userError.jsp");
				request.setAttribute("messageheader", "사용자 이름 찾기 오류");
				request.setAttribute("message", "입력하신 사용자 이름이 다르거나 없습니다.");
				view.forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
