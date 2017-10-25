package com.studyhub.group.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;


/**
 * Servlet implementation class GBoardInsertServlet 
 */
@WebServlet("/gboardinsert")
public class GBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gNboard;
	private GBoardService gNboardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				RequestDispatcher view = null;

				if(!ServletFileUpload.isMultipartContent(request)){
					view = request.getRequestDispatcher("/views/group/groupBoard/BoardError.jsp");
					request.setAttribute("message", "form enctype 속성 사용 안 함!");
					view.forward(request, response);
				}
				GBoard gboard = new GBoard();
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String uploader = request.getParameter("uploader");
				System.out.println(request.getParameter("access_no"));
				int accessNo = Integer.parseInt(request.getParameter("access_no"));
				int groupNo = Integer.parseInt(request.getParameter("group_no"));
				
				gboard.setTitle(title);
				gboard.setContent(content);
				gboard.setUploader(uploader);
				gboard.setAccessNo(accessNo);
				gboard.setGroupNo(groupNo);
				
				if(new GBoardService().insertBoard(gboard)>0){
					response.sendRedirect("/studyhub/gboardlist");
				}else{
					RequestDispatcher errorPage = request.getRequestDispatcher("/views/group/groupBoard/BoardError.jsp");
					request.setAttribute("message", "질문 등록 실패");
					errorPage.forward(request, response);
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
