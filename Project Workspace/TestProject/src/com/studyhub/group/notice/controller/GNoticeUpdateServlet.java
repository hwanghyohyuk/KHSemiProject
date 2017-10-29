package com.studyhub.group.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GNotice;
import com.studyhub.group.notice.model.service.GNoticeService;

/**
 * Servlet implementation class GNoticeUpdateServlet
 */
@WebServlet("/gnoticeupdate")
public class GNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GNotice gNotice;
	private GNoticeService gNoticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		//int groupno = Integer.parseInt(request.getParameter("nglist"));
		String content = request.getParameter("content");
		
		gNotice = new GNotice();
		gNotice.setNoticeNo(no);
		gNotice.setTitle(title);
		gNotice.setContent(content);
		//gNotice.setGroupNo(groupno);
		
		gNoticeService = new GNoticeService();
		int result = gNoticeService.updateGNotice(gNotice);
		
		RequestDispatcher view = null;
		
		if(result > 0){
			response.sendRedirect("/studyhub/gnoticelist?page=1");
		}else{
			view = request.getRequestDispatcher("/views/group/groupNotice/NoticeError.jsp");
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
