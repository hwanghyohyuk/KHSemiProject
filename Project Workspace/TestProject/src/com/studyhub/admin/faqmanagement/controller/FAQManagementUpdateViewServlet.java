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
 * Servlet implementation class FAQManagementUpdateViewServlet
 */
@WebServlet("/faqmanagementupdateview")
public class FAQManagementUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FAQManagementService faqms;
	private FAQ faq;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		FAQ faq = new FAQManagementService().selectOneFAQ(Integer.parseInt(request.getParameter("no")));
		
		RequestDispatcher view = null;
		
		if(faq !=null){
			view = request.getRequestDispatcher("/views/admin/FAQUpdateForm.jsp");
			request.setAttribute("faq", faq);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message","수정화면 출력 실패");
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
