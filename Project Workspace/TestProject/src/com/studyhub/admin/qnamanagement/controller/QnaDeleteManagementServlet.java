package com.studyhub.admin.qnamanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.qnamanagement.model.service.QnaManagementService;

/**
 * Servlet implementation class QnaDeleteManagementServlet
 */
@WebServlet("/qnadeletemanagement")
public class QnaDeleteManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int qnano = Integer.parseInt(request.getParameter("qnano"));
		
		if(new QnaManagementService().DeleteQna(qnano) > 0){
			response.sendRedirect("/studyhub/qnalistmanagement");
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
