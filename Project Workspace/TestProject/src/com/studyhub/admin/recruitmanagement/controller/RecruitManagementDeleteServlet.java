package com.studyhub.admin.recruitmanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.main.board.model.service.BoardService;

/**
 * Servlet implementation class RecruitManagementDeleteServlet
 */
@WebServlet("/recruitmanagementdelete")
public class RecruitManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitManagementDeleteServlet() {
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
		
		bs = new BoardService();
		int result = bs.deleteBoard(bno);
		RequestDispatcher view = null;
		if(result>0){
			response.sendRedirect("/studyhub/recruitmanagementlist?page=1");
		} else {
			view = request.getRequestDispatcher("views/admin/BoardError.jsp");
			request.setAttribute("message", "모집게시판 서비스 : 모집글 삭제 실패!");
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
