package com.studyhub.admin.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.notice.model.service.NoticeService;
import com.studyhub.common.vo.Notice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/noticeinsert")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Notice notice;
	private NoticeService nService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
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
		String notice = request.getParameter("notice");
		String popup = request.getParameter("popup");
		
		if(new NoticeService().insertNotice(notice) > 0){
			response.sendRedirect("/studyhub/noticeview");
		}else{
			RequestDispatcher errorPage = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "등록 실패");
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
