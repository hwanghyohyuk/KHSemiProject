package com.studyhub.group.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.board.model.service.GBoardService;
import com.studyhub.common.vo.*;

/**
 * Servlet implementation class GBoardDeleteServlet
 */
@WebServlet("/gboarddelete")
public class GBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GBoardService gboardService;
       
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
			//게시글 삭제
		response.setContentType("text/html; charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("groupno"));
		
		if(new GBoardService().deleteGBoard(no) > 0){
			response.sendRedirect("/studyhub/gboardpreview?groupno=1");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/group/groupBoard/BoardError.jsp");
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
