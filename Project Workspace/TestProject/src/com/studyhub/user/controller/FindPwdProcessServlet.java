package com.studyhub.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.CryptTemplate;
import com.studyhub.common.vo.AesUtil;
import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class FindPwdProcessServlet
 */
@WebServlet("/findpwdprocess")
public class FindPwdProcessServlet extends HttpServlet implements CryptTemplate {
	private static final long serialVersionUID = 1L;
	private UserService us;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userEmail = request.getParameter("email");
		String userName = request.getParameter("name");
		String userPwd = request.getParameter("pwd");
		String newPwd = null;
		
		AesUtil util = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String decryptEmail = util.decrypt(SALT, IV, PASSPHRASE, userEmail);
		String decryptName = util.decrypt(SALT, IV, PASSPHRASE, userName);
		String encryptPwd = util.encrypt(SALT, IV, PASSPHRASE, userPwd);
		
		us = new UserService();
		int result = us.checkPwd(decryptEmail,decryptName,encryptPwd);	
		
		RequestDispatcher view = null;
			if (result > 0) {
				view = request.getRequestDispatcher("/views/user/userSuccess.jsp");
				request.setAttribute("messageheader", "기존 비밀번호 찾기 완료");
				request.setAttribute("message", "지금까지 입력하신 정보로 다시 로그인해주세요.");
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("/views/user/userError.jsp");
				if((newPwd = us.sendNewPwd(decryptEmail,decryptName))!=null){
					request.setAttribute("messageheader", "기존 비밀번호 찾기 실패");
					request.setAttribute("message", "입력하셨던 이메일로 임시 비밀번호가 전송되었습니다.");
					int updateResult = us.modifyPwd(decryptEmail,newPwd);
					if(updateResult>0){
						System.out.println("비밀번호 변경 성공");
					}else{
						System.out.println("비밀번호 변경 실패");
					}
				}else{
					request.setAttribute("messageheader", "메일 전송 오류");
					request.setAttribute("message", "메일 전송 실패");
				}
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