package com.studyhub.group.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.board.model.service.GBoardService;
import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class GBoardCommentInsert
 */
@WebServlet("/gbcommentinsert")
public class GBoardCommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GBoardCommentInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int gboardno = Integer.parseInt(request.getParameter("gboardno"));
		int userno = Integer.parseInt(request.getParameter("userno"));
		String comment = request.getParameter("comment");
		System.out.println(comment);

		if (new GBoardService().insertComment(gboardno, userno, comment) > 0) {
			response.sendRedirect("views/group/groupBoard/BoardList.jsp");
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
