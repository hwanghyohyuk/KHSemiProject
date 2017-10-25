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
 * Servlet implementation class GNoticeViewServlet
 */
@WebServlet("/gnoticeview")
public class GNoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GNotice gNotice;
	private GNoticeService gNoticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		
		GNoticeService gnservice = new GNoticeService();
		GNotice gNotice = gnservice.selectGNotice(no);
		
		RequestDispatcher view = null;
		
		if(gNotice != null){
			view = request.getRequestDispatcher("views/group/groupNotice/NoticeDetail.jsp");
			request.setAttribute("gNotice", gNotice);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/group/groupNotice/NoticeError.jsp");
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
