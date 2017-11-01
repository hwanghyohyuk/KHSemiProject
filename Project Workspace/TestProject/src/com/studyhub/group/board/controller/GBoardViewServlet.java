package com.studyhub.group.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GBoard;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.board.model.service.GBoardService;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class GBoardViewServlet
 */
@WebServlet("/gboardview")
public class GBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gBoard;
	private GBoardService gBoardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));

		gBoardService = new GBoardService();
		gBoard = gBoardService.selectGBoard(no);
		gBoardService.updateReadCount(no);
		RequestDispatcher view = null;
		if(gBoard != null){
			view = request.getRequestDispatcher("views/group/groupBoard/BoardDetail.jsp");
			request.setAttribute("gBoard", gBoard);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/group/groupBoard/BoardError.jsp");
			request.setAttribute("message", "상세조회실패");
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
