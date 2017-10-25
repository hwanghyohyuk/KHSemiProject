package com.studyhub.group.board.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class GBoardListServlet
 */
@WebServlet("/gboardlist")
public class GBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gNboard;
	private GBoardService gNboardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset=utf-8");
		int no = Integer.parseInt(request.getParameter("groupno"));
		
		int currentPage = 1;
		int limit = 15;

		ArrayList<GBoard> list = new GBoardService().selectList(currentPage, limit,no);
		RequestDispatcher view = null;
		
		if(list!=null){
			view = request.getRequestDispatcher("views/group/groupBoard/BoardList.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
			
		}else{
			view = request.getRequestDispatcher("views/group/groupBoard/BoardError.jsp");
			request.setAttribute("message", "파일 공유 리스트 조회 실패");
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
