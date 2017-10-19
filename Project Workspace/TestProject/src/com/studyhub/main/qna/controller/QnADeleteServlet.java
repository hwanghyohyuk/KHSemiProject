package com.studyhub.main.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class QnADeleteServlet
 */
@WebServlet("/qnadelete")
public class QnADeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QnAService qs;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnADeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		if(new QnAService().deleteQNA(Integer.parseInt(request.getParameter("no"))) > 0){
			response.sendRedirect("/studyhub/qnalist");
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
