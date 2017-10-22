package com.studyhub.group.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;


/**
 * Servlet implementation class GBoardUpdateServlet
 */
@WebServlet("/gboardupdate")
public class GBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gNboard;
	private GBoardService gNboardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 수정페이지 출력 처리용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		GBoard gboard = new GBoard();
		gboard.setgBoardNo(bnum);
		int result = new GBoardService().updateViewBoard(gboard);
				
		
		RequestDispatcher view = null;
		if(gboard != null){
			view = request.getRequestDispatcher("views/gboard/gboardError.jsp");
			request.setAttribute("gboard", gboard);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/gboard/gboardError.jsp");
			request.setAttribute("message", "수정페이지 출력 요청 실패!");
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
