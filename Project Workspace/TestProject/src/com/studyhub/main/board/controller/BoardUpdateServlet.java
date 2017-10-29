package com.studyhub.main.board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.Board;
import com.studyhub.main.board.model.service.BoardService;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardupdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService bs;
	private Board b;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		int bno = Integer.parseInt(request.getParameter("bno"));
		String btitle = request.getParameter("btitle");
		int groupno = Integer.parseInt(request.getParameter("bglist"));
		Date deadline = Date.valueOf(request.getParameter("deadline"));
		int bwriterNo = Integer.parseInt(request.getParameter("bwriterno"));
		String bcontent = request.getParameter("bcontent");
		
		b = new Board();
		b.setBoardNo(bno);
		b.setTitle(btitle);
		b.setContent(bcontent);
		b.setUploader(bwriterNo);
		b.setDeadlineDate(deadline);
		b.setGroupNo(groupno);
		
		bs = new BoardService();
		int result=bs.updateBoard(b);
		
		RequestDispatcher view = null;
		// 처리결과에 따라 뷰 지정함
		if (result > 0) {
			response.sendRedirect("/studyhub/boardlist?page=1");
		} else {
			view = request.getRequestDispatcher("views/main/Board/BoardError.jsp");
			request.setAttribute("message", "모집게시판 서비스 : 모집글 수정 실패!");
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
