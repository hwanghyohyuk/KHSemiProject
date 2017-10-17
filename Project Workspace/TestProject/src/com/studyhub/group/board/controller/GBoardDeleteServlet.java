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
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;


/**
 * Servlet implementation class GBoardDeleteServlet
 */
@WebServlet("/gboarddelete")
public class GBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GBoard gNboard;
	private GBoardService gNboardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=utf-8");
		
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		if(new GBoardService().deleteBoard(bnum) > 0){
			response.sendRedirect("/first/blist?page=1");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", "게시글 삭제 처리 실패!");
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
