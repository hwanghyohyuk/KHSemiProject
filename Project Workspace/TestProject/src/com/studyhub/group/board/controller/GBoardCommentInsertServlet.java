package com.studyhub.group.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;
import com.studyhub.group.notice.model.service.GNoticeService;
import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class GBoardCommentInsert
 */
@WebServlet("/gbcommentinsert")
public class GBoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GBoardCommentInsertServlet() {
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
		String comment = request.getParameter("comment");
		int uploader = Integer.parseInt(request.getParameter("uploader"));
		if(new GBoardService().insertComment(gboardno, uploader, comment)>0 ){
			response.sendRedirect("views/group/groupBoard/BoardDetail.jsp");
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
