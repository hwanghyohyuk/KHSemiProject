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
		
		gNotice = new GNotice();
		gNotice.setNoticeNo(Integer.parseInt(request.getParameter("no")));
		gNotice.setTitle(request.getParameter("title"));
		gNotice.setContent(request.getParameter("content"));
		
		RequestDispatcher view = null;
		
		if(new GNoticeService().updateGNotice(gNotice)>0){
			response.sendRedirect("/studyhub/gnoticepreview");
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
