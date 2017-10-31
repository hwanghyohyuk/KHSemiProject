package com.studyhub.group.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;

/**
 * Servlet implementation class GBoardCommentDelete
 */
@WebServlet("/gbcommentdelete")
public class GBoardCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GBoard gboard;
	private GBoardService gboardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentno = Integer.parseInt(request.getParameter("commentno"));
		if(new GBoardService().deleteComment(commentno)>0){
			response.sendRedirect("/views/group/groupBoard/BoardList.jsp");
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
