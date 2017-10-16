package com.studyhub.admin.faqmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.faqmanagement.model.service.FAQManagementService;

/**
 * Servlet implementation class FAQManagementListServlet
 */
@WebServlet("/faqmanagementlist")
public class FAQManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FAQManagementService faqmService = new FAQManagementService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
