package com.studyhub.admin.faqmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class FAQManagementListServlet
 */
@WebServlet("/faqmanagementlist")
public class FAQManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FAQManagementService faqms;
	private FAQ faq;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FAQManagementListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryno = Integer.parseInt(request.getParameter("categoryno"));
		
		response.setContentType("text/html; charset=utf-8");
		ArrayList<FAQ> list = new FAQManagementService().selectList(categoryno);
		RequestDispatcher view = null;
		if(list!=null){
			view= request.getRequestDispatcher("/views/main/FAQ/FAQdetail.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "리스트 불러오기 실패");
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
