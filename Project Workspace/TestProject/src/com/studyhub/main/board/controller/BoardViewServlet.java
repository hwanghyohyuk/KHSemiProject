package com.studyhub.main.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.QnA;
import com.studyhub.main.board.model.service.BoardService;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardview")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService bs;
	private Board board;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int bno = Integer.parseInt(request.getParameter("bno"));

		bs = new BoardService();
		board = bs.selectBoard(bno);

		RequestDispatcher view = null;

		if (board != null) {
			view = request.getRequestDispatcher("/views/main/Board/BoardDetail.jsp");
			request.setAttribute("board", board);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("/views/main/Board/BoardError.jsp");
			request.setAttribute("message", "상세조회실패");
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
