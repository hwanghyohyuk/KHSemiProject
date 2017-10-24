package com.studyhub.main.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.Board;
import com.studyhub.main.board.model.service.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService bs;
	private Board board;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				response.setContentType("text/html; charset=utf-8");
				
				int currentPage = 1;
				int limit = 10;
				if(request.getParameter("page") != null)
					currentPage = Integer.parseInt(request.getParameter("page"));
				
				bs = new BoardService();
			
				int listCount = bs.getListCount();
				
				ArrayList<Board> list = bs.selectList(currentPage, limit);
				int maxPage = (int)((double)listCount / limit + 0.9);
				int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
				int endPage = startPage + limit - 1;
				if(maxPage < endPage)
					endPage = maxPage;
				
				RequestDispatcher view = null;
				if(list != null){
					view = request.getRequestDispatcher("/views/main/Board/BoardList.jsp");
					
					request.setAttribute("list", list);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("listCount", listCount);
					
					view.forward(request, response);
				}else{
					view = request.getRequestDispatcher("/views/main/Board/BoardError.jsp");
					request.setAttribute("message", "게시글 페이지별 조회 실패!");
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
