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
import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class FAQManagementUpdateServlet
 */
@WebServlet("/faqmanagementupdate")
public class FAQManagementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FAQManagementService faqms;
	private FAQ faq;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		faq = new FAQ();
		faq.setFaqNo(Integer.parseInt(request.getParameter("faqno")));
		faq.setTitle(request.getParameter("title"));
		faq.setContent(request.getParameter("content"));
		int categoryno = Integer.parseInt(request.getParameter("categoryno"));
		faq.setFaqCategoryNo(categoryno);
		
		RequestDispatcher view = null;
		
		if(new FAQManagementService().updateFAQ(faq) > 0){
			response.sendRedirect("/studyhub/faqmanagementlist?categoryno="+categoryno);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "수정실패");
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
