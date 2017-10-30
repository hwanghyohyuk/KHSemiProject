package com.studyhub.group.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.notice.model.service.GNoticeService;
import com.studyhub.common.vo.*;

/**
 * Servlet implementation class GNoticeDeleteServlet
 */
@WebServlet("/gnoticedelete")
public class GNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GNoticeService gNoticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 삭제
		response.setContentType("text/html; charset=utf-8");
		
		int gno= Integer.parseInt(request.getParameter("groupno"));
		
		
		if(new GNoticeService().deleteGNotice(gno) > 0){
			response.sendRedirect("/studyhub/gnoticepreview?groupno=1");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("/views/group/groupNotice/NoticeError.jsp");
			request.setAttribute("message", "게시글 삭제 실패");
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
