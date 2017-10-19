package com.studyhub.main.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class QnAUpdateServlet
 */
@WebServlet("/qnaupdate")
public class QnAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnAService qs;
	private QnA qna;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		qna = new QnA();
		qna.setQnaNo(Integer.parseInt(request.getParameter("no")));
		qna.setTitle(request.getParameter("title"));
		qna.setContent(request.getParameter("content"));
		
		RequestDispatcher view = null;
		
		if(new QnAService().updateQNA(qna) > 0){
			response.sendRedirect("/studyhub/qnalist");
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
