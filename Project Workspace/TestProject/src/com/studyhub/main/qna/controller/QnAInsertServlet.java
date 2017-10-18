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
 * Servlet implementation class QnAInsertServlet
 */
@WebServlet("/qnainsert")
public class QnAInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QnAService qs;
	private QnA qna;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher view = null;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		QnA qna = new QnA();
		qna.setTitle(title);
		qna.setContent(content);
		qna.setWriter(writer);
		
		if(new QnAService().insertQNA(qna)>0){
			response.sendRedirect("/studyhub/qnalist");
		}else{
			RequestDispatcher errorPage = request.getRequestDispatcher("/studyhub/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "질문 등록 실패");
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
