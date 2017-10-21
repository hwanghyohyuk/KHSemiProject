package com.studyhub.main.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class QnACommentInsertServlet
 */
@WebServlet("/qnacommentinsert")
public class QnACommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnACommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int qnano = Integer.parseInt(request.getParameter("qnano"));
		String comment = request.getParameter("comment");
		int userno = Integer.parseInt(request.getParameter("userno"));
		System.out.println(comment);
		if(new QnAService().insertComment(qnano, comment, userno) > 0){
			response.sendRedirect("views/main/QnA/QnADetail.jsp");
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
