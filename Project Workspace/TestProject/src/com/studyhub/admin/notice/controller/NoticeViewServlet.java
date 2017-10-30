package com.studyhub.admin.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.notice.model.service.NoticeService;
import com.studyhub.common.vo.Notice;
import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/noticeview")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Notice notice;
	private NoticeService nService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//Notice 표시 --> 도움말 첫페이지에 바로 뜨도록 .. 
		RequestDispatcher view = null;
		
		String notice = new NoticeService().selectNotice();
		
		if(notice!=null){
			view= request.getRequestDispatcher("/views/main/FAQ/FAQmain.jsp");
			request.setAttribute("notice", notice);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "view 출력 실패");
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
