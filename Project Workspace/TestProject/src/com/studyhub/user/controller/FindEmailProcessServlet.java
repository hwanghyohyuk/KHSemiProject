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
@WebServlet("/findemailprocess")
public class FindEmailProcessServlet extends HttpServlet implements CryptTemplate{
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userEmail = request.getParameter("email");
		String pagename = request.getParameter("pagename");
		us = new UserService();
		int result = us.checkEmail(userEmail);
		
		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String encryptEmail = util.encrypt(SALT, IV, PASSPHRASE, userEmail);
		
		RequestDispatcher view = null;
		if (pagename !=null &&( pagename.equals("signup") || pagename.equals("start"))) {// 전달받은 페이지이름으로 실행할 코드
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
		} else {// 이메일찾기 페이지에서 사용할 코드
			if (result > 0) {
				// 찾고자하는 이메일이 1개이상 >> 이메일 중복 O
				request.setAttribute("userEmail", encryptEmail);
				view = request.getRequestDispatcher("/views/user/FindName.jsp");
				view.forward(request, response);
			} else {
				// 찾고자하는 이메일이 없다 >> 이메일 중복 X
				view = request.getRequestDispatcher("/views/user/userError.jsp");
				request.setAttribute("messageheader", "이메일 찾기 오류");
				request.setAttribute("message", "이메일을 찾을 수 없습니다.");
				view.forward(request, response);
			}
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
