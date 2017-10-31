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
import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class FAQManagementInsertServlet
 */
@WebServlet("/faqmanagementinsert")
public class FAQManagementInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FAQManagementService faqms;
	private FAQ faq;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		content= content.replaceAll("\n", "<br>");
		int categoryno = Integer.parseInt(request.getParameter("categoryno"));
		
		System.out.println(title+content+categoryno);

		if(new FAQManagementService().insertFAQ(title, content, categoryno) > 0){
				response.sendRedirect("/studyhub/noticeview");
		}else{
			RequestDispatcher errorPage = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "등록 실패");
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
