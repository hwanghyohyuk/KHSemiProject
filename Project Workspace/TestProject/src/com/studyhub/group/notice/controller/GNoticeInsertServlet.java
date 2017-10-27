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
 * Servlet implementation class GNoticeCreateServlet
 */
@WebServlet("/gnoticecreate")
public class GNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GNotice gNotice;
	private GNoticeService gNoticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 원글 등록
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8"); 
		
		RequestDispatcher view = null;
		gNotice = new GNotice();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int uploader = Integer.parseInt(request.getParameter("uploader"));
		int accessNo = Integer.parseInt(request.getParameter("accessno"));
		int groupNo = Integer.parseInt(request.getParameter("groupno"));
				
		gNotice.setTitle(title);
		gNotice.setContent(content);
		gNotice.setUploader(uploader);
		gNotice.setAccessNo(accessNo);
		gNotice.setGroupNo(groupNo);
				
		if(new GNoticeService().insertGNotice(gNotice)>0){
			response.sendRedirect("/studyhub/gnoticepreview?groupno="+groupNo);
		}else{
			
			view = request.getRequestDispatcher("/views/group/groupNotice/NoticeError.jsp");
			request.setAttribute("message", "공지글 등록 실패");
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
