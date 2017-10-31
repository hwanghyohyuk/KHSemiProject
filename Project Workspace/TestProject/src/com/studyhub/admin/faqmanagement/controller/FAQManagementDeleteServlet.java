package com.studyhub.admin.faqmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.faqmanagement.model.service.FAQManagementService;
import com.studyhub.common.vo.FAQ;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class FAQManagementDeleteServlet
 */
@WebServlet("/faqmanagementdelete")
public class FAQManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FAQManagementService faqms;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		if(new FAQManagementService().deleteFAQ(Integer.parseInt(request.getParameter("faqno"))) > 0){
			response.sendRedirect("/studyhub/faqmanagementlist?categoryno="+cno); 
			
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
