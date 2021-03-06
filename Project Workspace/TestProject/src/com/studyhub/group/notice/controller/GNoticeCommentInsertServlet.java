package com.studyhub.group.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.notice.model.service.GNoticeService;

/**
 * Servlet implementation class GNoticeCommentInsertServlet
 */
@WebServlet("/gnoticecommentinsert")
public class GNoticeCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int gnoticeno = Integer.parseInt(request.getParameter("gnoticeno"));
		String comment = request.getParameter("comment");
		int uploader = Integer.parseInt(request.getParameter("uploader"));
		//console 출력
		System.out.println("\n코멘트 인서트 서블릿 : comment : " + comment + ", gnoticeno : "+ gnoticeno);
		if(new GNoticeService().insertComment(gnoticeno, uploader, comment)>0 ){
			response.sendRedirect("views/group/groupNotice/NoticeDetail.jsp");
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
