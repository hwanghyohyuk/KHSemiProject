package com.studyhub.group.sharefile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class ShareFileListServlet
 */
@WebServlet("/sharefilelist")
public class ShareFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ShareFileService sfs;
	private ShareFile shareFile;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset=utf-8");
		int no = Integer.parseInt(request.getParameter("groupno"));
		
		int currentPage = 1;
		int limit = 11;
		
		if(request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		ShareFileService sfservice = new ShareFileService();
		
		int listCount = sfservice.getListCount();
		ArrayList<ShareFile> list = sfservice.selectList(currentPage, limit, no);
		
		int maxPage = (int)((double)listCount / limit + 0.95); //total # of pages
		int startPage = ((int)((double)currentPage / limit + 0.95) - 1) * limit + 1;
		int endPage = startPage + limit - 1;
		if(maxPage < endPage)
			endPage = maxPage;
		
		RequestDispatcher view = null;
		
		if(list!=null){
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareList.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			view.forward(request, response);
			
		}else{
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "파일 공유 리스트 조회 실패");
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
