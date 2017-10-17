package com.studyhub.admin.faqmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.faqmanagement.model.service.FAQManagementService;
import com.studyhub.common.vo.FAQ;

/**
 * Servlet implementation class FAQManagementSearchServlet
 */
@WebServlet("/faqmanagementsearch")
public class FAQManagementSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FAQManagementService faqms;
	private FAQ faq;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
