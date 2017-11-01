package com.studyhub.group.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Group;
import com.studyhub.group.notice.model.service.GNoticeService;

/**
 * Servlet implementation class GNoticePreviewServlet
 */
@WebServlet("/gnoticepreview")
public class GNoticePreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GNoticeService gns;
	private GNotice gNotice;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticePreviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
				
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		int currentPage = 1;
		int limit = 10;			
		if(request.getParameter("groupno")!= null)
			currentPage = Integer.parseInt(request.getParameter("groupno"));						
		
		gns = new GNoticeService();
		
		int listCount = gns.getListCount();
		
		ArrayList<GNotice> list = gns.selectGroupNotice(groupno,currentPage,limit);
					
		int maxPage = (int)((double)listCount / limit + 0.9);
		int startPage = ((int)((double)currentPage / limit + 0.9) -1) *limit +1;
		int endPage = startPage + limit -1;
		if(maxPage < endPage)
			endPage = maxPage;
		
		
				
		RequestDispatcher view = null;
		if(list != null){
			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			view = request.getRequestDispatcher("views/group/groupNotice/NoticeList.jsp");
			
			
			System.out.println("\n 프리뷰서블릿 currentPage : " + currentPage + "maxPage : " + maxPage + "startPage : " + startPage + "endPage : " + endPage + "listCount : " + listCount);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/group/groupNotice/NoticeError.jsp");
			request.setAttribute("message", "게시글 페이지별 조회 실패!");
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
