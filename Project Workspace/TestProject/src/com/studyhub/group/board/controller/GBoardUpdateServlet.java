
package com.studyhub.group.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GBoard;
import com.studyhub.common.vo.GNotice;
import com.studyhub.group.board.model.service.GBoardService;
import com.studyhub.group.notice.model.service.GNoticeService;


/**
 * Servlet implementation class GBoardUpdateServlet
 */
@WebServlet("/gboardupdate")
public class GBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gBoard;
	private GBoardService gboardService;
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int gBoardNo = Integer.parseInt(request.getParameter("gBoardNo"));
		String title = request.getParameter("title");
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		String content = request.getParameter("content");
		int accessNo = Integer.parseInt(request.getParameter("accessno"));
		
		
		gBoard = new GBoard();
		gBoard.setgBoardNo(gBoardNo);
		gBoard.setTitle(title);
		gBoard.setContent(content);
		gBoard.setGroupNo(groupno);
		gBoard.setAccessNo(accessNo);
		gboardService = new GBoardService();
		
		System.out.println(gBoard);
		RequestDispatcher view = null;
		
		if(gboardService.updateGBoard(gBoard) >0){
			response.sendRedirect("/studyhub/gboardpreview?groupno="+groupno);
		}else{
			view = request.getRequestDispatcher("/views/group/groupBoard/BoardError.jsp");
			request.setAttribute("message", "수정실패");
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
