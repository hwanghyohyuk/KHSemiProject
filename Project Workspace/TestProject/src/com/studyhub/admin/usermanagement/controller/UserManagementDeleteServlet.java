package com.studyhub.admin.usermanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.faqmanagement.model.service.FAQManagementService;
import com.studyhub.admin.usermanagement.model.service.UserManagementService;
import com.studyhub.user.model.service.UserService;

/**
 * Servlet implementation class UserManagementDeleteServlet
 */
@WebServlet("/usermanagementdelete")
public class UserManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserManagementService ums;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String usermail = request.getParameter("ue");
		int state = 1;
		
		if(new UserService().changeUserState(usermail, state) > 0){
			response.sendRedirect("/studyhub/usermanagementlist"); 
			
		}else{
			RequestDispatcher errorPage = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "삭제 실패");
			errorPage.forward(request, response);
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
